package com.routeplanner.routerplannerapi.android.studio.appuser;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Entity

public class AppUser {
    @Id
    java.util.UUID id;
    String email;
    String userName;
    String password;
    LocalDateTime updatedAt;
}
