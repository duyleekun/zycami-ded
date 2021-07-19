/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.opengl.GLES20
 */
package d.v.b0.j;

import android.opengl.GLES20;

public class a {
    private int[] a;
    private int[] b;

    public a() {
        int[] nArray = new int[4];
        this.b = nArray;
    }

    public int a(int n10, int n11) {
        int[] nArray = this.a;
        int n12 = 2;
        int n13 = 36006;
        int n14 = 36160;
        if (nArray == null) {
            this.a = nArray = new int[3];
            int n15 = 1;
            GLES20.glGenFramebuffers((int)n15, (int[])nArray, (int)0);
            nArray = this.a;
            GLES20.glGenTextures((int)n15, (int[])nArray, (int)n15);
            int n16 = this.a[n15];
            int n17 = 3553;
            GLES20.glBindTexture((int)n17, (int)n16);
            int n18 = 6408;
            int n19 = 6408;
            int n20 = 5121;
            GLES20.glTexImage2D((int)3553, (int)0, (int)n18, (int)n10, (int)n11, (int)0, (int)n19, (int)n20, null);
            int n21 = 9729;
            GLES20.glTexParameteri((int)n17, (int)10241, (int)n21);
            GLES20.glTexParameteri((int)n17, (int)10240, (int)n21);
            n21 = 33071;
            GLES20.glTexParameteri((int)n17, (int)10242, (int)n21);
            GLES20.glTexParameteri((int)n17, (int)10243, (int)n21);
            nArray = this.a;
            GLES20.glGetIntegerv((int)n13, (int[])nArray, (int)n12);
            nArray = this.a;
            n16 = nArray[0];
            GLES20.glBindFramebuffer((int)n14, (int)n16);
            n16 = 36064;
            int[] nArray2 = this.a;
            n12 = nArray2[n15];
            GLES20.glFramebufferTexture2D((int)n14, (int)n16, (int)n17, (int)n12, (int)0);
        } else {
            GLES20.glGetIntegerv((int)n13, (int[])nArray, (int)n12);
            nArray = this.a;
            int n22 = nArray[0];
            GLES20.glBindFramebuffer((int)n14, (int)n22);
        }
        return GLES20.glGetError();
    }

    public void b(int n10, int n11, int n12, int n13, int n14, int n15, int n16, int n17) {
        int[] nArray = this.a;
        int n18 = 2;
        int n19 = 36006;
        int n20 = 36160;
        if (nArray == null) {
            this.a = nArray = new int[3];
            int n21 = 1;
            GLES20.glGenFramebuffers((int)n21, (int[])nArray, (int)0);
            nArray = this.a;
            GLES20.glGenTextures((int)n21, (int[])nArray, (int)n21);
            int n22 = this.a[n21];
            GLES20.glBindTexture((int)n12, (int)n22);
            int n23 = 5121;
            n22 = n12;
            GLES20.glTexImage2D((int)n12, (int)0, (int)n13, (int)n10, (int)n11, (int)0, (int)n13, (int)n23, null);
            int n24 = n14;
            GLES20.glTexParameteri((int)n12, (int)10241, (int)n14);
            n24 = n15;
            GLES20.glTexParameteri((int)n12, (int)10240, (int)n15);
            n24 = n16;
            GLES20.glTexParameteri((int)n12, (int)10242, (int)n16);
            n24 = n17;
            GLES20.glTexParameteri((int)n12, (int)10243, (int)n17);
            nArray = this.a;
            GLES20.glGetIntegerv((int)n19, (int[])nArray, (int)n18);
            nArray = this.a;
            n22 = nArray[0];
            GLES20.glBindFramebuffer((int)n20, (int)n22);
            n22 = 36064;
            int[] nArray2 = this.a;
            n24 = nArray2[n21];
            GLES20.glFramebufferTexture2D((int)n20, (int)n22, (int)n12, (int)n24, (int)0);
        } else {
            GLES20.glGetIntegerv((int)n19, (int[])nArray, (int)n18);
            nArray = this.a;
            int n25 = nArray[0];
            GLES20.glBindFramebuffer((int)n20, (int)n25);
        }
    }

    public void c() {
        int[] nArray = this.a;
        if (nArray != null) {
            int n10 = 1;
            GLES20.glDeleteFramebuffers((int)n10, (int[])nArray, (int)0);
            nArray = this.a;
            GLES20.glDeleteTextures((int)n10, (int[])nArray, (int)n10);
            nArray = null;
            this.a = null;
        }
    }

    public int d() {
        int n10;
        int[] nArray = this.a;
        if (nArray != null) {
            int n11 = 1;
            n10 = nArray[n11];
        } else {
            n10 = -1;
        }
        return n10;
    }

    public void e() {
        int[] nArray = this.a;
        if (nArray != null) {
            int n10 = 36160;
            int n11 = 2;
            int n12 = nArray[n11];
            GLES20.glBindFramebuffer((int)n10, (int)n12);
        }
    }
}

