/*
 * Decompiled with CFR 0.151.
 */
package org.apache.tools.zip;

import java.util.zip.ZipException;
import org.apache.tools.zip.ZipExtraField;
import org.apache.tools.zip.ZipShort;

public final class JarMarker
implements ZipExtraField {
    private static final JarMarker DEFAULT;
    private static final ZipShort ID;
    private static final byte[] NO_BYTES;
    private static final ZipShort NULL;

    static {
        Object object = new ZipShort(51966);
        ID = object;
        object = new ZipShort(0);
        NULL = object;
        NO_BYTES = new byte[0];
        DEFAULT = object = new JarMarker();
    }

    public static JarMarker getInstance() {
        return DEFAULT;
    }

    public byte[] getCentralDirectoryData() {
        return NO_BYTES;
    }

    public ZipShort getCentralDirectoryLength() {
        return NULL;
    }

    public ZipShort getHeaderId() {
        return ID;
    }

    public byte[] getLocalFileDataData() {
        return NO_BYTES;
    }

    public ZipShort getLocalFileDataLength() {
        return NULL;
    }

    public void parseFromLocalFileData(byte[] object, int n10, int n11) {
        if (n11 == 0) {
            return;
        }
        object = new ZipException;
        object("JarMarker doesn't expect any data");
        throw object;
    }
}

