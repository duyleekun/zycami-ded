/*
 * Decompiled with CFR 0.151.
 */
package kotlin.text;

import f.g1;
import f.h2.s.l;
import f.h2.s.p;
import f.h2.t.f0;
import f.k2.e;
import f.k2.e$a;
import f.l2.i;
import f.l2.k;
import f.l2.q;
import f.n2.m;
import f.q2.v;
import f.w0;
import f.x1.c1;
import f.x1.d1;
import f.x1.e0;
import f.x1.j0;
import f.x1.s0;
import f.x1.t;
import f.x1.u;
import f.x1.y;
import java.io.Serializable;
import java.lang.constant.Constable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.SlidingWindowKt;
import kotlin.sequences.SequencesKt__SequencesKt;
import kotlin.sequences.SequencesKt___SequencesKt;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.StringsKt___StringsKt$a;
import kotlin.text.StringsKt___StringsKt$b;
import kotlin.text.StringsKt___StringsKt$c;
import kotlin.text.StringsKt___StringsKt$chunkedSequence$1;
import kotlin.text.StringsKt___StringsKt$windowed$1;
import kotlin.text.StringsKt___StringsKt$windowedSequence$1;
import kotlin.text.StringsKt___StringsKt$windowedSequence$2;
import kotlin.text.StringsKt___StringsKt$withIndex$1;

