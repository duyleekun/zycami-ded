/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Message
 */
package com.baidu.location.c;

import android.os.Handler;
import android.os.Message;
import com.baidu.location.c.b;

public class c
extends Handler {
    public final /* synthetic */ b a;

    public c(b b10) {
        this.a = b10;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public void handleMessage(Message var1_1) {
        var2_2 = var1_1 /* !! */ .what;
        var3_3 = 1;
        if (var2_2 == var3_3) ** GOTO lbl13
        var3_3 = 2;
        if (var2_2 != var3_3) ** GOTO lbl16
        try {
            var1_1 /* !! */  = this.a;
        }
        catch (Exception v0) {
            ** continue;
        }
        b.b((b)var1_1 /* !! */ );
        ** GOTO lbl16
lbl13:
        // 1 sources

        var1_1 /* !! */  = this.a;
        b.a((b)var1_1 /* !! */ );
lbl16:
        // 4 sources

    }
}

