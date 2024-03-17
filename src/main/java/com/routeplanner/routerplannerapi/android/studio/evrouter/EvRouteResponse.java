package com.routeplanner.routerplannerapi.android.studio.evrouter;


import lombok.*;
import org.json.JSONObject;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class EvRouteResponse {
    java.util.UUID id;
    java.util.UUID userId;
    String name;
    JSONObject routeJson;
    LocalDateTime updatedAt;
}
