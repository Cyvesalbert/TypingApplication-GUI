package ht.typingapp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;

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
	private HashMap<String, JButton> keyButtonMap;  // Map to store key-button associations
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
		
		keyButtonMap = new HashMap<>();  // Initialize the key-button map
		

        for (String key : keys) {
            JButton button = new JButton(key);
            keyButtonMap.put(key, button); // Store the button with its corresponding key in the map
            add(button);
            button.addKeyListener(this);
            //panel.add(button);
            
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

	    // Reset all buttons to default color first
	    for (JButton button : keyButtonMap.values()) {
	        button.setBackground(Color.LIGHT_GRAY);
	    }

	    // If a key is pressed and its corresponding button exists, highlight it
	    JButton pressedButton = keyButtonMap.get(text);
	    if (pressedButton != null) {
	        pressedButton.setBackground(Color.RED);
	    }
		
	}

	private JButton getButtonForKey(String text) {
		// TODO Auto-generated method stub
		// Handle special cases for Space, Backspace, etc.
        switch (text) {
            case "Space":
                return keyButtonMap.get("Space");
            case "Backspace":
                return keyButtonMap.get("Backspace");
            case "Enter":
                return keyButtonMap.get("Enter");
            case "Tab":
                return keyButtonMap.get("Tab");
            case "Left Arrow":
                return keyButtonMap.get("Left");
            case "Right Arrow":
                return keyButtonMap.get("Right");
            case "Up Arrow":
                return keyButtonMap.get("Up");
            case "Down Arrow":
                return keyButtonMap.get("Down");
            default:
                // For letters, numbers, and special characters
                return keyButtonMap.get(text.toUpperCase());
	}
	}

	@Override
	public void keyReleased(KeyEvent event) {
		// TODO Auto-generated method stub
		String text = KeyEvent.getKeyText(event.getKeyCode());
		
        JButton button = getButtonForKey(text); // Find the corresponding button and reset its background color
        if(button != null) {
        	button.setBackground(null);
        }
	}

	
	
}
