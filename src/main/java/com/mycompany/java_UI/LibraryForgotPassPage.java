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

public class LibraryForgotPassPage implements ActionListener, MouseListener{
    
    JFrame forgotPassFrame = new JFrame();

    CustomRoundedButton resetPassButton = new CustomRoundedButton("Reset Password");
    JTextField usernameField = new JTextField();
    JPasswordField newPasswordField = new JPasswordField();
    JPasswordField confirmNewPasswordField = new JPasswordField();
    JLabel usernameLabel = new JLabel("Username:");
    JLabel newPasswordLabel = new JLabel("New Password:");
    JLabel confirmNewPasswordLabel = new JLabel("Confirm New Password:");
    JLabel emptyUsernameMessageLabel = new JLabel();
    JLabel emptyNewPasswordMessageLabel = new JLabel();
    JLabel emptyConfirmNewPasswordMessageLabel = new JLabel();
    JLabel matchPasswordMessageLabel = new JLabel();
    
    JPanel headerPanel = new JPanel();
    JPanel leftPanel = new JPanel();
    JPanel rightPanel = new JPanel();
    JPanel footerPanel = new JPanel();
    JPanel centerPanel = new JPanel();
    
    JPanel titlePanel = new JPanel();
    JPanel resetPassFieldPanel = new JPanel();
    
    JLabel signIn = new JLabel("Sign In");
    JLabel signInLine = new JLabel("_______");
    
