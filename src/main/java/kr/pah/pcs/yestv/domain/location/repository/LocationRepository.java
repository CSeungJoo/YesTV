package kr.pah.pcs.yestv.domain.location.repository;

import kr.pah.pcs.yestv.domain.location.domain.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Integer> {
}
