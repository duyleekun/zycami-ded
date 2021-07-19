/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.AssetManager
 *  android.net.ConnectivityManager
 *  android.text.TextUtils
 */
package com.tencent.liteav.basic.util;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.ConnectivityManager;
import android.text.TextUtils;
import com.tencent.liteav.basic.log.TXCLog;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;

public class d {
    public static long a(File file) {
        return d.a(file, 5);
    }

    public static long a(File fileArray, int n10) {
        long l10 = 0L;
        if (n10 <= 0) {
            return l10;
        }
        fileArray = fileArray.listFiles();
        int n11 = fileArray.length;
        for (int i10 = 0; i10 < n11; ++i10) {
            long l11;
            block10: {
                File file;
                block9: {
                    file = fileArray[i10];
                    int n12 = file.isDirectory();
                    if (n12 == 0) break block9;
                    n12 = n10 + -1;
                    l11 = d.a(file, n12);
                    break block10;
                }
                try {
                    l11 = file.length();
                }
                catch (Exception exception) {
                    CharSequence charSequence = new StringBuilder();
                    String string2 = "getFolderSize exception ";
                    charSequence.append(string2);
                    String string3 = exception.toString();
                    charSequence.append(string3);
                    string3 = charSequence.toString();
                    charSequence = "FileUtil";
                    TXCLog.i((String)charSequence, string3);
                    break;
                }
            }
            l10 += l11;
            continue;
        }
        return l10;
    }

    /*
     * Loose catch block
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void a(Context object, String object2, String string2) {
        void var2_10;
        void var3_20;
        FileOutputStream fileOutputStream;
        block17: {
            block18: {
                void var3_19;
                void var2_12;
                block19: {
                    InputStream inputStream;
                    block16: {
                        block15: {
                            void var2_6;
                            AssetManager assetManager = object.getAssets();
                            Object var3_16 = null;
                            inputStream = assetManager.open((String)((Object)fileOutputStream));
                            fileOutputStream = new FileOutputStream((String)var2_6);
                            try {
                                d.a(inputStream, fileOutputStream);
                            }
                            catch (Throwable throwable) {
                                break block15;
                            }
                            catch (IOException iOException) {
                                break block16;
                            }
                            d.a(inputStream);
                            break block18;
                            catch (Throwable throwable) {
                                fileOutputStream = null;
                            }
                        }
                        InputStream inputStream2 = inputStream;
                        break block17;
                        catch (IOException iOException) {
                            fileOutputStream = null;
                        }
                    }
                    InputStream inputStream3 = inputStream;
                    break block19;
                    catch (Throwable throwable) {
                        fileOutputStream = null;
                        break block17;
                    }
                    catch (IOException iOException) {
                        fileOutputStream = null;
                    }
                }
                String string3 = "FileUtil";
                String string4 = "copy asset file failed.";
                TXCLog.e(string3, string4, (Throwable)var2_12);
                d.a((Closeable)var3_19);
                if (fileOutputStream == null) return;
            }
            try {
                fileOutputStream.flush();
                ((OutputStream)fileOutputStream).close();
                return;
            }
            catch (IOException iOException) {}
            return;
            catch (Throwable throwable) {
                // empty catch block
            }
        }
        d.a((Closeable)var3_20);
        if (fileOutputStream == null) throw var2_10;
        try {
            fileOutputStream.flush();
            ((OutputStream)fileOutputStream).close();
        }
        catch (IOException iOException) {
            throw var2_10;
        }
        throw var2_10;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void a(Closeable closeable) {
        if (closeable == null) return;
        try {
            closeable.close();
            return;
        }
        catch (IOException iOException) {
            return;
        }
    }

    public static void a(InputStream inputStream, OutputStream outputStream) {
        int n10;
        int n11;
        int n12 = 1024;
        byte[] byArray = new byte[n12];
        while ((n11 = inputStream.read(byArray)) != (n10 = -1)) {
            n10 = 0;
            outputStream.write(byArray, 0, n11);
        }
    }

    /*
     * Unable to fully structure code
     */
    public static void a(String var0, byte[] var1_1) {
        block25: {
            block24: {
                block27: {
                    block26: {
                        var2_9 = null;
                        var3_10 = new File((String)var0);
                        var0 = new FileOutputStream((File)var3_10);
                        var3_10 = new BufferedOutputStream((OutputStream)var0);
                        var3_10.write(var1_1);
                        try {
                            var3_10.close();
lbl12:
                            // 2 sources

                            while (true) {
                                var0.close();
                                break block24;
                                break;
                            }
                        }
                        catch (Exception v0) {}
                        catch (Throwable var1_2) {
                            var2_9 = var3_10;
                            break block25;
                        }
                        catch (Exception var1_3) {
                            var2_9 = var3_10;
                            break block26;
                        }
                        catch (Exception var1_4) {
                            break block26;
                        }
                        catch (Throwable var1_5) {
                            var0 = null;
                            break block25;
                        }
                        catch (Exception var1_6) {
                            var0 = null;
                        }
                    }
                    var3_10 = "FileUtil";
                    var4_11 = "write file failed.";
                    TXCLog.e((String)var3_10, var4_11, (Throwable)var1_1);
                    if (var2_9 == null) break block27;
                    var2_9.close();
                }
                if (var0 != null) {
                    ** continue;
                }
            }
            return;
            catch (Throwable var1_7) {
                // empty catch block
            }
        }
        if (var2_9 != null) {
            var2_9.close();
        }
        if (var0 != null) {
            var0.close();
        }
lbl52:
        // 4 sources

        throw var1_8;
        catch (Exception v1) {
            ** continue;
        }
    }

