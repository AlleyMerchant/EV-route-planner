package com.routeplanner.routerplannerapi.android.studio;

import com.routeplanner.routerplannerapi.android.studio.flyway.FlywayMigration;
import io.prometheus.metrics.core.metrics.Counter;
import io.prometheus.metrics.instrumentation.jvm.JvmMetrics;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

import java.io.IOException;

@SpringBootApplication
@EntityScan({"com.routeplanner.routerplannerapi.android.studio.appuser", "com.routeplanner.routerplannerapi.android.studio.evrouter", "com.routeplanner.routerplannerapi.android.studio.comment"})
@ComponentScan(basePackages = {"com.routeplanner.routerplannerapi.android.studio"})
public class Application {

	public static void main(String[] args) {

		JvmMetrics.builder().register(); // initialize the out-of-the-box JVM metrics

		Counter counter = Counter.builder()
				.name("my_count_total")
				.help("example counter")
				.labelNames("status")
				.register();

		counter.labelValues("ok").inc();
		counter.labelValues("ok").inc();
		counter.labelValues("error").inc();


		FlywayMigration flyway = new FlywayMigration();
		flyway.migrate();
		SpringApplication.run(Application.class, args);


	}

}

//endpoints to expose
//Login
//Logout
//save route
//fetch route
