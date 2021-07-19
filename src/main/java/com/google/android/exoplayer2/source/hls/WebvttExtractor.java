/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package com.google.android.exoplayer2.source.hls;

import android.text.TextUtils;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.Format$Builder;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap$Unseekable;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.text.webvtt.WebvttParserUtil;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class WebvttExtractor
implements Extractor {
    private static final int HEADER_MAX_LENGTH = 9;
    private static final int HEADER_MIN_LENGTH = 6;
    private static final Pattern LOCAL_TIMESTAMP = Pattern.compile("LOCAL:([^,]+)");
    private static final Pattern MEDIA_TIMESTAMP = Pattern.compile("MPEGTS:(-?\\d+)");
    private final String language;
    private ExtractorOutput output;
    private byte[] sampleData;
    private final ParsableByteArray sampleDataWrapper;
    private int sampleSize;
    private final TimestampAdjuster timestampAdjuster;

    public WebvttExtractor(String object, TimestampAdjuster timestampAdjuster) {
        this.language = object;
        this.timestampAdjuster = timestampAdjuster;
        this.sampleDataWrapper = object = new ParsableByteArray();
        object = new byte[1024];
        this.sampleData = (byte[])object;
    }

    private TrackOutput buildTrackOutput(long l10) {
        TrackOutput trackOutput = this.output.track(0, 3);
        Format$Builder format$Builder = new Format$Builder();
        format$Builder = format$Builder.setSampleMimeType("text/vtt");
        String string2 = this.language;
        Format format = format$Builder.setLanguage(string2).setSubsampleOffsetUs(l10).build();
        trackOutput.format(format);
        this.output.endTracks();
        return trackOutput;
    }

    private void processSample() {
        Object object;
        int n10;
        long l10;
        Object object2 = this.sampleData;
        Object object3 = new ParsableByteArray((byte[])object2);
        WebvttParserUtil.validateWebvttHeaderLine((ParsableByteArray)object3);
        object2 = ((ParsableByteArray)object3).readLine();
        long l11 = l10 = 0L;
        long l12 = l10;
        while (true) {
            boolean bl2 = TextUtils.isEmpty((CharSequence)object2);
            n10 = 1;
            if (bl2) break;
            String string2 = "X-TIMESTAMP-MAP";
            bl2 = ((String)object2).startsWith(string2);
            if (bl2) {
                Matcher matcher = LOCAL_TIMESTAMP.matcher((CharSequence)object2);
                boolean bl3 = matcher.find();
                if (!bl3) {
                    String string3 = "X-TIMESTAMP-MAP doesn't contain local timestamp: ";
                    int n11 = ((String)(object2 = String.valueOf(object2))).length();
                    object2 = n11 != 0 ? string3.concat((String)object2) : new String(string3);
                    object3 = new ParserException((String)object2);
                    throw object3;
                }
                object = MEDIA_TIMESTAMP.matcher((CharSequence)object2);
                boolean bl4 = ((Matcher)object).find();
                if (!bl4) {
                    String string4 = "X-TIMESTAMP-MAP doesn't contain media timestamp: ";
                    int n12 = ((String)(object2 = String.valueOf(object2))).length();
                    object2 = n12 != 0 ? (Object)string4.concat((String)object2) : new String(string4);
                    object3 = new ParserException((String)object2);
                    throw object3;
                }
                l12 = WebvttParserUtil.parseTimestampUs((String)Assertions.checkNotNull(matcher.group(n10)));
                object2 = (String)Assertions.checkNotNull(((Matcher)object).group(n10));
                l11 = TimestampAdjuster.ptsToUs(Long.parseLong((String)object2));
            }
            object2 = ((ParsableByteArray)object3).readLine();
        }
        if ((object3 = WebvttParserUtil.findNextCueHeader((ParsableByteArray)object3)) == null) {
            this.buildTrackOutput(l10);
            return;
        }
        long l13 = WebvttParserUtil.parseTimestampUs((String)Assertions.checkNotNull(((Matcher)object3).group(n10)));
        TimestampAdjuster timestampAdjuster = this.timestampAdjuster;
        long l14 = TimestampAdjuster.usToWrappedPts(l11 + l13 - l12);
        l12 = timestampAdjuster.adjustTsTimestamp(l14);
        l13 = l12 - l13;
        object = this.buildTrackOutput(l13);
        object3 = this.sampleDataWrapper;
        object2 = this.sampleData;
        int n13 = this.sampleSize;
        ((ParsableByteArray)object3).reset((byte[])object2, n13);
        object3 = this.sampleDataWrapper;
        int n14 = this.sampleSize;
        object.sampleData((ParsableByteArray)object3, n14);
        n10 = this.sampleSize;
        object.sampleMetadata(l12, 1, n10, 0, null);
    }

    public void init(ExtractorOutput extractorOutput) {
        this.output = extractorOutput;
        SeekMap$Unseekable seekMap$Unseekable = new SeekMap$Unseekable(-9223372036854775807L);
        extractorOutput.seekMap(seekMap$Unseekable);
    }

    public int read(ExtractorInput extractorInput, PositionHolder object) {
        int n10;
        int n11;
        byte[] byArray;
        object = this.output;
        Assertions.checkNotNull(object);
        long l10 = extractorInput.getLength();
        int n12 = (int)l10;
        int n13 = this.sampleSize;
        byte[] byArray2 = this.sampleData;
        int n14 = byArray2.length;
        int n15 = -1;
        if (n13 == n14) {
            n13 = n12 != n15 ? n12 : byArray2.length;
            n13 = n13 * 3 / 2;
            this.sampleData = byArray = Arrays.copyOf(byArray2, n13);
        }
        if ((n11 = extractorInput.read(byArray = this.sampleData, n10 = this.sampleSize, n14 = byArray.length - n10)) != n15) {
            this.sampleSize = n13 = this.sampleSize + n11;
            if (n12 == n15 || n13 != n12) {
                return 0;
            }
        }
        this.processSample();
        return n15;
    }

    public void release() {
    }

    public void seek(long l10, long l11) {
        IllegalStateException illegalStateException = new IllegalStateException();
        throw illegalStateException;
    }

    public boolean sniff(ExtractorInput object) {
        Object object2 = this.sampleData;
        int n10 = 6;
        object.peekFully((byte[])object2, 0, n10, false);
        object2 = this.sampleDataWrapper;
        byte[] byArray = this.sampleData;
        object2.reset(byArray, n10);
        object2 = this.sampleDataWrapper;
        boolean bl2 = WebvttParserUtil.isWebvttHeaderLine((ParsableByteArray)object2);
        if (bl2) {
            return true;
        }
        object2 = this.sampleData;
        object.peekFully((byte[])object2, n10, 3, false);
        object = this.sampleDataWrapper;
        object2 = this.sampleData;
        ((ParsableByteArray)object).reset((byte[])object2, 9);
        return WebvttParserUtil.isWebvttHeaderLine(this.sampleDataWrapper);
    }
}

