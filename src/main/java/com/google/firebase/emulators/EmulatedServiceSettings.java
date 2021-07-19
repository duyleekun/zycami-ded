/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.emulators;

public final class EmulatedServiceSettings {
    private final String host;
    private final int port;

    public EmulatedServiceSettings(String string2, int n10) {
        this.host = string2;
        this.port = n10;
    }

    public String getHost() {
        return this.host;
    }

    public int getPort() {
        return this.port;
    }
}

