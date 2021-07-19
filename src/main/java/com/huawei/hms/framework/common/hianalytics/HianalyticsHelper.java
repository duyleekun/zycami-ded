/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.provider.Settings$Secure
 *  com.huawei.hianalytics.process.HiAnalyticsInstance
 *  com.huawei.hianalytics.process.HiAnalyticsManager
 *  com.huawei.hianalytics.v2.HiAnalytics
 */
package com.huawei.hms.framework.common.hianalytics;

import android.content.ContentResolver;
import android.content.Context;
import android.provider.Settings;
import com.huawei.hianalytics.process.HiAnalyticsInstance;
import com.huawei.hianalytics.process.HiAnalyticsManager;
import com.huawei.hianalytics.v2.HiAnalytics;
import com.huawei.hms.framework.common.ExecutorsUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.hianalytics.HianalyticsHelper$1;
import java.util.LinkedHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;

public class HianalyticsHelper {
    private static final String EVENT_ID = "networkkit_restclient";
    private static final String HWID_HA_SERVICE_TAG = "hms_hwid";
    private static final String TAG = "HianalyticsHelper";
    private static final int TYPE_MAINTF = 1;
    private static final String USER_EXPERIENCE_INVOLVED = "user_experience_involved";
    private static final int USER_EXPERIENCE_ON = 1;
    private static volatile HianalyticsHelper instance;
    private HiAnalyticsInstance hInstance;
    private String haTag = "hms_hwid";
    private boolean hasHianalytics;
    private ExecutorService reportExecutor;

    private HianalyticsHelper() {
        ExecutorService executorService;
        boolean bl2 = false;
        this.hInstance = null;
        this.reportExecutor = executorService = ExecutorsUtils.newSingleThreadExecutor("report_ha");
        HiAnalytics.getInitFlag();
        bl2 = true;
        try {
            this.hasHianalytics = bl2;
        }
        catch (Throwable throwable) {
            String string2 = "maybe you need add Hianalytics sdk";
            Logger.w(TAG, string2);
            bl2 = false;
            executorService = null;
            this.hasHianalytics = false;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static HianalyticsHelper getInstance() {
        Object object = instance;
        if (object != null) return instance;
        object = HianalyticsHelper.class;
        synchronized (object) {
            HianalyticsHelper hianalyticsHelper = instance;
            if (hianalyticsHelper != null) return instance;
            instance = hianalyticsHelper = new HianalyticsHelper();
            return instance;
        }
    }

    public ExecutorService getReportExecutor() {
        return this.reportExecutor;
    }

    public boolean isEnableReport(Context context) {
        boolean bl2 = this.hasHianalytics;
        if (!bl2) {
            return false;
        }
        return this.isEnableReportNoSeed(context);
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     */
    public boolean isEnableReportNoSeed(Context object) {
        void var1_3;
        int n10 = this.hasHianalytics;
        String string2 = TAG;
        int n11 = 0;
        if (!n10) {
            String string3 = "Hianalytics sdk need to be initialized";
        } else if (object == null) {
            String string4 = "HianalyticsHelper context can't be null";
        } else {
            String string5;
            ContentResolver contentResolver = object.getContentResolver();
            int n12 = Settings.Secure.getInt((ContentResolver)contentResolver, (String)(string5 = USER_EXPERIENCE_INVOLVED), (int)-1);
            if (n12 == (n10 = 1)) {
                HiAnalyticsInstance hiAnalyticsInstance;
                n12 = (int)(HiAnalytics.getInitFlag() ? 1 : 0);
                if (n12 != 0) {
                    return n10;
                }
                HiAnalyticsInstance hiAnalyticsInstance2 = this.hInstance;
                if (hiAnalyticsInstance2 == null) {
                    HiAnalyticsInstance hiAnalyticsInstance3;
                    this.hInstance = hiAnalyticsInstance3 = HiAnalyticsManager.getInstanceByTag((String)this.haTag);
                }
                if ((hiAnalyticsInstance = this.hInstance) == null) return n11;
                return n10;
            }
            String string6 = "user experience involved needs to be opened";
        }
        Logger.i(string2, var1_3);
        return false;
    }

    public void onEvent(LinkedHashMap linkedHashMap) {
        this.onEvent(linkedHashMap, EVENT_ID);
    }

    public void onEvent(LinkedHashMap linkedHashMap, String string2) {
        int n10 = (int)(this.hasHianalytics ? 1 : 0);
        if (n10 == 0) {
            return;
        }
        if (linkedHashMap == null) {
            return;
        }
        n10 = 1;
        HiAnalyticsInstance hiAnalyticsInstance = new Object[n10];
        hiAnalyticsInstance[0] = linkedHashMap;
        String string3 = TAG;
        String string4 = "data = %s";
        Logger.v(string3, string4, (Object[])hiAnalyticsInstance);
        boolean bl2 = HiAnalytics.getInitFlag();
        if (bl2) {
            HiAnalytics.onEvent((int)n10, (String)string2, (LinkedHashMap)linkedHashMap);
        } else {
            hiAnalyticsInstance = this.hInstance;
            if (hiAnalyticsInstance != null) {
                hiAnalyticsInstance.onEvent(n10, string2, linkedHashMap);
            }
        }
    }

    public void reportException(Throwable object, String objectArray) {
        String string2 = TAG;
        String string3 = Thread.currentThread().getName();
        ExecutorService executorService = this.reportExecutor;
        HianalyticsHelper$1 hianalyticsHelper$1 = new HianalyticsHelper$1(this, string3, (Throwable)object, (String)objectArray);
        try {
            executorService.submit(hianalyticsHelper$1);
        }
        catch (Exception exception) {
            int n10 = 1;
            objectArray = new Object[n10];
            string3 = null;
            objectArray[0] = object;
            object = "reportException error!";
            Logger.i(string2, (String)object, objectArray);
        }
        catch (RejectedExecutionException rejectedExecutionException) {
            object = "reportException error RejectedExecutionException";
            Logger.i(string2, object);
        }
    }

    public void setHaTag(String string2) {
        this.haTag = string2;
    }
}

