package org.unibl.etf.ipback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.unibl.etf.ipback.entities.MessageEntity;

public interface MessageRepositroy extends JpaRepository<MessageEntity, Integer> {
}
