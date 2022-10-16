package lk.ac.kln.lms.service;

import lk.ac.kln.lms.domain.Announcements;
import lk.ac.kln.lms.dto.AnnouncementsDto;
import lk.ac.kln.lms.dto.GetAnnouncementsDto;


public interface AnnouncementsService {
    Announcements saveAnnouncement(final AnnouncementsDto announcement) throws Exception;

    Iterable<Announcements> getAnnouncementsByCourseCode(final GetAnnouncementsDto courseCode) throws Exception;

}
