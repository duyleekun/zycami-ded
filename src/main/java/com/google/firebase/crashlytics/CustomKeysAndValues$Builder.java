/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics;

import com.google.firebase.crashlytics.CustomKeysAndValues;
import java.util.HashMap;
import java.util.Map;

public class CustomKeysAndValues$Builder {
    private Map keysAndValues;

    public CustomKeysAndValues$Builder() {
        HashMap hashMap;
        this.keysAndValues = hashMap = new HashMap();
    }

    public static /* synthetic */ Map access$000(CustomKeysAndValues$Builder customKeysAndValues$Builder) {
        return customKeysAndValues$Builder.keysAndValues;
    }

    public CustomKeysAndValues build() {
        CustomKeysAndValues customKeysAndValues = new CustomKeysAndValues(this);
        return customKeysAndValues;
    }

    public CustomKeysAndValues$Builder putBoolean(String string2, boolean bl2) {
        Map map = this.keysAndValues;
        String string3 = Boolean.toString(bl2);
        map.put(string2, string3);
        return this;
    }

    public CustomKeysAndValues$Builder putDouble(String string2, double d10) {
        Map map = this.keysAndValues;
        String string3 = Double.toString(d10);
        map.put(string2, string3);
        return this;
    }

    public CustomKeysAndValues$Builder putFloat(String string2, float f10) {
        Map map = this.keysAndValues;
        String string3 = Float.toString(f10);
        map.put(string2, string3);
        return this;
    }

    public CustomKeysAndValues$Builder putInt(String string2, int n10) {
        Map map = this.keysAndValues;
        String string3 = Integer.toString(n10);
        map.put(string2, string3);
        return this;
    }

    public CustomKeysAndValues$Builder putLong(String string2, long l10) {
        Map map = this.keysAndValues;
        String string3 = Long.toString(l10);
        map.put(string2, string3);
        return this;
    }

    public CustomKeysAndValues$Builder putString(String string2, String string3) {
        this.keysAndValues.put(string2, string3);
        return this;
    }
}

