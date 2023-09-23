package com.lm2a.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class GatewayRoutingConfig {

	
	//http://localhost:9090/api/v1/dragonball/characters (1)
	//http://localhost:9090/api/v1/gameofthrones/characters (2)
	
//  Enrutado estatico	
	@Bean
	@Profile("static-routing")
	public RouteLocator configLocalStatic(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(r->r.path("/api/v1/dragonball/*").uri("http://localhost:8003")) //(1)
				.route(r->r.path("/api/v1/gameofthrones/*").uri("http://localhost:8006")) //(2)
				.build();
	}
	
// Enrutado dinamico
	@Bean
	@Profile("dynamic-routing")
	public RouteLocator configLocalDynamic(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(r->r.path("/api/v1/dragonball/*").uri("lb://db")) //(1)
				.route(r->r.path("/api/v1/gameofthrones/*").uri("lb://got")) //(2)
				.build();
	}
	
	// Circuit Breaking
		@Bean
		@Profile("dynamic-circuit-breaking")
		public RouteLocator configLocalDynamicCB(RouteLocatorBuilder builder) {
			return builder.routes()
					.route(r->r.path("/api/v1/gameofthrones/*")
							.filters(f->f.circuitBreaker(c->c.setName("failoverCB")
									.setFallbackUri("forward:/api/v1/got-failover/gameofthrones/characters")
									.setRouteId("dbFailover")))
							.uri("lb://got")) //(2)
					.route(r->r.path("/api/v1/dragonball/*").uri("lb://db")) 

					.route(r->r.path("/api/v1/got-failover/gameofthrones/*").uri("lb://got-failover"))
					
					.build();
		}
	
}
