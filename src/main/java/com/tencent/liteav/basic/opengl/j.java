/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.opengl.GLES20
 */
package com.tencent.liteav.basic.opengl;

import android.opengl.GLES20;
import com.tencent.liteav.basic.opengl.i;
import java.nio.Buffer;
import java.nio.FloatBuffer;

public class j
extends i {
    public boolean r;
    private float[] s;
    private int t;

    public j() {
        super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nuniform mat4 textureTransform;\nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = (textureTransform * inputTextureCoordinate).xy;\n}", "#extension GL_OES_EGL_image_external : require\n\nvarying lowp vec2 textureCoordinate;\n \nuniform samplerExternalOES inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}");
        float[] fArray = new float[16];
        this.s = fArray;
        this.r = false;
        this.o = true;
    }

    public void a(int n10, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        float[] fArray;
        GLES20.glUseProgram((int)this.a);
        this.k();
        boolean bl2 = this.n();
        if (bl2 && (fArray = this.s) != null) {
            bl2 = false;
            fArray = null;
            floatBuffer.position(0);
            int n11 = this.b;
            int n12 = 2;
            int n13 = 5126;
            GLES20.glVertexAttribPointer((int)n11, (int)n12, (int)n13, (boolean)false, (int)0, (Buffer)floatBuffer);
            GLES20.glEnableVertexAttribArray((int)this.b);
            floatBuffer2.position(0);
            n11 = this.d;
            GLES20.glVertexAttribPointer((int)n11, (int)n12, (int)n13, (boolean)false, (int)0, (Buffer)floatBuffer2);
            GLES20.glEnableVertexAttribArray((int)this.d);
            int n14 = this.t;
            float[] fArray2 = this.s;
            GLES20.glUniformMatrix4fv((int)n14, (int)1, (boolean)false, (float[])fArray2, (int)0);
            n14 = -1;
            int n15 = 36197;
            if (n10 != n14) {
                n14 = 33984;
                GLES20.glActiveTexture((int)n14);
                GLES20.glBindTexture((int)n15, (int)n10);
                n10 = this.c;
                GLES20.glUniform1i((int)n10, (int)0);
            }
            n14 = 4;
            GLES20.glDrawArrays((int)5, (int)0, (int)n14);
            GLES20.glDisableVertexAttribArray((int)this.b);
            n10 = this.d;
            GLES20.glDisableVertexAttribArray((int)n10);
            GLES20.glBindTexture((int)n15, (int)0);
        }
    }

    public void a(float[] fArray) {
        this.s = fArray;
    }

    public boolean b() {
        int n10 = super.b();
        int n11 = this.a;
        String string2 = "textureTransform";
        this.t = n11 = GLES20.glGetUniformLocation((int)n11, (String)string2);
        return n10 != 0 && (n10 = GLES20.glGetError()) == 0;
    }
}

