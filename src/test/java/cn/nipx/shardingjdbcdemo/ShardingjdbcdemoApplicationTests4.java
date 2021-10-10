package cn.nipx.shardingjdbcdemo;

import cn.nipx.shardingjdbcdemo.entity.Udict;
import cn.nipx.shardingjdbcdemo.entity.User;
import cn.nipx.shardingjdbcdemo.mapper.UdictMapper;
import cn.nipx.shardingjdbcdemo.mapper.UserMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 测试公共表
 */
@SpringBootTest
class ShardingjdbcdemoApplicationTests4 {

    @Autowired
    private UdictMapper udictMapper;


    @Test
    void addDict() {
        Udict udict = new Udict();
        udict.setUstatus("1");
        udict.setUvalue("已启用");
        udictMapper.insert(udict);
    }

    @Test
    void deleteDict() {
        QueryWrapper<Udict> wrapper = new QueryWrapper<>();
        wrapper.eq("dictid", "654079660392448001");
        udictMapper.delete(wrapper);
    }


}
