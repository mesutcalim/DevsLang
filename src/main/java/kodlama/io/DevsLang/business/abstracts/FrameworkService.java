package kodlama.io.DevsLang.business.abstracts;

import kodlama.io.DevsLang.business.requests.CreateFrameworkRequest;
import kodlama.io.DevsLang.business.responses.GetFrameworkResponse;

import java.util.List;

public interface FrameworkService {
    void add(CreateFrameworkRequest createFrameworkRequest);
    void udpate(GetFrameworkResponse getFrameworkResponse) throws Exception;
    void delete(int id) throws Exception;
    List<GetFrameworkResponse> getAll();
    List<GetFrameworkResponse>getById(int id);

}
