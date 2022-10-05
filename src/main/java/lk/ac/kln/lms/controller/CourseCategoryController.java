package lk.ac.kln.lms.controller;

import lk.ac.kln.lms.domain.CourseCategory;
import lk.ac.kln.lms.dto.UpdateCourseCategoryDto;
import lk.ac.kln.lms.service.CourseCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/coursecategory")
public class CourseCategoryController {

    @Autowired
    private CourseCategoryService courseCategoryService;

    @GetMapping("")
    public ResponseEntity<Iterable<CourseCategory>> getAllCourseCategories() {
        return new ResponseEntity<>(courseCategoryService.allCourseCategories(), HttpStatus.ACCEPTED);
    }

    @GetMapping("name")
    public ResponseEntity<Optional<CourseCategory>> getCourseCategoryByCategoryName(@RequestBody String categoryName) {
        return new ResponseEntity<>(courseCategoryService.getCourseCategoryByCategoryName(categoryName), HttpStatus.ACCEPTED);
    }

    @PostMapping("create")
    public ResponseEntity<Optional<CourseCategory>> saveCourseCategory(@RequestBody UpdateCourseCategoryDto courseCategoryInfo) {
        return new ResponseEntity<>(courseCategoryService.saveCourseCategory(courseCategoryInfo), HttpStatus.ACCEPTED);
    }

}
