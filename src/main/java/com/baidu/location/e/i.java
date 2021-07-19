/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.database.Cursor
 */
package com.baidu.location.e;

import android.database.Cursor;
import com.baidu.location.BDLocation;
import com.baidu.location.e.h;
import com.baidu.location.e.j;
import com.baidu.location.e.j$a;
import java.util.concurrent.Callable;

public class i
implements Callable {
    public final /* synthetic */ String[] a;
    public final /* synthetic */ h b;

    public i(h h10, String[] stringArray) {
        this.b = h10;
        this.a = stringArray;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public BDLocation a() {
        block29: {
            block30: {
                var1_1 = new BDLocation();
                var2_2 = this.a;
                var3_9 = ((String[])var2_2).length;
                if (var3_9 <= 0) return var1_1;
                var1_1 = h.a(this.b).o();
                var3_9 = 0;
                var2_2 = null;
                var4_10 = 0;
                var5_11 = null;
                var7_13 = null;
                for (var6_12 = 0; var6_12 < (var8_14 = ((String[])var1_1).length); ++var6_12) {
                    try {
                        var7_13 = h.p();
                        var7_13 = var7_13.getPackageManager();
                        var9_15 = var1_1[var6_12];
                        var7_13 = var7_13.resolveContentProvider((String)var9_15, 0);
                    }
                    catch (Exception v0) {
                        var7_13 = null;
                    }
                    if (var7_13 != null) break;
                }
                if (var7_13 == null) break block30;
                var1_1 = h.p();
                var9_15 = var1_1.getContentResolver();
                var1_1 = var7_13.authority;
                var10_16 = h.b((String)var1_1);
                var11_17 = this.a;
                var1_1 = var9_15.query(var10_16, var11_17, null, null, null);
                try {
                    var5_11 = j.a((Cursor)var1_1);
                    if (var1_1 == null) ** GOTO lbl36
                }
                catch (Throwable var2_3) {
                    var5_11 = var1_1;
                }
lbl33:
                // 3 sources

                while (true) {
                    try {
                        var1_1.close();
                    }
                    catch (Exception v1) {
                    }
lbl36:
                    // 5 sources

                    while (true) {
                        var1_1 = var5_11;
lbl38:
                        // 2 sources

                        while (true) {
                            if (var1_1 == null) return var1_1;
                            var3_9 = var1_1.getLocType();
                            if (var3_9 == (var4_10 = 67)) return var1_1;
                            var3_9 = 66;
                            var1_1.setLocType(var3_9);
                            return var1_1;
                        }
                        break;
                    }
                    break;
                }
                catch (Throwable var2_4) {
                    // empty catch block
                }
                if (var5_11 == null) throw var2_5;
                var5_11.close();
                throw var2_5;
                catch (Exception v2) {
                    var1_1 = null;
lbl58:
                    // 2 sources

                    while (true) {
                        if (var1_1 == null) ** GOTO lbl36
                        break;
                    }
                }
                ** GOTO lbl33
            }
            var2_2 = this.a;
            var1_1 = new j$a((String[])var2_2);
            var2_2 = this.b;
            var2_2 = h.b((h)var2_2);
            var1_1 = var2_2.a((j$a)var1_1);
            var2_2 = j.a((Cursor)var1_1);
            if (var1_1 == null) break block29;
            var1_1.close();
        }
lbl75:
        // 2 sources

        while (true) {
            var1_1 = var2_2;
            ** continue;
            break;
        }
        catch (Throwable var2_6) {
            var5_11 = var1_1;
        }
        catch (Throwable var2_7) {
            // empty catch block
        }
        if (var5_11 == null) throw var2_8;
        try {
            var5_11.close();
        }
        catch (Exception v5) {
            throw var2_8;
        }
        throw var2_8;
        catch (Exception v3) {
            var1_1 = null;
lbl89:
            // 2 sources

            while (true) {
                if (var1_1 != null) ** break;
                ** continue;
                ** continue;
                break;
            }
        }
        catch (Exception v4) {
            ** continue;
        }
        catch (Exception v6) {
            ** continue;
        }
        catch (Exception v7) {
            ** continue;
        }
        catch (Exception v8) {
            throw var2_5;
        }
    }

    public /* synthetic */ Object call() {
        return this.a();
    }
}

