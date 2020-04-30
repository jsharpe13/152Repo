import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
/**************************************************************
* Name        : GUI final project
* Author      : Jacob Sharpe
* Created     : 4/29/2020
* Course      : CIS 152 Data Structures
* Version     : 1.0
* OS          : Windows 10
* Copyright   : This is my own original work based on
*               specifications issued by our instructor
* Description : library check out list that catelogues what each person has check out
*               Input:  user is required to click button and input password and book titles
*               Output: JFrames with book lists
* Academic Honesty: I attest that this is my original work.
* I have not used unauthorized source code, either modified or 
* unmodified. I have not given other fellow student(s) access to
* my program.         
***************************************************************/
public class mainGUI 
{
	public static void main(String[] args)
	{
		booklist bl = new booklist();
		takeOutBook2 tob2 = new takeOutBook2(bl);
		printAllBooks pab = new printAllBooks(bl);
		peopleMap pm = new peopleMap();
		password pw = new password(pm, tob2);
		
		
		JFrame frame = new JFrame("GUI");
		JPanel Menupanel = new JPanel();
		Menupanel.setPreferredSize(new Dimension(500,300));
		//Menupanel.setLayout(new GridLayout(1,3));
		Menupanel.setLayout(new BoxLayout(Menupanel, BoxLayout.PAGE_AXIS));
		
		JLabel welcome = new JLabel("Welcome");
		welcome.setAlignmentX(Component.CENTER_ALIGNMENT);
		Menupanel.add(welcome);
		JLabel choose = new JLabel("Choose what you want to do");
		choose.setAlignmentX(Component.CENTER_ALIGNMENT);
		Menupanel.add(choose);
		JLabel empty = new JLabel(" ");
		empty.setAlignmentX(Component.CENTER_ALIGNMENT);
		Menupanel.add(empty);
		
		JButton button1 = new JButton("View All Books");
		button1.setAlignmentX(Component.CENTER_ALIGNMENT);
		button1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				pab.printMasters();
			}
		});
		
		JButton button2 = new JButton("Lookup Category");
		button2.setAlignmentX(Component.CENTER_ALIGNMENT);
		button2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				pab.getCategoryList();
			}
		});
		JButton button3 = new JButton("Take Out Book");
		button3.setAlignmentX(Component.CENTER_ALIGNMENT);
		button3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				pw.checkPassword();
				
			}
		});
		JButton button4 = new JButton("Return Books");
		button4.setAlignmentX(Component.CENTER_ALIGNMENT);
		button4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				pw.checkPasswordReturn();
				

			}
		});
		JButton button5 = new JButton("Create Password");
		button5.setAlignmentX(Component.CENTER_ALIGNMENT);
		button5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				pm.newPassword();
			}
		});
		
		Menupanel.add(button1);
		JLabel empty1 = new JLabel(" ");
		empty1.setAlignmentX(Component.CENTER_ALIGNMENT);
		Menupanel.add(empty1);
		Menupanel.add(button2);
		JLabel empty2 = new JLabel(" ");
		empty2.setAlignmentX(Component.CENTER_ALIGNMENT);
		Menupanel.add(empty2);
		Menupanel.add(button3);
		JLabel empty3 = new JLabel(" ");
		empty3.setAlignmentX(Component.CENTER_ALIGNMENT);
		Menupanel.add(empty3);
		Menupanel.add(button4);
		JLabel empty4 = new JLabel(" ");
		empty4.setAlignmentX(Component.CENTER_ALIGNMENT);
		Menupanel.add(empty4);
		Menupanel.add(button5);
		frame.add(Menupanel);
		frame.setSize(500,300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
		frame.setVisible(true);
	}
}
