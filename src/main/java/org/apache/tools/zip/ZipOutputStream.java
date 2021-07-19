/*
 * Decompiled with CFR 0.151.
 */
package org.apache.tools.zip;

import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Hashtable;
import java.util.Vector;
import java.util.zip.CRC32;
import java.util.zip.Deflater;
import java.util.zip.ZipException;
import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipLong;
import org.apache.tools.zip.ZipShort;

public class ZipOutputStream
extends FilterOutputStream {
    public static final byte[] CFH_SIG;
    public static final byte[] DD_SIG;
    public static final int DEFAULT_COMPRESSION = 255;
    public static final int DEFLATED = 8;
    private static final byte[] DOS_TIME_MIN;
    public static final byte[] EOCD_SIG;
    public static final byte[] LFH_SIG;
    private static final byte[] LZERO;
    public static final int STORED;
    private static final byte[] ZERO;
    public byte[] buf;
    private long cdLength;
    private long cdOffset;
    private String comment;
    private CRC32 crc;
    private long dataStart;
    public Deflater def;
    private String encoding;
    private Vector entries;
    private ZipEntry entry;
    private boolean hasCompressionLevelChanged;
    private int level;
    private long localDataStart;
    private int method;
    private Hashtable offsets;
    private RandomAccessFile raf;
    private long written;

    static {
        byte[] byArray = new byte[]{0, 0};
        ZERO = byArray;
        byte[] byArray2 = byArray = new byte[4];
        byte[] byArray3 = byArray;
        byArray2[0] = 0;
        byArray3[1] = 0;
        byArray2[2] = 0;
        byArray3[3] = 0;
        LZERO = byArray;
        LFH_SIG = ZipLong.getBytes(67324752L);
        DD_SIG = ZipLong.getBytes(134695760L);
        CFH_SIG = ZipLong.getBytes(33639248L);
        EOCD_SIG = ZipLong.getBytes(101010256L);
        DOS_TIME_MIN = ZipLong.getBytes(8448L);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public ZipOutputStream(File file) {
        long l10;
        int n10;
        FileOutputStream fileOutputStream = null;
        super(null);
        this.comment = "";
        this.level = -1;
        this.hasCompressionLevelChanged = false;
        this.method = n10 = 8;
        Object object = new Vector();
        this.entries = object;
        this.crc = object = new CRC32();
        this.written = l10 = 0L;
        this.dataStart = l10;
        this.localDataStart = l10;
        this.cdOffset = l10;
        this.cdLength = l10;
        Object object2 = new Hashtable();
        this.offsets = object2;
        this.encoding = null;
        int n11 = this.level;
        boolean bl2 = true;
        this.def = object2 = new Deflater(n11, bl2);
        int n12 = 512;
        object2 = new byte[n12];
        this.buf = (byte[])object2;
        this.raf = null;
        try {
            String string2 = "rw";
            this.raf = object2 = new RandomAccessFile(file, string2);
            ((RandomAccessFile)object2).setLength(l10);
            return;
        }
        catch (IOException iOException) {
            object = this.raf;
            if (object != null) {
                try {
                    ((RandomAccessFile)object).close();
                }
                catch (IOException iOException2) {}
                this.raf = null;
            }
            fileOutputStream = new FileOutputStream(file);
            this.out = fileOutputStream;
        }
    }

    public ZipOutputStream(OutputStream hashtable) {
        super((OutputStream)((Object)hashtable));
        long l10;
        this.comment = "";
        this.level = -1;
        this.hasCompressionLevelChanged = false;
        this.method = 8;
        hashtable = new Hashtable();
        this.entries = hashtable;
        hashtable = new Hashtable();
        this.crc = hashtable;
        this.written = l10 = 0L;
        this.dataStart = l10;
        this.localDataStart = l10;
        this.cdOffset = l10;
        this.cdLength = l10;
        this.offsets = hashtable = new Hashtable();
        this.encoding = null;
        int n10 = this.level;
        Object object = new Deflater(n10, true);
        this.def = object;
        object = new byte[512];
        this.buf = (byte[])object;
        this.raf = null;
    }

    public static long adjustToLong(int n10) {
        if (n10 < 0) {
            return (long)n10 + 0x100000000L;
        }
        return n10;
    }

    public static ZipLong toDosTime(Date object) {
        object = ZipOutputStream.toDosTime(((Date)object).getTime());
        ZipLong zipLong = new ZipLong((byte[])object);
        return zipLong;
    }

    public static byte[] toDosTime(long l10) {
        int n10;
        Date date = new Date(l10);
        int n11 = date.getYear() + 1900;
        if (n11 < (n10 = 1980)) {
            return DOS_TIME_MIN;
        }
        int n12 = date.getMonth() + 1;
        n11 = n11 - n10 << 25;
        n10 = n12 << 21;
        n11 |= n10;
        n10 = date.getDate() << 16;
        n11 |= n10;
        n10 = date.getHours() << 11;
        n11 |= n10;
        n10 = date.getMinutes() << 5;
        n11 |= n10;
        n10 = date.getSeconds() >> 1;
        return ZipLong.getBytes(n11 | n10);
    }

    public void close() {
        this.finish();
        Closeable closeable = this.raf;
        if (closeable != null) {
            ((RandomAccessFile)closeable).close();
        }
        if ((closeable = this.out) != null) {
            ((OutputStream)closeable).close();
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public void closeEntry() {
        long l10;
        long l11;
        Object object = this.entry;
        if (object == null) {
            return;
        }
        object = this.crc;
        long l12 = ((CRC32)object).getValue();
        this.crc.reset();
        Object object2 = this.entry;
        int n10 = ((java.util.zip.ZipEntry)object2).getMethod();
        int n11 = 8;
        if (n10 == n11) {
            object2 = this.def;
            ((Deflater)object2).finish();
            while ((n10 = (int)(((Deflater)(object2 = this.def)).finished() ? 1 : 0)) == 0) {
                this.deflate();
            }
            object2 = this.entry;
            l11 = ZipOutputStream.adjustToLong(this.def.getTotalIn());
            ((java.util.zip.ZipEntry)object2).setSize(l11);
            object2 = this.entry;
            Deflater deflater = this.def;
            n11 = deflater.getTotalOut();
            l11 = ZipOutputStream.adjustToLong(n11);
            ((java.util.zip.ZipEntry)object2).setCompressedSize(l11);
            this.entry.setCrc(l12);
            object = this.def;
            ((Deflater)object).reset();
            l12 = this.written;
            object2 = this.entry;
            l10 = ((java.util.zip.ZipEntry)object2).getCompressedSize();
            this.written = l12 += l10;
        } else {
            object2 = this.raf;
            if (object2 == null) {
                object2 = this.entry;
                l10 = ((java.util.zip.ZipEntry)object2).getCrc();
                n10 = (int)(l10 == l12 ? 0 : (l10 < l12 ? -1 : 1));
                String string2 = " instead of ";
                String string3 = ": ";
                if (n10 != 0) {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("bad CRC checksum for entry ");
                    String string4 = this.entry.getName();
                    stringBuffer.append(string4);
                    stringBuffer.append(string3);
                    string3 = Long.toHexString(this.entry.getCrc());
                    stringBuffer.append(string3);
                    stringBuffer.append(string2);
                    object = Long.toHexString(l12);
                    stringBuffer.append((String)object);
                    object = stringBuffer.toString();
                    object2 = new ZipException((String)object);
                    throw object2;
                }
                object = this.entry;
                l12 = ((java.util.zip.ZipEntry)object).getSize();
                long l13 = this.written;
                long l14 = this.dataStart;
                long l15 = l12 - (l13 -= l14);
                Object object3 = l15 == 0L ? 0 : (l15 < 0L ? -1 : 1);
                if (object3 != false) {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("bad size for entry ");
                    object2 = this.entry.getName();
                    stringBuffer.append((String)object2);
                    stringBuffer.append(string3);
                    long l16 = this.entry.getSize();
                    stringBuffer.append(l16);
                    stringBuffer.append(string2);
                    l10 = this.written;
                    l16 = this.dataStart;
                    stringBuffer.append(l10 -= l16);
                    String string5 = stringBuffer.toString();
                    object = new ZipException(string5);
                    throw object;
                }
            } else {
                l10 = this.written;
                long l17 = this.dataStart;
                this.entry.setSize(l10 -= l17);
                ZipEntry zipEntry = this.entry;
                zipEntry.setCompressedSize(l10);
                object2 = this.entry;
                ((java.util.zip.ZipEntry)object2).setCrc(l12);
            }
        }
        object = this.raf;
        if (object != null) {
            l12 = ((RandomAccessFile)object).getFilePointer();
            object2 = this.raf;
            l11 = this.localDataStart;
            ((RandomAccessFile)object2).seek(l11);
            object2 = ZipLong.getBytes(this.entry.getCrc());
            this.writeOut((byte[])object2);
            object2 = ZipLong.getBytes(this.entry.getCompressedSize());
            this.writeOut((byte[])object2);
            l10 = this.entry.getSize();
            object2 = ZipLong.getBytes(l10);
            this.writeOut((byte[])object2);
            object2 = this.raf;
            ((RandomAccessFile)object2).seek(l12);
        }
        object = this.entry;
        this.writeDataDescriptor((ZipEntry)object);
        this.entry = null;
    }

    public final void deflate() {
        Deflater deflater = this.def;
        byte[] byArray = this.buf;
        int n10 = byArray.length;
        int n11 = deflater.deflate(byArray, 0, n10);
        if (n11 > 0) {
            byArray = this.buf;
            this.writeOut(byArray, 0, n11);
        }
    }

    public void finish() {
        long l10;
        this.closeEntry();
        this.cdOffset = l10 = this.written;
        Vector vector = this.entries;
        int n10 = vector.size();
        for (int i10 = 0; i10 < n10; ++i10) {
            ZipEntry zipEntry = (ZipEntry)this.entries.elementAt(i10);
            this.writeCentralFileHeader(zipEntry);
        }
        l10 = this.written;
        long l11 = this.cdOffset;
        this.cdLength = l10 -= l11;
        this.writeCentralDirectoryEnd();
        this.offsets.clear();
        this.entries.removeAllElements();
    }

    public void flush() {
        OutputStream outputStream = this.out;
        if (outputStream != null) {
            outputStream.flush();
        }
    }

    public byte[] getBytes(String string2) {
        Object object = this.encoding;
        if (object == null) {
            return string2.getBytes();
        }
        try {
            return string2.getBytes((String)object);
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            String string3 = unsupportedEncodingException.getMessage();
            object = new ZipException(string3);
            throw object;
        }
    }

    public String getEncoding() {
        return this.encoding;
    }

    public boolean isSeekable() {
        boolean bl2;
        RandomAccessFile randomAccessFile = this.raf;
        if (randomAccessFile != null) {
            bl2 = true;
        } else {
            bl2 = false;
            randomAccessFile = null;
        }
        return bl2;
    }

    /*
     * Enabled aggressive block sorting
     */
    public void putNextEntry(ZipEntry object) {
        long l10;
        long l11;
        long l12;
        this.closeEntry();
        this.entry = object;
        Vector vector = this.entries;
        vector.addElement(object);
        object = this.entry;
        int n10 = ((java.util.zip.ZipEntry)object).getMethod();
        int n11 = -1;
        if (n10 == n11) {
            object = this.entry;
            n11 = this.method;
            ((java.util.zip.ZipEntry)object).setMethod(n11);
        }
        if ((n10 = (int)((l12 = (l11 = ((java.util.zip.ZipEntry)(object = this.entry)).getTime()) - (l10 = (long)-1)) == 0L ? 0 : (l12 < 0L ? -1 : 1))) == 0) {
            object = this.entry;
            l11 = System.currentTimeMillis();
            ((java.util.zip.ZipEntry)object).setTime(l11);
        }
        if ((n10 = ((java.util.zip.ZipEntry)(object = this.entry)).getMethod()) == 0 && (object = this.raf) == null) {
            object = this.entry;
            l11 = ((java.util.zip.ZipEntry)object).getSize();
            long l13 = l11 - l10;
            n10 = (int)(l13 == 0L ? 0 : (l13 < 0L ? -1 : 1));
            if (n10 == 0) {
                object = new ZipException("uncompressed size is required for STORED method when not writing to a file");
                throw object;
            }
            object = this.entry;
            l11 = ((java.util.zip.ZipEntry)object).getCrc();
            long l14 = l11 - l10;
            n10 = (int)(l14 == 0L ? 0 : (l14 < 0L ? -1 : 1));
            if (n10 == 0) {
                object = new ZipException("crc checksum is required for STORED method when not writing to a file");
                throw object;
            }
            object = this.entry;
            l11 = ((java.util.zip.ZipEntry)object).getSize();
            ((java.util.zip.ZipEntry)object).setCompressedSize(l11);
        }
        if ((n10 = ((java.util.zip.ZipEntry)(object = this.entry)).getMethod()) == (n11 = 8) && (n10 = (int)(this.hasCompressionLevelChanged ? 1 : 0)) != 0) {
            object = this.def;
            n11 = this.level;
            ((Deflater)object).setLevel(n11);
            n10 = 0;
            object = null;
            this.hasCompressionLevelChanged = false;
        }
        object = this.entry;
        this.writeLocalFileHeader((ZipEntry)object);
    }

    public void setComment(String string2) {
        this.comment = string2;
    }

    public void setEncoding(String string2) {
        this.encoding = string2;
    }

    public void setLevel(int n10) {
        int n11 = -1;
        if (n10 >= n11 && n10 <= (n11 = 9)) {
            n11 = this.level;
            if (n11 != n10) {
                n11 = 1;
            } else {
                n11 = 0;
                Object var3_3 = null;
            }
            this.hasCompressionLevelChanged = n11;
            this.level = n10;
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Invalid compression level: ");
        stringBuffer.append(n10);
        String string2 = stringBuffer.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string2);
        throw illegalArgumentException;
    }

    public void setMethod(int n10) {
        this.method = n10;
    }

    public void write(int n10) {
        int n11 = 1;
        byte[] byArray = new byte[n11];
        byArray[0] = n10 = (int)((byte)(n10 & 0xFF));
        this.write(byArray, 0, n11);
    }

    public void write(byte[] byArray, int n10, int n11) {
        int n12;
        Object object = this.entry;
        int n13 = ((java.util.zip.ZipEntry)object).getMethod();
        if (n13 == (n12 = 8)) {
            if (n11 > 0 && (n13 = (int)(((Deflater)(object = this.def)).finished() ? 1 : 0)) == 0) {
                object = this.def;
                ((Deflater)object).setInput(byArray, n10, n11);
                while ((n13 = (int)(((Deflater)(object = this.def)).needsInput() ? 1 : 0)) == 0) {
                    this.deflate();
                }
            }
        } else {
            this.writeOut(byArray, n10, n11);
            long l10 = this.written;
            long l11 = n11;
            this.written = l10 += l11;
        }
        this.crc.update(byArray, n10, n11);
    }

    public void writeCentralDirectoryEnd() {
        Object object = EOCD_SIG;
        this.writeOut((byte[])object);
        object = ZERO;
        this.writeOut((byte[])object);
        this.writeOut((byte[])object);
        object = ZipShort.getBytes(this.entries.size());
        this.writeOut((byte[])object);
        this.writeOut((byte[])object);
        object = ZipLong.getBytes(this.cdLength);
        this.writeOut((byte[])object);
        object = ZipLong.getBytes(this.cdOffset);
        this.writeOut((byte[])object);
        object = this.comment;
        object = this.getBytes((String)object);
        byte[] byArray = ZipShort.getBytes(((byte[])object).length);
        this.writeOut(byArray);
        this.writeOut((byte[])object);
    }

    public void writeCentralFileHeader(ZipEntry object) {
        long l10;
        Object object2 = CFH_SIG;
        this.writeOut((byte[])object2);
        long l11 = this.written;
        long l12 = 4;
        this.written = l11 += l12;
        int n10 = ((ZipEntry)object).getPlatform();
        int n11 = 8;
        int n12 = 20;
        object2 = ZipShort.getBytes((n10 <<= n11) | n12);
        this.writeOut((byte[])object2);
        long l13 = this.written;
        long l14 = 2;
        this.written = l13 += l14;
        n10 = ((java.util.zip.ZipEntry)object).getMethod();
        if (n10 == n11 && (object2 = (Object)this.raf) == null) {
            object2 = ZipShort.getBytes(n12);
            this.writeOut((byte[])object2);
            object2 = ZipShort.getBytes(n11);
            this.writeOut((byte[])object2);
        } else {
            n10 = 10;
            object2 = ZipShort.getBytes(n10);
            this.writeOut((byte[])object2);
            object2 = ZERO;
            this.writeOut((byte[])object2);
        }
        this.written = l11 = this.written + l12;
        n10 = ((java.util.zip.ZipEntry)object).getMethod();
        object2 = ZipShort.getBytes(n10);
        this.writeOut((byte[])object2);
        this.written = l11 = this.written + l14;
        object2 = ZipOutputStream.toDosTime(((java.util.zip.ZipEntry)object).getTime());
        this.writeOut((byte[])object2);
        this.written = l11 = this.written + l12;
        object2 = ZipLong.getBytes(((java.util.zip.ZipEntry)object).getCrc());
        this.writeOut((byte[])object2);
        object2 = ZipLong.getBytes(((java.util.zip.ZipEntry)object).getCompressedSize());
        this.writeOut((byte[])object2);
        object2 = ZipLong.getBytes(((java.util.zip.ZipEntry)object).getSize());
        this.writeOut((byte[])object2);
        this.written = l11 = this.written + (long)12;
        object2 = ((ZipEntry)object).getName();
        object2 = this.getBytes((String)object2);
        n11 = ((byte[])object2).length;
        byte[] byArray = ZipShort.getBytes(n11);
        this.writeOut(byArray);
        this.written = l10 = this.written + l14;
        byArray = ((ZipEntry)object).getCentralDirectoryExtra();
        n12 = byArray.length;
        Object object3 = ZipShort.getBytes(n12);
        this.writeOut((byte[])object3);
        this.written = l10 = this.written + l14;
        object3 = ((java.util.zip.ZipEntry)object).getComment();
        if (object3 == null) {
            object3 = "";
        }
        object3 = this.getBytes((String)object3);
        byte[] byArray2 = ZipShort.getBytes(((byte[])object3).length);
        this.writeOut(byArray2);
        this.written = l13 = this.written + l14;
        byArray2 = ZERO;
        this.writeOut(byArray2);
        this.written = l13 = this.written + l14;
        byArray2 = ZipShort.getBytes(((ZipEntry)object).getInternalAttributes());
        this.writeOut(byArray2);
        this.written = l13 = this.written + l14;
        byArray2 = ZipLong.getBytes(((ZipEntry)object).getExternalAttributes());
        this.writeOut(byArray2);
        this.written = l13 = this.written + l12;
        object = (byte[])this.offsets.get(object);
        this.writeOut((byte[])object);
        this.written = l13 = this.written + l12;
        this.writeOut((byte[])object2);
        l12 = this.written;
        l13 = ((byte[])object2).length;
        this.written = l12 += l13;
        this.writeOut(byArray);
        l12 = this.written;
        l11 = byArray.length;
        this.written = l12 += l11;
        this.writeOut((byte[])object3);
        l11 = this.written;
        l12 = ((byte[])object3).length;
        this.written = l11 += l12;
    }

    public void writeDataDescriptor(ZipEntry object) {
        int n10;
        int n11 = ((java.util.zip.ZipEntry)object).getMethod();
        if (n11 == (n10 = 8) && (object = this.raf) == null) {
            object = DD_SIG;
            this.writeOut((byte[])object);
            object = ZipLong.getBytes(this.entry.getCrc());
            this.writeOut((byte[])object);
            object = ZipLong.getBytes(this.entry.getCompressedSize());
            this.writeOut((byte[])object);
            object = ZipLong.getBytes(this.entry.getSize());
            this.writeOut((byte[])object);
            long l10 = this.written;
            long l11 = 16;
            this.written = l10 += l11;
        }
    }

    public void writeLocalFileHeader(ZipEntry object) {
        long l10;
        Object object2;
        Object object3 = this.offsets;
        long l11 = this.written;
        byte[] byArray = ZipLong.getBytes(l11);
        ((Hashtable)object3).put(object, byArray);
        object3 = LFH_SIG;
        this.writeOut((byte[])object3);
        long l12 = this.written;
        long l13 = 4;
        this.written = l12 += l13;
        int n10 = ((java.util.zip.ZipEntry)object).getMethod();
        int n11 = 8;
        if (n10 == n11 && (object2 = this.raf) == null) {
            int n12 = 20;
            object2 = ZipShort.getBytes(n12);
            this.writeOut((byte[])object2);
            object2 = ZipShort.getBytes(n11);
            this.writeOut((byte[])object2);
        } else {
            int n13 = 10;
            object2 = ZipShort.getBytes(n13);
            this.writeOut((byte[])object2);
            object2 = ZERO;
            this.writeOut((byte[])object2);
        }
        this.written = l10 = this.written + l13;
        object2 = ZipShort.getBytes(n10);
        this.writeOut((byte[])object2);
        l10 = this.written;
        long l14 = 2;
        this.written = l10 += l14;
        object2 = ZipOutputStream.toDosTime(((java.util.zip.ZipEntry)object).getTime());
        this.writeOut((byte[])object2);
        this.written = l10 = this.written + l13;
        this.localDataStart = l10;
        if (n10 != n11 && (object3 = this.raf) == null) {
            object3 = ZipLong.getBytes(((java.util.zip.ZipEntry)object).getCrc());
            this.writeOut((byte[])object3);
            object3 = ZipLong.getBytes(((java.util.zip.ZipEntry)object).getSize());
            this.writeOut((byte[])object3);
            l12 = ((java.util.zip.ZipEntry)object).getSize();
            object3 = ZipLong.getBytes(l12);
            this.writeOut((byte[])object3);
        } else {
            object3 = LZERO;
            this.writeOut((byte[])object3);
            this.writeOut((byte[])object3);
            this.writeOut((byte[])object3);
        }
        this.written = l12 = this.written + (long)12;
        object3 = ((ZipEntry)object).getName();
        object3 = this.getBytes((String)object3);
        byArray = ZipShort.getBytes(((Object)object3).length);
        this.writeOut(byArray);
        this.written = l11 = this.written + l14;
        object = ((ZipEntry)object).getLocalFileDataExtra();
        byArray = ZipShort.getBytes(((Object)object).length);
        this.writeOut(byArray);
        this.written = l11 = this.written + l14;
        this.writeOut((byte[])object3);
        l11 = this.written;
        long l15 = ((Object)object3).length;
        this.written = l11 += l15;
        this.writeOut((byte[])object);
        l12 = this.written;
        l13 = ((Object)object).length;
        this.written = l12 += l13;
        this.dataStart = l12;
    }

    public final void writeOut(byte[] byArray) {
        int n10 = byArray.length;
        this.writeOut(byArray, 0, n10);
    }

    public final void writeOut(byte[] byArray, int n10, int n11) {
        Closeable closeable = this.raf;
        if (closeable != null) {
            ((RandomAccessFile)closeable).write(byArray, n10, n11);
        } else {
            closeable = this.out;
            ((OutputStream)closeable).write(byArray, n10, n11);
        }
    }
}

