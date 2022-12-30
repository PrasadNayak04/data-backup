package com.robosoft.user_service.service;

import com.robosoft.user_service.VO.Department;
import com.robosoft.user_service.VO.ResponseTemplate;
import com.robosoft.user_service.entity.User;
import com.robosoft.user_service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public ResponseTemplate getUserDetailsByUserId(Long departmentId) {
        ResponseTemplate responseTemplate = new ResponseTemplate();

        User user = userRepository.getUserDetailsByUserId(departmentId);
        Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/department/" + user.getDepartmentId(), Department.class);

        responseTemplate.setUser(user);
        responseTemplate.setDepartment(department);

        return responseTemplate;
    }

}
