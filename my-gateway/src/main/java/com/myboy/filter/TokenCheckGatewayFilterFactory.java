package com.myboy.filter;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TokenCheckGatewayFilterFactory extends AbstractGatewayFilterFactory<TokenCheckGatewayFilterFactory.Config> {

	public TokenCheckGatewayFilterFactory() {
		super(Config.class);
	}

	@Override
	public GatewayFilter apply(Config config) {
		return (exchange, chain) -> {
			List<String> authorization = exchange.getRequest().getHeaders().get("Authorization");
			if (authorization != null) {
				String token = authorization.get(0);
				System.out.println(token);
				// check token
			}
			return chain.filter(exchange);
		};
	}

	public static class Config {
		//Put the configuration properties for your filter here
	}

}