package com.fjd.mbt.controller;

import com.fjd.mbt.model.Conference;
import com.fjd.mbt.service.ConferenceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/Conferences")
public class ConferenceController {
    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    ConferenceService conferenceService;


    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> addConference(
            @Valid @RequestBody Conference conference) {
        logger.info("Prepare to create new conference");


        conferenceService.addConference(conference);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Optional<Conference>> getConference(
            @Min(0) @PathVariable Long id) {
        logger.info("logging in " + id);

        return new ResponseEntity<Optional<Conference>>(conferenceService.getConference(id), HttpStatus.OK);
    }


    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Conference>> getConferences() {
        return new ResponseEntity<List<Conference>>(conferenceService.getConferences(), HttpStatus.OK);
    }


    @RequestMapping(value = "/{id}", method = {RequestMethod.PATCH})
    public ResponseEntity<Void> update(
            @PathVariable Long id,
            @RequestBody Conference conference) {

        conferenceService.updateConference(id, conference);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
