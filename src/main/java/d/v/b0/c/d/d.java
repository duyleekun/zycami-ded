/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.opengl.GLES20
 */
package d.v.b0.c.d;

import android.opengl.GLES20;
import d.v.b0.c.d.b;
import d.v.b0.f.c.b.a;
import d.v.b0.f.c.b.e;
import d.v.b0.f.c.b.g;
import java.nio.Buffer;
import java.nio.FloatBuffer;

public class d
extends g {
    private static final String i = "uniform mat4 uMVPMatrix;\nuniform mat4 uTexMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTexMatrix * aTextureCoord).xy;\n}\n";
    private static final String j = "precision mediump float;\nvarying vec2 vTextureCoord;\nuniform sampler2D sTexture;\nvoid main() {\n    gl_FragColor = vec4(texture2D(sTexture, vTextureCoord).rgb, 1.0);\n}\n";
    private int e;
    private int f;
    private int g;
    private int h;

    public d() {
        super(i, j);
    }

    public void b(int n10, float[] object, float[] fArray) {
        d.v.b0.f.c.b.e.d("draw start");
        GLES20.glUseProgram((int)this.a);
        d.v.b0.f.c.b.e.d("glUseProgram");
        GLES20.glActiveTexture((int)33984);
        int n11 = 3553;
        GLES20.glBindTexture((int)n11, (int)n10);
        n10 = this.e;
        int n12 = 1;
        GLES20.glUniformMatrix4fv((int)n10, (int)n12, (boolean)false, (float[])fArray, (int)0);
        String string2 = "glUniformMatrix4fv";
        d.v.b0.f.c.b.e.d(string2);
        GLES20.glUniformMatrix4fv((int)this.f, (int)n12, (boolean)false, (float[])object, (int)0);
        d.v.b0.f.c.b.e.d(string2);
        GLES20.glEnableVertexAttribArray((int)this.g);
        string2 = "glEnableVertexAttribArray";
        d.v.b0.f.c.b.e.d(string2);
        int n13 = this.g;
        FloatBuffer floatBuffer = this.b.d();
        int n14 = 2;
        int n15 = 5126;
        int n16 = 8;
        GLES20.glVertexAttribPointer((int)n13, (int)n14, (int)n15, (boolean)false, (int)n16, (Buffer)floatBuffer);
        object = "glVertexAttribPointer";
        d.v.b0.f.c.b.e.d((String)object);
        GLES20.glEnableVertexAttribArray((int)this.h);
        d.v.b0.f.c.b.e.d(string2);
        n13 = this.h;
        floatBuffer = this.b.a();
        GLES20.glVertexAttribPointer((int)n13, (int)n14, (int)n15, (boolean)false, (int)n16, (Buffer)floatBuffer);
        d.v.b0.f.c.b.e.d((String)object);
        n10 = this.b.e();
        GLES20.glDrawArrays((int)5, (int)0, (int)n10);
        d.v.b0.f.c.b.e.d("glDrawArrays");
        GLES20.glDisableVertexAttribArray((int)this.g);
        GLES20.glDisableVertexAttribArray((int)this.h);
        GLES20.glBindTexture((int)n11, (int)0);
        GLES20.glUseProgram((int)0);
    }

    public a d() {
        b b10 = new b();
        return b10;
    }

    public void e() {
        int n10 = this.a;
        String string2 = "aPosition";
        this.g = n10 = GLES20.glGetAttribLocation((int)n10, (String)string2);
        d.v.b0.f.c.b.e.e(n10, string2);
        n10 = this.a;
        string2 = "aTextureCoord";
        this.h = n10 = GLES20.glGetAttribLocation((int)n10, (String)string2);
        d.v.b0.f.c.b.e.e(n10, string2);
        n10 = this.a;
        string2 = "uMVPMatrix";
        this.e = n10 = GLES20.glGetUniformLocation((int)n10, (String)string2);
        d.v.b0.f.c.b.e.e(n10, string2);
        n10 = this.a;
        string2 = "uTexMatrix";
        this.f = n10 = GLES20.glGetUniformLocation((int)n10, (String)string2);
        d.v.b0.f.c.b.e.e(n10, string2);
    }
}

