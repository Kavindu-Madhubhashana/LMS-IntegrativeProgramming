package lk.ac.kln.lms.service;

import lk.ac.kln.lms.domain.Course;
import lk.ac.kln.lms.domain.CourseCategory;
import lk.ac.kln.lms.dto.CreateCourseDto;
import lk.ac.kln.lms.dto.DeleteCourseDto;
import lk.ac.kln.lms.dto.GetCourseDto;
import lk.ac.kln.lms.dto.UpdateCourseDto;
import lk.ac.kln.lms.repo.CourseRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class CourseServiceImpl implements CourseService {

    @Autowired
    private final CourseRepo courseRepo;

    @Autowired
    private final CourseCategoryService courseCategoryService;

    @Override
    public Iterable<Course> allCourses() {
        return courseRepo.findAll();
    }

    @Override
    public Optional<Course> getCourseById(String code) {
        return courseRepo.findByCourseCode(code);
    }

    @Override
    public Optional<Course> getCourseByCourseCode(GetCourseDto courseCode) {
        return this.courseRepo.findByCourseCode(courseCode.getCourseCode());
    }

    @Override
    public Course updateCourseById(UpdateCourseDto newCourse) {

        Optional<Course> foundCourse = this.courseRepo.findById(newCourse.getCourseId());

        if(foundCourse.isEmpty()) {
            return new Course();
        }

        Optional<CourseCategory> foundCourseCategory = this.courseCategoryService.getCourseCategoryById(newCourse.getCourseCategoryId());

        if(foundCourseCategory.isEmpty()) {
            return new Course();
        }

        Course course = new Course();
        course.setId(newCourse.getCourseId());
        course.setCourseCode(newCourse.getCourseCode());
        course.setCourseName(newCourse.getCourseName());
        course.setDescription(newCourse.getDescription());
        course.setStartDate(newCourse.getStartDate());
        course.setEndDate(newCourse.getEndDate());
        course.setCourseCategory(foundCourseCategory.get());

        return this.courseRepo.save(course);

    }

    @Override
    public Boolean removeCourseById(DeleteCourseDto courseDto) {
        Optional<Course> foundCourse = this.courseRepo.findByCourseCode(courseDto.getCourseCode());

        if(foundCourse.isEmpty()) {
            return false;
        }

        try {
            this.courseRepo.delete(foundCourse.get());
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;

    }

    @Override
    public Course saveCourse(CreateCourseDto course) {

        Optional<CourseCategory> foundCourseCategory = this.courseCategoryService.getCourseCategoryById(course.getCourseCategoryId());

        if(foundCourseCategory.isEmpty()) {
            return new Course();
        }
        
        Optional<Course> foundCourse = this.courseRepo.findByCourseCode(course.getCourseCode());
        
        if(foundCourse.isPresent()) {
            return new Course();
        }
        
        Course newCourse = new Course();
        newCourse.setCourseName(course.getCourseName());
        newCourse.setCourseCode(course.getCourseCode());
        newCourse.setCourseCategory(foundCourseCategory.get());
        newCourse.setDescription(course.getDescription());
        newCourse.setStartDate(course.getStartDate());
        newCourse.setEndDate(course.getEndDate());
        
        return this.courseRepo.save(newCourse);
    }
}
