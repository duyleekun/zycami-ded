/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.Looper
 *  android.os.Message
 */
package android.support.v4.media.session;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaControllerCompat$Callback;
import android.support.v4.media.session.MediaControllerCompat$PlaybackInfo;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.PlaybackStateCompat;
import java.util.List;

public class MediaControllerCompat$Callback$MessageHandler
extends Handler {
    private static final int MSG_DESTROYED = 8;
    private static final int MSG_EVENT = 1;
    private static final int MSG_SESSION_READY = 13;
    private static final int MSG_UPDATE_CAPTIONING_ENABLED = 11;
    private static final int MSG_UPDATE_EXTRAS = 7;
    private static final int MSG_UPDATE_METADATA = 3;
    private static final int MSG_UPDATE_PLAYBACK_STATE = 2;
    private static final int MSG_UPDATE_QUEUE = 5;
    private static final int MSG_UPDATE_QUEUE_TITLE = 6;
    private static final int MSG_UPDATE_REPEAT_MODE = 9;
    private static final int MSG_UPDATE_SHUFFLE_MODE = 12;
    private static final int MSG_UPDATE_VOLUME = 4;
    public boolean mRegistered;
    public final /* synthetic */ MediaControllerCompat$Callback this$0;

    public MediaControllerCompat$Callback$MessageHandler(MediaControllerCompat$Callback mediaControllerCompat$Callback, Looper looper) {
        this.this$0 = mediaControllerCompat$Callback;
        super(looper);
        this.mRegistered = false;
    }

    public void handleMessage(Message object) {
        int n10 = this.mRegistered;
        if (n10 == 0) {
            return;
        }
        n10 = ((Message)object).what;
        switch (n10) {
            default: {
                break;
            }
            case 13: {
                object = this.this$0;
                ((MediaControllerCompat$Callback)object).onSessionReady();
                break;
            }
            case 12: {
                MediaControllerCompat$Callback mediaControllerCompat$Callback = this.this$0;
                object = (Integer)((Message)object).obj;
                int n11 = (Integer)object;
                mediaControllerCompat$Callback.onShuffleModeChanged(n11);
                break;
            }
            case 11: {
                MediaControllerCompat$Callback mediaControllerCompat$Callback = this.this$0;
                object = (Boolean)((Message)object).obj;
                boolean bl2 = (Boolean)object;
                mediaControllerCompat$Callback.onCaptioningEnabledChanged(bl2);
                break;
            }
            case 9: {
                MediaControllerCompat$Callback mediaControllerCompat$Callback = this.this$0;
                object = (Integer)((Message)object).obj;
                int n12 = (Integer)object;
                mediaControllerCompat$Callback.onRepeatModeChanged(n12);
                break;
            }
            case 8: {
                object = this.this$0;
                ((MediaControllerCompat$Callback)object).onSessionDestroyed();
                break;
            }
            case 7: {
                object = (Bundle)((Message)object).obj;
                MediaSessionCompat.ensureClassLoader((Bundle)object);
                MediaControllerCompat$Callback mediaControllerCompat$Callback = this.this$0;
                mediaControllerCompat$Callback.onExtrasChanged((Bundle)object);
                break;
            }
            case 6: {
                MediaControllerCompat$Callback mediaControllerCompat$Callback = this.this$0;
                object = (CharSequence)((Message)object).obj;
                mediaControllerCompat$Callback.onQueueTitleChanged((CharSequence)object);
                break;
            }
            case 5: {
                MediaControllerCompat$Callback mediaControllerCompat$Callback = this.this$0;
                object = (List)((Message)object).obj;
                mediaControllerCompat$Callback.onQueueChanged((List)object);
                break;
            }
            case 4: {
                MediaControllerCompat$Callback mediaControllerCompat$Callback = this.this$0;
                object = (MediaControllerCompat$PlaybackInfo)((Message)object).obj;
                mediaControllerCompat$Callback.onAudioInfoChanged((MediaControllerCompat$PlaybackInfo)object);
                break;
            }
            case 3: {
                MediaControllerCompat$Callback mediaControllerCompat$Callback = this.this$0;
                object = (MediaMetadataCompat)((Message)object).obj;
                mediaControllerCompat$Callback.onMetadataChanged((MediaMetadataCompat)object);
                break;
            }
            case 2: {
                MediaControllerCompat$Callback mediaControllerCompat$Callback = this.this$0;
                object = (PlaybackStateCompat)((Message)object).obj;
                mediaControllerCompat$Callback.onPlaybackStateChanged((PlaybackStateCompat)object);
                break;
            }
            case 1: {
                Bundle bundle = object.getData();
                MediaSessionCompat.ensureClassLoader(bundle);
                MediaControllerCompat$Callback mediaControllerCompat$Callback = this.this$0;
                object = (String)((Message)object).obj;
                mediaControllerCompat$Callback.onSessionEvent((String)object, bundle);
            }
        }
    }
}

