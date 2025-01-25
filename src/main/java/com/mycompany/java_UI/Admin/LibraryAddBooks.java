package com.mycompany.java_UI.Admin;

import com.mycompany.java_library.library_function.libraryFunctions;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class LibraryAddBooks implements ActionListener{
    
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
    
    JLabel EnterAuthorMessageLabel = new JLabel();
    JLabel EnterTitleMessageLabel = new JLabel();
    JLabel EnterISBNMessageLabel = new JLabel();
    JLabel newBookAuthorLabel = new JLabel("Enter Author:");
    JLabel newBookTitleLabel = new JLabel("Enter Title:");
    JLabel newBookISBNLabel = new JLabel("Enter ISBN:");
    
    JTextField newBookAuthorField = new JTextField();
    JTextField newBookTitleField = new JTextField();
    JTextField newBookISBNField = new JTextField(); 
    
    static JButton queueButton = new JButton("Queue");
    JButton viewQueueButton = new JButton("View Queue");
    JButton confirmButton = new JButton("Confirm");
    JButton resetButton = new JButton("Reset");
    JButton backButton = new JButton("Back");
    
    private Set<String> currentLabels;

    public LibraryAddBooks() {
        
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
        
        titleLabel.setBounds(460,15,50,12);
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
        
        newBookAuthorLabel.setBounds(85,45,150,20);
        newBookAuthorLabel.setForeground(Color.decode("#E2E2B6"));
        newBookAuthorLabel.setFont(new Font(null, Font.BOLD,13));
        
        newBookTitleLabel.setBounds(85,125,150,20);
        newBookTitleLabel.setForeground(Color.decode("#E2E2B6"));
        newBookTitleLabel.setFont(new Font(null, Font.BOLD,13));
        
        newBookISBNLabel.setBounds(85,205,200,20);
        newBookISBNLabel.setForeground(Color.decode("#E2E2B6"));
        newBookISBNLabel.setFont(new Font(null, Font.BOLD,13));
        
        newBookAuthorField.setBounds(155,75,200,30);
        newBookTitleField.setBounds(155,155,200,30);
        newBookISBNField.setBounds(155,235,200,30);
        
        EnterAuthorMessageLabel.setBounds(155,105,140,15);
        EnterAuthorMessageLabel.setForeground(Color.red);
        EnterAuthorMessageLabel.setFont(new Font(null, Font.ITALIC,11));
        
        EnterTitleMessageLabel.setBounds(155,185,140,15);
        EnterTitleMessageLabel.setForeground(Color.red);
        EnterTitleMessageLabel.setFont(new Font(null, Font.ITALIC,11));
        
        EnterISBNMessageLabel.setBounds(155,265,140,15);
        EnterISBNMessageLabel.setForeground(Color.red);
        EnterISBNMessageLabel.setFont(new Font(null, Font.ITALIC,11));
        
        queueButton.setBounds(500,100,180,60);
        queueButton.addActionListener(this);
        queueButton.setFocusable(false);
        
        viewQueueButton.setBounds(705,100,180,60);
        viewQueueButton.addActionListener(this);
        viewQueueButton.setFocusable(false);
        
        confirmButton.setBounds(500,185,180,60);
        confirmButton.addActionListener(this);
        confirmButton.setFocusable(false);
        
        resetButton.setBounds(705,185,180,60);
        resetButton.addActionListener(this);
        resetButton.setFocusable(false);
        
        backButton.setBounds(30,350,80,20);
        backButton.addActionListener(this);
        backButton.setFocusable(false);
        
        labelFooter.setLayout(null); // Center the panel
        labelFooter.setBackground(Color.decode("#021526"));
        labelFooter.setPreferredSize(new Dimension(1000,400));
        
        labelFooter.add(newBookAuthorLabel);
        labelFooter.add(newBookTitleLabel);
        labelFooter.add(newBookISBNLabel);
        labelFooter.add(EnterAuthorMessageLabel);
        labelFooter.add(EnterTitleMessageLabel);
        labelFooter.add(EnterISBNMessageLabel);
        labelFooter.add(newBookAuthorField);
        labelFooter.add(newBookTitleField);
        labelFooter.add(newBookISBNField);
        labelFooter.add(queueButton);
        labelFooter.add(viewQueueButton);
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
        frame.setSize(1000, 800);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
    static int count;
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        String bookAuthorName = newBookAuthorField.getText();
        String bookTitle = newBookTitleField.getText(); 
        String bookISBN = newBookISBNField.getText();
        
        if(e.getSource()==backButton){
            frame.dispose();
            new AdminPage();
        }
        
        if(e.getSource()==resetButton){
            newBookAuthorField.setText("");
            newBookTitleField.setText("");
            newBookISBNField.setText("");
            EnterAuthorMessageLabel.setText("");
            EnterTitleMessageLabel.setText("");
            EnterISBNMessageLabel.setText("");
            newBookAuthorField.requestFocusInWindow();
        }
        
        if(e.getSource()==queueButton){
            
            if(bookAuthorName.isEmpty()){
               EnterAuthorMessageLabel.setText("Please Enter Author Name");
               return;
            }
            
            if(bookTitle.isEmpty()){
                EnterTitleMessageLabel.setText("Please Enter Title");
                return;
            }
            
            if(bookISBN.isEmpty()){
                EnterISBNMessageLabel.setText("Please Enter ISBN");
                return;
            }
            
            if(!libFuncs.checkQueue(bookISBN)){
                libFuncs.tempQueue(bookTitle, bookAuthorName, bookISBN);
                
                newBookAuthorField.setText("");
                newBookTitleField.setText("");
                newBookISBNField.setText("");
                EnterAuthorMessageLabel.setText("");
                EnterTitleMessageLabel.setText("");
                EnterISBNMessageLabel.setText("");
                newBookAuthorField.requestFocusInWindow();
                count++;
                //checkQueueCount();
                queueButton.setText(String.format("Queue(%d)", count));
                
            }else{
                JOptionPane.showMessageDialog(frame, "This Book is Already Added in Queue!", "Book Already Added", JOptionPane.PLAIN_MESSAGE);
            }
        }
        
        if(e.getSource()==viewQueueButton){
            
            if(!new File("tempQueue.txt").exists()){
                JOptionPane.showMessageDialog(frame, "There are currently no books in queue", "No Queue", JOptionPane.PLAIN_MESSAGE);
                return;
            }
            
            new viewQueue();
        }
        
        if(e.getSource()==confirmButton){
            
            EnterAuthorMessageLabel.setText("");
            EnterTitleMessageLabel.setText("");
            EnterISBNMessageLabel.setText("");
            
            if(!libFuncs.checkAddedBooks(bookISBN) 
                    &&(bookAuthorName.isEmpty() 
                    && bookTitle.isEmpty() 
                    && bookISBN.isEmpty())
                    && count != 0){
                
                JOptionPane.showMessageDialog(frame, "Book/s Added Successfully!", "Book Added", JOptionPane.PLAIN_MESSAGE);
                
                libFuncs.addBooksFromQueue();
                newBookAuthorField.setText("");
                newBookTitleField.setText("");
                newBookISBNField.setText("");
                EnterAuthorMessageLabel.setText("");
                EnterTitleMessageLabel.setText("");
                EnterISBNMessageLabel.setText("");
                count=0;
                queueButton.setText("Queue");
                newBookAuthorField.requestFocusInWindow();
                return;
            }
            
            if(bookAuthorName.isEmpty()){
               EnterAuthorMessageLabel.setText("Please Enter Author Name");
               return;
            }
            
            if(bookTitle.isEmpty()){
                EnterTitleMessageLabel.setText("Please Enter Title");
                return;
            }
            
            if(bookISBN.isEmpty()){
                EnterISBNMessageLabel.setText("Please Enter ISBN");
                return;
            }
            
            if(libFuncs.checkAddedBooks(bookISBN)){
                JOptionPane.showMessageDialog(frame, "This Book is Already Added!", "Book Already Added", JOptionPane.PLAIN_MESSAGE);
                
            } else{
                libFuncs.fileWriterBooks(bookAuthorName, bookTitle, bookISBN);
                
                if(count != 0){
                    libFuncs.addBooksFromQueue();
                }
                
                JOptionPane.showMessageDialog(frame, "Book/s Added Successfully!", "Book Added", JOptionPane.PLAIN_MESSAGE);

                newBookAuthorField.setText("");
                newBookTitleField.setText("");
                newBookISBNField.setText("");
                EnterAuthorMessageLabel.setText("");
                EnterTitleMessageLabel.setText("");
                EnterISBNMessageLabel.setText("");
                count = 0;
                queueButton.setText("Queue");
                newBookAuthorField.requestFocusInWindow();
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
                
            }
        } catch (IOException e) {
        }
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
        
    public static void main(String[] args) {
        new LibraryAddBooks();
    }
}