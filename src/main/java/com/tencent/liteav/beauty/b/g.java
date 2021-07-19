/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.opengl.GLES20
 */
package com.tencent.liteav.beauty.b;

import android.opengl.GLES20;
import com.tencent.liteav.basic.opengl.i;
import java.util.Iterator;
import java.util.List;

public class g
extends i {
    public List r;
    public List s;
    private int[] t;
    private int[] u;
    private i v;

    public int a(int n10, int n11, int n12) {
        Object object = this.s;
        int n13 = object.size();
        this.k();
        boolean bl2 = false;
        for (int i10 = 0; i10 < n13; ++i10) {
            i i11 = (i)this.s.get(i10);
            if (bl2) {
                n10 = i11.a(n10, n11, n12);
            } else {
                int[] nArray = this.t;
                int n14 = nArray[0];
                int[] nArray2 = this.u;
                int n15 = nArray2[0];
                n10 = i11.a(n10, n14, n15);
            }
            bl2 ^= true;
        }
        if (bl2) {
            object = this.v;
            ((i)object).a(n10, n11, n12);
        }
        return n12;
    }

    public void a(int n10, int n11) {
        Object object;
        int n12;
        g g10 = this;
        int n13 = n10;
        int n14 = n11;
        int n15 = this.e;
        if (n15 == n10 && (n15 = this.f) == n11) {
            return;
        }
        Object object2 = g10.t;
        if (object2 != null) {
            this.f();
        }
        super.a(n10, n11);
        object2 = g10.s;
        n15 = object2.size();
        float f10 = 0.0f;
        for (n12 = 0; n12 < n15; ++n12) {
            object = (i)g10.s.get(n12);
            ((i)object).a(n13, n14);
        }
        g10.v.a(n13, n14);
        object2 = g10.s;
        if (object2 != null && (n15 = object2.size()) > 0) {
            g10.s.size();
            int n16 = 2;
            g10.t = object2 = (Object)new int[n16];
            object2 = new int[n16];
            g10.u = object2;
            for (int i10 = 0; i10 < n16; ++i10) {
                object2 = g10.t;
                n12 = 1;
                GLES20.glGenFramebuffers((int)n12, (int[])object2, (int)i10);
                object2 = g10.u;
                GLES20.glGenTextures((int)n12, (int[])object2, (int)i10);
                n15 = g10.u[i10];
                int n17 = 3553;
                GLES20.glBindTexture((int)n17, (int)n15);
                int n18 = 6408;
                int n19 = 5121;
                GLES20.glTexImage2D((int)3553, (int)0, (int)6408, (int)n10, (int)n11, (int)0, (int)n18, (int)n19, null);
                f10 = 9729.0f;
                GLES20.glTexParameterf((int)n17, (int)10240, (float)f10);
                GLES20.glTexParameterf((int)n17, (int)10241, (float)f10);
                f10 = 33071.0f;
                GLES20.glTexParameterf((int)n17, (int)10242, (float)f10);
                GLES20.glTexParameterf((int)n17, (int)10243, (float)f10);
                object2 = g10.t;
                n15 = object2[i10];
                n12 = 36160;
                f10 = 5.0671E-41f;
                GLES20.glBindFramebuffer((int)n12, (int)n15);
                n15 = 36064;
                object = g10.u;
                Object object3 = object[i10];
                GLES20.glFramebufferTexture2D((int)n12, (int)n15, (int)n17, (int)object3, (int)0);
                GLES20.glBindTexture((int)n17, (int)0);
                GLES20.glBindFramebuffer((int)n12, (int)0);
            }
        }
    }

    public boolean b() {
        int n10 = super.b();
        if (n10 != 0) {
            boolean bl2;
            Object object = this.r.iterator();
            while (bl2 = object.hasNext()) {
                i i10 = (i)object.next();
                i10.a();
                bl2 = i10.n();
                if (bl2) continue;
            }
            object = this.v;
            n10 = (int)(((i)object).a() ? 1 : 0);
        }
        return n10 != 0 && (n10 = GLES20.glGetError()) == 0;
    }

    public void e() {
        boolean bl2;
        super.e();
        Iterator iterator2 = this.r.iterator();
        while (bl2 = iterator2.hasNext()) {
            i i10 = (i)iterator2.next();
            i10.d();
        }
    }

    public void f() {
        super.f();
        int[] nArray = this.u;
        int n10 = 2;
        if (nArray != null) {
            GLES20.glDeleteTextures((int)n10, (int[])nArray, (int)0);
            this.u = null;
        }
        if ((nArray = this.t) != null) {
            GLES20.glDeleteFramebuffers((int)n10, (int[])nArray, (int)0);
            this.t = null;
        }
    }
}

