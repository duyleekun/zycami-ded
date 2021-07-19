/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Looper
 */
package com.meicam.sdk;

import android.os.Handler;
import android.os.Looper;
import com.meicam.sdk.NvsUtils;
import com.meicam.sdk.NvsWaveformDataGenerator$1;
import com.meicam.sdk.NvsWaveformDataGenerator$Task;
import com.meicam.sdk.NvsWaveformDataGenerator$WaveformDataCallback;
import java.util.HashMap;
import java.util.Iterator;

public class NvsWaveformDataGenerator {
    private final String TAG;
    private boolean m_fetchingWaveformData;
    private long m_nextTaskId;
    private HashMap m_taskMap;
    private float[] m_tmpLeftWaveformData;
    private float[] m_tmpRightWaveformData;
    private long m_tmpSamplesPerGroup;
    private long m_tmpWaveformTaskId;
    private NvsWaveformDataGenerator$WaveformDataCallback m_waveformDataCallback;
    private long m_waveformDataGenerator;

    public NvsWaveformDataGenerator() {
        HashMap hashMap;
        long l10;
        this.TAG = "Meicam";
        this.m_waveformDataGenerator = l10 = 0L;
        this.m_nextTaskId = 1L;
        this.m_fetchingWaveformData = false;
        this.m_tmpWaveformTaskId = l10;
        this.m_tmpSamplesPerGroup = l10;
        this.m_taskMap = hashMap = new HashMap();
        NvsUtils.checkFunctionInMainThread();
        this.m_waveformDataGenerator = l10 = this.nativeInit();
    }

    private void finishWaveformDataFetchingTask(long l10, boolean bl2) {
        Object object = this.m_taskMap;
        Object object2 = l10;
        object = (NvsWaveformDataGenerator$Task)((HashMap)object).get(object2);
        object2 = this.m_taskMap;
        Object object3 = l10;
        ((HashMap)object2).remove(object3);
        if (object == null) {
            return;
        }
        NvsWaveformDataGenerator$WaveformDataCallback nvsWaveformDataGenerator$WaveformDataCallback = this.m_waveformDataCallback;
        if (nvsWaveformDataGenerator$WaveformDataCallback == null) {
            return;
        }
        String string2 = ((NvsWaveformDataGenerator$Task)object).m_audioFilePath;
        long l11 = ((NvsWaveformDataGenerator$Task)object).m_audioFileSampleCount;
        long l12 = NvsWaveformDataGenerator$Task.access$100((NvsWaveformDataGenerator$Task)object);
        float[] fArray = NvsWaveformDataGenerator$Task.access$200((NvsWaveformDataGenerator$Task)object);
        float[] fArray2 = NvsWaveformDataGenerator$Task.access$300((NvsWaveformDataGenerator$Task)object);
        if (!bl2) {
            nvsWaveformDataGenerator$WaveformDataCallback.onWaveformDataReady(l10, string2, l11, l12, fArray, fArray2);
        } else {
            NvsWaveformDataGenerator$1 nvsWaveformDataGenerator$1;
            object = Looper.getMainLooper();
            Handler handler = new Handler((Looper)object);
            object = nvsWaveformDataGenerator$1;
            object2 = this;
            object3 = nvsWaveformDataGenerator$WaveformDataCallback;
            nvsWaveformDataGenerator$1 = new NvsWaveformDataGenerator$1(this, nvsWaveformDataGenerator$WaveformDataCallback, l10, string2, l11, l12, fArray, fArray2);
            handler.post((Runnable)nvsWaveformDataGenerator$1);
        }
    }

    private native void nativeCancelTask(long var1);

    private native void nativeClose(long var1);

    private native long nativeFetchWaveformData(long var1, String var3, long var4, long var6, long var8);

    private native long nativeGetAudioFileDuration(String var1);

    private native long nativeGetAudioFileSampleCount(String var1);

    private native long nativeInit();

    public void cancelTask(long l10) {
        NvsUtils.checkFunctionInMainThread();
        Object object = this.m_taskMap;
        Long l11 = l10;
        object = (NvsWaveformDataGenerator$Task)((HashMap)object).get(l11);
        if (object != null) {
            boolean bl2 = this.isReleased();
            if (!bl2) {
                long l12 = ((NvsWaveformDataGenerator$Task)object).waveformTaskId;
                this.nativeCancelTask(l12);
            }
            object = this.m_taskMap;
            Long l13 = l10;
            ((HashMap)object).remove(l13);
        }
    }

