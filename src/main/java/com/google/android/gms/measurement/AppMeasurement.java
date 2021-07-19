/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 */
package com.google.android.gms.measurement;

import android.content.Context;
import android.os.Bundle;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzy;
import com.google.android.gms.measurement.AppMeasurement$ConditionalUserProperty;
import com.google.android.gms.measurement.AppMeasurement$EventInterceptor;
import com.google.android.gms.measurement.AppMeasurement$OnEventListener;
import com.google.android.gms.measurement.internal.zzd;
import com.google.android.gms.measurement.internal.zzfl;
import com.google.android.gms.measurement.internal.zzhn;
import com.google.android.gms.measurement.internal.zzho;
import com.google.android.gms.measurement.internal.zzkg;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AppMeasurement {
    public static final String CRASH_ORIGIN = "crash";
    public static final String FCM_ORIGIN = "fcm";
    public static final String FIAM_ORIGIN = "fiam";
    private static volatile AppMeasurement zza;
    private final zzfl zzb;
    private final zzho zzc;

    public AppMeasurement(zzfl zzfl2) {
        Preconditions.checkNotNull(zzfl2);
        this.zzb = zzfl2;
        this.zzc = null;
    }

    public AppMeasurement(zzho zzho2) {
        Preconditions.checkNotNull(zzho2);
        this.zzc = zzho2;
        this.zzb = null;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static AppMeasurement getInstance(Context object) {
        Object object2 = zza;
        if (object2 != null) return zza;
        object2 = AppMeasurement.class;
        synchronized (object2) {
            int n10;
            Object object3;
            AppMeasurement appMeasurement;
            block8: {
                int n11;
                appMeasurement = zza;
                if (appMeasurement != null) return zza;
                appMeasurement = null;
                object3 = "com.google.firebase.analytics.FirebaseAnalytics";
                try {
                    object3 = Class.forName((String)object3);
                    n11 = 2;
                }
                catch (ClassNotFoundException exception) {
                    object3 = null;
                    break block8;
                }
                {
                    Class[] classArray = new Class[n11];
                    Object object4 = Context.class;
                    classArray[0] = object4;
                    object4 = Bundle.class;
                    n10 = 1;
                    classArray[n10] = object4;
                    object4 = "getScionFrontendApiImplementation";
                    object3 = ((Class)object3).getDeclaredMethod((String)object4, classArray);
                    Object[] objectArray = new Object[n11];
                    objectArray[0] = object;
                    objectArray[n10] = null;
                    object3 = ((Method)object3).invoke(null, objectArray);
                    object3 = (zzho)object3;
                }
            }
            if (object3 != null) {
                object = new AppMeasurement((zzho)object3);
                zza = object;
            } else {
                zzy zzy2;
                long l10 = 0L;
                long l11 = 0L;
                n10 = 1;
                object3 = zzy2;
                zzy2 = new zzy(l10, l11, n10 != 0, null, null, null, null, null);
                object = zzfl.zzC(object, zzy2, null);
                zza = appMeasurement = new AppMeasurement((zzfl)object);
            }
            return zza;
        }
    }

    public void beginAdUnitExposure(String string2) {
        Object object = this.zzc;
        if (object != null) {
            object.zzl(string2);
            return;
        }
        Preconditions.checkNotNull(this.zzb);
        object = this.zzb.zzB();
        long l10 = this.zzb.zzax().elapsedRealtime();
        ((zzd)object).zza(string2, l10);
    }

    public void clearConditionalUserProperty(String string2, String string3, Bundle bundle) {
        zzho zzho2 = this.zzc;
        if (zzho2 != null) {
            zzho2.zzo(string2, string3, bundle);
            return;
        }
        Preconditions.checkNotNull(this.zzb);
        this.zzb.zzk().zzO(string2, string3, bundle);
    }

    public void endAdUnitExposure(String string2) {
        Object object = this.zzc;
        if (object != null) {
            object.zzm(string2);
            return;
        }
        Preconditions.checkNotNull(this.zzb);
        object = this.zzb.zzB();
        long l10 = this.zzb.zzax().elapsedRealtime();
        ((zzd)object).zzb(string2, l10);
    }

    public long generateEventId() {
        zzho zzho2 = this.zzc;
        if (zzho2 != null) {
            return zzho2.zzk();
        }
        Preconditions.checkNotNull(this.zzb);
        return this.zzb.zzl().zzd();
    }

    public String getAppInstanceId() {
        zzho zzho2 = this.zzc;
        if (zzho2 != null) {
            return zzho2.zzi();
        }
        Preconditions.checkNotNull(this.zzb);
        return this.zzb.zzk().zzD();
    }

    public Boolean getBoolean() {
        zzho zzho2 = this.zzc;
        if (zzho2 != null) {
            return (Boolean)zzho2.zzr(4);
        }
        Preconditions.checkNotNull(this.zzb);
        return this.zzb.zzk().zzi();
    }

    public List getConditionalUserProperties(String iterator2, String arrayList) {
        int n10;
        Object object = this.zzc;
        if (object != null) {
            iterator2 = object.zzp((String)((Object)iterator2), (String)((Object)arrayList));
        } else {
            Preconditions.checkNotNull(this.zzb);
            object = this.zzb.zzk();
            iterator2 = ((zzhn)object).zzP((String)((Object)iterator2), (String)((Object)arrayList));
        }
        if (iterator2 == null) {
            n10 = 0;
            object = null;
        } else {
            n10 = iterator2.size();
        }
        arrayList = new ArrayList<AppMeasurement$ConditionalUserProperty>(n10);
        iterator2 = iterator2.iterator();
        while ((n10 = (int)(iterator2.hasNext() ? 1 : 0)) != 0) {
            object = (Bundle)iterator2.next();
            AppMeasurement$ConditionalUserProperty appMeasurement$ConditionalUserProperty = new AppMeasurement$ConditionalUserProperty((Bundle)object);
            arrayList.add(appMeasurement$ConditionalUserProperty);
        }
        return arrayList;
    }

    public String getCurrentScreenClass() {
        zzho zzho2 = this.zzc;
        if (zzho2 != null) {
            return zzho2.zzh();
        }
        Preconditions.checkNotNull(this.zzb);
        return this.zzb.zzk().zzS();
    }

    public String getCurrentScreenName() {
        zzho zzho2 = this.zzc;
        if (zzho2 != null) {
            return zzho2.zzg();
        }
        Preconditions.checkNotNull(this.zzb);
        return this.zzb.zzk().zzR();
    }

    public Double getDouble() {
        zzho zzho2 = this.zzc;
        if (zzho2 != null) {
            return (Double)zzho2.zzr(2);
        }
        Preconditions.checkNotNull(this.zzb);
        return this.zzb.zzk().zzm();
    }

    public String getGmpAppId() {
        zzho zzho2 = this.zzc;
        if (zzho2 != null) {
            return zzho2.zzj();
        }
        Preconditions.checkNotNull(this.zzb);
        return this.zzb.zzk().zzT();
    }

    public Integer getInteger() {
        zzho zzho2 = this.zzc;
        if (zzho2 != null) {
            return (Integer)zzho2.zzr(3);
        }
        Preconditions.checkNotNull(this.zzb);
        return this.zzb.zzk().zzl();
    }

    public Long getLong() {
        zzho zzho2 = this.zzc;
        if (zzho2 != null) {
            return (Long)zzho2.zzr(1);
        }
        Preconditions.checkNotNull(this.zzb);
        return this.zzb.zzk().zzk();
    }

    public int getMaxUserProperties(String string2) {
        zzho zzho2 = this.zzc;
        if (zzho2 != null) {
            return zzho2.zzq(string2);
        }
        Preconditions.checkNotNull(this.zzb);
        this.zzb.zzk().zzL(string2);
        return 25;
    }

    public String getString() {
        zzho zzho2 = this.zzc;
        if (zzho2 != null) {
            return (String)zzho2.zzr(0);
        }
        Preconditions.checkNotNull(this.zzb);
        return this.zzb.zzk().zzj();
    }

    public Map getUserProperties(String string2, String string3, boolean bl2) {
        zzho zzho2 = this.zzc;
        if (zzho2 != null) {
            return zzho2.zzc(string2, string3, bl2);
        }
        Preconditions.checkNotNull(this.zzb);
        return this.zzb.zzk().zzQ(string2, string3, bl2);
    }

    public Map getUserProperties(boolean bl2) {
        Object object = this.zzc;
        if (object != null) {
            return object.zzc(null, null, bl2);
        }
        Preconditions.checkNotNull(this.zzb);
        Object object2 = this.zzb.zzk().zzC(bl2);
        int n10 = object2.size();
        object = new ArrayMap(n10);
        object2 = object2.iterator();
        while ((n10 = (int)(object2.hasNext() ? 1 : 0)) != 0) {
            Object object3 = (zzkg)object2.next();
            Object object4 = ((zzkg)object3).zza();
            if (object4 == null) continue;
            object3 = ((zzkg)object3).zzb;
            object.put(object3, object4);
        }
        return object;
    }

    public void logEventInternal(String string2, String string3, Bundle bundle) {
        zzho zzho2 = this.zzc;
        if (zzho2 != null) {
            zzho2.zza(string2, string3, bundle);
            return;
        }
        Preconditions.checkNotNull(this.zzb);
        this.zzb.zzk().zzs(string2, string3, bundle);
    }

    public void logEventInternalNoInterceptor(String string2, String string3, Bundle bundle, long l10) {
        zzho zzho2 = this.zzc;
        if (zzho2 != null) {
            zzho2.zzb(string2, string3, bundle, l10);
            return;
        }
        Preconditions.checkNotNull(this.zzb);
        this.zzb.zzk().zzv(string2, string3, bundle, true, false, l10);
    }

    public void registerOnMeasurementEventListener(AppMeasurement$OnEventListener appMeasurement$OnEventListener) {
        zzho zzho2 = this.zzc;
        if (zzho2 != null) {
            zzho2.zze(appMeasurement$OnEventListener);
            return;
        }
        Preconditions.checkNotNull(this.zzb);
        this.zzb.zzk().zzJ(appMeasurement$OnEventListener);
    }

    public void setConditionalUserProperty(AppMeasurement$ConditionalUserProperty appMeasurement$ConditionalUserProperty) {
        Preconditions.checkNotNull(appMeasurement$ConditionalUserProperty);
        Object object = this.zzc;
        if (object != null) {
            appMeasurement$ConditionalUserProperty = appMeasurement$ConditionalUserProperty.zza();
            object.zzn((Bundle)appMeasurement$ConditionalUserProperty);
            return;
        }
        Preconditions.checkNotNull(this.zzb);
        object = this.zzb.zzk();
        appMeasurement$ConditionalUserProperty = appMeasurement$ConditionalUserProperty.zza();
        ((zzhn)object).zzM((Bundle)appMeasurement$ConditionalUserProperty);
    }

    public void setEventInterceptor(AppMeasurement$EventInterceptor appMeasurement$EventInterceptor) {
        zzho zzho2 = this.zzc;
        if (zzho2 != null) {
            zzho2.zzd(appMeasurement$EventInterceptor);
            return;
        }
        Preconditions.checkNotNull(this.zzb);
        this.zzb.zzk().zzI(appMeasurement$EventInterceptor);
    }

    public void unregisterOnMeasurementEventListener(AppMeasurement$OnEventListener appMeasurement$OnEventListener) {
        zzho zzho2 = this.zzc;
        if (zzho2 != null) {
            zzho2.zzf(appMeasurement$OnEventListener);
            return;
        }
        Preconditions.checkNotNull(this.zzb);
        this.zzb.zzk().zzK(appMeasurement$OnEventListener);
    }
}

