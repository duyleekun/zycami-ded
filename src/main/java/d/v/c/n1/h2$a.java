/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$CompressFormat
 */
package d.v.c.n1;

import android.graphics.Bitmap;
import d.v.c.n1.h2;
import d.v.e.l.k2;
import d.v.e.l.u1;
import d.v.l.f;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class h2$a
extends f {
    public final /* synthetic */ h2 b;

    public h2$a(h2 h22) {
        this.b = h22;
    }

    public void b() {
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void e(Bitmap var1_1) {
        block7: {
            var3_8 = k2.h();
            var4_9 = new StringBuilder();
            var5_10 = System.currentTimeMillis();
            var4_9.append(var5_10);
            var7_11 = ".png";
            var4_9.append(var7_11);
            var4_9 = var4_9.toString();
            var2_7 = new File((File)var3_8, (String)var4_9);
            var3_8 = null;
            try {
                var4_9 = new FileOutputStream((File)var2_7);
            }
            catch (Throwable var1_4) {
                break block7;
            }
            catch (Exception var1_5) {
                // empty catch block
                ** GOTO lbl-1000
            }
            try {
                var3_8 = Bitmap.CompressFormat.JPEG;
                var8_12 = 100;
                var1_1.compress((Bitmap.CompressFormat)var3_8, var8_12, (OutputStream)var4_9);
                var4_9.flush();
                var1_1 = this.b;
                var1_1 = h2.n((h2)var1_1);
                var2_7 = var2_7.getAbsolutePath();
                var1_1.r((String)var2_7);
            }
            catch (Throwable var1_2) {
                var3_8 = var4_9;
                break block7;
            }
            catch (Exception var1_3) {
                var3_8 = var4_9;
                ** GOTO lbl-1000
            }
            u1.a((Closeable)var4_9);
            return;
lbl-1000:
            // 2 sources

            {
                var1_1.printStackTrace();
            }
            u1.a((Closeable)var3_8);
            return;
        }
        u1.a((Closeable)var3_8);
        throw var1_6;
    }
}

