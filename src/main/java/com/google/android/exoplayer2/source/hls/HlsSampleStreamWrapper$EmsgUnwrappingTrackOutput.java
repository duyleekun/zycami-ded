/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.source.hls;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.Format$Builder;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.TrackOutput$CryptoData;
import com.google.android.exoplayer2.metadata.emsg.EventMessage;
import com.google.android.exoplayer2.metadata.emsg.EventMessageDecoder;
import com.google.android.exoplayer2.upstream.DataReader;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.io.EOFException;
import java.util.Arrays;

public class HlsSampleStreamWrapper$EmsgUnwrappingTrackOutput
implements TrackOutput {
    private static final Format EMSG_FORMAT;
    private static final Format ID3_FORMAT;
    private static final String TAG = "EmsgUnwrappingTrackOutput";
    private byte[] buffer;
    private int bufferPosition;
    private final TrackOutput delegate;
    private final Format delegateFormat;
    private final EventMessageDecoder emsgDecoder;
    private Format format;

    static {
        Format$Builder format$Builder = new Format$Builder();
        ID3_FORMAT = format$Builder.setSampleMimeType("application/id3").build();
        format$Builder = new Format$Builder();
        EMSG_FORMAT = format$Builder.setSampleMimeType("application/x-emsg").build();
    }

    /*
     * Enabled aggressive block sorting
     */
    public HlsSampleStreamWrapper$EmsgUnwrappingTrackOutput(TrackOutput object, int n10) {
        EventMessageDecoder eventMessageDecoder;
        this.emsgDecoder = eventMessageDecoder = new EventMessageDecoder();
        this.delegate = object;
        int n11 = 1;
        if (n10 != n11) {
            n11 = 3;
            if (n10 != n11) {
                StringBuilder stringBuilder = new StringBuilder(33);
                stringBuilder.append("Unknown metadataType: ");
                stringBuilder.append(n10);
                String string2 = stringBuilder.toString();
                object = new IllegalArgumentException(string2);
                throw object;
            }
            this.delegateFormat = object = EMSG_FORMAT;
        } else {
            this.delegateFormat = object = ID3_FORMAT;
        }
        byte[] byArray = new byte[]{};
        this.buffer = byArray;
        this.bufferPosition = 0;
    }

    private boolean emsgContainsExpectedWrappedFormat(EventMessage object) {
        String string2;
        boolean bl2;
        if ((object = ((EventMessage)object).getWrappedMetadataFormat()) != null && (bl2 = Util.areEqual(string2 = this.delegateFormat.sampleMimeType, object = ((Format)object).sampleMimeType))) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    private void ensureBufferCapacity(int n10) {
        byte[] byArray = this.buffer;
        int n11 = byArray.length;
        if (n11 < n10) {
            n11 = n10 / 2;
            byte[] byArray2 = Arrays.copyOf(byArray, n10 += n11);
            this.buffer = byArray2;
        }
    }

    private ParsableByteArray getSampleAndTrimBuffer(int n10, int n11) {
        int n12 = this.bufferPosition - n11;
        n10 = n12 - n10;
        byte[] byArray = Arrays.copyOfRange(this.buffer, n10, n12);
        ParsableByteArray parsableByteArray = new ParsableByteArray(byArray);
        byArray = this.buffer;
        System.arraycopy(byArray, n12, byArray, 0, n11);
        this.bufferPosition = n11;
        return parsableByteArray;
    }

    public void format(Format object) {
        this.format = object;
        object = this.delegate;
        Format format = this.delegateFormat;
        object.format(format);
    }

    public int sampleData(DataReader object, int n10, boolean bl2, int n11) {
        n11 = this.bufferPosition + n10;
        this.ensureBufferCapacity(n11);
        byte[] byArray = this.buffer;
        int n12 = this.bufferPosition;
        int n13 = object.read(byArray, n12, n10);
        n10 = -1;
        if (n13 == n10) {
            if (bl2) {
                return n10;
            }
            object = new EOFException();
            throw object;
        }
        this.bufferPosition = n10 = this.bufferPosition + n13;
        return n13;
    }

    public void sampleData(ParsableByteArray parsableByteArray, int n10, int n11) {
        int n12;
        n11 = this.bufferPosition + n10;
        this.ensureBufferCapacity(n11);
        byte[] byArray = this.buffer;
        int n13 = this.bufferPosition;
        parsableByteArray.readBytes(byArray, n13, n10);
        this.bufferPosition = n12 = this.bufferPosition + n10;
    }

    public void sampleMetadata(long l10, int n10, int n11, int n12, TrackOutput$CryptoData trackOutput$CryptoData) {
        String string2;
        block5: {
            Object object;
            block4: {
                Assertions.checkNotNull(this.format);
                object = this.getSampleAndTrimBuffer(n11, n12);
                Object object2 = this.format.sampleMimeType;
                string2 = this.delegateFormat.sampleMimeType;
                boolean bl2 = Util.areEqual(object2, string2);
                if (bl2) break block4;
                object2 = this.format.sampleMimeType;
                bl2 = "application/x-emsg".equals(object2);
                string2 = TAG;
                if (!bl2) break block5;
                object2 = this.emsgDecoder;
                bl2 = this.emsgContainsExpectedWrappedFormat((EventMessage)(object = ((EventMessageDecoder)object2).decode((ParsableByteArray)object)));
                if (!bl2) {
                    Object object3 = this.delegateFormat.sampleMimeType;
                    object3 = ((EventMessage)object).getWrappedMetadataFormat();
                    Object object4 = new Object[]{object3, object3};
                    object4 = String.format("Ignoring EMSG. Expected it to contain wrapped %s but actual wrapped format: %s", object4);
                    Log.w(string2, (String)object4);
                    return;
                }
                object = (byte[])Assertions.checkNotNull(((EventMessage)object).getWrappedMetadataBytes());
                object = object2 = new ParsableByteArray((byte[])object);
            }
            int n13 = ((ParsableByteArray)object).bytesLeft();
            this.delegate.sampleData((ParsableByteArray)object, n13);
            this.delegate.sampleMetadata(l10, n10, n13, n12, trackOutput$CryptoData);
            return;
        }
        String string3 = "Ignoring sample for unsupported format: ";
        String string4 = String.valueOf(this.format.sampleMimeType);
        n10 = string4.length();
        string3 = n10 != 0 ? string3.concat(string4) : (string4 = new String(string3));
        Log.w(string2, string3);
    }
}

