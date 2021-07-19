/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.decoder.Buffer;
import com.google.android.exoplayer2.decoder.CryptoInfo;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.extractor.TrackOutput$CryptoData;
import com.google.android.exoplayer2.source.SampleDataQueue$AllocationNode;
import com.google.android.exoplayer2.source.SampleQueue$SampleExtrasHolder;
import com.google.android.exoplayer2.upstream.Allocation;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.DataReader;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.io.EOFException;
import java.nio.ByteBuffer;
import java.util.Arrays;

public class SampleDataQueue {
    private static final int INITIAL_SCRATCH_SIZE = 32;
    private final int allocationLength;
    private final Allocator allocator;
    private SampleDataQueue$AllocationNode firstAllocationNode;
    private SampleDataQueue$AllocationNode readAllocationNode;
    private final ParsableByteArray scratch;
    private long totalBytesWritten;
    private SampleDataQueue$AllocationNode writeAllocationNode;

    public SampleDataQueue(Allocator allocator) {
        int n10;
        this.allocator = allocator;
        this.allocationLength = n10 = allocator.getIndividualAllocationLength();
        Object object = new ParsableByteArray(32);
        this.scratch = object;
        this.firstAllocationNode = object = new SampleDataQueue$AllocationNode(0L, n10);
        this.readAllocationNode = object;
        this.writeAllocationNode = object;
    }

    private void clearAllocationNodes(SampleDataQueue$AllocationNode sampleDataQueue$AllocationNode) {
        int n10 = sampleDataQueue$AllocationNode.wasInitialized;
        if (n10 == 0) {
            return;
        }
        Allocation[] allocationArray = this.writeAllocationNode;
        int n11 = allocationArray.wasInitialized;
        long l10 = allocationArray.startPosition;
        long l11 = sampleDataQueue$AllocationNode.startPosition;
        n10 = (int)(l10 -= l11);
        int n12 = this.allocationLength;
        int n13 = n11 + (n10 /= n12);
        allocationArray = new Allocation[n13];
        for (n12 = 0; n12 < n13; ++n12) {
            Allocation allocation;
            allocationArray[n12] = allocation = sampleDataQueue$AllocationNode.allocation;
            sampleDataQueue$AllocationNode = sampleDataQueue$AllocationNode.clear();
        }
        this.allocator.release(allocationArray);
    }

    private static SampleDataQueue$AllocationNode getNodeContainingPosition(SampleDataQueue$AllocationNode sampleDataQueue$AllocationNode, long l10) {
        long l11;
        long l12;
        long l13;
        while ((l13 = (l12 = l10 - (l11 = sampleDataQueue$AllocationNode.endPosition)) == 0L ? 0 : (l12 < 0L ? -1 : 1)) >= 0) {
            sampleDataQueue$AllocationNode = sampleDataQueue$AllocationNode.next;
        }
        return sampleDataQueue$AllocationNode;
    }

