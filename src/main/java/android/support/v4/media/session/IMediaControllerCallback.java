/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.IInterface
 */
package android.support.v4.media.session;

import android.os.Bundle;
import android.os.IInterface;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.ParcelableVolumeInfo;
import android.support.v4.media.session.PlaybackStateCompat;
import java.util.List;

public interface IMediaControllerCallback
extends IInterface {
    public void onCaptioningEnabledChanged(boolean var1);

    public void onEvent(String var1, Bundle var2);

    public void onExtrasChanged(Bundle var1);

    public void onMetadataChanged(MediaMetadataCompat var1);

    public void onPlaybackStateChanged(PlaybackStateCompat var1);

    public void onQueueChanged(List var1);

    public void onQueueTitleChanged(CharSequence var1);

    public void onRepeatModeChanged(int var1);

    public void onSessionDestroyed();

    public void onSessionReady();

    public void onShuffleModeChanged(int var1);

    public void onShuffleModeChangedRemoved(boolean var1);

    public void onVolumeInfoChanged(ParcelableVolumeInfo var1);
}

