/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.HandlerThread
 *  android.os.Looper
 */
package d.v.v.q;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.meicam.sdk.NvsMediaFileConvertor;
import com.meicam.sdk.NvsMediaFileConvertor$MeidaFileConvertorCallback;
import d.v.e.l.k2;
import d.v.e.l.s1;
import d.v.v.q.a;
import d.v.v.q.b;
import d.v.v.q.c;
import d.v.v.q.g$a;
import d.v.v.q.g$b;
import d.v.v.q.g$c;
import d.v.v.q.h;
import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Hashtable;

public class g
implements NvsMediaFileConvertor$MeidaFileConvertorCallback {
    private static final int i = 1;
    private static final int j = 2;
    private static final int k = 3;
    private static final int l = 4;
    private static final int m = 5;
    private static final int n = 6;
    private NvsMediaFileConvertor a;
    private HandlerThread b;
    private Handler c;
    private g$b d;
    private String e;
    private String f;
    private String g;
    private long h;

    private boolean A() {
        long l10;
        Object object;
        Object object2 = this.e;
        if (object2 == null) {
            return false;
        }
        object2 = this.a;
        if (object2 == null) {
            this.a = object2 = new NvsMediaFileConvertor();
            object = null;
            ((NvsMediaFileConvertor)object2).setMeidaFileConvertorCallback((NvsMediaFileConvertor$MeidaFileConvertorCallback)this, null);
        }
        object2 = new StringBuilder();
        object = k2.y("editor");
        ((StringBuilder)object2).append(object);
        object = File.separator;
        ((StringBuilder)object2).append((String)object);
        long l11 = System.currentTimeMillis();
        ((StringBuilder)object2).append(l11);
        ((StringBuilder)object2).append(".mp3");
        this.f = object2 = ((StringBuilder)object2).toString();
        long l12 = d.v.v.q.h.Z(this.e);
        Hashtable<String, Object> hashtable = new Hashtable<String, Object>();
        object2 = Boolean.TRUE;
        hashtable.put("convertor-no-video", object2);
        object = this.a;
        String string2 = this.e;
        String string3 = this.f;
        this.h = l10 = ((NvsMediaFileConvertor)object).convertMeidaFile(string2, string3, false, 0L, l12, hashtable);
        return true;
    }

    private boolean B() {
        long l10;
        Object object;
        Object object2 = this.e;
        if (object2 == null) {
            return false;
        }
        object2 = this.a;
        if (object2 == null) {
            this.a = object2 = new NvsMediaFileConvertor();
            object = null;
            ((NvsMediaFileConvertor)object2).setMeidaFileConvertorCallback((NvsMediaFileConvertor$MeidaFileConvertorCallback)this, null);
        }
        object2 = new StringBuilder();
        object = k2.y("editor");
        ((StringBuilder)object2).append(object);
        object = File.separator;
        ((StringBuilder)object2).append((String)object);
        long l11 = System.currentTimeMillis();
        ((StringBuilder)object2).append(l11);
        ((StringBuilder)object2).append(".mp4");
        this.f = object2 = ((StringBuilder)object2).toString();
        long l12 = d.v.v.q.h.Z(this.e);
        object = this.a;
        String string2 = this.e;
        String string3 = this.f;
        this.h = l10 = ((NvsMediaFileConvertor)object).convertMeidaFile(string2, string3, true, 0L, l12, null);
        return true;
    }

    public static /* synthetic */ boolean a(g g10) {
        return g10.B();
    }

    public static /* synthetic */ String b(g g10, String string2) {
        g10.g = string2;
        return string2;
    }

    public static /* synthetic */ void c(g g10) {
        g10.i();
    }

    public static /* synthetic */ boolean d(g g10) {
        return g10.A();
    }

    public static /* synthetic */ HandlerThread e(g g10) {
        return g10.b;
    }

    public static /* synthetic */ void f(g g10) {
        g10.j();
    }

    public static /* synthetic */ void g(g g10) {
        g10.h();
    }

    private void h() {
        Object object = this.d;
        if (object != null) {
            object.onCancel();
        }
        if ((object = this.a) != null) {
            long l10;
            long l11 = this.h;
            ((NvsMediaFileConvertor)object).cancelTask(l11);
            this.h = l10 = (long)-1;
            object = this.f;
            s1.h((String)object);
            this.t();
        }
    }

    private void i() {
        g$b g$b = this.d;
        if (g$b != null) {
            Object object = Looper.getMainLooper();
            g$b = new Handler(object);
            object = new c(this);
            g$b.post((Runnable)object);
        }
        this.t();
    }

    private void j() {
        Object object = this.d;
        if (object != null) {
            Object object2 = Looper.getMainLooper();
            object = new Handler(object2);
            object2 = new b(this);
            object.post((Runnable)object2);
        }
        if ((object = this.a) != null) {
            ((NvsMediaFileConvertor)object).release();
        }
        this.a = null;
    }

    public static g k() {
        return g$c.a();
    }

    private /* synthetic */ void m() {
        g$b g$b = this.d;
        String string2 = this.g;
        g$b.onError(string2);
    }

    private /* synthetic */ void o() {
        g$b g$b = this.d;
        String string2 = this.f;
        g$b.onSuccess(string2);
    }

    private /* synthetic */ void q(float f10) {
        this.d.onProgress(f10);
    }

    private void t() {
        NvsMediaFileConvertor nvsMediaFileConvertor = this.a;
        if (nvsMediaFileConvertor != null) {
            nvsMediaFileConvertor.release();
            nvsMediaFileConvertor = null;
            this.a = null;
        }
    }

    public void l() {
        Object object;
        this.b = object = new HandlerThread("covert thread");
        object.start();
        Looper looper = this.b.getLooper();
        object = new g$a(this, looper);
        this.c = object;
    }

    public /* synthetic */ void n() {
        this.m();
    }

    public void notifyAudioMuteRage(long l10, long l11, long l12) {
    }

    public void onFinish(long l10, String string2, String string3, int n10) {
        int n11 = 2;
        Object[] objectArray = new Object[n11];
        objectArray[0] = string2;
        int n12 = 1;
        objectArray[n12] = string3;
        string3 = "----srcFile = %s, dstFile = %s";
        m.a.a.b(string3, objectArray);
        long l11 = this.h;
        long l12 = 0L;
        long l13 = l11 == l12 ? 0 : (l11 < l12 ? -1 : 1);
        if (l13 < 0) {
            return;
        }
        Object object = l11 == l10 ? 0 : (l11 < l10 ? -1 : 1);
        if (object != false) {
            return;
        }
        if (n10 == 0) {
            this.v();
        } else if (n10 != n12) {
            String string4 = n10 != n11 ? (n10 != (object = (Object)3) ? (n10 != (object = (Object)4) ? (n10 != (object = (Object)5) ? "\u672a\u77e5\u9519\u8bef " : "\u89c6\u9891\u89e3\u7801\u5668\u89e3\u7801\u8fc7\u7a0b\u4e2d\u51fa\u73b0\u9519\u8bef ") : "\u89c6\u9891\u89e3\u7801\u5668\u8bbe\u7f6e\u8fc7\u7a0b\u4e2d\u51fa\u73b0\u9519\u8bef") : "\u89c6\u9891\u7f16\u7801\u5668\u7f16\u7801\u8fc7\u7a0b\u4e2d\u51fa\u73b0\u9519\u8bef") : "\u89c6\u9891\u7f16\u7801\u5668\u8bbe\u7f6e\u9519\u8bef";
            this.g = string4;
            this.w();
        }
    }

    public void onProgress(long l10, float f10) {
        Object object;
        int n10 = 1;
        Handler handler = new Object[n10];
        handler[0] = object = Float.valueOf(f10);
        object = "------onProgress-----%s";
        m.a.a.b((String)object, (Object[])handler);
        handler = this.d;
        if (handler != null) {
            object = Looper.getMainLooper();
            handler = new Handler((Looper)object);
            object = new a(this, f10);
            handler.post((Runnable)object);
        }
    }

    public /* synthetic */ void p() {
        this.o();
    }

    public /* synthetic */ void r(float f10) {
        this.q(f10);
    }

    public void s() {
        this.d = null;
    }

    public void u() {
        Object object = this.b;
        boolean bl2 = object.isAlive();
        if (!bl2) {
            return;
        }
        object = Looper.class;
        String string2 = "mQueue";
        object = ((Class)object).getDeclaredField(string2);
        int n10 = 1;
        ((Field)object).setAccessible(n10 != 0);
        Constructor<?>[] constructorArray = "android.os.MessageQueue";
        constructorArray = Class.forName((String)constructorArray);
        constructorArray = constructorArray.getDeclaredConstructors();
        int n11 = constructorArray.length;
        block19: for (int i10 = 0; i10 < n11; ++i10) {
            Boolean bl3;
            int n12;
            Constructor<?> constructor = constructorArray[i10];
            constructor.setAccessible(n10 != 0);
            Handler handler = constructor.getParameterTypes();
            try {
                n12 = ((Class<?>[])handler).length;
                bl3 = null;
            }
            catch (Exception exception) {}
            for (int i11 = 0; i11 < n12; ++i11) {
                Object object2 = handler[i11];
                object2 = ((Class)object2).getName();
                String string3 = "boolean";
                boolean bl4 = ((String)object2).equalsIgnoreCase(string3);
                if (!bl4) continue;
                handler = this.c;
                handler = handler.getLooper();
                Object[] objectArray = new Object[n10];
                bl3 = Boolean.TRUE;
                objectArray[0] = bl3;
                constructor = constructor.newInstance(objectArray);
                ((Field)object).set(handler, constructor);
                continue block19;
            }
            continue;
            break;
        }
        this.c.sendEmptyMessage(3);
    }

    public void v() {
        this.c.sendEmptyMessage(2);
    }

    public void w() {
        this.c.sendEmptyMessage(5);
    }

    public void x(String string2) {
        this.e = string2;
        this.c.sendEmptyMessage(1);
    }

    public void y(String string2) {
        this.e = string2;
        this.c.sendEmptyMessage(6);
    }

    public void z(g$b g$b) {
        this.d = g$b;
    }
}

