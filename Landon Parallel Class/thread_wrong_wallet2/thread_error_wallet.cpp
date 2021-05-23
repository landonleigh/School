/*
 * error_wallet.cpp
 *
 *  Created on: Nov 7, 2020
 *      Author: Qiong
 */

#include <iostream>
#include <thread>
#include <vector>
#include <mutex>
using namespace std;

class Wallet
{
    int mMoney;
    mutex mu;
public:
    Wallet() :mMoney(0){}
    int getMoney() { return mMoney; }

void addMoney(int money) {
    for(int i = 0; i < money; ++i) {
        mMoney++;
    }
}
};

int testMultithreadedWallet()
{
   Wallet walletObject;
   vector<thread> threads;
   int cores = thread::hardware_concurrency();

   for(int i = 0; i < cores; ++i){
	   walletObject.mu.lock();
       threads.push_back(move(thread(&Wallet::addMoney, &walletObject, 1000))); // @suppress("Symbol is not resolved")
       walletObject.mu.unlock();
   }

   for(int i = 0; i < (int) (threads.size()); i++) {
       threads.at(i).join();
   }

   return walletObject.getMoney();
}
int main() {
	int val = 0;
	int cores = thread::hardware_concurrency();
	for(int k = 0; k < 1000; k++) {
		if((val = testMultithreadedWallet()) != cores * 1000) {
			cout << "Error at count = "<< k
			   <<" Money in Wallet = $"<<val << " [Expect $"
			   << (cores * 1000) << " in Wallet]"<< endl;
		 }
	}
	return 0;
}
