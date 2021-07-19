/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.extractor.ogg;

import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ogg.DefaultOggSeeker$OggSeekMap;
import com.google.android.exoplayer2.extractor.ogg.OggPageHeader;
import com.google.android.exoplayer2.extractor.ogg.OggSeeker;
import com.google.android.exoplayer2.extractor.ogg.StreamReader;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.io.EOFException;
import java.io.IOException;

public final class DefaultOggSeeker
implements OggSeeker {
    private static final int DEFAULT_OFFSET = 30000;
    private static final int MATCH_BYTE_RANGE = 100000;
    private static final int MATCH_RANGE = 72000;
    private static final int STATE_IDLE = 4;
    private static final int STATE_READ_LAST_PAGE = 1;
    private static final int STATE_SEEK = 2;
    private static final int STATE_SEEK_TO_END = 0;
    private static final int STATE_SKIP = 3;
    private long end;
    private long endGranule;
    private final OggPageHeader pageHeader;
    private final long payloadEndPosition;
    private final long payloadStartPosition;
    private long positionBeforeSeekToEnd;
    private long start;
    private long startGranule;
    private int state;
    private final StreamReader streamReader;
    private long targetGranule;
    private long totalGranules;

    public DefaultOggSeeker(StreamReader object, long l10, long l11, long l12, long l13, boolean bl2) {
        long l14 = 0L;
        long l15 = l10 == l14 ? 0 : (l10 < l14 ? -1 : 1);
        l15 = l15 >= 0 && (l15 = l11 == l10 ? 0 : (l11 < l10 ? -1 : 1)) > 0 ? (long)1 : (long)0;
        Assertions.checkArgument((boolean)l15);
        this.streamReader = object;
        this.payloadStartPosition = l10;
        this.payloadEndPosition = l11;
        long l16 = l12 - (l11 -= l10);
        long l17 = l16 == 0L ? 0 : (l16 < 0L ? -1 : 1);
        if (l17 != false && !bl2) {
            this.state = 0;
        } else {
            this.totalGranules = l13;
            l17 = 4;
            this.state = (int)l17;
        }
        this.pageHeader = object = new OggPageHeader();
    }

    public static /* synthetic */ StreamReader access$100(DefaultOggSeeker defaultOggSeeker) {
        return defaultOggSeeker.streamReader;
    }

    public static /* synthetic */ long access$200(DefaultOggSeeker defaultOggSeeker) {
        return defaultOggSeeker.payloadStartPosition;
    }

    public static /* synthetic */ long access$300(DefaultOggSeeker defaultOggSeeker) {
        return defaultOggSeeker.payloadEndPosition;
    }

    public static /* synthetic */ long access$400(DefaultOggSeeker defaultOggSeeker) {
        return defaultOggSeeker.totalGranules;
    }

    private long getNextSeekPosition(ExtractorInput extractorInput) {
        long l10;
        long l11;
        DefaultOggSeeker defaultOggSeeker = this;
        Object object = extractorInput;
        long l12 = this.start;
        long l13 = this.end;
        Object object2 = l12 == l13 ? 0 : (l12 < l13 ? -1 : 1);
        long l14 = -1;
        if (object2 == false) {
            return l14;
        }
        long l15 = extractorInput.getPosition();
        OggPageHeader oggPageHeader = this.pageHeader;
        long l16 = this.end;
        object2 = oggPageHeader.skipToNextPage(extractorInput, l16);
        if (object2 == false) {
            long l17 = this.start;
            long l18 = l17 - l15;
            Object object3 = l18 == 0L ? 0 : (l18 < 0L ? -1 : 1);
            if (object3 != false) {
                return l17;
            }
            object = new IOException("No ogg page can be found.");
            throw object;
        }
        this.pageHeader.populate(extractorInput, false);
        extractorInput.resetPeekPosition();
        l16 = this.targetGranule;
        oggPageHeader = this.pageHeader;
        long l19 = oggPageHeader.granulePosition;
        int n10 = oggPageHeader.headerSize;
        object2 = oggPageHeader.bodySize;
        n10 += object2;
        long l20 = 0L;
        long l21 = l20 - (l16 -= l19);
        object2 = l21 == 0L ? 0 : (l21 < 0L ? -1 : 1);
        if (object2 <= 0 && (object2 = (l11 = l16 - (l10 = 72000L)) == 0L ? 0 : (l11 < 0L ? -1 : 1)) < 0) {
            return l14;
        }
        object2 = l16 == l20 ? 0 : (l16 < l20 ? -1 : 1);
        if (object2 < 0) {
            defaultOggSeeker.end = l15;
            defaultOggSeeker.endGranule = l19;
        } else {
            l14 = extractorInput.getPosition();
            l15 = n10;
            defaultOggSeeker.start = l14 += l15;
            OggPageHeader oggPageHeader2 = defaultOggSeeker.pageHeader;
            defaultOggSeeker.startGranule = l14 = oggPageHeader2.granulePosition;
        }
        l14 = defaultOggSeeker.end;
        l15 = defaultOggSeeker.start;
        l19 = 100000L;
        long l22 = (l14 -= l15) - l19;
        long l23 = l22 == 0L ? 0 : (l22 < 0L ? -1 : 1);
        if (l23 < 0) {
            defaultOggSeeker.end = l15;
            return l15;
        }
        l14 = n10;
        l15 = 1L;
        l19 = object2 <= 0 ? (long)2 : l15;
        long l24 = extractorInput.getPosition() - (l14 *= l19);
        l14 = defaultOggSeeker.end;
        long l25 = defaultOggSeeker.start;
        l19 = l14 - l25;
        l16 *= l19;
        l19 = defaultOggSeeker.endGranule;
        long l26 = defaultOggSeeker.startGranule;
        l19 = l24 + (l16 /= (l19 -= l26));
        l26 = l14 - l15;
        return Util.constrainValue(l19, l25, l26);
    }

    private void skipToPageOfTargetGranule(ExtractorInput extractorInput) {
        while (true) {
            long l10;
            this.pageHeader.skipToNextPage(extractorInput);
            this.pageHeader.populate(extractorInput, false);
            OggPageHeader oggPageHeader = this.pageHeader;
            long l11 = oggPageHeader.granulePosition;
            long l12 = this.targetGranule;
            long l13 = l11 == l12 ? 0 : (l11 < l12 ? -1 : 1);
            if (l13 > 0) {
                extractorInput.resetPeekPosition();
                return;
            }
            l13 = oggPageHeader.headerSize;
            int n10 = oggPageHeader.bodySize;
            extractorInput.skipFully((int)(l13 += n10));
            this.start = l10 = extractorInput.getPosition();
            oggPageHeader = this.pageHeader;
            this.startGranule = l10 = oggPageHeader.granulePosition;
        }
    }

    public DefaultOggSeeker$OggSeekMap createSeekMap() {
        long l10 = this.totalGranules;
        long l11 = 0L;
        long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        DefaultOggSeeker$OggSeekMap defaultOggSeeker$OggSeekMap = null;
        if (l12 != false) {
            DefaultOggSeeker$OggSeekMap defaultOggSeeker$OggSeekMap2;
            defaultOggSeeker$OggSeekMap = defaultOggSeeker$OggSeekMap2 = new DefaultOggSeeker$OggSeekMap(this, null);
        }
        return defaultOggSeeker$OggSeekMap;
    }

    public long read(ExtractorInput object) {
        long l10;
        int n10 = this.state;
        int n11 = 1;
        int n12 = 4;
        if (n10 != 0) {
            if (n10 != n11) {
                n11 = 2;
                long l11 = -1;
                int n13 = 3;
                if (n10 != n11) {
                    if (n10 != n13) {
                        if (n10 == n12) {
                            return l11;
                        }
                        object = new IllegalStateException();
                        throw object;
                    }
                } else {
                    long l12 = this.getNextSeekPosition((ExtractorInput)object);
                    long l13 = l12 - l11;
                    Object object2 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
                    if (object2 != false) {
                        return l12;
                    }
                    this.state = n13;
                }
                this.skipToPageOfTargetGranule((ExtractorInput)object);
                this.state = n12;
                return -(this.startGranule + (long)2);
            }
        } else {
            long l14;
            this.positionBeforeSeekToEnd = l14 = object.getPosition();
            this.state = n11;
            l10 = this.payloadEndPosition;
            long l15 = 65307L;
            long l16 = (l10 -= l15) - l14;
            Object object3 = l16 == 0L ? 0 : (l16 < 0L ? -1 : 1);
            if (object3 > 0) {
                return l10;
            }
        }
        this.totalGranules = l10 = this.readGranuleOfLastPage((ExtractorInput)object);
        this.state = n12;
        return this.positionBeforeSeekToEnd;
    }

    public long readGranuleOfLastPage(ExtractorInput object) {
        this.pageHeader.reset();
        OggPageHeader oggPageHeader = this.pageHeader;
        int n10 = oggPageHeader.skipToNextPage((ExtractorInput)object);
        if (n10 != 0) {
            long l10;
            long l11;
            long l12;
            int n11;
            do {
                this.pageHeader.populate((ExtractorInput)object, false);
                oggPageHeader = this.pageHeader;
                int n12 = oggPageHeader.headerSize;
                n10 = oggPageHeader.bodySize;
                object.skipFully(n12 += n10);
                oggPageHeader = this.pageHeader;
                n12 = oggPageHeader.type;
            } while ((n12 &= (n11 = 4)) != n11 && (n10 = (int)(oggPageHeader.skipToNextPage((ExtractorInput)object) ? 1 : 0)) != 0 && (n10 = (int)((l12 = (l11 = object.getPosition()) - (l10 = this.payloadEndPosition)) == 0L ? 0 : (l12 < 0L ? -1 : 1))) < 0);
            return this.pageHeader.granulePosition;
        }
        object = new EOFException();
        throw object;
    }

    public void startSeek(long l10) {
        long l11 = this.totalGranules - 1L;
        this.targetGranule = l10 = Util.constrainValue(l10, 0L, l11);
        this.state = 2;
        this.start = l10 = this.payloadStartPosition;
        this.end = l10 = this.payloadEndPosition;
        this.startGranule = 0L;
        this.endGranule = l10 = this.totalGranules;
    }
}

