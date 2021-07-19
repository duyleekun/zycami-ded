/*
 * Decompiled with CFR 0.151.
 */
package android.support.v4.media.session;

import androidx.media.AudioAttributesCompat;
import androidx.media.AudioAttributesCompat$Builder;

public final class MediaControllerCompat$PlaybackInfo {
    public static final int PLAYBACK_TYPE_LOCAL = 1;
    public static final int PLAYBACK_TYPE_REMOTE = 2;
    private final AudioAttributesCompat mAudioAttrsCompat;
    private final int mCurrentVolume;
    private final int mMaxVolume;
    private final int mPlaybackType;
    private final int mVolumeControl;

    public MediaControllerCompat$PlaybackInfo(int n10, int n11, int n12, int n13, int n14) {
        Object object = new AudioAttributesCompat$Builder();
        AudioAttributesCompat audioAttributesCompat = ((AudioAttributesCompat$Builder)object).setLegacyStreamType(n11).build();
        object = this;
        this(n10, audioAttributesCompat, n12, n13, n14);
    }

    public MediaControllerCompat$PlaybackInfo(int n10, AudioAttributesCompat audioAttributesCompat, int n11, int n12, int n13) {
        this.mPlaybackType = n10;
        this.mAudioAttrsCompat = audioAttributesCompat;
        this.mVolumeControl = n11;
        this.mMaxVolume = n12;
        this.mCurrentVolume = n13;
    }

    public AudioAttributesCompat getAudioAttributes() {
        return this.mAudioAttrsCompat;
    }

    public int getAudioStream() {
        return this.mAudioAttrsCompat.getLegacyStreamType();
    }

    public int getCurrentVolume() {
        return this.mCurrentVolume;
    }

    public int getMaxVolume() {
        return this.mMaxVolume;
    }

    public int getPlaybackType() {
        return this.mPlaybackType;
    }

    public int getVolumeControl() {
        return this.mVolumeControl;
    }
}

