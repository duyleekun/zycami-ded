/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.opengl.GLES20
 */
package com.tencent.liteav.beauty.b.a;

import android.opengl.GLES20;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.opengl.i;
import com.tencent.liteav.beauty.NativeLoad;

public class d
extends i {
    private int r;
    private int s;
    private float t;
    private String u;

    public d() {
        super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "varying lowp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}");
        int n10;
        this.r = n10 = -1;
        this.s = n10;
        this.t = 4.0f;
        this.u = "SmoothHorizontal";
    }

    public void a(int n10, int n11) {
        super.a(n10, n11);
        int n12 = 0x40000000;
        float f10 = 2.0f;
        float f11 = 4.0f;
        int n13 = 540;
        float f12 = 7.57E-43f;
        this.t = n10 > n11 ? (n11 < n13 ? f10 : f11) : (n10 < n13 ? f10 : f11);
        String string2 = this.u;
        CharSequence charSequence = new StringBuilder();
        charSequence.append("m_textureRation ");
        f12 = this.t;
        charSequence.append(f12);
        charSequence = charSequence.toString();
        TXCLog.i(string2, (String)charSequence);
        n12 = this.r;
        f11 = this.t;
        float f13 = n10;
        this.a(n12, f11 /= f13);
        n10 = this.s;
        f10 = this.t;
        float f14 = n11;
        this.a(n10, f10 /= f14);
    }

    public boolean a() {
        int n10;
        this.a = n10 = NativeLoad.nativeLoadGLProgram(13);
        if (n10 != 0 && (n10 = (int)(this.b() ? 1 : 0)) != 0) {
            n10 = 1;
            this.g = n10;
        } else {
            n10 = 0;
            this.g = false;
        }
        this.c();
        return this.g;
    }

    public boolean b() {
        super.b();
        this.r();
        return true;
    }

    public void r() {
        int n10;
        this.r = n10 = GLES20.glGetUniformLocation((int)this.q(), (String)"texelWidthOffset");
        this.s = n10 = GLES20.glGetUniformLocation((int)this.q(), (String)"texelHeightOffset");
    }
}

