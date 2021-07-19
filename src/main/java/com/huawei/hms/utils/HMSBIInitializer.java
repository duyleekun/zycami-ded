/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 *  com.huawei.hianalytics.process.HiAnalyticsInstance
 *  com.huawei.hianalytics.process.HiAnalyticsManager
 */
package com.huawei.hms.utils;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hianalytics.process.HiAnalyticsInstance;
import com.huawei.hianalytics.process.HiAnalyticsManager;
import com.huawei.hms.framework.network.grs.GrsApp;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.GrsClient;
import com.huawei.hms.framework.network.grs.IQueryUrlCallBack;
import com.huawei.hms.hatool.HmsHiAnalyticsUtils;
import com.huawei.hms.stats.a;
import com.huawei.hms.stats.c;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.HMSBIInitializer$a;
import com.huawei.hms.utils.HMSBIInitializer$b;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;

public class HMSBIInitializer {
    public static final Object d;
    public static HMSBIInitializer e;
    public static HiAnalyticsInstance f;
    public final Context a;
    public AtomicBoolean b;
    public boolean c;

    static {
        Object object;
        d = object = new Object();
    }

    public HMSBIInitializer(Context context) {
        boolean bl2;
        AtomicBoolean atomicBoolean;
        this.b = atomicBoolean = new AtomicBoolean(false);
        this.a = context;
        this.c = bl2 = com.huawei.hms.stats.c.a();
    }

    public static /* synthetic */ HiAnalyticsInstance a() {
        return f;
    }

    public static /* synthetic */ HiAnalyticsInstance a(HiAnalyticsInstance hiAnalyticsInstance) {
        f = hiAnalyticsInstance;
        return hiAnalyticsInstance;
    }

    public static /* synthetic */ void a(HMSBIInitializer hMSBIInitializer, String string2) {
        hMSBIInitializer.a(string2);
    }

    public static /* synthetic */ boolean a(HMSBIInitializer hMSBIInitializer) {
        return hMSBIInitializer.c;
    }

    public static /* synthetic */ Context b(HMSBIInitializer hMSBIInitializer) {
        return hMSBIInitializer.a;
    }

    public static /* synthetic */ AtomicBoolean c(HMSBIInitializer hMSBIInitializer) {
        return hMSBIInitializer.b;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static HMSBIInitializer getInstance(Context object) {
        Object object2 = d;
        synchronized (object2) {
            HMSBIInitializer hMSBIInitializer = e;
            if (hMSBIInitializer == null) {
                hMSBIInitializer = object.getApplicationContext();
                if (hMSBIInitializer != null) {
                    object = new HMSBIInitializer((Context)hMSBIInitializer);
                    e = object;
                } else {
                    e = hMSBIInitializer = new HMSBIInitializer((Context)object);
                }
            }
            return e;
        }
    }

    public final void a(String object) {
        HMSLog.i("HMSBIInitializer", "Start to query GRS");
        Object object2 = new GrsBaseInfo();
        ((GrsBaseInfo)object2).setIssueCountry((String)object);
        Context context = this.a;
        object = new GrsClient(context, (GrsBaseInfo)object2);
        object2 = new HMSBIInitializer$a(this);
        ((GrsClient)object).ayncGetGrsUrl("com.huawei.cloud.opensdkhianalytics", "ROOT", (IQueryUrlCallBack)object2);
    }

    public HiAnalyticsInstance getAnalyticsInstance() {
        return f;
    }

    public void initBI() {
        Object object;
        boolean bl2 = this.c;
        if (!bl2) {
            bl2 = HmsHiAnalyticsUtils.getInitFlag();
        } else {
            object = "hms_config_tag";
            bl2 = HiAnalyticsManager.getInitFlag((String)object);
        }
        CharSequence charSequence = new StringBuilder();
        charSequence.append("Builder->biInitFlag :");
        charSequence.append(bl2);
        charSequence = charSequence.toString();
        Object object2 = "HMSBIInitializer";
        HMSLog.i(object2, (String)charSequence);
        if (bl2) {
            return;
        }
        object = this.a;
        bl2 = com.huawei.hms.stats.a.c((Context)object);
        if (bl2) {
            return;
        }
        object = this.b;
        charSequence = null;
        int n10 = 1;
        bl2 = ((AtomicBoolean)object).compareAndSet(false, n10 != 0);
        if (bl2) {
            object = GrsApp.getInstance();
            Object object3 = this.a;
            boolean bl3 = TextUtils.isEmpty((CharSequence)(object = ((GrsApp)object).getIssueCountryCode((Context)object3)));
            if (!bl3) {
                object3 = Locale.ENGLISH;
                object = ((String)object).toUpperCase((Locale)object3);
            }
            if (!(bl3 = ((String)(object3 = "UNKNOWN")).equalsIgnoreCase((String)object)) && !(bl3 = TextUtils.isEmpty((CharSequence)object))) {
                bl3 = false;
                object3 = null;
                object2 = new HMSBIInitializer$b(this, null);
                Object[] objectArray = new String[n10];
                objectArray[0] = object;
                object2.execute(objectArray);
            } else {
                HMSLog.e(object2, "Failed to get device issue country");
                object = this.b;
                ((AtomicBoolean)object).set(false);
            }
        }
    }

    public boolean isInit() {
        boolean bl2 = this.c;
        if (!bl2) {
            return HmsHiAnalyticsUtils.getInitFlag();
        }
        return HiAnalyticsManager.getInitFlag((String)"hms_config_tag");
    }
}

