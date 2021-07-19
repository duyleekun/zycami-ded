/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.AudioAttributes
 */
package androidx.media;

import android.media.AudioAttributes;
import androidx.media.AudioAttributesCompat;
import androidx.media.AudioAttributesImpl;

public class AudioAttributesImplApi21
implements AudioAttributesImpl {
    public AudioAttributes mAudioAttributes;
    public int mLegacyStreamType = -1;

    public AudioAttributesImplApi21() {
    }

    public AudioAttributesImplApi21(AudioAttributes audioAttributes) {
        this(audioAttributes, -1);
    }

    public AudioAttributesImplApi21(AudioAttributes audioAttributes, int n10) {
        this.mAudioAttributes = audioAttributes;
        this.mLegacyStreamType = n10;
    }

    public boolean equals(Object object) {
        boolean bl2 = object instanceof AudioAttributesImplApi21;
        if (!bl2) {
            return false;
        }
        object = (AudioAttributesImplApi21)object;
        AudioAttributes audioAttributes = this.mAudioAttributes;
        object = ((AudioAttributesImplApi21)object).mAudioAttributes;
        return audioAttributes.equals(object);
    }

    public Object getAudioAttributes() {
        return this.mAudioAttributes;
    }

    public int getContentType() {
        return this.mAudioAttributes.getContentType();
    }

    public int getFlags() {
        return this.mAudioAttributes.getFlags();
    }

    public int getLegacyStreamType() {
        int n10 = this.mLegacyStreamType;
        int n11 = -1;
        if (n10 != n11) {
            return n10;
        }
        n11 = this.getFlags();
        int n12 = this.getUsage();
        return AudioAttributesCompat.toVolumeStreamType(false, n11, n12);
    }

    public int getRawLegacyStreamType() {
        return this.mLegacyStreamType;
    }

    public int getUsage() {
        return this.mAudioAttributes.getUsage();
    }

    public int getVolumeControlStream() {
        int n10 = this.getFlags();
        int n11 = this.getUsage();
        return AudioAttributesCompat.toVolumeStreamType(true, n10, n11);
    }

    public int hashCode() {
        return this.mAudioAttributes.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("AudioAttributesCompat: audioattributes=");
        AudioAttributes audioAttributes = this.mAudioAttributes;
        stringBuilder.append(audioAttributes);
        return stringBuilder.toString();
    }
}

