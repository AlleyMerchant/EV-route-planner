package com.routeplanner.routerplannerapi.android.studio.evrouter;


import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.json.JSONObject;

import java.util.Optional;
import java.util.UUID;

@Getter
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@ToString
public class UpdateRouteRequest extends Route {
    private final UUID userId;
    private final UUID routeId;
    private final Optional<String> routeName;
    private final Optional<String> routeJson;
    private final Optional<Boolean> commentable;
}

