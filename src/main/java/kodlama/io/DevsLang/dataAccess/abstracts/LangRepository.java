package kodlama.io.DevsLang.dataAccess.abstracts;

import kodlama.io.DevsLang.business.responses.GetAllLanguageResponse;
import kodlama.io.DevsLang.entities.concretes.Language;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LangRepository extends JpaRepository<Language,Integer>{

}
