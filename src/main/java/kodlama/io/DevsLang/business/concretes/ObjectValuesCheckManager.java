package kodlama.io.DevsLang.business.concretes;

import kodlama.io.DevsLang.business.abstracts.ObjectValuesCheckService;
import kodlama.io.DevsLang.dataAccess.abstracts.LangRepository;
import kodlama.io.DevsLang.entities.concretes.Language;
import org.springframework.stereotype.Service;

@Service
public class ObjectValuesCheckManager implements ObjectValuesCheckService {
    LangRepository languageRepository;

    public ObjectValuesCheckManager(LangRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    @Override
    public void isLanguageId(int id) throws Exception {
        boolean result = false;
        for (Language language : this.languageRepository.findAll()) {
            if (id == language.getId()) {
                result = true;
            }
        }
        if (result != true) {
            throw new Exception("Id Bulunamadı");
        }
    }

    @Override
    public void isLanguageName(String name) throws Exception {

        for (Language language : this.languageRepository.findAll()) {
            if (name.equals(language.getName())) {
                throw new Exception("Girilen Programlama Dili Mevcut");
            }
        }

    }

}

