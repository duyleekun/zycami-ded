/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.opengl.GLES20
 *  android.opengl.GLSurfaceView
 *  android.opengl.GLSurfaceView$Renderer
 *  javax.microedition.khronos.egl.EGLConfig
 *  javax.microedition.khronos.opengles.GL10
 */
package com.google.android.exoplayer2.video;

import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.GlUtil;
import com.google.android.exoplayer2.video.VideoDecoderOutputBuffer;
import com.google.android.exoplayer2.video.VideoDecoderOutputBufferRenderer;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.util.concurrent.atomic.AtomicReference;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class VideoDecoderGLFrameRenderer
implements GLSurfaceView.Renderer,
VideoDecoderOutputBufferRenderer {
    private static final String FRAGMENT_SHADER = "precision mediump float;\nvarying vec2 interp_tc_y;\nvarying vec2 interp_tc_u;\nvarying vec2 interp_tc_v;\nuniform sampler2D y_tex;\nuniform sampler2D u_tex;\nuniform sampler2D v_tex;\nuniform mat3 mColorConversion;\nvoid main() {\n  vec3 yuv;\n  yuv.x = texture2D(y_tex, interp_tc_y).r - 0.0625;\n  yuv.y = texture2D(u_tex, interp_tc_u).r - 0.5;\n  yuv.z = texture2D(v_tex, interp_tc_v).r - 0.5;\n  gl_FragColor = vec4(mColorConversion * yuv, 1.0);\n}\n";
    private static final String[] TEXTURE_UNIFORMS;
    private static final FloatBuffer TEXTURE_VERTICES;
    private static final String VERTEX_SHADER = "varying vec2 interp_tc_y;\nvarying vec2 interp_tc_u;\nvarying vec2 interp_tc_v;\nattribute vec4 in_pos;\nattribute vec2 in_tc_y;\nattribute vec2 in_tc_u;\nattribute vec2 in_tc_v;\nvoid main() {\n  gl_Position = in_pos;\n  interp_tc_y = in_tc_y;\n  interp_tc_u = in_tc_u;\n  interp_tc_v = in_tc_v;\n}\n";
    private static final float[] kColorConversion2020;
    private static final float[] kColorConversion601;
    private static final float[] kColorConversion709;
    private int colorMatrixLocation;
    private final AtomicReference pendingOutputBufferReference;
    private int[] previousStrides;
    private int[] previousWidths;
    private int program;
    private VideoDecoderOutputBuffer renderedOutputBuffer;
    private final GLSurfaceView surfaceView;
    private int[] texLocations;
    private FloatBuffer[] textureCoords;
    private final int[] yuvTextures;

    static {
        float[] fArray;
        float[] fArray2;
        int n10 = 9;
        float[] fArray3 = fArray2 = new float[n10];
        float[] fArray4 = fArray2;
        fArray3[0] = 1.164f;
        fArray4[1] = 1.164f;
        fArray3[2] = 1.164f;
        fArray4[3] = 0.0f;
        fArray3[4] = -0.392f;
        fArray4[5] = 2.017f;
        fArray3[6] = 1.596f;
        fArray4[7] = -0.813f;
        fArray4[8] = 0.0f;
        kColorConversion601 = fArray2;
        float[] fArray5 = fArray2 = new float[n10];
        float[] fArray6 = fArray2;
        fArray5[0] = 1.164f;
        fArray6[1] = 1.164f;
        fArray5[2] = 1.164f;
        fArray6[3] = 0.0f;
        fArray5[4] = -0.213f;
        fArray6[5] = 2.112f;
        fArray5[6] = 1.793f;
        fArray6[7] = -0.533f;
        fArray6[8] = 0.0f;
        kColorConversion709 = fArray2;
        float[] fArray7 = fArray = new float[n10];
        float[] fArray8 = fArray;
        fArray7[0] = 1.168f;
        fArray8[1] = 1.168f;
        fArray7[2] = 1.168f;
        fArray8[3] = 0.0f;
        fArray7[4] = -0.188f;
        fArray8[5] = 2.148f;
        fArray7[6] = 1.683f;
        fArray8[7] = -0.652f;
        fArray8[8] = 0.0f;
        kColorConversion2020 = fArray;
        TEXTURE_UNIFORMS = new String[]{"y_tex", "u_tex", "v_tex"};
        float[] fArray9 = fArray = new float[8];
        float[] fArray10 = fArray;
        fArray9[0] = -1.0f;
        fArray10[1] = 1.0f;
        fArray9[2] = -1.0f;
        fArray10[3] = -1.0f;
        fArray9[4] = 1.0f;
        fArray10[5] = 1.0f;
        fArray9[6] = 1.0f;
        fArray10[7] = -1.0f;
        TEXTURE_VERTICES = GlUtil.createBuffer(fArray);
    }

    public VideoDecoderGLFrameRenderer(GLSurfaceView objectArray) {
        int n10 = 3;
        int[] nArray = new int[n10];
        this.yuvTextures = nArray;
        this.surfaceView = objectArray;
        this.pendingOutputBufferReference = objectArray;
        objectArray = new FloatBuffer[n10];
        this.textureCoords = objectArray;
        objectArray = new int[n10];
        this.texLocations = (int[])objectArray;
        objectArray = new int[n10];
        this.previousWidths = (int[])objectArray;
        objectArray = new int[n10];
        this.previousStrides = (int[])objectArray;
        objectArray = null;
        for (int i10 = 0; i10 < n10; ++i10) {
            int n11;
            nArray = this.previousWidths;
            int[] nArray2 = this.previousStrides;
            nArray2[i10] = n11 = -1;
            nArray[i10] = n11;
        }
    }

    private void setupTextures() {
        int[] nArray = this.yuvTextures;
        int n10 = 3;
        GLES20.glGenTextures((int)n10, (int[])nArray, (int)0);
        for (int i10 = 0; i10 < n10; ++i10) {
            int n11 = this.program;
            String string2 = TEXTURE_UNIFORMS[i10];
            GLES20.glUniform1i((int)GLES20.glGetUniformLocation((int)n11, (String)string2), (int)i10);
            GLES20.glActiveTexture((int)(33984 + i10));
            nArray = this.yuvTextures;
            n11 = nArray[i10];
            int n12 = 3553;
            GLES20.glBindTexture((int)n12, (int)n11);
            float f10 = 9729.0f;
            GLES20.glTexParameterf((int)n12, (int)10241, (float)f10);
            GLES20.glTexParameterf((int)n12, (int)10240, (float)f10);
            f10 = 33071.0f;
            GLES20.glTexParameterf((int)n12, (int)10242, (float)f10);
            n11 = 10243;
            GLES20.glTexParameterf((int)n12, (int)n11, (float)f10);
        }
        GlUtil.checkGlError();
    }

    public void onDrawFrame(GL10 gL10) {
        FloatBuffer floatBuffer;
        float f10;
        Object object;
        float f11;
        Object object2;
        int[] nArray;
        float f12;
        Object object3;
        int n10;
        Object object4;
        int n11;
        VideoDecoderGLFrameRenderer videoDecoderGLFrameRenderer = this;
        Object object5 = this.pendingOutputBufferReference;
        Object object6 = null;
        if ((object5 = (VideoDecoderOutputBuffer)((AtomicReference)object5).getAndSet(null)) == null && (object6 = this.renderedOutputBuffer) == null) {
            return;
        }
        if (object5 != null) {
            object6 = videoDecoderGLFrameRenderer.renderedOutputBuffer;
            if (object6 != null) {
                ((VideoDecoderOutputBuffer)object6).release();
            }
            videoDecoderGLFrameRenderer.renderedOutputBuffer = object5;
        }
        object5 = (VideoDecoderOutputBuffer)Assertions.checkNotNull(videoDecoderGLFrameRenderer.renderedOutputBuffer);
        object6 = kColorConversion709;
        int n12 = ((VideoDecoderOutputBuffer)object5).colorspace;
        int n13 = 3;
        int n14 = 1;
        float f13 = Float.MIN_VALUE;
        if (n12 != n14) {
            if (n12 == n13) {
                object6 = kColorConversion2020;
            }
        } else {
            object6 = kColorConversion601;
        }
        int n15 = videoDecoderGLFrameRenderer.colorMatrixLocation;
        GLES20.glUniformMatrix3fv((int)n15, (int)n14, (boolean)false, (float[])object6, (int)0);
        object6 = (int[])Assertions.checkNotNull(((VideoDecoderOutputBuffer)object5).yuvStrides);
        Object[] objectArray = (ByteBuffer[])Assertions.checkNotNull(((VideoDecoderOutputBuffer)object5).yuvPlanes);
        int n16 = 0;
        Object object7 = null;
        while (true) {
            n11 = 2;
            if (n16 >= n13) break;
            if (n16 == 0) {
                n11 = ((VideoDecoderOutputBuffer)object5).height;
            } else {
                object4 = ((VideoDecoderOutputBuffer)object5).height + n14;
                n11 = object4 / 2;
            }
            n10 = n11;
            GLES20.glActiveTexture((int)(33984 + n16));
            int[] nArray2 = videoDecoderGLFrameRenderer.yuvTextures;
            object4 = nArray2[n16];
            GLES20.glBindTexture((int)3553, (int)object4);
            n11 = 3317;
            GLES20.glPixelStorei((int)n11, (int)n14);
            object4 = 3553;
            object3 = 0;
            f12 = 0.0f;
            nArray = null;
            object2 = 6409;
            f11 = 8.981E-42f;
            object = object6[n16];
            f10 = 0.0f;
            floatBuffer = null;
            int n17 = 6409;
            int n18 = 5121;
            ByteBuffer byteBuffer = objectArray[n16];
            GLES20.glTexImage2D((int)object4, (int)0, (int)object2, (int)object, (int)n10, (int)0, (int)n17, (int)n18, (Buffer)byteBuffer);
            ++n16;
        }
        objectArray = new int[n13];
        Object object8 = ((VideoDecoderOutputBuffer)object5).width;
        objectArray[0] = (ByteBuffer)object8;
        object8 = (objectArray[0] + n14) / n11;
        objectArray[n11] = (ByteBuffer)object8;
        objectArray[n14] = (ByteBuffer)object8;
        object8 = 0;
        object5 = null;
        while (true) {
            n16 = 4;
            object4 = 5;
            if (object8 >= n13) break;
            nArray = videoDecoderGLFrameRenderer.previousWidths;
            object3 = nArray[object8];
            object2 = objectArray[object8];
            if (object3 != object2 || (object3 = (nArray = videoDecoderGLFrameRenderer.previousStrides)[object8]) != (object2 = (Object)object6[object8])) {
                object3 = object6[object8];
                if (object3 != 0) {
                    object3 = n14;
                    f12 = f13;
                } else {
                    object3 = false;
                    nArray = null;
                    f12 = 0.0f;
                }
                Assertions.checkState((boolean)object3);
                f12 = (float)objectArray[object8];
                f11 = (float)object6[object8];
                FloatBuffer[] floatBufferArray = videoDecoderGLFrameRenderer.textureCoords;
                float[] fArray = new float[8];
                fArray[0] = 0.0f;
                fArray[n14] = 0.0f;
                fArray[n11] = 0.0f;
                fArray[n13] = f10 = 1.0f;
                fArray[n16] = f12 /= f11;
                fArray[object4] = 0.0f;
                fArray[6] = f12;
                n16 = 7;
                fArray[n16] = f10;
                object7 = GlUtil.createBuffer(fArray);
                floatBufferArray[object8] = object7;
                object4 = videoDecoderGLFrameRenderer.texLocations[object8];
                object3 = 2;
                f12 = 2.8E-45f;
                object2 = 5126;
                f11 = 7.183E-42f;
                object = false;
                fArray = null;
                n10 = 0;
                floatBuffer = videoDecoderGLFrameRenderer.textureCoords[object8];
                GLES20.glVertexAttribPointer((int)object4, (int)object3, (int)object2, (boolean)false, (int)0, (Buffer)floatBuffer);
                object7 = videoDecoderGLFrameRenderer.previousWidths;
                object4 = objectArray[object8];
                object7[object8] = object4;
                object7 = videoDecoderGLFrameRenderer.previousStrides;
                object4 = object6[object8];
                object7[object8] = object4;
            }
            ++object8;
        }
        GLES20.glClear((int)16384);
        GLES20.glDrawArrays((int)object4, (int)0, (int)n16);
        GlUtil.checkGlError();
    }

    public void onSurfaceChanged(GL10 gL10, int n10, int n11) {
        GLES20.glViewport((int)0, (int)0, (int)n10, (int)n11);
    }

    public void onSurfaceCreated(GL10 object, EGLConfig eGLConfig) {
        int n10;
        this.program = n10 = GlUtil.compileProgram(VERTEX_SHADER, FRAGMENT_SHADER);
        GLES20.glUseProgram((int)n10);
        int n11 = GLES20.glGetAttribLocation((int)this.program, (String)"in_pos");
        GLES20.glEnableVertexAttribArray((int)n11);
        FloatBuffer floatBuffer = TEXTURE_VERTICES;
        GLES20.glVertexAttribPointer((int)n11, (int)2, (int)5126, (boolean)false, (int)0, (Buffer)floatBuffer);
        object = this.texLocations;
        int n12 = GLES20.glGetAttribLocation((int)this.program, (String)"in_tc_y");
        object[0] = (GL10)n12;
        GLES20.glEnableVertexAttribArray((int)this.texLocations[0]);
        object = this.texLocations;
        n12 = GLES20.glGetAttribLocation((int)this.program, (String)"in_tc_u");
        n11 = 1;
        object[n11] = (GL10)n12;
        GLES20.glEnableVertexAttribArray((int)this.texLocations[n11]);
        object = this.texLocations;
        n12 = GLES20.glGetAttribLocation((int)this.program, (String)"in_tc_v");
        n11 = 2;
        object[n11] = (GL10)n12;
        GLES20.glEnableVertexAttribArray((int)this.texLocations[n11]);
        GlUtil.checkGlError();
        this.colorMatrixLocation = n10 = GLES20.glGetUniformLocation((int)this.program, (String)"mColorConversion");
        GlUtil.checkGlError();
        this.setupTextures();
        GlUtil.checkGlError();
    }

    public void setOutputBuffer(VideoDecoderOutputBuffer videoDecoderOutputBuffer) {
        AtomicReference atomicReference = this.pendingOutputBufferReference;
        if ((videoDecoderOutputBuffer = atomicReference.getAndSet(videoDecoderOutputBuffer)) != null) {
            videoDecoderOutputBuffer.release();
        }
        this.surfaceView.requestRender();
    }
}

