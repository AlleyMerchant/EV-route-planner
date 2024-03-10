package com.routeplanner.routerplannerapi.android.studio.evrouter;


import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EvRouteService {
    public void save(String userId, EvChargerRoute route){
        //save to db
    }

    public void save(EvRouteRequest request){
        //save to db
    }

    public EvChargerRoute get(String userId, String name){
        //retrieve from to db
        return new EvChargerRoute(name);
    }

    public EvChargerRoute get(EvRouteRequest request){
        //retrieve from to db
        System.out.println(request.getUserId() + ": " + request.getRouteName());
        return new EvChargerRoute("route-1");
    }


    public ResponseEntity<EvChargerRoute[]> getAll(String userId){
        //retrieve all from db for user
        EvChargerRoute route1 = new EvChargerRoute("route 1: "+userId);
        EvChargerRoute route2 = new EvChargerRoute("route 2: "+userId);
        EvChargerRoute route3 = new EvChargerRoute("route 3: "+userId);
        EvChargerRoute[] routes = new EvChargerRoute[]{route1, route2, route3};
        return new ResponseEntity<EvChargerRoute[]>(routes, HttpStatus.OK);
    }
}
