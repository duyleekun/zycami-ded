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
import androidx.media.AudioAttributesImplApi21;
import androidx.versionedparcelable.VersionedParcel;

public class AudioAttributesImplApi21Parcelizer {
    public static AudioAttributesImplApi21 read(VersionedParcel versionedParcel) {
        int n10;
        AudioAttributesImplApi21 audioAttributesImplApi21 = new AudioAttributesImplApi21();
        AudioAttributes audioAttributes = audioAttributesImplApi21.mAudioAttributes;
        audioAttributesImplApi21.mAudioAttributes = audioAttributes = (AudioAttributes)versionedParcel.readParcelable((Parcelable)audioAttributes, 1);
        int n11 = audioAttributesImplApi21.mLegacyStreamType;
        audioAttributesImplApi21.mLegacyStreamType = n10 = versionedParcel.readInt(n11, 2);
        return audioAttributesImplApi21;
    }

    public static void write(AudioAttributesImplApi21 audioAttributesImplApi21, VersionedParcel versionedParcel) {
        versionedParcel.setSerializationFlags(false, false);
        AudioAttributes audioAttributes = audioAttributesImplApi21.mAudioAttributes;
        versionedParcel.writeParcelable((Parcelable)audioAttributes, 1);
        int n10 = audioAttributesImplApi21.mLegacyStreamType;
        versionedParcel.writeInt(n10, 2);
    }
}

