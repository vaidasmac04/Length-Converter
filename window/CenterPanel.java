package window;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import app.ActionHandler;

public class CenterPanel extends JPanel{
	
	private JTextField inputField;
	private JTextField answerField;
	private JComboBox<String> boxFrom;
	private JComboBox<String> boxTo;
	
	public CenterPanel() {
		createComponents();
		setUpPanel();
		addComponents();
	}
	
	private void addComponents() {
		this.add(Box.createRigidArea(new Dimension(20, 10)));
		this.add(new JLabel("From:"));
		this.add(inputField);
		this.add(boxFrom);
		this.add(Box.createRigidArea(new Dimension(30, 10)));
		this.add(new JLabel("To:"));
		this.add(answerField);
		this.add(boxTo);
		this.add(Box.createRigidArea(new Dimension(20, 10)));
	}
	
	private void setUpPanel() {
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		this.setBackground(Color.GRAY);
	}
	
	private void createComponents() {
		boxFrom = new OptionsComboBox();
		boxTo = new OptionsComboBox();
		inputField = new JTextField(10);
		answerField = new JTextField(10);
		
		inputField.setMaximumSize(new Dimension(1000, 30));
		answerField.setMaximumSize(new Dimension(1000, 30));
		boxFrom.setMaximumSize(new Dimension(100, 30));
		boxTo.setMaximumSize(new Dimension(100, 30));
	}
	
    //-----------getters-------------
	public JTextField getInputField() {
		return inputField;
	}

	public JTextField getAnswerField() {
		return answerField;
	}

	public JComboBox<String> getBoxFrom() {
		return boxFrom;
	}

	public JComboBox<String> getBoxTo() {
		return boxTo;
	}
}
