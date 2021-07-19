/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.log;

import com.google.firebase.crashlytics.internal.log.QueueFile$1;
import com.google.firebase.crashlytics.internal.log.QueueFile$Element;
import com.google.firebase.crashlytics.internal.log.QueueFile$ElementInputStream;
import com.google.firebase.crashlytics.internal.log.QueueFile$ElementReader;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class QueueFile
implements Closeable {
    public static final int HEADER_LENGTH = 16;
    private static final int INITIAL_LENGTH = 4096;
    private static final Logger LOGGER = Logger.getLogger(QueueFile.class.getName());
    private final byte[] buffer;
    private int elementCount;
    public int fileLength;
    private QueueFile$Element first;
    private QueueFile$Element last;
    private final RandomAccessFile raf;

    public QueueFile(File object) {
        byte[] byArray = new byte[16];
        this.buffer = byArray;
        boolean bl2 = ((File)object).exists();
        if (!bl2) {
            QueueFile.initialize((File)object);
        }
        this.raf = object = QueueFile.open((File)object);
        this.readHeader();
    }

    public QueueFile(RandomAccessFile randomAccessFile) {
        byte[] byArray = new byte[16];
        this.buffer = byArray;
        this.raf = randomAccessFile;
        this.readHeader();
    }

    public static /* synthetic */ int access$100(QueueFile queueFile, int n10) {
        return queueFile.wrapPosition(n10);
    }

    public static /* synthetic */ Object access$200(Object object, String string2) {
        return QueueFile.nonNull(object, string2);
    }

    public static /* synthetic */ void access$300(QueueFile queueFile, int n10, byte[] byArray, int n11, int n12) {
        queueFile.ringRead(n10, byArray, n11, n12);
    }

    public static /* synthetic */ RandomAccessFile access$400(QueueFile queueFile) {
        return queueFile.raf;
    }

    private void expandIfNecessary(int n10) {
        int n11 = this.remainingBytes();
        if (n11 >= (n10 += 4)) {
            return;
        }
        int n12 = this.fileLength;
        while ((n11 += (n12 <<= 1)) < n10) {
        }
        this.setLength(n12);
        Object object = this.last;
        n11 = ((QueueFile$Element)object).position + 4;
        n10 = ((QueueFile$Element)object).length;
        n11 += n10;
        n10 = this.wrapPosition(n11);
        Object object2 = this.first;
        n11 = ((QueueFile$Element)object2).position;
        if (n10 < n11) {
            object2 = this.raf;
            FileChannel fileChannel = ((RandomAccessFile)object2).getChannel();
            n11 = this.fileLength;
            long l10 = n11;
            fileChannel.position(l10);
            long l11 = 16;
            long l12 = n10 += -4;
            l10 = fileChannel.transferTo(l11, l12, fileChannel);
            n10 = (int)(l10 == l12 ? 0 : (l10 < l12 ? -1 : 1));
            if (n10 != 0) {
                object = new AssertionError((Object)"Copied insufficient number of bytes!");
                throw object;
            }
        }
        object = this.last;
        n10 = ((QueueFile$Element)object).position;
        object2 = this.first;
        n11 = ((QueueFile$Element)object2).position;
        if (n10 < n11) {
            int n13 = this.fileLength + n10 + -16;
            n10 = this.elementCount;
            this.writeHeader(n12, n10, n11, n13);
            object2 = this.last;
            n11 = ((QueueFile$Element)object2).length;
            this.last = object = new QueueFile$Element(n13, n11);
        } else {
            int n14 = this.elementCount;
            this.writeHeader(n12, n14, n11, n10);
        }
        this.fileLength = n12;
    }

    private static void initialize(File serializable) {
        int n10;
        Object object = new StringBuilder();
        Object object2 = serializable.getPath();
        ((StringBuilder)object).append((String)object2);
        object2 = ".tmp";
        ((StringBuilder)object).append((String)object2);
        object = ((StringBuilder)object).toString();
        File file = new File((String)object);
        object = QueueFile.open(file);
        long l10 = 4096L;
        ((RandomAccessFile)object).setLength(l10);
        l10 = 0L;
        ((RandomAccessFile)object).seek(l10);
        int n11 = 16;
        object2 = new byte[n11];
        int n12 = 4;
        int[] nArray = new int[n12];
        nArray[0] = n10 = 4096;
        n10 = 1;
        nArray[n10] = 0;
        n10 = 2;
        nArray[n10] = 0;
        n10 = 3;
        nArray[n10] = 0;
        QueueFile.writeInts((byte[])object2, nArray);
        ((RandomAccessFile)object).write((byte[])object2);
        boolean bl2 = file.renameTo((File)serializable);
        if (bl2) {
            return;
        }
        serializable = new IOException("Rename failed!");
        throw serializable;
        finally {
            ((RandomAccessFile)object).close();
        }
    }

    private static Object nonNull(Object object, String string2) {
        Objects.requireNonNull(object, string2);
        return object;
    }

    private static RandomAccessFile open(File file) {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rwd");
        return randomAccessFile;
    }

    private QueueFile$Element readElement(int n10) {
        if (n10 == 0) {
            return QueueFile$Element.NULL;
        }
        Object object = this.raf;
        long l10 = n10;
        ((RandomAccessFile)object).seek(l10);
        int n11 = this.raf.readInt();
        object = new QueueFile$Element(n10, n11);
        return object;
    }

    private void readHeader() {
        int n10;
        Object object = this.raf;
        long l10 = 0L;
        ((RandomAccessFile)object).seek(l10);
        object = this.raf;
        Object object2 = this.buffer;
        ((RandomAccessFile)object).readFully((byte[])object2);
        object = this.buffer;
        int n11 = 0;
        object2 = null;
        this.fileLength = n10 = QueueFile.readInt((byte[])object, 0);
        long l11 = n10;
        RandomAccessFile randomAccessFile = this.raf;
        long l12 = randomAccessFile.length();
        n10 = (int)(l11 == l12 ? 0 : (l11 < l12 ? -1 : 1));
        if (n10 <= 0) {
            this.elementCount = n10 = QueueFile.readInt(this.buffer, 4);
            n10 = QueueFile.readInt(this.buffer, 8);
            n11 = QueueFile.readInt(this.buffer, 12);
            this.first = object = this.readElement(n10);
            this.last = object = this.readElement(n11);
            return;
        }
        object2 = new StringBuilder;
        ((StringBuilder)object2)();
        ((StringBuilder)object2).append("File is truncated. Expected length: ");
        int n12 = this.fileLength;
        ((StringBuilder)object2).append(n12);
        ((StringBuilder)object2).append(", Actual length: ");
        l12 = this.raf.length();
        ((StringBuilder)object2).append(l12);
        object2 = ((StringBuilder)object2).toString();
        object = new IOException((String)object2);
        throw object;
    }

    private static int readInt(byte[] byArray, int n10) {
        int n11 = (byArray[n10] & 0xFF) << 24;
        int n12 = n10 + 1;
        n12 = (byArray[n12] & 0xFF) << 16;
        n11 += n12;
        n12 = n10 + 2;
        n12 = (byArray[n12] & 0xFF) << 8;
        int n13 = byArray[n10 += 3] & 0xFF;
        return (n11 += n12) + n13;
    }

    private int remainingBytes() {
        int n10 = this.fileLength;
        int n11 = this.usedBytes();
        return n10 - n11;
    }

    private void ringRead(int n10, byte[] byArray, int n11, int n12) {
        int n13;
        int n14 = (n10 = this.wrapPosition(n10)) + n12;
        if (n14 <= (n13 = this.fileLength)) {
            RandomAccessFile randomAccessFile = this.raf;
            long l10 = n10;
            randomAccessFile.seek(l10);
            RandomAccessFile randomAccessFile2 = this.raf;
            randomAccessFile2.readFully(byArray, n11, n12);
        } else {
            RandomAccessFile randomAccessFile = this.raf;
            long l11 = n10;
            randomAccessFile.seek(l11);
            this.raf.readFully(byArray, n11, n13 -= n10);
            RandomAccessFile randomAccessFile3 = this.raf;
            l11 = 16;
            randomAccessFile3.seek(l11);
            randomAccessFile3 = this.raf;
            randomAccessFile3.readFully(byArray, n11 += n13, n12 -= n13);
        }
    }

    private void ringWrite(int n10, byte[] byArray, int n11, int n12) {
        int n13;
        int n14 = (n10 = this.wrapPosition(n10)) + n12;
        if (n14 <= (n13 = this.fileLength)) {
            RandomAccessFile randomAccessFile = this.raf;
            long l10 = n10;
            randomAccessFile.seek(l10);
            RandomAccessFile randomAccessFile2 = this.raf;
            randomAccessFile2.write(byArray, n11, n12);
        } else {
            RandomAccessFile randomAccessFile = this.raf;
            long l11 = n10;
            randomAccessFile.seek(l11);
            this.raf.write(byArray, n11, n13 -= n10);
            RandomAccessFile randomAccessFile3 = this.raf;
            l11 = 16;
            randomAccessFile3.seek(l11);
            randomAccessFile3 = this.raf;
            randomAccessFile3.write(byArray, n11 += n13, n12 -= n13);
        }
    }

    private void setLength(int n10) {
        RandomAccessFile randomAccessFile = this.raf;
        long l10 = n10;
        randomAccessFile.setLength(l10);
        this.raf.getChannel().force(true);
    }

    private int wrapPosition(int n10) {
        int n11 = this.fileLength;
        if (n10 >= n11) {
            n10 = n10 + 16 - n11;
        }
        return n10;
    }

    private void writeHeader(int n10, int n11, int n12, int n13) {
        byte[] byArray = this.buffer;
        int[] nArray = new int[]{n10, n11, n12, n13};
        QueueFile.writeInts(byArray, nArray);
        this.raf.seek(0L);
        RandomAccessFile randomAccessFile = this.raf;
        byte[] byArray2 = this.buffer;
        randomAccessFile.write(byArray2);
    }

    private static void writeInt(byte[] byArray, int n10, int n11) {
        byte by2;
        int n12;
        byArray[n10] = n12 = (int)(n11 >> 24);
        n12 = n10 + 1;
        byArray[n12] = by2 = (byte)(n11 >> 16);
        n12 = n10 + 2;
        byArray[n12] = by2 = (byte)(n11 >> 8);
        byArray[n10 += 3] = n11 = (int)((byte)n11);
    }

    private static void writeInts(byte[] byArray, int ... nArray) {
        int n10 = nArray.length;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            int n12 = nArray[i10];
            QueueFile.writeInt(byArray, n11, n12);
            n11 += 4;
        }
    }

    public void add(byte[] byArray) {
        int n10 = byArray.length;
        this.add(byArray, 0, n10);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void add(byte[] object, int n10, int n11) {
        synchronized (this) {
            int n12;
            int n13;
            String string2 = "buffer";
            QueueFile.nonNull(object, string2);
            int n14 = n13 | n12;
            if (n14 >= 0 && n12 <= (n14 = ((byte[])object).length - n13)) {
                int n15;
                Object object2;
                int n16;
                this.expandIfNecessary(n12);
                n14 = (int)(this.isEmpty() ? 1 : 0);
                int n17 = 4;
                if (n14 != 0) {
                    n16 = 16;
                } else {
                    object2 = this.last;
                    int n18 = ((QueueFile$Element)object2).position + n17;
                    n16 = ((QueueFile$Element)object2).length;
                    n18 += n16;
                    n16 = this.wrapPosition(n18);
                }
                QueueFile$Element queueFile$Element = new QueueFile$Element(n16, n12);
                object2 = this.buffer;
                QueueFile.writeInt((byte[])object2, 0, n12);
                n16 = queueFile$Element.position;
                byte[] byArray = this.buffer;
                this.ringWrite(n16, byArray, 0, n17);
                n16 = queueFile$Element.position + n17;
                this.ringWrite(n16, (byte[])object, n13, n12);
                if (n14 != 0) {
                    n15 = queueFile$Element.position;
                } else {
                    QueueFile$Element queueFile$Element2 = this.first;
                    n15 = queueFile$Element2.position;
                }
                n13 = this.fileLength;
                n12 = this.elementCount + 1;
                n17 = queueFile$Element.position;
                this.writeHeader(n13, n12, n15, n17);
                this.last = queueFile$Element;
                this.elementCount = n15 = this.elementCount + 1;
                if (n14 != 0) {
                    this.first = queueFile$Element;
                }
                return;
            }
            IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException();
            throw indexOutOfBoundsException;
        }
    }

    public void clear() {
        synchronized (this) {
            int n10;
            block8: {
                int n11 = 0;
                QueueFile$Element queueFile$Element = null;
                n10 = 4096;
                this.writeHeader(n10, 0, 0, 0);
                this.elementCount = 0;
                queueFile$Element = QueueFile$Element.NULL;
                this.first = queueFile$Element;
                this.last = queueFile$Element;
                n11 = this.fileLength;
                if (n11 <= n10) break block8;
                this.setLength(n10);
            }
            this.fileLength = n10;
            return;
        }
    }

    public void close() {
        synchronized (this) {
            RandomAccessFile randomAccessFile = this.raf;
            randomAccessFile.close();
            return;
        }
    }

    public void forEach(QueueFile$ElementReader queueFile$ElementReader) {
        synchronized (this) {
            QueueFile$Element queueFile$Element = this.first;
            int n10 = queueFile$Element.position;
            int n11 = 0;
            while (true) {
                int n12 = this.elementCount;
                if (n11 >= n12) break;
                queueFile$Element = this.readElement(n10);
                int n13 = 0;
                QueueFile$ElementInputStream queueFile$ElementInputStream = new QueueFile$ElementInputStream(this, queueFile$Element, null);
                n13 = queueFile$Element.length;
                queueFile$ElementReader.read(queueFile$ElementInputStream, n13);
                n12 = queueFile$Element.position + 4;
                n10 = queueFile$Element.length;
                n12 += n10;
                n10 = this.wrapPosition(n12);
                ++n11;
                continue;
                break;
            }
            return;
        }
    }

    public boolean hasSpaceFor(int n10, int n11) {
        int n12 = this.usedBytes() + 4 + n10;
        n10 = n12 <= n11 ? 1 : 0;
        return n10 != 0;
    }

    /*
     * WARNING - void declaration
     */
    public boolean isEmpty() {
        synchronized (this) {
            void var1_4;
            block4: {
                int bl2 = this.elementCount;
                if (bl2 == 0) {
                    boolean bl3 = true;
                    break block4;
                }
                boolean bl4 = false;
                Object var2_5 = null;
            }
            return (boolean)var1_4;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void peek(QueueFile$ElementReader queueFile$ElementReader) {
        synchronized (this) {
            int n10 = this.elementCount;
            if (n10 > 0) {
                QueueFile$Element queueFile$Element = this.first;
                QueueFile$ElementInputStream queueFile$ElementInputStream = new QueueFile$ElementInputStream(this, queueFile$Element, null);
                queueFile$Element = this.first;
                int n11 = queueFile$Element.length;
                queueFile$ElementReader.read(queueFile$ElementInputStream, n11);
            }
            return;
        }
    }

    public byte[] peek() {
        synchronized (this) {
            int n10;
            block8: {
                n10 = this.isEmpty();
                if (n10 == 0) break block8;
                return null;
            }
            QueueFile$Element queueFile$Element = this.first;
            int n11 = queueFile$Element.length;
            byte[] byArray = new byte[n11];
            n10 = queueFile$Element.position + 4;
            this.ringRead(n10, byArray, 0, n11);
            return byArray;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void remove() {
        synchronized (this) {
            int n10 = this.isEmpty();
            if (n10 != 0) {
                NoSuchElementException noSuchElementException = new NoSuchElementException();
                throw noSuchElementException;
            }
            n10 = this.elementCount;
            int n11 = 1;
            if (n10 == n11) {
                this.clear();
            } else {
                QueueFile$Element queueFile$Element;
                QueueFile$Element queueFile$Element2 = this.first;
                int n12 = queueFile$Element2.position;
                int n13 = 4;
                n12 += n13;
                n10 = queueFile$Element2.length;
                n12 += n10;
                n10 = this.wrapPosition(n12);
                byte[] byArray = this.buffer;
                int n14 = 0;
                this.ringRead(n10, byArray, 0, n13);
                byArray = this.buffer;
                n12 = QueueFile.readInt(byArray, 0);
                n13 = this.fileLength;
                n14 = this.elementCount - n11;
                QueueFile$Element queueFile$Element3 = this.last;
                int n15 = queueFile$Element3.position;
                this.writeHeader(n13, n14, n10, n15);
                this.elementCount = n13 = this.elementCount - n11;
                this.first = queueFile$Element = new QueueFile$Element(n10, n12);
            }
            return;
        }
    }

    public int size() {
        synchronized (this) {
            int n10 = this.elementCount;
            return n10;
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Object object = this.getClass().getSimpleName();
        stringBuilder.append((String)object);
        stringBuilder.append('[');
        stringBuilder.append("fileLength=");
        int n10 = this.fileLength;
        stringBuilder.append(n10);
        stringBuilder.append(", size=");
        n10 = this.elementCount;
        stringBuilder.append(n10);
        stringBuilder.append(", first=");
        object = this.first;
        stringBuilder.append(object);
        stringBuilder.append(", last=");
        object = this.last;
        stringBuilder.append(object);
        object = ", element lengths=[";
        stringBuilder.append((String)object);
        object = new QueueFile$1(this, stringBuilder);
        try {
            this.forEach((QueueFile$ElementReader)object);
        }
        catch (IOException iOException) {
            Logger logger = LOGGER;
            Level level = Level.WARNING;
            String string2 = "read error";
            logger.log(level, string2, iOException);
        }
        stringBuilder.append("]]");
        return stringBuilder.toString();
    }

    public int usedBytes() {
        int n10 = this.elementCount;
        int n11 = 16;
        if (n10 == 0) {
            return n11;
        }
        QueueFile$Element queueFile$Element = this.last;
        int n12 = queueFile$Element.position;
        QueueFile$Element queueFile$Element2 = this.first;
        int n13 = queueFile$Element2.position;
        if (n12 >= n13) {
            n12 = n12 - n13 + 4;
            n10 = queueFile$Element.length;
            return n12 + n10 + n11;
        }
        n12 += 4;
        n10 = queueFile$Element.length;
        n12 += n10;
        n10 = this.fileLength;
        return n12 + n10 - n13;
    }
}

