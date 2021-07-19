/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.hms.framework.common.hianalytics;

import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.huawei.hms.framework.common.hianalytics.HianalyticsBaseData;
import com.huawei.hms.framework.common.hianalytics.HianalyticsHelper;
import java.util.LinkedHashMap;

public class HianalyticsHelper$1
implements Runnable {
    public final /* synthetic */ HianalyticsHelper this$0;
    public final /* synthetic */ Throwable val$e;
    public final /* synthetic */ String val$eventId;
    public final /* synthetic */ String val$threadName;

    public HianalyticsHelper$1(HianalyticsHelper hianalyticsHelper, String string2, Throwable throwable, String string3) {
        this.this$0 = hianalyticsHelper;
        this.val$threadName = string2;
        this.val$e = throwable;
        this.val$eventId = string3;
    }

    public void run() {
        Object object = new CrashHianalyticsData();
        Object object2 = this.val$threadName;
        ((HianalyticsBaseData)object).put("thread_name", (String)object2);
        object2 = this.val$e.getClass().getName();
        ((HianalyticsBaseData)object).put("exception_name", (String)object2);
        object2 = StringUtils.anonymizeMessage(this.val$e.getMessage());
        ((HianalyticsBaseData)object).put("message", (String)object2);
        object2 = StringUtils.getTraceInfo(this.val$e);
        ((HianalyticsBaseData)object).put("stack_trace", (String)object2);
        object2 = HianalyticsHelper.getInstance();
        object = ((HianalyticsBaseData)object).get();
        String string2 = this.val$eventId;
        ((HianalyticsHelper)object2).onEvent((LinkedHashMap)object, string2);
    }
}

