package com.routeplanner.routerplannerapi.android.studio.evrouter;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.Optional;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.Getter;
import org.json.JSONObject;

import java.util.UUID;

@Getter
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@ToString
public class CreateRouteRequest extends Route {
    private final UUID userId;
    private final String routeName;
    private final JSONObject routeJson;
    private final Boolean commentable;
}