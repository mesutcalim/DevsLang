package kodlama.io.DevsLang.dataAccess.abstracts;

import kodlama.io.DevsLang.entities.concretes.LanguageTech;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FrameworkRepository extends JpaRepository<LanguageTech, Integer> {

}
