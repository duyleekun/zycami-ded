/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.extractor.mp4;

public final class AtomParsers$TkhdData {
    private final long duration;
    private final int id;
    private final int rotationDegrees;

    public AtomParsers$TkhdData(int n10, long l10, int n11) {
        this.id = n10;
        this.duration = l10;
        this.rotationDegrees = n11;
    }

    public static /* synthetic */ long access$000(AtomParsers$TkhdData atomParsers$TkhdData) {
        return atomParsers$TkhdData.duration;
    }

    public static /* synthetic */ int access$100(AtomParsers$TkhdData atomParsers$TkhdData) {
        return atomParsers$TkhdData.id;
    }

    public static /* synthetic */ int access$200(AtomParsers$TkhdData atomParsers$TkhdData) {
        return atomParsers$TkhdData.rotationDegrees;
    }
}

