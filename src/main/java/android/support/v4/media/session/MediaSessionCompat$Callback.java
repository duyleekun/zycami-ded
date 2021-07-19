/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Intent
 *  android.media.session.MediaSession$Callback
 *  android.net.Uri
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.Looper
 *  android.os.Message
 *  android.os.ResultReceiver
 *  android.view.KeyEvent
 *  android.view.ViewConfiguration
 */
package android.support.v4.media.session;

import android.content.Intent;
import android.media.session.MediaSession;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.ResultReceiver;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.RatingCompat;
import android.support.v4.media.session.MediaSessionCompat$Callback$CallbackHandler;
import android.support.v4.media.session.MediaSessionCompat$Callback$MediaSessionCallbackApi21;
import android.support.v4.media.session.MediaSessionCompat$MediaSessionImpl;
import android.support.v4.media.session.PlaybackStateCompat;
import android.view.KeyEvent;
import android.view.ViewConfiguration;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

public abstract class MediaSessionCompat$Callback {
    public final MediaSession.Callback mCallbackFwk;
    public MediaSessionCompat$Callback$CallbackHandler mCallbackHandler;
    public final Object mLock;
    private boolean mMediaPlayPausePendingOnHandler;
    public WeakReference mSessionImpl;

    public MediaSessionCompat$Callback() {
        Object object;
        this.mLock = object = new Object();
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        if (n10 >= n11) {
            object = new MediaSessionCompat$Callback$MediaSessionCallbackApi21(this);
            this.mCallbackFwk = object;
        } else {
            this.mCallbackFwk = null;
        }
        object = new WeakReference(null);
        this.mSessionImpl = object;
    }

    public void handleMediaPlayPauseIfPendingOnHandler(MediaSessionCompat$MediaSessionImpl object, Handler handler) {
        int n10;
        int n11;
        int n12 = this.mMediaPlayPausePendingOnHandler;
        if (n12 == 0) {
            return;
        }
        n12 = 0;
        this.mMediaPlayPausePendingOnHandler = false;
        int n13 = 1;
        handler.removeMessages(n13);
        object = object.getPlaybackState();
        long l10 = 0L;
        long l11 = object == null ? l10 : ((PlaybackStateCompat)object).getActions();
        if (object != null && (n11 = ((PlaybackStateCompat)object).getState()) == (n10 = 3)) {
            n11 = n13;
        } else {
            n11 = 0;
            object = null;
        }
        long l12 = 0x204L & l11;
        n10 = l12 == l10 ? 0 : (l12 < l10 ? -1 : 1);
        if (n10 != 0) {
            n10 = n13;
        } else {
            n10 = 0;
            handler = null;
        }
        l12 = 514L;
        long l13 = (l11 &= l12) - l10;
        long l14 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (l14 != false) {
            n12 = n13;
        }
        if (n11 != 0 && n12 != 0) {
            this.onPause();
        } else if (n11 == 0 && n10 != 0) {
            this.onPlay();
        }
    }

    public void onAddQueueItem(MediaDescriptionCompat mediaDescriptionCompat) {
    }

    public void onAddQueueItem(MediaDescriptionCompat mediaDescriptionCompat, int n10) {
    }

    public void onCommand(String string2, Bundle bundle, ResultReceiver resultReceiver) {
    }

    public void onCustomAction(String string2, Bundle bundle) {
    }

