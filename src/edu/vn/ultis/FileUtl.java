/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.vn.ultis;

import edu.vn.models.Students;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author starbuck
 */
public class FileUtl {
    public static final String FILE_NAME = "student.dat";
    public static void writeFile(List<Students> ls) throws FileNotFoundException, IOException{

    try{
    FileOutputStream fos = new FileOutputStream(FILE_NAME);
        try (ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(ls);
        }
    }catch(IOException e)
    {
        System.out.println(e.getMessage());
    }
    }

    public static List<Students> readFile() throws FileNotFoundException, IOException, ClassNotFoundException{
    FileInputStream fis = new FileInputStream(FILE_NAME);
    ObjectInputStream ois = new ObjectInputStream(fis);
    ArrayList<Students> ls = (ArrayList<Students>) ois.readObject();
    //   return ls;
    //   ham readFile - return ve mot danh sach sau do se do danh sach vao.
        return ls;
        
    }
    
}
