package ht.typingapp;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class TypingApp extends JFrame implements KeyListener {

	private JLabel messageLabel;
	//private JPanel panel;
	private JTextArea typingArea;
	String[] keys = {
            "~", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0",
            "-", "+", "Backspace","Tab", "Q", "W", "E", "R", "T",
            "Y", "U", "I", "O", "P", "[", "]", "\\", "Caps", "A",
            "S", "D", "F", "G", "H", "J", "K", "L", ";", "\"",
            "Enter", "Shift", "Z", "X", "C", "V", "B", "N", "M",
            ",", ".", "?", "Shift", "Up", "Space", "Left", "Down", "Right"
        };
	
	public TypingApp() {
		super("Typing Application");
		setLayout(new FlowLayout(FlowLayout.CENTER, 30, 5));
		//JPanel panel = new JPanel();
		//panel.setLayout(new GridLayout(3, 10));
		 
		messageLabel = new JLabel("Type some text using your keyboard."
				+ "\nthe key you press will be highlighted and the text will displayed"
				+ "\nNote: Clicking the buttons with your mouse will not perform any action.");
		add(messageLabel); 
		
		typingArea = new JTextArea(20, 90); 
		add(new JScrollPane(typingArea));
		

        for (String key : keys) {
            JButton button = new JButton(key);
            //button.addActionListener(this);
            //panel.add(button);
            add(button);
        }

	}

	@Override
	public void keyTyped(KeyEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent event) {
		// TODO Auto-generated method stub
		String text = KeyEvent.getKeyText(event.getKeyCode());
		typingArea.setText(text);
		for(String key : keys) {
			if(text == key) {
				
			}
		}
		
	}

	@Override
	public void keyReleased(KeyEvent event) {
		// TODO Auto-generated method stub
		
	}

	
	
}
