package lk.ac.kln.lms.repo;

import lk.ac.kln.lms.domain.AppUser;
import lk.ac.kln.lms.domain.Evaluation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EvaluationRepo extends CrudRepository<Evaluation, Long> {

    Iterable<Evaluation> findByStudent(final AppUser student);

}
