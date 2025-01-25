package com.mycompany.java_UI.Student;

import com.mycompany.java_library.library_function.libraryFunctions;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class LibraryViewBooksStudent implements ActionListener{
    
    libraryFunctions libFuncs = new libraryFunctions();

    JFrame frame = new JFrame();
    
    JPanel panelContainer = new JPanel();
    JPanel labelFooter = new JPanel();
    JPanel labelHeader = new JPanel();
    
    JLabel authorLabel = new JLabel("Author");
    JLabel titleLabel = new JLabel("Title");
    JLabel ISBNLabel = new JLabel("ISBN");
    
    JPanel bookAuthorPanel = new JPanel();
    JPanel bookTitlePanel = new JPanel();
    JPanel bookISBNPanel = new JPanel();
    
    JLabel bookAuthorLabel;
    JLabel bookTitleLabel;
    JLabel bookISBNLabel;
    
    JLabel messageLabel = new JLabel();
    JLabel studentIDLabel = new JLabel("Enter Student ID:");
    JLabel studentNameLabel = new JLabel("Enter Student Name:");
    JTextField nameField = new JTextField();
    JTextField IDField = new JTextField();
    
    JLabel borrowBookLabel = new JLabel("Borrow Book (Title | ISBN):");
    
    JButton confirmButton = new JButton("Confirm");
    JButton resetButton = new JButton("Reset");
    JButton backButton = new JButton("Back");
    
    ImageIcon icon = new ImageIcon("icon.jpg");
    Image resizedImage = icon.getImage().getScaledInstance(50,50, Image.SCALE_SMOOTH);
    ImageIcon resizedIcon = new ImageIcon(resizedImage);
    
    JComboBox<String> choicesBox = new JComboBox<>();
    
    private Set<String> currentLabels;

    public LibraryViewBooksStudent() {
        
        currentLabels = new HashSet<>();
        
        panelContainer.setLayout(new BoxLayout(panelContainer, BoxLayout.X_AXIS));
        
        bookAuthorPanel.setBackground(Color.decode("#03346E"));
        bookAuthorPanel.setLayout(new BoxLayout(bookAuthorPanel, BoxLayout.Y_AXIS));
        bookAuthorPanel.setMaximumSize(new Dimension(333,Integer.MAX_VALUE));
        
        bookTitlePanel.setBackground(Color.decode("#03346E"));
        bookTitlePanel.setLayout(new BoxLayout(bookTitlePanel, BoxLayout.Y_AXIS));
        bookTitlePanel.setMaximumSize(new Dimension(333,Integer.MAX_VALUE));
        
        bookISBNPanel.setBackground(Color.decode("#03346E"));
        bookISBNPanel.setLayout(new BoxLayout(bookISBNPanel, BoxLayout.Y_AXIS));
        bookISBNPanel.setMaximumSize(new Dimension(333,Integer.MAX_VALUE));
        
        panelContainer.add(bookAuthorPanel);
        panelContainer.add(bookTitlePanel);
        panelContainer.add(bookISBNPanel);
        
        JScrollPane scrollPane = new JScrollPane(panelContainer);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        loadLabels();
        
        authorLabel.setBounds(135,15,50,12);
        authorLabel.setForeground(Color.decode("#E2E2B6"));
        authorLabel.setFont(new Font(null, Font.BOLD, 15));
        
        titleLabel.setBounds(455,15,50,12);
        titleLabel.setForeground(Color.decode("#E2E2B6"));
        titleLabel.setFont(new Font(null, Font.BOLD, 15));
        
        ISBNLabel.setBounds(775,15,50,12);
        ISBNLabel.setForeground(Color.decode("#E2E2B6"));
        ISBNLabel.setFont(new Font(null, Font.BOLD, 15));
        
        labelHeader.setLayout(null); // Center the panel
        labelHeader.setPreferredSize(new Dimension(40,40));
        labelHeader.setBackground(Color.decode("#021526"));
        labelHeader.add(authorLabel);
        labelHeader.add(titleLabel);
        labelHeader.add(ISBNLabel);
        
        studentNameLabel.setBounds(85,55,150,20);
        studentNameLabel.setForeground(Color.decode("#E2E2B6"));
        studentNameLabel.setFont(new Font(null, Font.BOLD,13));
        
        studentIDLabel.setBounds(85,135,150,20);
        studentIDLabel.setForeground(Color.decode("#E2E2B6"));
        studentIDLabel.setFont(new Font(null, Font.BOLD,13));
        
        nameField.setBounds(155,85,200,30);
        IDField.setBounds(155,165,200,30);
        
        messageLabel.setBounds(155,117,140,15);
        messageLabel.setForeground(Color.red);
        messageLabel.setFont(new Font(null, Font.ITALIC,11));
        
        borrowBookLabel.setBounds(525,55,200,20);
        borrowBookLabel.setForeground(Color.decode("#E2E2B6"));
        borrowBookLabel.setFont(new Font(null, Font.BOLD,13));
        
        choicesBox.setBounds(525,85,340,30);
        choicesBox.setFocusable(false);
        
        confirmButton.setBounds(525,155,140,40);
        confirmButton.addActionListener(this);
        confirmButton.setFocusable(false);
        
        resetButton.setBounds(720,155,145,40);
        resetButton.addActionListener(this);
        resetButton.setFocusable(false);
        
        backButton.setBounds(30,250,80,20);
        backButton.addActionListener(this);
        backButton.setFocusable(false);
        
        labelFooter.setLayout(null); // Center the panel
        labelFooter.setBackground(Color.decode("#021526"));
        labelFooter.setPreferredSize(new Dimension(300,300));
        
        labelFooter.add(studentNameLabel);
        labelFooter.add(studentIDLabel);
        labelFooter.add(messageLabel);
        labelFooter.add(nameField);
        labelFooter.add(IDField);
        labelFooter.add(choicesBox);
        labelFooter.add(borrowBookLabel);
        labelFooter.add(confirmButton);
        labelFooter.add(resetButton);
        labelFooter.add(backButton);
        
        JPanel container = new JPanel();
        JPanel border1 = new JPanel();
        JPanel border2 = new JPanel();
        JPanel border3 = new JPanel();
        JPanel border4 = new JPanel();
        
        container.setLayout(new BorderLayout());
        container.add(labelHeader, BorderLayout.NORTH);
        container.add(scrollPane, BorderLayout.CENTER);
        container.add(labelFooter, BorderLayout.SOUTH);
        
        border1.setBackground(Color.decode("#6EACDA"));
        border1.setPreferredSize(new Dimension(5,5));
        
        border2.setBackground(Color.decode("#6EACDA"));
        border2.setPreferredSize(new Dimension(5,5));
        
        border3.setBackground(Color.decode("#6EACDA"));
        border3.setPreferredSize(new Dimension(5,5));
        
        border4.setBackground(Color.decode("#6EACDA"));
        border4.setPreferredSize(new Dimension(5,5));
        
        frame.setLayout(new BorderLayout());
        frame.add(border1, BorderLayout.NORTH);
        frame.add(border2, BorderLayout.WEST);
        frame.add(border3, BorderLayout.SOUTH);
        frame.add(border4, BorderLayout.EAST);

        frame.add(container, BorderLayout.CENTER);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("View/Borrow Books");
        frame.setSize(1000, 600);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==backButton){
            frame.dispose();
            new StudentPage();
        }
        
        if(e.getSource()==resetButton){
            nameField.setText("");
            IDField.setText("");
            messageLabel.setText("");
            nameField.requestFocusInWindow();
        }
        
        if(e.getSource()==confirmButton){
            
            String studName = nameField.getText();
            String isbn = returnISBN(String.valueOf(choicesBox.getSelectedItem()));
            
            if(!studName.isEmpty()){
                
                if(libFuncs.checkIfBorrowed(isbn)){
                    JOptionPane.showMessageDialog(frame, "The Book is Already Borrowed", "Borrow Failed", JOptionPane.PLAIN_MESSAGE);
                    
                }else {
                    String text = String.format(
                    "Book Borrowed! %n%n"
                    + "Name: %n%-50s %n%n"
                    + "Borrowed Book:%n%-50s",
                    studName,choicesBox.getSelectedItem());
                    
                    libFuncs.borrowBooks(isbn, studName, IDField.getText());
                    
                    JOptionPane.showMessageDialog(frame, text, "Borrow Successful", JOptionPane.OK_OPTION, resizedIcon);
                    nameField.setText("");
                    IDField.setText("");
                    messageLabel.setText("");
                    nameField.requestFocusInWindow();
                }
                
            } else{
                messageLabel.setText("Please Enter Your Name");
            }
        }
    }

    private void loadLabels() {
        try (BufferedReader reader = new BufferedReader(new FileReader("Books.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                
                String  bookAuthor = parts[0].trim(),
                        bookTitle = parts[1].trim(),
                        bookISBN = parts[2].trim();
                
                addLabel(bookAuthor, bookTitle, bookISBN);
                
                if(libFuncs.checkBorrowedBooks(bookISBN)){
                    choicesBox.addItem(String.format("(Borrowed)%-15s|%20s", bookTitle, bookISBN));
                    choicesBox.revalidate();
                    choicesBox.repaint();
                }else {
                    choicesBox.addItem(String.format("%-15s|%20s", bookTitle, bookISBN));
                    choicesBox.revalidate();
                    choicesBox.repaint();
                }
            }
        } catch (IOException e) {}
    }
    
    private void addLabel(String author, String title, String isbn) {
        
        // Create a unique key by concatenating author, title, and isbn
        String uniqueBookKey = author + "|" + title + "|" + isbn;

        // Check if the combination of author, title, and isbn already exists
        if (!currentLabels.contains(uniqueBookKey)) {
            // Create and add author label
            bookAuthorLabel = new JLabel(author);
            bookAuthorLabel.setForeground(Color.decode("#E2E2B6"));
            bookAuthorLabel.setFont(new Font(null, Font.PLAIN, 15));
            bookAuthorPanel.add(bookAuthorLabel);
            bookAuthorLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

            // Create and add title label
            bookTitleLabel = new JLabel(title);
            bookTitleLabel.setForeground(Color.decode("#E2E2B6"));
            bookTitleLabel.setFont(new Font(null, Font.PLAIN, 15));
            bookTitlePanel.add(bookTitleLabel);
            bookTitleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

            // Create and add ISBN label
            bookISBNLabel = new JLabel(isbn);
            bookISBNLabel.setForeground(Color.decode("#E2E2B6"));
            bookISBNLabel.setFont(new Font(null, Font.PLAIN, 15));
            bookISBNPanel.add(bookISBNLabel);
            bookISBNLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        }
    }
    
    private String returnISBN(String element){
        
        String[] parts = element.split("\\|");
        
        String isbn = parts[1].trim();
        
        return isbn;
    }
    
        
    public static void main(String[] args) {
        new LibraryViewBooksStudent();
    }
}