package kr.pah.pcs.yestv.domain.video.controller;

import jakarta.validation.Valid;
import kr.pah.pcs.yestv.domain.cam.domain.Cam;
import kr.pah.pcs.yestv.domain.cam.service.CamService;
import kr.pah.pcs.yestv.domain.location.domain.Location;
import kr.pah.pcs.yestv.domain.location.service.LocationService;
import kr.pah.pcs.yestv.domain.video.domain.Video;
import kr.pah.pcs.yestv.domain.video.dto.ReturnVideoDto;
import kr.pah.pcs.yestv.domain.video.service.VideoService;
import kr.pah.pcs.yestv.global.util.Result;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/video")
public class VideoController {

    private final VideoService videoService;
    private final CamService camService;
    private final LocationService locationService;

    @GetMapping("/get-video/{idx}")
    public ResponseEntity<?> getVideo(@Valid @PathVariable int idx) {
        try {

            byte[] video = videoService.getVideoFileByIdx(idx);

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            headers.setContentDispositionFormData("attachment", "video.mp4");

            return new ResponseEntity<>(new Result<>(video), headers, HttpStatus.OK);
        }catch (IllegalStateException e) {
            return ResponseEntity.ok(new Result<>(e.getMessage(), true));
        }
    }

    @GetMapping("/get-videos")
    public ResponseEntity<?> getVideosByStartTimeAndEndTime(
            @RequestParam LocalDateTime startTime,
            @RequestParam LocalDateTime endTime) {

        try {
            List<Video> videos = videoService.getVideosByStartTimeBetweenEndTime(startTime, endTime);

            List<ReturnVideoDto> returnVideoDtos = videos.stream()
                    .map(v -> new ReturnVideoDto(v.getIdx(), v.getCam().getDetailedLocation(), v.getStartTime(), v.getEndTime(), v.getLocation().getName()))
                    .toList();

            return ResponseEntity.ok(new Result<>(returnVideoDtos));
        }catch (IllegalStateException e) {
            return ResponseEntity.ok(new Result<>(e.getMessage(), true));
        }

    }

    @PostMapping("/create")
    public ResponseEntity<?> createVideo(
            @Valid @RequestParam("videoFile") MultipartFile videoFile,
            @Valid @RequestParam("camId") int camId) {
        try {
            Cam cam = camService.getCamByIdx(camId);

            Video video = videoService.createVideo(videoFile, cam);

            ReturnVideoDto returnVideoDto = new ReturnVideoDto(video);

            return ResponseEntity.ok(new Result<>(returnVideoDto));
        }catch (IllegalStateException e) {
            return ResponseEntity.ok(new Result<>(e.getMessage(), true));
        }
    }

    @GetMapping("/get-location-by-location-idx/{locationIdx}")
    public ResponseEntity<?> getVideosByLocation(@PathVariable("locationIdx") int locationIdx, @PageableDefault Pageable pageable) {
        try {

            Location location = locationService.getLocationByIdx(locationIdx);

            Page<Video> videos = videoService.getVideosByLocation(location, pageable);

            List<ReturnVideoDto> returnVideoDtos = videos.stream()
                    .map(ReturnVideoDto::new)
                    .toList();

            return ResponseEntity.ok(new Result<>(returnVideoDtos));
        }catch (IllegalStateException e) {
            return ResponseEntity.ok(new Result<>(e.getMessage(), true));
        }
    }

    @DeleteMapping("/delete-video/{idx}")
    public ResponseEntity<?> deleteVideo(@PathVariable int idx) {
        try {
            videoService.deleteVideo(idx);

            return ResponseEntity.ok(new Result<>("정상적으로 처리되었습니다."));
        }catch (IllegalStateException e) {
            return ResponseEntity.ok(new Result<>(e.getMessage(), true));
        }
    }

}
