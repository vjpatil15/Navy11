package ankhmorpork;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Rectangle2D;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.AbstractButton;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.plaf.basic.BasicComboBoxEditor;

public class Player_Frame implements ActionListener{
	
	   JFrame myFrame = null;
	   JEditorPane myPane = null;

	   public void Viewer(String dataToView) {
	      myFrame = new JFrame("Ankh_Morpork View Game State");
	      myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      myFrame.setSize(700,500);
	      
	      myPane = new JEditorPane();
	      myPane.setContentType("text/plain");
	      myPane.setText(dataToView);
	      myFrame.setContentPane(myPane);
	      
	      JMenuBar myBar = new JMenuBar();
	      JMenu myMenu = getFileMenu();
	      myBar.add(myMenu); 
	      myFrame.setJMenuBar(myBar);
	      myFrame.setVisible(true);
	   }
	   private JMenu getFileMenu() {
	      JMenu myMenu = new JMenu("File");
	      
	      JMenuItem myItem = new JMenuItem("Exit");
	      myItem.addActionListener(this);
	      myMenu.add(myItem);
	      /*
	      
	      myItem = new JMenuItem("Edit");
	      myItem.addActionListener(this);
	      myMenu.add(myItem);
	      
	      myItem = new JMenuItem("Save");
	      myItem.addActionListener(this);
	      myMenu.add(myItem);
	      */
	      
	      return myMenu;
	   }
	   public void actionPerformed(ActionEvent e) {
	      String cmd = ((AbstractButton) e.getSource()).getText();
	      try {
	         if (cmd.equals("Open")) {
	            FileReader in = new FileReader("JEditorPane.txt");
	            char[] buffer = new char[1024];
	            int n = in.read(buffer);
	            String text = new String(buffer, 0, n);
	            myPane.setText(text);
	            in.close();
	         } else if (cmd.equals("Save")) {
	            FileWriter out = new FileWriter("JEditorPane.txt");
	            out.write(myPane.getText());
	            out.close();
	         } else if (cmd.equals("Exit")){
	        	 myFrame.setVisible(false);
	         }
	      } catch (Exception f) {
	      	 f.printStackTrace();
	      }
	   }
	}
	





