package kodlama.io.DevsLang.business.concretes;

import kodlama.io.DevsLang.business.abstracts.LangService;
import kodlama.io.DevsLang.business.requests.CreateLanguageRequest;
import kodlama.io.DevsLang.business.responses.GetAllLanguageResponse;
import kodlama.io.DevsLang.business.responses.GetFrameworkResponse;
import kodlama.io.DevsLang.dataAccess.abstracts.FrameworkRepository;
import kodlama.io.DevsLang.dataAccess.abstracts.LangRepository;
import kodlama.io.DevsLang.entities.concretes.Language;
import kodlama.io.DevsLang.entities.concretes.LanguageTech;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LangManager extends ObjectValuesCheckManager implements LangService {

    LangRepository programingLanguageRepository;
    FrameworkRepository frameworkRepository;

    public LangManager(LangRepository languageRepository,
                       LangRepository programingLanguageRepository, FrameworkRepository frameworkRepository) {
        super(languageRepository);
        this.programingLanguageRepository = programingLanguageRepository;
        this.frameworkRepository = frameworkRepository;
    }

    @Override
    public List<GetAllLanguageResponse> getAll() {
        List<Language> languages = programingLanguageRepository.findAll();
        List<LanguageTech> frameworks = frameworkRepository.findAll();
        List<GetAllLanguageResponse> getLanguageResponses = new ArrayList<>();
        //List<GetFrameworkResponse> frameworkResponses = new ArrayList<>();

        for (Language language : languages) {
            List<GetFrameworkResponse> frameworkResponses = new ArrayList<>();
            GetAllLanguageResponse addItem = new GetAllLanguageResponse();

            addItem.setId(language.getId());
            addItem.setName(language.getName());

            addItem.setFrameworks(frameworkResponses);

            getLanguageResponses.add(addItem);
            for (LanguageTech framework : frameworks) {
                if (addItem.getId() == framework.getLanguages().getId()) {
                    GetFrameworkResponse addItem1 = new GetFrameworkResponse();
                    addItem1.setId(framework.getId());
                    addItem1.setName(framework.getTechnologyName());
                    addItem1.setLanguage_id(framework.getLanguages().getId());
                    frameworkResponses.add(addItem1);
                }
            }
        }

        return getLanguageResponses;

    }
    @Override
    public void add(CreateLanguageRequest createLanguageRequest) throws Exception {
        Language language1 = new Language();
        isLanguageName(createLanguageRequest.getName());
        if (createLanguageRequest.getName().isEmpty()) {
            throw new Exception("Programlama Dili Alanı Boş Olamaz!!!");
        }

        language1.setName(createLanguageRequest.getName());

        programingLanguageRepository.save(language1);
    }

    @Override
    public void delete(int id) throws Exception {
        isLanguageId(id);
        programingLanguageRepository.delete(programingLanguageRepository.getReferenceById(id));

    }

    @Override
    public void update(GetAllLanguageResponse getLanguageResponse) throws Exception {
        isLanguageId(getLanguageResponse.getId());
        isLanguageName(getLanguageResponse.getName());
        Language language = programingLanguageRepository.getReferenceById(getLanguageResponse.getId());
        language.setName(getLanguageResponse.getName());

        programingLanguageRepository.save(language);

    }

}
