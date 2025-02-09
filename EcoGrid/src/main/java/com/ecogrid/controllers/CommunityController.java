package com.ecogrid.controllers;

import com.ecogrid.models.Community;
import com.ecogrid.services.CommunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/communities")
public class CommunityController {

    @Autowired
    private CommunityService communityService;

    @GetMapping
    public List<Community> getAllCommunities() {
        return communityService.getAllCommunities();
    }

    @GetMapping("/{id}")
    public Community getCommunityById(@PathVariable int id) {
        return communityService.getCommunityById(id);
    }

    @PostMapping
    public Community createCommunity(@RequestBody Community community) {
        return communityService.createCommunity(community);
    }

    @PutMapping("/{id}")
    public Community updateCommunity(@PathVariable int id, @RequestBody Community community) {
        return communityService.updateCommunity(id, community);
    }

    @DeleteMapping("/{id}")
    public void deleteCommunity(@PathVariable int id) {
        communityService.deleteCommunity(id);
    }
}
