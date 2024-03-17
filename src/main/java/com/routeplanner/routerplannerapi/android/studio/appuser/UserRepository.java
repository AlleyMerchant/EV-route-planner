package com.routeplanner.routerplannerapi.android.studio.appuser;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Repository
@Transactional(readOnly = true)
public interface UserRepository
        extends JpaRepository<AppUser, UUID> {


//    @Transactional
//    @Modifying
//    @Query("INSERT INTO user VALUES(null, ?1, ?2, ?3, ?4);")
//    User saveUser(String email, String username, String password, LocalDateTime updatedAt);


//    Optional<AppUser> findById(String userId);


//    @Transactional
//    @Modifying
//    @Query("INSERT INTO route VALUES('', '', '', '')")
//    int save(AppUser route, LocalDateTime updatedAt);
}
