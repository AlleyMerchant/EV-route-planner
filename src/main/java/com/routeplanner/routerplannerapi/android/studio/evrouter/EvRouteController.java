package com.routeplanner.routerplannerapi.android.studio.evrouter;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping(path = "api/v1/route")
public class EvRouteController {
    private final EvRouteService routeService;


    @PostMapping("/create")
    public void saveRouteForUser(@RequestBody CreateRouteRequest request) {
        routeService.saveNewRoute(request);
    }

    @PostMapping("/update")
    public void updateRouteForUser(@RequestBody UpdateRouteRequest request) {
        routeService.updateRoute(request);
    }

    @GetMapping(path = "/delete")
    public void deleteRoute(@RequestParam("routeId") UUID routeId) {
        routeService.delete(routeId);
    }

    @GetMapping(value = "/get")
    public EvRouteResponse getRouteForUser2(@RequestBody EvRouteRequest request) {
        return routeService.get(request);
    }

    @GetMapping(path = "/getAll")
    public ResponseEntity<List<EvChargerRoute>> getAllRoutesForUser(@RequestParam("userId") UUID userId) {
        return routeService.getAll(userId);
    }

}

