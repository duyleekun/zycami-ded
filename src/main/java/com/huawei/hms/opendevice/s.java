/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.hms.opendevice;

import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.IOUtils;
import d.j.f.a.a.k.d;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;

public abstract class s {
    public static String a(InputStream inputStream) {
        int n10;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int n11 = inputStream.read();
        while ((n10 = -1) != n11) {
            byteArrayOutputStream.write(n11);
            n11 = inputStream.read();
        }
        String string2 = byteArrayOutputStream.toString("UTF-8");
        s.a((Closeable)inputStream);
        d.d(byteArrayOutputStream);
        return string2;
    }

    /*
     * Unable to fully structure code
     */
    public static String a(String var0) {
        block23: {
            block22: {
                var1_5 = "StreamUtil";
                var2_6 = new File((String)var0);
                var0 = new StringBuilder();
                var3_7 = null;
                var5_9 = new FileInputStream((File)var2_6);
                var2_6 = "UTF-8";
                var4_8 = new InputStreamReader((InputStream)var5_9, (String)var2_6);
                try {
                    var2_6 = new BufferedReader(var4_8);
                }
                catch (IOException v4) {
                    ** continue;
                }
                catch (FileNotFoundException v5) {
                    ** continue;
                }
                while (true) {
                    var3_7 = var2_6.readLine();
                    if (var3_7 == null) break;
                    var0.append((String)var3_7);
                    continue;
                    break;
                }
                IOUtils.closeQuietly(var4_8);
                IOUtils.closeQuietly((Reader)var2_6);
                ** GOTO lbl52
                catch (Throwable var0_1) {
                    var3_7 = var2_6;
                    ** GOTO lbl55
                }
                catch (IOException v0) {
                    var3_7 = var2_6;
                    break block22;
                }
                catch (FileNotFoundException v1) {
                    var3_7 = var2_6;
                    break block23;
                }
                catch (Throwable var0_2) {
                    var4_8 = null;
                    ** GOTO lbl55
                }
                catch (IOException v2) {
                    var4_8 = null;
                }
            }
lbl38:
            // 2 sources

            while (true) {
                var2_6 = "read value IOException.";
                HMSLog.e(var1_5, (String)var2_6);
                ** GOTO lbl50
                break;
            }
            catch (FileNotFoundException v3) {
                var4_8 = null;
            }
        }
lbl46:
        // 2 sources

        while (true) {
            var2_6 = "file not exist.";
            try {
                HMSLog.e(var1_5, (String)var2_6);
            }
            catch (Throwable var0_3) {
                // empty catch block
            }
lbl50:
            // 2 sources

            IOUtils.closeQuietly(var4_8);
            IOUtils.closeQuietly(var3_7);
lbl52:
            // 2 sources

            return var0.toString();
lbl55:
            // 3 sources

            IOUtils.closeQuietly(var4_8);
            IOUtils.closeQuietly(var3_7);
            throw var0_4;
        }
    }

    public static void a(Closeable object) {
        if (object != null) {
            try {
                object.close();
            }
            catch (IOException iOException) {
                object = "StreamUtil";
                String string2 = "close IOException";
                HMSLog.w((String)object, string2);
            }
        }
    }

    public static void a(File serializable) {
        boolean bl2 = ((File)serializable).exists();
        if (bl2) {
            return;
        }
        File file = ((File)serializable).getParentFile();
        String string2 = "StreamUtil";
        if (file != null) {
            file = ((File)serializable).getParentFile();
            bl2 = file.exists();
            if (!bl2 && !(bl2 = (file = ((File)serializable).getParentFile()).mkdirs())) {
                HMSLog.e(string2, "make parent dirs failed.");
                serializable = new IOException("make parent dirs failed");
                throw serializable;
            }
            boolean bl3 = ((File)serializable).createNewFile();
            if (bl3) {
                return;
            }
            HMSLog.e(string2, "create file failed.");
            serializable = new IOException("create file failed");
            throw serializable;
        }
        HMSLog.e(string2, "parent file is null.");
        serializable = new IOException("parent file is null");
        throw serializable;
    }

    public static void a(HttpURLConnection object) {
        if (object != null) {
            try {
                ((HttpURLConnection)object).disconnect();
            }
            catch (Throwable throwable) {
                object = "StreamUtil";
                String string2 = "close HttpURLConnection Exception";
                HMSLog.w((String)object, string2);
            }
        }
    }
}

