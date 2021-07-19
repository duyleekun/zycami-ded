/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.common;

import com.google.firebase.crashlytics.internal.common.CommonUtils;
import com.google.firebase.crashlytics.internal.common.NativeSessionFile;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.zip.GZIPOutputStream;

public class NativeSessionFileGzipper {
    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static void gzipInputStream(InputStream inputStream, File file) {
        void var0_3;
        GZIPOutputStream gZIPOutputStream;
        block6: {
            GZIPOutputStream gZIPOutputStream2;
            if (inputStream == null) {
                return;
            }
            int n10 = 8192;
            byte[] byArray = new byte[n10];
            gZIPOutputStream = null;
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                gZIPOutputStream2 = new GZIPOutputStream(fileOutputStream);
            }
            catch (Throwable throwable) {
                // empty catch block
                break block6;
            }
            try {
                int n11;
                while ((n11 = inputStream.read(byArray)) > 0) {
                    gZIPOutputStream = null;
                    gZIPOutputStream2.write(byArray, 0, n11);
                }
                gZIPOutputStream2.finish();
            }
            catch (Throwable throwable) {
                gZIPOutputStream = gZIPOutputStream2;
            }
            CommonUtils.closeQuietly(gZIPOutputStream2);
            return;
        }
        CommonUtils.closeQuietly(gZIPOutputStream);
        throw var0_3;
    }

    /*
     * Unable to fully structure code
     */
    public static void processNativeSessions(File var0, List var1_2) {
        var1_2 = var1_2.iterator();
        block7: while (var2_3 = var1_2.hasNext()) {
            block9: {
                var3_4 = (NativeSessionFile)var1_2.next();
                var4_5 = null;
                var4_5 = var3_4.getStream();
                if (var4_5 != null) break block9;
lbl8:
                // 3 sources

                while (true) {
                    CommonUtils.closeQuietly(var4_5);
                    continue block7;
                    break;
                }
            }
            var3_4 = var3_4.getReportsEndpointFilename();
            var5_6 = new File(var0, (String)var3_4);
            try {
                NativeSessionFileGzipper.gzipInputStream(var4_5, var5_6);
                ** GOTO lbl8
            }
            catch (Throwable var0_1) {
                CommonUtils.closeQuietly(var4_5);
                throw var0_1;
            }
        }
        return;
        catch (IOException v0) {
            ** continue;
        }
    }
}

