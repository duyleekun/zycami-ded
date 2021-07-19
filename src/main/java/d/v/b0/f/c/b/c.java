/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$CompressFormat
 *  android.graphics.Bitmap$Config
 *  android.opengl.EGL14
 *  android.opengl.EGLSurface
 *  android.opengl.GLES20
 *  android.util.Log
 */
package d.v.b0.f.c.b;

import android.graphics.Bitmap;
import android.opengl.EGL14;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.util.Log;
import d.v.b0.f.c.b.b;
import d.v.b0.f.c.b.e;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.OutputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class c {
    public static final String e = "GlUtil";
    public b a;
    private EGLSurface b;
    private int c;
    private int d;

    public c(b b10) {
        int n10;
        EGLSurface eGLSurface;
        this.b = eGLSurface = EGL14.EGL_NO_SURFACE;
        this.c = n10 = -1;
        this.d = n10;
        this.a = b10;
    }

    public void a(int n10, int n11) {
        EGLSurface eGLSurface = this.b;
        EGLSurface eGLSurface2 = EGL14.EGL_NO_SURFACE;
        if (eGLSurface == eGLSurface2) {
            this.b = eGLSurface = this.a.b(n10, n11);
            this.c = n10;
            this.d = n11;
            return;
        }
        IllegalStateException illegalStateException = new IllegalStateException("surface already created");
        throw illegalStateException;
    }

    public void b(Object object) {
        EGLSurface eGLSurface = this.b;
        EGLSurface eGLSurface2 = EGL14.EGL_NO_SURFACE;
        if (eGLSurface == eGLSurface2) {
            object = this.a.c(object);
            this.b = object;
            return;
        }
        object = new IllegalStateException("surface already created");
        throw object;
    }

    public int c() {
        int n10 = this.d;
        if (n10 < 0) {
            b b10 = this.a;
            EGLSurface eGLSurface = this.b;
            int n11 = 12374;
            n10 = b10.l(eGLSurface, n11);
        }
        return n10;
    }

    public int d() {
        int n10 = this.c;
        if (n10 < 0) {
            b b10 = this.a;
            EGLSurface eGLSurface = this.b;
            int n11 = 12375;
            n10 = b10.l(eGLSurface, n11);
        }
        return n10;
    }

    public void e() {
        b b10 = this.a;
        EGLSurface eGLSurface = this.b;
        b10.h(eGLSurface);
    }

    public void f(c c10) {
        b b10 = this.a;
        EGLSurface eGLSurface = this.b;
        c10 = c10.b;
        b10.i(eGLSurface, (EGLSurface)c10);
    }

    public void g() {
        int n10;
        b b10 = this.a;
        EGLSurface eGLSurface = this.b;
        b10.n(eGLSurface);
        b10 = EGL14.EGL_NO_SURFACE;
        this.b = b10;
        this.d = n10 = -1;
        this.c = n10;
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void h(File object) {
        void var1_4;
        Object object2;
        block6: {
            FileOutputStream fileOutputStream;
            object2 = this.a;
            Object object3 = this.b;
            boolean bl2 = ((b)object2).f((EGLSurface)object3);
            if (!bl2) {
                object = new RuntimeException("Expected EGL context/surface is not current");
                throw object;
            }
            object = ((File)object).toString();
            int n10 = this.d();
            int n11 = this.c();
            ByteBuffer byteBuffer = ByteBuffer.allocateDirect(n10 * n11 * 4);
            object2 = ByteOrder.LITTLE_ENDIAN;
            byteBuffer.order((ByteOrder)object2);
            object3 = null;
            int n12 = 6408;
            int n13 = 5121;
            int n14 = n11;
            GLES20.glReadPixels((int)0, (int)0, (int)n10, (int)n11, (int)n12, (int)n13, (Buffer)byteBuffer);
            d.v.b0.f.c.b.e.d("glReadPixels");
            byteBuffer.rewind();
            bl2 = false;
            object2 = null;
            try {
                fileOutputStream = new FileOutputStream((String)object);
                object3 = new BufferedOutputStream(fileOutputStream);
            }
            catch (Throwable throwable) {
                // empty catch block
                break block6;
            }
            try {
                object2 = Bitmap.Config.ARGB_8888;
                object2 = Bitmap.createBitmap((int)n10, (int)n11, (Bitmap.Config)object2);
                object2.copyPixelsFromBuffer((Buffer)byteBuffer);
                fileOutputStream = Bitmap.CompressFormat.PNG;
                n14 = 90;
                object2.compress((Bitmap.CompressFormat)fileOutputStream, n14, (OutputStream)object3);
                object2.recycle();
            }
            catch (Throwable throwable) {
                object2 = object3;
                break block6;
            }
            ((FilterOutputStream)object3).close();
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("Saved ");
            ((StringBuilder)object2).append(n10);
            ((StringBuilder)object2).append("x");
            ((StringBuilder)object2).append(n11);
            ((StringBuilder)object2).append(" frame as '");
            ((StringBuilder)object2).append((String)object);
            ((StringBuilder)object2).append("'");
            object = ((StringBuilder)object2).toString();
            Log.d((String)e, (String)object);
            return;
        }
        if (object2 != null) {
            ((FilterOutputStream)object2).close();
        }
        throw var1_4;
    }

    public void i(long l10) {
        b b10 = this.a;
        EGLSurface eGLSurface = this.b;
        b10.o(eGLSurface, l10);
    }

    public boolean j() {
        b b10 = this.a;
        Object object = this.b;
        boolean bl2 = b10.p((EGLSurface)object);
        if (!bl2) {
            object = e;
            String string2 = "WARNING: swapBuffers() failed";
            Log.d((String)object, (String)string2);
        }
        return bl2;
    }
}

