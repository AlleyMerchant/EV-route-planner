package com.routeplanner.routerplannerapi.android.studio.evrouter;


import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class EvRouteRequest {
    private final UUID userId;
    private final UUID routeId;
}