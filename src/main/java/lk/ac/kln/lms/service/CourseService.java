package lk.ac.kln.lms.service;

import lk.ac.kln.lms.domain.Course;
import lk.ac.kln.lms.dto.CreateCourseDto;
import lk.ac.kln.lms.dto.DeleteCourseDto;
import lk.ac.kln.lms.dto.GetCourseDto;
import lk.ac.kln.lms.dto.UpdateCourseDto;

import java.util.Optional;

public interface CourseService {

    Iterable<Course> allCourses();

    Optional<Course> getCourseById(final String id);

    Optional<Course> getCourseByCourseCode(final GetCourseDto courseCode);

    Course updateCourseById(final UpdateCourseDto updatedCourse);

    Boolean removeCourseById(final DeleteCourseDto courseDto);

    Course saveCourse(final CreateCourseDto course);
}
