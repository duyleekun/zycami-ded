/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.google.firebase.abt.component;

import android.content.Context;
import com.google.firebase.abt.FirebaseABTesting;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import java.util.HashMap;
import java.util.Map;

public class AbtComponent {
    private final Map abtOriginInstances;
    private final AnalyticsConnector analyticsConnector;
    private final Context appContext;

    public AbtComponent(Context context, AnalyticsConnector analyticsConnector) {
        HashMap hashMap;
        this.abtOriginInstances = hashMap = new HashMap();
        this.appContext = context;
        this.analyticsConnector = analyticsConnector;
    }

    public FirebaseABTesting createAbtInstance(String string2) {
        Context context = this.appContext;
        AnalyticsConnector analyticsConnector = this.analyticsConnector;
        FirebaseABTesting firebaseABTesting = new FirebaseABTesting(context, analyticsConnector, string2);
        return firebaseABTesting;
    }

    public FirebaseABTesting get(String object) {
        synchronized (this) {
            Map map = this.abtOriginInstances;
            boolean bl2 = map.containsKey(object);
            if (!bl2) {
                map = this.abtOriginInstances;
                FirebaseABTesting firebaseABTesting = this.createAbtInstance((String)object);
                map.put(object, firebaseABTesting);
            }
            map = this.abtOriginInstances;
            object = map.get(object);
            object = (FirebaseABTesting)object;
            return object;
        }
    }
}

