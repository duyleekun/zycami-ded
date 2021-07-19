/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.hms.availableupdate;

import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.IOUtils;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;

public class b
extends OutputStream {
    public RandomAccessFile a;

    public b(File object, int n10) {
        String string2 = "create  file stream failed";
        String string3 = "RandomFileOutputStream";
        String string4 = "rwd";
        RandomAccessFile randomAccessFile = new RandomAccessFile((File)object, string4);
        this.a = randomAccessFile;
        long l10 = n10;
        try {
            randomAccessFile.setLength(l10);
        }
        catch (IOException iOException) {
            object = this.a;
            IOUtils.closeQuietly((Closeable)object);
            HMSLog.e(string3, string2);
        }
        catch (FileNotFoundException fileNotFoundException) {
            HMSLog.e(string3, string2);
        }
    }

    public void a(long l10) {
        this.a.seek(l10);
    }

    public void close() {
        this.a.close();
    }

    public void write(int n10) {
        int n11 = 1;
        byte[] byArray = new byte[n11];
        byArray[0] = n10 = (int)((byte)n10);
        this.write(byArray, 0, n11);
    }

    public void write(byte[] byArray, int n10, int n11) {
        this.a.write(byArray, n10, n11);
    }
}

