/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.VolumeProvider
 */
package androidx.media;

import android.media.VolumeProvider;
import androidx.media.VolumeProviderCompat;

public class VolumeProviderCompat$1
extends VolumeProvider {
    public final /* synthetic */ VolumeProviderCompat this$0;

    public VolumeProviderCompat$1(VolumeProviderCompat volumeProviderCompat, int n10, int n11, int n12, String string2) {
        this.this$0 = volumeProviderCompat;
        super(n10, n11, n12, string2);
    }

    public void onAdjustVolume(int n10) {
        this.this$0.onAdjustVolume(n10);
    }

    public void onSetVolumeTo(int n10) {
        this.this$0.onSetVolumeTo(n10);
    }
}

