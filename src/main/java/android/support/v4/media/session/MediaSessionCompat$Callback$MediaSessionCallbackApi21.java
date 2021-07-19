/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Intent
 *  android.media.Rating
 *  android.media.session.MediaSession$Callback
 *  android.net.Uri
 *  android.os.BadParcelableException
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.IBinder
 *  android.os.Parcelable
 *  android.os.ResultReceiver
 *  android.text.TextUtils
 *  android.util.Log
 */
package android.support.v4.media.session;

import android.content.Intent;
import android.media.Rating;
import android.media.session.MediaSession;
import android.net.Uri;
import android.os.BadParcelableException;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.os.ResultReceiver;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.RatingCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.MediaSessionCompat$Callback;
import android.support.v4.media.session.MediaSessionCompat$MediaSessionImpl;
import android.support.v4.media.session.MediaSessionCompat$MediaSessionImplApi21;
import android.support.v4.media.session.MediaSessionCompat$QueueItem;
import android.support.v4.media.session.MediaSessionCompat$Token;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.app.BundleCompat;
import androidx.media.MediaSessionManager$RemoteUserInfo;
import androidx.versionedparcelable.ParcelUtils;
import androidx.versionedparcelable.VersionedParcelable;
import java.lang.ref.Reference;

public class MediaSessionCompat$Callback$MediaSessionCallbackApi21
extends MediaSession.Callback {
    public final /* synthetic */ MediaSessionCompat$Callback this$0;

    public MediaSessionCompat$Callback$MediaSessionCallbackApi21(MediaSessionCompat$Callback mediaSessionCompat$Callback) {
        this.this$0 = mediaSessionCompat$Callback;
    }

    private void clearCurrentControllerInfo(MediaSessionCompat$MediaSessionImpl mediaSessionCompat$MediaSessionImpl) {
        mediaSessionCompat$MediaSessionImpl.setCurrentControllerInfo(null);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private MediaSessionCompat$MediaSessionImplApi21 getSessionImplIfCallbackIsSet() {
        Object object;
        Object object2 = this.this$0.mLock;
        synchronized (object2) {
            object = this.this$0;
            object = ((MediaSessionCompat$Callback)object).mSessionImpl;
            object = ((Reference)object).get();
            object = (MediaSessionCompat$MediaSessionImplApi21)object;
        }
        object2 = this.this$0;
        MediaSessionCompat$Callback mediaSessionCompat$Callback = ((MediaSessionCompat$MediaSessionImplApi21)object).getCallback();
        if (object2 != mediaSessionCompat$Callback) return null;
        return object;
    }

    private void setCurrentControllerInfo(MediaSessionCompat$MediaSessionImpl mediaSessionCompat$MediaSessionImpl) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 28;
        if (n10 >= n11) {
            return;
        }
        String string2 = mediaSessionCompat$MediaSessionImpl.getCallingPackage();
        n11 = TextUtils.isEmpty((CharSequence)string2) ? 1 : 0;
        if (n11 != 0) {
            string2 = "android.media.session.MediaController";
        }
        int n12 = -1;
        MediaSessionManager$RemoteUserInfo mediaSessionManager$RemoteUserInfo = new MediaSessionManager$RemoteUserInfo(string2, n12, n12);
        mediaSessionCompat$MediaSessionImpl.setCurrentControllerInfo(mediaSessionManager$RemoteUserInfo);
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onCommand(String object, Bundle object2, ResultReceiver object3) {
        MediaSessionCompat$MediaSessionImplApi21 mediaSessionCompat$MediaSessionImplApi21;
        block11: {
            mediaSessionCompat$MediaSessionImplApi21 = this.getSessionImplIfCallbackIsSet();
            if (mediaSessionCompat$MediaSessionImplApi21 == null) {
                return;
            }
            MediaSessionCompat.ensureClassLoader((Bundle)object2);
            this.setCurrentControllerInfo(mediaSessionCompat$MediaSessionImplApi21);
            Object object4 = "android.support.v4.media.session.command.GET_EXTRA_BINDER";
            try {
                boolean bl2 = ((String)object).equals(object4);
                Object var7_9 = null;
                if (bl2) {
                    void var7_11;
                    object = new Bundle();
                    object2 = mediaSessionCompat$MediaSessionImplApi21.getSessionToken();
                    object4 = ((MediaSessionCompat$Token)object2).getExtraBinder();
                    String string2 = "android.support.v4.media.session.EXTRA_BINDER";
                    if (object4 != null) {
                        IBinder iBinder = object4.asBinder();
                    }
                    BundleCompat.putBinder((Bundle)object, string2, (IBinder)var7_11);
                    object4 = "android.support.v4.media.session.SESSION_TOKEN2";
                    object2 = ((MediaSessionCompat$Token)object2).getSession2Token();
                    ParcelUtils.putVersionedParcelable((Bundle)object, (String)object4, (VersionedParcelable)object2);
                    boolean bl3 = false;
                    object2 = null;
                    object3.send(0, (Bundle)object);
                    break block11;
                }
                object4 = "android.support.v4.media.session.command.ADD_QUEUE_ITEM";
                bl2 = ((String)object).equals(object4);
                String string3 = "android.support.v4.media.session.command.ARGUMENT_MEDIA_DESCRIPTION";
                if (bl2) {
                    object = this.this$0;
                    object2 = object2.getParcelable(string3);
                    object2 = (MediaDescriptionCompat)object2;
                    ((MediaSessionCompat$Callback)object).onAddQueueItem((MediaDescriptionCompat)object2);
                    break block11;
                }
                object4 = "android.support.v4.media.session.command.ADD_QUEUE_ITEM_AT";
                bl2 = ((String)object).equals(object4);
                String string4 = "android.support.v4.media.session.command.ARGUMENT_INDEX";
                if (bl2) {
                    object = this.this$0;
                    Parcelable parcelable = object2.getParcelable(string3);
                    MediaDescriptionCompat mediaDescriptionCompat = (MediaDescriptionCompat)parcelable;
                    int n10 = object2.getInt(string4);
                    ((MediaSessionCompat$Callback)object).onAddQueueItem(mediaDescriptionCompat, n10);
                    break block11;
                }
                object4 = "android.support.v4.media.session.command.REMOVE_QUEUE_ITEM";
                bl2 = ((String)object).equals(object4);
                if (bl2) {
                    object = this.this$0;
                    object2 = object2.getParcelable(string3);
                    object2 = (MediaDescriptionCompat)object2;
                    ((MediaSessionCompat$Callback)object).onRemoveQueueItem((MediaDescriptionCompat)object2);
                    break block11;
                }
                object4 = "android.support.v4.media.session.command.REMOVE_QUEUE_ITEM_AT";
                bl2 = ((String)object).equals(object4);
                if (bl2) {
                    void var7_14;
                    int n11;
                    object = mediaSessionCompat$MediaSessionImplApi21.mQueue;
                    if (object == null) break block11;
                    int n12 = -1;
                    if ((n12 = object2.getInt(string4, n12)) >= 0 && n12 < (n11 = (object2 = mediaSessionCompat$MediaSessionImplApi21.mQueue).size())) {
                        object2 = mediaSessionCompat$MediaSessionImplApi21.mQueue;
                        Object object5 = object = object2.get(n12);
                        MediaSessionCompat$QueueItem mediaSessionCompat$QueueItem = (MediaSessionCompat$QueueItem)object;
                    }
                    if (var7_14 != null) {
                        object = this.this$0;
                        object2 = var7_14.getDescription();
                        ((MediaSessionCompat$Callback)object).onRemoveQueueItem((MediaDescriptionCompat)object2);
                    }
                    break block11;
                }
                object4 = this.this$0;
                ((MediaSessionCompat$Callback)object4).onCommand((String)object, (Bundle)object2, (ResultReceiver)object3);
            }
            catch (BadParcelableException badParcelableException) {
                object = "MediaSessionCompat";
                object2 = "Could not unparcel the extra data.";
                Log.e((String)object, (String)object2);
            }
        }
        this.clearCurrentControllerInfo(mediaSessionCompat$MediaSessionImplApi21);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onCustomAction(String object, Bundle object2) {
        MediaSessionCompat$MediaSessionImplApi21 mediaSessionCompat$MediaSessionImplApi21;
        block14: {
            mediaSessionCompat$MediaSessionImplApi21 = this.getSessionImplIfCallbackIsSet();
            if (mediaSessionCompat$MediaSessionImplApi21 == null) {
                return;
            }
            MediaSessionCompat.ensureClassLoader((Bundle)object2);
            this.setCurrentControllerInfo(mediaSessionCompat$MediaSessionImplApi21);
            Object object3 = "android.support.v4.media.session.action.PLAY_FROM_URI";
            try {
                int n10 = ((String)object).equals(object3);
                String string2 = "android.support.v4.media.session.action.ARGUMENT_URI";
                String string3 = "android.support.v4.media.session.action.ARGUMENT_EXTRAS";
                if (n10 != 0) {
                    object = object2.getParcelable(string2);
                    object = (Uri)object;
                    object2 = object2.getBundle(string3);
                    MediaSessionCompat.ensureClassLoader((Bundle)object2);
                    object3 = this.this$0;
                    ((MediaSessionCompat$Callback)object3).onPlayFromUri((Uri)object, (Bundle)object2);
                    break block14;
                }
                object3 = "android.support.v4.media.session.action.PREPARE";
                n10 = ((String)object).equals(object3);
                if (n10 != 0) {
                    object = this.this$0;
                    ((MediaSessionCompat$Callback)object).onPrepare();
                    break block14;
                }
                object3 = "android.support.v4.media.session.action.PREPARE_FROM_MEDIA_ID";
                n10 = ((String)object).equals(object3);
                if (n10 != 0) {
                    object = "android.support.v4.media.session.action.ARGUMENT_MEDIA_ID";
                    object = object2.getString((String)object);
                    object2 = object2.getBundle(string3);
                    MediaSessionCompat.ensureClassLoader((Bundle)object2);
                    object3 = this.this$0;
                    ((MediaSessionCompat$Callback)object3).onPrepareFromMediaId((String)object, (Bundle)object2);
                    break block14;
                }
                object3 = "android.support.v4.media.session.action.PREPARE_FROM_SEARCH";
                n10 = ((String)object).equals(object3);
                if (n10 != 0) {
                    object = "android.support.v4.media.session.action.ARGUMENT_QUERY";
                    object = object2.getString((String)object);
                    object2 = object2.getBundle(string3);
                    MediaSessionCompat.ensureClassLoader((Bundle)object2);
                    object3 = this.this$0;
                    ((MediaSessionCompat$Callback)object3).onPrepareFromSearch((String)object, (Bundle)object2);
                    break block14;
                }
                object3 = "android.support.v4.media.session.action.PREPARE_FROM_URI";
                n10 = ((String)object).equals(object3);
                if (n10 != 0) {
                    object = object2.getParcelable(string2);
                    object = (Uri)object;
                    object2 = object2.getBundle(string3);
                    MediaSessionCompat.ensureClassLoader((Bundle)object2);
                    object3 = this.this$0;
                    ((MediaSessionCompat$Callback)object3).onPrepareFromUri((Uri)object, (Bundle)object2);
                    break block14;
                }
                object3 = "android.support.v4.media.session.action.SET_CAPTIONING_ENABLED";
                n10 = ((String)object).equals(object3);
                if (n10 != 0) {
                    object = "android.support.v4.media.session.action.ARGUMENT_CAPTIONING_ENABLED";
                    boolean bl2 = object2.getBoolean((String)object);
                    object2 = this.this$0;
                    ((MediaSessionCompat$Callback)object2).onSetCaptioningEnabled(bl2);
                    break block14;
                }
                object3 = "android.support.v4.media.session.action.SET_REPEAT_MODE";
                n10 = ((String)object).equals(object3);
                if (n10 != 0) {
                    object = "android.support.v4.media.session.action.ARGUMENT_REPEAT_MODE";
                    int n11 = object2.getInt((String)object);
                    object2 = this.this$0;
                    ((MediaSessionCompat$Callback)object2).onSetRepeatMode(n11);
                    break block14;
                }
                object3 = "android.support.v4.media.session.action.SET_SHUFFLE_MODE";
                n10 = ((String)object).equals(object3);
                if (n10 != 0) {
                    object = "android.support.v4.media.session.action.ARGUMENT_SHUFFLE_MODE";
                    int n12 = object2.getInt((String)object);
                    object2 = this.this$0;
                    ((MediaSessionCompat$Callback)object2).onSetShuffleMode(n12);
                    break block14;
                }
                object3 = "android.support.v4.media.session.action.SET_RATING";
                n10 = ((String)object).equals(object3);
                if (n10 != 0) {
                    object = "android.support.v4.media.session.action.ARGUMENT_RATING";
                    object = object2.getParcelable((String)object);
                    object = (RatingCompat)object;
                    object2 = object2.getBundle(string3);
                    MediaSessionCompat.ensureClassLoader((Bundle)object2);
                    object3 = this.this$0;
                    ((MediaSessionCompat$Callback)object3).onSetRating((RatingCompat)object, (Bundle)object2);
                    break block14;
                }
                object3 = "android.support.v4.media.session.action.SET_PLAYBACK_SPEED";
                n10 = ((String)object).equals(object3);
                if (n10 != 0) {
                    object = "android.support.v4.media.session.action.ARGUMENT_PLAYBACK_SPEED";
                    n10 = 1065353216;
                    float f10 = 1.0f;
                    float f11 = object2.getFloat((String)object, f10);
                    object2 = this.this$0;
                    ((MediaSessionCompat$Callback)object2).onSetPlaybackSpeed(f11);
                } else {
                    object3 = this.this$0;
                    ((MediaSessionCompat$Callback)object3).onCustomAction((String)object, (Bundle)object2);
                }
            }
            catch (BadParcelableException badParcelableException) {
                object = "MediaSessionCompat";
                object2 = "Could not unparcel the data.";
                Log.e((String)object, (String)object2);
            }
        }
        this.clearCurrentControllerInfo(mediaSessionCompat$MediaSessionImplApi21);
    }

    public void onFastForward() {
        MediaSessionCompat$MediaSessionImplApi21 mediaSessionCompat$MediaSessionImplApi21 = this.getSessionImplIfCallbackIsSet();
        if (mediaSessionCompat$MediaSessionImplApi21 == null) {
            return;
        }
        this.setCurrentControllerInfo(mediaSessionCompat$MediaSessionImplApi21);
        this.this$0.onFastForward();
        this.clearCurrentControllerInfo(mediaSessionCompat$MediaSessionImplApi21);
    }

    public boolean onMediaButtonEvent(Intent intent) {
        boolean bl2;
        MediaSessionCompat$MediaSessionImplApi21 mediaSessionCompat$MediaSessionImplApi21 = this.getSessionImplIfCallbackIsSet();
        boolean bl3 = false;
        if (mediaSessionCompat$MediaSessionImplApi21 == null) {
            return false;
        }
        this.setCurrentControllerInfo(mediaSessionCompat$MediaSessionImplApi21);
        MediaSessionCompat$Callback mediaSessionCompat$Callback = this.this$0;
        boolean bl4 = mediaSessionCompat$Callback.onMediaButtonEvent(intent);
        this.clearCurrentControllerInfo(mediaSessionCompat$MediaSessionImplApi21);
        if (bl4 || (bl2 = super.onMediaButtonEvent(intent))) {
            bl3 = true;
        }
        return bl3;
    }

    public void onPause() {
        MediaSessionCompat$MediaSessionImplApi21 mediaSessionCompat$MediaSessionImplApi21 = this.getSessionImplIfCallbackIsSet();
        if (mediaSessionCompat$MediaSessionImplApi21 == null) {
            return;
        }
        this.setCurrentControllerInfo(mediaSessionCompat$MediaSessionImplApi21);
        this.this$0.onPause();
        this.clearCurrentControllerInfo(mediaSessionCompat$MediaSessionImplApi21);
    }

    public void onPlay() {
        MediaSessionCompat$MediaSessionImplApi21 mediaSessionCompat$MediaSessionImplApi21 = this.getSessionImplIfCallbackIsSet();
        if (mediaSessionCompat$MediaSessionImplApi21 == null) {
            return;
        }
        this.setCurrentControllerInfo(mediaSessionCompat$MediaSessionImplApi21);
        this.this$0.onPlay();
        this.clearCurrentControllerInfo(mediaSessionCompat$MediaSessionImplApi21);
    }

    public void onPlayFromMediaId(String string2, Bundle bundle) {
        MediaSessionCompat$MediaSessionImplApi21 mediaSessionCompat$MediaSessionImplApi21 = this.getSessionImplIfCallbackIsSet();
        if (mediaSessionCompat$MediaSessionImplApi21 == null) {
            return;
        }
        MediaSessionCompat.ensureClassLoader(bundle);
        this.setCurrentControllerInfo(mediaSessionCompat$MediaSessionImplApi21);
        this.this$0.onPlayFromMediaId(string2, bundle);
        this.clearCurrentControllerInfo(mediaSessionCompat$MediaSessionImplApi21);
    }

    public void onPlayFromSearch(String string2, Bundle bundle) {
        MediaSessionCompat$MediaSessionImplApi21 mediaSessionCompat$MediaSessionImplApi21 = this.getSessionImplIfCallbackIsSet();
        if (mediaSessionCompat$MediaSessionImplApi21 == null) {
            return;
        }
        MediaSessionCompat.ensureClassLoader(bundle);
        this.setCurrentControllerInfo(mediaSessionCompat$MediaSessionImplApi21);
        this.this$0.onPlayFromSearch(string2, bundle);
        this.clearCurrentControllerInfo(mediaSessionCompat$MediaSessionImplApi21);
    }

    public void onPlayFromUri(Uri uri, Bundle bundle) {
        MediaSessionCompat$MediaSessionImplApi21 mediaSessionCompat$MediaSessionImplApi21 = this.getSessionImplIfCallbackIsSet();
        if (mediaSessionCompat$MediaSessionImplApi21 == null) {
            return;
        }
        MediaSessionCompat.ensureClassLoader(bundle);
        this.setCurrentControllerInfo(mediaSessionCompat$MediaSessionImplApi21);
        this.this$0.onPlayFromUri(uri, bundle);
        this.clearCurrentControllerInfo(mediaSessionCompat$MediaSessionImplApi21);
    }

    public void onPrepare() {
        MediaSessionCompat$MediaSessionImplApi21 mediaSessionCompat$MediaSessionImplApi21 = this.getSessionImplIfCallbackIsSet();
        if (mediaSessionCompat$MediaSessionImplApi21 == null) {
            return;
        }
        this.setCurrentControllerInfo(mediaSessionCompat$MediaSessionImplApi21);
        this.this$0.onPrepare();
        this.clearCurrentControllerInfo(mediaSessionCompat$MediaSessionImplApi21);
    }

    public void onPrepareFromMediaId(String string2, Bundle bundle) {
        MediaSessionCompat$MediaSessionImplApi21 mediaSessionCompat$MediaSessionImplApi21 = this.getSessionImplIfCallbackIsSet();
        if (mediaSessionCompat$MediaSessionImplApi21 == null) {
            return;
        }
        MediaSessionCompat.ensureClassLoader(bundle);
        this.setCurrentControllerInfo(mediaSessionCompat$MediaSessionImplApi21);
        this.this$0.onPrepareFromMediaId(string2, bundle);
        this.clearCurrentControllerInfo(mediaSessionCompat$MediaSessionImplApi21);
    }

    public void onPrepareFromSearch(String string2, Bundle bundle) {
        MediaSessionCompat$MediaSessionImplApi21 mediaSessionCompat$MediaSessionImplApi21 = this.getSessionImplIfCallbackIsSet();
        if (mediaSessionCompat$MediaSessionImplApi21 == null) {
            return;
        }
        MediaSessionCompat.ensureClassLoader(bundle);
        this.setCurrentControllerInfo(mediaSessionCompat$MediaSessionImplApi21);
        this.this$0.onPrepareFromSearch(string2, bundle);
        this.clearCurrentControllerInfo(mediaSessionCompat$MediaSessionImplApi21);
    }

    public void onPrepareFromUri(Uri uri, Bundle bundle) {
        MediaSessionCompat$MediaSessionImplApi21 mediaSessionCompat$MediaSessionImplApi21 = this.getSessionImplIfCallbackIsSet();
        if (mediaSessionCompat$MediaSessionImplApi21 == null) {
            return;
        }
        MediaSessionCompat.ensureClassLoader(bundle);
        this.setCurrentControllerInfo(mediaSessionCompat$MediaSessionImplApi21);
        this.this$0.onPrepareFromUri(uri, bundle);
        this.clearCurrentControllerInfo(mediaSessionCompat$MediaSessionImplApi21);
    }

    public void onRewind() {
        MediaSessionCompat$MediaSessionImplApi21 mediaSessionCompat$MediaSessionImplApi21 = this.getSessionImplIfCallbackIsSet();
        if (mediaSessionCompat$MediaSessionImplApi21 == null) {
            return;
        }
        this.setCurrentControllerInfo(mediaSessionCompat$MediaSessionImplApi21);
        this.this$0.onRewind();
        this.clearCurrentControllerInfo(mediaSessionCompat$MediaSessionImplApi21);
    }

    public void onSeekTo(long l10) {
        MediaSessionCompat$MediaSessionImplApi21 mediaSessionCompat$MediaSessionImplApi21 = this.getSessionImplIfCallbackIsSet();
        if (mediaSessionCompat$MediaSessionImplApi21 == null) {
            return;
        }
        this.setCurrentControllerInfo(mediaSessionCompat$MediaSessionImplApi21);
        this.this$0.onSeekTo(l10);
        this.clearCurrentControllerInfo(mediaSessionCompat$MediaSessionImplApi21);
    }

    public void onSetPlaybackSpeed(float f10) {
        MediaSessionCompat$MediaSessionImplApi21 mediaSessionCompat$MediaSessionImplApi21 = this.getSessionImplIfCallbackIsSet();
        if (mediaSessionCompat$MediaSessionImplApi21 == null) {
            return;
        }
        this.setCurrentControllerInfo(mediaSessionCompat$MediaSessionImplApi21);
        this.this$0.onSetPlaybackSpeed(f10);
        this.clearCurrentControllerInfo(mediaSessionCompat$MediaSessionImplApi21);
    }

    public void onSetRating(Rating object) {
        MediaSessionCompat$MediaSessionImplApi21 mediaSessionCompat$MediaSessionImplApi21 = this.getSessionImplIfCallbackIsSet();
        if (mediaSessionCompat$MediaSessionImplApi21 == null) {
            return;
        }
        this.setCurrentControllerInfo(mediaSessionCompat$MediaSessionImplApi21);
        MediaSessionCompat$Callback mediaSessionCompat$Callback = this.this$0;
        object = RatingCompat.fromRating(object);
        mediaSessionCompat$Callback.onSetRating((RatingCompat)object);
        this.clearCurrentControllerInfo(mediaSessionCompat$MediaSessionImplApi21);
    }

    public void onSetRating(Rating rating, Bundle bundle) {
    }

    public void onSkipToNext() {
        MediaSessionCompat$MediaSessionImplApi21 mediaSessionCompat$MediaSessionImplApi21 = this.getSessionImplIfCallbackIsSet();
        if (mediaSessionCompat$MediaSessionImplApi21 == null) {
            return;
        }
        this.setCurrentControllerInfo(mediaSessionCompat$MediaSessionImplApi21);
        this.this$0.onSkipToNext();
        this.clearCurrentControllerInfo(mediaSessionCompat$MediaSessionImplApi21);
    }

    public void onSkipToPrevious() {
        MediaSessionCompat$MediaSessionImplApi21 mediaSessionCompat$MediaSessionImplApi21 = this.getSessionImplIfCallbackIsSet();
        if (mediaSessionCompat$MediaSessionImplApi21 == null) {
            return;
        }
        this.setCurrentControllerInfo(mediaSessionCompat$MediaSessionImplApi21);
        this.this$0.onSkipToPrevious();
        this.clearCurrentControllerInfo(mediaSessionCompat$MediaSessionImplApi21);
    }

    public void onSkipToQueueItem(long l10) {
        MediaSessionCompat$MediaSessionImplApi21 mediaSessionCompat$MediaSessionImplApi21 = this.getSessionImplIfCallbackIsSet();
        if (mediaSessionCompat$MediaSessionImplApi21 == null) {
            return;
        }
        this.setCurrentControllerInfo(mediaSessionCompat$MediaSessionImplApi21);
        this.this$0.onSkipToQueueItem(l10);
        this.clearCurrentControllerInfo(mediaSessionCompat$MediaSessionImplApi21);
    }

    public void onStop() {
        MediaSessionCompat$MediaSessionImplApi21 mediaSessionCompat$MediaSessionImplApi21 = this.getSessionImplIfCallbackIsSet();
        if (mediaSessionCompat$MediaSessionImplApi21 == null) {
            return;
        }
        this.setCurrentControllerInfo(mediaSessionCompat$MediaSessionImplApi21);
        this.this$0.onStop();
        this.clearCurrentControllerInfo(mediaSessionCompat$MediaSessionImplApi21);
    }
}

