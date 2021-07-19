/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.remoteconfig;

public interface FirebaseRemoteConfigValue {
    public boolean asBoolean();

    public byte[] asByteArray();

    public double asDouble();

    public long asLong();

    public String asString();

    public int getSource();
}

