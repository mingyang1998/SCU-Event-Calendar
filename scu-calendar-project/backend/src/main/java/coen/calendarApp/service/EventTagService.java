package coen.calendarApp.service;
import coen.calendarApp.model.EventTag;
import coen.calendarApp.model.RSVP;
import coen.calendarApp.repository.EventTagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EventTagService {

    private final EventTagRepository eventTagRepository;
    @Autowired
    public EventTagService(EventTagRepository eventTagRepository) { this.eventTagRepository = eventTagRepository; }

    public EventTag saveEventTag(EventTag eventtag) {
        return eventTagRepository.save(eventtag);
    }
    public List<EventTag> getAllEventTag() {
        return eventTagRepository.findAll();
    }
    public List<EventTag> getEventTagByTag(String tag) {return eventTagRepository.findByTag(tag);}
    public List<EventTag> getEventTagByEventId(Long eventId) {return eventTagRepository.findByEventId(eventId);}

}
