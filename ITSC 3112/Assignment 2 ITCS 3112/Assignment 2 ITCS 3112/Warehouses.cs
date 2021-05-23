using System;
using System.Collections.Generic;
using System.Text;
using System.IO;

//Landon Leigh
//Could not figure out how to sort all of the warehouses so I had it update all of them so it would at least do something

namespace Assignment_2_ITCS_3112
{
    class Warehouses
    {
        static void Main(string[] args)
        {
            //variable for line number
            int line = 1;

            //create object for each werehouse
            Atlanta atlanta = new Atlanta();
            Baltimore baltimore = new Baltimore();
            Chicago chicago = new Chicago();
            Denver denver = new Denver();
            Ely ely = new Ely();
            Fargo fargo = new Fargo();

            //read file
            FileStream inFile = new FileStream("Inventory.txt", FileMode.Open, FileAccess.Read); ;
            StreamReader reader = new StreamReader(inFile);

            String recordIn;
            String[] fields;
            recordIn = reader.ReadLine();

            //loop through each line to initialize each part for each warehouse
            while (recordIn != null)
            {
                if (line == 1)
                {
                    fields = recordIn.Split(',');
                    atlanta.setPart102(int.Parse(fields[0]));
                    atlanta.setPart215(int.Parse(fields[1]));
                    atlanta.setPart410(int.Parse(fields[2]));
                    atlanta.setPart525(int.Parse(fields[3]));
                    atlanta.setPart711(int.Parse(fields[4]));
                    line++;
                }
                else if (line == 2)
                {
                    fields = recordIn.Split(',');
                    baltimore.setPart102(int.Parse(fields[0]));
                    baltimore.setPart215(int.Parse(fields[1]));
                    baltimore.setPart410(int.Parse(fields[2]));
                    baltimore.setPart525(int.Parse(fields[3]));
                    baltimore.setPart711(int.Parse(fields[4]));
                    line++;
                }
                else if (line == 3)
                {
                    fields = recordIn.Split(',');
                    chicago.setPart102(int.Parse(fields[0]));
                    chicago.setPart215(int.Parse(fields[1]));
                    chicago.setPart410(int.Parse(fields[2]));
                    chicago.setPart525(int.Parse(fields[3]));
                    chicago.setPart711(int.Parse(fields[4]));
                    line++;
                }
                else if (line == 4)
                {
                    fields = recordIn.Split(',');
                    denver.setPart102(int.Parse(fields[0]));
                    denver.setPart215(int.Parse(fields[1]));
                    denver.setPart410(int.Parse(fields[2]));
                    denver.setPart525(int.Parse(fields[3]));
                    denver.setPart711(int.Parse(fields[4]));
                    line++;
                }
                else if (line == 5)
                {
                    fields = recordIn.Split(',');
                    ely.setPart102(int.Parse(fields[0]));
                    ely.setPart215(int.Parse(fields[1]));
                    ely.setPart410(int.Parse(fields[2]));
                    ely.setPart525(int.Parse(fields[3]));
                    ely.setPart711(int.Parse(fields[4]));
                    line++;
                }
                else if (line == 6)
                {
                    fields = recordIn.Split(',');
                    fargo.setPart102(int.Parse(fields[0]));
                    fargo.setPart215(int.Parse(fields[1]));
                    fargo.setPart410(int.Parse(fields[2]));
                    fargo.setPart525(int.Parse(fields[3]));
                    fargo.setPart711(int.Parse(fields[4]));
                    line++;
                }
                recordIn = reader.ReadLine();
            }

            //beginning of day status
            Console.WriteLine("Beginning of day status");
            Console.WriteLine("Atlanta: " + atlanta.toString());
            Console.WriteLine("Baltimore: " + baltimore.toString());
            Console.WriteLine("Chicago: " + chicago.toString());
            Console.WriteLine("Denver: " + denver.toString());
            Console.WriteLine("Ely: " + ely.toString());
            Console.WriteLine("Fargo: " + fargo.toString() + "\n");

            //read transactions file
            inFile = new FileStream("Transactions.txt", FileMode.Open, FileAccess.Read); ;
            StreamReader streamReader = new StreamReader(inFile);
            reader = streamReader;
            recordIn = reader.ReadLine();
            
            //loop and update inventory based on file read
            while (recordIn != null)
            {
                fields = recordIn.Split(',');
                
                //if transcation is a sale it subtracts from inventory
                if (fields[0] == "S")
                {
                    if (fields[1] ==  " 102")
                    {
                        atlanta.setPart102(atlanta.getPart102() - int.Parse(fields[2]));
                        baltimore.setPart102(baltimore.getPart102() - int.Parse(fields[2]));
                        chicago.setPart102(chicago.getPart102() - int.Parse(fields[2]));
                        denver.setPart102(denver.getPart102() - int.Parse(fields[2]));
                        ely.setPart102(ely.getPart102() - int.Parse(fields[2]));
                        fargo.setPart102(fargo.getPart102() - int.Parse(fields[2]));
                        Console.WriteLine("Updating Part 102\n");
                    }
                    else if (fields[1] == " 215")
                    {
                        atlanta.setPart215(atlanta.getPart215() - int.Parse(fields[2]));
                        baltimore.setPart215(baltimore.getPart215() - int.Parse(fields[2]));
                        chicago.setPart215(chicago.getPart215() - int.Parse(fields[2]));
                        denver.setPart215(denver.getPart215() - int.Parse(fields[2]));
                        ely.setPart215(ely.getPart215() - int.Parse(fields[2]));
                        fargo.setPart215(fargo.getPart215() - int.Parse(fields[2]));
                        Console.WriteLine("Updating Part 215\n");
                    }
                    else if (fields[1] == " 410")
                    {
                        atlanta.setPart410(atlanta.getPart410() - int.Parse(fields[2]));
                        baltimore.setPart410(baltimore.getPart410() - int.Parse(fields[2]));
                        chicago.setPart410(chicago.getPart410() - int.Parse(fields[2]));
                        denver.setPart410(denver.getPart410() - int.Parse(fields[2]));
                        ely.setPart410(ely.getPart410() - int.Parse(fields[2]));
                        fargo.setPart410(fargo.getPart410() - int.Parse(fields[2]));
                        Console.WriteLine("Updating Part 410\n");
                    }
                    else if (fields[1] == " 525")
                    {
                        atlanta.setPart525(atlanta.getPart525() - int.Parse(fields[2]));
                        baltimore.setPart525(baltimore.getPart525() - int.Parse(fields[2]));
                        chicago.setPart525(chicago.getPart525() - int.Parse(fields[2]));
                        denver.setPart525(denver.getPart525() - int.Parse(fields[2]));
                        ely.setPart525(ely.getPart525() - int.Parse(fields[2]));
                        fargo.setPart525(fargo.getPart525() - int.Parse(fields[2]));
                        Console.WriteLine("Updating Part 525\n");
                    }
                    else if (fields[1] == " 711")
                    {
                        atlanta.setPart711(atlanta.getPart711() - int.Parse(fields[2]));
                        baltimore.setPart711(baltimore.getPart711() - int.Parse(fields[2]));
                        chicago.setPart711(chicago.getPart711() - int.Parse(fields[2]));
                        denver.setPart711(denver.getPart711() - int.Parse(fields[2]));
                        ely.setPart711(ely.getPart711() - int.Parse(fields[2]));
                        fargo.setPart711(fargo.getPart711() - int.Parse(fields[2]));
                        Console.WriteLine("Updating Part 711\n");
                    }
                }

                //if transaction is a purchase, it adds to inventory
                else if (fields[0] == "P")
                {
                    //Console.WriteLine(fields[1]);
                    if (fields[1] == " 102")
                    {
                        Console.WriteLine(fields[1]);
                        atlanta.setPart102(atlanta.getPart102() + int.Parse(fields[2]));
                        baltimore.setPart102(baltimore.getPart102() + int.Parse(fields[2]));
                        chicago.setPart102(chicago.getPart102() + int.Parse(fields[2]));
                        denver.setPart102(denver.getPart102() + int.Parse(fields[2]));
                        ely.setPart102(ely.getPart102() + int.Parse(fields[2]));
                        fargo.setPart102(fargo.getPart102() + int.Parse(fields[2]));
                        Console.WriteLine("Updating Part 102\n");
                    }
                    else if (fields[1] == " 215")
                    {
                        atlanta.setPart215(atlanta.getPart215() + int.Parse(fields[2]));
                        baltimore.setPart215(baltimore.getPart215() + int.Parse(fields[2]));
                        chicago.setPart215(chicago.getPart215() + int.Parse(fields[2]));
                        denver.setPart215(denver.getPart215() + int.Parse(fields[2]));
                        ely.setPart215(ely.getPart215() + int.Parse(fields[2]));
                        fargo.setPart215(fargo.getPart215() + int.Parse(fields[2]));
                        Console.WriteLine("Updating Part 215\n");
                    }
                    else if (fields[1] == " 410")
                    {
                        atlanta.setPart410(atlanta.getPart410() + int.Parse(fields[2]));
                        baltimore.setPart410(baltimore.getPart410() + int.Parse(fields[2]));
                        chicago.setPart410(chicago.getPart410() + int.Parse(fields[2]));
                        denver.setPart410(denver.getPart410() + int.Parse(fields[2]));
                        ely.setPart410(ely.getPart410() + int.Parse(fields[2]));
                        fargo.setPart410(fargo.getPart410() + int.Parse(fields[2]));
                        Console.WriteLine("Updating Part 410\n");
                    }
                    else if (fields[1] == " 525")
                    {
                        atlanta.setPart525(atlanta.getPart525() + int.Parse(fields[2]));
                        baltimore.setPart525(baltimore.getPart525() + int.Parse(fields[2]));
                        chicago.setPart525(chicago.getPart525() + int.Parse(fields[2]));
                        denver.setPart525(denver.getPart525() + int.Parse(fields[2]));
                        ely.setPart525(ely.getPart525() + int.Parse(fields[2]));
                        fargo.setPart525(fargo.getPart525() + int.Parse(fields[2]));
                        Console.WriteLine("Updating Part 525\n");
                    }
                    else if (fields[1] == " 711")
                    {
                        atlanta.setPart711(atlanta.getPart711() + int.Parse(fields[2]));
                        baltimore.setPart711(baltimore.getPart711() + int.Parse(fields[2]));
                        chicago.setPart711(chicago.getPart711() + int.Parse(fields[2]));
                        denver.setPart711(denver.getPart711() + int.Parse(fields[2]));
                        ely.setPart711(ely.getPart711() + int.Parse(fields[2]));
                        fargo.setPart711(fargo.getPart711() + int.Parse(fields[2]));
                        Console.WriteLine("Updating Part 711\n");
                    }
                }
                recordIn = reader.ReadLine();
            }

            //end of day status
            Console.WriteLine("End of day status");
            Console.WriteLine("Atlanta: " + atlanta.toString());
            Console.WriteLine("Baltimore: " + baltimore.toString());
            Console.WriteLine("Chicago: " + chicago.toString());
            Console.WriteLine("Denver: " + denver.toString());
            Console.WriteLine("Ely: " + ely.toString());
            Console.WriteLine("Fargo: " + fargo.toString());
        }
    }
}
