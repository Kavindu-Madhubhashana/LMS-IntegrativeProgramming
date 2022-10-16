package lk.ac.kln.lms.service;

import lk.ac.kln.lms.domain.AppUser;
import lk.ac.kln.lms.domain.Course;
import lk.ac.kln.lms.domain.Evaluation;
import lk.ac.kln.lms.dto.CreateEvaluationDto;
import lk.ac.kln.lms.dto.GetEvaluationsDto;
import lk.ac.kln.lms.repo.EvaluationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EvaluationServiceImpl implements EvaluationService{

    @Autowired AppUserService appUserService;

    @Autowired CourseService courseService;

    @Autowired EvaluationRepo evaluationRepo;

    @Override
    public Optional<Evaluation> makeEvaluation(CreateEvaluationDto evaluationInfo) throws Exception {
        Optional<AppUser> lecturer = appUserService.getAppUserById(evaluationInfo.getTeacherId());

        if(lecturer.isEmpty()) {
            throw new Exception("Teacher not found");
        }

        Optional<AppUser> student = appUserService.getAppUserById(evaluationInfo.getStudentId());

        if(student.isEmpty()){
            throw new Exception("Student not found");
        }

        Optional<Course> course = courseService.getCourseById(evaluationInfo.getCourseId());

        if(course.isEmpty()) {
            throw new Exception("Course not found");
        }

        Evaluation evaluation = new Evaluation();
        evaluation.setTeacher(lecturer.get());
        evaluation.setStudent(student.get());

        evaluation.setCourse(course.get());

        evaluation.setGrade(evaluationInfo.getGrade());


        return Optional.of(evaluationRepo.save(evaluation));
    }

    @Override
    public Iterable<Evaluation> allEvaluationsByStudentID(GetEvaluationsDto studentId) {
        return null;
    }
}
