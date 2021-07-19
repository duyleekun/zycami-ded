/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.view.View
 */
package com.zhiyun.cama.me.message;

import android.app.Activity;
import android.view.View;
import androidx.core.app.ActivityCompat;
import com.zhiyun.cama.me.message.MessageTextFragment;
import d.v.c.x1.l;

public class MessageTextFragment$a {
    public final /* synthetic */ MessageTextFragment a;

    public MessageTextFragment$a(MessageTextFragment messageTextFragment) {
        this.a = messageTextFragment;
    }

    public void a(View object) {
        boolean bl2 = l.g(object);
        if (!bl2) {
            object = this.a.getActivity();
            ActivityCompat.finishAfterTransition((Activity)object);
        }
    }
}

