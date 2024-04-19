package kr.pah.pcs.yestv.domain.cam.repository;

import kr.pah.pcs.yestv.domain.cam.domain.Cam;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CamRepository extends JpaRepository<Cam, Integer> {
}
