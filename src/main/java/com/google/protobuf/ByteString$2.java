/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.ByteString$ByteIterator;
import java.util.Comparator;

public final class ByteString$2
implements Comparator {
    public int compare(ByteString byteString, ByteString byteString2) {
        int n10;
        ByteString$ByteIterator byteString$ByteIterator = byteString.iterator();
        ByteString$ByteIterator byteString$ByteIterator2 = byteString2.iterator();
        while ((n10 = byteString$ByteIterator.hasNext()) != 0 && (n10 = byteString$ByteIterator2.hasNext()) != 0) {
            n10 = ByteString.access$200(byteString$ByteIterator.nextByte());
            int n11 = ByteString.access$200(byteString$ByteIterator2.nextByte());
            if ((n10 = Integer.compare(n10, n11)) == 0) continue;
            return n10;
        }
        int n12 = byteString.size();
        int n13 = byteString2.size();
        return Integer.compare(n12, n13);
    }
}

