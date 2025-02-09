package com.ecogrid.services;

import com.ecogrid.models.Community;
import com.ecogrid.repositories.CommunityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommunityService {

    @Autowired
    private CommunityRepository communityRepository;

    public List<Community> getAllCommunities() {
        return communityRepository.findAll();
    }

    public Community getCommunityById(int id) {
        return communityRepository.findById(id).orElse(null);
    }

    public Community createCommunity(Community community) {
        return communityRepository.save(community);
    }

    public Community updateCommunity(int id, Community communityDetails) {
        Optional<Community> community = communityRepository.findById(id);
        if (community.isPresent()) {
            Community updatedCommunity = community.get();
            updatedCommunity.setName(communityDetails.getName());
            updatedCommunity.setLocation(communityDetails.getLocation());
            updatedCommunity.setPopulation(communityDetails.getPopulation());
            return communityRepository.save(updatedCommunity);
        }
        return null;
    }

    public void deleteCommunity(int id) {
        communityRepository.deleteById(id);
    }
}
