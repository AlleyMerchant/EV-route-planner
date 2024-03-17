package com.routeplanner.routerplannerapi.android.studio.comment;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
public class Comment {
    @Id
    UUID id;
    UUID userId;
    UUID routeId;
    String comment;
    LocalDateTime updatedAt;

    Comment update(String comment){
      return new Comment(this.id, this.userId, this.routeId, comment, LocalDateTime.now());
    }
}
