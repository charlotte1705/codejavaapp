/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.vn.ultis;
import java.awt.Color;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JTextField;
/**
 *
 * @author starbuck
 */
public class StudentsValidation {
    public static boolean isEmpty(JTextField txtField, StringBuilder str, String msg){
        String strField = txtField.getText().trim();
        if (strField.equals("")) {
            str.append(msg).append("\n");
            //noi chuoi
            txtField.setBackground(Color.GRAY);
            return false;
        }
        txtField.setBackground(Color.WHITE);
        return true;
    }
     public static boolean isDate(JTextField txtField, StringBuilder str, String msg, String pattern){
       
         if (!isEmpty(txtField, str, msg)) {
             return false;
         }
         else{
             try{
                 DateFormat dateFormat = new SimpleDateFormat(pattern);
                 dateFormat.setLenient(false);
                 dateFormat.parse(txtField.getText().trim());
             }catch(Exception e){
                 str.append("Wrong date format").append("\n");
                 txtField.setBackground(Color.GRAY);
                 System.out.println("isDate Error"+e.toString());
                 return false;
             }
         }
         txtField.setBackground(Color.white); 
        return true;
    }
    public static boolean isPositiveId(JTextField txtField, StringBuilder str, String msg){
        if (!isEmpty(txtField, str, msg)) {
             return false;
         }
        int num;
        try{
        String strField = txtField.getText().trim();
        num = Integer.parseInt(strField);
        }
        catch(Exception e){
            str.append("the input is not a number").append("\n");
               //noi chuoi
               txtField.setBackground(Color.GRAY);
               return false;
        }
    
           if (num<=0) {
               str.append(msg).append("\n");
               //noi chuoi
               txtField.setBackground(Color.GRAY);
               return false;
           }
           txtField.setBackground(Color.WHITE);
           return true;
    }
    
    public static boolean isValidEmail(JTextField txtField, StringBuilder str, String msg){
        if (!isEmpty(txtField, str, msg)) {
             return false;
         }
        int num;
        
        String strField = txtField.getText().trim();
        boolean check = strField.matches("^(.+)@(.+)$");
        
    
           if (!check) {
               str.append(msg).append("\n");
               //noi chuoi
               txtField.setBackground(Color.GRAY);
               return false;
           }
           txtField.setBackground(Color.WHITE);
           return true;
    }
    
}
 

