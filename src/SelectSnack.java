
public class SelectSnack extends SnackVendingMachine {
	public Snack SnackKeypad;
	
	public Snack isAvaliable(String snackKeypad) {
		int i = 0  ,j = 0;
		for(i = 0 ; i < snacksArray.length ; i++) {
			for(j = 0 ; j < snacksArray[i].length ; j++) {
				if(snacksArray[i][j].getSnackKeypad().equals(snackKeypad)) {
					checkStatus(snacksArray[i][j]);
					return snacksArray[i][j];
					
				}

			}
		}
		return null;
	}
	public int checkStatus(Snack snack) {
		if(snack.getSnackName().equals("empty slot")) {
			System.out.println("This slot is empty");
		}
		else {
			if(snack.getSnackQuantity() > 0) {
				System.out.println("The price of " + snack.getSnackName() +  " is " + snack.getSnackPrice());
			}
			else {
				System.out.println("Unfortunately, out of stock");
			}
				
		}
		return snack.getSnackQuantity();
	}

	
}
