/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.AudioAttributes
 *  android.os.Parcelable
 */
package androidx.media;

import android.media.AudioAttributes;
import android.os.Parcelable;
import androidx.media.AudioAttributesImplApi26;
import androidx.versionedparcelable.VersionedParcel;

public class AudioAttributesImplApi26Parcelizer {
    public static AudioAttributesImplApi26 read(VersionedParcel versionedParcel) {
        int n10;
        AudioAttributesImplApi26 audioAttributesImplApi26 = new AudioAttributesImplApi26();
        AudioAttributes audioAttributes = audioAttributesImplApi26.mAudioAttributes;
        audioAttributesImplApi26.mAudioAttributes = audioAttributes = (AudioAttributes)versionedParcel.readParcelable((Parcelable)audioAttributes, 1);
        int n11 = audioAttributesImplApi26.mLegacyStreamType;
        audioAttributesImplApi26.mLegacyStreamType = n10 = versionedParcel.readInt(n11, 2);
        return audioAttributesImplApi26;
    }

    public static void write(AudioAttributesImplApi26 audioAttributesImplApi26, VersionedParcel versionedParcel) {
        versionedParcel.setSerializationFlags(false, false);
        AudioAttributes audioAttributes = audioAttributesImplApi26.mAudioAttributes;
        versionedParcel.writeParcelable((Parcelable)audioAttributes, 1);
        int n10 = audioAttributesImplApi26.mLegacyStreamType;
        versionedParcel.writeInt(n10, 2);
    }
}

