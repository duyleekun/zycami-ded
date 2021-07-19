/*
 * Decompiled with CFR 0.151.
 */
package com.meicam.sdk;

import com.meicam.sdk.NvsWaveformDataGenerator;
import com.meicam.sdk.NvsWaveformDataGenerator$WaveformDataCallback;

public class NvsWaveformDataGenerator$1
implements Runnable {
    public final /* synthetic */ NvsWaveformDataGenerator this$0;
    public final /* synthetic */ String val$audioFilePath;
    public final /* synthetic */ long val$audioFileSampleCount;
    public final /* synthetic */ float[] val$leftWaveformData;
    public final /* synthetic */ float[] val$rightWaveformData;
    public final /* synthetic */ long val$samplesPerGroup;
    public final /* synthetic */ long val$tid;
    public final /* synthetic */ NvsWaveformDataGenerator$WaveformDataCallback val$waveformDataCallback;

    public NvsWaveformDataGenerator$1(NvsWaveformDataGenerator nvsWaveformDataGenerator, NvsWaveformDataGenerator$WaveformDataCallback nvsWaveformDataGenerator$WaveformDataCallback, long l10, String string2, long l11, long l12, float[] fArray, float[] fArray2) {
        this.this$0 = nvsWaveformDataGenerator;
        this.val$waveformDataCallback = nvsWaveformDataGenerator$WaveformDataCallback;
        this.val$tid = l10;
        this.val$audioFilePath = string2;
        this.val$audioFileSampleCount = l11;
        this.val$samplesPerGroup = l12;
        this.val$leftWaveformData = fArray;
        this.val$rightWaveformData = fArray2;
    }

    public void run() {
        NvsWaveformDataGenerator$WaveformDataCallback nvsWaveformDataGenerator$WaveformDataCallback = this.val$waveformDataCallback;
        long l10 = this.val$tid;
        String string2 = this.val$audioFilePath;
        long l11 = this.val$audioFileSampleCount;
        long l12 = this.val$samplesPerGroup;
        float[] fArray = this.val$leftWaveformData;
        float[] fArray2 = this.val$rightWaveformData;
        nvsWaveformDataGenerator$WaveformDataCallback.onWaveformDataReady(l10, string2, l11, l12, fArray, fArray2);
    }
}

