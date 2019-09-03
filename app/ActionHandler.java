package app;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.math.BigDecimal;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import window.MainWindow;

public class ActionHandler{

	private MainWindow mainWindow;
	private String statusMessage;
	
	public ActionHandler(MainWindow mainWindow) {
		this.mainWindow = mainWindow;
	}
	
	public DocumentListener getDocumentListener() {
		DocumentListener documentListener = new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				update();
				
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				update();
				
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
	
			}
		};
		
		return documentListener;
	}
	
	public ItemListener getItemListener() {
		ItemListener itemListener = new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				update();
			}
		};
		
		return itemListener;
	}
	
	private void update() {
		InputGetter inputGetter = new InputGetter(mainWindow.getCenterPanel().getInputField());
		String text = mainWindow.getCenterPanel().getInputField().getText();
		if(text.length() != 0) {
			try {
				double value = inputGetter.convertToDouble();
				
				BigDecimal answer = BigDecimal.valueOf(Converter.getAnswer(
						value, (String)mainWindow.getCenterPanel().getBoxFrom().getSelectedItem(), 
						(String)mainWindow.getCenterPanel().getBoxTo().getSelectedItem())).stripTrailingZeros();
				
				mainWindow.getCenterPanel().getAnswerField().setText(answer.toPlainString());
				
				statusMessage = "Converted successfully";
			}catch(NumberFormatException numberFormatException) {
				statusMessage = numberFormatException.getMessage();
				mainWindow.getCenterPanel().getAnswerField().setText("");
				
			}catch(IllegalArgumentException illegalArgumentException) {
				statusMessage = illegalArgumentException.getMessage();
				mainWindow.getCenterPanel().getAnswerField().setText("");
			}
			
		}
		else {;
			mainWindow.getCenterPanel().getAnswerField().setText("");
			statusMessage = "Length converter is ready";
		}
		
		mainWindow.getStatusLabel().setText(statusMessage);
	}
}




