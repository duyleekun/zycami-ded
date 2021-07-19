/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.opengl.GLES20
 */
package com.tencent.liteav.beauty.b;

import android.opengl.GLES20;
import com.tencent.liteav.beauty.NativeLoad;
import com.tencent.liteav.beauty.b.c;
import com.tencent.liteav.beauty.b.s;

public class c$a
extends s {
    private int x;
    private int y;
    private int z;

    public c$a() {
        super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\nattribute vec4 inputTextureCoordinate2;\nattribute vec4 inputTextureCoordinate3;\n \nvarying vec2 textureCoordinate;\nvarying vec2 textureCoordinate2;\nvarying vec2 textureCoordinate3;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n    textureCoordinate2 = inputTextureCoordinate2.xy;\n    textureCoordinate3 = inputTextureCoordinate3.xy;\n}", "varying lowp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}");
        int n10;
        this.x = n10 = -1;
        this.y = n10;
        this.z = n10;
    }

    public void a(float f10) {
        int n10 = this.x;
        f10 = com.tencent.liteav.beauty.b.c.a(f10);
        this.a(n10, f10);
    }

    public void a(int n10, int n11) {
        int n12 = this.f;
        if (n12 == n11 && (n12 = this.e) == n10) {
            return;
        }
        super.a(n10, n11);
        this.x = n10 = GLES20.glGetUniformLocation((int)this.q(), (String)"smoothDegree");
        this.y = n10 = GLES20.glGetUniformLocation((int)this.q(), (String)"brightDegree");
        this.z = n10 = GLES20.glGetUniformLocation((int)this.q(), (String)"ruddyDegree");
    }

    public boolean a() {
        int n10;
        int n11 = 1;
        this.a = n10 = NativeLoad.nativeLoadGLProgram(n11);
        if (n10 != 0 && (n10 = (int)(this.b() ? 1 : 0)) != 0) {
            this.g = n11;
        } else {
            n11 = 0;
            this.g = false;
        }
        this.c();
        return this.g;
    }

    public void b(float f10) {
        int n10 = this.y;
        this.a(n10, f10 /= 3.0f);
    }

    public boolean b() {
        return super.b();
    }

    public void c(float f10) {
        int n10 = this.z;
        f10 = f10 / 10.0f / 2.0f;
        this.a(n10, f10);
    }
}

