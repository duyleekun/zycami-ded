/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.RectF
 *  android.graphics.SurfaceTexture
 *  android.graphics.SurfaceTexture$OnFrameAvailableListener
 *  android.media.MediaCodec
 *  android.media.MediaCodec$BufferInfo
 *  android.media.MediaCodecInfo
 *  android.opengl.EGL14
 *  android.opengl.EGLConfig
 *  android.opengl.EGLContext
 *  android.opengl.EGLDisplay
 *  android.opengl.EGLExt
 *  android.opengl.EGLSurface
 *  android.opengl.GLES20
 *  android.opengl.Matrix
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.Looper
 *  android.os.Message
 *  android.util.Log
 *  android.view.Surface
 *  javax.microedition.khronos.egl.EGL10
 *  javax.microedition.khronos.egl.EGLConfig
 *  javax.microedition.khronos.egl.EGLContext
 *  javax.microedition.khronos.egl.EGLDisplay
 *  javax.microedition.khronos.egl.EGLSurface
 */
package com.meicam.nvconvertorlib;

import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.opengl.EGL14;
import android.opengl.EGLDisplay;
import android.opengl.EGLExt;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.Surface;
import com.meicam.nvconvertorlib.Logger;
import com.meicam.nvconvertorlib.NvAndroidSurfaceFileWriter;
import com.meicam.nvconvertorlib.NvAndroidSurfaceFileWriterVideoWorker$1;
import com.meicam.nvconvertorlib.NvAndroidSurfaceFileWriterVideoWorker$2;
import com.meicam.nvconvertorlib.NvAndroidSurfaceFileWriterVideoWorker$NvCacheSampleBuffer;
import com.meicam.nvconvertorlib.NvAndroidSurfaceFileWriterVideoWorker$ReverseInfo;
import com.meicam.nvconvertorlib.NvAndroidSurfaceVideoFileReader;
import com.meicam.nvconvertorlib.NvConvertorUtils;
import com.meicam.nvconvertorlib.NvMediaEncodecCallback;
import com.meicam.nvconvertorlib.NvVideoFrame;
import com.meicam.nvconvertorlib.NvVideoResolution;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.reflect.Method;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.concurrent.Semaphore;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLSurface;

