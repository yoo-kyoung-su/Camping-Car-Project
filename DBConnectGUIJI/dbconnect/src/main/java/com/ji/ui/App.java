package com.ji.ui;

import javax.swing.JFrame;

/**
 * @author JI
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        JFrame frame = new JFrame("Jihyunjung");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //to close normal
        frame.setResizable(false); // can't control frame size
        
        PrimaryPanel primary = new PrimaryPanel();
		frame.getContentPane().add(primary);
		
		frame.pack();
		frame.setVisible(true);
		
    }//main()
}//App class
