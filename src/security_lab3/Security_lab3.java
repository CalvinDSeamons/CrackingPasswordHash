/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package security_lab3;

/**
 *
 * @author calvinseamons chancecoleman tyler[last-name]
 */

//import java.util.Scanner;
import java.io.File;
//import java.io.FileNotFoundException;
import java.math.BigInteger; 
import java.security.MessageDigest; 
import java.security.NoSuchAlgorithmException; 
import java.io.BufferedReader;
import java.io.FileReader;


public class Security_lab3 {
    //Here are all the hashes that we compare too.
    public static String[] hashes = {"6f047ccaa1ed3e8e05cde1c7ebc7d958","275a5602cd91a468a0e10c226a03a39c","b4ba93170358df216e8648734ac2d539",
        "dc1c6ca00763a1821c5af993e0b6f60a","8cd9f1b962128bd3d3ede2f5f101f4fc","554532464e066aba23aee72b95f18ba2"};     
    
 
    public static void main(String[] args) throws Exception{
        System.out.println("Starting Program. This takes a while.");
        
        //test();
        
        
        //System.exit(0);
        
        
        //i is used because i need to switch the list that is read in. do not merge the list!!! ultra lag!!
        for(int i = 1; i<7;i++){
        String hash = "password" + i + "hash";
        long startTime = System.nanoTime();
        //here we call the method to decode the hash, well not really we encode and compare.
        String password = decrypt(i);
        long endTime = System.nanoTime();
        long duration = ((endTime-startTime)/1000000);  
        
            System.out.println("The password for hash value " + hashes[i-1] + " is " + password);
            System.out.println("It takes to program [" +duration+ "ms] to recover this password");
            System.out.println("\n\n");
        }
        
        
        
    }
    
    public static String decrypt(int fileChoice) throws Exception{
        BufferedReader br = null;
        //Here i pull in the password file that has 65,000,000 passwords WOW! how cool.
        String passwordHash="";
        if(fileChoice == 1){
            passwordHash = "6f047ccaa1ed3e8e05cde1c7ebc7d958";
        }
        else if(fileChoice ==2){
            passwordHash = "275a5602cd91a468a0e10c226a03a39c";
        }
        else if(fileChoice ==3){
            passwordHash = "b4ba93170358df216e8648734ac2d539";
        }
        else if(fileChoice ==4){
            passwordHash = "dc1c6ca00763a1821c5af993e0b6f60a";
        }
        else if(fileChoice ==5){
            passwordHash = "8cd9f1b962128bd3d3ede2f5f101f4fc";
        }
        else if(fileChoice ==6){
            passwordHash = "554532464e066aba23aee72b95f18ba2";
        }
        
        
        //The reason for this loop is some password lists have some of the passwords
        if(fileChoice == 1 || fileChoice == 2|| fileChoice == 4){
           
             br = new BufferedReader(new FileReader(new File("passwords.txt")));
        }
        else if(fileChoice ==3){
        
            br = new BufferedReader(new FileReader(new File("passwords.txt")));
        }
        
        else{
            br = new BufferedReader(new FileReader(new File("passwords.txt")));
        }
        //br = new BufferedReader(new FileReader(new File("godHelpMe.txt")));
        
        
        String pass;
        boolean match = false;
        int counter = 0;
        //int counter = 0;
        while((pass = br.readLine())!=null){
           counter+=1;
           String passHash = md5(pass);
        
           //Print below shows pass and hash. seeing that its 1mil i do not recommend printing.
           //System.out.println("Password: " + pass + " Hash: " + passHash);
                 
           if(passwordHash.equals(passHash)){
               //System.out.println("Match!");
               match = true;
               break;
           }
           
        }
        
      if(match){
        return pass;
      }
      else{
          System.out.println("Password Not In List After Searching " + counter+" Passwords...");
          return null;
      }
    }
    
    
    //this is where we encrypt the password and return it 
    public static String md5(String password){
        try{
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] message = md.digest(password.getBytes());
            BigInteger number = new BigInteger(1,message);
            String hash = number.toString(16);
        
            while (hash.length() < 32){
                hash = "0"+hash;
            }
            
            return hash;
        }catch (NoSuchAlgorithmException e){ 
            throw new RuntimeException(e); 
        } 
        
    }
    
    // you dont need to use this unless you want to just test one. 
    public static void test() throws Exception{
        BufferedReader br = null;
        br = new BufferedReader(new FileReader(new File("n/a.txt")));
        String pass;
        int counter = 0;
        boolean match = false;
        while(( pass = br.readLine())!=null){
            counter +=1;
            String passHash = md5(pass);
        
       if(hashes[5].equals(passHash)){
               //System.out.println("Match!");
               match = true;
               break;
           }
           
        }
        
      if(match){
          System.out.println("Pass  is " + pass);
      }
      else{
          System.out.println("Password Not In List After Searching " + counter+" Passwords...");
          
      }
        
        
    }
     
    }
    



