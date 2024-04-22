package com.projeto.tdsapi.event.listener;

import com.projeto.tdsapi.event.RecursoCriadEvent;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationListener;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

public class Listener implements ApplicationListener <RecursoCriadEvent> {


    @Override
    public void onApplicationEvent(RecursoCriadEvent RecursoCriadEvent) {
        HttpServletResponse response = RecursoCriadEvent.getResponse();
        Long id = RecursoCriadEvent.getId();

        adicionarHeaderLocation(response, id);
    }

    private void adicionarHeaderLocation(HttpServletResponse response, Long id) {
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(id).toUri();
        response.setHeader("Location", uri.toASCIIString());
    }
}