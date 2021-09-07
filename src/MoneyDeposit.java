
public class MoneyDeposit  {
	public boolean isCard;
	public int incomingMoney;
	
	MoneyDeposit(){
	//	System.out.print("in MD");
	//	printAllSnacks();
	}
	public void checkIfCard (int paymentMethod) {
		if(paymentMethod == 1)
			this.isCard = true;
		else 
			this.isCard = false;
	}
	
	public void setIncomingMoney(int incomingMoney) {
		this.incomingMoney = incomingMoney;
	}
	public int sendRemainingMoney (Snack snack) {

		// return -1 if the user enters a number less than the desired price
		if(snack.getSnackPrice() > incomingMoney)
			return -1;
		
		else {
			int newSnackQuantity = snack.getSnackQuantity() - 1;
			snack.setSnackQuantity(newSnackQuantity);
		// return  remaining money if the user enters a number grater than the desired price
			if (snack.getSnackPrice() < incomingMoney) {
				return incomingMoney - snack.getSnackPrice();

			}
		
		// return 0 If the user enters the desired number exactly
			else 
				return 0;
		}
	}

}
