package lk.ac.kln.lms.controller;


import lk.ac.kln.lms.domain.Evaluation;
import lk.ac.kln.lms.dto.CreateEvaluationDto;
import lk.ac.kln.lms.service.EvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

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

}


