/*
 * Decompiled with CFR 0.151.
 */
package android.support.v4.media.session;

import android.support.v4.media.session.MediaSessionCompat$MediaSessionImplBase;
import android.support.v4.media.session.ParcelableVolumeInfo;
import androidx.media.VolumeProviderCompat;
import androidx.media.VolumeProviderCompat$Callback;

public class MediaSessionCompat$MediaSessionImplBase$1
extends VolumeProviderCompat$Callback {
    public final /* synthetic */ MediaSessionCompat$MediaSessionImplBase this$0;

    public MediaSessionCompat$MediaSessionImplBase$1(MediaSessionCompat$MediaSessionImplBase mediaSessionCompat$MediaSessionImplBase) {
        this.this$0 = mediaSessionCompat$MediaSessionImplBase;
    }

    public void onVolumeChanged(VolumeProviderCompat volumeProviderCompat) {
        Object object = this.this$0.mVolumeProvider;
        if (object != volumeProviderCompat) {
            return;
        }
        Object object2 = this.this$0;
        int n10 = ((MediaSessionCompat$MediaSessionImplBase)object2).mVolumeType;
        int n11 = ((MediaSessionCompat$MediaSessionImplBase)object2).mLocalStream;
        int n12 = volumeProviderCompat.getVolumeControl();
        int n13 = volumeProviderCompat.getMaxVolume();
        int n14 = volumeProviderCompat.getCurrentVolume();
        object2 = object;
        object = new ParcelableVolumeInfo(n10, n11, n12, n13, n14);
        this.this$0.sendVolumeInfoChanged((ParcelableVolumeInfo)object);
    }
}

