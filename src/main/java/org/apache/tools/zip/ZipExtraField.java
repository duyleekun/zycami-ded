/*
 * Decompiled with CFR 0.151.
 */
package org.apache.tools.zip;

import org.apache.tools.zip.ZipShort;

public interface ZipExtraField {
    public byte[] getCentralDirectoryData();

    public ZipShort getCentralDirectoryLength();

    public ZipShort getHeaderId();

    public byte[] getLocalFileDataData();

    public ZipShort getLocalFileDataLength();

    public void parseFromLocalFileData(byte[] var1, int var2, int var3);
}

