package kodlama.io.DevsLang.webApi.controllers;


import kodlama.io.DevsLang.business.abstracts.FrameworkService;
import kodlama.io.DevsLang.business.requests.CreateFrameworkRequest;
import kodlama.io.DevsLang.business.responses.GetFrameworkResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/framework")
public class FrameworkController {

    private FrameworkService frameworkService;

    @Autowired
    public FrameworkController(FrameworkService frameworkService) {

        this.frameworkService = frameworkService;
    }

    @GetMapping("/getall")
    public List<GetFrameworkResponse> getAll() {
        return frameworkService.getAll();

    }
    @GetMapping("/getbyid")
    public List<GetFrameworkResponse> getById(int id){
        return frameworkService.getById(id);
    }

    @PostMapping("/add")
    public void add(CreateFrameworkRequest createFrameworkRequest) {
        frameworkService.add(createFrameworkRequest);

    }

    @PutMapping("/update")
    public void update(GetFrameworkResponse framework) throws Exception {
        frameworkService.udpate(framework);
    }

    @DeleteMapping("/delete")
    public void delete(int id) throws Exception {
        frameworkService.delete(id);
    }

}
