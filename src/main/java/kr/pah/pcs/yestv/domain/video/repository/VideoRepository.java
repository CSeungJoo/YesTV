package kr.pah.pcs.yestv.domain.video.repository;

import kr.pah.pcs.yestv.domain.location.domain.Location;
import kr.pah.pcs.yestv.domain.video.domain.Video;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface VideoRepository extends JpaRepository<Video, Integer>, CustomVideoRepository {
    Page<Video> findAllByLocation(Location location, Pageable pageable);
}
