import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Insert extends Students{
    public Insert(){
        super();
    }
    public void insert() throws SQLException {
        String insert="insert students values(?,?,?,?,?)";

        PreparedStatement ps=Main.connection.prepareStatement(insert);
        ps.setString(1,Snum);
        ps.setString(2,Sname);
        ps.setString(3,Ssex);
        ps.setString(4,Tname);
        ps.setInt(5,Sclass);

        int res=ps.executeUpdate();
        if (res == 0)
            System.out.println("新增失败！");
        else
            System.out.println("共插入" + res + "条记录");

        System.out.println();
    }
}
