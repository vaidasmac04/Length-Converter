package window;

import javax.swing.JComboBox;

public class OptionsComboBox extends JComboBox<String>{
	
	public OptionsComboBox() {
		fill();
		this.setSelectedIndex(0);
	}
	
	private void fill() {
		String[] parameter = {"mm", "cm", "dm", "m", "km", "in", "ft", "yd", "mi"};
		
		for(int i = 0; i < parameter.length; i++) {
			this.addItem(parameter[i]);
		}
	}
}
