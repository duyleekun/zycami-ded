/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.graphics.SurfaceTexture
 *  android.media.MediaFormat
 *  android.opengl.GLES20
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Handler
 *  android.os.HandlerThread
 *  android.os.Looper
 *  android.util.Log
 *  javax.microedition.khronos.egl.EGL10
 *  javax.microedition.khronos.egl.EGLConfig
 *  javax.microedition.khronos.egl.EGLContext
 *  javax.microedition.khronos.egl.EGLDisplay
 *  javax.microedition.khronos.egl.EGLSurface
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.meicam.nvconvertorlib;

import android.app.Activity;
import android.graphics.SurfaceTexture;
import android.media.MediaFormat;
import android.opengl.GLES20;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Log;
import com.meicam.nvconvertorlib.Logger;
import com.meicam.nvconvertorlib.NvAndroidAudioFileReader;
import com.meicam.nvconvertorlib.NvAndroidSurfaceFileWriter;
import com.meicam.nvconvertorlib.NvAndroidSurfaceFileWriter$OnReleaseEncoderListener;
import com.meicam.nvconvertorlib.NvAndroidSurfaceVideoFileReader;
import com.meicam.nvconvertorlib.NvConvertorUtils;
import com.meicam.nvconvertorlib.NvConvertorUtils$NvMediaFileInfo;
import com.meicam.nvconvertorlib.NvFileConvertConfig;
import com.meicam.nvconvertorlib.NvFileConvertProcess$1;
import com.meicam.nvconvertorlib.NvFileConvertProcess$2;
import com.meicam.nvconvertorlib.NvFileConvertProcess$3;
import com.meicam.nvconvertorlib.NvFileConvertProcess$4;
import com.meicam.nvconvertorlib.NvFileConvertProcess$5;
import com.meicam.nvconvertorlib.NvFileConvertProcess$NvFileConvertProcessNotify;
import com.meicam.nvconvertorlib.NvFileConvertProcess$NvFileConvertProcessNotify2;
import com.meicam.nvconvertorlib.NvFileConvertProcess$NvFileConvertProgressNotify;
import com.meicam.nvconvertorlib.NvSampleBufferReturnCallBack;
import com.meicam.nvconvertorlib.NvVideoFrame;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import org.json.JSONException;
import org.json.JSONObject;

