package guru.springframework.sdjpainheritence.repository;

import guru.springframework.sdjpainheritence.domain.jointable.ElectricGuitar;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by jd birla on 25-04-2023 at 15:41
 */
public interface ElectricGuitarRepository extends JpaRepository<ElectricGuitar,Long> {
}
