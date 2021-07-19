/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package d.v.b0.d.e;

import android.content.Context;
import com.faceunity.wrapper.faceunity;
import com.zhiyun.renderengine.bean.TextureFormat;
import com.zhiyun.renderengine.engine.faceunity.FaceUnityPlatform;
import com.zhiyun.renderengine.engine.faceunity.FaceUnityPlatform$Key;
import d.v.b0.d.a;
import d.v.b0.d.d;

public class b
extends a
implements d {
    private Context c = null;
    private int d;
    private int e;
    private int f;
    private int[] g;
    private volatile int h;
    private boolean i;

    public b() {
        int n10;
        this.d = n10 = 1;
        this.e = 0;
        this.f = -1;
        int[] nArray = new int[n10];
        this.g = nArray;
        this.h = 0;
        this.i = false;
    }

    public void a(int n10, int n11) {
        this.h = 0;
    }

    public int b(int n10, int n11, int n12) {
        return this.n(n10, n11, n12, false);
    }

    public int c(byte[] byArray, TextureFormat textureFormat, int n10, int n11) {
        int n12;
        int n13 = this.e;
        Object object = TextureFormat.RGBA;
        if (textureFormat == object) {
            n13 = 4;
        }
        int n14 = this.h;
        this.h = n12 = n14 + 1;
        int[] nArray = this.g;
        object = byArray;
        return faceunity.fuRenderToNV21Image(byArray, n10, n11, n14, nArray, n13);
    }

    public void f() {
        int n10 = this.i;
        if (n10 == 0) {
            this.f = n10 = -1;
            int[] nArray = this.g;
            nArray[0] = n10;
            FaceUnityPlatform.d();
            n10 = 1;
            this.i = n10;
        }
    }

    public void h(boolean bl2) {
        float f10;
        if (bl2) {
            int n10 = 1065353216;
            f10 = 1.0f;
        } else {
            boolean bl3 = false;
            f10 = 0.0f;
        }
        int n11 = this.f;
        double d10 = f10;
        faceunity.fuItemSetParam(n11, "is_beauty_on", d10);
    }

    public void j(int n10, float f10) {
        int n11 = 1065353216;
        float f11 = 1.0f;
        int n12 = 3;
        if (n10 == n12) {
            n10 = this.f;
            double d10 = f10 *= f11;
            faceunity.fuItemSetParam(n10, "cheek_thinning", d10);
            return;
        }
        n12 = 4;
        if (n10 == n12) {
            n10 = this.f;
            double d11 = f10 *= 6.0f;
            faceunity.fuItemSetParam(n10, "blur_level", d11);
            return;
        }
        n12 = 2;
        if (n10 == n12) {
            n10 = this.f;
            double d12 = f10 *= f11;
            faceunity.fuItemSetParam(n10, "color_level", d12);
            return;
        }
        n12 = 1;
        if (n10 == n12) {
            n10 = this.f;
            double d13 = f10 *= f11;
            faceunity.fuItemSetParam(n10, "eye_enlarging", d13);
            return;
        }
        n12 = 5;
        if (n10 == n12) {
            n10 = this.f;
            double d14 = f10 *= f11;
            faceunity.fuItemSetParam(n10, "red_level", d14);
            return;
        }
        n11 = 103;
        f11 = 1.44E-43f;
        if (n10 == n11) {
            float f12 = 0.8f;
            n10 = this.f;
            String string2 = "filter_name";
            String string3 = "bailiang2";
            faceunity.fuItemSetParam(n10, string2, string3);
            n10 = this.f;
            double d15 = f10 *= f12;
            String string4 = "filter_level";
            faceunity.fuItemSetParam(n10, string4, d15);
        }
    }

    public boolean k() {
        return false;
    }

    public String l() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("the special effect include big eyes , whitening , cheek thinning , microdermabrasion , rosy , bailiang. ");
        return stringBuffer.toString();
    }

    /*
     * WARNING - void declaration
     */
    public int m(byte[] byArray, TextureFormat textureFormat, int n10, boolean bl2, int n11, int n12) {
        void var6_7;
        void var5_6;
        int n13 = this.d;
        int n14 = this.e;
        int n15 = n13 | n14;
        int n16 = this.h;
        this.h = n13 = n16 + 1;
        int[] nArray = this.g;
        return faceunity.fuDualInputToTexture(byArray, n10, n15, (int)var5_6, (int)var6_7, n16, nArray);
    }

    public int n(int n10, int n11, int n12, boolean bl2) {
        int n13;
        int n14 = this.h;
        this.h = n13 = n14 + 1;
        int[] nArray = this.g;
        return faceunity.fuRenderToTexture(n10, n11, n12, n14, nArray, 0);
    }

    public void o(Context stringArray) {
        double[] dArray;
        int n10;
        stringArray = stringArray.getApplicationContext();
        this.c = stringArray;
        Object object = FaceUnityPlatform$Key.KEY_FACE_BEAUTIFUL;
        this.f = n10 = FaceUnityPlatform.j((Context)stringArray, object);
        this.g[0] = n10;
        faceunity.fuItemSetParam(n10, "is_beauty_on", 1.0);
        n10 = this.f;
        double d10 = 2.0;
        faceunity.fuItemSetParam(n10, "blur_type", d10);
        object = "blur_level";
        String string2 = "red_level";
        stringArray = new String[]{"cheek_thinning", object, "color_level", "eye_enlarging", string2};
        int n11 = 5;
        double[] dArray2 = dArray = new double[n11];
        double[] dArray3 = dArray;
        dArray2[0] = 0.0;
        dArray3[1] = 4.199999999999999;
        dArray2[2] = 0.3;
        dArray3[3] = 0.4;
        dArray3[4] = 0.3;
        for (int i10 = 0; i10 < n11; ++i10) {
            int n12 = this.f;
            String string3 = stringArray[i10];
            double d11 = dArray[i10];
            faceunity.fuItemSetParam(n12, string3, d11);
        }
        faceunity.fuItemSetParam(this.f, "sharpen", 0.2f);
        this.i = false;
    }

    public int q() {
        return 1;
    }
}

