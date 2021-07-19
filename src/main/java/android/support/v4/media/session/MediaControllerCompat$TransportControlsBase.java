/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  android.os.Bundle
 *  android.os.RemoteException
 *  android.util.Log
 */
package android.support.v4.media.session;

import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import android.support.v4.media.RatingCompat;
import android.support.v4.media.session.IMediaSession;
import android.support.v4.media.session.MediaControllerCompat;
import android.support.v4.media.session.MediaControllerCompat$TransportControls;
import android.support.v4.media.session.PlaybackStateCompat$CustomAction;
import android.util.Log;

public class MediaControllerCompat$TransportControlsBase
extends MediaControllerCompat$TransportControls {
    private IMediaSession mBinder;

    public MediaControllerCompat$TransportControlsBase(IMediaSession iMediaSession) {
        this.mBinder = iMediaSession;
    }

    public void fastForward() {
        IMediaSession iMediaSession = this.mBinder;
        try {
            iMediaSession.fastForward();
        }
        catch (RemoteException remoteException) {
            String string2 = "MediaControllerCompat";
            String string3 = "Dead object in fastForward.";
            Log.e((String)string2, (String)string3, (Throwable)remoteException);
        }
    }

    public void pause() {
        IMediaSession iMediaSession = this.mBinder;
        try {
            iMediaSession.pause();
        }
        catch (RemoteException remoteException) {
            String string2 = "MediaControllerCompat";
            String string3 = "Dead object in pause.";
            Log.e((String)string2, (String)string3, (Throwable)remoteException);
        }
    }

    public void play() {
        IMediaSession iMediaSession = this.mBinder;
        try {
            iMediaSession.play();
        }
        catch (RemoteException remoteException) {
            String string2 = "MediaControllerCompat";
            String string3 = "Dead object in play.";
            Log.e((String)string2, (String)string3, (Throwable)remoteException);
        }
    }

    public void playFromMediaId(String string2, Bundle object) {
        Object object2 = this.mBinder;
        try {
            object2.playFromMediaId(string2, (Bundle)object);
        }
        catch (RemoteException remoteException) {
            object = "MediaControllerCompat";
            object2 = "Dead object in playFromMediaId.";
            Log.e((String)object, (String)object2, (Throwable)remoteException);
        }
    }

    public void playFromSearch(String string2, Bundle object) {
        Object object2 = this.mBinder;
        try {
            object2.playFromSearch(string2, (Bundle)object);
        }
        catch (RemoteException remoteException) {
            object = "MediaControllerCompat";
            object2 = "Dead object in playFromSearch.";
            Log.e((String)object, (String)object2, (Throwable)remoteException);
        }
    }

    public void playFromUri(Uri uri, Bundle object) {
        Object object2 = this.mBinder;
        try {
            object2.playFromUri(uri, (Bundle)object);
        }
        catch (RemoteException remoteException) {
            object = "MediaControllerCompat";
            object2 = "Dead object in playFromUri.";
            Log.e((String)object, (String)object2, (Throwable)remoteException);
        }
    }

    public void prepare() {
        IMediaSession iMediaSession = this.mBinder;
        try {
            iMediaSession.prepare();
        }
        catch (RemoteException remoteException) {
            String string2 = "MediaControllerCompat";
            String string3 = "Dead object in prepare.";
            Log.e((String)string2, (String)string3, (Throwable)remoteException);
        }
    }

    public void prepareFromMediaId(String string2, Bundle object) {
        Object object2 = this.mBinder;
        try {
            object2.prepareFromMediaId(string2, (Bundle)object);
        }
        catch (RemoteException remoteException) {
            object = "MediaControllerCompat";
            object2 = "Dead object in prepareFromMediaId.";
            Log.e((String)object, (String)object2, (Throwable)remoteException);
        }
    }

    public void prepareFromSearch(String string2, Bundle object) {
        Object object2 = this.mBinder;
        try {
            object2.prepareFromSearch(string2, (Bundle)object);
        }
        catch (RemoteException remoteException) {
            object = "MediaControllerCompat";
            object2 = "Dead object in prepareFromSearch.";
            Log.e((String)object, (String)object2, (Throwable)remoteException);
        }
    }

    public void prepareFromUri(Uri uri, Bundle object) {
        Object object2 = this.mBinder;
        try {
            object2.prepareFromUri(uri, (Bundle)object);
        }
        catch (RemoteException remoteException) {
            object = "MediaControllerCompat";
            object2 = "Dead object in prepareFromUri.";
            Log.e((String)object, (String)object2, (Throwable)remoteException);
        }
    }

    public void rewind() {
        IMediaSession iMediaSession = this.mBinder;
        try {
            iMediaSession.rewind();
        }
        catch (RemoteException remoteException) {
            String string2 = "MediaControllerCompat";
            String string3 = "Dead object in rewind.";
            Log.e((String)string2, (String)string3, (Throwable)remoteException);
        }
    }

    public void seekTo(long l10) {
        Object object = this.mBinder;
        try {
            object.seekTo(l10);
        }
        catch (RemoteException remoteException) {
            String string2 = "MediaControllerCompat";
            object = "Dead object in seekTo.";
            Log.e((String)string2, (String)object, (Throwable)remoteException);
        }
    }

    public void sendCustomAction(PlaybackStateCompat$CustomAction object, Bundle bundle) {
        object = ((PlaybackStateCompat$CustomAction)object).getAction();
        this.sendCustomAction((String)object, bundle);
    }

    public void sendCustomAction(String string2, Bundle object) {
        MediaControllerCompat.validateCustomAction(string2, object);
        Object object2 = this.mBinder;
        try {
            object2.sendCustomAction(string2, (Bundle)object);
        }
        catch (RemoteException remoteException) {
            object = "MediaControllerCompat";
            object2 = "Dead object in sendCustomAction.";
            Log.e((String)object, (String)object2, (Throwable)remoteException);
        }
    }

    public void setCaptioningEnabled(boolean bl2) {
        Object object = this.mBinder;
        try {
            object.setCaptioningEnabled(bl2);
        }
        catch (RemoteException remoteException) {
            object = "MediaControllerCompat";
            String string2 = "Dead object in setCaptioningEnabled.";
            Log.e((String)object, (String)string2, (Throwable)remoteException);
        }
    }

    public void setPlaybackSpeed(float f10) {
        Object object = null;
        float f11 = f10 - 0.0f;
        Object object2 = f11 == 0.0f ? 0 : (f11 > 0.0f ? 1 : -1);
        if (object2 != false) {
            object = this.mBinder;
            try {
                object.setPlaybackSpeed(f10);
            }
            catch (RemoteException remoteException) {
                object = "MediaControllerCompat";
                String string2 = "Dead object in setPlaybackSpeed.";
                Log.e((String)object, (String)string2, (Throwable)remoteException);
            }
            return;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("speed must not be zero");
        throw illegalArgumentException;
    }

    public void setRating(RatingCompat ratingCompat) {
        Object object = this.mBinder;
        try {
            object.rate(ratingCompat);
        }
        catch (RemoteException remoteException) {
            object = "MediaControllerCompat";
            String string2 = "Dead object in setRating.";
            Log.e((String)object, (String)string2, (Throwable)remoteException);
        }
    }

    public void setRating(RatingCompat ratingCompat, Bundle object) {
        Object object2 = this.mBinder;
        try {
            object2.rateWithExtras(ratingCompat, (Bundle)object);
        }
        catch (RemoteException remoteException) {
            object = "MediaControllerCompat";
            object2 = "Dead object in setRating.";
            Log.e((String)object, (String)object2, (Throwable)remoteException);
        }
    }

    public void setRepeatMode(int n10) {
        Object object = this.mBinder;
        try {
            object.setRepeatMode(n10);
        }
        catch (RemoteException remoteException) {
            object = "MediaControllerCompat";
            String string2 = "Dead object in setRepeatMode.";
            Log.e((String)object, (String)string2, (Throwable)remoteException);
        }
    }

    public void setShuffleMode(int n10) {
        Object object = this.mBinder;
        try {
            object.setShuffleMode(n10);
        }
        catch (RemoteException remoteException) {
            object = "MediaControllerCompat";
            String string2 = "Dead object in setShuffleMode.";
            Log.e((String)object, (String)string2, (Throwable)remoteException);
        }
    }

    public void skipToNext() {
        IMediaSession iMediaSession = this.mBinder;
        try {
            iMediaSession.next();
        }
        catch (RemoteException remoteException) {
            String string2 = "MediaControllerCompat";
            String string3 = "Dead object in skipToNext.";
            Log.e((String)string2, (String)string3, (Throwable)remoteException);
        }
    }

    public void skipToPrevious() {
        IMediaSession iMediaSession = this.mBinder;
        try {
            iMediaSession.previous();
        }
        catch (RemoteException remoteException) {
            String string2 = "MediaControllerCompat";
            String string3 = "Dead object in skipToPrevious.";
            Log.e((String)string2, (String)string3, (Throwable)remoteException);
        }
    }

    public void skipToQueueItem(long l10) {
        Object object = this.mBinder;
        try {
            object.skipToQueueItem(l10);
        }
        catch (RemoteException remoteException) {
            String string2 = "MediaControllerCompat";
            object = "Dead object in skipToQueueItem.";
            Log.e((String)string2, (String)object, (Throwable)remoteException);
        }
    }

    public void stop() {
        IMediaSession iMediaSession = this.mBinder;
        try {
            iMediaSession.stop();
        }
        catch (RemoteException remoteException) {
            String string2 = "MediaControllerCompat";
            String string3 = "Dead object in stop.";
            Log.e((String)string2, (String)string3, (Throwable)remoteException);
        }
    }
}

