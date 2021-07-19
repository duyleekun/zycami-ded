/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Looper
 */
package com.google.firebase;

import android.os.Handler;
import android.os.Looper;
import com.google.firebase.FirebaseApp$1;
import java.util.concurrent.Executor;

public class FirebaseApp$UiExecutor
implements Executor {
    private static final Handler HANDLER;

    static {
        Handler handler;
        Looper looper = Looper.getMainLooper();
        HANDLER = handler = new Handler(looper);
    }

    private FirebaseApp$UiExecutor() {
    }

    public /* synthetic */ FirebaseApp$UiExecutor(FirebaseApp$1 firebaseApp$1) {
        this();
    }

    public void execute(Runnable runnable) {
        HANDLER.post(runnable);
    }
}

