/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.scheduling.jobscheduling.AlarmManagerSchedulerBroadcastReceiver;

public final class AlarmManagerSchedulerBroadcastReceiver$$Lambda$1
implements Runnable {
    private static final AlarmManagerSchedulerBroadcastReceiver$$Lambda$1 instance;

    static {
        AlarmManagerSchedulerBroadcastReceiver$$Lambda$1 alarmManagerSchedulerBroadcastReceiver$$Lambda$1;
        instance = alarmManagerSchedulerBroadcastReceiver$$Lambda$1 = new AlarmManagerSchedulerBroadcastReceiver$$Lambda$1();
    }

    private AlarmManagerSchedulerBroadcastReceiver$$Lambda$1() {
    }

    public static Runnable lambdaFactory$() {
        return instance;
    }

    public void run() {
        AlarmManagerSchedulerBroadcastReceiver.lambda$onReceive$0();
    }
}

