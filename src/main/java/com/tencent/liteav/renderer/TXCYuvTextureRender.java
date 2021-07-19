/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.opengl.GLES20
 *  android.opengl.Matrix
 */
package com.tencent.liteav.renderer;

import android.opengl.GLES20;
import android.opengl.Matrix;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.structs.TXSVideoFrame;
import com.tencent.liteav.basic.util.g;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

public class TXCYuvTextureRender {
    private static final int BYTES_PER_FLOAT = 4;
    private static final int INVALID_TEXTURE_ID = 53191;
    private static final int POSITION_COMPONENT_COUNT = 2;
    private static final String TAG = "TXCYuvTextureRender";
    private static final int TEXTURE_COORDINATES_COMPONENT_COUNT = 2;
    private static final String mFragmentShaderCode = "precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D yTexture;\nuniform sampler2D uTexture;\nuniform mat3 convertMatrix;\nuniform vec3 offset;\n\nvoid main()\n{\n    highp vec3 yuvColor;\n    highp vec3 rgbColor;\n\n    // Get the YUV values\n    yuvColor.x = texture2D(yTexture, textureCoordinate).r;\n    yuvColor.y = texture2D(uTexture, vec2(textureCoordinate.x * 0.5, textureCoordinate.y * 0.5)).r;\n    yuvColor.z = texture2D(uTexture, vec2(textureCoordinate.x * 0.5, textureCoordinate.y * 0.5 + 0.5)).r;\n\n    // Do the color transform   \n    yuvColor += offset;\n    rgbColor = convertMatrix * yuvColor; \n\n    gl_FragColor = vec4(rgbColor, 1.0);\n}\n";
    private static final String mVertexShaderCode = "uniform mat4 uMatrix;uniform mat4 uTextureMatrix;attribute vec2 position;attribute vec2 inputTextureCoordinate;varying vec2 textureCoordinate;void main() {vec4 pos  = vec4(position, 0.0, 1.0);gl_Position = uMatrix * pos;textureCoordinate = (uTextureMatrix*vec4(inputTextureCoordinate, 0.0, 0.0)).xy;}";
    public float[] bt601_fullrage_ffmpeg_matrix;
    public float[] bt601_fullrange_ffmpeg_offset;
    public float[] bt601_videorage_ffmpeg_matrix;
    public float[] bt601_videorange_ffmpeg_offset;
    private final int def_InputType_YUVJ420;
    private int mConvertMatrixUniform;
    private int mConvertOffsetUniform;
    private int mFrameBufferID;
    private int mFrameBufferTextureID;
    private int mHeight;
    private short[] mIndices;
    private ShortBuffer mIndicesBuffer;
    private float[] mMVPMatrix;
    private boolean mNeedReLoadFrameBuffer;
    private int mPositionHandle;
    private int mProgram;
    private int mRawDataFrameType;
    private FloatBuffer mTextureBuffer;
    private int mTextureCoordinatesHandle;
    private int[] mTextureIds;
    private float[] mTextureMatrix;
    private int mTextureMatrixHandle;
    private int mTextureUnitHandle0;
    private int mTextureUnitHandle1;
    private FloatBuffer mVertexBuffer;
    private int mVertexMatrixHandle;
    private float[] mVerticesCoordinates;
    private int mVideoHeight;
    private int mVideoWidth;
    private int mWidth;
    private float[] mbt601_fullRange_matrix3;
    private float[] mbt601_offset_matrix;
    private float[] mbt601_videoRange_matrix3;
    private float[] mbt709_videoRange_matrix3;

    static {
        g.f();
    }

