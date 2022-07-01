package GizikoBank;

import java.util.*;
public class multilistdatastorage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> accountid = new ArrayList<>();
		ArrayList<String> accountname = new ArrayList<>();
		ArrayList<String> accountpin = new ArrayList<>();
		ArrayList<ArrayList<String>> datastorage = new ArrayList<>();
		
		Scanner sc = new Scanner(System.in); //Using Scanner function for inputs
		Random rd = new Random(); //using random
		int count = 1; //count for loop return
		
		for(int a=1; a<=count; a++) {
			System.out.print("ID number: ");
			int tempID = Math.abs(rd.nextInt(99999999));
			String ID = Integer.toString(tempID);
			accountid.add(ID);
			System.out.println(ID);
			//Random ID Generator
			
			System.out.print("Enter Name: ");
			String name = sc.next();
			accountname.add(name);
			//Storing name after inputs
			
			
			for(int i =1; i<=count; i++) {
				System.out.print("Enter pin number: ");
				int temppin = sc.nextInt();
				String pin = Integer.toString(temppin);
				if(pin.length()== 4) {
					System.out.println("pin accepted");
					accountpin.add(pin);
					count = 1;
				}
				else {
					System.out.println("Pin must have 4 numbers only. Try again!");
					count+=1;
				}
			}
			
			datastorage.add(accountname);
			datastorage.add(accountid);
			datastorage.add(accountpin);
			
			System.out.println(datastorage);
			count = 1;
			
			if(count == 1) {
				int count2 = 1;
				for(int i=1; i<=count2; i++) {
					System.out.println("Do you want to continue? [Yes] or [No]");
					String choice = sc.next();
					if(choice.equals("Yes") || choice.equals("YES") || choice.equals("yes")) {
						count+=2;
					}
					else if(choice.equals("No") || choice.equals("NO") || choice.equals("no")) {
						System.out.println("Thank you for Using GizikoBank of the World");
					}
					else {
						System.out.println("Error. Try again!");
						count2+=1;
					}
				}
			}
		}
		
		sc.close();
	}

}
