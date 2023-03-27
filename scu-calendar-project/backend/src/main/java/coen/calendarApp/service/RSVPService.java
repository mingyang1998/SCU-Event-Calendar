package coen.calendarApp.service;

import coen.calendarApp.model.RSVP;
import coen.calendarApp.model.User;
import coen.calendarApp.model.Event;
import coen.calendarApp.repository.RSVPRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RSVPService {

    private final RSVPRepository rsvpRepository;
    @Autowired
    public RSVPService(RSVPRepository rsvpRepository) { this.rsvpRepository = rsvpRepository; }

    public RSVP saveRSVP(RSVP rsvp) {
        return rsvpRepository.save(rsvp);
    }
    public List<RSVP> getAllRSVP() {
        return rsvpRepository.findAll();
    }

    public List<RSVP> getRSVPByUsername(String username) {return rsvpRepository.findByUsername(username);}
    public List<RSVP> getRSVPByEventId(Long eventId) {return rsvpRepository.findByEventId(eventId);}

}
