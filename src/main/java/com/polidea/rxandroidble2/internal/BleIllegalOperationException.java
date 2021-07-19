/*
 * Decompiled with CFR 0.151.
 */
package com.polidea.rxandroidble2.internal;

import java.util.UUID;

public class BleIllegalOperationException
extends RuntimeException {
    public final UUID characteristicUUID;
    public final int neededProperties;
    public final int supportedProperties;

    public BleIllegalOperationException(String string2, UUID uUID, int n10, int n11) {
        super(string2);
        this.characteristicUUID = uUID;
        this.supportedProperties = n10;
        this.neededProperties = n11;
    }
}

