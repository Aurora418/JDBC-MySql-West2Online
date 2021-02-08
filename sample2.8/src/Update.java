import java.sql.SQLException;

public class Update extends Students {
    private String updateSnum;
    private String updateSname;
    private String updateSsex;
    private String updateTname;
    private int updateSclass;

    public Update() {
        super();
        this.updateSnum = null;
        this.updateSname = null;
        this.updateSsex = null;
        this.updateTname = null;
        this.updateSclass = 0;
    }

    public void updateSnum(String updateSnum) {
        this.updateSnum = updateSnum;
    }

    public void updateSname(String updateSname) {
        this.updateSname = updateSname;
    }

    public void updateSsex(String updateSsex) {
        this.updateSsex = updateSsex;
    }

    public void updateTname(String updateTname) {
        this.updateTname = updateTname;
    }

    public void updateSclass(int updateSclass) {
        this.updateSclass = updateSclass;
    }

    private String getUpdateStatement() {
        if (getConditionStatement() == null) {
            System.out.println("请输入修改条件！");
            return null;
        }
        boolean updateExist = false;
        boolean hadBefore = false;
        String statement = "update students set";
        if (updateSnum != null) {
            statement += " Snum=\"" + updateSnum + "\"";
            updateExist = true;
            hadBefore = true;
        }
        if (updateSname != null) {
            if (hadBefore)
                statement += " ,";
            statement += " Sname=\"" + updateSname + "\"";
            updateExist = true;
            hadBefore = true;
        }
        if (updateSsex != null) {
            if (hadBefore)
                statement += " ,";
            statement += " Ssex=\"" + updateSsex + "\"";
            updateExist = true;
            hadBefore = true;
        }
        if (updateTname != null) {
            if (hadBefore)
                statement += " ,";
            statement += " Tname=\"" + updateTname + "\"";
            updateExist = true;
            hadBefore = true;
        }
        if (updateSclass != 0) {
            if (hadBefore)
                statement += " ,";
            statement += " Sclass=" + updateSclass;
            updateExist = true;
            hadBefore = true;
        }

        if (!updateExist) {
            System.out.println("请输入要修改的数据！");
            return null;
        } else
            return statement + getConditionStatement();
    }

    public void update() throws SQLException {
        String update = getUpdateStatement();
        if (update != null) {
            int res = Main.statement.executeUpdate(update);
            if (res == 0)
                System.out.println("修改失败：表中没有该记录");
            else
                System.out.println("共" + res + "条记录被修改");
        }
        System.out.println();
    }
}
