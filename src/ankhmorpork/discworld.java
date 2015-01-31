package ankhmorpork;
import java.applet.Applet;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import ankhmorpork.GameLoad.*;
import ankhmorpork.GameObjects.*;

import java.applet.AudioClip;
import java.awt.event.*;
import java.awt.image.*;
import java.lang.*;
import java.util.*;
import java.net.*;
import java.awt.*;
import java.io.*;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.BorderLayout;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import ankhmorpork.Game.Game;
import ankhmorpork.GameObjects.Area;

public class discworld extends Applet implements ActionListener, WindowListener {
	
	private static final long serialVersionUID = 1L;
	static Frame mainFrame = new Frame( " Ank Morpork " );
	static discworldboard discworldboard;
	static final DoubleBufferPanel dbp = new DoubleBufferPanel();
	static final BufferPanel bp = new BufferPanel();
	static final Frame a = new Frame();
	static final Frame b = new Frame();//for player
	private Button yes = new Button(" Yes ");
	private Button no = new Button (" No ");
	private Button Roll  = new Button( "Roll Dice" );

//	private List property;// = new List();

	static final Button start2 = new Button( "Two Player" );
	static final Button start3 = new Button( "Three Player" );
	static final Button start4 = new Button( "Four Player" );

	static final Button load = new Button( "Load Game!" );

	static final Button Quit = new Button ("Close ");
	static final Button Exit = new Button ("Exit Game "); 
	static final Button ViewState = new Button ("View State "); 
	static final Button Save = new Button ("Save Game "); 

	static final Label comments2 = new Label ("Please enter your names for player 1 and player 2 .");
	static final Label comments4 = new Label ("");
	static final Button Info = new Button ("Rules");

	Image back ;



	//ashish code
    public static void main(String argv[]) 
    {

    	Area[] AreaList = new Area[13];
    	AreaList[0]=new Area(0,0,"Not on Board",0);
    	AreaList[1]=new Area(1,6,"Dolly Sisters",0);
    	AreaList[2]=new Area(2,18,"Unreal Estate",0);
    	AreaList[3]=new Area(3,12,"Dragon's Landing",0);
    	AreaList[4]=new Area(4,18,"Small Gods",0);
    	AreaList[5]=new Area(5,6,"The Scours",0);
    	AreaList[6]=new Area(6,12,"The Hippo",0);
    	AreaList[7]=new Area(7,6,"The Shades",0);
    	AreaList[8]=new Area(8,6,"Dimwel",0);
    	AreaList[9]=new Area(9,12,"Longwall",0);
    	AreaList[10]=new Area(10,12,"Isle of Gods",0);
    	AreaList[11]=new Area(11,18,"Seven Sleepers",0);
    	AreaList[12]=new Area(12,12,"Nap Hill",0);
    	System.out.println("Welcome to Ankh-Morpork");	
    	System.out.println("Enter number of Players:");
    	Integer input=0;
     new discworld();

    }

 
	public void init() {

		a.setSize( 380, 390 );
		a.setBackground(new Color( (20), (100), (90) ));
		a.setLayout(new FlowLayout(FlowLayout.CENTER));
		a.setResizable(false);
		Panel mainstuff = new Panel(new GridLayout(0,1));

		mainstuff.add(comments2);
		mainstuff.add(comments4);
		mainstuff.add(new Label ("            "));

		mainstuff.add(new Label ("          "));
		mainstuff.add( start2 );
		mainstuff.add( start3 );
		mainstuff.add( start4 );

		mainstuff.add(load);
		mainstuff.add(Exit);
		a.add(mainstuff);
		a.setVisible( true );
		Exit.addActionListener(this);
		Info.addActionListener(this);
		start2.addActionListener( this );
		start3.addActionListener( this );
		start4.addActionListener( this );

		mainFrame.addWindowListener( this );
	}
	public void paint(Graphics g){
		g.drawImage(back,15,15,this);
	}
	public void actionPerformed( ActionEvent e ) {
	
		
	if (e.getSource() == Exit){
	    a.setVisible(false);    
	    }
	
	    
	if (e.getSource() == start2 || e.getSource() == start3 || e.getSource() == start4 ){
		
			if(e.getSource() == start2)
			//discworldboard = new discworldboard( tf1.getText(), tf2.getText() );
			discworldboard = new discworldboard( );
		    //GamLoad gm1 = new GamLoad();
		    //gm1.LoadGame();
					
			String Player1, Player2, Player3, Player4;
			
			if(e.getSource() == start2){
				
				
				//Player1= JOptionPane.showInputDialog("Please input mark for Player 1: ");
				//Player2= JOptionPane.showInputDialog("Please input mark for Player 2: ");
								
			}else if(e.getSource() == start3){
				 Player1= JOptionPane.showInputDialog("Please input mark for Player 1: ");
				 Player2= JOptionPane.showInputDialog("Please input mark for Player 2: ");
				 Player3= JOptionPane.showInputDialog("Please input mark for Player 3: ");
			}else if(e.getSource() == start4){
				Player1= JOptionPane.showInputDialog("Please input mark for Player 1: ");
				Player2= JOptionPane.showInputDialog("Please input mark for Player 2: ");
				Player3= JOptionPane.showInputDialog("Please input mark for Player 3: ");
				Player4= JOptionPane.showInputDialog("Please input mark for Player 4: ");
			}
	    
	    	    
		a.setVisible( false );
		dbp.setLayout(new BorderLayout());
		bp.setLayout( new BorderLayout() );	
		mainFrame.setSize( 2000,1500 );
		mainFrame.setBackground(new Color( (100), (180), (150) ) ); //blue color
		mainFrame.setLayout( new FlowLayout(FlowLayout.CENTER));
		mainFrame.add(dbp );
		dbp.add( "Center", bp );
		bp.add( discworldboard);
		
		
		Panel buttons = new Panel(new GridLayout(0,1));
								
				buttons.add(Roll);
				Roll.addActionListener(new ActionListener() {
					public void actionPerformed( ActionEvent e ) {
							if( !discworldboard.rolled ) {
								discworldboard.Roll();
							}
					}});

				buttons.add(Save);
				Save.addActionListener(new ActionListener() {
					public void actionPerformed( ActionEvent e ) {
						discworldboard.SaveGame();
					}});	
				buttons.add(ViewState);
				ViewState.addActionListener(new ActionListener() {
					public void actionPerformed( ActionEvent e ) {
						discworldboard.ViewGameState();
					}});
				buttons.add(Quit);
				Quit.addActionListener(new ActionListener() {
					public void actionPerformed( ActionEvent e ) {
						discworldboard.quit();
					}});
					


								
		mainFrame.add(buttons);
		mainFrame.setVisible( true );
		}
	}
	
 		Button exit = new Button ("<< Return Back");

	public void windowClosing( WindowEvent e ) {
		System.exit( 0 );
	}
	public void windowIconified( WindowEvent e ) {}
	public void windowClosed( WindowEvent e ) {}
	public void windowActivated( WindowEvent e ) {}
	public void windowDeactivated( WindowEvent e ) {}
	public void windowDeiconified( WindowEvent e ) {}
	public void windowOpened( WindowEvent e ) {}
	public void processKeyEvent (KeyEvent e) {
		if( e.getKeyChar() =='q' || e.getKeyChar() == 'Q'){
		    mainFrame.setVisible (false);
		    System.exit(0);}
		}
}
