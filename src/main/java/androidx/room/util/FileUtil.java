/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 */
package androidx.room.util;

import android.os.Build;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;

public class FileUtil {
    private FileUtil() {
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void copy(ReadableByteChannel readableByteChannel, FileChannel fileChannel) {
        try {
            int n10 = Build.VERSION.SDK_INT;
            int n11 = 23;
            if (n10 > n11) {
                long l10 = 0L;
                long l11 = Long.MAX_VALUE;
                FileChannel fileChannel2 = fileChannel;
                fileChannel.transferFrom(readableByteChannel, l10, l11);
            } else {
                int n12;
                InputStream inputStream = Channels.newInputStream(readableByteChannel);
                OutputStream outputStream = Channels.newOutputStream(fileChannel);
                int n13 = 4096;
                byte[] byArray = new byte[n13];
                while ((n12 = inputStream.read(byArray)) > 0) {
                    outputStream.write(byArray, 0, n12);
                }
            }
            fileChannel.force(false);
            return;
        }
        finally {
            readableByteChannel.close();
            fileChannel.close();
        }
    }
}

