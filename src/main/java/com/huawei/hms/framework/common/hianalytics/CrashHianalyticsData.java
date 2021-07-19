/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Process
 */
package com.huawei.hms.framework.common.hianalytics;

import android.os.Process;
import com.huawei.hms.framework.common.hianalytics.HianalyticsBaseData;

public class CrashHianalyticsData
extends HianalyticsBaseData {
    public static final String EXCEPTION_NAME = "exception_name";
    public static final String MESSAGE = "message";
    public static final String PROCESS_ID = "process_id";
    public static final String STACK_TRACE = "stack_trace";
    public static final String THREAD_ID = "thread_id";
    public static final String THREAD_NAME = "thread_name";
    public static final String TIME = "time";

    public CrashHianalyticsData() {
        this.put("sdk_name", "Restclient_Crash");
        CharSequence charSequence = new StringBuilder();
        String string2 = "";
        ((StringBuilder)charSequence).append(string2);
        long l10 = System.currentTimeMillis();
        ((StringBuilder)charSequence).append(l10);
        charSequence = ((StringBuilder)charSequence).toString();
        this.put(TIME, (String)charSequence);
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append(string2);
        int n10 = Process.myPid();
        ((StringBuilder)charSequence).append(n10);
        charSequence = ((StringBuilder)charSequence).toString();
        this.put(PROCESS_ID, (String)charSequence);
        ((StringBuilder)charSequence).append(string2);
        int n11 = Process.myTid();
        ((StringBuilder)charSequence).append(n11);
        charSequence = ((StringBuilder)charSequence).toString();
        this.put(THREAD_ID, (String)charSequence);
    }
}

