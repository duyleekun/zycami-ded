/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.opengl.GLES20
 */
package com.google.android.exoplayer2.util;

import android.opengl.GLES20;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.GlUtil;
import java.nio.Buffer;

public final class GlUtil$Attribute {
    private Buffer buffer;
    private final int index;
    private final int location;
    public final String name;
    private int size;

    public GlUtil$Attribute(int n10, int n11) {
        String string2;
        int n12 = 1;
        int[] nArray = new int[n12];
        GLES20.glGetProgramiv((int)n10, (int)35722, (int[])nArray, (int)0);
        int[] nArray2 = new int[n12];
        int[] nArray3 = new int[n12];
        byte[] byArray = new byte[nArray[0]];
        int[] nArray4 = new int[n12];
        int n13 = nArray[0];
        n12 = n10;
        int n14 = n11;
        GLES20.glGetActiveAttrib((int)n10, (int)n11, (int)n13, (int[])nArray4, (int)0, (int[])nArray3, (int)0, (int[])nArray2, (int)0, (byte[])byArray, (int)0);
        n14 = GlUtil.access$000(byArray);
        this.name = string2 = new String(byArray, 0, n14);
        this.location = n12 = GLES20.glGetAttribLocation((int)n10, (String)string2);
        n12 = n11;
        this.index = n11;
    }

    public void bind() {
        Object object;
        Object object2 = object = Assertions.checkNotNull(this.buffer, "call setBuffer before bind");
        object2 = (Buffer)object;
        GLES20.glBindBuffer((int)34962, (int)0);
        int n10 = this.location;
        int n11 = this.size;
        GLES20.glVertexAttribPointer((int)n10, (int)n11, (int)5126, (boolean)false, (int)0, (Buffer)object2);
        GLES20.glEnableVertexAttribArray((int)this.index);
        GlUtil.checkGlError();
    }

    public void setBuffer(float[] object, int n10) {
        object = GlUtil.createBuffer(object);
        this.buffer = object;
        this.size = n10;
    }
}

