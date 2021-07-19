/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.source.smoothstreaming.manifest;

import com.google.android.exoplayer2.extractor.mp4.TrackEncryptionBox;
import java.util.UUID;

public class SsManifest$ProtectionElement {
    public final byte[] data;
    public final TrackEncryptionBox[] trackEncryptionBoxes;
    public final UUID uuid;

    public SsManifest$ProtectionElement(UUID uUID, byte[] byArray, TrackEncryptionBox[] trackEncryptionBoxArray) {
        this.uuid = uUID;
        this.data = byArray;
        this.trackEncryptionBoxes = trackEncryptionBoxArray;
    }
}

