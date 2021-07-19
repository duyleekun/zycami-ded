/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package com.google.android.gms.measurement;

import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.measurement.internal.zzgh;
import com.google.android.gms.measurement.internal.zzht;

public class AppMeasurement$ConditionalUserProperty {
    public boolean mActive;
    public String mAppId;
    public long mCreationTimestamp;
    public String mExpiredEventName;
    public Bundle mExpiredEventParams;
    public String mName;
    public String mOrigin;
    public long mTimeToLive;
    public String mTimedOutEventName;
    public Bundle mTimedOutEventParams;
    public String mTriggerEventName;
    public long mTriggerTimeout;
    public String mTriggeredEventName;
    public Bundle mTriggeredEventParams;
    public long mTriggeredTimestamp;
    public Object mValue;

    public AppMeasurement$ConditionalUserProperty() {
    }

    public AppMeasurement$ConditionalUserProperty(Bundle bundle) {
        long l10;
        long l11;
        boolean bl2;
        String string2;
        long l12;
        Class<Long> clazz = Long.class;
        Object object = String.class;
        Preconditions.checkNotNull(bundle);
        Object object2 = (String)zzgh.zzb(bundle, "app_id", object, null);
        this.mAppId = object2;
        object2 = (String)zzgh.zzb(bundle, "origin", object, null);
        this.mOrigin = object2;
        object2 = (String)zzgh.zzb(bundle, "name", object, null);
        this.mName = object2;
        this.mValue = object2 = zzgh.zzb(bundle, "value", Object.class, null);
        this.mTriggerEventName = object2 = (String)zzgh.zzb(bundle, "trigger_event_name", object, null);
        object2 = 0L;
        this.mTriggerTimeout = l12 = ((Long)zzgh.zzb(bundle, "trigger_timeout", clazz, object2)).longValue();
        this.mTimedOutEventName = string2 = (String)zzgh.zzb(bundle, "timed_out_event_name", object, null);
        string2 = (Bundle)zzgh.zzb(bundle, "timed_out_event_params", Bundle.class, null);
        this.mTimedOutEventParams = string2;
        this.mTriggeredEventName = string2 = (String)zzgh.zzb(bundle, "triggered_event_name", object, null);
        string2 = (Bundle)zzgh.zzb(bundle, "triggered_event_params", Bundle.class, null);
        this.mTriggeredEventParams = string2;
        this.mTimeToLive = l12 = ((Long)zzgh.zzb(bundle, "time_to_live", clazz, object2)).longValue();
        this.mExpiredEventName = object = (String)zzgh.zzb(bundle, "expired_event_name", object, null);
        object = (Bundle)zzgh.zzb(bundle, "expired_event_params", Bundle.class, null);
        this.mExpiredEventParams = object;
        Boolean bl3 = Boolean.FALSE;
        this.mActive = bl2 = ((Boolean)zzgh.zzb(bundle, "active", Boolean.class, bl3)).booleanValue();
        this.mCreationTimestamp = l11 = ((Long)zzgh.zzb(bundle, "creation_timestamp", clazz, object2)).longValue();
        this.mTriggeredTimestamp = l10 = ((Long)zzgh.zzb(bundle, "triggered_timestamp", clazz, object2)).longValue();
    }

