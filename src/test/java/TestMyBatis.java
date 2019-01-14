import com.isoft.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class TestMyBatis {
    @Test
    public void insert1(){
        InputStream rs = TestMyBatis.class.getResourceAsStream("configuration.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(rs);
        SqlSession sqlSession = sessionFactory.openSession();
        String str = "com.isoft.mapper.UserMapper.insert2";
        List list=new ArrayList();
        User user = new User();
        user.setUname("admin");
        user.setRuname("管理员");
        user.setRemark("我是新管理员");
        list.add(user);
        User user1 = new User();
        user1.setUname("teacher");
        user1.setRuname("教师");
        user1.setRemark("我是新教师");
        list.add(user1);
        int insert = sqlSession.insert(str,list);
        sqlSession.commit(true);
        System.out.println(insert);
    }
    public void insert(){
        InputStream rs = TestMyBatis.class.getResourceAsStream("configuration.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(rs);
        SqlSession sqlSession = sessionFactory.openSession();
        String str = "com.isoft.mapper.UserMapper.insert";
        User user = new User();
        user.setUname("admin");
        user.setRuname("管理员");
        user.setRemark("我是新管理员");
        int insert = sqlSession.insert(str,user);
        sqlSession.commit(true);
        System.out.println(insert);
    }

    public void delete(){
        InputStream rs = TestMyBatis.class.getResourceAsStream("configuration.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(rs);
        SqlSession sqlSession = sessionFactory.openSession();
        String str = "com.isoft.mapper.UserMapper.delete";
        int update = sqlSession.update(str, 2);
        sqlSession.commit();
        System.out.println(1);
    }

    public void update(){
        InputStream rs = TestMyBatis.class.getResourceAsStream("configuration.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(rs);
        SqlSession sqlSession = sessionFactory.openSession();
        String str = "com.isoft.mapper.UserMapper.update";
        User user = new User();
        user.setId(2);
        user.setUname("admin");
        user.setRuname("管理员");
        user.setRemark("我是管理员");
        try {
            int update = sqlSession.update(str,user);
            sqlSession.commit();//注意：增、删、改等影响结果的操作要提交
            System.out.println(1);
        }catch (Exception e){
            sqlSession.rollback();//回滚
        }
    }

    public void findAll(){
        InputStream rs = TestMyBatis.class.getResourceAsStream("configuration.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(rs);
        SqlSession sqlSession = sessionFactory.openSession();
        String str = "com.isoft.mapper.UserMapper.findAll";
        List<Object> objects = sqlSession.selectList(str);
        for (Object obj:objects) {
            User user = (User) obj;
            System.out.println(user.getUname());
            System.out.println(user.getRuname());
            System.out.println(user.getRemark());
            System.out.println("----------");
        }
    }

    public void findUserById(){//写main（）快捷键是psvm
        InputStream rs = TestMyBatis.class.getResourceAsStream("configuration.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(rs);
        SqlSession sqlSession = sessionFactory.openSession();
        String str = "com.isoft.mapper.UserMapper.findUserById";
        User o = sqlSession.selectOne(str,2);
        System.out.println(o);
    }
}
