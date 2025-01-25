package com.mycompany.java_UI.Admin;

import com.mycompany.java_UI.LibraryLogInPage;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class AdminPage implements ActionListener {
    
    JFrame frame = new JFrame();
    JButton addBooksButton = new JButton("Add Books");
    JButton viewBooksButton = new JButton("View Books");
    JButton logOutButton = new JButton("Log Out");
    JLabel welcomeLabel = new JLabel("Hello, Admin!");
    
    public AdminPage(){
        
        addBooksButton.setBounds(87,100,115,30);
        addBooksButton.addActionListener(this);
        addBooksButton.setFocusable(false);
        
        viewBooksButton.setBounds(87,140,115,30);
        viewBooksButton.addActionListener(this);
        viewBooksButton.setFocusable(false);
        
        logOutButton.setBounds(87,180,115,30);
        logOutButton.addActionListener(this);
        logOutButton.setFocusable(false);
        
        welcomeLabel.setBounds(85,10,200,100);
        welcomeLabel.setFont(new Font(null, Font.PLAIN, 20));
        
        frame.add(welcomeLabel);
        frame.add(addBooksButton);
        frame.add(viewBooksButton);
        frame.add(logOutButton);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,300);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setTitle("Admin");
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==addBooksButton){
            frame.dispose();
            new LibraryAddBooks();
        }
        
        if(e.getSource()==viewBooksButton){
            frame.dispose();
            new LibraryViewBooksAdmin();
        }
        
        if(e.getSource()==logOutButton){
            frame.dispose();
            new LibraryLogInPage();
        }
    }
    
}
