package kodlama.io.DevsLang.business.concretes;

import kodlama.io.DevsLang.business.abstracts.FrameworkService;
import kodlama.io.DevsLang.business.requests.CreateFrameworkRequest;
import kodlama.io.DevsLang.business.responses.GetFrameworkResponse;
import kodlama.io.DevsLang.dataAccess.abstracts.FrameworkRepository;
import kodlama.io.DevsLang.dataAccess.abstracts.LangRepository;
import kodlama.io.DevsLang.entities.concretes.Language;
import kodlama.io.DevsLang.entities.concretes.LanguageTech;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FrameworkManager implements FrameworkService {

    private FrameworkRepository frameworkRepository;
    private LangRepository languageRepository;

    @Autowired
    public FrameworkManager(FrameworkRepository frameworkRepository, LangRepository languageRepository) {

        this.frameworkRepository = frameworkRepository;
        this.languageRepository = languageRepository;
    }

    @Override
    public List<GetFrameworkResponse> getAll() {
        List<LanguageTech> prFramework = frameworkRepository.findAll();
        List<GetFrameworkResponse> getLanguageResponses = new ArrayList<>();
        for (LanguageTech framework : prFramework) {
            GetFrameworkResponse addItem = new GetFrameworkResponse();
            addItem.setId(framework.getId());
            addItem.setName(framework.getTechnologyName());
            addItem.setLanguage_id(framework.getLanguages().getId());
            getLanguageResponses.add(addItem);
        }
        return getLanguageResponses;
    }

    @Override
    public void add(CreateFrameworkRequest createFrameworkRequest) {
        List<Language> languages = languageRepository.findAll();
        LanguageTech frameWork = new LanguageTech();
        for (Language programingLanguage : languages) {
            if(programingLanguage.getId() == createFrameworkRequest.getLanguage_id()) {
                frameWork.setTechnologyName(createFrameworkRequest.getName());
                frameWork.setLanguages(programingLanguage);
                frameworkRepository.save(frameWork);
            }
        }
    }
    @Override
    public void delete(int id) throws Exception {
        frameworkRepository.deleteById(id);
    }

    @Override
    public void udpate(GetFrameworkResponse getLanguageResponse) throws Exception {

        List<LanguageTech> framework = frameworkRepository.findAll();

        GetFrameworkResponse frameworkResponse = new GetFrameworkResponse();
        for (LanguageTech languageTech : framework) {

            if(getLanguageResponse.getId() == languageTech.getId()) {
                frameworkResponse.setLanguage_id(getLanguageResponse.getLanguage_id());
                frameworkResponse.setName(getLanguageResponse.getName());
                frameworkRepository.save(languageTech);
            }
        }
    }
    @Override
    public List<GetFrameworkResponse> getById(int id) {
        List<LanguageTech> frameworks = frameworkRepository.findAll();
        List<GetFrameworkResponse> frameworkResponses = new ArrayList<GetFrameworkResponse>();

        for (LanguageTech getLanguageTech : frameworks) {
            GetFrameworkResponse response = new GetFrameworkResponse();
            if(getLanguageTech.getId() == id) {

                response.setId(getLanguageTech.getId());
                response.setName(getLanguageTech.getTechnologyName());
                response.setLanguage_id(getLanguageTech.getLanguages().getId());

            }
            frameworkResponses.add(response);
        }
        return frameworkResponses;
    }
}