    public long generateWaveformData(String string2, long l10, long l11, long l12, int n10) {
        NvsWaveformDataGenerator nvsWaveformDataGenerator = this;
        NvsUtils.checkFunctionInMainThread();
        int n11 = this.isReleased();
        long l13 = 0L;
        if (n11 != 0) {
            return l13;
        }
        if (string2 != null && (n11 = l10 == l13 ? 0 : (l10 < l13 ? -1 : 1)) > 0) {
            boolean bl2;
            long l14 = this.nativeGetAudioFileSampleCount(string2);
            long l15 = l14 - l13;
            n11 = (int)(l15 == 0L ? 0 : (l15 < 0L ? -1 : 1));
            if (n11 <= 0) {
                return l13;
            }
            this.m_fetchingWaveformData = bl2 = true;
            long l16 = this.m_waveformDataGenerator;
            Object object = this;
            long l17 = l10;
            long l18 = l11;
            long l19 = this.nativeFetchWaveformData(l16, string2, l10, l11, l12);
            NvsWaveformDataGenerator$Task nvsWaveformDataGenerator$Task = null;
            this.m_fetchingWaveformData = false;
            Object object2 = l19 == l13 ? 0 : (l19 < l13 ? -1 : 1);
            if (object2 == false) {
                return l13;
            }
            nvsWaveformDataGenerator$Task = new NvsWaveformDataGenerator$Task(null);
            l17 = this.m_nextTaskId;
            this.m_nextTaskId = l18 = 1L + l17;
            nvsWaveformDataGenerator$Task.taskId = l17;
            nvsWaveformDataGenerator$Task.waveformTaskId = l19;
            nvsWaveformDataGenerator$Task.m_audioFilePath = string2;
            nvsWaveformDataGenerator$Task.m_audioFileSampleCount = l14;
            object = this.m_taskMap;
            Object object3 = l17;
            ((HashMap)object).put(object3, nvsWaveformDataGenerator$Task);
            l19 = this.m_tmpWaveformTaskId;
            n11 = (int)(l19 == l13 ? 0 : (l19 < l13 ? -1 : 1));
            if (n11 > 0) {
                boolean bl3;
                object = this.m_taskMap.entrySet().iterator();
                while (bl3 = object.hasNext()) {
                    object3 = (NvsWaveformDataGenerator$Task)object.next().getValue();
                    l17 = ((NvsWaveformDataGenerator$Task)object3).waveformTaskId;
                    l18 = nvsWaveformDataGenerator.m_tmpWaveformTaskId;
                    long l20 = l17 - l18;
                    Object object4 = l20 == 0L ? 0 : (l20 < 0L ? -1 : 1);
                    if (object4 != false) continue;
                    l17 = nvsWaveformDataGenerator.m_tmpSamplesPerGroup;
                    NvsWaveformDataGenerator$Task.access$102((NvsWaveformDataGenerator$Task)object3, l17);
                    object = nvsWaveformDataGenerator.m_tmpLeftWaveformData;
                    NvsWaveformDataGenerator$Task.access$202((NvsWaveformDataGenerator$Task)object3, (float[])object);
                    object = nvsWaveformDataGenerator.m_tmpRightWaveformData;
                    NvsWaveformDataGenerator$Task.access$302((NvsWaveformDataGenerator$Task)object3, (float[])object);
                    l19 = ((NvsWaveformDataGenerator$Task)object3).taskId;
                    object4 = 1;
                    nvsWaveformDataGenerator.finishWaveformDataFetchingTask(l19, (boolean)object4);
                    break;
                }
                nvsWaveformDataGenerator.m_tmpWaveformTaskId = l13;
                nvsWaveformDataGenerator.m_tmpLeftWaveformData = null;
                nvsWaveformDataGenerator.m_tmpRightWaveformData = null;
                nvsWaveformDataGenerator.m_tmpSamplesPerGroup = l13;
            }
            return nvsWaveformDataGenerator$Task.taskId;
        }
        return l13;
    }

    public long getAudioFileDuration(String string2) {
        NvsUtils.checkFunctionInMainThread();
        if (string2 == null) {
            return 0L;
        }
        return this.nativeGetAudioFileDuration(string2);
    }

    public long getAudioFileSampleCount(String string2) {
        NvsUtils.checkFunctionInMainThread();
        if (string2 == null) {
            return 0L;
        }
        return this.nativeGetAudioFileSampleCount(string2);
    }

