/*
 * Decompiled with CFR 0.151.
 */
package org.apache.tools.zip;

import org.apache.tools.zip.ZipExtraField;
import org.apache.tools.zip.ZipShort;

public class UnrecognizedExtraField
implements ZipExtraField {
    private byte[] centralData;
    private ZipShort headerId;
    private byte[] localData;

    public byte[] getCentralDirectoryData() {
        byte[] byArray = this.centralData;
        if (byArray != null) {
            return byArray;
        }
        return this.getLocalFileDataData();
    }

    public ZipShort getCentralDirectoryLength() {
        byte[] byArray = this.centralData;
        if (byArray != null) {
            int n10 = byArray.length;
            ZipShort zipShort = new ZipShort(n10);
            return zipShort;
        }
        return this.getLocalFileDataLength();
    }

    public ZipShort getHeaderId() {
        return this.headerId;
    }

    public byte[] getLocalFileDataData() {
        return this.localData;
    }

    public ZipShort getLocalFileDataLength() {
        int n10 = this.localData.length;
        ZipShort zipShort = new ZipShort(n10);
        return zipShort;
    }

    public void parseFromLocalFileData(byte[] byArray, int n10, int n11) {
        byte[] byArray2 = new byte[n11];
        System.arraycopy(byArray, n10, byArray2, 0, n11);
        this.setLocalFileDataData(byArray2);
    }

    public void setCentralDirectoryData(byte[] byArray) {
        this.centralData = byArray;
    }

    public void setHeaderId(ZipShort zipShort) {
        this.headerId = zipShort;
    }

    public void setLocalFileDataData(byte[] byArray) {
        this.localData = byArray;
    }
}

