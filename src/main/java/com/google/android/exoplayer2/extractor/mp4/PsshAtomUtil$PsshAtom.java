/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.extractor.mp4;

import java.util.UUID;

public class PsshAtomUtil$PsshAtom {
    private final byte[] schemeData;
    private final UUID uuid;
    private final int version;

    public PsshAtomUtil$PsshAtom(UUID uUID, int n10, byte[] byArray) {
        this.uuid = uUID;
        this.version = n10;
        this.schemeData = byArray;
    }

    public static /* synthetic */ UUID access$000(PsshAtomUtil$PsshAtom psshAtomUtil$PsshAtom) {
        return psshAtomUtil$PsshAtom.uuid;
    }

    public static /* synthetic */ int access$100(PsshAtomUtil$PsshAtom psshAtomUtil$PsshAtom) {
        return psshAtomUtil$PsshAtom.version;
    }

    public static /* synthetic */ byte[] access$200(PsshAtomUtil$PsshAtom psshAtomUtil$PsshAtom) {
        return psshAtomUtil$PsshAtom.schemeData;
    }
}

