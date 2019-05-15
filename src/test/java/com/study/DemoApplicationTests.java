package com.study;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.study.sys.entity.User;
import com.study.sys.mapper.UserMapper;
import com.study.sys.service.IUserService;
import com.study.utils.UUIDUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private IUserService userService;

    @Test
    public void insert() {
        System.out.println("---------dao中insert方法----------");
        User user = new User();
        String uid = UUIDUtils.createUUID();
        user.setId(uid);
        user.setUserName("jack"+uid);
        user.setPassword("password");

        int insertRows = userMapper.insert(user);
        System.out.println("insert:"+insertRows);

    }

    @Test
    public void delete(){
        System.out.println("------dao中deleteById方法-------");
        String uid = "56aea95ae4304da4acf83b7207385964";
        System.out.println("deleteById:"+userMapper.deleteById(uid));

        System.out.println("--------dao中deleteBatchIds方法------------");
        List<String> uids = new ArrayList<>();
        uids.add("7dd648e00eb1426aa8044c88209c3225");
        uids.add("85b95619cce44034858d0f996a4132ec");
        System.out.println("deleteBatchIds："+userMapper.deleteBatchIds(uids));

        System.out.println("------dao中delete方法-------");
        System.out.println("delete:"+userMapper.delete(new QueryWrapper<User>()
                .eq("id","5bf29f690d204ddd8e02318173d2f0d2")
                .eq("user_name","jack5bf29f690d204ddd8e02318173d2f0d2")));

        System.out.println("---------dao中deleteByMap方法-------------");
        Map<String,Object> map = new HashMap<>();
        map.put("id","13dc0adc226d492e93a599bfdf90afa9");
        map.put("user_name","string2");
        System.out.println("deleteByMap:"+userMapper.deleteByMap(map));

    }

    @Test
    public void select(){
        System.out.println("---------dao中selectById方法----------");
        String uid = "0b3c8b049eeb43a89769057bfca73405";
        System.out.println("selectById:"+userMapper.selectById(uid));

        System.out.println("----------dao中selectBatchIds方法--------------");
        List<String> uids = new ArrayList<>();
        uids.add("0b3c8b049eeb43a89769057bfca73405");
        uids.add("0db8c10fc96343eaa45ddc7fc1a11510");
        System.out.println("selectBatchIds:"+ userMapper.selectBatchIds(uids));

        //userMapper.selectList(new QueryWrapper<User>());
        userMapper.selectMaps(null);

    }

}
