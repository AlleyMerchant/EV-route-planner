package com.routeplanner.routerplannerapi.android.studio.evrouter;


import com.routeplanner.routerplannerapi.android.studio.Util;
import com.routeplanner.routerplannerapi.android.studio.appuser.UserRepository;
import lombok.AllArgsConstructor;
import org.json.JSONObject;
import org.postgresql.util.PGobject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.*;

@Service
@AllArgsConstructor
public class EvRouteService {

    private final UserRepository userRepository;
    private final EvRouteRepository evRouteRepository;
    public void save(String userId, EvChargerRoute route){

        //save to db
    }

    public void saveNewRoute(CreateRouteRequest request){
        Util util = new Util();
      //  if(util.isValidJson(request.getRouteJson())){
            evRouteRepository.saveRoute(UUID.randomUUID(), request.getUserId(), request.getRouteName(), util.convertToDatabaseColumn(request.getRouteJson()), request.getCommentable(),LocalDateTime.now());
        }

    public void delete(UUID routeId){
        evRouteRepository.deleteById(routeId);
    }


    public void updateRoute(UpdateRouteRequest request){
        EvChargerRoute savedRoute = evRouteRepository.getOne(request.getRouteId());
        evRouteRepository.save(savedRoute.update(request.getRouteName(), request.getRouteJson().orElse("{}"), request.getCommentable()));
        //save to db
    }

    public EvChargerRoute get(String userId, String name){
        //retrieve from to db
        PGobject pGobject = new PGobject();
        try {
            pGobject.setValue("");
            return new EvChargerRoute(UUID.randomUUID() ,UUID.randomUUID(), "route-1", "{}", true, LocalDateTime.now());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public EvRouteResponse get(EvRouteRequest request){
        //retrieve from to db
        //evRouteRepository.getOne(request.getRouteId());
        Util util = new Util();
        System.out.println(request.getUserId() + ": " + request.getRouteId());
        EvChargerRoute route = evRouteRepository.findById(request.getRouteId()).get();
        return new EvRouteResponse(route.id, route.userId, route.name, util.convertToEntityAttribute(route.routeJson), route.updatedAt);
        //return evRouteRepository.findById(request.getRouteId()).get();
    }


    public ResponseEntity<List<EvChargerRoute>> getAll(UUID userId){
        ArrayList<UUID> userIds = new ArrayList<UUID>();
        userIds.add(userId);
        List<EvChargerRoute> results = evRouteRepository.getRoutesByUserId(userId);
//
//        //retrieve all from db for user
//        EvChargerRoute route1 = new EvChargerRoute(UUID.randomUUID(),"route 1: "+userId, "json",  LocalDateTime.now());
//        EvChargerRoute route2 = new EvChargerRoute(UUID.randomUUID(),"route 2: "+userId,"json",  LocalDateTime.now());
//        EvChargerRoute route3 = new EvChargerRoute(UUID.randomUUID(),"route 3: "+userId,"json",  LocalDateTime.now());
//        EvChargerRoute[] routes = new EvChargerRoute[]{route1, route2, route3};
        return new ResponseEntity<List<EvChargerRoute>>(results, HttpStatus.OK);
    }
}


