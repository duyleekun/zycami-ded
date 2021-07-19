/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.IInterface
 */
package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IInterface;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.measurement.zzs;
import com.google.android.gms.internal.measurement.zzv;
import com.google.android.gms.internal.measurement.zzx;
import com.google.android.gms.internal.measurement.zzy;
import java.util.Map;

public interface zzp
extends IInterface {
    public void beginAdUnitExposure(String var1, long var2);

    public void clearConditionalUserProperty(String var1, String var2, Bundle var3);

    public void clearMeasurementEnabled(long var1);

    public void endAdUnitExposure(String var1, long var2);

    public void generateEventId(zzs var1);

    public void getAppInstanceId(zzs var1);

    public void getCachedAppInstanceId(zzs var1);

    public void getConditionalUserProperties(String var1, String var2, zzs var3);

    public void getCurrentScreenClass(zzs var1);

    public void getCurrentScreenName(zzs var1);

    public void getGmpAppId(zzs var1);

    public void getMaxUserProperties(String var1, zzs var2);

    public void getTestFlag(zzs var1, int var2);

    public void getUserProperties(String var1, String var2, boolean var3, zzs var4);

    public void initForTests(Map var1);

    public void initialize(IObjectWrapper var1, zzy var2, long var3);

    public void isDataCollectionEnabled(zzs var1);

    public void logEvent(String var1, String var2, Bundle var3, boolean var4, boolean var5, long var6);

    public void logEventAndBundle(String var1, String var2, Bundle var3, zzs var4, long var5);

    public void logHealthData(int var1, String var2, IObjectWrapper var3, IObjectWrapper var4, IObjectWrapper var5);

    public void onActivityCreated(IObjectWrapper var1, Bundle var2, long var3);

    public void onActivityDestroyed(IObjectWrapper var1, long var2);

    public void onActivityPaused(IObjectWrapper var1, long var2);

    public void onActivityResumed(IObjectWrapper var1, long var2);

    public void onActivitySaveInstanceState(IObjectWrapper var1, zzs var2, long var3);

    public void onActivityStarted(IObjectWrapper var1, long var2);

    public void onActivityStopped(IObjectWrapper var1, long var2);

    public void performAction(Bundle var1, zzs var2, long var3);

    public void registerOnMeasurementEventListener(zzv var1);

    public void resetAnalyticsData(long var1);

    public void setConditionalUserProperty(Bundle var1, long var2);

    public void setConsent(Bundle var1, long var2);

    public void setConsentThirdParty(Bundle var1, long var2);

    public void setCurrentScreen(IObjectWrapper var1, String var2, String var3, long var4);

    public void setDataCollectionEnabled(boolean var1);

    public void setDefaultEventParameters(Bundle var1);

    public void setEventInterceptor(zzv var1);

    public void setInstanceIdProvider(zzx var1);

    public void setMeasurementEnabled(boolean var1, long var2);

    public void setMinimumSessionDuration(long var1);

    public void setSessionTimeoutDuration(long var1);

    public void setUserId(String var1, long var2);

    public void setUserProperty(String var1, String var2, IObjectWrapper var3, boolean var4, long var5);

    public void unregisterOnMeasurementEventListener(zzv var1);
}

