/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.opengl.GLES20
 */
package com.tencent.liteav.beauty.b;

import android.opengl.GLES20;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.opengl.i;

public class q
extends i {
    private static String v = "GPUSharpen";
    private int r;
    private float s;
    private int t;
    private int u;

    public q() {
        this(0.0f);
    }

    public q(float f10) {
        super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n\nuniform float imageWidthFactor; \nuniform float imageHeightFactor; \n\nvarying vec2 textureCoordinate;\nvarying vec2 leftTextureCoordinate;\nvarying vec2 rightTextureCoordinate; \nvarying vec2 topTextureCoordinate;\nvarying vec2 bottomTextureCoordinate;\n\n\nvoid main()\n{\n    gl_Position = position;\n    \n    mediump vec2 widthStep = vec2(imageWidthFactor, 0.0);\n    mediump vec2 heightStep = vec2(0.0, imageHeightFactor);\n    \n    textureCoordinate = inputTextureCoordinate.xy;\n    leftTextureCoordinate = inputTextureCoordinate.xy - widthStep;\n    rightTextureCoordinate = inputTextureCoordinate.xy + widthStep;\n    topTextureCoordinate = inputTextureCoordinate.xy + heightStep;     \n    bottomTextureCoordinate = inputTextureCoordinate.xy - heightStep;\n}\n", "precision mediump float;\n\nuniform float sharpness;\nvarying mediump vec2 textureCoordinate;\nvarying mediump vec2 leftTextureCoordinate;\nvarying mediump vec2 rightTextureCoordinate; \nvarying mediump vec2 topTextureCoordinate;\nvarying mediump vec2 bottomTextureCoordinate;\n\nuniform sampler2D inputImageTexture;\nfloat centerMultiplier;\nfloat edgeMultiplier;\n\nvoid main()\n{\n    mediump vec4 textureColor = texture2D(inputImageTexture, textureCoordinate);\n    mediump vec3 leftTextureColor = texture2D(inputImageTexture, leftTextureCoordinate).rgb;\n    mediump vec3 rightTextureColor = texture2D(inputImageTexture, rightTextureCoordinate).rgb;\n    mediump vec3 topTextureColor = texture2D(inputImageTexture, topTextureCoordinate).rgb;\n    mediump vec3 bottomTextureColor = texture2D(inputImageTexture, bottomTextureCoordinate).rgb;\n\n    centerMultiplier = 1.0 + 4.0 * sharpness * (1.0 - textureColor.a);\n    edgeMultiplier = sharpness * (1.0 - textureColor.a);\n    gl_FragColor = vec4((textureColor.rgb * centerMultiplier - (leftTextureColor * edgeMultiplier + rightTextureColor * edgeMultiplier + topTextureColor * edgeMultiplier + bottomTextureColor * edgeMultiplier)), textureColor.a);    \n}\n");
        this.s = f10;
    }

    public void a(float f10) {
        this.s = f10;
        String string2 = v;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("set Sharpness ");
        stringBuilder.append(f10);
        String string3 = stringBuilder.toString();
        TXCLog.i(string2, string3);
        int n10 = this.r;
        float f11 = this.s;
        this.a(n10, f11);
    }

    public void a(int n10, int n11) {
        super.a(n10, n11);
        int n12 = this.t;
        float f10 = n10;
        float f11 = 1.0f;
        f10 = f11 / f10;
        this.a(n12, f10);
        n10 = this.u;
        float f12 = n11;
        this.a(n10, f11 /= f12);
    }

    public boolean b() {
        int n10;
        boolean bl2 = super.b();
        this.r = n10 = GLES20.glGetUniformLocation((int)this.q(), (String)"sharpness");
        this.t = n10 = GLES20.glGetUniformLocation((int)this.q(), (String)"imageWidthFactor");
        this.u = n10 = GLES20.glGetUniformLocation((int)this.q(), (String)"imageHeightFactor");
        float f10 = this.s;
        this.a(f10);
        return bl2;
    }
}

