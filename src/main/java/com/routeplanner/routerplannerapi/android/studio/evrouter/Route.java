package com.routeplanner.routerplannerapi.android.studio.evrouter;

import org.postgresql.util.PGobject;

import java.sql.SQLException;
import java.util.Optional;

public abstract class Route {
    Optional<String> routeJson;

    public PGobject getRouteAsJson() {
        PGobject jsonObject = new PGobject();
        jsonObject.setType("json");
        try {
            jsonObject.setValue(routeJson.orElse("{}"));
            System.out.println("jsonObject");
            System.out.println(jsonObject);
            System.out.println("jsonObject");
            return jsonObject;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
