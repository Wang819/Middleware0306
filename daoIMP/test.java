package daoIMP;
import java.util.List;
//import java.sql.*;
import bean.Student;
//import connection.DataBaseConnection;
import dao.StudentDAO;
public class test {
	public void insert() {
		StudentDAO daoimp=new StudentDAOIMP();
		Student s=new Student();
		s.setID(1);
		s.setName("wang");
		daoimp.insert(s);
		System.out.println("添加成功");
	} 
	public void update() {
		StudentDAO daoimp=new StudentDAOIMP();
		Student s=new Student();
		s.setID(3);
		s.setName("peng2");
		daoimp.update(s);
		System.out.println("更新成功");
	}
	public void delete() {
		StudentDAO daoimp=new StudentDAOIMP();
		Student s=new Student();
		daoimp.delete(5);
		System.out.println("删除成功");
	}
	public void findAll() {
		StudentDAO daoimp=new StudentDAOIMP();
		List<Student> list=daoimp.findAll();
//		System.out.println(list);
		for(Student s : list) {
			System.out.println(s);
		}
		
		//System.out.println("查找成功");
	}
	public void findById() {
		StudentDAO daoimp=new StudentDAOIMP();
		Student s=daoimp.findByID(2);
		System.out.println(s);
	}

	public static void main(String[] args) {
		test t=new test();
		t.insert();
		t.findAll();
		System.out.println("根据学号查询");
		t.findById();
		t.delete();
		t.update();
	
	}
}