    public AppMeasurement$ConditionalUserProperty(AppMeasurement$ConditionalUserProperty appMeasurement$ConditionalUserProperty) {
        Bundle bundle;
        boolean bl2;
        long l10;
        Preconditions.checkNotNull(appMeasurement$ConditionalUserProperty);
        Object object = appMeasurement$ConditionalUserProperty.mAppId;
        this.mAppId = object;
        object = appMeasurement$ConditionalUserProperty.mOrigin;
        this.mOrigin = object;
        this.mCreationTimestamp = l10 = appMeasurement$ConditionalUserProperty.mCreationTimestamp;
        object = appMeasurement$ConditionalUserProperty.mName;
        this.mName = object;
        object = appMeasurement$ConditionalUserProperty.mValue;
        if (object != null) {
            this.mValue = object = zzht.zzc(object);
            if (object == null) {
                this.mValue = object = appMeasurement$ConditionalUserProperty.mValue;
            }
        }
        this.mActive = bl2 = appMeasurement$ConditionalUserProperty.mActive;
        this.mTriggerEventName = object = appMeasurement$ConditionalUserProperty.mTriggerEventName;
        this.mTriggerTimeout = l10 = appMeasurement$ConditionalUserProperty.mTriggerTimeout;
        this.mTimedOutEventName = object = appMeasurement$ConditionalUserProperty.mTimedOutEventName;
        object = appMeasurement$ConditionalUserProperty.mTimedOutEventParams;
        if (object != null) {
            this.mTimedOutEventParams = bundle = new Bundle((Bundle)object);
        }
        this.mTriggeredEventName = object = appMeasurement$ConditionalUserProperty.mTriggeredEventName;
        object = appMeasurement$ConditionalUserProperty.mTriggeredEventParams;
        if (object != null) {
            this.mTriggeredEventParams = bundle = new Bundle((Bundle)object);
        }
        this.mTriggeredTimestamp = l10 = appMeasurement$ConditionalUserProperty.mTriggeredTimestamp;
        this.mTimeToLive = l10 = appMeasurement$ConditionalUserProperty.mTimeToLive;
        this.mExpiredEventName = object = appMeasurement$ConditionalUserProperty.mExpiredEventName;
        appMeasurement$ConditionalUserProperty = appMeasurement$ConditionalUserProperty.mExpiredEventParams;
        if (appMeasurement$ConditionalUserProperty != null) {
            object = new Bundle((Bundle)appMeasurement$ConditionalUserProperty);
            this.mExpiredEventParams = object;
        }
    }

    public final Bundle zza() {
        String string2;
        Bundle bundle = new Bundle();
        Object object = this.mAppId;
        if (object != null) {
            string2 = "app_id";
            bundle.putString(string2, (String)object);
        }
        if ((object = this.mOrigin) != null) {
            string2 = "origin";
            bundle.putString(string2, (String)object);
        }
        if ((object = this.mName) != null) {
            string2 = "name";
            bundle.putString(string2, (String)object);
        }
        if ((object = this.mValue) != null) {
            zzgh.zza(bundle, object);
        }
        if ((object = this.mTriggerEventName) != null) {
            string2 = "trigger_event_name";
            bundle.putString(string2, (String)object);
        }
        long l10 = this.mTriggerTimeout;
        String string3 = "trigger_timeout";
        bundle.putLong(string3, l10);
        object = this.mTimedOutEventName;
        if (object != null) {
            string2 = "timed_out_event_name";
            bundle.putString(string2, (String)object);
        }
        if ((object = this.mTimedOutEventParams) != null) {
            string2 = "timed_out_event_params";
            bundle.putBundle(string2, (Bundle)object);
        }
        if ((object = this.mTriggeredEventName) != null) {
            string2 = "triggered_event_name";
            bundle.putString(string2, (String)object);
        }
        if ((object = this.mTriggeredEventParams) != null) {
            string2 = "triggered_event_params";
            bundle.putBundle(string2, (Bundle)object);
        }
        l10 = this.mTimeToLive;
        string3 = "time_to_live";
        bundle.putLong(string3, l10);
        object = this.mExpiredEventName;
        if (object != null) {
            string2 = "expired_event_name";
            bundle.putString(string2, (String)object);
        }
        if ((object = this.mExpiredEventParams) != null) {
            string2 = "expired_event_params";
            bundle.putBundle(string2, (Bundle)object);
        }
        l10 = this.mCreationTimestamp;
        bundle.putLong("creation_timestamp", l10);
        boolean bl2 = this.mActive;
        bundle.putBoolean("active", bl2);
        l10 = this.mTriggeredTimestamp;
        bundle.putLong("triggered_timestamp", l10);
        return bundle;
    }
}

