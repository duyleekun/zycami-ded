/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.VolumeProvider
 *  android.os.Build$VERSION
 */
package androidx.media;

import android.media.VolumeProvider;
import android.os.Build;
import androidx.media.VolumeProviderCompat$1;
import androidx.media.VolumeProviderCompat$2;
import androidx.media.VolumeProviderCompat$Callback;

public abstract class VolumeProviderCompat {
    public static final int VOLUME_CONTROL_ABSOLUTE = 2;
    public static final int VOLUME_CONTROL_FIXED = 0;
    public static final int VOLUME_CONTROL_RELATIVE = 1;
    private VolumeProviderCompat$Callback mCallback;
    private final String mControlId;
    private final int mControlType;
    private int mCurrentVolume;
    private final int mMaxVolume;
    private VolumeProvider mVolumeProviderFwk;

    public VolumeProviderCompat(int n10, int n11, int n12) {
        this(n10, n11, n12, null);
    }

    public VolumeProviderCompat(int n10, int n11, int n12, String string2) {
        this.mControlType = n10;
        this.mMaxVolume = n11;
        this.mCurrentVolume = n12;
        this.mControlId = string2;
    }

    public final int getCurrentVolume() {
        return this.mCurrentVolume;
    }

    public final int getMaxVolume() {
        return this.mMaxVolume;
    }

    public final int getVolumeControl() {
        return this.mControlType;
    }

    public final String getVolumeControlId() {
        return this.mControlId;
    }

    public Object getVolumeProvider() {
        VolumeProvider volumeProvider = this.mVolumeProviderFwk;
        if (volumeProvider == null) {
            int n10 = Build.VERSION.SDK_INT;
            int n11 = 30;
            if (n10 >= n11) {
                int n12 = this.mControlType;
                int n13 = this.mMaxVolume;
                int n14 = this.mCurrentVolume;
                String string2 = this.mControlId;
                this.mVolumeProviderFwk = volumeProvider = new VolumeProviderCompat$1(this, n12, n13, n14, string2);
            } else {
                n11 = 21;
                if (n10 >= n11) {
                    n11 = this.mControlType;
                    int n15 = this.mMaxVolume;
                    int n16 = this.mCurrentVolume;
                    this.mVolumeProviderFwk = volumeProvider = new VolumeProviderCompat$2(this, n11, n15, n16);
                }
            }
        }
        return this.mVolumeProviderFwk;
    }

    public void onAdjustVolume(int n10) {
    }

    public void onSetVolumeTo(int n10) {
    }

    public void setCallback(VolumeProviderCompat$Callback volumeProviderCompat$Callback) {
        this.mCallback = volumeProviderCompat$Callback;
    }

    public final void setCurrentVolume(int n10) {
        VolumeProviderCompat$Callback volumeProviderCompat$Callback;
        this.mCurrentVolume = n10;
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 21;
        if (n11 >= n12) {
            VolumeProvider volumeProvider = (VolumeProvider)this.getVolumeProvider();
            volumeProvider.setCurrentVolume(n10);
        }
        if ((volumeProviderCompat$Callback = this.mCallback) != null) {
            volumeProviderCompat$Callback.onVolumeChanged(this);
        }
    }
}

