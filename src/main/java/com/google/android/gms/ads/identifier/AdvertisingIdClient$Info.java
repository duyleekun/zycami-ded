/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.ads.identifier;

public final class AdvertisingIdClient$Info {
    private final String zzq;
    private final boolean zzr;

    public AdvertisingIdClient$Info(String string2, boolean bl2) {
        this.zzq = string2;
        this.zzr = bl2;
    }

    public final String getId() {
        return this.zzq;
    }

    public final boolean isLimitAdTrackingEnabled() {
        return this.zzr;
    }

    public final String toString() {
        String string2 = this.zzq;
        boolean bl2 = this.zzr;
        int n10 = String.valueOf(string2).length() + 7;
        StringBuilder stringBuilder = new StringBuilder(n10);
        stringBuilder.append("{");
        stringBuilder.append(string2);
        stringBuilder.append("}");
        stringBuilder.append(bl2);
        return stringBuilder.toString();
    }
}

