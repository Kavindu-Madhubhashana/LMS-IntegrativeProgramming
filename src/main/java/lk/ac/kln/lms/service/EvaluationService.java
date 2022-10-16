package lk.ac.kln.lms.service;

import lk.ac.kln.lms.domain.Evaluation;
import lk.ac.kln.lms.dto.CreateEvaluationDto;
import lk.ac.kln.lms.dto.GetEvaluationsDto;

import java.util.Optional;

public interface EvaluationService {

    Optional<Evaluation> makeEvaluation(CreateEvaluationDto evaluationInfo) throws Exception;

    Iterable<Evaluation> allEvaluationsByStudentID(GetEvaluationsDto studentId) throws Exception;

}