public class NvFileConvertProcess
implements NvSampleBufferReturnCallBack {
    private static final int EGL_CONTEXT_CLIENT_VERSION = 12440;
    private static final int EGL_OPENGL_ES2_BIT = 4;
    private static final int EGL_RECORDABLE_ANDROID = 12610;
    public static final int MSG_CONVERT_COMPLETE_ALL = 3;
    public static final int MSG_CONVERT_FINISH = 0;
    public static final int MSG_CONVERT_PROGRESS = 1;
    public static final int MSG_CONVERT_REVERSE_CONTINUE = 2;
    public static final int NV_E_CONVERTOR_IS_OPENED = 249;
    public static final int NV_E_CONVERTOR_IS_STARTED = 248;
    public static final int NV_E_CONVERT_TOO_LATER = 246;
    public static final int NV_E_FAIL = 255;
    public static final int NV_E_FILE_EOF = 254;
    public static final int NV_E_INVALID_PARAMETER = 252;
    public static final int NV_E_INVALID_POINTER = 253;
    public static final int NV_E_NOT_INITIALIZED = 251;
    public static final int NV_E_NO_VIDEO_STREAM = 250;
    public static final int NV_E_OPEN_FAILED = 247;
    public static final int NV_M_SEGMET_COMPLETE = 1;
    public static final int NV_NOERROR = 0;
    private static final String TAG = "NvFileConvertProcess";
    private static boolean mLicenseInstalled = false;
    public Thread audioprcoess;
    private boolean mFileConvertSuccess;
    private int m_MaxProcessCount = 70;
    private Object m_audioBufferObject;
    private NvAndroidAudioFileReader m_audioReader;
    private Object m_audiowrtieObject;
    public boolean m_bHasAudioOutput;
    private boolean m_bIsOpened;
    private boolean m_bIsReverseConvert;
    private boolean m_bIsStarted;
    private boolean m_bStopping;
    private boolean m_bWritingComplete;
    private Handler m_backgroundHandler;
    private HandlerThread m_backgroundThread;
    public NvFileConvertProcess$NvFileConvertProcessNotify m_completeNotify;
    public NvFileConvertProcess$NvFileConvertProcessNotify2 m_completeNotify2;
    private NvAndroidSurfaceFileWriter m_fileWriter;
    private Object m_finishEvent;
    private boolean m_hasCheckingGPUInfo;
    private boolean m_ifReaderProcessThreadOver;
    private boolean m_isAdreno;
    private int m_maxWebPFrameCount = 100;
    public Handler m_messageHandler;
    private long m_n64ConvertFrom;
    private long m_n64ConvertTo;
    private long m_n64Progress;
    private int m_nDstHeight;
    private int m_nDstWidth;
    private int m_nSrcHeight;
    private int m_nSrcWidth;
    private String m_outputFilePath;
    private ArrayList m_pendingAudioSamples;
    public NvFileConvertProcess$NvFileConvertProgressNotify m_progressNotify;
    public Object m_reverseContinue;
    private long m_reverseContinuePos;
    private long m_reverseEndPos;
    private Object m_safeCloseObject;
    private NvAndroidSurfaceVideoFileReader m_videoReader;
    private int m_videoResolution;
    private ArrayList m_writingAudioSamples;
    public Thread prcoess;
    public Thread writerprcoess;

    public NvFileConvertProcess(NvFileConvertProcess$NvFileConvertProcessNotify2 nvFileConvertProcess$NvFileConvertProcessNotify2) {
        boolean bl2;
        Object object;
        long l10;
        this.m_n64ConvertFrom = l10 = 0L;
        this.m_n64ConvertTo = l10;
        this.m_nSrcWidth = 0;
        this.m_nSrcHeight = 0;
        this.m_nDstWidth = 0;
        this.m_nDstHeight = 0;
        this.m_videoResolution = 4;
        this.m_bIsOpened = false;
        this.m_bIsStarted = false;
        this.m_bIsReverseConvert = false;
        this.m_bStopping = false;
        this.m_bWritingComplete = false;
        this.m_n64Progress = l10;
        this.m_finishEvent = object = new Object();
        this.m_safeCloseObject = object = new Object();
        this.m_audioBufferObject = object = new Object();
        this.m_audiowrtieObject = object = new Object();
        this.m_reverseContinue = object = new Object();
        this.m_reverseContinuePos = l10;
        this.m_isAdreno = false;
        this.m_hasCheckingGPUInfo = false;
        this.mFileConvertSuccess = false;
        this.m_ifReaderProcessThreadOver = bl2 = true;
        this.m_completeNotify = null;
        this.m_completeNotify2 = null;
        this.m_progressNotify = null;
        Looper looper = Looper.getMainLooper();
        NvFileConvertProcess$1 nvFileConvertProcess$1 = new NvFileConvertProcess$1(this, looper);
        this.m_messageHandler = nvFileConvertProcess$1;
        this.m_bHasAudioOutput = bl2;
        this.m_completeNotify2 = nvFileConvertProcess$NvFileConvertProcessNotify2;
        this.InitBackgroundHandler();
    }

    public NvFileConvertProcess(NvFileConvertProcess$NvFileConvertProcessNotify nvFileConvertProcess$NvFileConvertProcessNotify) {
        boolean bl2;
        Object object;
        long l10;
        this.m_n64ConvertFrom = l10 = 0L;
        this.m_n64ConvertTo = l10;
        this.m_nSrcWidth = 0;
        this.m_nSrcHeight = 0;
        this.m_nDstWidth = 0;
        this.m_nDstHeight = 0;
        this.m_videoResolution = 4;
        this.m_bIsOpened = false;
        this.m_bIsStarted = false;
        this.m_bIsReverseConvert = false;
        this.m_bStopping = false;
        this.m_bWritingComplete = false;
        this.m_n64Progress = l10;
        this.m_finishEvent = object = new Object();
        this.m_safeCloseObject = object = new Object();
        this.m_audioBufferObject = object = new Object();
        this.m_audiowrtieObject = object = new Object();
        this.m_reverseContinue = object = new Object();
        this.m_reverseContinuePos = l10;
        this.m_isAdreno = false;
        this.m_hasCheckingGPUInfo = false;
        this.mFileConvertSuccess = false;
        this.m_ifReaderProcessThreadOver = bl2 = true;
        this.m_completeNotify = null;
        this.m_completeNotify2 = null;
        this.m_progressNotify = null;
        Looper looper = Looper.getMainLooper();
        NvFileConvertProcess$1 nvFileConvertProcess$1 = new NvFileConvertProcess$1(this, looper);
        this.m_messageHandler = nvFileConvertProcess$1;
        this.m_bHasAudioOutput = bl2;
        this.m_completeNotify = nvFileConvertProcess$NvFileConvertProcessNotify;
        this.InitBackgroundHandler();
    }

    private void CalcVideoSize() {
        int n10;
        int n11 = this.m_videoResolution;
        if (n11 != 0) {
            n10 = 1;
            if (n11 != n10) {
                n10 = 2;
                if (n11 != n10) {
                    n10 = 3;
                    if (n11 == n10) {
                        this.m_nDstHeight = n11 = 1080;
                    }
                } else {
                    this.m_nDstHeight = n11 = 720;
                }
            } else {
                this.m_nDstHeight = n11 = 480;
            }
        } else {
            this.m_nDstHeight = n11 = 352;
        }
        n11 = this.m_nDstHeight;
        n10 = this.m_nSrcHeight;
        if (n11 != n10) {
            int n12 = 32;
            int n13 = this.m_nSrcWidth * n11 / n10;
            double d10 = n13;
            double d11 = 0.5;
            this.m_nDstWidth = n11 = NvConvertorUtils.NvUpAlignP02((int)(d10 += d11), n12);
            n10 = 1920;
            this.m_nDstWidth = n11 = Math.min(n11, n10);
        } else {
            this.m_nDstWidth = n11 = this.m_nSrcWidth;
        }
    }

    private static boolean CheckLicense(Activity object, String object2) {
        int n10;
        block24: {
            int n11;
            int n12;
            JSONObject jSONObject;
            block23: {
                String string2;
                block22: {
                    jSONObject = new JSONObject((String)object2);
                    object2 = "type";
                    object2 = jSONObject.get((String)object2);
                    object2 = object2.toString();
                    string2 = "meishesdk";
                    n12 = ((String)object2).compareTo(string2);
                    if (n12 == 0) break block22;
                    return false;
                }
                object = object.getApplicationContext();
                object = object.getPackageName();
                object2 = "allowedAppIds";
                object2 = jSONObject.getJSONArray((String)object2);
                int n13 = 0;
                string2 = null;
                while (true) {
                    int n14 = object2.length();
                    n10 = 1;
                    if (n13 >= n14) break;
                    String string3 = object2.getString(n13);
                    n14 = (int)(string3.equals(object) ? 1 : 0);
                    if (n14 != 0) {
                        n11 = n10;
                        break block23;
                    }
                    ++n13;
                    continue;
                    break;
                }
                n11 = 0;
                object = null;
            }
            if (n11 == 0) {
                return false;
            }
            object = "profile";
            try {
                object = jSONObject.get((String)object);
            }
            catch (JSONException jSONException) {
                jSONException.printStackTrace();
                return false;
            }
            object = object.toString();
            object2 = "capture";
            n12 = ((String)object).compareTo((String)object2);
            if (n12 == 0) break block24;
            object2 = "liveStream";
            n12 = ((String)object).compareTo((String)object2);
            if (n12 == 0) break block24;
            object2 = "editBasic";
            n12 = ((String)object).compareTo((String)object2);
            if (n12 == 0) break block24;
            object2 = "edit";
            n12 = ((String)object).compareTo((String)object2);
            if (n12 == 0) break block24;
            object2 = "editPro";
            n11 = ((String)object).compareTo((String)object2);
            if (n11 == 0) break block24;
            return false;
        }
        mLicenseInstalled = n10;
        return n10 != 0;
    }

    private void CloseBackgroundHandler() {
        Handler handler = this.m_backgroundHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.m_backgroundHandler = null;
        }
        if ((handler = this.m_backgroundThread) != null) {
            int n10 = handler.isAlive();
            if (n10 != 0) {
                n10 = Build.VERSION.SDK_INT;
                int n11 = 18;
                if (n10 >= n11) {
                    handler = this.m_backgroundThread;
                    handler.quitSafely();
                }
                handler = this.m_backgroundThread;
                try {
                    handler.join();
                }
                catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
            }
            this.m_backgroundThread = null;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void CompleteAll() {
        Object object;
        boolean bl2;
        Object object2;
        int n10;
        int n11;
        Object var1_1 = null;
        Object object3 = null;
        for (n11 = 0; n11 < (n10 = 100); ++n11) {
            object2 = this.m_safeCloseObject;
            synchronized (object2) {
                bl2 = this.m_ifReaderProcessThreadOver;
                if (!bl2) {
                    try {
                        object = this.m_safeCloseObject;
                        long l10 = 20;
                        object.wait(l10);
                    }
                    catch (InterruptedException interruptedException) {
                        interruptedException.printStackTrace();
                    }
                    object = this.m_videoReader;
                    if (object != null && (object = ((NvAndroidSurfaceVideoFileReader)object).m_frameSyncObject) != null) {
                        synchronized (object) {
                            Object object4 = this.m_videoReader;
                            if (object4 != null && (object4 = ((NvAndroidSurfaceVideoFileReader)object4).m_frameSyncObject) != null) {
                                object4.notifyAll();
                            }
                        }
                    }
                    continue;
                }
                break;
            }
        }
        n11 = 1;
        this.m_bStopping = n11;
        object2 = this.m_videoReader;
        if (object2 != null) {
            ((NvAndroidSurfaceVideoFileReader)object2).CloseFile();
        }
        try {
            object2 = this.m_fileWriter;
            if (object2 != null) {
                this.mFileConvertSuccess = bl2 = ((NvAndroidSurfaceFileWriter)object2).isSuccess;
                ((NvAndroidSurfaceFileWriter)object2).FlushWriter();
            }
        }
        catch (Exception exception) {}
        if ((object2 = this.m_audioReader) != null) {
            ((NvAndroidAudioFileReader)object2).CloseFile();
        }
        if ((object2 = this.m_pendingAudioSamples) != null) {
            ((ArrayList)object2).clear();
        }
        n10 = 0;
        object2 = null;
        this.m_pendingAudioSamples = null;
        object = this.m_writingAudioSamples;
        if (object != null) {
            ((ArrayList)object).clear();
        }
        this.m_writingAudioSamples = null;
        this.m_bIsStarted = false;
        object2 = this.m_finishEvent;
        synchronized (object2) {
            this.m_bWritingComplete = n11;
            object3 = this.m_finishEvent;
            object3.notifyAll();
        }
        object3 = this.m_completeNotify;
        if (object3 != null) {
            object2 = this.m_outputFilePath;
            object3.convertComplete((String)object2);
        }
        if ((object3 = this.m_completeNotify2) != null) {
            object2 = this.m_outputFilePath;
            bl2 = this.mFileConvertSuccess;
            object3.convertComplete2((String)object2, bl2);
            this.mFileConvertSuccess = false;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private NvVideoFrame GetAudioEmptyBufferFromList() {
        Object object = this.m_audioBufferObject;
        synchronized (object) {
            Object object2 = this.m_pendingAudioSamples;
            int n10 = ((ArrayList)object2).size();
            if (n10 <= 0) {
                try {
                    object2 = this.m_audioBufferObject;
                    long l10 = Long.MAX_VALUE;
                    object2.wait(l10);
                    object2 = this.m_pendingAudioSamples;
                    n10 = ((ArrayList)object2).size();
                    if (n10 <= 0) {
                        return new NvVideoFrame();
                    }
                    object2 = this.m_pendingAudioSamples;
                    object2 = ((ArrayList)object2).get(0);
                    object2 = (NvVideoFrame)object2;
                    ArrayList arrayList = this.m_pendingAudioSamples;
                    arrayList.remove(0);
                }
                catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                    return null;
                }
            } else {
                object2 = this.m_pendingAudioSamples;
                object2 = ((ArrayList)object2).get(0);
                object2 = (NvVideoFrame)object2;
                ArrayList arrayList = this.m_pendingAudioSamples;
                arrayList.remove(0);
            }
            return object2;
        }
    }

    private void InitBackgroundHandler() {
        Handler handler;
        Object object;
        this.m_backgroundThread = object = new HandlerThread("background handler");
        String string2 = TAG;
        if (object == null) {
            Logger.e(string2, "Failed to create background handler thread!");
            return;
        }
        object.start();
        object = this.m_backgroundThread.getLooper();
        if (object == null) {
            Logger.e(string2, "Failed to getLooper of the background thread!");
            this.CloseBackgroundHandler();
            return;
        }
        this.m_backgroundHandler = handler = new Handler((Looper)object);
        if (handler == null) {
            object = "Failed to create handler with looper!";
            Logger.e(string2, object);
            this.CloseBackgroundHandler();
        }
    }

    public static boolean InstallLicense(Activity activity, byte[] object) {
        mLicenseInstalled = false;
        if ((object = (Object)NvConvertorUtils.NvDecodeLicenseFile(object)) == null) {
            return false;
        }
        return NvFileConvertProcess.CheckLicense(activity, (String)object);
    }

    private boolean ProcessAudioData() {
        Object object;
        int n10;
        int n11;
        for (n11 = 0; n11 < (n10 = this.m_MaxProcessCount * 3); n11 += 1) {
            NvVideoFrame nvVideoFrame = new NvVideoFrame();
            object = this.m_pendingAudioSamples;
            ((ArrayList)object).add(nvVideoFrame);
        }
        n11 = 0;
        while (true) {
            long l10;
            long l11;
            long l12;
            n10 = 1;
            if (n11 != 0) break;
            object = this.GetAudioEmptyBufferFromList();
            if (object == null) {
                return false;
            }
            NvAndroidAudioFileReader nvAndroidAudioFileReader = this.m_audioReader;
            int n12 = nvAndroidAudioFileReader.GetNextAudioSamplesForPlayback((NvVideoFrame)object);
            if (n12 == n10 || (n12 = (int)(this.m_bStopping ? 1 : 0)) != 0 || (n12 = (int)((l12 = (l11 = ((NvVideoFrame)object).streamTime) - (l10 = this.m_n64ConvertTo)) == 0L ? 0 : (l12 < 0L ? -1 : 1))) >= 0) {
                n11 = n10;
            }
            if (n11 == 0) {
                this.AddBufferToAudioCacheArray((NvVideoFrame)object, false);
                continue;
            }
            object = null;
            this.AddBufferToAudioCacheArray(null, n10 != 0);
        }
        return n10 != 0;
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    private boolean ProcessVideoData() {
        Object object;
        int n10;
        block14: {
            Throwable throwable22;
            n10 = 0;
            Object var2_2 = null;
            this.m_ifReaderProcessThreadOver = false;
            while (true) {
                block16: {
                    CharSequence charSequence;
                    CharSequence charSequence2;
                    long l10;
                    n10 = 1;
                    object = this.m_videoReader;
                    if (object == null) break block14;
                    boolean bl2 = this.m_bStopping;
                    long l11 = -1;
                    if (bl2) {
                        ((NvAndroidSurfaceVideoFileReader)object).m_timestampOfCurTexFrame = l11;
                        break block14;
                    }
                    int n11 = ((NvAndroidSurfaceVideoFileReader)object).GetNextVideoFrameForPlayback();
                    if (n11 != n10) {
                        object = this.m_videoReader;
                        long l12 = ((NvAndroidSurfaceVideoFileReader)object).m_timestampOfCurTexFrame;
                        l10 = this.m_reverseEndPos;
                        long l13 = l12 - l10;
                        n11 = (int)(l13 == 0L ? 0 : (l13 < 0L ? -1 : 1));
                        if (n11 < 0) continue;
                    }
                    if ((n11 = (int)(this.m_bIsReverseConvert ? 1 : 0)) == 0) break block14;
                    object = this.m_reverseContinue;
                    // MONITORENTER : object
                    Object object2 = "wait";
                    String string2 = "m_reverseContinue";
                    try {
                        block15: {
                            Logger.e((String)object2, string2);
                            object2 = this.m_reverseContinue;
                            object2.wait();
                            l10 = this.m_reverseContinuePos;
                            bl2 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
                            if (bl2) break block15;
                            // MONITOREXIT : object
                            break block14;
                        }
                        object2 = TAG;
                        charSequence2 = new StringBuilder();
                        charSequence = "StartPlayback: ";
                        ((StringBuilder)charSequence2).append((String)charSequence);
                        long l14 = this.m_reverseContinuePos;
                        ((StringBuilder)charSequence2).append(l14);
                        charSequence2 = ((StringBuilder)charSequence2).toString();
                        Logger.e((String)object2, charSequence2);
                        object2 = this.m_videoReader;
                        l11 = this.m_reverseContinuePos;
                        l10 = Long.MAX_VALUE;
                        ((NvAndroidSurfaceVideoFileReader)object2).StartPlayback(l11, l10);
                        break block16;
                    }
                    catch (Throwable throwable22) {
                        break;
                    }
                    catch (InterruptedException interruptedException) {
                        charSequence2 = TAG;
                        charSequence = new StringBuilder();
                        string2 = "";
                        charSequence.append(string2);
                        string2 = interruptedException.getMessage();
                        charSequence.append(string2);
                        charSequence = charSequence.toString();
                        Logger.e((String)charSequence2, charSequence);
                        interruptedException.printStackTrace();
                    }
                }
                // MONITOREXIT : object
            }
            // MONITOREXIT : object
            try {
                throw throwable22;
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        object = this.m_safeCloseObject;
        // MONITORENTER : object
        this.m_ifReaderProcessThreadOver = n10;
        // MONITOREXIT : object
        return n10 != 0;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean ProcessWriteData() {
        float f10;
        int n10;
        NvAndroidAudioFileReader nvAndroidAudioFileReader = this.m_audioReader;
        int n11 = 1;
        float f11 = Float.MIN_VALUE;
        if (nvAndroidAudioFileReader != null) {
            n10 = n11;
            f10 = f11;
        } else {
            n10 = 0;
            nvAndroidAudioFileReader = null;
            f10 = 0.0f;
        }
        Object object = TAG;
        CharSequence charSequence = new StringBuilder();
        String string2 = "ProcessWriteData: 1111";
        charSequence.append(string2);
        charSequence.append(n10 != 0);
        charSequence = charSequence.toString();
        Logger.e((String)object, charSequence);
        while (n10 != 0) {
            float f12;
            int n12;
            object = this.m_fileWriter;
            long l10 = ((NvAndroidSurfaceFileWriter)object).lastVideoTimeStamp;
            block9: while (true) {
                n12 = n10;
                f12 = f10;
                while (n10 != 0) {
                    long l11;
                    String string3;
                    Object object2;
                    Object object3 = null;
                    Object object4 = this.m_audiowrtieObject;
                    synchronized (object4) {
                        object2 = this.m_writingAudioSamples;
                        int n13 = ((ArrayList)object2).size();
                        if (n13 > 0) {
                            object3 = this.m_writingAudioSamples;
                            object3 = ((ArrayList)object3).get(0);
                            object3 = (NvVideoFrame)object3;
                        } else {
                            object2 = "wait";
                            string3 = "m_audiowrtieObject";
                            try {
                                Logger.e((String)object2, string3);
                                object2 = this.m_audiowrtieObject;
                                l11 = Long.MAX_VALUE;
                                object2.wait(l11);
                            }
                            catch (InterruptedException interruptedException) {
                                interruptedException.printStackTrace();
                            }
                        }
                        if (object3 == null) continue;
                    }
                    int n14 = ((NvVideoFrame)object3).bufferFlags;
                    if (n14 != n11) {
                        long l12 = ((NvVideoFrame)object3).streamTime;
                        long l13 = l12 - l10;
                        n14 = (int)(l13 == 0L ? 0 : (l13 < 0L ? -1 : 1));
                        if (n14 < 0) {
                            object4 = this.m_audiowrtieObject;
                            synchronized (object4) {
                                object2 = this.m_writingAudioSamples;
                                ((ArrayList)object2).remove(0);
                            }
                            object2 = new StringBuilder();
                            ((StringBuilder)object2).append("write audio time stamp: ");
                            l11 = ((NvVideoFrame)object3).streamTime;
                            ((StringBuilder)object2).append(l11);
                            string3 = "video time stamp:";
                            ((StringBuilder)object2).append(string3);
                            ((StringBuilder)object2).append(l10);
                            object2 = ((StringBuilder)object2).toString();
                            Logger.e(TAG, object2);
                            object4 = this.m_fileWriter;
                            ((NvAndroidSurfaceFileWriter)object4).WriteAudioFrame((NvVideoFrame)object3);
                            continue;
                        }
                        n10 = 0;
                        nvAndroidAudioFileReader = null;
                        f10 = 0.0f;
                        continue;
                    }
                    this.m_fileWriter.NotifyAudioEOS();
                    n10 = 0;
                    nvAndroidAudioFileReader = null;
                    f10 = 0.0f;
                    continue block9;
                }
                break;
            }
            n10 = n12;
            f10 = f12;
        }
        return n11 != 0;
    }

    private int WriteWaveImageToImageBuffer(NvVideoFrame nvVideoFrame) {
        int n10 = 2;
        if (nvVideoFrame == null) {
            return n10;
        }
        ByteBuffer byteBuffer = nvVideoFrame.buffer;
        if (byteBuffer == null) {
            return n10;
        }
        n10 = this.m_nDstWidth;
        int n11 = this.m_nDstHeight;
        byteBuffer.position(n10 *= n11);
        NvConvertorUtils.NvMemsetBuffer(nvVideoFrame.buffer, (byte)-128);
        return 0;
    }

    public static /* synthetic */ String access$000(NvFileConvertProcess nvFileConvertProcess) {
        return nvFileConvertProcess.m_outputFilePath;
    }

    public static /* synthetic */ long access$102(NvFileConvertProcess nvFileConvertProcess, long l10) {
        nvFileConvertProcess.m_reverseContinuePos = l10;
        return l10;
    }

    public static /* synthetic */ long access$202(NvFileConvertProcess nvFileConvertProcess, long l10) {
        nvFileConvertProcess.m_reverseEndPos = l10;
        return l10;
    }

    public static /* synthetic */ boolean access$300(NvFileConvertProcess nvFileConvertProcess) {
        return nvFileConvertProcess.ProcessVideoData();
    }

    public static /* synthetic */ boolean access$400(NvFileConvertProcess nvFileConvertProcess) {
        return nvFileConvertProcess.ProcessAudioData();
    }

    public static /* synthetic */ boolean access$500(NvFileConvertProcess nvFileConvertProcess) {
        return nvFileConvertProcess.ProcessWriteData();
    }

    private boolean isNumeric(String object) {
        Pattern pattern = Pattern.compile("[0-9]*");
        object = pattern.matcher((CharSequence)object);
        boolean bl2 = ((Matcher)object).matches();
        return bl2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void AddBufferToAudioCacheArray(NvVideoFrame object, boolean bl2) {
        Object object2 = this.m_audiowrtieObject;
        synchronized (object2) {
            if (bl2) {
                object = new NvVideoFrame();
                bl2 = true;
                ((NvVideoFrame)object).bufferFlags = (int)(bl2 ? 1 : 0);
                ArrayList arrayList = this.m_writingAudioSamples;
                arrayList.add(object);
            } else {
                ArrayList arrayList = this.m_writingAudioSamples;
                arrayList.add(object);
            }
            object = this.m_audiowrtieObject;
            object.notify();
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void Close() {
        boolean bl2;
        Object object;
        this.Stop();
        try {
            object = this.m_videoReader;
            if (object != null) {
                ((NvAndroidSurfaceVideoFileReader)object).CloseFile();
            }
            bl2 = false;
            object = null;
            this.m_videoReader = null;
            Object object2 = this.m_audioReader;
            if (object2 != null) {
                ((NvAndroidAudioFileReader)object2).CloseFile();
            }
            this.m_audioReader = null;
            object2 = this.m_fileWriter;
            if (object2 != null) {
                boolean bl3;
                this.mFileConvertSuccess = bl3 = ((NvAndroidSurfaceFileWriter)object2).isSuccess;
                ((NvAndroidSurfaceFileWriter)object2).FlushWriter();
                this.m_fileWriter = null;
            }
        }
        catch (Exception exception) {}
        bl2 = false;
        object = null;
        this.m_bIsOpened = false;
        this.m_bIsStarted = false;
        try {
            object = this.prcoess;
            if (object != null && (bl2 = ((Thread)object).isAlive())) {
                object = this.prcoess;
                ((Thread)object).interrupt();
            }
            if ((object = this.audioprcoess) != null && (bl2 = ((Thread)object).isAlive())) {
                object = this.audioprcoess;
                ((Thread)object).interrupt();
            }
            if ((object = this.writerprcoess) == null) return;
            bl2 = ((Thread)object).isAlive();
            if (!bl2) return;
            object = this.writerprcoess;
            ((Thread)object).interrupt();
            return;
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public void DetectAndroidDevicePowerGrade() {
        block49: {
            block50: {
                var1_1 = this.m_nDstHeight;
                var2_2 = 720;
                var3_3 = 2;
                var4_4 = 1;
                if (var1_1 > var2_2) {
                    var1_1 = NvConvertorUtils.getCPUCount();
                    var5_5 = NvConvertorUtils.getCPUMaxFreqKHz();
                    var6_6 = NvConvertorUtils.getTotalMemory();
                    cfr_temp_0 = var6_6 - (var8_7 = 0L);
                    var10_8 /* !! */  = (long)(cfr_temp_0 == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1));
                    if (var10_8 /* !! */  > 0 && (var11_9 = (int)((cfr_temp_1 = var6_6 - (var8_7 = 0x40000000L)) == 0L ? 0 : (cfr_temp_1 < 0L ? -1 : 1))) < 0 && (var11_9 = this.m_videoResolution) > var4_4) {
                        this.m_videoResolution = var4_4;
                    }
                    if (var1_1 <= (var11_9 = 4)) {
                        if (var1_1 > var3_3) {
                            if (var5_5 > 0 && var5_5 <= (var1_1 = 1000000)) {
                                var1_1 = this.m_videoResolution;
                                if (var1_1 > 0) {
                                    this.m_videoResolution = 0;
                                }
                            } else if (var5_5 > 0 && var5_5 <= (var1_1 = 1190000) && (var1_1 = this.m_videoResolution) > var4_4) {
                                this.m_videoResolution = var4_4;
                            }
                        } else if (var1_1 == var3_3) {
                            if (var5_5 > 0 && var5_5 < (var1_1 = 1700000) && (var1_1 = this.m_videoResolution) > var4_4) {
                                this.m_videoResolution = var4_4;
                            }
                        } else {
                            var1_1 = this.m_videoResolution;
                            if (var1_1 > var4_4) {
                                this.m_videoResolution = var4_4;
                            }
                            if (var5_5 > 0 && var5_5 < (var1_1 = 2000000) && (var1_1 = this.m_videoResolution) > 0) {
                                this.m_videoResolution = 0;
                            }
                        }
                    }
                }
                var1_1 = this.m_nDstHeight;
                var12_10 = "X909T";
                var13_14 = "GT-I9508";
                var14_15 = "X909";
                var15_16 = "vivo X510t";
                var16_17 = "vivo";
                var17_18 = "OPPO";
                var18_19 = "samsung";
                var19_20 = 352;
                if (var1_1 > var2_2) {
                    var20_21 = Build.MANUFACTURER;
                    var21_22 = var20_21.compareTo((String)var17_18);
                    if ((var21_22 == 0 && ((var23_25 = (var17_18 = Build.MODEL).compareTo(var22_24 = "N5117")) == 0 || (var24_27 = var17_18.compareTo((String)var14_15)) == 0 || (var5_5 = var17_18.compareTo((String)var12_10)) == 0) || (var5_5 = var20_21.compareTo((String)var16_17)) == 0 && (var5_5 = (var12_10 = Build.MODEL).compareTo((String)var15_16)) == 0 || (var1_1 = var20_21.compareTo(var18_19)) == 0 && (var1_1 = (var20_21 = Build.MODEL).compareTo((String)var13_14)) == 0) && (var1_1 = this.m_videoResolution) > var3_3) {
                        this.m_videoResolution = var3_3;
                    }
                } else {
                    var23_26 = 480;
                    if (var1_1 > var23_26) {
                        var20_21 = Build.MANUFACTURER;
                        var1_1 = var20_21.compareTo(var18_19);
                        if (var1_1 == 0 && ((var5_5 = (var20_21 = Build.MODEL).compareTo((String)(var12_10 = "GT-I8552"))) == 0 || (var5_5 = var20_21.compareTo((String)(var12_10 = "GT-I8580"))) == 0 || (var5_5 = var20_21.compareTo((String)(var12_10 = "GT-N7108"))) == 0 || (var5_5 = var20_21.compareTo((String)(var12_10 = "GT-N7102"))) == 0 || (var1_1 = var20_21.compareTo((String)(var12_10 = "GT-N7100"))) == 0) && (var1_1 = this.m_videoResolution) > var4_4) {
                            this.m_videoResolution = var4_4;
                        }
                    } else if (var1_1 > var19_20 && ((var21_23 = (var20_21 = Build.MANUFACTURER).compareTo((String)var17_18)) == 0 && ((var24_27 = (var17_18 = Build.MODEL).compareTo((String)var14_15)) == 0 || (var5_5 = var17_18.compareTo((String)var12_10)) == 0) || (var5_5 = var20_21.compareTo((String)var16_17)) == 0 && (var5_5 = (var12_10 = Build.MODEL).compareTo((String)var15_16)) == 0 || (var1_1 = var20_21.compareTo(var18_19)) == 0 && (var1_1 = (var20_21 = Build.MODEL).compareTo((String)var13_14)) == 0) && (var1_1 = this.m_videoResolution) > 0) {
                        this.m_videoResolution = 0;
                    }
                }
                if ((var1_1 = (int)this.m_hasCheckingGPUInfo) != 0) {
                    var1_1 = (int)this.m_isAdreno;
                    if (var1_1 != 0) {
                        var1_1 = this.m_nDstHeight;
                        if (var1_1 > var2_2) {
                            var1_1 = this.m_videoResolution;
                            if (var1_1 > var3_3) {
                                this.m_videoResolution = var3_3;
                            }
                        } else if (var1_1 > var19_20 && (var1_1 = this.m_videoResolution) > 0) {
                            this.m_videoResolution = 0;
                        }
                    }
                    return;
                }
                var20_21 = (EGL10)EGLContext.getEGL();
                var12_10 = EGL10.EGL_DEFAULT_DISPLAY;
                var18_19 = var20_21.eglGetDisplay(var12_10);
                var12_10 = EGL10.EGL_NO_DISPLAY;
                var22_24 = "NvFileConvertProcess";
                if (var18_19 == var12_10) {
                    var25_28 = new Object[var4_4];
                    var25_28[0] = var20_21 = Integer.valueOf(var20_21.eglGetError());
                    var20_21 = String.format("eglGetDisplay() failed, errno=0x%d", var25_28);
                    Logger.e(var22_24, var20_21);
                    this.m_hasCheckingGPUInfo = var4_4;
                    return;
                }
                var12_10 = new int[var3_3];
                var5_5 = (int)var20_21.eglInitialize((EGLDisplay)var18_19, (int[])var12_10);
                if (var5_5 == 0) {
                    var25_29 = new Object[var4_4];
                    var25_29[0] = var20_21 = Integer.valueOf(var20_21.eglGetError());
                    var20_21 = String.format("eglInitialize() failed, errno=0x%d", var25_29);
                    Logger.e(var22_24, var20_21);
                    this.m_hasCheckingGPUInfo = var4_4;
                    return;
                }
                v0 = var14_15 = (Object)new int[13];
                v0[0] = 12324;
                v0[1] = 8;
                v0[2] = 12323;
                v0[3] = 8;
                v0[4] = 12322;
                v0[5] = 8;
                v0[6] = 12321;
                v0[7] = 8;
                v0[8] = 12352;
                v0[9] = 4;
                v0[10] = 12339;
                v0[11] = true;
                v0[12] = 12344;
                var26_34 = new EGLConfig[var4_4];
                var17_18 = new int[var4_4];
                var27_35 = 1;
                var12_10 = var20_21;
                var13_14 = var18_19;
                var15_16 = var26_34;
                var5_5 = (int)var20_21.eglChooseConfig((EGLDisplay)var18_19, (int[])var14_15, (EGLConfig[])var26_34, var27_35, (int[])var17_18);
                if (var5_5 == 0) {
                    var25_30 = new Object[var4_4];
                    var25_30[0] = var20_21 = Integer.valueOf(var20_21.eglGetError());
                    var20_21 = String.format("eglChooseConfig() failed, errno=0x%d", var25_30);
                    Logger.e(var22_24, var20_21);
                    this.m_hasCheckingGPUInfo = var4_4;
                    return;
                }
                var5_5 = 3;
                v1 = var13_14 = (Object)new int[var5_5];
                v1[0] = 12440;
                v1[1] = 2;
                v1[2] = 12344;
                var14_15 = var26_34[0];
                var15_16 = EGL10.EGL_NO_CONTEXT;
                if ((var13_14 = var20_21.eglCreateContext((EGLDisplay)var18_19, (EGLConfig)var14_15, (EGLContext)var15_16, (int[])var13_14)) == (var14_15 = EGL10.EGL_NO_CONTEXT)) {
                    var25_31 = new Object[var4_4];
                    var25_31[0] = var20_21 = Integer.valueOf(var20_21.eglGetError());
                    var20_21 = String.format("eglCreateContext() failed, errno=0x%d", var25_31);
                    Logger.e(var22_24, var20_21);
                    this.m_hasCheckingGPUInfo = var4_4;
                    return;
                }
                var24_27 = 5;
                v2 = var14_15 = (Object)new int[var24_27];
                v2[0] = 12375;
                v2[1] = true;
                v2[2] = 12374;
                v2[3] = true;
                v2[4] = 12344;
                var15_16 = var26_34[0];
                if ((var14_15 = var20_21.eglCreatePbufferSurface((EGLDisplay)var18_19, (EGLConfig)var15_16, (int[])var14_15)) == (var15_16 = EGL10.EGL_NO_SURFACE)) {
                    var25_32 /* !! */  = new Object[var4_4];
                    var28_36 = var20_21.eglGetError();
                    var25_32 /* !! */ [0] = var28_36;
                    var25_32 /* !! */  = String.format("eglCreateWindowSurface() failed, errno=0x%d", var25_32 /* !! */ );
                    Logger.e(var22_24, var25_32 /* !! */ );
                    var20_21.eglDestroyContext((EGLDisplay)var18_19, (EGLContext)var13_14);
                    this.m_hasCheckingGPUInfo = var4_4;
                    return;
                }
                var10_8 /* !! */  = (long)var20_21.eglMakeCurrent((EGLDisplay)var18_19, (EGLSurface)var14_15, (EGLSurface)var14_15, (EGLContext)var13_14);
                if (var10_8 /* !! */  == false) {
                    var25_33 /* !! */  = new Object[var4_4];
                    var28_37 = var20_21.eglGetError();
                    var25_33 /* !! */ [0] = var28_37;
                    var25_33 /* !! */  = String.format("eglMakeCurrent() failed, errno=0x%d", var25_33 /* !! */ );
                    Logger.e(var22_24, var25_33 /* !! */ );
                    var20_21.eglDestroySurface((EGLDisplay)var18_19, (EGLSurface)var14_15);
                    var20_21.eglDestroyContext((EGLDisplay)var18_19, (EGLContext)var13_14);
                    this.m_hasCheckingGPUInfo = var4_4;
                    return;
                }
                var10_8 /* !! */  = 7937;
                var15_16 = GLES20.glGetString((int)var10_8 /* !! */ );
                var16_17 = "[-\\s+]";
                var27_35 = ((Object)(var15_16 = var15_16.split((String)var16_17))).length;
                if (var27_35 < var3_3 || (var27_35 = (var16_17 = var15_16[0]).compareTo((String)(var17_18 = "Adreno"))) != 0) break block49;
                var16_17 = var15_16[var4_4];
                var17_18 = "(TM)";
                var27_35 = var16_17.compareTo((String)var17_18);
                if (var27_35 != 0) break block50;
                var27_35 = ((Object)var15_16).length;
                if (var27_35 == var5_5 && (var5_5 = (int)this.isNumeric((String)(var12_10 = var15_16[var3_3]))) != 0) {
                    try {
                        var12_10 = var15_16[var3_3];
                    }
                    catch (NumberFormatException var12_11) {
                        var12_11.printStackTrace();
                        break block48;
                    }
                    var5_5 = Integer.parseInt((String)var12_10);
                    break block47;
                }
                ** GOTO lbl-1000
            }
            var12_10 = var15_16[var4_4];
            var5_5 = (int)this.isNumeric((String)var12_10);
            if (var5_5 != 0) {
                block47: {
                    block48: {
                        var12_10 = var15_16[var4_4];
                        try {
                            var5_5 = Integer.parseInt((String)var12_10);
                            break block47;
                        }
                        catch (NumberFormatException var12_12) {
                            var12_12.printStackTrace();
                        }
                    }
                    var5_5 = 0;
                    var12_13 = null;
                }
                var10_8 /* !! */  = var4_4;
            } else lbl-1000:
            // 2 sources

            {
                var5_5 = 0;
                var12_10 = null;
                var10_8 /* !! */  = 0;
                var15_16 = null;
            }
            if (var10_8 /* !! */  != false && var5_5 == (var10_8 /* !! */  = (long)320)) {
                var5_5 = this.m_nDstHeight;
                if (var5_5 > var2_2) {
                    var2_2 = this.m_videoResolution;
                    if (var2_2 > var3_3) {
                        this.m_videoResolution = var3_3;
                    }
                } else if (var5_5 > var19_20 && (var2_2 = this.m_videoResolution) > 0) {
                    this.m_videoResolution = 0;
                }
                this.m_isAdreno = var4_4;
            }
        }
        var20_21.eglDestroySurface((EGLDisplay)var18_19, (EGLSurface)var14_15);
        var20_21.eglDestroyContext((EGLDisplay)var18_19, (EGLContext)var13_14);
        this.m_hasCheckingGPUInfo = var4_4;
    }

    public double GetConvertProgress() {
        double d10 = this.m_n64Progress;
        long l10 = this.m_n64ConvertTo;
        long l11 = this.m_n64ConvertFrom;
        double d11 = l10 - l11;
        return d10 / d11;
    }

    public boolean IsStarting() {
        return this.m_bIsStarted;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public int Open(String string2, String string3, NvFileConvertConfig nvFileConvertConfig) {
        boolean bl2;
        long l10;
        NvFileConvertProcess nvFileConvertProcess = this;
        Object object = nvFileConvertConfig;
        int n10 = this.m_bIsOpened;
        if (n10 != 0) {
            n10 = this.m_bIsStarted;
            if (n10 != 0) {
                return -7;
            }
            this.Close();
        }
        n10 = string2.isEmpty();
        int n11 = -4;
        if (n10 != 0 || (n10 = string3.isEmpty()) != 0 || object == null) return n11;
        float f10 = ((NvFileConvertConfig)object).convertStart;
        float f11 = ((NvFileConvertConfig)object).convertEnd;
        int n12 = 0;
        Handler handler = null;
        nvFileConvertProcess.m_bIsReverseConvert = false;
        float f12 = f11 == f10 ? 0 : (f11 < f10 ? -1 : 1);
        boolean bl3 = true;
        if (f12 < 0) {
            nvFileConvertProcess.m_bIsReverseConvert = bl3;
            float f13 = f11;
            f11 = f10;
            f10 = f13;
        }
        f12 = 1232348160;
        float f14 = 1000000.0f;
        long l11 = (long)(f10 *= f14);
        long l12 = 0L;
        nvFileConvertProcess.m_n64ConvertFrom = l11 = Math.max(l11, l12);
        l11 = (long)(f11 * f14);
        long l13 = Long.MAX_VALUE;
        nvFileConvertProcess.m_n64ConvertTo = l11 = Math.min(l11, l13);
        Object object2 = NvConvertorUtils.GetMediaFileInfo(string2);
        int n13 = -9;
        f11 = 0.0f / 0.0f;
        if (object2 == null) {
            return n13;
        }
        f12 = ((NvConvertorUtils$NvMediaFileInfo)object2).videoTrackCount;
        if (f12 == false && (f12 = (float)((NvConvertorUtils$NvMediaFileInfo)object2).audioTrackCount) == false) {
            return n11;
        }
        l11 = ((NvConvertorUtils$NvMediaFileInfo)object2).duration;
        Object object3 = ((NvConvertorUtils$NvMediaFileInfo)object2).videoTrackFormat;
        if (object3 == null) {
            Log.e((String)TAG, (String)"videoTrackFormat is null");
            return n13;
        }
        Object object4 = "width";
        n11 = object3.getInteger((String)object4);
        MediaFormat mediaFormat = ((NvConvertorUtils$NvMediaFileInfo)object2).videoTrackFormat;
        String string4 = "height";
        int n14 = mediaFormat.getInteger(string4);
        if ((n11 *= n14) > (n14 = 2073600)) {
            nvFileConvertProcess.m_MaxProcessCount = 30;
            n11 = (int)(bl3 ? 1 : 0);
        } else {
            n11 = 0;
            object3 = null;
        }
        long l14 = nvFileConvertProcess.m_n64ConvertTo;
        long l15 = nvFileConvertProcess.m_n64ConvertFrom;
        n13 = (int)(l14 == l15 ? 0 : (l14 < l15 ? -1 : 1));
        if (n13 <= 0) {
            nvFileConvertProcess.m_n64ConvertFrom = l12;
            nvFileConvertProcess.m_n64ConvertTo = l11;
        }
        if ((n13 = (int)((l10 = (l15 = nvFileConvertProcess.m_n64ConvertTo) - l11) == 0L ? 0 : (l10 < 0L ? -1 : 1))) > 0) {
            nvFileConvertProcess.m_n64ConvertTo = l11;
        }
        nvFileConvertProcess.m_reverseEndPos = l15 = nvFileConvertProcess.m_n64ConvertTo;
        Object object5 = nvFileConvertProcess.m_backgroundHandler;
        if (object5 == null || (object5 = nvFileConvertProcess.m_backgroundThread) == null || (n13 = (int)(object5.isAlive() ? 1 : 0)) == 0) {
            this.InitBackgroundHandler();
        }
        if ((object5 = nvFileConvertProcess.m_fileWriter) == null) {
            handler = nvFileConvertProcess.m_backgroundHandler;
            object5 = new NvAndroidSurfaceFileWriter(handler, nvFileConvertProcess, n11 != 0);
            nvFileConvertProcess.m_fileWriter = object5;
        }
        object3 = nvFileConvertProcess.m_fileWriter;
        object5 = new NvFileConvertProcess$2(nvFileConvertProcess);
        ((NvAndroidSurfaceFileWriter)object3).setOnReleaseEncoderListener((NvAndroidSurfaceFileWriter$OnReleaseEncoderListener)object5);
        n11 = ((NvFileConvertConfig)object).deposeOperatingRate;
        object5 = nvFileConvertProcess.m_fileWriter;
        n12 = ((NvConvertorUtils$NvMediaFileInfo)object2).displayRotation;
        int n15 = nvFileConvertProcess.m_bIsReverseConvert;
        boolean bl4 = true;
        int n16 = n15;
        object3 = ((NvAndroidSurfaceFileWriter)object5).OpenFile(string3, n12, n15 != 0, bl4, n11 != 0);
        n13 = (int)(nvFileConvertProcess.m_bHasAudioOutput ? 1 : 0);
        n12 = ((NvConvertorUtils$NvMediaFileInfo)object2).audioTrackCount;
        if (n12 <= 0) {
            n13 = 0;
            f11 = 0.0f;
            object5 = null;
        }
        n10 = ((NvConvertorUtils$NvMediaFileInfo)object2).videoTrackCount;
        n12 = 0;
        handler = null;
        if (n10 > 0) {
            n16 = 30;
            nvFileConvertProcess.m_videoReader = object2 = new NvAndroidSurfaceVideoFileReader((SurfaceTexture)object3);
            l11 = nvFileConvertProcess.m_n64ConvertFrom;
            l12 = nvFileConvertProcess.m_n64ConvertTo;
            n10 = (int)(((NvAndroidSurfaceVideoFileReader)object2).OpenFile(string2, l11, l12, null) ? 1 : 0);
            if (n10 == 0 || object3 == null) return -9;
            object2 = nvFileConvertProcess.m_videoReader.m_format;
            nvFileConvertProcess.m_nSrcWidth = n11 = object2.getInteger((String)object4);
            nvFileConvertProcess.m_nSrcHeight = n10 = object2.getInteger(string4);
            nvFileConvertProcess.m_nDstHeight = n10;
            f10 = 5.6E-45f;
            nvFileConvertProcess.m_videoResolution = 4;
            n10 = (int)(nvFileConvertConfig.videoResolutionIsValid() ? 1 : 0);
            if (n10 != 0) {
                nvFileConvertProcess.m_videoResolution = n10 = ((NvFileConvertConfig)object).videoResolution;
            }
            this.CalcVideoSize();
            n10 = Build.VERSION.SDK_INT;
            n11 = 18;
            if (n10 >= n11) {
                this.DetectAndroidDevicePowerGrade();
                this.CalcVideoSize();
            }
            object2 = nvFileConvertProcess.m_fileWriter;
            n11 = nvFileConvertProcess.m_nDstWidth;
            f12 = nvFileConvertProcess.m_nDstHeight;
            l11 = nvFileConvertProcess.m_n64ConvertFrom;
            l12 = nvFileConvertProcess.m_n64ConvertTo;
            ((NvAndroidSurfaceFileWriter)object2).InitVideoInfo(n11, (int)f12, n16, l11, l12);
            long l16 = ((NvFileConvertConfig)object).dataRate;
            l11 = 1000L;
            f12 = (float)(l16 == l11 ? 0 : (l16 < l11 ? -1 : 1));
            if (f12 > 0) {
                object4 = nvFileConvertProcess.m_fileWriter;
                ((NvAndroidSurfaceFileWriter)object4).m_bitrate = l16;
            }
            if ((n10 = ((NvFileConvertConfig)object).gopsize) > 0) {
                object3 = nvFileConvertProcess.m_fileWriter;
                ((NvAndroidSurfaceFileWriter)object3).m_gopsize = n10;
            }
            object2 = nvFileConvertProcess.m_fileWriter;
            ((NvAndroidSurfaceFileWriter)object2).m_IFrameOnly = bl2 = ((NvFileConvertConfig)object).iFrameOnly;
        } else {
            object = nvFileConvertProcess.m_videoReader;
            if (object != null) {
                ((NvAndroidSurfaceVideoFileReader)object).CloseFile();
            }
            nvFileConvertProcess.m_videoReader = null;
        }
        if (n13 != 0) {
            nvFileConvertProcess.m_audioReader = object = new NvAndroidAudioFileReader();
            object2 = string2;
            bl2 = ((NvAndroidAudioFileReader)object).OpenFile(string2);
            if (!bl2) {
                return -9;
            }
        } else {
            object = nvFileConvertProcess.m_audioReader;
            if (object != null) {
                ((NvAndroidAudioFileReader)object).CloseFile();
            }
            nvFileConvertProcess.m_audioReader = null;
        }
        if ((object = nvFileConvertProcess.m_videoReader) == null) {
            return -6;
        }
        object2 = nvFileConvertProcess.m_fileWriter;
        ((NvAndroidSurfaceFileWriter)object2).m_videoReader = object;
        object = nvFileConvertProcess.m_messageHandler;
        ((NvAndroidSurfaceFileWriter)object2).m_processEventHandler = object;
        object = string3;
        nvFileConvertProcess.m_outputFilePath = string3;
        nvFileConvertProcess.m_bIsOpened = bl3;
        nvFileConvertProcess.m_bIsStarted = false;
        return 0;
    }

    public void SetProgressNotify(NvFileConvertProcess$NvFileConvertProgressNotify nvFileConvertProcess$NvFileConvertProgressNotify) {
        this.m_progressNotify = nvFileConvertProcess$NvFileConvertProgressNotify;
    }

    public int Start() {
        Object object;
        int n10;
        Object object2;
        long l10;
        long l11;
        long l12;
        boolean bl2 = this.m_bIsStarted;
        if (bl2) {
            return -8;
        }
        bl2 = false;
        this.m_bStopping = false;
        this.m_bWritingComplete = false;
        this.m_n64Progress = l12 = 0L;
        Object object3 = this.m_audioReader;
        int n11 = 1;
        int n12 = -1;
        String string2 = TAG;
        if (object3 != null) {
            int n13;
            object3 = new StringBuilder();
            ((StringBuilder)object3).append("Start: ");
            Object object4 = this.m_audioReader;
            if (object4 != null) {
                n13 = n11;
            } else {
                n13 = 0;
                object4 = null;
            }
            ((StringBuilder)object3).append(n13 != 0);
            object3 = ((StringBuilder)object3).toString();
            Logger.e(string2, object3);
            object3 = this.m_audioReader;
            l11 = this.m_n64ConvertFrom;
            l10 = 1L;
            object2 = ((NvAndroidAudioFileReader)object3).StartPlayback(l11, l10);
            if (object2 != 0) {
                Logger.e(string2, "The convertor audio reader start failed");
                return n12;
            }
            object3 = this.m_audioReader.GetAudioOutputMediaFormat();
            object4 = "sample-rate";
            n13 = object3.getInteger((String)object4);
            object2 = object3.getInteger("channel-count");
            NvAndroidSurfaceFileWriter nvAndroidSurfaceFileWriter = this.m_fileWriter;
            nvAndroidSurfaceFileWriter.addAudioStream(n13, (int)object2);
        }
        if ((object2 = ((NvAndroidSurfaceFileWriter)(object3 = this.m_fileWriter)).Start()) == 0) {
            Logger.e(string2, "The convertor writer start failed");
            return n12;
        }
        object2 = this.m_bIsReverseConvert;
        if (object2 != 0) {
            l11 = this.m_n64ConvertTo;
            l10 = 1000000L;
            long l13 = (l11 -= l10) - l12;
            object2 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
            if (object2 >= 0) {
                l12 = l11;
            }
            object3 = this.m_videoReader;
            l11 = Long.MAX_VALUE;
            n10 = ((NvAndroidSurfaceVideoFileReader)object3).StartPlayback(l12, l11);
        } else {
            object = this.m_videoReader;
            long l14 = this.m_n64ConvertFrom;
            l11 = 10;
            n10 = ((NvAndroidSurfaceVideoFileReader)object).StartPlayback(l14, l11);
        }
        if (n10 != 0) {
            Logger.e(string2, "The convertor video reader start failed");
            return n12;
        }
        object = new ArrayList();
        this.m_pendingAudioSamples = object;
        object = new ArrayList();
        this.m_writingAudioSamples = object;
        this.m_ifReaderProcessThreadOver = n11;
        Object object5 = new NvFileConvertProcess$3(this);
        this.prcoess = object = new Thread((Runnable)object5);
        object5 = "Video Process Thread";
        ((Thread)object).setName((String)object5);
        this.prcoess.start();
        object = this.m_audioReader;
        if (object != null) {
            object5 = new NvFileConvertProcess$4(this);
            this.audioprcoess = object = new Thread((Runnable)object5);
            ((Thread)object).setName("audio Process Thread");
            this.audioprcoess.start();
            object5 = new NvFileConvertProcess$5(this);
            this.writerprcoess = object = new Thread((Runnable)object5);
            object5 = "writer Thread";
            ((Thread)object).setName((String)object5);
            object = this.writerprcoess;
            ((Thread)object).start();
        }
        this.m_bIsStarted = n11;
        return 0;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public int Stop() {
        boolean bl2 = this.m_bIsStarted;
        int n10 = 0;
        Object var3_3 = null;
        if (!bl2) {
            return 0;
        }
        Object object = this.m_fileWriter;
        if (object == null) {
            return -5;
        }
        boolean bl3 = this.m_bWritingComplete;
        if (bl3) {
            return 0;
        }
        this.m_bStopping = bl3 = true;
        ((NvAndroidSurfaceFileWriter)object).m_stopping = bl3;
        object = this.m_finishEvent;
        synchronized (object) {
            Throwable throwable22222;
            Object object2 = this.m_finishEvent;
            long l10 = Long.MAX_VALUE;
            object2.wait(l10);
            // MONITOREXIT @DISABLED, blocks:[0, 2] lbl20 : MonitorExitStatement: MONITOREXIT : var4_6
            this.m_bStopping = false;
            this.m_bIsStarted = false;
            return 0;
            {
                catch (Throwable throwable22222) {
                }
                catch (InterruptedException interruptedException) {}
                {
                    interruptedException.printStackTrace();
                    return -1;
                }
            }
            throw throwable22222;
        }
    }

    public void cancle() {
        boolean bl2 = this.m_bIsStarted;
        if (bl2) {
            CharSequence charSequence = new StringBuilder();
            charSequence.append("cancle: 1   ");
            long l10 = System.currentTimeMillis();
            charSequence.append(l10);
            charSequence = charSequence.toString();
            String string2 = TAG;
            Logger.e(string2, charSequence);
            this.Close();
        }
        this.CloseBackgroundHandler();
    }

    public void finish() {
        boolean bl2;
        Object object = new StringBuilder();
        ((StringBuilder)object).append("handleMessage: 11    ");
        Object object2 = this.m_progressNotify;
        if (object2 != null) {
            bl2 = true;
        } else {
            bl2 = false;
            object2 = null;
        }
        ((StringBuilder)object).append(bl2);
        object = ((StringBuilder)object).toString();
        object2 = TAG;
        Logger.e((String)object2, object);
        object = this.m_progressNotify;
        if (object != null) {
            int n10 = 100;
            object.convertProgress(n10);
        }
        this.CompleteAll();
        Logger.e((String)object2, "handleMessage: 12");
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void returnToPool(NvVideoFrame object) {
        Object object2 = this.m_audioBufferObject;
        synchronized (object2) {
            ArrayList arrayList = this.m_pendingAudioSamples;
            if (arrayList != null) {
                arrayList.add(object);
            } else {
                arrayList = null;
                ((NvVideoFrame)object).buffer = null;
            }
            object = this.m_audioBufferObject;
            object.notifyAll();
            return;
        }
    }

    public void setHasAudioOutput(boolean bl2) {
        this.m_bHasAudioOutput = bl2;
    }
}

