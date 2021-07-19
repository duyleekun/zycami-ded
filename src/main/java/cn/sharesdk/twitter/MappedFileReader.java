/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Base64
 */
package cn.sharesdk.twitter;

import android.util.Base64;
import java.io.FileInputStream;
import java.nio.Buffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class MappedFileReader {
    private byte[] array;
    private int arraySize;
    private FileInputStream fileIn;
    private long fileLength;
    private MappedByteBuffer mappedBuf;

    public MappedFileReader(String object, int n10) {
        long l10;
        FileInputStream fileInputStream;
        this.fileIn = fileInputStream = new FileInputStream((String)object);
        FileChannel fileChannel = fileInputStream.getChannel();
        this.fileLength = l10 = fileChannel.size();
        FileChannel.MapMode mapMode = FileChannel.MapMode.READ_ONLY;
        this.mappedBuf = object = fileChannel.map(mapMode, 0L, l10);
        this.arraySize = n10;
    }

    public static String byteToBase64(byte[] byArray) {
        return Base64.encodeToString((byte[])byArray, (int)0);
    }

    public void close() {
        this.fileIn.close();
    }

    public byte[] getArray() {
        return this.array;
    }

    public long getFileLength() {
        return this.fileLength;
    }

    public int read() {
        Object object = this.mappedBuf;
        int n10 = ((Buffer)object).limit();
        Object object2 = this.mappedBuf;
        int n11 = ((Buffer)object2).position();
        if (n11 == n10) {
            return -1;
        }
        if ((n10 -= n11) > (n11 = this.arraySize)) {
            object = new byte[n11];
            this.array = (byte[])object;
            this.mappedBuf.get((byte[])object);
            return this.arraySize;
        }
        object2 = new byte[n10];
        this.array = (byte[])object2;
        this.mappedBuf.get((byte[])object2);
        return n10;
    }
}

