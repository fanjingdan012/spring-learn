package com.fjd.mbt.service;

import com.fjd.mbt.model.Presentation;
import com.fjd.mbt.repo.PresentationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class PresentationService{

    @Autowired
    PresentationRepository presentationRepository;

    public void addPresentation(Presentation presentation) {
        //ExceptionHandlerUtils.throwIfIdNotNull(presentation.getId());
        presentationRepository.save(presentation);

    }

    public Optional<Presentation> getPresentation(Long id) {
        //ExceptionHandlerUtils.throwIfNonexisting(presentationRepository,id);
        return presentationRepository.findById(id);
    }

    public List<Presentation> getAllPresentations() {
        Iterable<Presentation> presentations = presentationRepository.findAll();
        List<Presentation> presentationList = new ArrayList<Presentation>();
        for (Presentation presentation : presentations) {
            presentationList.add(presentation);
        }
        return presentationList;
    }

    public void updatePresentation(Long id, Presentation presentation) {
        //ExceptionHandlerUtils.throwIfNonexisting(presentationRepository,id);
        //ExceptionHandlerUtils.throwIfInconsistent(id, presentation.getId());
        presentationRepository.save(presentation);
    }

}
