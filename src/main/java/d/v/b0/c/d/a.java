/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.opengl.GLES20
 */
package d.v.b0.c.d;

import android.opengl.GLES20;
import d.v.b0.c.d.b;
import d.v.b0.f.c.b.e;
import d.v.b0.f.c.b.g;
import java.nio.Buffer;
import java.nio.FloatBuffer;

public class a
extends g {
    private static final String p = "attribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = aPosition;\n    vTextureCoord = aTextureCoord.xy;\n}\n";
    private static final String q = "precision mediump float;\nvarying vec2 vTextureCoord;\nuniform sampler2D sTexture;\nuniform int landscape;\nuniform int sTextureWidth;\nuniform int sTextureHeight;\nuniform int viewPortWidth;\nuniform int viewPortHeight;\n\nvoid main() {\n\n    float x = gl_FragCoord.x;\n    float y = gl_FragCoord.y;\n\n    vec4 blackColor = vec4(0.0f,0.0f,0.0f,0.0f);\n\n    vec4 redColor = vec4(0.0f,255.0f,0.0f,0.0f);\n    vec4 blueColor = vec4(255.0f,0.0f,0.0f,0.0f);\n\n    //float coorX =  x / 2162.0f;\n    //float coorY =  y / 1080.0f;\n    float halfWidth =  float(viewPortWidth) / 2.0f;\n\n    texture2D(sTexture,vTextureCoord);\n\n    gl_FragColor = blueColor;\n\n    if(x < halfWidth){\n        //gl_FragColor = texture2D(sTexture, vec2(coorX,coorY));\n        //gl_FragColor = redColor;//texture2D(sTexture, vec2(coorX,coorY));\n    }else{\n        //gl_FragColor = blueColor;\n    }\n\n\n\n    if(landscape == 1){\n        //\u6a2a\u5c4f\n        float left  = float(viewPortWidth) / 2.0f - float(sTextureWidth) / 2.0f;\n        float right = float(viewPortWidth) / 2.0f + float(sTextureWidth) / 2.0f;\n//        if(x <= left || x >= right){\n//            gl_FragColor = blackColor;\n//        }else{\n//            float coorX =  (x - left) / float(sTextureWidth);\n//            float coorY =  y / float(sTextureHeight);\n//            gl_FragColor = texture2D(sTexture, vec2(coorX,coorY));\n//        }\n    } else{\n        //\u7ad6\u5c4f\n        float top    = float(viewPortHeight) / 2.0f - float(sTextureHeight) / 2.0f;\n        float bottom = float(viewPortHeight) / 2.0f + float(sTextureHeight) / 2.0f;\n//        if(y <= top || y>= bottom){\n//            gl_FragColor = blackColor;\n//        }else{\n//            float coorX =  x / float(sTextureWidth);\n//            float coorY =  (y - top) / float(sTextureHeight);\n//            gl_FragColor = texture2D(sTexture, vec2(coorX,coorY));\n//        }\n    }\n\n}\n";
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

    public a() {
        super(p, q);
    }

    public void b(int n10, float[] fArray, float[] object) {
        d.v.b0.f.c.b.e.d("draw start");
        GLES20.glUseProgram((int)this.a);
        d.v.b0.f.c.b.e.d("glUseProgram");
        GLES20.glActiveTexture((int)33984);
        int n11 = 3553;
        GLES20.glBindTexture((int)n11, (int)n10);
        GLES20.glEnableVertexAttribArray((int)this.e);
        String string2 = "glEnableVertexAttribArray";
        d.v.b0.f.c.b.e.d(string2);
        int n12 = this.e;
        FloatBuffer floatBuffer = this.b.d();
        GLES20.glVertexAttribPointer((int)n12, (int)2, (int)5126, (boolean)false, (int)8, (Buffer)floatBuffer);
        object = "glVertexAttribPointer";
        d.v.b0.f.c.b.e.d((String)object);
        GLES20.glEnableVertexAttribArray((int)this.f);
        d.v.b0.f.c.b.e.d(string2);
        int n13 = this.f;
        FloatBuffer floatBuffer2 = this.b.a();
        GLES20.glVertexAttribPointer((int)n13, (int)2, (int)5126, (boolean)false, (int)8, (Buffer)floatBuffer2);
        d.v.b0.f.c.b.e.d((String)object);
        n10 = this.b.e();
        GLES20.glDrawArrays((int)5, (int)0, (int)n10);
        d.v.b0.f.c.b.e.d("glDrawArrays");
        GLES20.glDisableVertexAttribArray((int)this.e);
        GLES20.glDisableVertexAttribArray((int)this.f);
        GLES20.glBindTexture((int)n11, (int)0);
        GLES20.glUseProgram((int)0);
    }

    public d.v.b0.f.c.b.a d() {
        b b10 = new b();
        return b10;
    }

    public void e() {
        int n10 = this.a;
        String string2 = "aPosition";
        this.e = n10 = GLES20.glGetAttribLocation((int)n10, (String)string2);
        d.v.b0.f.c.b.e.e(n10, string2);
        n10 = this.a;
        string2 = "aTextureCoord";
        this.f = n10 = GLES20.glGetAttribLocation((int)n10, (String)string2);
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

    public void i(int n10, int n11, int n12, int n13, int n14, boolean bl2) {
        d.v.b0.f.c.b.e.d("draw start");
        this.l = n11;
        this.m = n12;
        this.n = n13;
        this.o = n14;
        GLES20.glUseProgram((int)this.a);
        d.v.b0.f.c.b.e.d("glUseProgram");
        GLES20.glActiveTexture((int)33984);
        n11 = 3553;
        GLES20.glBindTexture((int)n11, (int)n10);
        GLES20.glUniform1i((int)this.g, (int)(bl2 ? 1 : 0));
        d.v.b0.f.c.b.e.d("glUniform1f mLandscapeHandle");
        n10 = this.h;
        n12 = this.l;
        GLES20.glUniform1i((int)n10, (int)n12);
        d.v.b0.f.c.b.e.d("glUniform1f mViewPortWidthHandle");
        n10 = this.i;
        n12 = this.m;
        GLES20.glUniform1i((int)n10, (int)n12);
        d.v.b0.f.c.b.e.d("glUniform1f mViewPortHeightHandle");
        n10 = this.j;
        n12 = this.n;
        GLES20.glUniform1i((int)n10, (int)n12);
        d.v.b0.f.c.b.e.d("glUniform1f mTextureWidthHandle");
        n10 = this.k;
        n12 = this.o;
        GLES20.glUniform1i((int)n10, (int)n12);
        d.v.b0.f.c.b.e.d("glUniform1f mTextureHeightHandle");
        GLES20.glEnableVertexAttribArray((int)this.e);
        String string2 = "glEnableVertexAttribArray";
        d.v.b0.f.c.b.e.d(string2);
        int n15 = this.e;
        int n16 = 2;
        int n17 = 5126;
        int n18 = 8;
        FloatBuffer floatBuffer = this.b.d();
        GLES20.glVertexAttribPointer((int)n15, (int)n16, (int)n17, (boolean)false, (int)n18, (Buffer)floatBuffer);
        String string3 = "glVertexAttribPointer";
        d.v.b0.f.c.b.e.d(string3);
        GLES20.glEnableVertexAttribArray((int)this.f);
        d.v.b0.f.c.b.e.d(string2);
        n15 = this.f;
        floatBuffer = this.b.a();
        GLES20.glVertexAttribPointer((int)n15, (int)n16, (int)n17, (boolean)false, (int)n18, (Buffer)floatBuffer);
        d.v.b0.f.c.b.e.d(string3);
        n12 = this.b.e();
        GLES20.glDrawArrays((int)5, (int)0, (int)n12);
        d.v.b0.f.c.b.e.d("glDrawArrays");
        GLES20.glDisableVertexAttribArray((int)this.e);
        GLES20.glDisableVertexAttribArray((int)this.f);
        GLES20.glBindTexture((int)n11, (int)0);
        GLES20.glUseProgram((int)0);
    }
}

