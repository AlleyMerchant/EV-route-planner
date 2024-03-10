package com.routeplanner.routerplannerapi.android.studio.evrouter;


import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.Getter;
@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class EvRouteRequest {
    private final String userId;
    private final String routeName;
}