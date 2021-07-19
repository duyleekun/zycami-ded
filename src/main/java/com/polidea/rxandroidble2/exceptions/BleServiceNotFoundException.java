/*
 * Decompiled with CFR 0.151.
 */
package com.polidea.rxandroidble2.exceptions;

import com.polidea.rxandroidble2.exceptions.BleException;
import java.util.UUID;

public class BleServiceNotFoundException
extends BleException {
    private final UUID serviceUUID;

    public BleServiceNotFoundException(UUID uUID) {
        CharSequence charSequence = new StringBuilder();
        charSequence.append("BLE Service not found with UUID ");
        charSequence.append(uUID);
        charSequence = charSequence.toString();
        super((String)charSequence);
        this.serviceUUID = uUID;
    }

    public UUID getServiceUUID() {
        return this.serviceUUID;
    }
}

