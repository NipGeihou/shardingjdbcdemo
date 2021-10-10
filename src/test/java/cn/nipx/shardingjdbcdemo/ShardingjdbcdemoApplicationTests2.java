package cn.nipx.shardingjdbcdemo;

import cn.nipx.shardingjdbcdemo.entity.Course;
import cn.nipx.shardingjdbcdemo.mapper.CourseMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * 测试分库分表
 */
@SpringBootTest
class ShardingjdbcdemoApplicationTests2 {

    @Autowired
    private CourseMapper courseMapper;

    @Test
    void addCourse() {
        for (int i = 0; i < 10; i++) {
            Course course = new Course();
            course.setCname("javaDb" + i);
            course.setUserId(100L + (int) (Math.random() * 10));
            course.setCstatus("Normal");
            courseMapper.insert(course);
        }
    }

    @Test
    void findCourse() {
        QueryWrapper<Course> queryWrapper = new QueryWrapper<>();
        // queryWrapper.eq("cid", 654009546762616832L);
        queryWrapper.orderByDesc("cname");
        List<Course> courses = courseMapper.selectList(queryWrapper);
        courses.forEach(System.out::println);
    }

}
