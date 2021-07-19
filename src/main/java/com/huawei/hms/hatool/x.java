/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package com.huawei.hms.hatool;

import android.text.TextUtils;
import com.huawei.hms.hatool.b;
import com.huawei.hms.hatool.e;
import com.huawei.hms.hatool.r0;
import com.huawei.hms.hatool.x$a;
import com.huawei.hms.hatool.y;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;

public class x {
    public static x b;
    public x$a a;

    static {
        x x10;
        b = x10 = new x();
    }

    public x() {
        x$a x$a;
        this.a = x$a = new x$a(this);
    }

    public static /* synthetic */ x$a a(x x10) {
        return x10.a;
    }

    public static x f() {
        return b;
    }

    public String a() {
        return this.a.c;
    }

    public long b() {
        return this.a.d;
    }

    public String c() {
        return this.a.b;
    }

    public void d() {
        long l10 = this.b();
        long l11 = 0L;
        long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        int n10 = 16;
        if (l12 == false) {
            l10 = System.currentTimeMillis();
            Object object = this.e();
            boolean bl2 = TextUtils.isEmpty((CharSequence)object);
            if (bl2) {
                y.f("hmsSdk", "get rsa pubkey config error");
                return;
            }
            String string2 = d.j.f.a.a.h.f.b.f(n10);
            String string3 = e.a((String)object, string2);
            x$a x$a = this.a;
            x$a.b((String)object);
            object = this.a;
            ((x$a)object).a(l10);
            this.a.c(string2);
            x$a x$a2 = this.a;
            x$a2.a(string3);
        } else {
            long l13;
            long l14 = System.currentTimeMillis();
            l10 = l14 - l10;
            long l15 = l10 - (l13 = 43200000L);
            Object object = l15 == 0L ? 0 : (l15 < 0L ? -1 : 1);
            if (object > 0) {
                String string4 = this.a.a;
                Object object2 = d.j.f.a.a.h.f.b.f(n10);
                string4 = e.a(string4, (String)object2);
                this.a.a(l14);
                x$a x$a = this.a;
                x$a.c((String)object2);
                object2 = this.a;
                ((x$a)object2).a(string4);
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
    public final String e() {
        block7: {
            var1_1 = null;
            var2_3 /* !! */  = com.huawei.hms.hatool.b.f();
            var2_3 /* !! */  = var2_3 /* !! */ .getResources();
            var2_3 /* !! */  = var2_3 /* !! */ .getAssets();
            var3_4 = "hianalytics_njjn";
            var2_3 /* !! */  = var2_3 /* !! */ .open(var3_4);
            ** try [egrp 1[TRYBLOCK] [9, 8 : 25->29)] { 
lbl9:
            // 1 sources

            ** GOTO lbl15
lbl-1000:
            // 1 sources

            {
                block8: {
                    catch (Throwable var1_2) {
                        // empty catch block
                        break block7;
                    }
lbl13:
                    // 1 sources

                    catch (IOException v0) {
                        break block8;
                    }
lbl15:
                    // 1 sources

                    var1_1 = r0.a((InputStream)var2_3 /* !! */ );
                    r0.a((Closeable)var2_3 /* !! */ );
                    return var1_1;
                    catch (Throwable var4_5) {
                        var2_3 /* !! */  = null;
                        var1_1 = var4_5;
                    }
                    catch (IOException v1) {}
                    var2_3 /* !! */  = null;
                }
                var3_4 = "hmsSdk";
                var5_6 = "read pubKey error,the file is corrupted";
                {
                    y.f(var3_4, var5_6);
                }
                r0.a((Closeable)var2_3 /* !! */ );
                return null;
            }
        }
        r0.a((Closeable)var2_3 /* !! */ );
        throw var1_1;
    }
}

