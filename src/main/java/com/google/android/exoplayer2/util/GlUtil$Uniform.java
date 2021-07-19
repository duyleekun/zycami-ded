/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.opengl.GLES20
 */
package com.google.android.exoplayer2.util;

import android.opengl.GLES20;
import com.google.android.exoplayer2.util.GlUtil;

public final class GlUtil$Uniform {
    private final int location;
    public final String name;
    private int texId;
    private final int type;
    private int unit;
    private final float[] value;

    public GlUtil$Uniform(int n10, int n11) {
        int n12 = 1;
        Object object = new int[n12];
        GLES20.glGetProgramiv((int)n10, (int)35719, (int[])object, (int)0);
        int[] nArray = new int[n12];
        int[] nArray2 = new int[n12];
        byte[] byArray = new byte[object[0]];
        int[] nArray3 = new int[n12];
        int n13 = object[0];
        int n14 = n10;
        int n15 = n11;
        GLES20.glGetActiveUniform((int)n10, (int)n11, (int)n13, (int[])nArray3, (int)0, (int[])nArray2, (int)0, (int[])nArray, (int)0, (byte[])byArray, (int)0);
        object = new String;
        n15 = GlUtil.access$000(byArray);
        super(byArray, 0, n15);
        this.name = object;
        this.location = n14 = GLES20.glGetUniformLocation((int)n10, (String)object);
        this.type = n14 = nArray[0];
        object = new float[n12];
        this.value = object;
    }

    public void bind() {
        block4: {
            int n10;
            block7: {
                int n11;
                int n12;
                block6: {
                    block5: {
                        n12 = this.type;
                        n10 = 5126;
                        if (n12 == n10) {
                            n12 = this.location;
                            float[] fArray = this.value;
                            GLES20.glUniform1fv((int)n12, (int)1, (float[])fArray, (int)0);
                            GlUtil.checkGlError();
                            return;
                        }
                        n12 = this.texId;
                        if (n12 == 0) break block4;
                        GLES20.glActiveTexture((int)(this.unit + 33984));
                        n12 = this.type;
                        n10 = 36198;
                        n11 = 3553;
                        if (n12 != n10) break block5;
                        n12 = 36197;
                        n10 = this.texId;
                        GLES20.glBindTexture((int)n12, (int)n10);
                        break block6;
                    }
                    n10 = 35678;
                    if (n12 != n10) break block7;
                    n12 = this.texId;
                    GLES20.glBindTexture((int)n11, (int)n12);
                }
                n12 = this.location;
                n10 = this.unit;
                GLES20.glUniform1i((int)n12, (int)n10);
                n10 = 9729;
                GLES20.glTexParameteri((int)n11, (int)10240, (int)n10);
                GLES20.glTexParameteri((int)n11, (int)10241, (int)n10);
                n10 = 33071;
                GLES20.glTexParameteri((int)n11, (int)10242, (int)n10);
                GLES20.glTexParameteri((int)n11, (int)10243, (int)n10);
                GlUtil.checkGlError();
                return;
            }
            n10 = this.type;
            StringBuilder stringBuilder = new StringBuilder(36);
            stringBuilder.append("unexpected uniform type: ");
            stringBuilder.append(n10);
            String string2 = stringBuilder.toString();
            IllegalStateException illegalStateException = new IllegalStateException(string2);
            throw illegalStateException;
        }
        IllegalStateException illegalStateException = new IllegalStateException("call setSamplerTexId before bind");
        throw illegalStateException;
    }

    public void setFloat(float f10) {
        this.value[0] = f10;
    }

    public void setSamplerTexId(int n10, int n11) {
        this.texId = n10;
        this.unit = n11;
    }
}