    public TXCYuvTextureRender() {
        Object object;
        float[] fArray;
        int n10;
        int n11 = 16;
        float[] fArray2 = new float[n11];
        this.mMVPMatrix = fArray2;
        Object object2 = new float[n11];
        this.mTextureMatrix = object2;
        this.mConvertMatrixUniform = n11 = -1;
        this.mConvertOffsetUniform = n11;
        this.mNeedReLoadFrameBuffer = false;
        this.mFrameBufferTextureID = n10 = -12345;
        this.mFrameBufferID = n10;
        this.mVideoWidth = 0;
        this.mVideoHeight = 0;
        this.def_InputType_YUVJ420 = n10 = 4;
        this.mRawDataFrameType = n11;
        n11 = 9;
        float[] fArray3 = fArray = new float[n11];
        float[] fArray4 = fArray;
        fArray3[0] = 1.0f;
        fArray4[1] = 1.0f;
        fArray3[2] = 1.0f;
        fArray4[3] = 0.0f;
        fArray3[4] = -0.343f;
        fArray4[5] = 1.765f;
        fArray3[6] = 1.4f;
        fArray4[7] = -0.711f;
        fArray4[8] = 0.0f;
        this.mbt601_fullRange_matrix3 = fArray;
        float[] fArray5 = fArray = new float[n11];
        float[] fArray6 = fArray;
        fArray5[0] = 1.164f;
        fArray6[1] = 1.164f;
        fArray5[2] = 1.164f;
        fArray6[3] = 0.0f;
        fArray5[4] = -0.392f;
        fArray6[5] = 2.017f;
        fArray5[6] = 1.596f;
        fArray6[7] = -0.813f;
        fArray6[8] = 0.0f;
        this.mbt601_videoRange_matrix3 = fArray;
        int n12 = 3;
        float[] fArray7 = object = new float[n12];
        object[0] = 0.0f;
        fArray7[1] = -0.5f;
        fArray7[2] = -0.5f;
        this.mbt601_offset_matrix = object;
        float[] fArray8 = object = new float[n11];
        float[] fArray9 = object;
        fArray8[0] = 1.164f;
        fArray9[1] = 1.164f;
        fArray8[2] = 1.164f;
        fArray9[3] = 0.0f;
        fArray8[4] = -0.213f;
        fArray9[5] = 2.112f;
        fArray8[6] = 1.793f;
        fArray9[7] = -0.533f;
        fArray9[8] = 0.0f;
        this.mbt709_videoRange_matrix3 = object;
        float[] fArray10 = object = new float[n12];
        object[0] = -0.0627451f;
        fArray10[1] = -0.5019608f;
        fArray10[2] = -0.5019608f;
        this.bt601_videorange_ffmpeg_offset = object;
        float[] fArray11 = object = new float[n11];
        float[] fArray12 = object;
        fArray11[0] = 1.1644f;
        fArray12[1] = 1.1644f;
        fArray11[2] = 1.1644f;
        fArray12[3] = 0.0f;
        fArray11[4] = -0.3918f;
        fArray12[5] = 2.0172f;
        fArray11[6] = 1.596f;
        fArray12[7] = -0.813f;
        fArray12[8] = 0.0f;
        this.bt601_videorage_ffmpeg_matrix = object;
        float[] fArray13 = fArray = new float[n12];
        fArray[0] = 0.0f;
        fArray13[1] = -0.5019608f;
        fArray13[2] = -0.5019608f;
        this.bt601_fullrange_ffmpeg_offset = fArray;
        object2 = new float[n11];
        float[] fArray14 = object2;
        float[] fArray15 = object2;
        fArray14[0] = 1.0f;
        fArray15[1] = 1.0f;
        fArray14[2] = 1.0f;
        fArray15[3] = 0.0f;
        fArray14[4] = -0.3441f;
        fArray15[5] = 1.772f;
        fArray14[6] = 1.402f;
        fArray15[7] = -0.7141f;
        fArray15[8] = 0.0f;
        this.bt601_fullrage_ffmpeg_matrix = object2;
        n11 = 8;
        float[] fArray16 = fArray = new float[n11];
        float[] fArray17 = fArray;
        fArray16[0] = 0.0f;
        fArray17[1] = 1.0f;
        fArray16[2] = 1.0f;
        fArray17[3] = 1.0f;
        fArray16[4] = 0.0f;
        fArray17[5] = 0.0f;
        fArray16[6] = 1.0f;
        fArray17[7] = 0.0f;
        Object[] objectArray = object = (Object)new short[6];
        Object[] objectArray2 = object;
        objectArray[0] = 0.0f;
        objectArray2[1] = 1.0f;
        objectArray[2] = 2;
        objectArray2[3] = 1.0f;
        objectArray[4] = 3;
        objectArray2[5] = 2;
        this.mIndices = (short[])object;
        object2 = new float[n11];
        float[] fArray18 = object2;
        float[] fArray19 = object2;
        fArray18[0] = -1.0f;
        fArray19[1] = -1.0f;
        fArray18[2] = 1.0f;
        fArray19[3] = -1.0f;
        fArray18[4] = -1.0f;
        fArray19[5] = 1.0f;
        fArray18[6] = 1.0f;
        fArray19[7] = 1.0f;
        this.mVerticesCoordinates = object2;
        object2 = ByteBuffer.allocateDirect(32);
        object = ByteOrder.nativeOrder();
        this.mTextureBuffer = object2 = ((ByteBuffer)object2).order((ByteOrder)object).asFloatBuffer();
        ((FloatBuffer)object2).put(fArray);
        this.mTextureBuffer.position(0);
        object2 = ByteBuffer.allocateDirect(this.mVerticesCoordinates.length * n10);
        Object object3 = ByteOrder.nativeOrder();
        this.mVertexBuffer = object2 = ((ByteBuffer)object2).order((ByteOrder)object3).asFloatBuffer();
        object3 = this.mVerticesCoordinates;
        ((FloatBuffer)object2).put((float[])object3);
        this.mVertexBuffer.position(0);
        object2 = ByteBuffer.allocateDirect(this.mIndices.length * 2);
        object3 = ByteOrder.nativeOrder();
        this.mIndicesBuffer = object2 = ((ByteBuffer)object2).order((ByteOrder)object3).asShortBuffer();
        object3 = this.mIndices;
        ((ShortBuffer)object2).put((short[])object3);
        this.mIndicesBuffer.position(0);
    }

