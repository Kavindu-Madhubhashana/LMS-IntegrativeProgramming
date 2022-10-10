package lk.ac.kln.lms.service;

import lk.ac.kln.lms.domain.CourseCategory;
import lk.ac.kln.lms.dto.CreateCourseCategoryDto;
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
        return courseCategoryRepo.findByCourseCategory(categoryName);
    }

    @Override
    public Boolean updateCourseCategory(UpdateCourseCategoryDto courseCategoryInfo) {
        Optional<CourseCategory> foundCourseCategory = this.courseCategoryRepo.findById(courseCategoryInfo.getId());
        if(foundCourseCategory.isEmpty()) {
            return false;
        }
        foundCourseCategory = this.courseCategoryRepo.findByCourseCategory(courseCategoryInfo.getCourseCategory());
        if(foundCourseCategory.isPresent()) {
            return false;
        }
        CourseCategory courseCategory = new CourseCategory(courseCategoryInfo.getId(), courseCategoryInfo.getCourseCategory());
        CourseCategory updatedCourseCategory = this.courseCategoryRepo.save(courseCategory);
        return true;
    }

    @Override
    public Optional<CourseCategory> saveCourseCategory(CreateCourseCategoryDto courseCategoryInfo) {
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