    public boolean isReleased() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_waveformDataGenerator;
        long l11 = 0L;
        long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        l12 = l12 == false ? (long)1 : (long)0;
        return (boolean)l12;
    }

    public void notifyWaveformDataFailed(long l10, long l11) {
        Object object;
        long l12;
        Object object2;
        long l13;
        block4: {
            Object object3;
            block3: {
                Object object4;
                long l14;
                long l15;
                long l16;
                object3 = this.m_taskMap.entrySet().iterator();
                do {
                    boolean bl2 = object3.hasNext();
                    l13 = 0L;
                    if (!bl2) break block3;
                    object4 = (NvsWaveformDataGenerator$Task)object3.next().getValue();
                } while ((l16 = (l15 = (l14 = ((NvsWaveformDataGenerator$Task)object4).waveformTaskId) - l10) == 0L ? 0 : (l15 < 0L ? -1 : 1)) != false);
                l10 = ((NvsWaveformDataGenerator$Task)object4).taskId;
                object3 = ((NvsWaveformDataGenerator$Task)object4).m_audioFilePath;
                object4 = this.m_taskMap;
                object2 = l10;
                ((HashMap)object4).remove(object2);
                l12 = l10;
                object = object3;
                break block4;
            }
            object3 = null;
            object = null;
            l12 = l13;
        }
        object2 = this.m_waveformDataCallback;
        if (object2 == null) {
            return;
        }
        Object object5 = l12 == l13 ? 0 : (l12 < l13 ? -1 : 1);
        if (object5 != false && object != null) {
            object2.onWaveformDataGenerationFailed(l12, (String)object, l11);
        }
    }

    public void notifyWaveformDataReady(long l10, long l11, long l12, float[] fArray, float[] fArray2) {
        block5: {
            block3: {
                long l13;
                block4: {
                    block2: {
                        NvsWaveformDataGenerator$Task nvsWaveformDataGenerator$Task;
                        long l14;
                        long l15;
                        long l16;
                        boolean bl2 = this.m_fetchingWaveformData;
                        if (bl2) break block3;
                        Iterator iterator2 = this.m_taskMap.entrySet().iterator();
                        do {
                            boolean bl3 = iterator2.hasNext();
                            l13 = 0L;
                            if (!bl3) break block2;
                            nvsWaveformDataGenerator$Task = (NvsWaveformDataGenerator$Task)iterator2.next().getValue();
                        } while ((l16 = (l15 = (l14 = nvsWaveformDataGenerator$Task.waveformTaskId) - l10) == 0L ? 0 : (l15 < 0L ? -1 : 1)) != false);
                        NvsWaveformDataGenerator$Task.access$102(nvsWaveformDataGenerator$Task, l11);
                        NvsWaveformDataGenerator$Task.access$202(nvsWaveformDataGenerator$Task, fArray);
                        NvsWaveformDataGenerator$Task.access$302(nvsWaveformDataGenerator$Task, fArray2);
                        l10 = nvsWaveformDataGenerator$Task.taskId;
                        break block4;
                    }
                    l10 = l13;
                }
                long l17 = l10 == l13 ? 0 : (l10 < l13 ? -1 : 1);
                if (l17 != false) {
                    l17 = 0;
                    this.finishWaveformDataFetchingTask(l10, false);
                }
                break block5;
            }
            this.m_tmpWaveformTaskId = l10;
            this.m_tmpSamplesPerGroup = l11;
            this.m_tmpLeftWaveformData = fArray;
            this.m_tmpRightWaveformData = fArray2;
        }
    }

    public void release() {
        boolean bl2;
        NvsUtils.checkFunctionInMainThread();
        boolean bl3 = this.isReleased();
        if (bl3) {
            return;
        }
        Iterator iterator2 = this.m_taskMap.entrySet().iterator();
        while (bl2 = iterator2.hasNext()) {
            NvsWaveformDataGenerator$Task nvsWaveformDataGenerator$Task = (NvsWaveformDataGenerator$Task)iterator2.next().getValue();
            long l10 = nvsWaveformDataGenerator$Task.waveformTaskId;
            this.nativeCancelTask(l10);
        }
        this.m_taskMap.clear();
        this.m_waveformDataCallback = null;
        long l11 = this.m_waveformDataGenerator;
        this.nativeClose(l11);
        this.m_waveformDataGenerator = 0L;
    }

    public void setWaveformDataCallback(NvsWaveformDataGenerator$WaveformDataCallback nvsWaveformDataGenerator$WaveformDataCallback) {
        NvsUtils.checkFunctionInMainThread();
        this.m_waveformDataCallback = nvsWaveformDataGenerator$WaveformDataCallback;
    }
}

