/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.media.AudioRecord
 */
package com.tencent.liteav.audio.impl.Record;

import android.content.Context;
import android.media.AudioRecord;
import com.tencent.liteav.audio.impl.Record.c;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;

public class TXCAudioSysRecord
implements Runnable {
    private static final String TAG;
    private static TXCAudioSysRecord instance;
    private int mAECType = 0;
    private int mBits = 16;
    private int mChannels = 1;
    private Context mContext;
    private boolean mIsCapFirstFrame = false;
    private boolean mIsRunning = false;
    private AudioRecord mMic;
    private AtomicBoolean mPause;
    private byte[] mRecordBuffer = null;
    private Thread mRecordThread = null;
    private int mSampleRate = 48000;
    private boolean mSendMuteData = false;
    private WeakReference mWeakRefListener;
    private Object threadMutex;

    static {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("AudioCenter:");
        String string2 = TXCAudioSysRecord.class.getSimpleName();
        stringBuilder.append(string2);
        TAG = stringBuilder.toString();
        instance = null;
    }

    private TXCAudioSysRecord() {
        Object object;
        AtomicBoolean atomicBoolean;
        this.mPause = atomicBoolean = new AtomicBoolean(false);
        this.threadMutex = object = new Object();
        this.nativeClassInit();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static TXCAudioSysRecord getInstance() {
        Object object = instance;
        if (object != null) return instance;
        object = TXCAudioSysRecord.class;
        synchronized (object) {
            TXCAudioSysRecord tXCAudioSysRecord = instance;
            if (tXCAudioSysRecord != null) return instance;
            instance = tXCAudioSysRecord = new TXCAudioSysRecord();
            return instance;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void init() {
        int n10;
        int n11;
        int n12;
        Object object;
        int n13;
        Object object2;
        Object object3;
        int n14;
        int n15;
        int n16;
        int n17;
        int n18;
        TXCAudioSysRecord tXCAudioSysRecord;
        block10: {
            Object object4;
            block9: {
                int n23;
                tXCAudioSysRecord = this;
                n18 = this.mSampleRate;
                n17 = this.mChannels;
                n16 = this.mBits;
                n15 = this.mAECType;
                object4 = TAG;
                n14 = 4;
                object3 = new Object[n14];
                object3[0] = object2 = Integer.valueOf(n18);
                object2 = n17;
                n13 = 1;
                object3[n13] = object2;
                object2 = n16;
                int n19 = 2;
                object3[n19] = object2;
                object = n15;
                int n20 = 3;
                object3[n20] = object;
                object = String.format("audio record sampleRate = %d, channels = %d, bits = %d, aectype = %d", object3);
                TXCLog.i((String)object4, (String)object);
                n15 = n17 == n13 ? 16 : 12;
                n12 = n15;
                int n21 = 8;
                int n22 = n16 == n21 ? n20 : n19;
                n11 = AudioRecord.getMinBufferSize((int)n18, (int)n12, (int)n22);
                object = "audio record type: system normal";
                try {
                    TXCLog.i((String)object4, (String)object);
                    n10 = 1;
                    n23 = n11 * 2;
                    object4 = object;
                    n14 = n11;
                    n11 = n18;
                    n21 = n23;
                }
                catch (IllegalArgumentException illegalArgumentException) {
                    n14 = n11;
                    break block9;
                }
                try {
                    object = new AudioRecord(n10, n18, n12, n22, n23);
                    tXCAudioSysRecord.mMic = object;
                    break block10;
                }
                catch (IllegalArgumentException illegalArgumentException) {}
            }
            object4 = TAG;
            object3 = "create AudioRecord failed.";
            TXCLog.e((String)object4, (String)object3, (Throwable)object);
        }
        object = tXCAudioSysRecord.mMic;
        int n24 = -1;
        if (object != null && (n15 = object.getState()) == n13) {
            n15 = n17 * 1024 * n16 / 8;
            if (n15 > n14) {
                object = new byte[n14];
                tXCAudioSysRecord.mRecordBuffer = (byte[])object;
            } else {
                object = new byte[n15];
                tXCAudioSysRecord.mRecordBuffer = (byte[])object;
            }
            object = TAG;
            n10 = 6;
            object3 = new Object[n10];
            object3[0] = object2 = Integer.valueOf(n18);
            object3[n13] = object2 = Integer.valueOf(n17);
            object3[n19] = object2 = Integer.valueOf(n16);
            object3[n20] = object2 = Integer.valueOf(n14);
            object3[4] = object2 = Integer.valueOf(tXCAudioSysRecord.mRecordBuffer.length);
            n11 = 5;
            n12 = tXCAudioSysRecord.mMic.getState();
            Integer n25 = n12;
            object3[n11] = n25;
            object2 = "audio record: mic open rate=%dHZ, channels=%d, bits=%d, buffer=%d/%d, state=%d";
            object3 = String.format((String)object2, object3);
            TXCLog.i((String)object, (String)object3);
            object = tXCAudioSysRecord.mMic;
            if (object == null) return;
            try {
                object.startRecording();
                return;
            }
            catch (Exception exception) {
                object = TAG;
                object2 = "mic startRecording failed.";
                TXCLog.e((String)object, (String)object2, exception);
                object = "start recording failed!";
                tXCAudioSysRecord.onRecordError(n24, (String)object);
            }
            return;
        }
        TXCLog.e(TAG, "audio record: initialize the mic failed.");
        this.uninit();
        tXCAudioSysRecord.onRecordError(n24, "microphone permission denied!");
    }

    private native void nativeClassInit();

    private native void nativeSendSysRecordAudioData(byte[] var1, int var2, int var3, int var4, int var5);

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    private void onRecordError(int n10, String string2) {
        // MONITORENTER : this
        Object object = this.mWeakRefListener;
        if (object != null) {
            object = ((Reference)object).get();
            object = (c)object;
        } else {
            object = null;
        }
        // MONITOREXIT : this
        if (object != null) {
            object.onAudioRecordError(n10, string2);
            return;
        }
        String string3 = TAG;
        string2 = "onRecordError:no callback";
        TXCLog.e(string3, string2);
    }

    private void onRecordPcmData(byte[] object, int n10, long l10) {
        Object object2 = this.mWeakRefListener;
        object2 = object2 != null ? (c)((Reference)object2).get() : null;
        if (object2 != null) {
            object2.onAudioRecordPCM((byte[])object, n10, l10);
        } else {
            object = TAG;
            String string2 = "onRecordPcmData:no callback";
            TXCLog.e((String)object, string2);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    private void onRecordStart() {
        // MONITORENTER : this
        Object object = this.mWeakRefListener;
        if (object != null) {
            object = ((Reference)object).get();
            object = (c)object;
        } else {
            object = null;
        }
        // MONITOREXIT : this
        if (object != null) {
            object.onAudioRecordStart();
            return;
        }
        object = TAG;
        String string2 = "onRecordStart:no callback";
        TXCLog.e((String)object, string2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    private void onRecordStop() {
        // MONITORENTER : this
        Object object = this.mWeakRefListener;
        if (object != null) {
            object = ((Reference)object).get();
            object = (c)object;
        } else {
            object = null;
        }
        // MONITOREXIT : this
        if (object != null) {
            object.onAudioRecordStop();
            return;
        }
        object = TAG;
        String string2 = "onRecordStop:no callback";
        TXCLog.e((String)object, string2);
    }

    private void uninit() {
        Object object = this.mMic;
        if (object != null) {
            object = TAG;
            String string2 = "stop mic";
            TXCLog.i((String)object, string2);
            object = this.mMic;
            object.setRecordPositionUpdateListener(null);
            object = this.mMic;
            object.stop();
            object = this.mMic;
            try {
                object.release();
            }
            catch (Exception exception) {
                string2 = TAG;
                String string3 = "stop AudioRecord failed.";
                TXCLog.e(string2, string3, exception);
            }
        }
        this.mMic = null;
        this.mRecordBuffer = null;
        this.mIsCapFirstFrame = false;
    }

    public boolean isRecording() {
        synchronized (this) {
            boolean bl2 = this.mIsRunning;
            return bl2;
        }
    }

    public void pause(boolean bl2) {
        TXCLog.i(TAG, "system audio record pause");
        this.mPause.set(true);
        this.mSendMuteData = bl2;
    }

    public void resume() {
        TXCLog.i(TAG, "system audio record resume");
        this.mPause.set(false);
    }

    public void run() {
        Object object;
        int n10;
        int n11;
        int n12;
        int n13 = this.mIsRunning;
        if (n13 == 0) {
            TXCLog.w(TAG, "audio record: abandom start audio sys record thread!");
            return;
        }
        this.onRecordStart();
        String string2 = TAG;
        Object object2 = new StringBuilder();
        ((StringBuilder)object2).append("start capture audio data ...,mIsRunning:");
        boolean bl2 = this.mIsRunning;
        ((StringBuilder)object2).append(bl2);
        ((StringBuilder)object2).append(" Thread.interrupted:");
        bl2 = Thread.interrupted();
        ((StringBuilder)object2).append(bl2);
        String string3 = " mMic:";
        ((StringBuilder)object2).append(string3);
        Object object3 = this.mMic;
        ((StringBuilder)object2).append(object3);
        object2 = ((StringBuilder)object2).toString();
        TXCLog.i(string2, (String)object2);
        this.init();
        n13 = 0;
        string2 = null;
        block0: while (true) {
            Object object4;
            Object object5;
            n12 = 0;
            object2 = null;
            int n14 = 0;
            object3 = null;
            while (true) {
                n11 = this.mIsRunning;
                n10 = 5;
                if (n11 == 0 || (n11 = Thread.interrupted()) != 0 || (object = this.mMic) == null || n12 > n10) break block0;
                System.currentTimeMillis();
                object = this.mMic;
                Object object6 = this.mRecordBuffer;
                int n15 = ((byte[])object6).length - n14;
                n11 = object.read(object6, n14, n15);
                object6 = this.mRecordBuffer;
                n10 = ((byte[])object6).length - n14;
                if (n11 == n10) break;
                if (n11 <= 0) {
                    object6 = TAG;
                    object5 = new StringBuilder();
                    object4 = "read pcm error, len =";
                    ((StringBuilder)object5).append((String)object4);
                    ((StringBuilder)object5).append(n11);
                    object = ((StringBuilder)object5).toString();
                    TXCLog.e((String)object6, (String)object);
                    ++n12;
                    continue;
                }
                n14 += n11;
            }
            n12 = (int)(this.mIsCapFirstFrame ? 1 : 0);
            n14 = 1;
            if (n12 == 0) {
                n12 = -6;
                object = "First frame captured#";
                this.onRecordError(n12, (String)object);
                this.mIsCapFirstFrame = n14;
            }
            if ((n12 = (int)(this.mSendMuteData ? 1 : 0)) != 0) {
                object2 = this.mRecordBuffer;
                Arrays.fill((byte[])object2, (byte)0);
            }
            if ((n12 = (int)(((AtomicBoolean)(object2 = this.mPause)).get() ? 1 : 0)) != 0 && (n12 = (int)(this.mSendMuteData ? 1 : 0)) == 0) {
                n14 = 0;
                object3 = null;
            }
            if (n14 == 0) continue;
            object2 = this.mRecordBuffer;
            n14 = ((Object)object2).length;
            long l10 = TXCTimeUtil.getTimeTick();
            this.onRecordPcmData((byte[])object2, n14, l10);
            object4 = this.mRecordBuffer;
            int n16 = ((Object)object4).length;
            int n17 = this.mSampleRate;
            int n18 = this.mChannels;
            int n19 = this.mBits;
            object5 = this;
            this.nativeSendSysRecordAudioData((byte[])object4, n16, n17, n18, n19);
        }
        string2 = TAG;
        object3 = new StringBuilder();
        object = "stop capture audio data ...,mIsRunning:";
        ((StringBuilder)object3).append((String)object);
        n11 = this.mIsRunning;
        ((StringBuilder)object3).append(n11 != 0);
        ((StringBuilder)object3).append(string3);
        string3 = this.mMic;
        ((StringBuilder)object3).append((Object)string3);
        ((StringBuilder)object3).append(" nFailedCount:");
        ((StringBuilder)object3).append(n12);
        string3 = ((StringBuilder)object3).toString();
        TXCLog.d(string2, string3);
        this.uninit();
        if (n12 > n10) {
            n13 = -1;
            object2 = "read data failed!";
            this.onRecordError(n13, (String)object2);
        } else {
            this.onRecordStop();
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void setAudioRecordListener(c c10) {
        synchronized (this) {
            if (c10 == null) {
                c10 = null;
                this.mWeakRefListener = null;
                return;
            }
            WeakReference<c> weakReference = new WeakReference<c>(c10);
            this.mWeakRefListener = weakReference;
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void start(int n10, int n11, int n12) {
        String string2 = TAG;
        TXCLog.i(string2, "start");
        Object object = this.threadMutex;
        synchronized (object) {
            Thread thread;
            this.stop();
            this.mSampleRate = n10;
            this.mChannels = n11;
            this.mBits = n12;
            n10 = 1;
            this.mIsRunning = n10;
            String string3 = "AudioSysRecord Thread";
            this.mRecordThread = thread = new Thread((Runnable)this, string3);
            thread.start();
        }
        TXCLog.i(string2, "start ok");
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void stop() {
        Object object;
        TXCLog.i(TAG, "stop");
        Object object2 = this.threadMutex;
        synchronized (object2) {
            CharSequence charSequence;
            Object object3;
            long l10;
            long l11;
            long l12;
            boolean bl2;
            String string2 = null;
            this.mIsRunning = false;
            long l13 = System.currentTimeMillis();
            object = this.mRecordThread;
            if (object != null && (bl2 = ((Thread)object).isAlive()) && (bl2 = (l12 = (l11 = ((Thread)(object = Thread.currentThread())).getId()) - (l10 = ((Thread)(object3 = this.mRecordThread)).getId())) == 0L ? 0 : (l12 < 0L ? -1 : 1))) {
                try {
                    object = this.mRecordThread;
                    ((Thread)object).join();
                }
                catch (Exception exception) {
                    charSequence = TAG;
                    object3 = new StringBuilder();
                    String string3 = "record stop Exception: ";
                    ((StringBuilder)object3).append(string3);
                    object = exception.getMessage();
                    ((StringBuilder)object3).append((String)object);
                    object = ((StringBuilder)object3).toString();
                    TXCLog.e((String)charSequence, (String)object);
                }
            }
            object = TAG;
            charSequence = new StringBuilder();
            object3 = "stop ok,stop record cost time(MS): ";
            charSequence.append((String)object3);
            l10 = System.currentTimeMillis() - l13;
            charSequence.append(l10);
            string2 = charSequence.toString();
            TXCLog.i((String)object, string2);
            string2 = null;
            this.mRecordThread = null;
        }
        TXCLog.i((String)object, "stop ok");
    }
}

