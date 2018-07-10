package com.fjd.mbt.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.fjd.mbt.common.util.ExceptionHandlerUtils;
import com.fjd.mbt.model.Conference;
import com.fjd.mbt.persistence.ConferenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ConferenceServiceImpl implements ConferenceService {

    @Autowired
    ConferenceRepository conferenceRepository;

    @Override
    public void addConference(Conference conference) {
    	ExceptionHandlerUtils.throwIfIdNotNull(conference.getId());
        conferenceRepository.save(conference);
    }

    @Override
    public Optional<Conference> getConference(Long id) {
    	ExceptionHandlerUtils.throwIfNonexisting(conferenceRepository,id);
        return conferenceRepository.findById(id);
    }

    @Override
    public List<Conference> getConferences() {
        Iterable<Conference> conferences = conferenceRepository.findAll();
        List<Conference> conferenceList = new ArrayList<Conference>();
        for (Conference conference : conferences) {
            conferenceList.add(conference);
        }
        return conferenceList;
    }

    @Override
    public void updateConference(Long id, Conference conference) {
    	ExceptionHandlerUtils.throwIfNonexisting(conferenceRepository,id);
    	ExceptionHandlerUtils.throwIfInconsistent(id, conference.getId());
    	conferenceRepository.save(conference);
    }

}
