package org.unibl.etf.ipback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.unibl.etf.ipback.entities.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    public UserEntity findUserEntityByUserAccount_Username(String username);

    public UserEntity findUserEntityById(Integer id);

}
