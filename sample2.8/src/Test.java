import java.sql.SQLException;

public class Test {
    public void test() throws SQLException {
        // TODO: 查询
        Query query=new Query();
        // 没有设置任何条件时，查询全部数据
        query.query();

        // 组合查询，如果数据设置错误，则查询已输入的无误数据
        query.setSnum("221801315");
        query.setSname("张福荣");
        //query.setSnumCondition("221801314");
        //query.setSsexCondition("man");
        query.setSsex("女");
        query.setTname("Lily");
        query.setSclass(3);
        query.query();

        // TODO: 修改
        Update update=new Update();
        // 没有设置修改条件时，打印提示
        update.update();
        // 没有找到要修改的记录
        update.setSnum("221801317");
        update.updateTname("Tony");
        update.update();
        // 没有设置要修改的数据时，打印提示
        update.setSnum("221801315");
        update.update();
        // 设置要修改的数据
        System.out.println("修改前的数据：");
        query.clear();
        query.setSnum("221801315");
        query.query();

        update.updateSname("Diana");
        update.updateTname("Tony");
        update.update();

        System.out.println("修改后的数据：");
        query.query();

        // TODO: 插入
        Insert insert=new Insert();
        insert.setSnum("221801115");
        insert.setSname("Dony");
        insert.setSsex("男");
        insert.setSclass(1);
        insert.insert();

        System.out.println("插入后的Students表：");
        query.clear();
        query.query();

        // TODO: 删除
        Delete delete=new Delete();
        // 没有设置删除条件时，打印错误
        delete.delete();
        // 设置删除条件
        delete.setSname("Dony");
        delete.delete();

        System.out.println("删除后的Students表：");
        query.clear();
        query.query();
    }
}
