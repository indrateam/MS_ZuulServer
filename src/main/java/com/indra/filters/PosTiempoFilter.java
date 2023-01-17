package com.indra.filters;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class PosTiempoFilter extends ZuulFilter {

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();

		System.out.println("Ingresando a PosTiempoFilter");

		Long tiempoInicial = (Long) request.getAttribute("tiempoInicial");
		Long tiempoFinal = System.currentTimeMillis();
		Long tiempoTranscurrido = tiempoFinal - tiempoInicial;

		System.out.println("Tiempo final en Segundos:: " + tiempoFinal / 1000);
		System.out.println("Total de tiempo transcurrido en segundos:: " + tiempoTranscurrido / 1000);
		return null;
	}

	@Override
	public String filterType() {
		return "pos";
	}

	@Override
	public int filterOrder() {
		return 1;
	}

}
