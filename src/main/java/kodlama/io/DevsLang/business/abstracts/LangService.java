package kodlama.io.DevsLang.business.abstracts;

import kodlama.io.DevsLang.business.requests.CreateLanguageRequest;
import kodlama.io.DevsLang.business.responses.GetAllLanguageResponse;
import kodlama.io.DevsLang.entities.concretes.Language;

import javax.swing.*;
import java.util.List;

public interface   LangService {
    List<GetAllLanguageResponse> getAll();
    void add(CreateLanguageRequest createLanguageRequest) throws Exception;

    void delete(int id) throws Exception;

    void update(GetAllLanguageResponse getLanguageResponse) throws Exception;
}
