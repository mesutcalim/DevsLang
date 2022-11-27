package kodlama.io.DevsLang.webApi.controllers;

import kodlama.io.DevsLang.business.abstracts.LangService;
import kodlama.io.DevsLang.business.requests.CreateLanguageRequest;
import kodlama.io.DevsLang.business.responses.GetAllLanguageResponse;
import kodlama.io.DevsLang.entities.concretes.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/programinglanguages")
public class LanguageController {
    private LangService langService;

    @Autowired
    public LanguageController(LangService languageService) {
        this.langService = languageService;
    }

    @GetMapping("/getall")
    public List<GetAllLanguageResponse> getAll() {
        return langService.getAll();
    }

    @PostMapping("/add")
    public void add(CreateLanguageRequest createLanguageRequest) throws Exception {
        langService.add(createLanguageRequest);
    }

    @DeleteMapping("/delete")
    public void delete(int id) throws Exception {
        langService.delete(id);
    }
    @PutMapping("/update")
    public void update(GetAllLanguageResponse getLanguageResponse) throws Exception {
        langService.update(getLanguageResponse);
    }


}
