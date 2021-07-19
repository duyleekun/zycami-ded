/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.types;

import cn.leancloud.utils.AVUtils;

public class AVGeoPoint {
    public static double ONE_KM_TO_MILES = 1.609344;
    private double latitude;
    private double longitude;

    public AVGeoPoint() {
        double d10;
        this.latitude = d10 = 0.0;
        this.longitude = d10;
    }

    public AVGeoPoint(double d10, double d11) {
        this.latitude = d10;
        this.longitude = d11;
    }

    public double distanceInKilometersTo(AVGeoPoint aVGeoPoint) {
        if (aVGeoPoint == null) {
            return 0.0;
        }
        double d10 = this.latitude;
        double d11 = aVGeoPoint.latitude;
        double d12 = this.longitude;
        double d13 = aVGeoPoint.longitude;
        return AVUtils.distance(d10, d11, d12, d13, 0.0, 0.0);
    }

    public double distanceInMilesTo(AVGeoPoint aVGeoPoint) {
        double d10 = this.distanceInKilometersTo(aVGeoPoint);
        double d11 = ONE_KM_TO_MILES;
        return d10 / d11;
    }

    public double distanceInRadiansTo(AVGeoPoint aVGeoPoint) {
        return this.distanceInKilometersTo(aVGeoPoint) / 6378.14;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public void setLatitude(double d10) {
        this.latitude = d10;
    }

    public void setLongitude(double d10) {
        this.longitude = d10;
    }
}

