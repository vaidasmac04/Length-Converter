package app;

import javax.swing.JTextField;


public class InputGetter {
	private JTextField inputField;
	private String inputText;
	
	public InputGetter(JTextField inputField) {
		this.inputField = inputField;
		inputText = inputField.getText();
	}
	
	public double convertToDouble(){
		if(!isConvertible()) {
			throw new NumberFormatException("Failed to convert. Illegal symbols found.");
		}
		double value = Double.parseDouble(inputText);
		
		if(value <= 0) {
			throw new IllegalArgumentException("Failed to convert. Length must be positive.");
		}
		
		return value;
	}
	
	private boolean isConvertible() {
		try {
			double value = Double.parseDouble(inputText);
			return true;
		}catch (NumberFormatException numberFormatException) {
			return false;
		}
	}
}
