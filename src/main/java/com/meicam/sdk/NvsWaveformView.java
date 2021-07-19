/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Canvas
 *  android.graphics.Color
 *  android.graphics.Paint
 *  android.graphics.Paint$Style
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.PorterDuffXfermode
 *  android.graphics.Rect
 *  android.graphics.Xfermode
 *  android.util.AttributeSet
 *  android.view.View
 */
package com.meicam.sdk;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Xfermode;
import android.util.AttributeSet;
import android.view.View;
import com.meicam.sdk.NvsUtils;
import com.meicam.sdk.NvsWaveformDataGenerator;
import com.meicam.sdk.NvsWaveformDataGenerator$WaveformDataCallback;

public class NvsWaveformView
extends View
implements NvsWaveformDataGenerator$WaveformDataCallback {
    private long m_audioFileDuration;
    private String m_audioFilePath;
    private long m_audioFileSampleCount;
    private long m_currentTaskId;
    private float[] m_leftWaveformData;
    private boolean m_needUpdateWaveformData;
    private float[] m_rightWaveformData;
    private long m_samplesPerGroup;
    private boolean m_singleChannelMode;
    private long m_trimIn;
    private long m_trimOut;
    private int m_waveformColor;
    private NvsWaveformDataGenerator m_waveformDataGenerator;

    public NvsWaveformView(Context context) {
        super(context);
        long l10;
        this.m_audioFileDuration = l10 = 0L;
        this.m_audioFileSampleCount = l10;
        this.m_trimIn = l10;
        this.m_trimOut = l10;
        this.m_waveformColor = -16777216;
        this.m_singleChannelMode = false;
        this.m_needUpdateWaveformData = false;
        this.m_currentTaskId = l10;
        this.m_samplesPerGroup = l10;
        NvsUtils.checkFunctionInMainThread();
        this.init();
    }

    public NvsWaveformView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        long l10;
        this.m_audioFileDuration = l10 = 0L;
        this.m_audioFileSampleCount = l10;
        this.m_trimIn = l10;
        this.m_trimOut = l10;
        this.m_waveformColor = -16777216;
        this.m_singleChannelMode = false;
        this.m_needUpdateWaveformData = false;
        this.m_currentTaskId = l10;
        this.m_samplesPerGroup = l10;
        NvsUtils.checkFunctionInMainThread();
        this.init();
    }

    public NvsWaveformView(Context context, AttributeSet attributeSet, int n10) {
        super(context, attributeSet, n10);
        long l10;
        this.m_audioFileDuration = l10 = 0L;
        this.m_audioFileSampleCount = l10;
        this.m_trimIn = l10;
        this.m_trimOut = l10;
        this.m_waveformColor = -16777216;
        this.m_singleChannelMode = false;
        this.m_needUpdateWaveformData = false;
        this.m_currentTaskId = l10;
        this.m_samplesPerGroup = l10;
        NvsUtils.checkFunctionInMainThread();
        this.init();
    }

    public NvsWaveformView(Context context, AttributeSet attributeSet, int n10, int n11) {
        super(context, attributeSet, n10, n11);
        long l10;
        this.m_audioFileDuration = l10 = 0L;
        this.m_audioFileSampleCount = l10;
        this.m_trimIn = l10;
        this.m_trimOut = l10;
        this.m_waveformColor = -16777216;
        this.m_singleChannelMode = false;
        this.m_needUpdateWaveformData = false;
        this.m_currentTaskId = l10;
        this.m_samplesPerGroup = l10;
        NvsUtils.checkFunctionInMainThread();
        this.init();
    }

    private long calcExpectedSamplesPerGroup() {
        long l10 = this.m_trimOut;
        long l11 = this.m_trimIn;
        double d10 = l10 - l11;
        double d11 = this.m_audioFileDuration;
        d10 /= d11;
        l11 = this.m_audioFileSampleCount;
        d11 = (double)l11 * d10;
        l10 = (long)d11;
        int n10 = this.getWidth();
        long l12 = 1L;
        if (n10 <= 0) {
            return l12;
        }
        long l13 = n10 / 2;
        l10 += l13;
        l13 = n10;
        return Math.max(l10 / l13, l12);
    }

    private void cancelCurrentTask() {
        long l10;
        long l11;
        long l12;
        long l13;
        boolean bl2 = this.isInEditMode();
        if (!bl2 && (l13 = (l12 = (l11 = this.m_currentTaskId) - (l10 = 0L)) == 0L ? 0 : (l12 < 0L ? -1 : 1)) != false) {
            NvsWaveformDataGenerator nvsWaveformDataGenerator = this.m_waveformDataGenerator;
            if (nvsWaveformDataGenerator != null) {
                nvsWaveformDataGenerator.cancelTask(l11);
            }
            this.m_currentTaskId = l10;
        }
    }

    private void init() {
        boolean bl2 = this.isInEditMode();
        if (!bl2) {
            NvsWaveformDataGenerator nvsWaveformDataGenerator;
            this.m_waveformDataGenerator = nvsWaveformDataGenerator = new NvsWaveformDataGenerator();
            nvsWaveformDataGenerator.setWaveformDataCallback(this);
        }
        this.setBackgroundColor(-1);
    }

    private void validateWaveformData() {
        long l10;
        long l11 = this.m_samplesPerGroup;
        long l12 = 0L;
        Object object = l11 == l12 ? 0 : (l11 < l12 ? -1 : 1);
        boolean bl2 = true;
        if (object <= 0) {
            this.m_needUpdateWaveformData = bl2;
            this.cancelCurrentTask();
            return;
        }
        l12 = this.calcExpectedSamplesPerGroup();
        long l13 = l12 - (l10 = this.m_samplesPerGroup);
        object = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (object != false) {
            this.m_needUpdateWaveformData = bl2;
            this.cancelCurrentTask();
            this.invalidate();
        }
    }

    public String getAudioFilePath() {
        NvsUtils.checkFunctionInMainThread();
        return this.m_audioFilePath;
    }

    public boolean getSingleChannelMode() {
        NvsUtils.checkFunctionInMainThread();
        return this.m_singleChannelMode;
    }

    public long getTrimIn() {
        NvsUtils.checkFunctionInMainThread();
        return this.m_trimIn;
    }

    public long getTrimOut() {
        NvsUtils.checkFunctionInMainThread();
        return this.m_trimOut;
    }

    public int getWaveformColor() {
        NvsUtils.checkFunctionInMainThread();
        return this.m_waveformColor;
    }

    public void onAttachedToWindow() {
    }

    public void onDetachedFromWindow() {
        this.cancelCurrentTask();
        NvsWaveformDataGenerator nvsWaveformDataGenerator = this.m_waveformDataGenerator;
        if (nvsWaveformDataGenerator != null) {
            nvsWaveformDataGenerator.setWaveformDataCallback(null);
            nvsWaveformDataGenerator = this.m_waveformDataGenerator;
            nvsWaveformDataGenerator.release();
            this.m_waveformDataGenerator = null;
        }
        super.onDetachedFromWindow();
    }

    public void onDraw(Canvas canvas) {
        float[] fArray;
        long l10;
        long l11;
        float[] fArray2;
        float f10;
        int n10;
        Object object;
        NvsWaveformView nvsWaveformView = this;
        Canvas canvas2 = canvas;
        super.onDraw(canvas);
        Object object2 = this.isInEditMode();
        if (object2 != 0) {
            return;
        }
        long l12 = this.m_audioFileDuration;
        long l13 = 0L;
        long l14 = l12 - l13;
        object2 = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
        if (object2 <= 0) {
            return;
        }
        object2 = this.m_needUpdateWaveformData;
        if (object2 != 0 && (object = this.m_waveformDataGenerator) != null) {
            this.m_needUpdateWaveformData = false;
            String string2 = this.m_audioFilePath;
            long l15 = this.calcExpectedSamplesPerGroup();
            long l16 = 0L;
            long l17 = 0L;
            n10 = 0;
            f10 = 0.0f;
            fArray2 = null;
            this.m_currentTaskId = l11 = ((NvsWaveformDataGenerator)object).generateWaveformData(string2, l15, l16, l17, 0);
        }
        if ((object2 = (Object)((l10 = (l11 = nvsWaveformView.m_samplesPerGroup) - l13) == 0L ? 0 : (l10 < 0L ? -1 : 1))) > 0 && (fArray = nvsWaveformView.m_leftWaveformData) != null) {
            Object object3;
            int n11;
            int n12;
            object2 = fArray.length / 2;
            object = nvsWaveformView.m_rightWaveformData;
            if (object != null && (n12 = nvsWaveformView.m_singleChannelMode) == 0) {
                n11 = ((Object)object).length / 2;
            } else {
                n11 = 0;
                object = null;
                object3 = 0.0f;
            }
            if (object2 == 0) {
                return;
            }
            n12 = this.getWidth();
            int n13 = this.getHeight();
            if (n11 != 0) {
                n13 /= 2;
            }
            Rect rect = new Rect();
            Paint paint = new Paint();
            Paint.Style style2 = Paint.Style.FILL;
            paint.setStyle(style2);
            paint.setAntiAlias(false);
            int n14 = nvsWaveformView.m_waveformColor;
            paint.setColor(n14);
            n14 = nvsWaveformView.m_waveformColor;
            Color.alpha((int)n14);
            Object object4 = PorterDuff.Mode.SRC;
            style2 = new PorterDuffXfermode(object4);
            paint.setXfermode((Xfermode)style2);
            long l18 = nvsWaveformView.m_trimIn;
            double d10 = l18;
            long l19 = nvsWaveformView.m_audioFileDuration;
            int n15 = n11;
            double d11 = l19;
            d10 /= d11;
            long l20 = nvsWaveformView.m_audioFileSampleCount;
            Rect rect2 = rect;
            Paint paint2 = paint;
            double d12 = l20;
            long l21 = (long)(d10 *= d12);
            long l22 = nvsWaveformView.m_trimOut - l18;
            double d13 = l22;
            double d14 = l19;
            d13 /= d14;
            d14 = l20;
            l19 = (long)(d13 *= d14);
            l20 = 0L;
            d11 = 0.0;
            long l23 = l19 == l20 ? 0 : (l19 < l20 ? -1 : 1);
            if (l23 == false) {
                return;
            }
            for (l23 = (long)0; l23 < n12; ++l23) {
                Rect rect3;
                int n16;
                float f11;
                int n17;
                d13 = l23;
                d10 = n12;
                d13 /= d10;
                d10 = l19;
                l18 = (long)(d13 *= d10) + l21;
                l22 = nvsWaveformView.m_samplesPerGroup;
                n11 = (int)(l18 /= l22);
                n14 = 0x40000000;
                float f12 = 2.0f;
                int n18 = 1065353216;
                float f13 = 1.0f;
                if (n11 < object2) {
                    float f14 = n13;
                    fArray2 = nvsWaveformView.m_leftWaveformData;
                    int n19 = n11 * 2;
                    n17 = n19 + 1;
                    f11 = (fArray2[n17] + f13) / f12;
                    f11 = f13 - f11;
                    f12 = f14 * f11;
                    n14 = (int)f12;
                    f10 = fArray2[n19] + f13;
                    n19 = 0x40000000;
                    float f15 = 2.0f;
                    f10 /= f15;
                    f10 = f13 - f10;
                    n16 = (int)(f14 *= f10);
                    n10 = l23 + true;
                    rect3 = rect2;
                    rect2.set((int)l23, n14, n10, n16);
                    style2 = paint2;
                    canvas2.drawRect(rect2, paint2);
                } else {
                    rect3 = rect2;
                    style2 = paint2;
                }
                n16 = n15;
                if (n11 < n15) {
                    f10 = n13;
                    object4 = nvsWaveformView.m_rightWaveformData;
                    n15 = (n11 *= 2) + 1;
                    Object object5 = object4[n15];
                    n17 = 1065353216;
                    f11 = 1.0f;
                    object5 += f11;
                    float f16 = 2.0f;
                    object5 /= f16;
                    object5 = f11 - object5;
                    float f17 = f10 * object5;
                    int n20 = (int)f17;
                    object3 = (object4[n11] + f11) / f16;
                    f13 = f11 - object3;
                    n11 = (int)(f10 *= f13);
                    n18 = (int)(l23 + true);
                    rect3.set((int)l23, n20 += n13, n18, n11 += n13);
                    canvas2.drawRect(rect3, (Paint)style2);
                }
                nvsWaveformView = this;
                paint2 = style2;
                n15 = n16;
                rect2 = rect3;
            }
        }
    }

    public void onSizeChanged(int n10, int n11, int n12, int n13) {
        if (n12 != n10) {
            this.validateWaveformData();
        }
        super.onSizeChanged(n10, n11, n12, n13);
    }

    public void onWaveformDataGenerationFailed(long l10, String string2, long l11) {
    }

    public void onWaveformDataReady(long l10, String string2, long l11, long l12, float[] fArray, float[] fArray2) {
        this.m_leftWaveformData = fArray;
        this.m_rightWaveformData = fArray2;
        this.m_samplesPerGroup = l12;
        this.m_currentTaskId = 0L;
        this.invalidate();
    }

    public void setAudioFilePath(String string2) {
        boolean bl2;
        NvsUtils.checkFunctionInMainThread();
        String string3 = this.m_audioFilePath;
        if (string3 != null && (bl2 = string3.equals(string2))) {
            return;
        }
        long l10 = 0L;
        if (string2 == null) {
            this.m_audioFilePath = null;
            this.m_audioFileSampleCount = l10;
            this.cancelCurrentTask();
            this.invalidate();
            return;
        }
        NvsWaveformDataGenerator nvsWaveformDataGenerator = this.m_waveformDataGenerator;
        if (nvsWaveformDataGenerator == null) {
            return;
        }
        long l11 = nvsWaveformDataGenerator.getAudioFileDuration(string2);
        NvsWaveformDataGenerator nvsWaveformDataGenerator2 = this.m_waveformDataGenerator;
        long l12 = nvsWaveformDataGenerator2.getAudioFileSampleCount(string2);
        Object object = l11 == l10 ? 0 : (l11 < l10 ? -1 : 1);
        if (object > 0 && (object = l12 == l10 ? 0 : (l12 < l10 ? -1 : 1)) > 0) {
            boolean bl3;
            this.m_audioFilePath = string2;
            this.m_audioFileDuration = l11;
            this.m_audioFileSampleCount = l12;
            this.m_trimIn = l10;
            this.m_trimOut = l11;
            this.m_needUpdateWaveformData = bl3 = true;
            this.cancelCurrentTask();
            this.invalidate();
        }
    }

    public void setSingleChannelMode(boolean bl2) {
        NvsUtils.checkFunctionInMainThread();
        boolean bl3 = this.m_singleChannelMode;
        if (bl2 == bl3) {
            return;
        }
        this.m_singleChannelMode = bl2;
        this.invalidate();
    }

    public void setTrimIn(long l10) {
        NvsUtils.checkFunctionInMainThread();
        l10 = Math.max(l10, 0L);
        long l11 = this.m_trimIn;
        long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        if (l12 == false) {
            return;
        }
        this.m_trimIn = l10;
        this.validateWaveformData();
    }

    public void setTrimOut(long l10) {
        NvsUtils.checkFunctionInMainThread();
        long l11 = this.m_trimIn;
        long l12 = 1L;
        l10 = Math.max(l10, l11 += l12);
        l11 = this.m_audioFileDuration;
        l10 = Math.min(l10, l11);
        l11 = this.m_trimOut;
        long l13 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        if (l13 == false) {
            return;
        }
        this.m_trimOut = l10;
        this.validateWaveformData();
    }

    public void setWaveformColor(int n10) {
        NvsUtils.checkFunctionInMainThread();
        int n11 = this.m_waveformColor;
        if (n10 == n11) {
            return;
        }
        this.m_waveformColor = n10;
        this.invalidate();
    }
}

