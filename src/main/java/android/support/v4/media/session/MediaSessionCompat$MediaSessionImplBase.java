/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.PendingIntent
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.pm.PackageManager
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  android.media.AudioManager
 *  android.media.RemoteControlClient
 *  android.media.RemoteControlClient$MetadataEditor
 *  android.os.Binder
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.Looper
 *  android.os.Message
 *  android.os.RemoteCallbackList
 *  android.os.RemoteException
 *  android.text.TextUtils
 */
package android.support.v4.media.session;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.media.AudioManager;
import android.media.RemoteControlClient;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.MediaMetadataCompat$Builder;
import android.support.v4.media.session.IMediaControllerCallback;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.MediaSessionCompat$Callback;
import android.support.v4.media.session.MediaSessionCompat$MediaSessionImpl;
import android.support.v4.media.session.MediaSessionCompat$MediaSessionImplBase$1;
import android.support.v4.media.session.MediaSessionCompat$MediaSessionImplBase$MediaSessionStub;
import android.support.v4.media.session.MediaSessionCompat$MediaSessionImplBase$MessageHandler;
import android.support.v4.media.session.MediaSessionCompat$Token;
import android.support.v4.media.session.ParcelableVolumeInfo;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import androidx.media.MediaSessionManager$RemoteUserInfo;
import androidx.media.VolumeProviderCompat;
import androidx.media.VolumeProviderCompat$Callback;
import androidx.versionedparcelable.VersionedParcelable;
import java.util.List;

