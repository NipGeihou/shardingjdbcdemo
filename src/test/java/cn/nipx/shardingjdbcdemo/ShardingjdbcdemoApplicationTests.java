package cn.nipx.shardingjdbcdemo;

import cn.nipx.shardingjdbcdemo.entity.Course;
import cn.nipx.shardingjdbcdemo.mapper.CourseMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ShardingjdbcdemoApplicationTests {

    @Autowired
    private CourseMapper courseMapper;

    @Test
    void addCourse() {
        for (int i = 0; i < 10; i++) {
            Course course = new Course();
            course.setCname("java" + i);
            course.setUserId(100L);
            course.setCstatus("Normal");
            courseMapper.insert(course);
        }
    }

    @Test
    void findCourse() {
        QueryWrapper<Course> queryWrapper = new QueryWrapper<>();
        // queryWrapper.eq("cid", 654009546762616832L);
        queryWrapper.eq("user_id", 100L).orderByDesc("cname");
        List<Course> courses = courseMapper.selectList(queryWrapper);
        courses.forEach(System.out::println);
    }

}
