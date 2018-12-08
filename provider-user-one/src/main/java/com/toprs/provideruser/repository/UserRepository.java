package com.toprs.provideruser.repository;

import com.toprs.provideruser.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @Auther: scp
 * @Date: 2018/12/4 11:40
 * @Description:
 */
@Repository
public interface UserRepository extends CrudRepository<User,Long>{

    User findByUserId(Long userId);
}
