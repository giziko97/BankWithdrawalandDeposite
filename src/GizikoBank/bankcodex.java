package GizikoBank;

import java.util.*;
public class bankcodex {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random rd = new Random();
		ArrayList<String> accountid = new ArrayList<>();
		ArrayList<String> accountname = new ArrayList<>();
		ArrayList<String> accountpin = new ArrayList<>();
		int pinmax = 1;
		int menumax = 1;
		int choicemax = 1;
		
		for(int a=1; a<=menumax; a++) {
			System.out.println("1. New Account");
			System.out.println("2. Login");
			System.out.print("Enter you Choices: ");
			int choice = sc.nextInt();
			
			if(choice == 1) {
				System.out.println("Welcome to GizikoBank of the World");
				System.out.println("Please Enter the Following: ");
				System.out.print("ID number: ");
				int tempID = Math.abs(rd.nextInt(99999999)+1);
				String ID = Integer.toString(tempID);
				System.out.println(ID);
				accountid.add(ID);
				System.out.print("Enter Name: ");
				String name = sc.next();
				accountname.add(name);
				
				for(int i=1; i<=pinmax; i++) {
					System.out.println("Create your own pin number: ");
					int temppin = sc.nextInt();
					String pin = Integer.toString(temppin);
					
					if(pin.length() < 4 || pin.length() > 4) {
						System.out.println("Enter exactly 4 pin numbers!!!");
						pinmax+=1;
					}
					else if(pin.length() == 4) {
						accountpin.add(pin);
						for(int j=1; j<=choicemax; j++) {
							System.out.println("Do you want to return from the start? ");
							String choices2 = sc.next(); 
							if(choices2.equals("Yes")|| choices2.equals("YES")|| choices2.equals("yes")) {
								menumax+=1;
							}
							else if(choices2.equals("No") || choices2.equals("NO") || choices2.equals("no")) {
								menumax+=0;
							}
							else {
								System.out.println("Error input! Try again!!!!!");
								choicemax +=1;
							}
						}
					}
				}
			}
			
			else if(choice == 2) {
				int idmax = 1;
				System.out.println("Welcome to GizikoBank of the World");
				if(accountid.isEmpty() && accountname.isEmpty() && accountpin.isEmpty()) {
					System.out.println("There is no Data inside. Please Create your own account!");
					menumax +=1;
				}
				else {
					for(int i=1; i<=idmax; i++) {
						System.out.println("Enter your ID number: ");
						String accid = sc.next();
						if(accid.length() == 8) {
							for(int j=1; j<=accountid.size(); j++) {
								if(accountid.contains(accid)) {
									System.out.println("ID Accepted");
									System.out.println("Enter your pin number: ");
									int pinup = sc.nextInt();
									String Inputpin = Integer.toString(pinup);
									for(int k=1; k<= accountpin.size(); k++) {
										if(accountpin.contains(Inputpin)) {
											int withmax = 1;
											int bankmoney= 0;
											System.out.println("Pin accepted");
											for(int l=1; l<=withmax; l++) {
												System.out.print("Welcome to Gizibank of the World \n"
														+ "1. Withdraw \n"
														+ "2. Deposit \n"
														+ "3. Balance Inquiry \n");
												System.out.print("Enter choice: ");
												int choice2 = sc.nextInt();
												if(choice2 == 1) {
													if(bankmoney == 0 ) {
														System.out.println("There is no money inside the bank. Please deposit at least 100 pesos. ");
														withmax+=1;
													}
													else if(bankmoney > 100) {
														System.out.println("Enter money to withdraw: ");
														int withmoney = sc.nextInt();
														bankmoney -= withmoney;
														System.out.print(withmoney + " was withdrawn from the bank. Thank you for using GizikoBank of the World! Have a nice day!");
														withmax += 1;
													}
													else {
														System.out.println("Balance is now below 100. You must have at least 100 pesos in the bank to withdraw money.");
														withmax+=1;
													}
												}
												else if(choice2 == 2){
													int depmax = 1;
													System.out.println("Enter number to be deposit: ");
													int moneydep = sc.nextInt();
													for(int n=1; n<=depmax; n++) {
														if(moneydep >= 100) {
															bankmoney += moneydep;
															System.out.print(moneydep + " was deposited from the bank. Thank you for using GizikoBank of the World! Have a nice day!");
															withmax += 1;
														}
														else {
															System.out.println("You should deposit at least 100 pesos");
															depmax += 1;
														}
													}
													
												}
												else if(choice2 == 3) {
													int balmax = 1;
													System.out.println("Your bank account has a balance of P" + bankmoney);
													for(int m=1; m<=balmax; m++) {
														System.out.println("Do you want to return from the start? ");
														String choices2 = sc.next(); 
														if(choices2.equals("Yes")|| choices2.equals("YES")|| choices2.equals("yes")) {
															withmax+=1;
														}
														else if(choices2.equals("No") || choices2.equals("NO") || choices2.equals("no")) {
															withmax+=0;
														}
														else {
															System.out.println("Error input! Try again!!!!!");
															balmax +=1;
														}
													}
												}
												else {
													System.out.println("Error input. Try again");
													withmax += 1;
												}
											}
										}
										else {
										 System.out.println("ID not found. Check if it is correct!");
										 idmax += 1;
										}
									}
								}
								else {
									System.out.println("ID not found. Check if it is correct!");
									idmax += 1;
								}
							}
						}
					}
				}
			}
		}
		sc.close();
	}
}
