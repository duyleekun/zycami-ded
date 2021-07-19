/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  android.text.TextUtils
 */
package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import android.text.TextUtils;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.Format$Builder;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.mp3.Mp3Extractor;
import com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor;
import com.google.android.exoplayer2.extractor.ts.Ac3Extractor;
import com.google.android.exoplayer2.extractor.ts.Ac4Extractor;
import com.google.android.exoplayer2.extractor.ts.AdtsExtractor;
import com.google.android.exoplayer2.extractor.ts.DefaultTsPayloadReaderFactory;
import com.google.android.exoplayer2.extractor.ts.TsExtractor;
import com.google.android.exoplayer2.extractor.ts.TsPayloadReader$Factory;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.Metadata$Entry;
import com.google.android.exoplayer2.source.hls.BundledHlsMediaChunkExtractor;
import com.google.android.exoplayer2.source.hls.HlsExtractorFactory;
import com.google.android.exoplayer2.source.hls.HlsTrackMetadataEntry;
import com.google.android.exoplayer2.source.hls.WebvttExtractor;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.FileTypes;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import java.io.EOFException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class DefaultHlsExtractorFactory
implements HlsExtractorFactory {
    private static final int[] DEFAULT_EXTRACTOR_ORDER;
    private final boolean exposeCea608WhenMissingDeclarations;
    private final int payloadReaderFactoryFlags;

    static {
        int[] nArray;
        int[] nArray2 = nArray = new int[7];
        int[] nArray3 = nArray;
        nArray2[0] = 8;
        nArray3[1] = 13;
        nArray2[2] = 11;
        nArray3[3] = 2;
        nArray2[4] = 0;
        nArray3[5] = 1;
        nArray3[6] = 7;
        DEFAULT_EXTRACTOR_ORDER = nArray;
    }

    public DefaultHlsExtractorFactory() {
        this(0, true);
    }

    public DefaultHlsExtractorFactory(int n10, boolean bl2) {
        this.payloadReaderFactoryFlags = n10;
        this.exposeCea608WhenMissingDeclarations = bl2;
    }

    private static void addFileTypeIfNotPresent(int n10, List list) {
        Integer n11;
        int n12 = -1;
        if (n10 != n12 && (n12 = (int)(list.contains(n11 = Integer.valueOf(n10)) ? 1 : 0)) == 0) {
            Integer n13 = n10;
            list.add(n13);
        }
    }

    private Extractor createExtractorByFileType(int n10, Format object, List list, TimestampAdjuster timestampAdjuster) {
        if (n10 != 0) {
            int n11 = 1;
            if (n10 != n11) {
                n11 = 2;
                if (n10 != n11) {
                    n11 = 7;
                    if (n10 != n11) {
                        n11 = 8;
                        if (n10 != n11) {
                            n11 = 11;
                            if (n10 != n11) {
                                int n12 = 13;
                                if (n10 != n12) {
                                    return null;
                                }
                                object = ((Format)object).language;
                                WebvttExtractor webvttExtractor = new WebvttExtractor((String)object, timestampAdjuster);
                                return webvttExtractor;
                            }
                            n10 = this.payloadReaderFactoryFlags;
                            n11 = (int)(this.exposeCea608WhenMissingDeclarations ? 1 : 0);
                            return DefaultHlsExtractorFactory.createTsExtractor(n10, n11 != 0, (Format)object, list, timestampAdjuster);
                        }
                        return DefaultHlsExtractorFactory.createFragmentedMp4Extractor(timestampAdjuster, (Format)object, list);
                    }
                    Mp3Extractor mp3Extractor = new Mp3Extractor(0, 0L);
                    return mp3Extractor;
                }
                AdtsExtractor adtsExtractor = new AdtsExtractor();
                return adtsExtractor;
            }
            Ac4Extractor ac4Extractor = new Ac4Extractor();
            return ac4Extractor;
        }
        Ac3Extractor ac3Extractor = new Ac3Extractor();
        return ac3Extractor;
    }

    private static FragmentedMp4Extractor createFragmentedMp4Extractor(TimestampAdjuster timestampAdjuster, Format format, List list) {
        int n10 = DefaultHlsExtractorFactory.isFmp4Variant(format);
        if (n10 != 0) {
            n10 = 4;
        } else {
            n10 = 0;
            format = null;
        }
        if (list == null) {
            list = Collections.emptyList();
        }
        FragmentedMp4Extractor fragmentedMp4Extractor = new FragmentedMp4Extractor(n10, timestampAdjuster, null, list);
        return fragmentedMp4Extractor;
    }

    private static TsExtractor createTsExtractor(int n10, boolean bl2, Format object, List list, TimestampAdjuster timestampAdjuster) {
        Object object2;
        n10 |= 0x10;
        if (list != null) {
            n10 |= 0x20;
        } else if (bl2) {
            object2 = new Format$Builder();
            object2 = ((Format$Builder)object2).setSampleMimeType("application/cea-608").build();
            list = Collections.singletonList(object2);
        } else {
            list = Collections.emptyList();
        }
        object2 = ((Format)object).codecs;
        boolean bl3 = TextUtils.isEmpty((CharSequence)object2);
        if (!bl3) {
            object = "audio/mp4a-latm";
            bl3 = MimeTypes.containsCodecsCorrespondingToMimeType((String)object2, (String)object);
            if (!bl3) {
                n10 |= 2;
            }
            if (!(bl2 = MimeTypes.containsCodecsCorrespondingToMimeType((String)object2, (String)(object = "video/avc")))) {
                n10 |= 4;
            }
        }
        object = new DefaultTsPayloadReaderFactory(n10, list);
        object2 = new TsExtractor(2, timestampAdjuster, (TsPayloadReader$Factory)object);
        return object2;
    }

    private static boolean isFmp4Variant(Format object) {
        int n10;
        object = ((Format)object).metadata;
        if (object == null) {
            return false;
        }
        for (int i10 = 0; i10 < (n10 = ((Metadata)object).length()); ++i10) {
            Metadata$Entry metadata$Entry = ((Metadata)object).get(i10);
            boolean bl2 = metadata$Entry instanceof HlsTrackMetadataEntry;
            if (!bl2) continue;
            return ((HlsTrackMetadataEntry)metadata$Entry).variantInfos.isEmpty() ^ true;
        }
        return false;
    }

    private static boolean sniffQuietly(Extractor extractor, ExtractorInput extractorInput) {
        boolean bl2;
        try {
            bl2 = extractor.sniff(extractorInput);
            extractorInput.resetPeekPosition();
        }
        catch (Throwable throwable) {
            extractorInput.resetPeekPosition();
            throw throwable;
        }
        catch (EOFException eOFException) {
            extractorInput.resetPeekPosition();
            bl2 = false;
            extractor = null;
        }
        return bl2;
    }

    public BundledHlsMediaChunkExtractor createExtractor(Uri object, Format format, List object2, TimestampAdjuster timestampAdjuster, Map map, ExtractorInput extractorInput) {
        int n10 = FileTypes.inferFileTypeFromMimeType(format.sampleMimeType);
        int n11 = FileTypes.inferFileTypeFromResponseHeaders(map);
        int n12 = FileTypes.inferFileTypeFromUri(object);
        Object object3 = DEFAULT_EXTRACTOR_ORDER;
        int n13 = ((int[])object3).length;
        ArrayList arrayList = new ArrayList(n13);
        DefaultHlsExtractorFactory.addFileTypeIfNotPresent(n10, arrayList);
        DefaultHlsExtractorFactory.addFileTypeIfNotPresent(n11, arrayList);
        DefaultHlsExtractorFactory.addFileTypeIfNotPresent(n12, arrayList);
        n12 = ((int[])object3).length;
        n11 = 0;
        map = null;
        Integer n14 = null;
        for (n10 = 0; n10 < n12; ++n10) {
            n13 = object3[n10];
            DefaultHlsExtractorFactory.addFileTypeIfNotPresent(n13, arrayList);
        }
        n12 = 0;
        object = null;
        extractorInput.resetPeekPosition();
        while (n11 < (n10 = arrayList.size())) {
            n14 = (Integer)arrayList.get(n11);
            n10 = n14;
            object3 = (Extractor)Assertions.checkNotNull(this.createExtractorByFileType(n10, format, (List)object2, timestampAdjuster));
            n13 = (int)(DefaultHlsExtractorFactory.sniffQuietly((Extractor)object3, extractorInput) ? 1 : 0);
            if (n13 != 0) {
                object = new BundledHlsMediaChunkExtractor((Extractor)object3, format, timestampAdjuster);
                return object;
            }
            n13 = 11;
            if (n10 == n13) {
                object = object3;
            }
            ++n11;
        }
        object = (Extractor)Assertions.checkNotNull(object);
        object2 = new BundledHlsMediaChunkExtractor((Extractor)object, format, timestampAdjuster);
        return object2;
    }
}

