/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.hardware.Sensor
 *  android.hardware.SensorEventListener
 *  android.hardware.SensorManager
 *  android.os.Handler
 *  android.util.Log
 */
package d.v.b0.i;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.util.Log;
import com.faceunity.wrapper.faceunity;
import d.v.b0.i.a$a;
import d.v.b0.i.a$b;
import d.v.b0.i.a$c;
import d.v.b0.i.a$d;
import d.v.b0.i.a$e;
import java.io.InputStream;

public class a {
    private volatile int a = 0;
    private volatile int b;
    private volatile int c;
    private int d = 90;
    private int e;
    private final String f;
    private final String g;
    private int h;
    private int[] i;
    private SensorManager j;
    private Sensor k;
    private Context l;
    private Handler m;
    private int n;
    private int o;
    private SensorEventListener p;

    public a(Context context, Handler handler) {
        int n10;
        this.e = n10 = 1;
        this.f = "AI_model/ai_face_processor.bundle";
        this.g = "face_beautification.bundle";
        this.h = -1;
        int[] nArray = new int[n10];
        this.i = nArray;
        this.n = n10;
        this.o = 0;
        a$d a$d = new a$d(this);
        this.p = a$d;
        this.l = context;
        this.m = handler;
        context = (SensorManager)context.getSystemService("sensor");
        this.j = context;
        context = context.getDefaultSensor(n10);
        this.k = context;
        handler = this.j;
        a$d = this.p;
        handler.registerListener((SensorEventListener)a$d, (Sensor)context, 3);
    }

    private void A() {
        faceunity.fuOnCameraChange();
    }

    private int C(int n10) {
        int n11 = faceunity.fuIsAIModelLoaded(n10);
        String string2 = "ZL";
        int n12 = 1;
        if (n11 == n12) {
            if ((n10 = faceunity.fuReleaseAIModel(n10)) == 0) {
                String string3 = "unload model fail.";
                Log.e((String)string2, (String)string3);
            }
        } else {
            String string4 = "model not be loaded.";
            Log.d((String)string2, (String)string4);
            n10 = -999;
        }
        return n10;
    }

    public static /* synthetic */ Context a(a a10) {
        return a10.l;
    }

    public static /* synthetic */ int b(a a10, Context context, String string2, int n10) {
        return a10.w(context, string2, n10);
    }

    public static /* synthetic */ int c(a a10) {
        return a10.e;
    }

    public static /* synthetic */ int d(a a10, int n10) {
        a10.e = n10;
        return n10;
    }

    public static /* synthetic */ int e(a a10) {
        return a10.r();
    }

    public static /* synthetic */ int f(a a10) {
        return a10.d;
    }

    public static /* synthetic */ int g(a a10, int n10) {
        a10.d = n10;
        return n10;
    }

    public static /* synthetic */ byte[] h(a a10, Context context, String string2) {
        return a10.z(context, string2);
    }

    public static /* synthetic */ int i(a a10) {
        return a10.h;
    }

    public static /* synthetic */ int j(a a10, int n10) {
        a10.h = n10;
        return n10;
    }

    public static /* synthetic */ int k(a a10, byte[] byArray) {
        return a10.t(byArray);
    }

    public static /* synthetic */ int[] l(a a10) {
        return a10.i;
    }

    public static /* synthetic */ int m(a a10, int n10) {
        a10.b = n10;
        return n10;
    }

    public static /* synthetic */ int n(a a10) {
        return a10.c;
    }

    public static /* synthetic */ int o(a a10, int n10) {
        a10.c = n10;
        return n10;
    }

    public static /* synthetic */ int p(a a10, int n10) {
        a10.a = n10;
        return n10;
    }

    public static /* synthetic */ void q(a a10) {
        a10.A();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private int r() {
        int n10 = this.c;
        int n11 = 3;
        int n12 = 2;
        int n13 = 180;
        int n14 = 270;
        int n15 = 1;
        int n16 = 90;
        if (n10 == n14) {
            n10 = this.b;
            if (n10 == n15) {
                n10 = this.d;
                return n10 / 90;
            }
            n10 = this.d;
            if (n10 == n13) return 0;
            if (n10 != 0) return n10 / 90;
            return n12;
        }
        n10 = this.c;
        if (n10 != n16) return 0;
        n10 = this.b;
        if (n10 == 0) {
            n10 = this.d;
            if (n10 == n16) return n11;
            if (n10 != n14) return n10 / 90;
            return n15;
        }
        n10 = this.d;
        if (n10 == 0) {
            return n12;
        }
        if (n10 == n16) return n11;
        if (n10 != n13) return n15;
        return 0;
    }

    private int t(byte[] byArray) {
        int n10;
        int n11 = byArray != null && (n10 = byArray.length) > 0 ? faceunity.fuCreateItemFromPackage(byArray) : -999;
        return n11;
    }

    private void u(int n10) {
        faceunity.fuDestroyItem(n10);
    }

    /*
     * WARNING - void declaration
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private int w(Context object, String string2, int n10) {
        String string3;
        int n11 = -999;
        byte[] byArray = this.z((Context)object, string3);
        if (byArray == null) return n11;
        try {
            void var3_8;
            return faceunity.fuLoadAIModelFromPackage(byArray, (int)var3_8);
        }
        catch (Exception exception) {
            try {
                exception.printStackTrace();
                string3 = "ZL";
            }
            catch (Throwable throwable) {
                return n11;
            }
            StringBuilder stringBuilder = new StringBuilder();
            String string4 = "load model fail\uff1a";
            stringBuilder.append(string4);
            String string5 = exception.toString();
            stringBuilder.append(string5);
            String string6 = stringBuilder.toString();
            Log.e((String)string3, (String)string6);
            return n11;
        }
    }

    private byte[] z(Context object, String object2) {
        object = object.getAssets().open((String)object2);
        object2 = new byte[((InputStream)object).available()];
        ((InputStream)object).read((byte[])object2);
        ((InputStream)object).close();
        return object2;
    }

    public void B(int n10) {
        int n11 = this.d;
        if (n11 != n10) {
            Handler handler = this.m;
            a$e a$e = new a$e(this, n10);
            handler.post((Runnable)a$e);
        }
    }

    public void s(boolean bl2) {
        Handler handler = this.m;
        a$c a$c = new a$c(this, bl2);
        handler.post((Runnable)a$c);
    }

    public void v() {
        Handler handler = this.m;
        a$a a$a = new a$a(this);
        handler.post((Runnable)a$a);
    }

    public void x(int n10, int n11) {
        Handler handler = this.m;
        a$b a$b = new a$b(this, n10, n11);
        handler.post((Runnable)a$b);
    }

    public int y(byte[] byArray, int n10, int n11, int n12) {
        int n13 = this.n;
        int n14 = this.o;
        int n15 = n13 | n14;
        int n16 = this.a;
        this.a = n13 = n16 + 1;
        int[] nArray = this.i;
        return faceunity.fuDualInputToTexture(byArray, n10, n15, n11, n12, n16, nArray);
    }
}

