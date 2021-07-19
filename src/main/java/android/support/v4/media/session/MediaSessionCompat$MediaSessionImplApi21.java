/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.PendingIntent
 *  android.media.AudioAttributes
 *  android.media.AudioAttributes$Builder
 *  android.media.MediaMetadata
 *  android.media.VolumeProvider
 *  android.media.session.MediaSession
 *  android.media.session.MediaSession$Callback
 *  android.media.session.MediaSession$QueueItem
 *  android.media.session.PlaybackState
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.RemoteCallbackList
 *  android.os.RemoteException
 *  android.util.Log
 */
package android.support.v4.media.session;

import android.app.PendingIntent;
import android.media.AudioAttributes;
import android.media.MediaMetadata;
import android.media.VolumeProvider;
import android.media.session.MediaSession;
import android.media.session.PlaybackState;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.IMediaControllerCallback;
import android.support.v4.media.session.MediaSessionCompat$Callback;
import android.support.v4.media.session.MediaSessionCompat$MediaSessionImpl;
import android.support.v4.media.session.MediaSessionCompat$MediaSessionImplApi21$ExtraSession;
import android.support.v4.media.session.MediaSessionCompat$QueueItem;
import android.support.v4.media.session.MediaSessionCompat$Token;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.Log;
import androidx.media.MediaSessionManager$RemoteUserInfo;
import androidx.media.VolumeProviderCompat;
import androidx.versionedparcelable.VersionedParcelable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class MediaSessionCompat$MediaSessionImplApi21
implements MediaSessionCompat$MediaSessionImpl {
    public MediaSessionCompat$Callback mCallback;
    public boolean mCaptioningEnabled;
    public boolean mDestroyed;
    public final RemoteCallbackList mExtraControllerCallbacks;
    public final Object mLock;
    public MediaMetadataCompat mMetadata;
    public PlaybackStateCompat mPlaybackState;
    public List mQueue;
    public int mRatingType;
    public MediaSessionManager$RemoteUserInfo mRemoteUserInfo;
    public int mRepeatMode;
    public final MediaSession mSessionFwk;
    public Bundle mSessionInfo;
    public int mShuffleMode;
    public final MediaSessionCompat$Token mToken;

    public MediaSessionCompat$MediaSessionImplApi21(MediaSession mediaSession, VersionedParcelable versionedParcelable, Bundle bundle) {
        Object object;
        this.mLock = object = new Object();
        this.mDestroyed = false;
        object = new RemoteCallbackList();
        this.mExtraControllerCallbacks = object;
        this.mSessionFwk = mediaSession;
        mediaSession = mediaSession.getSessionToken();
        MediaSessionCompat$MediaSessionImplApi21$ExtraSession mediaSessionCompat$MediaSessionImplApi21$ExtraSession = new MediaSessionCompat$MediaSessionImplApi21$ExtraSession(this);
        this.mToken = object = new MediaSessionCompat$Token(mediaSession, mediaSessionCompat$MediaSessionImplApi21$ExtraSession, versionedParcelable);
        this.mSessionInfo = bundle;
        this.setFlags(3);
    }

    public MediaSessionCompat$MediaSessionImplApi21(Object object) {
        Object object2;
        this.mLock = object2 = new Object();
        this.mDestroyed = false;
        object2 = new RemoteCallbackList();
        this.mExtraControllerCallbacks = object2;
        boolean bl2 = object instanceof MediaSession;
        if (bl2) {
            object = (MediaSession)object;
            this.mSessionFwk = object;
            object = object.getSessionToken();
            MediaSessionCompat$MediaSessionImplApi21$ExtraSession mediaSessionCompat$MediaSessionImplApi21$ExtraSession = new MediaSessionCompat$MediaSessionImplApi21$ExtraSession(this);
            this.mToken = object2 = new MediaSessionCompat$Token(object, mediaSessionCompat$MediaSessionImplApi21$ExtraSession);
            this.mSessionInfo = null;
            this.setFlags(3);
            return;
        }
        object = new IllegalArgumentException("mediaSession is not a valid MediaSession object");
        throw object;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public MediaSessionCompat$Callback getCallback() {
        Object object = this.mLock;
        synchronized (object) {
            return this.mCallback;
        }
    }

    public String getCallingPackage() {
        Object object;
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 24;
        if (n10 < n11) {
            return null;
        }
        try {
            object = this.mSessionFwk;
        }
        catch (Exception exception) {
            Log.e((String)"MediaSessionCompat", (String)"Cannot execute MediaSession.getCallingPackage()", (Throwable)exception);
            return null;
        }
        object = object.getClass();
        String string2 = "getCallingPackage";
        Object[] objectArray = null;
        Class[] classArray = new Class[]{};
        object = ((Class)object).getMethod(string2, classArray);
        string2 = this.mSessionFwk;
        objectArray = new Object[]{};
        object = ((Method)object).invoke(string2, objectArray);
        return (String)object;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public MediaSessionManager$RemoteUserInfo getCurrentControllerInfo() {
        Object object = this.mLock;
        synchronized (object) {
            return this.mRemoteUserInfo;
        }
    }

    public Object getMediaSession() {
        return this.mSessionFwk;
    }

    public PlaybackStateCompat getPlaybackState() {
        return this.mPlaybackState;
    }

    public Object getRemoteControlClient() {
        return null;
    }

    public MediaSessionCompat$Token getSessionToken() {
        return this.mToken;
    }

    public boolean isActive() {
        return this.mSessionFwk.isActive();
    }

    public void release() {
        block9: {
            boolean bl2;
            this.mDestroyed = bl2 = true;
            Object object = this.mExtraControllerCallbacks;
            object.kill();
            int n10 = Build.VERSION.SDK_INT;
            int n11 = 27;
            if (n10 == n11) {
                object = this.mSessionFwk;
                object = object.getClass();
                String string2 = "mCallback";
                object = ((Class)object).getDeclaredField(string2);
                ((Field)object).setAccessible(bl2);
                Object object2 = this.mSessionFwk;
                object2 = ((Field)object).get(object2);
                object2 = (Handler)object2;
                if (object2 == null) break block9;
                try {
                    object2.removeCallbacksAndMessages(null);
                }
                catch (Exception exception) {
                    object = "MediaSessionCompat";
                    string2 = "Exception happened while accessing MediaSession.mCallback.";
                    Log.w((String)object, (String)string2, (Throwable)exception);
                }
            }
        }
        this.mSessionFwk.setCallback(null);
        this.mSessionFwk.release();
    }

    /*
     * Unable to fully structure code
     */
    public void sendSessionEvent(String var1_1, Bundle var2_2) {
        var3_3 = Build.VERSION.SDK_INT;
        var4_4 = 23;
        if (var3_3 < var4_4) {
            var5_5 = this.mExtraControllerCallbacks;
            block2: for (var3_3 = var5_5.beginBroadcast() + -1; var3_3 >= 0; var3_3 += -1) {
                var6_6 = (IMediaControllerCallback)this.mExtraControllerCallbacks.getBroadcastItem(var3_3);
                var6_6.onEvent(var1_1, var2_2);
lbl9:
                // 2 sources

                continue block2;
            }
            var5_5 = this.mExtraControllerCallbacks;
            var5_5.finishBroadcast();
        }
        this.mSessionFwk.sendSessionEvent(var1_1, var2_2);
        return;
        catch (RemoteException v0) {
            ** continue;
        }
    }

    public void setActive(boolean bl2) {
        this.mSessionFwk.setActive(bl2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void setCallback(MediaSessionCompat$Callback mediaSessionCompat$Callback, Handler handler) {
        Object object = this.mLock;
        synchronized (object) {
            this.mCallback = mediaSessionCompat$Callback;
            MediaSession mediaSession = this.mSessionFwk;
            MediaSession.Callback callback = mediaSessionCompat$Callback == null ? null : mediaSessionCompat$Callback.mCallbackFwk;
            mediaSession.setCallback(callback, handler);
            if (mediaSessionCompat$Callback != null) {
                mediaSessionCompat$Callback.setSessionImpl(this, handler);
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public void setCaptioningEnabled(boolean bl2) {
        int n10 = (int)(this.mCaptioningEnabled ? 1 : 0);
        if (n10 == bl2) return;
        this.mCaptioningEnabled = bl2;
        RemoteCallbackList remoteCallbackList = this.mExtraControllerCallbacks;
        n10 = remoteCallbackList.beginBroadcast() + -1;
        while (true) {
            if (n10 < 0) {
                RemoteCallbackList remoteCallbackList2 = this.mExtraControllerCallbacks;
                remoteCallbackList2.finishBroadcast();
                return;
            }
            IMediaControllerCallback iMediaControllerCallback = (IMediaControllerCallback)this.mExtraControllerCallbacks.getBroadcastItem(n10);
            try {
                iMediaControllerCallback.onCaptioningEnabledChanged(bl2);
            }
            catch (RemoteException remoteException) {}
            n10 += -1;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void setCurrentControllerInfo(MediaSessionManager$RemoteUserInfo mediaSessionManager$RemoteUserInfo) {
        Object object = this.mLock;
        synchronized (object) {
            this.mRemoteUserInfo = mediaSessionManager$RemoteUserInfo;
            return;
        }
    }

    public void setExtras(Bundle bundle) {
        this.mSessionFwk.setExtras(bundle);
    }

    public void setFlags(int n10) {
        MediaSession mediaSession = this.mSessionFwk;
        n10 = n10 | 1 | 2;
        mediaSession.setFlags(n10);
    }

    public void setMediaButtonReceiver(PendingIntent pendingIntent) {
        this.mSessionFwk.setMediaButtonReceiver(pendingIntent);
    }

    public void setMetadata(MediaMetadataCompat mediaMetadataCompat) {
        this.mMetadata = mediaMetadataCompat;
        MediaSession mediaSession = this.mSessionFwk;
        mediaMetadataCompat = mediaMetadataCompat == null ? null : (MediaMetadata)mediaMetadataCompat.getMediaMetadata();
        mediaSession.setMetadata((MediaMetadata)mediaMetadataCompat);
    }

    /*
     * Loose catch block
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void setPlaybackState(PlaybackStateCompat playbackStateCompat) {
        this.mPlaybackState = playbackStateCompat;
        RemoteCallbackList remoteCallbackList = this.mExtraControllerCallbacks;
        int n10 = remoteCallbackList.beginBroadcast() + -1;
        while (true) {
            if (n10 >= 0) {
                IMediaControllerCallback iMediaControllerCallback = (IMediaControllerCallback)this.mExtraControllerCallbacks.getBroadcastItem(n10);
                iMediaControllerCallback.onPlaybackStateChanged(playbackStateCompat);
            } else {
                void var1_4;
                this.mExtraControllerCallbacks.finishBroadcast();
                remoteCallbackList = this.mSessionFwk;
                if (playbackStateCompat == null) {
                    Object var1_2 = null;
                } else {
                    PlaybackState playbackState = (PlaybackState)playbackStateCompat.getPlaybackState();
                }
                remoteCallbackList.setPlaybackState((PlaybackState)var1_4);
                return;
                catch (RemoteException remoteException) {}
            }
            n10 += -1;
        }
    }

    public void setPlaybackToLocal(int n10) {
        AudioAttributes.Builder builder = new AudioAttributes.Builder();
        builder.setLegacyStreamType(n10);
        MediaSession mediaSession = this.mSessionFwk;
        builder = builder.build();
        mediaSession.setPlaybackToLocal((AudioAttributes)builder);
    }

    public void setPlaybackToRemote(VolumeProviderCompat volumeProviderCompat) {
        MediaSession mediaSession = this.mSessionFwk;
        volumeProviderCompat = (VolumeProvider)volumeProviderCompat.getVolumeProvider();
        mediaSession.setPlaybackToRemote((VolumeProvider)volumeProviderCompat);
    }

    public void setQueue(List object) {
        boolean bl2;
        this.mQueue = object;
        if (object == null) {
            this.mSessionFwk.setQueue(null);
            return;
        }
        ArrayList<MediaSession.QueueItem> arrayList = new ArrayList<MediaSession.QueueItem>();
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            MediaSession.QueueItem queueItem = (MediaSession.QueueItem)((MediaSessionCompat$QueueItem)object.next()).getQueueItem();
            arrayList.add(queueItem);
        }
        this.mSessionFwk.setQueue(arrayList);
    }

    public void setQueueTitle(CharSequence charSequence) {
        this.mSessionFwk.setQueueTitle(charSequence);
    }

    public void setRatingType(int n10) {
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 22;
        if (n11 < n12) {
            this.mRatingType = n10;
        } else {
            MediaSession mediaSession = this.mSessionFwk;
            mediaSession.setRatingType(n10);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public void setRepeatMode(int n10) {
        int n11 = this.mRepeatMode;
        if (n11 == n10) return;
        this.mRepeatMode = n10;
        RemoteCallbackList remoteCallbackList = this.mExtraControllerCallbacks;
        n11 = remoteCallbackList.beginBroadcast() + -1;
        while (true) {
            if (n11 < 0) {
                RemoteCallbackList remoteCallbackList2 = this.mExtraControllerCallbacks;
                remoteCallbackList2.finishBroadcast();
                return;
            }
            IMediaControllerCallback iMediaControllerCallback = (IMediaControllerCallback)this.mExtraControllerCallbacks.getBroadcastItem(n11);
            try {
                iMediaControllerCallback.onRepeatModeChanged(n10);
            }
            catch (RemoteException remoteException) {}
            n11 += -1;
        }
    }

    public void setSessionActivity(PendingIntent pendingIntent) {
        this.mSessionFwk.setSessionActivity(pendingIntent);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public void setShuffleMode(int n10) {
        int n11 = this.mShuffleMode;
        if (n11 == n10) return;
        this.mShuffleMode = n10;
        RemoteCallbackList remoteCallbackList = this.mExtraControllerCallbacks;
        n11 = remoteCallbackList.beginBroadcast() + -1;
        while (true) {
            if (n11 < 0) {
                RemoteCallbackList remoteCallbackList2 = this.mExtraControllerCallbacks;
                remoteCallbackList2.finishBroadcast();
                return;
            }
            IMediaControllerCallback iMediaControllerCallback = (IMediaControllerCallback)this.mExtraControllerCallbacks.getBroadcastItem(n11);
            try {
                iMediaControllerCallback.onShuffleModeChanged(n10);
            }
            catch (RemoteException remoteException) {}
            n11 += -1;
        }
    }
}

