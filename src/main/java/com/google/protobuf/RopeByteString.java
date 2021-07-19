/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.ByteOutput;
import com.google.protobuf.ByteString;
import com.google.protobuf.ByteString$ByteIterator;
import com.google.protobuf.ByteString$LeafByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.RopeByteString$1;
import com.google.protobuf.RopeByteString$Balancer;
import com.google.protobuf.RopeByteString$PieceIterator;
import com.google.protobuf.RopeByteString$RopeInputStream;
import java.io.InputStream;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public final class RopeByteString
extends ByteString {
    public static final int[] minLengthByDepth;
    private static final long serialVersionUID = 1L;
    private final ByteString left;
    private final int leftLength;
    private final ByteString right;
    private final int totalLength;
    private final int treeDepth;

    static {
        int[] nArray;
        int[] nArray2 = nArray = new int[47];
        int[] nArray3 = nArray;
        nArray2[0] = 1;
        nArray3[1] = 1;
        nArray2[2] = 2;
        nArray3[3] = 3;
        nArray2[4] = 5;
        nArray3[5] = 8;
        nArray2[6] = 13;
        nArray3[7] = 21;
        nArray2[8] = 34;
        nArray3[9] = 55;
        nArray2[10] = 89;
        nArray3[11] = 144;
        nArray2[12] = 233;
        nArray3[13] = 377;
        nArray2[14] = 610;
        nArray3[15] = 987;
        nArray2[16] = 1597;
        nArray3[17] = 2584;
        nArray2[18] = 4181;
        nArray3[19] = 6765;
        nArray2[20] = 10946;
        nArray3[21] = 17711;
        nArray2[22] = 28657;
        nArray3[23] = 46368;
        nArray2[24] = 75025;
        nArray3[25] = 121393;
        nArray2[26] = 196418;
        nArray3[27] = 317811;
        nArray2[28] = 514229;
        nArray3[29] = 832040;
        nArray2[30] = 1346269;
        nArray3[31] = 2178309;
        nArray2[32] = 3524578;
        nArray3[33] = 5702887;
        nArray2[34] = 0x8CCCC9;
        nArray3[35] = 14930352;
        nArray2[36] = 24157817;
        nArray3[37] = 39088169;
        nArray2[38] = 63245986;
        nArray3[39] = 102334155;
        nArray2[40] = 165580141;
        nArray3[41] = 267914296;
        nArray2[42] = 433494437;
        nArray3[43] = 701408733;
        nArray2[44] = 1134903170;
        nArray3[45] = 1836311903;
        nArray3[46] = -1 >>> 1;
        minLengthByDepth = nArray;
    }

    private RopeByteString(ByteString byteString, ByteString byteString2) {
        int n10;
        this.left = byteString;
        this.right = byteString2;
        this.leftLength = n10 = byteString.size();
        int n11 = byteString2.size();
        this.totalLength = n10 += n11;
        int n12 = byteString.getTreeDepth();
        int n13 = byteString2.getTreeDepth();
        this.treeDepth = n12 = Math.max(n12, n13) + 1;
    }

    public /* synthetic */ RopeByteString(ByteString byteString, ByteString byteString2, RopeByteString$1 ropeByteString$1) {
        this(byteString, byteString2);
    }

    public static /* synthetic */ ByteString access$400(RopeByteString ropeByteString) {
        return ropeByteString.left;
    }

    public static /* synthetic */ ByteString access$500(RopeByteString ropeByteString) {
        return ropeByteString.right;
    }

    public static ByteString concatenate(ByteString byteString, ByteString byteString2) {
        int n10 = byteString2.size();
        if (n10 == 0) {
            return byteString;
        }
        n10 = byteString.size();
        if (n10 == 0) {
            return byteString2;
        }
        n10 = byteString.size();
        int n11 = byteString2.size();
        if ((n10 += n11) < (n11 = 128)) {
            return RopeByteString.concatenateBytes(byteString, byteString2);
        }
        int n12 = byteString instanceof RopeByteString;
        if (n12 != 0) {
            ByteString byteString3 = byteString;
            byteString3 = (RopeByteString)byteString;
            ByteString byteString4 = ((RopeByteString)byteString3).right;
            int n13 = byteString4.size();
            int n14 = byteString2.size();
            if ((n13 += n14) < n11) {
                byteString = RopeByteString.concatenateBytes(((RopeByteString)byteString3).right, byteString2);
                ByteString byteString5 = ((RopeByteString)byteString3).left;
                byteString2 = new RopeByteString(byteString5, byteString);
                return byteString2;
            }
            ByteString byteString6 = ((RopeByteString)byteString3).left;
            n11 = byteString6.getTreeDepth();
            if (n11 > (n13 = (byteString4 = ((RopeByteString)byteString3).right).getTreeDepth()) && (n11 = ((RopeByteString)byteString3).getTreeDepth()) > (n13 = byteString2.getTreeDepth())) {
                ByteString byteString7 = ((RopeByteString)byteString3).right;
                byteString = new RopeByteString(byteString7, byteString2);
                byteString7 = ((RopeByteString)byteString3).left;
                byteString2 = new RopeByteString(byteString7, byteString);
                return byteString2;
            }
        }
        n11 = byteString.getTreeDepth();
        n12 = byteString2.getTreeDepth();
        if (n10 >= (n11 = RopeByteString.minLength(Math.max(n11, n12) + 1))) {
            RopeByteString ropeByteString = new RopeByteString(byteString, byteString2);
            return ropeByteString;
        }
        RopeByteString$Balancer ropeByteString$Balancer = new RopeByteString$Balancer(null);
        return RopeByteString$Balancer.access$100(ropeByteString$Balancer, byteString, byteString2);
    }

    private static ByteString concatenateBytes(ByteString byteString, ByteString byteString2) {
        int n10 = byteString.size();
        int n11 = byteString2.size();
        byte[] byArray = new byte[n10 + n11];
        byteString.copyTo(byArray, 0, 0, n10);
        byteString2.copyTo(byArray, 0, n10, n11);
        return ByteString.wrap(byArray);
    }

    private boolean equalsFragments(ByteString serializable) {
        RopeByteString$PieceIterator ropeByteString$PieceIterator = new RopeByteString$PieceIterator(this, null);
        ByteString$LeafByteString byteString$LeafByteString = (ByteString$LeafByteString)ropeByteString$PieceIterator.next();
        RopeByteString$PieceIterator ropeByteString$PieceIterator2 = new RopeByteString$PieceIterator((ByteString)serializable, null);
        serializable = (ByteString$LeafByteString)ropeByteString$PieceIterator2.next();
        int n10 = 0;
        int n11 = 0;
        int n12 = 0;
        while (true) {
            int n13 = byteString$LeafByteString.size() - n10;
            int n14 = serializable.size() - n11;
            int n15 = Math.min(n13, n14);
            int n16 = n10 == 0 ? byteString$LeafByteString.equalsRange((ByteString)serializable, n11, n15) : ((ByteString$LeafByteString)serializable).equalsRange(byteString$LeafByteString, n10, n15);
            if (n16 == 0) {
                return false;
            }
            n16 = this.totalLength;
            if ((n12 += n15) >= n16) {
                if (n12 == n16) {
                    return true;
                }
                serializable = new IllegalStateException();
                throw serializable;
            }
            if (n15 == n13) {
                byteString$LeafByteString = (ByteString$LeafByteString)ropeByteString$PieceIterator.next();
                n10 = 0;
            } else {
                n10 += n15;
            }
            if (n15 == n14) {
                serializable = (ByteString$LeafByteString)ropeByteString$PieceIterator2.next();
                n11 = 0;
                continue;
            }
            n11 += n15;
        }
    }

    public static int minLength(int n10) {
        int[] nArray = minLengthByDepth;
        int n11 = nArray.length;
        if (n10 >= n11) {
            return -1 >>> 1;
        }
        return nArray[n10];
    }

    public static RopeByteString newInstanceForTest(ByteString byteString, ByteString byteString2) {
        RopeByteString ropeByteString = new RopeByteString(byteString, byteString2);
        return ropeByteString;
    }

    private void readObject(ObjectInputStream object) {
        object = new InvalidObjectException("RopeByteStream instances are not to be serialized directly");
        throw object;
    }

    public ByteBuffer asReadOnlyByteBuffer() {
        return ByteBuffer.wrap(this.toByteArray()).asReadOnlyBuffer();
    }

    public List asReadOnlyByteBufferList() {
        ArrayList<ByteBuffer> arrayList = new ArrayList<ByteBuffer>();
        boolean bl2 = false;
        ByteBuffer byteBuffer = null;
        RopeByteString$PieceIterator ropeByteString$PieceIterator = new RopeByteString$PieceIterator(this, null);
        while (bl2 = ropeByteString$PieceIterator.hasNext()) {
            byteBuffer = ropeByteString$PieceIterator.next().asReadOnlyByteBuffer();
            arrayList.add(byteBuffer);
        }
        return arrayList;
    }

    public byte byteAt(int n10) {
        int n11 = this.totalLength;
        ByteString.checkIndex(n10, n11);
        return this.internalByteAt(n10);
    }

    public void copyTo(ByteBuffer byteBuffer) {
        this.left.copyTo(byteBuffer);
        this.right.copyTo(byteBuffer);
    }

    public void copyToInternal(byte[] byArray, int n10, int n11, int n12) {
        int n13 = n10 + n12;
        int n14 = this.leftLength;
        if (n13 <= n14) {
            ByteString byteString = this.left;
            byteString.copyToInternal(byArray, n10, n11, n12);
        } else if (n10 >= n14) {
            ByteString byteString = this.right;
            byteString.copyToInternal(byArray, n10 -= n14, n11, n12);
        } else {
            this.left.copyToInternal(byArray, n10, n11, n14 -= n10);
            ByteString byteString = this.right;
            n13 = 0;
            Object var7_9 = null;
            byteString.copyToInternal(byArray, 0, n11 += n14, n12 -= n14);
        }
    }

    public boolean equals(Object object) {
        int n10 = 1;
        if (object == this) {
            return n10 != 0;
        }
        int n11 = object instanceof ByteString;
        if (n11 == 0) {
            return false;
        }
        n11 = this.totalLength;
        int n12 = ((ByteString)(object = (ByteString)object)).size();
        if (n11 != n12) {
            return false;
        }
        n11 = this.totalLength;
        if (n11 == 0) {
            return n10 != 0;
        }
        n10 = this.peekCachedHashCode();
        n11 = ((ByteString)object).peekCachedHashCode();
        if (n10 != 0 && n11 != 0 && n10 != n11) {
            return false;
        }
        return this.equalsFragments((ByteString)object);
    }

    public int getTreeDepth() {
        return this.treeDepth;
    }

    public byte internalByteAt(int n10) {
        int n11 = this.leftLength;
        if (n10 < n11) {
            return this.left.internalByteAt(n10);
        }
        ByteString byteString = this.right;
        return byteString.internalByteAt(n10 -= n11);
    }

    public boolean isBalanced() {
        int n10 = this.totalLength;
        int n11 = RopeByteString.minLength(this.treeDepth);
        n10 = n10 >= n11 ? 1 : 0;
        return n10 != 0;
    }

    public boolean isValidUtf8() {
        ByteString byteString = this.left;
        int n10 = this.leftLength;
        boolean bl2 = false;
        int n11 = byteString.partialIsValidUtf8(0, 0, n10);
        ByteString byteString2 = this.right;
        int n12 = byteString2.size();
        if ((n11 = byteString2.partialIsValidUtf8(n11, 0, n12)) == 0) {
            bl2 = true;
        }
        return bl2;
    }

    public ByteString$ByteIterator iterator() {
        RopeByteString$1 ropeByteString$1 = new RopeByteString$1(this);
        return ropeByteString$1;
    }

    public CodedInputStream newCodedInput() {
        RopeByteString$RopeInputStream ropeByteString$RopeInputStream = new RopeByteString$RopeInputStream(this);
        return CodedInputStream.newInstance(ropeByteString$RopeInputStream);
    }

    public InputStream newInput() {
        RopeByteString$RopeInputStream ropeByteString$RopeInputStream = new RopeByteString$RopeInputStream(this);
        return ropeByteString$RopeInputStream;
    }

    public int partialHash(int n10, int n11, int n12) {
        int n13 = n11 + n12;
        int n14 = this.leftLength;
        if (n13 <= n14) {
            return this.left.partialHash(n10, n11, n12);
        }
        if (n11 >= n14) {
            ByteString byteString = this.right;
            return byteString.partialHash(n10, n11 -= n14, n12);
        }
        n10 = this.left.partialHash(n10, n11, n14 -= n11);
        ByteString byteString = this.right;
        return byteString.partialHash(n10, 0, n12 -= n14);
    }

    public int partialIsValidUtf8(int n10, int n11, int n12) {
        int n13 = n11 + n12;
        int n14 = this.leftLength;
        if (n13 <= n14) {
            return this.left.partialIsValidUtf8(n10, n11, n12);
        }
        if (n11 >= n14) {
            ByteString byteString = this.right;
            return byteString.partialIsValidUtf8(n10, n11 -= n14, n12);
        }
        n10 = this.left.partialIsValidUtf8(n10, n11, n14 -= n11);
        ByteString byteString = this.right;
        return byteString.partialIsValidUtf8(n10, 0, n12 -= n14);
    }

    public int size() {
        return this.totalLength;
    }

    public ByteString substring(int n10, int n11) {
        int n12 = this.totalLength;
        if ((n12 = ByteString.checkRange(n10, n11, n12)) == 0) {
            return ByteString.EMPTY;
        }
        int n13 = this.totalLength;
        if (n12 == n13) {
            return this;
        }
        n12 = this.leftLength;
        if (n11 <= n12) {
            return this.left.substring(n10, n11);
        }
        if (n10 >= n12) {
            ByteString byteString = this.right;
            return byteString.substring(n10 -= n12, n11 -= n12);
        }
        ByteString byteString = this.left.substring(n10);
        ByteString byteString2 = this.right;
        int n14 = this.leftLength;
        ByteString byteString3 = byteString2.substring(0, n11 -= n14);
        byteString2 = new RopeByteString(byteString, byteString3);
        return byteString2;
    }

    public String toStringInternal(Charset charset) {
        byte[] byArray = this.toByteArray();
        String string2 = new String(byArray, charset);
        return string2;
    }

    public Object writeReplace() {
        return ByteString.wrap(this.toByteArray());
    }

    public void writeTo(ByteOutput byteOutput) {
        this.left.writeTo(byteOutput);
        this.right.writeTo(byteOutput);
    }

    public void writeTo(OutputStream outputStream) {
        this.left.writeTo(outputStream);
        this.right.writeTo(outputStream);
    }

    public void writeToInternal(OutputStream outputStream, int n10, int n11) {
        int n12 = n10 + n11;
        int n13 = this.leftLength;
        if (n12 <= n13) {
            ByteString byteString = this.left;
            byteString.writeToInternal(outputStream, n10, n11);
        } else if (n10 >= n13) {
            ByteString byteString = this.right;
            byteString.writeToInternal(outputStream, n10 -= n13, n11);
        } else {
            this.left.writeToInternal(outputStream, n10, n13 -= n10);
            ByteString byteString = this.right;
            n12 = 0;
            Object var6_8 = null;
            byteString.writeToInternal(outputStream, 0, n11 -= n13);
        }
    }

    public void writeToReverse(ByteOutput byteOutput) {
        this.right.writeToReverse(byteOutput);
        this.left.writeToReverse(byteOutput);
    }
}

