/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Message
 */
package com.mob.commons.a;

import android.os.Message;
import com.mob.commons.a.h;
import com.mob.tools.utils.ReflectHelper$ReflectRunnable;
import java.util.HashMap;

public class h$1
implements ReflectHelper$ReflectRunnable {
    public final /* synthetic */ h a;

    public h$1(h h10) {
        this.a = h10;
    }

    public Void a(HashMap hashMap) {
        Message message = new Message();
        message.obj = hashMap;
        message.what = 2;
        this.a.b(message);
        return null;
    }

    public /* synthetic */ Object run(Object object) {
        object = (HashMap)object;
        return this.a((HashMap)object);
    }
}

