package lk.ac.kln.lms.controller;


import lk.ac.kln.lms.domain.Enrollment;
import lk.ac.kln.lms.domain.Evaluation;
import lk.ac.kln.lms.dto.CreateEvaluationDto;
import lk.ac.kln.lms.dto.GetEvaluationsDto;
import lk.ac.kln.lms.dto.NewEnrollmentDto;
import lk.ac.kln.lms.service.EvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@Controller
@RequestMapping("evaluation")
public class EvaluationController {

    @Autowired
    EvaluationService evaluationService;

    @PostMapping("save")
    public ResponseEntity<Optional<Evaluation>> saveEvaluation(@RequestBody CreateEvaluationDto evaluationDto) {
        try {
            Optional<Evaluation> savedEvaluation = evaluationService.makeEvaluation(evaluationDto);
            if(savedEvaluation.isPresent()) {
                return new ResponseEntity<>(savedEvaluation, HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>(Optional.empty(), HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(Optional.empty(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("all")
    public ResponseEntity<Iterable<Evaluation>> getAllEvaluations(@RequestBody GetEvaluationsDto evaluationDto ) {

        try{
            Iterable<Evaluation> getAllEvaluations = evaluationService.allEvaluationsByStudentID(evaluationDto);
            return new ResponseEntity<>(getAllEvaluations, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
        }


    }

}




