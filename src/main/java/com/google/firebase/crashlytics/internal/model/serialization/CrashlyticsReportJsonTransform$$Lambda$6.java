/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.JsonReader
 */
package com.google.firebase.crashlytics.internal.model.serialization;

import android.util.JsonReader;
import com.google.firebase.crashlytics.internal.model.serialization.CrashlyticsReportJsonTransform;
import com.google.firebase.crashlytics.internal.model.serialization.CrashlyticsReportJsonTransform$ObjectParser;

public final class CrashlyticsReportJsonTransform$$Lambda$6
implements CrashlyticsReportJsonTransform$ObjectParser {
    private static final CrashlyticsReportJsonTransform$$Lambda$6 instance;

    static {
        CrashlyticsReportJsonTransform$$Lambda$6 crashlyticsReportJsonTransform$$Lambda$6;
        instance = crashlyticsReportJsonTransform$$Lambda$6 = new CrashlyticsReportJsonTransform$$Lambda$6();
    }

    private CrashlyticsReportJsonTransform$$Lambda$6() {
    }

    public static CrashlyticsReportJsonTransform$ObjectParser lambdaFactory$() {
        return instance;
    }

    public Object parse(JsonReader jsonReader) {
        return CrashlyticsReportJsonTransform.access$lambda$5(jsonReader);
    }
}

