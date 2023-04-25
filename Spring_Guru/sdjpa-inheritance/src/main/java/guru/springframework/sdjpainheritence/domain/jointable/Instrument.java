package guru.springframework.sdjpainheritence.domain.jointable;

import jakarta.persistence.*;

/**
 * Created by jd birla on 25-04-2023 at 15:32
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Instrument {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

}