/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.vn.models;

import edu.vn.Itf.ItfStudent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import edu.vn.ultis.FileUtl;
import java.io.FileNotFoundException;

/**
 *
 * @author starbuck
 */
public class StudentsDAO implements ItfStudent {

    public static List<Students> ls = new ArrayList<>();
    
    @Override
    public int save(Students e) {
        int pos = findByID(e.getId());
        if (pos < 0) {
            ls.add(e);
        }else
        {
            ls.set(pos, e);
        }
        return 1;
    }
    // pos<0 (khg tim thay -> add new).(tim thay -> update 1 vi tri student)

    @Override
    public int del(String id) {
        int pos = findByID(id);
        if (pos >= 0) {
            ls.remove(pos);
        }
        return pos;
    }

    @Override
    public int findByID(String id) {
        int position = -1;
        for (int i = 0; i < ls.size(); i++) {
            if (ls.get(i).getId().equals(id)) {
                position = i;
                break;              
            }
        }
        return position;
    }

    @Override
    public Students getStudentsByPosition(int index) {
        if (index >= 0 && index < ls.size()) {
            return ls.get(index);
        }
        return null;
    }

    @Override
    public List<Students> openFile() {
        try {
            
            ls.clear();
            ls = FileUtl.readFile();
            System.err.println(ls.size());
        } catch (IOException ex) {
            System.out.println("Error: "+ ex.toString());
        } catch (ClassNotFoundException ex) {
            System.out.println("Error: "+ ex.toString());
        }
        return ls;
    } 

    @Override
    public void saveFile() {
        try {
           
            FileUtl.writeFile(ls);
            System.err.println(ls.size());
        } catch (IOException ex) {
           System.out.println("Fault: "+ex.toString());
        }
    }

    @Override
    public List<Students> getAlls() {
        return ls;
    }

    @Override
    public int count() {
        return ls.size();
    }
    
}
