package com.example.servidor_datos;


import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.cert.X509Certificate;

@RestController
public class DatosController {

    @GetMapping("/datos")
    public DatosResponse getDatos(HttpServletRequest request) {

        boolean clientCertPresent = false;
        String clientSubject = null;

        // 👇 Primero intentamos con la clave nueva de Jakarta (Tomcat 10 / Spring Boot 3)
        X509Certificate[] certs =
                (X509Certificate[]) request.getAttribute("jakarta.servlet.request.X509Certificate");

        // 👇 Por compatibilidad, si viniera por la vieja clave (raro, pero por si acaso)
        if (certs == null) {
            certs = (X509Certificate[]) request.getAttribute("javax.servlet.request.X509Certificate");
        }

        if (certs != null && certs.length > 0) {
            clientCertPresent = true;
            clientSubject = certs[0].getSubjectDN().toString();
            System.out.println("🔥 Certificado del cliente: " + clientSubject);
        } else {
            System.out.println("⚠️ NO hay certificado de cliente en la petición");
        }

        return new DatosResponse("123.456.789", clientCertPresent, clientSubject);
    }
}
