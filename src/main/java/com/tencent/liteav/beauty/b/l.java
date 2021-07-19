/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.opengl.GLES20
 */
package com.tencent.liteav.beauty.b;

import android.opengl.GLES20;
import com.tencent.liteav.basic.opengl.i;

public class l
extends i {
    private static String r = "attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n\nuniform int  bTransform;\nuniform mat4 textureTransform;\n\nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n     gl_Position = position;\n    if (0 != bTransform){\n        textureCoordinate =  (textureTransform * inputTextureCoordinate).xy;\n    }else{\n        textureCoordinate = inputTextureCoordinate.xy;\n    }\n}\n";
    private int s;
    private boolean t;

    public l() {
        String string2 = r;
        this(string2, "varying lowp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}", false);
    }

    public l(String string2, String string3, boolean bl2) {
        super(string2, string3, bl2);
        this.s = -1;
        this.t = false;
    }

    public void a(float[] fArray) {
        if (fArray != null) {
            int n10 = this.s;
            int n11 = 1;
            this.b(n10, n11);
        } else {
            int n12 = this.s;
            boolean bl2 = false;
            this.b(n12, 0);
        }
        super.a(fArray);
    }

    public boolean b() {
        int n10;
        boolean bl2 = super.b();
        this.s = n10 = GLES20.glGetUniformLocation((int)this.a, (String)"bTransform");
        this.b(n10, 0);
        return bl2;
    }

    public void c(boolean bl2) {
        boolean bl3 = this.t;
        if (bl2 != bl3) {
            this.t = bl2;
            this.h();
        }
    }
}

