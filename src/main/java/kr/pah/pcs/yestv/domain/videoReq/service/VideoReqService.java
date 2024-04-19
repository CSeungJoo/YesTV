package kr.pah.pcs.yestv.domain.videoReq.service;

import kr.pah.pcs.yestv.domain.location.domain.Location;
import kr.pah.pcs.yestv.domain.video.domain.Video;
import kr.pah.pcs.yestv.domain.videoReq.domain.VideoReq;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface VideoReqService {
    VideoReq createVideoReq(VideoReq videoReq);
    VideoReq getVideoReqByIdx(int idx);
    List<VideoReq> getVideoReqsByStartTimeBetweenEndTime();
    Page<VideoReq> getVideoReqsByLocation(Location location, Pageable pageable);
    VideoReq updateVideoReq(VideoReq videoReq);
    void deleteVideoReq(int idx);
}
