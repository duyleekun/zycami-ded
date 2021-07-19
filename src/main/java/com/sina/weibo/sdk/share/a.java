/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.net.Uri
 *  android.os.Environment
 *  android.text.TextUtils
 */
package com.sina.weibo.sdk.share;

import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import com.sina.weibo.sdk.c.c;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Calendar;

public final class a {
    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static String a(Context var0, Uri var1_12, int var2_15) {
        block36: {
            block38: {
                block37: {
                    block35: {
                        block33: {
                            block34: {
                                var3_16 = "_display_name";
                                var4_19 = "WBShareTag";
                                var5_20 = 0;
                                var6_21 = null;
                                var7_22 = com.sina.weibo.sdk.c.a.c((Context)var0);
                                var7_22 = var7_22.packageName;
                                var8_23 = TextUtils.isEmpty((CharSequence)var7_22);
                                if (var8_23) {
                                    var7_22 = "com.sina.weibo";
                                }
                                var10_25 = "/Android/data/";
                                var9_24 = new StringBuilder((String)var10_25);
                                var9_24.append((String)var7_22);
                                var7_22 = "/files/.composerTem/";
                                var9_24.append((String)var7_22);
                                var7_22 = var9_24.toString();
                                var10_25 = new StringBuilder();
                                var11_26 = Environment.getExternalStorageDirectory();
                                var11_26 = var11_26.getAbsolutePath();
                                var10_25.append((String)var11_26);
                                var10_25.append((String)var7_22);
                                var10_25 = var10_25.toString();
                                var9_24 = new File((String)var10_25);
                                var9_24.mkdirs();
                                var9_24 = Calendar.getInstance();
                                var10_25 = "file";
                                var11_26 = var1_12.getScheme();
                                var12_27 = var10_25.equals(var11_26);
                                if (var12_27) {
                                    var3_16 = new StringBuilder();
                                    var13_28 = var9_24.getTimeInMillis();
                                    var3_16.append(var13_28);
                                    var9_24 = var1_12.getLastPathSegment();
                                    var3_16.append((String)var9_24);
                                    var3_16 = var3_16.toString();
                                    var8_23 = false;
                                    var9_24 = null;
                                    break block33;
                                }
                                var9_24 = var0.getContentResolver();
                                var11_26 = new String[]{var3_16};
                                var10_25 = var1_12;
                                if ((var9_24 = var9_24.query((Uri)var1_12, var11_26, null, null, null)) == null) break block34;
                                try {
                                    var12_27 = var9_24.moveToFirst();
                                    if (!var12_27) break block34;
                                    var15_29 = var9_24.getColumnIndex((String)var3_16);
                                    var3_16 = var9_24.getString(var15_29);
                                    break block33;
                                }
                                catch (Exception var3_17) {
                                    break block35;
                                }
                            }
                            var15_29 = 0;
                            var3_16 = null;
                        }
                        if (var9_24 == null) ** GOTO lbl89
                        var9_24.close();
                        ** GOTO lbl89
                        catch (Throwable var0_1) {
                            var8_23 = false;
                            var9_24 = null;
                            break block36;
                        }
                        catch (Exception var3_18) {
                            var8_23 = false;
                            var9_24 = null;
                        }
                    }
                    var11_26 = "share util and exception is ";
                    var10_25 = new StringBuilder((String)var11_26);
                    var11_26 = var3_16.getMessage();
                    var10_25.append((String)var11_26);
                    var10_25 = var10_25.toString();
                    c.b(var4_19, (String)var10_25);
                    var3_16.printStackTrace();
                    if (var9_24 == null) ** GOTO lbl87
                    var9_24.close();
lbl87:
                    // 2 sources

                    var15_29 = 0;
                    var3_16 = null;
lbl89:
                    // 3 sources

                    if (var8_23 = TextUtils.isEmpty((CharSequence)var3_16)) {
                        var3_16 = new StringBuilder();
                        var9_24 = Calendar.getInstance();
                        var13_28 = var9_24.getTimeInMillis();
                        var3_16.append(var13_28);
                        var16_30 = var2_15 == 0 ? "_sdk_temp.mp4" : "_sdk_temp.jpg";
                        var3_16.append((String)var16_30);
                        var3_16 = var3_16.toString();
                    }
                    var0 = var0.getContentResolver();
                    var16_30 = "r";
                    var0 = var0.openFileDescriptor((Uri)var1_12, (String)var16_30);
                    var0 = var0.getFileDescriptor();
                    var16_30 = new FileInputStream((FileDescriptor)var0);
                    var1_12 = new BufferedInputStream((InputStream)var16_30);
                    var16_30 = new StringBuilder();
                    var9_24 = Environment.getExternalStorageDirectory();
                    var9_24 = var9_24.getAbsolutePath();
                    var16_30.append((String)var9_24);
                    var16_30.append((String)var7_22);
                    var16_30.append((String)var3_16);
                    var16_30 = var16_30.toString();
                    var0 = new File((String)var16_30);
                    var2_15 = (int)var0.exists();
                    if (var2_15 != 0) {
                        var0.delete();
                    }
                    var16_30 = new FileOutputStream((File)var0);
                    var15_29 = 1444;
                    var3_16 = new byte[var15_29];
                    while ((var5_20 = var1_12.read((byte[])var3_16)) != (var17_31 = -1)) {
                        var17_31 = 0;
                        var7_22 = null;
                        var16_30.write((byte[])var3_16, 0, var5_20);
                    }
                    var0 = var0.getPath();
                    try {
                        var1_12.close();
                        var16_30.close();
                        return var0;
                    }
                    catch (Exception var1_13) {
                        var1_13.printStackTrace();
                    }
                    return var0;
                    catch (Throwable var0_2) {
                        break block37;
                    }
                    catch (Exception var0_3) {
                        break block38;
                    }
                    catch (Throwable var0_4) {
                        var2_15 = 0;
                        var16_30 = null;
                    }
                }
                var6_21 = var1_12;
lbl147:
                // 3 sources

                while (true) {
                    block39: {
                        if (var6_21 != null) {
                            try {
                                var6_21.close();
                            }
                            catch (Exception var1_14) {
                                break block39;
                            }
                        }
                        if (var16_30 == null) throw var0_5;
                        var16_30.close();
                        throw var0_5;
                    }
                    var1_14.printStackTrace();
                    throw var0_5;
                }
                catch (Exception var0_6) {
                    var2_15 = 0;
                    var16_30 = null;
                }
            }
            var6_21 = var1_12;
            try {
                var3_16 = "share util and error is ";
                var1_12 = new StringBuilder((String)var3_16);
                var3_16 = var0_7.getMessage();
                var1_12.append((String)var3_16);
                var1_12 = var1_12.toString();
                c.b(var4_19, (String)var1_12);
                var1_12 = new Throwable((Throwable)var0_7);
                throw var1_12;
            }
            catch (Throwable var0_11) {
                // empty catch block
            }
            ** GOTO lbl147
            catch (Throwable var0_8) {
                // empty catch block
            }
        }
        if (var9_24 == null) throw var0;
        try {
            var9_24.close();
            throw var0;
        }
        catch (Throwable var0_9) {}
        catch (Exception var0_10) {}
        finally {
            var2_15 = 0;
            var16_30 = null;
            ** continue;
        }
    }
}

