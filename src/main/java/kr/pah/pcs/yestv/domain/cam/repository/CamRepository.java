package kr.pah.pcs.yestv.domain.cam.repository;

import kr.pah.pcs.yestv.domain.cam.domain.Cam;
import kr.pah.pcs.yestv.domain.location.domain.Location;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CamRepository extends JpaRepository<Cam, Integer> {
    List<Cam> findAllByLocation(Location location);
}
