package lk.ac.kln.lms.service;

import lk.ac.kln.lms.domain.Course;
import lk.ac.kln.lms.dto.CreateCourseDto;
import lk.ac.kln.lms.dto.UpdateCourseDto;
import lk.ac.kln.lms.repo.CourseRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class CourseServiceImpl implements CourseService {

    private final CourseRepo courseRepo;

    @Override
    public Iterable<Course> allCourses() {
        Iterable<Course> courses = courseRepo.findAll();
        return courses;
    }

    @Override
    public Optional<Course> getCourseById(String code) {
        Optional<Course> course = courseRepo.findByCourseCode(code);
        if(course.isPresent()) {
            return course;
        } else return Optional.empty();
    }

    @Override
    public Optional<Course> updateCourseById(String code, UpdateCourseDto newCourse) {
        return Optional.empty();
    }

    @Override
    public Boolean removeCourseById(int id) {
        return null;
    }

    @Override
    public Optional<Course> saveCourse(CreateCourseDto course) {
        return Optional.empty();
    }
}
