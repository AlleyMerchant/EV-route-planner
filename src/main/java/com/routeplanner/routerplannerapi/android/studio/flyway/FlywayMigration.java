package com.routeplanner.routerplannerapi.android.studio.flyway;

import org.flywaydb.core.Flyway;


public class FlywayMigration {
    public void migrate() {
       Flyway flyway = Flyway.configure().dataSource("jdbc:postgresql://localhost:5432/ev_route_planner", "postgres", "password").load();
       flyway.migrate();
    }
}

