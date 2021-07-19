/*
 * Decompiled with CFR 0.151.
 */
package org.apache.tools.zip;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;
import java.util.zip.ZipException;
import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipFile$BoundedInputStream;
import org.apache.tools.zip.ZipFile$OffsetEntry;
import org.apache.tools.zip.ZipLong;
import org.apache.tools.zip.ZipOutputStream;
import org.apache.tools.zip.ZipShort;

public class ZipFile {
    private static final int CFD_LOCATOR_OFFSET = 16;
    private static final int CFH_LEN = 42;
    private static final long LFH_OFFSET_FOR_FILENAME_LENGTH = 26L;
    private static final int MIN_EOCD_SIZE = 22;
    private RandomAccessFile archive;
    private String encoding;
    private Hashtable entries;
    private Hashtable nameMap;

    public ZipFile(File file) {
        this(file, null);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public ZipFile(File file, String object) {
        int n10 = 509;
        Object object2 = new Hashtable(n10);
        this.entries = object2;
        object2 = new Hashtable(n10);
        this.nameMap = object2;
        this.encoding = null;
        this.encoding = object;
        object2 = "r";
        this.archive = object = new RandomAccessFile(file, (String)object2);
        try {
            this.populateFromCentralDirectory();
            this.resolveLocalFileHeaderData();
            return;
        }
        catch (IOException iOException) {
            try {
                object = this.archive;
            }
            catch (IOException iOException2) {
                throw iOException;
            }
            ((RandomAccessFile)object).close();
            throw iOException;
        }
    }

    public ZipFile(String string2) {
        File file = new File(string2);
        this(file, null);
    }

    public ZipFile(String string2, String string3) {
        File file = new File(string2);
        this(file, string3);
    }

    public static /* synthetic */ RandomAccessFile access$300(ZipFile zipFile) {
        return zipFile.archive;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void closeQuietly(ZipFile zipFile) {
        if (zipFile == null) return;
        try {
            zipFile.close();
            return;
        }
        catch (IOException iOException) {
            return;
        }
    }

    private static long dosToJavaTime(long l10) {
        Calendar calendar = Calendar.getInstance();
        int n10 = (int)(l10 >> 25 & (long)127) + 1980;
        int n11 = 1;
        calendar.set(n11, n10);
        n10 = (int)(l10 >> 21 & (long)15) - n11;
        calendar.set(2, n10);
        n10 = (int)(l10 >> 16) & 0x1F;
        int n12 = 5;
        calendar.set(n12, n10);
        n10 = 11;
        int n13 = (int)(l10 >> n10) & 0x1F;
        calendar.set(n10, n13);
        n10 = (int)(l10 >> n12) & 0x3F;
        calendar.set(12, n10);
        int n14 = (int)(l10 << n11) & 0x3E;
        calendar.set(13, n14);
        return calendar.getTime().getTime();
    }

    public static Date fromDosTime(ZipLong cloneable) {
        long l10 = cloneable.getValue();
        l10 = ZipFile.dosToJavaTime(l10);
        cloneable = new Date(l10);
        return cloneable;
    }

    private void populateFromCentralDirectory() {
        long l10;
        this.positionAtCentralDirectory();
        int n10 = 42;
        byte[] byArray = new byte[n10];
        int n11 = 4;
        byte[] byArray2 = new byte[n11];
        Object object = this.archive;
        ((RandomAccessFile)object).readFully(byArray2);
        long l11 = ZipLong.getValue(byArray2);
        byte[] byArray3 = ZipOutputStream.CFH_SIG;
        long l12 = ZipLong.getValue(byArray3);
        while ((l10 = l11 == l12 ? 0 : (l11 < l12 ? -1 : 1)) == false) {
            this.archive.readFully(byArray);
            ZipEntry zipEntry = new ZipEntry();
            l10 = ZipShort.getValue(byArray, 0);
            int n12 = 8;
            l10 = l10 >> n12 & 0xF;
            zipEntry.setPlatform((int)l10);
            l10 = ZipShort.getValue(byArray, 6);
            zipEntry.setMethod((int)l10);
            long l13 = ZipFile.dosToJavaTime(ZipLong.getValue(byArray, n12));
            zipEntry.setTime(l13);
            l13 = ZipLong.getValue(byArray, 12);
            zipEntry.setCrc(l13);
            l13 = ZipLong.getValue(byArray, 16);
            zipEntry.setCompressedSize(l13);
            l13 = ZipLong.getValue(byArray, 20);
            zipEntry.setSize(l13);
            l10 = ZipShort.getValue(byArray, 24);
            n12 = ZipShort.getValue(byArray, 26);
            int n13 = ZipShort.getValue(byArray, 28);
            int n14 = ZipShort.getValue(byArray, 32);
            zipEntry.setInternalAttributes(n14);
            long l14 = ZipLong.getValue(byArray, 34);
            zipEntry.setExternalAttributes(l14);
            n14 = 38;
            object = new byte[l10];
            this.archive.readFully((byte[])object);
            object = this.getString((byte[])object);
            zipEntry.setName((String)object);
            object = new ZipFile$OffsetEntry(null);
            l14 = ZipLong.getValue(byArray, n14);
            ZipFile$OffsetEntry.access$202((ZipFile$OffsetEntry)object, l14);
            this.entries.put(zipEntry, object);
            object = this.nameMap;
            String string2 = zipEntry.getName();
            ((Hashtable)object).put(string2, zipEntry);
            this.archive.skipBytes(n12);
            object = new byte[n13];
            RandomAccessFile randomAccessFile = this.archive;
            randomAccessFile.readFully((byte[])object);
            object = this.getString((byte[])object);
            zipEntry.setComment((String)object);
            object = this.archive;
            ((RandomAccessFile)object).readFully(byArray2);
            l11 = ZipLong.getValue(byArray2);
        }
    }

    private void positionAtCentralDirectory() {
        Object object;
        Object object2 = this.archive;
        long l10 = ((RandomAccessFile)object2).length() - (long)22;
        long l11 = 0L;
        long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        int n10 = 1;
        if (l12 >= 0) {
            Object object3;
            this.archive.seek(l10);
            object = ZipOutputStream.EOCD_SIG;
            RandomAccessFile randomAccessFile = this.archive;
            int n11 = randomAccessFile.read();
            while (n11 != (object3 = -1)) {
                object3 = object[0];
                if (n11 != object3 || (n11 = (randomAccessFile = this.archive).read()) != (object3 = (Object)object[n10]) || (n11 = (randomAccessFile = this.archive).read()) != (object3 = (Object)object[2]) || (n11 = (randomAccessFile = this.archive).read()) != (object3 = (Object)object[3])) {
                    randomAccessFile = this.archive;
                    long l13 = 1L;
                    randomAccessFile.seek(l10 -= l13);
                    randomAccessFile = this.archive;
                    n11 = randomAccessFile.read();
                    continue;
                }
                break;
            }
        } else {
            n10 = 0;
        }
        if (n10 != 0) {
            object = this.archive;
            ((RandomAccessFile)object).seek(l10 += (long)16);
            object2 = new byte[4];
            this.archive.readFully((byte[])object2);
            RandomAccessFile randomAccessFile = this.archive;
            l11 = ZipLong.getValue((byte[])object2);
            randomAccessFile.seek(l11);
            return;
        }
        object2 = new ZipException("archive is not a ZIP archive");
        throw object2;
    }

    private void resolveLocalFileHeaderData() {
        boolean bl2;
        Enumeration enumeration = this.getEntries();
        while (bl2 = enumeration.hasMoreElements()) {
            ZipEntry zipEntry = (ZipEntry)enumeration.nextElement();
            ZipFile$OffsetEntry zipFile$OffsetEntry = (ZipFile$OffsetEntry)this.entries.get(zipEntry);
            long l10 = ZipFile$OffsetEntry.access$200(zipFile$OffsetEntry);
            Object object = this.archive;
            ((RandomAccessFile)object).seek(l10 += (long)26);
            object = new byte[2];
            RandomAccessFile randomAccessFile = this.archive;
            randomAccessFile.readFully((byte[])object);
            int n10 = ZipShort.getValue((byte[])object);
            this.archive.readFully((byte[])object);
            int n11 = ZipShort.getValue((byte[])object);
            this.archive.skipBytes(n10);
            byte[] byArray = new byte[n11];
            RandomAccessFile randomAccessFile2 = this.archive;
            randomAccessFile2.readFully(byArray);
            zipEntry.setExtra(byArray);
            long l11 = 2;
            l10 = l10 + l11 + l11;
            long l12 = n10;
            l10 += l12;
            long l13 = n11;
            ZipFile$OffsetEntry.access$002(zipFile$OffsetEntry, l10 += l13);
        }
    }

    public void close() {
        this.archive.close();
    }

    public String getEncoding() {
        return this.encoding;
    }

    public Enumeration getEntries() {
        return this.entries.keys();
    }

    public ZipEntry getEntry(String string2) {
        return (ZipEntry)this.nameMap.get(string2);
    }

    public InputStream getInputStream(ZipEntry object) {
        ZipFile$BoundedInputStream zipFile$BoundedInputStream;
        Object object2 = (ZipFile$OffsetEntry)this.entries.get(object);
        if (object2 == null) {
            return null;
        }
        long l10 = ZipFile$OffsetEntry.access$000((ZipFile$OffsetEntry)object2);
        long l11 = ((java.util.zip.ZipEntry)object).getCompressedSize();
        object2 = zipFile$BoundedInputStream;
        Object object3 = this;
        zipFile$BoundedInputStream = new ZipFile$BoundedInputStream(this, l10, l11);
        int n10 = ((java.util.zip.ZipEntry)object).getMethod();
        if (n10 != 0) {
            int n11 = 8;
            if (n10 == n11) {
                zipFile$BoundedInputStream.addDummy();
                object2 = new Inflater(true);
                object = new InflaterInputStream(zipFile$BoundedInputStream, (Inflater)object2);
                return object;
            }
            object3 = new StringBuffer();
            ((StringBuffer)object3).append("Found unsupported compression method ");
            int n12 = ((java.util.zip.ZipEntry)object).getMethod();
            ((StringBuffer)object3).append(n12);
            object = ((StringBuffer)object3).toString();
            object2 = new ZipException((String)object);
            throw object2;
        }
        return zipFile$BoundedInputStream;
    }

    public String getString(byte[] byArray) {
        String string2;
        Object object = this.encoding;
        if (object == null) {
            object = new String(byArray);
            return object;
        }
        try {
            string2 = this.encoding;
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            String string3 = unsupportedEncodingException.getMessage();
            object = new ZipException(string3);
            throw object;
        }
        object = new String(byArray, string2);
        return object;
    }
}

