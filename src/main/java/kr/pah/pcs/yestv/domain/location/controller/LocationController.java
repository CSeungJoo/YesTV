package kr.pah.pcs.yestv.domain.location.controller;

import jakarta.validation.Valid;
import kr.pah.pcs.yestv.domain.location.domain.Location;
import kr.pah.pcs.yestv.domain.location.dto.CreateLocationDto;
import kr.pah.pcs.yestv.domain.location.dto.ReturnLocationDto;
import kr.pah.pcs.yestv.domain.location.dto.UpdateLocationDto;
import kr.pah.pcs.yestv.domain.location.service.LocationService;
import kr.pah.pcs.yestv.global.common.Result;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/location")
public class LocationController {

    private final LocationService locationService;

    @GetMapping("/get-location/{idx}")
    public ResponseEntity<?> getLocationByIdx(@Valid @PathVariable int idx) {
        try {
            Location location = locationService.getLocationByIdx(idx);

            ReturnLocationDto returnLocationDto = ReturnLocationDto.builder()
                    .idx(location.getIdx())
                    .name(location.getName())
                    .build();

            return ResponseEntity.ok(new Result<>(returnLocationDto));
        }catch (IllegalStateException e) {
            return ResponseEntity.ok(new Result<>(e.getMessage(), true));
        }
    }

    @GetMapping("/get-locations")
    public ResponseEntity<?> getLocations(@PageableDefault Pageable pageable) {
        try {
            Page<Location> locations = locationService.getLocations(pageable);

            return ResponseEntity.ok(new Result<>(locations));
        }catch (IllegalStateException e) {
            return ResponseEntity.ok(new Result<>(e.getMessage(), true));
        }
    }

    @PostMapping("/create")
    public ResponseEntity<?> createLocation(@Valid @RequestBody CreateLocationDto createLocationDto) {
        try {

            Location location = locationService.createLocation(createLocationDto);

            ReturnLocationDto returnLocationDto = ReturnLocationDto.builder()
                    .idx(location.getIdx())
                    .name(location.getName())
                    .build();

            return ResponseEntity.ok(new Result<>(returnLocationDto));
        }catch (IllegalStateException e) {
            return ResponseEntity.ok(new Result<>(e.getMessage(), true));
        }
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateLocation(@RequestBody UpdateLocationDto updateLocationDto) {
        try {

            Location location = locationService.getLocationByIdx(updateLocationDto.getIdx());

            location.setName(updateLocationDto.getName());

            locationService.updateLocation(location);

            ReturnLocationDto returnLocationDto = ReturnLocationDto.builder()
                    .idx(location.getIdx())
                    .name(location.getName())
                    .build();

            return ResponseEntity.ok(new Result<>(returnLocationDto));
        }catch (IllegalStateException e) {
            return ResponseEntity.ok(new Result<>(e.getMessage(), true));
        }
    }

    @DeleteMapping("/delete/{idx}")
    public ResponseEntity<?> deleteLocation(@Valid @PathVariable int idx) {
        try {

            locationService.deleteLocation(idx);

            return ResponseEntity.ok(new Result<>("정상적으로 변경되었습니다."));
        }catch (IllegalStateException e) {
            return ResponseEntity.ok(new Result<>(e.getMessage(), true));
        }
    }
}
