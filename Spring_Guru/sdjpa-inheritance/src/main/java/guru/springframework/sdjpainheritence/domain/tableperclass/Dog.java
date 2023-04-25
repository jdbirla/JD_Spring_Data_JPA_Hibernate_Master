package guru.springframework.sdjpainheritence.domain.tableperclass;

import jakarta.persistence.Entity;

/**
 * Created by jd birla on 25-04-2023 at 15:21
 */
@Entity
public class Dog extends Mammal {

    private String breed;

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }
}