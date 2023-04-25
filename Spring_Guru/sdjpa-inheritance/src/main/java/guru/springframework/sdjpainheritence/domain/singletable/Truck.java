package guru.springframework.sdjpainheritence.domain.singletable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

/**
 * Created by jd birla on 25-04-2023 at 15:29
 */
@Entity
@DiscriminatorValue("truck")
public class Truck extends Vehicle{

    private Integer payload;

    public Integer getPayload() {
        return payload;
    }

    public void setPayload(Integer payload) {
        this.payload = payload;
    }
}