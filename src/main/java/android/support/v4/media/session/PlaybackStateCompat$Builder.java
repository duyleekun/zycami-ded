/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.SystemClock
 */
package android.support.v4.media.session;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.media.session.PlaybackStateCompat;
import android.support.v4.media.session.PlaybackStateCompat$CustomAction;
import java.util.ArrayList;
import java.util.List;

public final class PlaybackStateCompat$Builder {
    private long mActions;
    private long mActiveItemId;
    private long mBufferedPosition;
    private final List mCustomActions;
    private int mErrorCode;
    private CharSequence mErrorMessage;
    private Bundle mExtras;
    private long mPosition;
    private float mRate;
    private int mState;
    private long mUpdateTime;

    public PlaybackStateCompat$Builder() {
        ArrayList arrayList;
        this.mCustomActions = arrayList = new ArrayList();
        this.mActiveItemId = -1;
    }

    public PlaybackStateCompat$Builder(PlaybackStateCompat playbackStateCompat) {
        long l10;
        float f10;
        long l11;
        int n10;
        ArrayList arrayList;
        this.mCustomActions = arrayList = new ArrayList();
        this.mActiveItemId = -1;
        this.mState = n10 = playbackStateCompat.mState;
        this.mPosition = l11 = playbackStateCompat.mPosition;
        this.mRate = f10 = playbackStateCompat.mSpeed;
        this.mUpdateTime = l11 = playbackStateCompat.mUpdateTime;
        this.mBufferedPosition = l11 = playbackStateCompat.mBufferedPosition;
        this.mActions = l11 = playbackStateCompat.mActions;
        this.mErrorCode = n10 = playbackStateCompat.mErrorCode;
        Object object = playbackStateCompat.mErrorMessage;
        this.mErrorMessage = object;
        object = playbackStateCompat.mCustomActions;
        if (object != null) {
            arrayList.addAll(object);
        }
        this.mActiveItemId = l10 = playbackStateCompat.mActiveItemId;
        playbackStateCompat = playbackStateCompat.mExtras;
        this.mExtras = playbackStateCompat;
    }

    public PlaybackStateCompat$Builder addCustomAction(PlaybackStateCompat$CustomAction object) {
        if (object != null) {
            this.mCustomActions.add(object);
            return this;
        }
        object = new IllegalArgumentException("You may not add a null CustomAction to PlaybackStateCompat");
        throw object;
    }

    public PlaybackStateCompat$Builder addCustomAction(String string2, String string3, int n10) {
        PlaybackStateCompat$CustomAction playbackStateCompat$CustomAction = new PlaybackStateCompat$CustomAction(string2, string3, n10, null);
        return this.addCustomAction(playbackStateCompat$CustomAction);
    }

    public PlaybackStateCompat build() {
        int n10 = this.mState;
        long l10 = this.mPosition;
        long l11 = this.mBufferedPosition;
        float f10 = this.mRate;
        long l12 = this.mActions;
        int n11 = this.mErrorCode;
        CharSequence charSequence = this.mErrorMessage;
        long l13 = this.mUpdateTime;
        List list = this.mCustomActions;
        long l14 = this.mActiveItemId;
        Bundle bundle = this.mExtras;
        PlaybackStateCompat playbackStateCompat = new PlaybackStateCompat(n10, l10, l11, f10, l12, n11, charSequence, l13, list, l14, bundle);
        return playbackStateCompat;
    }

    public PlaybackStateCompat$Builder setActions(long l10) {
        this.mActions = l10;
        return this;
    }

    public PlaybackStateCompat$Builder setActiveQueueItemId(long l10) {
        this.mActiveItemId = l10;
        return this;
    }

    public PlaybackStateCompat$Builder setBufferedPosition(long l10) {
        this.mBufferedPosition = l10;
        return this;
    }

    public PlaybackStateCompat$Builder setErrorMessage(int n10, CharSequence charSequence) {
        this.mErrorCode = n10;
        this.mErrorMessage = charSequence;
        return this;
    }

    public PlaybackStateCompat$Builder setErrorMessage(CharSequence charSequence) {
        this.mErrorMessage = charSequence;
        return this;
    }

    public PlaybackStateCompat$Builder setExtras(Bundle bundle) {
        this.mExtras = bundle;
        return this;
    }

    public PlaybackStateCompat$Builder setState(int n10, long l10, float f10) {
        long l11 = SystemClock.elapsedRealtime();
        return this.setState(n10, l10, f10, l11);
    }

    public PlaybackStateCompat$Builder setState(int n10, long l10, float f10, long l11) {
        this.mState = n10;
        this.mPosition = l10;
        this.mUpdateTime = l11;
        this.mRate = f10;
        return this;
    }
}

