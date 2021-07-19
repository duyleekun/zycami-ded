/*
 * Decompiled with CFR 0.151.
 */
package com.polidea.rxandroidble2.exceptions;

import com.polidea.rxandroidble2.exceptions.BleException;
import java.util.UUID;

public class BleDescriptorNotFoundException
extends BleException {
    private final UUID descriptorUUID;

    public BleDescriptorNotFoundException(UUID uUID) {
        CharSequence charSequence = new StringBuilder();
        charSequence.append("Descriptor not found with UUID ");
        charSequence.append(uUID);
        charSequence = charSequence.toString();
        super((String)charSequence);
        this.descriptorUUID = uUID;
    }

    public UUID getDescriptorUUID() {
        return this.descriptorUUID;
    }
}

