/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$CompressFormat
 *  android.graphics.Bitmap$Config
 *  android.graphics.BitmapFactory
 *  android.opengl.EGLContext
 *  android.opengl.GLES20
 *  android.opengl.Matrix
 */
package d.v.b0.c.c;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.EGLContext;
import android.opengl.GLES20;
import android.opengl.Matrix;
import com.zhiyun.renderengine.engine.IRenderEngine;
import d.v.b0.c.c.c$a;
import d.v.b0.c.c.c$b;
import d.v.b0.c.c.d;
import d.v.b0.c.c.d$c;
import d.v.b0.f.b;
import d.v.b0.j.a;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.LinkedBlockingQueue;

public class c
extends Thread {
    private d a;
    private Context b;
    private LinkedBlockingQueue c;
    private Map d;
    private d.v.b0.c.e.a e;
    private float[] f;
    private float[] g;
    private EGLContext h;
    private b i;
    private IRenderEngine j;
    private d.v.b0.c.d.c k;
    private a l;
    private d.v.b0.d.d m;
    private volatile boolean n;

    public c(EGLContext object, IRenderEngine object2, Context context) {
        Object object3 = new d();
        this.a = object3;
        object3 = new LinkedBlockingQueue();
        this.c = object3;
        this.d = object3;
        this.e = object3 = new d.v.b0.c.e.a();
        int n10 = 16;
        float[] fArray = new float[n10];
        this.f = fArray;
        object3 = new float[n10];
        this.g = (float[])object3;
        object3 = null;
        Matrix.setIdentityM((float[])fArray, (int)0);
        fArray = this.g;
        Matrix.setIdentityM((float[])fArray, (int)0);
        n10 = 1;
        this.n = n10;
        this.h = object;
        this.b = context;
        this.j = object2;
        object = this.a;
        object2 = new c$a(this);
        ((d)object).f((d$c)object2);
        object = new StringBuilder();
        object2 = context.getCacheDir();
        ((StringBuilder)object).append(object2);
        object2 = File.separator;
        ((StringBuilder)object).append((String)object2);
        ((StringBuilder)object).append("temp");
        object = ((StringBuilder)object).toString();
        object2 = new File((String)object);
        boolean bl2 = ((File)object2).exists();
        if (!bl2) {
            ((File)object2).mkdirs();
        }
        object = this.a;
        object2 = ((File)object2).getAbsolutePath();
        ((d)object).e((String)object2);
        this.a.start();
    }

    public static /* synthetic */ Map a(c c10) {
        return c10.d;
    }

    public static /* synthetic */ LinkedBlockingQueue b(c c10) {
        return c10.c;
    }

    public void c() {
        this.n = false;
    }

    public void d(byte[] byArray, Object object, d.v.b0.c.e.b b10) {
        String string2 = UUID.randomUUID().toString();
        c$b c$b = new c$b(this);
        c$b.a = string2;
        c$b.c = b10;
        c$b.d = object;
        object = this.d;
        object.put(string2, c$b);
        object = this.a;
        try {
            ((d)object).h(string2, byArray);
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void run() {
        int n10;
        c c10 = this;
        super.run();
        Object object = this.h;
        Object object2 = new d.v.b0.f.c.a((EGLContext)object);
        this.i = object2;
        while ((n10 = c10.n) != 0) {
            int n11;
            int n12;
            Object object3;
            Object object4;
            int n13;
            Object object5;
            Object object6;
            Object object7;
            block20: {
                try {
                    object2 = c10.c;
                    object = object2 = ((LinkedBlockingQueue)object2).take();
                    object = (c$b)object2;
                    object7 = ((c$b)object).c;
                    object6 = ((c$b)object).b;
                    object5 = object2 = ((c$b)object).d;
                }
                catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                    break;
                }
                object5 = (d.v.b0.c.e.c$a)object2;
                if (object5 == null || (object2 = ((d.v.b0.c.e.c$a)object5).e) != null && (n10 = object2.isRecycled()) == 0) break block20;
                n13 = 0;
                object4 = null;
                object2 = c10.b;
                object2 = object2.getResources();
                object2 = object2.getAssets();
                object3 = ((d.v.b0.c.e.c$a)object5).b;
                object4 = object2.open((String)object3);
                object2 = BitmapFactory.decodeStream((InputStream)object4);
                ((d.v.b0.c.e.c$a)object5).e = object2;
                if (object4 == null) break block20;
                try {
                    ((InputStream)object4).close();
                }
                catch (IOException iOException) {
                    object4 = iOException;
                    iOException.printStackTrace();
                }
                break block20;
                {
                    catch (Throwable throwable) {
                        object = throwable;
                    }
                    catch (Exception exception) {}
                    {
                        object = new StringBuilder();
                        object7 = "FilterBitmapFactory  open Assets exception:";
                        ((StringBuilder)object).append((String)object7);
                        object2 = exception.toString();
                        ((StringBuilder)object).append((String)object2);
                        object2 = ((StringBuilder)object).toString();
                        d.v.b0.j.b.b((String)object2);
                        if (object4 == null) continue;
                    }
                    try {
                        ((InputStream)object4).close();
                    }
                    catch (IOException iOException) {
                        object = iOException;
                        iOException.printStackTrace();
                    }
                    continue;
                }
                if (object4 == null) throw object;
                try {
                    ((InputStream)object4).close();
                    throw object;
                }
                catch (IOException iOException) {
                    object7 = iOException;
                    iOException.printStackTrace();
                }
                throw object;
            }
            if ((object2 = c10.e.b((String)object6)) == null) continue;
            int n14 = object2.getWidth();
            int n15 = object2.getHeight();
            d.v.b0.b.c c11 = new d.v.b0.b.c(n14, n15);
            c10.i.e(c11);
            c10.i.c(c11);
            object4 = c10.k;
            if (object4 == null) {
                c10.k = object4 = new d.v.b0.c.d.c();
            }
            if ((object4 = c10.m) == null) {
                object4 = c10.j;
                n12 = 105;
                c10.m = object4 = object4.m(n12);
                object3 = c10.b;
                object4.o((Context)object3);
            }
            if (object5 != null) {
                object4 = new d.v.b0.b.a();
                object3 = ((d.v.b0.c.e.c$a)object5).b;
                ((d.v.b0.b.a)object4).a = object3;
                ((d.v.b0.b.a)object4).b = n12 = ((d.v.b0.c.e.c$a)object5).c;
                ((d.v.b0.b.a)object4).c = n12 = ((d.v.b0.c.e.c$a)object5).d;
                c10.m.g((d.v.b0.b.a)object4);
                object4 = c10.m;
                object3 = ((d.v.b0.c.e.c$a)object5).e;
                object4.d((Bitmap)object3);
            }
            n13 = -1;
            int n16 = d.v.b0.j.d.l((Bitmap)object2, n13, false);
            object4 = c10.e;
            ((d.v.b0.c.e.a)object4).h((Bitmap)object2);
            n10 = 1;
            if (object5 != null) {
                object5 = c10.m;
                n11 = object5.n(n16, n14, n15, n10 != 0);
            } else {
                n11 = n16;
            }
            if (n11 < 0) {
                n11 = n16;
            }
            object4 = c10.f;
            float f10 = 1.0f;
            Matrix.scaleM((float[])object4, (int)0, (float)f10, (float)-1.0f, (float)f10);
            object4 = c10.k;
            object3 = c10.g;
            float[] fArray = c10.f;
            ((d.v.b0.c.d.c)object4).b(n11, (float[])object3, fArray);
            Matrix.setIdentityM((float[])c10.f, (int)0);
            n11 = n14 * n15 * 4;
            object5 = ByteBuffer.allocateDirect(n11);
            object4 = ByteOrder.LITTLE_ENDIAN;
            ((ByteBuffer)object5).order((ByteOrder)object4);
            n13 = 0;
            int n17 = 6408;
            int n18 = 5121;
            n10 = n16;
            GLES20.glReadPixels((int)0, (int)0, (int)n14, (int)n15, (int)n17, (int)n18, (Buffer)object5);
            ((ByteBuffer)object5).rewind();
            object4 = c10.e;
            object3 = Bitmap.Config.ARGB_8888;
            object6 = ((d.v.b0.c.e.a)object4).f(n14, n15, (Bitmap.Config)object3);
            ((ByteBuffer)object5).position(0);
            object6.copyPixelsFromBuffer((Buffer)object5);
            object5 = new ByteArrayOutputStream();
            object4 = Bitmap.CompressFormat.JPEG;
            n12 = 80;
            object6.compress((Bitmap.CompressFormat)object4, n12, (OutputStream)object5);
            object4 = c10.e;
            ((d.v.b0.c.e.a)object4).h((Bitmap)object6);
            if (object7 != null) {
                object6 = ((ByteArrayOutputStream)object5).toByteArray();
                object7.a((byte[])object6);
            }
            object = ((c$b)object).b;
            object7 = new File((String)object);
            ((File)object7).delete();
            object2 = new int[n10];
            int n19 = 1;
            GLES20.glDeleteTextures((int)n19, (int[])object2, (int)0);
            object2 = c10.i;
            object2.a(c11);
        }
        c10.a.g();
        c10.d.clear();
        c10.c.clear();
        c10.e.g();
        c10.m.f();
        c10.i.release();
    }
}

