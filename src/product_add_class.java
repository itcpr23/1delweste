
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author laurence
 */
public class product_add_class {
    public int addPro(String product_name, int quantity, String price){
    int jo = 0;
    String sql = "INSERT INTO products VALUES(null,?,?,?);";
    try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = (Connection)DriverManager.getConnection("jdbc:mysql://localhost/registration_form?", "root", "");
        
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, product_name);
        pstm.setInt(2,quantity);
        pstm.setString(3, price);
        jo=pstm.executeUpdate();
        
    }   catch (ClassNotFoundException ex) {
            Logger.getLogger(product_add_class.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(product_add_class.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    return jo;
}
}
