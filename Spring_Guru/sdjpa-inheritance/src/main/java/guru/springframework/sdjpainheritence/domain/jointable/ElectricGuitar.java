package guru.springframework.sdjpainheritence.domain.jointable;

import jakarta.persistence.Entity;

/**
 * Created by jd birla on 25-04-2023 at 15:34
 */
@Entity
public class ElectricGuitar extends Guitar{

    private Integer numberOfPickups;

    public Integer getNumberOfPickups() {
        return numberOfPickups;
    }

    public void setNumberOfPickups(Integer numberOfPickups) {
        this.numberOfPickups = numberOfPickups;
    }
}