package com.rqm.springclouddomain1.service.impl;


import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.rqm.springclouddomain1.mapper.UserMapper;
import com.rqm.springclouddomain1.model.entity.User;
import com.rqm.springclouddomain1.service.IUserService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author rqm
 * @since 2019-12-16
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
