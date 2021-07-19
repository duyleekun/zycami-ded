/*
 * Decompiled with CFR 0.151.
 */
package com.polidea.rxandroidble2.exceptions;

import com.polidea.rxandroidble2.exceptions.BleException;
import java.util.UUID;

public class BleCharacteristicNotFoundException
extends BleException {
    private final UUID characteristicUUID;

    public BleCharacteristicNotFoundException(UUID uUID) {
        CharSequence charSequence = new StringBuilder();
        charSequence.append("Characteristic not found with UUID ");
        charSequence.append(uUID);
        charSequence = charSequence.toString();
        super((String)charSequence);
        this.characteristicUUID = uUID;
    }

    public UUID getCharacteristicUUID() {
        return this.characteristicUUID;
    }

    public UUID getCharactersisticUUID() {
        return this.characteristicUUID;
    }
}

