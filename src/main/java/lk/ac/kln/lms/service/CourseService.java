package lk.ac.kln.lms.service;

import lk.ac.kln.lms.domain.Course;
import lk.ac.kln.lms.dto.CreateCourseDto;
import lk.ac.kln.lms.dto.UpdateCourseDto;

import java.util.Optional;

public interface CourseService {

    Iterable<Course> allCourses();

    Optional<Course> getCourseById(final String id);

    Optional<Course> updateCourseById(final String code, final UpdateCourseDto updatedCourse);

    Boolean removeCourseById(final int id);

    Optional<Course> saveCourse(final CreateCourseDto course);
}
