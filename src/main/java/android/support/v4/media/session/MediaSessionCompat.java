/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.PendingIntent
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.Intent
 *  android.media.session.MediaSession
 *  android.os.BadParcelableException
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.Looper
 *  android.os.SystemClock
 *  android.text.TextUtils
 *  android.util.DisplayMetrics
 *  android.util.Log
 *  android.util.TypedValue
 */
package android.support.v4.media.session;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.media.session.MediaSession;
import android.os.BadParcelableException;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaControllerCompat;
import android.support.v4.media.session.MediaSessionCompat$Callback;
import android.support.v4.media.session.MediaSessionCompat$MediaSessionImpl;
import android.support.v4.media.session.MediaSessionCompat$MediaSessionImplApi21;
import android.support.v4.media.session.MediaSessionCompat$MediaSessionImplApi28;
import android.support.v4.media.session.MediaSessionCompat$MediaSessionImplApi29;
import android.support.v4.media.session.MediaSessionCompat$OnActiveChangeListener;
import android.support.v4.media.session.MediaSessionCompat$QueueItem;
import android.support.v4.media.session.MediaSessionCompat$Token;
import android.support.v4.media.session.PlaybackStateCompat;
import android.support.v4.media.session.PlaybackStateCompat$Builder;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import androidx.media.MediaSessionManager$RemoteUserInfo;
import androidx.media.VolumeProviderCompat;
import androidx.media.session.MediaButtonReceiver;
import androidx.versionedparcelable.VersionedParcelable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class MediaSessionCompat {
    public static final String ACTION_ARGUMENT_CAPTIONING_ENABLED = "android.support.v4.media.session.action.ARGUMENT_CAPTIONING_ENABLED";
    public static final String ACTION_ARGUMENT_EXTRAS = "android.support.v4.media.session.action.ARGUMENT_EXTRAS";
    public static final String ACTION_ARGUMENT_MEDIA_ID = "android.support.v4.media.session.action.ARGUMENT_MEDIA_ID";
    public static final String ACTION_ARGUMENT_PLAYBACK_SPEED = "android.support.v4.media.session.action.ARGUMENT_PLAYBACK_SPEED";
    public static final String ACTION_ARGUMENT_QUERY = "android.support.v4.media.session.action.ARGUMENT_QUERY";
    public static final String ACTION_ARGUMENT_RATING = "android.support.v4.media.session.action.ARGUMENT_RATING";
    public static final String ACTION_ARGUMENT_REPEAT_MODE = "android.support.v4.media.session.action.ARGUMENT_REPEAT_MODE";
    public static final String ACTION_ARGUMENT_SHUFFLE_MODE = "android.support.v4.media.session.action.ARGUMENT_SHUFFLE_MODE";
    public static final String ACTION_ARGUMENT_URI = "android.support.v4.media.session.action.ARGUMENT_URI";
    public static final String ACTION_FLAG_AS_INAPPROPRIATE = "android.support.v4.media.session.action.FLAG_AS_INAPPROPRIATE";
    public static final String ACTION_FOLLOW = "android.support.v4.media.session.action.FOLLOW";
    public static final String ACTION_PLAY_FROM_URI = "android.support.v4.media.session.action.PLAY_FROM_URI";
    public static final String ACTION_PREPARE = "android.support.v4.media.session.action.PREPARE";
    public static final String ACTION_PREPARE_FROM_MEDIA_ID = "android.support.v4.media.session.action.PREPARE_FROM_MEDIA_ID";
    public static final String ACTION_PREPARE_FROM_SEARCH = "android.support.v4.media.session.action.PREPARE_FROM_SEARCH";
    public static final String ACTION_PREPARE_FROM_URI = "android.support.v4.media.session.action.PREPARE_FROM_URI";
    public static final String ACTION_SET_CAPTIONING_ENABLED = "android.support.v4.media.session.action.SET_CAPTIONING_ENABLED";
    public static final String ACTION_SET_PLAYBACK_SPEED = "android.support.v4.media.session.action.SET_PLAYBACK_SPEED";
    public static final String ACTION_SET_RATING = "android.support.v4.media.session.action.SET_RATING";
    public static final String ACTION_SET_REPEAT_MODE = "android.support.v4.media.session.action.SET_REPEAT_MODE";
    public static final String ACTION_SET_SHUFFLE_MODE = "android.support.v4.media.session.action.SET_SHUFFLE_MODE";
    public static final String ACTION_SKIP_AD = "android.support.v4.media.session.action.SKIP_AD";
    public static final String ACTION_UNFOLLOW = "android.support.v4.media.session.action.UNFOLLOW";
    public static final String ARGUMENT_MEDIA_ATTRIBUTE = "android.support.v4.media.session.ARGUMENT_MEDIA_ATTRIBUTE";
    public static final String ARGUMENT_MEDIA_ATTRIBUTE_VALUE = "android.support.v4.media.session.ARGUMENT_MEDIA_ATTRIBUTE_VALUE";
    private static final String DATA_CALLING_PACKAGE = "data_calling_pkg";
    private static final String DATA_CALLING_PID = "data_calling_pid";
    private static final String DATA_CALLING_UID = "data_calling_uid";
    private static final String DATA_EXTRAS = "data_extras";
    public static final int FLAG_HANDLES_MEDIA_BUTTONS = 1;
    public static final int FLAG_HANDLES_QUEUE_COMMANDS = 4;
    public static final int FLAG_HANDLES_TRANSPORT_CONTROLS = 2;
    public static final String KEY_EXTRA_BINDER = "android.support.v4.media.session.EXTRA_BINDER";
    public static final String KEY_SESSION2_TOKEN = "android.support.v4.media.session.SESSION_TOKEN2";
    public static final String KEY_TOKEN = "android.support.v4.media.session.TOKEN";
    private static final int MAX_BITMAP_SIZE_IN_DP = 320;
    public static final int MEDIA_ATTRIBUTE_ALBUM = 1;
    public static final int MEDIA_ATTRIBUTE_ARTIST = 0;
    public static final int MEDIA_ATTRIBUTE_PLAYLIST = 2;
    public static final String TAG = "MediaSessionCompat";
    public static int sMaxBitmapSize;
    private final ArrayList mActiveListeners;
    private final MediaControllerCompat mController;
    private final MediaSessionCompat$MediaSessionImpl mImpl;

    private MediaSessionCompat(Context context, MediaSessionCompat$MediaSessionImpl object) {
        ArrayList arrayList;
        this.mActiveListeners = arrayList = new ArrayList();
        this.mImpl = object;
        this.mController = object = new MediaControllerCompat(context, this);
    }

    public MediaSessionCompat(Context context, String string2) {
        this(context, string2, null, null);
    }

    public MediaSessionCompat(Context context, String string2, ComponentName componentName, PendingIntent pendingIntent) {
        this(context, string2, componentName, pendingIntent, null);
    }

    public MediaSessionCompat(Context context, String string2, ComponentName componentName, PendingIntent pendingIntent, Bundle bundle) {
        this(context, string2, componentName, pendingIntent, bundle, null);
    }

    public MediaSessionCompat(Context object, String object2, ComponentName object3, PendingIntent pendingIntent, Bundle bundle, VersionedParcelable versionedParcelable) {
        Object object4 = new ArrayList();
        this.mActiveListeners = object4;
        if (object != null) {
            boolean bl2 = TextUtils.isEmpty((CharSequence)object2);
            if (!bl2) {
                int n10;
                if (object3 == null && (object3 = MediaButtonReceiver.getMediaButtonReceiverComponent(object)) == null) {
                    object4 = TAG;
                    String string2 = "Couldn't find a unique registered media button receiver in the given context.";
                    Log.w((String)object4, (String)string2);
                }
                ComponentName componentName = object3;
                if (object3 != null && pendingIntent == null) {
                    super("android.intent.action.MEDIA_BUTTON");
                    object3.setComponent(componentName);
                    n10 = 0;
                    pendingIntent = PendingIntent.getBroadcast((Context)object, (int)0, (Intent)object3, (int)0);
                }
                PendingIntent pendingIntent2 = pendingIntent;
                int n11 = Build.VERSION.SDK_INT;
                n10 = 21;
                if (n11 >= n10) {
                    object2 = this.createFwkMediaSession((Context)object, (String)object2, bundle);
                    n10 = 29;
                    if (n11 >= n10) {
                        super((MediaSession)object2, versionedParcelable, bundle);
                        this.mImpl = object3;
                    } else {
                        n10 = 28;
                        if (n11 >= n10) {
                            super((MediaSession)object2, versionedParcelable, bundle);
                            this.mImpl = object3;
                        } else {
                            super((MediaSession)object2, versionedParcelable, bundle);
                            this.mImpl = object3;
                        }
                    }
                    object3 = Looper.myLooper();
                    object3 = object3 != null ? Looper.myLooper() : Looper.getMainLooper();
                    object2 = new Handler((Looper)object3);
                    super(this);
                    this.setCallback((MediaSessionCompat$Callback)object3, (Handler)object2);
                    object2 = this.mImpl;
                    object2.setMediaButtonReceiver(pendingIntent2);
                } else {
                    n10 = 19;
                    if (n11 >= n10) {
                        super((Context)object, (String)object2, componentName, pendingIntent, versionedParcelable, bundle);
                        this.mImpl = object3;
                    } else {
                        n10 = 18;
                        if (n11 >= n10) {
                            super((Context)object, (String)object2, componentName, pendingIntent, versionedParcelable, bundle);
                            this.mImpl = object3;
                        } else {
                            super((Context)object, (String)object2, componentName, pendingIntent, versionedParcelable, bundle);
                            this.mImpl = object3;
                        }
                    }
                }
                this.mController = object2 = new MediaControllerCompat((Context)object, this);
                int n12 = sMaxBitmapSize;
                if (n12 == 0) {
                    int n13;
                    n11 = 1134559232;
                    float f10 = 320.0f;
                    object = object.getResources().getDisplayMetrics();
                    float f11 = TypedValue.applyDimension((int)1, (float)f10, (DisplayMetrics)object);
                    n12 = 0x3F000000;
                    float f12 = 0.5f;
                    sMaxBitmapSize = n13 = (int)(f11 += f12);
                }
                return;
            }
            super("tag must not be null or empty");
            throw object;
        }
        super("context must not be null");
        throw object;
    }

    private MediaSession createFwkMediaSession(Context context, String string2, Bundle bundle) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 29;
        if (n10 >= n11) {
            MediaSession mediaSession = new MediaSession(context, string2, bundle);
            return mediaSession;
        }
        bundle = new MediaSession(context, string2);
        return bundle;
    }

    public static void ensureClassLoader(Bundle bundle) {
        if (bundle != null) {
            ClassLoader classLoader = MediaSessionCompat.class.getClassLoader();
            bundle.setClassLoader(classLoader);
        }
    }

    public static MediaSessionCompat fromMediaSession(Context context, Object object) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        if (n10 >= n11 && context != null && object != null) {
            n11 = 29;
            MediaSessionCompat$MediaSessionImplApi21 mediaSessionCompat$MediaSessionImplApi21 = n10 >= n11 ? new MediaSessionCompat$MediaSessionImplApi29(object) : (n10 >= (n11 = 28) ? new MediaSessionCompat$MediaSessionImplApi28(object) : new MediaSessionCompat$MediaSessionImplApi21(object));
            object = new MediaSessionCompat(context, mediaSessionCompat$MediaSessionImplApi21);
            return object;
        }
        return null;
    }

    public static PlaybackStateCompat getStateWithUpdatedPosition(PlaybackStateCompat playbackStateCompat, MediaMetadataCompat mediaMetadataCompat) {
        long l10;
        long l11;
        long l12;
        int n10;
        long l13;
        long l14;
        long l15;
        long l16;
        if (playbackStateCompat != null && (l16 = (l15 = (l14 = playbackStateCompat.getPosition()) - (l13 = (long)-1)) == 0L ? 0 : (l15 < 0L ? -1 : 1)) != false && ((l16 = (long)playbackStateCompat.getState()) == (n10 = 3) || (l16 = (long)playbackStateCompat.getState()) == (n10 = 4) || (l16 = (long)playbackStateCompat.getState()) == (n10 = 5)) && (l12 = (l11 = (l14 = playbackStateCompat.getLastPositionUpdateTime()) - (l10 = 0L)) == 0L ? 0 : (l11 < 0L ? -1 : 1)) > 0) {
            long l17;
            String string2;
            boolean bl2;
            long l18 = SystemClock.elapsedRealtime();
            float f10 = playbackStateCompat.getPlaybackSpeed();
            float f11 = l18 - l14;
            l14 = (long)(f10 *= f11);
            long l19 = playbackStateCompat.getPosition();
            l14 += l19;
            if (mediaMetadataCompat != null && (bl2 = mediaMetadataCompat.containsKey(string2 = "android.media.metadata.DURATION"))) {
                l13 = mediaMetadataCompat.getLong(string2);
            }
            long l20 = (l17 = l13 == l10 ? 0 : (l13 < l10 ? -1 : 1)) >= 0 && (l17 = l14 == l13 ? 0 : (l14 < l13 ? -1 : 1)) > 0 ? l13 : ((l17 = l14 == l10 ? 0 : (l14 < l10 ? -1 : 1)) < 0 ? l10 : l14);
            PlaybackStateCompat$Builder playbackStateCompat$Builder = new PlaybackStateCompat$Builder(playbackStateCompat);
            int n11 = playbackStateCompat.getState();
            float f12 = playbackStateCompat.getPlaybackSpeed();
            playbackStateCompat = playbackStateCompat$Builder.setState(n11, l20, f12, l18).build();
        }
        return playbackStateCompat;
    }

    public static Bundle unparcelWithClassLoader(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        MediaSessionCompat.ensureClassLoader(bundle);
        try {
            bundle.isEmpty();
            return bundle;
        }
        catch (BadParcelableException badParcelableException) {
            Log.e((String)TAG, (String)"Could not unparcel the data.");
            return null;
        }
    }

    public void addOnActiveChangeListener(MediaSessionCompat$OnActiveChangeListener object) {
        if (object != null) {
            this.mActiveListeners.add(object);
            return;
        }
        object = new IllegalArgumentException("Listener may not be null");
        throw object;
    }

    public String getCallingPackage() {
        return this.mImpl.getCallingPackage();
    }

    public MediaControllerCompat getController() {
        return this.mController;
    }

    public final MediaSessionManager$RemoteUserInfo getCurrentControllerInfo() {
        return this.mImpl.getCurrentControllerInfo();
    }

    public Object getMediaSession() {
        return this.mImpl.getMediaSession();
    }

    public Object getRemoteControlClient() {
        return this.mImpl.getRemoteControlClient();
    }

    public MediaSessionCompat$Token getSessionToken() {
        return this.mImpl.getSessionToken();
    }

    public boolean isActive() {
        return this.mImpl.isActive();
    }

    public void release() {
        this.mImpl.release();
    }

    public void removeOnActiveChangeListener(MediaSessionCompat$OnActiveChangeListener object) {
        if (object != null) {
            this.mActiveListeners.remove(object);
            return;
        }
        object = new IllegalArgumentException("Listener may not be null");
        throw object;
    }

    public void sendSessionEvent(String object, Bundle bundle) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        if (!bl2) {
            this.mImpl.sendSessionEvent((String)object, bundle);
            return;
        }
        object = new IllegalArgumentException("event cannot be null or empty");
        throw object;
    }

    public void setActive(boolean bl2) {
        boolean bl3;
        Object object = this.mImpl;
        object.setActive(bl2);
        Iterator iterator2 = this.mActiveListeners.iterator();
        while (bl3 = iterator2.hasNext()) {
            object = (MediaSessionCompat$OnActiveChangeListener)iterator2.next();
            object.onActiveChanged();
        }
    }

    public void setCallback(MediaSessionCompat$Callback mediaSessionCompat$Callback) {
        this.setCallback(mediaSessionCompat$Callback, null);
    }

    public void setCallback(MediaSessionCompat$Callback object, Handler handler) {
        if (object == null) {
            object = this.mImpl;
            handler = null;
            object.setCallback(null, null);
        } else {
            MediaSessionCompat$MediaSessionImpl mediaSessionCompat$MediaSessionImpl = this.mImpl;
            if (handler == null) {
                handler = new Handler();
            }
            mediaSessionCompat$MediaSessionImpl.setCallback((MediaSessionCompat$Callback)object, handler);
        }
    }

    public void setCaptioningEnabled(boolean bl2) {
        this.mImpl.setCaptioningEnabled(bl2);
    }

    public void setExtras(Bundle bundle) {
        this.mImpl.setExtras(bundle);
    }

    public void setFlags(int n10) {
        this.mImpl.setFlags(n10);
    }

    public void setMediaButtonReceiver(PendingIntent pendingIntent) {
        this.mImpl.setMediaButtonReceiver(pendingIntent);
    }

    public void setMetadata(MediaMetadataCompat mediaMetadataCompat) {
        this.mImpl.setMetadata(mediaMetadataCompat);
    }

    public void setPlaybackState(PlaybackStateCompat playbackStateCompat) {
        this.mImpl.setPlaybackState(playbackStateCompat);
    }

    public void setPlaybackToLocal(int n10) {
        this.mImpl.setPlaybackToLocal(n10);
    }

    public void setPlaybackToRemote(VolumeProviderCompat object) {
        if (object != null) {
            this.mImpl.setPlaybackToRemote((VolumeProviderCompat)object);
            return;
        }
        object = new IllegalArgumentException("volumeProvider may not be null!");
        throw object;
    }

    public void setQueue(List object) {
        if (object != null) {
            boolean bl2;
            HashSet<Object> hashSet = new HashSet<Object>();
            Iterator iterator2 = object.iterator();
            while (bl2 = iterator2.hasNext()) {
                Object object2 = (MediaSessionCompat$QueueItem)iterator2.next();
                if (object2 != null) {
                    long l10 = ((MediaSessionCompat$QueueItem)object2).getQueueId();
                    Object object3 = l10;
                    boolean bl3 = hashSet.contains(object3);
                    if (bl3) {
                        object3 = new StringBuilder();
                        ((StringBuilder)object3).append("Found duplicate queue id: ");
                        long l11 = ((MediaSessionCompat$QueueItem)object2).getQueueId();
                        ((StringBuilder)object3).append(l11);
                        object3 = ((StringBuilder)object3).toString();
                        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("id of each queue item should be unique");
                        String string2 = TAG;
                        Log.e((String)string2, (String)object3, (Throwable)illegalArgumentException);
                    }
                    long l12 = ((MediaSessionCompat$QueueItem)object2).getQueueId();
                    object2 = l12;
                    hashSet.add(object2);
                    continue;
                }
                object = new IllegalArgumentException("queue shouldn't have null items");
                throw object;
            }
        }
        this.mImpl.setQueue((List)object);
    }

    public void setQueueTitle(CharSequence charSequence) {
        this.mImpl.setQueueTitle(charSequence);
    }

    public void setRatingType(int n10) {
        this.mImpl.setRatingType(n10);
    }

    public void setRepeatMode(int n10) {
        this.mImpl.setRepeatMode(n10);
    }

    public void setSessionActivity(PendingIntent pendingIntent) {
        this.mImpl.setSessionActivity(pendingIntent);
    }

    public void setShuffleMode(int n10) {
        this.mImpl.setShuffleMode(n10);
    }
}

