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

public final class CrashlyticsReportJsonTransform$$Lambda$1
implements CrashlyticsReportJsonTransform$ObjectParser {
    private static final CrashlyticsReportJsonTransform$$Lambda$1 instance;

    static {
        CrashlyticsReportJsonTransform$$Lambda$1 crashlyticsReportJsonTransform$$Lambda$1;
        instance = crashlyticsReportJsonTransform$$Lambda$1 = new CrashlyticsReportJsonTransform$$Lambda$1();
    }

    private CrashlyticsReportJsonTransform$$Lambda$1() {
    }

    public static CrashlyticsReportJsonTransform$ObjectParser lambdaFactory$() {
        return instance;
    }

    public Object parse(JsonReader jsonReader) {
        return CrashlyticsReportJsonTransform.access$lambda$0(jsonReader);
    }
}

