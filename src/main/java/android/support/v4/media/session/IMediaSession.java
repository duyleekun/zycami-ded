/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.PendingIntent
 *  android.net.Uri
 *  android.os.Bundle
 *  android.os.IInterface
 *  android.view.KeyEvent
 */
package android.support.v4.media.session;

import android.app.PendingIntent;
import android.net.Uri;
import android.os.Bundle;
import android.os.IInterface;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.RatingCompat;
import android.support.v4.media.session.IMediaControllerCallback;
import android.support.v4.media.session.MediaSessionCompat$ResultReceiverWrapper;
import android.support.v4.media.session.ParcelableVolumeInfo;
import android.support.v4.media.session.PlaybackStateCompat;
import android.view.KeyEvent;
import java.util.List;

public interface IMediaSession
extends IInterface {
    public void addQueueItem(MediaDescriptionCompat var1);

    public void addQueueItemAt(MediaDescriptionCompat var1, int var2);

    public void adjustVolume(int var1, int var2, String var3);

    public void fastForward();

    public Bundle getExtras();

    public long getFlags();

    public PendingIntent getLaunchPendingIntent();

    public MediaMetadataCompat getMetadata();

    public String getPackageName();

    public PlaybackStateCompat getPlaybackState();

    public List getQueue();

    public CharSequence getQueueTitle();

    public int getRatingType();

    public int getRepeatMode();

    public Bundle getSessionInfo();

    public int getShuffleMode();

    public String getTag();

    public ParcelableVolumeInfo getVolumeAttributes();

    public boolean isCaptioningEnabled();

    public boolean isShuffleModeEnabledRemoved();

    public boolean isTransportControlEnabled();

    public void next();

    public void pause();

    public void play();

    public void playFromMediaId(String var1, Bundle var2);

    public void playFromSearch(String var1, Bundle var2);

    public void playFromUri(Uri var1, Bundle var2);

    public void prepare();

    public void prepareFromMediaId(String var1, Bundle var2);

    public void prepareFromSearch(String var1, Bundle var2);

    public void prepareFromUri(Uri var1, Bundle var2);

    public void previous();

    public void rate(RatingCompat var1);

    public void rateWithExtras(RatingCompat var1, Bundle var2);

    public void registerCallbackListener(IMediaControllerCallback var1);

    public void removeQueueItem(MediaDescriptionCompat var1);

    public void removeQueueItemAt(int var1);

    public void rewind();

    public void seekTo(long var1);

    public void sendCommand(String var1, Bundle var2, MediaSessionCompat.ResultReceiverWrapper var3);

    public void sendCustomAction(String var1, Bundle var2);

    public boolean sendMediaButton(KeyEvent var1);

    public void setCaptioningEnabled(boolean var1);

    public void setPlaybackSpeed(float var1);

    public void setRepeatMode(int var1);

    public void setShuffleMode(int var1);

    public void setShuffleModeEnabledRemoved(boolean var1);

    public void setVolumeTo(int var1, int var2, String var3);

    public void skipToQueueItem(long var1);

    public void stop();

    public void unregisterCallbackListener(IMediaControllerCallback var1);
}

