package com.ejemplo.cliente_consumidor;


import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ClienteConsumidorApplication {

    @Value("${cliente.ssl.key-store}")
    private String keyStorePath;
    @Value("${cliente.ssl.key-store-password}")
    private String keyStorePassword;
    @Value("${cliente.ssl.key-store-type}")
    private String keyStoreType;

    @Value("${cliente.ssl.trust-store}")
    private String trustStorePath;
    @Value("${cliente.ssl.trust-store-password}")
    private String trustStorePassword;
    @Value("${cliente.ssl.trust-store-type}")
    private String trustStoreType;

    public static void main(String[] args) {
        SpringApplication.run(ClienteConsumidorApplication.class, args);
    }

    @PostConstruct
    public void configureSsl() {
        System.setProperty("javax.net.ssl.keyStore", keyStorePath);
        System.setProperty("javax.net.ssl.keyStorePassword", keyStorePassword);
        System.setProperty("javax.net.ssl.keyStoreType", keyStoreType);

        System.setProperty("javax.net.ssl.trustStore", trustStorePath);
        System.setProperty("javax.net.ssl.trustStorePassword", trustStorePassword);
        System.setProperty("javax.net.ssl.trustStoreType", trustStoreType);

        System.out.println("🔐 SSL del cliente configurado");
        System.out.println("   keyStore=" + keyStorePath);
        System.out.println("   trustStore=" + trustStorePath);
    }
}



// import org.springframework.boot.SpringApplication;
// import org.springframework.boot.autoconfigure.SpringBootApplication;

// @SpringBootApplication
// public class ClienteConsumidorApplication {

//     public static void main(String[] args) {
//         SpringApplication.run(ClienteConsumidorApplication.class, args);
//     }
// }

