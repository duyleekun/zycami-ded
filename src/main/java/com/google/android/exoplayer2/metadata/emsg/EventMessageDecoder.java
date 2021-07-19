/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.metadata.emsg;

import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.Metadata$Entry;
import com.google.android.exoplayer2.metadata.MetadataInputBuffer;
import com.google.android.exoplayer2.metadata.SimpleMetadataDecoder;
import com.google.android.exoplayer2.metadata.emsg.EventMessage;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.Arrays;

public final class EventMessageDecoder
extends SimpleMetadataDecoder {
    public Metadata decode(MetadataInputBuffer object, ByteBuffer object2) {
        Metadata$Entry[] metadata$EntryArray = new Metadata$Entry[1];
        byte[] byArray = ((ByteBuffer)object2).array();
        int n10 = ((Buffer)object2).limit();
        ParsableByteArray parsableByteArray = new ParsableByteArray(byArray, n10);
        metadata$EntryArray[0] = object2 = this.decode(parsableByteArray);
        object = new Metadata(metadata$EntryArray);
        return object;
    }

    public EventMessage decode(ParsableByteArray object) {
        Object object2;
        Object object3 = object2 = Assertions.checkNotNull(((ParsableByteArray)object).readNullTerminatedString());
        object3 = (String)object2;
        Object object4 = object2 = Assertions.checkNotNull(((ParsableByteArray)object).readNullTerminatedString());
        object4 = (String)object2;
        long l10 = ((ParsableByteArray)object).readUnsignedInt();
        long l11 = ((ParsableByteArray)object).readUnsignedInt();
        object2 = ((ParsableByteArray)object).getData();
        int n10 = ((ParsableByteArray)object).getPosition();
        int n11 = ((ParsableByteArray)object).limit();
        byte[] byArray = Arrays.copyOfRange((byte[])object2, n10, n11);
        object = new EventMessage((String)object3, (String)object4, l10, l11, byArray);
        return object;
    }
}