    private void postAppend(int n10) {
        long l10 = this.totalBytesWritten;
        long l11 = n10;
        this.totalBytesWritten = l10 += l11;
        SampleDataQueue$AllocationNode sampleDataQueue$AllocationNode = this.writeAllocationNode;
        l11 = sampleDataQueue$AllocationNode.endPosition;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object == false) {
            this.writeAllocationNode = sampleDataQueue$AllocationNode = sampleDataQueue$AllocationNode.next;
        }
    }

    private int preAppend(int n10) {
        SampleDataQueue$AllocationNode sampleDataQueue$AllocationNode = this.writeAllocationNode;
        boolean bl2 = sampleDataQueue$AllocationNode.wasInitialized;
        if (!bl2) {
            Allocation allocation = this.allocator.allocate();
            SampleDataQueue$AllocationNode sampleDataQueue$AllocationNode2 = this.writeAllocationNode;
            long l10 = sampleDataQueue$AllocationNode2.endPosition;
            int n11 = this.allocationLength;
            SampleDataQueue$AllocationNode sampleDataQueue$AllocationNode3 = new SampleDataQueue$AllocationNode(l10, n11);
            sampleDataQueue$AllocationNode.initialize(allocation, sampleDataQueue$AllocationNode3);
        }
        long l11 = this.writeAllocationNode.endPosition;
        long l12 = this.totalBytesWritten;
        int n12 = (int)(l11 - l12);
        return Math.min(n10, n12);
    }

    private static SampleDataQueue$AllocationNode readData(SampleDataQueue$AllocationNode sampleDataQueue$AllocationNode, long l10, ByteBuffer byteBuffer, int n10) {
        sampleDataQueue$AllocationNode = SampleDataQueue.getNodeContainingPosition(sampleDataQueue$AllocationNode, l10);
        while (n10 > 0) {
            int n11 = (int)(sampleDataQueue$AllocationNode.endPosition - l10);
            n11 = Math.min(n10, n11);
            byte[] byArray = sampleDataQueue$AllocationNode.allocation.data;
            int n12 = sampleDataQueue$AllocationNode.translateOffset(l10);
            byteBuffer.put(byArray, n12, n11);
            n10 -= n11;
            long l11 = n11;
            long l12 = (l10 += l11) - (l11 = sampleDataQueue$AllocationNode.endPosition);
            n11 = (int)(l12 == 0L ? 0 : (l12 < 0L ? -1 : 1));
            if (n11 != 0) continue;
            sampleDataQueue$AllocationNode = sampleDataQueue$AllocationNode.next;
        }
        return sampleDataQueue$AllocationNode;
    }

    private static SampleDataQueue$AllocationNode readData(SampleDataQueue$AllocationNode sampleDataQueue$AllocationNode, long l10, byte[] byArray, int n10) {
        int n11;
        sampleDataQueue$AllocationNode = SampleDataQueue.getNodeContainingPosition(sampleDataQueue$AllocationNode, l10);
        for (int i10 = n10; i10 > 0; i10 -= n11) {
            n11 = (int)(sampleDataQueue$AllocationNode.endPosition - l10);
            n11 = Math.min(i10, n11);
            byte[] byArray2 = sampleDataQueue$AllocationNode.allocation.data;
            int n12 = sampleDataQueue$AllocationNode.translateOffset(l10);
            int n13 = n10 - i10;
            System.arraycopy(byArray2, n12, byArray, n13, n11);
            long l11 = n11;
            long l12 = (l10 += l11) - (l11 = sampleDataQueue$AllocationNode.endPosition);
            n11 = (int)(l12 == 0L ? 0 : (l12 < 0L ? -1 : 1));
            if (n11 != 0) continue;
            sampleDataQueue$AllocationNode = sampleDataQueue$AllocationNode.next;
        }
        return sampleDataQueue$AllocationNode;
    }

    private static SampleDataQueue$AllocationNode readEncryptionData(SampleDataQueue$AllocationNode sampleDataQueue$AllocationNode, DecoderInputBuffer decoderInputBuffer, SampleQueue$SampleExtrasHolder sampleQueue$SampleExtrasHolder, ParsableByteArray parsableByteArray) {
        int n10;
        int n11;
        int n12;
        SampleQueue$SampleExtrasHolder sampleQueue$SampleExtrasHolder2 = sampleQueue$SampleExtrasHolder;
        Object object = parsableByteArray;
        long l10 = sampleQueue$SampleExtrasHolder.offset;
        int n13 = 1;
        parsableByteArray.reset(n13);
        Object object2 = parsableByteArray.getData();
        Object object3 = sampleDataQueue$AllocationNode;
        object2 = SampleDataQueue.readData(sampleDataQueue$AllocationNode, l10, object2, n13);
        long l11 = 1L;
        l10 += l11;
        object3 = parsableByteArray.getData();
        int n14 = 0;
        Object object4 = object3[0];
        int n15 = object4 & 0x80;
        n15 = n15 != 0 ? n13 : 0;
        object4 = object4 & 0x7F;
        Object object5 = decoderInputBuffer;
        object5 = decoderInputBuffer.cryptoInfo;
        byte[] byArray = ((CryptoInfo)object5).iv;
        if (byArray == null) {
            n12 = 16;
            ((CryptoInfo)object5).iv = byArray = new byte[n12];
        } else {
            Arrays.fill(byArray, (byte)0);
        }
        byArray = ((CryptoInfo)object5).iv;
        object2 = SampleDataQueue.readData((SampleDataQueue$AllocationNode)object2, l10, byArray, (int)object4);
        long l12 = (long)object4;
        l10 += l12;
        if (n15 != 0) {
            n13 = 2;
            ((ParsableByteArray)object).reset(n13);
            object3 = parsableByteArray.getData();
            object2 = SampleDataQueue.readData((SampleDataQueue$AllocationNode)object2, l10, (byte[])object3, n13);
            l12 = 2;
            l10 += l12;
            n13 = parsableByteArray.readUnsignedShort();
        }
        n12 = n13;
        int[] nArray = ((CryptoInfo)object5).numBytesOfClearData;
        if (nArray == null || (object4 = (Object)nArray.length) < n13) {
            nArray = new int[n12];
        }
        int[] nArray2 = nArray;
        nArray = ((CryptoInfo)object5).numBytesOfEncryptedData;
        if (nArray == null || (object4 = (Object)nArray.length) < n12) {
            nArray = new int[n12];
        }
        int[] nArray3 = nArray;
        if (n15 != 0) {
            n13 = n12 * 6;
            ((ParsableByteArray)object).reset(n13);
            object3 = parsableByteArray.getData();
            object2 = SampleDataQueue.readData((SampleDataQueue$AllocationNode)object2, l10, (byte[])object3, n13);
            long l13 = n13;
            l10 += l13;
            ((ParsableByteArray)object).setPosition(0);
            while (n14 < n12) {
                nArray2[n14] = n13 = parsableByteArray.readUnsignedShort();
                nArray3[n14] = n13 = parsableByteArray.readUnsignedIntToInt();
                ++n14;
            }
        } else {
            nArray2[0] = 0;
            n11 = sampleQueue$SampleExtrasHolder2.size;
            long l14 = sampleQueue$SampleExtrasHolder2.offset;
            l14 = l10 - l14;
            n13 = (int)l14;
            nArray[0] = n11 -= n13;
        }
        object = (TrackOutput$CryptoData)Util.castNonNull(sampleQueue$SampleExtrasHolder2.cryptoData);
        byte[] byArray2 = ((TrackOutput$CryptoData)object).encryptionKey;
        byte[] byArray3 = ((CryptoInfo)object5).iv;
        int n16 = ((TrackOutput$CryptoData)object).cryptoMode;
        n13 = ((TrackOutput$CryptoData)object).encryptedBlocks;
        n11 = ((TrackOutput$CryptoData)object).clearBlocks;
        ((CryptoInfo)object5).set(n12, nArray2, nArray3, byArray2, byArray3, n16, n13, n11);
        l11 = sampleQueue$SampleExtrasHolder2.offset;
        n11 = (int)(l10 - l11);
        l10 = n11;
        sampleQueue$SampleExtrasHolder2.offset = l11 += l10;
        sampleQueue$SampleExtrasHolder2.size = n10 = sampleQueue$SampleExtrasHolder2.size - n11;
        return object2;
    }

    private static SampleDataQueue$AllocationNode readSampleData(SampleDataQueue$AllocationNode sampleDataQueue$AllocationNode, DecoderInputBuffer object, SampleQueue$SampleExtrasHolder sampleQueue$SampleExtrasHolder, ParsableByteArray parsableByteArray) {
        boolean bl2;
        boolean n10 = ((DecoderInputBuffer)object).isEncrypted();
        if (n10) {
            sampleDataQueue$AllocationNode = SampleDataQueue.readEncryptionData(sampleDataQueue$AllocationNode, (DecoderInputBuffer)object, sampleQueue$SampleExtrasHolder, parsableByteArray);
        }
        if (bl2 = ((Buffer)object).hasSupplementalData()) {
            int n11;
            int n12;
            int n13 = 4;
            parsableByteArray.reset(n13);
            long l10 = sampleQueue$SampleExtrasHolder.offset;
            byte[] byArray = parsableByteArray.getData();
            sampleDataQueue$AllocationNode = SampleDataQueue.readData(sampleDataQueue$AllocationNode, l10, byArray, n13);
            int n14 = parsableByteArray.readUnsignedIntToInt();
            l10 = sampleQueue$SampleExtrasHolder.offset;
            long l11 = 4;
            sampleQueue$SampleExtrasHolder.offset = l10 += l11;
            sampleQueue$SampleExtrasHolder.size = n12 = sampleQueue$SampleExtrasHolder.size - n13;
            ((DecoderInputBuffer)object).ensureSpaceForWrite(n14);
            long l12 = sampleQueue$SampleExtrasHolder.offset;
            ByteBuffer byteBuffer = ((DecoderInputBuffer)object).data;
            sampleDataQueue$AllocationNode = SampleDataQueue.readData(sampleDataQueue$AllocationNode, l12, byteBuffer, n14);
            l12 = sampleQueue$SampleExtrasHolder.offset;
            long l13 = n14;
            sampleQueue$SampleExtrasHolder.offset = l12 += l13;
            sampleQueue$SampleExtrasHolder.size = n11 = sampleQueue$SampleExtrasHolder.size - n14;
            ((DecoderInputBuffer)object).resetSupplementalData(n11);
            l12 = sampleQueue$SampleExtrasHolder.offset;
            object = ((DecoderInputBuffer)object).supplementalData;
            int n15 = sampleQueue$SampleExtrasHolder.size;
            sampleDataQueue$AllocationNode = SampleDataQueue.readData(sampleDataQueue$AllocationNode, l12, (ByteBuffer)object, n15);
        } else {
            int n16 = sampleQueue$SampleExtrasHolder.size;
            ((DecoderInputBuffer)object).ensureSpaceForWrite(n16);
            long l14 = sampleQueue$SampleExtrasHolder.offset;
            object = ((DecoderInputBuffer)object).data;
            int n17 = sampleQueue$SampleExtrasHolder.size;
            sampleDataQueue$AllocationNode = SampleDataQueue.readData(sampleDataQueue$AllocationNode, l14, (ByteBuffer)object, n17);
        }
        return sampleDataQueue$AllocationNode;
    }

    public void discardDownstreamTo(long l10) {
        long l11;
        Object object;
        long l12 = -1;
        long l13 = l10 - l12;
        Object object2 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (object2 == false) {
            return;
        }
        while (true) {
            object = this.firstAllocationNode;
            l11 = ((SampleDataQueue$AllocationNode)object).endPosition;
            long l14 = l10 - l11;
            Object object3 = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
            if (object3 < 0) break;
            Allocator allocator = this.allocator;
            object = ((SampleDataQueue$AllocationNode)object).allocation;
            allocator.release((Allocation)object);
            this.firstAllocationNode = object = this.firstAllocationNode.clear();
        }
        SampleDataQueue$AllocationNode sampleDataQueue$AllocationNode = this.readAllocationNode;
        l10 = sampleDataQueue$AllocationNode.startPosition;
        l11 = ((SampleDataQueue$AllocationNode)object).startPosition;
        long l15 = l10 - l11;
        Object object4 = l15 == 0L ? 0 : (l15 < 0L ? -1 : 1);
        if (object4 < 0) {
            this.readAllocationNode = object;
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public void discardUpstreamSampleBytes(long l10) {
        this.totalBytesWritten = l10;
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object != false) {
            SampleDataQueue$AllocationNode sampleDataQueue$AllocationNode = this.firstAllocationNode;
            long l13 = sampleDataQueue$AllocationNode.startPosition;
            long l14 = l10 - l13;
            Object object2 = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
            if (object2 != false) {
                SampleDataQueue$AllocationNode sampleDataQueue$AllocationNode2;
                long l15;
                long l16;
                while ((l16 = (l15 = (l10 = this.totalBytesWritten) - (l13 = sampleDataQueue$AllocationNode.endPosition)) == 0L ? 0 : (l15 < 0L ? -1 : 1)) > 0) {
                    sampleDataQueue$AllocationNode = sampleDataQueue$AllocationNode.next;
                }
                SampleDataQueue$AllocationNode sampleDataQueue$AllocationNode3 = sampleDataQueue$AllocationNode.next;
                this.clearAllocationNodes(sampleDataQueue$AllocationNode3);
                l13 = sampleDataQueue$AllocationNode.endPosition;
                int n10 = this.allocationLength;
                sampleDataQueue$AllocationNode.next = sampleDataQueue$AllocationNode2 = new SampleDataQueue$AllocationNode(l13, n10);
                l13 = this.totalBytesWritten;
                long l17 = sampleDataQueue$AllocationNode.endPosition;
                long l18 = l13 == l17 ? 0 : (l13 < l17 ? -1 : 1);
                if (l18 == false) {
                    sampleDataQueue$AllocationNode = sampleDataQueue$AllocationNode2;
                }
                this.writeAllocationNode = sampleDataQueue$AllocationNode;
                sampleDataQueue$AllocationNode = this.readAllocationNode;
                if (sampleDataQueue$AllocationNode != sampleDataQueue$AllocationNode3) return;
                this.readAllocationNode = sampleDataQueue$AllocationNode2;
                return;
            }
        }
        SampleDataQueue$AllocationNode sampleDataQueue$AllocationNode = this.firstAllocationNode;
        this.clearAllocationNodes(sampleDataQueue$AllocationNode);
        l11 = this.totalBytesWritten;
        int n11 = this.allocationLength;
        this.firstAllocationNode = sampleDataQueue$AllocationNode = new SampleDataQueue$AllocationNode(l11, n11);
        this.readAllocationNode = sampleDataQueue$AllocationNode;
        this.writeAllocationNode = sampleDataQueue$AllocationNode;
    }

    public long getTotalBytesWritten() {
        return this.totalBytesWritten;
    }

    public void peekToBuffer(DecoderInputBuffer decoderInputBuffer, SampleQueue$SampleExtrasHolder sampleQueue$SampleExtrasHolder) {
        SampleDataQueue$AllocationNode sampleDataQueue$AllocationNode = this.readAllocationNode;
        ParsableByteArray parsableByteArray = this.scratch;
        SampleDataQueue.readSampleData(sampleDataQueue$AllocationNode, decoderInputBuffer, sampleQueue$SampleExtrasHolder, parsableByteArray);
    }

    public void readToBuffer(DecoderInputBuffer object, SampleQueue$SampleExtrasHolder sampleQueue$SampleExtrasHolder) {
        SampleDataQueue$AllocationNode sampleDataQueue$AllocationNode = this.readAllocationNode;
        ParsableByteArray parsableByteArray = this.scratch;
        this.readAllocationNode = object = SampleDataQueue.readSampleData(sampleDataQueue$AllocationNode, (DecoderInputBuffer)object, sampleQueue$SampleExtrasHolder, parsableByteArray);
    }

    public void reset() {
        SampleDataQueue$AllocationNode sampleDataQueue$AllocationNode = this.firstAllocationNode;
        this.clearAllocationNodes(sampleDataQueue$AllocationNode);
        int n10 = this.allocationLength;
        long l10 = 0L;
        this.firstAllocationNode = sampleDataQueue$AllocationNode = new SampleDataQueue$AllocationNode(l10, n10);
        this.readAllocationNode = sampleDataQueue$AllocationNode;
        this.writeAllocationNode = sampleDataQueue$AllocationNode;
        this.totalBytesWritten = l10;
        this.allocator.trim();
    }

    public void rewind() {
        SampleDataQueue$AllocationNode sampleDataQueue$AllocationNode;
        this.readAllocationNode = sampleDataQueue$AllocationNode = this.firstAllocationNode;
    }

    public int sampleData(DataReader object, int n10, boolean bl2) {
        SampleDataQueue$AllocationNode sampleDataQueue$AllocationNode;
        n10 = this.preAppend(n10);
        byte[] byArray = sampleDataQueue$AllocationNode.allocation.data;
        sampleDataQueue$AllocationNode = this.writeAllocationNode;
        long l10 = this.totalBytesWritten;
        int n11 = sampleDataQueue$AllocationNode.translateOffset(l10);
        int n12 = object.read(byArray, n11, n10);
        if (n12 == (n10 = -1)) {
            if (bl2) {
                return n10;
            }
            object = new EOFException();
            throw object;
        }
        this.postAppend(n12);
        return n12;
    }

    public void sampleData(ParsableByteArray parsableByteArray, int n10) {
        while (n10 > 0) {
            int n11 = this.preAppend(n10);
            SampleDataQueue$AllocationNode sampleDataQueue$AllocationNode = this.writeAllocationNode;
            byte[] byArray = sampleDataQueue$AllocationNode.allocation.data;
            long l10 = this.totalBytesWritten;
            int n12 = sampleDataQueue$AllocationNode.translateOffset(l10);
            parsableByteArray.readBytes(byArray, n12, n11);
            n10 -= n11;
            this.postAppend(n11);
        }
    }
}

