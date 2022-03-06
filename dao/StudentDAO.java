package dao;
import bean.*;
import java.util.*;
public interface StudentDAO{
    public void insert(Student s);
    public void update(Student s);
    public void delete(int iD);
    public Student findByID(int iD);
    public List<Student> findAll();
} 

