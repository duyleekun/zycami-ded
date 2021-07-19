/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Build$VERSION
 *  android.os.Environment
 *  android.text.TextUtils
 */
package com.xiaomi.push;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.g;
import com.xiaomi.push.y;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.Reader;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;

public class ag {
    /*
     * Loose catch block
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static boolean a(Context context, String string2, long l10) {
        void var0_5;
        Object object;
        block18: {
            boolean bl2;
            block17: {
                boolean bl3;
                block14: {
                    boolean bl4;
                    Object object2;
                    block16: {
                        boolean bl5;
                        block15: {
                            boolean bl6;
                            int n10 = Build.VERSION.SDK_INT;
                            bl2 = true;
                            int n11 = 23;
                            if (n10 >= n11 && (n10 = (int)(g.c(context, (String)(object2 = "android.permission.WRITE_EXTERNAL_STORAGE")) ? 1 : 0)) == 0) {
                                return bl2;
                            }
                            n10 = 0;
                            object2 = null;
                            Object object3 = Environment.getExternalStorageDirectory();
                            String string3 = "/.vdevdir/";
                            object = new File((File)object3, string3);
                            string3 = "lcfp.lock";
                            object3 = new File((File)object, string3);
                            y.a((File)object3);
                            string3 = "rw";
                            object = new RandomAccessFile((File)object3, string3);
                            object3 = ((RandomAccessFile)object).getChannel();
                            object2 = ((FileChannel)object3).lock();
                            bl3 = ag.b(context, string2, l10);
                            if (object2 == null || !(bl6 = ((FileLock)object2).isValid())) break block14;
                            try {
                                ((FileLock)object2).release();
                                break block14;
                            }
                            catch (IOException iOException) {}
                            catch (IOException iOException) {
                                break block15;
                            }
                            catch (Throwable throwable) {
                                n11 = 0;
                                object = null;
                                break block16;
                            }
                            catch (IOException iOException) {
                                n11 = 0;
                                object = null;
                            }
                        }
                        context.printStackTrace();
                        if (object2 == null || !(bl5 = ((FileLock)object2).isValid())) break block17;
                        try {
                            ((FileLock)object2).release();
                            break block17;
                        }
                        catch (IOException iOException) {}
                        catch (Throwable throwable) {
                            // empty catch block
                        }
                    }
                    if (object2 == null || !(bl4 = ((FileLock)object2).isValid())) break block18;
                    try {
                        ((FileLock)object2).release();
                        break block18;
                    }
                    catch (IOException iOException) {}
                }
                y.a((Closeable)object);
                return bl3;
            }
            y.a((Closeable)object);
            return bl2;
        }
        y.a((Closeable)object);
        throw var0_5;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static boolean b(Context var0, String var1_1, long var2_2) {
        block23: {
            block24: {
                block22: {
                    block21: {
                        var5_14 = Environment.getExternalStorageDirectory();
                        var4_3 = new File((File)var5_14, "/.vdevdir/");
                        var6_15 = "lcfp";
                        var5_14 = new File((File)var4_3, (String)var6_15);
                        var4_3 = new ArrayList();
                        var7_16 = System.currentTimeMillis();
                        var9_17 /* !! */  = new StringBuilder();
                        var9_17 /* !! */ .append(var1_1);
                        var10_18 = ":";
                        var9_17 /* !! */ .append(var10_18);
                        var11_19 = var0.getPackageName();
                        var9_17 /* !! */ .append(var11_19);
                        var11_19 = ",";
                        var9_17 /* !! */ .append(var11_19);
                        var9_17 /* !! */ .append(var7_16);
                        var9_17 /* !! */  = var9_17 /* !! */ .toString();
                        var12_20 = var5_14.exists();
                        var13_21 = 1;
                        if (!var12_20) ** GOTO lbl65
                        try {
                            var15_23 = new FileReader((File)var5_14);
                            var14_22 = new BufferedReader((Reader)var15_23);
                            ** GOTO lbl38
                        }
                        catch (Throwable var4_4) {
                            var21_30 = false;
                            var26_35 = 0.0f;
                            var20_28 /* !! */  = null;
                            break block21;
                        }
                        catch (Exception v0) {
                            var12_20 = false;
                            var14_22 = null;
                            ** GOTO lbl-1000
lbl38:
                            // 3 sources

                            block17: while (true) {
                                block25: {
                                    ** try [egrp 1[TRYBLOCK] [9, 8 : 161->293)] { 
lbl40:
                                    // 1 sources

                                    break block25;
lbl41:
                                    // 1 sources

                                    catch (Throwable var4_5) {
                                        var20_28 /* !! */  = var14_22;
                                        break block21;
                                    }
                                }
                                while ((var15_23 = var14_22.readLine()) != null) {
                                    var16_24 = var15_23.split(var10_18);
                                    var17_25 = var16_24.length;
                                    if (var17_25 != (var18_26 = 2)) continue;
                                    var17_25 = 0;
                                    var19_27 = var16_24[0];
                                    var20_28 /* !! */  = String.valueOf(var1_1);
                                    var21_29 /* !! */  = TextUtils.equals((CharSequence)var19_27, (CharSequence)var20_28 /* !! */ );
                                    if (var21_29 /* !! */  == 0) ** GOTO lbl-1000
                                    var20_28 /* !! */  = var16_24[var13_21];
                                    var22_31 = (var20_28 /* !! */  = var20_28 /* !! */ .split(var11_19)).length;
                                    if (var22_31 != var18_26) continue;
                                    var15_23 = var20_28 /* !! */ [var13_21];
                                    var23_32 = Long.parseLong((String)var15_23);
                                    var25_33 = var0.getPackageName();
                                    var21_29 /* !! */  = TextUtils.equals((CharSequence)(var20_28 /* !! */  = var20_28 /* !! */ [0]), (CharSequence)var25_33);
                                    if (var21_29 /* !! */  != 0) continue block17;
                                    var23_32 = var7_16 - var23_32;
                                    ** GOTO lbl-1000
                                }
                                break;
                            }
lbl65:
                            // 1 sources

                            var29_38 = y.a((File)var5_14);
                            if (!var29_38) {
                                return (boolean)var13_21;
                            }
                            break block22;
lbl69:
                            // 1 sources

                            catch (Exception v1) {
                                ** GOTO lbl-1000
                            }
lbl-1000:
                            // 1 sources

                            {
                                var26_34 = Math.abs(var23_32);
                                var23_32 = 1000L * var2_2;
                            }
                            var27_36 = var23_32;
                            var28_37 = 0.9f;
                            cfr_temp_0 = var26_34 - (var27_36 *= var28_37);
                            var21_29 /* !! */  = (int)(cfr_temp_0 == 0.0f ? 0 : (cfr_temp_0 < 0.0f ? -1 : 1));
                            if (var21_29 /* !! */  >= 0) ** GOTO lbl38
                            y.a(var14_22);
                            return false;
lbl-1000:
                            // 1 sources

                            {
                                var4_3.add(var15_23);
                                ** continue;
                            }
lbl-1000:
                            // 2 sources

                            {
                                var4_3.clear();
                            }
                        }
                        y.a(var14_22);
                        break block22;
                    }
                    y.a(var20_28 /* !! */ );
                    throw var4_6;
                }
                var4_3.add(var9_17 /* !! */ );
                try {
                    var30_39 = new FileWriter((File)var5_14);
                    var6_15 = new BufferedWriter(var30_39);
                }
                catch (Throwable var4_9) {
                    var21_29 /* !! */  = 0;
                    var26_34 = 0.0f;
                    var20_28 /* !! */  = null;
                    break block23;
                }
                catch (IOException var4_10) {
                    var21_29 /* !! */  = 0;
                    var26_34 = 0.0f;
                    var20_28 /* !! */  = null;
                    break block24;
                }
                try {
                    var4_3 = var4_3.iterator();
                    while (var31_40 = var4_3.hasNext()) {
                        var5_14 = var4_3.next();
                        var5_14 = (String)var5_14;
                        var6_15.write((String)var5_14);
                        var6_15.newLine();
                        var6_15.flush();
                    }
                }
                catch (Throwable var4_7) {
                    var20_28 /* !! */  = var6_15;
                    break block23;
                }
                catch (IOException var4_8) {
                    var20_28 /* !! */  = var6_15;
                    break block24;
                }
                y.a((Closeable)var6_15);
                return (boolean)var13_21;
            }
            try {
                var4_11 = var4_11.toString();
                b.d(var4_11);
            }
            catch (Throwable var4_12) {
                // empty catch block
                break block23;
            }
            y.a((Closeable)var20_28 /* !! */ );
            return (boolean)var13_21;
        }
        y.a((Closeable)var20_28 /* !! */ );
        throw var4_13;
    }
}

