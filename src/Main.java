package src;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void writeDataToFile(String path, List<Student> studentList){
        try {
            FileOutputStream fo = new FileOutputStream(path);
            ObjectOutputStream os = new ObjectOutputStream(fo);
            os.writeObject(studentList);
            os.close();
            fo.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public static List<Student> readData(String path){
        List<Student> st = new ArrayList<>();
        try {
            FileInputStream fi = new FileInputStream(path);
            ObjectInputStream oi = new ObjectInputStream(fi);
            st = (List<Student>) oi.readObject();
            oi.close();
            fi.close();
        }catch (IOException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return st;
    }



    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
//        Student s1 = new Student(1, "abnhn");
//        Student s2 = new Student(2,"jldkk");
//        list.add(s1);
//        list.add(s2);
//        writeDataToFile("out.txt", list);
       list =  readData("out.txt");
        for (Student e: list) {
            System.out.println(e);
        }

    }
}
