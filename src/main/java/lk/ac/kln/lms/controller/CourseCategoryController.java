package lk.ac.kln.lms.controller;

import lk.ac.kln.lms.domain.CourseCategory;
import lk.ac.kln.lms.dto.CreateCourseCategoryDto;
import lk.ac.kln.lms.dto.UpdateCourseCategoryDto;
import lk.ac.kln.lms.service.CourseCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
        System.out.println(categoryName);
        return new ResponseEntity<>(courseCategoryService.getCourseCategoryByCategoryName(categoryName), HttpStatus.ACCEPTED);
    }

    @PostMapping("create")
    public ResponseEntity<Optional<CourseCategory>> saveCourseCategory(@RequestBody CreateCourseCategoryDto courseCategoryInfo) {
        Optional<CourseCategory> createdCourseCategory = courseCategoryService.saveCourseCategory(courseCategoryInfo);
        if(createdCourseCategory.isEmpty()){
            return new ResponseEntity<>(createdCourseCategory, HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(createdCourseCategory, HttpStatus.ACCEPTED);
    }

    @PutMapping("update")
    public ResponseEntity<Boolean> updateCourseCategory(@RequestBody UpdateCourseCategoryDto updateCourseCategoryInfo){
        if(courseCategoryService.updateCourseCategory(updateCourseCategoryInfo)) {
            return new ResponseEntity<>(true, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
    }

}
