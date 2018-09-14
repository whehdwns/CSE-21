//Dongjun Cho
//CSE 21 

import java.util.Scanner;

public class shop {
 
    public static double setup(int max, String[] names, double[]prices){
        Scanner input=new Scanner(System.in);
 
        int i=0;
 
        do{
            System.out.print("Enter name of product " + i + ": ");
            names[i]=input.next();
            System.out.print("Enter price of product " + i + ": ");
            prices[i]=input.nextDouble();
            i++;
        }while(i<max);
        return max;
    }
 
    public static int Buy(String[] names,int[] amounts){
        Scanner input=new Scanner(System.in);
        int i = 0;
        do{
            System.out.print("Enter the amount of " + names[i] + " :");
            amounts[i]=input.nextInt();
            i++;
        } while(i<names.length);
        return amounts[i-1];
    }
 
    public static double listItems(String[] names,int[] amounts, double[]prices,double subtotal){
        int i = 0;
        do{
            System.out.println(amounts[i]+ " count of " + names[i] + " @ " + prices[i] + " = $" + (prices[i]*amounts[i]));
            subtotal+=(prices[i]*amounts[i]);
            i++;
        }while (i<names.length);
        return subtotal;
 
                  }
 
    public static double checkout(double total, double discounts, double discount, double subtotal){
 
        System.out.println("Thanks for coming!");
        if (subtotal>discounts){
            System.out.println("Sub Total: $" + subtotal);
            System.out.println("-Discount: $" + (discount*subtotal));
            total=(subtotal-(discount*subtotal));
            System.out.println("Total\t : $" + total);
        } 
         
         
         
        else if (subtotal < discounts) {
            discount = 0;
            System.out.println("Sub Total: $" + subtotal);
            System.out.println("-Discount: $" + (discount));
            total=(subtotal-(discount*subtotal));
            System.out.println("Total\t : $" + total);
                }
                       return total;
    }
 
    public static void main(String[] args) {
 
        Scanner input=new Scanner(System.in);
 
        String[] names;
        double[] prices;
        int[] amounts;
 
        int max=0;
        int num;
        names = new String[max];
        prices = new double[max];
        amounts = new int[max];
        int total=0;
        double subtotal=0;
        double discount=0;
        double discounts = 0;
 
                  boolean seenZero = false;
        boolean seenOne = false;
 
        while(true){
            System.out.println("This program supports 4 functions:");
            System.out.println("        1.Setup Shop");
            System.out.println("        2. Buy");
            System.out.println("        3.List Items");
            System.out.println("        4.Checkout");
            System.out.print("Please choose the function you want:");
                         num=input.nextInt();    
 
            if (num==1){
                seenZero = true;
                System.out.print("Please enter the number of items:");
                          max=input.nextInt();
 
                names = new String[max];
                prices = new double[max];
                amounts = new int[max];
 
                setup(max, names, prices);
 
                System.out.print("Please enter the amount to qualify for discount: ");
                       discounts=input.nextDouble();
                System.out.print("Please enter the discount rate(0.1 for 10%):");
                        discount=input.nextDouble();
                System.out.println("");
            }
            else if (num==2 && seenZero == true){
                seenOne = true;
                System.out.println("");
                Buy(names,amounts);
                System.out.println("");
            } 
                   else if (seenZero == false && num == 2) {
                   System.out.println("");
                System.out.println("Shop is not setup yet!");
                System.out.println("");
            }
                   else if (seenZero == false && num == 3) {
                System.out.println("");
                System.out.println("Shop is not setup yet!");
                System.out.println("");
            }
                   else if (num==3 && seenZero == true && seenOne == true){
                System.out.println("");
                listItems(names,amounts,prices,subtotal);
                System.out.println("");
            }
            else if (num == 3 && seenOne == false){
                System.out.println("");
                System.out.println("Try again: You have not bought anything");
                System.out.println("");
            }
            else if (num==4 && seenZero == true && seenOne == true){
                System.out.println("");
                checkout(total,discounts,discount,listItems(names, amounts, prices, subtotal));
                System.out.println("");
                break;
            }
            else if (num==4 && seenZero == false){
                System.out.println("");
                System.out.println("Shop is not setup yet!");
                System.out.println("");
            }
            else if (num==4 && seenOne == false){
                System.out.println("");
                System.out.println("Try again: You have not bought anything");
                System.out.println("");
            }
            else{
                System.out.println("");
                System.out.println("Error: do not know " + num);
                System.out.println("");
            }
        }
         }
}