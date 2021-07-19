/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.opengl.GLES20
 */
package com.tencent.liteav.beauty.b;

import android.opengl.GLES20;
import com.tencent.liteav.basic.opengl.i;
import com.tencent.liteav.basic.opengl.k;
import com.tencent.liteav.basic.opengl.l;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public class s
extends i {
    public int r;
    public int s;
    public int t;
    public int u;
    public int v;
    public int w;
    private ByteBuffer x;
    private ByteBuffer y;

    public s(String object) {
        this("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\nattribute vec4 inputTextureCoordinate2;\nattribute vec4 inputTextureCoordinate3;\n \nvarying vec2 textureCoordinate;\nvarying vec2 textureCoordinate2;\nvarying vec2 textureCoordinate3;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n    textureCoordinate2 = inputTextureCoordinate2.xy;\n    textureCoordinate3 = inputTextureCoordinate3.xy;\n}", (String)object);
        object = com.tencent.liteav.basic.opengl.k.a;
        this.a((k)((Object)object), false, true);
    }

    public s(String object, String string2) {
        super((String)object, string2);
        int n10;
        this.t = n10 = -1;
        this.w = n10;
        object = com.tencent.liteav.basic.opengl.k.a;
        this.a((k)((Object)object), false, true);
    }

    public int a(int n10, int n11, int n12) {
        int n13 = this.m;
        int n14 = this.n;
        return this.a(n10, n11, n12, n13, n14);
    }

    public int a(int n10, int n11, int n12, int n13, int n14) {
        this.t = n11;
        this.w = n12;
        return super.a(n10, n13, n14);
    }

    public void a(int n10, int n11) {
        super.a(n10, n11);
    }

    /*
     * WARNING - void declaration
     */
    public void a(k object, boolean bl2, boolean bl3) {
        void var3_4;
        object = com.tencent.liteav.basic.opengl.l.a(object, bl2, (boolean)var3_4);
        int n10 = 32;
        Object object2 = ByteBuffer.allocateDirect(n10);
        Object object3 = ByteOrder.nativeOrder();
        object2 = ((ByteBuffer)object2).order((ByteOrder)object3);
        object3 = ((ByteBuffer)object2).asFloatBuffer();
        ((FloatBuffer)object3).put((float[])object);
        ((FloatBuffer)object3).flip();
        this.x = object2;
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(n10);
        object2 = ByteOrder.nativeOrder();
        byteBuffer = byteBuffer.order((ByteOrder)object2);
        object2 = byteBuffer.asFloatBuffer();
        ((FloatBuffer)object2).put((float[])object);
        ((FloatBuffer)object2).flip();
        this.y = byteBuffer;
    }

    public boolean b() {
        int n10;
        boolean bl2 = super.b();
        GLES20.glUseProgram((int)this.q());
        this.r = n10 = GLES20.glGetAttribLocation((int)this.q(), (String)"inputTextureCoordinate2");
        this.u = n10 = GLES20.glGetAttribLocation((int)this.q(), (String)"inputTextureCoordinate3");
        this.s = n10 = GLES20.glGetUniformLocation((int)this.q(), (String)"inputImageTexture2");
        this.v = n10 = GLES20.glGetUniformLocation((int)this.q(), (String)"inputImageTexture3");
        GLES20.glEnableVertexAttribArray((int)this.r);
        GLES20.glEnableVertexAttribArray((int)this.u);
        return bl2;
    }

    public void i() {
        GLES20.glEnableVertexAttribArray((int)this.r);
        GLES20.glActiveTexture((int)33987);
        int n10 = this.t;
        int n11 = 3553;
        GLES20.glBindTexture((int)n11, (int)n10);
        GLES20.glUniform1i((int)this.s, (int)3);
        this.x.position(0);
        int n12 = this.r;
        ByteBuffer byteBuffer = this.x;
        int n13 = 2;
        int n14 = 5126;
        GLES20.glVertexAttribPointer((int)n12, (int)n13, (int)n14, (boolean)false, (int)0, (Buffer)byteBuffer);
        GLES20.glEnableVertexAttribArray((int)this.u);
        GLES20.glActiveTexture((int)33988);
        n10 = this.w;
        GLES20.glBindTexture((int)n11, (int)n10);
        GLES20.glUniform1i((int)this.v, (int)4);
        this.y.position(0);
        n12 = this.u;
        byteBuffer = this.y;
        GLES20.glVertexAttribPointer((int)n12, (int)n13, (int)n14, (boolean)false, (int)0, (Buffer)byteBuffer);
    }
}

