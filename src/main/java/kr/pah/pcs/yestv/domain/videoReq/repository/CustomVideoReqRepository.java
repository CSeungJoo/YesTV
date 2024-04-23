package kr.pah.pcs.yestv.domain.videoReq.repository;

import kr.pah.pcs.yestv.domain.videoReq.domain.VideoReq;

import java.time.LocalDateTime;
import java.util.List;

public interface CustomVideoReqRepository {
    List<VideoReq> findAllByStartTimeBetweenEndTime(LocalDateTime startTime, LocalDateTime endTime);

}
