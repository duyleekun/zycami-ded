/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.os.SystemClock
 *  com.zhiyun.mediapipe.ZYMPController
 */
package d.v.c.x1;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.SystemClock;
import com.zhiyun.mediapipe.ZYMPController;
import d.v.c.x1.a;
import d.v.c.x1.b;
import d.v.c.x1.c;
import d.v.c.x1.d;
import d.v.c.x1.e;
import d.v.c.x1.f;
import d.v.c.x1.g;
import d.v.c.x1.j;
import d.v.r.h;
import e.a.h0;
import e.a.l;
import e.a.m;
import e.a.v0.o;
import e.a.v0.r;
import io.reactivex.BackpressureStrategy;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Callable;

public class i {
    private static final String a = "gestures";
    private static final String b = "5";
    private static final String c = "2";
    private static ZYMPController d;
    private static volatile Callable e;

    private static ZYMPController a(Context context) {
        int n10;
        ZYMPController zYMPController;
        int n11 = 0;
        do {
            Object object;
            n10 = 1;
            n11 += n10;
            zYMPController = new ZYMPController();
            Object[] objectArray = context.getApplicationContext();
            try {
                zYMPController.j((Context)objectArray);
                zYMPController.l();
            }
            catch (Exception exception) {
                zYMPController = null;
            }
            int n12 = 2;
            objectArray = new Object[n12];
            objectArray[0] = object = Integer.valueOf(n11);
            object = zYMPController == null ? "\u5931\u8d25" : "\u6210\u529f";
            objectArray[n10] = object;
            String string2 = "\u7b2c%d\u6b21\u521d\u59cb\u5316%s";
            m.a.a.i(string2, objectArray);
        } while (zYMPController == null && n11 < (n10 = 3));
        return zYMPController;
    }

    private static List b(Map object, String string2) {
        boolean bl2;
        if (object == null) {
            return Collections.emptyList();
        }
        if ((object = (List)object.get(string2)) != null && !(bl2 = object.isEmpty())) {
            return object;
        }
        return Collections.emptyList();
    }

    public static e.a.j c(Context object) {
        Object object2 = new a((Context)object);
        object = BackpressureStrategy.LATEST;
        object = e.a.j.D1((m)object2, (BackpressureStrategy)((Object)object));
        object2 = j.b();
        object = ((e.a.j)object).n6((h0)object2);
        object2 = Collections.emptyList();
        object = ((e.a.j)object).K4(object2);
        object2 = d.v.c.x1.d.a;
        object = ((e.a.j)object).u2((r)object2);
        object2 = g.a;
        object = ((e.a.j)object).y2((o)object2).M(3);
        object2 = d.v.c.x1.c.a;
        object = ((e.a.j)object).R3((o)object2);
        object2 = d.v.c.x1.e.a;
        return ((e.a.j)object).u2((r)object2);
    }

    private static boolean d(List object) {
        Object object2;
        String string2 = (String)object.get(0);
        boolean bl2 = Objects.equals(string2, object2 = "2");
        if (!bl2 && !(bl2 = Objects.equals(string2, object2 = b))) {
            return false;
        }
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            object2 = (String)object.next();
            bl2 = Objects.equals(string2, object2);
            if (bl2) continue;
            return false;
        }
        boolean bl3 = true;
        object2 = new Object[bl3];
        object2[0] = string2;
        m.a.a.i("Gesture detected: %s", object2);
        return bl3;
    }

    public static /* synthetic */ boolean e(List list) {
        return i.d(list);
    }

    public static /* synthetic */ void f(Context object, l l10) {
        boolean bl2;
        Object object2 = d;
        if (object2 == null) {
            object = i.a(object);
            d = object;
        }
        object = d;
        object2 = new b(l10);
        object.d((h)object2);
        while (!(bl2 = l10.isCancelled())) {
            bl2 = false;
            object = null;
            object2 = e;
            if (object2 != null) {
                object = (Bitmap)e.call();
            }
            if (object == null) continue;
            long l11 = 500L;
            SystemClock.sleep((long)l11);
            object2 = d;
            object2.i((Bitmap)object);
        }
        object = f.a;
        l10.setCancellable((e.a.v0.f)object);
    }

    public static /* synthetic */ boolean g(List list) {
        return list.isEmpty() ^ true;
    }

    public static /* synthetic */ boolean h(Boolean bl2) {
        return bl2;
    }

    public static /* synthetic */ void i(l l10, Map object) {
        object = i.b((Map)object, a);
        l10.onNext(object);
    }

    public static /* synthetic */ void j() {
        d.d(null);
    }

    private static void k(Map objectArray) {
        boolean bl2;
        CharSequence charSequence = new StringBuilder();
        objectArray = objectArray.entrySet().iterator();
        while (bl2 = objectArray.hasNext()) {
            Object object = (Map.Entry)objectArray.next();
            String string2 = (String)object.getKey();
            ((StringBuilder)charSequence).append(string2);
            char c10 = ':';
            ((StringBuilder)charSequence).append(c10);
            object = (List)object.getValue();
            i.m((StringBuilder)charSequence, (List)object);
        }
        objectArray = new Object[1];
        charSequence = ((StringBuilder)charSequence).toString();
        objectArray[0] = charSequence;
        m.a.a.b("%s", objectArray);
    }

    public static void l(Callable callable) {
        e = callable;
    }

    private static void m(StringBuilder stringBuilder, List list) {
        char c10;
        if (list != null && (c10 = list.isEmpty()) == '\u0000') {
            char c11;
            stringBuilder.append('[');
            for (c10 = '\u0000'; c10 < (c11 = list.size()); ++c10) {
                String string2 = list.get(c10).toString();
                stringBuilder.append(string2);
                c11 = list.size() + -1;
                if (c10 >= c11) continue;
                c11 = ',';
                stringBuilder.append(c11);
            }
            stringBuilder.append(']');
            return;
        }
        stringBuilder.append("[]");
    }
}

