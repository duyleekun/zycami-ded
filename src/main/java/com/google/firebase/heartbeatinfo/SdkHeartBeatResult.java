/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.heartbeatinfo;

import com.google.firebase.heartbeatinfo.AutoValue_SdkHeartBeatResult;

public abstract class SdkHeartBeatResult
implements Comparable {
    public static SdkHeartBeatResult create(String string2, long l10) {
        AutoValue_SdkHeartBeatResult autoValue_SdkHeartBeatResult = new AutoValue_SdkHeartBeatResult(string2, l10);
        return autoValue_SdkHeartBeatResult;
    }

    public int compareTo(SdkHeartBeatResult sdkHeartBeatResult) {
        long l10;
        long l11 = this.getMillis();
        long l12 = l11 - (l10 = sdkHeartBeatResult.getMillis());
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        object = object < 0 ? (Object)-1 : (Object)1;
        return (int)object;
    }

    public abstract long getMillis();

    public abstract String getSdkName();
}

