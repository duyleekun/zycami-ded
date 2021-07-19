/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Handler$Callback
 *  android.os.Looper
 *  android.os.Message
 */
package com.google.android.exoplayer2.metadata;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.exoplayer2.BaseRenderer;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.RendererCapabilities;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.MetadataDecoder;
import com.google.android.exoplayer2.metadata.MetadataDecoderFactory;
import com.google.android.exoplayer2.metadata.MetadataInputBuffer;
import com.google.android.exoplayer2.metadata.MetadataOutput;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class MetadataRenderer
extends BaseRenderer
implements Handler.Callback {
    private static final int MAX_PENDING_METADATA_COUNT = 5;
    private static final int MSG_INVOKE_RENDERER = 0;
    private static final String TAG = "MetadataRenderer";
    private final MetadataInputBuffer buffer;
    private MetadataDecoder decoder;
    private final MetadataDecoderFactory decoderFactory;
    private boolean inputStreamEnded;
    private final MetadataOutput output;
    private final Handler outputHandler;
    private final Metadata[] pendingMetadata;
    private int pendingMetadataCount;
    private int pendingMetadataIndex;
    private final long[] pendingMetadataTimestamps;
    private long subsampleOffsetUs;

    public MetadataRenderer(MetadataOutput metadataOutput, Looper looper) {
        MetadataDecoderFactory metadataDecoderFactory = MetadataDecoderFactory.DEFAULT;
        this(metadataOutput, looper, metadataDecoderFactory);
    }

    public MetadataRenderer(MetadataOutput object, Looper looper, MetadataDecoderFactory metadataDecoderFactory) {
        int n10 = 5;
        super(n10);
        object = (MetadataOutput)Assertions.checkNotNull(object);
        this.output = object;
        object = looper == null ? null : Util.createHandler(looper, this);
        this.outputHandler = object;
        object = (MetadataDecoderFactory)Assertions.checkNotNull(metadataDecoderFactory);
        this.decoderFactory = object;
        object = new MetadataInputBuffer();
        this.buffer = object;
        object = new Metadata[n10];
        this.pendingMetadata = object;
        object = new long[n10];
        this.pendingMetadataTimestamps = (long[])object;
    }

    private void decodeWrappedMetadata(Metadata metadata, List list) {
        int n10;
        for (int i10 = 0; i10 < (n10 = metadata.length()); ++i10) {
            Object object;
            boolean bl2;
            Object object2 = metadata.get(i10).getWrappedMetadataFormat();
            if (object2 != null && (bl2 = (object = this.decoderFactory).supportsFormat((Format)object2))) {
                object2 = this.decoderFactory.createDecoder((Format)object2);
                object = (byte[])Assertions.checkNotNull(metadata.get(i10).getWrappedMetadataBytes());
                this.buffer.clear();
                Object object3 = this.buffer;
                int n11 = ((Object)object).length;
                ((DecoderInputBuffer)object3).ensureSpaceForWrite(n11);
                object3 = (ByteBuffer)Util.castNonNull(this.buffer.data);
                ((ByteBuffer)object3).put((byte[])object);
                this.buffer.flip();
                object = this.buffer;
                object2 = object2.decode((MetadataInputBuffer)object);
                if (object2 == null) continue;
                this.decodeWrappedMetadata((Metadata)object2, list);
                continue;
            }
            object2 = metadata.get(i10);
            list.add(object2);
        }
    }

    private void flushPendingMetadata() {
        Arrays.fill(this.pendingMetadata, null);
        this.pendingMetadataIndex = 0;
        this.pendingMetadataCount = 0;
    }

    private void invokeRenderer(Metadata metadata) {
        Handler handler = this.outputHandler;
        if (handler != null) {
            metadata = handler.obtainMessage(0, (Object)metadata);
            metadata.sendToTarget();
        } else {
            this.invokeRendererInternal(metadata);
        }
    }

    private void invokeRendererInternal(Metadata metadata) {
        this.output.onMetadata(metadata);
    }

    public String getName() {
        return TAG;
    }

    public boolean handleMessage(Message object) {
        int n10 = object.what;
        if (n10 == 0) {
            object = (Metadata)object.obj;
            this.invokeRendererInternal((Metadata)object);
            return true;
        }
        object = new IllegalStateException();
        throw object;
    }

    public boolean isEnded() {
        return this.inputStreamEnded;
    }

    public boolean isReady() {
        return true;
    }

    public void onDisabled() {
        this.flushPendingMetadata();
        this.decoder = null;
    }

    public void onPositionReset(long l10, boolean bl2) {
        this.flushPendingMetadata();
        this.inputStreamEnded = false;
    }

    public void onStreamChanged(Format[] object, long l10, long l11) {
        MetadataDecoderFactory metadataDecoderFactory = this.decoderFactory;
        object = object[0];
        this.decoder = object = metadataDecoderFactory.createDecoder((Format)object);
    }

    public void render(long l10, long l11) {
        long l12;
        long l13;
        long l14;
        int n10;
        Object object;
        int n11 = this.inputStreamEnded;
        int n12 = 5;
        int n13 = 1;
        if (n11 == 0 && (n11 = this.pendingMetadataCount) < n12) {
            this.buffer.clear();
            object = this.getFormatHolder();
            ArrayList arrayList = this.buffer;
            n10 = this.readSource((FormatHolder)object, (DecoderInputBuffer)((Object)arrayList), false);
            int n14 = -4;
            if (n10 == n14) {
                object = this.buffer;
                n11 = (int)(object.isEndOfStream() ? 1 : 0);
                if (n11 != 0) {
                    this.inputStreamEnded = n13;
                } else {
                    long l15;
                    object = this.buffer;
                    object.subsampleOffsetUs = l15 = this.subsampleOffsetUs;
                    object.flip();
                    object = (MetadataDecoder)Util.castNonNull(this.decoder);
                    arrayList = this.buffer;
                    object = object.decode((MetadataInputBuffer)((Object)arrayList));
                    if (object != null) {
                        n14 = object.length();
                        arrayList = new ArrayList(n14);
                        this.decodeWrappedMetadata((Metadata)object, arrayList);
                        n11 = (int)(arrayList.isEmpty() ? 1 : 0);
                        if (n11 == 0) {
                            long l16;
                            object = new Metadata(arrayList);
                            n10 = this.pendingMetadataIndex;
                            n14 = this.pendingMetadataCount;
                            n10 = (n10 + n14) % n12;
                            this.pendingMetadata[n10] = object;
                            object = this.pendingMetadataTimestamps;
                            MetadataInputBuffer metadataInputBuffer = this.buffer;
                            object[n10] = l16 = metadataInputBuffer.timeUs;
                            this.pendingMetadataCount = n14 += n13;
                        }
                    }
                }
            } else {
                n14 = -5;
                if (n10 == n14) {
                    long l17;
                    object = (Format)Assertions.checkNotNull(object.format);
                    this.subsampleOffsetUs = l17 = object.subsampleOffsetUs;
                }
            }
        }
        if ((n11 = this.pendingMetadataCount) > 0 && (l14 = (l13 = (l12 = (object = this.pendingMetadataTimestamps)[n10 = this.pendingMetadataIndex]) - l10) == 0L ? 0 : (l13 < 0L ? -1 : 1)) <= 0) {
            Metadata[] metadataArray = (Metadata[])Util.castNonNull(this.pendingMetadata[n10]);
            this.invokeRenderer((Metadata)metadataArray);
            metadataArray = this.pendingMetadata;
            int n15 = this.pendingMetadataIndex;
            n11 = 0;
            object = null;
            metadataArray[n15] = null;
            this.pendingMetadataIndex = n15 = (n15 + n13) % n12;
            l14 = this.pendingMetadataCount - n13;
            this.pendingMetadataCount = (int)l14;
        }
    }

    public int supportsFormat(Format object) {
        MetadataDecoderFactory metadataDecoderFactory = this.decoderFactory;
        boolean bl2 = metadataDecoderFactory.supportsFormat((Format)object);
        if (bl2) {
            object = ((Format)object).exoMediaCryptoType;
            int n10 = object == null ? 4 : 2;
            return RendererCapabilities.create(n10);
        }
        return RendererCapabilities.create(0);
    }
}

