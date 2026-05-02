package org.unibl.etf.ipback.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.unibl.etf.ipback.entities.LocationEntity;
import org.unibl.etf.ipback.service.LocationService;
import java.util.List;

@RestController
@RequestMapping("/locations")
public class LocationController {
    @Autowired
    private LocationService locationService;

    @GetMapping
    public List<LocationEntity> getAllLocations(){
        return locationService.getAllLocations();
    }
}
