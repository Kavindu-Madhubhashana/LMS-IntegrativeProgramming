package lk.ac.kln.lms.service;

import lk.ac.kln.lms.domain.Course;
import lk.ac.kln.lms.domain.CourseCategory;
import lk.ac.kln.lms.dto.CreateCourseCategoryDto;
import lk.ac.kln.lms.dto.GetCourseCategoryDto;
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
    public Optional<CourseCategory> getCourseCategoryByCategoryName(GetCourseCategoryDto categoryName) {
        return this.courseCategoryRepo.findByName(categoryName.getCategoryName());
    }

    @Override
    public Optional<CourseCategory> getCourseCategoryById(Long id) {
        return this.courseCategoryRepo.findById(id);
    }

    @Override
    public Boolean updateCourseCategory(UpdateCourseCategoryDto courseCategoryInfo) {
        Optional<CourseCategory> foundCourseCategory = this.courseCategoryRepo.findById(courseCategoryInfo.getId());
        if(foundCourseCategory.isEmpty()) {
            return false;
        }
        foundCourseCategory = this.courseCategoryRepo.findByName(courseCategoryInfo.getCourseCategory());
        if(foundCourseCategory.isPresent()) {
            return false;
        }
        CourseCategory courseCategory = new CourseCategory(courseCategoryInfo.getId(), courseCategoryInfo.getCourseCategory());
        this.courseCategoryRepo.save(courseCategory);
        return true;
    }

    @Override
    public Optional<CourseCategory> saveCourseCategory(CreateCourseCategoryDto courseCategoryInfo) {
        Optional<CourseCategory> foundCourseCategory = this.courseCategoryRepo.findByName(courseCategoryInfo.getCourseCategory());
        if(foundCourseCategory.isEmpty()) {
            CourseCategory courseCategory = new CourseCategory();
            courseCategory.setName(courseCategoryInfo.getCourseCategory());
            CourseCategory savedCourseCategory = this.courseCategoryRepo.save(courseCategory);
            return Optional.of(savedCourseCategory);
        } return Optional.empty();
    }

    @Override
    public Boolean removeCourseCategory(GetCourseCategoryDto courseCategory) {
        System.out.println(courseCategory.getCategoryName());


        Optional<CourseCategory> foundCourseCategory = this.courseCategoryRepo.findByName(courseCategory.getCategoryName());
        if(foundCourseCategory.isEmpty()) {
            return false;
        }
        System.out.println(foundCourseCategory.get());
        this.courseCategoryRepo.delete(foundCourseCategory.get());
        return true;
    }
}
