package com.candidjava;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import com.candidjava.Users;

public class Validate {
    public static boolean checkUser(String userid,String password) 
    {
		EntityManagerFactory ufactory = Persistence.createEntityManagerFactory( "RegistrationLoginJPA" );
	    EntityManager entitymanager = ufactory.createEntityManager();
	    TypedQuery<Users> query = entitymanager.createQuery("Select u from Users AS u WHERE u.userid = :userid and u.password=:password",Users.class);
	    query.setParameter("userid", userid);
	    query.setParameter("password", password);
	    List<Users> list = query.getResultList();
	    if(list.isEmpty()) {
	    	entitymanager.close( );
		    ufactory.close( );
	    	return false;
	    }
	    entitymanager.close( );
	    ufactory.close( );
		return true;
  
    	
    	
    	
    	
    }	
}  	
    	
    	
 /*       boolean st =false;
        try {

            //loading drivers for mysql
            Class.forName("com.mysql.cj.jdbc.Driver");

            //creating connection with the database
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?serverTimezone=UTC","root","eva324751997");
            PreparedStatement ps = con.prepareStatement("select * from users where userid=? and password=?");
            ps.setString(1, userid);
            ps.setString(2, password);
            ResultSet rs =ps.executeQuery();
            st = rs.next();

        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return st;                 
    }   
}
*/