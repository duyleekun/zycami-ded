/*
 * Decompiled with CFR 0.151.
 */
package androidx.media;

import androidx.media.AudioAttributesCompat;
import androidx.media.AudioAttributesImpl;
import androidx.versionedparcelable.VersionedParcel;

public class AudioAttributesCompatParcelizer {
    public static AudioAttributesCompat read(VersionedParcel object) {
        AudioAttributesCompat audioAttributesCompat = new AudioAttributesCompat();
        AudioAttributesImpl audioAttributesImpl = audioAttributesCompat.mImpl;
        audioAttributesCompat.mImpl = object = (AudioAttributesImpl)((VersionedParcel)object).readVersionedParcelable(audioAttributesImpl, 1);
        return audioAttributesCompat;
    }

    public static void write(AudioAttributesCompat versionedParcelable, VersionedParcel versionedParcel) {
        versionedParcel.setSerializationFlags(false, false);
        versionedParcelable = versionedParcelable.mImpl;
        versionedParcel.writeVersionedParcelable(versionedParcelable, 1);
    }
}

