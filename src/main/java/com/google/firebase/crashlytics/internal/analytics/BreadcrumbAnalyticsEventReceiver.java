/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.google.firebase.crashlytics.internal.analytics;

import android.os.Bundle;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.analytics.AnalyticsEventReceiver;
import com.google.firebase.crashlytics.internal.breadcrumbs.BreadcrumbHandler;
import com.google.firebase.crashlytics.internal.breadcrumbs.BreadcrumbSource;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class BreadcrumbAnalyticsEventReceiver
implements AnalyticsEventReceiver,
BreadcrumbSource {
    private static final String BREADCRUMB_NAME_KEY = "name";
    private static final String BREADCRUMB_PARAMS_KEY = "parameters";
    private static final String BREADCRUMB_PREFIX = "$A$:";
    private BreadcrumbHandler breadcrumbHandler;

    private static String serializeEvent(String string2, Bundle bundle) {
        boolean bl2;
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        Iterator iterator2 = bundle.keySet().iterator();
        while (bl2 = iterator2.hasNext()) {
            String string3 = (String)iterator2.next();
            Object object = bundle.get(string3);
            jSONObject2.put(string3, object);
        }
        jSONObject.put(BREADCRUMB_NAME_KEY, (Object)string2);
        jSONObject.put(BREADCRUMB_PARAMS_KEY, (Object)jSONObject2);
        return jSONObject.toString();
    }

    public void onEvent(String object, Bundle object2) {
        BreadcrumbHandler breadcrumbHandler = this.breadcrumbHandler;
        if (breadcrumbHandler != null) {
            StringBuilder stringBuilder = new StringBuilder();
            String string2 = BREADCRUMB_PREFIX;
            stringBuilder.append(string2);
            object = BreadcrumbAnalyticsEventReceiver.serializeEvent((String)object, object2);
            stringBuilder.append((String)object);
            object = stringBuilder.toString();
            try {
                breadcrumbHandler.handleBreadcrumb((String)object);
            }
            catch (JSONException jSONException) {
                object = Logger.getLogger();
                object2 = "Unable to serialize Firebase Analytics event to breadcrumb.";
                ((Logger)object).w((String)object2);
            }
        }
    }

    public void registerBreadcrumbHandler(BreadcrumbHandler breadcrumbHandler) {
        this.breadcrumbHandler = breadcrumbHandler;
        Logger.getLogger().d("Registered Firebase Analytics event receiver for breadcrumbs");
    }
}

