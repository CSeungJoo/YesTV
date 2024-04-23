package kr.pah.pcs.yestv.domain.video.repository;

import kr.pah.pcs.yestv.domain.video.domain.Video;

import java.time.LocalDateTime;
import java.util.List;

public interface CustomVideoRepository {
    List<Video> findAllByStartTimeBetweenEndTime(LocalDateTime startTime, LocalDateTime endTime);

}
