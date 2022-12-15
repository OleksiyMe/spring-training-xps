package com.cydeo.service.impl;

import com.cydeo.mapper.UserMapper;
import com.cydeo.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)  //enabling Mockito framework
class UserServiceImplTest {

    @Mock
    UserRepository userRepository;

    @Mock
    UserMapper userMapper;

    @InjectMocks
    UserServiceImpl userService;   //we are using classes in testing, not interfaces

    @Test
    void findByUserNameTest() {

        //calling the real method
        //this method i want to test
        userService.findByUserName("harold@manager.com");

        //chechking if this method was run or not
        verify(userRepository).findByUserNameAndIsDeleted("harold@manager.com", false);

        verify(userRepository, times(1))   //if we use it 1 times?
                .findByUserNameAndIsDeleted("harold@manager.com", false);

        verify(userRepository, atLeastOnce())
                .findByUserNameAndIsDeleted("harold@manager.com", false);

        verify(userRepository, atLeast(1))
                .findByUserNameAndIsDeleted("harold@manager.com", false);

        verify(userRepository, atMostOnce())
                .findByUserNameAndIsDeleted("harold@manager.com", false);

        verify(userRepository, atMost(10))
                .findByUserNameAndIsDeleted("harold@manager.com", false);

        //dependencies called in order or not
        InOrder inOrder= inOrder(userRepository,userMapper);

        inOrder.verify(userRepository)
                .findByUserNameAndIsDeleted("harold@manager.com",false);
        inOrder.verify(userMapper).convertToDto(null);

    }

}