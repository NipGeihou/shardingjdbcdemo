package cn.nipx.shardingjdbcdemo;

import cn.nipx.shardingjdbcdemo.entity.User;
import cn.nipx.shardingjdbcdemo.mapper.UserMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 测试专库专表
 */
@SpringBootTest
class ShardingjdbcdemoApplicationTests3 {

    @Autowired
    private UserMapper userMapper;


    @Test
    void addUser() {
        User user = new User();
        user.setUsername("NipGeihou");
        user.setUstatus("1");
        userMapper.insert(user);
    }

    @Test
    void findUser() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id", "654448836650991617");
        User user = userMapper.selectOne(wrapper);
        System.out.println(user);
    }

}
