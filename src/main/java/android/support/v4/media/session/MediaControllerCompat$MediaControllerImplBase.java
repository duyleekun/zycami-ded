/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.PendingIntent
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.IBinder
 *  android.os.IBinder$DeathRecipient
 *  android.os.RemoteException
 *  android.os.ResultReceiver
 *  android.util.Log
 *  android.view.KeyEvent
 */
package android.support.v4.media.session;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.IMediaControllerCallback;
import android.support.v4.media.session.IMediaSession;
import android.support.v4.media.session.IMediaSession$Stub;
import android.support.v4.media.session.MediaControllerCompat$Callback;
import android.support.v4.media.session.MediaControllerCompat$MediaControllerImpl;
import android.support.v4.media.session.MediaControllerCompat$PlaybackInfo;
import android.support.v4.media.session.MediaControllerCompat$TransportControls;
import android.support.v4.media.session.MediaControllerCompat$TransportControlsBase;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.MediaSessionCompat$ResultReceiverWrapper;
import android.support.v4.media.session.MediaSessionCompat$Token;
import android.support.v4.media.session.ParcelableVolumeInfo;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.Log;
import android.view.KeyEvent;
import java.util.List;

public class MediaControllerCompat$MediaControllerImplBase
implements MediaControllerCompat$MediaControllerImpl {
    private IMediaSession mBinder;
    private Bundle mSessionInfo;
    private MediaControllerCompat$TransportControls mTransportControls;

    public MediaControllerCompat$MediaControllerImplBase(MediaSessionCompat$Token object) {
        this.mBinder = object = IMediaSession$Stub.asInterface((IBinder)((MediaSessionCompat$Token)object).getToken());
    }

    public void addQueueItem(MediaDescriptionCompat object) {
        Object object2;
        block6: {
            object2 = this.mBinder;
            long l10 = object2.getFlags() & (long)4;
            long l11 = 0L;
            long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
            if (l12 == false) break block6;
            object2 = this.mBinder;
            object2.addQueueItem((MediaDescriptionCompat)object);
        }
        object2 = "This session doesn't support queue management operations";
        try {
            object = new UnsupportedOperationException((String)object2);
            throw object;
        }
        catch (RemoteException remoteException) {
            object2 = "MediaControllerCompat";
            String string2 = "Dead object in addQueueItem.";
            Log.e((String)object2, (String)string2, (Throwable)remoteException);
        }
    }

    public void addQueueItem(MediaDescriptionCompat object, int n10) {
        Object object2;
        block6: {
            object2 = this.mBinder;
            long l10 = object2.getFlags() & (long)4;
            long l11 = 0L;
            long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
            if (l12 == false) break block6;
            object2 = this.mBinder;
            object2.addQueueItemAt((MediaDescriptionCompat)object, n10);
        }
        String string2 = "This session doesn't support queue management operations";
        try {
            object = new UnsupportedOperationException(string2);
            throw object;
        }
        catch (RemoteException remoteException) {
            string2 = "MediaControllerCompat";
            object2 = "Dead object in addQueueItemAt.";
            Log.e((String)string2, (String)object2, (Throwable)remoteException);
        }
    }

    public void adjustVolume(int n10, int n11) {
        Object object = this.mBinder;
        try {
            object.adjustVolume(n10, n11, null);
        }
        catch (RemoteException remoteException) {
            String string2 = "MediaControllerCompat";
            object = "Dead object in adjustVolume.";
            Log.e((String)string2, (String)object, (Throwable)remoteException);
        }
    }

    public boolean dispatchMediaButtonEvent(KeyEvent object) {
        if (object != null) {
            Object object2 = this.mBinder;
            try {
                object2.sendMediaButton((KeyEvent)object);
            }
            catch (RemoteException remoteException) {
                object2 = "MediaControllerCompat";
                String string2 = "Dead object in dispatchMediaButtonEvent.";
                Log.e((String)object2, (String)string2, (Throwable)remoteException);
            }
            return false;
        }
        object = new IllegalArgumentException("event may not be null.");
        throw object;
    }

    public Bundle getExtras() {
        IMediaSession iMediaSession;
        try {
            iMediaSession = this.mBinder;
        }
        catch (RemoteException remoteException) {
            Log.e((String)"MediaControllerCompat", (String)"Dead object in getExtras.", (Throwable)remoteException);
            return null;
        }
        return iMediaSession.getExtras();
    }

    public long getFlags() {
        IMediaSession iMediaSession;
        try {
            iMediaSession = this.mBinder;
        }
        catch (RemoteException remoteException) {
            Log.e((String)"MediaControllerCompat", (String)"Dead object in getFlags.", (Throwable)remoteException);
            return 0L;
        }
        return iMediaSession.getFlags();
    }

    public Object getMediaController() {
        return null;
    }

    public MediaMetadataCompat getMetadata() {
        IMediaSession iMediaSession;
        try {
            iMediaSession = this.mBinder;
        }
        catch (RemoteException remoteException) {
            Log.e((String)"MediaControllerCompat", (String)"Dead object in getMetadata.", (Throwable)remoteException);
            return null;
        }
        return iMediaSession.getMetadata();
    }

    public String getPackageName() {
        IMediaSession iMediaSession;
        try {
            iMediaSession = this.mBinder;
        }
        catch (RemoteException remoteException) {
            Log.e((String)"MediaControllerCompat", (String)"Dead object in getPackageName.", (Throwable)remoteException);
            return null;
        }
        return iMediaSession.getPackageName();
    }

    public MediaControllerCompat$PlaybackInfo getPlaybackInfo() {
        Object object;
        try {
            object = this.mBinder;
        }
        catch (RemoteException remoteException) {
            Log.e((String)"MediaControllerCompat", (String)"Dead object in getPlaybackInfo.", (Throwable)remoteException);
            return null;
        }
        object = object.getVolumeAttributes();
        int n10 = ((ParcelableVolumeInfo)object).volumeType;
        int n11 = ((ParcelableVolumeInfo)object).audioStream;
        int n12 = ((ParcelableVolumeInfo)object).controlType;
        int n13 = ((ParcelableVolumeInfo)object).maxVolume;
        int n14 = ((ParcelableVolumeInfo)object).currentVolume;
        MediaControllerCompat$PlaybackInfo mediaControllerCompat$PlaybackInfo = new MediaControllerCompat$PlaybackInfo(n10, n11, n12, n13, n14);
        return mediaControllerCompat$PlaybackInfo;
    }

    public PlaybackStateCompat getPlaybackState() {
        IMediaSession iMediaSession;
        try {
            iMediaSession = this.mBinder;
        }
        catch (RemoteException remoteException) {
            Log.e((String)"MediaControllerCompat", (String)"Dead object in getPlaybackState.", (Throwable)remoteException);
            return null;
        }
        return iMediaSession.getPlaybackState();
    }

    public List getQueue() {
        IMediaSession iMediaSession;
        try {
            iMediaSession = this.mBinder;
        }
        catch (RemoteException remoteException) {
            Log.e((String)"MediaControllerCompat", (String)"Dead object in getQueue.", (Throwable)remoteException);
            return null;
        }
        return iMediaSession.getQueue();
    }

    public CharSequence getQueueTitle() {
        IMediaSession iMediaSession;
        try {
            iMediaSession = this.mBinder;
        }
        catch (RemoteException remoteException) {
            Log.e((String)"MediaControllerCompat", (String)"Dead object in getQueueTitle.", (Throwable)remoteException);
            return null;
        }
        return iMediaSession.getQueueTitle();
    }

    public int getRatingType() {
        IMediaSession iMediaSession;
        try {
            iMediaSession = this.mBinder;
        }
        catch (RemoteException remoteException) {
            Log.e((String)"MediaControllerCompat", (String)"Dead object in getRatingType.", (Throwable)remoteException);
            return 0;
        }
        return iMediaSession.getRatingType();
    }

    public int getRepeatMode() {
        IMediaSession iMediaSession;
        try {
            iMediaSession = this.mBinder;
        }
        catch (RemoteException remoteException) {
            Log.e((String)"MediaControllerCompat", (String)"Dead object in getRepeatMode.", (Throwable)remoteException);
            return -1;
        }
        return iMediaSession.getRepeatMode();
    }

    public PendingIntent getSessionActivity() {
        IMediaSession iMediaSession;
        try {
            iMediaSession = this.mBinder;
        }
        catch (RemoteException remoteException) {
            Log.e((String)"MediaControllerCompat", (String)"Dead object in getSessionActivity.", (Throwable)remoteException);
            return null;
        }
        return iMediaSession.getLaunchPendingIntent();
    }

    public Bundle getSessionInfo() {
        String string2;
        IMediaSession iMediaSession = this.mBinder;
        iMediaSession = iMediaSession.getSessionInfo();
        try {
            this.mSessionInfo = iMediaSession;
        }
        catch (RemoteException remoteException) {
            string2 = "MediaControllerCompat";
            String string3 = "Dead object in getSessionInfo.";
            Log.d((String)string2, (String)string3, (Throwable)remoteException);
        }
        iMediaSession = MediaSessionCompat.unparcelWithClassLoader(this.mSessionInfo);
        this.mSessionInfo = iMediaSession;
        if (iMediaSession == null) {
            iMediaSession = Bundle.EMPTY;
        } else {
            string2 = this.mSessionInfo;
            iMediaSession = new Bundle((Bundle)string2);
        }
        return iMediaSession;
    }

    public int getShuffleMode() {
        IMediaSession iMediaSession;
        try {
            iMediaSession = this.mBinder;
        }
        catch (RemoteException remoteException) {
            Log.e((String)"MediaControllerCompat", (String)"Dead object in getShuffleMode.", (Throwable)remoteException);
            return -1;
        }
        return iMediaSession.getShuffleMode();
    }

    public MediaControllerCompat$TransportControls getTransportControls() {
        MediaControllerCompat$TransportControls mediaControllerCompat$TransportControls = this.mTransportControls;
        if (mediaControllerCompat$TransportControls == null) {
            IMediaSession iMediaSession = this.mBinder;
            this.mTransportControls = mediaControllerCompat$TransportControls = new MediaControllerCompat$TransportControlsBase(iMediaSession);
        }
        return this.mTransportControls;
    }

    public boolean isCaptioningEnabled() {
        IMediaSession iMediaSession;
        try {
            iMediaSession = this.mBinder;
        }
        catch (RemoteException remoteException) {
            Log.e((String)"MediaControllerCompat", (String)"Dead object in isCaptioningEnabled.", (Throwable)remoteException);
            return false;
        }
        return iMediaSession.isCaptioningEnabled();
    }

    public boolean isSessionReady() {
        return true;
    }

    public void registerCallback(MediaControllerCompat$Callback object, Handler handler) {
        if (object != null) {
            IMediaSession iMediaSession = this.mBinder;
            iMediaSession = iMediaSession.asBinder();
            Object object2 = null;
            iMediaSession.linkToDeath((IBinder.DeathRecipient)object, 0);
            iMediaSession = this.mBinder;
            object2 = ((MediaControllerCompat$Callback)object).mIControllerCallback;
            iMediaSession.registerCallbackListener((IMediaControllerCallback)object2);
            int n10 = 13;
            try {
                ((MediaControllerCompat$Callback)object).postToHandler(n10, null, null);
            }
            catch (RemoteException remoteException) {
                object2 = "MediaControllerCompat";
                String string2 = "Dead object in registerCallback.";
                Log.e((String)object2, (String)string2, (Throwable)remoteException);
                n10 = 8;
                ((MediaControllerCompat$Callback)object).postToHandler(n10, null, null);
            }
            return;
        }
        object = new IllegalArgumentException("callback may not be null.");
        throw object;
    }

    public void removeQueueItem(MediaDescriptionCompat object) {
        Object object2;
        block6: {
            object2 = this.mBinder;
            long l10 = object2.getFlags() & (long)4;
            long l11 = 0L;
            long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
            if (l12 == false) break block6;
            object2 = this.mBinder;
            object2.removeQueueItem((MediaDescriptionCompat)object);
        }
        object2 = "This session doesn't support queue management operations";
        try {
            object = new UnsupportedOperationException((String)object2);
            throw object;
        }
        catch (RemoteException remoteException) {
            object2 = "MediaControllerCompat";
            String string2 = "Dead object in removeQueueItem.";
            Log.e((String)object2, (String)string2, (Throwable)remoteException);
        }
    }

    public void sendCommand(String string2, Bundle object, ResultReceiver object2) {
        IMediaSession iMediaSession;
        block6: {
            block5: {
                iMediaSession = this.mBinder;
                if (object2 != null) break block5;
                object2 = null;
                break block6;
            }
            MediaSessionCompat$ResultReceiverWrapper mediaSessionCompat$ResultReceiverWrapper = new MediaSessionCompat$ResultReceiverWrapper((ResultReceiver)object2);
            object2 = mediaSessionCompat$ResultReceiverWrapper;
        }
        try {
            iMediaSession.sendCommand(string2, (Bundle)object, (MediaSessionCompat$ResultReceiverWrapper)object2);
        }
        catch (RemoteException remoteException) {
            object = "MediaControllerCompat";
            object2 = "Dead object in sendCommand.";
            Log.e((String)object, (String)object2, (Throwable)remoteException);
        }
    }

    public void setVolumeTo(int n10, int n11) {
        Object object = this.mBinder;
        try {
            object.setVolumeTo(n10, n11, null);
        }
        catch (RemoteException remoteException) {
            String string2 = "MediaControllerCompat";
            object = "Dead object in setVolumeTo.";
            Log.e((String)string2, (String)object, (Throwable)remoteException);
        }
    }

    public void unregisterCallback(MediaControllerCompat$Callback object) {
        if (object != null) {
            Object object2 = this.mBinder;
            Object object3 = ((MediaControllerCompat$Callback)object).mIControllerCallback;
            object2.unregisterCallbackListener((IMediaControllerCallback)object3);
            object2 = this.mBinder;
            object2 = object2.asBinder();
            object3 = null;
            try {
                object2.unlinkToDeath((IBinder.DeathRecipient)object, 0);
            }
            catch (RemoteException remoteException) {
                object2 = "MediaControllerCompat";
                object3 = "Dead object in unregisterCallback.";
                Log.e((String)object2, (String)object3, (Throwable)remoteException);
            }
            return;
        }
        object = new IllegalArgumentException("callback may not be null.");
        throw object;
    }
}

