package guru.springframework.sdjpainheritence.domain.tableperclass;

import jakarta.persistence.Entity;

/**
 * Created by jd birla on 25-04-2023 at 15:21
 */
@Entity
public class Dolphin extends Mammal {

    private Boolean hasSpots;

    public Boolean getHasSpots() {
        return hasSpots;
    }

    public void setHasSpots(Boolean hasSpots) {
        this.hasSpots = hasSpots;
    }
}
