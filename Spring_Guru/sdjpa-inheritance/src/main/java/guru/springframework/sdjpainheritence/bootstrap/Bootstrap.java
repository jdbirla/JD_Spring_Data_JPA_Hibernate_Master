package guru.springframework.sdjpainheritence.bootstrap;

import guru.springframework.sdjpainheritence.domain.jointable.ElectricGuitar;
import guru.springframework.sdjpainheritence.repository.ElectricGuitarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Created by jd birla on 25-04-2023 at 15:40
 */
@Component
public class Bootstrap implements CommandLineRunner {

    @Autowired
    ElectricGuitarRepository electricGuitarRepository;

    @Override
    public void run(String... args) throws Exception {
        ElectricGuitar eg = new ElectricGuitar();
        eg.setNumberOfStrings(6);
        eg.setNumberOfPickups(2);
        electricGuitarRepository.save(eg);
    }
}