/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.BitmapRegionDecoder
 */
package com.tencent.rtmp.a;

import android.graphics.BitmapRegionDecoder;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.rtmp.a.b;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;

public class b$b
implements Runnable {
    private WeakReference a;
    private String b;
    private String c;

    public b$b(b b10, String string2, String string3) {
        WeakReference<b> weakReference;
        this.a = weakReference = new WeakReference<b>(b10);
        this.b = string2;
        this.c = string3;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void run() {
        Throwable throwable2;
        Object object;
        block10: {
            Object object2;
            int n10;
            Object object3 = (b)this.a.get();
            object = this.a;
            if (object == null) return;
            if (object3 == null) return;
            object = null;
            String string2 = this.c;
            object = com.tencent.rtmp.a.b.a((b)object3, string2);
            string2 = this.c;
            String string3 = "/";
            int n11 = string2.lastIndexOf(string3);
            int n12 = -1;
            if (n11 != n12 && (n11 += (n12 = 1)) < (n10 = ((String)(object2 = this.c)).length())) {
                object2 = this.c;
                int n13 = ((String)object2).length();
                string2 = ((String)object2).substring(n11, n13);
                object2 = com.tencent.rtmp.a.b.b((b)object3);
                if (object2 != null) {
                    object3 = com.tencent.rtmp.a.b.b((b)object3);
                    string3 = BitmapRegionDecoder.newInstance((InputStream)object, n12 != 0);
                    object3.put(string2, string3);
                }
            }
            if (object == null) return;
            {
                catch (Throwable throwable2) {
                    break block10;
                }
                catch (IOException iOException) {}
                String string4 = "TXImageSprite";
                String string5 = "load bitmap from network failed.";
                {
                    TXCLog.e(string4, string5, iOException);
                    if (object == null) return;
                }
            }
            try {
                ((InputStream)object).close();
                return;
            }
            catch (IOException iOException) {}
        }
        if (object == null) throw throwable2;
        try {
            ((InputStream)object).close();
            throw throwable2;
        }
        catch (IOException iOException) {
            throw throwable2;
        }
    }
}

