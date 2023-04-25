package guru.springframework.sdjpainheritence.domain.jointable;

import jakarta.persistence.Entity;

/**
 * Created by jd birla on 25-04-2023 at 15:33
 */
@Entity
public class Guitar extends Instrument {

    private Integer numberOfStrings;

    public Integer getNumberOfStrings() {
        return numberOfStrings;
    }

    public void setNumberOfStrings(Integer numberOfStrings) {
        this.numberOfStrings = numberOfStrings;
    }
}