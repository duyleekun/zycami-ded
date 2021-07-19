/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.IBinder
 */
package android.support.v4.media.session;

import android.os.Bundle;
import android.os.IBinder;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.IMediaControllerCallback;
import android.support.v4.media.session.ParcelableVolumeInfo;
import android.support.v4.media.session.PlaybackStateCompat;
import java.util.List;

public class IMediaControllerCallback$Default
implements IMediaControllerCallback {
    public IBinder asBinder() {
        return null;
    }

    public void onCaptioningEnabledChanged(boolean bl2) {
    }

    public void onEvent(String string2, Bundle bundle) {
    }

    public void onExtrasChanged(Bundle bundle) {
    }

    public void onMetadataChanged(MediaMetadataCompat mediaMetadataCompat) {
    }

    public void onPlaybackStateChanged(PlaybackStateCompat playbackStateCompat) {
    }

    public void onQueueChanged(List list) {
    }

    public void onQueueTitleChanged(CharSequence charSequence) {
    }

    public void onRepeatModeChanged(int n10) {
    }

    public void onSessionDestroyed() {
    }

    public void onSessionReady() {
    }

    public void onShuffleModeChanged(int n10) {
    }

    public void onShuffleModeChangedRemoved(boolean bl2) {
    }

    public void onVolumeInfoChanged(ParcelableVolumeInfo parcelableVolumeInfo) {
    }
}

