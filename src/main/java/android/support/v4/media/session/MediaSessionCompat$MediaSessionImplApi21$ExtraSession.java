/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.PendingIntent
 *  android.net.Uri
 *  android.os.Binder
 *  android.os.Bundle
 *  android.os.IInterface
 *  android.os.RemoteCallbackList
 *  android.view.KeyEvent
 */
package android.support.v4.media.session;

import android.app.PendingIntent;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteCallbackList;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.RatingCompat;
import android.support.v4.media.session.IMediaControllerCallback;
import android.support.v4.media.session.IMediaSession$Stub;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.MediaSessionCompat$MediaSessionImplApi21;
import android.support.v4.media.session.MediaSessionCompat$ResultReceiverWrapper;
import android.support.v4.media.session.ParcelableVolumeInfo;
import android.support.v4.media.session.PlaybackStateCompat;
import android.view.KeyEvent;
import androidx.media.MediaSessionManager$RemoteUserInfo;
import java.util.List;

public class MediaSessionCompat$MediaSessionImplApi21$ExtraSession
extends IMediaSession$Stub {
    public final /* synthetic */ MediaSessionCompat$MediaSessionImplApi21 this$0;

    public MediaSessionCompat$MediaSessionImplApi21$ExtraSession(MediaSessionCompat$MediaSessionImplApi21 mediaSessionCompat$MediaSessionImplApi21) {
        this.this$0 = mediaSessionCompat$MediaSessionImplApi21;
    }

    public void addQueueItem(MediaDescriptionCompat object) {
        object = new AssertionError();
        throw object;
    }

    public void addQueueItemAt(MediaDescriptionCompat object, int n10) {
        object = new AssertionError();
        throw object;
    }

    public void adjustVolume(int n10, int n11, String string2) {
        AssertionError assertionError = new AssertionError();
        throw assertionError;
    }

    public void fastForward() {
        AssertionError assertionError = new AssertionError();
        throw assertionError;
    }

    public Bundle getExtras() {
        AssertionError assertionError = new AssertionError();
        throw assertionError;
    }

    public long getFlags() {
        AssertionError assertionError = new AssertionError();
        throw assertionError;
    }

    public PendingIntent getLaunchPendingIntent() {
        AssertionError assertionError = new AssertionError();
        throw assertionError;
    }

    public MediaMetadataCompat getMetadata() {
        AssertionError assertionError = new AssertionError();
        throw assertionError;
    }

    public String getPackageName() {
        AssertionError assertionError = new AssertionError();
        throw assertionError;
    }

    public PlaybackStateCompat getPlaybackState() {
        Object object = this.this$0;
        PlaybackStateCompat playbackStateCompat = ((MediaSessionCompat$MediaSessionImplApi21)object).mPlaybackState;
        object = ((MediaSessionCompat$MediaSessionImplApi21)object).mMetadata;
        return MediaSessionCompat.getStateWithUpdatedPosition(playbackStateCompat, (MediaMetadataCompat)object);
    }

    public List getQueue() {
        return null;
    }

    public CharSequence getQueueTitle() {
        AssertionError assertionError = new AssertionError();
        throw assertionError;
    }

    public int getRatingType() {
        return this.this$0.mRatingType;
    }

    public int getRepeatMode() {
        return this.this$0.mRepeatMode;
    }

    public Bundle getSessionInfo() {
        Bundle bundle = this.this$0.mSessionInfo;
        if (bundle == null) {
            bundle = null;
        } else {
            Bundle bundle2 = this.this$0.mSessionInfo;
            bundle = new Bundle(bundle2);
        }
        return bundle;
    }

    public int getShuffleMode() {
        return this.this$0.mShuffleMode;
    }

    public String getTag() {
        AssertionError assertionError = new AssertionError();
        throw assertionError;
    }

    public ParcelableVolumeInfo getVolumeAttributes() {
        AssertionError assertionError = new AssertionError();
        throw assertionError;
    }

    public boolean isCaptioningEnabled() {
        return this.this$0.mCaptioningEnabled;
    }

    public boolean isShuffleModeEnabledRemoved() {
        return false;
    }

    public boolean isTransportControlEnabled() {
        AssertionError assertionError = new AssertionError();
        throw assertionError;
    }

    public void next() {
        AssertionError assertionError = new AssertionError();
        throw assertionError;
    }

    public void pause() {
        AssertionError assertionError = new AssertionError();
        throw assertionError;
    }

    public void play() {
        AssertionError assertionError = new AssertionError();
        throw assertionError;
    }

    public void playFromMediaId(String object, Bundle bundle) {
        object = new AssertionError();
        throw object;
    }

    public void playFromSearch(String object, Bundle bundle) {
        object = new AssertionError();
        throw object;
    }

    public void playFromUri(Uri object, Bundle bundle) {
        object = new AssertionError();
        throw object;
    }

    public void prepare() {
        AssertionError assertionError = new AssertionError();
        throw assertionError;
    }

    public void prepareFromMediaId(String object, Bundle bundle) {
        object = new AssertionError();
        throw object;
    }

    public void prepareFromSearch(String object, Bundle bundle) {
        object = new AssertionError();
        throw object;
    }

    public void prepareFromUri(Uri object, Bundle bundle) {
        object = new AssertionError();
        throw object;
    }

    public void previous() {
        AssertionError assertionError = new AssertionError();
        throw assertionError;
    }

    public void rate(RatingCompat object) {
        object = new AssertionError();
        throw object;
    }

    public void rateWithExtras(RatingCompat object, Bundle bundle) {
        object = new AssertionError();
        throw object;
    }

    public void registerCallbackListener(IMediaControllerCallback iMediaControllerCallback) {
        Object object = this.this$0;
        boolean bl2 = ((MediaSessionCompat$MediaSessionImplApi21)object).mDestroyed;
        if (!bl2) {
            int n10 = Binder.getCallingPid();
            int n11 = Binder.getCallingUid();
            String string2 = "android.media.session.MediaController";
            object = new MediaSessionManager$RemoteUserInfo(string2, n10, n11);
            RemoteCallbackList remoteCallbackList = this.this$0.mExtraControllerCallbacks;
            remoteCallbackList.register((IInterface)iMediaControllerCallback, object);
        }
    }

    public void removeQueueItem(MediaDescriptionCompat object) {
        object = new AssertionError();
        throw object;
    }

    public void removeQueueItemAt(int n10) {
        AssertionError assertionError = new AssertionError();
        throw assertionError;
    }

    public void rewind() {
        AssertionError assertionError = new AssertionError();
        throw assertionError;
    }

    public void seekTo(long l10) {
        AssertionError assertionError = new AssertionError();
        throw assertionError;
    }

    public void sendCommand(String object, Bundle bundle, MediaSessionCompat$ResultReceiverWrapper mediaSessionCompat$ResultReceiverWrapper) {
        object = new AssertionError();
        throw object;
    }

    public void sendCustomAction(String object, Bundle bundle) {
        object = new AssertionError();
        throw object;
    }

    public boolean sendMediaButton(KeyEvent object) {
        object = new AssertionError();
        throw object;
    }

    public void setCaptioningEnabled(boolean bl2) {
        AssertionError assertionError = new AssertionError();
        throw assertionError;
    }

    public void setPlaybackSpeed(float f10) {
        AssertionError assertionError = new AssertionError();
        throw assertionError;
    }

    public void setRepeatMode(int n10) {
        AssertionError assertionError = new AssertionError();
        throw assertionError;
    }

    public void setShuffleMode(int n10) {
        AssertionError assertionError = new AssertionError();
        throw assertionError;
    }

    public void setShuffleModeEnabledRemoved(boolean bl2) {
    }

    public void setVolumeTo(int n10, int n11, String string2) {
        AssertionError assertionError = new AssertionError();
        throw assertionError;
    }

    public void skipToQueueItem(long l10) {
        AssertionError assertionError = new AssertionError();
        throw assertionError;
    }

    public void stop() {
        AssertionError assertionError = new AssertionError();
        throw assertionError;
    }

    public void unregisterCallbackListener(IMediaControllerCallback iMediaControllerCallback) {
        this.this$0.mExtraControllerCallbacks.unregister((IInterface)iMediaControllerCallback);
    }
}