    public void onFastForward() {
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean onMediaButtonEvent(Intent object) {
        int n10;
        MediaSessionCompat$Callback$CallbackHandler mediaSessionCompat$Callback$CallbackHandler;
        Object object2;
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 27;
        if (n11 >= n12) {
            return false;
        }
        Object object3 = this.mLock;
        synchronized (object3) {
            object2 = this.mSessionImpl;
            object2 = ((Reference)object2).get();
            object2 = (MediaSessionCompat$MediaSessionImpl)object2;
            mediaSessionCompat$Callback$CallbackHandler = this.mCallbackHandler;
        }
        if (object2 == null) return false;
        if (mediaSessionCompat$Callback$CallbackHandler == null) {
            return false;
        }
        object3 = "android.intent.extra.KEY_EVENT";
        if ((object = (KeyEvent)object.getParcelableExtra((String)object3)) == null) return false;
        n11 = object.getAction();
        if (n11 != 0) {
            return false;
        }
        object3 = object2.getCurrentControllerInfo();
        int n13 = object.getKeyCode();
        if (n13 != (n10 = 79) && n13 != (n10 = 85)) {
            this.handleMediaPlayPauseIfPendingOnHandler((MediaSessionCompat$MediaSessionImpl)object2, mediaSessionCompat$Callback$CallbackHandler);
            return false;
        }
        int n14 = object.getRepeatCount();
        n13 = 1;
        if (n14 != 0) {
            this.handleMediaPlayPauseIfPendingOnHandler((MediaSessionCompat$MediaSessionImpl)object2, mediaSessionCompat$Callback$CallbackHandler);
            return n13 != 0;
        }
        n14 = this.mMediaPlayPausePendingOnHandler ? 1 : 0;
        if (n14 == 0) {
            this.mMediaPlayPausePendingOnHandler = n13;
            object = mediaSessionCompat$Callback$CallbackHandler.obtainMessage(n13, object3);
            n11 = ViewConfiguration.getDoubleTapTimeout();
            long l10 = n11;
            mediaSessionCompat$Callback$CallbackHandler.sendMessageDelayed((Message)object, l10);
            return n13 != 0;
        }
        mediaSessionCompat$Callback$CallbackHandler.removeMessages(n13);
        this.mMediaPlayPausePendingOnHandler = false;
        object = object2.getPlaybackState();
        long l11 = 0L;
        long l12 = object == null ? l11 : ((PlaybackStateCompat)object).getActions();
        long l13 = 32;
        long l14 = (l12 &= l13) - l11;
        n14 = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
        if (n14 == 0) return n13 != 0;
        this.onSkipToNext();
        return n13 != 0;
    }

    public void onPause() {
    }

    public void onPlay() {
    }

    public void onPlayFromMediaId(String string2, Bundle bundle) {
    }

    public void onPlayFromSearch(String string2, Bundle bundle) {
    }

    public void onPlayFromUri(Uri uri, Bundle bundle) {
    }

    public void onPrepare() {
    }

    public void onPrepareFromMediaId(String string2, Bundle bundle) {
    }

    public void onPrepareFromSearch(String string2, Bundle bundle) {
    }

    public void onPrepareFromUri(Uri uri, Bundle bundle) {
    }

    public void onRemoveQueueItem(MediaDescriptionCompat mediaDescriptionCompat) {
    }

    public void onRemoveQueueItemAt(int n10) {
    }

    public void onRewind() {
    }

    public void onSeekTo(long l10) {
    }

    public void onSetCaptioningEnabled(boolean bl2) {
    }

    public void onSetPlaybackSpeed(float f10) {
    }

    public void onSetRating(RatingCompat ratingCompat) {
    }

    public void onSetRating(RatingCompat ratingCompat, Bundle bundle) {
    }

    public void onSetRepeatMode(int n10) {
    }

    public void onSetShuffleMode(int n10) {
    }

    public void onSkipToNext() {
    }

    public void onSkipToPrevious() {
    }

    public void onSkipToQueueItem(long l10) {
    }

    public void onStop() {
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void setSessionImpl(MediaSessionCompat$MediaSessionImpl mediaSessionCompat$MediaSessionImpl, Handler handler) {
        Object object = this.mLock;
        synchronized (object) {
            Object object2;
            this.mSessionImpl = object2 = new Object(mediaSessionCompat$MediaSessionImpl);
            object2 = this.mCallbackHandler;
            MediaSessionCompat$Callback$CallbackHandler mediaSessionCompat$Callback$CallbackHandler = null;
            if (object2 != null) {
                object2.removeCallbacksAndMessages(null);
            }
            if (mediaSessionCompat$MediaSessionImpl != null && handler != null) {
                mediaSessionCompat$MediaSessionImpl = handler.getLooper();
                mediaSessionCompat$Callback$CallbackHandler = new MediaSessionCompat$Callback$CallbackHandler(this, (Looper)mediaSessionCompat$MediaSessionImpl);
            }
            this.mCallbackHandler = mediaSessionCompat$Callback$CallbackHandler;
            return;
        }
    }
}

