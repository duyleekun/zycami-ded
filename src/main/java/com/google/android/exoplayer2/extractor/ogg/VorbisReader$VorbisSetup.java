/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.extractor.ogg;

import com.google.android.exoplayer2.extractor.VorbisUtil$CommentHeader;
import com.google.android.exoplayer2.extractor.VorbisUtil$Mode;
import com.google.android.exoplayer2.extractor.VorbisUtil$VorbisIdHeader;

public final class VorbisReader$VorbisSetup {
    public final VorbisUtil$CommentHeader commentHeader;
    public final int iLogModes;
    public final VorbisUtil$VorbisIdHeader idHeader;
    public final VorbisUtil$Mode[] modes;
    public final byte[] setupHeaderData;

    public VorbisReader$VorbisSetup(VorbisUtil$VorbisIdHeader vorbisUtil$VorbisIdHeader, VorbisUtil$CommentHeader vorbisUtil$CommentHeader, byte[] byArray, VorbisUtil$Mode[] vorbisUtil$ModeArray, int n10) {
        this.idHeader = vorbisUtil$VorbisIdHeader;
        this.commentHeader = vorbisUtil$CommentHeader;
        this.setupHeaderData = byArray;
        this.modes = vorbisUtil$ModeArray;
        this.iLogModes = n10;
    }
}

