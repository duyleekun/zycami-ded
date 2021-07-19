/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.internal.zaab;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

public final class zaad
implements OnCompleteListener {
    private final /* synthetic */ zaab zafn;
    private final /* synthetic */ TaskCompletionSource zafo;

    public zaad(zaab zaab2, TaskCompletionSource taskCompletionSource) {
        this.zafn = zaab2;
        this.zafo = taskCompletionSource;
    }

    public final void onComplete(Task object) {
        object = zaab.zab(this.zafn);
        TaskCompletionSource taskCompletionSource = this.zafo;
        object.remove(taskCompletionSource);
    }
}

