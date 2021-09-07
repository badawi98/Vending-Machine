
public class SnackVendingMachine {
	
	public static Snack [][] snacksArray;
	
	SnackVendingMachine(){
		 if(snacksArray == null) {
			 snacksArray = new Snack [5][5];
			 for(int i = 0 ; i < snacksArray.length ; i++ ) {
					for(int j = 0 ; j < snacksArray[i].length ; j++) {
						snacksArray[i][j] = new Snack(i,j);
					}
				}
		 }
	}

	public void addSnack(Snack newSnack) {
		for(int i = 0 ; i < snacksArray.length ; i++ ) {
			for(int j = 0 ; j < snacksArray[i].length ; j++) {
				if (snacksArray[i][j].getSnackName().equals("empty slot")) {
					String snackKeypad = ((char)(i+65)) + "" + j;
					newSnack.setSnackkeypad(snackKeypad);
					snacksArray[i][j] = newSnack;
					return;
				}
			}
		}
	}
	public void printAllSnacks() {
		for(int i = 0 ; i < snacksArray.length ; i++ ) {
			System.out.println();
			for(int j = 0 ; j < snacksArray[i].length ; j++) {
				System.out.print(snacksArray[i][j].getSnackKeypad() + "  ");;
				}
			}
	}
	public Snack getSnack(String snackKeypad) {
		for(int i = 0 ; i < snacksArray.length ; i++ ) {
			for(int j = 0 ; j < snacksArray[i].length ; j++) {
				if(snacksArray[i][j].getSnackKeypad().equals(snackKeypad)) {
					return snacksArray[i][j];
					
				}
			}
		}
		return null;
	}
	
}
