/*
 * Decompiled with CFR 0.151.
 */
package com.google.mediapipe.formats.proto;

import com.google.mediapipe.formats.proto.LocationDataProto$LocationData$Format;
import com.google.protobuf.Internal$EnumVerifier;

public final class LocationDataProto$LocationData$Format$FormatVerifier
implements Internal$EnumVerifier {
    public static final Internal$EnumVerifier INSTANCE;

    static {
        LocationDataProto$LocationData$Format$FormatVerifier locationDataProto$LocationData$Format$FormatVerifier = new LocationDataProto$LocationData$Format$FormatVerifier();
        INSTANCE = locationDataProto$LocationData$Format$FormatVerifier;
    }

    private LocationDataProto$LocationData$Format$FormatVerifier() {
    }

    public boolean isInRange(int n10) {
        LocationDataProto$LocationData$Format locationDataProto$LocationData$Format = LocationDataProto$LocationData$Format.forNumber(n10);
        if (locationDataProto$LocationData$Format != null) {
            n10 = 1;
        } else {
            n10 = 0;
            locationDataProto$LocationData$Format = null;
        }
        return n10 != 0;
    }
}

