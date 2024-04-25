package kr.pah.pcs.yestv.domain.cam.controller;

import jakarta.validation.Valid;
import kr.pah.pcs.yestv.domain.cam.domain.Cam;
import kr.pah.pcs.yestv.domain.cam.dto.CreateCamDto;
import kr.pah.pcs.yestv.domain.cam.dto.ReturnCamDto;
import kr.pah.pcs.yestv.domain.cam.dto.UpdateCamDto;
import kr.pah.pcs.yestv.domain.cam.service.CamService;
import kr.pah.pcs.yestv.domain.location.domain.Location;
import kr.pah.pcs.yestv.domain.location.service.LocationService;
import kr.pah.pcs.yestv.global.common.Result;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cam")
public class CamController {

    private final CamService camService;
    private final LocationService locationService;

    @GetMapping("/get-cam/{idx}")
    public ResponseEntity<?> getCam(@Valid @PathVariable Integer idx) {
        try {

            Cam cam = camService.getCamByIdx(idx);

            ReturnCamDto returnCamDto = new ReturnCamDto(cam);

            return ResponseEntity.ok(new Result<>(returnCamDto));
        }catch (IllegalStateException e) {
            return ResponseEntity.ok(new Result<>(e.getMessage(), true));
        }
    }

    @GetMapping("/get-cam-by-location/{locationIdx}")
    public ResponseEntity<?> getCamsByLocation(@Valid @PathVariable Integer locationIdx) {
        try {

            Location location = locationService.getLocationByIdx(locationIdx);
            List<Cam> cams = camService.getCamsByLocation(location);

            List<ReturnCamDto> returnCamDtos = cams.stream()
                    .map(ReturnCamDto::new)
                    .toList();

            return ResponseEntity.ok(new Result<>(returnCamDtos));
        }catch (IllegalStateException e) {
            return ResponseEntity.ok(new Result<>(e.getMessage(), true));
        }
    }

    @PostMapping("/create")
    public ResponseEntity<?> createCam(@Valid @RequestBody CreateCamDto createCamDto) {
        try {

            Cam cam = camService.createCam(createCamDto);

            return ResponseEntity.ok(new Result<>(cam));
        }catch (IllegalStateException e) {
            return ResponseEntity.ok(new Result<>(e.getMessage(), true));
        }
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateCam(@Valid @RequestBody UpdateCamDto updateCamDto) {
        try {

            Cam cam = camService.getCamByIdx(updateCamDto.getIdx());

            cam.modifiedCam(cam.getName(), cam.getIp());

            camService.updateCamBy(cam);

            return ResponseEntity.ok(new Result<>(cam));
        }catch (IllegalStateException e) {
            return ResponseEntity.ok(new Result<>(e.getMessage(), true));
        }
    }
}