    public LibraryForgotPassPage(){
        
        //===================================================================//
        //---------------------------FRAME SET UP--------------------------- //
        //===================================================================//
        ImageIcon icon = new ImageIcon("logo.jpg");
        
        forgotPassFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        forgotPassFrame.setSize(950,600);
        forgotPassFrame.setResizable(false);
        forgotPassFrame.setTitle("Reset Password");
        forgotPassFrame.setIconImage(icon.getImage());
        forgotPassFrame.setLayout(new BorderLayout());
        forgotPassFrame.setLocationRelativeTo(null);
        
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
        resetPassFieldPanel.setPreferredSize(new Dimension(350,470));
        resetPassFieldPanel.setOpaque(false);
        resetPassFieldPanel.setBackground(Color.decode("#182c25"));
        resetPassFieldPanel.setLayout(null);
        
        JLayeredPane resetPassField = new JLayeredPane();
        resetPassField.setBounds(0,0,350,460);
        
        RoundedPanel resetPassFieldContainer = new RoundedPanel(20);
        resetPassFieldContainer.setBackground(Color.decode("#E8F1DC"));
        
        RoundedPanel resetPassContainerHeader = new RoundedPanel(20);
        resetPassContainerHeader.setBackground(Color.decode("#123524"));
        //------------------------------------------------------------------ //
        
        //------------------RESET PASSWORD FIELD HEADER--------------------- //
        JLabel resetPass = new JLabel("Reset Password");
        resetPass.setForeground(Color.white);
        resetPass.setFont(new Font("Calibri", Font.PLAIN,26));
        
        resetPassContainerHeader.setBounds(50,15,190,38);
        resetPassContainerHeader.add(resetPass);
        
        resetPassFieldContainer.setBounds(20,40,310,390);
        resetPassFieldContainer.setLayout(null);
        
        resetPassField.add(resetPassFieldContainer, Integer.valueOf(0));
        resetPassField.add(resetPassContainerHeader, Integer.valueOf(1));
        //------------------------------------------------------------------ //
        
        //--------RIGHT OF MAIN PANEL (RESET PASSWORD FIELD) (1/2)---------- //
        usernameLabel.setBounds(30,30,100,25);
        usernameLabel.setForeground(Color.decode("#404737"));
        usernameLabel.setFont(new Font("Calibri", Font.BOLD, 17));
        
        newPasswordLabel.setBounds(30,105,120,25);
        newPasswordLabel.setForeground(Color.decode("#404737"));
        newPasswordLabel.setFont(new Font("Calibri", Font.BOLD, 17));
        
        confirmNewPasswordLabel.setBounds(30,185,170,25);
        confirmNewPasswordLabel.setForeground(Color.decode("#404737"));
        confirmNewPasswordLabel.setFont(new Font("Calibri", Font.BOLD, 17));
        
        emptyUsernameMessageLabel.setBounds(30,85,225,15);
        emptyUsernameMessageLabel.setForeground(Color.decode("#BE3144"));
        emptyUsernameMessageLabel.setFont(new Font(null, Font.ITALIC, 11));
        
        emptyNewPasswordMessageLabel.setBounds(30,160,225,15);
        emptyNewPasswordMessageLabel.setForeground(Color.decode("#BE3144"));
        emptyNewPasswordMessageLabel.setFont(new Font(null, Font.ITALIC, 11));
        
        emptyConfirmNewPasswordMessageLabel.setBounds(30,240,225,15);
        emptyConfirmNewPasswordMessageLabel.setForeground(Color.decode("#BE3144"));
        emptyConfirmNewPasswordMessageLabel.setFont(new Font(null, Font.ITALIC, 11));
        
        matchPasswordMessageLabel.setBounds(30,240,225,15);
        matchPasswordMessageLabel.setForeground(Color.decode("#BE3144"));
        matchPasswordMessageLabel.setFont(new Font(null, Font.ITALIC, 11));
        
        usernameField.setBounds(30,50,250,35);
        usernameField.setBackground(Color.decode("#667860"));
        usernameField.setForeground(Color.decode("#E8F1DC"));
        usernameField.setBorder(new EmptyBorder(5,10,0,0));
        usernameField.setFont(new Font("Calibri", Font.PLAIN, 17));
        
        newPasswordField.setBounds(30,125,250,35);
        newPasswordField.setBorder(new EmptyBorder(5,10,5,0));
        newPasswordField.setForeground(Color.decode("#E8F1DC"));
        newPasswordField.setBackground(Color.decode("#667860"));
        newPasswordField.setFont(new Font(null, Font.PLAIN, 17));
        
        confirmNewPasswordField.setBounds(30,205,250,35);
        confirmNewPasswordField.setBorder(new EmptyBorder(5,10,5,0));
        confirmNewPasswordField.setBackground(Color.decode("#667860"));
        confirmNewPasswordField.setForeground(Color.decode("#E8F1DC"));
        confirmNewPasswordField.setFont(new Font(null, Font.PLAIN, 17));
        
        resetPassButton.setBounds(30,280,250,45);
        resetPassButton.setFont(new Font("Calibri", Font.BOLD, 21));
        resetPassButton.setForeground(Color.white);
        resetPassButton.setBackground(Color.decode("#123524"));
        resetPassButton.addActionListener(this);
        resetPassButton.setFocusable(false);
        resetPassButton.addMouseListener(this);
        
        signIn.setBounds(130, 335, 150, 20);
        signIn.setForeground(Color.decode("#123524"));
        signIn.setFont(new Font(null, Font.BOLD, 15));
        signIn.addMouseListener(this);
        
        signInLine.setBounds(130, 340, 60, 15);
        signInLine.setForeground(Color.decode("#123524"));
        signInLine.setFont(new Font(null, Font.BOLD, 12));
        //----------------------------------------------------------------- //
        
        //===================================================================//
        //-----------------------ADDING COMPONENTS-------------------------- //
        //===================================================================//
        resetPassFieldContainer.add(usernameLabel);
        resetPassFieldContainer.add(newPasswordLabel);
        resetPassFieldContainer.add(confirmNewPasswordLabel);
        resetPassFieldContainer.add(emptyUsernameMessageLabel);
        resetPassFieldContainer.add(emptyNewPasswordMessageLabel);
        resetPassFieldContainer.add(emptyConfirmNewPasswordMessageLabel);
        resetPassFieldContainer.add(matchPasswordMessageLabel);
        resetPassFieldContainer.add(usernameField);
        resetPassFieldContainer.add(newPasswordField);
        resetPassFieldContainer.add(confirmNewPasswordField);
        resetPassFieldContainer.add(resetPassButton);
        resetPassFieldContainer.add(signIn);
        resetPassFieldContainer.add(signInLine);
        
        centerPanel.add(resetPassFieldPanel, BorderLayout.EAST);
        centerPanel.add(titlePanel, BorderLayout.WEST);
        
        bgPanel.add(headerPanel, BorderLayout.NORTH);
        bgPanel.add(leftPanel, BorderLayout.WEST);
        bgPanel.add(rightPanel, BorderLayout.EAST);
        bgPanel.add(footerPanel, BorderLayout.SOUTH);
        bgPanel.add(centerPanel, BorderLayout.CENTER);
        
        forgotPassFrame.add(bgPanel, BorderLayout.CENTER);
        
        // ADDING LAYERED PANE TO LOG IN FIELD //
        resetPassFieldPanel.add(resetPassField);
        
        //------------------------------------------------------------------ //
        
        forgotPassFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        
        UserData userData = new UserData();
        
        String userName = usernameField.getText();
        String newPass = String.valueOf(newPasswordField.getPassword());
        String confirmNewPass = String.valueOf(confirmNewPasswordField.getPassword());
        
        if(e.getSource()==resetPassButton){
                emptyUsernameMessageLabel.setText(null);
                emptyNewPasswordMessageLabel.setText(null);
                emptyConfirmNewPasswordMessageLabel.setText(null);
                matchPasswordMessageLabel.setText(null);
            
            if(userName.equals("admin")){
                JOptionPane.showMessageDialog(forgotPassFrame, "NICE TRY", "OKAY", JOptionPane.PLAIN_MESSAGE);
                return;
            }
            
            if(userName.isEmpty()){
                emptyUsernameMessageLabel.setText("Please enter username");
                return;
            }
            
            if(newPass.isEmpty()){
                emptyNewPasswordMessageLabel.setText("Please enter new password");
                return;
            }
            
            if(confirmNewPass.isEmpty()){
                emptyConfirmNewPasswordMessageLabel.setText("Please confirm new password");
                return;
            }
            
            if(userData.checkUsername(userName)){
                
                if(!newPass.equals(confirmNewPass)){
                    matchPasswordMessageLabel.setText("Passwords Must Match");
                    return;
                }
            
                if(userData.forgotPassword(userName, newPass)){
                    JOptionPane.showMessageDialog(forgotPassFrame, "New password cannot be the old password", "Same Password", JOptionPane.PLAIN_MESSAGE);
                    return;
                }
                
                JOptionPane.showMessageDialog(forgotPassFrame, "Password Reset Successful", "Password Reset", JOptionPane.PLAIN_MESSAGE);
                usernameField.setText(null);
                newPasswordField.setText(null);
                confirmNewPasswordField.setText(null);
                usernameField.requestFocusInWindow();
                return;
            }
            
            JOptionPane.showMessageDialog(forgotPassFrame, "Username Not Found", "Username Not Found", JOptionPane.PLAIN_MESSAGE);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource()==signIn){
            forgotPassFrame.dispose();
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
        
        if(e.getSource()==resetPassButton){
            resetPassButton.setLocation(resetPassButton.getX(), resetPassButton.getY()-2);
        }
        
        if(e.getSource()==signIn){
            signIn.setLocation(signIn.getX(), signIn.getY()-2);
            signInLine.setLocation(signInLine.getX(), signInLine.getY()-2);
        }
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
        if(e.getSource()==resetPassButton){
            resetPassButton.setLocation(resetPassButton.getX(), resetPassButton.getY()+2);
        }
        
        if(e.getSource()==signIn){
            signIn.setLocation(signIn.getX(), signIn.getY()+2);
            signInLine.setLocation(signInLine.getX(), signInLine.getY()+2);
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
        new LibraryForgotPassPage();
    }

}
