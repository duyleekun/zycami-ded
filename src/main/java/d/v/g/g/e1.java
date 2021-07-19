/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.LruCache
 */
package d.v.g.g;

import android.util.LruCache;
import d.v.g.g.e1$a;
import d.v.g.g.e1$b;

public class e1 {
    private LruCache a;

    private e1() {
        LruCache lruCache;
        this.a = lruCache = new LruCache(10);
    }

    public /* synthetic */ e1(e1$a e1$a) {
        this();
    }

    public static void a(boolean bl2) {
        e1.d().g("action_to_firmware_upgrade", bl2);
    }

    public static boolean b() {
        return e1.d().c("use_4g_download_firmware");
    }

    private boolean c(String object) {
        boolean bl2;
        LruCache lruCache = e1.d().a;
        if ((object = lruCache.get(object)) != null && (bl2 = ((Boolean)(object = (Boolean)object)).booleanValue())) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    private static e1 d() {
        return e1$b.a();
    }

    public static boolean e() {
        return e1.d().c("action_to_firmware_upgrade");
    }

    public static boolean f() {
        return e1.d().c("need_check_firmware_update");
    }

    private void g(String string2, boolean bl2) {
        LruCache lruCache = e1.d().a;
        Boolean bl3 = bl2;
        lruCache.put((Object)string2, (Object)bl3);
    }

    public static void h(boolean bl2) {
        e1.d().g("use_4g_download_firmware", bl2);
    }

    public static void i(boolean bl2) {
        e1.d().g("need_check_firmware_update", bl2);
    }
}

