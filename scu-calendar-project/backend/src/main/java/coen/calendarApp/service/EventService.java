package coen241.calendarApp.service;

import coen241.calendarApp.model.Event;
import coen241.calendarApp.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Service
public class EventService {


    private final EventRepository eventRepository;
    @Autowired
    public EventService(EventRepository eventRepository) { this.eventRepository = eventRepository; }

    public List<Event> getAllEvent() { return eventRepository.findAll();}
    public Event getEvent(Long eventId) {
        return eventRepository.findByEventId(eventId);
    }
    public List<Event> getEventsByLocation(String location) { return eventRepository.findByLocation(location);}
    public List<Event> getEventsByPublisher(String publisher) { return eventRepository.findByPublisher(publisher);}
    public List<Event> getEventsByEventDate(Date date) { return eventRepository.findByEventDate(date);}
    public List<Event> getEventsByValid(int valid) { return eventRepository.findByValid(valid);}

    public List<Event> getEventsByDateAndLocation(Date date, String location) { return eventRepository.findByEventDateAndLocation(date,location);}

    public List<Event> getEventsByTag(String tag) { return eventRepository.findByTag(tag); }

    public Event saveEvent(Event event) { return eventRepository.save(event); }

    public List<Event> getEventsByParams(Map<String,List<String>> params) {

        List<String> dates = params.get("event_date");
        List<String> locations = params.get("location");
        List<String> tags = params.get("tag");

        if (dates.size()==0 && locations.size()==0 && tags.size()==0) {
            return eventRepository.findAll(); // if dictionary params is empty, return all events instead
        }
        else {
            return eventRepository.findByEventDateAndLocationAndTag(dates, locations, tags); //search by params
        }
    }

    //----------------------------------------

}
