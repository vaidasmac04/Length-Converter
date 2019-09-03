package window;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import app.ActionHandler;

public class MainWindow extends JFrame{
	
	private CenterPanel centerPanel;
	private JLabel statusLabel;
	
	public MainWindow() {
		super("Length Converter");
		this.setLayout(new BorderLayout(50, 50));
		this.getContentPane().setBackground(Color.GRAY);
		
		createComponents();
		addComponents();
		addActionHandler();

		this.pack();
		this.setVisible(true);
	}
	
	private void createComponents() {
		centerPanel = new CenterPanel();
		statusLabel = createStatusLabel();
	}
	
	private void addComponents() {
		this.add(createTitleBar(), BorderLayout.NORTH);
		this.add(centerPanel, BorderLayout.CENTER);
		this.add(statusLabel, BorderLayout.SOUTH);
	}
	
	private void addActionHandler() {
		ActionHandler actionHandler = new ActionHandler(this);
		centerPanel.getInputField().getDocument().addDocumentListener(actionHandler.getDocumentListener());
		centerPanel.getBoxFrom().addItemListener(actionHandler.getItemListener());
		centerPanel.getBoxTo().addItemListener(actionHandler.getItemListener());
	}
	
	private JLabel createStatusLabel() {
		JLabel label = new JLabel("Length converter is ready");
		label.setOpaque(true);
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setBackground(Color.DARK_GRAY);	
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Serif", Font.BOLD, 20));
		return label;
	}
	
	private JLabel createTitleBar() {
		JLabel label = new JLabel("Length Converter");
		label.setOpaque(true);
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setBackground(Color.LIGHT_GRAY);	
		label.setFont(new Font("Serif", Font.BOLD, 40));
		return label;
	}
	
	//-------------getters--------------
	public CenterPanel getCenterPanel(){
		return centerPanel;
	}
	
	public JLabel getStatusLabel() {
		return statusLabel;
	}
}




