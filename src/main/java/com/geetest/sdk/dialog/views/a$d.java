/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Message
 */
package com.geetest.sdk.dialog.views;

import android.os.Message;
import com.geetest.sdk.dialog.views.a;

public class a$d
implements Runnable {
    public final /* synthetic */ a a;

    public a$d(a a10) {
        this.a = a10;
    }

    public void run() {
        Message message = new Message();
        message.what = 1;
        com.geetest.sdk.dialog.views.a.d(this.a).sendMessage(message);
    }
}

