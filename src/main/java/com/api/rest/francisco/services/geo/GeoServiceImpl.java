package com.api.rest.francisco.services.geo;

import org.springframework.stereotype.Service;

@Service
public class GeoServiceImpl implements GeoServiceI{

    @Override
    public Double haversine(Double userLatitude, Double userLongitude, Double museumLatitude, Double museumLongitude) {

        final int R = 6371; // Radio de la Tierra en kilómetros

        // Convertir latitudes y longitudes de grados a radianes
        userLatitude = Math.toRadians(userLatitude);
        userLongitude = Math.toRadians(userLongitude);
        museumLatitude = Math.toRadians(museumLatitude);
        museumLongitude = Math.toRadians(museumLongitude);

        // Calcular las diferencias de latitud y longitud
        double dlat = museumLatitude - userLatitude;
        double dlon = museumLongitude - userLongitude;

        // Aplicar la fórmula de Haversine
        double a = Math.pow(Math.sin(dlat / 2), 2) + Math.cos(userLatitude) * Math.cos(museumLatitude) * Math.pow(Math.sin(dlon / 2), 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distancia = R * c;

        return distancia;
    }
}
