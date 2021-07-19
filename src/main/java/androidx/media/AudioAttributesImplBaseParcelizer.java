/*
 * Decompiled with CFR 0.151.
 */
package androidx.media;

import androidx.media.AudioAttributesImplBase;
import androidx.versionedparcelable.VersionedParcel;

public class AudioAttributesImplBaseParcelizer {
    public static AudioAttributesImplBase read(VersionedParcel versionedParcel) {
        int n10;
        AudioAttributesImplBase audioAttributesImplBase = new AudioAttributesImplBase();
        int n11 = audioAttributesImplBase.mUsage;
        audioAttributesImplBase.mUsage = n11 = versionedParcel.readInt(n11, 1);
        n11 = audioAttributesImplBase.mContentType;
        audioAttributesImplBase.mContentType = n11 = versionedParcel.readInt(n11, 2);
        n11 = audioAttributesImplBase.mFlags;
        audioAttributesImplBase.mFlags = n11 = versionedParcel.readInt(n11, 3);
        n11 = audioAttributesImplBase.mLegacyStream;
        audioAttributesImplBase.mLegacyStream = n10 = versionedParcel.readInt(n11, 4);
        return audioAttributesImplBase;
    }

    public static void write(AudioAttributesImplBase audioAttributesImplBase, VersionedParcel versionedParcel) {
        versionedParcel.setSerializationFlags(false, false);
        int n10 = audioAttributesImplBase.mUsage;
        versionedParcel.writeInt(n10, 1);
        n10 = audioAttributesImplBase.mContentType;
        versionedParcel.writeInt(n10, 2);
        n10 = audioAttributesImplBase.mFlags;
        versionedParcel.writeInt(n10, 3);
        int n11 = audioAttributesImplBase.mLegacyStream;
        versionedParcel.writeInt(n11, 4);
    }
}

