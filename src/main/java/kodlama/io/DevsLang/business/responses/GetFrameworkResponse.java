package kodlama.io.DevsLang.business.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GetFrameworkResponse {
    private int id;
    private String name;
    private int language_id;

}