/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.tencent.liteav.audio;

import android.content.Context;
import com.tencent.liteav.audio.TXCAudioEngine;
import com.tencent.liteav.audio.f;
import com.tencent.liteav.audio.impl.Record.TXCAudioSysRecord;
import com.tencent.liteav.audio.impl.Record.a;
import com.tencent.liteav.audio.impl.Record.c;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.g;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class TXCAudioUGCRecorder
implements c {
    private static final TXCAudioUGCRecorder INSTANCE;
    private static final String TAG = "AudioCenter:TXCAudioUGCRecorder";
    private final int AAC_SAMPLE_NUM;
    public int mAACFrameLength;
    public int mAECType;
    private a mBGMRecorder;
    public int mBits;
    public int mChannels;
    public Context mContext;
    private boolean mCurBGMRecordFlag;
    private boolean mEnableBGMRecord;
    private final List mEncodedAudioList;
    public boolean mIsEarphoneOn;
    private boolean mIsMute;
    private boolean mIsPause;
    private boolean mIsRunning;
    private long mLastPTS;
    public int mReverbType;
    public AtomicInteger mSampleRate;
    private int mShouldClearAACDataCnt;
    private AtomicReference mSpeedRate;
    public int mVoiceChangerType;
    private float mVolume;
    private WeakReference mWeakRecordListener;

    static {
        TXCAudioUGCRecorder tXCAudioUGCRecorder;
        g.f();
        INSTANCE = tXCAudioUGCRecorder = new TXCAudioUGCRecorder();
    }

    private TXCAudioUGCRecorder() {
        ArrayList arrayList;
        AtomicReference<AtomicInteger> atomicReference;
        float f10;
        int n10;
        int n11;
        Number number;
        int n12;
        this.AAC_SAMPLE_NUM = n12 = 1024;
        this.mSampleRate = number = new AtomicInteger(48000);
        this.mChannels = n11 = 1;
        this.mBits = n10 = 16;
        this.mAACFrameLength = n11 = n11 * n12 * n10 / 8;
        this.mReverbType = 0;
        this.mVoiceChangerType = 0;
        this.mAECType = 0;
        this.mIsEarphoneOn = false;
        this.mLastPTS = 0L;
        this.mVolume = f10 = 1.0f;
        this.mBGMRecorder = null;
        this.mEnableBGMRecord = false;
        this.mShouldClearAACDataCnt = 0;
        this.mCurBGMRecordFlag = false;
        number = Float.valueOf(f10);
        this.mSpeedRate = atomicReference = new AtomicReference<AtomicInteger>((AtomicInteger)number);
        this.mIsRunning = false;
        this.mIsPause = false;
        this.mIsMute = false;
        this.mEncodedAudioList = arrayList = new ArrayList();
        TXCAudioSysRecord.getInstance();
        this.nativeClassInit();
    }

    public static TXCAudioUGCRecorder getInstance() {
        return INSTANCE;
    }

    private native void nativeClassInit();

    private native void nativeEnableMixMode(boolean var1);

    private native void nativeSetChangerType(int var1);

    private native void nativeSetReverbType(int var1);

    private native void nativeSetSpeedRate(float var1);

    private native void nativeSetVolume(float var1);

    private native void nativeStartAudioRecord(int var1, int var2, int var3);

    private native void nativeStopAudioRecord();

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void updateAudioEffector() {
        synchronized (this) {
            int n10 = 0;
            float f10 = 0.0f;
            Serializable serializable = null;
            int n11 = this.mEnableBGMRecord;
            int n12 = 1;
            float f11 = Float.MIN_VALUE;
            if (n11 != 0 || (n11 = this.mAECType) == n12) {
                n10 = n12;
                f10 = f11;
            }
            n11 = 0;
            if (n10 == 0) {
                n12 = this.mReverbType;
                this.nativeSetReverbType(n12);
                n12 = this.mVoiceChangerType;
                this.nativeSetChangerType(n12);
                n12 = (int)(this.mIsMute ? 1 : 0);
                if (n12 != 0) {
                    this.nativeSetVolume(0.0f);
                } else {
                    f11 = this.mVolume;
                    this.nativeSetVolume(f11);
                }
            }
            if (n10 != 0) {
                this.nativeSetVolume(0.0f);
            }
            this.nativeEnableMixMode(n10 != 0);
            serializable = this.mSpeedRate;
            serializable = ((AtomicReference)serializable).get();
            serializable = (Float)serializable;
            f10 = ((Float)serializable).floatValue();
            this.nativeSetSpeedRate(f10);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void clearCache() {
        synchronized (this) {
            Object object = "AudioCenter:TXCAudioUGCRecorder";
            Object object2 = "clearCache";
            TXCLog.i((String)object, (String)object2);
            object = this.mEncodedAudioList;
            synchronized (object) {
                object2 = this.mEncodedAudioList;
                object2.clear();
                return;
            }
        }
    }

    public void enableBGMRecord(boolean n10) {
        CharSequence charSequence = new StringBuilder();
        charSequence.append("enableBGMRecord: ");
        charSequence.append(n10 != 0);
        charSequence = charSequence.toString();
        String string2 = "AudioCenter:TXCAudioUGCRecorder";
        TXCLog.i(string2, (String)charSequence);
        int n11 = this.mEnableBGMRecord;
        if (n11 != n10 && !n10) {
            this.mShouldClearAACDataCnt = n11 = 2;
        }
        this.mEnableBGMRecord = n10;
        this.updateAudioEffector();
    }

    public int getChannels() {
        return this.mChannels;
    }

    public f getListener() {
        WeakReference weakReference = this.mWeakRecordListener;
        if (weakReference != null) {
            return (f)weakReference.get();
        }
        return null;
    }

    public int getSampleRate() {
        return this.mSampleRate.get();
    }

    public boolean isPaused() {
        return this.mIsPause;
    }

    public boolean isRecording() {
        return this.mIsRunning;
    }

    public void onAudioRecordError(int n10, String string2) {
        Object object = new StringBuilder();
        ((StringBuilder)object).append("sys audio record error: ");
        ((StringBuilder)object).append(n10);
        ((StringBuilder)object).append(", ");
        ((StringBuilder)object).append(string2);
        object = ((StringBuilder)object).toString();
        String string3 = "AudioCenter:TXCAudioUGCRecorder";
        TXCLog.e(string3, (String)object);
        object = this.getListener();
        if (object != null) {
            object.a(n10, string2);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onAudioRecordPCM(byte[] object, int n10, long l10) {
        Object object2;
        long l11 = this.mLastPTS;
        long l12 = l11 - l10;
        Object object3 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object3 >= 0) {
            l10 = (long)2 + l11;
        }
        do {
            object = this.mEncodedAudioList;
            synchronized (object) {
                object2 = this.mEncodedAudioList;
                n10 = (int)(object2.isEmpty() ? 1 : 0);
                object3 = 0;
                float f10 = 0.0f;
                Object object4 = null;
                if (n10 != 0) return;
                n10 = (int)(this.mIsPause ? 1 : 0);
                if (n10 != 0) return;
                object2 = this.mEncodedAudioList;
                int n11 = 0;
                float f11 = 0.0f;
                Object object5 = null;
                object2 = object2.get(0);
                object2 = (byte[])object2;
                Object object6 = this.mEncodedAudioList;
                object6.remove(0);
                n11 = this.mShouldClearAACDataCnt;
                if (n11 > 0) {
                    this.mShouldClearAACDataCnt = n11 += -1;
                    return;
                }
                if (object2 != null) {
                    this.mLastPTS = l10;
                    object4 = this.getListener();
                    if (object4 != null) {
                        object5 = this.mSampleRate;
                        int n12 = ((AtomicInteger)object5).get();
                        int n13 = this.mChannels;
                        int n14 = this.mBits;
                        object5 = object2;
                        object4.b((byte[])object2, l10, n12, n13, n14);
                    } else {
                        object4 = "AudioCenter:TXCAudioUGCRecorder";
                        object5 = "onAudioRecordPCM listener is null";
                        TXCLog.e((String)object4, (String)object5);
                    }
                    object4 = this.mSampleRate;
                    object3 = ((AtomicInteger)object4).get();
                    if (object3 > 0) {
                        n11 = 1232732160;
                        f11 = 1024000.0f;
                        object6 = this.mSpeedRate;
                        object6 = ((AtomicReference)object6).get();
                        object6 = (Float)object6;
                        float f12 = ((Float)object6).floatValue() * f11;
                        f10 = object3;
                        long l13 = (long)(f12 /= f10);
                        l10 += l13;
                    }
                }
            }
        } while (object2 != null);
    }

    public void onAudioRecordStart() {
        TXCLog.i("AudioCenter:TXCAudioUGCRecorder", "sys audio record start");
    }

    public void onAudioRecordStop() {
        TXCLog.i("AudioCenter:TXCAudioUGCRecorder", "sys audio record stop");
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onEncodedData(byte[] byArray) {
        List list = this.mEncodedAudioList;
        synchronized (list) {
            List list2 = this.mEncodedAudioList;
            list2.add(byArray);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void pause() {
        String string2 = "pause";
        TXCLog.i("AudioCenter:TXCAudioUGCRecorder", string2);
        TXCAudioEngine.getInstance().pauseLocalAudio();
        List list = this.mEncodedAudioList;
        synchronized (list) {
            boolean bl2;
            this.mIsPause = bl2 = true;
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void resume() {
        TXCLog.i("AudioCenter:TXCAudioUGCRecorder", "resume");
        TXCAudioEngine.getInstance().resumeLocalAudio();
        List list = this.mEncodedAudioList;
        synchronized (list) {
            Object var2_2 = null;
            this.mIsPause = false;
        }
        boolean bl2 = this.mEnableBGMRecord;
        this.nativeEnableMixMode(bl2);
        bl2 = this.mIsMute;
        if (!bl2 && !(bl2 = this.mEnableBGMRecord)) {
            float f10 = this.mVolume;
            this.nativeSetVolume(f10);
            return;
        }
        bl2 = false;
        float f11 = 0.0f;
        list = null;
        this.nativeSetVolume(0.0f);
    }

    public void setAECType(int n10, Context context) {
        CharSequence charSequence = new StringBuilder();
        charSequence.append("setAECType: ");
        charSequence.append(n10);
        charSequence = charSequence.toString();
        String string2 = "AudioCenter:TXCAudioUGCRecorder";
        TXCLog.i(string2, (String)charSequence);
        this.mAECType = n10;
        if (context != null) {
            Context context2;
            this.mContext = context2 = context.getApplicationContext();
        }
    }

    public void setChangerType(int n10) {
        synchronized (this) {
            String string2 = "AudioCenter:TXCAudioUGCRecorder";
            CharSequence charSequence = new StringBuilder();
            String string3 = "setChangerType: ";
            charSequence.append(string3);
            charSequence.append(n10);
            charSequence = charSequence.toString();
            TXCLog.i(string2, (String)charSequence);
            this.mVoiceChangerType = n10;
            this.nativeSetChangerType(n10);
            return;
        }
    }

    public void setChannels(int n10) {
        CharSequence charSequence = new StringBuilder();
        charSequence.append("setChannels: ");
        charSequence.append(n10);
        charSequence = charSequence.toString();
        TXCLog.i("AudioCenter:TXCAudioUGCRecorder", (String)charSequence);
        this.mChannels = n10;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void setListener(f f10) {
        synchronized (this) {
            if (f10 == null) {
                f10 = null;
                this.mWeakRecordListener = null;
                return;
            }
            WeakReference<f> weakReference = new WeakReference<f>(f10);
            this.mWeakRecordListener = weakReference;
            return;
        }
    }

    public void setMute(boolean bl2) {
        CharSequence charSequence = new StringBuilder();
        charSequence.append("setMute: ");
        charSequence.append(bl2);
        charSequence = charSequence.toString();
        String string2 = "AudioCenter:TXCAudioUGCRecorder";
        TXCLog.i(string2, (String)charSequence);
        this.mIsMute = bl2;
        if (bl2) {
            bl2 = false;
            float f10 = 0.0f;
            this.nativeSetVolume(0.0f);
        } else {
            float f11 = this.mVolume;
            this.nativeSetVolume(f11);
        }
    }

    public void setReverbType(int n10) {
        synchronized (this) {
            String string2 = "AudioCenter:TXCAudioUGCRecorder";
            CharSequence charSequence = new StringBuilder();
            String string3 = "setReverbType: ";
            charSequence.append(string3);
            charSequence.append(n10);
            charSequence = charSequence.toString();
            TXCLog.i(string2, (String)charSequence);
            this.mReverbType = n10;
            this.nativeSetReverbType(n10);
            return;
        }
    }

    public void setSampleRate(int n10) {
        CharSequence charSequence = new StringBuilder();
        charSequence.append("setSampleRate: ");
        charSequence.append(n10);
        charSequence = charSequence.toString();
        TXCLog.i("AudioCenter:TXCAudioUGCRecorder", (String)charSequence);
        this.mSampleRate.set(n10);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void setSpeedRate(float f10) {
        synchronized (this) {
            Object object = "AudioCenter:TXCAudioUGCRecorder";
            StringBuilder stringBuilder = new StringBuilder();
            String string2 = "setSpeedRate: ";
            stringBuilder.append(string2);
            stringBuilder.append(f10);
            String string3 = stringBuilder.toString();
            TXCLog.i((String)object, string3);
            object = this.mSpeedRate;
            Serializable serializable = Float.valueOf(f10);
            ((AtomicReference)object).set(serializable);
            serializable = this.mSpeedRate;
            serializable = ((AtomicReference)serializable).get();
            f10 = ((Float)serializable).floatValue();
            this.nativeSetSpeedRate(f10);
            return;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void setVolume(float f10) {
        synchronized (this) {
            block11: {
                String string2 = "AudioCenter:TXCAudioUGCRecorder";
                StringBuilder stringBuilder = new StringBuilder();
                String string3 = "setVolume: ";
                stringBuilder.append(string3);
                stringBuilder.append(f10);
                String string4 = stringBuilder.toString();
                TXCLog.i(string2, string4);
                this.mVolume = f10;
                boolean bl2 = this.mIsMute;
                if (!bl2) break block11;
                f10 = 0.0f;
                Object var6_7 = null;
                this.nativeSetVolume(0.0f);
                return;
            }
            this.nativeSetVolume(f10);
            return;
        }
    }

    public int startRecord(Context context) {
        String string2 = "AudioCenter:TXCAudioUGCRecorder";
        String string3 = "startRecord";
        TXCLog.i(string2, string3);
        if (context != null) {
            this.mContext = context = context.getApplicationContext();
        }
        this.updateAudioEffector();
        TXCAudioSysRecord.getInstance().setAudioRecordListener(this);
        int n10 = this.mSampleRate.get();
        int n11 = this.mChannels;
        int n12 = this.mBits;
        this.nativeStartAudioRecord(n10, n11, n12);
        this.mIsRunning = true;
        this.mLastPTS = 0L;
        return 0;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public int stopRecord() {
        TXCLog.i("AudioCenter:TXCAudioUGCRecorder", "stopRecord");
        Runnable runnable = TXCAudioSysRecord.getInstance();
        float f10 = 0.0f;
        List list = null;
        ((TXCAudioSysRecord)runnable).setAudioRecordListener(null);
        runnable = this.mBGMRecorder;
        if (runnable != null) {
            ((a)runnable).a();
            this.mBGMRecorder = null;
        }
        this.nativeStopAudioRecord();
        runnable = null;
        this.nativeEnableMixMode(false);
        f10 = 1.0f;
        this.nativeSetVolume(f10);
        list = this.mEncodedAudioList;
        synchronized (list) {
            List list2 = this.mEncodedAudioList;
            list2.clear();
        }
        this.mIsRunning = false;
        this.mLastPTS = 0L;
        this.mIsPause = false;
        this.mIsMute = false;
        this.mShouldClearAACDataCnt = 0;
        return 0;
    }
}

