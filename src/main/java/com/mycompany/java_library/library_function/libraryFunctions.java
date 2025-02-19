package com.mycompany.java_library.library_function;

import java.io.*;

    public class libraryFunctions {
        
        public File sourceFile;

        //private static File borrowedBooksFile;

        protected String book_title = "",
                         book_author = "", 
                         book_isbn = "";

        ///////////////
        ///  BOOKS  ///
        ///////////////
        public void fileWriterBooks(String book_title, String book_author, String book_isbn) {
            try (FileWriter fileWrite = new FileWriter("Books.txt", true)) { 
                fileWrite.append(String.format("%s|%s|%s%n", 
                            book_author, book_title, book_isbn));

            } catch(IOException e){}
        }

        // Library Books Functions

        //////////////////////
        ///  BORROW BOOKS  ///
        //////////////////////
        
        public void fileWriterBorrowers(String student_name,
                                        String student_ID,
                                        String book_title,
                                        String book_author) {

            // Check if the file is empty, if so, write the header
            try (FileWriter fileWriter = new FileWriter("Borrowed_Books.txt", true)) {
                fileWriter.append(String.format("%s|%s|%s|%s|%n", 
                                student_name, student_ID, book_title, book_author));
            } catch(IOException e){}
        }
        
        public void tempQueue(String book_title, String book_author, String book_isbn) {
            
            try (FileWriter fileWrite = new FileWriter("tempQueue.txt", true)) { 
                fileWrite.append(String.format("%s|%s|%s%n", book_author, book_title, book_isbn));

            } catch(IOException e){}
        }
        
        public boolean checkQueue(String isbn){
            try(BufferedReader reader = new BufferedReader(new FileReader("tempQueue.txt"))){
                String borrowedLine;

                while((borrowedLine = reader.readLine()) != null){
                    String[] parts = borrowedLine.split("\\|");

                    String foundISBN = parts[2].trim();

                    if(foundISBN.equals(isbn)) return true;
                }
            } catch(IOException e){}

            return false;
        }
        
        public void addBooksFromQueue(){
            
            File file = new File("tempQueue.txt");
            
            try(BufferedReader tempReader = new BufferedReader(new FileReader(file));
                BufferedWriter tempWriter = new BufferedWriter(new FileWriter("Books.txt", true))) {
                
                String line;
                // Read and write line by line
                while ((line = tempReader.readLine()) != null) {
                    tempWriter.write(line);
                    tempWriter.newLine(); // Add a newline character after each line
                }
                
            } catch (IOException e) {
                e.printStackTrace();
            }
            
            // Delete the source file after moving its content
            file.delete();

        }
        
        public boolean checkAddedBooks(String isbn){

            try(BufferedReader reader = new BufferedReader(new FileReader("Books.txt"))){
                String borrowedLine;

                while((borrowedLine = reader.readLine()) != null){
                    String[] parts = borrowedLine.split("\\|");

                    String foundISBN = parts[2].trim();

                    if(foundISBN.equals(isbn)) return true;
                }
            } catch(IOException e){}

            return false;
        }
        
        public boolean checkBorrowedBooks(String isbn){

            try(BufferedReader reader = new BufferedReader(new FileReader("Borrowed_Books.txt"))){
                String borrowedLine;

                while((borrowedLine = reader.readLine()) != null){
                    String[] parts = borrowedLine.split("\\|");

                    String foundISBN = parts[4].trim();

                    if(foundISBN.equals(isbn)) return true;
                }
                
            } catch(IOException e){}

            return false;
        }
        
        public boolean checkIfBorrowed(String title, String author){

            String bookInfo = title + "|" + author;

            try (BufferedReader reader = new BufferedReader(new FileReader("Borrowed_Books.txt"))){
                 
                // Read the file content into a String
                String borrowedLine;

                while((borrowedLine = reader.readLine()) != null){
                    String[] parts = borrowedLine.split("\\|");

                    String foundTitle = parts[2].trim();
                    String foundAuthor = parts[3].trim();

                    String book = foundTitle + "|" + foundAuthor;

                    // Check if the file content contains the Book
                    if(book.equals(bookInfo)){
                        return true;
                    }
                }
            } catch (IOException e) {}
            return false;
        }
        public boolean isBorrowed = false;
        
        //Library Functions
        /* public void borrowBooks(String isbn, String studName, String studID){

            // Ensure the borrowed books file exists
            borrowedBooksFile = new File("Borrowed_Books.txt");

            try (BufferedReader br = new BufferedReader(new FileReader("Books.txt"))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] parts = line.split("\\|");

                    //extracted info from splits, creates new fields
                    String  foundAuthor = parts[0].trim(),
                            foundTitle = parts[1].trim(),
                            foundISBN = parts[2].trim();

                    if (isbn.equalsIgnoreCase(foundISBN)){
                        
                        // return info to rightful fields
                        book_author = foundAuthor;
                        book_title = foundTitle;
                        book_isbn = foundISBN;

                        fileWriterBorrowers(studName, studID, book_title, book_author, book_isbn);
                    }
                }
            } catch(IOException e){}
        } */

        public void borrowBooks(String title,String author, String studName, String studID){

            String book = title + "_" + author;

            File bookCoversFolder = new File("BookCovers");

            File[] bookCoversFolderFiles = bookCoversFolder.listFiles(File::isFile);
            
            if(bookCoversFolderFiles != null){
                for(File cover : bookCoversFolderFiles) {
                    String[] bookDescription = cover.getName().split("[_.]");

                    String bookTitle = bookDescription[0].trim();
                    String bookAuthor = bookDescription[1].trim();

                        if(book.equalsIgnoreCase(bookTitle + "_" + bookAuthor)){
                            fileWriterBorrowers(studName, studID, bookTitle,bookAuthor);
                        }
                    
                }
            }
        }
    }