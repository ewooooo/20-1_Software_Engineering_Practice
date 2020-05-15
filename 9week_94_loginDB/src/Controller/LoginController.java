package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {

    @FXML
    private Button btn1;

    @FXML
    private TextField textfield1;

    @FXML
    private PasswordField passwordfield1;

    @FXML
    private Label statusLable;

    @FXML
    private Label result;

    @FXML
    void btnAction(ActionEvent event) {
    	if(isCorrect(textfield1.getText(), passwordfield1.getText())){
    		result.setText("로그인 되었습니다.");
    	}else {
    		result.setText("로그인 실패했습니다.");
    	}
    }

    boolean isCorrect(String id, String pwd) {
    	Connection con = null;
    	Statement stmt = null;
    	ResultSet rs = null;
    	
    	try {
    		try {
    			Class.forName("org.mariadb.jdbc.Driver");
    		} catch (ClassNotFoundException e) {
    			e.printStackTrace();
    		}
    		con = DriverManager.getConnection("jdbc:mariadb://127.0.0.1:3306/logintest","root","admin");
    		stmt = con.createStatement();
    		rs = stmt.executeQuery("select password from login where id =\""+id+"\"");
    		while(rs.next()) {
    			if(rs.getString(1).equals(pwd)) {
    				System.out.println("YES");
    				return true;
    			}
    		}
    	} catch(SQLException sqex) {
    		System.out.println("SQLException: "+sqex.getMessage());
    		System.out.println("SQLState: "+sqex.getSQLState());
    	}
		return false;
    	
    }
}