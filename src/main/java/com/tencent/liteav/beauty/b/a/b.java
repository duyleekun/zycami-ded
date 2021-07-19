/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.opengl.GLES20
 *  android.util.Log
 */
package com.tencent.liteav.beauty.b.a;

import android.opengl.GLES20;
import android.util.Log;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.beauty.NativeLoad;
import com.tencent.liteav.beauty.b.t;

public class b
extends t {
    private int r;
    private int s;
    private int t;
    private final String x;

    public b() {
        super("varying lowp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}");
        int n10;
        this.r = n10 = -1;
        this.s = n10;
        this.t = n10;
        this.x = "BeautyBlend";
    }

    private void r() {
        int n10;
        this.s = n10 = GLES20.glGetUniformLocation((int)this.q(), (String)"whiteDegree");
        this.r = n10 = GLES20.glGetUniformLocation((int)this.q(), (String)"contrast");
        this.t = n10 = GLES20.glGetUniformLocation((int)this.q(), (String)"ruddyDegree");
    }

    public void a(float f10) {
        CharSequence charSequence = new StringBuilder();
        charSequence.append("setBrightLevel ");
        charSequence.append(f10);
        charSequence = charSequence.toString();
        TXCLog.i("BeautyBlend", (String)charSequence);
        int n10 = this.s;
        this.a(n10, f10);
    }

    public boolean a() {
        int n10;
        this.a = n10 = NativeLoad.nativeLoadGLProgram(12);
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

    public void b(float f10) {
        CharSequence charSequence = new StringBuilder();
        charSequence.append("setRuddyLevel level ");
        charSequence.append(f10);
        charSequence = charSequence.toString();
        Log.i((String)"BeautyBlend", (String)charSequence);
        int n10 = this.t;
        this.a(n10, f10 /= 2.0f);
    }

    public boolean b() {
        super.b();
        this.r();
        return true;
    }
}

