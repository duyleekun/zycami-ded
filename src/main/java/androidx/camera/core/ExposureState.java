/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Range
 *  android.util.Rational
 */
package androidx.camera.core;

import android.util.Range;
import android.util.Rational;

public interface ExposureState {
    public int getExposureCompensationIndex();

    public Range getExposureCompensationRange();

    public Rational getExposureCompensationStep();

    public boolean isExposureCompensationSupported();
}

