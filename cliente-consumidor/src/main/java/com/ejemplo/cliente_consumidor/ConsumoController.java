package com.ejemplo.cliente_consumidor;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumoController {

    private final RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/consumir")
    public ResponseEntity<String> consumirDatos() {

            // String url = "http://localhost:8080/datos";

        String url = "https://localhost:8443/datos";

        try {
           
            String body = restTemplate.getForObject(url, String.class);

            return ResponseEntity.ok(body);

        } catch (Exception e) {
           
            e.printStackTrace();

            // Y devolvemos un 500 con el mensaje claro en el body
            String mensajeError = "Error llamando a " + url + " -> "
                    + e.getClass().getSimpleName() + ": " + e.getMessage();

            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(mensajeError);
        }
    }
}
