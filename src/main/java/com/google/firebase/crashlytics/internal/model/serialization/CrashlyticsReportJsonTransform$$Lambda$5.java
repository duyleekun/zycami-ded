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

public final class CrashlyticsReportJsonTransform$$Lambda$5
implements CrashlyticsReportJsonTransform$ObjectParser {
    private static final CrashlyticsReportJsonTransform$$Lambda$5 instance;

    static {
        CrashlyticsReportJsonTransform$$Lambda$5 crashlyticsReportJsonTransform$$Lambda$5;
        instance = crashlyticsReportJsonTransform$$Lambda$5 = new CrashlyticsReportJsonTransform$$Lambda$5();
    }

    private CrashlyticsReportJsonTransform$$Lambda$5() {
    }

    public static CrashlyticsReportJsonTransform$ObjectParser lambdaFactory$() {
        return instance;
    }

    public Object parse(JsonReader jsonReader) {
        return CrashlyticsReportJsonTransform.access$lambda$4(jsonReader);
    }
}

