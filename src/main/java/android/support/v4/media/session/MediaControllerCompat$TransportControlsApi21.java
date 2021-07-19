/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.Rating
 *  android.media.session.MediaController$TransportControls
 *  android.net.Uri
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.Parcelable
 */
package android.support.v4.media.session;

import android.media.Rating;
import android.media.session.MediaController;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.media.RatingCompat;
import android.support.v4.media.session.MediaControllerCompat;
import android.support.v4.media.session.MediaControllerCompat$TransportControls;
import android.support.v4.media.session.PlaybackStateCompat$CustomAction;

public class MediaControllerCompat$TransportControlsApi21
extends MediaControllerCompat$TransportControls {
    public final MediaController.TransportControls mControlsFwk;

    public MediaControllerCompat$TransportControlsApi21(MediaController.TransportControls transportControls) {
        this.mControlsFwk = transportControls;
    }

    public void fastForward() {
        this.mControlsFwk.fastForward();
    }

    public void pause() {
        this.mControlsFwk.pause();
    }

    public void play() {
        this.mControlsFwk.play();
    }

    public void playFromMediaId(String string2, Bundle bundle) {
        this.mControlsFwk.playFromMediaId(string2, bundle);
    }

    public void playFromSearch(String string2, Bundle bundle) {
        this.mControlsFwk.playFromSearch(string2, bundle);
    }

    public void playFromUri(Uri object, Bundle bundle) {
        Uri uri;
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 23;
        if (n10 >= n11) {
            this.mControlsFwk.playFromUri(object, bundle);
            return;
        }
        if (object != null && (n10 = (int)((uri = Uri.EMPTY).equals(object) ? 1 : 0)) == 0) {
            uri = new Bundle();
            uri.putParcelable("android.support.v4.media.session.action.ARGUMENT_URI", (Parcelable)object);
            uri.putBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS", bundle);
            this.sendCustomAction("android.support.v4.media.session.action.PLAY_FROM_URI", (Bundle)uri);
            return;
        }
        object = new IllegalArgumentException("You must specify a non-empty Uri for playFromUri.");
        throw object;
    }

    public void prepare() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 24;
        if (n10 >= n11) {
            this.mControlsFwk.prepare();
            return;
        }
        this.sendCustomAction("android.support.v4.media.session.action.PREPARE", null);
    }

    public void prepareFromMediaId(String string2, Bundle bundle) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 24;
        if (n10 >= n11) {
            this.mControlsFwk.prepareFromMediaId(string2, bundle);
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putString("android.support.v4.media.session.action.ARGUMENT_MEDIA_ID", string2);
        bundle2.putBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS", bundle);
        this.sendCustomAction("android.support.v4.media.session.action.PREPARE_FROM_MEDIA_ID", bundle2);
    }

    public void prepareFromSearch(String string2, Bundle bundle) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 24;
        if (n10 >= n11) {
            this.mControlsFwk.prepareFromSearch(string2, bundle);
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putString("android.support.v4.media.session.action.ARGUMENT_QUERY", string2);
        bundle2.putBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS", bundle);
        this.sendCustomAction("android.support.v4.media.session.action.PREPARE_FROM_SEARCH", bundle2);
    }

    public void prepareFromUri(Uri uri, Bundle bundle) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 24;
        if (n10 >= n11) {
            this.mControlsFwk.prepareFromUri(uri, bundle);
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putParcelable("android.support.v4.media.session.action.ARGUMENT_URI", (Parcelable)uri);
        bundle2.putBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS", bundle);
        this.sendCustomAction("android.support.v4.media.session.action.PREPARE_FROM_URI", bundle2);
    }

    public void rewind() {
        this.mControlsFwk.rewind();
    }

    public void seekTo(long l10) {
        this.mControlsFwk.seekTo(l10);
    }

    public void sendCustomAction(PlaybackStateCompat$CustomAction object, Bundle bundle) {
        MediaControllerCompat.validateCustomAction(((PlaybackStateCompat$CustomAction)object).getAction(), bundle);
        MediaController.TransportControls transportControls = this.mControlsFwk;
        object = ((PlaybackStateCompat$CustomAction)object).getAction();
        transportControls.sendCustomAction((String)object, bundle);
    }

    public void sendCustomAction(String string2, Bundle bundle) {
        MediaControllerCompat.validateCustomAction(string2, bundle);
        this.mControlsFwk.sendCustomAction(string2, bundle);
    }

    public void setCaptioningEnabled(boolean bl2) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("android.support.v4.media.session.action.ARGUMENT_CAPTIONING_ENABLED", bl2);
        this.sendCustomAction("android.support.v4.media.session.action.SET_CAPTIONING_ENABLED", bundle);
    }

    public void setPlaybackSpeed(float f10) {
        Bundle bundle = null;
        float f11 = f10 - 0.0f;
        Object object = f11 == 0.0f ? 0 : (f11 > 0.0f ? 1 : -1);
        if (object != false) {
            object = Build.VERSION.SDK_INT;
            int n10 = 29;
            if (object >= n10) {
                this.mControlsFwk.setPlaybackSpeed(f10);
                return;
            }
            bundle = new Bundle();
            bundle.putFloat("android.support.v4.media.session.action.ARGUMENT_PLAYBACK_SPEED", f10);
            this.sendCustomAction("android.support.v4.media.session.action.SET_PLAYBACK_SPEED", bundle);
            return;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("speed must not be zero");
        throw illegalArgumentException;
    }

    public void setRating(RatingCompat ratingCompat) {
        MediaController.TransportControls transportControls = this.mControlsFwk;
        ratingCompat = ratingCompat != null ? (Rating)ratingCompat.getRating() : null;
        transportControls.setRating((Rating)ratingCompat);
    }

    public void setRating(RatingCompat ratingCompat, Bundle bundle) {
        Bundle bundle2 = new Bundle();
        bundle2.putParcelable("android.support.v4.media.session.action.ARGUMENT_RATING", (Parcelable)ratingCompat);
        bundle2.putBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS", bundle);
        this.sendCustomAction("android.support.v4.media.session.action.SET_RATING", bundle2);
    }

    public void setRepeatMode(int n10) {
        Bundle bundle = new Bundle();
        bundle.putInt("android.support.v4.media.session.action.ARGUMENT_REPEAT_MODE", n10);
        this.sendCustomAction("android.support.v4.media.session.action.SET_REPEAT_MODE", bundle);
    }

    public void setShuffleMode(int n10) {
        Bundle bundle = new Bundle();
        bundle.putInt("android.support.v4.media.session.action.ARGUMENT_SHUFFLE_MODE", n10);
        this.sendCustomAction("android.support.v4.media.session.action.SET_SHUFFLE_MODE", bundle);
    }

    public void skipToNext() {
        this.mControlsFwk.skipToNext();
    }

    public void skipToPrevious() {
        this.mControlsFwk.skipToPrevious();
    }

    public void skipToQueueItem(long l10) {
        this.mControlsFwk.skipToQueueItem(l10);
    }

    public void stop() {
        this.mControlsFwk.stop();
    }
}

