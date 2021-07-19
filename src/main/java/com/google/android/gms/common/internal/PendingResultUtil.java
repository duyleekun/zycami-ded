/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.common.internal;

import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Response;
import com.google.android.gms.common.internal.PendingResultUtil$ResultConverter;
import com.google.android.gms.common.internal.PendingResultUtil$zaa;
import com.google.android.gms.common.internal.zai;
import com.google.android.gms.common.internal.zaj;
import com.google.android.gms.common.internal.zak;
import com.google.android.gms.common.internal.zal;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

public class PendingResultUtil {
    private static final PendingResultUtil$zaa zaou;

    static {
        zai zai2 = new zai();
        zaou = zai2;
    }

    public static Task toResponseTask(PendingResult pendingResult, Response response) {
        zak zak2 = new zak(response);
        return PendingResultUtil.toTask(pendingResult, zak2);
    }

    public static Task toTask(PendingResult pendingResult, PendingResultUtil$ResultConverter pendingResultUtil$ResultConverter) {
        PendingResultUtil$zaa pendingResultUtil$zaa = zaou;
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        zaj zaj2 = new zaj(pendingResult, taskCompletionSource, pendingResultUtil$ResultConverter, pendingResultUtil$zaa);
        pendingResult.addStatusListener(zaj2);
        return taskCompletionSource.getTask();
    }

    public static Task toVoidTask(PendingResult pendingResult) {
        zal zal2 = new zal();
        return PendingResultUtil.toTask(pendingResult, zal2);
    }
}

