/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.PendingIntent
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.ResultReceiver
 *  android.view.KeyEvent
 */
package android.support.v4.media.session;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaControllerCompat$Callback;
import android.support.v4.media.session.MediaControllerCompat$PlaybackInfo;
import android.support.v4.media.session.MediaControllerCompat$TransportControls;
import android.support.v4.media.session.PlaybackStateCompat;
import android.view.KeyEvent;
import java.util.List;

public interface MediaControllerCompat$MediaControllerImpl {
    public void addQueueItem(MediaDescriptionCompat var1);

    public void addQueueItem(MediaDescriptionCompat var1, int var2);

    public void adjustVolume(int var1, int var2);

    public boolean dispatchMediaButtonEvent(KeyEvent var1);

    public Bundle getExtras();

    public long getFlags();

    public Object getMediaController();

    public MediaMetadataCompat getMetadata();

    public String getPackageName();

    public MediaControllerCompat$PlaybackInfo getPlaybackInfo();

    public PlaybackStateCompat getPlaybackState();

    public List getQueue();

    public CharSequence getQueueTitle();

    public int getRatingType();

    public int getRepeatMode();

    public PendingIntent getSessionActivity();

    public Bundle getSessionInfo();

    public int getShuffleMode();

    public MediaControllerCompat.TransportControls getTransportControls();

    public boolean isCaptioningEnabled();

    public boolean isSessionReady();

    public void registerCallback(MediaControllerCompat$Callback var1, Handler var2);

    public void removeQueueItem(MediaDescriptionCompat var1);

    public void sendCommand(String var1, Bundle var2, ResultReceiver var3);

    public void setVolumeTo(int var1, int var2);

    public void unregisterCallback(MediaControllerCompat$Callback var1);
}

