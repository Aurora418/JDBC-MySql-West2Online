import java.sql.ResultSet;
import java.sql.SQLException;

public class Query extends Students {
    public Query() {
        super();
    }

    // 拼接查询语句
    private String getSelectStatement() {
        String condition = getConditionStatement();
        if (condition != null)
            return "select * from students" + condition;
        else
            return "select * from students";
    }

    // 查询
    public void query() throws SQLException {
        String query = getSelectStatement();

        ResultSet rs = Main.statement.executeQuery(query);
        boolean rsExist = false;
        while (rs.next()) {
            rsExist = true;
            System.out.println(rs.getString("Snum") + " " + rs.getString("Sname") + " "
                    + rs.getString("Ssex") + " " + rs.getString("Tname") + " " + rs.getString("Sclass"));
        }
        if (!rsExist)
            System.out.println("查无此人!");

        System.out.println();
    }
}
