/*
 * Decompiled with CFR 0.151.
 */
package org.apache.tools.zip;

import java.util.zip.CRC32;
import java.util.zip.ZipException;
import org.apache.tools.zip.UnixStat;
import org.apache.tools.zip.ZipExtraField;
import org.apache.tools.zip.ZipLong;
import org.apache.tools.zip.ZipShort;

public class AsiExtraField
implements ZipExtraField,
UnixStat,
Cloneable {
    private static final ZipShort HEADER_ID;
    private CRC32 crc;
    private boolean dirFlag = false;
    private int gid = 0;
    private String link = "";
    private int mode = 0;
    private int uid = 0;

    static {
        ZipShort zipShort;
        HEADER_ID = zipShort = new ZipShort(30062);
    }

    public AsiExtraField() {
        CRC32 cRC32;
        this.crc = cRC32 = new CRC32();
    }

    public byte[] getCentralDirectoryData() {
        return this.getLocalFileDataData();
    }

    public ZipShort getCentralDirectoryLength() {
        return this.getLocalFileDataLength();
    }

    public int getGroupId() {
        return this.gid;
    }

    public ZipShort getHeaderId() {
        return HEADER_ID;
    }

    public String getLinkedFile() {
        return this.link;
    }

    public byte[] getLocalFileDataData() {
        int n10 = this.getLocalFileDataLength().getValue();
        int n11 = 4;
        byte[] byArray = new byte[n10 -= n11];
        byte[] byArray2 = ZipShort.getBytes(this.getMode());
        int n12 = 2;
        System.arraycopy(byArray2, 0, byArray, 0, n12);
        byArray2 = this.getLinkedFile().getBytes();
        System.arraycopy(ZipLong.getBytes(byArray2.length), 0, byArray, n12, n11);
        System.arraycopy(ZipShort.getBytes(this.getUserId()), 0, byArray, 6, n12);
        System.arraycopy(ZipShort.getBytes(this.getGroupId()), 0, byArray, 8, n12);
        n12 = byArray2.length;
        System.arraycopy(byArray2, 0, byArray, 10, n12);
        this.crc.reset();
        this.crc.update(byArray);
        long l10 = this.crc.getValue();
        byArray2 = new byte[n10 + 4];
        System.arraycopy(ZipLong.getBytes(l10), 0, byArray2, 0, n11);
        System.arraycopy(byArray, 0, byArray2, n11, n10);
        return byArray2;
    }

    public ZipShort getLocalFileDataLength() {
        int n10 = this.getLinkedFile().getBytes().length + 14;
        ZipShort zipShort = new ZipShort(n10);
        return zipShort;
    }

    public int getMode() {
        return this.mode;
    }

    public int getMode(int n10) {
        int n11 = this.isLink();
        n11 = n11 != 0 ? 40960 : ((n11 = (int)(this.isDirectory() ? 1 : 0)) != 0 ? 16384 : 32768);
        return n10 & 0xFFF | n11;
    }

    public int getUserId() {
        return this.uid;
    }

    public boolean isDirectory() {
        boolean bl2 = this.dirFlag;
        bl2 = bl2 && !(bl2 = this.isLink());
        return bl2;
    }

    public boolean isLink() {
        String string2 = this.getLinkedFile();
        int n10 = string2.length();
        if (n10) {
            n10 = 1;
        } else {
            n10 = 0;
            string2 = null;
        }
        return n10 != 0;
    }

    public void parseFromLocalFileData(byte[] object, int n10, int n11) {
        long l10 = ZipLong.getValue((byte[])object, n10);
        Object object2 = new byte[n11 += -4];
        boolean bl2 = false;
        System.arraycopy(object, n10 += 4, object2, 0, n11);
        this.crc.reset();
        this.crc.update((byte[])object2);
        object = this.crc;
        long l11 = ((CRC32)object).getValue();
        n11 = (int)(l10 == l11 ? 0 : (l10 < l11 ? -1 : 1));
        if (n11 == 0) {
            int n12;
            int n13 = ZipShort.getValue((byte[])object2, 0);
            long l12 = ZipLong.getValue((byte[])object2, 2);
            n10 = (int)l12;
            byte[] byArray = new byte[n10];
            this.uid = n12 = ZipShort.getValue((byte[])object2, 6);
            this.gid = n12 = ZipShort.getValue((byte[])object2, 8);
            if (n10 == 0) {
                String string2;
                this.link = string2 = "";
            } else {
                String string3;
                n12 = 10;
                System.arraycopy(object2, n12, byArray, 0, n10);
                this.link = string3 = new String(byArray);
            }
            n10 = n13 & 0x4000;
            if (n10 != 0) {
                bl2 = true;
            }
            this.setDirectory(bl2);
            this.setMode(n13);
            return;
        }
        object2 = new StringBuffer;
        ((StringBuffer)object2)();
        ((StringBuffer)object2).append("bad CRC checksum ");
        String string4 = Long.toHexString(l10);
        ((StringBuffer)object2).append(string4);
        ((StringBuffer)object2).append(" instead of ");
        object = Long.toHexString(l11);
        ((StringBuffer)object2).append((String)object);
        object = ((StringBuffer)object2).toString();
        ZipException zipException = new ZipException((String)object);
        throw zipException;
    }

    public void setDirectory(boolean bl2) {
        int n10;
        this.dirFlag = bl2;
        int n11 = this.mode;
        this.mode = n10 = this.getMode(n11);
    }

    public void setGroupId(int n10) {
        this.gid = n10;
    }

    public void setLinkedFile(String string2) {
        this.link = string2;
        int n10 = this.mode;
        this.mode = n10 = this.getMode(n10);
    }

    public void setMode(int n10) {
        this.mode = n10 = this.getMode(n10);
    }

    public void setUserId(int n10) {
        this.uid = n10;
    }
}

