package com.fjd.mbt.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.fjd.mbt.model.Conference;
import com.fjd.mbt.repo.ConferenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ConferenceService {

    @Autowired
    ConferenceRepository conferenceRepository;

    public void addConference(Conference conference) {
    	//ExceptionHandlerUtils.throwIfIdNotNull(conference.getId());
        conferenceRepository.save(conference);
    }

    public Optional<Conference> getConference(Long id) {
    	//ExceptionHandlerUtils.throwIfNonexisting(conferenceRepository,id);
        return conferenceRepository.findById(id);
    }

    public List<Conference> getConferences() {
        Iterable<Conference> conferences = conferenceRepository.findAll();
        List<Conference> conferenceList = new ArrayList<Conference>();
        for (Conference conference : conferences) {
            conferenceList.add(conference);
        }
        return conferenceList;
    }

    public void updateConference(Long id, Conference conference) {
    	//ExceptionHandlerUtils.throwIfNonexisting(conferenceRepository,id);
    	//ExceptionHandlerUtils.throwIfInconsistent(id, conference.getId());
    	conferenceRepository.save(conference);
    }

}
