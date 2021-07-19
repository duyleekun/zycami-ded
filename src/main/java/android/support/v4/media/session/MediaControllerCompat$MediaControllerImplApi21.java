/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.PendingIntent
 *  android.content.Context
 *  android.media.session.MediaController
 *  android.media.session.MediaController$PlaybackInfo
 *  android.media.session.MediaController$TransportControls
 *  android.media.session.MediaSession$Token
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.Parcelable
 *  android.os.RemoteException
 *  android.os.ResultReceiver
 *  android.util.Log
 *  android.view.KeyEvent
 */
package android.support.v4.media.session;

import android.app.PendingIntent;
import android.content.Context;
import android.media.session.MediaController;
import android.media.session.MediaSession;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.IMediaControllerCallback;
import android.support.v4.media.session.IMediaSession;
import android.support.v4.media.session.MediaControllerCompat$Callback;
import android.support.v4.media.session.MediaControllerCompat$MediaControllerImpl;
import android.support.v4.media.session.MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver;
import android.support.v4.media.session.MediaControllerCompat$MediaControllerImplApi21$ExtraCallback;
import android.support.v4.media.session.MediaControllerCompat$PlaybackInfo;
import android.support.v4.media.session.MediaControllerCompat$TransportControls;
import android.support.v4.media.session.MediaControllerCompat$TransportControlsApi21;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.MediaSessionCompat$QueueItem;
import android.support.v4.media.session.MediaSessionCompat$Token;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.Log;
import android.view.KeyEvent;
import androidx.media.AudioAttributesCompat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MediaControllerCompat$MediaControllerImplApi21
implements MediaControllerCompat$MediaControllerImpl {
    private HashMap mCallbackMap;
    public final MediaController mControllerFwk;
    public final Object mLock;
    private final List mPendingCallbacks;
    private Bundle mSessionInfo;
    public final MediaSessionCompat$Token mSessionToken;

    public MediaControllerCompat$MediaControllerImplApi21(Context object, MediaSessionCompat$Token mediaSessionCompat$Token) {
        MediaController mediaController = new Object();
        this.mLock = mediaController;
        mediaController = new ArrayList();
        this.mPendingCallbacks = mediaController;
        this.mCallbackMap = mediaController;
        this.mSessionToken = mediaSessionCompat$Token;
        MediaSession.Token token = (MediaSession.Token)mediaSessionCompat$Token.getToken();
        this.mControllerFwk = mediaController = new MediaController(object, token);
        object = mediaSessionCompat$Token.getExtraBinder();
        if (object == null) {
            this.requestExtraBinder();
        }
    }

    private void requestExtraBinder() {
        MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver mediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver = new MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver(this);
        this.sendCommand("android.support.v4.media.session.command.GET_EXTRA_BINDER", null, mediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver);
    }

    public void addQueueItem(MediaDescriptionCompat object) {
        long l10;
        long l11 = this.getFlags() & (long)4;
        long l12 = l11 - (l10 = 0L);
        Object object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object2 != false) {
            Bundle bundle = new Bundle();
            bundle.putParcelable("android.support.v4.media.session.command.ARGUMENT_MEDIA_DESCRIPTION", (Parcelable)object);
            this.sendCommand("android.support.v4.media.session.command.ADD_QUEUE_ITEM", bundle, null);
            return;
        }
        object = new UnsupportedOperationException("This session doesn't support queue management operations");
        throw object;
    }

    public void addQueueItem(MediaDescriptionCompat object, int n10) {
        long l10;
        long l11 = this.getFlags() & (long)4;
        long l12 = l11 - (l10 = 0L);
        Object object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object2 != false) {
            Bundle bundle = new Bundle();
            bundle.putParcelable("android.support.v4.media.session.command.ARGUMENT_MEDIA_DESCRIPTION", (Parcelable)object);
            bundle.putInt("android.support.v4.media.session.command.ARGUMENT_INDEX", n10);
            this.sendCommand("android.support.v4.media.session.command.ADD_QUEUE_ITEM_AT", bundle, null);
            return;
        }
        object = new UnsupportedOperationException("This session doesn't support queue management operations");
        throw object;
    }

    public void adjustVolume(int n10, int n11) {
        this.mControllerFwk.adjustVolume(n10, n11);
    }

    public boolean dispatchMediaButtonEvent(KeyEvent keyEvent) {
        return this.mControllerFwk.dispatchMediaButtonEvent(keyEvent);
    }

    public Bundle getExtras() {
        return this.mControllerFwk.getExtras();
    }

    public long getFlags() {
        return this.mControllerFwk.getFlags();
    }

    public Object getMediaController() {
        return this.mControllerFwk;
    }

    public MediaMetadataCompat getMetadata() {
        Object object = this.mControllerFwk.getMetadata();
        object = object != null ? MediaMetadataCompat.fromMediaMetadata(object) : null;
        return object;
    }

    public String getPackageName() {
        return this.mControllerFwk.getPackageName();
    }

    public MediaControllerCompat$PlaybackInfo getPlaybackInfo() {
        MediaControllerCompat$PlaybackInfo mediaControllerCompat$PlaybackInfo;
        MediaController.PlaybackInfo playbackInfo = this.mControllerFwk.getPlaybackInfo();
        if (playbackInfo != null) {
            int n10 = playbackInfo.getPlaybackType();
            AudioAttributesCompat audioAttributesCompat = AudioAttributesCompat.wrap(playbackInfo.getAudioAttributes());
            int n11 = playbackInfo.getVolumeControl();
            int n12 = playbackInfo.getMaxVolume();
            int n13 = playbackInfo.getCurrentVolume();
            mediaControllerCompat$PlaybackInfo = new MediaControllerCompat$PlaybackInfo(n10, audioAttributesCompat, n11, n12, n13);
        } else {
            mediaControllerCompat$PlaybackInfo = null;
        }
        return mediaControllerCompat$PlaybackInfo;
    }

    public PlaybackStateCompat getPlaybackState() {
        Object object = this.mSessionToken.getExtraBinder();
        if (object != null) {
            object = this.mSessionToken;
            object = ((MediaSessionCompat$Token)object).getExtraBinder();
            try {
                return object.getPlaybackState();
            }
            catch (RemoteException remoteException) {
                String string2 = "MediaControllerCompat";
                String string3 = "Dead object in getPlaybackState.";
                Log.e((String)string2, (String)string3, (Throwable)remoteException);
            }
        }
        object = (object = this.mControllerFwk.getPlaybackState()) != null ? PlaybackStateCompat.fromPlaybackState(object) : null;
        return object;
    }

    public List getQueue() {
        List list = this.mControllerFwk.getQueue();
        list = list != null ? MediaSessionCompat$QueueItem.fromQueueItemList(list) : null;
        return list;
    }

    public CharSequence getQueueTitle() {
        return this.mControllerFwk.getQueueTitle();
    }

    public int getRatingType() {
        Object object;
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 22;
        if (n10 < n11 && (object = this.mSessionToken.getExtraBinder()) != null) {
            object = this.mSessionToken;
            object = ((MediaSessionCompat$Token)object).getExtraBinder();
            try {
                return object.getRatingType();
            }
            catch (RemoteException remoteException) {
                String string2 = "MediaControllerCompat";
                String string3 = "Dead object in getRatingType.";
                Log.e((String)string2, (String)string3, (Throwable)remoteException);
            }
        }
        return this.mControllerFwk.getRatingType();
    }

    public int getRepeatMode() {
        Object object = this.mSessionToken.getExtraBinder();
        if (object != null) {
            object = this.mSessionToken;
            object = ((MediaSessionCompat$Token)object).getExtraBinder();
            try {
                return object.getRepeatMode();
            }
            catch (RemoteException remoteException) {
                String string2 = "MediaControllerCompat";
                String string3 = "Dead object in getRepeatMode.";
                Log.e((String)string2, (String)string3, (Throwable)remoteException);
            }
        }
        return -1;
    }

    public PendingIntent getSessionActivity() {
        return this.mControllerFwk.getSessionActivity();
    }

    public Bundle getSessionInfo() {
        String string2;
        Object object = this.mSessionInfo;
        if (object != null) {
            Bundle bundle = this.mSessionInfo;
            object = new Bundle(bundle);
            return object;
        }
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 29;
        if (n10 >= n11) {
            object = this.mControllerFwk.getSessionInfo();
            this.mSessionInfo = object;
        } else {
            object = this.mSessionToken.getExtraBinder();
            if (object != null) {
                object = this.mSessionToken;
                object = ((MediaSessionCompat$Token)object).getExtraBinder();
                object = object.getSessionInfo();
                try {
                    this.mSessionInfo = object;
                }
                catch (RemoteException remoteException) {
                    string2 = "MediaControllerCompat";
                    String string3 = "Dead object in getSessionInfo.";
                    Log.e((String)string2, (String)string3, (Throwable)remoteException);
                    object = Bundle.EMPTY;
                    this.mSessionInfo = object;
                }
            }
        }
        object = MediaSessionCompat.unparcelWithClassLoader(this.mSessionInfo);
        this.mSessionInfo = object;
        if (object == null) {
            object = Bundle.EMPTY;
        } else {
            string2 = this.mSessionInfo;
            object = new Bundle((Bundle)string2);
        }
        return object;
    }

    public int getShuffleMode() {
        Object object = this.mSessionToken.getExtraBinder();
        if (object != null) {
            object = this.mSessionToken;
            object = ((MediaSessionCompat$Token)object).getExtraBinder();
            try {
                return object.getShuffleMode();
            }
            catch (RemoteException remoteException) {
                String string2 = "MediaControllerCompat";
                String string3 = "Dead object in getShuffleMode.";
                Log.e((String)string2, (String)string3, (Throwable)remoteException);
            }
        }
        return -1;
    }

    public MediaControllerCompat$TransportControls getTransportControls() {
        MediaController.TransportControls transportControls = this.mControllerFwk.getTransportControls();
        MediaControllerCompat$TransportControlsApi21 mediaControllerCompat$TransportControlsApi21 = new MediaControllerCompat$TransportControlsApi21(transportControls);
        return mediaControllerCompat$TransportControlsApi21;
    }

    public boolean isCaptioningEnabled() {
        Object object = this.mSessionToken.getExtraBinder();
        if (object != null) {
            object = this.mSessionToken;
            object = ((MediaSessionCompat$Token)object).getExtraBinder();
            try {
                return object.isCaptioningEnabled();
            }
            catch (RemoteException remoteException) {
                String string2 = "MediaControllerCompat";
                String string3 = "Dead object in isCaptioningEnabled.";
                Log.e((String)string2, (String)string3, (Throwable)remoteException);
            }
        }
        return false;
    }

    public boolean isSessionReady() {
        boolean bl2;
        IMediaSession iMediaSession = this.mSessionToken.getExtraBinder();
        if (iMediaSession != null) {
            bl2 = true;
        } else {
            bl2 = false;
            iMediaSession = null;
        }
        return bl2;
    }

    public void processPendingCallbacksLocked() {
        boolean bl2;
        Object object = this.mSessionToken.getExtraBinder();
        if (object == null) {
            return;
        }
        object = this.mPendingCallbacks.iterator();
        while (bl2 = object.hasNext()) {
            Object object2 = (MediaControllerCompat$Callback)object.next();
            Object object3 = new MediaControllerCompat$MediaControllerImplApi21$ExtraCallback((MediaControllerCompat$Callback)object2);
            Object object4 = this.mCallbackMap;
            ((HashMap)object4).put(object2, object3);
            ((MediaControllerCompat$Callback)object2).mIControllerCallback = object3;
            object4 = this.mSessionToken;
            object4 = ((MediaSessionCompat$Token)object4).getExtraBinder();
            try {
                object4.registerCallbackListener((IMediaControllerCallback)object3);
                int n10 = 13;
                object4 = null;
                ((MediaControllerCompat$Callback)object2).postToHandler(n10, null, null);
            }
            catch (RemoteException remoteException) {
                object2 = "MediaControllerCompat";
                object3 = "Dead object in registerCallback.";
                Log.e((String)object2, (String)object3, (Throwable)remoteException);
                break;
            }
        }
        this.mPendingCallbacks.clear();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void registerCallback(MediaControllerCompat$Callback mediaControllerCompat$Callback, Handler object) {
        Object object2 = this.mControllerFwk;
        Object object3 = mediaControllerCompat$Callback.mCallbackFwk;
        object2.registerCallback(object3, object);
        object = this.mLock;
        synchronized (object) {
            object2 = this.mSessionToken;
            object2 = ((MediaSessionCompat$Token)object2).getExtraBinder();
            object3 = null;
            if (object2 != null) {
                object2 = new MediaControllerCompat$MediaControllerImplApi21$ExtraCallback(mediaControllerCompat$Callback);
                Object object4 = this.mCallbackMap;
                ((HashMap)object4).put(mediaControllerCompat$Callback, object2);
                mediaControllerCompat$Callback.mIControllerCallback = object2;
                try {
                    object4 = this.mSessionToken;
                    object4 = ((MediaSessionCompat$Token)object4).getExtraBinder();
                    object4.registerCallbackListener((IMediaControllerCallback)object2);
                    int n10 = 13;
                    mediaControllerCompat$Callback.postToHandler(n10, null, null);
                }
                catch (RemoteException remoteException) {
                    object2 = "MediaControllerCompat";
                    object3 = "Dead object in registerCallback.";
                    Log.e((String)object2, (String)object3, (Throwable)remoteException);
                }
            } else {
                mediaControllerCompat$Callback.mIControllerCallback = null;
                object2 = this.mPendingCallbacks;
                object2.add(mediaControllerCompat$Callback);
            }
            return;
        }
    }

    public void removeQueueItem(MediaDescriptionCompat object) {
        long l10;
        long l11 = this.getFlags() & (long)4;
        long l12 = l11 - (l10 = 0L);
        Object object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object2 != false) {
            Bundle bundle = new Bundle();
            bundle.putParcelable("android.support.v4.media.session.command.ARGUMENT_MEDIA_DESCRIPTION", (Parcelable)object);
            this.sendCommand("android.support.v4.media.session.command.REMOVE_QUEUE_ITEM", bundle, null);
            return;
        }
        object = new UnsupportedOperationException("This session doesn't support queue management operations");
        throw object;
    }

    public void sendCommand(String string2, Bundle bundle, ResultReceiver resultReceiver) {
        this.mControllerFwk.sendCommand(string2, bundle, resultReceiver);
    }

    public void setVolumeTo(int n10, int n11) {
        this.mControllerFwk.setVolumeTo(n10, n11);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void unregisterCallback(MediaControllerCompat$Callback object) {
        Object object2 = this.mControllerFwk;
        Object object3 = ((MediaControllerCompat$Callback)object).mCallbackFwk;
        object2.unregisterCallback(object3);
        object2 = this.mLock;
        synchronized (object2) {
            object3 = this.mSessionToken;
            object3 = object3.getExtraBinder();
            if (object3 != null) {
                try {
                    object3 = this.mCallbackMap;
                    object3 = object3.remove(object);
                    object3 = (MediaControllerCompat$MediaControllerImplApi21$ExtraCallback)object3;
                    if (object3 != null) {
                        Object var4_5 = null;
                        ((MediaControllerCompat$Callback)object).mIControllerCallback = null;
                        object = this.mSessionToken;
                        object = ((MediaSessionCompat$Token)object).getExtraBinder();
                        object.unregisterCallbackListener((IMediaControllerCallback)object3);
                    }
                }
                catch (RemoteException remoteException) {
                    object3 = "MediaControllerCompat";
                    String string2 = "Dead object in unregisterCallback.";
                    Log.e((String)object3, (String)string2, (Throwable)remoteException);
                }
            } else {
                object3 = this.mPendingCallbacks;
                object3.remove(object);
            }
            return;
        }
    }
}

