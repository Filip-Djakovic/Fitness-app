package org.unibl.etf.ipback.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.unibl.etf.ipback.entities.LocationEntity;
import org.unibl.etf.ipback.repository.LocationRepository;

import java.util.List;

@Service
public class LocationService {
    @Autowired
    private LocationRepository locationRepository;

    public List<LocationEntity> getAllLocations(){
        return locationRepository.findAll();
    }

}
