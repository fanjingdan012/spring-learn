package com.fjd.mbt.service;

import com.fjd.mbt.model.Presentation;

import java.util.List;
import java.util.Optional;

public interface PresentationService {


    void addPresentation(Presentation presentation);

    Optional<Presentation> getPresentation(Long id);

    List<Presentation> getAllPresentations();

    void updatePresentation(Long id, Presentation presentation);
}
