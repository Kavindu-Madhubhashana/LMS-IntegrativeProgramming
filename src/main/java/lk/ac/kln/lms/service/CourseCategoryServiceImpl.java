package lk.ac.kln.lms.service;

import lk.ac.kln.lms.domain.CourseCategory;
import lk.ac.kln.lms.dto.UpdateCourseCategoryDto;
import lk.ac.kln.lms.repo.CourseCategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CourseCategoryServiceImpl implements CourseCategoryService{

    @Autowired
    private CourseCategoryRepo courseCategoryRepo;

    @Override
    public Iterable<CourseCategory> allCourseCategories() {
        return courseCategoryRepo.findAll();
    }

    @Override
    public Optional<CourseCategory> getCourseCategoryByCategoryName(String categoryName) {
        Optional<CourseCategory> courseCategory = courseCategoryRepo.findByCourseCategory(categoryName);
        System.out.println(courseCategory);
        if(courseCategory.isPresent()) {
            return courseCategory;
        }
        return Optional.empty();
    }

    @Override
    public Boolean updateCourseCategory(int courseCategoryId, UpdateCourseCategoryDto courseCategoryInfo) {
        return null;
    }

    @Override
    public Optional<CourseCategory> saveCourseCategory(UpdateCourseCategoryDto courseCategoryInfo) {
        Optional<CourseCategory> foundCourseCategory = this.courseCategoryRepo.findByCourseCategory(courseCategoryInfo.getCourseCategory());
        if(foundCourseCategory.isEmpty()) {
            CourseCategory courseCategory = new CourseCategory();
            courseCategory.setCourseCategory(courseCategoryInfo.getCourseCategory());
            CourseCategory savedCourseCategory = this.courseCategoryRepo.save(courseCategory);
            return Optional.of(savedCourseCategory);
        } return Optional.empty();
    }

    @Override
    public Boolean removeCourseCategory(int courseCategoryId) {
        return null;
    }
}
