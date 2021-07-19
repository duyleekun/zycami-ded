/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$Execution$BinaryImage;
import java.nio.charset.Charset;

public abstract class CrashlyticsReport$Session$Event$Application$Execution$BinaryImage$Builder {
    public abstract CrashlyticsReport$Session$Event$Application$Execution$BinaryImage build();

    public abstract CrashlyticsReport$Session$Event$Application$Execution$BinaryImage$Builder setBaseAddress(long var1);

    public abstract CrashlyticsReport$Session$Event$Application$Execution$BinaryImage$Builder setName(String var1);

    public abstract CrashlyticsReport$Session$Event$Application$Execution$BinaryImage$Builder setSize(long var1);

    public abstract CrashlyticsReport$Session$Event$Application$Execution$BinaryImage$Builder setUuid(String var1);

    public CrashlyticsReport$Session$Event$Application$Execution$BinaryImage$Builder setUuidFromUtf8Bytes(byte[] byArray) {
        Charset charset = CrashlyticsReport.access$000();
        String string2 = new String(byArray, charset);
        return this.setUuid(string2);
    }
}

