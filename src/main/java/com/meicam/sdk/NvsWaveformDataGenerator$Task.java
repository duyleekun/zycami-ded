/*
 * Decompiled with CFR 0.151.
 */
package com.meicam.sdk;

import com.meicam.sdk.NvsWaveformDataGenerator$1;

public class NvsWaveformDataGenerator$Task {
    public String m_audioFilePath;
    public long m_audioFileSampleCount;
    private float[] m_leftWaveformData;
    private float[] m_rightWaveformData;
    private long m_samplesPerGroup;
    public long taskId;
    public long waveformTaskId;

    private NvsWaveformDataGenerator$Task() {
    }

    public /* synthetic */ NvsWaveformDataGenerator$Task(NvsWaveformDataGenerator$1 nvsWaveformDataGenerator$1) {
        this();
    }

    public static /* synthetic */ long access$100(NvsWaveformDataGenerator$Task nvsWaveformDataGenerator$Task) {
        return nvsWaveformDataGenerator$Task.m_samplesPerGroup;
    }

    public static /* synthetic */ long access$102(NvsWaveformDataGenerator$Task nvsWaveformDataGenerator$Task, long l10) {
        nvsWaveformDataGenerator$Task.m_samplesPerGroup = l10;
        return l10;
    }

    public static /* synthetic */ float[] access$200(NvsWaveformDataGenerator$Task nvsWaveformDataGenerator$Task) {
        return nvsWaveformDataGenerator$Task.m_leftWaveformData;
    }

    public static /* synthetic */ float[] access$202(NvsWaveformDataGenerator$Task nvsWaveformDataGenerator$Task, float[] fArray) {
        nvsWaveformDataGenerator$Task.m_leftWaveformData = fArray;
        return fArray;
    }

    public static /* synthetic */ float[] access$300(NvsWaveformDataGenerator$Task nvsWaveformDataGenerator$Task) {
        return nvsWaveformDataGenerator$Task.m_rightWaveformData;
    }

    public static /* synthetic */ float[] access$302(NvsWaveformDataGenerator$Task nvsWaveformDataGenerator$Task, float[] fArray) {
        nvsWaveformDataGenerator$Task.m_rightWaveformData = fArray;
        return fArray;
    }
}

