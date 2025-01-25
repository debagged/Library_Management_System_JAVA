package com.mycompany.java_UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import com.mycompany.java_library.users.*;

public class LibraryRegisterPage implements ActionListener, MouseListener{
    
    JFrame registerFrame = new JFrame();

    CustomRoundedButton registerButton = new CustomRoundedButton("Register");
    JTextField usernameField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JPasswordField confirmPasswordField = new JPasswordField();
    
    JLabel usernameLabel = new JLabel("Username:");
    JLabel passwordLabel = new JLabel("Password:");
    JLabel confirmPasswordLabel = new JLabel("Confirm Password:");
    JLabel emptyUsernameMessageLabel = new JLabel();
    JLabel emptyPasswordMessageLabel = new JLabel();
    JLabel emptyConfirmPasswordMessageLabel = new JLabel();
    JLabel matchPasswordMessageLabel = new JLabel();
    
    JPanel headerPanel = new JPanel();
    JPanel leftPanel = new JPanel();
    JPanel rightPanel = new JPanel();
    JPanel footerPanel = new JPanel();
    JPanel centerPanel = new JPanel();
    
    JPanel titlePanel = new JPanel();
    JPanel registerFieldPanel = new JPanel();
    
    JLabel haveAccount1 = new JLabel("Already have an Account?");
    JLabel haveAccount2 = new JLabel("Log in");
    JLabel haveAccountLine = new JLabel("_____");
    
