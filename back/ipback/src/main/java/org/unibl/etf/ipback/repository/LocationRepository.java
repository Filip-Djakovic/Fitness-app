package org.unibl.etf.ipback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.unibl.etf.ipback.entities.LocationEntity;

@Repository
public interface LocationRepository extends JpaRepository<LocationEntity, Integer> {
}
