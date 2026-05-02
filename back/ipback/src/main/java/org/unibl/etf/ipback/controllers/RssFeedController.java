package org.unibl.etf.ipback.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.unibl.etf.ipback.entities.RssFeedEntity;
import org.unibl.etf.ipback.service.RssFeedService;

import java.util.List;

@RestController
@RequestMapping("rss_feeds")
public class RssFeedController {
    @Autowired
    private RssFeedService rssFeedService;

    @GetMapping
    public List<RssFeedEntity> getAll(){
        return rssFeedService.getRssFeeds();
    }
}
