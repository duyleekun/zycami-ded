/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Handler$Callback
 *  android.os.Looper
 */
package com.mob.commons.a;

import android.os.Handler;
import android.os.Looper;
import com.mob.commons.LockAction;
import com.mob.commons.a.d;
import com.mob.commons.a.d$1$1;
import com.mob.commons.e;
import com.mob.tools.MobHandlerThread;
import com.mob.tools.MobLog;
import com.mob.tools.log.NLog;
import java.io.File;
import java.util.HashMap;

public class d$1
extends MobHandlerThread {
    public final /* synthetic */ File a;
    public final /* synthetic */ d b;

    public d$1(d d10, File file) {
        this.b = d10;
        this.a = file;
    }

    private void a() {
        super.run();
    }

    public static /* synthetic */ void a(d$1 d$1) {
        d$1.a();
    }

    public void onLooperPrepared(Looper object) {
        Object object2 = this.b;
        d d10 = this.b;
        Handler handler = new Handler((Looper)object, (Handler.Callback)d10);
        d.a((d)object2, handler);
        object = this.b;
        try {
            ((d)object).d();
        }
        catch (Throwable throwable) {
            object2 = MobLog.getInstance();
            ((NLog)object2).d(throwable);
        }
    }

    public void run() {
        block19: {
            Object object = this.a;
            Object object2 = new d$1$1(this);
            boolean bl2 = e.a((File)object, (LockAction)object2);
            if (bl2) break block19;
            object = MobLog.getInstance();
            object2 = new StringBuilder();
            Object object3 = "synchronizeProcess failed clt: ";
            ((StringBuilder)object2).append((String)object3);
            object3 = this.b;
            object3 = object3.getClass();
            object3 = ((Class)object3).getSimpleName();
            ((StringBuilder)object2).append((String)object3);
            object3 = ", file: ";
            ((StringBuilder)object2).append((String)object3);
            object3 = this.a;
            object3 = ((File)object3).getPath();
            ((StringBuilder)object2).append((String)object3);
            object2 = ((StringBuilder)object2).toString();
            ((NLog)object).w((String)object2);
            object = d.g();
            object2 = this.getClass();
            object2 = ((Class)object2).getSimpleName();
            object3 = null;
            try {
                ((HashMap)object).put(object2, null);
            }
            catch (Throwable throwable) {
                object2 = MobLog.getInstance();
                ((NLog)object2).d(throwable);
            }
        }
    }
}

