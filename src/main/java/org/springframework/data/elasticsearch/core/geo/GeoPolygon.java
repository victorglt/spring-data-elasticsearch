package org.springframework.data.elasticsearch.core.geo;

import org.springframework.data.geo.Point;
import org.springframework.data.geo.Polygon;

import java.util.ArrayList;
import java.util.List;

/**
 * GeoPolygon implentation
 * @author Victor Galante
 */
public class GeoPolygon {

    private List<GeoPoint> coordinates;

    private GeoPolygon() {

    }

    public GeoPolygon(List<GeoPoint> coordinates) {
        this.coordinates = coordinates;
    }

    public List<GeoPoint> getCoordinates() {
        return coordinates;
    }

    public static GeoPolygon fromPolygon(Polygon polygon) {
        List<GeoPoint> coordinates = new ArrayList<GeoPoint>();
        for(Point point : polygon.getPoints()) {
            coordinates.add(GeoPoint.fromPoint(point));
        }

        return new GeoPolygon(coordinates);
    }

    public static Polygon toPolygon(GeoPolygon geoPolygon) {
        List<Point> coordinates = new ArrayList<Point>();
        for(GeoPoint geoPoint : geoPolygon.getCoordinates()) {
            coordinates.add(GeoPoint.toPoint(geoPoint));
        }

        return new Polygon(coordinates);
    }

}
