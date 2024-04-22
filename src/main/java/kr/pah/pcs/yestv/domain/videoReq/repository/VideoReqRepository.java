package kr.pah.pcs.yestv.domain.videoReq.repository;

import kr.pah.pcs.yestv.domain.location.domain.Location;
import kr.pah.pcs.yestv.domain.videoReq.domain.VideoReq;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface VideoReqRepository extends JpaRepository<VideoReq, Integer> {
    List<VideoReq> getVideosByStartTimeBetweenEndTime(LocalDateTime startTime, LocalDateTime endTime);

    Page<VideoReq> findByLocation(Location location, Pageable pageable);
}
