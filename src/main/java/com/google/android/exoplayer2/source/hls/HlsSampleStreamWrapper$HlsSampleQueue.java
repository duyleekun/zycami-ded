/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Looper
 */
package com.google.android.exoplayer2.source.hls;

import android.os.Looper;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.DrmSessionEventListener$EventDispatcher;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.extractor.TrackOutput$CryptoData;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.Metadata$Entry;
import com.google.android.exoplayer2.metadata.id3.PrivFrame;
import com.google.android.exoplayer2.source.SampleQueue;
import com.google.android.exoplayer2.source.hls.HlsMediaChunk;
import com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper$1;
import com.google.android.exoplayer2.upstream.Allocator;
import java.util.Map;

public final class HlsSampleStreamWrapper$HlsSampleQueue
extends SampleQueue {
    private DrmInitData drmInitData;
    private final Map overridingDrmInitData;

    private HlsSampleStreamWrapper$HlsSampleQueue(Allocator allocator, Looper looper, DrmSessionManager drmSessionManager, DrmSessionEventListener$EventDispatcher drmSessionEventListener$EventDispatcher, Map map) {
        super(allocator, looper, drmSessionManager, drmSessionEventListener$EventDispatcher);
        this.overridingDrmInitData = map;
    }

    public /* synthetic */ HlsSampleStreamWrapper$HlsSampleQueue(Allocator allocator, Looper looper, DrmSessionManager drmSessionManager, DrmSessionEventListener$EventDispatcher drmSessionEventListener$EventDispatcher, Map map, HlsSampleStreamWrapper$1 hlsSampleStreamWrapper$1) {
        this(allocator, looper, drmSessionManager, drmSessionEventListener$EventDispatcher, map);
    }

    private Metadata getAdjustedMetadata(Metadata metadata) {
        Object object;
        int n10;
        int n11;
        int n12;
        int n13;
        Metadata$Entry[] metadata$EntryArray;
        int n14;
        block7: {
            n14 = 0;
            metadata$EntryArray = null;
            if (metadata == null) {
                return null;
            }
            n13 = metadata.length();
            n12 = 0;
            n11 = 0;
            while (true) {
                String string2;
                boolean bl2;
                n10 = -1;
                if (n11 >= n13) break;
                object = metadata.get(n11);
                boolean bl3 = object instanceof PrivFrame;
                if (!bl3 || !(bl2 = (string2 = "com.apple.streaming.transportStreamTimestamp").equals(object = ((PrivFrame)object).owner))) {
                    ++n11;
                    continue;
                }
                break block7;
                break;
            }
            n11 = n10;
        }
        if (n11 == n10) {
            return metadata;
        }
        n10 = 1;
        if (n13 == n10) {
            return null;
        }
        n14 = n13 + -1;
        metadata$EntryArray = new Metadata$Entry[n14];
        while (n12 < n13) {
            if (n12 != n11) {
                n10 = n12 < n11 ? n12 : n12 + -1;
                metadata$EntryArray[n10] = object = metadata.get(n12);
            }
            ++n12;
        }
        metadata = new Metadata(metadata$EntryArray);
        return metadata;
    }

    public Format getAdjustedUpstreamFormat(Format format) {
        Object object;
        Object object2;
        Object object3 = this.drmInitData;
        if (object3 == null) {
            object3 = format.drmInitData;
        }
        if (object3 != null) {
            object2 = this.overridingDrmInitData;
            object = ((DrmInitData)object3).schemeType;
            if ((object2 = (DrmInitData)object2.get(object)) != null) {
                object3 = object2;
            }
        }
        object2 = format.metadata;
        object2 = this.getAdjustedMetadata((Metadata)object2);
        object = format.drmInitData;
        if (object3 != object || object2 != (object = format.metadata)) {
            format = format.buildUpon().setDrmInitData((DrmInitData)object3).setMetadata((Metadata)object2).build();
        }
        return super.getAdjustedUpstreamFormat(format);
    }

    public void sampleMetadata(long l10, int n10, int n11, int n12, TrackOutput$CryptoData trackOutput$CryptoData) {
        super.sampleMetadata(l10, n10, n11, n12, trackOutput$CryptoData);
    }

    public void setDrmInitData(DrmInitData drmInitData) {
        this.drmInitData = drmInitData;
        this.invalidateUpstreamFormatAdjustment();
    }

    public void setSourceChunk(HlsMediaChunk hlsMediaChunk) {
        int n10 = hlsMediaChunk.uid;
        this.sourceId(n10);
    }
}

