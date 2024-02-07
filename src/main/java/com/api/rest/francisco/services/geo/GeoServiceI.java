package com.api.rest.francisco.services.geo;

public interface GeoServiceI {

    /** Aplica la formula de haversine */
    public Double haversine(Double userLatitude,Double userLongitude,Double museumLatitude,Double museumLongitude);
}
