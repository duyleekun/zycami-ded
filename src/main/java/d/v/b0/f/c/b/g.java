/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.opengl.GLES20
 */
package d.v.b0.f.c.b;

import android.content.Context;
import android.opengl.GLES20;
import d.v.b0.f.c.b.a;
import d.v.b0.f.c.b.d;
import d.v.b0.f.c.b.e;

public abstract class g {
    private static final String d = "GlUtil";
    public int a;
    public a b;
    private int[] c;

    public g(Context object, int n10, int n11) {
        String string2 = d.v.b0.f.c.b.d.c(object, n10);
        object = d.v.b0.f.c.b.d.c(object, n11);
        this(string2, (String)object);
    }

    public g(String object, String string2) {
        int n10;
        int[] nArray = new int[4];
        this.c = nArray;
        this.a = n10 = e.j((String)object, string2);
        this.b = object = this.d();
        this.e();
    }

    public void a(int n10, float[] fArray) {
        float[] fArray2 = e.b;
        this.b(n10, fArray, fArray2);
    }

    public abstract void b(int var1, float[] var2, float[] var3);

    public void c(int n10, float[] fArray, float[] fArray2, int n11, int n12, int n13, int n14) {
        int[] nArray = this.c;
        GLES20.glGetIntegerv((int)2978, (int[])nArray, (int)0);
        GLES20.glViewport((int)n11, (int)n12, (int)n13, (int)n14);
        this.b(n10, fArray, fArray2);
        int[] nArray2 = this.c;
        int n15 = nArray2[0];
        int n16 = nArray2[1];
        n11 = nArray2[2];
        n10 = nArray2[3];
        GLES20.glViewport((int)n15, (int)n16, (int)n11, (int)n10);
    }

    public abstract a d();

    public abstract void e();

    public void f() {
        GLES20.glDeleteProgram((int)this.a);
        this.a = -1;
    }

    public void g(float[] fArray) {
        this.b.b(fArray);
    }

    public void h(float[] fArray) {
        this.b.c(fArray);
    }
}

