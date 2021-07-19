/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 */
package com.xiaomi.push.service;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.y;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class a {
    private static volatile a a;
    private Context a;
    private final Object a;
    private final String a;
    private final Object b;
    private final String b;
    private final String c;
    private final String d;
    private volatile String e;
    private volatile String f;

    public a(Context context) {
        Object object;
        this.a = object = new Object();
        this.b = object = new Object();
        this.a = "mipush_region";
        this.b = "mipush_country_code";
        this.c = "mipush_region.lock";
        this.d = "mipush_country_code.lock";
        this.a = context;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static a a(Context context) {
        Object object = a;
        if (object != null) return a;
        object = a.class;
        synchronized (object) {
            a a10 = a;
            if (a10 != null) return a;
            a = a10 = new a(context);
            return a;
        }
    }

    /*
     * Loose catch block
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private String a(Context object, String object2, String string2, Object object3) {
        File file = object.getFilesDir();
        File file2 = new File(file, (String)object2);
        boolean bl2 = file2.exists();
        Object object4 = null;
        if (!bl2) {
            object = new StringBuilder();
            ((StringBuilder)object).append("No ready file to get data from ");
            ((StringBuilder)object).append((String)object2);
            com.xiaomi.channel.commonutils.logger.b.a(((StringBuilder)object).toString());
            return null;
        }
        synchronized (object3) {
            void var3_13;
            boolean bl3;
            block23: {
                block24: {
                    boolean bl4;
                    block22: {
                        block21: {
                            boolean bl5;
                            object = object.getFilesDir();
                            object2 = new File((File)object, string2);
                            y.a((File)object2);
                            string2 = "rw";
                            object = new RandomAccessFile((File)object2, string2);
                            object2 = ((RandomAccessFile)object).getChannel();
                            object2 = ((FileChannel)object2).lock();
                            string2 = y.a(file2);
                            if (object2 == null || !(bl5 = ((FileLock)object2).isValid())) break block21;
                            try {
                                ((FileLock)object2).release();
                            }
                            catch (IOException iOException) {
                                com.xiaomi.channel.commonutils.logger.b.a(iOException);
                            }
                        }
                        y.a((Closeable)object);
                        return string2;
                        catch (Exception exception) {
                            break block22;
                        }
                        catch (Throwable throwable) {
                            break block23;
                        }
                        catch (Exception exception) {
                            bl3 = false;
                            object2 = null;
                            break block22;
                        }
                        catch (Throwable throwable) {
                            object = null;
                            break block23;
                        }
                        catch (Exception exception) {
                            object = null;
                            bl3 = false;
                            object2 = null;
                        }
                    }
                    com.xiaomi.channel.commonutils.logger.b.a((Throwable)((Object)string2));
                    if (object2 == null || !(bl4 = ((FileLock)object2).isValid())) break block24;
                    try {
                        ((FileLock)object2).release();
                    }
                    catch (IOException iOException) {
                        com.xiaomi.channel.commonutils.logger.b.a(iOException);
                    }
                }
                y.a((Closeable)object);
                return null;
                catch (Throwable throwable) {
                    object4 = object2;
                }
            }
            if (object4 != null && (bl3 = ((FileLock)object4).isValid())) {
                try {
                    ((FileLock)object4).release();
                }
                catch (IOException iOException) {
                    com.xiaomi.channel.commonutils.logger.b.a(iOException);
                }
            }
            y.a((Closeable)object);
            throw var3_13;
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void a(Context var1_1, String var2_10, String var3_12, String var4_13, Object var5_14) {
        synchronized (var5_14) {
            var6_15 = null;
            var8_17 = var1_1 /* !! */ .getFilesDir();
            var7_16 = new File((File)var8_17, (String)var4_13);
            y.a((File)var7_16);
            var8_17 = "rw";
            var4_13 = new RandomAccessFile((File)var7_16, (String)var8_17);
            ** try [egrp 1[TRYBLOCK] [12, 13 : 50->87)] { 
lbl11:
            // 1 sources

            ** GOTO lbl24
lbl-1000:
            // 1 sources

            {
                block19: {
                    block20: {
                        catch (Throwable var1_8) {
                            // empty catch block
                            break block19;
                        }
lbl-1000:
                        // 6 sources

                        {
                            while (true) {
                                y.a((Closeable)var4_13);
                                break block20;
                                break;
                            }
                            catch (Throwable var1_4) {
                                var4_13 = null;
                                break block19;
                            }
                            catch (Exception var1_5) {
                                var4_13 = null;
                                ** GOTO lbl-1000
                            }
lbl24:
                            // 1 sources

                            var7_16 = var4_13.getChannel();
                            var6_15 = var7_16.lock();
                            var1_1 /* !! */  = var1_1 /* !! */ .getFilesDir();
                            var7_16 = new File((File)var1_1 /* !! */ , var3_12);
                            y.a((File)var7_16, var2_10);
                            if (var6_15 == null || !(var9_18 = var6_15.isValid())) ** GOTO lbl-1000
                            try {
                                var6_15.release();
                            }
                            catch (IOException var1_2) {
                                com.xiaomi.channel.commonutils.logger.b.a(var1_2);
                            }
                            ** GOTO lbl-1000
                        }
lbl36:
                        // 1 sources

                        catch (Exception var1_3) {}
lbl-1000:
                        // 2 sources

                        {
                            com.xiaomi.channel.commonutils.logger.b.a((Throwable)var1_1 /* !! */ );
                        }
                        if (var6_15 == null || !(var9_19 = var6_15.isValid())) ** GOTO lbl-1000
                        try {
                            var6_15.release();
                        }
                        catch (IOException var1_6) {
                            com.xiaomi.channel.commonutils.logger.b.a(var1_6);
                        }
                        ** continue;
                    }
                    return;
                }
                if (var6_15 != null && (var10_20 = var6_15.isValid())) {
                    try {
                        var6_15.release();
                    }
                    catch (IOException var2_11) {
                        com.xiaomi.channel.commonutils.logger.b.a(var2_11);
                    }
                }
                y.a((Closeable)var4_13);
                throw var1_9;
            }
        }
    }

    public String a() {
        String string2 = this.e;
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (bl2) {
            string2 = this.a;
            Object object = this.a;
            String string3 = "mipush_region";
            String string4 = "mipush_region.lock";
            this.e = string2 = this.a((Context)string2, string3, string4, object);
        }
        return this.e;
    }

    public void a(String string2) {
        String string3 = this.e;
        boolean bl2 = TextUtils.equals((CharSequence)string2, (CharSequence)string3);
        if (!bl2) {
            this.e = string2;
            Context context = this.a;
            String string4 = this.e;
            Object object = this.a;
            String string5 = "mipush_region";
            String string6 = "mipush_region.lock";
            this.a(context, string4, string5, string6, object);
        }
    }

    public String b() {
        String string2 = this.f;
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (bl2) {
            string2 = this.a;
            Object object = this.b;
            String string3 = "mipush_country_code";
            String string4 = "mipush_country_code.lock";
            this.f = string2 = this.a((Context)string2, string3, string4, object);
        }
        return this.f;
    }

    public void b(String string2) {
        String string3 = this.f;
        boolean bl2 = TextUtils.equals((CharSequence)string2, (CharSequence)string3);
        if (!bl2) {
            this.f = string2;
            Context context = this.a;
            String string4 = this.f;
            Object object = this.b;
            String string5 = "mipush_country_code";
            String string6 = "mipush_country_code.lock";
            this.a(context, string4, string5, string6, object);
        }
    }
}

