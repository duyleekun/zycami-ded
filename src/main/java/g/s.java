/*
 * Decompiled with CFR 0.151.
 */
package g;

import f.h2.t.f0;
import f.h2.t.h;
import f.h2.t.s0;
import f.h2.t.x0.a;
import f.q2.u;
import f.w0;
import f.x1.y;
import g.h0.j.c;
import g.s$a;
import g.s$b;
import j$.$r8$retargetLibraryMember$virtualDispatch$Date$toInstant$dispatchHolder;
import j$.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;

public final class s
implements Iterable,
a {
    public static final s$b b;
    private final String[] a;

    static {
        s$b s$b;
        b = s$b = new s$b(null);
    }

    private s(String[] stringArray) {
        this.a = stringArray;
    }

    public /* synthetic */ s(String[] stringArray, f.h2.t.u u10) {
        this(stringArray);
    }

    public static final s k(Map map) {
        return b.i(map);
    }

    public static final s l(String ... stringArray) {
        return b.j(stringArray);
    }

    public final int b() {
        return this.size();
    }

    public final long c() {
        String[] stringArray = this.a;
        int n10 = stringArray.length * 2;
        long l10 = n10;
        int n11 = stringArray.length;
        for (int i10 = 0; i10 < n11; ++i10) {
            String string2 = this.a[i10];
            int n12 = string2.length();
            long l11 = n12;
            l10 += l11;
        }
        return l10;
    }

    public final String e(String string2) {
        f0.p(string2, "name");
        s$b s$b = b;
        String[] stringArray = this.a;
        return s$b.e(s$b, stringArray, string2);
    }

    public boolean equals(Object objectArray) {
        Object[] objectArray2;
        boolean bl2;
        boolean bl3 = objectArray instanceof s;
        if (bl3 && (bl2 = Arrays.equals(objectArray2 = this.a, objectArray = ((s)objectArray).a))) {
            bl2 = true;
        } else {
            bl2 = false;
            objectArray = null;
        }
        return bl2;
    }

    public final Date f(String object) {
        String string2 = "name";
        f0.p(object, string2);
        object = this.e((String)object);
        object = object != null ? c.a((String)object) : null;
        return object;
    }

    public final Instant g(String object) {
        String string2 = "name";
        f0.p(object, string2);
        object = this.f((String)object);
        object = object != null ? $r8$retargetLibraryMember$virtualDispatch$Date$toInstant$dispatchHolder.toInstant((Date)object) : null;
        return object;
    }

    public final String h(int n10) {
        String[] stringArray = this.a;
        return stringArray[n10 *= 2];
    }

    public int hashCode() {
        return Arrays.hashCode(this.a);
    }

    public final Set i() {
        Comparator comparator = u.Q1(s0.a);
        Set<String> set = new Set<String>(comparator);
        int n10 = this.size();
        for (int i10 = 0; i10 < n10; ++i10) {
            String string2 = this.h(i10);
            ((TreeSet)set).add(string2);
        }
        set = Collections.unmodifiableSet(set);
        f0.o(set, "Collections.unmodifiableSet(result)");
        return set;
    }

    public Iterator iterator() {
        int n10 = this.size();
        Object[] objectArray = new Pair[n10];
        for (int i10 = 0; i10 < n10; ++i10) {
            Object object = this.h(i10);
            String string2 = this.n(i10);
            objectArray[i10] = object = w0.a(object, string2);
        }
        return h.a(objectArray);
    }

    public final s$a j() {
        s$a s$a = new s$a();
        List list = s$a.k();
        Object[] objectArray = this.a;
        y.s0(list, objectArray);
        return s$a;
    }

    public final Map m() {
        Comparator comparator = u.Q1(s0.a);
        TreeMap<String, ArrayList<String>> treeMap = new TreeMap<String, ArrayList<String>>(comparator);
        int n10 = this.size();
        for (int i10 = 0; i10 < n10; ++i10) {
            String string2 = this.h(i10);
            ArrayList<String> arrayList = Locale.US;
            f0.o(arrayList, "Locale.US");
            String string3 = "null cannot be cast to non-null type java.lang.String";
            Objects.requireNonNull(string2, string3);
            string2 = string2.toLowerCase((Locale)((Object)arrayList));
            f0.o(string2, "(this as java.lang.String).toLowerCase(locale)");
            arrayList = (List)treeMap.get(string2);
            if (arrayList == null) {
                int n11 = 2;
                arrayList = new ArrayList<String>(n11);
                treeMap.put(string2, arrayList);
            }
            string2 = this.n(i10);
            arrayList.add(string2);
        }
        return treeMap;
    }

    public final String n(int n10) {
        String[] stringArray = this.a;
        n10 = n10 * 2 + 1;
        return stringArray[n10];
    }

    public final List o(String list) {
        String string2 = "name";
        f0.p(list, string2);
        int n10 = this.size();
        ArrayList<String> arrayList = null;
        for (int i10 = 0; i10 < n10; ++i10) {
            boolean bl2;
            String string3 = this.h(i10);
            int n11 = u.I1(list, string3, bl2 = true);
            if (n11 == 0) continue;
            if (arrayList == null) {
                n11 = 2;
                arrayList = new ArrayList<String>(n11);
            }
            string3 = this.n(i10);
            arrayList.add(string3);
        }
        if (arrayList != null) {
            list = Collections.unmodifiableList(arrayList);
            string2 = "Collections.unmodifiableList(result)";
            f0.o(list, string2);
        } else {
            list = CollectionsKt__CollectionsKt.E();
        }
        return list;
    }

    public final int size() {
        return this.a.length / 2;
    }

    public String toString() {
        CharSequence charSequence = new StringBuilder();
        int n10 = this.size();
        for (int i10 = 0; i10 < n10; ++i10) {
            String string2 = this.h(i10);
            ((StringBuilder)charSequence).append(string2);
            ((StringBuilder)charSequence).append(": ");
            string2 = this.n(i10);
            ((StringBuilder)charSequence).append(string2);
            string2 = "\n";
            ((StringBuilder)charSequence).append(string2);
        }
        charSequence = ((StringBuilder)charSequence).toString();
        f0.o(charSequence, "StringBuilder().apply(builderAction).toString()");
        return charSequence;
    }
}

