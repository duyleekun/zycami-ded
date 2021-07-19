/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.PendingIntent
 *  android.content.Context
 *  android.media.session.MediaController
 *  android.media.session.MediaSession$Token
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.ResultReceiver
 *  android.text.TextUtils
 *  android.util.Log
 *  android.view.KeyEvent
 *  android.view.View
 */
package android.support.v4.media.session;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.media.session.MediaController;
import android.media.session.MediaSession;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaControllerCompat$Callback;
import android.support.v4.media.session.MediaControllerCompat$MediaControllerImpl;
import android.support.v4.media.session.MediaControllerCompat$MediaControllerImplApi21;
import android.support.v4.media.session.MediaControllerCompat$PlaybackInfo;
import android.support.v4.media.session.MediaControllerCompat$TransportControls;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.MediaSessionCompat$QueueItem;
import android.support.v4.media.session.MediaSessionCompat$Token;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import androidx.media.R$id;
import androidx.versionedparcelable.VersionedParcelable;
import java.io.Serializable;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public final class MediaControllerCompat {
    public static final String COMMAND_ADD_QUEUE_ITEM = "android.support.v4.media.session.command.ADD_QUEUE_ITEM";
    public static final String COMMAND_ADD_QUEUE_ITEM_AT = "android.support.v4.media.session.command.ADD_QUEUE_ITEM_AT";
    public static final String COMMAND_ARGUMENT_INDEX = "android.support.v4.media.session.command.ARGUMENT_INDEX";
    public static final String COMMAND_ARGUMENT_MEDIA_DESCRIPTION = "android.support.v4.media.session.command.ARGUMENT_MEDIA_DESCRIPTION";
    public static final String COMMAND_GET_EXTRA_BINDER = "android.support.v4.media.session.command.GET_EXTRA_BINDER";
    public static final String COMMAND_REMOVE_QUEUE_ITEM = "android.support.v4.media.session.command.REMOVE_QUEUE_ITEM";
    public static final String COMMAND_REMOVE_QUEUE_ITEM_AT = "android.support.v4.media.session.command.REMOVE_QUEUE_ITEM_AT";
    public static final String TAG = "MediaControllerCompat";
    private final MediaControllerCompat$MediaControllerImpl mImpl;
    private final ConcurrentHashMap mRegisteredCallbacks;
    private final MediaSessionCompat$Token mToken;

    public MediaControllerCompat(Context object, MediaSessionCompat$Token mediaSessionCompat$Token) {
        Object object2 = new ConcurrentHashMap();
        this.mRegisteredCallbacks = object2;
        if (mediaSessionCompat$Token != null) {
            this.mToken = mediaSessionCompat$Token;
            int n10 = Build.VERSION.SDK_INT;
            int n11 = 21;
            if (n10 >= n11) {
                this.mImpl = object2 = new MediaControllerCompat$MediaControllerImplApi21((Context)object, mediaSessionCompat$Token);
            } else {
                super(mediaSessionCompat$Token);
                this.mImpl = object;
            }
            return;
        }
        super("sessionToken must not be null");
        throw object;
    }

    public MediaControllerCompat(Context object, MediaSessionCompat object2) {
        Object object3 = new ConcurrentHashMap();
        this.mRegisteredCallbacks = object3;
        if (object2 != null) {
            this.mToken = object2 = ((MediaSessionCompat)object2).getSessionToken();
            int n10 = Build.VERSION.SDK_INT;
            int n11 = 21;
            if (n10 >= n11) {
                this.mImpl = object3 = new MediaControllerCompat$MediaControllerImplApi21((Context)object, (MediaSessionCompat$Token)object2);
            } else {
                super((MediaSessionCompat$Token)object2);
                this.mImpl = object;
            }
            return;
        }
        super("session must not be null");
        throw object;
    }

    public static MediaControllerCompat getMediaController(Activity activity) {
        Object object = activity.getWindow().getDecorView();
        int n10 = R$id.media_controller_compat_view_tag;
        if ((n10 = (object = object.getTag(n10)) instanceof MediaControllerCompat) != 0) {
            return (MediaControllerCompat)object;
        }
        int n11 = Build.VERSION.SDK_INT;
        n10 = 21;
        if (n11 >= n10) {
            object = activity.getMediaController();
            if (object == null) {
                return null;
            }
            object = object.getSessionToken();
            object = MediaSessionCompat$Token.fromToken(object);
            MediaControllerCompat mediaControllerCompat = new MediaControllerCompat((Context)activity, (MediaSessionCompat$Token)object);
            return mediaControllerCompat;
        }
        return null;
    }

    public static void setMediaController(Activity activity, MediaControllerCompat object) {
        View view = activity.getWindow().getDecorView();
        int n10 = R$id.media_controller_compat_view_tag;
        view.setTag(n10, object);
        int n11 = Build.VERSION.SDK_INT;
        n10 = 21;
        if (n11 >= n10) {
            n11 = 0;
            view = null;
            if (object != null) {
                object = ((MediaControllerCompat)object).getSessionToken().getToken();
                object = (MediaSession.Token)object;
                view = new MediaController((Context)activity, (MediaSession.Token)object);
            }
            activity.setMediaController((MediaController)view);
        }
    }

    public static void validateCustomAction(String string2, Bundle object) {
        boolean bl2;
        if (string2 == null) {
            return;
        }
        string2.hashCode();
        CharSequence charSequence = "android.support.v4.media.session.action.FOLLOW";
        boolean bl3 = string2.equals(charSequence);
        if (!bl3 && !(bl3 = string2.equals(charSequence = "android.support.v4.media.session.action.UNFOLLOW")) || object != null && (bl2 = object.containsKey((String)(charSequence = "android.support.v4.media.session.ARGUMENT_MEDIA_ATTRIBUTE")))) {
            return;
        }
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("An extra field android.support.v4.media.session.ARGUMENT_MEDIA_ATTRIBUTE is required for this action ");
        ((StringBuilder)charSequence).append(string2);
        ((StringBuilder)charSequence).append(".");
        string2 = ((StringBuilder)charSequence).toString();
        object = new IllegalArgumentException(string2);
        throw object;
    }

    public void addQueueItem(MediaDescriptionCompat mediaDescriptionCompat) {
        this.mImpl.addQueueItem(mediaDescriptionCompat);
    }

    public void addQueueItem(MediaDescriptionCompat mediaDescriptionCompat, int n10) {
        this.mImpl.addQueueItem(mediaDescriptionCompat, n10);
    }

    public void adjustVolume(int n10, int n11) {
        this.mImpl.adjustVolume(n10, n11);
    }

    public boolean dispatchMediaButtonEvent(KeyEvent object) {
        if (object != null) {
            return this.mImpl.dispatchMediaButtonEvent((KeyEvent)object);
        }
        object = new IllegalArgumentException("KeyEvent may not be null");
        throw object;
    }

    public Bundle getExtras() {
        return this.mImpl.getExtras();
    }

    public long getFlags() {
        return this.mImpl.getFlags();
    }

    public Object getMediaController() {
        return this.mImpl.getMediaController();
    }

    public MediaMetadataCompat getMetadata() {
        return this.mImpl.getMetadata();
    }

    public String getPackageName() {
        return this.mImpl.getPackageName();
    }

    public MediaControllerCompat$PlaybackInfo getPlaybackInfo() {
        return this.mImpl.getPlaybackInfo();
    }

    public PlaybackStateCompat getPlaybackState() {
        return this.mImpl.getPlaybackState();
    }

    public List getQueue() {
        return this.mImpl.getQueue();
    }

    public CharSequence getQueueTitle() {
        return this.mImpl.getQueueTitle();
    }

    public int getRatingType() {
        return this.mImpl.getRatingType();
    }

    public int getRepeatMode() {
        return this.mImpl.getRepeatMode();
    }

    public VersionedParcelable getSession2Token() {
        return this.mToken.getSession2Token();
    }

    public PendingIntent getSessionActivity() {
        return this.mImpl.getSessionActivity();
    }

    public Bundle getSessionInfo() {
        return this.mImpl.getSessionInfo();
    }

    public MediaSessionCompat$Token getSessionToken() {
        return this.mToken;
    }

    public int getShuffleMode() {
        return this.mImpl.getShuffleMode();
    }

    public MediaControllerCompat$TransportControls getTransportControls() {
        return this.mImpl.getTransportControls();
    }

    public boolean isCaptioningEnabled() {
        return this.mImpl.isCaptioningEnabled();
    }

    public boolean isSessionReady() {
        return this.mImpl.isSessionReady();
    }

    public void registerCallback(MediaControllerCompat$Callback mediaControllerCompat$Callback) {
        this.registerCallback(mediaControllerCompat$Callback, null);
    }

    public void registerCallback(MediaControllerCompat$Callback object, Handler handler) {
        if (object != null) {
            Serializable serializable = this.mRegisteredCallbacks;
            Boolean bl2 = Boolean.TRUE;
            if ((serializable = serializable.putIfAbsent(object, bl2)) != null) {
                Log.w((String)TAG, (String)"the callback has already been registered");
                return;
            }
            if (handler == null) {
                handler = new Handler();
            }
            ((MediaControllerCompat$Callback)object).setHandler(handler);
            this.mImpl.registerCallback((MediaControllerCompat$Callback)object, handler);
            return;
        }
        object = new IllegalArgumentException("callback must not be null");
        throw object;
    }

    public void removeQueueItem(MediaDescriptionCompat mediaDescriptionCompat) {
        this.mImpl.removeQueueItem(mediaDescriptionCompat);
    }

    public void removeQueueItemAt(int n10) {
        Object object;
        int n11;
        List list = this.getQueue();
        if (list != null && n10 >= 0 && n10 < (n11 = list.size()) && (object = (MediaSessionCompat$QueueItem)list.get(n10)) != null) {
            object = object.getDescription();
            this.removeQueueItem((MediaDescriptionCompat)object);
        }
    }

    public void sendCommand(String object, Bundle bundle, ResultReceiver resultReceiver) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        if (!bl2) {
            this.mImpl.sendCommand((String)object, bundle, resultReceiver);
            return;
        }
        object = new IllegalArgumentException("command must neither be null nor empty");
        throw object;
    }

    public void setVolumeTo(int n10, int n11) {
        this.mImpl.setVolumeTo(n10, n11);
    }

    public void unregisterCallback(MediaControllerCompat$Callback object) {
        if (object != null) {
            Object v10 = this.mRegisteredCallbacks.remove(object);
            if (v10 == null) {
                Log.w((String)TAG, (String)"the callback has never been registered");
                return;
            }
            v10 = null;
            try {
                MediaControllerCompat$MediaControllerImpl mediaControllerCompat$MediaControllerImpl = this.mImpl;
                mediaControllerCompat$MediaControllerImpl.unregisterCallback((MediaControllerCompat$Callback)object);
                return;
            }
            finally {
                ((MediaControllerCompat$Callback)object).setHandler(null);
            }
        }
        object = new IllegalArgumentException("callback must not be null");
        throw object;
    }
}

