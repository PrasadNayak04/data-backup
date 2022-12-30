package com.robosoft.user_service.repository;

import com.robosoft.user_service.VO.ResponseTemplate;
import com.robosoft.user_service.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User getUserDetailsByUserId(Long userId);

}
