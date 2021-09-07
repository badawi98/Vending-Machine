
public class Snack {
	private String snackName , snackKeypad;
	private int snackPrice , snackQuantity;
	
	Snack(int i , int j ){
		this.snackKeypad = ((char) (i+65)) + "" + j;
		this.snackName = "empty slot";
		this.snackPrice = 0;
		this.snackQuantity = 0;
	}
	Snack (String name , int quantity , int price){
		this.snackName = name;
		this.snackPrice = price;
		this.snackQuantity = quantity;
	}
	
	public void setSnackkeypad(String keypad) {
		this.snackKeypad = keypad;
	}
	
	public void setSnackName(String newName) {
		this.snackName = newName;
		
	}
	
	public void setSnackPricee(int newPrice) {
		this.snackPrice = newPrice;
	}
	
	public void setSnackQuantity (int newQuantity) {
		this.snackQuantity = newQuantity;
	}
	
	public int getSnackQuantity() {
		return this.snackQuantity;
	}
	public int getSnackPrice() {
		return this.snackPrice;
	}
	public String getSnackName() {
		return this.snackName;
	}
	public String  getSnackKeypad() { 
		return this.snackKeypad;
	}
}