    private void destroyFrameBuffer() {
        int[] nArray;
        int n10 = this.mFrameBufferID;
        int n11 = 1;
        int n12 = -12345;
        if (n10 != n12) {
            nArray = new int[n11];
            nArray[0] = n10;
            GLES20.glDeleteFramebuffers((int)n11, (int[])nArray, (int)0);
            this.mFrameBufferID = n12;
        }
        if ((n10 = this.mFrameBufferTextureID) != n12) {
            nArray = new int[n11];
            nArray[0] = n10;
            GLES20.glDeleteTextures((int)n11, (int[])nArray, (int)0);
            this.mFrameBufferTextureID = n12;
        }
    }

    public static native void nativeLoadTexture(ByteBuffer var0, int var1, int var2, int[] var3);

    private void reloadFrameBuffer() {
        int n10 = this.mNeedReLoadFrameBuffer;
        if (n10 == 0) {
            return;
        }
        String string2 = TAG;
        CharSequence charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("reloadFrameBuffer. size = ");
        int n11 = this.mWidth;
        ((StringBuilder)charSequence).append(n11);
        ((StringBuilder)charSequence).append("*");
        n11 = this.mHeight;
        ((StringBuilder)charSequence).append(n11);
        charSequence = ((StringBuilder)charSequence).toString();
        TXCLog.i(string2, (String)charSequence);
        this.destroyFrameBuffer();
        int n12 = 1;
        int[] nArray = new int[n12];
        int[] nArray2 = new int[n12];
        GLES20.glGenTextures((int)n12, (int[])nArray, (int)0);
        GLES20.glGenFramebuffers((int)n12, (int[])nArray2, (int)0);
        this.mFrameBufferTextureID = n12 = nArray[0];
        this.mFrameBufferID = n12 = nArray2[0];
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("frameBuffer id = ");
        n11 = this.mFrameBufferID;
        ((StringBuilder)charSequence).append(n11);
        ((StringBuilder)charSequence).append(", texture id = ");
        n11 = this.mFrameBufferTextureID;
        ((StringBuilder)charSequence).append(n11);
        charSequence = ((StringBuilder)charSequence).toString();
        TXCLog.d(string2, (String)charSequence);
        n10 = this.mFrameBufferTextureID;
        n12 = 3553;
        GLES20.glBindTexture((int)n12, (int)n10);
        int n13 = this.mWidth;
        int n14 = this.mHeight;
        GLES20.glTexImage2D((int)3553, (int)0, (int)6408, (int)n13, (int)n14, (int)0, (int)6408, (int)5121, null);
        float f10 = 9729.0f;
        GLES20.glTexParameterf((int)n12, (int)10241, (float)f10);
        GLES20.glTexParameterf((int)n12, (int)10240, (float)f10);
        n11 = 33071;
        GLES20.glTexParameteri((int)n12, (int)10242, (int)n11);
        GLES20.glTexParameteri((int)n12, (int)10243, (int)n11);
        n10 = this.mFrameBufferID;
        n11 = 36160;
        GLES20.glBindFramebuffer((int)n11, (int)n10);
        int n15 = this.mFrameBufferTextureID;
        GLES20.glFramebufferTexture2D((int)n11, (int)36064, (int)n12, (int)n15, (int)0);
        GLES20.glBindTexture((int)n12, (int)0);
        GLES20.glBindFramebuffer((int)n11, (int)0);
        this.mNeedReLoadFrameBuffer = false;
    }

