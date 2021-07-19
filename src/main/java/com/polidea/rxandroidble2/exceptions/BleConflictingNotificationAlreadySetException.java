/*
 * Decompiled with CFR 0.151.
 */
package com.polidea.rxandroidble2.exceptions;

import com.polidea.rxandroidble2.exceptions.BleException;
import java.util.UUID;

public class BleConflictingNotificationAlreadySetException
extends BleException {
    private final boolean alreadySetIsIndication;
    private final UUID characteristicUuid;

    public BleConflictingNotificationAlreadySetException(UUID uUID, boolean bl2) {
        CharSequence charSequence = new StringBuilder();
        charSequence.append("Characteristic ");
        charSequence.append(uUID);
        String string2 = " notification already set to ";
        charSequence.append(string2);
        string2 = bl2 ? "indication" : "notification";
        charSequence.append(string2);
        charSequence = charSequence.toString();
        super((String)charSequence);
        this.characteristicUuid = uUID;
        this.alreadySetIsIndication = bl2;
    }

    public UUID getCharacteristicUuid() {
        return this.characteristicUuid;
    }

    public boolean indicationAlreadySet() {
        return this.alreadySetIsIndication;
    }

    public boolean notificationAlreadySet() {
        return this.alreadySetIsIndication ^ true;
    }
}

