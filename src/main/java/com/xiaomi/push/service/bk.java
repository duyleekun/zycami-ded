/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.hq;
import com.xiaomi.push.service.bj;
import com.xiaomi.push.y;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class bk
implements Runnable {
    public final /* synthetic */ Context a;
    public final /* synthetic */ hq a;

    public bk(Context context, hq hq2) {
        this.a = context;
        this.a = hq2;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void run() {
        var1_1 = bj.a;
        synchronized (var1_1) {
            var2_2 = null;
            var4_13 = this.a;
            var4_13 = var4_13.getFilesDir();
            var5_14 = "tiny_data.lock";
            var3_7 = new File((File)var4_13, (String)var5_14);
            y.a((File)var3_7);
            var5_14 = "rw";
            var4_13 = new RandomAccessFile((File)var3_7, (String)var5_14);
            ** try [egrp 1[TRYBLOCK] [14, 15 : 59->87)] { 
lbl14:
            // 1 sources

            ** GOTO lbl27
lbl-1000:
            // 1 sources

            {
                block19: {
                    block20: {
                        catch (Throwable var3_11) {
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
                            catch (Throwable var3_9) {
                                var4_13 = null;
                                break block19;
                            }
                            catch (Exception var3_10) {
                                var4_13 = null;
                                ** GOTO lbl-1000
                            }
lbl27:
                            // 1 sources

                            var3_7 = var4_13.getChannel();
                            var2_2 = var3_7.lock();
                            var3_7 = this.a;
                            var5_14 = this.a;
                            bj.b((Context)var3_7, (hq)var5_14);
                            if (var2_2 == null || !(var6_15 = var2_2.isValid())) ** GOTO lbl-1000
                            try {
                                var2_2.release();
                            }
                            catch (IOException var2_3) {
                                b.a(var2_3);
                            }
                            ** GOTO lbl-1000
                        }
lbl39:
                        // 1 sources

                        catch (Exception var3_8) {}
lbl-1000:
                        // 2 sources

                        {
                            b.a((Throwable)var3_7);
                        }
                        if (var2_2 == null || !(var6_16 = var2_2.isValid())) ** GOTO lbl-1000
                        try {
                            var2_2.release();
                        }
                        catch (IOException var2_4) {
                            b.a(var2_4);
                        }
                        ** continue;
                    }
                    return;
                }
                if (var2_2 != null && (var7_17 = var2_2.isValid())) {
                    try {
                        var2_2.release();
                    }
                    catch (IOException var2_6) {
                        b.a(var2_6);
                    }
                }
                y.a((Closeable)var4_13);
                throw var3_12;
            }
        }
    }
}

