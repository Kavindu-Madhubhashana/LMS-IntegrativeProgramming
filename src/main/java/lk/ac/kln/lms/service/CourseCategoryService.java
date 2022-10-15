package lk.ac.kln.lms.service;

import lk.ac.kln.lms.domain.CourseCategory;
import lk.ac.kln.lms.dto.CreateCourseCategoryDto;
import lk.ac.kln.lms.dto.GetCourseCategoryDto;
import lk.ac.kln.lms.dto.UpdateCourseCategoryDto;

import java.util.Optional;

public interface CourseCategoryService {

    Iterable<CourseCategory> allCourseCategories();

    Optional<CourseCategory> getCourseCategoryByCategoryName(final GetCourseCategoryDto courseCategory);

    Optional<CourseCategory> getCourseCategoryById(final Long id);

    Boolean updateCourseCategory(final UpdateCourseCategoryDto courseCategoryInfo);

    Optional<CourseCategory> saveCourseCategory(final CreateCourseCategoryDto courseCategoryInfo);

    Boolean removeCourseCategory(final GetCourseCategoryDto courseCategory);
}