public class NvAndroidSurfaceFileWriterVideoWorker
implements SurfaceTexture.OnFrameAvailableListener {
    private static final int EGL_CONTEXT_CLIENT_VERSION = 12440;
    private static final int EGL_OPENGL_ES2_BIT = 4;
    public static final int EGL_RECORDABLE_ANDROID = 12610;
    public static final int FLOAT_SIZE_BTYES = 4;
    public static final String FRAGMENT_SHADER = "#extension GL_OES_EGL_image_external : require\nvarying highp vec2 texCoord;\nuniform samplerExternalOES sampler;\nuniform mediump float LuminosityAmount;\nvoid main()\n{\n    lowp vec4 renderTex = texture2D(sampler, texCoord);\n    lowp float luminosity = 0.299 * renderTex.r + 0.587 * renderTex.g + 0.114 * renderTex.b;\n    gl_FragColor.r = renderTex.r + LuminosityAmount * (luminosity - renderTex.r);\n    gl_FragColor.g = renderTex.g + LuminosityAmount * (luminosity - renderTex.g);\n    gl_FragColor.b = renderTex.b + LuminosityAmount * (luminosity - renderTex.b);\n    gl_FragColor.a = renderTex.a;\n}\n";
    public static final String FRAGMENT_SHADER_CONVERTTOYUY2 = "varying highp vec2 texCoord;\nuniform sampler2D sampler;\nuniform mediump vec4 coefY;\nuniform mediump vec4 coefU;\nuniform mediump vec4 coefV;\nuniform highp float sPerHalfTexel;\nvoid main()\n{\n    highp vec2 texelOffset = vec2(sPerHalfTexel, 0);\n    lowp vec4 leftRGBA = texture2D(sampler, texCoord - texelOffset);\n    lowp vec4 rightRGBA = texture2D(sampler, texCoord + texelOffset);\n    lowp vec4 left = vec4(leftRGBA.rgb, 1);\n    lowp float y0 = dot(left, coefY);\n    lowp float y1 = dot(vec4(rightRGBA.rgb, 1), coefY);\n    lowp float u = dot(left, coefU);\n    lowp float v = dot(left, coefV);\n    gl_FragColor = vec4(y0, u, y1, v);\n}\n";
    public static final String FRAGMENT_SHADER_DRAW = "varying highp vec2 texCoord;\nuniform sampler2D sampler;\nvoid main()\n{\n    gl_FragColor = texture2D(sampler, texCoord);\n}\n";
    public static final int NV_CLEARUP_EVENT_TYPE = 0;
    public static final int NV_M_SEGMET_COMPLETE = 1;
    public static final int NV_NOERROR = 0;
    public static final float NV_YUY2_B_U_601 = 0.43922f;
    public static final float NV_YUY2_B_U_709 = 0.43922f;
    public static final float NV_YUY2_B_V_601 = 0.07143f;
    public static final float NV_YUY2_B_V_709 = 0.04027f;
    public static final float NV_YUY2_B_Y_601 = 0.09791f;
    public static final float NV_YUY2_B_Y_709 = 0.06201f;
    public static final float NV_YUY2_G_U_601 = 0.29099f;
    public static final float NV_YUY2_G_U_709 = 0.33857f;
    public static final float NV_YUY2_G_V_601 = 0.36779f;
    public static final float NV_YUY2_G_V_709 = 0.39894f;
    public static final float NV_YUY2_G_Y_601 = 0.50413f;
    public static final float NV_YUY2_G_Y_709 = 0.61423f;
    public static final float NV_YUY2_R_U_601 = 0.14822f;
    public static final float NV_YUY2_R_U_709 = 0.10064f;
    public static final float NV_YUY2_R_V_601 = 0.43922f;
    public static final float NV_YUY2_R_V_709 = 0.43922f;
    public static final float NV_YUY2_R_Y_601 = 0.25679f;
    public static final float NV_YUY2_R_Y_709 = 0.18259f;
    public static final String TAG = "VideoWorker";
    public static final String VERTEX_SHADER = "attribute highp vec2 posAttr;\nattribute highp vec2 texCoordAttr;\nuniform highp mat4 mvpMatrix;\nuniform highp mat4 texMatrix;\nvarying highp vec2 texCoord;\nvoid main()\n{\n    texCoord = (texMatrix * vec4(texCoordAttr, 0, 1)).xy;\n    gl_Position = mvpMatrix * vec4(posAttr, 0, 1);\n}\n";
    public static final String VERTEX_SHADER_DRAW = "attribute highp vec2 posAttr;\nattribute highp vec2 texCoordAttr;\nvarying highp vec2 texCoord;\nvoid main()\n{\n    texCoord = texCoordAttr;\n    gl_Position = vec4(posAttr, 0, 1);\n}\n";
    public static final int VERTICES_DATA_STRIDE_BYTES = 16;
    public static final String gFragmentShader_YUY2_Uploader = "varying highp vec2 texCoord;\nuniform sampler2D sampler;\nuniform lowp float yOffset;\nuniform mediump float coef_Y_RGB;\nuniform mediump float coef_V_R;\nuniform mediump float coef_U_G;\nuniform mediump float coef_V_G;\nuniform mediump float coef_U_B;\nvoid main()\n{\n    lowp vec4 yuy2 = texture2D(sampler, texCoord) - vec4(yOffset, 128.0 / 255.0, yOffset, 128.0 / 255.0);\n    lowp float u = yuy2.g;\n    lowp float v = yuy2.w;\n    lowp float y = (mod(gl_FragCoord.x, 2.0) <= 1.0) ? yuy2.r : yuy2.b;\n    lowp float yRGB = coef_Y_RGB * y;\n    lowp float r = yRGB + v * coef_V_R;\n    lowp float g = yRGB - u * coef_U_G - v * coef_V_G;\n    lowp float b = yRGB + u * coef_U_B;\n    gl_FragColor = vec4(r, g, b, 1);\n}\n";
    public static Method m_setOnFrameAvailableListener2;
    public int a;
    public int b;
    private boolean bProcessSegment;
    public int[] downloadTexture;
    public boolean firstReverseReplayback;
    public boolean hasInitSurfaceTexture;
    public boolean hasInitVideoEncoder;
    public boolean initUploadTextId;
    public float[] mMVPMatrix;
    public float[] mSTMatrix;
    private long mTempStreamTimeForJudgeEndOfConvert;
    private int m_MaxProcessCount;
    public int m_attrLoc_pos;
    public int m_attrLoc_texCoord;
    public boolean m_bHasInstalledLicense;
    public boolean m_bIsReverseConvert;
    public EGLContext m_context;
    public int m_convertToYUY2Program;
    public int m_convertToYUY2Program_attrLoc_pos;
    public int m_convertToYUY2Program_attrLoc_texCoord;
    public boolean m_convertToYUY2Program_luma601_loaded;
    public int m_convertToYUY2Program_uniformLoc_coefU;
    public int m_convertToYUY2Program_uniformLoc_coefV;
    public int m_convertToYUY2Program_uniformLoc_coefY;
    public int m_convertToYUY2Program_uniformLoc_sPerHalfTexel;
    public boolean m_deposeOperatingRate;
    public boolean m_dontUseEncodecCallBack;
    public int m_drawProgram;
    public int m_draw_attrLoc_pos;
    public int m_draw_attrLoc_texCoord;
    public android.opengl.EGLConfig[] m_eglConfigs;
    public android.opengl.EGLContext m_eglContext;
    public EGLDisplay m_eglDisplay;
    public android.opengl.EGLSurface m_eglSurface;
    public boolean m_endOfInputStreamSignaled;
    public Handler m_eventHandler;
    public int[] m_fbo;
    public NvAndroidSurfaceFileWriter m_fileWriter;
    public boolean m_frameAvailable;
    public Object m_frameSyncObject;
    public Handler m_handler;
    public ByteBuffer[] m_inputBuffers;
    public NvMediaEncodecCallback m_jVideoEncoderCallback;
    private long m_n64PlayBackStartPosForReverse;
    private long m_n64TimeStampStart;
    private long m_n64VideoProcessPos;
    public int m_program;
    public int m_requestSyncVideoFrameInterval;
    public EGLSurface m_surface;
    public SurfaceTexture m_surfaceTexture;
    public Semaphore m_surfaceTextureCreationSemaphore;
    public int[] m_textureId;
    private RandomAccessFile m_tmpAccessFile;
    private File m_tmpFile;
    private ArrayList m_tmpVideoFrame;
    public int m_uniformLoc_mvpMatrix;
    public int m_uniformLoc_texMatrix;
    public int m_uniformLuminosityAmount;
    public FloatBuffer m_vertices;
    public float[] m_verticesData;
    public FloatBuffer m_verticesDraw;
    public final float[] m_verticesDrawData;
    public FloatBuffer m_verticesUpload;
    public final float[] m_verticesUploadData;
    public FloatBuffer m_verticesYUY2;
    public float[] m_verticesYUY2Data;
    public MediaCodec.BufferInfo m_videoBufferInfo;
    public Object m_videoEncodeEosSyncEvent;
    public MediaCodec m_videoEncoder;
    public boolean m_videoEncoderFormatChanged;
    public int m_videoEncoderInputColorFormat;
    public int m_videoEncoderInputPixelFormat;
    public Surface m_videoEncoderInputSurface;
    public boolean m_videoEncoderStarted;
    public ByteBuffer m_videoFrameDirectByteBuffer;
    private ArrayList m_videoFramePool;
    private Object m_videoFramePoolObject;
    public int m_videoFrameSent;
    public int m_yuy2UploaderProgram;
    public int m_yuy2Uploader_attrLoc_pos;
    public int m_yuy2Uploader_attrLoc_texCoord;
    public int m_yuy2Uploader_uniformLoc_U_B;
    public int m_yuy2Uploader_uniformLoc_U_G;
    public int m_yuy2Uploader_uniformLoc_V_G;
    public int m_yuy2Uploader_uniformLoc_V_R;
    public int m_yuy2Uploader_uniformLoc_Y_RGB;
    public int m_yuy2Uploader_uniformLoc_yOffset;
    public boolean sawTheEnd;
    public int textureIdPoolMaxCount;
    private long tmpSamplePts;
    public int[] uploadTexture;

    static {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        if (n10 >= n11) {
            Object object = SurfaceTexture.class;
            String string2 = "setOnFrameAvailableListener";
            int n12 = 2;
            Class[] classArray = new Class[n12];
            int n13 = 0;
            Class<SurfaceTexture.OnFrameAvailableListener> clazz = SurfaceTexture.OnFrameAvailableListener.class;
            classArray[0] = clazz;
            n13 = 1;
            clazz = Handler.class;
            classArray[n13] = clazz;
            object = ((Class)object).getDeclaredMethod(string2, classArray);
            m_setOnFrameAvailableListener2 = object;
            object = TAG;
            string2 = "New SurfaceTexture.setOnFrameAvailableListener() method is available!";
            try {
                Log.d((String)object, (String)string2);
            }
            catch (Exception exception) {
                n10 = 0;
                object = null;
                m_setOnFrameAvailableListener2 = null;
            }
        }
    }

    public NvAndroidSurfaceFileWriterVideoWorker(NvAndroidSurfaceFileWriter nvAndroidSurfaceFileWriter, Handler handler) {
        float[] fArray;
        long l10;
        long l11;
        Object object;
        int n10;
        Object object2;
        int n11 = 16;
        float[] fArray2 = object2 = new float[n11];
        float[] fArray3 = object2;
        fArray2[0] = -1.0f;
        fArray3[1] = 1.0f;
        fArray2[2] = 0.0f;
        fArray3[3] = 1.0f;
        fArray2[4] = -1.0f;
        fArray3[5] = -1.0f;
        fArray2[6] = 0.0f;
        fArray3[7] = 0.0f;
        fArray2[8] = 1.0f;
        fArray3[9] = 1.0f;
        fArray2[10] = 1.0f;
        fArray3[11] = 1.0f;
        fArray2[12] = 1.0f;
        fArray3[13] = -1.0f;
        fArray2[14] = 1.0f;
        fArray3[15] = 0.0f;
        this.m_verticesDrawData = object2;
        object2 = new float[n11];
        this.m_verticesData = object2;
        object2 = new float[n11];
        this.mMVPMatrix = object2;
        object2 = new float[n11];
        this.mSTMatrix = object2;
        int n12 = 1;
        Object object3 = new int[n12];
        this.m_fbo = object3;
        object3 = new Object;
        this.m_videoEncodeEosSyncEvent = object3;
        this.m_videoEncoderInputColorFormat = n10 = -1;
        this.m_videoEncoderInputPixelFormat = n10;
        this.m_videoEncoderStarted = false;
        int n13 = Build.VERSION.SDK_INT;
        int n14 = 18;
        Object object4 = n13 >= n14 ? EGL14.EGL_NO_DISPLAY : null;
        this.m_eglDisplay = object4;
        object4 = n13 >= n14 ? EGL14.EGL_NO_CONTEXT : null;
        this.m_eglContext = object4;
        object4 = new android.opengl.EGLConfig[n12];
        this.m_eglConfigs = object4;
        if (n13 >= n14) {
            object = EGL14.EGL_NO_SURFACE;
        } else {
            n13 = 0;
            object = null;
        }
        this.m_eglSurface = object;
        this.m_drawProgram = 0;
        this.m_draw_attrLoc_pos = n10;
        this.m_draw_attrLoc_texCoord = n10;
        this.m_program = 0;
        this.m_attrLoc_pos = n10;
        this.m_attrLoc_texCoord = n10;
        this.m_uniformLoc_mvpMatrix = n10;
        this.m_uniformLoc_texMatrix = n10;
        this.m_uniformLuminosityAmount = n10;
        this.m_endOfInputStreamSignaled = false;
        this.m_videoEncoderFormatChanged = false;
        object = new int[n12];
        this.m_textureId = (int[])object;
        this.m_surfaceTexture = null;
        super();
        this.m_frameSyncObject = object;
        this.m_frameAvailable = false;
        this.m_videoFrameSent = 0;
        this.m_convertToYUY2Program = 0;
        this.m_convertToYUY2Program_attrLoc_pos = n10;
        this.m_convertToYUY2Program_attrLoc_texCoord = n10;
        this.m_convertToYUY2Program_uniformLoc_coefY = n10;
        this.m_convertToYUY2Program_uniformLoc_coefU = n10;
        this.m_convertToYUY2Program_uniformLoc_coefV = n10;
        this.m_convertToYUY2Program_uniformLoc_sPerHalfTexel = n10;
        object = new float[n11];
        this.m_verticesYUY2Data = (float[])object;
        object = EGL10.EGL_NO_CONTEXT;
        this.m_context = object;
        object = EGL10.EGL_NO_SURFACE;
        this.m_surface = object;
        object = new int[n12];
        this.downloadTexture = (int[])object;
        object = new int[n12];
        this.uploadTexture = (int[])object;
        this.textureIdPoolMaxCount = n13 = 70;
        this.sawTheEnd = false;
        this.firstReverseReplayback = n12;
        object2 = new ArrayList;
        super();
        this.m_tmpVideoFrame = object2;
        this.m_MaxProcessCount = n13;
        this.m_bIsReverseConvert = false;
        this.m_bHasInstalledLicense = false;
        this.m_n64VideoProcessPos = l11 = 0L;
        this.m_n64PlayBackStartPosForReverse = l11;
        this.m_n64TimeStampStart = l10 = Long.MAX_VALUE;
        object2 = new ArrayList;
        super();
        this.m_videoFramePool = object2;
        object2 = new Object;
        super();
        this.m_videoFramePoolObject = object2;
        this.initUploadTextId = false;
        this.hasInitSurfaceTexture = false;
        this.hasInitVideoEncoder = false;
        this.b = 0;
        this.bProcessSegment = false;
        this.tmpSamplePts = l11;
        this.m_yuy2UploaderProgram = 0;
        this.m_yuy2Uploader_attrLoc_pos = n10;
        this.m_yuy2Uploader_attrLoc_texCoord = n10;
        this.m_yuy2Uploader_uniformLoc_yOffset = n10;
        this.m_yuy2Uploader_uniformLoc_Y_RGB = n10;
        this.m_yuy2Uploader_uniformLoc_V_R = n10;
        this.m_yuy2Uploader_uniformLoc_U_G = n10;
        this.m_yuy2Uploader_uniformLoc_V_G = n10;
        this.m_yuy2Uploader_uniformLoc_U_B = n10;
        float[] fArray4 = fArray = new float[n11];
        float[] fArray5 = fArray;
        fArray4[0] = -1.0f;
        fArray5[1] = 1.0f;
        fArray4[2] = 0.0f;
        fArray5[3] = 1.0f;
        fArray4[4] = -1.0f;
        fArray5[5] = -1.0f;
        fArray4[6] = 0.0f;
        fArray5[7] = 0.0f;
        fArray4[8] = 1.0f;
        fArray5[9] = 1.0f;
        fArray4[10] = 1.0f;
        fArray5[11] = 1.0f;
        fArray4[12] = 1.0f;
        fArray5[13] = -1.0f;
        fArray4[14] = 1.0f;
        fArray5[15] = 0.0f;
        this.m_verticesUploadData = fArray;
        this.a = 0;
        this.m_fileWriter = nvAndroidSurfaceFileWriter;
        this.m_handler = handler;
        int n15 = nvAndroidSurfaceFileWriter.m_is4K;
        this.textureIdPoolMaxCount = n15 != 0 ? (n15 = 30) : n13;
        this.m_n64VideoProcessPos = l11;
        this.m_n64PlayBackStartPosForReverse = l11;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    private NvVideoFrame GetVideoFrameFromPool() {
        Object object;
        Object object2 = this.m_videoFramePoolObject;
        // MONITORENTER : object2
        ArrayList arrayList = this.m_videoFramePool;
        int n10 = arrayList.size();
        Object object3 = false;
        Object var5_5 = null;
        if (n10 <= 0) {
            block7: {
                n10 = 0;
                arrayList = null;
                try {
                    object = this.m_videoFramePoolObject;
                    long l10 = Long.MAX_VALUE;
                    object.wait(l10);
                    object = this.m_videoFramePool;
                    int n11 = ((ArrayList)object).size();
                    if (n11 > 0) break block7;
                    object = TAG;
                    Object object4 = "Video frame pool is empty, and no frame return to pool!";
                    Log.d((String)object, (String)object4);
                    object = new NvVideoFrame();
                    int n12 = 1;
                    int[] nArray = ((NvVideoFrame)object).textureId;
                    GLES20.glGenTextures((int)n12, (int[])nArray, (int)0);
                    object4 = ((NvVideoFrame)object).textureId;
                    object3 = object4[0];
                    if (object3) return object;
                }
                catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                    // MONITOREXIT : object2
                    return null;
                }
                return null;
            }
            object = this.m_videoFramePool;
            object = ((ArrayList)object).get(0);
            object = (NvVideoFrame)object;
            ArrayList arrayList2 = this.m_videoFramePool;
            arrayList2.remove(0);
            return object;
        }
        arrayList = this.m_videoFramePool;
        arrayList = arrayList.get(0);
        object = arrayList;
        object = (NvVideoFrame)((Object)arrayList);
        arrayList = this.m_videoFramePool;
        arrayList.remove(0);
        // MONITOREXIT : object2
        return object;
    }

    private void ProceVideoSamples(NvVideoFrame object) {
        Object object2;
        int n10;
        int n11 = this.bProcessSegment;
        if (n11 != 0) {
            return;
        }
        long l10 = this.m_n64VideoProcessPos;
        if (object != null) {
            l10 = ((NvVideoFrame)object).streamTime;
        }
        CharSequence charSequence = new StringBuilder();
        charSequence.append("samplePts: ");
        charSequence.append(l10);
        charSequence.append("m_n64VideoProcessPos: ");
        long l11 = this.m_n64VideoProcessPos;
        charSequence.append(l11);
        Object object3 = "    ";
        charSequence.append((String)object3);
        int n12 = 1;
        int n13 = 0;
        if (object != null) {
            n10 = n12;
        } else {
            n10 = 0;
            object2 = null;
        }
        charSequence.append(n10 != 0);
        charSequence = charSequence.toString();
        object2 = TAG;
        Logger.e((String)object2, charSequence);
        long l12 = this.m_n64VideoProcessPos;
        n11 = l10 == l12 ? 0 : (l10 < l12 ? -1 : 1);
        if (n11 < 0) {
            Object object4 = this.m_tmpVideoFrame;
            n11 = ((ArrayList)object4).size();
            int n14 = n11 + 5;
            if (n14 < (n12 = this.m_MaxProcessCount)) {
                int n15;
                long l13;
                object4 = new NvAndroidSurfaceFileWriterVideoWorker$NvCacheSampleBuffer(this);
                ((NvAndroidSurfaceFileWriterVideoWorker$NvCacheSampleBuffer)object4).m_samplesBuffer = object;
                ((NvAndroidSurfaceFileWriterVideoWorker$NvCacheSampleBuffer)object4).m_timestamp = l13 = ((NvVideoFrame)object).streamTime;
                ((NvAndroidSurfaceFileWriterVideoWorker$NvCacheSampleBuffer)object4).pixelFormat = n15 = ((NvVideoFrame)object).pixelFormat;
                object = this.m_tmpVideoFrame;
                ((ArrayList)object).add(object4);
            } else {
                int n16;
                long l14;
                charSequence = null;
                for (n14 = 0; n14 < n11; ++n14) {
                    object3 = (NvAndroidSurfaceFileWriterVideoWorker$NvCacheSampleBuffer)this.m_tmpVideoFrame.get(n14);
                    if (object3 == null || (object2 = ((NvAndroidSurfaceFileWriterVideoWorker$NvCacheSampleBuffer)object3).m_samplesBuffer) == null) continue;
                    int n17 = Build.VERSION.SDK_INT;
                    int n18 = 18;
                    if (n17 < n18) {
                        this.writeBufferToTempFile((NvAndroidSurfaceFileWriterVideoWorker$NvCacheSampleBuffer)object3);
                        object4 = ((NvAndroidSurfaceFileWriterVideoWorker$NvCacheSampleBuffer)object3).m_samplesBuffer;
                        ((NvVideoFrame)object4).buffer = null;
                        this.ReturnVideoFrameToPool((NvVideoFrame)object4);
                        ((NvAndroidSurfaceFileWriterVideoWorker$NvCacheSampleBuffer)object3).m_samplesBuffer = null;
                        object4 = this.m_tmpVideoFrame;
                        ((ArrayList)object4).set(n14, object3);
                        break;
                    }
                    int[] nArray = ((NvVideoFrame)object2).textureId;
                    n17 = nArray[0];
                    if (n17 == 0) continue;
                    ((NvAndroidSurfaceFileWriterVideoWorker$NvCacheSampleBuffer)object3).m_samplesBuffer = object4 = this.DownloadGPUToHost((NvVideoFrame)object2, false);
                    ((NvVideoFrame)object4).pixelFormat = n13 = 4;
                    this.writeBufferToTempFile((NvAndroidSurfaceFileWriterVideoWorker$NvCacheSampleBuffer)object3);
                    object4 = ((NvAndroidSurfaceFileWriterVideoWorker$NvCacheSampleBuffer)object3).m_samplesBuffer;
                    ((NvVideoFrame)object4).buffer = null;
                    this.ReturnVideoFrameToPool((NvVideoFrame)object4);
                    ((NvAndroidSurfaceFileWriterVideoWorker$NvCacheSampleBuffer)object3).m_samplesBuffer = null;
                    object4 = this.m_tmpVideoFrame;
                    ((ArrayList)object4).set(n14, object3);
                    break;
                }
                object4 = new NvAndroidSurfaceFileWriterVideoWorker$NvCacheSampleBuffer(this);
                ((NvAndroidSurfaceFileWriterVideoWorker$NvCacheSampleBuffer)object4).m_samplesBuffer = object;
                ((NvAndroidSurfaceFileWriterVideoWorker$NvCacheSampleBuffer)object4).m_timestamp = l14 = ((NvVideoFrame)object).streamTime;
                ((NvAndroidSurfaceFileWriterVideoWorker$NvCacheSampleBuffer)object4).pixelFormat = n16 = ((NvVideoFrame)object).pixelFormat;
                object = this.m_tmpVideoFrame;
                ((ArrayList)object).add(object4);
            }
        } else {
            this.bProcessSegment = n12;
            if (object != null) {
                ((NvVideoFrame)object).buffer = null;
                this.ReturnVideoFrameToPool((NvVideoFrame)object);
            }
        }
    }

    private int ProcessVideoSegment() {
        long l10;
        long l11;
        Object object = this.m_tmpVideoFrame;
        int n10 = ((ArrayList)object).size();
        this.tmpSamplePts = l11 = this.m_n64VideoProcessPos;
        int n11 = 1;
        if (n10 <= 0) {
            return n11;
        }
        Object object2 = this.m_tmpVideoFrame;
        if ((object2 = (NvAndroidSurfaceFileWriterVideoWorker$NvCacheSampleBuffer)((ArrayList)object2).get(n10 -= n11)) != null) {
            int n12 = Build.VERSION.SDK_INT;
            int n13 = 18;
            long l12 = Long.MAX_VALUE;
            if (n12 >= n13) {
                NvVideoFrame nvVideoFrame = ((NvAndroidSurfaceFileWriterVideoWorker$NvCacheSampleBuffer)object2).m_samplesBuffer;
                if (nvVideoFrame == null) {
                    this.ReadSamplebufferFromTmpFile((NvAndroidSurfaceFileWriterVideoWorker$NvCacheSampleBuffer)object2);
                    nvVideoFrame = ((NvAndroidSurfaceFileWriterVideoWorker$NvCacheSampleBuffer)object2).m_samplesBuffer;
                    ((NvAndroidSurfaceFileWriterVideoWorker$NvCacheSampleBuffer)object2).m_samplesBuffer = nvVideoFrame = this.UpladFrameToGPU_YUY2(nvVideoFrame);
                    n13 = 0;
                    nvVideoFrame.buffer = null;
                }
                this.tmpSamplePts = l10 = ((NvAndroidSurfaceFileWriterVideoWorker$NvCacheSampleBuffer)object2).m_timestamp;
                long l13 = this.m_n64TimeStampStart;
                long l14 = l13 - l12;
                Object object3 = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
                if (object3 == false) {
                    this.m_n64TimeStampStart = l10;
                }
                object2 = ((NvAndroidSurfaceFileWriterVideoWorker$NvCacheSampleBuffer)object2).m_samplesBuffer;
                ((NvVideoFrame)object2).streamTime = l12 = this.m_n64TimeStampStart - l10;
                this.EncodeFrame((NvVideoFrame)object2);
            } else {
                NvVideoFrame nvVideoFrame = ((NvAndroidSurfaceFileWriterVideoWorker$NvCacheSampleBuffer)object2).m_samplesBuffer;
                if (nvVideoFrame == null) {
                    this.ReadSamplebufferFromTmpFile((NvAndroidSurfaceFileWriterVideoWorker$NvCacheSampleBuffer)object2);
                }
                this.tmpSamplePts = l10 = ((NvAndroidSurfaceFileWriterVideoWorker$NvCacheSampleBuffer)object2).m_timestamp;
                long l15 = this.m_n64TimeStampStart;
                long l16 = l15 - l12;
                Object object4 = l16 == 0L ? 0 : (l16 < 0L ? -1 : 1);
                if (object4 == false) {
                    this.m_n64TimeStampStart = l10;
                }
                object2 = ((NvAndroidSurfaceFileWriterVideoWorker$NvCacheSampleBuffer)object2).m_samplesBuffer;
                ((NvVideoFrame)object2).streamTime = l12 = this.m_n64TimeStampStart - l10;
                this.EncodeFrame((NvVideoFrame)object2);
            }
        }
        this.m_tmpVideoFrame.remove(n10);
        object = this.m_tmpVideoFrame;
        n10 = ((ArrayList)object).size();
        object2 = null;
        if (n10 > 0) {
            return 0;
        }
        object = this.m_tmpAccessFile;
        l10 = 0L;
        try {
            ((RandomAccessFile)object).seek(l10);
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
        this.m_n64VideoProcessPos = l10 = this.tmpSamplePts;
        this.m_tmpVideoFrame.clear();
        this.bProcessSegment = false;
        return n11;
    }

    private void ReadSamplebufferFromTmpFile(NvAndroidSurfaceFileWriterVideoWorker$NvCacheSampleBuffer object) {
        block21: {
            int n10;
            Object object2;
            Object object3;
            block20: {
                block19: {
                    int n12;
                    object3 = this.GetVideoFrameFromPool();
                    object2 = ByteBuffer.allocateDirect(((NvAndroidSurfaceFileWriterVideoWorker$NvCacheSampleBuffer)object).sampleSizeInFile);
                    ((NvVideoFrame)object3).buffer = object2;
                    ((ByteBuffer)object2).clear();
                    object2 = this.m_fileWriter.m_videoRes;
                    ((NvVideoFrame)object3).imageWidth = n12 = ((NvVideoResolution)object2).imageWidth;
                    ((NvVideoFrame)object3).imageHeight = n10 = ((NvVideoResolution)object2).imageHeight;
                    ((NvAndroidSurfaceFileWriterVideoWorker$NvCacheSampleBuffer)object).m_samplesBuffer = object3;
                    object2 = this.m_tmpAccessFile;
                    long l10 = ((NvAndroidSurfaceFileWriterVideoWorker$NvCacheSampleBuffer)object).offsetInTmpFile;
                    ((RandomAccessFile)object2).seek(l10);
                    object = ((NvVideoFrame)object3).buffer;
                    boolean n11 = ((ByteBuffer)object).hasArray();
                    if (!n11) break block19;
                    object = ((NvVideoFrame)object3).buffer;
                    object = ((ByteBuffer)object).array();
                    object2 = ((NvVideoFrame)object3).buffer;
                    n10 = ((ByteBuffer)object2).arrayOffset();
                    break block20;
                }
                object = ((NvVideoFrame)object3).buffer;
                int n11 = ((Buffer)object).limit();
                object = new byte[n11];
                n10 = 0;
                object2 = null;
            }
            RandomAccessFile randomAccessFile = this.m_tmpAccessFile;
            ByteBuffer byteBuffer = ((NvVideoFrame)object3).buffer;
            int n12 = byteBuffer.limit();
            randomAccessFile.read((byte[])object, n10, n12);
            object2 = ((NvVideoFrame)object3).buffer;
            n10 = (int)(((ByteBuffer)object2).hasArray() ? 1 : 0);
            if (n10 != 0) break block21;
            object3 = ((NvVideoFrame)object3).buffer;
            try {
                ((ByteBuffer)object3).put((byte[])object);
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
            }
        }
    }

    /*
     * WARNING - void declaration
     */
    private void writeBufferToTempFile(NvAndroidSurfaceFileWriterVideoWorker$NvCacheSampleBuffer nvAndroidSurfaceFileWriterVideoWorker$NvCacheSampleBuffer) {
        Object object = nvAndroidSurfaceFileWriterVideoWorker$NvCacheSampleBuffer.m_samplesBuffer;
        if (object != null && (object = ((NvVideoFrame)object).buffer) != null) {
            void var9_12;
            Object object2;
            Object object3;
            int n11;
            Object object4;
            long l10;
            block26: {
                Object object5;
                block25: {
                    object = this.m_tmpAccessFile;
                    l10 = ((RandomAccessFile)object).getFilePointer();
                    object4 = nvAndroidSurfaceFileWriterVideoWorker$NvCacheSampleBuffer.m_samplesBuffer;
                    object4 = ((NvVideoFrame)object4).buffer;
                    n11 = ((Buffer)object4).limit();
                    object3 = null;
                    object5 = nvAndroidSurfaceFileWriterVideoWorker$NvCacheSampleBuffer.m_samplesBuffer;
                    object5 = ((NvVideoFrame)object5).buffer;
                    boolean n10 = ((ByteBuffer)object5).hasArray();
                    if (!n10) break block25;
                    object3 = nvAndroidSurfaceFileWriterVideoWorker$NvCacheSampleBuffer.m_samplesBuffer;
                    object3 = ((NvVideoFrame)object3).buffer;
                    object3 = ((ByteBuffer)object3).array();
                    object5 = nvAndroidSurfaceFileWriterVideoWorker$NvCacheSampleBuffer.m_samplesBuffer;
                    object5 = ((NvVideoFrame)object5).buffer;
                    int n12 = ((ByteBuffer)object5).arrayOffset();
                    break block26;
                }
                object5 = new byte[n11];
                object2 = nvAndroidSurfaceFileWriterVideoWorker$NvCacheSampleBuffer.m_samplesBuffer;
                object2 = ((NvVideoFrame)object2).buffer;
                ((ByteBuffer)object2).get((byte[])object5);
                Object object6 = object5;
                boolean bl2 = false;
                object5 = null;
                object3 = object6;
            }
            object2 = this.m_tmpAccessFile;
            ((RandomAccessFile)object2).write((byte[])object3, (int)var9_12, n11);
            object4 = this.m_tmpAccessFile;
            long l11 = ((RandomAccessFile)object4).getFilePointer();
            nvAndroidSurfaceFileWriterVideoWorker$NvCacheSampleBuffer.offsetInTmpFile = l10;
            int n13 = (int)(l11 -= l10);
            try {
                nvAndroidSurfaceFileWriterVideoWorker$NvCacheSampleBuffer.sampleSizeInFile = n13;
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void AwaitNewImage() {
        long l10;
        Object object;
        Object object2 = this.m_fileWriter.m_videoReader.m_frameSyncObject;
        synchronized (object2) {
            object = this.m_fileWriter;
            object = ((NvAndroidSurfaceFileWriter)object).m_videoReader;
            l10 = ((NvAndroidSurfaceVideoFileReader)object).GetTimestampOfCurrentTextureFrame();
        }
        object2 = this.m_fileWriter;
        int n10 = ((NvAndroidSurfaceFileWriter)object2).m_stopping;
        long l11 = -1;
        if (n10 != 0) {
            l10 = l11;
        }
        if ((n10 = this.sawTheEnd) != 0) {
            return;
        }
        object2 = this.m_videoFramePool;
        n10 = ((ArrayList)object2).size();
        if (n10 <= 0) {
            return;
        }
        n10 = (int)(l10 == l11 ? 0 : (l10 < l11 ? -1 : 1));
        l10 = 1000000L;
        int n11 = 2;
        int n12 = 0;
        Object object3 = null;
        boolean bl2 = true;
        if (n10 == 0) {
            boolean bl3;
            object2 = this.m_fileWriter;
            n10 = (int)(((NvAndroidSurfaceFileWriter)object2).m_stopping ? 1 : 0);
            if (n10 == 0 && (bl3 = this.m_bIsReverseConvert)) {
                long l12;
                n10 = (int)(this.firstReverseReplayback ? 1 : 0);
                if (n10 == 0) {
                    return;
                }
                n10 = (int)(this.bProcessSegment ? 1 : 0);
                if (n10 == 0) {
                    this.ProceVideoSamples(null);
                    return;
                }
                object2 = TAG;
                String string2 = "1111111111";
                Logger.e((String)object2, string2);
                n10 = this.ProcessVideoSegment();
                if (n10 != bl2) return;
                this.firstReverseReplayback = false;
                long l13 = this.m_n64PlayBackStartPosForReverse;
                object2 = this.m_fileWriter;
                long l14 = ((NvAndroidSurfaceFileWriter)object2).m_startTime;
                long l15 = l13 - l14;
                n10 = (int)(l15 == 0L ? 0 : (l15 < 0L ? -1 : 1));
                if (n10 <= 0) {
                    this.sawTheEnd = bl2;
                    this.EncodeFrame(null);
                    object2 = new Message();
                    ((Message)object2).what = n11;
                    ((Message)object2).obj = null;
                    object = this.m_fileWriter.m_eventHandler;
                    object.sendMessage((Message)object2);
                    return;
                }
                long l16 = this.m_n64VideoProcessPos;
                long l17 = l16 - l13;
                n10 = (int)(l17 == 0L ? 0 : (l17 < 0L ? -1 : 1));
                if (n10 < 0) {
                    this.m_n64PlayBackStartPosForReverse = l16;
                }
                if ((n10 = (int)((l12 = (l16 = this.m_n64PlayBackStartPosForReverse - l10) - l14) == 0L ? 0 : (l12 < 0L ? -1 : 1))) >= 0) {
                    l14 = l16;
                }
                this.m_n64PlayBackStartPosForReverse = l14;
                object = new StringBuilder();
                String string3 = "1111sendMessage: ";
                ((StringBuilder)object).append(string3);
                ((StringBuilder)object).append(l14);
                object = ((StringBuilder)object).toString();
                Logger.e(TAG, object);
                long l18 = this.m_n64PlayBackStartPosForReverse;
                long l19 = this.m_n64VideoProcessPos;
                object3 = object2;
                NvAndroidSurfaceFileWriterVideoWorker nvAndroidSurfaceFileWriterVideoWorker = this;
                object2 = new NvAndroidSurfaceFileWriterVideoWorker$ReverseInfo(this, l18, l19);
                object = new Message();
                ((Message)object).what = n11;
                ((Message)object).obj = object2;
                object2 = this.m_fileWriter.m_eventHandler;
                object2.sendMessage((Message)object);
                return;
            }
            if (n10 != 0 && (n10 = (int)(this.m_bIsReverseConvert ? 1 : 0)) != 0) {
                while ((n10 = ((ArrayList)(object2 = this.m_tmpVideoFrame)).size()) > 0) {
                    Object object4;
                    object2 = (NvAndroidSurfaceFileWriterVideoWorker$NvCacheSampleBuffer)this.m_tmpVideoFrame.get(0);
                    object = this.m_tmpVideoFrame;
                    ((ArrayList)object).remove(0);
                    if (object2 == null || (object2 = ((NvAndroidSurfaceFileWriterVideoWorker$NvCacheSampleBuffer)object2).m_samplesBuffer) == null || (object4 = (object = (Object)((NvVideoFrame)object2).textureId)[0]) == false) continue;
                    ((NvVideoFrame)object2).buffer = null;
                    this.ReturnVideoFrameToPool((NvVideoFrame)object2);
                }
            }
            this.sawTheEnd = bl2;
            this.EncodeFrame(null);
            return;
        }
        n10 = (int)(this.m_bIsReverseConvert ? 1 : 0);
        if (n10 != 0 && (n10 = (int)(this.bProcessSegment ? 1 : 0)) != 0) {
            long l20;
            n10 = this.ProcessVideoSegment();
            if (n10 != bl2) return;
            long l21 = this.m_n64PlayBackStartPosForReverse;
            object2 = this.m_fileWriter;
            long l22 = ((NvAndroidSurfaceFileWriter)object2).m_startTime;
            long l23 = l21 - l22;
            n10 = (int)(l23 == 0L ? 0 : (l23 < 0L ? -1 : 1));
            if (n10 <= 0) {
                Logger.e(TAG, "sawTheEnd");
                this.sawTheEnd = bl2;
                this.EncodeFrame(null);
                object2 = new Message();
                ((Message)object2).what = n11;
                ((Message)object2).obj = null;
                object = this.m_fileWriter.m_eventHandler;
                object.sendMessage((Message)object2);
                return;
            }
            long l24 = this.m_n64VideoProcessPos;
            long l25 = l24 - l21;
            n10 = (int)(l25 == 0L ? 0 : (l25 < 0L ? -1 : 1));
            if (n10 < 0) {
                this.m_n64PlayBackStartPosForReverse = l24;
            }
            if ((n10 = (int)((l20 = (l24 = this.m_n64PlayBackStartPosForReverse - l10) - l22) == 0L ? 0 : (l20 < 0L ? -1 : 1))) >= 0) {
                l22 = l24;
            }
            this.m_n64PlayBackStartPosForReverse = l22;
            object = new StringBuilder();
            String string4 = "sendMessage: ";
            ((StringBuilder)object).append(string4);
            ((StringBuilder)object).append(l22);
            object = ((StringBuilder)object).toString();
            Logger.e(TAG, object);
            long l26 = this.m_n64PlayBackStartPosForReverse;
            long l27 = this.m_n64VideoProcessPos;
            object3 = object2;
            NvAndroidSurfaceFileWriterVideoWorker nvAndroidSurfaceFileWriterVideoWorker = this;
            object2 = new NvAndroidSurfaceFileWriterVideoWorker$ReverseInfo(this, l26, l27);
            object = new Message();
            ((Message)object).what = n11;
            ((Message)object).obj = object2;
            object2 = this.m_fileWriter.m_eventHandler;
            object2.sendMessage((Message)object);
            return;
        }
        object = this.m_frameSyncObject;
        synchronized (object) {
            n10 = (int)(this.m_frameAvailable ? 1 : 0);
            if (n10 == 0) {
                return;
            }
            this.m_frameAvailable = false;
        }
        try {
            object2 = this.m_surfaceTexture;
            object2.updateTexImage();
            object2 = this.m_fileWriter.m_videoReader.m_frameSyncObject;
        }
        catch (Exception exception) {
            CharSequence charSequence = new StringBuilder();
            charSequence.append("");
            String string5 = exception.getMessage();
            charSequence.append(string5);
            charSequence = charSequence.toString();
            Logger.e(TAG, charSequence);
            exception.printStackTrace();
            return;
        }
        synchronized (object2) {
            object = this.m_fileWriter;
            object = ((NvAndroidSurfaceFileWriter)object).m_videoReader;
            object = ((NvAndroidSurfaceVideoFileReader)object).m_frameSyncObject;
            object.notifyAll();
            object = this.m_fileWriter;
            object = ((NvAndroidSurfaceFileWriter)object).m_videoReader;
            l10 = ((NvAndroidSurfaceVideoFileReader)object).GetTimestampOfCurrentTextureFrame();
        }
        object2 = this.SurfaceTextureResizer();
        Object object5 = this.m_fileWriter.m_videoRes;
        ((NvVideoFrame)object2).imageWidth = n12 = ((NvVideoResolution)object5).imageWidth;
        ((NvVideoFrame)object2).imageHeight = n11 = ((NvVideoResolution)object5).imageHeight;
        n11 = Build.VERSION.SDK_INT;
        n12 = 18;
        if (n11 < n12) {
            object2 = this.DownloadGPUToHost((NvVideoFrame)object2, bl2);
            ((NvVideoFrame)object2).pixelFormat = n11 = 4;
        }
        ((NvVideoFrame)object2).streamTime = l11 = NvConvertorUtils.UsToNvTime(l10);
        object5 = TAG;
        object3 = new StringBuilder();
        String string6 = "";
        ((StringBuilder)object3).append(string6);
        ((StringBuilder)object3).append(l10);
        ((StringBuilder)object3).append(" really time: ");
        l10 = ((NvVideoFrame)object2).streamTime;
        ((StringBuilder)object3).append(l10);
        object = ((StringBuilder)object3).toString();
        Logger.e((String)object5, object);
        boolean bl4 = this.m_bIsReverseConvert;
        if (bl4) {
            this.ProceVideoSamples((NvVideoFrame)object2);
            return;
        }
        this.EncodeFrame((NvVideoFrame)object2);
    }

    public boolean CheckOperatingRateIsValid(int n10, int n11) {
        n10 *= n11;
        n11 = 0;
        int n12 = 8294400;
        if (n10 > n12) {
            return false;
        }
        String string2 = Build.MANUFACTURER;
        String string3 = Build.MODEL;
        String string4 = "OPPO";
        boolean bl2 = string2.equals(string4);
        boolean bl3 = true;
        if (bl2) {
            return bl3;
        }
        string4 = "vivo";
        bl2 = string2.equals(string4);
        if (bl2) {
            return bl3;
        }
        string4 = "Xiaomi";
        n10 = (int)(string2.equals(string4) ? 1 : 0);
        if (n10 != 0 && (n10 = (int)(string3.equals(string2 = "MI 8") ? 1 : 0)) != 0) {
            return bl3;
        }
        return false;
    }

    public void Cleanup() {
        Object object;
        Object object2;
        int n10;
        Object object3 = this.m_tmpAccessFile;
        if (object3 != null) {
            try {
                ((RandomAccessFile)object3).close();
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
            }
            this.m_tmpAccessFile = null;
        }
        if ((object3 = this.m_tmpVideoFrame) != null) {
            ((ArrayList)object3).clear();
        }
        this.m_tmpVideoFrame = null;
        object3 = this.m_surfaceTexture;
        if (object3 != null) {
            object3.release();
            this.m_surfaceTexture = null;
        }
        object3 = this.m_fbo;
        Object object4 = object3[0];
        int n11 = 1;
        if (object4 != false) {
            GLES20.glDeleteFramebuffers((int)n11, (int[])object3, (int)0);
            object3 = this.m_fbo;
            object3[0] = false;
        }
        if ((object4 = (object3 = (Object)this.m_textureId)[0]) != false) {
            GLES20.glDeleteTextures((int)n11, (int[])object3, (int)0);
            object3 = this.m_textureId;
            object3[0] = false;
        }
        if ((object4 = (object3 = (Object)this.downloadTexture)[0]) != false) {
            GLES20.glDeleteTextures((int)n11, (int[])object3, (int)0);
            object3 = this.downloadTexture;
            object3[0] = false;
        }
        if ((object4 = (object3 = (Object)this.uploadTexture)[0]) != false) {
            GLES20.glDeleteTextures((int)n11, (int[])object3, (int)0);
            object3 = this.uploadTexture;
            object3[0] = false;
        }
        if ((object3 = this.m_videoFramePool) != null) {
            object3 = null;
            for (n10 = 0; n10 < (object4 = (Object)((ArrayList)(object2 = this.m_videoFramePool)).size()); ++n10) {
                object2 = ((NvVideoFrame)this.m_videoFramePool.get((int)n10)).textureId;
                object4 = object2[0];
                if (object4 == false) continue;
                object2 = ((NvVideoFrame)this.m_videoFramePool.get((int)n10)).textureId;
                GLES20.glDeleteTextures((int)n11, (int[])object2, (int)0);
                object2 = ((NvVideoFrame)this.m_videoFramePool.get((int)n10)).textureId;
                object2[0] = false;
            }
            object3 = this.m_videoFramePool;
            ((ArrayList)object3).clear();
        }
        this.m_videoFramePool = null;
        object3 = this.m_videoEncoder;
        if (object3 != null) {
            object4 = this.m_videoEncoderStarted;
            if (object4 != false) {
                try {
                    object3.stop();
                }
                catch (IllegalStateException illegalStateException) {
                    illegalStateException.printStackTrace();
                }
                this.m_videoEncoderStarted = false;
            }
            if ((object3 = this.m_videoEncoderInputSurface) != null) {
                object3.release();
                this.m_videoEncoderInputSurface = null;
            }
            this.m_inputBuffers = null;
            object3 = this.m_videoEncoder;
            object3.release();
            this.m_videoEncoder = null;
        }
        n10 = this.m_program;
        object4 = -1;
        if (n10 != 0) {
            GLES20.glDeleteProgram((int)n10);
            this.m_program = 0;
            this.m_attrLoc_pos = (int)object4;
            this.m_attrLoc_texCoord = (int)object4;
            this.m_uniformLoc_mvpMatrix = (int)object4;
            this.m_uniformLoc_texMatrix = (int)object4;
            this.m_uniformLuminosityAmount = (int)object4;
        }
        if ((n10 = this.m_drawProgram) != 0) {
            GLES20.glDeleteProgram((int)n10);
            this.m_drawProgram = 0;
            this.m_draw_attrLoc_pos = (int)object4;
            this.m_draw_attrLoc_texCoord = (int)object4;
        }
        if ((n10 = this.m_convertToYUY2Program) != 0) {
            GLES20.glDeleteProgram((int)n10);
            this.m_convertToYUY2Program = 0;
            this.m_convertToYUY2Program_attrLoc_pos = (int)object4;
            this.m_convertToYUY2Program_attrLoc_texCoord = (int)object4;
            this.m_convertToYUY2Program_uniformLoc_coefY = (int)object4;
            this.m_convertToYUY2Program_uniformLoc_coefU = (int)object4;
            this.m_convertToYUY2Program_uniformLoc_coefV = (int)object4;
            this.m_convertToYUY2Program_uniformLoc_sPerHalfTexel = (int)object4;
        }
        if ((n10 = this.m_yuy2UploaderProgram) != 0) {
            GLES20.glDeleteProgram((int)n10);
            this.m_yuy2UploaderProgram = 0;
            this.m_yuy2Uploader_attrLoc_pos = (int)object4;
            this.m_yuy2Uploader_attrLoc_texCoord = (int)object4;
            this.m_yuy2Uploader_uniformLoc_yOffset = (int)object4;
            this.m_yuy2Uploader_uniformLoc_Y_RGB = (int)object4;
            this.m_yuy2Uploader_uniformLoc_V_R = (int)object4;
            this.m_yuy2Uploader_uniformLoc_U_G = (int)object4;
            this.m_yuy2Uploader_uniformLoc_V_G = (int)object4;
            this.m_yuy2Uploader_uniformLoc_U_B = (int)object4;
        }
        if ((n10 = Build.VERSION.SDK_INT) >= (object4 = (Object)18)) {
            object3 = this.m_eglSurface;
            object2 = EGL14.EGL_NO_SURFACE;
            if (object3 != object2) {
                object2 = this.m_eglDisplay;
                EGL14.eglDestroySurface((EGLDisplay)object2, (android.opengl.EGLSurface)object3);
                n10 = EGL14.eglGetError();
                object4 = 12288;
                if (n10 != object4) {
                    object2 = new StringBuilder();
                    object = "EGL error: 0x";
                    ((StringBuilder)object2).append((String)object);
                    ((StringBuilder)object2).append(n10);
                    object3 = ((StringBuilder)object2).toString();
                    object2 = TAG;
                    Logger.e((String)object2, object3);
                }
                object3 = EGL14.EGL_NO_SURFACE;
                this.m_eglSurface = object3;
            }
            if ((object3 = this.m_eglContext) != (object2 = EGL14.EGL_NO_CONTEXT)) {
                object2 = this.m_eglDisplay;
                EGL14.eglDestroyContext((EGLDisplay)object2, (android.opengl.EGLContext)object3);
                object3 = EGL14.EGL_NO_CONTEXT;
                this.m_eglContext = object3;
                object3 = EGL14.EGL_NO_DISPLAY;
                this.m_eglDisplay = object3;
            }
        }
        if ((object3 = this.m_context) != (object2 = EGL10.EGL_NO_CONTEXT)) {
            object3 = (EGL10)EGLContext.getEGL();
            object2 = EGL10.EGL_DEFAULT_DISPLAY;
            if ((object2 = object3.eglGetDisplay(object2)) != (object = EGL10.EGL_NO_DISPLAY)) {
                object = this.m_surface;
                object3.eglDestroySurface((javax.microedition.khronos.egl.EGLDisplay)object2, (EGLSurface)object);
                object = this.m_context;
                object3.eglDestroyContext((javax.microedition.khronos.egl.EGLDisplay)object2, (EGLContext)object);
            }
            object3 = EGL10.EGL_NO_SURFACE;
            this.m_surface = object3;
            object3 = EGL10.EGL_NO_CONTEXT;
            this.m_context = object3;
        }
        if ((object3 = this.m_jVideoEncoderCallback) != null) {
            ((NvMediaEncodecCallback)object3).cleanUp();
            this.m_jVideoEncoderCallback = null;
        }
        this.m_videoBufferInfo = null;
        this.m_videoFrameSent = 0;
        this.m_requestSyncVideoFrameInterval = 0;
        this.m_videoEncoderFormatChanged = false;
        this.m_vertices = null;
        this.m_verticesDraw = null;
        this.m_verticesYUY2 = null;
        this.m_verticesUpload = null;
        this.m_videoFrameDirectByteBuffer = null;
    }

    public boolean ConvertToYUY2(NvVideoFrame nvVideoFrame, boolean n10, boolean bl2) {
        NvAndroidSurfaceFileWriterVideoWorker nvAndroidSurfaceFileWriterVideoWorker = this;
        Object object = nvVideoFrame;
        int n11 = n10;
        int n12 = this.Prepare_ConvertToYUY2_Program();
        if (n12 == 0) {
            return false;
        }
        n12 = nvVideoFrame.imageWidth;
        int n13 = 1;
        n12 = (n12 + n13) / 2;
        int n14 = this.downloadTexture[0];
        int n15 = 3553;
        GLES20.glBindTexture((int)n15, (int)n14);
        this.checkGlError();
        float f10 = 4.979E-42f;
        int n16 = 6408;
        int n17 = nvVideoFrame.imageHeight;
        int n18 = 0;
        float f11 = 0.0f;
        int n19 = 6408;
        float f12 = 8.98E-42f;
        int n20 = 5121;
        float f13 = 7.176E-42f;
        int n21 = n12;
        int n22 = n15;
        n15 = 0;
        float f14 = 0.0f;
        GLES20.glTexImage2D((int)3553, (int)0, (int)n16, (int)n12, (int)n17, (int)0, (int)n19, (int)n20, null);
        this.checkGlError();
        int[] nArray = new int[n13];
        GLES20.glGetIntegerv((int)36006, (int[])nArray, (int)0);
        n14 = nArray[0];
        int n23 = 36160;
        if (n14 <= 0) {
            nArray = this.m_fbo;
            n14 = nArray[0];
            GLES20.glBindFramebuffer((int)n23, (int)n14);
        }
        GLES20.glActiveTexture((int)33984);
        this.checkGlError();
        n14 = ((NvVideoFrame)object).textureId[0];
        GLES20.glBindTexture((int)n22, (int)n14);
        this.checkGlError();
        n16 = 9728;
        GLES20.glTexParameteri((int)n22, (int)10241, (int)n16);
        f10 = 1.4349E-41f;
        GLES20.glTexParameteri((int)n22, (int)10240, (int)n16);
        nArray = nvAndroidSurfaceFileWriterVideoWorker.downloadTexture;
        n14 = nArray[0];
        n16 = 36064;
        GLES20.glFramebufferTexture2D((int)n23, (int)n16, (int)n22, (int)n14, (int)0);
        this.checkGlError();
        n14 = ((NvVideoFrame)object).imageHeight;
        GLES20.glViewport((int)0, (int)0, (int)n12, (int)n14);
        this.checkGlError();
        GLES20.glUseProgram((int)nvAndroidSurfaceFileWriterVideoWorker.m_convertToYUY2Program);
        n14 = nvAndroidSurfaceFileWriterVideoWorker.m_convertToYUY2Program_uniformLoc_sPerHalfTexel;
        n21 = 0x3F000000;
        n17 = ((NvVideoFrame)object).imageWidth;
        float f15 = n17;
        float f16 = 0.5f / f15;
        GLES20.glUniform1f((int)n14, (float)f16);
        n14 = (int)(nvAndroidSurfaceFileWriterVideoWorker.m_convertToYUY2Program_luma601_loaded ? 1 : 0);
        if (n11 != n14) {
            n14 = 1031831681;
            f10 = 0.0627451f;
            n21 = 1056997505;
            f16 = 0.5019608f;
            n17 = 1054925170;
            f15 = 0.43922f;
            if (n11 == 0) {
                n18 = nvAndroidSurfaceFileWriterVideoWorker.m_convertToYUY2Program_uniformLoc_coefY;
                n20 = 1058881069;
                f13 = 0.61423f;
                n15 = 1031667251;
                f14 = 0.06201f;
                GLES20.glUniform4f((int)n18, (float)0.18259f, (float)f13, (float)f14, (float)f10);
                GLES20.glUniform4f((int)nvAndroidSurfaceFileWriterVideoWorker.m_convertToYUY2Program_uniformLoc_coefU, (float)-0.10064f, (float)-0.33857f, (float)f15, (float)f16);
                n14 = nvAndroidSurfaceFileWriterVideoWorker.m_convertToYUY2Program_uniformLoc_coefV;
                n18 = -1093910051;
                f11 = -0.39894f;
                n19 = -1121652184;
                f12 = -0.04027f;
                GLES20.glUniform4f((int)n14, (float)f15, (float)f11, (float)f12, (float)f16);
            } else {
                n18 = nvAndroidSurfaceFileWriterVideoWorker.m_convertToYUY2Program_uniformLoc_coefY;
                n20 = 1057033898;
                f13 = 0.50413f;
                n15 = 1036551434;
                f14 = 0.09791f;
                GLES20.glUniform4f((int)n18, (float)0.25679f, (float)f13, (float)f14, (float)f10);
                GLES20.glUniform4f((int)nvAndroidSurfaceFileWriterVideoWorker.m_convertToYUY2Program_uniformLoc_coefU, (float)-0.14822f, (float)-0.29099f, (float)f15, (float)f16);
                n14 = nvAndroidSurfaceFileWriterVideoWorker.m_convertToYUY2Program_uniformLoc_coefV;
                n18 = -1094955271;
                f11 = -0.36779f;
                n19 = -1114486300;
                f12 = -0.07143f;
                GLES20.glUniform4f((int)n14, (float)f15, (float)f11, (float)f12, (float)f16);
            }
            nvAndroidSurfaceFileWriterVideoWorker.m_convertToYUY2Program_luma601_loaded = n11;
        }
        Object object2 = nvAndroidSurfaceFileWriterVideoWorker.m_verticesYUY2Data;
        n14 = -1082130432;
        object2[0] = f10 = -1.0f;
        n21 = 1065353216;
        object2[n13] = f16 = 1.0f;
        n17 = 0;
        f15 = 0.0f;
        object2[2] = 0.0f;
        n18 = 3;
        f11 = 4.2E-45f;
        if (bl2) {
            n19 = 0;
            f12 = 0.0f;
        } else {
            n19 = n21;
            f12 = f16;
        }
        object2[n18] = f12;
        n18 = 4;
        f11 = 5.6E-45f;
        object2[n18] = f10;
        n19 = 5;
        f12 = 7.0E-45f;
        object2[n19] = f10;
        object2[6] = 0.0f;
        n20 = 7;
        f13 = 9.8E-45f;
        if (bl2) {
            n15 = n21;
            f14 = f16;
        } else {
            n15 = 0;
            f14 = 0.0f;
        }
        object2[n20] = f14;
        object2[8] = f16;
        n20 = 9;
        f13 = 1.3E-44f;
        object2[n20] = f16;
        int n24 = ((NvVideoFrame)object).imageWidth;
        float f17 = nvAndroidSurfaceFileWriterVideoWorker.NvCalcConvertToYUY2_U_TexCoord(n24, n12);
        n12 = 10;
        Object object3 = 1.4E-44f;
        object2[n12] = f17;
        object = nvAndroidSurfaceFileWriterVideoWorker.m_verticesYUY2Data;
        n11 = 11;
        if (bl2) {
            n20 = 0;
            f13 = 0.0f;
        } else {
            n20 = n21;
            f13 = f16;
        }
        object[n11] = f13;
        object[12] = f16;
        object[13] = f10;
        object3 = object[n12];
        object[14] = object3;
        n11 = 15;
        if (!bl2) {
            n21 = 0;
            f16 = 0.0f;
        }
        object[n11] = f16;
        GLES20.glDisable((int)3042);
        GLES20.glDisable((int)2929);
        n24 = 2884;
        f17 = 4.041E-42f;
        GLES20.glDisable((int)n24);
        object = nvAndroidSurfaceFileWriterVideoWorker.m_verticesYUY2;
        if (object == null || (n24 = ((Buffer)object).capacity()) < (n11 = ((float[])(object2 = nvAndroidSurfaceFileWriterVideoWorker.m_verticesYUY2Data)).length * n18)) {
            n24 = nvAndroidSurfaceFileWriterVideoWorker.m_verticesYUY2Data.length * n18;
            object = ByteBuffer.allocateDirect(n24);
            object2 = ByteOrder.nativeOrder();
            nvAndroidSurfaceFileWriterVideoWorker.m_verticesYUY2 = object = ((ByteBuffer)object).order((ByteOrder)object2).asFloatBuffer();
        }
        object = nvAndroidSurfaceFileWriterVideoWorker.m_verticesYUY2;
        object2 = nvAndroidSurfaceFileWriterVideoWorker.m_verticesYUY2Data;
        ((FloatBuffer)object).put((float[])object2).position(0);
        n24 = nvAndroidSurfaceFileWriterVideoWorker.m_convertToYUY2Program_attrLoc_pos;
        object2 = nvAndroidSurfaceFileWriterVideoWorker.m_verticesYUY2;
        GLES20.glVertexAttribPointer((int)n24, (int)2, (int)5126, (boolean)false, (int)16, (Buffer)object2);
        object = nvAndroidSurfaceFileWriterVideoWorker.m_verticesYUY2;
        object2 = nvAndroidSurfaceFileWriterVideoWorker.m_verticesYUY2Data;
        ((FloatBuffer)object).put((float[])object2).position(2);
        n20 = nvAndroidSurfaceFileWriterVideoWorker.m_convertToYUY2Program_attrLoc_texCoord;
        object = nvAndroidSurfaceFileWriterVideoWorker.m_verticesYUY2;
        GLES20.glVertexAttribPointer((int)n20, (int)2, (int)5126, (boolean)false, (int)16, (Buffer)object);
        GLES20.glEnableVertexAttribArray((int)nvAndroidSurfaceFileWriterVideoWorker.m_convertToYUY2Program_attrLoc_pos);
        GLES20.glEnableVertexAttribArray((int)nvAndroidSurfaceFileWriterVideoWorker.m_convertToYUY2Program_attrLoc_texCoord);
        GLES20.glDrawArrays((int)n19, (int)0, (int)n18);
        this.checkGlError();
        GLES20.glDisableVertexAttribArray((int)nvAndroidSurfaceFileWriterVideoWorker.m_convertToYUY2Program_attrLoc_pos);
        GLES20.glDisableVertexAttribArray((int)nvAndroidSurfaceFileWriterVideoWorker.m_convertToYUY2Program_attrLoc_texCoord);
        GLES20.glFramebufferTexture2D((int)n23, (int)n16, (int)n22, (int)0, (int)0);
        return n13 != 0;
    }

    public void CopyInputVideoFrame(NvVideoFrame nvVideoFrame, ByteBuffer byteBuffer) {
        int n10 = this.m_videoEncoderInputPixelFormat;
        int n11 = 9;
        int n12 = 2;
        if (n10 != n12 && n10 != 0 && n10 != (n12 = 1)) {
            n11 = 0;
        }
        if (n11 == 0) {
            return;
        }
        ByteBuffer byteBuffer2 = nvVideoFrame.buffer;
        n12 = nvVideoFrame.imageWidth;
        int n13 = nvVideoFrame.imageHeight;
        NvConvertorUtils.convertPixFmt(byteBuffer2, byteBuffer, n12, n13, n11);
    }

    public NvVideoFrame DownloadGPUToHost(NvVideoFrame nvVideoFrame, boolean n10) {
        if ((n10 = this.ConvertToYUY2(nvVideoFrame, false, n10 != 0)) == 0) {
            return null;
        }
        Object object = this.m_fileWriter.m_videoRes;
        int n11 = ((NvVideoResolution)object).imageWidth;
        n10 = ((NvVideoResolution)object).imageHeight;
        n11 = n11 * n10 * 2;
        object = nvVideoFrame.buffer;
        if (object == null || (n10 = ((Buffer)object).capacity()) < n11) {
            nvVideoFrame.buffer = object = ByteBuffer.allocateDirect(n11);
        }
        object = nvVideoFrame.pitch;
        n11 = this.m_fileWriter.m_videoRes.imageWidth * 2;
        object[0] = n11;
        n10 = this.downloadTexture[0];
        this.DownloadImageFromTexture(n10, nvVideoFrame);
        return nvVideoFrame;
    }

    public void DownloadImageFromTexture(int n10, NvVideoFrame object) {
        int n11 = (((NvVideoFrame)object).imageWidth + 1) / 2;
        int n12 = 3553;
        GLES20.glBindTexture((int)n12, (int)n10);
        this.checkGlError();
        int n13 = 9728;
        GLES20.glTexParameteri((int)n12, (int)10241, (int)n13);
        GLES20.glTexParameteri((int)n12, (int)10240, (int)n13);
        n13 = 33071;
        GLES20.glTexParameteri((int)n12, (int)10242, (int)n13);
        GLES20.glTexParameteri((int)n12, (int)10243, (int)n13);
        int n14 = 36160;
        int n15 = 36064;
        GLES20.glFramebufferTexture2D((int)n14, (int)n15, (int)n12, (int)n10, (int)0);
        this.checkGlError();
        int n16 = ((NvVideoFrame)object).imageHeight;
        ByteBuffer byteBuffer = ((NvVideoFrame)object).buffer;
        StringBuilder stringBuilder = null;
        n13 = 0;
        String string2 = null;
        int n17 = 6408;
        int n18 = 5121;
        GLES20.glReadPixels((int)0, (int)0, (int)n11, (int)n16, (int)n17, (int)n18, (Buffer)byteBuffer);
        n10 = GLES20.glGetError();
        if (n10 != 0) {
            stringBuilder = new StringBuilder();
            string2 = "glReadPixels() failed! errno=";
            stringBuilder.append(string2);
            stringBuilder.append(n10);
            stringBuilder.append(", format=RGBA, width=");
            stringBuilder.append(n11);
            stringBuilder.append(", height=");
            n10 = ((NvVideoFrame)object).imageHeight;
            stringBuilder.append(n10);
            String string3 = stringBuilder.toString();
            object = TAG;
            Logger.e((String)object, string3);
        }
        GLES20.glFramebufferTexture2D((int)n14, (int)n15, (int)n12, (int)0, (int)0);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void DrainVideoEncoder(boolean var1_1) {
        block15: {
            var2_2 = true;
            if (!var1_1) ** GOTO lbl10
            try {
                var3_3 = Build.VERSION.SDK_INT;
                var4_4 = 18;
                if (var3_3 >= var4_4) {
                    var5_5 = this.m_videoEncoder;
                    var5_5.signalEndOfInputStream();
                }
                this.m_endOfInputStreamSignaled = var2_2;
lbl10:
                // 2 sources

                var3_3 = (int)this.m_dontUseEncodecCallBack;
                var6_6 = 5000L;
                if (var3_3 != 0) break block15;
                if (var1_1 == false) return;
                var8_7 = this.m_videoEncodeEosSyncEvent;
                synchronized (var8_7) {
                    var5_5 = this.m_videoEncodeEosSyncEvent;
                }
            }
            catch (Exception var8_12) {
                var8_12.printStackTrace();
                this.m_endOfInputStreamSignaled = var2_2;
                return;
            }
            {
                var5_5.wait(var6_6);
                return;
            }
        }
        var5_5 = this.m_videoEncoder;
        var5_5 = var5_5.getOutputBuffers();
        var9_13 = ((ByteBuffer[])var5_5).length;
        while (true) {
            block16: {
                this.AwaitNewImage();
                try {
                    var10_14 /* !! */  = this.m_videoEncoder;
                    var11_15 /* !! */  = this.m_videoBufferInfo;
                    var12_16 = var10_14 /* !! */ .dequeueOutputBuffer(var11_15 /* !! */ , var6_6);
                    var13_17 = -1;
                    if (var12_16 == var13_17) {
                        if (var1_1) continue;
                        return;
                    }
                    var13_17 = -3;
                    if (var12_16 != var13_17) break block16;
                    var5_5 = this.m_videoEncoder;
                }
                catch (IllegalStateException var8_11) {
                    var8_11.printStackTrace();
                    return;
                }
                var5_5 = var5_5.getOutputBuffers();
                var9_13 = ((Object)var5_5).length;
                continue;
            }
            var13_17 = -2;
            if (var12_16 == var13_17) {
                var12_16 = (int)this.m_videoEncoderFormatChanged;
                if (var12_16 != 0) {
                    var10_14 /* !! */  = "VideoWorker";
                    var11_15 /* !! */  = "Output format changed again!";
                    Logger.e((String)var10_14 /* !! */ , var11_15 /* !! */ );
                    continue;
                }
                this.m_videoEncoderFormatChanged = var2_2;
                continue;
            }
            if (var12_16 < 0) {
                var11_15 /* !! */  = "VideoWorker";
                var14_18 = new StringBuilder();
                var15_19 = "Unexpected result from dequeueOutputBuffer(), status=";
                var14_18.append(var15_19);
                var14_18.append(var12_16);
                var10_14 /* !! */  = var14_18.toString();
                Logger.e((String)var11_15 /* !! */ , var10_14 /* !! */ );
                continue;
            }
            if (var12_16 >= var9_13) {
                var8_8 = "VideoWorker";
                var5_5 = new StringBuilder();
                var16_21 = "Unexpected result from dequeueOutputBuffer(), status=";
                var5_5.append(var16_21);
                var5_5.append(var12_16);
                var5_5 = var5_5.toString();
                Logger.e(var8_8, var5_5);
                return;
            }
            var11_15 /* !! */  = var5_5[var12_16];
            if (var11_15 /* !! */  == null) {
                var8_9 = "VideoWorker";
                var5_5 = new StringBuilder();
                var16_22 = "encoderOutputBuffer ";
                var5_5.append(var16_22);
                var5_5.append(var12_16);
                var16_22 = "is null!";
                var5_5.append(var16_22);
                var5_5 = var5_5.toString();
                Logger.e(var8_9, var5_5);
                return;
            }
            var14_18 = this.m_videoBufferInfo;
            var17_20 = var14_18.flags;
            this.SendVideoData((ByteBuffer)var11_15 /* !! */ , (MediaCodec.BufferInfo)var14_18);
            var11_15 /* !! */  = this.m_videoEncoder;
            var14_18 = null;
            var11_15 /* !! */ .releaseOutputBuffer(var12_16, false);
            var12_16 = var17_20 & 4;
            if (var12_16 != 0) break;
        }
        if (var1_1 != false) return;
        var8_10 = "VideoWorker";
        var5_5 = "Reached end of stream unexpectedly!";
        Logger.e(var8_10, var5_5);
    }

    public void EncodeFrame(NvVideoFrame nvVideoFrame) {
        if (nvVideoFrame != null) {
            long l10;
            this.mTempStreamTimeForJudgeEndOfConvert = l10 = nvVideoFrame.streamTime;
        }
        this.m_fileWriter.m_pendingVideoFrame.add(nvVideoFrame);
    }

    public void FeedVideoEncoder(NvVideoFrame object, long l10) {
        block13: {
            boolean bl2;
            int n10 = (int)(this.m_videoEncoderStarted ? 1 : 0);
            if (n10 == 0) {
                return;
            }
            n10 = 1;
            int n11 = object == null ? n10 : 0;
            String string2 = TAG;
            if (n11 != 0 && (bl2 = this.m_endOfInputStreamSignaled)) {
                Logger.e(string2, "Repeated signaling input EOS!");
                return;
            }
            ByteBuffer[] byteBufferArray = this.m_videoEncoder.getOutputBuffers();
            int n12 = byteBufferArray.length;
            int n13 = 0;
            while (true) {
                StringBuilder stringBuilder;
                long l11;
                Object object2;
                int n14;
                Object object3;
                int n15;
                this.AwaitNewImage();
                if (n13 == 0 || n11 != 0 && (n15 = this.m_endOfInputStreamSignaled) == 0) {
                    object3 = new int[n10];
                    n14 = this.QueueInputVideoFrame((NvVideoFrame)object, l10, (int[])object3);
                    if (n14 != 0) {
                        n13 = n10;
                    } else {
                        n15 = object3[0];
                        if (n15 == n10) {
                            return;
                        }
                    }
                }
                if ((n15 = (object3 = (Object)this.m_videoEncoder).dequeueOutputBuffer(object2 = this.m_videoBufferInfo, l11 = 5000L)) == (n14 = -1)) {
                    if (n11 != 0 || n13 == 0) continue;
                    break block13;
                }
                n14 = -3;
                if (n15 == n14) {
                    byteBufferArray = this.m_videoEncoder.getOutputBuffers();
                    n12 = byteBufferArray.length;
                    continue;
                }
                n14 = -2;
                if (n15 == n14) continue;
                object2 = "Unexpected result from dequeueOutputBuffer(), status=";
                if (n15 < 0) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append((String)object2);
                    stringBuilder.append(n15);
                    object3 = stringBuilder.toString();
                    Logger.e(string2, object3);
                    continue;
                }
                if (n15 >= n12) {
                    object = new StringBuilder();
                    ((StringBuilder)object).append((String)object2);
                    ((StringBuilder)object).append(n15);
                    object = ((StringBuilder)object).toString();
                    Logger.e(string2, object);
                    return;
                }
                object2 = byteBufferArray[n15];
                if (object2 == null) {
                    object = new StringBuilder();
                    ((StringBuilder)object).append("encoderOutputBuffer ");
                    ((StringBuilder)object).append(n15);
                    ((StringBuilder)object).append(" is null!");
                    object = ((StringBuilder)object).toString();
                    Logger.e(string2, object);
                    return;
                }
                stringBuilder = this.m_videoBufferInfo;
                int n16 = ((MediaCodec.BufferInfo)stringBuilder).flags;
                this.SendVideoData((ByteBuffer)object2, (MediaCodec.BufferInfo)stringBuilder);
                object2 = this.m_videoEncoder;
                object2.releaseOutputBuffer(n15, false);
                n15 = n16 & 4;
                if (n15 != 0) break;
            }
            if (n11 == 0) {
                object = "Reached end of stream unexpectedly!";
                Logger.e(string2, object);
            }
        }
    }

    public void FeedVideoEncoderToSurface(int n10, long l10) {
        Object object;
        int n11;
        int n12;
        int n13 = this.m_videoEncoderStarted;
        if (n13 == 0) {
            return;
        }
        n13 = this.m_requestSyncVideoFrameInterval;
        if (n13 > 0 && (n12 = this.m_videoFrameSent % n13) == 0) {
            this.RequestSyncFrame();
        }
        n13 = this.m_videoFrameSent;
        n12 = 0;
        android.opengl.EGLSurface eGLSurface = null;
        if (n13 > 0) {
            this.DrainVideoEncoder(false);
        }
        this.AwaitNewImage();
        n13 = 1;
        Object object2 = new int[n13];
        int n14 = 36006;
        GLES20.glGetIntegerv((int)n14, (int[])object2, (int)0);
        int n15 = object2[0];
        if (n15 > 0) {
            n15 = 36160;
            GLES20.glBindFramebuffer((int)n15, (int)0);
        }
        if ((n15 = (int)(this.PrepareDrawProgram() ? 1 : 0)) == 0) {
            return;
        }
        object2 = this.m_fileWriter.m_videoRes;
        n14 = ((NvVideoResolution)object2).imageWidth;
        n15 = ((NvVideoResolution)object2).imageHeight;
        GLES20.glViewport((int)0, (int)0, (int)n14, (int)n15);
        this.checkGlError();
        GLES20.glActiveTexture((int)33984);
        this.checkGlError();
        n15 = this.m_drawProgram;
        GLES20.glUseProgram((int)n15);
        this.checkGlError();
        object2 = this.m_verticesDraw;
        n14 = 4;
        if (object2 == null || (n15 = ((Buffer)object2).capacity()) < (n11 = ((float[])(object = this.m_verticesDrawData)).length * n14)) {
            n15 = this.m_verticesDrawData.length * n14;
            object2 = ByteBuffer.allocateDirect(n15);
            object = ByteOrder.nativeOrder();
            this.m_verticesDraw = object2 = ((ByteBuffer)object2).order((ByteOrder)object).asFloatBuffer();
        }
        object2 = this.m_verticesDraw;
        object = this.m_verticesDrawData;
        ((FloatBuffer)object2).put((float[])object).position(0);
        n11 = this.m_draw_attrLoc_pos;
        FloatBuffer floatBuffer = this.m_verticesDraw;
        GLES20.glVertexAttribPointer((int)n11, (int)2, (int)5126, (boolean)false, (int)16, (Buffer)floatBuffer);
        object2 = this.m_verticesDraw;
        object = this.m_verticesDrawData;
        object2 = ((FloatBuffer)object2).put((float[])object);
        ((FloatBuffer)object2).position(2);
        int n16 = this.m_draw_attrLoc_texCoord;
        int n17 = 2;
        int n18 = 5126;
        int n19 = 16;
        FloatBuffer floatBuffer2 = this.m_verticesDraw;
        GLES20.glVertexAttribPointer((int)n16, (int)n17, (int)n18, (boolean)false, (int)n19, (Buffer)floatBuffer2);
        GLES20.glEnableVertexAttribArray((int)this.m_draw_attrLoc_pos);
        GLES20.glEnableVertexAttribArray((int)this.m_draw_attrLoc_texCoord);
        GLES20.glDisable((int)3042);
        GLES20.glDisable((int)2929);
        GLES20.glDisable((int)2884);
        n15 = 3553;
        GLES20.glBindTexture((int)n15, (int)n10);
        this.checkGlError();
        n11 = 9728;
        GLES20.glTexParameteri((int)n15, (int)10241, (int)n11);
        GLES20.glTexParameteri((int)n15, (int)10240, (int)n11);
        GLES20.glDrawArrays((int)5, (int)0, (int)n14);
        this.checkGlError();
        n10 = Build.VERSION.SDK_INT;
        n12 = 18;
        if (n10 >= n12) {
            int n20;
            CharSequence charSequence;
            long l11 = NvConvertorUtils.NvTimeToUs(l10);
            long l12 = 1000L;
            Object object3 = this.m_eglDisplay;
            eGLSurface = this.m_eglSurface;
            n10 = (int)(EGLExt.eglPresentationTimeANDROID((EGLDisplay)object3, (android.opengl.EGLSurface)eGLSurface, (long)(l11 *= l12)) ? 1 : 0);
            String string2 = TAG;
            if (n10 == 0) {
                charSequence = new StringBuilder();
                object3 = "eglPresentationTimeANDROID() failed, errno=0x";
                ((StringBuilder)charSequence).append((String)object3);
                n20 = EGL14.eglGetError();
                ((StringBuilder)charSequence).append(n20);
                charSequence = ((StringBuilder)charSequence).toString();
                Logger.e(string2, charSequence);
            }
            if ((n10 = (int)(EGL14.eglSwapBuffers((EGLDisplay)(charSequence = this.m_eglDisplay), (android.opengl.EGLSurface)(object3 = this.m_eglSurface)) ? 1 : 0)) == 0) {
                charSequence = new StringBuilder();
                object3 = "eglSwapBuffers() failed, errno=0x";
                ((StringBuilder)charSequence).append((String)object3);
                n20 = EGL14.eglGetError();
                ((StringBuilder)charSequence).append(n20);
                charSequence = ((StringBuilder)charSequence).toString();
                Logger.e(string2, charSequence);
            }
        }
        this.m_videoFrameSent = n10 = this.m_videoFrameSent + n13;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public SurfaceTexture InitSurfaceTexture() {
        int n10;
        Object object;
        String string2;
        int n11 = this.hasInitSurfaceTexture;
        if (n11 != 0) {
            return this.m_surfaceTexture;
        }
        this.PrepareEGL();
        Object object2 = this.m_textureId;
        int n12 = 1;
        Object object3 = null;
        GLES20.glGenTextures((int)n12, (int[])object2, (int)0);
        object2 = this.m_textureId;
        n11 = object2[0];
        if (n11 == 0) {
            this.checkGlError();
            return null;
        }
        object2 = this.downloadTexture;
        GLES20.glGenTextures((int)n12, (int[])object2, (int)0);
        object2 = this.downloadTexture;
        int n13 = object2[0];
        if (n13 == 0) {
            this.checkGlError();
            return null;
        }
        n11 = object2[0];
        int n14 = 3553;
        GLES20.glBindTexture((int)n14, (int)n11);
        this.checkGlError();
        int n15 = 9728;
        GLES20.glTexParameteri((int)n14, (int)10241, (int)n15);
        GLES20.glTexParameteri((int)n14, (int)10240, (int)n15);
        n15 = 33071;
        GLES20.glTexParameteri((int)n14, (int)10242, (int)n15);
        GLES20.glTexParameteri((int)n14, (int)10243, (int)n15);
        this.checkGlError();
        n11 = Build.VERSION.SDK_INT;
        int n16 = 18;
        if (n11 >= n16) {
            object2 = this.uploadTexture;
            GLES20.glGenTextures((int)n12, (int[])object2, (int)0);
            object2 = this.uploadTexture;
            n11 = object2[0];
            if (n11 == 0) {
                this.checkGlError();
                return null;
            }
        }
        object2 = new ArrayList;
        ((ArrayList)object2)();
        this.m_videoFramePool = object2;
        n11 = 0;
        object2 = null;
        while (true) {
            Object object4 = this.textureIdPoolMaxCount;
            string2 = TAG;
            if (n11 >= object4) break;
            object = new NvVideoFrame();
            this.m_videoFramePool.add(object);
            this.b = n10 = this.b + n12;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("\u5730\u5740\uff1a  ");
            int n17 = this.b;
            stringBuilder.append(n17);
            String string3 = "       ";
            stringBuilder.append(string3);
            int n18 = object.hashCode();
            stringBuilder.append(n18);
            stringBuilder.append(string3);
            string3 = object.toString();
            stringBuilder.append(string3);
            String string4 = stringBuilder.toString();
            Logger.e(string2, string4);
            int[] nArray = ((NvVideoFrame)object).textureId;
            GLES20.glGenTextures((int)n12, (int[])nArray, (int)0);
            object = ((NvVideoFrame)object).textureId;
            object4 = object[0];
            if (object4 == 0) {
                Logger.e(string2, "glGenTextures to video frame pool failed!");
                this.checkGlError();
                return null;
            }
            ++n11;
        }
        try {
            object2 = m_setOnFrameAvailableListener2;
            if (object2 != null) {
                object2 = new SurfaceTexture;
                object = this.m_textureId;
                Object object5 = object[0];
                object2((int)object5);
                this.m_surfaceTexture = (SurfaceTexture)object2;
                object = m_setOnFrameAvailableListener2;
                n10 = 2;
                Object[] objectArray = new Object[n10];
                objectArray[0] = this;
                objectArray[n12] = object3 = this.m_handler;
                ((Method)object).invoke(object2, objectArray);
            } else {
                object2 = new Semaphore;
                ((Semaphore)object2)(0);
                this.m_surfaceTextureCreationSemaphore = object2;
                object2 = this.m_handler;
                object3 = new NvAndroidSurfaceFileWriterVideoWorker$2(this);
                object2.post((Runnable)object3);
                object2 = this.m_surfaceTextureCreationSemaphore;
                ((Semaphore)object2).acquire();
                this.m_surfaceTextureCreationSemaphore = null;
                object2 = this.m_surfaceTexture;
                if (object2 == null) {
                    return null;
                }
                object2.setOnFrameAvailableListener((SurfaceTexture.OnFrameAvailableListener)this);
            }
            this.hasInitSurfaceTexture = n12;
            return this.m_surfaceTexture;
        }
        catch (Exception exception) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("");
            object3 = exception.getMessage();
            stringBuilder.append((String)object3);
            String string5 = stringBuilder.toString();
            Logger.e(string2, string5);
            exception.printStackTrace();
            return null;
        }
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public void InitVideoEncoder() {
        block107: {
            block106: {
                block105: {
                    block104: {
                        block103: {
                            block102: {
                                block101: {
                                    var1_1 = this;
                                    this.InitVideoWorker();
                                    var2_2 /* !! */  = this.m_bIsReverseConvert;
                                    if (var2_2 /* !! */  != 0) {
                                        block100: {
                                            var3_3 = this.m_fileWriter;
                                            this.m_n64VideoProcessPos = var4_6 = var3_3.m_endTime;
                                            var6_7 = 0L;
                                            cfr_temp_0 = (var4_6 -= 1000000L) - var6_7;
                                            var2_2 /* !! */  = (int)(cfr_temp_0 == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1));
                                            if (var2_2 /* !! */  < 0) {
                                                var4_6 = var6_7;
                                            }
                                            var1_1.m_n64PlayBackStartPosForReverse = var4_6;
                                            var3_3 = var1_1.m_tmpFile;
                                            if (var3_3 != null) break block100;
                                            var3_3 = "converttmp";
                                            var8_8 = ".tmp";
                                            var3_3 = File.createTempFile((String)var3_3, (String)var8_8);
                                            var1_1.m_tmpFile = var3_3;
                                            var3_3.deleteOnExit();
                                        }
                                        var8_8 = var1_1.m_tmpFile;
                                        var9_9 = "rw";
                                        var3_3 = new RandomAccessFile((File)var8_8, (String)var9_9);
                                        var1_1.m_tmpAccessFile = var3_3;
                                        try {
                                            var3_3.seek(var6_7);
                                        }
                                        catch (IOException var3_4) {
                                            var3_4.printStackTrace();
                                        }
                                        var1_1.m_tmpVideoFrame = var3_3 = new ArrayList();
                                    }
                                    if ((var3_3 = var1_1.m_videoBufferInfo) == null) {
                                        var3_3 = new MediaCodec.BufferInfo();
                                        var1_1.m_videoBufferInfo = var3_3;
                                    }
                                    if ((var2_2 /* !! */  = this.SetupVideoEncoder()) == 0) {
                                        return;
                                    }
                                    var2_2 /* !! */  = Build.VERSION.SDK_INT;
                                    var10_10 /* !! */  = 18;
                                    var9_9 = "Failed to create fbo!";
                                    var11_11 = "VideoWorker";
                                    var12_12 = 1;
                                    if (var2_2 /* !! */  < var10_10 /* !! */ ) break block106;
                                    var3_3 = var1_1.m_videoEncoderInputSurface;
                                    if (var3_3 == null) {
                                        Logger.e(var11_11, "Video encoder input surface is null!");
                                        return;
                                    }
                                    var3_3 = var1_1.m_eglDisplay;
                                    var8_8 = EGL14.EGL_NO_DISPLAY;
                                    var13_13 = 12344;
                                    if (var3_3 == var8_8) break block101;
                                    var3_3 = var1_1.m_eglContext;
                                    var8_8 = EGL14.EGL_NO_CONTEXT;
                                    if (var3_3 != var8_8) ** GOTO lbl212
                                }
                                var3_3 = EGL14.eglGetDisplay((int)0);
                                var1_1.m_eglDisplay = var3_3;
                                var8_8 = EGL14.EGL_NO_DISPLAY;
                                if (var3_3 != var8_8) break block102;
                                var3_3 = "eglGetDisplay() failed, errno=0x%d";
                                var8_8 = new Object[var12_12];
                                var14_14 = EGL14.eglGetError();
                                var9_9 = var14_14;
                                var8_8[0] = var9_9;
                                var3_3 = String.format((String)var3_3, var8_8);
                                Logger.e(var11_11, var3_3);
                                return;
                            }
                            var10_10 /* !! */  = 2;
                            var15_20 /* !! */  = new int[var10_10 /* !! */ ];
                            var2_2 /* !! */  = (int)EGL14.eglInitialize((EGLDisplay)var3_3, (int[])var15_20 /* !! */ , (int)0, (int[])var15_20 /* !! */ , (int)var12_12);
                            if (var2_2 /* !! */  != 0) break block103;
                            var3_3 = "eglInitialize() failed, errno=0x%d";
                            var8_8 = new Object[var12_12];
                            var14_15 = EGL14.eglGetError();
                            var9_9 = var14_15;
                            var8_8[0] = var9_9;
                            var3_3 = String.format((String)var3_3, var8_8);
                            Logger.e(var11_11, var3_3);
                            return;
                        }
                        var2_2 /* !! */  = 13;
                        var16_21 = new int[var2_2 /* !! */ ];
                        var2_2 /* !! */  = 12324;
                        var16_21[0] = var2_2 /* !! */ ;
                        var2_2 /* !! */  = 8;
                        var16_21[var12_12] = var2_2 /* !! */ ;
                        var17_22 = 12323;
                        var16_21[var10_10 /* !! */ ] = var17_22;
                        var18_23 = 3;
                        var16_21[var18_23] = var2_2 /* !! */ ;
                        var17_22 = 12322;
                        var19_24 = 4;
                        var16_21[var19_24] = var17_22;
                        var17_22 = 5;
                        var16_21[var17_22] = var2_2 /* !! */ ;
                        var17_22 = 6;
                        var20_25 = 12321;
                        var16_21[var17_22] = var20_25;
                        var17_22 = 7;
                        var16_21[var17_22] = var2_2 /* !! */ ;
                        var17_22 = 12352;
                        var16_21[var2_2 /* !! */ ] = var17_22;
                        var2_2 /* !! */  = 9;
                        var16_21[var2_2 /* !! */ ] = var19_24;
                        var2_2 /* !! */  = 10;
                        var17_22 = 12610;
                        var16_21[var2_2 /* !! */ ] = var17_22;
                        var2_2 /* !! */  = 11;
                        var16_21[var2_2 /* !! */ ] = var12_12;
                        var2_2 /* !! */  = 12;
                        var16_21[var2_2 /* !! */ ] = var13_13;
                        var3_3 = new int[var12_12];
                        var15_20 /* !! */  = (int[])var1_1.m_eglDisplay;
                        var19_24 = 0;
                        var21_26 = var1_1.m_eglConfigs;
                        var22_27 = var21_26.length;
                        var23_28 = var18_23;
                        var2_2 /* !! */  = (int)EGL14.eglChooseConfig((EGLDisplay)var15_20 /* !! */ , (int[])var16_21, (int)0, (android.opengl.EGLConfig[])var21_26, (int)0, (int)var22_27, (int[])var3_3, (int)0);
                        if (var2_2 /* !! */  != 0) ** GOTO lbl177
                        var3_3 = "eglChooseConfig() failed, errno=0x%d";
                        var8_8 = new Object[var12_12];
                        var14_16 = EGL14.eglGetError();
                        var9_9 = var14_16;
                        var8_8[0] = var9_9;
                        var3_3 = String.format((String)var3_3, var8_8);
                        Logger.e(var11_11, var3_3);
                        return;
lbl177:
                        // 1 sources

                        var3_3 = new int[var18_23];
                        var23_28 = 12440;
                        var3_3[0] = var23_28;
                        var3_3[var12_12] = var10_10 /* !! */ ;
                        var3_3[var10_10 /* !! */ ] = var13_13;
                        var8_8 = var1_1.m_eglDisplay;
                        var24_29 = var1_1.m_eglConfigs;
                        var24_29 = var24_29[0];
                        var15_20 /* !! */  = (int[])EGL14.EGL_NO_CONTEXT;
                        var3_3 = EGL14.eglCreateContext((EGLDisplay)var8_8, (android.opengl.EGLConfig)var24_29, (android.opengl.EGLContext)var15_20 /* !! */ , (int[])var3_3, (int)0);
                        var1_1.m_eglContext = var3_3;
                        var8_8 = EGL14.EGL_NO_CONTEXT;
                        if (var3_3 != var8_8) ** GOTO lbl212
                        var3_3 = "eglCreateContext() failed, errno=0x%d";
                        var8_8 = new Object[var12_12];
                        var14_17 = EGL14.eglGetError();
                        var9_9 = var14_17;
                        var8_8[0] = var9_9;
                        var3_3 = String.format((String)var3_3, var8_8);
                        Logger.e(var11_11, var3_3);
                        return;
lbl212:
                        // 2 sources

                        var3_3 = new int[var12_12];
                        var3_3[0] = var13_13;
                        var8_8 = var1_1.m_eglDisplay;
                        var24_29 = var1_1.m_eglConfigs;
                        var24_29 = var24_29[0];
                        var25_30 = var1_1.m_videoEncoderInputSurface;
                        var3_3 = EGL14.eglCreateWindowSurface((EGLDisplay)var8_8, (android.opengl.EGLConfig)var24_29, (Object)var25_30, (int[])var3_3, (int)0);
                        var1_1.m_eglSurface = var3_3;
                        var8_8 = EGL14.EGL_NO_SURFACE;
                        if (var3_3 != var8_8) ** GOTO lbl242
                        var3_3 = "eglCreateWindowSurface() failed, errno=0x%d";
                        var8_8 = new Object[var12_12];
                        var14_18 = EGL14.eglGetError();
                        var9_9 = var14_18;
                        var8_8[0] = var9_9;
                        var3_3 = String.format((String)var3_3, var8_8);
                        Logger.e(var11_11, var3_3);
                        return;
lbl242:
                        // 1 sources

                        var8_8 = var1_1.m_eglDisplay;
                        var24_29 = var1_1.m_eglContext;
                        var2_2 /* !! */  = (int)EGL14.eglMakeCurrent((EGLDisplay)var8_8, (android.opengl.EGLSurface)var3_3, (android.opengl.EGLSurface)var3_3, (android.opengl.EGLContext)var24_29);
                        if (var2_2 /* !! */  != 0) ** GOTO lbl262
                        var3_3 = "eglMakeCurrent() failed, errno=0x%d";
                        var8_8 = new Object[var12_12];
                        var14_19 = EGL14.eglGetError();
                        var9_9 = var14_19;
                        var8_8[0] = var9_9;
                        var3_3 = String.format((String)var3_3, var8_8);
                        Logger.e(var11_11, var3_3);
                        return;
lbl262:
                        // 1 sources

                        var2_2 /* !! */  = (int)var1_1.hasInitVideoEncoder;
                        if (var2_2 /* !! */  == 0) break block104;
                        return;
                    }
                    var3_3 = var1_1.m_fbo;
                    GLES20.glGenFramebuffers((int)var12_12, (int[])var3_3, (int)0);
                    var3_3 = var1_1.m_fbo;
                    var10_10 /* !! */  = (int)var3_3[0];
                    if (var10_10 /* !! */  != 0) break block105;
                    Logger.e(var11_11, var9_9);
                    return;
                }
                var2_2 /* !! */  = (int)var3_3[0];
                var10_10 /* !! */  = 36160;
                try {
                    GLES20.glBindFramebuffer((int)var10_10 /* !! */ , (int)var2_2 /* !! */ );
                }
                catch (Exception var3_5) {
                    var3_5.printStackTrace();
                }
                break block107;
            }
            this.PrepareEGL();
            var2_2 /* !! */  = (int)var1_1.hasInitVideoEncoder;
            if (var2_2 /* !! */  != 0) {
                return;
            }
            var3_3 = var1_1.m_fbo;
            GLES20.glGenFramebuffers((int)var12_12, (int[])var3_3, (int)0);
            var3_3 = var1_1.m_fbo;
            var10_10 /* !! */  = (int)var3_3[0];
            if (var10_10 /* !! */  == 0) {
                Logger.e(var11_11, var9_9);
                return;
            }
            var2_2 /* !! */  = (int)var3_3[0];
            var10_10 /* !! */  = 36160;
            GLES20.glBindFramebuffer((int)var10_10 /* !! */ , (int)var2_2 /* !! */ );
        }
        var1_1.hasInitVideoEncoder = var12_12;
    }

    public void InitVideoWorker() {
        long l10;
        long l11;
        boolean bl2;
        this.m_videoEncoderInputPixelFormat = -1;
        this.m_videoEncoderStarted = false;
        this.m_endOfInputStreamSignaled = false;
        this.m_videoEncoderFormatChanged = false;
        this.m_frameAvailable = false;
        this.sawTheEnd = false;
        this.firstReverseReplayback = bl2 = true;
        this.m_n64VideoProcessPos = l11 = 0L;
        this.m_n64PlayBackStartPosForReverse = l11;
        this.m_n64TimeStampStart = l10 = Long.MAX_VALUE;
        this.bProcessSegment = false;
        this.tmpSamplePts = l11;
        NvAndroidSurfaceFileWriter nvAndroidSurfaceFileWriter = this.m_fileWriter;
        int n10 = nvAndroidSurfaceFileWriter.m_is4K;
        this.m_MaxProcessCount = n10 != 0 ? (n10 = 30) : (n10 = 70);
    }

    public float NvCalcConvertToYUY2_U_TexCoord(int n10, int n11) {
        int n12 = n10 & 1;
        if (n12 == 0) {
            return 1.0f;
        }
        n12 = 1;
        if (n10 == n12) {
            return 2.0f;
        }
        float f10 = (n10 + -1) * n11;
        float f11 = n10 * (n11 -= n12);
        return f10 / f11;
    }

    public boolean PrepareDrawProgram() {
        int n10 = this.m_drawProgram;
        boolean bl2 = true;
        if (n10 != 0) {
            return bl2;
        }
        String string2 = VERTEX_SHADER_DRAW;
        this.m_drawProgram = n10 = this.createProgram(string2, FRAGMENT_SHADER_DRAW);
        if (n10 == 0) {
            return false;
        }
        this.m_draw_attrLoc_pos = n10 = GLES20.glGetAttribLocation((int)n10, (String)"posAttr");
        this.m_draw_attrLoc_texCoord = n10 = GLES20.glGetAttribLocation((int)this.m_drawProgram, (String)"texCoordAttr");
        GLES20.glUseProgram((int)this.m_drawProgram);
        GLES20.glUniform1i((int)GLES20.glGetUniformLocation((int)this.m_drawProgram, (String)"sampler"), (int)0);
        GLES20.glUseProgram((int)0);
        this.checkGlError();
        GLES20.glFlush();
        return bl2;
    }

    public void PrepareEGL() {
        Object object;
        Object object2 = this.m_context;
        Object[] objectArray = EGL10.EGL_NO_CONTEXT;
        if (object2 != objectArray) {
            return;
        }
        object2 = (EGL10)EGLContext.getEGL();
        objectArray = EGL10.EGL_DEFAULT_DISPLAY;
        javax.microedition.khronos.egl.EGLDisplay eGLDisplay = object2.eglGetDisplay((Object)objectArray);
        objectArray = EGL10.EGL_NO_DISPLAY;
        String string2 = TAG;
        int n10 = 1;
        if (eGLDisplay == objectArray) {
            objectArray = new Object[n10];
            object2 = object2.eglGetError();
            objectArray[0] = object2;
            object2 = String.format("eglGetDisplay() failed, errno=0x%d", objectArray);
            Logger.e(string2, object2);
            return;
        }
        objectArray = new int[2];
        int n11 = object2.eglInitialize(eGLDisplay, (int[])objectArray);
        if (n11 == 0) {
            objectArray = new Object[n10];
            object2 = object2.eglGetError();
            objectArray[0] = object2;
            object2 = String.format("eglInitialize() failed, errno=0x%d", objectArray);
            Logger.e(string2, object2);
            return;
        }
        int[] nArray = object = new int[13];
        int[] nArray2 = object;
        nArray[0] = 12324;
        nArray2[1] = 8;
        nArray[2] = 12323;
        nArray2[3] = 8;
        nArray[4] = 12322;
        nArray2[5] = 8;
        nArray[6] = 12321;
        nArray2[7] = 8;
        nArray[8] = 12352;
        nArray2[9] = 4;
        nArray[10] = 12339;
        nArray2[11] = 1;
        nArray2[12] = 12344;
        EGLConfig[] eGLConfigArray = new EGLConfig[n10];
        int[] nArray3 = new int[n10];
        int n12 = 1;
        objectArray = object2;
        javax.microedition.khronos.egl.EGLDisplay eGLDisplay2 = eGLDisplay;
        n11 = object2.eglChooseConfig(eGLDisplay, object, eGLConfigArray, n12, nArray3);
        if (n11 == 0) {
            objectArray = new Object[n10];
            object2 = object2.eglGetError();
            objectArray[0] = object2;
            object2 = String.format("eglChooseConfig() failed, errno=0x%d", objectArray);
            Logger.e(string2, object2);
            return;
        }
        n11 = 3;
        Object[] objectArray2 = objectArray = (Object[])new int[n11];
        objectArray[0] = 12440;
        objectArray2[1] = 2;
        objectArray2[2] = 12344;
        eGLDisplay2 = eGLConfigArray[0];
        object = EGL10.EGL_NO_CONTEXT;
        this.m_context = objectArray = object2.eglCreateContext(eGLDisplay, (EGLConfig)eGLDisplay2, (EGLContext)object, (int[])objectArray);
        eGLDisplay2 = EGL10.EGL_NO_CONTEXT;
        if (objectArray == eGLDisplay2) {
            objectArray = new Object[n10];
            object2 = object2.eglGetError();
            objectArray[0] = object2;
            object2 = String.format("eglCreateContext() failed, errno=0x%d", objectArray);
            Logger.e(string2, object2);
            return;
        }
        n11 = 5;
        Object[] objectArray3 = objectArray = (Object[])new int[n11];
        Object[] objectArray4 = objectArray;
        objectArray3[0] = 12375;
        objectArray4[1] = true;
        objectArray3[2] = 12374;
        objectArray4[3] = true;
        objectArray4[4] = 12344;
        eGLDisplay2 = eGLConfigArray[0];
        this.m_surface = objectArray = object2.eglCreatePbufferSurface(eGLDisplay, (EGLConfig)eGLDisplay2, (int[])objectArray);
        eGLDisplay2 = EGL10.EGL_NO_SURFACE;
        if (objectArray == eGLDisplay2) {
            objectArray = new Object[n10];
            object2 = object2.eglGetError();
            objectArray[0] = object2;
            object2 = String.format("eglCreateWindowSurface() failed, errno=0x%d", objectArray);
            Logger.e(string2, object2);
            return;
        }
        eGLDisplay2 = this.m_context;
        n11 = (int)(object2.eglMakeCurrent(eGLDisplay, (EGLSurface)objectArray, (EGLSurface)objectArray, (EGLContext)eGLDisplay2) ? 1 : 0);
        if (n11 == 0) {
            objectArray = new Object[n10];
            int n13 = object2.eglGetError();
            object2 = n13;
            objectArray[0] = object2;
            object2 = String.format("eglMakeCurrent() failed, errno=0x%d", objectArray);
            Logger.e(string2, object2);
        }
    }

    public boolean PrepareSurfaceTextureResizerProgram() {
        float f10;
        int n10 = this.m_program;
        boolean bl2 = true;
        if (n10 != 0) {
            return bl2;
        }
        String string2 = VERTEX_SHADER;
        this.m_program = n10 = this.createProgram(string2, FRAGMENT_SHADER);
        if (n10 == 0) {
            return false;
        }
        this.m_attrLoc_pos = n10 = GLES20.glGetAttribLocation((int)n10, (String)"posAttr");
        this.m_attrLoc_texCoord = n10 = GLES20.glGetAttribLocation((int)this.m_program, (String)"texCoordAttr");
        this.m_uniformLoc_mvpMatrix = n10 = GLES20.glGetUniformLocation((int)this.m_program, (String)"mvpMatrix");
        this.m_uniformLoc_texMatrix = n10 = GLES20.glGetUniformLocation((int)this.m_program, (String)"texMatrix");
        n10 = this.m_program;
        String string3 = "LuminosityAmount";
        this.m_uniformLuminosityAmount = n10 = GLES20.glGetUniformLocation((int)n10, (String)string3);
        GLES20.glUseProgram((int)this.m_program);
        n10 = this.m_uniformLuminosityAmount;
        int n11 = this.m_bHasInstalledLicense;
        if (n11 != 0) {
            n11 = 0;
            f10 = 0.0f;
            string3 = null;
        } else {
            n11 = 1065353216;
            f10 = 1.0f;
        }
        GLES20.glUniform1f((int)n10, (float)f10);
        GLES20.glUniform1i((int)GLES20.glGetUniformLocation((int)this.m_program, (String)"sampler"), (int)0);
        return bl2;
    }

    public boolean Prepare_ConvertToYUY2_Program() {
        int n10 = this.m_convertToYUY2Program;
        boolean bl2 = true;
        if (n10 != 0) {
            return bl2;
        }
        String string2 = VERTEX_SHADER_DRAW;
        this.m_convertToYUY2Program = n10 = this.createProgram(string2, FRAGMENT_SHADER_CONVERTTOYUY2);
        if (n10 == 0) {
            return false;
        }
        this.m_convertToYUY2Program_attrLoc_pos = n10 = GLES20.glGetAttribLocation((int)n10, (String)"posAttr");
        this.m_convertToYUY2Program_attrLoc_texCoord = n10 = GLES20.glGetAttribLocation((int)this.m_convertToYUY2Program, (String)"texCoordAttr");
        this.m_convertToYUY2Program_uniformLoc_coefY = n10 = GLES20.glGetUniformLocation((int)this.m_convertToYUY2Program, (String)"coefY");
        this.m_convertToYUY2Program_uniformLoc_coefU = n10 = GLES20.glGetUniformLocation((int)this.m_convertToYUY2Program, (String)"coefU");
        this.m_convertToYUY2Program_uniformLoc_coefV = n10 = GLES20.glGetUniformLocation((int)this.m_convertToYUY2Program, (String)"coefV");
        this.m_convertToYUY2Program_uniformLoc_sPerHalfTexel = n10 = GLES20.glGetUniformLocation((int)this.m_convertToYUY2Program, (String)"sPerHalfTexel");
        GLES20.glUseProgram((int)this.m_convertToYUY2Program);
        GLES20.glUniform4f((int)this.m_convertToYUY2Program_uniformLoc_coefY, (float)0.18259f, (float)0.61423f, (float)0.06201f, (float)0.0627451f);
        n10 = this.m_convertToYUY2Program_uniformLoc_coefU;
        float f10 = 0.43922f;
        float f11 = 0.5019608f;
        GLES20.glUniform4f((int)n10, (float)-0.10064f, (float)-0.33857f, (float)f10, (float)f11);
        GLES20.glUniform4f((int)this.m_convertToYUY2Program_uniformLoc_coefV, (float)f10, (float)-0.39894f, (float)-0.04027f, (float)f11);
        this.m_convertToYUY2Program_luma601_loaded = false;
        GLES20.glUniform1i((int)GLES20.glGetUniformLocation((int)this.m_convertToYUY2Program, (String)"sampler"), (int)0);
        GLES20.glUseProgram((int)0);
        return bl2;
    }

    public boolean Prepare_YUY2_Uploader_Program() {
        int n10 = this.m_yuy2UploaderProgram;
        boolean bl2 = true;
        if (n10 != 0) {
            return bl2;
        }
        String string2 = VERTEX_SHADER_DRAW;
        this.m_yuy2UploaderProgram = n10 = this.createProgram(string2, gFragmentShader_YUY2_Uploader);
        if (n10 == 0) {
            return false;
        }
        this.m_yuy2Uploader_attrLoc_pos = n10 = GLES20.glGetAttribLocation((int)n10, (String)"posAttr");
        this.m_yuy2Uploader_attrLoc_texCoord = n10 = GLES20.glGetAttribLocation((int)this.m_yuy2UploaderProgram, (String)"texCoordAttr");
        this.m_yuy2Uploader_uniformLoc_yOffset = n10 = GLES20.glGetUniformLocation((int)this.m_yuy2UploaderProgram, (String)"yOffset");
        this.m_yuy2Uploader_uniformLoc_Y_RGB = n10 = GLES20.glGetUniformLocation((int)this.m_yuy2UploaderProgram, (String)"coef_Y_RGB");
        this.m_yuy2Uploader_uniformLoc_V_R = n10 = GLES20.glGetUniformLocation((int)this.m_yuy2UploaderProgram, (String)"coef_V_R");
        this.m_yuy2Uploader_uniformLoc_U_G = n10 = GLES20.glGetUniformLocation((int)this.m_yuy2UploaderProgram, (String)"coef_U_G");
        this.m_yuy2Uploader_uniformLoc_V_G = n10 = GLES20.glGetUniformLocation((int)this.m_yuy2UploaderProgram, (String)"coef_V_G");
        this.m_yuy2Uploader_uniformLoc_U_B = n10 = GLES20.glGetUniformLocation((int)this.m_yuy2UploaderProgram, (String)"coef_U_B");
        GLES20.glUseProgram((int)this.m_yuy2UploaderProgram);
        GLES20.glUniform1f((int)this.m_yuy2Uploader_uniformLoc_yOffset, (float)0.0627451f);
        GLES20.glUniform1f((int)this.m_yuy2Uploader_uniformLoc_Y_RGB, (float)1.16438f);
        GLES20.glUniform1f((int)this.m_yuy2Uploader_uniformLoc_V_R, (float)1.79274f);
        GLES20.glUniform1f((int)this.m_yuy2Uploader_uniformLoc_U_G, (float)0.21325f);
        GLES20.glUniform1f((int)this.m_yuy2Uploader_uniformLoc_V_G, (float)0.53291f);
        GLES20.glUniform1f((int)this.m_yuy2Uploader_uniformLoc_U_B, (float)2.1124f);
        GLES20.glUniform1i((int)GLES20.glGetUniformLocation((int)this.m_yuy2UploaderProgram, (String)"sampler"), (int)0);
        return bl2;
    }

    public boolean QueueInputVideoFrame(NvVideoFrame object, long l10, int[] object2) {
        int n10;
        int n102;
        object2[0] = false;
        MediaCodec mediaCodec = this.m_videoEncoder;
        long l11 = 5000L;
        int n11 = mediaCodec.dequeueInputBuffer(l11);
        if (n11 == (n102 = -1)) {
            return false;
        }
        n102 = 1;
        if (object == null) {
            long l12 = NvConvertorUtils.NvTimeToUs(l10);
            this.m_videoEncoder.queueInputBuffer(n11, 0, 0, l12, 4);
            this.m_endOfInputStreamSignaled = n102;
            return n102 != 0;
        }
        int n12 = ((NvVideoFrame)object).pixelFormat;
        int n13 = 4;
        String string2 = TAG;
        if (n12 != n13) {
            Logger.e(string2, "Unexpected video frame pixel format!");
            object2[0] = n102;
            return false;
        }
        Object object3 = this.m_fileWriter.m_videoRes;
        n13 = ((NvVideoResolution)object3).imageWidth;
        n12 = ((NvVideoResolution)object3).imageHeight;
        int n14 = this.m_videoEncoderInputPixelFormat;
        int n15 = 2;
        if (n14 != n15 && n14 != 0 && n14 != n102) {
            Logger.e(string2, "Unexpected input pixel format!");
            object2[0] = n102;
            return false;
        }
        n14 = n13 * n12;
        n13 /= n15;
        n13 = n13 * (n12 /= n15) * n15;
        n15 = n14 + n13;
        object3 = this.m_inputBuffers[n11];
        if (object3 == null) {
            object = new StringBuilder();
            ((StringBuilder)object).append("encoder input buffer ");
            ((StringBuilder)object).append(n11);
            ((StringBuilder)object).append(" is null!");
            object = ((StringBuilder)object).toString();
            Logger.e(string2, object);
            object2[0] = n102;
            return false;
        }
        ((ByteBuffer)object3).clear();
        boolean n16 = ((ByteBuffer)object3).isDirect();
        if (n16) {
            this.CopyInputVideoFrame((NvVideoFrame)object, (ByteBuffer)object3);
        } else {
            object2 = this.m_videoFrameDirectByteBuffer;
            if (object2 == null) {
                this.m_videoFrameDirectByteBuffer = object2 = ByteBuffer.allocateDirect(n15);
            }
            object2 = this.m_videoFrameDirectByteBuffer;
            this.CopyInputVideoFrame((NvVideoFrame)object, (ByteBuffer)object2);
            this.m_videoFrameDirectByteBuffer.clear();
            object = this.m_videoFrameDirectByteBuffer;
            ((ByteBuffer)object3).put((ByteBuffer)object);
        }
        int n17 = this.m_requestSyncVideoFrameInterval;
        if (n17 > 0 && (n10 = this.m_videoFrameSent % n17) == 0) {
            this.RequestSyncFrame();
        }
        long l13 = NvConvertorUtils.NvTimeToUs(l10);
        this.m_videoEncoder.queueInputBuffer(n11, 0, n15, l13, 0);
        this.m_videoFrameSent = n17 = this.m_videoFrameSent + n102;
        return n102 != 0;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public int ReportInputPixelFormatSpecialCase() {
        String string2 = Build.MANUFACTURER;
        String string3 = Build.MODEL;
        String string4 = "samsung";
        int n10 = string2.compareToIgnoreCase(string4);
        int n11 = 1;
        int n12 = 21;
        if (n10 == 0) {
            string2 = "GT-I8552";
            int n13 = string3.compareToIgnoreCase(string2);
            if (n13 != 0 && (n13 = string3.compareToIgnoreCase(string2 = "SCH-I829")) != 0) {
                string2 = "GT-I9500";
                n13 = string3.compareToIgnoreCase(string2);
                if (n13 != 0) return -1;
                this.m_videoEncoderInputPixelFormat = 0;
                return n12;
            }
            this.m_videoEncoderInputPixelFormat = n11;
            return n12;
        }
        string4 = "Xiaomi";
        n10 = string2.compareToIgnoreCase(string4);
        if (n10 == 0) {
            string2 = "MI 2SC";
            int n14 = string3.compareToIgnoreCase(string2);
            if (n14 != 0) return -1;
            this.m_videoEncoderInputPixelFormat = 0;
            return n12;
        }
        string4 = "HUAWEI";
        int n15 = string2.compareToIgnoreCase(string4);
        if (n15 != 0 || (n15 = string3.compareToIgnoreCase(string2 = "HUAWEI C8813Q")) != 0) return -1;
        this.m_videoEncoderInputPixelFormat = n11;
        return n12;
    }

    public void RequestSyncFrame() {
        int n10 = this.m_videoEncoderStarted;
        if (n10 == 0) {
            return;
        }
        n10 = Build.VERSION.SDK_INT;
        int n11 = 19;
        if (n10 < n11) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("request-sync", 0);
        this.m_videoEncoder.setParameters(bundle);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void ReturnVideoFrameToPool(NvVideoFrame object) {
        Object object2 = this.m_videoFramePoolObject;
        synchronized (object2) {
            Object object3;
            Object object4 = ((NvVideoFrame)object).buffer;
            if (object4 != null) {
                object3 = false;
                object4 = null;
                ((NvVideoFrame)object).buffer = null;
            }
            if (object != null) {
                object4 = ((NvVideoFrame)object).textureId;
                StringBuilder stringBuilder = null;
                object3 = object4[0];
                if (object3 != 0) {
                    this.a = object3 = this.a + 1;
                    object4 = this.m_videoFramePool;
                    if (object4 != null) {
                        ((ArrayList)object4).add(object);
                    }
                    object4 = TAG;
                    stringBuilder = new StringBuilder();
                    String string2 = "\u5730\u5740222\uff1a  ";
                    stringBuilder.append(string2);
                    int n10 = this.a;
                    stringBuilder.append(n10);
                    string2 = "        ";
                    stringBuilder.append(string2);
                    n10 = object.hashCode();
                    stringBuilder.append(n10);
                    string2 = "       ";
                    stringBuilder.append(string2);
                    object = object.toString();
                    stringBuilder.append((String)object);
                    object = stringBuilder.toString();
                    Logger.e((String)object4, object);
                    object = this.m_videoFramePoolObject;
                    object.notifyAll();
                    return;
                }
            }
            return;
        }
    }

    public void SendVideoData(ByteBuffer byteBuffer, MediaCodec.BufferInfo object) {
        int n10 = ((MediaCodec.BufferInfo)object).flags;
        int n11 = ((MediaCodec.BufferInfo)object).size;
        if (n11 == 0) {
            return;
        }
        int n12 = ((MediaCodec.BufferInfo)object).offset;
        long l10 = ((MediaCodec.BufferInfo)object).presentationTimeUs;
        byteBuffer.position(n12);
        byteBuffer.limit(n12 += n11);
        object = ByteBuffer.allocateDirect(n11);
        ((ByteBuffer)object).put(byteBuffer);
        byteBuffer = new Message();
        NvVideoFrame nvVideoFrame = new NvVideoFrame();
        nvVideoFrame.buffer = object;
        nvVideoFrame.bufferSize = n11;
        int n13 = n10 & 2;
        if (n13 != 0) {
            nvVideoFrame.bufferFlags = 4;
            ((Message)byteBuffer).what = 0;
            ((Message)byteBuffer).obj = nvVideoFrame;
            this.m_fileWriter.m_eventHandler.sendMessage((Message)byteBuffer);
            return;
        }
        n13 = 8;
        n11 = 1;
        if ((n10 &= n11) != 0) {
            n13 = 9;
        }
        nvVideoFrame.bufferFlags = n13;
        nvVideoFrame.streamTime = l10;
        ((Message)byteBuffer).what = n11;
        ((Message)byteBuffer).obj = nvVideoFrame;
        this.m_fileWriter.m_eventHandler.sendMessage((Message)byteBuffer);
    }

    public boolean SetupVideoEncoder() {
        NvAndroidSurfaceFileWriter nvAndroidSurfaceFileWriter = this.m_fileWriter;
        NvVideoResolution nvVideoResolution = nvAndroidSurfaceFileWriter.m_videoRes;
        int n10 = nvVideoResolution.imageWidth;
        int n11 = nvVideoResolution.imageHeight;
        int n12 = nvAndroidSurfaceFileWriter.m_avgFps;
        float f10 = n12;
        String string2 = "video/avc";
        boolean bl2 = this.SetupVideoEncoderByMimeType(string2, n10, n11, f10);
        boolean bl3 = true;
        if (bl2) {
            this.m_fileWriter.m_isAVC = bl3;
            return bl3;
        }
        string2 = "video/mp4v-es";
        n12 = (int)(this.SetupVideoEncoderByMimeType(string2, n10, n11, f10) ? 1 : 0);
        n11 = 0;
        nvVideoResolution = null;
        if (n12 != 0) {
            this.m_fileWriter.m_isAVC = false;
            return bl3;
        }
        return false;
    }

    /*
     * Exception decompiling
     */
    public boolean SetupVideoEncoderByMimeType(String var1_1, int var2_2, int var3_3, float var4_4) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Started 4 blocks at once
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.getStartingBlocks(Op04StructuredStatement.java:412)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:487)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:845)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1042)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:929)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:73)
         *     at org.benf.cfr.reader.Main.main(Main.java:49)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public boolean SetupVideoEncoderInputColorFormat(String var1_1, MediaCodecInfo var2_2) {
        block8: {
            block9: {
                var3_3 = Build.VERSION.SDK_INT;
                var4_4 = true;
                var5_5 = 18;
                if (var3_3 >= var5_5) {
                    this.m_videoEncoderInputColorFormat = 2130708361;
                    return var4_4;
                }
                var3_3 = this.ReportInputPixelFormatSpecialCase();
                var5_5 = this.m_videoEncoderInputPixelFormat;
                var6_6 = 2;
                var7_7 = -1;
                var8_8 = "VideoWorker";
                if (var5_5 != var7_7) break block8;
                if ((var1_1 /* !! */  = var2_2 /* !! */ .getCapabilitiesForType((String)var1_1 /* !! */ )) == null) {
                    Logger.e(var8_8, "MediaCodecInfo.getCapabilitiesForType() failed!");
                    return false;
                }
                var2_2 /* !! */  = (MediaCodecInfo)var1_1 /* !! */ .colorFormats;
                if (var2_2 /* !! */  == null || (var9_9 = ((MediaCodecInfo)var2_2 /* !! */ ).length) <= 0) break block9;
                var2_2 /* !! */  = null;
                for (var9_9 = 0; var9_9 < (var11_11 = (var10_10 = var1_1 /* !! */ .colorFormats).length); ++var9_9) {
                    block10: {
                        var5_5 = var10_10[var9_9];
                        var11_11 = 39;
                        if (var5_5 == var11_11 || var5_5 == (var11_11 = 2130706688)) ** GOTO lbl-1000
                        switch (var5_5) {
                            default: {
                                break block10;
                            }
                            case 19: 
                            case 20: {
                                this.m_videoEncoderInputPixelFormat = var6_6;
                                break;
                            }
                            case 21: lbl-1000:
                            // 2 sources

                            {
                                this.m_videoEncoderInputPixelFormat = 0;
                            }
                        }
                        var3_3 = var5_5;
                    }
                    var5_5 = this.m_videoEncoderInputPixelFormat;
                    if (var5_5 != var7_7) break;
                }
                if ((var12_12 = this.m_videoEncoderInputPixelFormat) == var7_7) {
                    Logger.e(var8_8, "Couldn't find an acceptable color format!");
                    return false;
                }
                break block8;
            }
            Logger.e(var8_8, "Failed to get CodecCapabilities.colorFormats!");
            return false;
        }
        var1_1 /* !! */  = new Object[var6_6];
        var2_2 /* !! */  = Integer.valueOf(var3_3);
        var1_1 /* !! */ [0] = var2_2 /* !! */ ;
        var2_2 /* !! */  = Integer.valueOf(this.m_videoEncoderInputPixelFormat);
        var1_1 /* !! */ [var4_4] = var2_2 /* !! */ ;
        var1_1 /* !! */  = String.format("MediaCodec: input color format=%d, input pixel format=%d", (Object[])var1_1 /* !! */ );
        Log.d((String)var8_8, (String)var1_1 /* !! */ );
        this.m_videoEncoderInputColorFormat = var3_3;
        return var4_4;
    }

    public NvVideoFrame SurfaceTextureResizer() {
        NvAndroidSurfaceFileWriterVideoWorker nvAndroidSurfaceFileWriterVideoWorker = this;
        boolean bl2 = this.PrepareSurfaceTextureResizerProgram();
        int n10 = 0;
        if (!bl2) {
            return null;
        }
        NvVideoFrame nvVideoFrame = this.GetVideoFrameFromPool();
        if (nvVideoFrame == null) {
            return null;
        }
        n10 = 1;
        Object object = new int[n10];
        GLES20.glGetIntegerv((int)36006, (int[])object, (int)0);
        int n11 = object[0];
        int n12 = 36160;
        float f10 = 5.0671E-41f;
        if (n11 <= 0) {
            object = this.m_fbo;
            n11 = object[0];
            GLES20.glBindFramebuffer((int)n12, (int)n11);
        }
        n11 = nvVideoFrame.textureId[0];
        int n13 = 3553;
        GLES20.glBindTexture((int)n13, (int)n11);
        this.checkGlError();
        Object object2 = null;
        object = nvAndroidSurfaceFileWriterVideoWorker.m_fileWriter.m_videoRes;
        int n14 = ((NvVideoResolution)object).imageWidth;
        int n15 = ((NvVideoResolution)object).imageHeight;
        int n16 = 0;
        int n17 = 6408;
        int n18 = 5121;
        float f11 = 7.176E-42f;
        int n19 = 0;
        float f12 = 0.0f;
        GLES20.glTexImage2D((int)3553, (int)0, (int)6408, (int)n14, (int)n15, (int)0, (int)n17, (int)n18, null);
        this.checkGlError();
        n11 = 10241;
        float f13 = 1.435E-41f;
        int n20 = 9728;
        float f14 = 1.3632E-41f;
        GLES20.glTexParameteri((int)n13, (int)n11, (int)n20);
        int n21 = 10240;
        float f15 = 1.4349E-41f;
        GLES20.glTexParameteri((int)n13, (int)n21, (int)n20);
        this.checkGlError();
        Object object3 = nvVideoFrame.textureId;
        int n22 = object3[0];
        n14 = 36064;
        GLES20.glFramebufferTexture2D((int)n12, (int)n14, (int)n13, (int)n22, (int)0);
        this.checkGlError();
        n22 = GLES20.glCheckFramebufferStatus((int)n12);
        n15 = 36053;
        float f16 = 5.0521E-41f;
        if (n22 != n15) {
            this.checkGlError();
        }
        object3 = nvAndroidSurfaceFileWriterVideoWorker.m_fileWriter.m_videoRes;
        n15 = object3.imageWidth;
        n22 = object3.imageHeight;
        GLES20.glViewport((int)0, (int)0, (int)n15, (int)n22);
        this.checkGlError();
        n22 = 0;
        object3 = null;
        GLES20.glClearColor((float)0.0f, (float)0.0f, (float)0.0f, (float)0.0f);
        this.checkGlError();
        GLES20.glClear((int)16384);
        this.checkGlError();
        GLES20.glActiveTexture((int)33984);
        int[] nArray = nvAndroidSurfaceFileWriterVideoWorker.m_textureId;
        n15 = nArray[0];
        n16 = 36197;
        GLES20.glBindTexture((int)n16, (int)n15);
        this.checkGlError();
        GLES20.glTexParameteri((int)n16, (int)n11, (int)n20);
        GLES20.glTexParameteri((int)n16, (int)n21, (int)n20);
        n20 = 33071;
        GLES20.glTexParameteri((int)n16, (int)10242, (int)n20);
        GLES20.glTexParameteri((int)n16, (int)10243, (int)n20);
        GLES20.glUseProgram((int)nvAndroidSurfaceFileWriterVideoWorker.m_program);
        object = new RectF;
        Object object4 = nvAndroidSurfaceFileWriterVideoWorker.m_fileWriter.m_videoRes;
        n21 = ((NvVideoResolution)object4).imageWidth;
        n15 = -n21;
        n17 = 2;
        f16 = n15 / n17;
        n20 = ((NvVideoResolution)object4).imageHeight;
        f11 = n20 / 2;
        f15 = n21 / n17;
        n20 = -n20 / n17;
        f14 = n20;
        object(f16, f11, f15, f14);
        object2 = nvAndroidSurfaceFileWriterVideoWorker.m_fileWriter.m_videoRes;
        n15 = ((NvVideoResolution)object2).imageWidth;
        f11 = -n15 / n17;
        n21 = ((NvVideoResolution)object2).imageHeight;
        f12 = n21 / 2;
        f16 = n15 / n17;
        f15 = -n21 / n17;
        object4 = new RectF(f11, f12, f16, f15);
        object2 = nvAndroidSurfaceFileWriterVideoWorker.mMVPMatrix;
        Matrix.setIdentityM((float[])object2, (int)0);
        float[] fArray = nvAndroidSurfaceFileWriterVideoWorker.mMVPMatrix;
        f15 = ((RectF)object4).left;
        f16 = ((RectF)object4).right;
        f10 = ((RectF)object4).bottom;
        f14 = ((RectF)object4).top;
        float f17 = -1.0f;
        float f18 = 1.0f;
        Matrix.orthoM((float[])fArray, (int)0, (float)f15, (float)f16, (float)f10, (float)f14, (float)f17, (float)f18);
        n12 = nvAndroidSurfaceFileWriterVideoWorker.m_uniformLoc_mvpMatrix;
        object4 = nvAndroidSurfaceFileWriterVideoWorker.mMVPMatrix;
        GLES20.glUniformMatrix4fv((int)n12, (int)n10, (boolean)false, (float[])object4, (int)0);
        Matrix.setIdentityM((float[])nvAndroidSurfaceFileWriterVideoWorker.mSTMatrix, (int)0);
        Object object5 = nvAndroidSurfaceFileWriterVideoWorker.m_surfaceTexture;
        object4 = nvAndroidSurfaceFileWriterVideoWorker.mSTMatrix;
        object5.getTransformMatrix((float[])object4);
        n12 = nvAndroidSurfaceFileWriterVideoWorker.m_uniformLoc_texMatrix;
        object4 = nvAndroidSurfaceFileWriterVideoWorker.mSTMatrix;
        GLES20.glUniformMatrix4fv((int)n12, (int)n10, (boolean)false, (float[])object4, (int)0);
        object5 = nvAndroidSurfaceFileWriterVideoWorker.m_verticesData;
        f14 = ((RectF)object).left;
        object5[0] = (SurfaceTexture)f14;
        f15 = ((RectF)object).top;
        object5[n10] = (SurfaceTexture)f15;
        object5[n17] = (SurfaceTexture)0.0f;
        n15 = 1065353216;
        f16 = 1.0f;
        object5[3] = (SurfaceTexture)f16;
        n10 = 4;
        object5[n10] = (SurfaceTexture)f14;
        f14 = ((RectF)object).bottom;
        n18 = 5;
        f11 = 7.0E-45f;
        object5[n18] = (SurfaceTexture)f14;
        object5[6] = (SurfaceTexture)0.0f;
        object5[7] = (SurfaceTexture)0.0f;
        f13 = ((RectF)object).right;
        object5[8] = (SurfaceTexture)f13;
        n19 = 9;
        f12 = 1.3E-44f;
        object5[n19] = (SurfaceTexture)f15;
        object5[10] = (SurfaceTexture)f16;
        object5[11] = (SurfaceTexture)f16;
        n21 = 12;
        f15 = 1.7E-44f;
        object5[n21] = (SurfaceTexture)f13;
        object5[13] = (SurfaceTexture)f14;
        object5[14] = (SurfaceTexture)f16;
        object5[15] = (SurfaceTexture)0.0f;
        GLES20.glDisable((int)3042);
        GLES20.glDisable((int)2929);
        n11 = 2884;
        f13 = 4.041E-42f;
        GLES20.glDisable((int)n11);
        object = nvAndroidSurfaceFileWriterVideoWorker.m_vertices;
        if (object == null || (n11 = ((Buffer)object).capacity()) < (n12 = ((SurfaceTexture)(object5 = (Object)nvAndroidSurfaceFileWriterVideoWorker.m_verticesData)).length * n10)) {
            n11 = nvAndroidSurfaceFileWriterVideoWorker.m_verticesData.length * n10;
            object = ByteBuffer.allocateDirect(n11);
            object5 = ByteOrder.nativeOrder();
            nvAndroidSurfaceFileWriterVideoWorker.m_vertices = object = ((ByteBuffer)object).order((ByteOrder)object5).asFloatBuffer();
        }
        object = nvAndroidSurfaceFileWriterVideoWorker.m_vertices;
        object5 = nvAndroidSurfaceFileWriterVideoWorker.m_verticesData;
        ((FloatBuffer)object).put((float[])object5).position(0);
        n19 = nvAndroidSurfaceFileWriterVideoWorker.m_attrLoc_pos;
        int n23 = 2;
        int n24 = 5126;
        int n25 = 16;
        object = nvAndroidSurfaceFileWriterVideoWorker.m_vertices;
        GLES20.glVertexAttribPointer((int)n19, (int)n23, (int)n24, (boolean)false, (int)n25, (Buffer)object);
        object = nvAndroidSurfaceFileWriterVideoWorker.m_vertices;
        object5 = nvAndroidSurfaceFileWriterVideoWorker.m_verticesData;
        ((FloatBuffer)object).put((float[])object5).position(n17);
        n19 = nvAndroidSurfaceFileWriterVideoWorker.m_attrLoc_texCoord;
        object = nvAndroidSurfaceFileWriterVideoWorker.m_vertices;
        GLES20.glVertexAttribPointer((int)n19, (int)n23, (int)n24, (boolean)false, (int)n25, (Buffer)object);
        GLES20.glEnableVertexAttribArray((int)nvAndroidSurfaceFileWriterVideoWorker.m_attrLoc_pos);
        GLES20.glEnableVertexAttribArray((int)nvAndroidSurfaceFileWriterVideoWorker.m_attrLoc_texCoord);
        GLES20.glDrawArrays((int)n18, (int)0, (int)n10);
        this.checkGlError();
        GLES20.glDisableVertexAttribArray((int)nvAndroidSurfaceFileWriterVideoWorker.m_attrLoc_pos);
        GLES20.glDisableVertexAttribArray((int)nvAndroidSurfaceFileWriterVideoWorker.m_attrLoc_texCoord);
        GLES20.glBindTexture((int)n16, (int)0);
        GLES20.glFramebufferTexture2D((int)36160, (int)n14, (int)n13, (int)0, (int)0);
        return nvVideoFrame;
    }

    public NvVideoFrame UpladFrameToGPU_YUY2(NvVideoFrame nvVideoFrame) {
        int[] nArray;
        NvAndroidSurfaceFileWriterVideoWorker nvAndroidSurfaceFileWriterVideoWorker = this;
        NvVideoFrame nvVideoFrame2 = nvVideoFrame;
        int n10 = this.Prepare_YUY2_Uploader_Program();
        int n11 = 0;
        Object object = null;
        if (n10 == 0) {
            return null;
        }
        n10 = nvVideoFrame.imageWidth;
        int n12 = 1;
        n10 += n12;
        int n13 = 2;
        n10 /= n13;
        int n14 = this.initUploadTextId;
        int n15 = 10243;
        int n16 = 10242;
        int n17 = 10240;
        int n18 = 10241;
        int n19 = 33071;
        int n20 = 9728;
        int n21 = 3553;
        int n22 = 0;
        if (n14 == 0) {
            nArray = this.uploadTexture;
            n14 = nArray[0];
            GLES20.glBindTexture((int)n21, (int)n14);
            this.checkGlError();
            GLES20.glTexParameteri((int)n21, (int)n18, (int)n20);
            GLES20.glTexParameteri((int)n21, (int)n17, (int)n20);
            GLES20.glTexParameteri((int)n21, (int)n16, (int)n19);
            GLES20.glTexParameteri((int)n21, (int)n15, (int)n19);
            this.checkGlError();
            this.initUploadTextId = n12;
        } else {
            nArray = this.uploadTexture;
            n14 = nArray[0];
            GLES20.glBindTexture((int)n21, (int)n14);
            this.checkGlError();
        }
        int n23 = 0;
        Object object2 = null;
        int n24 = 6408;
        n20 = nvVideoFrame2.imageHeight;
        int n25 = 6408;
        int n26 = 5121;
        n13 = 0;
        n22 = n24;
        n15 = n21;
        n21 = n10;
        n19 = 0;
        n18 = n25;
        n17 = n26;
        n16 = 0;
        GLES20.glTexImage2D((int)3553, (int)0, (int)n24, (int)n10, (int)n20, (int)0, (int)n25, (int)n26, null);
        this.checkGlError();
        nArray = nvVideoFrame2.textureId;
        n14 = nArray[0];
        if (n14 == 0) {
            return null;
        }
        object = new int[n12];
        GLES20.glGetIntegerv((int)36006, (int[])object, (int)0);
        n11 = object[0];
        n12 = 36160;
        if (n11 <= 0) {
            object = nvAndroidSurfaceFileWriterVideoWorker.m_fbo;
            n11 = object[0];
            GLES20.glBindFramebuffer((int)n12, (int)n11);
        }
        n11 = nvVideoFrame2.textureId[0];
        GLES20.glBindTexture((int)n15, (int)n11);
        this.checkGlError();
        n14 = 9728;
        GLES20.glTexParameteri((int)n15, (int)10241, (int)n14);
        GLES20.glTexParameteri((int)n15, (int)10240, (int)n14);
        n14 = 33071;
        GLES20.glTexParameteri((int)n15, (int)10242, (int)n14);
        GLES20.glTexParameteri((int)n15, (int)10243, (int)n14);
        int n27 = 3553;
        int n28 = 6408;
        n11 = nvVideoFrame2.imageWidth;
        n14 = nvVideoFrame2.imageHeight;
        int n29 = 6408;
        int n30 = 5121;
        GLES20.glTexImage2D((int)n27, (int)0, (int)n28, (int)n11, (int)n14, (int)0, (int)n29, (int)n30, null);
        this.checkGlError();
        n11 = nvVideoFrame2.textureId[0];
        n16 = 36064;
        GLES20.glFramebufferTexture2D((int)n12, (int)n16, (int)n15, (int)n11, (int)0);
        this.checkGlError();
        GLES20.glClear((int)16384);
        GLES20.glActiveTexture((int)33984);
        this.checkGlError();
        n11 = nvAndroidSurfaceFileWriterVideoWorker.uploadTexture[0];
        GLES20.glBindTexture((int)n15, (int)n11);
        this.checkGlError();
        n23 = 0;
        object2 = null;
        n22 = 0;
        n21 = 0;
        n19 = nvVideoFrame2.imageHeight;
        n18 = 6408;
        n17 = 5121;
        object = nvVideoFrame2.buffer;
        n20 = n10;
        n10 = n16;
        GLES20.glTexSubImage2D((int)3553, (int)0, (int)0, (int)0, (int)n20, (int)n19, (int)n18, (int)n17, (Buffer)object);
        this.checkGlError();
        n11 = nvVideoFrame2.imageWidth;
        n14 = nvVideoFrame2.imageHeight;
        GLES20.glViewport((int)0, (int)0, (int)n11, (int)n14);
        this.checkGlError();
        GLES20.glUseProgram((int)nvAndroidSurfaceFileWriterVideoWorker.m_yuy2UploaderProgram);
        GLES20.glDisable((int)3042);
        GLES20.glDisable((int)2929);
        n11 = 2884;
        GLES20.glDisable((int)n11);
        object = nvAndroidSurfaceFileWriterVideoWorker.m_verticesUpload;
        n14 = 4;
        if (object == null || (n11 = ((Buffer)object).capacity()) < (n23 = ((float[])(object2 = nvAndroidSurfaceFileWriterVideoWorker.m_verticesUploadData)).length * n14)) {
            n11 = nvAndroidSurfaceFileWriterVideoWorker.m_verticesUploadData.length * n14;
            object = ByteBuffer.allocateDirect(n11);
            object2 = ByteOrder.nativeOrder();
            nvAndroidSurfaceFileWriterVideoWorker.m_verticesUpload = object = ((ByteBuffer)object).order((ByteOrder)object2).asFloatBuffer();
        }
        object = nvAndroidSurfaceFileWriterVideoWorker.m_verticesUpload;
        object2 = nvAndroidSurfaceFileWriterVideoWorker.m_verticesUploadData;
        ((FloatBuffer)object).put((float[])object2).position(0);
        n23 = nvAndroidSurfaceFileWriterVideoWorker.m_yuy2Uploader_attrLoc_pos;
        FloatBuffer floatBuffer = nvAndroidSurfaceFileWriterVideoWorker.m_verticesUpload;
        GLES20.glVertexAttribPointer((int)n23, (int)2, (int)5126, (boolean)false, (int)16, (Buffer)floatBuffer);
        object = nvAndroidSurfaceFileWriterVideoWorker.m_verticesUpload;
        object2 = nvAndroidSurfaceFileWriterVideoWorker.m_verticesUploadData;
        ((FloatBuffer)object).put((float[])object2).position(2);
        n22 = nvAndroidSurfaceFileWriterVideoWorker.m_yuy2Uploader_attrLoc_texCoord;
        FloatBuffer floatBuffer2 = nvAndroidSurfaceFileWriterVideoWorker.m_verticesUpload;
        GLES20.glVertexAttribPointer((int)n22, (int)2, (int)5126, (boolean)false, (int)16, (Buffer)floatBuffer2);
        GLES20.glEnableVertexAttribArray((int)nvAndroidSurfaceFileWriterVideoWorker.m_yuy2Uploader_attrLoc_pos);
        GLES20.glEnableVertexAttribArray((int)nvAndroidSurfaceFileWriterVideoWorker.m_yuy2Uploader_attrLoc_texCoord);
        GLES20.glDrawArrays((int)5, (int)0, (int)n14);
        this.checkGlError();
        GLES20.glDisableVertexAttribArray((int)nvAndroidSurfaceFileWriterVideoWorker.m_yuy2Uploader_attrLoc_pos);
        GLES20.glDisableVertexAttribArray((int)nvAndroidSurfaceFileWriterVideoWorker.m_yuy2Uploader_attrLoc_texCoord);
        GLES20.glFramebufferTexture2D((int)n12, (int)n10, (int)n15, (int)0, (int)0);
        return nvVideoFrame2;
    }

    public void checkGlError() {
        int n10 = GLES20.glGetError();
        if (n10 != 0) {
            Object object;
            int n11 = 1;
            Object object2 = new Object[n11];
            object2[0] = object = Integer.valueOf(n10);
            object = String.format("GL error: 0x%d", object2);
            object2 = TAG;
            Logger.e((String)object2, object);
        }
    }

    public int createProgram(String object, String string2) {
        int n10 = GLES20.glCreateShader((int)35633);
        this.checkGlError();
        if (n10 == 0) {
            return 0;
        }
        int n11 = GLES20.glCreateShader((int)35632);
        this.checkGlError();
        if (n11 == 0) {
            GLES20.glDeleteShader((int)n10);
            return 0;
        }
        GLES20.glShaderSource((int)n10, (String)object);
        GLES20.glCompileShader((int)n10);
        Object object2 = 1;
        Object object3 = new int[object2];
        int n12 = 35713;
        GLES20.glGetShaderiv((int)n10, (int)n12, (int[])object3, (int)0);
        int n13 = object3[0];
        String string3 = TAG;
        if (n13 == 0) {
            object = new StringBuilder();
            ((StringBuilder)object).append("vertex glCompileShader() failed! ");
            string2 = GLES20.glGetShaderInfoLog((int)n10);
            ((StringBuilder)object).append(string2);
            object = ((StringBuilder)object).toString();
            Logger.e(string3, object);
            GLES20.glDeleteShader((int)n10);
            GLES20.glDeleteShader((int)n11);
            return 0;
        }
        GLES20.glShaderSource((int)n11, (String)string2);
        GLES20.glCompileShader((int)n11);
        GLES20.glGetShaderiv((int)n11, (int)n12, (int[])object3, (int)0);
        int n14 = object3[0];
        if (n14 == 0) {
            object = new StringBuilder();
            ((StringBuilder)object).append("fragment glCompileShader() failed! ");
            string2 = GLES20.glGetShaderInfoLog((int)n11);
            ((StringBuilder)object).append(string2);
            object = ((StringBuilder)object).toString();
            Logger.e(string3, object);
            GLES20.glDeleteShader((int)n10);
            GLES20.glDeleteShader((int)n11);
            return 0;
        }
        n14 = GLES20.glCreateProgram();
        this.checkGlError();
        if (n14 == 0) {
            Logger.e(string3, "glCreateProgram() failed!");
            GLES20.glDeleteShader((int)n10);
            GLES20.glDeleteShader((int)n11);
            return 0;
        }
        GLES20.glAttachShader((int)n14, (int)n10);
        this.checkGlError();
        GLES20.glAttachShader((int)n14, (int)n11);
        this.checkGlError();
        GLES20.glLinkProgram((int)n14);
        object = new int[object2];
        int n15 = 35714;
        GLES20.glGetProgramiv((int)n14, (int)n15, (int[])object, (int)0);
        object2 = object[0];
        if (object2 == 0) {
            object = new StringBuilder();
            ((StringBuilder)object).append("glLinkProgram() failed! ");
            object3 = GLES20.glGetProgramInfoLog((int)n14);
            ((StringBuilder)object).append((String)object3);
            object = ((StringBuilder)object).toString();
            Logger.e(string3, object);
            GLES20.glDeleteShader((int)n10);
            GLES20.glDeleteShader((int)n11);
            GLES20.glDeleteProgram((int)n14);
            return 0;
        }
        GLES20.glDeleteShader((int)n10);
        GLES20.glDeleteShader((int)n11);
        return n14;
    }

    public long getPlayBackStartPosForReverse() {
        return this.m_n64PlayBackStartPosForReverse;
    }

    public long getmTempStreamTimeForJudgeEndOfConvert() {
        return this.mTempStreamTimeForJudgeEndOfConvert;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onFrameAvailable(SurfaceTexture object) {
        object = this.m_frameSyncObject;
        synchronized (object) {
            Object object2;
            boolean bl2 = this.m_frameAvailable;
            if (bl2) {
                object2 = TAG;
                String string2 = "m_frameAvailable already set, frame could be dropped!";
                Logger.e((String)object2, string2);
            }
            this.m_frameAvailable = bl2 = true;
            object2 = this.m_frameSyncObject;
            object2.notifyAll();
            return;
        }
    }

    public void setLooper(Looper looper) {
        NvAndroidSurfaceFileWriterVideoWorker$1 nvAndroidSurfaceFileWriterVideoWorker$1 = new NvAndroidSurfaceFileWriterVideoWorker$1(this, looper);
        this.m_eventHandler = nvAndroidSurfaceFileWriterVideoWorker$1;
    }
}

