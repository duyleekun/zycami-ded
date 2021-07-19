/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ContentValues
 *  android.content.Context
 *  android.database.sqlite.SQLiteException
 *  android.net.ConnectivityManager
 *  android.text.TextUtils
 */
package com.xiaomi.push;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.net.ConnectivityManager;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.al;
import com.xiaomi.push.al$b;
import com.xiaomi.push.gx$a;
import com.xiaomi.push.gy;
import com.xiaomi.push.l;
import com.xiaomi.push.providers.a;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class gx {
    private static volatile int a;
    private static long a;
    private static al a;
    private static a a;
    private static final Object a;
    private static String a;
    private static List a;

    static {
        ArrayList arrayList = new ArrayList(true);
        a = arrayList;
        a = -1;
        a = System.currentTimeMillis();
        arrayList = new ArrayList();
        a = arrayList;
        arrayList = new ArrayList();
        a = Collections.synchronizedList(arrayList);
        a = "";
        a = null;
    }

    public static int a(Context context) {
        int n10 = a;
        int n11 = -1;
        if (n10 == n11) {
            int n12;
            a = n12 = gx.b(context);
        }
        return a;
    }

    public static int a(String string2) {
        Object object = "UTF-8";
        try {
            object = string2.getBytes((String)object);
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            return string2.getBytes().length;
        }
        return ((Object)object).length;
    }

    private static long a(int n10, long l10, boolean object, long l11, boolean bl2) {
        long l12;
        if (object != 0 && bl2) {
            long l13;
            long l14 = a;
            a = l11;
            long l15 = (l11 -= l14) - (l14 = 30000L);
            object = l15 == 0L ? 0 : (l15 < 0L ? -1 : 1);
            if (object > 0 && (object = (Object)((l13 = l10 - (l12 = 1024L)) == 0L ? 0 : (l13 < 0L ? -1 : 1))) > 0) {
                return l10 * (long)2;
            }
        }
        n10 = n10 == 0 ? 13 : 11;
        l12 = n10;
        return l10 * l12 / (long)10;
    }

    private static a a(Context context) {
        a a10 = a;
        if (a10 != null) {
            return a10;
        }
        a = a10 = new a(context);
        return a10;
    }

    public static /* synthetic */ Object a() {
        return a;
    }

    private static String a(Context object) {
        object = gx.class;
        synchronized (object) {
            block6: {
                String string2 = a;
                boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
                if (bl2) break block6;
                string2 = a;
                return string2;
            }
            return "";
            finally {
            }
        }
    }

    public static /* synthetic */ List a() {
        return a;
    }

    public static void a(Context context) {
        a = gx.b(context);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static void a(Context context, String string2, long l10, boolean bl2, long l11) {
        boolean bl3;
        Context context2 = context;
        if (context == null) return;
        int n10 = TextUtils.isEmpty((CharSequence)string2);
        if (n10 != 0) return;
        Object object = "com.xiaomi.xmsf";
        Object object2 = context.getPackageName();
        n10 = ((String)object).equals(object2);
        if (n10 == 0) return;
        object = "com.xiaomi.xmsf";
        n10 = ((String)object).equals(string2);
        if (n10 != 0) {
            return;
        }
        n10 = -1;
        int n11 = gx.a(context);
        if (n10 == n11) {
            return;
        }
        object = a;
        synchronized (object) {
            gx$a gx$a;
            object2 = a;
            bl3 = object2.isEmpty();
            object2 = n11 == 0 ? gx.a(context) : "";
            Object object3 = object2;
            object2 = gx$a;
            gx$a = new gx$a(string2, l11, n11, (int)(bl2 ? 1 : 0), (String)object3, l10);
            gx.a(gx$a);
        }
        if (!bl3) return;
        object = a;
        object2 = new gy(context);
        long l12 = 5000L;
        ((al)object).a((al$b)object2, l12);
    }

    public static void a(Context context, String string2, long l10, boolean bl2, boolean bl3, long l11) {
        long l12 = gx.a(gx.a(context), l10, bl2, l11, bl3);
        gx.a(context, string2, l12, bl2, l11);
    }

    public static /* synthetic */ void a(Context context, List list) {
        gx.b(context, list);
    }

    private static void a(gx$a gx$a) {
        boolean bl2;
        Iterator iterator2 = a.iterator();
        while (bl2 = iterator2.hasNext()) {
            gx$a gx$a2 = (gx$a)iterator2.next();
            boolean bl3 = gx$a2.a(gx$a);
            if (!bl3) continue;
            long l10 = gx$a2.b;
            long l11 = gx$a.b;
            gx$a2.b = l10 += l11;
            return;
        }
        a.add(gx$a);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void a(String string2) {
        Class<gx> clazz = gx.class;
        synchronized (clazz) {
            boolean bl2 = l.d();
            if (!bl2 && !(bl2 = TextUtils.isEmpty((CharSequence)string2))) {
                a = string2;
            }
            return;
        }
    }

    private static int b(Context object) {
        block5: {
            int n10;
            block4: {
                n10 = -1;
                String string2 = "connectivity";
                try {
                    object = object.getSystemService(string2);
                }
                catch (Exception exception) {
                    return n10;
                }
                object = (ConnectivityManager)object;
                if (object != null) break block4;
                return n10;
            }
            object = object.getActiveNetworkInfo();
            if (object != null) break block5;
            return n10;
        }
        return object.getType();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static void b(Context object, List object2) {
        try {
            Object object3 = com.xiaomi.push.providers.a.a;
            synchronized (object3) {
            }
        }
        catch (SQLiteException sQLiteException) {
            b.a(sQLiteException);
            return;
        }
        {
            object = gx.a(object);
            object = object.getWritableDatabase();
            object.beginTransaction();
            try {
                boolean bl2;
                object2 = object2.iterator();
                while (bl2 = object2.hasNext()) {
                    Object object4 = object2.next();
                    object4 = (gx$a)object4;
                    ContentValues contentValues = new ContentValues();
                    String string2 = "package_name";
                    Object object5 = ((gx$a)object4).a;
                    contentValues.put(string2, (String)object5);
                    string2 = "message_ts";
                    long l10 = ((gx$a)object4).a;
                    object5 = l10;
                    contentValues.put(string2, (Long)object5);
                    string2 = "network_type";
                    int n10 = ((gx$a)object4).a;
                    object5 = n10;
                    contentValues.put(string2, (Integer)object5);
                    string2 = "bytes";
                    l10 = ((gx$a)object4).b;
                    object5 = l10;
                    contentValues.put(string2, (Long)object5);
                    string2 = "rcv";
                    n10 = ((gx$a)object4).b;
                    object5 = n10;
                    contentValues.put(string2, (Integer)object5);
                    string2 = "imsi";
                    object4 = ((gx$a)object4).b;
                    contentValues.put(string2, object4);
                    object4 = "traffic";
                    string2 = null;
                    object.insert(object4, null, contentValues);
                }
                object.setTransactionSuccessful();
                return;
            }
            finally {
                object.endTransaction();
            }
        }
    }
}

