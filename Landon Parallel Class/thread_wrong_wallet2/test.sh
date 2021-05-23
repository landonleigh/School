#/bin/sh
i=1; 
while [ $i -le 2000 ]; 
do 
echo "Run ./thread_error_wallet.exe ($i)"
./thread_error_wallet.exe ; 
((i=i+1)); 
done