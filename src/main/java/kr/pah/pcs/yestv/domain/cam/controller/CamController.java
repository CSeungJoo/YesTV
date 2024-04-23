package kr.pah.pcs.yestv.domain.cam.controller;

import jakarta.validation.Valid;
import kr.pah.pcs.yestv.domain.cam.domain.Cam;
import kr.pah.pcs.yestv.domain.cam.dto.CreateCamDto;
import kr.pah.pcs.yestv.domain.cam.dto.ReturnCamDto;
import kr.pah.pcs.yestv.domain.cam.dto.UpdateCamDto;
import kr.pah.pcs.yestv.domain.cam.service.CamService;
import kr.pah.pcs.yestv.domain.location.domain.Location;
import kr.pah.pcs.yestv.domain.location.service.LocationService;
import kr.pah.pcs.yestv.global.util.Result;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cam")
public class CamController {

    private final CamService camService;
    private final LocationService locationService;

    @GetMapping("/getCam/{idx}")
    public ResponseEntity<?> getCam(@Valid @PathVariable Integer idx) {
        Cam cam = camService.getCamByIdx(idx);

        ReturnCamDto returnCamDto = new ReturnCamDto(cam);

        return ResponseEntity.ok(new Result<>(returnCamDto, false));
    }

    @GetMapping("/getCam/{locationIdx}")
    public ResponseEntity<?> getCamsByLocation(@Valid @PathVariable Integer locationIdx) {
        Location location = locationService.getLocationByIdx(locationIdx);
        List<Cam> cams = camService.getCamsByLocation(location);

        List<ReturnCamDto> returnCamDtos = cams.stream()
                .map(ReturnCamDto::new)
                .toList();

        return ResponseEntity.ok(new Result<>(returnCamDtos, false));
    }

    @PostMapping("/create")
    public ResponseEntity<?> createCam(@Valid @RequestBody CreateCamDto createCamDto) {
        Cam cam = camService.createCam(createCamDto);

        return ResponseEntity.ok(new Result<>(cam, false));
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateCam(@Valid @RequestBody UpdateCamDto updateCamDto) {
        Cam cam = camService.getCamByIdx(updateCamDto.getIdx());

        cam.modifiedCam(cam.getName(), cam.getIp());

        camService.updateCamBy(cam);

        return ResponseEntity.ok(new Result<>(cam, false));
    }
}
