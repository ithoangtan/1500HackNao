package StudyEnglish.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import StudyEnglish.model.Myvocabulary;

public interface MyvocabularyRepository extends CrudRepository<Myvocabulary, Integer> {

}