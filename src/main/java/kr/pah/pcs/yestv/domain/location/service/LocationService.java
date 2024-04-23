package kr.pah.pcs.yestv.domain.location.service;

import kr.pah.pcs.yestv.domain.location.domain.Location;
import kr.pah.pcs.yestv.domain.location.dto.CreateLocationDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface LocationService {
    Location createLocation(CreateLocationDto createLocationDto);
    Location getLocationByIdx(int idx);
    Page<Location> getLocations(Pageable pageable);
    Location updateLocation(Location location);
    void deleteLocation(int idx);
}
