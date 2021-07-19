/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.cb$a;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class cd
implements Runnable {
    public final /* synthetic */ Context a;
    public final /* synthetic */ cb$a a;

    public cd(cb$a cb$a, Context context) {
        this.a = cb$a;
        this.a = context;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void run() {
        block15: {
            block16: {
                block17: {
                    var1_1 /* !! */  = null;
                    var2_5 = this.a;
                    var1_1 /* !! */  = var2_5.a();
                    if (var1_1 /* !! */  != null && (var3_8 = var1_1 /* !! */ .isOpen())) {
                        var1_1 /* !! */ .beginTransaction();
                        var2_5 = this.a;
                        var4_9 = this.a;
                        var2_5.a(var4_9, var1_1 /* !! */ );
                        var1_1 /* !! */ .setTransactionSuccessful();
                    }
                    if (var1_1 /* !! */  != null) {
                    }
                    ** GOTO lbl31
                    {
                        catch (Throwable var2_6) {
                            break block15;
                        }
                        catch (Exception var2_7) {}
                        {
                            b.a(var2_7);
                            if (var1_1 /* !! */  == null) ** GOTO lbl21
                        }
                        try {
                            var1_1 /* !! */ .endTransaction();
lbl21:
                            // 2 sources

                            var1_1 /* !! */  = this.a;
                            var1_1 /* !! */  = var1_1 /* !! */ .a;
                            if (var1_1 /* !! */  != null) {
                                var1_1 /* !! */ .close();
                            }
                            break block16;
                        }
                        catch (Exception var1_3) {
                            // empty catch block
                            break block17;
                        }
                    }
                    try {
                        var1_1 /* !! */ .endTransaction();
lbl31:
                        // 2 sources

                        var1_1 /* !! */  = this.a;
                        var1_1 /* !! */  = var1_1 /* !! */ .a;
                        if (var1_1 /* !! */  != null) {
                            var1_1 /* !! */ .close();
                        }
                        break block16;
                    }
                    catch (Exception var1_2) {}
                }
                b.a((Throwable)var1_1 /* !! */ );
            }
            var1_1 /* !! */  = this.a;
            var2_5 = this.a;
            var1_1 /* !! */ .a((Context)var2_5);
            return;
        }
        if (var1_1 /* !! */  == null) ** GOTO lbl48
        try {
            var1_1 /* !! */ .endTransaction();
lbl48:
            // 2 sources

            var1_1 /* !! */  = this.a;
            var1_1 /* !! */  = var1_1 /* !! */ .a;
            if (var1_1 /* !! */  != null) {
                var1_1 /* !! */ .close();
            }
        }
        catch (Exception var1_4) {
            b.a(var1_4);
        }
        var1_1 /* !! */  = this.a;
        var4_10 = this.a;
        var1_1 /* !! */ .a(var4_10);
        throw var2_6;
    }
}

