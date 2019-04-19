package com.fjd.mbt.controller;

import com.fjd.mbt.model.Presentation;
import com.fjd.mbt.service.PresentationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/Presentations")
public class PresentationController {
    @Autowired
    PresentationService presentationService;


    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> addPresentation(
            @Valid @RequestBody Presentation presentation) {
//    	ExceptionHandlerUtils.throwIfIdNotNull(presentation.getId());
        presentationService.addPresentation(presentation);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Optional<Presentation>> getPresentation(
            @Min(0) @PathVariable Long id) {
        return new ResponseEntity<Optional<Presentation>>(presentationService.getPresentation(id), HttpStatus.OK);

    }


    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Presentation>> getPresentations() {
        return new ResponseEntity<List<Presentation>>(presentationService.getAllPresentations(), HttpStatus.OK);
    }


    @RequestMapping(value = "/{id}", method = {RequestMethod.PATCH})
    public ResponseEntity<Void> update(
            @PathVariable Long id,
            @RequestBody Presentation presentation) {

        presentationService.updatePresentation(id, presentation);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