public class StringsKt___StringsKt
extends v {
    public static final char A6(CharSequence object, l l10) {
        int n10;
        f0.p(object, "$this$first");
        f0.p(l10, "predicate");
        for (int i10 = 0; i10 < (n10 = object.length()); ++i10) {
            n10 = object.charAt(i10);
            Comparable<Character> comparable = Character.valueOf((char)n10);
            boolean bl2 = (Boolean)(comparable = (Boolean)l10.invoke(comparable));
            if (!bl2) continue;
            return (char)n10;
        }
        object = new NoSuchElementException("Char sequence contains no character matching the predicate.");
        throw object;
    }

    private static final float A7(CharSequence object, l l10) {
        Serializable serializable;
        float f10;
        int n10 = object.length();
        int n11 = 0;
        int n12 = 1;
        float f11 = Float.MIN_VALUE;
        if (n10 == 0) {
            n10 = n12;
            f10 = f11;
        } else {
            n10 = 0;
            serializable = null;
            f10 = 0.0f;
        }
        if (n10 == 0) {
            n10 = object.charAt(0);
            serializable = Character.valueOf((char)n10);
            serializable = (Number)l10.invoke(serializable);
            f10 = ((Number)serializable).floatValue();
            n11 = StringsKt__StringsKt.a3((CharSequence)object);
            if (n12 <= n11) {
                while (true) {
                    char c10 = object.charAt(n12);
                    Serializable serializable2 = Character.valueOf(c10);
                    serializable2 = (Number)l10.invoke(serializable2);
                    float f12 = ((Number)serializable2).floatValue();
                    f10 = Math.min(f10, f12);
                    if (n12 == n11) break;
                    ++n12;
                }
            }
            return f10;
        }
        object = new NoSuchElementException();
        throw object;
    }

    private static final long A8(CharSequence charSequence, l l10) {
        int n10;
        long l11 = g1.h(0);
        for (int i10 = 0; i10 < (n10 = charSequence.length()); ++i10) {
            n10 = charSequence.charAt(i10);
            Comparable<Character> comparable = Character.valueOf((char)n10);
            comparable = (g1)l10.invoke(comparable);
            long l12 = ((g1)comparable).a0();
            l11 = g1.h(l11 + l12);
        }
        return l11;
    }

    public static final Character B6(CharSequence object) {
        String string2 = "$this$firstOrNull";
        f0.p(object, string2);
        int n10 = object.length();
        if (n10 == 0) {
            n10 = 1;
        } else {
            n10 = 0;
            string2 = null;
        }
        if (n10 != 0) {
            boolean bl2 = false;
            object = null;
        } else {
            char c10 = object.charAt(0);
            object = Character.valueOf(c10);
        }
        return object;
    }

    private static final Comparable B7(CharSequence object, l l10) {
        Comparable<Character> comparable;
        int n10 = object.length();
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            comparable = null;
        }
        if (n10 == 0) {
            n10 = object.charAt(0);
            comparable = Character.valueOf((char)n10);
            comparable = (Comparable)l10.invoke(comparable);
            n11 = StringsKt__StringsKt.a3((CharSequence)object);
            if (n12 <= n11) {
                while (true) {
                    char c10 = object.charAt(n12);
                    Comparable<Character> comparable2 = Character.valueOf(c10);
                    int n13 = comparable.compareTo((Character)(comparable2 = (Comparable)l10.invoke(comparable2)));
                    if (n13 > 0) {
                        comparable = comparable2;
                    }
                    if (n12 == n11) break;
                    ++n12;
                }
            }
            return comparable;
        }
        object = new NoSuchElementException();
        throw object;
    }

    public static final CharSequence B8(CharSequence charSequence, int n10) {
        f0.p(charSequence, "$this$take");
        int n11 = n10 >= 0 ? 1 : 0;
        if (n11 != 0) {
            n11 = charSequence.length();
            n10 = q.u(n10, n11);
            return charSequence.subSequence(0, n10);
        }
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("Requested character count ");
        ((StringBuilder)charSequence).append(n10);
        ((StringBuilder)charSequence).append(" is less than zero.");
        charSequence = ((StringBuilder)charSequence).toString();
        charSequence = ((Object)charSequence).toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)charSequence);
        throw illegalArgumentException;
    }

    public static final Character C6(CharSequence charSequence, l l10) {
        int n10;
        f0.p(charSequence, "$this$firstOrNull");
        f0.p(l10, "predicate");
        for (int i10 = 0; i10 < (n10 = charSequence.length()); ++i10) {
            n10 = charSequence.charAt(i10);
            Comparable<Character> comparable = Character.valueOf((char)n10);
            boolean bl2 = (Boolean)(comparable = (Boolean)l10.invoke(comparable));
            if (!bl2) continue;
            return Character.valueOf((char)n10);
        }
        return null;
    }

    private static final Comparable C7(CharSequence charSequence, l l10) {
        Comparable<Character> comparable;
        int n10 = charSequence.length();
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            comparable = null;
        }
        if (n10 != 0) {
            return null;
        }
        n10 = charSequence.charAt(0);
        comparable = Character.valueOf((char)n10);
        comparable = (Comparable)l10.invoke(comparable);
        n11 = StringsKt__StringsKt.a3(charSequence);
        if (n12 <= n11) {
            while (true) {
                char c10 = charSequence.charAt(n12);
                Comparable<Character> comparable2 = Character.valueOf(c10);
                int n13 = comparable.compareTo((Character)(comparable2 = (Comparable)l10.invoke(comparable2)));
                if (n13 > 0) {
                    comparable = comparable2;
                }
                if (n12 == n11) break;
                ++n12;
            }
        }
        return comparable;
    }

    public static final String C8(String charSequence, int n10) {
        f0.p(charSequence, "$this$take");
        int n11 = n10 >= 0 ? 1 : 0;
        if (n11 != 0) {
            n11 = ((String)charSequence).length();
            n10 = q.u(n10, n11);
            charSequence = ((String)charSequence).substring(0, n10);
            f0.o(charSequence, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
            return charSequence;
        }
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("Requested character count ");
        ((StringBuilder)charSequence).append(n10);
        ((StringBuilder)charSequence).append(" is less than zero.");
        charSequence = ((StringBuilder)charSequence).toString();
        charSequence = charSequence.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)charSequence);
        throw illegalArgumentException;
    }

    public static final List D6(CharSequence charSequence, l l10) {
        int n10;
        f0.p(charSequence, "$this$flatMap");
        f0.p(l10, "transform");
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < (n10 = charSequence.length()); ++i10) {
            n10 = charSequence.charAt(i10);
            Object object = Character.valueOf((char)n10);
            object = (Iterable)l10.invoke(object);
            y.q0(arrayList, (Iterable)object);
        }
        return arrayList;
    }

    private static final Double D7(CharSequence charSequence, l l10) {
        Serializable serializable;
        int n10 = charSequence.length();
        int n11 = 1;
        if (n10 == 0) {
            n10 = n11;
        } else {
            n10 = 0;
            serializable = null;
        }
        if (n10 != 0) {
            return null;
        }
        n10 = charSequence.charAt(0);
        serializable = Character.valueOf((char)n10);
        serializable = (Number)l10.invoke(serializable);
        double d10 = ((Number)serializable).doubleValue();
        int n12 = StringsKt__StringsKt.a3(charSequence);
        if (n11 <= n12) {
            while (true) {
                char c10 = charSequence.charAt(n11);
                Serializable serializable2 = Character.valueOf(c10);
                serializable2 = (Number)l10.invoke(serializable2);
                double d11 = ((Number)serializable2).doubleValue();
                d10 = Math.min(d10, d11);
                if (n11 == n12) break;
                ++n11;
            }
        }
        return d10;
    }

    public static final CharSequence D8(CharSequence charSequence, int n10) {
        int n11;
        String string2 = "$this$takeLast";
        f0.p(charSequence, string2);
        if (n10 >= 0) {
            n11 = 1;
        } else {
            n11 = 0;
            string2 = null;
        }
        if (n11 != 0) {
            n11 = charSequence.length();
            n10 = q.u(n10, n11);
            n10 = n11 - n10;
            return charSequence.subSequence(n10, n11);
        }
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("Requested character count ");
        ((StringBuilder)charSequence).append(n10);
        ((StringBuilder)charSequence).append(" is less than zero.");
        charSequence = ((StringBuilder)charSequence).toString();
        charSequence = ((Object)charSequence).toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)charSequence);
        throw illegalArgumentException;
    }

    private static final List E6(CharSequence charSequence, p p10) {
        int n10;
        ArrayList arrayList = new ArrayList();
        int n11 = 0;
        for (int i10 = 0; i10 < (n10 = charSequence.length()); ++i10) {
            n10 = charSequence.charAt(i10);
            Integer n12 = n11;
            ++n11;
            Object object = Character.valueOf((char)n10);
            object = (Iterable)p10.invoke(n12, object);
            y.q0(arrayList, (Iterable)object);
        }
        return arrayList;
    }

    private static final Float E7(CharSequence charSequence, l l10) {
        Serializable serializable;
        float f10;
        int n10 = charSequence.length();
        int n11 = 0;
        int n12 = 1;
        float f11 = Float.MIN_VALUE;
        if (n10 == 0) {
            n10 = n12;
            f10 = f11;
        } else {
            n10 = 0;
            serializable = null;
            f10 = 0.0f;
        }
        if (n10 != 0) {
            return null;
        }
        n10 = charSequence.charAt(0);
        serializable = Character.valueOf((char)n10);
        serializable = (Number)l10.invoke(serializable);
        f10 = ((Number)serializable).floatValue();
        n11 = StringsKt__StringsKt.a3(charSequence);
        if (n12 <= n11) {
            while (true) {
                char c10 = charSequence.charAt(n12);
                Serializable serializable2 = Character.valueOf(c10);
                serializable2 = (Number)l10.invoke(serializable2);
                float f12 = ((Number)serializable2).floatValue();
                f10 = Math.min(f10, f12);
                if (n12 == n11) break;
                ++n12;
            }
        }
        return Float.valueOf(f10);
    }

    public static final String E8(String charSequence, int n10) {
        int n11;
        String string2 = "$this$takeLast";
        f0.p(charSequence, string2);
        if (n10 >= 0) {
            n11 = 1;
        } else {
            n11 = 0;
            string2 = null;
        }
        if (n11 != 0) {
            n11 = ((String)charSequence).length();
            n10 = q.u(n10, n11);
            charSequence = ((String)charSequence).substring(n11 -= n10);
            f0.o(charSequence, "(this as java.lang.String).substring(startIndex)");
            return charSequence;
        }
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("Requested character count ");
        ((StringBuilder)charSequence).append(n10);
        ((StringBuilder)charSequence).append(" is less than zero.");
        charSequence = ((StringBuilder)charSequence).toString();
        charSequence = charSequence.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)charSequence);
        throw illegalArgumentException;
    }

    private static final Collection F6(CharSequence charSequence, Collection collection, p p10) {
        int n10;
        int n11 = 0;
        for (int i10 = 0; i10 < (n10 = charSequence.length()); ++i10) {
            n10 = charSequence.charAt(i10);
            Integer n12 = n11;
            ++n11;
            Object object = Character.valueOf((char)n10);
            object = (Iterable)p10.invoke(n12, object);
            y.q0(collection, (Iterable)object);
        }
        return collection;
    }

    private static final Object F7(CharSequence object, Comparator comparator, l l10) {
        Object object2;
        int n10 = object.length();
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            object2 = null;
        }
        if (n10 == 0) {
            n10 = object.charAt(0);
            object2 = Character.valueOf((char)n10);
            object2 = l10.invoke(object2);
            n11 = StringsKt__StringsKt.a3((CharSequence)object);
            if (n12 <= n11) {
                while (true) {
                    char c10 = object.charAt(n12);
                    Object object3 = Character.valueOf(c10);
                    int n13 = comparator.compare(object2, object3 = l10.invoke(object3));
                    if (n13 > 0) {
                        object2 = object3;
                    }
                    if (n12 == n11) break;
                    ++n12;
                }
            }
            return object2;
        }
        object = new NoSuchElementException();
        throw object;
    }

    public static final CharSequence F8(CharSequence charSequence, l l10) {
        int n10;
        f0.p(charSequence, "$this$takeLastWhile");
        String string2 = "predicate";
        f0.p(l10, string2);
        for (n10 = StringsKt__StringsKt.a3(charSequence); n10 >= 0; n10 += -1) {
            Comparable<Character> comparable = Character.valueOf(charSequence.charAt(n10));
            boolean bl2 = (Boolean)(comparable = (Boolean)l10.invoke(comparable));
            if (bl2) continue;
            int n11 = charSequence.length();
            return charSequence.subSequence(++n10, n11);
        }
        n10 = charSequence.length();
        return charSequence.subSequence(0, n10);
    }

    public static final Collection G6(CharSequence charSequence, Collection collection, l l10) {
        int n10;
        f0.p(charSequence, "$this$flatMapTo");
        f0.p(collection, "destination");
        f0.p(l10, "transform");
        for (int i10 = 0; i10 < (n10 = charSequence.length()); ++i10) {
            n10 = charSequence.charAt(i10);
            Object object = Character.valueOf((char)n10);
            object = (Iterable)l10.invoke(object);
            y.q0(collection, (Iterable)object);
        }
        return collection;
    }

    private static final Object G7(CharSequence charSequence, Comparator comparator, l l10) {
        Object object;
        int n10 = charSequence.length();
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            object = null;
        }
        if (n10 != 0) {
            return null;
        }
        n10 = charSequence.charAt(0);
        object = Character.valueOf((char)n10);
        object = l10.invoke(object);
        n11 = StringsKt__StringsKt.a3(charSequence);
        if (n12 <= n11) {
            while (true) {
                char c10 = charSequence.charAt(n12);
                Object object2 = Character.valueOf(c10);
                int n13 = comparator.compare(object, object2 = l10.invoke(object2));
                if (n13 > 0) {
                    object = object2;
                }
                if (n12 == n11) break;
                ++n12;
            }
        }
        return object;
    }

    public static final String G8(String string2, l l10) {
        f0.p(string2, "$this$takeLastWhile");
        String string3 = "predicate";
        f0.p(l10, string3);
        for (int i10 = StringsKt__StringsKt.a3(string2); i10 >= 0; i10 += -1) {
            Comparable<Character> comparable = Character.valueOf(string2.charAt(i10));
            boolean bl2 = (Boolean)(comparable = (Boolean)l10.invoke(comparable));
            if (bl2) continue;
            string2 = string2.substring(++i10);
            f0.o(string2, "(this as java.lang.String).substring(startIndex)");
            return string2;
        }
        return string2;
    }

    public static final Object H6(CharSequence charSequence, Object object, p p10) {
        int n10;
        f0.p(charSequence, "$this$fold");
        f0.p(p10, "operation");
        for (int i10 = 0; i10 < (n10 = charSequence.length()); ++i10) {
            n10 = charSequence.charAt(i10);
            Character c10 = Character.valueOf((char)n10);
            object = p10.invoke(object, c10);
        }
        return object;
    }

    public static final Character H7(CharSequence charSequence) {
        String string2 = "$this$minOrNull";
        f0.p(charSequence, string2);
        int n10 = charSequence.length();
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            string2 = null;
        }
        if (n10 != 0) {
            return null;
        }
        n10 = charSequence.charAt(0);
        n11 = StringsKt__StringsKt.a3(charSequence);
        if (n12 <= n11) {
            while (true) {
                int n13;
                int n14;
                if ((n14 = f0.t(n10, n13 = charSequence.charAt(n12))) > 0) {
                    n10 = n13;
                }
                if (n12 == n11) break;
                ++n12;
            }
        }
        return Character.valueOf((char)n10);
    }

    public static final CharSequence H8(CharSequence charSequence, l l10) {
        f0.p(charSequence, "$this$takeWhile");
        String string2 = "predicate";
        f0.p(l10, string2);
        int n10 = charSequence.length();
        for (int i10 = 0; i10 < n10; ++i10) {
            Comparable<Character> comparable = Character.valueOf(charSequence.charAt(i10));
            boolean bl2 = (Boolean)(comparable = (Boolean)l10.invoke(comparable));
            if (bl2) continue;
            return charSequence.subSequence(0, i10);
        }
        int n11 = charSequence.length();
        return charSequence.subSequence(0, n11);
    }

    public static final Object I6(CharSequence charSequence, Object object, f.h2.s.q q10) {
        int n10;
        f0.p(charSequence, "$this$foldIndexed");
        f0.p(q10, "operation");
        int n11 = 0;
        for (int i10 = 0; i10 < (n10 = charSequence.length()); ++i10) {
            n10 = charSequence.charAt(i10);
            Integer n12 = n11;
            ++n11;
            Character c10 = Character.valueOf((char)n10);
            object = q10.invoke(n12, object, c10);
        }
        return object;
    }

    public static final Character I7(CharSequence charSequence, Comparator comparator) {
        f0.p(charSequence, "$this$minWith");
        f0.p(comparator, "comparator");
        return StringsKt___StringsKt.J7(charSequence, comparator);
    }

    public static final String I8(String string2, l l10) {
        f0.p(string2, "$this$takeWhile");
        String string3 = "predicate";
        f0.p(l10, string3);
        int n10 = string2.length();
        for (int i10 = 0; i10 < n10; ++i10) {
            Comparable<Character> comparable = Character.valueOf(string2.charAt(i10));
            boolean bl2 = (Boolean)(comparable = (Boolean)l10.invoke(comparable));
            if (bl2) continue;
            string2 = string2.substring(0, i10);
            f0.o(string2, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
            return string2;
        }
        return string2;
    }

    public static final Object J6(CharSequence charSequence, Object object, p p10) {
        f0.p(charSequence, "$this$foldRight");
        Object object2 = "operation";
        f0.p(p10, (String)object2);
        int n10 = StringsKt__StringsKt.a3(charSequence);
        while (n10 >= 0) {
            int n11 = n10 + -1;
            object2 = Character.valueOf(charSequence.charAt(n10));
            object = p10.invoke(object2, object);
            n10 = n11;
        }
        return object;
    }

    public static final Character J7(CharSequence charSequence, Comparator comparator) {
        f0.p(charSequence, "$this$minWithOrNull");
        String string2 = "comparator";
        f0.p(comparator, string2);
        int n10 = charSequence.length();
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            string2 = null;
        }
        if (n10 != 0) {
            return null;
        }
        n10 = charSequence.charAt(0);
        n11 = StringsKt__StringsKt.a3(charSequence);
        if (n12 <= n11) {
            while (true) {
                Character c10;
                int n13 = charSequence.charAt(n12);
                Character c11 = Character.valueOf((char)n10);
                int n14 = comparator.compare(c11, c10 = Character.valueOf((char)n13));
                if (n14 > 0) {
                    n10 = n13;
                }
                if (n12 == n11) break;
                ++n12;
            }
        }
        return Character.valueOf((char)n10);
    }

    public static final Collection J8(CharSequence charSequence, Collection collection) {
        int n10;
        f0.p(charSequence, "$this$toCollection");
        f0.p(collection, "destination");
        for (int i10 = 0; i10 < (n10 = charSequence.length()); ++i10) {
            n10 = charSequence.charAt(i10);
            Character c10 = Character.valueOf((char)n10);
            collection.add(c10);
        }
        return collection;
    }

    public static final Object K6(CharSequence charSequence, Object object, f.h2.s.q q10) {
        f0.p(charSequence, "$this$foldRightIndexed");
        String string2 = "operation";
        f0.p(q10, string2);
        for (int i10 = StringsKt__StringsKt.a3(charSequence); i10 >= 0; i10 += -1) {
            Integer n10 = i10;
            char c10 = charSequence.charAt(i10);
            Character c11 = Character.valueOf(c10);
            object = q10.invoke(n10, c11, object);
        }
        return object;
    }

    /*
     * WARNING - void declaration
     */
    public static final boolean K7(CharSequence charSequence) {
        void var2_5;
        String string2 = "$this$none";
        f0.p(charSequence, string2);
        int bl2 = charSequence.length();
        if (bl2 == 0) {
            boolean bl3 = true;
        } else {
            boolean bl4 = false;
            charSequence = null;
        }
        return (boolean)var2_5;
    }

    public static final HashSet K8(CharSequence charSequence) {
        f0.p(charSequence, "$this$toHashSet");
        int n10 = s0.j(q.u(charSequence.length(), 128));
        HashSet hashSet = new HashSet(n10);
        return (HashSet)StringsKt___StringsKt.J8(charSequence, hashSet);
    }

    public static final boolean L5(CharSequence charSequence, l l10) {
        int n10;
        f0.p(charSequence, "$this$all");
        f0.p(l10, "predicate");
        for (int i10 = 0; i10 < (n10 = charSequence.length()); ++i10) {
            Comparable<Character> comparable = Character.valueOf(charSequence.charAt(i10));
            n10 = (int)(((Boolean)(comparable = (Boolean)l10.invoke(comparable))).booleanValue() ? 1 : 0);
            if (n10 != 0) continue;
            return false;
        }
        return true;
    }

    public static final void L6(CharSequence charSequence, l l10) {
        int n10;
        f0.p(charSequence, "$this$forEach");
        f0.p(l10, "action");
        for (int i10 = 0; i10 < (n10 = charSequence.length()); ++i10) {
            n10 = charSequence.charAt(i10);
            Character c10 = Character.valueOf((char)n10);
            l10.invoke(c10);
        }
    }

    public static final boolean L7(CharSequence charSequence, l l10) {
        int n10;
        f0.p(charSequence, "$this$none");
        f0.p(l10, "predicate");
        for (int i10 = 0; i10 < (n10 = charSequence.length()); ++i10) {
            Comparable<Character> comparable = Character.valueOf(charSequence.charAt(i10));
            n10 = (int)(((Boolean)(comparable = (Boolean)l10.invoke(comparable))).booleanValue() ? 1 : 0);
            if (n10 == 0) continue;
            return false;
        }
        return true;
    }

    public static final List L8(CharSequence object) {
        String string2 = "$this$toList";
        f0.p(object, string2);
        int n10 = object.length();
        if (n10 != 0) {
            int n11 = 1;
            if (n10 != n11) {
                object = StringsKt___StringsKt.M8((CharSequence)object);
            } else {
                n10 = 0;
                string2 = null;
                char c10 = object.charAt(0);
                object = t.k(Character.valueOf(c10));
            }
        } else {
            object = CollectionsKt__CollectionsKt.E();
        }
        return object;
    }

    public static final boolean M5(CharSequence charSequence) {
        String string2 = "$this$any";
        f0.p(charSequence, string2);
        int n10 = charSequence.length();
        int n11 = 1;
        if (n10 == 0) {
            n10 = n11;
        } else {
            n10 = 0;
            charSequence = null;
        }
        return (n10 ^ n11) != 0;
    }

    public static final void M6(CharSequence charSequence, p p10) {
        int n10;
        f0.p(charSequence, "$this$forEachIndexed");
        f0.p(p10, "action");
        int n11 = 0;
        for (int i10 = 0; i10 < (n10 = charSequence.length()); ++i10) {
            n10 = charSequence.charAt(i10);
            Integer n12 = n11;
            ++n11;
            Character c10 = Character.valueOf((char)n10);
            p10.invoke(n12, c10);
        }
    }

    public static final CharSequence M7(CharSequence charSequence, l l10) {
        int n10;
        f0.p(charSequence, "$this$onEach");
        f0.p(l10, "action");
        for (int i10 = 0; i10 < (n10 = charSequence.length()); ++i10) {
            n10 = charSequence.charAt(i10);
            Character c10 = Character.valueOf((char)n10);
            l10.invoke(c10);
        }
        return charSequence;
    }

    public static final List M8(CharSequence charSequence) {
        f0.p(charSequence, "$this$toMutableList");
        int n10 = charSequence.length();
        ArrayList arrayList = new ArrayList(n10);
        return (List)StringsKt___StringsKt.J8(charSequence, arrayList);
    }

    public static final boolean N5(CharSequence charSequence, l l10) {
        int n10;
        f0.p(charSequence, "$this$any");
        f0.p(l10, "predicate");
        for (int i10 = 0; i10 < (n10 = charSequence.length()); ++i10) {
            Comparable<Character> comparable = Character.valueOf(charSequence.charAt(i10));
            n10 = (int)(((Boolean)(comparable = (Boolean)l10.invoke(comparable))).booleanValue() ? 1 : 0);
            if (n10 == 0) continue;
            return true;
        }
        return false;
    }

    private static final char N6(CharSequence object, int n10, l l10) {
        char c10;
        int n11;
        if (n10 >= 0 && n10 <= (n11 = StringsKt__StringsKt.a3((CharSequence)object))) {
            c10 = object.charAt(n10);
        } else {
            object = n10;
            object = (Character)l10.invoke(object);
            c10 = ((Character)object).charValue();
        }
        return c10;
    }

    public static final CharSequence N7(CharSequence charSequence, p p10) {
        int n10;
        f0.p(charSequence, "$this$onEachIndexed");
        f0.p(p10, "action");
        int n11 = 0;
        for (int i10 = 0; i10 < (n10 = charSequence.length()); ++i10) {
            n10 = charSequence.charAt(i10);
            Integer n12 = n11;
            ++n11;
            Character c10 = Character.valueOf((char)n10);
            p10.invoke(n12, c10);
        }
        return charSequence;
    }

    public static final Set N8(CharSequence object) {
        LinkedHashSet linkedHashSet = "$this$toSet";
        f0.p(object, (String)((Object)linkedHashSet));
        int n10 = object.length();
        if (n10 != 0) {
            int n11 = 1;
            if (n10 != n11) {
                n11 = object.length();
                int n12 = 128;
                n11 = s0.j(q.u(n11, n12));
                linkedHashSet = new LinkedHashSet(n11);
                object = (Set)StringsKt___StringsKt.J8((CharSequence)object, linkedHashSet);
            } else {
                n10 = 0;
                linkedHashSet = null;
                char c10 = object.charAt(0);
                object = c1.f(Character.valueOf(c10));
            }
        } else {
            object = d1.k();
        }
        return object;
    }

    public static final Iterable O5(CharSequence charSequence) {
        Object object = "$this$asIterable";
        f0.p(charSequence, (String)object);
        int n10 = charSequence instanceof String;
        if (n10 != 0) {
            n10 = charSequence.length();
            if (n10 == 0) {
                n10 = 1;
            } else {
                n10 = 0;
                object = null;
            }
            if (n10 != 0) {
                return CollectionsKt__CollectionsKt.E();
            }
        }
        object = new StringsKt___StringsKt$a(charSequence);
        return object;
    }

    public static final Character O6(CharSequence object, int n10) {
        int n11;
        String string2 = "$this$getOrNull";
        f0.p(object, string2);
        if (n10 >= 0 && n10 <= (n11 = StringsKt__StringsKt.a3((CharSequence)object))) {
            char c10 = object.charAt(n10);
            object = Character.valueOf(c10);
        } else {
            boolean bl2 = false;
            object = null;
        }
        return object;
    }

    public static final Pair O7(CharSequence object, l l10) {
        int n10;
        f0.p(object, "$this$partition");
        f0.p(l10, "predicate");
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder stringBuilder2 = new StringBuilder();
        for (int i10 = 0; i10 < (n10 = object.length()); ++i10) {
            n10 = object.charAt(i10);
            Comparable<Character> comparable = Character.valueOf((char)n10);
            boolean bl2 = (Boolean)(comparable = (Boolean)l10.invoke(comparable));
            if (bl2) {
                stringBuilder.append((char)n10);
                continue;
            }
            stringBuilder2.append((char)n10);
        }
        object = new Pair(stringBuilder, stringBuilder2);
        return object;
    }

    public static final List O8(CharSequence charSequence, int n10, int n11, boolean bl2) {
        f0.p(charSequence, "$this$windowed");
        StringsKt___StringsKt$windowed$1 stringsKt___StringsKt$windowed$1 = StringsKt___StringsKt$windowed$1.INSTANCE;
        return StringsKt___StringsKt.P8(charSequence, n10, n11, bl2, stringsKt___StringsKt$windowed$1);
    }

    public static final m P5(CharSequence charSequence) {
        Object object = "$this$asSequence";
        f0.p(charSequence, (String)object);
        int n10 = charSequence instanceof String;
        if (n10 != 0) {
            n10 = charSequence.length();
            if (n10 == 0) {
                n10 = 1;
            } else {
                n10 = 0;
                object = null;
            }
            if (n10 != 0) {
                return SequencesKt__SequencesKt.j();
            }
        }
        object = new StringsKt___StringsKt$b(charSequence);
        return object;
    }

    public static final Map P6(CharSequence charSequence, l l10) {
        int n10;
        f0.p(charSequence, "$this$groupBy");
        f0.p(l10, "keySelector");
        LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<Object, Object>();
        for (int i10 = 0; i10 < (n10 = charSequence.length()); ++i10) {
            n10 = charSequence.charAt(i10);
            Object object = Character.valueOf((char)n10);
            Object object2 = linkedHashMap.get(object = l10.invoke(object));
            if (object2 == null) {
                object2 = new ArrayList();
                linkedHashMap.put(object, object2);
            }
            object2 = (List)object2;
            Character c10 = Character.valueOf((char)n10);
            object2.add((Character)c10);
        }
        return linkedHashMap;
    }

    public static final Pair P7(String object, l object2) {
        f0.p(object, "$this$partition");
        f0.p(object2, "predicate");
        CharSequence charSequence = new StringBuilder();
        StringBuilder stringBuilder = new StringBuilder();
        int n10 = ((String)object).length();
        for (int i10 = 0; i10 < n10; ++i10) {
            char c10 = ((String)object).charAt(i10);
            Comparable<Character> comparable = Character.valueOf(c10);
            boolean bl2 = (Boolean)(comparable = (Boolean)object2.invoke(comparable));
            if (bl2) {
                ((StringBuilder)charSequence).append(c10);
                continue;
            }
            stringBuilder.append(c10);
        }
        object2 = ((StringBuilder)charSequence).toString();
        f0.o(object2, "first.toString()");
        charSequence = stringBuilder.toString();
        f0.o(charSequence, "second.toString()");
        object = new Pair(object2, charSequence);
        return object;
    }

    public static final List P8(CharSequence charSequence, int n10, int n11, boolean bl2, l l10) {
        ArrayList<Object> arrayList;
        f0.p(charSequence, "$this$windowed");
        String string2 = "transform";
        f0.p(l10, string2);
        SlidingWindowKt.a(n10, n11);
        int n12 = charSequence.length();
        int n13 = n12 / n11;
        int n14 = n12 % n11;
        int n15 = 0;
        if (n14 == 0) {
            n14 = 0;
            arrayList = null;
        } else {
            n14 = 1;
        }
        arrayList = new ArrayList<Object>(n13 += n14);
        while (n15 >= 0 && n12 > n15) {
            n13 = n15 + n10;
            if (n13 < 0 || n13 > n12) {
                if (!bl2) break;
                n13 = n12;
            }
            Object object = charSequence.subSequence(n15, n13);
            object = l10.invoke(object);
            arrayList.add(object);
            n15 += n11;
        }
        return arrayList;
    }

    public static final Map Q5(CharSequence charSequence, l l10) {
        char c10;
        f0.p(charSequence, "$this$associate");
        f0.p(l10, "transform");
        int n10 = s0.j(charSequence.length());
        int n11 = 16;
        n10 = q.n(n10, n11);
        LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<Object, Object>(n10);
        for (n10 = 0; n10 < (c10 = charSequence.length()); ++n10) {
            c10 = charSequence.charAt(n10);
            Object object = Character.valueOf(c10);
            object = (Pair)l10.invoke(object);
            Object object2 = ((Pair)object).getFirst();
            object = ((Pair)object).getSecond();
            linkedHashMap.put(object2, object);
        }
        return linkedHashMap;
    }

    public static final Map Q6(CharSequence charSequence, l l10, l l11) {
        int n10;
        f0.p(charSequence, "$this$groupBy");
        f0.p(l10, "keySelector");
        f0.p(l11, "valueTransform");
        LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<Object, Object>();
        for (int i10 = 0; i10 < (n10 = charSequence.length()); ++i10) {
            n10 = charSequence.charAt(i10);
            Object object = Character.valueOf((char)n10);
            Object object2 = linkedHashMap.get(object = l10.invoke(object));
            if (object2 == null) {
                object2 = new ArrayList();
                linkedHashMap.put(object, object2);
            }
            object2 = (List)object2;
            Object object3 = Character.valueOf((char)n10);
            object3 = l11.invoke(object3);
            object2.add((Object)object3);
        }
        return linkedHashMap;
    }

    private static final char Q7(CharSequence charSequence) {
        e$a e$a = e.b;
        return StringsKt___StringsKt.R7(charSequence, e$a);
    }

    public static /* synthetic */ List Q8(CharSequence charSequence, int n10, int n11, boolean bl2, int n12, Object object) {
        int n13 = n12 & 2;
        if (n13 != 0) {
            n11 = 1;
        }
        if ((n12 &= 4) != 0) {
            bl2 = false;
        }
        return StringsKt___StringsKt.O8(charSequence, n10, n11, bl2);
    }

    public static final Map R5(CharSequence charSequence, l l10) {
        char c10;
        f0.p(charSequence, "$this$associateBy");
        f0.p(l10, "keySelector");
        int n10 = s0.j(charSequence.length());
        int n11 = 16;
        n10 = q.n(n10, n11);
        LinkedHashMap<Object, Character> linkedHashMap = new LinkedHashMap<Object, Character>(n10);
        for (n10 = 0; n10 < (c10 = charSequence.length()); ++n10) {
            c10 = charSequence.charAt(n10);
            Object object = Character.valueOf(c10);
            object = l10.invoke(object);
            Character c11 = Character.valueOf(c10);
            linkedHashMap.put(object, c11);
        }
        return linkedHashMap;
    }

    public static final Map R6(CharSequence charSequence, Map map, l l10) {
        int n10;
        f0.p(charSequence, "$this$groupByTo");
        f0.p(map, "destination");
        f0.p(l10, "keySelector");
        for (int i10 = 0; i10 < (n10 = charSequence.length()); ++i10) {
            n10 = charSequence.charAt(i10);
            Object object = Character.valueOf((char)n10);
            Object object2 = map.get(object = l10.invoke(object));
            if (object2 == null) {
                object2 = new ArrayList();
                map.put(object, object2);
            }
            object2 = (List)object2;
            Character c10 = Character.valueOf((char)n10);
            object2.add((Character)c10);
        }
        return map;
    }

    public static final char R7(CharSequence object, e e10) {
        f0.p(object, "$this$random");
        String string2 = "random";
        f0.p(e10, string2);
        int n10 = object.length();
        if (n10 == 0) {
            n10 = 1;
        } else {
            n10 = 0;
            string2 = null;
        }
        if (n10 == 0) {
            n10 = object.length();
            int n11 = e10.m(n10);
            return object.charAt(n11);
        }
        object = new NoSuchElementException("Char sequence is empty.");
        throw object;
    }

    public static /* synthetic */ List R8(CharSequence charSequence, int n10, int n11, boolean bl2, l l10, int n12, Object object) {
        int n13 = n12 & 2;
        if (n13 != 0) {
            n11 = 1;
        }
        if ((n12 &= 4) != 0) {
            bl2 = false;
        }
        return StringsKt___StringsKt.P8(charSequence, n10, n11, bl2, l10);
    }

    public static final Map S5(CharSequence charSequence, l l10, l l11) {
        char c10;
        f0.p(charSequence, "$this$associateBy");
        f0.p(l10, "keySelector");
        f0.p(l11, "valueTransform");
        int n10 = s0.j(charSequence.length());
        int n11 = 16;
        n10 = q.n(n10, n11);
        LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<Object, Object>(n10);
        for (n10 = 0; n10 < (c10 = charSequence.length()); ++n10) {
            c10 = charSequence.charAt(n10);
            Object object = Character.valueOf(c10);
            object = l10.invoke(object);
            Object object2 = Character.valueOf(c10);
            object2 = l11.invoke(object2);
            linkedHashMap.put(object, object2);
        }
        return linkedHashMap;
    }

    public static final Map S6(CharSequence charSequence, Map map, l l10, l l11) {
        int n10;
        f0.p(charSequence, "$this$groupByTo");
        f0.p(map, "destination");
        f0.p(l10, "keySelector");
        f0.p(l11, "valueTransform");
        for (int i10 = 0; i10 < (n10 = charSequence.length()); ++i10) {
            n10 = charSequence.charAt(i10);
            Object object = Character.valueOf((char)n10);
            Object object2 = map.get(object = l10.invoke(object));
            if (object2 == null) {
                object2 = new ArrayList();
                map.put(object, object2);
            }
            object2 = (List)object2;
            Object object3 = Character.valueOf((char)n10);
            object3 = l11.invoke(object3);
            object2.add((Object)object3);
        }
        return map;
    }

    private static final Character S7(CharSequence charSequence) {
        e$a e$a = e.b;
        return StringsKt___StringsKt.T7(charSequence, e$a);
    }

    public static final m S8(CharSequence charSequence, int n10, int n11, boolean bl2) {
        f0.p(charSequence, "$this$windowedSequence");
        StringsKt___StringsKt$windowedSequence$1 stringsKt___StringsKt$windowedSequence$1 = StringsKt___StringsKt$windowedSequence$1.INSTANCE;
        return StringsKt___StringsKt.T8(charSequence, n10, n11, bl2, stringsKt___StringsKt$windowedSequence$1);
    }

    public static final Map T5(CharSequence charSequence, Map map, l l10) {
        int n10;
        f0.p(charSequence, "$this$associateByTo");
        f0.p(map, "destination");
        f0.p(l10, "keySelector");
        for (int i10 = 0; i10 < (n10 = charSequence.length()); ++i10) {
            n10 = charSequence.charAt(i10);
            Object object = Character.valueOf((char)n10);
            object = l10.invoke(object);
            Character c10 = Character.valueOf((char)n10);
            map.put(object, c10);
        }
        return map;
    }

    public static final e0 T6(CharSequence charSequence, l l10) {
        f0.p(charSequence, "$this$groupingBy");
        f0.p(l10, "keySelector");
        StringsKt___StringsKt$c stringsKt___StringsKt$c = new StringsKt___StringsKt$c(charSequence, l10);
        return stringsKt___StringsKt$c;
    }

    public static final Character T7(CharSequence charSequence, e e10) {
        f0.p(charSequence, "$this$randomOrNull");
        String string2 = "random";
        f0.p(e10, string2);
        int n10 = charSequence.length();
        if (n10 == 0) {
            n10 = 1;
        } else {
            n10 = 0;
            string2 = null;
        }
        if (n10 != 0) {
            return null;
        }
        n10 = charSequence.length();
        int n11 = e10.m(n10);
        return Character.valueOf(charSequence.charAt(n11));
    }

    public static final m T8(CharSequence charSequence, int n10, int n11, boolean bl2, l l10) {
        Object object;
        f0.p(charSequence, "$this$windowedSequence");
        String string2 = "transform";
        f0.p(l10, string2);
        SlidingWindowKt.a(n10, n11);
        if (bl2) {
            object = StringsKt__StringsKt.Z2(charSequence);
        } else {
            bl2 = false;
            int n12 = charSequence.length() - n10 + 1;
            object = q.n1(0, n12);
        }
        m m10 = CollectionsKt___CollectionsKt.n1(q.S0((i)object, n11));
        object = new StringsKt___StringsKt$windowedSequence$2(charSequence, n10, l10);
        return SequencesKt___SequencesKt.b1(m10, (l)object);
    }

    public static final Map U5(CharSequence charSequence, Map map, l l10, l l11) {
        int n10;
        f0.p(charSequence, "$this$associateByTo");
        f0.p(map, "destination");
        f0.p(l10, "keySelector");
        f0.p(l11, "valueTransform");
        for (int i10 = 0; i10 < (n10 = charSequence.length()); ++i10) {
            n10 = charSequence.charAt(i10);
            Object object = Character.valueOf((char)n10);
            object = l10.invoke(object);
            Object object2 = Character.valueOf((char)n10);
            object2 = l11.invoke(object2);
            map.put(object, object2);
        }
        return map;
    }

    public static final int U6(CharSequence charSequence, l l10) {
        f0.p(charSequence, "$this$indexOfFirst");
        String string2 = "predicate";
        f0.p(l10, string2);
        int n10 = charSequence.length();
        for (int i10 = 0; i10 < n10; ++i10) {
            Comparable<Character> comparable = Character.valueOf(charSequence.charAt(i10));
            boolean bl2 = (Boolean)(comparable = (Boolean)l10.invoke(comparable));
            if (!bl2) continue;
            return i10;
        }
        return -1;
    }

    public static final char U7(CharSequence object, p p10) {
        f0.p(object, "$this$reduce");
        Object object2 = "operation";
        f0.p(p10, (String)object2);
        int n10 = object.length();
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            object2 = null;
        }
        if (n10 == 0) {
            n10 = object.charAt(0);
            n11 = StringsKt__StringsKt.a3((CharSequence)object);
            if (n12 <= n11) {
                while (true) {
                    object2 = Character.valueOf((char)n10);
                    char c10 = object.charAt(n12);
                    Character c11 = Character.valueOf(c10);
                    object2 = (Character)p10.invoke(object2, c11);
                    n10 = ((Character)object2).charValue();
                    if (n12 == n11) break;
                    ++n12;
                }
            }
            return (char)n10;
        }
        object = new UnsupportedOperationException("Empty char sequence can't be reduced.");
        throw object;
    }

    public static /* synthetic */ m U8(CharSequence charSequence, int n10, int n11, boolean bl2, int n12, Object object) {
        int n13 = n12 & 2;
        if (n13 != 0) {
            n11 = 1;
        }
        if ((n12 &= 4) != 0) {
            bl2 = false;
        }
        return StringsKt___StringsKt.S8(charSequence, n10, n11, bl2);
    }

    public static final Map V5(CharSequence charSequence, Map map, l l10) {
        int n10;
        f0.p(charSequence, "$this$associateTo");
        f0.p(map, "destination");
        f0.p(l10, "transform");
        for (int i10 = 0; i10 < (n10 = charSequence.length()); ++i10) {
            n10 = charSequence.charAt(i10);
            Object object = Character.valueOf((char)n10);
            object = (Pair)l10.invoke(object);
            Object object2 = ((Pair)object).getFirst();
            object = ((Pair)object).getSecond();
            map.put(object2, object);
        }
        return map;
    }

    public static final int V6(CharSequence charSequence, l l10) {
        f0.p(charSequence, "$this$indexOfLast");
        String string2 = "predicate";
        f0.p(l10, string2);
        int n10 = charSequence.length();
        int n11 = -1;
        n10 += n11;
        while (n10 >= 0) {
            Comparable<Character> comparable = Character.valueOf(charSequence.charAt(n10));
            boolean bl2 = (Boolean)(comparable = (Boolean)l10.invoke(comparable));
            if (bl2) {
                return n10;
            }
            n10 += -1;
        }
        return n11;
    }

    public static final char V7(CharSequence object, f.h2.s.q q10) {
        f0.p(object, "$this$reduceIndexed");
        Object object2 = "operation";
        f0.p(q10, (String)object2);
        int n10 = object.length();
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            object2 = null;
        }
        if (n10 == 0) {
            n10 = object.charAt(0);
            n11 = StringsKt__StringsKt.a3((CharSequence)object);
            if (n12 <= n11) {
                while (true) {
                    Integer n13 = n12;
                    object2 = Character.valueOf((char)n10);
                    char c10 = object.charAt(n12);
                    Character c11 = Character.valueOf(c10);
                    object2 = (Character)q10.invoke(n13, object2, c11);
                    n10 = ((Character)object2).charValue();
                    if (n12 == n11) break;
                    ++n12;
                }
            }
            return (char)n10;
        }
        object = new UnsupportedOperationException("Empty char sequence can't be reduced.");
        throw object;
    }

    public static /* synthetic */ m V8(CharSequence charSequence, int n10, int n11, boolean bl2, l l10, int n12, Object object) {
        int n13 = n12 & 2;
        if (n13 != 0) {
            n11 = 1;
        }
        if ((n12 &= 4) != 0) {
            bl2 = false;
        }
        return StringsKt___StringsKt.T8(charSequence, n10, n11, bl2, l10);
    }

    public static final Map W5(CharSequence charSequence, l l10) {
        f0.p(charSequence, "$this$associateWith");
        f0.p(l10, "valueSelector");
        int n10 = s0.j(q.u(charSequence.length(), 128));
        int n11 = 16;
        n10 = q.n(n10, n11);
        LinkedHashMap<Character, Object> linkedHashMap = new LinkedHashMap<Character, Object>(n10);
        for (n10 = 0; n10 < (n11 = charSequence.length()); ++n10) {
            n11 = charSequence.charAt(n10);
            Character c10 = Character.valueOf((char)n11);
            Object object = Character.valueOf((char)n11);
            object = l10.invoke(object);
            linkedHashMap.put(c10, object);
        }
        return linkedHashMap;
    }

    public static final char W6(CharSequence object) {
        String string2 = "$this$last";
        f0.p(object, string2);
        int n10 = object.length();
        if (n10 == 0) {
            n10 = 1;
        } else {
            n10 = 0;
            string2 = null;
        }
        if (n10 == 0) {
            n10 = StringsKt__StringsKt.a3((CharSequence)object);
            return object.charAt(n10);
        }
        object = new NoSuchElementException("Char sequence is empty.");
        throw object;
    }

    public static final Character W7(CharSequence charSequence, f.h2.s.q q10) {
        f0.p(charSequence, "$this$reduceIndexedOrNull");
        Object object = "operation";
        f0.p(q10, (String)object);
        int n10 = charSequence.length();
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            object = null;
        }
        if (n10 != 0) {
            return null;
        }
        n10 = charSequence.charAt(0);
        n11 = StringsKt__StringsKt.a3(charSequence);
        if (n12 <= n11) {
            while (true) {
                Integer n13 = n12;
                object = Character.valueOf((char)n10);
                char c10 = charSequence.charAt(n12);
                Character c11 = Character.valueOf(c10);
                object = (Character)q10.invoke(n13, object, c11);
                n10 = ((Character)object).charValue();
                if (n12 == n11) break;
                ++n12;
            }
        }
        return Character.valueOf((char)n10);
    }

    public static final Iterable W8(CharSequence charSequence) {
        f0.p(charSequence, "$this$withIndex");
        StringsKt___StringsKt$withIndex$1 stringsKt___StringsKt$withIndex$1 = new StringsKt___StringsKt$withIndex$1(charSequence);
        j0 j02 = new j0(stringsKt___StringsKt$withIndex$1);
        return j02;
    }

    public static final Map X5(CharSequence charSequence, Map map, l l10) {
        int n10;
        f0.p(charSequence, "$this$associateWithTo");
        f0.p(map, "destination");
        f0.p(l10, "valueSelector");
        for (int i10 = 0; i10 < (n10 = charSequence.length()); ++i10) {
            n10 = charSequence.charAt(i10);
            Character c10 = Character.valueOf((char)n10);
            Object object = Character.valueOf((char)n10);
            object = l10.invoke(object);
            map.put(c10, object);
        }
        return map;
    }

    public static final char X6(CharSequence object, l l10) {
        f0.p(object, "$this$last");
        String string2 = "predicate";
        f0.p(l10, string2);
        int n10 = object.length();
        while ((n10 += -1) >= 0) {
            char c10 = object.charAt(n10);
            Comparable<Character> comparable = Character.valueOf(c10);
            boolean bl2 = (Boolean)(comparable = (Boolean)l10.invoke(comparable));
            if (!bl2) continue;
            return c10;
        }
        object = new NoSuchElementException("Char sequence contains no character matching the predicate.");
        throw object;
    }

    public static final Character X7(CharSequence charSequence, p p10) {
        f0.p(charSequence, "$this$reduceOrNull");
        Object object = "operation";
        f0.p(p10, (String)object);
        int n10 = charSequence.length();
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            object = null;
        }
        if (n10 != 0) {
            return null;
        }
        n10 = charSequence.charAt(0);
        n11 = StringsKt__StringsKt.a3(charSequence);
        if (n12 <= n11) {
            while (true) {
                object = Character.valueOf((char)n10);
                char c10 = charSequence.charAt(n12);
                Character c11 = Character.valueOf(c10);
                object = (Character)p10.invoke(object, c11);
                n10 = ((Character)object).charValue();
                if (n12 == n11) break;
                ++n12;
            }
        }
        return Character.valueOf((char)n10);
    }

    public static final List X8(CharSequence charSequence, CharSequence charSequence2) {
        f0.p(charSequence, "$this$zip");
        String string2 = "other";
        f0.p(charSequence2, string2);
        int n10 = charSequence.length();
        int n11 = charSequence2.length();
        n10 = Math.min(n10, n11);
        ArrayList<Character> arrayList = new ArrayList<Character>(n10);
        for (int i10 = 0; i10 < n10; ++i10) {
            char c10 = charSequence.charAt(i10);
            char c11 = charSequence2.charAt(i10);
            Serializable serializable = Character.valueOf(c10);
            Character c12 = Character.valueOf(c11);
            serializable = w0.a(serializable, c12);
            arrayList.add((Character)serializable);
        }
        return arrayList;
    }

    public static final List Y5(CharSequence charSequence, int n10) {
        f0.p(charSequence, "$this$chunked");
        return StringsKt___StringsKt.O8(charSequence, n10, n10, true);
    }

    public static final Character Y6(CharSequence object) {
        String string2 = "$this$lastOrNull";
        f0.p(object, string2);
        int n10 = object.length();
        int n11 = 1;
        if (n10 == 0) {
            n10 = n11;
        } else {
            n10 = 0;
            string2 = null;
        }
        if (n10 != 0) {
            boolean bl2 = false;
            object = null;
        } else {
            n10 = object.length() - n11;
            char c10 = object.charAt(n10);
            object = Character.valueOf(c10);
        }
        return object;
    }

    public static final char Y7(CharSequence object, p p10) {
        f0.p(object, "$this$reduceRight");
        Object object2 = "operation";
        f0.p(p10, (String)object2);
        int c10 = StringsKt__StringsKt.a3((CharSequence)object);
        if (c10 >= 0) {
            char c11;
            int n10 = c10 + -1;
            char c12 = object.charAt(c10);
            while (n10 >= 0) {
                int n11 = n10 + -1;
                Character c13 = Character.valueOf(object.charAt(n10));
                object2 = Character.valueOf(c11);
                object2 = (Character)p10.invoke(c13, object2);
                c11 = ((Character)object2).charValue();
                n10 = n11;
            }
            return c11;
        }
        object = new UnsupportedOperationException("Empty char sequence can't be reduced.");
        throw object;
    }

    public static final List Y8(CharSequence charSequence, CharSequence charSequence2, p p10) {
        f0.p(charSequence, "$this$zip");
        f0.p(charSequence2, "other");
        String string2 = "transform";
        f0.p(p10, string2);
        int n10 = charSequence.length();
        int n11 = charSequence2.length();
        n10 = Math.min(n10, n11);
        ArrayList<Object> arrayList = new ArrayList<Object>(n10);
        for (int i10 = 0; i10 < n10; ++i10) {
            char c10 = charSequence.charAt(i10);
            Object object = Character.valueOf(c10);
            char c11 = charSequence2.charAt(i10);
            Character c12 = Character.valueOf(c11);
            object = p10.invoke(object, c12);
            arrayList.add(object);
        }
        return arrayList;
    }

    public static final List Z5(CharSequence charSequence, int n10, l l10) {
        f0.p(charSequence, "$this$chunked");
        f0.p(l10, "transform");
        return StringsKt___StringsKt.P8(charSequence, n10, n10, true, l10);
    }

    public static final Character Z6(CharSequence charSequence, l l10) {
        f0.p(charSequence, "$this$lastOrNull");
        String string2 = "predicate";
        f0.p(l10, string2);
        int n10 = charSequence.length();
        while ((n10 += -1) >= 0) {
            char c10 = charSequence.charAt(n10);
            Comparable<Character> comparable = Character.valueOf(c10);
            boolean bl2 = (Boolean)(comparable = (Boolean)l10.invoke(comparable));
            if (!bl2) continue;
            return Character.valueOf(c10);
        }
        return null;
    }

    public static final char Z7(CharSequence object, f.h2.s.q q10) {
        f0.p(object, "$this$reduceRightIndexed");
        Object object2 = "operation";
        f0.p(q10, (String)object2);
        int c10 = StringsKt__StringsKt.a3((CharSequence)object);
        if (c10 >= 0) {
            char c11;
            char c12 = object.charAt(c10);
            for (int i10 = c10 + -1; i10 >= 0; i10 += -1) {
                Integer n10 = i10;
                char c13 = object.charAt(i10);
                Character c14 = Character.valueOf(c13);
                object2 = Character.valueOf(c11);
                object2 = (Character)q10.invoke(n10, c14, object2);
                c11 = ((Character)object2).charValue();
            }
            return c11;
        }
        object = new UnsupportedOperationException("Empty char sequence can't be reduced.");
        throw object;
    }

    public static final List Z8(CharSequence arrayList) {
        String string2 = "$this$zipWithNext";
        f0.p(arrayList, string2);
        int n10 = arrayList.length();
        int n11 = 1;
        if ((n10 -= n11) < n11) {
            arrayList = CollectionsKt__CollectionsKt.E();
        } else {
            ArrayList<Character> arrayList2 = new ArrayList<Character>(n10);
            int n12 = 0;
            while (n12 < n10) {
                char c10 = arrayList.charAt(n12);
                char c11 = arrayList.charAt(++n12);
                Serializable serializable = Character.valueOf(c10);
                Character c12 = Character.valueOf(c11);
                serializable = w0.a(serializable, c12);
                arrayList2.add((Character)serializable);
            }
            arrayList = arrayList2;
        }
        return arrayList;
    }

    public static final m a6(CharSequence charSequence, int n10) {
        f0.p(charSequence, "$this$chunkedSequence");
        StringsKt___StringsKt$chunkedSequence$1 stringsKt___StringsKt$chunkedSequence$1 = StringsKt___StringsKt$chunkedSequence$1.INSTANCE;
        return StringsKt___StringsKt.b6(charSequence, n10, stringsKt___StringsKt$chunkedSequence$1);
    }

    public static final List a7(CharSequence charSequence, l l10) {
        char c10;
        f0.p(charSequence, "$this$map");
        f0.p(l10, "transform");
        int n10 = charSequence.length();
        ArrayList<Object> arrayList = new ArrayList<Object>(n10);
        for (n10 = 0; n10 < (c10 = charSequence.length()); ++n10) {
            c10 = charSequence.charAt(n10);
            Object object = Character.valueOf(c10);
            object = l10.invoke(object);
            arrayList.add(object);
        }
        return arrayList;
    }

    public static final Character a8(CharSequence charSequence, f.h2.s.q q10) {
        char c10;
        f0.p(charSequence, "$this$reduceRightIndexedOrNull");
        Object object = "operation";
        f0.p(q10, (String)object);
        int c102 = StringsKt__StringsKt.a3(charSequence);
        if (c102 < 0) {
            return null;
        }
        char c11 = charSequence.charAt(c102);
        for (int i10 = c102 + -1; i10 >= 0; i10 += -1) {
            Integer n10 = i10;
            char c12 = charSequence.charAt(i10);
            Character c13 = Character.valueOf(c12);
            object = Character.valueOf(c10);
            object = (Character)q10.invoke(n10, c13, object);
            c10 = ((Character)object).charValue();
        }
        return Character.valueOf(c10);
    }

    public static final List a9(CharSequence charSequence, p p10) {
        f0.p(charSequence, "$this$zipWithNext");
        String string2 = "transform";
        f0.p(p10, string2);
        int n10 = charSequence.length();
        int n11 = 1;
        if ((n10 -= n11) < n11) {
            return CollectionsKt__CollectionsKt.E();
        }
        ArrayList<Object> arrayList = new ArrayList<Object>(n10);
        int n12 = 0;
        while (n12 < n10) {
            char c10 = charSequence.charAt(n12);
            Object object = Character.valueOf(c10);
            char c11 = charSequence.charAt(++n12);
            Character c12 = Character.valueOf(c11);
            object = p10.invoke(object, c12);
            arrayList.add(object);
        }
        return arrayList;
    }

    public static final m b6(CharSequence charSequence, int n10, l l10) {
        f0.p(charSequence, "$this$chunkedSequence");
        f0.p(l10, "transform");
        return StringsKt___StringsKt.T8(charSequence, n10, n10, true, l10);
    }

    public static final List b7(CharSequence charSequence, p p10) {
        char c10;
        f0.p(charSequence, "$this$mapIndexed");
        f0.p(p10, "transform");
        int n10 = charSequence.length();
        ArrayList<Object> arrayList = new ArrayList<Object>(n10);
        int n11 = 0;
        for (n10 = 0; n10 < (c10 = charSequence.length()); ++n10) {
            c10 = charSequence.charAt(n10);
            Integer n12 = n11;
            ++n11;
            Object object = Character.valueOf(c10);
            object = p10.invoke(n12, object);
            arrayList.add(object);
        }
        return arrayList;
    }

    public static final Character b8(CharSequence charSequence, p p10) {
        char c10;
        f0.p(charSequence, "$this$reduceRightOrNull");
        Object object = "operation";
        f0.p(p10, (String)object);
        int c102 = StringsKt__StringsKt.a3(charSequence);
        if (c102 < 0) {
            return null;
        }
        int n10 = c102 + -1;
        char c11 = charSequence.charAt(c102);
        while (n10 >= 0) {
            int n11 = n10 + -1;
            Character c12 = Character.valueOf(charSequence.charAt(n10));
            object = Character.valueOf(c10);
            object = (Character)p10.invoke(c12, object);
            c10 = ((Character)object).charValue();
            n10 = n11;
        }
        return Character.valueOf(c10);
    }

    private static final int c6(CharSequence charSequence) {
        return charSequence.length();
    }

    public static final List c7(CharSequence charSequence, p p10) {
        int n10;
        f0.p(charSequence, "$this$mapIndexedNotNull");
        f0.p(p10, "transform");
        ArrayList<Object> arrayList = new ArrayList<Object>();
        int n11 = 0;
        Object object = null;
        for (int i10 = 0; i10 < (n10 = charSequence.length()); ++i10) {
            n10 = charSequence.charAt(i10);
            int n12 = n11 + 1;
            object = n11;
            Character c10 = Character.valueOf((char)n10);
            if ((object = p10.invoke(object, c10)) != null) {
                arrayList.add(object);
            }
            n11 = n12;
        }
        return arrayList;
    }

    public static final CharSequence c8(CharSequence charSequence) {
        f0.p(charSequence, "$this$reversed");
        StringBuilder stringBuilder = new StringBuilder(charSequence);
        charSequence = stringBuilder.reverse();
        f0.o(charSequence, "StringBuilder(this).reverse()");
        return charSequence;
    }

    public static final int d6(CharSequence charSequence, l l10) {
        int n10;
        f0.p(charSequence, "$this$count");
        f0.p(l10, "predicate");
        int n11 = 0;
        for (int i10 = 0; i10 < (n10 = charSequence.length()); ++i10) {
            Comparable<Character> comparable = Character.valueOf(charSequence.charAt(i10));
            n10 = (int)(((Boolean)(comparable = (Boolean)l10.invoke(comparable))).booleanValue() ? 1 : 0);
            if (n10 == 0) continue;
            ++n11;
        }
        return n11;
    }

    public static final Collection d7(CharSequence charSequence, Collection collection, p p10) {
        int n10;
        f0.p(charSequence, "$this$mapIndexedNotNullTo");
        f0.p(collection, "destination");
        f0.p(p10, "transform");
        int n11 = 0;
        Object object = null;
        for (int i10 = 0; i10 < (n10 = charSequence.length()); ++i10) {
            n10 = charSequence.charAt(i10);
            int n12 = n11 + 1;
            object = n11;
            Character c10 = Character.valueOf((char)n10);
            if ((object = p10.invoke(object, c10)) != null) {
                collection.add(object);
            }
            n11 = n12;
        }
        return collection;
    }

    private static final String d8(String string2) {
        Objects.requireNonNull(string2, "null cannot be cast to non-null type kotlin.CharSequence");
        return ((Object)StringsKt___StringsKt.c8(string2)).toString();
    }

    public static final CharSequence e6(CharSequence charSequence, int n10) {
        int n11;
        String string2 = "$this$drop";
        f0.p(charSequence, string2);
        if (n10 >= 0) {
            n11 = 1;
        } else {
            n11 = 0;
            string2 = null;
        }
        if (n11 != 0) {
            n11 = charSequence.length();
            n10 = q.u(n10, n11);
            n11 = charSequence.length();
            return charSequence.subSequence(n10, n11);
        }
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("Requested character count ");
        ((StringBuilder)charSequence).append(n10);
        ((StringBuilder)charSequence).append(" is less than zero.");
        charSequence = ((StringBuilder)charSequence).toString();
        charSequence = ((Object)charSequence).toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)charSequence);
        throw illegalArgumentException;
    }

    public static final Collection e7(CharSequence charSequence, Collection collection, p p10) {
        int n10;
        f0.p(charSequence, "$this$mapIndexedTo");
        f0.p(collection, "destination");
        f0.p(p10, "transform");
        int n11 = 0;
        for (int i10 = 0; i10 < (n10 = charSequence.length()); ++i10) {
            n10 = charSequence.charAt(i10);
            Integer n12 = n11;
            ++n11;
            Object object = Character.valueOf((char)n10);
            object = p10.invoke(n12, object);
            collection.add(object);
        }
        return collection;
    }

    public static final List e8(CharSequence charSequence, Object object, p p10) {
        f0.p(charSequence, "$this$runningFold");
        ArrayList<Object> arrayList = "operation";
        f0.p(p10, (String)((Object)arrayList));
        int n10 = charSequence.length();
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            arrayList = null;
        }
        if (n10 != 0) {
            return t.k(object);
        }
        int n13 = charSequence.length() + n12;
        arrayList = new ArrayList<Object>(n13);
        arrayList.add(object);
        while (n11 < (n12 = charSequence.length())) {
            n12 = charSequence.charAt(n11);
            Character c10 = Character.valueOf((char)n12);
            object = p10.invoke(object, c10);
            arrayList.add(object);
            ++n11;
        }
        return arrayList;
    }

    public static final String f6(String charSequence, int n10) {
        int n11;
        String string2 = "$this$drop";
        f0.p(charSequence, string2);
        if (n10 >= 0) {
            n11 = 1;
        } else {
            n11 = 0;
            string2 = null;
        }
        if (n11 != 0) {
            n11 = ((String)charSequence).length();
            n10 = q.u(n10, n11);
            charSequence = ((String)charSequence).substring(n10);
            f0.o(charSequence, "(this as java.lang.String).substring(startIndex)");
            return charSequence;
        }
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("Requested character count ");
        ((StringBuilder)charSequence).append(n10);
        ((StringBuilder)charSequence).append(" is less than zero.");
        charSequence = ((StringBuilder)charSequence).toString();
        charSequence = charSequence.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)charSequence);
        throw illegalArgumentException;
    }

    public static final List f7(CharSequence charSequence, l l10) {
        int n10;
        f0.p(charSequence, "$this$mapNotNull");
        f0.p(l10, "transform");
        ArrayList<Object> arrayList = new ArrayList<Object>();
        for (int i10 = 0; i10 < (n10 = charSequence.length()); ++i10) {
            n10 = charSequence.charAt(i10);
            Object object = Character.valueOf((char)n10);
            if ((object = l10.invoke(object)) == null) continue;
            arrayList.add(object);
        }
        return arrayList;
    }

    public static final List f8(CharSequence charSequence, Object object, f.h2.s.q q10) {
        f0.p(charSequence, "$this$runningFoldIndexed");
        ArrayList<Object> arrayList = "operation";
        f0.p(q10, (String)((Object)arrayList));
        int n10 = charSequence.length();
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            arrayList = null;
        }
        if (n10 != 0) {
            return t.k(object);
        }
        int n13 = charSequence.length() + n12;
        arrayList = new ArrayList<Object>(n13);
        arrayList.add(object);
        n12 = charSequence.length();
        while (n11 < n12) {
            Integer n14 = n11;
            char c10 = charSequence.charAt(n11);
            Character c11 = Character.valueOf(c10);
            object = q10.invoke(n14, object, c11);
            arrayList.add(object);
            ++n11;
        }
        return arrayList;
    }

    public static final CharSequence g6(CharSequence charSequence, int n10) {
        f0.p(charSequence, "$this$dropLast");
        boolean bl2 = n10 >= 0;
        if (bl2) {
            n10 = q.n(charSequence.length() - n10, 0);
            return StringsKt___StringsKt.B8(charSequence, n10);
        }
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("Requested character count ");
        ((StringBuilder)charSequence).append(n10);
        ((StringBuilder)charSequence).append(" is less than zero.");
        charSequence = ((StringBuilder)charSequence).toString();
        charSequence = ((Object)charSequence).toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)charSequence);
        throw illegalArgumentException;
    }

    public static final Collection g7(CharSequence charSequence, Collection collection, l l10) {
        int n10;
        f0.p(charSequence, "$this$mapNotNullTo");
        f0.p(collection, "destination");
        f0.p(l10, "transform");
        for (int i10 = 0; i10 < (n10 = charSequence.length()); ++i10) {
            n10 = charSequence.charAt(i10);
            Object object = Character.valueOf((char)n10);
            if ((object = l10.invoke(object)) == null) continue;
            collection.add(object);
        }
        return collection;
    }

    public static final List g8(CharSequence charSequence, p p10) {
        f0.p(charSequence, "$this$runningReduce");
        Object object = "operation";
        f0.p(p10, (String)object);
        int n10 = charSequence.length();
        ArrayList<Character> arrayList = null;
        int n11 = 1;
        if (n10 == 0) {
            n10 = n11;
        } else {
            n10 = 0;
            object = null;
        }
        if (n10 != 0) {
            return CollectionsKt__CollectionsKt.E();
        }
        n10 = charSequence.charAt(0);
        int n12 = charSequence.length();
        arrayList = new ArrayList<Character>(n12);
        Character c10 = Character.valueOf((char)n10);
        arrayList.add(c10);
        n12 = charSequence.length();
        while (n11 < n12) {
            object = Character.valueOf((char)n10);
            char c11 = charSequence.charAt(n11);
            Character c12 = Character.valueOf(c11);
            object = (Character)p10.invoke(object, c12);
            n10 = ((Character)object).charValue();
            c12 = Character.valueOf((char)n10);
            arrayList.add(c12);
            ++n11;
        }
        return arrayList;
    }

    public static final String h6(String charSequence, int n10) {
        f0.p(charSequence, "$this$dropLast");
        boolean bl2 = n10 >= 0;
        if (bl2) {
            n10 = q.n(((String)charSequence).length() - n10, 0);
            return StringsKt___StringsKt.C8((String)charSequence, n10);
        }
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("Requested character count ");
        ((StringBuilder)charSequence).append(n10);
        ((StringBuilder)charSequence).append(" is less than zero.");
        charSequence = ((StringBuilder)charSequence).toString();
        charSequence = charSequence.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)charSequence);
        throw illegalArgumentException;
    }

    public static final Collection h7(CharSequence charSequence, Collection collection, l l10) {
        int n10;
        f0.p(charSequence, "$this$mapTo");
        f0.p(collection, "destination");
        f0.p(l10, "transform");
        for (int i10 = 0; i10 < (n10 = charSequence.length()); ++i10) {
            n10 = charSequence.charAt(i10);
            Object object = Character.valueOf((char)n10);
            object = l10.invoke(object);
            collection.add(object);
        }
        return collection;
    }

    public static final List h8(CharSequence charSequence, f.h2.s.q q10) {
        f0.p(charSequence, "$this$runningReduceIndexed");
        Object object = "operation";
        f0.p(q10, (String)object);
        int n10 = charSequence.length();
        ArrayList<Comparable<Character>> arrayList = null;
        int n11 = 1;
        if (n10 == 0) {
            n10 = n11;
        } else {
            n10 = 0;
            object = null;
        }
        if (n10 != 0) {
            return CollectionsKt__CollectionsKt.E();
        }
        n10 = charSequence.charAt(0);
        int n12 = charSequence.length();
        arrayList = new ArrayList<Comparable<Character>>(n12);
        Character c10 = Character.valueOf((char)n10);
        arrayList.add(c10);
        n12 = charSequence.length();
        while (n11 < n12) {
            Constable constable = n11;
            object = Character.valueOf((char)n10);
            char c11 = charSequence.charAt(n11);
            Character c12 = Character.valueOf(c11);
            object = (Character)q10.invoke(constable, object, c12);
            n10 = ((Character)object).charValue();
            constable = Character.valueOf((char)n10);
            arrayList.add((Comparable<Character>)((Object)constable));
            ++n11;
        }
        return arrayList;
    }

    public static final CharSequence i6(CharSequence charSequence, l l10) {
        f0.p(charSequence, "$this$dropLastWhile");
        String string2 = "predicate";
        f0.p(l10, string2);
        for (int i10 = StringsKt__StringsKt.a3(charSequence); i10 >= 0; i10 += -1) {
            Comparable<Character> comparable = Character.valueOf(charSequence.charAt(i10));
            boolean bl2 = (Boolean)(comparable = (Boolean)l10.invoke(comparable));
            if (bl2) continue;
            return charSequence.subSequence(0, ++i10);
        }
        return "";
    }

    public static final Character i7(CharSequence charSequence) {
        f0.p(charSequence, "$this$max");
        return StringsKt___StringsKt.t7(charSequence);
    }

    public static final List i8(CharSequence arrayList, Object object, p p10) {
        f0.p(arrayList, "$this$scan");
        ArrayList<Object> arrayList2 = "operation";
        f0.p(p10, (String)((Object)arrayList2));
        int n10 = arrayList.length();
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            arrayList2 = null;
        }
        if (n10 != 0) {
            arrayList = t.k(object);
        } else {
            int n13 = arrayList.length() + n12;
            arrayList2 = new ArrayList<Object>(n13);
            arrayList2.add(object);
            while (n11 < (n12 = arrayList.length())) {
                n12 = arrayList.charAt(n11);
                Character c10 = Character.valueOf((char)n12);
                object = p10.invoke(object, c10);
                arrayList2.add(object);
                ++n11;
            }
            arrayList = arrayList2;
        }
        return arrayList;
    }

    public static final String j6(String string2, l l10) {
        f0.p(string2, "$this$dropLastWhile");
        String string3 = "predicate";
        f0.p(l10, string3);
        for (int i10 = StringsKt__StringsKt.a3(string2); i10 >= 0; i10 += -1) {
            Comparable<Character> comparable = Character.valueOf(string2.charAt(i10));
            boolean bl2 = (Boolean)(comparable = (Boolean)l10.invoke(comparable));
            if (bl2) continue;
            string2 = string2.substring(0, ++i10);
            f0.o(string2, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
            return string2;
        }
        return "";
    }

    public static final Character j7(CharSequence object, l l10) {
        f0.p(object, "$this$maxBy");
        String string2 = "selector";
        f0.p(l10, string2);
        int n10 = object.length();
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            string2 = null;
        }
        if (n10 != 0) {
            object = null;
        } else {
            n10 = object.charAt(0);
            n11 = StringsKt__StringsKt.a3((CharSequence)object);
            if (n11 == 0) {
                object = Character.valueOf((char)n10);
            } else {
                Comparable<Character> comparable = Character.valueOf((char)n10);
                comparable = (Comparable)l10.invoke(comparable);
                if (n12 <= n11) {
                    while (true) {
                        int n13 = object.charAt(n12);
                        Comparable<Character> comparable2 = Character.valueOf((char)n13);
                        int n14 = comparable.compareTo((Character)(comparable2 = (Comparable)l10.invoke(comparable2)));
                        if (n14 < 0) {
                            n10 = n13;
                            comparable = comparable2;
                        }
                        if (n12 == n11) break;
                        ++n12;
                    }
                }
                object = Character.valueOf((char)n10);
            }
        }
        return object;
    }

    public static final List j8(CharSequence arrayList, Object object, f.h2.s.q q10) {
        f0.p(arrayList, "$this$scanIndexed");
        ArrayList<Object> arrayList2 = "operation";
        f0.p(q10, (String)((Object)arrayList2));
        int n10 = arrayList.length();
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            arrayList2 = null;
        }
        if (n10 != 0) {
            arrayList = t.k(object);
        } else {
            int n13 = arrayList.length() + n12;
            arrayList2 = new ArrayList<Object>(n13);
            arrayList2.add(object);
            n12 = arrayList.length();
            while (n11 < n12) {
                Integer n14 = n11;
                char c10 = arrayList.charAt(n11);
                Character c11 = Character.valueOf(c10);
                object = q10.invoke(n14, object, c11);
                arrayList2.add(object);
                ++n11;
            }
            arrayList = arrayList2;
        }
        return arrayList;
    }

    public static final CharSequence k6(CharSequence charSequence, l l10) {
        f0.p(charSequence, "$this$dropWhile");
        String string2 = "predicate";
        f0.p(l10, string2);
        int n10 = charSequence.length();
        for (int i10 = 0; i10 < n10; ++i10) {
            Comparable<Character> comparable = Character.valueOf(charSequence.charAt(i10));
            boolean bl2 = (Boolean)(comparable = (Boolean)l10.invoke(comparable));
            if (bl2) continue;
            int n11 = charSequence.length();
            return charSequence.subSequence(i10, n11);
        }
        return "";
    }

    public static final Character k7(CharSequence charSequence, l l10) {
        f0.p(charSequence, "$this$maxByOrNull");
        String string2 = "selector";
        f0.p(l10, string2);
        int n10 = charSequence.length();
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            string2 = null;
        }
        if (n10 != 0) {
            return null;
        }
        n10 = charSequence.charAt(0);
        n11 = StringsKt__StringsKt.a3(charSequence);
        if (n11 == 0) {
            return Character.valueOf((char)n10);
        }
        Comparable<Character> comparable = Character.valueOf((char)n10);
        comparable = (Comparable)l10.invoke(comparable);
        if (n12 <= n11) {
            while (true) {
                int n13 = charSequence.charAt(n12);
                Comparable<Character> comparable2 = Character.valueOf((char)n13);
                int n14 = comparable.compareTo((Character)(comparable2 = (Comparable)l10.invoke(comparable2)));
                if (n14 < 0) {
                    n10 = n13;
                    comparable = comparable2;
                }
                if (n12 == n11) break;
                ++n12;
            }
        }
        return Character.valueOf((char)n10);
    }

    public static final List k8(CharSequence arrayList, p p10) {
        f0.p(arrayList, "$this$scanReduce");
        Object object = "operation";
        f0.p(p10, (String)object);
        int n10 = arrayList.length();
        ArrayList<Character> arrayList2 = null;
        int n11 = 1;
        if (n10 == 0) {
            n10 = n11;
        } else {
            n10 = 0;
            object = null;
        }
        if (n10 != 0) {
            arrayList = CollectionsKt__CollectionsKt.E();
        } else {
            n10 = arrayList.charAt(0);
            int n12 = arrayList.length();
            arrayList2 = new ArrayList<Character>(n12);
            Character c10 = Character.valueOf((char)n10);
            arrayList2.add(c10);
            n12 = arrayList.length();
            while (n11 < n12) {
                object = Character.valueOf((char)n10);
                char c11 = arrayList.charAt(n11);
                Character c12 = Character.valueOf(c11);
                object = (Character)p10.invoke(object, c12);
                n10 = ((Character)object).charValue();
                c12 = Character.valueOf((char)n10);
                arrayList2.add(c12);
                ++n11;
            }
            arrayList = arrayList2;
        }
        return arrayList;
    }

    public static final String l6(String string2, l l10) {
        f0.p(string2, "$this$dropWhile");
        String string3 = "predicate";
        f0.p(l10, string3);
        int n10 = string2.length();
        for (int i10 = 0; i10 < n10; ++i10) {
            Comparable<Character> comparable = Character.valueOf(string2.charAt(i10));
            boolean bl2 = (Boolean)(comparable = (Boolean)l10.invoke(comparable));
            if (bl2) continue;
            string2 = string2.substring(i10);
            f0.o(string2, "(this as java.lang.String).substring(startIndex)");
            return string2;
        }
        return "";
    }

    private static final double l7(CharSequence object, l l10) {
        Serializable serializable;
        int n10 = object.length();
        int n11 = 1;
        if (n10 == 0) {
            n10 = n11;
        } else {
            n10 = 0;
            serializable = null;
        }
        if (n10 == 0) {
            n10 = object.charAt(0);
            serializable = Character.valueOf((char)n10);
            serializable = (Number)l10.invoke(serializable);
            double d10 = ((Number)serializable).doubleValue();
            int n12 = StringsKt__StringsKt.a3((CharSequence)object);
            if (n11 <= n12) {
                while (true) {
                    char c10 = object.charAt(n11);
                    Serializable serializable2 = Character.valueOf(c10);
                    serializable2 = (Number)l10.invoke(serializable2);
                    double d11 = ((Number)serializable2).doubleValue();
                    d10 = Math.max(d10, d11);
                    if (n11 == n12) break;
                    ++n11;
                }
            }
            return d10;
        }
        object = new NoSuchElementException();
        throw object;
    }

    public static final List l8(CharSequence arrayList, f.h2.s.q q10) {
        f0.p(arrayList, "$this$scanReduceIndexed");
        Object object = "operation";
        f0.p(q10, (String)object);
        int n10 = arrayList.length();
        ArrayList<Comparable<Character>> arrayList2 = null;
        int n11 = 1;
        if (n10 == 0) {
            n10 = n11;
        } else {
            n10 = 0;
            object = null;
        }
        if (n10 != 0) {
            arrayList = CollectionsKt__CollectionsKt.E();
        } else {
            n10 = arrayList.charAt(0);
            int n12 = arrayList.length();
            arrayList2 = new ArrayList<Comparable<Character>>(n12);
            Character c10 = Character.valueOf((char)n10);
            arrayList2.add(c10);
            n12 = arrayList.length();
            while (n11 < n12) {
                Constable constable = n11;
                object = Character.valueOf((char)n10);
                char c11 = arrayList.charAt(n11);
                Character c12 = Character.valueOf(c11);
                object = (Character)q10.invoke(constable, object, c12);
                n10 = ((Character)object).charValue();
                constable = Character.valueOf((char)n10);
                arrayList2.add((Comparable<Character>)((Object)constable));
                ++n11;
            }
            arrayList = arrayList2;
        }
        return arrayList;
    }

    private static final char m6(CharSequence object, int n10, l l10) {
        char c10;
        int n11;
        if (n10 >= 0 && n10 <= (n11 = StringsKt__StringsKt.a3((CharSequence)object))) {
            c10 = object.charAt(n10);
        } else {
            object = n10;
            object = (Character)l10.invoke(object);
            c10 = ((Character)object).charValue();
        }
        return c10;
    }

    private static final float m7(CharSequence object, l l10) {
        Serializable serializable;
        float f10;
        int n10 = object.length();
        int n11 = 0;
        int n12 = 1;
        float f11 = Float.MIN_VALUE;
        if (n10 == 0) {
            n10 = n12;
            f10 = f11;
        } else {
            n10 = 0;
            serializable = null;
            f10 = 0.0f;
        }
        if (n10 == 0) {
            n10 = object.charAt(0);
            serializable = Character.valueOf((char)n10);
            serializable = (Number)l10.invoke(serializable);
            f10 = ((Number)serializable).floatValue();
            n11 = StringsKt__StringsKt.a3((CharSequence)object);
            if (n12 <= n11) {
                while (true) {
                    char c10 = object.charAt(n12);
                    Serializable serializable2 = Character.valueOf(c10);
                    serializable2 = (Number)l10.invoke(serializable2);
                    float f12 = ((Number)serializable2).floatValue();
                    f10 = Math.max(f10, f12);
                    if (n12 == n11) break;
                    ++n12;
                }
            }
            return f10;
        }
        object = new NoSuchElementException();
        throw object;
    }

    public static final char m8(CharSequence object) {
        String string2 = "$this$single";
        f0.p(object, string2);
        int n10 = object.length();
        if (n10 != 0) {
            int n11 = 1;
            if (n10 == n11) {
                return object.charAt(0);
            }
            object = new IllegalArgumentException("Char sequence has more than one element.");
            throw object;
        }
        object = new NoSuchElementException("Char sequence is empty.");
        throw object;
    }

    private static final Character n6(CharSequence charSequence, int n10) {
        return StringsKt___StringsKt.O6(charSequence, n10);
    }

    private static final Comparable n7(CharSequence object, l l10) {
        Comparable<Character> comparable;
        int n10 = object.length();
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            comparable = null;
        }
        if (n10 == 0) {
            n10 = object.charAt(0);
            comparable = Character.valueOf((char)n10);
            comparable = (Comparable)l10.invoke(comparable);
            n11 = StringsKt__StringsKt.a3((CharSequence)object);
            if (n12 <= n11) {
                while (true) {
                    char c10 = object.charAt(n12);
                    Comparable<Character> comparable2 = Character.valueOf(c10);
                    int n13 = comparable.compareTo((Character)(comparable2 = (Comparable)l10.invoke(comparable2)));
                    if (n13 < 0) {
                        comparable = comparable2;
                    }
                    if (n12 == n11) break;
                    ++n12;
                }
            }
            return comparable;
        }
        object = new NoSuchElementException();
        throw object;
    }

    public static final char n8(CharSequence object, l l10) {
        int n10;
        f0.p(object, "$this$single");
        f0.p(l10, "predicate");
        boolean bl2 = false;
        Character c10 = null;
        boolean bl3 = false;
        Character c11 = null;
        for (int i10 = 0; i10 < (n10 = object.length()); ++i10) {
            n10 = object.charAt(i10);
            Comparable<Character> comparable = Character.valueOf((char)n10);
            boolean bl4 = (Boolean)(comparable = (Boolean)l10.invoke(comparable));
            if (!bl4) continue;
            if (!bl3) {
                c11 = Character.valueOf((char)n10);
                bl2 = true;
                c10 = c11;
                bl3 = bl2;
                continue;
            }
            object = new IllegalArgumentException("Char sequence contains more than one matching element.");
            throw object;
        }
        if (bl3) {
            Objects.requireNonNull(c10, "null cannot be cast to non-null type kotlin.Char");
            return c10.charValue();
        }
        object = new NoSuchElementException("Char sequence contains no character matching the predicate.");
        throw object;
    }

    public static final CharSequence o6(CharSequence charSequence, l l10) {
        f0.p(charSequence, "$this$filter");
        f0.p(l10, "predicate");
        StringBuilder stringBuilder = new StringBuilder();
        int n10 = charSequence.length();
        for (int i10 = 0; i10 < n10; ++i10) {
            char c10 = charSequence.charAt(i10);
            Comparable<Character> comparable = Character.valueOf(c10);
            boolean bl2 = (Boolean)(comparable = (Boolean)l10.invoke(comparable));
            if (!bl2) continue;
            stringBuilder.append(c10);
        }
        return stringBuilder;
    }

    private static final Comparable o7(CharSequence charSequence, l l10) {
        Comparable<Character> comparable;
        int n10 = charSequence.length();
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            comparable = null;
        }
        if (n10 != 0) {
            return null;
        }
        n10 = charSequence.charAt(0);
        comparable = Character.valueOf((char)n10);
        comparable = (Comparable)l10.invoke(comparable);
        n11 = StringsKt__StringsKt.a3(charSequence);
        if (n12 <= n11) {
            while (true) {
                char c10 = charSequence.charAt(n12);
                Comparable<Character> comparable2 = Character.valueOf(c10);
                int n13 = comparable.compareTo((Character)(comparable2 = (Comparable)l10.invoke(comparable2)));
                if (n13 < 0) {
                    comparable = comparable2;
                }
                if (n12 == n11) break;
                ++n12;
            }
        }
        return comparable;
    }

    public static final Character o8(CharSequence object) {
        String string2 = "$this$singleOrNull";
        f0.p(object, string2);
        int n10 = object.length();
        int n11 = 1;
        if (n10 == n11) {
            n10 = 0;
            string2 = null;
            char c10 = object.charAt(0);
            object = Character.valueOf(c10);
        } else {
            boolean bl2 = false;
            object = null;
        }
        return object;
    }

    public static final String p6(String string2, l l10) {
        f0.p(string2, "$this$filter");
        f0.p(l10, "predicate");
        StringBuilder stringBuilder = new StringBuilder();
        int n10 = string2.length();
        for (int i10 = 0; i10 < n10; ++i10) {
            char c10 = string2.charAt(i10);
            Comparable<Character> comparable = Character.valueOf(c10);
            boolean bl2 = (Boolean)(comparable = (Boolean)l10.invoke(comparable));
            if (!bl2) continue;
            stringBuilder.append(c10);
        }
        string2 = stringBuilder.toString();
        f0.o(string2, "filterTo(StringBuilder(), predicate).toString()");
        return string2;
    }

    private static final Double p7(CharSequence charSequence, l l10) {
        Serializable serializable;
        int n10 = charSequence.length();
        int n11 = 1;
        if (n10 == 0) {
            n10 = n11;
        } else {
            n10 = 0;
            serializable = null;
        }
        if (n10 != 0) {
            return null;
        }
        n10 = charSequence.charAt(0);
        serializable = Character.valueOf((char)n10);
        serializable = (Number)l10.invoke(serializable);
        double d10 = ((Number)serializable).doubleValue();
        int n12 = StringsKt__StringsKt.a3(charSequence);
        if (n11 <= n12) {
            while (true) {
                char c10 = charSequence.charAt(n11);
                Serializable serializable2 = Character.valueOf(c10);
                serializable2 = (Number)l10.invoke(serializable2);
                double d11 = ((Number)serializable2).doubleValue();
                d10 = Math.max(d10, d11);
                if (n11 == n12) break;
                ++n11;
            }
        }
        return d10;
    }

    public static final Character p8(CharSequence charSequence, l l10) {
        int n10;
        f0.p(charSequence, "$this$singleOrNull");
        f0.p(l10, "predicate");
        boolean bl2 = false;
        Character c10 = null;
        for (int i10 = 0; i10 < (n10 = charSequence.length()); ++i10) {
            n10 = charSequence.charAt(i10);
            Comparable<Character> comparable = Character.valueOf((char)n10);
            boolean bl3 = (Boolean)(comparable = (Boolean)l10.invoke(comparable));
            if (!bl3) continue;
            if (bl2) {
                return null;
            }
            c10 = Character.valueOf((char)n10);
            bl2 = true;
        }
        if (!bl2) {
            return null;
        }
        return c10;
    }

    public static final CharSequence q6(CharSequence charSequence, p p10) {
        int n10;
        f0.p(charSequence, "$this$filterIndexed");
        f0.p(p10, "predicate");
        StringBuilder stringBuilder = new StringBuilder();
        int n11 = 0;
        Constable constable = null;
        for (int i10 = 0; i10 < (n10 = charSequence.length()); ++i10) {
            n10 = charSequence.charAt(i10);
            int n12 = n11 + 1;
            constable = Integer.valueOf(n11);
            Character c10 = Character.valueOf((char)n10);
            n11 = (int)(((Boolean)(constable = (Boolean)p10.invoke(constable, c10))).booleanValue() ? 1 : 0);
            if (n11 != 0) {
                stringBuilder.append((char)n10);
            }
            n11 = n12;
        }
        return stringBuilder;
    }

    private static final Float q7(CharSequence charSequence, l l10) {
        Serializable serializable;
        float f10;
        int n10 = charSequence.length();
        int n11 = 0;
        int n12 = 1;
        float f11 = Float.MIN_VALUE;
        if (n10 == 0) {
            n10 = n12;
            f10 = f11;
        } else {
            n10 = 0;
            serializable = null;
            f10 = 0.0f;
        }
        if (n10 != 0) {
            return null;
        }
        n10 = charSequence.charAt(0);
        serializable = Character.valueOf((char)n10);
        serializable = (Number)l10.invoke(serializable);
        f10 = ((Number)serializable).floatValue();
        n11 = StringsKt__StringsKt.a3(charSequence);
        if (n12 <= n11) {
            while (true) {
                char c10 = charSequence.charAt(n12);
                Serializable serializable2 = Character.valueOf(c10);
                serializable2 = (Number)l10.invoke(serializable2);
                float f12 = ((Number)serializable2).floatValue();
                f10 = Math.max(f10, f12);
                if (n12 == n11) break;
                ++n12;
            }
        }
        return Float.valueOf(f10);
    }

    public static final CharSequence q8(CharSequence charSequence, Iterable object) {
        char c10;
        f0.p(charSequence, "$this$slice");
        Object object2 = "indices";
        f0.p(object, (String)object2);
        int c102 = u.Y((Iterable)((Object)object), 10);
        if (c102 == 0) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder(c102);
        object = object.iterator();
        while ((c10 = object.hasNext()) != '\u0000') {
            object2 = (Number)object.next();
            char c10 = ((Number)object2).intValue();
            c10 = charSequence.charAt(c10);
            stringBuilder.append(c10);
        }
        return stringBuilder;
    }

    public static final String r6(String string2, p p10) {
        int n10;
        f0.p(string2, "$this$filterIndexed");
        f0.p(p10, "predicate");
        StringBuilder stringBuilder = new StringBuilder();
        int n11 = 0;
        Constable constable = null;
        for (int i10 = 0; i10 < (n10 = string2.length()); ++i10) {
            n10 = string2.charAt(i10);
            int n12 = n11 + 1;
            constable = Integer.valueOf(n11);
            Character c10 = Character.valueOf((char)n10);
            n11 = (int)(((Boolean)(constable = (Boolean)p10.invoke(constable, c10))).booleanValue() ? 1 : 0);
            if (n11 != 0) {
                stringBuilder.append((char)n10);
            }
            n11 = n12;
        }
        string2 = stringBuilder.toString();
        f0.o(string2, "filterIndexedTo(StringBu\u2026(), predicate).toString()");
        return string2;
    }

    private static final Object r7(CharSequence object, Comparator comparator, l l10) {
        Object object2;
        int n10 = object.length();
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            object2 = null;
        }
        if (n10 == 0) {
            n10 = object.charAt(0);
            object2 = Character.valueOf((char)n10);
            object2 = l10.invoke(object2);
            n11 = StringsKt__StringsKt.a3((CharSequence)object);
            if (n12 <= n11) {
                while (true) {
                    char c10 = object.charAt(n12);
                    Object object3 = Character.valueOf(c10);
                    int n13 = comparator.compare(object2, object3 = l10.invoke(object3));
                    if (n13 < 0) {
                        object2 = object3;
                    }
                    if (n12 == n11) break;
                    ++n12;
                }
            }
            return object2;
        }
        object = new NoSuchElementException();
        throw object;
    }

    public static final CharSequence r8(CharSequence charSequence, k k10) {
        f0.p(charSequence, "$this$slice");
        String string2 = "indices";
        f0.p(k10, string2);
        boolean bl2 = k10.isEmpty();
        if (bl2) {
            return "";
        }
        return StringsKt__StringsKt.T4(charSequence, k10);
    }

    public static final Appendable s6(CharSequence charSequence, Appendable appendable, p p10) {
        int n10;
        f0.p(charSequence, "$this$filterIndexedTo");
        f0.p(appendable, "destination");
        f0.p(p10, "predicate");
        int n11 = 0;
        Constable constable = null;
        for (int i10 = 0; i10 < (n10 = charSequence.length()); ++i10) {
            n10 = charSequence.charAt(i10);
            int n12 = n11 + 1;
            constable = Integer.valueOf(n11);
            Character c10 = Character.valueOf((char)n10);
            n11 = (int)(((Boolean)(constable = (Boolean)p10.invoke(constable, c10))).booleanValue() ? 1 : 0);
            if (n11 != 0) {
                appendable.append((char)n10);
            }
            n11 = n12;
        }
        return appendable;
    }

    private static final Object s7(CharSequence charSequence, Comparator comparator, l l10) {
        Object object;
        int n10 = charSequence.length();
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            object = null;
        }
        if (n10 != 0) {
            return null;
        }
        n10 = charSequence.charAt(0);
        object = Character.valueOf((char)n10);
        object = l10.invoke(object);
        n11 = StringsKt__StringsKt.a3(charSequence);
        if (n12 <= n11) {
            while (true) {
                char c10 = charSequence.charAt(n12);
                Object object2 = Character.valueOf(c10);
                int n13 = comparator.compare(object, object2 = l10.invoke(object2));
                if (n13 < 0) {
                    object = object2;
                }
                if (n12 == n11) break;
                ++n12;
            }
        }
        return object;
    }

    private static final String s8(String string2, Iterable iterable) {
        Objects.requireNonNull(string2, "null cannot be cast to non-null type kotlin.CharSequence");
        return ((Object)StringsKt___StringsKt.q8(string2, iterable)).toString();
    }

    public static final CharSequence t6(CharSequence charSequence, l l10) {
        int n10;
        f0.p(charSequence, "$this$filterNot");
        f0.p(l10, "predicate");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i10 = 0; i10 < (n10 = charSequence.length()); ++i10) {
            n10 = charSequence.charAt(i10);
            Comparable<Character> comparable = Character.valueOf((char)n10);
            boolean bl2 = (Boolean)(comparable = (Boolean)l10.invoke(comparable));
            if (bl2) continue;
            stringBuilder.append((char)n10);
        }
        return stringBuilder;
    }

    public static final Character t7(CharSequence charSequence) {
        String string2 = "$this$maxOrNull";
        f0.p(charSequence, string2);
        int n10 = charSequence.length();
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            string2 = null;
        }
        if (n10 != 0) {
            return null;
        }
        n10 = charSequence.charAt(0);
        n11 = StringsKt__StringsKt.a3(charSequence);
        if (n12 <= n11) {
            while (true) {
                int n13;
                int n14;
                if ((n14 = f0.t(n10, n13 = charSequence.charAt(n12))) < 0) {
                    n10 = n13;
                }
                if (n12 == n11) break;
                ++n12;
            }
        }
        return Character.valueOf((char)n10);
    }

    public static final String t8(String string2, k k10) {
        f0.p(string2, "$this$slice");
        String string3 = "indices";
        f0.p(k10, string3);
        boolean bl2 = k10.isEmpty();
        if (bl2) {
            return "";
        }
        return StringsKt__StringsKt.X4(string2, k10);
    }

    public static final String u6(String string2, l l10) {
        int n10;
        f0.p(string2, "$this$filterNot");
        f0.p(l10, "predicate");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i10 = 0; i10 < (n10 = string2.length()); ++i10) {
            n10 = string2.charAt(i10);
            Comparable<Character> comparable = Character.valueOf((char)n10);
            boolean bl2 = (Boolean)(comparable = (Boolean)l10.invoke(comparable));
            if (bl2) continue;
            stringBuilder.append((char)n10);
        }
        string2 = stringBuilder.toString();
        f0.o(string2, "filterNotTo(StringBuilder(), predicate).toString()");
        return string2;
    }

    public static final Character u7(CharSequence charSequence, Comparator comparator) {
        f0.p(charSequence, "$this$maxWith");
        f0.p(comparator, "comparator");
        return StringsKt___StringsKt.v7(charSequence, comparator);
    }

    public static final int u8(CharSequence charSequence, l l10) {
        int n10;
        f0.p(charSequence, "$this$sumBy");
        f0.p(l10, "selector");
        int n11 = 0;
        for (int i10 = 0; i10 < (n10 = charSequence.length()); ++i10) {
            Serializable serializable = Character.valueOf(charSequence.charAt(i10));
            serializable = (Number)l10.invoke(serializable);
            n10 = ((Number)serializable).intValue();
            n11 += n10;
        }
        return n11;
    }

    public static final Appendable v6(CharSequence charSequence, Appendable appendable, l l10) {
        int n10;
        f0.p(charSequence, "$this$filterNotTo");
        f0.p(appendable, "destination");
        f0.p(l10, "predicate");
        for (int i10 = 0; i10 < (n10 = charSequence.length()); ++i10) {
            n10 = charSequence.charAt(i10);
            Comparable<Character> comparable = Character.valueOf((char)n10);
            boolean bl2 = (Boolean)(comparable = (Boolean)l10.invoke(comparable));
            if (bl2) continue;
            appendable.append((char)n10);
        }
        return appendable;
    }

    public static final Character v7(CharSequence charSequence, Comparator comparator) {
        f0.p(charSequence, "$this$maxWithOrNull");
        String string2 = "comparator";
        f0.p(comparator, string2);
        int n10 = charSequence.length();
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            string2 = null;
        }
        if (n10 != 0) {
            return null;
        }
        n10 = charSequence.charAt(0);
        n11 = StringsKt__StringsKt.a3(charSequence);
        if (n12 <= n11) {
            while (true) {
                Character c10;
                int n13 = charSequence.charAt(n12);
                Character c11 = Character.valueOf((char)n10);
                int n14 = comparator.compare(c11, c10 = Character.valueOf((char)n13));
                if (n14 < 0) {
                    n10 = n13;
                }
                if (n12 == n11) break;
                ++n12;
            }
        }
        return Character.valueOf((char)n10);
    }

    public static final double v8(CharSequence charSequence, l l10) {
        int n10;
        f0.p(charSequence, "$this$sumByDouble");
        String string2 = "selector";
        f0.p(l10, string2);
        double d10 = 0.0;
        for (int i10 = 0; i10 < (n10 = charSequence.length()); ++i10) {
            n10 = charSequence.charAt(i10);
            Serializable serializable = Character.valueOf((char)n10);
            serializable = (Number)l10.invoke(serializable);
            double d11 = ((Number)serializable).doubleValue();
            d10 += d11;
        }
        return d10;
    }

    public static final Appendable w6(CharSequence charSequence, Appendable appendable, l l10) {
        f0.p(charSequence, "$this$filterTo");
        f0.p(appendable, "destination");
        String string2 = "predicate";
        f0.p(l10, string2);
        int n10 = charSequence.length();
        for (int i10 = 0; i10 < n10; ++i10) {
            char c10 = charSequence.charAt(i10);
            Comparable<Character> comparable = Character.valueOf(c10);
            boolean bl2 = (Boolean)(comparable = (Boolean)l10.invoke(comparable));
            if (!bl2) continue;
            appendable.append(c10);
        }
        return appendable;
    }

    public static final Character w7(CharSequence charSequence) {
        f0.p(charSequence, "$this$min");
        return StringsKt___StringsKt.H7(charSequence);
    }

    private static final double w8(CharSequence charSequence, l l10) {
        int n10;
        double d10 = 0.0;
        for (int i10 = 0; i10 < (n10 = charSequence.length()); ++i10) {
            n10 = charSequence.charAt(i10);
            Serializable serializable = Character.valueOf((char)n10);
            serializable = (Number)l10.invoke(serializable);
            double d11 = ((Number)serializable).doubleValue();
            d10 += d11;
        }
        return d10;
    }

    private static final Character x6(CharSequence object, l l10) {
        block1: {
            int n10;
            for (int i10 = 0; i10 < (n10 = object.length()); ++i10) {
                n10 = object.charAt(i10);
                Comparable<Character> comparable = Character.valueOf((char)n10);
                boolean bl2 = (Boolean)(comparable = (Boolean)l10.invoke(comparable));
                if (!bl2) continue;
                object = Character.valueOf((char)n10);
                break block1;
            }
            object = null;
        }
        return object;
    }

    public static final Character x7(CharSequence object, l l10) {
        f0.p(object, "$this$minBy");
        String string2 = "selector";
        f0.p(l10, string2);
        int n10 = object.length();
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            string2 = null;
        }
        if (n10 != 0) {
            object = null;
        } else {
            n10 = object.charAt(0);
            n11 = StringsKt__StringsKt.a3((CharSequence)object);
            if (n11 == 0) {
                object = Character.valueOf((char)n10);
            } else {
                Comparable<Character> comparable = Character.valueOf((char)n10);
                comparable = (Comparable)l10.invoke(comparable);
                if (n12 <= n11) {
                    while (true) {
                        int n13 = object.charAt(n12);
                        Comparable<Character> comparable2 = Character.valueOf((char)n13);
                        int n14 = comparable.compareTo((Character)(comparable2 = (Comparable)l10.invoke(comparable2)));
                        if (n14 > 0) {
                            n10 = n13;
                            comparable = comparable2;
                        }
                        if (n12 == n11) break;
                        ++n12;
                    }
                }
                object = Character.valueOf((char)n10);
            }
        }
        return object;
    }

    private static final int x8(CharSequence charSequence, l l10) {
        int n10;
        int n11 = 0;
        for (int i10 = 0; i10 < (n10 = charSequence.length()); ++i10) {
            Serializable serializable = Character.valueOf(charSequence.charAt(i10));
            serializable = (Number)l10.invoke(serializable);
            n10 = ((Number)serializable).intValue();
            n11 += n10;
        }
        return n11;
    }

    private static final Character y6(CharSequence object, l l10) {
        block1: {
            int n10 = object.length();
            while ((n10 += -1) >= 0) {
                char c10 = object.charAt(n10);
                Comparable<Character> comparable = Character.valueOf(c10);
                boolean bl2 = (Boolean)(comparable = (Boolean)l10.invoke(comparable));
                if (!bl2) continue;
                object = Character.valueOf(c10);
                break block1;
            }
            object = null;
        }
        return object;
    }

    public static final Character y7(CharSequence charSequence, l l10) {
        f0.p(charSequence, "$this$minByOrNull");
        String string2 = "selector";
        f0.p(l10, string2);
        int n10 = charSequence.length();
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            string2 = null;
        }
        if (n10 != 0) {
            return null;
        }
        n10 = charSequence.charAt(0);
        n11 = StringsKt__StringsKt.a3(charSequence);
        if (n11 == 0) {
            return Character.valueOf((char)n10);
        }
        Comparable<Character> comparable = Character.valueOf((char)n10);
        comparable = (Comparable)l10.invoke(comparable);
        if (n12 <= n11) {
            while (true) {
                int n13 = charSequence.charAt(n12);
                Comparable<Character> comparable2 = Character.valueOf((char)n13);
                int n14 = comparable.compareTo((Character)(comparable2 = (Comparable)l10.invoke(comparable2)));
                if (n14 > 0) {
                    n10 = n13;
                    comparable = comparable2;
                }
                if (n12 == n11) break;
                ++n12;
            }
        }
        return Character.valueOf((char)n10);
    }

    private static final long y8(CharSequence charSequence, l l10) {
        int n10;
        long l11 = 0L;
        for (int i10 = 0; i10 < (n10 = charSequence.length()); ++i10) {
            n10 = charSequence.charAt(i10);
            Serializable serializable = Character.valueOf((char)n10);
            serializable = (Number)l10.invoke(serializable);
            long l12 = ((Number)serializable).longValue();
            l11 += l12;
        }
        return l11;
    }

    public static final char z6(CharSequence object) {
        String string2 = "$this$first";
        f0.p(object, string2);
        int n10 = object.length();
        if (n10 == 0) {
            n10 = 1;
        } else {
            n10 = 0;
            string2 = null;
        }
        if (n10 == 0) {
            return object.charAt(0);
        }
        object = new NoSuchElementException("Char sequence is empty.");
        throw object;
    }

    private static final double z7(CharSequence object, l l10) {
        Serializable serializable;
        int n10 = object.length();
        int n11 = 1;
        if (n10 == 0) {
            n10 = n11;
        } else {
            n10 = 0;
            serializable = null;
        }
        if (n10 == 0) {
            n10 = object.charAt(0);
            serializable = Character.valueOf((char)n10);
            serializable = (Number)l10.invoke(serializable);
            double d10 = ((Number)serializable).doubleValue();
            int n12 = StringsKt__StringsKt.a3((CharSequence)object);
            if (n11 <= n12) {
                while (true) {
                    char c10 = object.charAt(n11);
                    Serializable serializable2 = Character.valueOf(c10);
                    serializable2 = (Number)l10.invoke(serializable2);
                    double d11 = ((Number)serializable2).doubleValue();
                    d10 = Math.min(d10, d11);
                    if (n11 == n12) break;
                    ++n11;
                }
            }
            return d10;
        }
        object = new NoSuchElementException();
        throw object;
    }

    private static final int z8(CharSequence charSequence, l l10) {
        int n10;
        int n11 = f.c1.h(0);
        for (int i10 = 0; i10 < (n10 = charSequence.length()); ++i10) {
            Comparable<Character> comparable = Character.valueOf(charSequence.charAt(i10));
            comparable = (f.c1)l10.invoke(comparable);
            n10 = ((f.c1)comparable).a0();
            n11 = f.c1.h(n11 + n10);
        }
        return n11;
    }
}

