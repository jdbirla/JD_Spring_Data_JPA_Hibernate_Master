package guru.springframework.sdjpainheritence.domain.jointable;

import jakarta.persistence.Entity;

/**
 * Created by jd birla on 25-04-2023 at 15:33
 */
@Entity
public class Piano extends Instrument {

    private Integer numberOfKeys;

    public Integer getNumberOfKeys() {
        return numberOfKeys;
    }

    public void setNumberOfKeys(Integer numberOfKeys) {
        this.numberOfKeys = numberOfKeys;
    }
}