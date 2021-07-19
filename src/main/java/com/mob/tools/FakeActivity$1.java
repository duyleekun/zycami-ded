/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Handler$Callback
 *  android.os.Message
 */
package com.mob.tools;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import com.mob.tools.FakeActivity;

public class FakeActivity$1
implements Handler.Callback {
    public final /* synthetic */ FakeActivity this$0;
    public final /* synthetic */ Context val$context;
    public final /* synthetic */ Intent val$finalIExec;

    public FakeActivity$1(FakeActivity fakeActivity, Context context, Intent intent) {
        this.this$0 = fakeActivity;
        this.val$context = context;
        this.val$finalIExec = intent;
    }

    public boolean handleMessage(Message object) {
        object = this.this$0;
        Context context = this.val$context;
        Intent intent = this.val$finalIExec;
        FakeActivity.access$000((FakeActivity)object, context, intent);
        return false;
    }
}

