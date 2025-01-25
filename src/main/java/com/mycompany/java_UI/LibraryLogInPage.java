package com.mycompany.java_UI;


import com.mycompany.java_UI.Admin.AdminPage;
import com.mycompany.java_UI.Student.StudentPage;
import com.mycompany.java_library.users.UserData;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class LibraryLogInPage implements ActionListener, MouseListener{
    
    JFrame logInFrame = new JFrame();
    
    CustomRoundedButton loginButton = new CustomRoundedButton("Sign In");
    JTextField usernameField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JLabel usernameLabel = new JLabel("Username:");
    JLabel passwordLabel = new JLabel("Password:");
    JLabel invalidMessageLabel = new JLabel();
    JLabel emptyUsernameMessageLabel = new JLabel();
    JLabel emptyPasswordMessageLabel = new JLabel();
    JLabel headerLabel = new JLabel("Log in");
    
    JPanel headerPanel = new JPanel();
    JPanel leftPanel = new JPanel();
    JPanel rightPanel = new JPanel();
    JPanel footerPanel = new JPanel();
    JPanel centerPanel = new JPanel();
    
    JPanel titlePanel = new JPanel();
    JPanel logInFieldPanel = new JPanel();
    
    JLabel register1 = new JLabel("Don't have an account?");
    JLabel register2 = new JLabel("Register");
    JLabel registerLine = new JLabel("_______");
    JLabel forgotPass = new JLabel("Forgot Password?");
    JLabel forgotPassLine = new JLabel("______________");
    
    public LibraryLogInPage(){
        
        //===================================================================//
        //---------------------------FRAME SET UP--------------------------- //
        //===================================================================//
        ImageIcon icon = new ImageIcon("logo.jpg");
        
        logInFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        logInFrame.setSize(950,600);
        logInFrame.setResizable(false);
        logInFrame.setTitle("Log In");
        logInFrame.setIconImage(icon.getImage());
        logInFrame.setLayout(new BorderLayout());
        logInFrame.setLocationRelativeTo(null);
        
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
        
        //------------RIGHT OF MAIN PANEL (LOG IN FIELD) (1/2)-------------- //
        logInFieldPanel.setPreferredSize(new Dimension(350,470));
        logInFieldPanel.setOpaque(false);
        logInFieldPanel.setBackground(Color.decode("#182c25"));
        logInFieldPanel.setLayout(null);
        
        JLayeredPane logInField = new JLayeredPane();
        logInField.setBounds(0,0,350,460);
        
        RoundedPanel logInFieldContainer = new RoundedPanel(20);
        logInFieldContainer.setBackground(Color.decode("#E8F1DC"));
        
        RoundedPanel logInContainerHeader = new RoundedPanel(20);
        logInContainerHeader.setBackground(Color.decode("#123524"));
        //------------------------------------------------------------------ //
        
        //----------------------LOG IN FIELD HEADER------------------------- //
        JLabel logIn = new JLabel("Log In");
        logIn.setForeground(Color.white);
        logIn.setFont(new Font("Calibri", Font.PLAIN,30));
        
        logInContainerHeader.setBounds(50,15,100,40);
        logInContainerHeader.add(logIn);
        
        logInFieldContainer.setBounds(20,40,310,390);
        logInFieldContainer.setLayout(null);
        
        logInField.add(logInFieldContainer, Integer.valueOf(0));
        logInField.add(logInContainerHeader, Integer.valueOf(1));
        //------------------------------------------------------------------ //
        
        //------------RIGHT OF MAIN PANEL (LOG IN FIELD) (1/2)-------------- //
        usernameLabel.setBounds(30,35,80,25);
        usernameLabel.setForeground(Color.decode("#404737"));
        usernameLabel.setFont(new Font("Calibri", Font.BOLD, 17));
        
        passwordLabel.setBounds(30,110,100,25);
        passwordLabel.setForeground(Color.decode("#404737"));
        passwordLabel.setFont(new Font("Calibri", Font.BOLD, 17));
        
        invalidMessageLabel.setBounds(30,170,150,15);
        invalidMessageLabel.setForeground(Color.decode("#BE3144"));
        invalidMessageLabel.setFont(new Font(null, Font.ITALIC, 11));
        
        emptyUsernameMessageLabel.setBounds(112,37,155,15);
        emptyUsernameMessageLabel.setForeground(Color.decode("#BE3144"));
        emptyUsernameMessageLabel.setFont(new Font(null, Font.ITALIC, 11));
        
        emptyPasswordMessageLabel.setBounds(110,112,150,15);
        emptyPasswordMessageLabel.setForeground(Color.decode("#BE3144"));
        emptyPasswordMessageLabel.setFont(new Font(null, Font.ITALIC, 11));
        
        headerLabel.setBounds(150,50,200,35);
        headerLabel.setFont(new Font(null, Font.PLAIN, 30));
        
        usernameField.setBounds(30,60,250,35);
        usernameField.setBackground(Color.decode("#667860"));
        usernameField.setForeground(Color.decode("#E8F1DC"));
        usernameField.setBorder(new EmptyBorder(5,10,0,0));
        usernameField.setFont(new Font("Calibri", Font.PLAIN, 17));
        
        passwordField.setBounds(30,135,250,35);
        passwordField.setBorder(new EmptyBorder(5,10,5,0));
        passwordField.setBackground(Color.decode("#667860"));
        passwordField.setForeground(Color.decode("#E8F1DC"));
        passwordField.setFont(new Font(null, Font.PLAIN, 17));
        
        loginButton.setBounds(30,225,250,45);
        loginButton.setFocusable(false);
        loginButton.setFont(new Font("Calibri", Font.BOLD, 20));
        loginButton.setForeground(Color.white);
        loginButton.setBackground(Color.decode("#123524"));
        loginButton.setMargin(new Insets(15,0,10,10));
        loginButton.addActionListener(this);
        loginButton.addMouseListener(this);
        
        forgotPass.setBounds(30,200,120,15);
        forgotPass.setForeground(Color.decode("#123524"));
        forgotPass.setFont(new Font(null, Font.BOLD, 12));
        forgotPass.addMouseListener(this);
        
        forgotPassLine.setBounds(30,200,120,15);
        forgotPassLine.setForeground(Color.decode("#123524"));
        forgotPassLine.setFont(new Font(null, Font.BOLD, 12));
        forgotPassLine.setVisible(false);
        
        register1.setBounds(85, 300, 150, 15);
        register1.setForeground(Color.decode("#123524"));
        register1.setFont(new Font(null, Font.BOLD, 13));
        
        register2.setBounds(130, 320, 55, 15);
        register2.setForeground(Color.decode("#123524"));
        register2.setFont(new Font(null, Font.BOLD, 13));
        register2.addMouseListener(this);
        
        registerLine.setBounds(130, 320, 50, 15);
        registerLine.setForeground(Color.decode("#123524"));
        registerLine.setFont(new Font(null, Font.BOLD, 12));
        
        //----------------------------------------------------------------- //
        
        //===================================================================//
        //-----------------------ADDING COMPONENTS-------------------------- //
        //===================================================================//
        logInFieldContainer.add(usernameLabel);
        logInFieldContainer.add(passwordLabel);
        logInFieldContainer.add(invalidMessageLabel);
        logInFieldContainer.add(emptyUsernameMessageLabel);
        logInFieldContainer.add(emptyPasswordMessageLabel);
        logInFieldContainer.add(usernameField);
        logInFieldContainer.add(passwordField);
        logInFieldContainer.add(loginButton);
        logInFieldContainer.add(forgotPass);
        logInFieldContainer.add(forgotPassLine);
        logInFieldContainer.add(register1);
        logInFieldContainer.add(register2);
        logInFieldContainer.add(registerLine);
        
        centerPanel.add(logInFieldPanel, BorderLayout.EAST);
        centerPanel.add(titlePanel, BorderLayout.WEST);
        
        bgPanel.add(headerPanel, BorderLayout.NORTH);
        bgPanel.add(leftPanel, BorderLayout.WEST);
        bgPanel.add(rightPanel, BorderLayout.EAST);
        bgPanel.add(footerPanel, BorderLayout.SOUTH);
        bgPanel.add(centerPanel, BorderLayout.CENTER);
        
        logInFrame.add(bgPanel, BorderLayout.CENTER);
        
        // ADDING LAYERED PANE TO LOG IN FIELD //
        logInFieldPanel.add(logInField);
        
        //------------------------------------------------------------------ //
        
        logInFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        
        UserData userData = new UserData();
        
        if(e.getSource()==loginButton){
            
            emptyUsernameMessageLabel.setText(null);
            emptyPasswordMessageLabel.setText(null);
            invalidMessageLabel.setText(null);
                
            String username = usernameField.getText();
            String password = String.valueOf(passwordField.getPassword());
            
            if(username.isEmpty()){
                emptyUsernameMessageLabel.setText("Please enter your Username");
                return;
            }
            
            if(password.isEmpty()){
                emptyPasswordMessageLabel.setText("Please enter your Password");
                return;
            }
            
            if (userData.readDataFromFile(username, password)) {
            
                String role = userData.roleValidation(username, password);
            
                if("Admin".equals(role)){
                    logInFrame.dispose();
                    new AdminPage();
            
                }else{
                    logInFrame.dispose();
                    new StudentPage();
                }
            
            }else {
                emptyUsernameMessageLabel.setText(null);
                emptyPasswordMessageLabel.setText(null);
                invalidMessageLabel.setText("Invalid Passowrd/Username");
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource()==register2){
            logInFrame.dispose();
            new LibraryRegisterPage();
        }
        
        if(e.getSource()==forgotPass){
            logInFrame.dispose();
            new LibraryForgotPassPage();
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
        
        if(e.getSource()==loginButton){
            loginButton.setLocation(loginButton.getX(), loginButton.getY()-2);
        }
        
        if(e.getSource()==forgotPass){
            forgotPassLine.setVisible(true);
        }
        
        if(e.getSource()==register2){
            register2.setLocation(register2.getX(), register2.getY()-2);
            registerLine.setLocation(registerLine.getX(), registerLine.getY()-2);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
        if(e.getSource()==loginButton){
            loginButton.setLocation(loginButton.getX(), loginButton.getY()+2);
        }
        
        if(e.getSource()==forgotPass){
            forgotPassLine.setVisible(false);
        }
        
        if(e.getSource()==register2){
            register2.setLocation(register2.getX(), register2.getY()+2);
            registerLine.setLocation(registerLine.getX(), registerLine.getY()+2);
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
        new LibraryLogInPage();
    }

}
