/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.heartbeatinfo;

import com.google.firebase.heartbeatinfo.HeartBeatInfo$HeartBeat;
import com.google.firebase.heartbeatinfo.HeartBeatResult;
import java.util.Objects;

public final class AutoValue_HeartBeatResult
extends HeartBeatResult {
    private final HeartBeatInfo$HeartBeat heartBeat;
    private final long millis;
    private final String sdkName;

    public AutoValue_HeartBeatResult(String string2, long l10, HeartBeatInfo$HeartBeat heartBeatInfo$HeartBeat) {
        Objects.requireNonNull(string2, "Null sdkName");
        this.sdkName = string2;
        this.millis = l10;
        Objects.requireNonNull(heartBeatInfo$HeartBeat, "Null heartBeat");
        this.heartBeat = heartBeatInfo$HeartBeat;
    }

    public boolean equals(Object object) {
        boolean bl2 = true;
        if (object == this) {
            return bl2;
        }
        boolean bl3 = object instanceof HeartBeatResult;
        if (bl3) {
            boolean bl4;
            long l10;
            long l11;
            long l12;
            Object object2 = this.sdkName;
            String string2 = ((HeartBeatResult)(object = (HeartBeatResult)object)).getSdkName();
            bl3 = ((String)object2).equals(string2);
            if (!bl3 || (bl3 = (l12 = (l11 = this.millis) - (l10 = ((HeartBeatResult)object).getMillis())) == 0L ? 0 : (l12 < 0L ? -1 : 1)) || !(bl4 = ((Enum)(object2 = this.heartBeat)).equals(object = ((HeartBeatResult)object).getHeartBeat()))) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public HeartBeatInfo$HeartBeat getHeartBeat() {
        return this.heartBeat;
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
        int n12 = (int)(l10 ^ l11);
        n10 = (n10 ^ n12) * n11;
        n11 = this.heartBeat.hashCode();
        return n10 ^ n11;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("HeartBeatResult{sdkName=");
        Object object = this.sdkName;
        stringBuilder.append((String)object);
        stringBuilder.append(", millis=");
        long l10 = this.millis;
        stringBuilder.append(l10);
        stringBuilder.append(", heartBeat=");
        object = this.heartBeat;
        stringBuilder.append(object);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

