package com.spring.orm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.orm.dao.StudentDao;
import com.spring.orm.entities.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Welcome to spring orm project" );
        
     ApplicationContext context =  new ClassPathXmlApplicationContext("config.xml");
     StudentDao bean = context.getBean("studentDao",StudentDao.class);
//     Student student = new Student(223,"Ashutosh pandey","Shahganj");
//     int insert = bean.insert(student);
//     System.out.println(insert);
     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
     boolean go =true;
    while(go)
    {
    	 System.out.println("Enter 1 for adding Student");
         System.out.println("Enter 2 for displaying all students");
         System.out.println("Enter 3 to get detail of one students");
         System.out.println("Enter 4 to delete students");
         System.out.println("Enter 5 to update");
         System.out.println("Enter 6 to get exit from program");
         try
         {
        	  int choice  = Integer.parseInt(br.readLine()) ;
        	   switch(choice)
        	   {
        	   case 1:
        	   {
//        		   Add student 
        		   System.out.println("Enter user Id");
        		   int uid = Integer.parseInt(br.readLine());
        		   System.out.println("Enter user name");
        		   String uName = br.readLine();
        		   System.out.println("Enter User city");
        		   String uCity = br.readLine();
        		   Student s = new Student();
        		   s.setStudentId(uid);
                   s.setStudentName(uName); 
                   s.setStudentCity(uCity);
                   int insert = bean.insert(s);
                   System.out.println("No of sucessful student added :"+insert);
                   System.out.println("------------------------------");
        		   break;
        		   
        	   }
        	   case 2:
        	   {
//        		   Display all student
        		   
        		   List<Student> allStudents = bean.getAllStudents();
        		   for(Student i:allStudents)
        		   {
        			   System.out.println("******************************************");
        			   System.out.println("StudentId :"+i.getStudentId());
        			   System.out.println("StudentName :  "+i.getStudentName());
        			   System.out.println("StudentCity :"+i.getStudentCity());
        			   System.out.println("-----------------------------------------");
        			   
        		   }
        		   break;
        	   }
        	   case 3:
        	   {
        		// get single student data
        		   System.out.println("Enter user Id");
        		   int uid = Integer.parseInt(br.readLine());
                   Student student = bean.getStudent(uid);
                   System.out.println("------------------------");
                   System.out.println("Student Id:"+student.getStudentId()+"   Student Name:"+student.getStudentName()+"  Student City :"+student.getStudentCity());
                   System.out.println("------------------------");
        		   break;
        		   
        	   }
        	   case 4:
        	   {
//        		   Delete student
        		   System.out.println("Enter user Id");
        		   int uid = Integer.parseInt(br.readLine());
        		   bean.deleteStudent(uid);
        		   System.out.println("Deleted Student");
        		   break;
        	   }
        	   case 5:
        	   {
//        		   Update Student
        		break;   
        	   }
        	   case 6:
        	   {
//        		   Exit
        		   go =false;
        		   break;
        		   
        	   }
        	   }
         }catch(Exception e)
         {
        	 System.out.println("Invaid input");
        	 System.out.println(e.getMessage());
         }
         
    }
    System.out.println("Thsnk you for using my Application");
        
    }
}
