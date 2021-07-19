/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.common;

public final class DeliveryMechanism
extends Enum {
    private static final /* synthetic */ DeliveryMechanism[] $VALUES;
    public static final /* enum */ DeliveryMechanism APP_STORE;
    public static final /* enum */ DeliveryMechanism DEVELOPER;
    public static final /* enum */ DeliveryMechanism TEST_DISTRIBUTION;
    public static final /* enum */ DeliveryMechanism USER_SIDELOAD;
    private final int id;

    static {
        DeliveryMechanism deliveryMechanism;
        DeliveryMechanism deliveryMechanism2;
        DeliveryMechanism deliveryMechanism3;
        DeliveryMechanism deliveryMechanism4;
        int n10 = 1;
        DEVELOPER = deliveryMechanism4 = new DeliveryMechanism("DEVELOPER", 0, n10);
        int n11 = 2;
        USER_SIDELOAD = deliveryMechanism3 = new DeliveryMechanism("USER_SIDELOAD", n10, n11);
        int n12 = 3;
        TEST_DISTRIBUTION = deliveryMechanism2 = new DeliveryMechanism("TEST_DISTRIBUTION", n11, n12);
        int n13 = 4;
        APP_STORE = deliveryMechanism = new DeliveryMechanism("APP_STORE", n12, n13);
        DeliveryMechanism[] deliveryMechanismArray = new DeliveryMechanism[n13];
        deliveryMechanismArray[0] = deliveryMechanism4;
        deliveryMechanismArray[n10] = deliveryMechanism3;
        deliveryMechanismArray[n11] = deliveryMechanism2;
        deliveryMechanismArray[n12] = deliveryMechanism;
        $VALUES = deliveryMechanismArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private DeliveryMechanism() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.id = var3_1;
    }

    public static DeliveryMechanism determineFrom(String object) {
        object = object != null ? APP_STORE : DEVELOPER;
        return object;
    }

    public static DeliveryMechanism valueOf(String string2) {
        return Enum.valueOf(DeliveryMechanism.class, string2);
    }

    public static DeliveryMechanism[] values() {
        return (DeliveryMechanism[])$VALUES.clone();
    }

    public int getId() {
        return this.id;
    }

    public String toString() {
        return Integer.toString(this.id);
    }
}

