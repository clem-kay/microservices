package com.clementk.UserMicroService.service;

import com.clementk.UserMicroService.VO.Department;
import com.clementk.UserMicroService.VO.ResponseTemplateVo;
import com.clementk.UserMicroService.entity.User;
import com.clementk.UserMicroService.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    public User saveUser(User user) {
        log.info("Inside save user of user service");
        return userRepository.save(user);
    }

    public ResponseTemplateVo getUserWithDepartment(Long userId) {
        log.info("Inside get user of user service");
        ResponseTemplateVo responseTemplateVo = new ResponseTemplateVo();
        User user = userRepository.findByUserId(userId);
        Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/" + user.getDepartmentId(),
                Department.class);

        responseTemplateVo.setDepartment(department);
        responseTemplateVo.setUser(user);

        return responseTemplateVo;
    }
}
