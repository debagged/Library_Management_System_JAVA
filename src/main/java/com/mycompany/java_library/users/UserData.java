package com.mycompany.java_library.users;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserData {
    
    public void saveDataToFile(String user_name, String password){
        try (FileWriter fw = new FileWriter("UserData_Log_File.txt", true);
                PrintWriter pw = new PrintWriter(fw)) {
                    pw.println(user_name + ":" + password);
                    pw.println("Role: Student");
                    pw.println("=====================");
                } catch (IOException e) {}       
    }

    public boolean readDataFromFile(String username, String password) {
        try (BufferedReader br = new BufferedReader(new FileReader("UserData_Log_File.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts[0].equals(String.valueOf(username))&& parts[1].equals(String.valueOf(password))) {
                    return true;
                }
            }
            return false; // Login failed
        } catch(IOException e){}
        return false;
    }
    
    public String roleValidation(String username, String password) {
        try (BufferedReader br = new BufferedReader(new FileReader("UserData_Log_File.txt"))) {
            String line;
            //String fileRole;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(":");
                
                if (parts[0].equals(String.valueOf(username)) && parts[1].equals(String.valueOf(password))) {
                    String roleLine = br.readLine();
                    if (roleLine.startsWith("Role:")) {
                        return roleLine.split(":")[1].trim(); // Extract role of User
                    }
                }
            }
        } catch(IOException e){}
        return null;
    }
    
    public boolean checkUsername(String username){
        String filePath = "UserData_Log_File.txt"; // Path to the file

        try {
            
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;

            while ((line = reader.readLine()) != null) {
                // Replace the target value with the new value if found
                if (line.contains(username)) {
                    String[] parts = line.split(":");
                    
                    if(parts[0].equals(username)){
                        reader.close();
                        return true;
                    }
                }
            }
            reader.close();
            
        } catch (IOException e) {}
        
        return false;
        
    }
    
    public boolean forgotPassword(String targetValue, String newValue){
        String filePath = "UserData_Log_File.txt"; // Path to the file

        try {
            // Read all lines from the file into a list
            List<String> lines = new ArrayList<>();
            
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;

            while ((line = reader.readLine()) != null) {
                // Replace the target value with the new value if found
                if (line.contains(targetValue)) {
                    String[] parts = line.split(":");
                    
                    if(parts[1].equals(newValue)){
                        reader.close();
                        return true;
                    }else{
                       parts[1] = newValue; 
                    }
                    
                    line = parts[0] + ":" + parts[1];
                }     
                lines.add(line);
                
            }
            reader.close();

            // Write the modified content back to the file
            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
            for (String updatedLine : lines) {
                writer.write(updatedLine);
                writer.newLine();
            }
            writer.close();
            
        } catch (IOException e) {}
        
        return false;
    }

    
}


