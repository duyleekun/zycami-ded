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

public class t
extends i {
    private ByteBuffer r;
    public int u;
    public int v;
    public int w;

    public t(String string2) {
        this("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\nattribute vec4 inputTextureCoordinate2;\n \nvarying vec2 textureCoordinate;\nvarying vec2 textureCoordinate2;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n    textureCoordinate2 = inputTextureCoordinate2.xy;\n}", string2);
    }

    public t(String object, String string2) {
        super((String)object, string2);
        int n10;
        this.u = n10 = -1;
        this.w = n10;
        object = com.tencent.liteav.basic.opengl.k.a;
        this.a((k)((Object)object), false, true);
    }

    public int a(int n10, int n11, int n12, int n13) {
        this.w = n11;
        return this.a(n10, n12, n13);
    }

    public void a(k object, boolean bl2, boolean bl3) {
        object = com.tencent.liteav.basic.opengl.l.a(object, bl2, bl3);
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(32);
        Object object2 = ByteOrder.nativeOrder();
        byteBuffer = byteBuffer.order((ByteOrder)object2);
        object2 = byteBuffer.asFloatBuffer();
        ((FloatBuffer)object2).put((float[])object);
        ((FloatBuffer)object2).flip();
        this.r = byteBuffer;
    }

    public boolean b() {
        boolean bl2 = super.b();
        if (bl2) {
            int n10;
            this.u = n10 = GLES20.glGetAttribLocation((int)this.q(), (String)"inputTextureCoordinate2");
            n10 = this.q();
            String string2 = "inputImageTexture2";
            this.v = n10 = GLES20.glGetUniformLocation((int)n10, (String)string2);
        }
        return bl2;
    }

    public int c(int n10, int n11) {
        this.w = n11;
        n11 = this.m;
        int n12 = this.n;
        return this.a(n10, n11, n12);
    }

    public void e() {
        super.e();
    }

    public void i() {
        GLES20.glActiveTexture((int)33987);
        int n10 = this.w;
        GLES20.glBindTexture((int)3553, (int)n10);
        GLES20.glUniform1i((int)this.v, (int)3);
        n10 = this.u;
        int n11 = -1;
        if (n10 != n11) {
            GLES20.glEnableVertexAttribArray((int)n10);
            ByteBuffer byteBuffer = this.r;
            n11 = 0;
            byteBuffer.position(0);
            int n12 = this.u;
            int n13 = 2;
            int n14 = 5126;
            ByteBuffer byteBuffer2 = this.r;
            GLES20.glVertexAttribPointer((int)n12, (int)n13, (int)n14, (boolean)false, (int)0, (Buffer)byteBuffer2);
        }
    }
}

