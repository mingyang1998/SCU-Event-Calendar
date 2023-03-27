package coen.calendarApp.repository;

import coen.calendarApp.model.EventTag;
import coen.calendarApp.model.RSVP;
import coen.calendarApp.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventTagRepository extends CrudRepository<EventTag, Integer> {

    List<EventTag> findAll();
    EventTag findByEventTagId(long event_tag_id);
    List<EventTag> findByTag(String tag);
    List<EventTag> findByEventId(long event_id);
    void deleteByEventTagId(long event_tag_id);
}
