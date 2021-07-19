/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.res.Resources
 *  android.content.res.Resources$NotFoundException
 *  android.text.TextUtils
 */
package l.a.q.g0;

import android.content.res.Resources;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.function.IntFunction;
import java.util.stream.Stream;
import l.a.q.g0.c;
import l.a.q.g0.d;
import l.a.q.g0.e;
import l.a.q.g0.n;
import l.a.q.g0.r;

public final class p {
    private static final Map a;
    private static final Map b;
    private static String c;

    static {
        HashMap hashMap;
        a = hashMap = new HashMap();
        b = hashMap = new HashMap();
    }

    private p() {
        AssertionError assertionError = new AssertionError((Object)"no instance");
        throw assertionError;
    }

    private static boolean a() {
        return a.isEmpty();
    }

    public static void b() {
        a.clear();
        b.clear();
    }

    private static boolean c(List object, String string2, String string3) {
        boolean bl2;
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            String string4 = (String)object.next();
            bl2 = string2.equals(string4);
            if (!bl2) continue;
            b.put(string3, string2);
            return true;
        }
        return false;
    }

    private static String d(Resources object, int n10) {
        String string2 = object.getResourceEntryName(n10);
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (bl2) {
            return null;
        }
        object = p.g((Resources)object).iterator();
        while (bl2 = object.hasNext()) {
            r r10 = (r)object.next();
            String string3 = r10.a();
            boolean bl3 = string2.equals(string3);
            if (!bl3) continue;
            return r10.b();
        }
        return null;
    }

    private static String[] e(Resources object, int n10) {
        String[] stringArray = object.getResourceEntryName(n10);
        boolean bl2 = TextUtils.isEmpty((CharSequence)stringArray);
        if (bl2) {
            return null;
        }
        object = p.g((Resources)object).iterator();
        while (bl2 = object.hasNext()) {
            r r10 = (r)object.next();
            String string2 = r10.a();
            boolean bl3 = stringArray.equals(string2);
            if (!bl3) continue;
            object = r10.c();
            stringArray = new String[]{};
            return object.toArray(stringArray);
        }
        return null;
    }

    private static String f(Resources object) {
        boolean bl2;
        object = n.a((Resources)object);
        Object object2 = b;
        Object object3 = object2.keySet();
        Object object4 = new ArrayList(object3);
        boolean bl3 = object4.isEmpty();
        if (!bl3 && (bl2 = (object3 = object[0]).equals(object4 = object4.get(0)))) {
            object4 = object[0];
            if ((object4 = object2.get(object4)) != null) {
                object = object[0];
                return (String)object2.get(object);
            }
        }
        object2.clear();
        object2 = a.keySet();
        object4 = new ArrayList(object2);
        object2 = c;
        int n10 = TextUtils.isEmpty((CharSequence)object2);
        if (n10 == 0) {
            object2 = c;
            object4.add(object2);
        }
        n10 = ((String[])object).length;
        Object object5 = object3 = "";
        for (int i10 = 0; i10 < n10; ++i10) {
            Object object6;
            int n11;
            object5 = object[i10];
            Stream stream = object[0];
            int n12 = p.c((List)object4, (String)object5, (String)((Object)stream));
            if (n12 != 0) {
                return object5;
            }
            stream = "_";
            n12 = ((String[])(object5 = object5.split((String)((Object)stream)))).length;
            if (n12 == (n11 = 2) && (n12 = (int)(((String)(object6 = "zh")).equals(stream = object5[0]) ? 1 : 0)) != 0 && (n12 = (int)(n.d((String)((Object)(stream = object5[1]))) ? 1 : 0)) != 0 && (n11 = (int)(p.c((List)object4, (String)((Object)(stream = "zh_TW")), (String)(object6 = object[0])) ? 1 : 0)) != 0) {
                return stream;
            }
            stream = object[0];
            n12 = (int)(p.c((List)object4, (String)(object5 = object5[0]), (String)((Object)stream)) ? 1 : 0);
            if (n12 != 0) {
                return object5;
            }
            stream = object4.stream();
            object5 = (String)stream.filter(object6 = new c((String)object5)).findFirst().orElse((String[])object3);
            n12 = (int)(TextUtils.isEmpty((CharSequence)object5) ? 1 : 0);
            if (n12 != 0) continue;
            object4 = b;
            object = object[0];
            object4.put(object, object5);
            return object5;
        }
        object4 = b;
        object = object[0];
        object4.put(object, object5);
        return object5;
    }

    private static List g(Resources object) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)(object = p.f(object)));
        if (bl2) {
            return Collections.emptyList();
        }
        Map map = a;
        if ((object = (List)map.get(object)) == null) {
            object = Collections.emptyList();
        }
        return object;
    }

    public static String h(Resources resources, int n10) {
        block8: {
            block7: {
                try {
                    boolean bl2 = p.a();
                    if (!bl2) break block7;
                }
                catch (Resources.NotFoundException notFoundException) {
                    return "";
                }
                return resources.getString(n10);
            }
            String string2 = p.d(resources, n10);
            boolean bl3 = TextUtils.isEmpty((CharSequence)string2);
            if (bl3) break block8;
            return p.o(string2);
        }
        return resources.getString(n10);
    }

    public static String i(Resources object, int n10, Object ... objectArray) {
        block10: {
            block9: {
                try {
                    boolean bl2 = p.a();
                    if (!bl2) break block9;
                }
                catch (Resources.NotFoundException notFoundException) {
                    return "";
                }
                return object.getString(n10, objectArray);
            }
            String string2 = p.d(object, n10);
            boolean bl3 = TextUtils.isEmpty((CharSequence)string2);
            if (bl3) break block10;
            String string3 = p.o(string2);
            object = n.b(object);
            return String.format((Locale)object, string3, objectArray);
        }
        return object.getString(n10, objectArray);
    }

    public static String[] j(Resources object, int n10) {
        block13: {
            block12: {
                try {
                    boolean bl2 = p.a();
                    if (!bl2) break block12;
                }
                catch (Resources.NotFoundException notFoundException) {
                    return new String[0];
                }
                return object.getStringArray(n10);
            }
            String[] stringArray = p.e((Resources)object, n10);
            if (stringArray == null) break block13;
            object = p.j((Resources)object, n10);
            object = Arrays.stream(object);
            Object object2 = e.a;
            object = object.map(object2);
            object2 = d.a;
            object = object.toArray((IntFunction<A[]>)object2);
            return (String[])object;
        }
        return object.getStringArray(n10);
    }

    public static /* synthetic */ String k(String string2) {
        return p.o(string2);
    }

    public static /* synthetic */ boolean l(String string2, String string3) {
        return string3.startsWith(string2);
    }

    public static /* synthetic */ String[] m(int n10) {
        return new String[n10];
    }

    public static void n(String string2, List list) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (!bl2 && list != null) {
            Map map = a;
            map.put(string2, list);
        }
    }

    private static String o(String string2) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (bl2) {
            return string2;
        }
        return string2.replace("\\n", "\n").replace("\\f", "\f").replace("\\r", "\r").replace("\\t", "\t").replace("\\\"", "\"").replace("\\", "");
    }

    public static void p(String string2) {
        c = string2;
    }
}

