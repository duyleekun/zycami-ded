/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package d.v.q.h;

import android.text.TextUtils;
import d.e.a.m;
import d.v.q.h.e;
import d.v.q.h.f$a;
import d.v.q.h.h;
import d.v.q.h.i;
import java.io.File;
import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class f
extends m {
    private h e;
    private final Map f;

    public f() {
        HashMap hashMap;
        this.f = hashMap = new HashMap();
    }

    public static /* synthetic */ h e(f f10) {
        return f10.e;
    }

    public static /* synthetic */ void f(f f10) {
        f10.a();
    }

    public static /* synthetic */ String g(f f10, File file, long l10) {
        return f10.h(file, l10);
    }

    private String h(File object, long l10) {
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object2 == false) {
            return null;
        }
        object2 = TextUtils.isEmpty((CharSequence)(object = ((File)object).getParent()));
        if (object2 != false) {
            object = new StringBuilder();
            ((StringBuilder)object).append(l10);
            String string2 = "";
            ((StringBuilder)object).append(string2);
            object = ((StringBuilder)object).toString();
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append((String)object);
            object = File.separator;
            stringBuilder.append((String)object);
            stringBuilder.append(l10);
            object = stringBuilder.toString();
        }
        return object;
    }

    private long i(File object) {
        Object object2 = this.f;
        String string2 = "fileDate";
        object2.remove(string2);
        object = ((File)object).getName();
        long l10 = i.f((String)object);
        long l11 = 0L;
        long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        if (l12 != false) {
            object = this.f;
            object2 = i.a;
            Date date = new Date(l10);
            object2 = ((DateFormat)object2).format(date);
            object.put(string2, object2);
        }
        return l10;
    }

    public void b(File file) {
        long l10 = this.i(file);
        Map map = this.f;
        f$a f$a = new f$a(this, file, l10);
        d.v.q.h.e.d(map, file, f$a);
    }

    public f j(Map map) {
        Map map2 = this.f;
        map2.clear();
        if (map != null) {
            map2 = this.f;
            map2.putAll(map);
        }
        return this;
    }

    public f k(h h10) {
        this.e = h10;
        return this;
    }
}

