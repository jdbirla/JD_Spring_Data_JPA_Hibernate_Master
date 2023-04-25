package guru.springframework.sdjpainheritence.domain.singletable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

/**
 * Created by jd birla on 25-04-2023 at 15:28
 */
@Entity
@DiscriminatorValue("car")
public class Car extends Vehicle{

    private String trimLevel;

    public String getTrimLevel() {
        return trimLevel;
    }

    public void setTrimLevel(String trimLevel) {
        this.trimLevel = trimLevel;
    }
}