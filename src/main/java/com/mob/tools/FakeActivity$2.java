/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler$Callback
 *  android.os.Message
 */
package com.mob.tools;

import android.os.Handler;
import android.os.Message;
import com.mob.tools.FakeActivity;

public class FakeActivity$2
implements Handler.Callback {
    public final /* synthetic */ FakeActivity this$0;
    public final /* synthetic */ Runnable val$r;

    public FakeActivity$2(FakeActivity fakeActivity, Runnable runnable) {
        this.this$0 = fakeActivity;
        this.val$r = runnable;
    }

    public boolean handleMessage(Message message) {
        this.val$r.run();
        return false;
    }
}

