/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.vn.Itf;
import edu.vn.models.Students;
import java.util.List;


/**
 *
 * @author starbuck
 */
public interface ItfStudent {
    int save(Students e);
    int del(String id);
    int findByID(String id);
    Students getStudentsByPosition(int index);
    List<Students> openFile();
    void saveFile();
    List<Students> getAlls();
    int count();
}

