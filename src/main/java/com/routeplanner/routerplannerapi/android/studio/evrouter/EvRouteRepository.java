package com.routeplanner.routerplannerapi.android.studio.evrouter;


import org.hibernate.annotations.Type;
import org.json.JSONObject;
import org.postgresql.util.PGobject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Repository
@Transactional
public interface EvRouteRepository
        extends JpaRepository<EvChargerRoute, UUID> {

 //   Optional<EvChargerRoute> findById(String userId);
    @Query("SELECT evcr FROM EvChargerRoute evcr WHERE evcr.userId=?1")
    List<EvChargerRoute> getRoutesByUserId(UUID id);

   @Query(value = "SELECT * FROM ev_charger_route evcr WHERE evcr.id=?1", nativeQuery = true)
   EvChargerRoute getRouteById(UUID id);


    @Modifying
    @Query(value = "INSERT INTO ev_charger_route VALUES(?1, ?2, ?3, to_jsonb(?4), ?5, ?6)",
            nativeQuery = true)
    void saveRoute(UUID id, UUID userId, String name, String routeJson, Boolean commentable, LocalDateTime updatedAt);
}
