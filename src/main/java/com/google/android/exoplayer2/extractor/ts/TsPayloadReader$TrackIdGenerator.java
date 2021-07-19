/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.extractor.ts;

public final class TsPayloadReader$TrackIdGenerator {
    private static final int ID_UNSET = Integer.MIN_VALUE;
    private final int firstTrackId;
    private String formatId;
    private final String formatIdPrefix;
    private int trackId;
    private final int trackIdIncrement;

    public TsPayloadReader$TrackIdGenerator(int n10, int n11) {
        this(-1 << -1, n10, n11);
    }

    public TsPayloadReader$TrackIdGenerator(int n10, int n11, int n12) {
        String string2;
        String string3 = "";
        int n13 = -1 << -1;
        if (n10 != n13) {
            int n14 = 12;
            StringBuilder stringBuilder = new StringBuilder(n14);
            stringBuilder.append(n10);
            stringBuilder.append("/");
            string2 = stringBuilder.toString();
        } else {
            string2 = string3;
        }
        this.formatIdPrefix = string2;
        this.firstTrackId = n11;
        this.trackIdIncrement = n12;
        this.trackId = n13;
        this.formatId = string3;
    }

    private void maybeThrowUninitializedError() {
        int n10 = this.trackId;
        int n11 = -1 << -1;
        if (n10 != n11) {
            return;
        }
        IllegalStateException illegalStateException = new IllegalStateException("generateNewId() must be called before retrieving ids.");
        throw illegalStateException;
    }

    public void generateNewId() {
        String string2;
        int n10 = this.trackId;
        int n11 = -1 << -1;
        if (n10 == n11) {
            n10 = this.firstTrackId;
        } else {
            n11 = this.trackIdIncrement;
            n10 += n11;
        }
        this.trackId = n10;
        String string3 = this.formatIdPrefix;
        int n12 = String.valueOf(string3).length() + 11;
        StringBuilder stringBuilder = new StringBuilder(n12);
        stringBuilder.append(string3);
        stringBuilder.append(n10);
        this.formatId = string2 = stringBuilder.toString();
    }

    public String getFormatId() {
        this.maybeThrowUninitializedError();
        return this.formatId;
    }

    public int getTrackId() {
        this.maybeThrowUninitializedError();
        return this.trackId;
    }
}