    public static boolean a(long l10) {
        return true;
    }

    public static boolean a(Context context) {
        boolean bl2;
        context = (ConnectivityManager)context.getSystemService("connectivity");
        boolean bl3 = false;
        if (context == null) {
            return false;
        }
        if ((context = context.getActiveNetworkInfo()) != null && (bl2 = context.isConnectedOrConnecting())) {
            bl3 = true;
        }
        return bl3;
    }

    public static boolean a(Context object, String string2) {
        int n10;
        String string3 = " not exist";
        String string4 = "isAssetFileExists";
        object = object.getAssets();
        String string5 = "";
        try {
            object = object.list(string5);
            n10 = 0;
            string5 = null;
        }
        catch (IOException iOException) {
            object = new StringBuilder();
            ((StringBuilder)object).append(string2);
            ((StringBuilder)object).append(string3);
            object = ((StringBuilder)object).toString();
            TXCLog.i(string4, (String)object);
            return false;
        }
        while (true) {
            block12: {
                int n11 = ((Object)object).length;
                if (n10 >= n11) break;
                Object object2 = object[n10];
                String string6 = string2.trim();
                n11 = (int)(((String)object2).equals(string6) ? 1 : 0);
                if (n11 == 0) break block12;
                object = new StringBuilder();
                ((StringBuilder)object).append(string2);
                string5 = " exist";
                ((StringBuilder)object).append(string5);
                object = ((StringBuilder)object).toString();
                TXCLog.i(string4, (String)object);
                return true;
            }
            ++n10;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append(string2);
        ((StringBuilder)object).append(string3);
        object = ((StringBuilder)object).toString();
        TXCLog.i(string4, (String)object);
        return false;
    }

    public static boolean a(String string2) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        boolean bl3 = false;
        if (bl2) {
            return false;
        }
        File file = new File(string2);
        boolean bl4 = file.exists();
        if (bl4 && (bl4 = file.isFile())) {
            bl3 = true;
        }
        return bl3;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static String b(Context object, String string2) {
        Throwable throwable222222;
        InputStream inputStream;
        String string3;
        block13: {
            string3 = "";
            inputStream = null;
            object = object.getAssets();
            inputStream = object.open(string2);
            int n10 = inputStream.available();
            object = new byte[n10];
            int n11 = inputStream.read((byte[])object);
            if (n11 > 0) break block13;
            if (inputStream == null) return string3;
            try {
                inputStream.close();
                return string3;
            }
            catch (IOException iOException) {
                return string3;
            }
        }
        inputStream.close();
        String string4 = "utf-8";
        string2 = new String((byte[])object, string4);
        if (inputStream == null) return string2;
        try {
            inputStream.close();
            return string2;
        }
        catch (IOException iOException) {
            return string2;
        }
        {
            block14: {
                catch (Throwable throwable222222) {
                    break block14;
                }
                catch (IOException iOException) {}
                string2 = "FileUtil";
                String string5 = "read asset file failed.";
                {
                    TXCLog.e(string2, string5, iOException);
                    if (inputStream == null) return string3;
                }
                inputStream.close();
                return string3;
            }
            if (inputStream == null) throw throwable222222;
            inputStream.close();
        }
        catch (IOException iOException) {
            throw throwable222222;
        }
        {
            throw throwable222222;
            catch (IOException iOException) {
                return string3;
            }
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static String b(String var0) {
        block13: {
            var1_8 = "IOException occurred. ";
            var2_9 = new File((String)var0);
            var3_10 = "";
            var0 = new StringBuilder((String)var3_10);
            var4_11 = var2_9.isFile();
            var5_12 = null;
            if (!var4_11) {
                return null;
            }
            try {
                var6_13 = new FileInputStream((File)var2_9);
                var3_10 = new InputStreamReader(var6_13);
                var2_9 = new BufferedReader((Reader)var3_10);
            }
            catch (Throwable var0_4) {
                break block13;
            }
            catch (IOException var0_5) {
                // empty catch block
                ** GOTO lbl-1000
            }
            try {
                while ((var3_10 = var2_9.readLine()) != null) {
                    var0.append((String)var3_10);
                }
                var2_9.close();
                var0 = var0.toString();
            }
            catch (Throwable var0_2) {
                var5_12 = var2_9;
                break block13;
            }
            catch (IOException var0_3) {
                var5_12 = var2_9;
                ** GOTO lbl-1000
            }
            try {
                var2_9.close();
                return var0;
            }
            catch (IOException var0_1) {
                var2_9 = new RuntimeException(var1_8, var0_1);
                throw var2_9;
            }
lbl-1000:
            // 2 sources

            {
                var2_9 = new RuntimeException(var1_8, (Throwable)var0);
                throw var2_9;
            }
        }
        if (var5_12 == null) throw var0_6;
        try {
            var5_12.close();
            throw var0_6;
        }
        catch (IOException var0_7) {
            var2_9 = new RuntimeException(var1_8, var0_7);
            throw var2_9;
        }
    }
}

