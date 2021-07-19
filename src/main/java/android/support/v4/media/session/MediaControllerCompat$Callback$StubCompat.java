/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package android.support.v4.media.session;

import android.os.Bundle;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.IMediaControllerCallback$Stub;
import android.support.v4.media.session.MediaControllerCompat$Callback;
import android.support.v4.media.session.MediaControllerCompat$PlaybackInfo;
import android.support.v4.media.session.ParcelableVolumeInfo;
import android.support.v4.media.session.PlaybackStateCompat;
import java.lang.ref.WeakReference;
import java.util.List;

public class MediaControllerCompat$Callback$StubCompat
extends IMediaControllerCallback$Stub {
    private final WeakReference mCallback;

    public MediaControllerCompat$Callback$StubCompat(MediaControllerCompat$Callback mediaControllerCompat$Callback) {
        WeakReference<MediaControllerCompat$Callback> weakReference;
        this.mCallback = weakReference = new WeakReference<MediaControllerCompat$Callback>(mediaControllerCompat$Callback);
    }

    public void onCaptioningEnabledChanged(boolean bl2) {
        MediaControllerCompat$Callback mediaControllerCompat$Callback = (MediaControllerCompat$Callback)this.mCallback.get();
        if (mediaControllerCompat$Callback != null) {
            int n10 = 11;
            Boolean bl3 = bl2;
            mediaControllerCompat$Callback.postToHandler(n10, bl3, null);
        }
    }

    public void onEvent(String string2, Bundle bundle) {
        MediaControllerCompat$Callback mediaControllerCompat$Callback = (MediaControllerCompat$Callback)this.mCallback.get();
        if (mediaControllerCompat$Callback != null) {
            int n10 = 1;
            mediaControllerCompat$Callback.postToHandler(n10, string2, bundle);
        }
    }

    public void onExtrasChanged(Bundle bundle) {
        MediaControllerCompat$Callback mediaControllerCompat$Callback = (MediaControllerCompat$Callback)this.mCallback.get();
        if (mediaControllerCompat$Callback != null) {
            int n10 = 7;
            mediaControllerCompat$Callback.postToHandler(n10, bundle, null);
        }
    }

    public void onMetadataChanged(MediaMetadataCompat mediaMetadataCompat) {
        MediaControllerCompat$Callback mediaControllerCompat$Callback = (MediaControllerCompat$Callback)this.mCallback.get();
        if (mediaControllerCompat$Callback != null) {
            int n10 = 3;
            mediaControllerCompat$Callback.postToHandler(n10, mediaMetadataCompat, null);
        }
    }

    public void onPlaybackStateChanged(PlaybackStateCompat playbackStateCompat) {
        MediaControllerCompat$Callback mediaControllerCompat$Callback = (MediaControllerCompat$Callback)this.mCallback.get();
        if (mediaControllerCompat$Callback != null) {
            int n10 = 2;
            mediaControllerCompat$Callback.postToHandler(n10, playbackStateCompat, null);
        }
    }

    public void onQueueChanged(List list) {
        MediaControllerCompat$Callback mediaControllerCompat$Callback = (MediaControllerCompat$Callback)this.mCallback.get();
        if (mediaControllerCompat$Callback != null) {
            int n10 = 5;
            mediaControllerCompat$Callback.postToHandler(n10, list, null);
        }
    }

    public void onQueueTitleChanged(CharSequence charSequence) {
        MediaControllerCompat$Callback mediaControllerCompat$Callback = (MediaControllerCompat$Callback)this.mCallback.get();
        if (mediaControllerCompat$Callback != null) {
            int n10 = 6;
            mediaControllerCompat$Callback.postToHandler(n10, charSequence, null);
        }
    }

    public void onRepeatModeChanged(int n10) {
        MediaControllerCompat$Callback mediaControllerCompat$Callback = (MediaControllerCompat$Callback)this.mCallback.get();
        if (mediaControllerCompat$Callback != null) {
            int n11 = 9;
            Integer n12 = n10;
            mediaControllerCompat$Callback.postToHandler(n11, n12, null);
        }
    }

    public void onSessionDestroyed() {
        MediaControllerCompat$Callback mediaControllerCompat$Callback = (MediaControllerCompat$Callback)this.mCallback.get();
        if (mediaControllerCompat$Callback != null) {
            int n10 = 8;
            mediaControllerCompat$Callback.postToHandler(n10, null, null);
        }
    }

    public void onSessionReady() {
        MediaControllerCompat$Callback mediaControllerCompat$Callback = (MediaControllerCompat$Callback)this.mCallback.get();
        if (mediaControllerCompat$Callback != null) {
            int n10 = 13;
            mediaControllerCompat$Callback.postToHandler(n10, null, null);
        }
    }

    public void onShuffleModeChanged(int n10) {
        MediaControllerCompat$Callback mediaControllerCompat$Callback = (MediaControllerCompat$Callback)this.mCallback.get();
        if (mediaControllerCompat$Callback != null) {
            int n11 = 12;
            Integer n12 = n10;
            mediaControllerCompat$Callback.postToHandler(n11, n12, null);
        }
    }

    public void onShuffleModeChangedRemoved(boolean bl2) {
    }

    public void onVolumeInfoChanged(ParcelableVolumeInfo parcelableVolumeInfo) {
        MediaControllerCompat$Callback mediaControllerCompat$Callback = (MediaControllerCompat$Callback)this.mCallback.get();
        if (mediaControllerCompat$Callback != null) {
            MediaControllerCompat$PlaybackInfo mediaControllerCompat$PlaybackInfo;
            if (parcelableVolumeInfo != null) {
                int n10 = parcelableVolumeInfo.volumeType;
                int n11 = parcelableVolumeInfo.audioStream;
                int n12 = parcelableVolumeInfo.controlType;
                int n13 = parcelableVolumeInfo.maxVolume;
                int n14 = parcelableVolumeInfo.currentVolume;
                mediaControllerCompat$PlaybackInfo = new MediaControllerCompat$PlaybackInfo(n10, n11, n12, n13, n14);
            } else {
                mediaControllerCompat$PlaybackInfo = null;
            }
            int n15 = 4;
            mediaControllerCompat$Callback.postToHandler(n15, mediaControllerCompat$PlaybackInfo, null);
        }
    }
}

