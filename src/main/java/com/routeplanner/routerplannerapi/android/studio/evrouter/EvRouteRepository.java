package com.routeplanner.routerplannerapi.android.studio.evrouter;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface EvRouteRepository
        extends JpaRepository<EvChargerRoute, Long> {

    Optional<EvChargerRoute> findById(String userId);

    @Transactional
    @Modifying
    @Query("INSERT INTO route VALUES()")
    int save(EvChargerRoute route, LocalDateTime updatedAt);
}
