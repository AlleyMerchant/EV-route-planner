package com.routeplanner.routerplannerapi.android.studio.evrouter;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "api/v1/route")
@AllArgsConstructor
public class EvRouteController {
    private final EvRouteService routeService;

    @PostMapping("/save")
    public void saveRouteForUser(@RequestBody EvRouteRequest request) {
        routeService.save(request);
    }

    @GetMapping(value = "/get")
    public EvChargerRoute getRouteForUser2(@RequestBody EvRouteRequest request) {
        return routeService.get(request);
    }

    @GetMapping(path = "/getAll")
    public ResponseEntity<EvChargerRoute[]> getAllRoutesForUser(@RequestParam("userId") String userId) {
        return routeService.getAll(userId);
    }

}

