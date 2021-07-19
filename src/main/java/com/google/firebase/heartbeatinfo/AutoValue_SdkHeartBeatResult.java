/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.heartbeatinfo;

import com.google.firebase.heartbeatinfo.SdkHeartBeatResult;
import java.util.Objects;

public final class AutoValue_SdkHeartBeatResult
extends SdkHeartBeatResult {
    private final long millis;
    private final String sdkName;

    public AutoValue_SdkHeartBeatResult(String string2, long l10) {
        Objects.requireNonNull(string2, "Null sdkName");
        this.sdkName = string2;
        this.millis = l10;
    }

    public boolean equals(Object object) {
        boolean bl2 = true;
        if (object == this) {
            return bl2;
        }
        boolean bl3 = object instanceof SdkHeartBeatResult;
        if (bl3) {
            long l10;
            long l11;
            long l12;
            long l13;
            String string2 = this.sdkName;
            String string3 = ((SdkHeartBeatResult)(object = (SdkHeartBeatResult)object)).getSdkName();
            bl3 = string2.equals(string3);
            if (!bl3 || (l13 = (l12 = (l11 = this.millis) - (l10 = ((SdkHeartBeatResult)object).getMillis())) == 0L ? 0 : (l12 < 0L ? -1 : 1)) != false) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public long getMillis() {
        return this.millis;
    }

    public String getSdkName() {
        return this.sdkName;
    }

    public int hashCode() {
        int n10 = this.sdkName.hashCode();
        int n11 = 1000003;
        n10 = (n10 ^ n11) * n11;
        long l10 = this.millis;
        long l11 = l10 >>> 32;
        n11 = (int)(l10 ^ l11);
        return n10 ^ n11;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SdkHeartBeatResult{sdkName=");
        String string2 = this.sdkName;
        stringBuilder.append(string2);
        stringBuilder.append(", millis=");
        long l10 = this.millis;
        stringBuilder.append(l10);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

