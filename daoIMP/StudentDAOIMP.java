package daoIMP;
import bean.Student;
import dao.StudentDAO;
import java.sql.*;
import java.util.List;
import java.util.ArrayList;
import connection.DataBaseConnection;

public class StudentDAOIMP implements StudentDAO{
  	DataBaseConnection db=new DataBaseConnection();
//  	private Connection conn;
	// ��Ӳ���
	    public void insert(Student s) {

	    	Connection conn=db.getConn();
	//    	Connection conn = db.getConn();
	        PreparedStatement pstm = null;
	        String sql_insert = "insert into student(ID,NAME) values(?,?)";	//sql����
	    
	        try{	        
	        	//conn = new DataBaseConnection();	  
	        	pstm = conn.prepareStatement(sql_insert);
	        	pstm.setInt(1,s.getID());
	        	//pstmt.setString(1,s.getID());
	        	pstm.setString(2,s.getName());
	        	pstm.executeUpdate();
	        	pstm.close();
	        	conn.close();
	        	}
	        catch(Exception e){  }
	        
	        //    pstm = conn.prepareStatement(sql_insert);
			/*
			//���sql����еģ�
	        pstm.setInt(1, s.getID());
	        pstm.setString(2, s.getName());
	       // pstm.setString(3, newUser.getPwd());

			//ʹ��executeUpdate����ִ��sql���
	        int row = pstm.executeUpdate();
	        System.out.println("�����û��ɹ�" + row + "���ܵ�Ӱ��");
	        //�ͷŶ����ݿ������
	        db.closeConn(null, pstm, conn);*/
	    }

	    public void update(Student s){
	    	Connection conn=db.getConn();
	    	//    	Connection conn = db.getConn();
	    	        PreparedStatement pstm = null;
	    	        String sql_update = "update student set NAME=? where ID=?";	//sql����
	    	    
	    	        try{	        
	    	        	//conn = new DataBaseConnection();	  
	    	        	pstm = conn.prepareStatement(sql_update);
	    	        	pstm.setString(1,s.getName());
	    	        	//pstmt.setString(1,s.getID());
	    	        	pstm.setInt(2,s.getID());
	    	        	pstm.executeUpdate();
	    	        	pstm.close();
	    	        	conn.close();
	    	        	}
	    	        catch(Exception e){  }
	    	        
	    }

       public void delete(int iD){ 
    	   Connection conn=db.getConn();
	    	//    	Connection conn = db.getConn();
	    	        PreparedStatement pstm = null;
	    	        String sql_delete = "delete from student where ID=?";	//sql����
	    	    
	    	        try{	        
	    	        	//conn = new DataBaseConnection();	  
	    	        	pstm = conn.prepareStatement(sql_delete);
	    	       // 	pstm.setString(1,s.getName());
	    	        	//pstmt.setString(1,s.getID());
	    	        	pstm.setInt(1,iD);
	    	        	pstm.executeUpdate();
	    	        	pstm.close();
	    	        	conn.close();
	    	        	}
	    	        catch(Exception e){  }
	    	       
    
       }
       
	   private Student toStr(ResultSet rs)throws SQLException{
		   Student s=new Student();
		   s.setID(rs.getInt("id"));
		   s.setName(rs.getString("name"));
		   return s;
	   } 
       public List<Student> findAll(){
    	  
    	   Connection conn=db.getConn();
	    	//    	Connection conn = db.getConn();
	    	        PreparedStatement pstm = null;
	    	        ResultSet rs=null;
	    	        String sql_findAll = "select * from student";	//sql����
	    	        List<Student> list=new ArrayList<Student>();
	    	        try{	        
	    	        	//conn = new DataBaseConnection();	  
	    	        	pstm = conn.prepareStatement(sql_findAll);
	    	       // 	pstm.setString(1,s.getName());
	    	        	//pstmt.setString(1,s.getID());
	    	 //       	pstm.setInt(1,iD);
	    	        	 rs= pstm.executeQuery();
	    	        	 while (rs.next()) {
	    	        		 
	    	        		 list.add(toStr(rs));
	    	        	 }
	    	        	pstm.close();
	    	        	conn.close();
	    	        	}
	    	        catch(Exception e){  }
    	   return list;
    	   
       }

                 
	    public Student findByID(int iD) {
	 //   	List<Student> list=new ArrayList();
	    	   Connection conn=db.getConn();
		    	//    	Connection conn = db.getConn();
		    	        PreparedStatement pstm = null;
		    	        String sql_findByID = "select * from student where ID =" + iD;	//sql����
		    	    
		    	        try{	        
		    	        	//conn = new DataBaseConnection();	  
		    	        	pstm = conn.prepareStatement(sql_findByID);
		    	       // 	pstm.setString(1,s.getName());
		    	        	//pstmt.setString(1,s.getID());
		    	 //       	pstm.setInt(1,iD);
		    	        	 ResultSet rs= pstm.executeQuery();
		    	        	 while (rs.next()) {
		    	        		 return toStr(rs);
		    	        	 }
		    	        	pstm.close();
		    	        	conn.close();
		    	        	}
		    	        catch(Exception e){  }
	//    	Student s;
	    	return null;
	    	
	    }

}
