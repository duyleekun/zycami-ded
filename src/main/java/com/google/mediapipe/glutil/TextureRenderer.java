/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.opengl.GLES20
 *  android.opengl.Matrix
 */
package com.google.mediapipe.glutil;

import android.opengl.GLES20;
import android.opengl.Matrix;
import com.google.mediapipe.glutil.CommonShaders;
import com.google.mediapipe.glutil.ShaderUtil;
import java.nio.Buffer;
import java.nio.FloatBuffer;
import java.util.HashMap;

public class TextureRenderer {
    private static final int ATTRIB_POSITION = 1;
    private static final int ATTRIB_TEXTURE_COORDINATE = 2;
    private static final FloatBuffer FLIPPED_TEXTURE_VERTICES;
    private static final String TAG = "TextureRenderer";
    private static final FloatBuffer TEXTURE_VERTICES;
    private boolean flipY;
    private int frameUniform;
    private int program = 0;
    private float[] textureTransformMatrix;
    private int textureTransformUniform;

    static {
        float[] fArray;
        float[] fArray2;
        int n10 = 8;
        float[] fArray3 = fArray2 = new float[n10];
        float[] fArray4 = fArray2;
        fArray3[0] = 0.0f;
        fArray4[1] = 0.0f;
        fArray3[2] = 1.0f;
        fArray4[3] = 0.0f;
        fArray3[4] = 0.0f;
        fArray4[5] = 1.0f;
        fArray3[6] = 1.0f;
        fArray4[7] = 1.0f;
        TEXTURE_VERTICES = ShaderUtil.floatBuffer(fArray2);
        float[] fArray5 = fArray = new float[n10];
        float[] fArray6 = fArray;
        fArray5[0] = 0.0f;
        fArray6[1] = 1.0f;
        fArray5[2] = 1.0f;
        fArray6[3] = 1.0f;
        fArray5[4] = 0.0f;
        fArray6[5] = 0.0f;
        fArray5[6] = 1.0f;
        fArray6[7] = 0.0f;
        FLIPPED_TEXTURE_VERTICES = ShaderUtil.floatBuffer(fArray);
    }

    public TextureRenderer() {
        float[] fArray = new float[16];
        this.textureTransformMatrix = fArray;
    }

    public void release() {
        GLES20.glDeleteProgram((int)this.program);
    }

    public void render(int n10) {
        GLES20.glClear((int)16384);
        GLES20.glActiveTexture((int)33984);
        String string2 = "glActiveTexture";
        ShaderUtil.checkGlError(string2);
        int n11 = 3553;
        GLES20.glBindTexture((int)n11, (int)n10);
        String string3 = "glBindTexture";
        ShaderUtil.checkGlError(string3);
        int n12 = 9729;
        GLES20.glTexParameteri((int)n11, (int)10241, (int)n12);
        GLES20.glTexParameteri((int)n11, (int)10240, (int)n12);
        n12 = 33071;
        GLES20.glTexParameteri((int)n11, (int)10242, (int)n12);
        GLES20.glTexParameteri((int)n11, (int)10243, (int)n12);
        ShaderUtil.checkGlError("glTexParameteri");
        GLES20.glUseProgram((int)this.program);
        ShaderUtil.checkGlError("glUseProgram");
        int n13 = this.frameUniform;
        n12 = 0;
        GLES20.glUniform1i((int)n13, (int)0);
        ShaderUtil.checkGlError("glUniform1i");
        n13 = this.textureTransformUniform;
        float[] fArray = this.textureTransformMatrix;
        int n14 = 1;
        GLES20.glUniformMatrix4fv((int)n13, (int)n14, (boolean)false, (float[])fArray, (int)0);
        Object object = "glUniformMatrix4fv";
        ShaderUtil.checkGlError((String)object);
        GLES20.glEnableVertexAttribArray((int)n14);
        FloatBuffer floatBuffer = CommonShaders.SQUARE_VERTICES;
        int n15 = 1;
        int n16 = 2;
        int n17 = 5126;
        GLES20.glVertexAttribPointer((int)n15, (int)n16, (int)n17, (boolean)false, (int)0, (Buffer)floatBuffer);
        GLES20.glEnableVertexAttribArray((int)2);
        n13 = (int)(this.flipY ? 1 : 0);
        object = n13 != 0 ? FLIPPED_TEXTURE_VERTICES : TEXTURE_VERTICES;
        GLES20.glVertexAttribPointer((int)2, (int)2, (int)5126, (boolean)false, (int)0, (Buffer)object);
        ShaderUtil.checkGlError("program setup");
        GLES20.glDrawArrays((int)5, (int)0, (int)4);
        ShaderUtil.checkGlError("glDrawArrays");
        GLES20.glBindTexture((int)n11, (int)0);
        ShaderUtil.checkGlError(string3);
        GLES20.glFlush();
    }

    public void setFlipY(boolean bl2) {
        this.flipY = bl2;
    }

    public void setup() {
        int n10;
        HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
        Integer n11 = 1;
        hashMap.put("position", n11);
        n11 = 2;
        hashMap.put("texture_coordinate", n11);
        this.program = n10 = ShaderUtil.createProgram("uniform mat4 texture_transform;\nattribute vec4 position;\nattribute mediump vec4 texture_coordinate;\nvarying mediump vec2 sample_coordinate;\n\nvoid main() {\n  gl_Position = position;\n  sample_coordinate = (texture_transform * texture_coordinate).xy;\n}", "varying mediump vec2 sample_coordinate;\nuniform sampler2D video_frame;\n\nvoid main() {\n  gl_FragColor = texture2D(video_frame, sample_coordinate);\n}", hashMap);
        this.frameUniform = n10 = GLES20.glGetUniformLocation((int)n10, (String)"video_frame");
        this.textureTransformUniform = n10 = GLES20.glGetUniformLocation((int)this.program, (String)"texture_transform");
        ShaderUtil.checkGlError("glGetUniformLocation");
        Matrix.setIdentityM((float[])this.textureTransformMatrix, (int)0);
    }
}