public class MediaSessionCompat$MediaSessionImplBase
implements MediaSessionCompat$MediaSessionImpl {
    public static final int RCC_PLAYSTATE_NONE;
    public final AudioManager mAudioManager;
    public volatile MediaSessionCompat$Callback mCallback;
    public boolean mCaptioningEnabled;
    private final Context mContext;
    public final RemoteCallbackList mControllerCallbacks;
    public boolean mDestroyed;
    public Bundle mExtras;
    public int mFlags;
    private MediaSessionCompat$MediaSessionImplBase$MessageHandler mHandler;
    public boolean mIsActive;
    public int mLocalStream;
    public final Object mLock;
    private final ComponentName mMediaButtonReceiverComponentName;
    private final PendingIntent mMediaButtonReceiverIntent;
    public MediaMetadataCompat mMetadata;
    public final String mPackageName;
    public List mQueue;
    public CharSequence mQueueTitle;
    public int mRatingType;
    public final RemoteControlClient mRcc;
    private MediaSessionManager$RemoteUserInfo mRemoteUserInfo;
    public int mRepeatMode;
    public PendingIntent mSessionActivity;
    public final Bundle mSessionInfo;
    public int mShuffleMode;
    public PlaybackStateCompat mState;
    private final MediaSessionCompat$MediaSessionImplBase$MediaSessionStub mStub;
    public final String mTag;
    private final MediaSessionCompat$Token mToken;
    private VolumeProviderCompat$Callback mVolumeCallback;
    public VolumeProviderCompat mVolumeProvider;
    public int mVolumeType;

    public MediaSessionCompat$MediaSessionImplBase(Context object, String object2, ComponentName componentName, PendingIntent pendingIntent, VersionedParcelable versionedParcelable, Bundle bundle) {
        int n10;
        Object object3;
        this.mLock = object3 = new Object();
        object3 = new RemoteCallbackList();
        this.mControllerCallbacks = object3;
        object3 = null;
        this.mDestroyed = false;
        this.mIsActive = false;
        this.mFlags = n10 = 3;
        Object object4 = new MediaSessionCompat$MediaSessionImplBase$1(this);
        this.mVolumeCallback = object4;
        if (componentName != null) {
            this.mContext = object;
            this.mPackageName = object4 = object.getPackageName();
            this.mSessionInfo = bundle;
            object = (AudioManager)object.getSystemService("audio");
            this.mAudioManager = object;
            this.mTag = object2;
            this.mMediaButtonReceiverComponentName = componentName;
            this.mMediaButtonReceiverIntent = pendingIntent;
            super(this);
            this.mStub = object;
            this.mToken = object2 = new MediaSessionCompat$Token(object, null, versionedParcelable);
            this.mRatingType = 0;
            this.mVolumeType = 1;
            this.mLocalStream = n10;
            super(pendingIntent);
            this.mRcc = object;
            return;
        }
        super("MediaButtonReceiver component may not be null");
        throw object;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void sendCaptioningEnabled(boolean bl2) {
        RemoteCallbackList remoteCallbackList = this.mControllerCallbacks;
        int n10 = remoteCallbackList.beginBroadcast() + -1;
        while (true) {
            if (n10 < 0) {
                this.mControllerCallbacks.finishBroadcast();
                return;
            }
            IMediaControllerCallback iMediaControllerCallback = (IMediaControllerCallback)this.mControllerCallbacks.getBroadcastItem(n10);
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
    private void sendEvent(String string2, Bundle bundle) {
        RemoteCallbackList remoteCallbackList = this.mControllerCallbacks;
        int n10 = remoteCallbackList.beginBroadcast() + -1;
        while (true) {
            if (n10 < 0) {
                this.mControllerCallbacks.finishBroadcast();
                return;
            }
            IMediaControllerCallback iMediaControllerCallback = (IMediaControllerCallback)this.mControllerCallbacks.getBroadcastItem(n10);
            try {
                iMediaControllerCallback.onEvent(string2, bundle);
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
    private void sendExtras(Bundle bundle) {
        RemoteCallbackList remoteCallbackList = this.mControllerCallbacks;
        int n10 = remoteCallbackList.beginBroadcast() + -1;
        while (true) {
            if (n10 < 0) {
                this.mControllerCallbacks.finishBroadcast();
                return;
            }
            IMediaControllerCallback iMediaControllerCallback = (IMediaControllerCallback)this.mControllerCallbacks.getBroadcastItem(n10);
            try {
                iMediaControllerCallback.onExtrasChanged(bundle);
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
    private void sendMetadata(MediaMetadataCompat mediaMetadataCompat) {
        RemoteCallbackList remoteCallbackList = this.mControllerCallbacks;
        int n10 = remoteCallbackList.beginBroadcast() + -1;
        while (true) {
            if (n10 < 0) {
                this.mControllerCallbacks.finishBroadcast();
                return;
            }
            IMediaControllerCallback iMediaControllerCallback = (IMediaControllerCallback)this.mControllerCallbacks.getBroadcastItem(n10);
            try {
                iMediaControllerCallback.onMetadataChanged(mediaMetadataCompat);
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
    private void sendQueue(List list) {
        RemoteCallbackList remoteCallbackList = this.mControllerCallbacks;
        int n10 = remoteCallbackList.beginBroadcast() + -1;
        while (true) {
            if (n10 < 0) {
                this.mControllerCallbacks.finishBroadcast();
                return;
            }
            IMediaControllerCallback iMediaControllerCallback = (IMediaControllerCallback)this.mControllerCallbacks.getBroadcastItem(n10);
            try {
                iMediaControllerCallback.onQueueChanged(list);
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
    private void sendQueueTitle(CharSequence charSequence) {
        RemoteCallbackList remoteCallbackList = this.mControllerCallbacks;
        int n10 = remoteCallbackList.beginBroadcast() + -1;
        while (true) {
            if (n10 < 0) {
                this.mControllerCallbacks.finishBroadcast();
                return;
            }
            IMediaControllerCallback iMediaControllerCallback = (IMediaControllerCallback)this.mControllerCallbacks.getBroadcastItem(n10);
            try {
                iMediaControllerCallback.onQueueTitleChanged(charSequence);
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
    private void sendRepeatMode(int n10) {
        RemoteCallbackList remoteCallbackList = this.mControllerCallbacks;
        int n11 = remoteCallbackList.beginBroadcast() + -1;
        while (true) {
            if (n11 < 0) {
                this.mControllerCallbacks.finishBroadcast();
                return;
            }
            IMediaControllerCallback iMediaControllerCallback = (IMediaControllerCallback)this.mControllerCallbacks.getBroadcastItem(n11);
            try {
                iMediaControllerCallback.onRepeatModeChanged(n10);
            }
            catch (RemoteException remoteException) {}
            n11 += -1;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void sendSessionDestroyed() {
        RemoteCallbackList remoteCallbackList = this.mControllerCallbacks;
        int n10 = remoteCallbackList.beginBroadcast() + -1;
        while (true) {
            if (n10 < 0) {
                this.mControllerCallbacks.finishBroadcast();
                this.mControllerCallbacks.kill();
                return;
            }
            IMediaControllerCallback iMediaControllerCallback = (IMediaControllerCallback)this.mControllerCallbacks.getBroadcastItem(n10);
            try {
                iMediaControllerCallback.onSessionDestroyed();
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
    private void sendShuffleMode(int n10) {
        RemoteCallbackList remoteCallbackList = this.mControllerCallbacks;
        int n11 = remoteCallbackList.beginBroadcast() + -1;
        while (true) {
            if (n11 < 0) {
                this.mControllerCallbacks.finishBroadcast();
                return;
            }
            IMediaControllerCallback iMediaControllerCallback = (IMediaControllerCallback)this.mControllerCallbacks.getBroadcastItem(n11);
            try {
                iMediaControllerCallback.onShuffleModeChanged(n10);
            }
            catch (RemoteException remoteException) {}
            n11 += -1;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void sendState(PlaybackStateCompat playbackStateCompat) {
        RemoteCallbackList remoteCallbackList = this.mControllerCallbacks;
        int n10 = remoteCallbackList.beginBroadcast() + -1;
        while (true) {
            if (n10 < 0) {
                this.mControllerCallbacks.finishBroadcast();
                return;
            }
            IMediaControllerCallback iMediaControllerCallback = (IMediaControllerCallback)this.mControllerCallbacks.getBroadcastItem(n10);
            try {
                iMediaControllerCallback.onPlaybackStateChanged(playbackStateCompat);
            }
            catch (RemoteException remoteException) {}
            n10 += -1;
        }
    }

    public void adjustVolume(int n10, int n11) {
        int n12 = this.mVolumeType;
        int n13 = 2;
        if (n12 == n13) {
            VolumeProviderCompat volumeProviderCompat = this.mVolumeProvider;
            if (volumeProviderCompat != null) {
                volumeProviderCompat.onAdjustVolume(n10);
            }
        } else {
            AudioManager audioManager = this.mAudioManager;
            n13 = this.mLocalStream;
            audioManager.adjustStreamVolume(n13, n10, n11);
        }
    }

    public RemoteControlClient.MetadataEditor buildRccMetadata(Bundle object) {
        long l10;
        String string2;
        int n10;
        RemoteControlClient remoteControlClient = this.mRcc;
        int n11 = 1;
        remoteControlClient = remoteControlClient.editMetadata(n11 != 0);
        if (object == null) {
            return remoteControlClient;
        }
        String string3 = "android.media.metadata.ART";
        boolean bl2 = object.containsKey(string3);
        int n12 = 100;
        if (bl2) {
            if ((string3 = (Bitmap)object.getParcelable(string3)) != null) {
                Bitmap.Config config = string3.getConfig();
                string3 = string3.copy(config, false);
            }
            remoteControlClient.putBitmap(n12, (Bitmap)string3);
        } else {
            string3 = "android.media.metadata.ALBUM_ART";
            bl2 = object.containsKey(string3);
            if (bl2) {
                if ((string3 = (Bitmap)object.getParcelable(string3)) != null) {
                    Bitmap.Config config = string3.getConfig();
                    string3 = string3.copy(config, false);
                }
                remoteControlClient.putBitmap(n12, (Bitmap)string3);
            }
        }
        string3 = "android.media.metadata.ALBUM";
        bl2 = object.containsKey(string3);
        if (bl2) {
            string3 = object.getString(string3);
            remoteControlClient.putString(n11, string3);
        }
        if ((n10 = object.containsKey(string2 = "android.media.metadata.ALBUM_ARTIST")) != 0) {
            n10 = 13;
            string2 = object.getString(string2);
            remoteControlClient.putString(n10, string2);
        }
        if ((n10 = (int)(object.containsKey(string2 = "android.media.metadata.ARTIST") ? 1 : 0)) != 0) {
            n10 = 2;
            string2 = object.getString(string2);
            remoteControlClient.putString(n10, string2);
        }
        if ((n10 = (int)(object.containsKey(string2 = "android.media.metadata.AUTHOR") ? 1 : 0)) != 0) {
            n10 = 3;
            string2 = object.getString(string2);
            remoteControlClient.putString(n10, string2);
        }
        if ((n10 = (int)(object.containsKey(string2 = "android.media.metadata.COMPILATION") ? 1 : 0)) != 0) {
            n10 = 15;
            string2 = object.getString(string2);
            remoteControlClient.putString(n10, string2);
        }
        if ((n10 = (int)(object.containsKey(string2 = "android.media.metadata.COMPOSER") ? 1 : 0)) != 0) {
            n10 = 4;
            string2 = object.getString(string2);
            remoteControlClient.putString(n10, string2);
        }
        if ((n10 = (int)(object.containsKey(string2 = "android.media.metadata.DATE") ? 1 : 0)) != 0) {
            n10 = 5;
            string2 = object.getString(string2);
            remoteControlClient.putString(n10, string2);
        }
        if ((n10 = (int)(object.containsKey(string2 = "android.media.metadata.DISC_NUMBER") ? 1 : 0)) != 0) {
            n10 = 14;
            l10 = object.getLong(string2);
            remoteControlClient.putLong(n10, l10);
        }
        if ((n10 = (int)(object.containsKey(string2 = "android.media.metadata.DURATION") ? 1 : 0)) != 0) {
            n10 = 9;
            l10 = object.getLong(string2);
            remoteControlClient.putLong(n10, l10);
        }
        if ((n10 = (int)(object.containsKey(string2 = "android.media.metadata.GENRE") ? 1 : 0)) != 0) {
            n10 = 6;
            string2 = object.getString(string2);
            remoteControlClient.putString(n10, string2);
        }
        if ((n10 = (int)(object.containsKey(string2 = "android.media.metadata.TITLE") ? 1 : 0)) != 0) {
            n10 = 7;
            string2 = object.getString(string2);
            remoteControlClient.putString(n10, string2);
        }
        if ((n10 = (int)(object.containsKey(string2 = "android.media.metadata.TRACK_NUMBER") ? 1 : 0)) != 0) {
            long l11 = object.getLong(string2);
            remoteControlClient.putLong(0, l11);
        }
        if ((n10 = (int)(object.containsKey(string2 = "android.media.metadata.WRITER") ? 1 : 0)) != 0) {
            n10 = 11;
            object = object.getString(string2);
            remoteControlClient.putString(n10, (String)object);
        }
        return remoteControlClient;
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
        return null;
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
        return null;
    }

    public String getPackageNameForUid(int n10) {
        PackageManager packageManager = this.mContext.getPackageManager();
        String string2 = packageManager.getNameForUid(n10);
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (bl2) {
            string2 = "android.media.session.MediaController";
        }
        return string2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public PlaybackStateCompat getPlaybackState() {
        Object object = this.mLock;
        synchronized (object) {
            return this.mState;
        }
    }

    public int getRccStateFromState(int n10) {
        switch (n10) {
            default: {
                return -1;
            }
            case 10: 
            case 11: {
                return 6;
            }
            case 9: {
                return 7;
            }
            case 7: {
                return 9;
            }
            case 6: 
            case 8: {
                return 8;
            }
            case 5: {
                return 5;
            }
            case 4: {
                return 4;
            }
            case 3: {
                return 3;
            }
            case 2: {
                return 2;
            }
            case 1: {
                return 1;
            }
            case 0: 
        }
        return 0;
    }

    public int getRccTransportControlFlagsFromActions(long l10) {
        long l11;
        long l12;
        long l13;
        long l14;
        long l15;
        long l16;
        long l17;
        long l18 = 1L & l10;
        long l19 = 0L;
        long l20 = l18 - l19;
        Object object = l20 == 0L ? 0 : (l20 < 0L ? -1 : 1);
        object = object != false ? (Object)32 : (Object)0;
        long l21 = (long)2 & l10;
        long l22 = l21 - l19;
        Object object2 = l22 == 0L ? 0 : (l22 < 0L ? -1 : 1);
        if (object2 != false) {
            object = object | 0x10;
        }
        if ((object2 = (l17 = (l21 = (long)4 & l10) - l19) == 0L ? 0 : (l17 < 0L ? -1 : 1)) != false) {
            object = object | 4;
        }
        if ((object2 = (l16 = (l21 = (long)8 & l10) - l19) == 0L ? 0 : (l16 < 0L ? -1 : 1)) != false) {
            object = object | 2;
        }
        if ((object2 = (l15 = (l21 = (long)16 & l10) - l19) == 0L ? 0 : (l15 < 0L ? -1 : 1)) != false) {
            object = object | 1;
        }
        if ((object2 = (l14 = (l21 = (long)32 & l10) - l19) == 0L ? 0 : (l14 < 0L ? -1 : 1)) != false) {
            object = object | 0x80;
        }
        if ((object2 = (l13 = (l21 = (long)64 & l10) - l19) == 0L ? 0 : (l13 < 0L ? -1 : 1)) != false) {
            object = object | 0x40;
        }
        if ((l12 = (l11 = (l10 &= (l21 = 512L)) - l19) == 0L ? 0 : (l11 < 0L ? -1 : 1)) != false) {
            object = object | 8;
        }
        return (int)object;
    }

    public Object getRemoteControlClient() {
        return null;
    }

    public MediaSessionCompat$Token getSessionToken() {
        return this.mToken;
    }

    public boolean isActive() {
        return this.mIsActive;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void postToHandler(int n10, int n11, int n12, Object object, Bundle bundle) {
        Object object2 = this.mLock;
        synchronized (object2) {
            MediaSessionCompat$MediaSessionImplBase$MessageHandler mediaSessionCompat$MediaSessionImplBase$MessageHandler = this.mHandler;
            if (mediaSessionCompat$MediaSessionImplBase$MessageHandler != null) {
                Message message = mediaSessionCompat$MediaSessionImplBase$MessageHandler.obtainMessage(n10, n11, n12, object);
                Bundle bundle2 = new Bundle();
                n12 = Binder.getCallingUid();
                object = "data_calling_uid";
                bundle2.putInt((String)object, n12);
                object = "data_calling_pkg";
                String string2 = this.getPackageNameForUid(n12);
                bundle2.putString((String)object, string2);
                n12 = Binder.getCallingPid();
                if (n12 > 0) {
                    object = "data_calling_pid";
                    bundle2.putInt((String)object, n12);
                } else {
                    string2 = "data_calling_pid";
                    int n13 = -1;
                    bundle2.putInt(string2, n13);
                }
                if (bundle != null) {
                    string2 = "data_extras";
                    bundle2.putBundle(string2, bundle);
                }
                message.setData(bundle2);
                message.sendToTarget();
            }
            return;
        }
    }

    public void registerMediaButtonEventReceiver(PendingIntent pendingIntent, ComponentName componentName) {
        this.mAudioManager.registerMediaButtonEventReceiver(componentName);
    }

    public void release() {
        this.mIsActive = false;
        this.mDestroyed = true;
        this.updateMbrAndRcc();
        this.sendSessionDestroyed();
        this.setCallback(null, null);
    }

    public void sendSessionEvent(String string2, Bundle bundle) {
        this.sendEvent(string2, bundle);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void sendVolumeInfoChanged(ParcelableVolumeInfo parcelableVolumeInfo) {
        RemoteCallbackList remoteCallbackList = this.mControllerCallbacks;
        int n10 = remoteCallbackList.beginBroadcast() + -1;
        while (true) {
            if (n10 < 0) {
                this.mControllerCallbacks.finishBroadcast();
                return;
            }
            IMediaControllerCallback iMediaControllerCallback = (IMediaControllerCallback)this.mControllerCallbacks.getBroadcastItem(n10);
            try {
                iMediaControllerCallback.onVolumeInfoChanged(parcelableVolumeInfo);
            }
            catch (RemoteException remoteException) {}
            n10 += -1;
        }
    }

    public void setActive(boolean bl2) {
        boolean bl3 = this.mIsActive;
        if (bl2 == bl3) {
            return;
        }
        this.mIsActive = bl2;
        this.updateMbrAndRcc();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void setCallback(MediaSessionCompat$Callback mediaSessionCompat$Callback, Handler handler) {
        Object object = this.mLock;
        synchronized (object) {
            Object object2 = this.mHandler;
            if (object2 != null) {
                object2.removeCallbacksAndMessages(null);
            }
            if (mediaSessionCompat$Callback != null && handler != null) {
                Looper looper = handler.getLooper();
                object2 = new MediaSessionCompat$MediaSessionImplBase$MessageHandler(this, looper);
            } else {
                object2 = null;
            }
            this.mHandler = object2;
            object2 = this.mCallback;
            if (object2 != mediaSessionCompat$Callback && (object2 = this.mCallback) != null) {
                object2 = this.mCallback;
                ((MediaSessionCompat$Callback)object2).setSessionImpl(null, null);
            }
            if ((mediaSessionCompat$Callback = (this.mCallback = mediaSessionCompat$Callback)) != null) {
                mediaSessionCompat$Callback = this.mCallback;
                mediaSessionCompat$Callback.setSessionImpl(this, handler);
            }
            return;
        }
    }

    public void setCaptioningEnabled(boolean bl2) {
        boolean bl3 = this.mCaptioningEnabled;
        if (bl3 != bl2) {
            this.mCaptioningEnabled = bl2;
            this.sendCaptioningEnabled(bl2);
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
        this.mExtras = bundle;
        this.sendExtras(bundle);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void setFlags(int n10) {
        Object object = this.mLock;
        synchronized (object) {
            this.mFlags = n10 = n10 | 1 | 2;
            return;
        }
    }

    public void setMediaButtonReceiver(PendingIntent pendingIntent) {
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void setMetadata(MediaMetadataCompat mediaMetadataCompat) {
        Object object;
        if (mediaMetadataCompat != null) {
            int n10 = MediaSessionCompat.sMaxBitmapSize;
            object = new MediaMetadataCompat$Builder(mediaMetadataCompat, n10);
            mediaMetadataCompat = ((MediaMetadataCompat$Builder)object).build();
        }
        object = this.mLock;
        synchronized (object) {
            this.mMetadata = mediaMetadataCompat;
        }
        this.sendMetadata(mediaMetadataCompat);
        boolean bl2 = this.mIsActive;
        if (!bl2) {
            return;
        }
        mediaMetadataCompat = mediaMetadataCompat == null ? null : mediaMetadataCompat.getBundle();
        this.buildRccMetadata((Bundle)mediaMetadataCompat).apply();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void setPlaybackState(PlaybackStateCompat playbackStateCompat) {
        Object object = this.mLock;
        synchronized (object) {
            this.mState = playbackStateCompat;
        }
        this.sendState(playbackStateCompat);
        boolean bl2 = this.mIsActive;
        if (!bl2) {
            return;
        }
        if (playbackStateCompat == null) {
            playbackStateCompat = this.mRcc;
            bl2 = false;
            object = null;
            playbackStateCompat.setPlaybackState(0);
            playbackStateCompat = this.mRcc;
            playbackStateCompat.setTransportControlFlags(0);
            return;
        }
        this.setRccState(playbackStateCompat);
        object = this.mRcc;
        long l10 = playbackStateCompat.getActions();
        int n10 = this.getRccTransportControlFlagsFromActions(l10);
        object.setTransportControlFlags(n10);
    }

    public void setPlaybackToLocal(int n10) {
        ParcelableVolumeInfo parcelableVolumeInfo;
        int n11;
        Object object = this.mVolumeProvider;
        if (object != null) {
            n11 = 0;
            ((VolumeProviderCompat)object).setCallback(null);
        }
        this.mLocalStream = n10;
        n11 = this.mVolumeType = 1;
        int n12 = this.mLocalStream;
        int n13 = this.mAudioManager.getStreamMaxVolume(n12);
        object = this.mAudioManager;
        int n14 = this.mLocalStream;
        n14 = object.getStreamVolume(n14);
        object = parcelableVolumeInfo;
        parcelableVolumeInfo = new ParcelableVolumeInfo(n11, n12, 2, n13, n14);
        this.sendVolumeInfoChanged(parcelableVolumeInfo);
    }

    public void setPlaybackToRemote(VolumeProviderCompat object) {
        if (object != null) {
            Object object2 = this.mVolumeProvider;
            if (object2 != null) {
                ((VolumeProviderCompat)object2).setCallback(null);
            }
            this.mVolumeType = 2;
            this.mVolumeProvider = object;
            int n10 = this.mVolumeType;
            int n11 = this.mLocalStream;
            int n12 = this.mVolumeProvider.getVolumeControl();
            int n13 = this.mVolumeProvider.getMaxVolume();
            int n14 = this.mVolumeProvider.getCurrentVolume();
            object2 = new ParcelableVolumeInfo(n10, n11, n12, n13, n14);
            this.sendVolumeInfoChanged((ParcelableVolumeInfo)object2);
            object2 = this.mVolumeCallback;
            ((VolumeProviderCompat)object).setCallback((VolumeProviderCompat$Callback)object2);
            return;
        }
        object = new IllegalArgumentException("volumeProvider may not be null");
        throw object;
    }

    public void setQueue(List list) {
        this.mQueue = list;
        this.sendQueue(list);
    }

    public void setQueueTitle(CharSequence charSequence) {
        this.mQueueTitle = charSequence;
        this.sendQueueTitle(charSequence);
    }

    public void setRatingType(int n10) {
        this.mRatingType = n10;
    }

    public void setRccState(PlaybackStateCompat playbackStateCompat) {
        RemoteControlClient remoteControlClient = this.mRcc;
        int n10 = playbackStateCompat.getState();
        n10 = this.getRccStateFromState(n10);
        remoteControlClient.setPlaybackState(n10);
    }

    public void setRepeatMode(int n10) {
        int n11 = this.mRepeatMode;
        if (n11 != n10) {
            this.mRepeatMode = n10;
            this.sendRepeatMode(n10);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void setSessionActivity(PendingIntent pendingIntent) {
        Object object = this.mLock;
        synchronized (object) {
            this.mSessionActivity = pendingIntent;
            return;
        }
    }

    public void setShuffleMode(int n10) {
        int n11 = this.mShuffleMode;
        if (n11 != n10) {
            this.mShuffleMode = n10;
            this.sendShuffleMode(n10);
        }
    }

    public void setVolumeTo(int n10, int n11) {
        int n12 = this.mVolumeType;
        int n13 = 2;
        if (n12 == n13) {
            VolumeProviderCompat volumeProviderCompat = this.mVolumeProvider;
            if (volumeProviderCompat != null) {
                volumeProviderCompat.onSetVolumeTo(n10);
            }
        } else {
            AudioManager audioManager = this.mAudioManager;
            n13 = this.mLocalStream;
            audioManager.setStreamVolume(n13, n10, n11);
        }
    }

    public void unregisterMediaButtonEventReceiver(PendingIntent pendingIntent, ComponentName componentName) {
        this.mAudioManager.unregisterMediaButtonEventReceiver(componentName);
    }

    public void updateMbrAndRcc() {
        boolean bl2 = this.mIsActive;
        if (bl2) {
            Object object = this.mMediaButtonReceiverIntent;
            ComponentName componentName = this.mMediaButtonReceiverComponentName;
            this.registerMediaButtonEventReceiver((PendingIntent)object, componentName);
            object = this.mAudioManager;
            componentName = this.mRcc;
            object.registerRemoteControlClient((RemoteControlClient)componentName);
            object = this.mMetadata;
            this.setMetadata((MediaMetadataCompat)object);
            object = this.mState;
            this.setPlaybackState((PlaybackStateCompat)object);
        } else {
            PendingIntent pendingIntent = this.mMediaButtonReceiverIntent;
            ComponentName componentName = this.mMediaButtonReceiverComponentName;
            this.unregisterMediaButtonEventReceiver(pendingIntent, componentName);
            this.mRcc.setPlaybackState(0);
            pendingIntent = this.mAudioManager;
            componentName = this.mRcc;
            pendingIntent.unregisterRemoteControlClient((RemoteControlClient)componentName);
        }
    }
}

