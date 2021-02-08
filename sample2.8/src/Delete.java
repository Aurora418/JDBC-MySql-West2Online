import java.sql.SQLException;

public class Delete extends Students{
    public Delete(){
        super();
    }
    public void delete() throws SQLException {
        if(getConditionStatement()==null)
            System.out.println("请输入删除条件！");
        else {
            String delete="delete from students"+getConditionStatement();

            int res=Main.statement.executeUpdate(delete);
            if (res == 0)
                System.out.println("修改失败：表中没有该记录");
            else
                System.out.println("共" + res + "条记录被删除");
        }
        System.out.println();
    }
}
