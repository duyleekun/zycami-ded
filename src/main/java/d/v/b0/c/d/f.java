/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.opengl.GLES20
 *  android.opengl.Matrix
 *  android.util.Log
 */
package d.v.b0.c.d;

import android.opengl.GLES20;
import android.opengl.Matrix;
import android.util.Log;
import d.v.b0.c.d.b;
import d.v.b0.f.c.b.a;
import d.v.b0.f.c.b.e;
import d.v.b0.f.c.b.g;
import java.nio.Buffer;

public class f
extends g {
    private static final String q = "uniform mat4 uMVPMatrix;\nattribute vec4 aPosition;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n}\n";
    private static final String r = "precision mediump float;\n//varying vec2 vTextureCoord;\nuniform sampler2D sTexture;\n\nuniform int landscape;\nuniform int sTextureWidth;\nuniform int sTextureHeight;\nuniform int viewPortWidth;\nuniform int viewPortHeight;\nvec4 redColor;\nvec2 coorXY;\n\nvoid main() {\n\n    float x = gl_FragCoord.x;\n    float y = gl_FragCoord.y;\n\n    //gl_FragColor = texture2D(sTexture, vTextureCoord);\n    redColor = vec4(255.0f,0.0f,0.0f,0.0f);\n\n    if(landscape == 1){\n\n        float right    = float(viewPortWidth) / 2.0f + float(sTextureWidth) / 2.0f;\n        float left     = float(viewPortWidth) / 2.0f - float(sTextureWidth) / 2.0f;\n\n        if(x >= right || x<= left){\n            gl_FragColor = redColor;\n        }else{\n            float coorX =  (x - left) / float(sTextureWidth);\n            float coorY =  y / float(viewPortHeight);\n            coorXY = vec2(coorX,coorY);\n            gl_FragColor = texture2D(sTexture, coorXY);\n        }\n\n    } else{\n\n        float top    = float(viewPortHeight) / 2.0f + float(sTextureHeight) / 2.0f;\n        float bottom = float(viewPortHeight) / 2.0f - float(sTextureHeight) / 2.0f;\n\n        if(y >= top || y <= bottom){\n            gl_FragColor = redColor;\n        }else{\n            float a2=  x / float(viewPortWidth);\n            float b2 =  (y - bottom) / float(viewPortHeight);\n            coorXY = vec2(a2,b2);\n            gl_FragColor = texture2D(sTexture, coorXY);\n        }\n\n    }\n\n\n\n}\n";
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;
    private int l;
    private int m;
    private int n;
    private int o;
    private boolean p = true;

    public f() {
        super(q, r);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Transform mProgramHandle:");
        int n10 = this.a;
        stringBuilder.append(n10);
        d.v.b0.j.b.b(stringBuilder.toString());
    }

    public void b(int n10, float[] fArray, float[] fArray2) {
    }

    public a d() {
        b b10 = new b();
        return b10;
    }

    public void e() {
        int n10 = this.a;
        String string2 = "aPosition";
        this.f = n10 = GLES20.glGetAttribLocation((int)n10, (String)string2);
        d.v.b0.f.c.b.e.e(n10, string2);
        n10 = this.a;
        string2 = "uMVPMatrix";
        this.e = n10 = GLES20.glGetUniformLocation((int)n10, (String)string2);
        d.v.b0.f.c.b.e.e(n10, string2);
        n10 = this.a;
        string2 = "landscape";
        this.g = n10 = GLES20.glGetUniformLocation((int)n10, (String)string2);
        d.v.b0.f.c.b.e.e(n10, string2);
        n10 = this.a;
        string2 = "sTextureWidth";
        this.j = n10 = GLES20.glGetUniformLocation((int)n10, (String)string2);
        d.v.b0.f.c.b.e.e(n10, string2);
        n10 = this.a;
        string2 = "sTextureHeight";
        this.k = n10 = GLES20.glGetUniformLocation((int)n10, (String)string2);
        d.v.b0.f.c.b.e.e(n10, string2);
        n10 = this.a;
        string2 = "viewPortWidth";
        this.h = n10 = GLES20.glGetUniformLocation((int)n10, (String)string2);
        d.v.b0.f.c.b.e.e(n10, string2);
        n10 = this.a;
        string2 = "viewPortHeight";
        this.i = n10 = GLES20.glGetUniformLocation((int)n10, (String)string2);
        d.v.b0.f.c.b.e.e(n10, string2);
    }

    public void i(int n10, float[] fArray, float[] fArray2, int n11, int n12, int n13, int n14, boolean bl2, boolean bl3) {
        CharSequence charSequence;
        StringBuilder stringBuilder;
        Object object;
        f f10 = this;
        int n15 = n11;
        int n16 = n12;
        int n17 = n13;
        int n18 = n14;
        int n19 = bl2;
        d.v.b0.f.c.b.e.d("draw start");
        this.l = n11;
        this.m = n12;
        this.n = n13;
        this.o = n14;
        String string2 = "ZL";
        float f11 = 1.0f;
        if (bl2) {
            if (!bl3) {
                float f12 = n12;
                f11 *= f12;
                float f13 = n11;
                this.n = n12;
                this.o = n15 = (int)(f12 *= (f11 /= f13));
                float[] fArray3 = d.v.b0.f.c.b.e.b(n12, n15, n13, n14);
                object = fArray2;
                Matrix.multiplyMM((float[])fArray2, (int)0, (float[])fArray2, (int)0, (float[])fArray3, (int)0);
            } else {
                n16 = (int)(this.p ? 1 : 0);
                if (n16 != 0) {
                    stringBuilder = new StringBuilder();
                    String string3 = "\u5b8c\u5168\u5339\u914d\u6a2a\u5c4f(\u6a2a\u5c4f\u6a2a\u5411\uff09\uff1aviewportWidth\uff1a";
                    stringBuilder.append(string3);
                    stringBuilder.append(n11);
                    stringBuilder.append(" textureWidth\uff1a");
                    stringBuilder.append(n13);
                    charSequence = stringBuilder.toString();
                    Log.e((String)string2, (String)charSequence);
                }
            }
        } else if (!bl3) {
            float f14 = n12;
            f11 *= f14;
            float f15 = n11;
            this.n = n12;
            this.o = n15 = (int)(f14 *= (f11 /= f15));
        }
        n15 = (int)(f10.p ? 1 : 0);
        n16 = 0;
        stringBuilder = null;
        if (n15 != 0) {
            f10.p = false;
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append("=== viewportWidth:");
            n17 = f10.l;
            ((StringBuilder)charSequence).append(n17);
            ((StringBuilder)charSequence).append("   viewportHeight:");
            n17 = f10.m;
            ((StringBuilder)charSequence).append(n17);
            ((StringBuilder)charSequence).append("  textureWidth:");
            n17 = f10.n;
            ((StringBuilder)charSequence).append(n17);
            ((StringBuilder)charSequence).append("   textureHeight:");
            n17 = f10.o;
            ((StringBuilder)charSequence).append(n17);
            String string4 = " scale:";
            ((StringBuilder)charSequence).append(string4);
            ((StringBuilder)charSequence).append(f11);
            charSequence = ((StringBuilder)charSequence).toString();
            Log.e((String)string2, (String)charSequence);
        }
        GLES20.glUseProgram((int)f10.a);
        d.v.b0.f.c.b.e.d("glUseProgram");
        GLES20.glActiveTexture((int)33984);
        n15 = 3553;
        n17 = n10;
        GLES20.glBindTexture((int)n15, (int)n10);
        GLES20.glUniform1i((int)f10.g, (int)n19);
        d.v.b0.f.c.b.e.d("glUniform1f mLandscapeHandle");
        n17 = f10.h;
        n18 = f10.l;
        GLES20.glUniform1i((int)n17, (int)n18);
        d.v.b0.f.c.b.e.d("glUniform1f mViewPortWidthHandle");
        n17 = f10.i;
        n18 = f10.m;
        GLES20.glUniform1i((int)n17, (int)n18);
        d.v.b0.f.c.b.e.d("glUniform1f mViewPortHeightHandle");
        n17 = f10.j;
        n18 = f10.n;
        GLES20.glUniform1i((int)n17, (int)n18);
        d.v.b0.f.c.b.e.d("glUniform1f mTextureWidthHandle");
        n17 = f10.k;
        n18 = f10.o;
        GLES20.glUniform1i((int)n17, (int)n18);
        d.v.b0.f.c.b.e.d("glUniform1f mTextureHeightHandle");
        GLES20.glUniformMatrix4fv((int)f10.e, (int)1, (boolean)false, (float[])fArray2, (int)0);
        d.v.b0.f.c.b.e.d("glUniformMatrix4fv");
        GLES20.glEnableVertexAttribArray((int)f10.f);
        d.v.b0.f.c.b.e.d("glEnableVertexAttribArray");
        n17 = f10.f;
        object = f10.b.d();
        n10 = n17;
        int n20 = 2;
        int n21 = 5126;
        n12 = 8;
        GLES20.glVertexAttribPointer((int)n17, (int)n20, (int)n21, (boolean)false, (int)n12, (Buffer)object);
        d.v.b0.f.c.b.e.d("glVertexAttribPointer");
        n18 = f10.b.e();
        GLES20.glDrawArrays((int)5, (int)0, (int)n18);
        d.v.b0.f.c.b.e.d("glDrawArrays");
        GLES20.glDisableVertexAttribArray((int)f10.f);
        GLES20.glBindTexture((int)n15, (int)0);
        GLES20.glUseProgram((int)0);
    }
}

