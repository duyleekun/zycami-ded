/*
 * Decompiled with CFR 0.151.
 */
package org.apache.tools.zip;

import java.io.InputStream;
import java.io.RandomAccessFile;
import org.apache.tools.zip.ZipFile;

public class ZipFile$BoundedInputStream
extends InputStream {
    private boolean addDummyByte = false;
    private long loc;
    private long remaining;
    private final /* synthetic */ ZipFile this$0;

    public ZipFile$BoundedInputStream(ZipFile zipFile, long l10, long l11) {
        this.this$0 = zipFile;
        this.remaining = l11;
        this.loc = l10;
    }

    public void addDummy() {
        this.addDummyByte = true;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public int read() {
        long l10;
        long l11 = this.remaining;
        long l12 = 1L;
        this.remaining = l10 = l11 - l12;
        l10 = 0L;
        long l13 = l11 - l10;
        Object object = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (object > 0) {
            RandomAccessFile randomAccessFile = ZipFile.access$300(this.this$0);
            synchronized (randomAccessFile) {
                Object object2 = this.this$0;
                object2 = ZipFile.access$300((ZipFile)object2);
                l10 = this.loc;
                this.loc = l12 += l10;
                ((RandomAccessFile)object2).seek(l10);
                object2 = this.this$0;
                object2 = ZipFile.access$300((ZipFile)object2);
                return ((RandomAccessFile)object2).read();
            }
        }
        object = this.addDummyByte;
        if (object == false) return -1;
        this.addDummyByte = false;
        return 0;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public int read(byte[] byArray, int n10, int n11) {
        long l10 = this.remaining;
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object <= 0) {
            n11 = (int)(this.addDummyByte ? 1 : 0);
            if (n11 == 0) return -1;
            this.addDummyByte = false;
            byArray[n10] = 0;
            return 1;
        }
        if (n11 <= 0) {
            return 0;
        }
        l11 = n11;
        long l13 = l11 - l10;
        object = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (object > 0) {
            n11 = (int)l10;
        }
        RandomAccessFile randomAccessFile = ZipFile.access$300(this.this$0);
        // MONITORENTER : randomAccessFile
        Object object2 = this.this$0;
        object2 = ZipFile.access$300((ZipFile)object2);
        l11 = this.loc;
        ((RandomAccessFile)object2).seek(l11);
        object2 = this.this$0;
        object2 = ZipFile.access$300((ZipFile)object2);
        int n12 = ((RandomAccessFile)object2).read(byArray, n10, n11);
        // MONITOREXIT : randomAccessFile
        if (n12 <= 0) return n12;
        long l14 = this.loc;
        l10 = n12;
        this.loc = l14 += l10;
        this.remaining = l14 = this.remaining - l10;
        return n12;
    }
}

