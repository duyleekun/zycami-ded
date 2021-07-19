/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.PendingIntent
 *  android.net.Uri
 *  android.os.Bundle
 *  android.os.IBinder
 *  android.view.KeyEvent
 */
package android.support.v4.media.session;

import android.app.PendingIntent;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.RatingCompat;
import android.support.v4.media.session.IMediaControllerCallback;
import android.support.v4.media.session.IMediaSession;
import android.support.v4.media.session.MediaSessionCompat$ResultReceiverWrapper;
import android.support.v4.media.session.ParcelableVolumeInfo;
import android.support.v4.media.session.PlaybackStateCompat;
import android.view.KeyEvent;
import java.util.List;

public class IMediaSession$Default
implements IMediaSession {
    public void addQueueItem(MediaDescriptionCompat mediaDescriptionCompat) {
    }

    public void addQueueItemAt(MediaDescriptionCompat mediaDescriptionCompat, int n10) {
    }

    public void adjustVolume(int n10, int n11, String string2) {
    }

    public IBinder asBinder() {
        return null;
    }

    public void fastForward() {
    }

    public Bundle getExtras() {
        return null;
    }

    public long getFlags() {
        return 0L;
    }

    public PendingIntent getLaunchPendingIntent() {
        return null;
    }

    public MediaMetadataCompat getMetadata() {
        return null;
    }

    public String getPackageName() {
        return null;
    }

    public PlaybackStateCompat getPlaybackState() {
        return null;
    }

    public List getQueue() {
        return null;
    }

    public CharSequence getQueueTitle() {
        return null;
    }

    public int getRatingType() {
        return 0;
    }

    public int getRepeatMode() {
        return 0;
    }

    public Bundle getSessionInfo() {
        return null;
    }

    public int getShuffleMode() {
        return 0;
    }

    public String getTag() {
        return null;
    }

    public ParcelableVolumeInfo getVolumeAttributes() {
        return null;
    }

    public boolean isCaptioningEnabled() {
        return false;
    }

    public boolean isShuffleModeEnabledRemoved() {
        return false;
    }

    public boolean isTransportControlEnabled() {
        return false;
    }

    public void next() {
    }

    public void pause() {
    }

    public void play() {
    }

    public void playFromMediaId(String string2, Bundle bundle) {
    }

    public void playFromSearch(String string2, Bundle bundle) {
    }

    public void playFromUri(Uri uri, Bundle bundle) {
    }

    public void prepare() {
    }

    public void prepareFromMediaId(String string2, Bundle bundle) {
    }

    public void prepareFromSearch(String string2, Bundle bundle) {
    }

    public void prepareFromUri(Uri uri, Bundle bundle) {
    }

    public void previous() {
    }

    public void rate(RatingCompat ratingCompat) {
    }

    public void rateWithExtras(RatingCompat ratingCompat, Bundle bundle) {
    }

    public void registerCallbackListener(IMediaControllerCallback iMediaControllerCallback) {
    }

    public void removeQueueItem(MediaDescriptionCompat mediaDescriptionCompat) {
    }

    public void removeQueueItemAt(int n10) {
    }

    public void rewind() {
    }

    public void seekTo(long l10) {
    }

    public void sendCommand(String string2, Bundle bundle, MediaSessionCompat$ResultReceiverWrapper mediaSessionCompat$ResultReceiverWrapper) {
    }

    public void sendCustomAction(String string2, Bundle bundle) {
    }

    public boolean sendMediaButton(KeyEvent keyEvent) {
        return false;
    }

    public void setCaptioningEnabled(boolean bl2) {
    }

    public void setPlaybackSpeed(float f10) {
    }

    public void setRepeatMode(int n10) {
    }

    public void setShuffleMode(int n10) {
    }

    public void setShuffleModeEnabledRemoved(boolean bl2) {
    }

    public void setVolumeTo(int n10, int n11, String string2) {
    }

    public void skipToQueueItem(long l10) {
    }

    public void stop() {
    }

    public void unregisterCallbackListener(IMediaControllerCallback iMediaControllerCallback) {
    }
}

