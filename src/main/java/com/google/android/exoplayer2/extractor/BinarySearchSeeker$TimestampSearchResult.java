/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.extractor;

public final class BinarySearchSeeker$TimestampSearchResult {
    public static final BinarySearchSeeker$TimestampSearchResult NO_TIMESTAMP_IN_RANGE_RESULT;
    public static final int TYPE_NO_TIMESTAMP = 253;
    public static final int TYPE_POSITION_OVERESTIMATED = 255;
    public static final int TYPE_POSITION_UNDERESTIMATED = 254;
    public static final int TYPE_TARGET_TIMESTAMP_FOUND;
    private final long bytePositionToUpdate;
    private final long timestampToUpdate;
    private final int type;

    static {
        BinarySearchSeeker$TimestampSearchResult binarySearchSeeker$TimestampSearchResult;
        NO_TIMESTAMP_IN_RANGE_RESULT = binarySearchSeeker$TimestampSearchResult = new BinarySearchSeeker$TimestampSearchResult(-3, -9223372036854775807L, -1);
    }

    private BinarySearchSeeker$TimestampSearchResult(int n10, long l10, long l11) {
        this.type = n10;
        this.timestampToUpdate = l10;
        this.bytePositionToUpdate = l11;
    }

    public static /* synthetic */ int access$500(BinarySearchSeeker$TimestampSearchResult binarySearchSeeker$TimestampSearchResult) {
        return binarySearchSeeker$TimestampSearchResult.type;
    }

    public static /* synthetic */ long access$600(BinarySearchSeeker$TimestampSearchResult binarySearchSeeker$TimestampSearchResult) {
        return binarySearchSeeker$TimestampSearchResult.timestampToUpdate;
    }

    public static /* synthetic */ long access$700(BinarySearchSeeker$TimestampSearchResult binarySearchSeeker$TimestampSearchResult) {
        return binarySearchSeeker$TimestampSearchResult.bytePositionToUpdate;
    }

    public static BinarySearchSeeker$TimestampSearchResult overestimatedResult(long l10, long l11) {
        BinarySearchSeeker$TimestampSearchResult binarySearchSeeker$TimestampSearchResult = new BinarySearchSeeker$TimestampSearchResult(-1, l10, l11);
        return binarySearchSeeker$TimestampSearchResult;
    }

    public static BinarySearchSeeker$TimestampSearchResult targetFoundResult(long l10) {
        BinarySearchSeeker$TimestampSearchResult binarySearchSeeker$TimestampSearchResult = new BinarySearchSeeker$TimestampSearchResult(0, -9223372036854775807L, l10);
        return binarySearchSeeker$TimestampSearchResult;
    }

    public static BinarySearchSeeker$TimestampSearchResult underestimatedResult(long l10, long l11) {
        BinarySearchSeeker$TimestampSearchResult binarySearchSeeker$TimestampSearchResult = new BinarySearchSeeker$TimestampSearchResult(-2, l10, l11);
        return binarySearchSeeker$TimestampSearchResult;
    }
}

