import java.util.Scanner;

public class VendingMachineMain {

	public static void main(String[] args) {
		
		//Scanner to read from user (keyboard)
		Scanner scan = new Scanner(System.in);
		String choice = "";
		int validChoice = 0 ;
		String keypadNumber = "";
		Snack snack ;
		// class MachineManager to add Snaks to VM
		MachineManager machineManager = new MachineManager();
		Snack s1 = machineManager.createSnack("KitKat", 3, 5);
		Snack s2 = machineManager.createSnack("Twix", 7, 2);

		// class SnackVendingMachine to handle user orders
		SnackVendingMachine SVM = new SnackVendingMachine();
		
		SelectSnack selectSnak = new SelectSnack();
		// add two snacks to the VM
		SVM.addSnack(s1);
		SVM.addSnack(s2);

		// print all slots in the VM

		while(true) {
			System.out.println("\nwhat do you want to do ?");
			System.out.println("1. order a snack");
			System.out.println("2. Exit");
			System.out.print("Your Choice : ");
			choice = scan.next();

			try {
				 validChoice = Integer.parseInt(choice);

			} catch (Exception e) {
				System.err.println("Invalid Choice");
				continue;
			}
			
			if(validChoice == 1) {
				SVM.printAllSnacks();
				System.out.print("\n\nPleasse enter the keypad Number : ");
				keypadNumber = scan.next();
				snack = selectSnak.isAvaliable(keypadNumber);
				try {
					if(snack.getSnackQuantity() > 0) {
						
						
						int paymentMethod = 0 ;
						System.out.println("\nPlease choose a payment method");
						System.out.println("1. cash");
						System.out.println("2. Pay by credit card");
						System.out.print("Please enter number 1 or 2 ONLY! : ");
						paymentMethod = scan.nextInt();

						MoneyDeposit moneyDeposit = new MoneyDeposit();
					
						// if the user choose cash then send anything except 1 to moneyDeposit
						if(paymentMethod == 1)	{
							
							String insertedMoney = "";
							int validMoney = 0;
							int remainingMoney = 0;
							moneyDeposit.checkIfCard(0);
							System.out.print("\nPleasse inserts the Money  : ");
							insertedMoney = scan.next();

							
							// handle if the user enther invalid money
							 try
							 {
								 validMoney = Integer.parseInt(insertedMoney);
								 if(validMoney < 0) {
									   System.out.println("Error: Invalid Money");
								 }
								
								 
								 else {
									 if(validMoney == 1 || validMoney == 10 || validMoney == 20 
											 || validMoney == 50) {}
									 else {
										 System.err.println("Only 1, 10, 20 and 50 dollar denominations are accepted");
										 continue;
									 }
										System.out.println("\nYou insert " + insertedMoney + " $");

								 }
							 }
							 catch(Exception ex)
							 {
							    System.out.println("Error: Could not parse money to number");
							    return; //exit function
							 }
							 moneyDeposit.setIncomingMoney(validMoney);
							 remainingMoney = moneyDeposit.sendRemainingMoney(snack);
							 
							 if(remainingMoney == -1) {
								 System.err.println("insufficient money");
							 }
							 else {
							 System.out.println("Your Remaining Money " + remainingMoney);
							 System.out.println("Please pick up your order from the order slot");
							 }
							// TODO Auto-generated method stub
						}
						// if the user choose pay by credit card then send 1 to moneyDeposit
						else if (paymentMethod == 2) {
							moneyDeposit.checkIfCard(1);
							System.out.println("The price of the snack has been deducted from your card");
						}
						else 
							System.out.println("Invalid Number");

					}
				} catch (Exception e) {
					System.err.println("Invalid Input");
					continue;				
					}
			
			}
			else if (validChoice == 2) { 
				System.out.println("Good Bye");
				scan.close();
				System.exit(0);
			}
			else {
				System.out.println("Invalid Number");

			}
		}

	}

}
