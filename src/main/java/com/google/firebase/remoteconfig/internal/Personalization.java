/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package com.google.firebase.remoteconfig.internal;

import android.os.Bundle;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.remoteconfig.internal.ConfigContainer;

public class Personalization {
    public static final String ANALYTICS_ORIGIN_PERSONALIZATION = "fp";
    public static final String ANALYTICS_PULL_EVENT = "_fpc";
    public static final String ARM_KEY = "_fpid";
    public static final String ARM_VALUE = "_fpct";
    public static final String PERSONALIZATION_ID = "personalizationId";
    private final AnalyticsConnector analyticsConnector;

    public Personalization(AnalyticsConnector analyticsConnector) {
        this.analyticsConnector = analyticsConnector;
    }

    public void logArmActive(String string2, ConfigContainer configContainer) {
        int n10;
        Object object = configContainer.getPersonalizationMetadata();
        int n11 = object.length();
        if (n11 < (n10 = 1)) {
            return;
        }
        n11 = (configContainer = configContainer.getConfigs()).length();
        if (n11 < n10) {
            return;
        }
        if ((object = object.optJSONObject(string2)) == null) {
            return;
        }
        Bundle bundle = new Bundle();
        object = object.optString(PERSONALIZATION_ID);
        bundle.putString(ARM_KEY, (String)object);
        string2 = configContainer.optString(string2);
        bundle.putString(ARM_VALUE, string2);
        this.analyticsConnector.logEvent(ANALYTICS_ORIGIN_PERSONALIZATION, ANALYTICS_PULL_EVENT, bundle);
    }
}

