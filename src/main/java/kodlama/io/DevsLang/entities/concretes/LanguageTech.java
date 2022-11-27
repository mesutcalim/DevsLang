package kodlama.io.DevsLang.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name= "technologies")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class LanguageTech {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String technologyName;

    @ManyToOne
    @JoinColumn(name = "language_id", nullable = false)
    private  Language languages;
}
