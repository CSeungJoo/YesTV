package kr.pah.pcs.yestv.domain.location.service;

import kr.pah.pcs.yestv.domain.location.domain.Location;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface LocationService {
    Location createLocation(Location location);
    Location getLocationByIdx(int idx);
    Page<Location> getLocations(Pageable pageable);
    Location updateLocation(Location location);
    void deleteLocation(int idx);
}
