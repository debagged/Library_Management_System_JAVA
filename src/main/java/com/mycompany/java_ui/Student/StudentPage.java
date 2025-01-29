package com.mycompany.java_ui.Student;

import com.mycompany.java_ui.LibraryLogInPage;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class StudentPage implements ActionListener {
    
    JFrame frame = new JFrame();
    JButton viewBooksButton = new JButton("View/Borrow Books");
    JButton viewBorrowedBooksButton = new JButton("View Borrowed Books");
    JButton logOutButton = new JButton("Log Out");
    JLabel welcomeLabel = new JLabel("Hello, Student!");
    
    public StudentPage(){
        
        welcomeLabel.setBounds(105,20,200,30);
        welcomeLabel.setFont(new Font(null, Font.PLAIN, 20));
        
        viewBooksButton.setBounds(75,60,185,40);
        viewBooksButton.addActionListener(this);
        viewBooksButton.setFocusable(false);
        
        viewBorrowedBooksButton.setBounds(75,110,185,40);
        viewBorrowedBooksButton.addActionListener(this);
        viewBorrowedBooksButton.setFocusable(false);
        
        logOutButton.setBounds(75,160,185,40);
        logOutButton.addActionListener(this);
        logOutButton.setFocusable(false);
        
        frame.add(welcomeLabel);
        frame.add(viewBooksButton);
        frame.add(viewBorrowedBooksButton);
        frame.add(logOutButton);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350,300);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setTitle("Student");
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==viewBooksButton){
            frame.dispose();
            new LibraryViewBooksStudent();
        }
        
        if(e.getSource()==viewBorrowedBooksButton){
            frame.dispose();
            new LibraryViewBorrowedBooks();
        }
        
        if(e.getSource()==logOutButton){
            frame.dispose();
            new LibraryLogInPage();
        }
    }
    
    public static void main(String[] args){
        new StudentPage();
    }
    
}
