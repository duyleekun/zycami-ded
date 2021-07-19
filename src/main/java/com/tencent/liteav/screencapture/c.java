/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.media.projection.MediaProjection
 *  android.media.projection.MediaProjection$Callback
 *  android.os.Handler
 *  android.os.Looper
 *  android.view.Surface
 */
package com.tencent.liteav.screencapture;

import android.content.Context;
import android.content.Intent;
import android.media.projection.MediaProjection;
import android.os.Handler;
import android.os.Looper;
import android.view.Surface;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.g;
import com.tencent.liteav.basic.util.i;
import com.tencent.liteav.basic.util.i$a;
import com.tencent.liteav.screencapture.c$3;
import com.tencent.liteav.screencapture.c$a;
import com.tencent.liteav.screencapture.c$b;
import com.tencent.rtmp.video.TXScreenCapture$TXScreenCaptureAssistantActivity;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class c {
    private static volatile c a;
    private final Context b;
    private final Handler c;
    private final Map d;
    private boolean e;
    private MediaProjection f;
    private i g;
    private boolean h;
    private MediaProjection.Callback i;
    private i$a j;

    public c(Context context) {
        boolean bl2;
        Object object = new HashMap();
        this.d = object;
        this.e = false;
        super(this);
        this.i = object;
        super(this);
        this.j = object;
        this.b = object = context.getApplicationContext();
        Looper looper = Looper.getMainLooper();
        super(looper);
        this.c = object;
        this.h = bl2 = this.b(context);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static c a(Context context) {
        Object object = a;
        if (object != null) return a;
        object = c.class;
        synchronized (object) {
            c c10 = a;
            if (c10 != null) return a;
            a = c10 = new c(context);
            return a;
        }
    }

    public static /* synthetic */ Map a(c c10) {
        return c10.d;
    }

    private void a() {
        boolean bl2;
        Iterator iterator2 = this.d.values().iterator();
        while (bl2 = iterator2.hasNext()) {
            Object object = (c$a)iterator2.next();
            Object object2 = ((c$a)object).e;
            if (object2 != null) continue;
            Object object3 = this.f;
            int n10 = ((c$a)object).b;
            int n11 = ((c$a)object).c;
            int n12 = 1;
            int n13 = 1;
            Surface surface = ((c$a)object).a;
            String string2 = "TXCScreenCapture";
            object2 = object3.createVirtualDisplay(string2, n10, n11, n12, n13, surface, null, null);
            ((c$a)object).e = object2;
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("create VirtualDisplay ");
            object3 = ((c$a)object).e;
            ((StringBuilder)object2).append(object3);
            object2 = ((StringBuilder)object2).toString();
            object3 = "VirtualDisplayManager";
            TXCLog.i((String)object3, (String)object2);
            object = ((c$a)object).d;
            if (object == null) continue;
            boolean bl3 = true;
            object3 = null;
            object.a(bl3, false);
        }
    }

    public static /* synthetic */ void a(c c10, boolean bl2) {
        c10.a(bl2);
    }

    private void a(boolean bl2) {
        Object object = this.d;
        boolean bl3 = object.isEmpty();
        if (!bl3) {
            return;
        }
        if (bl2) {
            Handler handler = this.c;
            object = new c$3(this);
            long l10 = TimeUnit.SECONDS.toMillis(1L);
            handler.postDelayed((Runnable)object, l10);
            return;
        }
        Object object2 = new StringBuilder();
        ((StringBuilder)object2).append("stop media projection session ");
        object = this.f;
        ((StringBuilder)object2).append(object);
        object2 = ((StringBuilder)object2).toString();
        TXCLog.i("VirtualDisplayManager", (String)object2);
        object2 = this.f;
        bl3 = false;
        object = null;
        if (object2 != null) {
            MediaProjection.Callback callback = this.i;
            object2.unregisterCallback(callback);
            object2 = this.f;
            object2.stop();
            this.f = null;
        }
        if ((object2 = this.g) != null) {
            ((i)((Object)object2)).a();
            this.g = null;
        }
    }

    public static /* synthetic */ boolean a(c c10, Context context) {
        return c10.b(context);
    }

    public static /* synthetic */ Context b(c c10) {
        return c10.b;
    }

    private boolean b(Context context) {
        int n10;
        int n11 = com.tencent.liteav.basic.util.g.f(context);
        if (n11 != 0 && n11 != (n10 = 2)) {
            n11 = 0;
            context = null;
        } else {
            n11 = 1;
        }
        return n11 != 0;
    }

    public static /* synthetic */ boolean b(c c10, boolean bl2) {
        c10.h = bl2;
        return bl2;
    }

    public static /* synthetic */ boolean c(c c10) {
        return c10.h;
    }

    public void a(MediaProjection object) {
        int n10 = 0;
        CharSequence charSequence = null;
        this.e = false;
        boolean bl2 = true;
        if (object == null) {
            boolean bl3;
            Object object2 = this.d;
            object = new HashMap(object2);
            object2 = this.d;
            object2.clear();
            object = object.values().iterator();
            while (bl3 = object.hasNext()) {
                object2 = ((c$a)object.next()).d;
                if (object2 == null) continue;
                object2.a(false, bl2);
            }
            return;
        }
        charSequence = new StringBuilder();
        charSequence.append("Got session ");
        charSequence.append(object);
        charSequence = charSequence.toString();
        TXCLog.i("VirtualDisplayManager", (String)charSequence);
        this.f = object;
        charSequence = this.i;
        Object object3 = this.c;
        object.registerCallback((MediaProjection.Callback)charSequence, object3);
        this.a();
        charSequence = Looper.getMainLooper();
        object3 = this.j;
        object = new i((Looper)charSequence, (i$a)object3);
        this.g = object;
        n10 = 50;
        ((i)((Object)object)).a(n10, n10);
        this.a(bl2);
    }

    public void a(Surface object) {
        Object object2;
        Object object3 = Looper.myLooper();
        if (object3 == (object2 = Looper.getMainLooper())) {
            if (object == null) {
                return;
            }
            object3 = this.d;
            if ((object = (c$a)object3.remove(object)) != null && (object3 = object.e) != null) {
                object3.release();
                object3 = new StringBuilder();
                object2 = "VirtualDisplay released, ";
                ((StringBuilder)object3).append((String)object2);
                object = object.e;
                ((StringBuilder)object3).append(object);
                object = ((StringBuilder)object3).toString();
                object3 = "VirtualDisplayManager";
                TXCLog.i((String)object3, (String)object);
            }
            this.a(true);
            return;
        }
        object = new IllegalStateException("Must call this at main thread!");
        throw object;
    }

    public void a(Surface object, int n10, int n11, c$b c$b) {
        Looper looper;
        Object object2 = Looper.myLooper();
        if (object2 == (looper = Looper.getMainLooper())) {
            if (object == null) {
                TXCLog.e("VirtualDisplayManager", "surface is null!");
                c$b.a(false, false);
                return;
            }
            looper = null;
            object2 = new c$a(null);
            object2.a = object;
            object2.b = n10;
            object2.c = n11;
            object2.d = c$b;
            object2.e = null;
            Map map = this.d;
            map.put(object, object2);
            object = this.f;
            if (object == null) {
                boolean bl2 = this.e;
                if (!bl2) {
                    this.e = bl2 = true;
                    map = this.b;
                    Class<TXScreenCapture.TXScreenCaptureAssistantActivity> clazz = TXScreenCapture.TXScreenCaptureAssistantActivity.class;
                    object = new Intent((Context)map, clazz);
                    n10 = 0x10000000;
                    object.addFlags(n10);
                    map = this.b;
                    map.startActivity((Intent)object);
                }
            } else {
                this.a();
            }
            return;
        }
        object = new IllegalStateException("Must call this method in main thread!");
        throw object;
    }
}

