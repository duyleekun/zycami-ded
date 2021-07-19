/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.ApplicationInfo
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.os.Bundle
 *  android.util.Log
 */
package com.google.firebase.perf;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import com.google.firebase.FirebaseApp;
import com.google.firebase.inject.Provider;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.perf.FirebasePerformanceAttributable;
import com.google.firebase.perf.config.ConfigResolver;
import com.google.firebase.perf.internal.GaugeManager;
import com.google.firebase.perf.internal.PerfMetricValidator;
import com.google.firebase.perf.internal.RemoteConfigManager;
import com.google.firebase.perf.logging.AndroidLogger;
import com.google.firebase.perf.metrics.HttpMetric;
import com.google.firebase.perf.metrics.Trace;
import com.google.firebase.perf.transport.TransportManager;
import com.google.firebase.perf.util.ImmutableBundle;
import com.google.firebase.perf.util.Timer;
import java.net.URL;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class FirebasePerformance
implements FirebasePerformanceAttributable {
    private static final int MAX_ATTRIBUTE_KEY_LENGTH = 40;
    private static final int MAX_ATTRIBUTE_VALUE_LENGTH = 100;
    private static final int MAX_TRACE_CUSTOM_ATTRIBUTES = 5;
    public static final int MAX_TRACE_NAME_LENGTH = 100;
    private static final AndroidLogger logger = AndroidLogger.getInstance();
    private final ConfigResolver configResolver;
    private final Map mCustomAttributes;
    private final ImmutableBundle mMetadataBundle;
    private Boolean mPerformanceCollectionForceEnabledState;

    public FirebasePerformance(FirebaseApp firebaseApp, Provider provider, FirebaseInstallationsApi firebaseInstallationsApi, Provider provider2) {
        RemoteConfigManager remoteConfigManager = RemoteConfigManager.getInstance();
        ConfigResolver configResolver = ConfigResolver.getInstance();
        GaugeManager gaugeManager = GaugeManager.getInstance();
        this(firebaseApp, provider, firebaseInstallationsApi, provider2, remoteConfigManager, configResolver, gaugeManager);
    }

    public FirebasePerformance(FirebaseApp object, Provider provider, FirebaseInstallationsApi object2, Provider provider2, RemoteConfigManager remoteConfigManager, ConfigResolver configResolver, GaugeManager gaugeManager) {
        ConcurrentHashMap concurrentHashMap;
        this.mCustomAttributes = concurrentHashMap = new ConcurrentHashMap();
        concurrentHashMap = null;
        this.mPerformanceCollectionForceEnabledState = null;
        if (object == null) {
            this.mPerformanceCollectionForceEnabledState = object = Boolean.FALSE;
            this.configResolver = configResolver;
            this.mMetadataBundle = object = new ImmutableBundle((Bundle)provider);
            return;
        }
        TransportManager.getInstance().initialize((FirebaseApp)object, (FirebaseInstallationsApi)object2, provider2);
        object = ((FirebaseApp)object).getApplicationContext();
        this.mMetadataBundle = object2 = FirebasePerformance.extractMetadata((Context)object);
        remoteConfigManager.setFirebaseRemoteConfigProvider(provider);
        this.configResolver = configResolver;
        configResolver.setMetadataBundle((ImmutableBundle)object2);
        configResolver.setApplicationContext((Context)object);
        gaugeManager.setApplicationContext((Context)object);
        this.mPerformanceCollectionForceEnabledState = object = configResolver.getIsPerformanceCollectionEnabled();
    }

    private void checkAttribute(String object, String object2) {
        if (object != null && object2 != null) {
            int n10;
            Object object3 = this.mCustomAttributes;
            int n11 = object3.containsKey(object);
            if (n11 == 0 && (n11 = (object3 = this.mCustomAttributes).size()) >= (n10 = 5)) {
                object2 = Locale.US;
                object3 = new Object[1];
                Integer n12 = n10;
                object3[0] = n12;
                object2 = String.format((Locale)object2, "Exceeds max limit of number of attributes - %d", object3);
                object = new IllegalArgumentException((String)object2);
                throw object;
            }
            object3 = new AbstractMap.SimpleEntry(object, object2);
            if ((object = PerfMetricValidator.validateAttribute(object3)) == null) {
                return;
            }
            object2 = new IllegalArgumentException((String)object);
            throw object2;
        }
        object = new IllegalArgumentException("Attribute must not have null key or value.");
        throw object;
    }

    private static ImmutableBundle extractMetadata(Context object) {
        Object object2;
        block6: {
            object2 = object.getPackageManager();
            object = object.getPackageName();
            int n10 = 128;
            object = object2.getApplicationInfo((String)object, n10);
            try {
                object = ((ApplicationInfo)object).metaData;
                break block6;
            }
            catch (NullPointerException nullPointerException) {
            }
            catch (PackageManager.NameNotFoundException nameNotFoundException) {
                // empty catch block
            }
            object2 = new StringBuilder();
            String string2 = "No perf enable meta data found ";
            ((StringBuilder)object2).append(string2);
            object = ((Throwable)object).getMessage();
            ((StringBuilder)object2).append((String)object);
            object = ((StringBuilder)object2).toString();
            object2 = "isEnabled";
            Log.d((String)object2, (String)object);
            object = null;
        }
        object2 = object != null ? new ImmutableBundle((Bundle)object) : new ImmutableBundle();
        return object2;
    }

    public static FirebasePerformance getInstance() {
        return (FirebasePerformance)FirebaseApp.getInstance().get(FirebasePerformance.class);
    }

    public static Trace startTrace(String object) {
        object = Trace.create((String)object);
        ((Trace)object).start();
        return object;
    }

    public String getAttribute(String string2) {
        return (String)this.mCustomAttributes.get(string2);
    }

    public Map getAttributes() {
        Map map = this.mCustomAttributes;
        HashMap hashMap = new HashMap(map);
        return hashMap;
    }

    public Boolean getPerformanceCollectionForceEnabledState() {
        return this.mPerformanceCollectionForceEnabledState;
    }

    public boolean isPerformanceCollectionEnabled() {
        boolean bl2;
        Object object = this.mPerformanceCollectionForceEnabledState;
        if (object != null) {
            bl2 = (Boolean)object;
        } else {
            object = FirebaseApp.getInstance();
            bl2 = ((FirebaseApp)object).isDataCollectionDefaultEnabled();
        }
        return bl2;
    }

    public HttpMetric newHttpMetric(String string2, String string3) {
        TransportManager transportManager = TransportManager.getInstance();
        Timer timer = new Timer();
        HttpMetric httpMetric = new HttpMetric(string2, string3, transportManager, timer);
        return httpMetric;
    }

    public HttpMetric newHttpMetric(URL uRL, String string2) {
        TransportManager transportManager = TransportManager.getInstance();
        Timer timer = new Timer();
        HttpMetric httpMetric = new HttpMetric(uRL, string2, transportManager, timer);
        return httpMetric;
    }

    public Trace newTrace(String string2) {
        return Trace.create(string2);
    }

    public void putAttribute(String string2, String string3) {
        int n10 = 0;
        Map map = null;
        int n11 = 1;
        string2 = string2.trim();
        string3 = string3.trim();
        try {
            this.checkAttribute(string2, string3);
            n10 = n11;
        }
        catch (Exception exception) {
            AndroidLogger androidLogger = logger;
            int n12 = 3;
            Object[] objectArray = new Object[n12];
            objectArray[0] = string2;
            objectArray[n11] = string3;
            n11 = 2;
            String string4 = exception.getMessage();
            objectArray[n11] = string4;
            String string5 = "Can not set attribute %s with value %s (%s)";
            androidLogger.error(string5, objectArray);
        }
        if (n10 != 0) {
            map = this.mCustomAttributes;
            map.put(string2, string3);
        }
    }

    public void removeAttribute(String string2) {
        this.mCustomAttributes.remove(string2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void setPerformanceCollectionEnabled(Boolean object) {
        synchronized (this) {
            Object object2;
            try {
                FirebaseApp.getInstance();
                object2 = this.configResolver;
            }
            catch (IllegalStateException illegalStateException) {
                return;
            }
            object2 = ((ConfigResolver)object2).getIsPerformanceCollectionDeactivated();
            boolean bl2 = (Boolean)object2;
            if (bl2) {
                object = logger;
                object2 = "Firebase Performance is permanently disabled";
                ((AndroidLogger)object).info((String)object2);
                return;
            }
            object2 = this.configResolver;
            ((ConfigResolver)object2).setIsPerformanceCollectionEnabled((Boolean)object);
            if (object != null) {
                this.mPerformanceCollectionForceEnabledState = object;
            } else {
                object = this.configResolver;
                this.mPerformanceCollectionForceEnabledState = object = ((ConfigResolver)object).getIsPerformanceCollectionEnabled();
            }
            object = Boolean.TRUE;
            object2 = this.mPerformanceCollectionForceEnabledState;
            boolean bl3 = ((Boolean)object).equals(object2);
            if (bl3) {
                object = logger;
                object2 = "Firebase Performance is Enabled";
                ((AndroidLogger)object).info((String)object2);
            } else {
                object = Boolean.FALSE;
                object2 = this.mPerformanceCollectionForceEnabledState;
                bl3 = ((Boolean)object).equals(object2);
                if (bl3) {
                    object = logger;
                    object2 = "Firebase Performance is Disabled";
                    ((AndroidLogger)object).info((String)object2);
                }
            }
            return;
        }
    }

    public void setPerformanceCollectionEnabled(boolean bl2) {
        Boolean bl3 = bl2;
        this.setPerformanceCollectionEnabled(bl3);
    }
}

