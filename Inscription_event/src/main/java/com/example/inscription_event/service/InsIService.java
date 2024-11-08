package com.example.inscription_event.service;

import com.example.inscription_event.entity.InsEvent;

import java.util.List;

public interface InsIService {


    public List<InsEvent> retrieveAllInsEvents();
    public InsEvent retrieveInsEvents(Long idIns);
    public InsEvent addInsEvents(InsEvent i);
    public void removeInsEvents(Long idIns);
    public InsEvent modifyInsEvents(InsEvent insEvent);



}