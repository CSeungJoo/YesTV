package kr.pah.pcs.yestv.domain.videoReq.service;

import kr.pah.pcs.yestv.domain.location.domain.Location;
import kr.pah.pcs.yestv.domain.video.domain.Video;
import kr.pah.pcs.yestv.domain.videoReq.domain.VideoReq;
import kr.pah.pcs.yestv.domain.videoReq.dto.CreateVideoReqDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.util.List;

public interface VideoReqService {
    VideoReq createVideoReq(CreateVideoReqDto createVideoReqDto);
    VideoReq getVideoReqByIdx(int idx);
    List<VideoReq> getVideosReqByStartTimeBetweenEndTime(LocalDateTime startTime, LocalDateTime endTime);
    Page<VideoReq> getVideoReqsByLocation(Location location, Pageable pageable);
    VideoReq updateVideoReq(VideoReq videoReq);
    void deleteVideoReq(int idx);
}
