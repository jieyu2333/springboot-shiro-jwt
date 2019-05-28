package com.study.sys.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.study.sys.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author JieYu
 * @since 2019-04-24
 */
public interface UserMapper extends BaseMapper<User> {

    IPage<User> selectPageByParam(Page page,@Param("user") User user);

    User selectByUserName(String userName);
}
