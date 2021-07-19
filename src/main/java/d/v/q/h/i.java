/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package d.v.q.h;

import android.content.Context;
import d.v.e.l.b2;
import d.v.e.l.s1;
import d.v.q.e;
import d.v.q.f;
import d.v.q.h.a;
import d.v.q.h.b;
import d.v.q.h.c;
import java.io.File;
import java.io.FilenameFilter;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.function.IntFunction;

public class i {
    public static final SimpleDateFormat a;
    public static long b;

    static {
        SimpleDateFormat simpleDateFormat;
        a = simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        b = i.a();
    }

    private static long a() {
        Calendar calendar = Calendar.getInstance();
        Date date = new Date();
        calendar.setTime(date);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTime().getTime();
    }

    private static boolean b(String string2) {
        long l10;
        long l11 = i.f(string2);
        long l12 = l11 - (l10 = b);
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object < 0) {
            object = 1;
        } else {
            object = 0;
            string2 = null;
        }
        return (boolean)object;
    }

    public static /* synthetic */ boolean c(File object, String string2) {
        File file = new File((File)object, string2);
        boolean bl2 = file.isFile();
        if (bl2 && !(bl2 = string2.endsWith((String)(object = "copy"))) && (bl2 = i.b(string2))) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public static /* synthetic */ String d(String string2) {
        SimpleDateFormat simpleDateFormat = a;
        long l10 = i.f(string2);
        Date date = new Date(l10);
        return simpleDateFormat.format(date);
    }

    public static /* synthetic */ String[] e(int n10) {
        return new String[n10];
    }

    public static long f(String object) {
        String string2 = "\\.";
        try {
            object = object.split(string2);
            string2 = null;
        }
        catch (Exception exception) {
            return 0L;
        }
        object = object[0];
        return Long.parseLong((String)object);
    }

    public static void g(Context context) {
        boolean bl2 = b2.m(context);
        if (!bl2) {
            return;
        }
        Object object = f.c();
        int n10 = s1.q((String)object);
        if (n10 == 0) {
            return;
        }
        Object object2 = new File((String)object);
        object = d.v.q.h.b.a;
        if ((object = ((File)object2).list((FilenameFilter)object)) != null && (n10 = ((String[])object).length) != 0) {
            object = Arrays.stream(object);
            object2 = d.v.q.h.a.a;
            object = object.map(object2);
            object2 = c.a;
            object = (String[])object.toArray((IntFunction<A[]>)object2);
            n10 = 0;
            object2 = null;
            e.D(context, (String[])object, null);
        }
    }
}

