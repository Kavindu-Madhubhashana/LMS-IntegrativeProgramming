package lk.ac.kln.lms.service;

import lk.ac.kln.lms.domain.Announcements;
import lk.ac.kln.lms.dto.AnnouncementsDto;


public interface AnnouncementsService {
    Announcements saveAnnouncement(final AnnouncementsDto announcement);

    Iterable<Announcements> getAnnouncementsByCourseCode(final AnnouncementsDto courseCode);


}
