package org.unibl.etf.ipback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.unibl.etf.ipback.entities.UserAccountEntity;

public interface UserAccountRepository extends JpaRepository<UserAccountEntity, String> {
    public UserAccountEntity findUserAccountEntitiesByUsername(String username);
}
