/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.PendingIntent
 *  android.net.Uri
 *  android.os.Binder
 *  android.os.Bundle
 *  android.os.IInterface
 *  android.os.ResultReceiver
 *  android.view.KeyEvent
 */
package android.support.v4.media.session;

import android.app.PendingIntent;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IInterface;
import android.os.ResultReceiver;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.RatingCompat;
import android.support.v4.media.session.IMediaControllerCallback;
import android.support.v4.media.session.IMediaSession$Stub;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.MediaSessionCompat$MediaSessionImplBase;
import android.support.v4.media.session.MediaSessionCompat$MediaSessionImplBase$Command;
import android.support.v4.media.session.MediaSessionCompat$ResultReceiverWrapper;
import android.support.v4.media.session.ParcelableVolumeInfo;
import android.support.v4.media.session.PlaybackStateCompat;
import android.view.KeyEvent;
import androidx.media.MediaSessionManager$RemoteUserInfo;
import androidx.media.VolumeProviderCompat;
import java.util.List;

public class MediaSessionCompat$MediaSessionImplBase$MediaSessionStub
extends IMediaSession$Stub {
    public final /* synthetic */ MediaSessionCompat$MediaSessionImplBase this$0;

    public MediaSessionCompat$MediaSessionImplBase$MediaSessionStub(MediaSessionCompat$MediaSessionImplBase mediaSessionCompat$MediaSessionImplBase) {
        this.this$0 = mediaSessionCompat$MediaSessionImplBase;
    }

    public void addQueueItem(MediaDescriptionCompat mediaDescriptionCompat) {
        this.postToHandler(25, mediaDescriptionCompat);
    }

    public void addQueueItemAt(MediaDescriptionCompat mediaDescriptionCompat, int n10) {
        this.postToHandler(26, (Object)mediaDescriptionCompat, n10);
    }

    public void adjustVolume(int n10, int n11, String string2) {
        this.this$0.adjustVolume(n10, n11);
    }

    public void fastForward() {
        this.postToHandler(16);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Bundle getExtras() {
        Object object = this.this$0.mLock;
        synchronized (object) {
            MediaSessionCompat$MediaSessionImplBase mediaSessionCompat$MediaSessionImplBase = this.this$0;
            return mediaSessionCompat$MediaSessionImplBase.mExtras;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public long getFlags() {
        Object object = this.this$0.mLock;
        synchronized (object) {
            MediaSessionCompat$MediaSessionImplBase mediaSessionCompat$MediaSessionImplBase = this.this$0;
            int n10 = mediaSessionCompat$MediaSessionImplBase.mFlags;
            return n10;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public PendingIntent getLaunchPendingIntent() {
        Object object = this.this$0.mLock;
        synchronized (object) {
            MediaSessionCompat$MediaSessionImplBase mediaSessionCompat$MediaSessionImplBase = this.this$0;
            return mediaSessionCompat$MediaSessionImplBase.mSessionActivity;
        }
    }

    public MediaMetadataCompat getMetadata() {
        return this.this$0.mMetadata;
    }

    public String getPackageName() {
        return this.this$0.mPackageName;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public PlaybackStateCompat getPlaybackState() {
        Object object = this.this$0.mLock;
        synchronized (object) {
            Object object2 = this.this$0;
            PlaybackStateCompat playbackStateCompat = ((MediaSessionCompat$MediaSessionImplBase)object2).mState;
            object2 = ((MediaSessionCompat$MediaSessionImplBase)object2).mMetadata;
            return MediaSessionCompat.getStateWithUpdatedPosition(playbackStateCompat, (MediaMetadataCompat)object2);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public List getQueue() {
        Object object = this.this$0.mLock;
        synchronized (object) {
            MediaSessionCompat$MediaSessionImplBase mediaSessionCompat$MediaSessionImplBase = this.this$0;
            return mediaSessionCompat$MediaSessionImplBase.mQueue;
        }
    }

    public CharSequence getQueueTitle() {
        return this.this$0.mQueueTitle;
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
        return this.this$0.mTag;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public ParcelableVolumeInfo getVolumeAttributes() {
        int n10;
        int n11;
        int n12;
        Object object;
        int n13;
        int n14;
        Object object2 = this.this$0.mLock;
        synchronized (object2) {
            MediaSessionCompat$MediaSessionImplBase mediaSessionCompat$MediaSessionImplBase = this.this$0;
            n14 = mediaSessionCompat$MediaSessionImplBase.mVolumeType;
            n13 = mediaSessionCompat$MediaSessionImplBase.mLocalStream;
            object = mediaSessionCompat$MediaSessionImplBase.mVolumeProvider;
            n12 = 2;
            if (n14 == n12) {
                int n15;
                int n16 = ((VolumeProviderCompat)object).getVolumeControl();
                n12 = ((VolumeProviderCompat)object).getMaxVolume();
                n11 = n15 = ((VolumeProviderCompat)object).getCurrentVolume();
                n10 = n12;
                n12 = n16;
            } else {
                mediaSessionCompat$MediaSessionImplBase = mediaSessionCompat$MediaSessionImplBase.mAudioManager;
                int n17 = mediaSessionCompat$MediaSessionImplBase.getStreamMaxVolume(n13);
                object = this.this$0;
                object = ((MediaSessionCompat$MediaSessionImplBase)object).mAudioManager;
                int n18 = object.getStreamVolume(n13);
                n10 = n17;
                n11 = n18;
            }
        }
        object = object2;
        return new ParcelableVolumeInfo(n14, n13, n12, n10, n11);
    }

    public boolean isCaptioningEnabled() {
        return this.this$0.mCaptioningEnabled;
    }

    public boolean isShuffleModeEnabledRemoved() {
        return false;
    }

    public boolean isTransportControlEnabled() {
        return true;
    }

    public void next() {
        this.postToHandler(14);
    }

    public void pause() {
        this.postToHandler(12);
    }

    public void play() {
        this.postToHandler(7);
    }

    public void playFromMediaId(String string2, Bundle bundle) {
        this.postToHandler(8, (Object)string2, bundle);
    }

    public void playFromSearch(String string2, Bundle bundle) {
        this.postToHandler(9, (Object)string2, bundle);
    }

    public void playFromUri(Uri uri, Bundle bundle) {
        this.postToHandler(10, (Object)uri, bundle);
    }

    public void postToHandler(int n10) {
        this.this$0.postToHandler(n10, 0, 0, null, null);
    }

    public void postToHandler(int n10, int n11) {
        this.this$0.postToHandler(n10, n11, 0, null, null);
    }

    public void postToHandler(int n10, Object object) {
        this.this$0.postToHandler(n10, 0, 0, object, null);
    }

    public void postToHandler(int n10, Object object, int n11) {
        this.this$0.postToHandler(n10, n11, 0, object, null);
    }

    public void postToHandler(int n10, Object object, Bundle bundle) {
        this.this$0.postToHandler(n10, 0, 0, object, bundle);
    }

    public void prepare() {
        this.postToHandler(3);
    }

    public void prepareFromMediaId(String string2, Bundle bundle) {
        this.postToHandler(4, (Object)string2, bundle);
    }

    public void prepareFromSearch(String string2, Bundle bundle) {
        this.postToHandler(5, (Object)string2, bundle);
    }

    public void prepareFromUri(Uri uri, Bundle bundle) {
        this.postToHandler(6, (Object)uri, bundle);
    }

    public void previous() {
        this.postToHandler(15);
    }

    public void rate(RatingCompat ratingCompat) {
        this.postToHandler(19, ratingCompat);
    }

    public void rateWithExtras(RatingCompat ratingCompat, Bundle bundle) {
        this.postToHandler(31, (Object)ratingCompat, bundle);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void registerCallbackListener(IMediaControllerCallback iMediaControllerCallback) {
        Object object = this.this$0;
        int n10 = ((MediaSessionCompat$MediaSessionImplBase)object).mDestroyed;
        if (n10 == 0) {
            n10 = Binder.getCallingUid();
            object = this.this$0.getPackageNameForUid(n10);
            int n11 = Binder.getCallingPid();
            int n12 = Binder.getCallingUid();
            MediaSessionManager$RemoteUserInfo mediaSessionManager$RemoteUserInfo = new MediaSessionManager$RemoteUserInfo((String)object, n11, n12);
            this.this$0.mControllerCallbacks.register((IInterface)iMediaControllerCallback, (Object)mediaSessionManager$RemoteUserInfo);
            return;
        }
        try {
            iMediaControllerCallback.onSessionDestroyed();
            return;
        }
        catch (Exception exception) {
            return;
        }
    }

    public void removeQueueItem(MediaDescriptionCompat mediaDescriptionCompat) {
        this.postToHandler(27, mediaDescriptionCompat);
    }

    public void removeQueueItemAt(int n10) {
        this.postToHandler(28, n10);
    }

    public void rewind() {
        this.postToHandler(17);
    }

    public void seekTo(long l10) {
        Long l11 = l10;
        this.postToHandler(18, l11);
    }

    public void sendCommand(String string2, Bundle bundle, MediaSessionCompat$ResultReceiverWrapper mediaSessionCompat$ResultReceiverWrapper) {
        mediaSessionCompat$ResultReceiverWrapper = mediaSessionCompat$ResultReceiverWrapper == null ? null : mediaSessionCompat$ResultReceiverWrapper.mResultReceiver;
        MediaSessionCompat$MediaSessionImplBase$Command mediaSessionCompat$MediaSessionImplBase$Command = new MediaSessionCompat$MediaSessionImplBase$Command(string2, bundle, (ResultReceiver)mediaSessionCompat$ResultReceiverWrapper);
        this.postToHandler(1, mediaSessionCompat$MediaSessionImplBase$Command);
    }

    public void sendCustomAction(String string2, Bundle bundle) {
        this.postToHandler(20, (Object)string2, bundle);
    }

    public boolean sendMediaButton(KeyEvent keyEvent) {
        this.postToHandler(21, keyEvent);
        return true;
    }

    public void setCaptioningEnabled(boolean bl2) {
        Boolean bl3 = bl2;
        this.postToHandler(29, bl3);
    }

    public void setPlaybackSpeed(float f10) {
        Float f11 = Float.valueOf(f10);
        this.postToHandler(32, f11);
    }

    public void setRepeatMode(int n10) {
        this.postToHandler(23, n10);
    }

    public void setShuffleMode(int n10) {
        this.postToHandler(30, n10);
    }

    public void setShuffleModeEnabledRemoved(boolean bl2) {
    }

    public void setVolumeTo(int n10, int n11, String string2) {
        this.this$0.setVolumeTo(n10, n11);
    }

    public void skipToQueueItem(long l10) {
        Long l11 = l10;
        this.postToHandler(11, l11);
    }

    public void stop() {
        this.postToHandler(13);
    }

    public void unregisterCallbackListener(IMediaControllerCallback iMediaControllerCallback) {
        this.this$0.mControllerCallbacks.unregister((IInterface)iMediaControllerCallback);
    }
}

