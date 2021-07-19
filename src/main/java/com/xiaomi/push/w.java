/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.push.v;
import java.io.File;

public final class w
extends v {
    public final /* synthetic */ Runnable a;

    public w(Context context, File file, Runnable runnable) {
        this.a = runnable;
        super(context, file, null);
    }

    public void a(Context object) {
        object = this.a;
        if (object != null) {
            object.run();
        }
    }
}

