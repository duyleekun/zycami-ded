/*
 * Decompiled with CFR 0.151.
 */
package com.baidu.location.indoor.mapversion.b;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FilterOutputStream;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class d {
    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static boolean a(File enumeration, ByteArrayOutputStream byteArrayOutputStream) {
        try {
            ZipFile zipFile = new ZipFile((File)((Object)enumeration));
            enumeration = zipFile.entries();
            while (true) {
                int n10;
                int n11;
                boolean bl2;
                if (!(bl2 = enumeration.hasMoreElements())) {
                    zipFile.close();
                    return true;
                }
                Object object = enumeration.nextElement();
                boolean bl3 = ((ZipEntry)object).isDirectory();
                if (bl3) continue;
                object = zipFile.getInputStream((ZipEntry)object);
                BufferedInputStream bufferedInputStream = new BufferedInputStream((InputStream)object);
                int n12 = 2048;
                object = new BufferedOutputStream(byteArrayOutputStream, n12);
                byte[] byArray = new byte[n12];
                while ((n11 = bufferedInputStream.read(byArray, 0, n12)) != (n10 = -1)) {
                    ((BufferedOutputStream)object).write(byArray, 0, n11);
                }
                ((BufferedOutputStream)object).flush();
                ((FilterOutputStream)object).close();
                bufferedInputStream.close();
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return false;
        }
    }
}

