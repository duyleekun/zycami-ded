/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 */
package com.google.firebase.analytics.connector;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzbr;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.DataCollectionDefaultChange;
import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.analytics.connector.AnalyticsConnector$AnalyticsConnectorHandle;
import com.google.firebase.analytics.connector.AnalyticsConnector$AnalyticsConnectorListener;
import com.google.firebase.analytics.connector.AnalyticsConnector$ConditionalUserProperty;
import com.google.firebase.analytics.connector.AnalyticsConnectorImpl$1;
import com.google.firebase.analytics.connector.internal.zzc;
import com.google.firebase.analytics.connector.internal.zze;
import com.google.firebase.analytics.connector.internal.zzg;
import com.google.firebase.analytics.connector.zza;
import com.google.firebase.analytics.connector.zzb;
import com.google.firebase.events.Event;
import com.google.firebase.events.EventHandler;
import com.google.firebase.events.Subscriber;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;

public class AnalyticsConnectorImpl
implements AnalyticsConnector {
    private static volatile AnalyticsConnector zzc;
    public final AppMeasurementSdk zza;
    public final Map zzb;

    public AnalyticsConnectorImpl(AppMeasurementSdk concurrentHashMap) {
        Preconditions.checkNotNull(concurrentHashMap);
        this.zza = concurrentHashMap;
        this.zzb = concurrentHashMap = new ConcurrentHashMap();
    }

    public static AnalyticsConnector getInstance() {
        return AnalyticsConnectorImpl.getInstance(FirebaseApp.getInstance());
    }

    public static AnalyticsConnector getInstance(FirebaseApp firebaseApp) {
        return (AnalyticsConnector)firebaseApp.get(AnalyticsConnector.class);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static AnalyticsConnector getInstance(FirebaseApp object, Context object2, Subscriber object3) {
        Preconditions.checkNotNull(object);
        Preconditions.checkNotNull(object2);
        Preconditions.checkNotNull(object3);
        Preconditions.checkNotNull(object2.getApplicationContext());
        Object object4 = zzc;
        if (object4 != null) return zzc;
        object4 = AnalyticsConnectorImpl.class;
        synchronized (object4) {
            AnalyticsConnector analyticsConnector = zzc;
            if (analyticsConnector != null) return zzc;
            int n10 = 1;
            analyticsConnector = new Bundle(n10);
            n10 = (int)(((FirebaseApp)object).isDefaultApp() ? 1 : 0);
            if (n10 != 0) {
                Class<DataCollectionDefaultChange> clazz = DataCollectionDefaultChange.class;
                Executor executor = com.google.firebase.analytics.connector.zza.zza;
                EventHandler eventHandler = com.google.firebase.analytics.connector.zzb.zza;
                object3.subscribe(clazz, executor, eventHandler);
                object3 = "dataCollectionDefaultEnabled";
                boolean bl2 = ((FirebaseApp)object).isDataCollectionDefaultEnabled();
                analyticsConnector.putBoolean((String)object3, bl2);
            }
            object3 = null;
            object2 = zzbr.zza((Context)object2, null, null, null, (Bundle)analyticsConnector);
            object2 = ((zzbr)object2).zzb();
            zzc = object = new AnalyticsConnectorImpl((AppMeasurementSdk)object2);
            return zzc;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static final /* synthetic */ void zza(Event object) {
        object = (DataCollectionDefaultChange)((Event)object).getPayload();
        boolean bl2 = ((DataCollectionDefaultChange)object).enabled;
        Class<AnalyticsConnectorImpl> clazz = AnalyticsConnectorImpl.class;
        synchronized (clazz) {
            Object object2 = zzc;
            object2 = Preconditions.checkNotNull(object2);
            object2 = (AnalyticsConnectorImpl)object2;
            object2 = ((AnalyticsConnectorImpl)object2).zza;
            ((AppMeasurementSdk)object2).zza(bl2);
            return;
        }
    }

    public static /* synthetic */ boolean zzb(AnalyticsConnectorImpl analyticsConnectorImpl, String string2) {
        return analyticsConnectorImpl.zzc(string2);
    }

    private final boolean zzc(String string2) {
        Map map;
        boolean bl2 = string2.isEmpty();
        return !bl2 && (bl2 = (map = this.zzb).containsKey(string2)) && (string2 = (map = this.zzb).get(string2)) != null;
    }

    public void clearConditionalUserProperty(String string2, String string3, Bundle bundle) {
        boolean bl2;
        if (string3 != null && !(bl2 = com.google.firebase.analytics.connector.internal.zzc.zzb(string3, bundle))) {
            return;
        }
        this.zza.clearConditionalUserProperty(string2, string3, bundle);
    }

    public List getConditionalUserProperties(String object, String object2) {
        boolean bl2;
        ArrayList<Object> arrayList = new ArrayList<Object>();
        AppMeasurementSdk appMeasurementSdk = this.zza;
        object = appMeasurementSdk.getConditionalUserProperties((String)object, (String)object2).iterator();
        while (bl2 = object.hasNext()) {
            object2 = com.google.firebase.analytics.connector.internal.zzc.zzh((Bundle)object.next());
            arrayList.add(object2);
        }
        return arrayList;
    }

    public int getMaxUserProperties(String string2) {
        return this.zza.getMaxUserProperties(string2);
    }

    public Map getUserProperties(boolean bl2) {
        return this.zza.getUserProperties(null, null, bl2);
    }

    public void logEvent(String string2, String string3, Bundle bundle) {
        boolean bl2;
        if (bundle == null) {
            bundle = new Bundle();
        }
        if (!(bl2 = com.google.firebase.analytics.connector.internal.zzc.zza(string2))) {
            return;
        }
        bl2 = com.google.firebase.analytics.connector.internal.zzc.zzb(string3, bundle);
        if (!bl2) {
            return;
        }
        bl2 = com.google.firebase.analytics.connector.internal.zzc.zzf(string2, string3, bundle);
        if (!bl2) {
            return;
        }
        com.google.firebase.analytics.connector.internal.zzc.zzm(string2, string3, bundle);
        this.zza.logEvent(string2, string3, bundle);
    }

    public AnalyticsConnector$AnalyticsConnectorHandle registerAnalyticsConnectorListener(String string2, AnalyticsConnector$AnalyticsConnectorListener object) {
        Preconditions.checkNotNull(object);
        boolean bl2 = com.google.firebase.analytics.connector.internal.zzc.zza(string2);
        if (!bl2) {
            return null;
        }
        bl2 = this.zzc(string2);
        if (bl2) {
            return null;
        }
        AppMeasurementSdk appMeasurementSdk = this.zza;
        Object object2 = "fiam";
        boolean bl3 = ((String)object2).equals(string2);
        if (bl3) {
            object2 = new zze(appMeasurementSdk, (AnalyticsConnector$AnalyticsConnectorListener)object);
        } else {
            object2 = "crash";
            bl3 = ((String)object2).equals(string2);
            if (!bl3 && !(bl3 = ((String)(object2 = "clx")).equals(string2))) {
                bl3 = false;
                object2 = null;
            } else {
                object2 = new zzg(appMeasurementSdk, (AnalyticsConnector$AnalyticsConnectorListener)object);
            }
        }
        if (object2 != null) {
            this.zzb.put(string2, object2);
            object = new AnalyticsConnectorImpl$1(this, string2);
            return object;
        }
        return null;
    }

    public void setConditionalUserProperty(AnalyticsConnector$ConditionalUserProperty analyticsConnector$ConditionalUserProperty) {
        boolean bl2 = com.google.firebase.analytics.connector.internal.zzc.zze(analyticsConnector$ConditionalUserProperty);
        if (!bl2) {
            return;
        }
        AppMeasurementSdk appMeasurementSdk = this.zza;
        analyticsConnector$ConditionalUserProperty = com.google.firebase.analytics.connector.internal.zzc.zzg(analyticsConnector$ConditionalUserProperty);
        appMeasurementSdk.setConditionalUserProperty((Bundle)analyticsConnector$ConditionalUserProperty);
    }

    public void setUserProperty(String string2, String string3, Object object) {
        boolean bl2 = com.google.firebase.analytics.connector.internal.zzc.zza(string2);
        if (!bl2) {
            return;
        }
        bl2 = com.google.firebase.analytics.connector.internal.zzc.zzd(string2, string3);
        if (!bl2) {
            return;
        }
        this.zza.setUserProperty(string2, string3, object);
    }
}

