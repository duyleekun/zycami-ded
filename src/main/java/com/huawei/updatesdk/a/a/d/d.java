/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package com.huawei.updatesdk.a.a.d;

import android.text.TextUtils;
import com.huawei.updatesdk.a.a.c.a.a.a;
import com.huawei.updatesdk.a.a.d.b;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public abstract class d {
    /*
     * Unable to fully structure code
     */
    public static String a(String var0, String var1_14) {
        block40: {
            block41: {
                block39: {
                    block38: {
                        block37: {
                            block36: {
                                block35: {
                                    var2_15 = "Close FileInputStream failed!";
                                    var3_16 = "FileUtil";
                                    var4_17 = TextUtils.isEmpty((CharSequence)var0);
                                    var5_18 = null;
                                    if (var4_17) {
                                        return null;
                                    }
                                    var1_14 = MessageDigest.getInstance((String)var1_14);
                                    var6_19 = new FileInputStream((String)var0);
                                    var7_20 = 1024;
                                    try {
                                        var0 = new byte[var7_20];
                                        var10_22 = var8_21 = 0L;
                                    }
                                    catch (IndexOutOfBoundsException var0_1) {
                                        break block35;
                                    }
                                    catch (IllegalArgumentException var0_2) {
                                        break block36;
                                    }
                                    catch (IOException var0_3) {
                                        break block37;
                                    }
                                    catch (FileNotFoundException var0_4) {
                                        break block38;
                                    }
                                    catch (NoSuchAlgorithmException var0_5) {
                                        break block39;
                                    }
                                    while (true) {
                                        var12_23 = var6_19.read((byte[])var0);
                                        var13_24 = -1;
                                        if (var12_23 == var13_24) break;
                                        var13_24 = 0;
                                        var1_14.update((byte[])var0, 0, var12_23);
                                        var14_25 = var12_23;
                                        var10_22 += var14_25;
                                    }
                                    var7_20 = (int)(var10_22 == var8_21 ? 0 : (var10_22 < var8_21 ? -1 : 1));
                                    if (var7_20 > 0) {
                                        var0 = var1_14.digest();
                                        var5_18 = var0 = b.a((byte[])var0);
                                    }
lbl32:
                                    // 8 sources

                                    while (true) {
                                        var6_19.close();
                                        break;
                                    }
                                    catch (Throwable var0_6) {
                                        break block40;
                                    }
                                    catch (IndexOutOfBoundsException var0_7) {
                                        var4_17 = false;
                                        var6_19 = null;
                                    }
                                }
                                var1_14 = "getFileHashData IndexOutOfBoundsException";
                                a.a(var3_16, (String)var1_14, (Throwable)var0);
                                if (var6_19 == null) break block41;
                                ** GOTO lbl32
                                catch (IllegalArgumentException var0_8) {
                                    var4_17 = false;
                                    var6_19 = null;
                                }
                            }
                            var1_14 = "getFileHashData IllegalArgumentException";
                            a.a(var3_16, (String)var1_14, (Throwable)var0);
                            if (var6_19 == null) break block41;
                            ** GOTO lbl32
                            catch (IOException var0_9) {
                                var4_17 = false;
                                var6_19 = null;
                            }
                        }
                        var1_14 = "getFileHashData IOException";
                        a.a(var3_16, (String)var1_14, (Throwable)var0);
                        if (var6_19 == null) break block41;
                        ** GOTO lbl32
                        catch (FileNotFoundException var0_10) {
                            var4_17 = false;
                            var6_19 = null;
                        }
                    }
                    var1_14 = "getFileHashData FileNotFoundException";
                    a.a(var3_16, (String)var1_14, (Throwable)var0);
                    if (var6_19 == null) break block41;
                    ** GOTO lbl32
                    catch (NoSuchAlgorithmException var0_11) {
                        var4_17 = false;
                        var6_19 = null;
                    }
                }
                var1_14 = "getFileHashData NoSuchAlgorithmException";
                a.a(var3_16, (String)var1_14, (Throwable)var0);
                if (var6_19 != null) {
                    ** continue;
                }
                break block41;
                catch (IOException v0) {
                    a.b(var3_16, var2_15);
                }
            }
            return var5_18;
            catch (Throwable var0_12) {
                var5_18 = var6_19;
            }
        }
        if (var5_18 != null) {
            try {
                var5_18.close();
            }
            catch (IOException v1) {
                a.b(var3_16, var2_15);
            }
        }
        throw var0_13;
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            }
            catch (IOException iOException) {
                String string2 = "FileUtil";
                String string3 = "Closeable exception";
                a.a(string2, string3, iOException);
            }
        }
    }

    public static boolean a(File file) {
        boolean bl2;
        if (file != null && (bl2 = file.exists())) {
            int n10;
            bl2 = file.isFile();
            if (bl2) {
                return file.delete();
            }
            File[] fileArray = file.listFiles();
            if (fileArray != null && (n10 = fileArray.length) > 0) {
                for (File file2 : fileArray) {
                    d.a(file2);
                }
            }
            return file.delete();
        }
        return true;
    }
}

