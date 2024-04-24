package kr.pah.pcs.yestv.domain.videoReq.controller;

import jakarta.validation.Valid;
import kr.pah.pcs.yestv.domain.location.domain.Location;
import kr.pah.pcs.yestv.domain.location.service.LocationService;
import kr.pah.pcs.yestv.domain.videoReq.domain.VideoReq;
import kr.pah.pcs.yestv.domain.videoReq.dto.CreateVideoReqDto;
import kr.pah.pcs.yestv.domain.videoReq.dto.ReturnVideoReqDto;
import kr.pah.pcs.yestv.domain.videoReq.service.VideoReqService;
import kr.pah.pcs.yestv.global.common.Result;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/video-req")
public class VideoReqController {

    private final VideoReqService videoReqService;
    private final LocationService locationService;

    @GetMapping("/get-video-req/{idx}")
    public ResponseEntity<?> getVideoReq(@Valid @PathVariable int idx) {
        try {

            VideoReq videoReq = videoReqService.getVideoReqByIdx(idx);

            ReturnVideoReqDto returnVideoReqDto = new ReturnVideoReqDto(videoReq);

            return ResponseEntity.ok(new Result<>(returnVideoReqDto));
        }catch (IllegalStateException e) {
            return ResponseEntity.ok(new Result<>(e.getMessage(), true));
        }
    }

    @GetMapping("/get-video-reqs-by-time")
    public ResponseEntity<?> getVideoReqByStartTimeBetweenEndTime(
            @Valid @RequestParam LocalDateTime startTime,
            @Valid @RequestParam LocalDateTime endTime) {
        try {
            List<VideoReq> videoReqs = videoReqService.getVideosReqByStartTimeBetweenEndTime(startTime, endTime);

            List<ReturnVideoReqDto> returnVideoReqDtos = videoReqs.stream()
                    .map(ReturnVideoReqDto::new)
                    .toList();

            return ResponseEntity.ok(new Result<>(returnVideoReqDtos));
        }catch (IllegalStateException e) {
            return ResponseEntity.ok(new Result<>(e.getMessage()));
        }
    }

    @GetMapping("/get-video-reqs-by-location/{locationIdx}")
    public ResponseEntity<?> getVideoReqsByLocation(@Valid @PathVariable int locationIdx, @PageableDefault Pageable pageable) {
        try {
            Location location = locationService.getLocationByIdx(locationIdx);

            Page<VideoReq> videoReqs = videoReqService.getVideoReqsByLocation(location, pageable);

            List<ReturnVideoReqDto> returnVideoReqDtos = videoReqs.stream()
                    .map(ReturnVideoReqDto::new)
                    .toList();

            return ResponseEntity.ok(new Result<>(returnVideoReqDtos));
        }catch (IllegalStateException e) {
            return ResponseEntity.ok(new Result<>(e.getMessage(), true));
        }
    }

    @PostMapping("/create")
    public ResponseEntity<?> createVideoReq(@Valid @RequestBody CreateVideoReqDto createVideoReqDto) {
        VideoReq videoReq = videoReqService.createVideoReq(createVideoReqDto);

        return ResponseEntity.ok(new Result<>("정상적으로 생성되었습니다."));
    }

    @DeleteMapping("/delete/{idx}")
    public ResponseEntity<?> deleteVideoReq(@Valid @PathVariable int idx) {
            videoReqService.deleteVideoReq(idx);

            return ResponseEntity.ok(new Result<>("정상적으로 삭제되었습니다."));
    }
}
