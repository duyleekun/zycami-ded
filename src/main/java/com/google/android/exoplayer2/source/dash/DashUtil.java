/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 */
package com.google.android.exoplayer2.source.dash;

import android.net.Uri;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.ChunkIndex;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor;
import com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor;
import com.google.android.exoplayer2.source.chunk.BundledChunkExtractor;
import com.google.android.exoplayer2.source.chunk.ChunkExtractor;
import com.google.android.exoplayer2.source.chunk.InitializationChunk;
import com.google.android.exoplayer2.source.dash.manifest.AdaptationSet;
import com.google.android.exoplayer2.source.dash.manifest.DashManifest;
import com.google.android.exoplayer2.source.dash.manifest.DashManifestParser;
import com.google.android.exoplayer2.source.dash.manifest.Period;
import com.google.android.exoplayer2.source.dash.manifest.RangedUri;
import com.google.android.exoplayer2.source.dash.manifest.Representation;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.DataSpec$Builder;
import com.google.android.exoplayer2.upstream.ParsingLoadable;
import com.google.android.exoplayer2.upstream.ParsingLoadable$Parser;
import com.google.android.exoplayer2.util.Assertions;

public final class DashUtil {
    private DashUtil() {
    }

    public static DataSpec buildDataSpec(Representation object, RangedUri object2, int n10) {
        DataSpec$Builder dataSpec$Builder = new DataSpec$Builder();
        String string2 = ((Representation)object).baseUrl;
        string2 = ((RangedUri)object2).resolveUri(string2);
        dataSpec$Builder = dataSpec$Builder.setUri((Uri)string2);
        long l10 = ((RangedUri)object2).start;
        dataSpec$Builder = dataSpec$Builder.setPosition(l10);
        l10 = ((RangedUri)object2).length;
        object2 = dataSpec$Builder.setLength(l10);
        object = ((Representation)object).getCacheKey();
        return ((DataSpec$Builder)object2).setKey((String)object).setFlags(n10).build();
    }

    private static Representation getFirstRepresentation(Period object, int n10) {
        n10 = ((Period)object).getAdaptationSetIndex(n10);
        Object object2 = null;
        int n11 = -1;
        if (n10 == n11) {
            return null;
        }
        object = ((AdaptationSet)object.adaptationSets.get((int)n10)).representations;
        n10 = (int)(object.isEmpty() ? 1 : 0);
        if (n10 == 0) {
            n10 = 0;
            object2 = object = object.get(0);
            object2 = (Representation)object;
        }
        return object2;
    }

    public static ChunkIndex loadChunkIndex(DataSource dataSource, int n10, Representation representation) {
        Object object = representation.getInitializationUri();
        if (object == null) {
            return null;
        }
        object = representation.format;
        ChunkExtractor chunkExtractor = DashUtil.newChunkExtractor(n10, (Format)object);
        boolean bl2 = true;
        try {
            DashUtil.loadInitializationData(chunkExtractor, dataSource, representation, bl2);
            return chunkExtractor.getChunkIndex();
        }
        finally {
            chunkExtractor.release();
        }
    }

    public static Format loadFormatWithDrmInitData(DataSource object, Period object2) {
        int n10 = 2;
        Representation representation = DashUtil.getFirstRepresentation((Period)object2, n10);
        if (representation == null && (representation = DashUtil.getFirstRepresentation((Period)object2, n10 = 1)) == null) {
            return null;
        }
        object2 = representation.format;
        if ((object = DashUtil.loadSampleFormat((DataSource)object, n10, representation)) != null) {
            object2 = ((Format)object).withManifestFormatInfo((Format)object2);
        }
        return object2;
    }

    private static void loadInitializationData(ChunkExtractor chunkExtractor, DataSource dataSource, Representation representation, boolean bl2) {
        Object object = (RangedUri)Assertions.checkNotNull(representation.getInitializationUri());
        if (bl2) {
            RangedUri rangedUri = representation.getIndexUri();
            if (rangedUri == null) {
                return;
            }
            Object object2 = representation.baseUrl;
            if ((object2 = ((RangedUri)object).attemptMerge(rangedUri, (String)object2)) == null) {
                DashUtil.loadInitializationData(dataSource, representation, chunkExtractor, (RangedUri)object);
                object = rangedUri;
            } else {
                object = object2;
            }
        }
        DashUtil.loadInitializationData(dataSource, representation, chunkExtractor, (RangedUri)object);
    }

    private static void loadInitializationData(DataSource dataSource, Representation representation, ChunkExtractor chunkExtractor, RangedUri object) {
        DataSpec dataSpec = DashUtil.buildDataSpec(representation, (RangedUri)object, 0);
        Format format = representation.format;
        object = new InitializationChunk(dataSource, dataSpec, format, 0, null, chunkExtractor);
        ((InitializationChunk)object).load();
    }

    public static DashManifest loadManifest(DataSource dataSource, Uri uri) {
        DashManifestParser dashManifestParser = new DashManifestParser();
        return (DashManifest)ParsingLoadable.load(dataSource, (ParsingLoadable$Parser)dashManifestParser, uri, 4);
    }

    public static Format loadSampleFormat(DataSource dataSource, int n10, Representation representation) {
        Object object = representation.getInitializationUri();
        if (object == null) {
            return null;
        }
        object = representation.format;
        ChunkExtractor chunkExtractor = DashUtil.newChunkExtractor(n10, (Format)object);
        object = null;
        try {
            DashUtil.loadInitializationData(chunkExtractor, dataSource, representation, false);
            return ((Format[])Assertions.checkStateNotNull(chunkExtractor.getSampleFormats()))[0];
        }
        finally {
            chunkExtractor.release();
        }
    }

    private static ChunkExtractor newChunkExtractor(int n10, Format format) {
        boolean bl2;
        Object object;
        boolean bl3;
        Object object2 = format.containerMimeType;
        if (object2 != null && ((bl3 = ((String)object2).startsWith((String)(object = "video/webm"))) || (bl2 = ((String)object2).startsWith((String)(object = "audio/webm"))))) {
            bl2 = true;
        } else {
            bl2 = false;
            object2 = null;
        }
        object2 = bl2 ? new MatroskaExtractor() : new FragmentedMp4Extractor();
        object = new BundledChunkExtractor((Extractor)object2, n10, format);
        return object;
    }
}