    public LibraryRegisterPage(){
        
        //===================================================================//
        //---------------------------FRAME SET UP--------------------------- //
        //===================================================================//
        ImageIcon icon = new ImageIcon("logo.jpg");
        
        registerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        registerFrame.setSize(950,600);
        registerFrame.setResizable(false);
        registerFrame.setTitle("Register");
        registerFrame.setIconImage(icon.getImage());
        registerFrame.setLayout(new BorderLayout());
        registerFrame.setLocationRelativeTo(null);
        
        BackgroundPanel bgPanel = new BackgroundPanel("logInPageBG.jpg");
        bgPanel.setPreferredSize(new Dimension(950,600));
        bgPanel.setLayout(new BorderLayout());
        //-------------------------------------------------------------------- //
        
        //----------------------------BORDERS-------------------------------- //
        headerPanel.setBackground(Color.decode("#182c25"));
        headerPanel.setOpaque(false);
        headerPanel.setPreferredSize(new Dimension(950,50));
        
        leftPanel.setBackground(Color.decode("#182c25"));
        leftPanel.setOpaque(false);
        leftPanel.setPreferredSize(new Dimension(80,600));
        
        rightPanel.setBackground(Color.decode("#182c25"));
        rightPanel.setOpaque(false);
        rightPanel.setPreferredSize(new Dimension(70,600));
        //------------------------------------------------------------------ //
        
        //----------------------------FOOTER-------------------------------- //
        JLabel line2 = new JLabel("___________________________________________________________________________________________");
        line2.setBounds(80,0,900,20);
        line2.setForeground(Color.white);
        line2.setFont(new Font("Serif", Font.BOLD, 15));
        
        JLabel footerDescription = new JLabel();
        footerDescription.setBounds(80,25,900,15);
        footerDescription.setText("OLFU BookHub is a comprehensive and user-friendly book management system designed");
        footerDescription.setForeground(Color.white);
        footerDescription.setFont(new Font("Arial", Font.PLAIN, 11));
        
        JLabel footerDescription2 = new JLabel();
        footerDescription2.setBounds(80,40,900,12);
        footerDescription2.setText("specifically for the students and faculty of Our Lady of Fatima University(OLFU)");
        footerDescription2.setForeground(Color.white);
        footerDescription2.setFont(new Font("Arial", Font.PLAIN, 11));
        
        footerPanel.setBackground(Color.decode("#182c25"));
        footerPanel.setOpaque(false);
        footerPanel.setLayout(null);
        footerPanel.setPreferredSize(new Dimension(950,70));
        footerPanel.add(line2);
        footerPanel.add(footerDescription);
        footerPanel.add(footerDescription2);
        //------------------------------------------------------------------ //
        
        //===================================================================//
        //----------------------------MAIN PANEL---------------------------- //
        //===================================================================//
        centerPanel.setBackground(Color.decode("#182c25"));
        centerPanel.setPreferredSize(new Dimension(450,470));
        centerPanel.setOpaque(false);
        centerPanel.setLayout(new BorderLayout());
        
        //------------------LEFT OF MAIN PANEL (TITLE)---------------------- //
        JLabel title = new JLabel();
        title.setBounds(0,100,250,30);
        title.setText("LRC LIBRARY");
        title.setForeground(Color.white);
        title.setFont(new Font("Serif", Font.BOLD, 35));
        
        JLabel line = new JLabel("__________________________");
        line.setBounds(0,115,400,30);
        line.setForeground(Color.white);
        line.setFont(new Font("Serif", Font.BOLD, 25));
        
        JLabel titleDescription = new JLabel();
        titleDescription.setBounds(0,140,250,30);
        titleDescription.setText("OUR LADY OF FATIMA LIBRARY SYSTEM");
        titleDescription.setForeground(Color.white);
        titleDescription.setFont(new Font("Serif", Font.BOLD, 12));
        
        titlePanel.setLayout(null);
        titlePanel.setPreferredSize(new Dimension(440,400));
        titlePanel.setOpaque(false);
        titlePanel.setBackground(Color.decode("#182c25"));
        titlePanel.add(title);
        titlePanel.add(line);
        titlePanel.add(titleDescription);
        //------------------------------------------------------------------ //
        
        //--------RIGHT OF MAIN PANEL (RESET PASSWORD FIELD) (1/2)---------- //
        registerFieldPanel.setPreferredSize(new Dimension(350,470));
        registerFieldPanel.setOpaque(false);
        registerFieldPanel.setBackground(Color.decode("#182c25"));
        registerFieldPanel.setLayout(null);
        
        JLayeredPane registerField = new JLayeredPane();
        registerField.setBounds(0,0,350,460);
        
        RoundedPanel registerFieldContainer = new RoundedPanel(20);
        registerFieldContainer.setBackground(Color.decode("#E8F1DC"));
        
        RoundedPanel registerContainerHeader = new RoundedPanel(20);
        registerContainerHeader.setBackground(Color.decode("#123524"));
        //------------------------------------------------------------------ //
        
        //------------------RESET PASSWORD FIELD HEADER--------------------- //
        JLabel resetPass = new JLabel("Register");
        resetPass.setForeground(Color.white);
        resetPass.setFont(new Font("Calibri", Font.PLAIN,26));
        
        registerContainerHeader.setBounds(50,15,120,38);
        registerContainerHeader.add(resetPass);
        
        registerFieldContainer.setBounds(20,40,310,390);
        registerFieldContainer.setLayout(null);
        
        registerField.add(registerFieldContainer, Integer.valueOf(0));
        registerField.add(registerContainerHeader, Integer.valueOf(1));
        //------------------------------------------------------------------ //
        
        //--------RIGHT OF MAIN PANEL (RESET PASSWORD FIELD) (1/2)---------- //
        usernameLabel.setBounds(30,30,100,25);
        usernameLabel.setForeground(Color.decode("#404737"));
        usernameLabel.setFont(new Font("Calibri", Font.BOLD, 17));
        
        passwordLabel.setBounds(30,105,120,25);
        passwordLabel.setForeground(Color.decode("#404737"));
        passwordLabel.setFont(new Font("Calibri", Font.BOLD, 17));
        
        confirmPasswordLabel.setBounds(30,185,170,25);
        confirmPasswordLabel.setForeground(Color.decode("#404737"));
        confirmPasswordLabel.setFont(new Font("Calibri", Font.BOLD, 17));
        
        emptyUsernameMessageLabel.setBounds(30,85,225,15);
        emptyUsernameMessageLabel.setForeground(Color.decode("#BE3144"));
        emptyUsernameMessageLabel.setFont(new Font(null, Font.ITALIC, 11));
        
        emptyPasswordMessageLabel.setBounds(30,160,225,15);
        emptyPasswordMessageLabel.setForeground(Color.decode("#BE3144"));
        emptyPasswordMessageLabel.setFont(new Font(null, Font.ITALIC, 11));
        
        emptyConfirmPasswordMessageLabel.setBounds(30,240,225,15);
        emptyConfirmPasswordMessageLabel.setForeground(Color.decode("#BE3144"));
        emptyConfirmPasswordMessageLabel.setFont(new Font(null, Font.ITALIC, 11));
        
        matchPasswordMessageLabel.setBounds(30,240,225,15);
        matchPasswordMessageLabel.setForeground(Color.decode("#BE3144"));
        matchPasswordMessageLabel.setFont(new Font(null, Font.ITALIC, 11));
        
        usernameField.setBounds(30,50,250,35);
        usernameField.setBackground(Color.decode("#667860"));
        usernameField.setForeground(Color.decode("#E8F1DC"));
        usernameField.setBorder(new EmptyBorder(5,10,0,0));
        usernameField.setFont(new Font("Calibri", Font.PLAIN, 17));
        
        passwordField.setBounds(30,125,250,35);
        passwordField.setBorder(new EmptyBorder(5,10,5,0));
        passwordField.setBackground(Color.decode("#667860"));
        passwordField.setForeground(Color.decode("#E8F1DC"));
        passwordField.setFont(new Font(null, Font.PLAIN, 17));
        
        confirmPasswordField.setBounds(30,205,250,35);
        confirmPasswordField.setBorder(new EmptyBorder(5,10,5,0));
        confirmPasswordField.setBackground(Color.decode("#667860"));
        confirmPasswordField.setForeground(Color.decode("#E8F1DC"));
        confirmPasswordField.setFont(new Font(null, Font.PLAIN, 17));
        
        registerButton.setBounds(30,280,250,45);
        registerButton.setFocusable(false);
        registerButton.setFont(new Font("Calibri", Font.BOLD, 21));
        registerButton.setForeground(Color.white);
        registerButton.setBackground(Color.decode("#123524"));
        registerButton.addActionListener(this);
        registerButton.addMouseListener(this);
        
        haveAccount1.setBounds(85, 335, 150, 15);
        haveAccount1.setForeground(Color.decode("#123524"));
        haveAccount1.setFont(new Font(null, Font.BOLD, 12));
        
        haveAccount2.setBounds(135, 350, 150, 15);
        haveAccount2.setForeground(Color.decode("#123524"));
        haveAccount2.setFont(new Font(null, Font.BOLD, 12));
        haveAccount2.addMouseListener(this);
        
        haveAccountLine.setBounds(135, 350, 60, 15);
        haveAccountLine.setForeground(Color.decode("#123524"));
        haveAccountLine.setFont(new Font(null, Font.BOLD, 12));
        //----------------------------------------------------------------- //
        
        //===================================================================//
        //-----------------------ADDING COMPONENTS-------------------------- //
        //===================================================================//
        registerFieldContainer.add(usernameLabel);
        registerFieldContainer.add(passwordLabel);
        registerFieldContainer.add(confirmPasswordLabel);
        registerFieldContainer.add(emptyUsernameMessageLabel);
        registerFieldContainer.add(emptyPasswordMessageLabel);
        registerFieldContainer.add(emptyConfirmPasswordMessageLabel);
        registerFieldContainer.add(matchPasswordMessageLabel);
        registerFieldContainer.add(usernameField);
        registerFieldContainer.add(passwordField);
        registerFieldContainer.add(confirmPasswordField);
        registerFieldContainer.add(registerButton);
        registerFieldContainer.add(haveAccount1);
        registerFieldContainer.add(haveAccount2);
        registerFieldContainer.add(haveAccountLine);
        
        centerPanel.add(registerFieldPanel, BorderLayout.EAST);
        centerPanel.add(titlePanel, BorderLayout.WEST);
        
        bgPanel.add(headerPanel, BorderLayout.NORTH);
        bgPanel.add(leftPanel, BorderLayout.WEST);
        bgPanel.add(rightPanel, BorderLayout.EAST);
        bgPanel.add(footerPanel, BorderLayout.SOUTH);
        bgPanel.add(centerPanel, BorderLayout.CENTER);
        
        registerFrame.add(bgPanel, BorderLayout.CENTER);
        
        // ADDING LAYERED PANE TO LOG IN FIELD //
        registerFieldPanel.add(registerField);
        
        //------------------------------------------------------------------ //
        
        registerFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        
        UserData userData = new UserData();
        
        String username = usernameField.getText();
        String password = String.valueOf(passwordField.getPassword());
        String confirmPass = String.valueOf(confirmPasswordField.getPassword());
        
        if(e.getSource()==registerButton){
            emptyUsernameMessageLabel.setText(null);
            emptyPasswordMessageLabel.setText(null);
            emptyConfirmPasswordMessageLabel.setText(null);
            matchPasswordMessageLabel.setText(null);
            
            if(username.isEmpty()){
                emptyUsernameMessageLabel.setText("Please enter username");
                return;
            }
            
            if(password.isEmpty()){
                emptyPasswordMessageLabel.setText("Please enter password");
                return;
            }
            
            if(confirmPass.isEmpty()){
                emptyConfirmPasswordMessageLabel.setText("Please confirm password");
                return;
            }
            
            if(password.equals(confirmPass)){
                userData.saveDataToFile(username, password);
                
                JOptionPane.showMessageDialog(registerFrame, "Registration Successful", "Registered", JOptionPane.PLAIN_MESSAGE);
                usernameField.setText(null);
                passwordField.setText(null);
                confirmPasswordField.setText(null);
                usernameField.requestFocusInWindow();
                
            } else{
                matchPasswordMessageLabel.setText("Passwords must match");
            }
        } 
    } 
    

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource()==haveAccount2){
            registerFrame.dispose();
            new LibraryLogInPage();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
        if(e.getSource()==registerButton){
            registerButton.setLocation(registerButton.getX(), registerButton.getY()-2);
        }
        
        if(e.getSource()==haveAccount2){
            haveAccount2.setLocation(haveAccount2.getX(), haveAccount2.getY()-2);
            haveAccountLine.setLocation(haveAccountLine.getX(), haveAccountLine.getY()-2);
        }
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
        if(e.getSource()==registerButton){
            registerButton.setLocation(registerButton.getX(), registerButton.getY()+2);
        }
        
        if(e.getSource()==haveAccount2){
            haveAccount2.setLocation(haveAccount2.getX(), haveAccount2.getY()+2);
            haveAccountLine.setLocation(haveAccountLine.getX(), haveAccountLine.getY()+2);
        }
    }
    
    class RoundedPanel extends JPanel {
        
        private int cornerRadius;

        public RoundedPanel(int radius) {
            super();
            this.cornerRadius = radius; // Set the corner radius
            setOpaque(false); // Makes the background transparent
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            // Paint background with rounded corners
            g2.setColor(getBackground());
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), cornerRadius, cornerRadius);

            // Paint border if needed
            g2.setColor(getForeground());
            g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, cornerRadius, cornerRadius);

            g2.dispose();
        }
    }
    
    public class CustomRoundedButton extends JButton {
        public CustomRoundedButton(String text) {
            super(text);
            setFocusPainted(false); // Remove the default focus painting
            setContentAreaFilled(false); // Make the background transparent
            setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20)); // Add some padding inside the button
        }
    
        @Override
        protected void paintComponent(Graphics g) {
            
            if (getModel().isPressed()) {
                g.setColor(Color.decode("#287750")); // Pressed color
            
            }else {
                g.setColor(Color.decode("#123524")); // Normal color
            }

            // Draw the rounded rectangle
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), 30, 30); // Corner radius of 30

            super.paintComponent(g); // Call the original paint method to paint the text
        }
    }
    
    public class BackgroundPanel extends JPanel {

    private Image backgroundImage;

    // Constructor to load the background image
    public BackgroundPanel(String imagePath) {
        backgroundImage = new ImageIcon(imagePath).getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Ensures proper rendering
        // Draw the image to fill the panel
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
    }
}

    
    public static void main(String[] args){
        new LibraryRegisterPage();
    }

}
