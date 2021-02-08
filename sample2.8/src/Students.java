/*
一个Students的实例对应数据库中Students表的一条记录
 */

public class Students {
    protected String Snum;
    protected String Sname;
    protected String Ssex;
    protected String Tname;
    protected int Sclass;

    public Students() {
        this.Snum = null;
        this.Sname = null;
        this.Ssex = null;
        this.Tname = null;
        this.Sclass = 0;
    }

    public void setSnum(String snum) {
        if (snum.length() != 9)
            System.out.println("学号必须为9位！");
        else
            Snum = snum;
    }

    public void setSname(String sname) {
        Sname = sname;
    }

    public void setSsex(String ssex) {
        if (ssex.equals("男") || ssex.equals("女"))
            Ssex = ssex;
        else
            System.out.println("性别必须为：男/女");
    }

    public void setTname(String tname) {
        Tname = tname;
    }

    public void setSclass(int sclass) {
        Sclass = sclass;
    }

    protected String getConditionStatement() {
        boolean conditionExist = false;
        boolean hadBefore = false;
        String statement = " where";
        if (Snum != null) {
            statement += " Snum=\"" + Snum + "\"";
            conditionExist = true;
            hadBefore = true;
        }
        if (Sname != null) {
            if (hadBefore)
                statement += " and";
            statement += " Sname=\"" + Sname + "\"";
            conditionExist = true;
            hadBefore = true;
        }
        if (Ssex != null) {
            if (hadBefore)
                statement += " and";
            statement += " Ssex=\"" + Ssex + "\"";
            conditionExist = true;
            hadBefore = true;
        }
        if (Tname != null) {
            if (hadBefore)
                statement += " and";
            statement += " Tname=\"" + Tname + "\"";
            conditionExist = true;
            hadBefore = true;
        }
        if (Sclass != 0) {
            if (hadBefore)
                statement += " and";
            statement += " Sclass=" + Sclass;
            conditionExist = true;
            hadBefore = true;
        }

        if (!conditionExist)
            return null;
        else
            return statement;
    }
    public void clear(){
        this.Snum = null;
        this.Sname = null;
        this.Ssex = null;
        this.Tname = null;
        this.Sclass = 0;
    }
}