    public int checkError() {
        int n10 = GLES20.glGetError();
        if (n10 == 0) {
            return n10;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("gl error=");
        stringBuilder.append(n10);
        String string2 = stringBuilder.toString();
        IllegalStateException illegalStateException = new IllegalStateException(string2);
        throw illegalStateException;
    }

    public void createTexture() {
        int n10;
        int n11 = GLES20.glCreateShader((int)35633);
        this.checkError();
        GLES20.glShaderSource((int)n11, (String)"uniform mat4 uMatrix;uniform mat4 uTextureMatrix;attribute vec2 position;attribute vec2 inputTextureCoordinate;varying vec2 textureCoordinate;void main() {vec4 pos  = vec4(position, 0.0, 1.0);gl_Position = uMatrix * pos;textureCoordinate = (uTextureMatrix*vec4(inputTextureCoordinate, 0.0, 0.0)).xy;}");
        this.checkError();
        GLES20.glCompileShader((int)n11);
        this.checkError();
        int n12 = GLES20.glCreateShader((int)35632);
        this.checkError();
        GLES20.glShaderSource((int)n12, (String)"precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D yTexture;\nuniform sampler2D uTexture;\nuniform mat3 convertMatrix;\nuniform vec3 offset;\n\nvoid main()\n{\n    highp vec3 yuvColor;\n    highp vec3 rgbColor;\n\n    // Get the YUV values\n    yuvColor.x = texture2D(yTexture, textureCoordinate).r;\n    yuvColor.y = texture2D(uTexture, vec2(textureCoordinate.x * 0.5, textureCoordinate.y * 0.5)).r;\n    yuvColor.z = texture2D(uTexture, vec2(textureCoordinate.x * 0.5, textureCoordinate.y * 0.5 + 0.5)).r;\n\n    // Do the color transform   \n    yuvColor += offset;\n    rgbColor = convertMatrix * yuvColor; \n\n    gl_FragColor = vec4(rgbColor, 1.0);\n}\n");
        this.checkError();
        GLES20.glCompileShader((int)n12);
        this.mProgram = n10 = GLES20.glCreateProgram();
        this.checkError();
        GLES20.glAttachShader((int)this.mProgram, (int)n11);
        this.checkError();
        GLES20.glAttachShader((int)this.mProgram, (int)n12);
        this.checkError();
        GLES20.glLinkProgram((int)this.mProgram);
        this.checkError();
        GLES20.glDeleteShader((int)n11);
        GLES20.glDeleteShader((int)n12);
        this.mVertexMatrixHandle = n11 = GLES20.glGetUniformLocation((int)this.mProgram, (String)"uMatrix");
        this.checkError();
        this.mTextureMatrixHandle = n11 = GLES20.glGetUniformLocation((int)this.mProgram, (String)"uTextureMatrix");
        this.checkError();
        this.mPositionHandle = n11 = GLES20.glGetAttribLocation((int)this.mProgram, (String)"position");
        this.checkError();
        this.mTextureCoordinatesHandle = n11 = GLES20.glGetAttribLocation((int)this.mProgram, (String)"inputTextureCoordinate");
        this.checkError();
        this.mTextureUnitHandle0 = n11 = GLES20.glGetUniformLocation((int)this.mProgram, (String)"yTexture");
        this.checkError();
        this.mTextureUnitHandle1 = n11 = GLES20.glGetUniformLocation((int)this.mProgram, (String)"uTexture");
        this.checkError();
        this.mConvertOffsetUniform = n11 = GLES20.glGetUniformLocation((int)this.mProgram, (String)"offset");
        Object object = FloatBuffer.wrap(this.bt601_fullrange_ffmpeg_offset);
        n10 = 1;
        GLES20.glUniform3fv((int)n11, (int)n10, (FloatBuffer)object);
        this.mConvertMatrixUniform = n11 = GLES20.glGetUniformLocation((int)this.mProgram, (String)"convertMatrix");
        object = this.bt601_fullrage_ffmpeg_matrix;
        GLES20.glUniformMatrix3fv((int)n11, (int)n10, (boolean)false, (float[])object, (int)0);
        n11 = 2;
        object = new int[n11];
        this.mTextureIds = (int[])object;
        GLES20.glGenTextures((int)n11, (int[])object, (int)0);
    }

    public void drawFrame(TXSVideoFrame tXSVideoFrame) {
        GLES20.glClearColor((float)0.0f, (float)0.0f, (float)0.0f, (float)1.0f);
        GLES20.glClear((int)16640);
        Object object = this.mMVPMatrix;
        Object object2 = null;
        Matrix.setIdentityM((float[])object, (int)0);
        Matrix.setIdentityM((float[])this.mTextureMatrix, (int)0);
        GLES20.glUseProgram((int)this.mProgram);
        this.checkError();
        GLES20.glEnableVertexAttribArray((int)this.mPositionHandle);
        this.checkError();
        this.mVertexBuffer.position(0);
        int n10 = this.mPositionHandle;
        FloatBuffer floatBuffer = this.mVertexBuffer;
        int n11 = 2;
        int n12 = 5126;
        int n13 = 0;
        String string2 = null;
        int n14 = 8;
        GLES20.glVertexAttribPointer((int)n10, (int)n11, (int)n12, (boolean)false, (int)n14, (Buffer)floatBuffer);
        this.checkError();
        GLES20.glEnableVertexAttribArray((int)this.mTextureCoordinatesHandle);
        this.checkError();
        object = this.mTextureBuffer;
        ((FloatBuffer)object).position(0);
        n10 = this.mTextureCoordinatesHandle;
        floatBuffer = this.mTextureBuffer;
        GLES20.glVertexAttribPointer((int)n10, (int)n11, (int)n12, (boolean)false, (int)n14, (Buffer)floatBuffer);
        this.checkError();
        int n15 = this.mVertexMatrixHandle;
        Object object3 = this.mMVPMatrix;
        n11 = 1;
        GLES20.glUniformMatrix4fv((int)n15, (int)n11, (boolean)false, (float[])object3, (int)0);
        this.checkError();
        n15 = this.mTextureMatrixHandle;
        object3 = this.mTextureMatrix;
        GLES20.glUniformMatrix4fv((int)n15, (int)n11, (boolean)false, (float[])object3, (int)0);
        this.checkError();
        n15 = tXSVideoFrame.frameType;
        object3 = " frame type ";
        n12 = 4;
        if (n12 == n15) {
            n13 = this.mConvertOffsetUniform;
            Object object4 = FloatBuffer.wrap(this.bt601_fullrange_ffmpeg_offset);
            GLES20.glUniform3fv((int)n13, (int)n11, (FloatBuffer)object4);
            n13 = this.mConvertMatrixUniform;
            object4 = this.bt601_fullrage_ffmpeg_matrix;
            GLES20.glUniformMatrix3fv((int)n13, (int)n11, (boolean)false, (float[])object4, (int)0);
            n13 = this.mRawDataFrameType;
            if (n15 != n13) {
                this.mRawDataFrameType = n15;
                string2 = TAG;
                object4 = new StringBuilder();
                ((StringBuilder)object4).append((String)object3);
                ((StringBuilder)object4).append(n15);
                ((StringBuilder)object4).append(" matrix_test fullRange");
                object = ((StringBuilder)object4).toString();
                TXCLog.i(string2, (String)object);
            }
        } else {
            n13 = this.mConvertOffsetUniform;
            Object object5 = FloatBuffer.wrap(this.bt601_videorange_ffmpeg_offset);
            GLES20.glUniform3fv((int)n13, (int)n11, (FloatBuffer)object5);
            n13 = this.mConvertMatrixUniform;
            object5 = this.bt601_videorage_ffmpeg_matrix;
            GLES20.glUniformMatrix3fv((int)n13, (int)n11, (boolean)false, (float[])object5, (int)0);
            n13 = this.mRawDataFrameType;
            if (n15 != n13) {
                this.mRawDataFrameType = n15;
                string2 = TAG;
                object5 = new StringBuilder();
                ((StringBuilder)object5).append((String)object3);
                ((StringBuilder)object5).append(n15);
                ((StringBuilder)object5).append(" matrix_test videoRange");
                object = ((StringBuilder)object5).toString();
                TXCLog.i(string2, (String)object);
            }
        }
        GLES20.glUniform1i((int)this.mTextureUnitHandle0, (int)0);
        this.checkError();
        n15 = this.mTextureUnitHandle1;
        GLES20.glUniform1i((int)n15, (int)n11);
        this.checkError();
        object = tXSVideoFrame.buffer;
        if (object != null && (object2 = this.mTextureIds) != null) {
            n10 = tXSVideoFrame.width;
            n11 = tXSVideoFrame.height;
            TXCYuvTextureRender.nativeLoadTexture((ByteBuffer)object, n10, n11, object2);
        }
        tXSVideoFrame.release();
        int n16 = this.mIndices.length;
        object2 = this.mIndicesBuffer;
        GLES20.glDrawElements((int)n12, (int)n16, (int)5123, (Buffer)object2);
        GLES20.glDisableVertexAttribArray((int)this.mPositionHandle);
        GLES20.glDisableVertexAttribArray((int)this.mTextureCoordinatesHandle);
    }

    public int drawToTexture(TXSVideoFrame tXSVideoFrame) {
        this.reloadFrameBuffer();
        int n10 = this.mFrameBufferID;
        int n11 = -12345;
        if (n10 == n11) {
            TXCLog.w(TAG, "invalid frame buffer id");
            return n11;
        }
        n11 = 36160;
        GLES20.glBindFramebuffer((int)n11, (int)n10);
        n10 = this.mWidth;
        int n12 = this.mHeight;
        GLES20.glViewport((int)0, (int)0, (int)n10, (int)n12);
        this.drawFrame(tXSVideoFrame);
        GLES20.glBindFramebuffer((int)n11, (int)0);
        return this.mFrameBufferTextureID;
    }

    public void flipVertical(boolean bl2) {
        float[] fArray;
        int n10 = 8;
        if (bl2) {
            float[] fArray2 = fArray = new float[n10];
            float[] fArray3 = fArray;
            fArray2[0] = 0.0f;
            fArray3[1] = 1.0f;
            fArray2[2] = 1.0f;
            fArray3[3] = 1.0f;
            fArray2[4] = 0.0f;
            fArray3[5] = 0.0f;
            fArray2[6] = 1.0f;
            fArray3[7] = 0.0f;
        } else {
            float[] fArray4 = fArray = new float[n10];
            float[] fArray5 = fArray;
            fArray4[0] = 0.0f;
            fArray5[1] = 0.0f;
            fArray4[2] = 1.0f;
            fArray5[3] = 0.0f;
            fArray4[4] = 0.0f;
            fArray5[5] = 1.0f;
            fArray4[6] = 1.0f;
            fArray5[7] = 1.0f;
        }
        Buffer buffer = ByteBuffer.allocateDirect(fArray.length * 4);
        ByteOrder byteOrder = ByteOrder.nativeOrder();
        buffer = ((ByteBuffer)buffer).order(byteOrder).asFloatBuffer();
        this.mTextureBuffer = buffer;
        ((FloatBuffer)buffer).put(fArray);
        this.mTextureBuffer.position(0);
    }

    public void onSurfaceDestroy() {
        int[] nArray = this.mTextureIds;
        if (nArray != null) {
            int n10 = 2;
            GLES20.glDeleteTextures((int)n10, (int[])nArray, (int)0);
            nArray = null;
            this.mTextureIds = null;
        }
        this.destroyFrameBuffer();
        GLES20.glDeleteProgram((int)this.mProgram);
    }

    public void setHasFrameBuffer(int n10, int n11) {
        int n12 = this.mWidth;
        if (n12 == n10 && (n12 = this.mHeight) == n11) {
            return;
        }
        this.mWidth = n10;
        this.mHeight = n11;
        this.mNeedReLoadFrameBuffer = true;
    }

    public void setVideoSize(int n10, int n11) {
        this.mVideoWidth = n10;
        this.mVideoHeight = n11;
    }
}

