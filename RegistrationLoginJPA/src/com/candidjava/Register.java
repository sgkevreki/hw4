package com.candidjava;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import com.candidjava.Users;



@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	
	//Finds newest id
	public int maxid() {

		EntityManagerFactory ufactory = Persistence.createEntityManagerFactory( "RegistrationLoginJPA" );
	    EntityManager entitymanager = ufactory.createEntityManager();
	    TypedQuery<Users> query = entitymanager.createQuery("Select u.id from Users AS u",Users.class);
	    List<Users> list = query.getResultList();
	    
	    StringBuilder sb = new StringBuilder();
	    for (Object object : list) {
	        sb.append(object);
	    }
	    String s=sb.toString();
	    char c = s.charAt(s.length()-1);
	    int  i=Character.getNumericValue(c); 
	    
	    entitymanager.close( );
	    ufactory.close( );
	    return i;
	}

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

				response.setContentType("text/html;charset=UTF-8");

        String name = request.getParameter("name");
        String userid = request.getParameter("userid");
        String password = request.getParameter("password");
        
      //INSERT NEW ENTITY
      		EntityManagerFactory ufactory = Persistence.createEntityManagerFactory( "RegistrationLoginJPA" );
      	    EntityManager entitymanager = ufactory.createEntityManager();
      	    entitymanager.getTransaction( ).begin( );
      	    int id = maxid();
      	    id +=1;
      	    Users user = new Users( ); 
      	    user.setId( id );
	        System.out.println(id);
      	    user.setName( name );
      	    user.setUserid( userid );
      	    user.setPassword( password );
      	    
      	    
      	    entitymanager.persist( user );
      	    entitymanager.getTransaction( ).commit( );

      	    entitymanager.close( );
      	    ufactory.close( );
      	    response.sendRedirect("index.html");
      	}

      }
 
        
        
        
        
    /* Connection c = null;
        Statement stmt = null;
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
	        c = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?serverTimezone=UTC","root","eva324751997");
	        System.out.println("Opened database successfully");
	        
	        stmt = c.createStatement();
	        String sql = "SELECT max(ID) FROM users";
	        ResultSet rs = stmt.executeQuery(sql);
	        rs.next();
	        Integer maxid = rs.getInt("max(ID)");
	        stmt = c.createStatement();
	        sql = "select count(*)" + 
	        		"from users U " + 
	        		"where '"+userid+"' in (select userid from users US where U.id=US.ID)";
	        rs = stmt.executeQuery(sql);
	        rs.next();
	        Integer validnum = rs.getInt("count(*)");
	        if (validnum==0){
	            PreparedStatement ps = c.prepareStatement
	                        ("INSERT INTO users( id, name, userid, password) values(?,?,?,?)");
	            ps.setInt(1, maxid+1);
	            ps.setString(2, name);
	            ps.setString(3, userid);
	            ps.setString(4, password);
	            
	            int i = ps.executeUpdate();
	            
	            if(i > 0) {
	                System.out.println("You are sucessfully registered");
	                response.sendRedirect("welcome.html");
	            }
	        }
	        else {
	        	out.println("This password already exists!");
	        	RequestDispatcher ns = request.getRequestDispatcher("register.html");
	            ns.include(request, response);
	        }
        
        }
        catch(Exception se) {
            se.printStackTrace();
        }
	
    }
} */