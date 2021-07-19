/*
 * Decompiled with CFR 0.151.
 */
package f.e2;

import f.e2.g;
import f.h2.t.f0;
import f.x1.u;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.text.StringsKt__StringsKt;

public class k {
    public static final File a(File object) {
        f0.p(object, "$this$root");
        object = k.c((File)object);
        File file = new File((String)object);
        return file;
    }

    private static final int b(String string2) {
        int n10;
        char c10;
        int n102 = File.separatorChar;
        char c102 = '\u0000';
        boolean c11 = false;
        int n11 = 4;
        int n12 = StringsKt__StringsKt.i3(string2, (char)n102, 0, false, n11, null);
        n102 = 1;
        if (n12 == 0) {
            int n13;
            char c12;
            n12 = string2.length();
            if (n12 > n102 && (n12 = (int)string2.charAt(n102)) == (c12 = File.separatorChar) && (n12 = StringsKt__StringsKt.i3(string2, c12, n11 = 2, false, n13 = 4, null)) >= 0) {
                char c13 = File.separatorChar;
                n11 = n12 + 1;
                n13 = 4;
                if ((n12 = StringsKt__StringsKt.i3(string2, c13, n11, false, n13, null)) >= 0) {
                    return n12 + n102;
                }
                return string2.length();
            }
            return n102;
        }
        c102 = ':';
        if (n12 > 0 && (c10 = string2.charAt(n10 = n12 + -1)) == c102) {
            return n12 + n102;
        }
        n102 = -1;
        boolean bl2 = false;
        if (n12 == n102) {
            n102 = 0;
            n12 = (int)(StringsKt__StringsKt.S2(string2, c102, false, 2, null) ? 1 : 0);
            if (n12 != 0) {
                return string2.length();
            }
        }
        return 0;
    }

    public static final String c(File object) {
        f0.p(object, "$this$rootName");
        String string2 = ((File)object).getPath();
        String string3 = "path";
        f0.o(string2, string3);
        object = ((File)object).getPath();
        f0.o(object, string3);
        int n10 = k.b((String)object);
        Objects.requireNonNull(string2, "null cannot be cast to non-null type java.lang.String");
        object = string2.substring(0, n10);
        f0.o(object, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
        return object;
    }

    /*
     * WARNING - void declaration
     */
    public static final boolean d(File object) {
        void var2_5;
        f0.p(object, "$this$isRooted");
        object = ((File)object).getPath();
        String string2 = "path";
        f0.o(object, string2);
        int bl2 = k.b((String)object);
        if (bl2 > 0) {
            boolean bl3 = true;
        } else {
            boolean bl4 = false;
            object = null;
        }
        return (boolean)var2_5;
    }

    public static final File e(File file, int n10, int n11) {
        f0.p(file, "$this$subPath");
        return k.f(file).j(n10, n11);
    }

    public static final g f(File object) {
        f0.p(object, "$this$toComponents");
        object = ((File)object).getPath();
        ArrayList<Object> arrayList = "path";
        f0.o(object, (String)((Object)arrayList));
        int n10 = k.b((String)object);
        int n11 = 0;
        Object object2 = null;
        String string2 = ((String)object).substring(0, n10);
        Object object3 = "(this as java.lang.Strin\u2026ing(startIndex, endIndex)";
        f0.o(string2, (String)object3);
        String string3 = ((String)object).substring(n10);
        object = "(this as java.lang.String).substring(startIndex)";
        f0.o(string3, (String)object);
        int n12 = string3.length();
        n10 = 1;
        if (n12 == 0) {
            n12 = n10;
        } else {
            n12 = 0;
            object = null;
        }
        if (n12 != 0) {
            object = CollectionsKt__CollectionsKt.E();
        } else {
            char[] cArray = new char[n10];
            cArray[0] = n12 = (int)File.separatorChar;
            int n13 = 6;
            object = StringsKt__StringsKt.H4(string3, cArray, false, 0, n13, null);
            n11 = u.Y((Iterable)object, 10);
            arrayList = new ArrayList<Object>(n11);
            object = object.iterator();
            while ((n11 = (int)(object.hasNext() ? 1 : 0)) != 0) {
                object2 = (String)object.next();
                object3 = new File((String)object2);
                arrayList.add(object3);
            }
            object = arrayList;
        }
        object2 = new File(string2);
        arrayList = new ArrayList<Object>((File)object2, (List)object);
        return arrayList;
    }
}

