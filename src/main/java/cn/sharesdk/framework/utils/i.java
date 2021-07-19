/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  android.text.TextUtils
 */
package cn.sharesdk.framework.utils;

import android.graphics.Bitmap;
import android.text.TextUtils;
import cn.sharesdk.framework.utils.QRCodeUtil.WriterException;
import cn.sharesdk.framework.utils.QRCodeUtil.a;
import cn.sharesdk.framework.utils.QRCodeUtil.c;
import cn.sharesdk.framework.utils.QRCodeUtil.e;
import cn.sharesdk.framework.utils.QRCodeUtil.l;
import java.util.Hashtable;

public class i {
    private static volatile i a;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static Bitmap a(String string2, int n10, int n11, String string3, String string4, String string5, int n12, int n13) {
        int n14 = n10;
        int n15 = n11;
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (bl2) {
            return null;
        }
        if (n10 < 0) return null;
        if (n11 < 0) {
            return null;
        }
        try {
            int n16;
            int n17;
            Object object;
            a a10;
            Object object2;
            Object object3;
            Hashtable<e, String> hashtable = new Hashtable<e, String>();
            bl2 = TextUtils.isEmpty((CharSequence)string3);
            if (!bl2) {
                object3 = e.b;
                object2 = string3;
                hashtable.put((e)((Object)object3), string3);
            }
            if (!(bl2 = TextUtils.isEmpty((CharSequence)string4))) {
                object3 = e.a;
                object2 = string4;
                hashtable.put((e)((Object)object3), string4);
            }
            if (!(bl2 = TextUtils.isEmpty((CharSequence)string5))) {
                object3 = e.j;
                object3 = e.f;
                object2 = string5;
                hashtable.put((e)((Object)object3), string5);
            }
            try {
                object2 = new l();
                a10 = cn.sharesdk.framework.utils.QRCodeUtil.a.l;
                object = string2;
                n17 = n10;
                n16 = n11;
                object3 = ((l)object2).encode(string2, a10, n10, n11, hashtable);
            }
            catch (WriterException writerException) {
                writerException.printStackTrace();
                bl2 = false;
                object3 = null;
            }
            int n18 = n14 * n15;
            object = new int[n18];
            n18 = 0;
            object2 = null;
            int n19 = 0;
            a10 = null;
            while (true) {
                if (n19 < n15) {
                } else {
                    object3 = Bitmap.Config.ARGB_8888;
                    object3 = Bitmap.createBitmap((int)n10, (int)n11, (Bitmap.Config)object3);
                    n19 = 0;
                    a10 = null;
                    n16 = 0;
                    hashtable = null;
                    object2 = object3;
                    n17 = n10;
                    n14 = n10;
                    n15 = n11;
                    object3.setPixels((int[])object, 0, n10, 0, 0, n10, n11);
                    return object3;
                }
                for (n17 = 0; n17 < n14; ++n17) {
                    n16 = (int)(((c)object3).a(n17, n19) ? 1 : 0);
                    if (n16 != 0) {
                        n16 = n19 * n14 + n17;
                        object[n16] = n12;
                        continue;
                    }
                    n16 = n19 * n14 + n17;
                    object[n16] = n13;
                }
                ++n19;
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        return null;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public static i a() {
        Class<i> clazz = i.class;
        // MONITORENTER : clazz
        i i10 = a;
        if (i10 == null) {
            // MONITORENTER : clazz
            i10 = a;
            if (i10 == null) {
                a = i10 = new i();
            }
            // MONITOREXIT : clazz
        }
        // MONITOREXIT : clazz
        return a;
    }
}

