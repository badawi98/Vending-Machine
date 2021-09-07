
public class MachineManager extends SnackVendingMachine {
	
	
	public Snack createSnack(String snackName , int snackQuantity , int snackPrice) {
		Snack snack = new Snack(snackName , snackQuantity , snackPrice);
		return snack;
	}
}
