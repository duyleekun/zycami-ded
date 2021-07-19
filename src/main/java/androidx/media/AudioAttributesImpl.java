/*
 * Decompiled with CFR 0.151.
 */
package androidx.media;

import androidx.versionedparcelable.VersionedParcelable;

public interface AudioAttributesImpl
extends VersionedParcelable {
    public Object getAudioAttributes();

    public int getContentType();

    public int getFlags();

    public int getLegacyStreamType();

    public int getRawLegacyStreamType();

    public int getUsage();

    public int getVolumeControlStream();
}

