/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$CompressFormat
 *  android.text.TextUtils
 */
package d.v.c.u0;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.bumptech.glide.Priority;
import com.zhiyun.editorinterface.EditConfig$a;
import d.v.c.u0.d;
import d.v.c.u0.e;
import d.v.c.u0.f;
import d.v.c.u0.g;
import d.v.c.x1.q.c;
import d.v.e.i.h;
import d.v.e.i.j;
import d.v.e.l.k2;
import d.v.e.l.s1;
import d.v.e.l.u1;
import e.a.i0;
import e.a.p0;
import e.a.s0.b;
import e.a.v0.o;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import m.a.a;

public class m
extends ViewModel {
    private j a;
    private MutableLiveData b;
    private MutableLiveData c;
    private int d;
    private String e;
    private e.a.s0.a f;

    public m() {
        Object object = new j();
        this.a = object;
        this.b = object;
        super();
        this.c = object;
        this.f = object = new e.a.s0.a();
    }

    private int c(int n10) {
        float[] fArray = EditConfig$a.k;
        int n11 = this.d;
        float f10 = fArray[n11];
        n11 = 1065353216;
        float f11 = 1.0f;
        float f12 = f10 - f11;
        Object object = f12 == 0.0f ? 0 : (f12 < 0.0f ? -1 : 1);
        if (object < 0) {
            object = 1920;
            f10 = 2.69E-42f;
        } else {
            object = 1080;
            f10 = 1.513E-42f;
        }
        if (n10 == 0) {
            n10 = (int)object;
        }
        return n10;
    }

    private long f() {
        long l10;
        Object object = this.b.getValue();
        if (object == null) {
            l10 = 0L;
        } else {
            object = (Long)this.b.getValue();
            l10 = (Long)object;
        }
        return l10;
    }

    private /* synthetic */ void j(c object, Bitmap object2) {
        if (object2 == null) {
            h.g(this.a, null);
            return;
        }
        object = i0.x0(object2);
        object2 = g.a;
        object = ((i0)object).z0((o)object2);
        object2 = d.v.e.k.e.f();
        object = ((i0)object).s((p0)object2);
        object2 = new e(this);
        d d10 = new d(this);
        object = ((i0)object).c((e.a.v0.g)object2, d10);
        this.f.b((b)object);
    }

    /*
     * Loose catch block
     * WARNING - void declaration
     */
    public static /* synthetic */ String l(Bitmap bitmap) {
        void throwable;
        Object object;
        block11: {
            Object object2;
            block9: {
                block10: {
                    object = k2.h();
                    object2 = new StringBuilder();
                    long l10 = System.currentTimeMillis();
                    ((StringBuilder)object2).append(l10);
                    String string2 = ".png";
                    ((StringBuilder)object2).append(string2);
                    object2 = ((StringBuilder)object2).toString();
                    File file = new File((File)object, (String)object2);
                    object = null;
                    object2 = new FileOutputStream(file);
                    string2 = Bitmap.CompressFormat.JPEG;
                    int n10 = 100;
                    try {
                        bitmap.compress((Bitmap.CompressFormat)string2, n10, (OutputStream)object2);
                        ((OutputStream)object2).flush();
                        object = file.getAbsolutePath();
                        break block9;
                    }
                    catch (Exception exception) {
                        break block10;
                    }
                    catch (Throwable throwable2) {
                        break block11;
                    }
                    catch (Exception exception) {
                        object2 = null;
                    }
                }
                try {
                    bitmap.printStackTrace();
                }
                catch (Throwable throwable) {
                    object = object2;
                }
            }
            u1.a((Closeable)object2);
            return object;
        }
        u1.a((Closeable)object);
        throw throwable;
    }

    private /* synthetic */ void m(String string2) {
        h.g(this.a, string2);
    }

    private /* synthetic */ void o(Throwable objectArray) {
        objectArray = new Object[]{};
        m.a.a.i("fetch cover error", objectArray);
        h.g(this.a, null);
    }

    public void b(Context context) {
        Object object = this.e;
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        if (bl2) {
            return;
        }
        this.f.e();
        object = this.e;
        long l10 = this.f();
        int n10 = this.c(0);
        object = d.v.c.x1.q.c.b((String)object, l10, n10);
        Priority priority = Priority.HIGH;
        d.v.c.b2.w.l.a a10 = new d.v.c.b2.w.l.a(object, priority);
        object = new f(this);
        a10.t(context, (d.v.c.b2.x.d)object);
    }

    public j d() {
        return this.a;
    }

    public MutableLiveData e() {
        return this.b;
    }

    public String g(int n10) {
        int n11 = 3;
        int n12 = 1;
        int n13 = 2;
        String string2 = "w,9:16";
        if (n10 != 0 && n10 != n13) {
            n10 = this.d;
            if (n10 != 0) {
                if (n10 != n12) {
                    if (n10 != n13) {
                        if (n10 == n11) {
                            string2 = "w,16:9";
                        }
                    } else {
                        string2 = "w,4:3";
                    }
                } else {
                    string2 = "w,1:1";
                }
            }
        } else {
            n10 = this.d;
            if (n10 != 0) {
                if (n10 != n12) {
                    if (n10 != n13) {
                        if (n10 == n11) {
                            string2 = "h,16:9";
                        }
                    } else {
                        string2 = "h,4:3";
                    }
                } else {
                    string2 = "h,1:1";
                }
            }
        }
        return string2;
    }

    public MutableLiveData i() {
        return this.c;
    }

    public /* synthetic */ void k(c c10, Bitmap bitmap) {
        this.j(c10, bitmap);
    }

    public /* synthetic */ void n(String string2) {
        this.m(string2);
    }

    public void onCleared() {
        super.onCleared();
        this.f.e();
        System.gc();
    }

    public /* synthetic */ void p(Throwable throwable) {
        this.o(throwable);
    }

    public void r(String string2) {
        h.g(this.a, string2);
    }

    public void s(long l10, int n10) {
        boolean bl2;
        Object object = this.e();
        Long l11 = l10;
        h.g((MutableLiveData)object, l11);
        if (n10 == 0) {
            n10 = 1080;
        }
        if (bl2 = TextUtils.isEmpty((CharSequence)(object = this.e))) {
            return;
        }
        object = this.e;
        n10 = this.c(n10);
        c c10 = d.v.c.x1.q.c.b((String)object, l10, n10);
        h.g(this.i(), c10);
    }

    public void t(String string2) {
        int n10;
        int n11 = s1.q(string2);
        int n12 = 0;
        int n13 = 1;
        float f10 = Float.MIN_VALUE;
        if (n11 == 0) {
            Object[] objectArray = new Object[n13];
            objectArray[0] = string2;
            m.a.a.e("video not exist,videoPath:%s", objectArray);
            return;
        }
        Object[] objectArray = d.v.v.q.h.e0(string2);
        if (objectArray != null && (n10 = objectArray.getWidth()) != 0 && (n10 = objectArray.getHeight()) != 0) {
            Object object;
            this.e = string2;
            int n14 = objectArray.getWidth();
            float f11 = (float)n14 * 1.0f;
            n11 = objectArray.getHeight();
            float f12 = n11;
            float f13 = (f11 /= f12) - (object = (objectArray = (Object[])EditConfig$a.k)[n13]);
            n10 = (int)(f13 == 0.0f ? 0 : (f13 < 0.0f ? -1 : 1));
            if (n10 <= 0) {
                float[] fArray;
                f12 = (float)objectArray[0];
                float f14 = (f12 = Math.abs(f11 - f12)) - (f11 = Math.abs(f11 - (object = (Object)(fArray = EditConfig$a.k)[n13])));
                n14 = (int)(f14 == 0.0f ? 0 : (f14 < 0.0f ? -1 : 1));
                if (n14 > 0) {
                    n12 = n13;
                }
                this.d = n12;
            } else {
                n12 = 3;
                object = objectArray[n12];
                float f15 = f11 - object;
                n10 = (int)(f15 == 0.0f ? 0 : (f15 > 0.0f ? 1 : -1));
                if (n10 >= 0) {
                    this.d = n12;
                } else {
                    f12 = (float)objectArray[n13];
                    f12 = Math.abs(f11 - f12);
                    float[] fArray = EditConfig$a.k;
                    int n15 = 2;
                    float f16 = 2.8E-45f;
                    object = fArray[n15];
                    float f17 = f12 - (object = (Object)Math.abs(f11 - object));
                    n11 = (int)(f17 == 0.0f ? 0 : (f17 < 0.0f ? -1 : 1));
                    if (n11 > 0) {
                        n13 = n15;
                        f10 = f16;
                    }
                    this.d = n13;
                    objectArray = EditConfig$a.k;
                    f12 = (float)objectArray[n13];
                    f12 = Math.abs(f11 - f12);
                    float[] fArray2 = EditConfig$a.k;
                    f10 = fArray2[n12];
                    f11 = Math.abs(f11 - f10);
                    n14 = (int)(f12 == f11 ? 0 : (f12 < f11 ? -1 : 1));
                    if (n14 <= 0) {
                        n12 = this.d;
                    }
                    this.d = n12;
                }
            }
            return;
        }
        objectArray = new Object[n13];
        objectArray[0] = string2;
        m.a.a.e("video size error,videoPath:%s", objectArray);
    }
}

