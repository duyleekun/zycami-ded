/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.session.PlaybackState
 *  android.media.session.PlaybackState$Builder
 *  android.media.session.PlaybackState$CustomAction
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  android.os.SystemClock
 *  android.text.TextUtils
 */
package android.support.v4.media.session;

import android.media.session.PlaybackState;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.PlaybackStateCompat$1;
import android.support.v4.media.session.PlaybackStateCompat$CustomAction;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

public final class PlaybackStateCompat
implements Parcelable {
    public static final long ACTION_FAST_FORWARD = 64L;
    public static final long ACTION_PAUSE = 2L;
    public static final long ACTION_PLAY = 4L;
    public static final long ACTION_PLAY_FROM_MEDIA_ID = 1024L;
    public static final long ACTION_PLAY_FROM_SEARCH = 2048L;
    public static final long ACTION_PLAY_FROM_URI = 8192L;
    public static final long ACTION_PLAY_PAUSE = 512L;
    public static final long ACTION_PREPARE = 16384L;
    public static final long ACTION_PREPARE_FROM_MEDIA_ID = 32768L;
    public static final long ACTION_PREPARE_FROM_SEARCH = 65536L;
    public static final long ACTION_PREPARE_FROM_URI = 131072L;
    public static final long ACTION_REWIND = 8L;
    public static final long ACTION_SEEK_TO = 256L;
    public static final long ACTION_SET_CAPTIONING_ENABLED = 0x100000L;
    public static final long ACTION_SET_RATING = 128L;
    public static final long ACTION_SET_REPEAT_MODE = 262144L;
    public static final long ACTION_SET_SHUFFLE_MODE = 0x200000L;
    public static final long ACTION_SET_SHUFFLE_MODE_ENABLED = 524288L;
    public static final long ACTION_SKIP_TO_NEXT = 32L;
    public static final long ACTION_SKIP_TO_PREVIOUS = 16L;
    public static final long ACTION_SKIP_TO_QUEUE_ITEM = 4096L;
    public static final long ACTION_STOP = 1L;
    public static final Parcelable.Creator CREATOR;
    public static final int ERROR_CODE_ACTION_ABORTED = 10;
    public static final int ERROR_CODE_APP_ERROR = 1;
    public static final int ERROR_CODE_AUTHENTICATION_EXPIRED = 3;
    public static final int ERROR_CODE_CONCURRENT_STREAM_LIMIT = 5;
    public static final int ERROR_CODE_CONTENT_ALREADY_PLAYING = 8;
    public static final int ERROR_CODE_END_OF_QUEUE = 11;
    public static final int ERROR_CODE_NOT_AVAILABLE_IN_REGION = 7;
    public static final int ERROR_CODE_NOT_SUPPORTED = 2;
    public static final int ERROR_CODE_PARENTAL_CONTROL_RESTRICTED = 6;
    public static final int ERROR_CODE_PREMIUM_ACCOUNT_REQUIRED = 4;
    public static final int ERROR_CODE_SKIP_LIMIT_REACHED = 9;
    public static final int ERROR_CODE_UNKNOWN_ERROR = 0;
    private static final int KEYCODE_MEDIA_PAUSE = 127;
    private static final int KEYCODE_MEDIA_PLAY = 126;
    public static final long PLAYBACK_POSITION_UNKNOWN = 255L;
    public static final int REPEAT_MODE_ALL = 2;
    public static final int REPEAT_MODE_GROUP = 3;
    public static final int REPEAT_MODE_INVALID = 255;
    public static final int REPEAT_MODE_NONE = 0;
    public static final int REPEAT_MODE_ONE = 1;
    public static final int SHUFFLE_MODE_ALL = 1;
    public static final int SHUFFLE_MODE_GROUP = 2;
    public static final int SHUFFLE_MODE_INVALID = 255;
    public static final int SHUFFLE_MODE_NONE = 0;
    public static final int STATE_BUFFERING = 6;
    public static final int STATE_CONNECTING = 8;
    public static final int STATE_ERROR = 7;
    public static final int STATE_FAST_FORWARDING = 4;
    public static final int STATE_NONE = 0;
    public static final int STATE_PAUSED = 2;
    public static final int STATE_PLAYING = 3;
    public static final int STATE_REWINDING = 5;
    public static final int STATE_SKIPPING_TO_NEXT = 10;
    public static final int STATE_SKIPPING_TO_PREVIOUS = 9;
    public static final int STATE_SKIPPING_TO_QUEUE_ITEM = 11;
    public static final int STATE_STOPPED = 1;
    public final long mActions;
    public final long mActiveItemId;
    public final long mBufferedPosition;
    public List mCustomActions;
    public final int mErrorCode;
    public final CharSequence mErrorMessage;
    public final Bundle mExtras;
    public final long mPosition;
    public final float mSpeed;
    public final int mState;
    private PlaybackState mStateFwk;
    public final long mUpdateTime;

    static {
        PlaybackStateCompat$1 playbackStateCompat$1 = new PlaybackStateCompat$1();
        CREATOR = playbackStateCompat$1;
    }

    public PlaybackStateCompat(int n10, long l10, long l11, float f10, long l12, int n11, CharSequence charSequence, long l13, List list, long l14, Bundle bundle) {
        this.mState = n10;
        this.mPosition = l10;
        this.mBufferedPosition = l11;
        this.mSpeed = f10;
        this.mActions = l12;
        this.mErrorCode = n11;
        Bundle bundle2 = charSequence;
        this.mErrorMessage = charSequence;
        this.mUpdateTime = l13;
        this.mCustomActions = bundle2 = new ArrayList(list);
        this.mActiveItemId = l14;
        bundle2 = bundle;
        this.mExtras = bundle;
    }

    public PlaybackStateCompat(Parcel parcel) {
        int n10;
        float f10;
        long l10;
        int n11;
        this.mState = n11 = parcel.readInt();
        this.mPosition = l10 = parcel.readLong();
        this.mSpeed = f10 = parcel.readFloat();
        this.mUpdateTime = l10 = parcel.readLong();
        this.mBufferedPosition = l10 = parcel.readLong();
        this.mActions = l10 = parcel.readLong();
        Object object = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.mErrorMessage = object;
        object = PlaybackStateCompat$CustomAction.CREATOR;
        this.mCustomActions = object = parcel.createTypedArrayList((Parcelable.Creator)object);
        this.mActiveItemId = l10 = parcel.readLong();
        object = MediaSessionCompat.class.getClassLoader();
        object = parcel.readBundle((ClassLoader)object);
        this.mExtras = object;
        this.mErrorCode = n10 = parcel.readInt();
    }

    public static PlaybackStateCompat fromPlaybackState(Object object) {
        int n10;
        int n11 = Build.VERSION.SDK_INT;
        Bundle bundle = null;
        if (object != null && n11 >= (n10 = 21)) {
            ArrayList<PlaybackStateCompat$CustomAction> arrayList;
            Object object2 = object;
            object2 = (PlaybackState)object;
            Object object3 = object2.getCustomActions();
            if (object3 != null) {
                int n12 = object3.size();
                ArrayList<PlaybackStateCompat$CustomAction> arrayList2 = new ArrayList<PlaybackStateCompat$CustomAction>(n12);
                object3 = object3.iterator();
                while ((n12 = (int)(object3.hasNext() ? 1 : 0)) != 0) {
                    PlaybackStateCompat$CustomAction playbackStateCompat$CustomAction = PlaybackStateCompat$CustomAction.fromCustomAction(object3.next());
                    arrayList2.add(playbackStateCompat$CustomAction);
                }
                arrayList = arrayList2;
            } else {
                arrayList = null;
            }
            int n13 = 22;
            if (n11 >= n13) {
                bundle = object2.getExtras();
                MediaSessionCompat.ensureClassLoader(bundle);
            }
            int n14 = object2.getState();
            long l10 = object2.getPosition();
            long l11 = object2.getBufferedPosition();
            float f10 = object2.getPlaybackSpeed();
            long l12 = object2.getActions();
            CharSequence charSequence = object2.getErrorMessage();
            long l13 = object2.getLastPositionUpdateTime();
            long l14 = object2.getActiveQueueItemId();
            PlaybackStateCompat playbackStateCompat = new PlaybackStateCompat(n14, l10, l11, f10, l12, 0, charSequence, l13, arrayList, l14, bundle);
            playbackStateCompat.mStateFwk = object2;
            return playbackStateCompat;
        }
        return null;
    }

    public static int toKeyCode(long l10) {
        long l11 = 4;
        long l12 = l10 - l11;
        long l13 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (l13 == false) {
            return 126;
        }
        l11 = 2;
        long l14 = l10 - l11;
        l13 = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
        if (l13 == false) {
            return 127;
        }
        l11 = 32;
        long l15 = l10 - l11;
        l13 = l15 == 0L ? 0 : (l15 < 0L ? -1 : 1);
        if (l13 == false) {
            return 87;
        }
        l11 = 16;
        long l16 = l10 - l11;
        l13 = l16 == 0L ? 0 : (l16 < 0L ? -1 : 1);
        if (l13 == false) {
            return 88;
        }
        l11 = 1L;
        long l17 = l10 - l11;
        l13 = l17 == 0L ? 0 : (l17 < 0L ? -1 : 1);
        if (l13 == false) {
            return 86;
        }
        l11 = 64;
        long l18 = l10 - l11;
        l13 = l18 == 0L ? 0 : (l18 < 0L ? -1 : 1);
        if (l13 == false) {
            return 90;
        }
        l11 = 8;
        long l19 = l10 - l11;
        l13 = l19 == 0L ? 0 : (l19 < 0L ? -1 : 1);
        if (l13 == false) {
            return 89;
        }
        l11 = 512L;
        long l20 = l10 - l11;
        long l21 = l20 == 0L ? 0 : (l20 < 0L ? -1 : 1);
        if (l21 == false) {
            return 85;
        }
        return 0;
    }

    public int describeContents() {
        return 0;
    }

    public long getActions() {
        return this.mActions;
    }

    public long getActiveQueueItemId() {
        return this.mActiveItemId;
    }

    public long getBufferedPosition() {
        return this.mBufferedPosition;
    }

    public long getCurrentPosition(Long l10) {
        long l11;
        long l12 = this.mPosition;
        float f10 = this.mSpeed;
        if (l10 != null) {
            l11 = l10;
        } else {
            l11 = SystemClock.elapsedRealtime();
            long l13 = this.mUpdateTime;
            l11 -= l13;
        }
        float f11 = l11;
        long l14 = (long)(f10 * f11);
        return Math.max(0L, l12 += l14);
    }

    public List getCustomActions() {
        return this.mCustomActions;
    }

    public int getErrorCode() {
        return this.mErrorCode;
    }

    public CharSequence getErrorMessage() {
        return this.mErrorMessage;
    }

    public Bundle getExtras() {
        return this.mExtras;
    }

    public long getLastPositionUpdateTime() {
        return this.mUpdateTime;
    }

    public float getPlaybackSpeed() {
        return this.mSpeed;
    }

    public Object getPlaybackState() {
        int n10;
        int n11 = Build.VERSION.SDK_INT;
        PlaybackState playbackState = this.mStateFwk;
        if (playbackState == null && n11 >= (n10 = 21)) {
            Bundle bundle;
            playbackState = new PlaybackState.Builder();
            int n12 = this.mState;
            long l10 = this.mPosition;
            float f10 = this.mSpeed;
            long l11 = this.mUpdateTime;
            Object object = playbackState;
            playbackState.setState(n12, l10, f10, l11);
            long l12 = this.mBufferedPosition;
            playbackState.setBufferedPosition(l12);
            l12 = this.mActions;
            playbackState.setActions(l12);
            object = this.mErrorMessage;
            playbackState.setErrorMessage((CharSequence)object);
            object = this.mCustomActions.iterator();
            while ((n12 = (int)(object.hasNext() ? 1 : 0)) != 0) {
                PlaybackState.CustomAction customAction = (PlaybackState.CustomAction)((PlaybackStateCompat$CustomAction)object.next()).getCustomAction();
                playbackState.addCustomAction(customAction);
            }
            l12 = this.mActiveItemId;
            playbackState.setActiveQueueItemId(l12);
            int n13 = 22;
            if (n11 >= n13) {
                bundle = this.mExtras;
                playbackState.setExtras(bundle);
            }
            bundle = playbackState.build();
            this.mStateFwk = bundle;
        }
        return this.mStateFwk;
    }

    public long getPosition() {
        return this.mPosition;
    }

    public int getState() {
        return this.mState;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("PlaybackState {");
        stringBuilder.append("state=");
        int n10 = this.mState;
        stringBuilder.append(n10);
        stringBuilder.append(", position=");
        long l10 = this.mPosition;
        stringBuilder.append(l10);
        stringBuilder.append(", buffered position=");
        l10 = this.mBufferedPosition;
        stringBuilder.append(l10);
        stringBuilder.append(", speed=");
        float f10 = this.mSpeed;
        stringBuilder.append(f10);
        stringBuilder.append(", updated=");
        l10 = this.mUpdateTime;
        stringBuilder.append(l10);
        stringBuilder.append(", actions=");
        l10 = this.mActions;
        stringBuilder.append(l10);
        stringBuilder.append(", error code=");
        n10 = this.mErrorCode;
        stringBuilder.append(n10);
        stringBuilder.append(", error message=");
        Object object = this.mErrorMessage;
        stringBuilder.append((CharSequence)object);
        stringBuilder.append(", custom actions=");
        object = this.mCustomActions;
        stringBuilder.append(object);
        stringBuilder.append(", active item id=");
        l10 = this.mActiveItemId;
        stringBuilder.append(l10);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int n10) {
        int n11 = this.mState;
        parcel.writeInt(n11);
        long l10 = this.mPosition;
        parcel.writeLong(l10);
        float f10 = this.mSpeed;
        parcel.writeFloat(f10);
        l10 = this.mUpdateTime;
        parcel.writeLong(l10);
        l10 = this.mBufferedPosition;
        parcel.writeLong(l10);
        l10 = this.mActions;
        parcel.writeLong(l10);
        TextUtils.writeToParcel((CharSequence)this.mErrorMessage, (Parcel)parcel, (int)n10);
        List list = this.mCustomActions;
        parcel.writeTypedList(list);
        l10 = this.mActiveItemId;
        parcel.writeLong(l10);
        list = this.mExtras;
        parcel.writeBundle((Bundle)list);
        n10 = this.mErrorCode;
        parcel.writeInt(n10);
    }
}

