
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataBaseConnections {

    public static Connection loadDriver() throws ClassNotFoundException, SQLException{
        String url = "jdbc:oracle:thin:QATAPP16@//10.158.201.66:1521/QAT32";
        String userName = "QATAPP16";
        String passWord = "QATAPP16";
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con = DriverManager.getConnection(url, userName, passWord);
        return con;
    }

    public static Statement createStatement() throws Exception{
        return loadDriver().createStatement();
    }

    public static void executeQuery(String query)throws Exception{
        ResultSet set =  createStatement().executeQuery(query);

       while(set.next()){
           if(set.getString("soc").equalsIgnoreCase("4SPHDNFLX")){
              System.out.println(set.getString("soc_description_lng2"));
           }
       }
    }

    public void demoDriverConncetion() throws Exception{
        String url = "jdbc:oracle:thin:QATAPP16@//10.158.201.66:1521/QAT32";
        String userName = "QATAPP16";
        String passWord = "QATAPP16";
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con = DriverManager.getConnection(url, userName, passWord);
        Statement st = con.createStatement();
        ResultSet set =  st.executeQuery("query");
        List<String> information = new ArrayList<>();
        while (set.next()){
            information.add(set.getString(""));
        }
    }

    public static void main (String [] args) throws Exception {
        executeQuery("select soc, soc_description_lng2 from SOC where soc_ind = 'NFX'");
        System.out.println("testing");
    }
}
