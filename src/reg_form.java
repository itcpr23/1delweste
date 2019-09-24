
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author laurence
 */
public class reg_form {
    
    public int form(String firstname, String lastname, String username, String pass){
        int ins = 0;
        String sql = " insert into formtbl values(?,?,?,md5(?));";

try{
    Class.forName("com.mysql.jdbc.Driver");
    Connection con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost/registration_form?", "root", "");
    
    PreparedStatement pstmt = con.prepareStatement(sql);
    pstmt.setString(1, firstname);
    pstmt.setString(2, lastname);
    pstmt.setString(3, username);
    pstmt.setString(4, pass);
    
    pstmt.executeUpdate();
    ins=1;
    
}       catch (ClassNotFoundException ex) {
            Logger.getLogger(register.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(register.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ins;
    }
  
      public int jcheckpass(String pass, String cpass){
        int x = 0;
        if(pass.equals(cpass)){
            x=1;
        }else{
            x=0;
        }
        
        
        return x;
    }
    
    public int checkuser(String uname){
        int p=0;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/registration_form?", "root", "");
            String sql = "select * from formtbl where username=?;";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, uname);
            
            ResultSet rs =pstmt.executeQuery();
            if(rs.next()){
               p=1;
            }else{
                p=0;
            }
            
            
            
        } catch (ClassNotFoundException ex) { 
            Logger.getLogger(reg_form.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(reg_form.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
        
    }
}
