package com.routeplanner.routerplannerapi.android.studio.evrouter;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Optional;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
public class EvChargerRoute {
    @Id
    java.util.UUID id;
    java.util.UUID userId;
    String name;
    @Column(columnDefinition = "jsonb")
    String routeJson;
    Boolean commentable;
    LocalDateTime updatedAt;

    EvChargerRoute update(Optional<String> maybeRouteName,  String routeJson, Optional<Boolean> commentable){
      return new EvChargerRoute(this.id, this.userId, maybeRouteName.orElse(this.name), routeJson, commentable.orElse(this.commentable), LocalDateTime.now());
    }
}
