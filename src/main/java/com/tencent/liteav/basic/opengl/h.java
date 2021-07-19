/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.opengl.EGLContext
 *  android.os.Handler
 *  android.os.HandlerThread
 *  android.os.Looper
 *  android.os.Message
 *  android.view.Surface
 *  javax.microedition.khronos.egl.EGLContext
 */
package com.tencent.liteav.basic.opengl;

import android.opengl.EGLContext;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.view.Surface;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.opengl.b;
import com.tencent.liteav.basic.opengl.c;
import com.tencent.liteav.basic.opengl.h$1;
import com.tencent.liteav.basic.opengl.h$a;
import com.tencent.liteav.basic.util.f;

public class h
extends f {
    public int a = 720;
    public int b = 1280;
    public Surface c = null;
    public boolean d = false;
    public c e = null;
    public EGLContext f = null;
    public b g = null;
    public javax.microedition.khronos.egl.EGLContext h = null;
    private h$a i = null;

    public h(Looper looper) {
        super(looper);
    }

    public static void a(Handler handler, HandlerThread handlerThread) {
        if (handler != null && handlerThread != null) {
            int n10;
            Message message = new Message();
            message.what = n10 = 101;
            h$1 h$1 = new h$1(handler, handlerThread);
            message.obj = h$1;
            handler.sendMessage(message);
        }
    }

    private void a(Message object) {
        try {
            this.d();
        }
        catch (Exception exception) {
            object = new StringBuilder();
            ((StringBuilder)object).append("surface-render: init egl context exception ");
            Object object2 = this.c;
            ((StringBuilder)object).append(object2);
            object = ((StringBuilder)object).toString();
            object2 = "TXGLThreadHandler";
            TXCLog.e((String)object2, (String)object);
            object = null;
            this.c = null;
        }
    }

    private void b(Message message) {
        this.e();
    }

    private void c(Message object) {
        block3: {
            object = this.i;
            if (object == null) break block3;
            try {
                object.d();
            }
            catch (Exception exception) {
                CharSequence charSequence = new StringBuilder();
                String string2 = "onMsgRend Exception ";
                charSequence.append(string2);
                String string3 = exception.getMessage();
                charSequence.append(string3);
                string3 = charSequence.toString();
                charSequence = "TXGLThreadHandler";
                TXCLog.e((String)charSequence, string3);
            }
        }
    }

    private boolean d() {
        Object object = new Object[2];
        Object object2 = this.a;
        Surface surface = null;
        object[0] = object2;
        int n10 = this.b;
        object2 = n10;
        boolean bl2 = true;
        object[bl2] = object2;
        object = String.format("init egl size[%d/%d]", (Object[])object);
        object2 = "TXGLThreadHandler";
        TXCLog.i((String)object2, (String)object);
        boolean bl3 = this.d;
        if (!bl3) {
            object = this.h;
            Surface surface2 = this.c;
            int n11 = this.a;
            int n12 = this.b;
            object = com.tencent.liteav.basic.opengl.b.a(null, (javax.microedition.khronos.egl.EGLContext)object, surface2, n11, n12);
            this.g = object;
        } else {
            object = this.f;
            Surface surface3 = this.c;
            int n13 = this.a;
            int n14 = this.b;
            object = com.tencent.liteav.basic.opengl.c.a(null, (EGLContext)object, surface3, n13, n14);
            this.e = object;
        }
        object = this.g;
        if (object == null && (object = this.e) == null) {
            return false;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("surface-render: create egl context ");
        surface = this.c;
        ((StringBuilder)object).append(surface);
        object = ((StringBuilder)object).toString();
        TXCLog.w((String)object2, (String)object);
        object = this.i;
        if (object != null) {
            object.c();
        }
        return bl2;
    }

    private void e() {
        Object object = new StringBuilder();
        ((StringBuilder)object).append("surface-render: destroy egl context ");
        Object object2 = this.c;
        ((StringBuilder)object).append(object2);
        object = ((StringBuilder)object).toString();
        object2 = "TXGLThreadHandler";
        TXCLog.w((String)object2, (String)object);
        object = this.i;
        if (object != null) {
            object.e();
        }
        object = this.g;
        object2 = null;
        if (object != null) {
            ((b)object).c();
            this.g = null;
        }
        if ((object = this.e) != null) {
            ((c)object).d();
            this.e = null;
        }
        this.c = null;
    }

    public javax.microedition.khronos.egl.EGLContext a() {
        b b10 = this.g;
        b10 = b10 != null ? b10.d() : null;
        return b10;
    }

    public void a(h$a h$a) {
        this.i = h$a;
    }

    public Surface b() {
        return this.c;
    }

    public void c() {
        Object object = this.g;
        if (object != null) {
            ((b)object).a();
        }
        if ((object = this.e) != null) {
            ((c)object).e();
        }
    }

    public void handleMessage(Message object) {
        if (object == null) {
            return;
        }
        int n10 = ((Message)object).what;
        switch (n10) {
            default: {
                break;
            }
            case 102: {
                this.c((Message)object);
                break;
            }
            case 101: {
                this.b((Message)object);
                break;
            }
            case 100: {
                this.a((Message)object);
            }
        }
        if (object != null && (object = ((Message)object).obj) != null) {
            object = (Runnable)object;
            object.run();
        }
    }
}

