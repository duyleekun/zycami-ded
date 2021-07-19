/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.MediaParser
 *  android.media.MediaParser$OutputConsumer
 *  android.media.MediaParser$SeekPoint
 *  android.media.MediaParser$SeekableInputReader
 *  android.net.Uri
 *  android.text.TextUtils
 */
package com.google.android.exoplayer2.source.hls;

import android.media.MediaParser;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.Format$Builder;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.source.hls.BundledHlsMediaChunkExtractor;
import com.google.android.exoplayer2.source.hls.HlsExtractorFactory;
import com.google.android.exoplayer2.source.hls.HlsMediaChunkExtractor;
import com.google.android.exoplayer2.source.hls.MediaParserHlsMediaChunkExtractor$PeekingInputReader;
import com.google.android.exoplayer2.source.hls.WebvttExtractor;
import com.google.android.exoplayer2.source.mediaparser.InputReaderAdapterV30;
import com.google.android.exoplayer2.source.mediaparser.MediaParserUtil;
import com.google.android.exoplayer2.source.mediaparser.OutputConsumerAdapterV30;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.FileTypes;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList$Builder;
import d.h.a.a.m0.o.d;
import java.util.List;
import java.util.Map;

public final class MediaParserHlsMediaChunkExtractor
implements HlsMediaChunkExtractor {
    public static final HlsExtractorFactory FACTORY = d.a;
    private final Format format;
    private final InputReaderAdapterV30 inputReaderAdapter;
    private final MediaParser mediaParser;
    private final ImmutableList muxedCaptionMediaFormats;
    private final OutputConsumerAdapterV30 outputConsumerAdapter;
    private final boolean overrideInBandCaptionDeclarations;
    private int pendingSkipBytes;

    public MediaParserHlsMediaChunkExtractor(MediaParser object, OutputConsumerAdapterV30 outputConsumerAdapterV30, Format format, boolean bl2, ImmutableList immutableList, int n10) {
        this.mediaParser = object;
        this.outputConsumerAdapter = outputConsumerAdapterV30;
        this.overrideInBandCaptionDeclarations = bl2;
        this.muxedCaptionMediaFormats = immutableList;
        this.format = format;
        this.pendingSkipBytes = n10;
        this.inputReaderAdapter = object;
    }

    public static /* synthetic */ HlsMediaChunkExtractor a(Uri uri, Format format, List list, TimestampAdjuster timestampAdjuster, Map map, ExtractorInput extractorInput) {
        String string2;
        int n10;
        int n11;
        Object object = list;
        TimestampAdjuster timestampAdjuster2 = timestampAdjuster;
        Object object2 = format.sampleMimeType;
        int n12 = FileTypes.inferFileTypeFromMimeType((String)object2);
        if (n12 == (n11 = 13)) {
            String string3 = format.language;
            object2 = new WebvttExtractor(string3, timestampAdjuster);
            object = new BundledHlsMediaChunkExtractor((Extractor)object2, format, timestampAdjuster);
            return object;
        }
        n12 = 0;
        object2 = null;
        if (list != null) {
            n11 = 1;
        } else {
            n11 = 0;
            Object var11_12 = null;
        }
        Object object3 = ImmutableList.builder();
        if (object != null) {
            while (n12 < (n10 = list.size())) {
                string2 = MediaParserUtil.toCaptionsMediaFormat((Format)list.get(n12));
                ((ImmutableList$Builder)object3).add(string2);
                n12 += 1;
            }
        } else {
            object2 = new Format$Builder();
            string2 = "application/cea-608";
            object2 = MediaParserUtil.toCaptionsMediaFormat(((Format$Builder)object2).setSampleMimeType(string2).build());
            ((ImmutableList$Builder)object3).add(object2);
        }
        object3 = ((ImmutableList$Builder)object3).build();
        object2 = new OutputConsumerAdapterV30();
        if (object == null) {
            object = ImmutableList.of();
        }
        ((OutputConsumerAdapterV30)object2).setMuxedCaptionFormats((List)object);
        ((OutputConsumerAdapterV30)object2).setTimestampAdjuster(timestampAdjuster);
        object = new String[]{"android.media.mediaparser.FragmentedMp4Parser", "android.media.mediaparser.Ac3Parser", "android.media.mediaparser.Ac4Parser", "android.media.mediaparser.AdtsParser", "android.media.mediaparser.Mp3Parser", "android.media.mediaparser.TsParser"};
        timestampAdjuster2 = MediaParserHlsMediaChunkExtractor.createMediaParserInstance((MediaParser.OutputConsumer)object2, format, n11 != 0, (ImmutableList)object3, object);
        Object object4 = extractorInput;
        object = new MediaParserHlsMediaChunkExtractor$PeekingInputReader(extractorInput, null);
        timestampAdjuster2.advance((MediaParser.SeekableInputReader)object);
        string2 = timestampAdjuster2.getParserName();
        ((OutputConsumerAdapterV30)object2).setSelectedParserName(string2);
        n10 = MediaParserHlsMediaChunkExtractor$PeekingInputReader.access$100((MediaParserHlsMediaChunkExtractor$PeekingInputReader)object);
        object = object4;
        object4 = new MediaParserHlsMediaChunkExtractor((MediaParser)timestampAdjuster2, (OutputConsumerAdapterV30)object2, format, n11 != 0, (ImmutableList)object3, n10);
        return object4;
    }

    private static MediaParser createMediaParserInstance(MediaParser.OutputConsumer outputConsumer, Format object, boolean bl2, ImmutableList object2, String ... object3) {
        int n10 = ((String[])object3).length;
        int n11 = 1;
        if (n10 == n11) {
            n10 = 0;
            object3 = object3[0];
            outputConsumer = MediaParser.createByName((String)object3, (MediaParser.OutputConsumer)outputConsumer);
        } else {
            outputConsumer = MediaParser.create((MediaParser.OutputConsumer)outputConsumer, (String[])object3);
        }
        outputConsumer.setParameter("android.media.mediaParser.exposeCaptionFormats", object2);
        Boolean bl3 = bl2;
        outputConsumer.setParameter("android.media.mediaParser.overrideInBandCaptionDeclarations", (Object)bl3);
        bl3 = Boolean.TRUE;
        outputConsumer.setParameter("android.media.mediaparser.inBandCryptoInfo", (Object)bl3);
        outputConsumer.setParameter("android.media.mediaparser.eagerlyExposeTrackType", (Object)bl3);
        outputConsumer.setParameter("android.media.mediaparser.ignoreTimestampOffset", (Object)bl3);
        outputConsumer.setParameter("android.media.mediaparser.ts.ignoreSpliceInfoStream", (Object)bl3);
        object2 = "android.media.mediaparser.ts.mode";
        object3 = "hls";
        outputConsumer.setParameter((String)object2, object3);
        object = ((Format)object).codecs;
        boolean bl4 = TextUtils.isEmpty((CharSequence)object);
        if (!bl4) {
            boolean bl5;
            object3 = "audio/mp4a-latm";
            object2 = MimeTypes.getAudioMediaMimeType((String)object);
            bl4 = ((String)object3).equals(object2);
            if (!bl4) {
                object2 = "android.media.mediaparser.ts.ignoreAacStream";
                outputConsumer.setParameter((String)object2, (Object)bl3);
            }
            if (!(bl5 = ((String)(object2 = "video/avc")).equals(object = MimeTypes.getVideoMediaMimeType((String)object)))) {
                object = "android.media.mediaparser.ts.ignoreAvcStream";
                outputConsumer.setParameter((String)object, (Object)bl3);
            }
        }
        return outputConsumer;
    }

    public void init(ExtractorOutput extractorOutput) {
        this.outputConsumerAdapter.setExtractorOutput(extractorOutput);
    }

    public boolean isPackedAudioExtractor() {
        boolean bl2;
        String string2 = "android.media.mediaparser.Ac3Parser";
        String string3 = this.mediaParser.getParserName();
        boolean bl3 = string2.equals(string3);
        if (!(bl3 || (bl3 = (string2 = "android.media.mediaparser.Ac4Parser").equals(string3)) || (bl3 = (string2 = "android.media.mediaparser.AdtsParser").equals(string3)) || (bl2 = (string2 = "android.media.mediaparser.Mp3Parser").equals(string3)))) {
            bl2 = false;
            string3 = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    public boolean isReusable() {
        boolean bl2;
        String string2 = "android.media.mediaparser.FragmentedMp4Parser";
        String string3 = this.mediaParser.getParserName();
        boolean bl3 = string2.equals(string3);
        if (!bl3 && !(bl2 = (string2 = "android.media.mediaparser.TsParser").equals(string3))) {
            bl2 = false;
            string3 = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    public void onTruncatedSegmentParsed() {
        MediaParser mediaParser = this.mediaParser;
        MediaParser.SeekPoint seekPoint = MediaParser.SeekPoint.START;
        mediaParser.seek(seekPoint);
    }

    public boolean read(ExtractorInput extractorInput) {
        int n10 = this.pendingSkipBytes;
        extractorInput.skipFully(n10);
        this.pendingSkipBytes = 0;
        InputReaderAdapterV30 inputReaderAdapterV30 = this.inputReaderAdapter;
        long l10 = extractorInput.getLength();
        inputReaderAdapterV30.setDataReader(extractorInput, l10);
        extractorInput = this.mediaParser;
        inputReaderAdapterV30 = this.inputReaderAdapter;
        return extractorInput.advance(inputReaderAdapterV30);
    }

    public HlsMediaChunkExtractor recreate() {
        MediaParserHlsMediaChunkExtractor mediaParserHlsMediaChunkExtractor;
        boolean bl2 = this.isReusable();
        int n10 = 1;
        Assertions.checkState(bl2 ^ n10);
        Object object = this.outputConsumerAdapter;
        Format format = this.format;
        boolean bl3 = this.overrideInBandCaptionDeclarations;
        Object object2 = this.muxedCaptionMediaFormats;
        String[] stringArray = new String[n10];
        Object object3 = this.mediaParser.getParserName();
        stringArray[0] = object3;
        format = MediaParserHlsMediaChunkExtractor.createMediaParserInstance((MediaParser.OutputConsumer)object, format, bl3, (ImmutableList)object2, stringArray);
        OutputConsumerAdapterV30 outputConsumerAdapterV30 = this.outputConsumerAdapter;
        object2 = this.format;
        boolean bl4 = this.overrideInBandCaptionDeclarations;
        object3 = this.muxedCaptionMediaFormats;
        object = mediaParserHlsMediaChunkExtractor;
        mediaParserHlsMediaChunkExtractor = new MediaParserHlsMediaChunkExtractor((MediaParser)format, outputConsumerAdapterV30, (Format)object2, bl4, (ImmutableList)object3, 0);
        return mediaParserHlsMediaChunkExtractor;
    }
}

