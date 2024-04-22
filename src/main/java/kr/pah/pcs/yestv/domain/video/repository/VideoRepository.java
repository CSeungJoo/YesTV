package kr.pah.pcs.yestv.domain.video.repository;

import kr.pah.pcs.yestv.domain.location.domain.Location;
import kr.pah.pcs.yestv.domain.video.domain.Video;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface VideoRepository extends JpaRepository<Video, Integer> {
    List<Video> findAllByStartTimeBetweenAndEndTime(LocalDateTime startTime, LocalDateTime endTime);

    Page<Video> findAllByLocation(Location location, Pageable pageable);
}
