/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.metadata.dvbsi;

import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.MetadataInputBuffer;
import com.google.android.exoplayer2.metadata.SimpleMetadataDecoder;
import com.google.android.exoplayer2.metadata.dvbsi.AppInfoTable;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.common.base.Charsets;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;

public final class AppInfoTableDecoder
extends SimpleMetadataDecoder {
    public static final int APPLICATION_INFORMATION_TABLE_ID = 116;
    private static final int DESCRIPTOR_SIMPLE_APPLICATION_LOCATION = 21;
    private static final int DESCRIPTOR_TRANSPORT_PROTOCOL = 2;
    private static final int TRANSPORT_PROTOCOL_HTTP = 3;

    private static Metadata parseAit(ParsableBitArray parsableBitArray) {
        Object object;
        int n10 = 12;
        parsableBitArray.skipBits(n10);
        int n11 = parsableBitArray.readBits(n10);
        int n12 = parsableBitArray.getBytePosition() + n11;
        n11 = 4;
        parsableBitArray.skipBits(44);
        int n13 = parsableBitArray.readBits(n10);
        parsableBitArray.skipBytes(n13);
        n13 = 16;
        parsableBitArray.skipBits(n13);
        ArrayList<AppInfoTable> arrayList = new ArrayList<AppInfoTable>();
        while (true) {
            int n14;
            int n15 = parsableBitArray.getBytePosition();
            int n16 = 0;
            object = null;
            if (n15 >= (n12 -= n11)) break;
            parsableBitArray.skipBits(48);
            n15 = 8;
            int n17 = parsableBitArray.readBits(n15);
            parsableBitArray.skipBits(n11);
            int n18 = parsableBitArray.readBits(n10);
            int n19 = parsableBitArray.getBytePosition() + n18;
            n18 = 0;
            Object object2 = null;
            while ((n14 = parsableBitArray.getBytePosition()) < n19) {
                n14 = parsableBitArray.readBits(n15);
                int n20 = parsableBitArray.readBits(n15);
                int n21 = parsableBitArray.getBytePosition() + n20;
                int n22 = 2;
                if (n14 == n22) {
                    n14 = parsableBitArray.readBits(n13);
                    parsableBitArray.skipBits(n15);
                    n20 = 3;
                    if (n14 == n20) {
                        while ((n14 = parsableBitArray.getBytePosition()) < n21) {
                            n16 = parsableBitArray.readBits(n15);
                            Charset charset = Charsets.US_ASCII;
                            object = parsableBitArray.readBytesAsString(n16, charset);
                            n14 = parsableBitArray.readBits(n15);
                            for (n20 = 0; n20 < n14; ++n20) {
                                n22 = parsableBitArray.readBits(n15);
                                parsableBitArray.skipBytes(n22);
                            }
                        }
                    }
                } else {
                    n22 = 21;
                    if (n14 == n22) {
                        object2 = Charsets.US_ASCII;
                        object2 = parsableBitArray.readBytesAsString(n20, (Charset)object2);
                    }
                }
                parsableBitArray.setPosition(n21 *= 8);
            }
            parsableBitArray.setPosition(n19 *= 8);
            if (object == null || object2 == null) continue;
            object = String.valueOf(object);
            n19 = ((String)(object2 = String.valueOf(object2))).length();
            object = n19 != 0 ? ((String)object).concat((String)object2) : (object2 = new String((String)object));
            AppInfoTable appInfoTable = new AppInfoTable(n17, (String)object);
            arrayList.add(appInfoTable);
        }
        boolean bl2 = arrayList.isEmpty();
        if (!bl2) {
            object = new Metadata(arrayList);
        }
        return object;
    }

    public Metadata decode(MetadataInputBuffer object, ByteBuffer byteBuffer) {
        byte by2;
        byte by3 = byteBuffer.get();
        if (by3 == (by2 = 116)) {
            byte[] byArray = byteBuffer.array();
            int n10 = byteBuffer.limit();
            object = new ParsableBitArray(byArray, n10);
            object = AppInfoTableDecoder.parseAit((ParsableBitArray)object);
        } else {
            by3 = 0;
            object = null;
        }
        return object;
    }
}

