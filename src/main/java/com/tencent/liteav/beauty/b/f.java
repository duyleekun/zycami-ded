/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.opengl.GLES20
 */
package com.tencent.liteav.beauty.b;

import android.opengl.GLES20;
import com.tencent.liteav.basic.opengl.i;
import com.tencent.liteav.beauty.b.d;
import com.tencent.liteav.beauty.b.f$a;
import com.tencent.liteav.beauty.b.f$b;
import com.tencent.liteav.beauty.b.f$c;
import com.tencent.liteav.beauty.b.s;
import com.tencent.liteav.beauty.b.t;

public class f
extends i {
    private int[] A;
    private float B = 4.0f;
    public int r;
    public int s;
    public boolean t;
    private d u;
    private i v;
    private f$c w;
    private f$a x;
    private f$b y;
    private int[] z;

    public void a(int n10, int n11) {
        int[] nArray;
        float f10;
        Object object;
        float f11;
        int n12;
        float f12;
        f f13 = this;
        int n13 = n10;
        int n14 = n11;
        Object object2 = this.f;
        if (object2 == n11 && (object2 = this.e) == n10) {
            return;
        }
        super.a(n10, n11);
        object2 = f13.t;
        if (object2 == 0) {
            object2 = 1065353216;
            f12 = 1.0f;
            n12 = 0x40800000;
            f11 = 4.0f;
            object = 540;
            f10 = 7.57E-43f;
            f13.B = n13 < n14 ? (n13 < object ? f12 : f11) : (n14 < object ? f12 : f11);
        }
        f12 = n13;
        f11 = f13.B;
        f13.r = object2 = (int)(f12 /= f11);
        f10 = (float)n14 / f11;
        f13.s = n12 = (int)f10;
        Object object3 = f13.v;
        ((i)object3).a((int)object2, n12);
        Object object4 = f13.w;
        n12 = f13.r;
        object = f13.s;
        ((f$c)object4).a(n12, (int)object);
        object4 = f13.x;
        n12 = f13.r;
        object = f13.s;
        ((i)object4).a(n12, (int)object);
        f13.y.a(n13, n14);
        object4 = f13.u;
        n12 = f13.r;
        object = f13.s;
        ((d)object4).a(n12, (int)object);
        object4 = f13.z;
        if (object4 != null) {
            n12 = ((Object)object4).length;
            GLES20.glDeleteFramebuffers((int)n12, (int[])object4, (int)0);
            object2 = f13.z.length;
            nArray = f13.A;
            GLES20.glDeleteTextures((int)object2, (int[])nArray, (int)0);
            object2 = 0;
            f12 = 0.0f;
            object4 = null;
            f13.z = null;
            f13.A = null;
        }
        f12 = 1.1E-44f;
        object4 = new int[8];
        f13.z = (int[])object4;
        nArray = new int[((Object)object4).length];
        f13.A = nArray;
        n12 = ((Object)object4).length;
        GLES20.glGenFramebuffers((int)n12, (int[])object4, (int)0);
        object4 = f13.z;
        object2 = ((Object)object4).length;
        nArray = f13.A;
        GLES20.glGenTextures((int)object2, (int[])nArray, (int)0);
        for (int i10 = 0; i10 < (object2 = ((Object)(object4 = (Object)f13.z)).length); ++i10) {
            object4 = f13.A;
            object2 = object4[i10];
            int n15 = 3553;
            GLES20.glBindTexture((int)n15, (int)object2);
            object2 = 5;
            f12 = 7.0E-45f;
            if (i10 >= object2) {
                object2 = 3553;
                f12 = 4.979E-42f;
                n12 = 0;
                f11 = 0.0f;
                nArray = null;
                object = 6408;
                f10 = 8.98E-42f;
                int n16 = 6408;
                int n17 = 5121;
                GLES20.glTexImage2D((int)object2, (int)0, (int)object, (int)n10, (int)n11, (int)0, (int)n16, (int)n17, null);
            } else {
                int n18 = 3553;
                int n19 = 6408;
                object2 = f13.r;
                n12 = f13.s;
                int n20 = 6408;
                int n21 = 5121;
                GLES20.glTexImage2D((int)n18, (int)0, (int)n19, (int)object2, (int)n12, (int)0, (int)n20, (int)n21, null);
            }
            f11 = 9729.0f;
            GLES20.glTexParameterf((int)n15, (int)10240, (float)f11);
            GLES20.glTexParameterf((int)n15, (int)10241, (float)f11);
            f11 = 33071.0f;
            GLES20.glTexParameterf((int)n15, (int)10242, (float)f11);
            GLES20.glTexParameterf((int)n15, (int)10243, (float)f11);
            object4 = f13.z;
            object2 = object4[i10];
            n12 = 36160;
            f11 = 5.0671E-41f;
            GLES20.glBindFramebuffer((int)n12, (int)object2);
            object2 = 36064;
            f12 = 5.0536E-41f;
            object3 = f13.A;
            object = object3[i10];
            GLES20.glFramebufferTexture2D((int)n12, (int)object2, (int)n15, (int)object, (int)0);
            GLES20.glBindTexture((int)n15, (int)0);
            GLES20.glBindFramebuffer((int)n12, (int)0);
        }
    }

    public int b(int n10) {
        Object object;
        int n11;
        float f10 = this.B;
        int n12 = 1065353216;
        float f11 = 1.0f;
        float f12 = f10 == f11 ? 0 : (f10 > f11 ? 1 : -1);
        int n13 = 0;
        int[] nArray = null;
        if (f12 != false) {
            f12 = this.r;
            n11 = this.s;
            GLES20.glViewport((int)0, (int)0, (int)f12, (int)n11);
            object = this.v;
            f12 = ((i)object).b(n10);
        } else {
            f12 = n10;
        }
        d d10 = this.u;
        Object object2 = this.z;
        int n14 = 4;
        int n15 = object2[n14];
        n14 = this.A[n14];
        n11 = d10.a((int)f12, n15, n14);
        object2 = this.w;
        n14 = this.z[0];
        int[] nArray2 = this.A;
        int n16 = nArray2[0];
        f12 = ((t)object2).a((int)f12, n11, n14, n16);
        object2 = this.x;
        int[] nArray3 = this.z;
        n16 = 1;
        n14 = nArray3[n16];
        n16 = this.A[n16];
        n11 = ((t)object2).a((int)f12, n11, n14, n16);
        object2 = this.u;
        nArray3 = this.z;
        n16 = 2;
        n14 = nArray3[n16];
        n16 = this.A[n16];
        f12 = ((i)object2).a((int)f12, n14, n16);
        object2 = this.u;
        nArray3 = this.z;
        n16 = 3;
        n14 = nArray3[n16];
        int[] nArray4 = this.A;
        n16 = nArray4[n16];
        n11 = ((i)object2).a(n11, n14, n16);
        float f13 = this.B;
        n12 = (int)(f13 == f11 ? 0 : (f13 > f11 ? 1 : -1));
        if (n12 != 0) {
            n12 = this.e;
            n15 = this.f;
            GLES20.glViewport((int)0, (int)0, (int)n12, (int)n15);
            i i10 = this.v;
            nArray = this.z;
            n15 = 5;
            n13 = nArray[n15];
            n15 = this.A[n15];
            f12 = i10.a((int)f12, n13, n15);
            i10 = this.v;
            nArray = this.z;
            n15 = 6;
            f13 = 8.4E-45f;
            n13 = nArray[n15];
            nArray3 = this.A;
            n15 = nArray3[n15];
            n11 = i10.a(n11, n13, n15);
        }
        n14 = (int)f12;
        n16 = n11;
        object2 = this.y;
        object = this.z;
        n12 = 7;
        Object object3 = object[n12];
        int n17 = this.A[n12];
        return ((s)object2).a((int)f12, n11, n10, (int)object3, n17);
    }

    public boolean b() {
        boolean bl2 = super.b();
        if (bl2) {
            i i10 = new d();
            this.u = i10;
            if (bl2) {
                bl2 = i10.a();
            }
            i10 = new f$c();
            this.w = i10;
            if (bl2) {
                bl2 = ((f$c)i10).a();
            }
            String string2 = "precision highp float;  \nuniform sampler2D inputImageTexture;  \nuniform sampler2D inputImageTexture2;  \nvarying vec2 textureCoordinate;  \nvarying vec2 textureCoordinate2;  \nvoid main()  \n{  \n\tgl_FragColor = texture2D(inputImageTexture2, textureCoordinate2) - texture2D(inputImageTexture, textureCoordinate) * texture2D(inputImageTexture2, textureCoordinate2);  \n}  \n";
            i10 = new f$a(string2);
            this.x = i10;
            if (bl2) {
                bl2 = i10.a();
            }
            string2 = "precision highp float;   \nuniform sampler2D inputImageTexture;   \nuniform sampler2D inputImageTexture2;  \nuniform sampler2D inputImageTexture3;   \nvarying vec2 textureCoordinate;   \nvarying vec2 textureCoordinate2;  \nvarying vec2 textureCoordinate3;    \nvoid main()   \n{   \n\tgl_FragColor = texture2D(inputImageTexture, textureCoordinate) * texture2D(inputImageTexture3, textureCoordinate3) + texture2D(inputImageTexture2, textureCoordinate2);   \n}   \n";
            i10 = new f$b(string2);
            this.y = i10;
            if (bl2) {
                bl2 = i10.a();
            }
            this.v = i10 = new i();
            boolean bl3 = true;
            i10.a(bl3);
            if (bl2) {
                i i11 = this.v;
                bl2 = i11.a();
            }
            if (bl2) {
                return bl3;
            }
        }
        this.d();
        return false;
    }

    public void e() {
        int n10 = this.g;
        if (n10 != 0) {
            super.e();
            this.u.d();
            this.w.d();
            this.x.d();
            this.y.d();
            this.v.d();
            int[] nArray = this.z;
            if (nArray != null) {
                int n11 = nArray.length;
                GLES20.glDeleteFramebuffers((int)n11, (int[])nArray, (int)0);
                nArray = this.z;
                n10 = nArray.length;
                int[] nArray2 = this.A;
                GLES20.glDeleteTextures((int)n10, (int[])nArray2, (int)0);
                this.z = null;
            }
            this.A = null;
        }
    }
}

