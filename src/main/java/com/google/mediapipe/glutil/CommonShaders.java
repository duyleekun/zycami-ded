/*
 * Decompiled with CFR 0.151.
 */
package com.google.mediapipe.glutil;

import com.google.mediapipe.glutil.ShaderUtil;
import java.nio.FloatBuffer;

public class CommonShaders {
    public static final String FRAGMENT_SHADER = "varying mediump vec2 sample_coordinate;\nuniform sampler2D video_frame;\n\nvoid main() {\n  gl_FragColor = texture2D(video_frame, sample_coordinate);\n}";
    public static final String FRAGMENT_SHADER_EXTERNAL = "#extension GL_OES_EGL_image_external : require\nvarying mediump vec2 sample_coordinate;\nuniform samplerExternalOES video_frame;\n\nvoid main() {\n  gl_FragColor = texture2D(video_frame, sample_coordinate);\n}";
    public static final FloatBuffer ROTATED_SQUARE_VERTICES;
    public static final FloatBuffer SQUARE_VERTICES;
    public static final String VERTEX_SHADER = "uniform mat4 texture_transform;\nattribute vec4 position;\nattribute mediump vec4 texture_coordinate;\nvarying mediump vec2 sample_coordinate;\n\nvoid main() {\n  gl_Position = position;\n  sample_coordinate = (texture_transform * texture_coordinate).xy;\n}";

    static {
        float[] fArray;
        float[] fArray2;
        int n10 = 8;
        float[] fArray3 = fArray2 = new float[n10];
        float[] fArray4 = fArray2;
        fArray3[0] = -1.0f;
        fArray4[1] = -1.0f;
        fArray3[2] = 1.0f;
        fArray4[3] = -1.0f;
        fArray3[4] = -1.0f;
        fArray4[5] = 1.0f;
        fArray3[6] = 1.0f;
        fArray4[7] = 1.0f;
        SQUARE_VERTICES = ShaderUtil.floatBuffer(fArray2);
        float[] fArray5 = fArray = new float[n10];
        float[] fArray6 = fArray;
        fArray5[0] = -1.0f;
        fArray6[1] = 1.0f;
        fArray5[2] = -1.0f;
        fArray6[3] = -1.0f;
        fArray5[4] = 1.0f;
        fArray6[5] = 1.0f;
        fArray5[6] = 1.0f;
        fArray6[7] = -1.0f;
        ROTATED_SQUARE_VERTICES = ShaderUtil.floatBuffer(fArray);
    }
}

