/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.opengl.GLES20
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.util.Log
 */
package com.tencent.liteav.beauty.b.a;

import android.opengl.GLES20;
import android.os.Build;
import android.util.Log;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.beauty.NativeLoad;
import com.tencent.liteav.beauty.b.t;

public class e
extends t {
    private String A;
    private int r;
    private int s;
    private int t;
    private int x;
    private float y;
    private float z;

    public e() {
        super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "varying lowp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}");
        int n10;
        this.r = n10 = -1;
        this.s = n10;
        this.t = n10;
        this.x = n10;
        this.y = 2.0f;
        this.z = 0.5f;
        this.A = "SmoothVertical";
    }

    public void a(float f10) {
        this.z = f10;
        String string2 = this.A;
        CharSequence charSequence = new StringBuilder();
        charSequence.append("setBeautyLevel ");
        charSequence.append(f10);
        charSequence = charSequence.toString();
        TXCLog.i(string2, (String)charSequence);
        int n10 = this.t;
        this.a(n10, f10);
    }

    public void a(int n10, int n11) {
        super.a(n10, n11);
        int n12 = 0x40000000;
        float f10 = 2.0f;
        float f11 = 4.0f;
        int n13 = 540;
        float f12 = 7.57E-43f;
        this.y = n10 > n11 ? (n11 < n13 ? f10 : f11) : (n10 < n13 ? f10 : f11);
        String string2 = this.A;
        CharSequence charSequence = new StringBuilder();
        charSequence.append("m_textureRation ");
        f12 = this.y;
        charSequence.append(f12);
        charSequence = charSequence.toString();
        TXCLog.i(string2, (String)charSequence);
        n12 = this.r;
        f11 = this.y;
        float f13 = n10;
        this.a(n12, f11 /= f13);
        n10 = this.s;
        f10 = this.y;
        float f14 = n11;
        this.a(n10, f10 /= f14);
    }

    public boolean a() {
        String string2 = Build.BRAND;
        String string3 = "samsung";
        int n10 = string2.equals(string3);
        if (n10 != 0 && (n10 = (int)((string2 = Build.MODEL).equals(string3 = "GT-I9500") ? 1 : 0)) != 0 && (n10 = (int)((string2 = Build.VERSION.RELEASE).equals(string3 = "4.3") ? 1 : 0)) != 0) {
            string2 = this.A;
            string3 = "SAMSUNG_S4 GT-I9500 + Android 4.3; use diffrent shader!";
            Log.d((String)string2, (String)string3);
            this.a = n10 = NativeLoad.nativeLoadGLProgram(15);
        } else {
            this.a = n10 = NativeLoad.nativeLoadGLProgram(5);
        }
        n10 = this.a;
        if (n10 != 0 && (n10 = (int)(this.b() ? 1 : 0)) != 0) {
            n10 = 1;
            this.g = n10;
        } else {
            n10 = 0;
            string2 = null;
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
        this.t = n10 = GLES20.glGetUniformLocation((int)this.q(), (String)"smoothDegree");
    }
}

