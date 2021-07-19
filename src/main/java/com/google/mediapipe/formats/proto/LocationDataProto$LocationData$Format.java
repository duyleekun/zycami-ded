/*
 * Decompiled with CFR 0.151.
 */
package com.google.mediapipe.formats.proto;

import com.google.mediapipe.formats.proto.LocationDataProto$LocationData$Format$1;
import com.google.mediapipe.formats.proto.LocationDataProto$LocationData$Format$FormatVerifier;
import com.google.protobuf.Internal$EnumLite;
import com.google.protobuf.Internal$EnumLiteMap;
import com.google.protobuf.Internal$EnumVerifier;

public final class LocationDataProto$LocationData$Format
extends Enum
implements Internal$EnumLite {
    private static final /* synthetic */ LocationDataProto$LocationData$Format[] $VALUES;
    public static final /* enum */ LocationDataProto$LocationData$Format BOUNDING_BOX;
    public static final int BOUNDING_BOX_VALUE = 1;
    public static final /* enum */ LocationDataProto$LocationData$Format GLOBAL;
    public static final int GLOBAL_VALUE = 0;
    public static final /* enum */ LocationDataProto$LocationData$Format MASK;
    public static final int MASK_VALUE = 3;
    public static final /* enum */ LocationDataProto$LocationData$Format RELATIVE_BOUNDING_BOX;
    public static final int RELATIVE_BOUNDING_BOX_VALUE = 2;
    private static final Internal$EnumLiteMap internalValueMap;
    private final int value;

    static {
        LocationDataProto$LocationData$Format locationDataProto$LocationData$Format;
        LocationDataProto$LocationData$Format locationDataProto$LocationData$Format2;
        LocationDataProto$LocationData$Format locationDataProto$LocationData$Format3;
        Object object = new LocationDataProto$LocationData$Format("GLOBAL", 0, 0);
        GLOBAL = object;
        int n10 = 1;
        BOUNDING_BOX = locationDataProto$LocationData$Format3 = new LocationDataProto$LocationData$Format("BOUNDING_BOX", n10, n10);
        int n11 = 2;
        RELATIVE_BOUNDING_BOX = locationDataProto$LocationData$Format2 = new LocationDataProto$LocationData$Format("RELATIVE_BOUNDING_BOX", n11, n11);
        int n12 = 3;
        MASK = locationDataProto$LocationData$Format = new LocationDataProto$LocationData$Format("MASK", n12, n12);
        LocationDataProto$LocationData$Format[] locationDataProto$LocationData$FormatArray = new LocationDataProto$LocationData$Format[4];
        locationDataProto$LocationData$FormatArray[0] = object;
        locationDataProto$LocationData$FormatArray[n10] = locationDataProto$LocationData$Format3;
        locationDataProto$LocationData$FormatArray[n11] = locationDataProto$LocationData$Format2;
        locationDataProto$LocationData$FormatArray[n12] = locationDataProto$LocationData$Format;
        $VALUES = locationDataProto$LocationData$FormatArray;
        internalValueMap = object = new LocationDataProto$LocationData$Format$1();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private LocationDataProto$LocationData$Format() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.value = var3_1;
    }

    public static LocationDataProto$LocationData$Format forNumber(int n10) {
        if (n10 != 0) {
            int n11 = 1;
            if (n10 != n11) {
                n11 = 2;
                if (n10 != n11) {
                    n11 = 3;
                    if (n10 != n11) {
                        return null;
                    }
                    return MASK;
                }
                return RELATIVE_BOUNDING_BOX;
            }
            return BOUNDING_BOX;
        }
        return GLOBAL;
    }

    public static Internal$EnumLiteMap internalGetValueMap() {
        return internalValueMap;
    }

    public static Internal$EnumVerifier internalGetVerifier() {
        return LocationDataProto$LocationData$Format$FormatVerifier.INSTANCE;
    }

    public static LocationDataProto$LocationData$Format valueOf(int n10) {
        return LocationDataProto$LocationData$Format.forNumber(n10);
    }

    public static LocationDataProto$LocationData$Format valueOf(String string2) {
        return Enum.valueOf(LocationDataProto$LocationData$Format.class, string2);
    }

    public static LocationDataProto$LocationData$Format[] values() {
        return (LocationDataProto$LocationData$Format[])$VALUES.clone();
    }

    public final int getNumber() {
        return this.value;
    }
}

