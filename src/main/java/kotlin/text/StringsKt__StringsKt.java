/*
 * Decompiled with CFR 0.151.
 */
package kotlin.text;

import f.h2.s.a;
import f.h2.s.l;
import f.h2.t.f0;
import f.l2.i;
import f.l2.k;
import f.l2.q;
import f.n2.m;
import f.q2.b;
import f.q2.c;
import f.q2.f;
import f.q2.u;
import f.w0;
import f.x1.n;
import f.x1.r;
import f.x1.t;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Pair;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.sequences.SequencesKt___SequencesKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsKt$a;
import kotlin.text.StringsKt__StringsKt$rangesDelimitedBy$2;
import kotlin.text.StringsKt__StringsKt$rangesDelimitedBy$4;
import kotlin.text.StringsKt__StringsKt$splitToSequence$1;
import kotlin.text.StringsKt__StringsKt$splitToSequence$2;

public class StringsKt__StringsKt
extends u {
    public static /* synthetic */ int A3(CharSequence charSequence, Collection collection, int n10, boolean bl2, int n11, Object object) {
        int n12 = n11 & 2;
        if (n12 != 0) {
            n10 = StringsKt__StringsKt.a3(charSequence);
        }
        if ((n11 &= 4) != 0) {
            bl2 = false;
        }
        return StringsKt__StringsKt.y3(charSequence, collection, n10, bl2);
    }

    private static final String A4(String string2, int n10, int n11, CharSequence charSequence) {
        Objects.requireNonNull(string2, "null cannot be cast to non-null type kotlin.CharSequence");
        return ((Object)StringsKt__StringsKt.y4(string2, n10, n11, charSequence)).toString();
    }

    public static final String A5(String charSequence, char ... cArray) {
        block1: {
            f0.p(charSequence, "$this$trimEnd");
            String string2 = "chars";
            f0.p(cArray, string2);
            int n10 = charSequence.length();
            while ((n10 += -1) >= 0) {
                char c10 = charSequence.charAt(n10);
                if ((c10 = (char)(ArraysKt___ArraysKt.K7(cArray, c10) ? 1 : 0)) != '\u0000') continue;
                cArray = null;
                charSequence = charSequence.subSequence(0, ++n10);
                break block1;
            }
            charSequence = "";
        }
        return charSequence.toString();
    }

    public static /* synthetic */ int B3(CharSequence charSequence, char[] cArray, int n10, boolean bl2, int n11, Object object) {
        int n12 = n11 & 2;
        if (n12 != 0) {
            n10 = StringsKt__StringsKt.a3(charSequence);
        }
        if ((n11 &= 4) != 0) {
            bl2 = false;
        }
        return StringsKt__StringsKt.z3(charSequence, cArray, n10, bl2);
    }

    private static final String B4(String string2, k k10, CharSequence charSequence) {
        Objects.requireNonNull(string2, "null cannot be cast to non-null type kotlin.CharSequence");
        return ((Object)StringsKt__StringsKt.z4(string2, k10, charSequence)).toString();
    }

    public static final CharSequence B5(CharSequence charSequence) {
        block1: {
            String string2 = "$this$trimStart";
            f0.p(charSequence, string2);
            int n10 = charSequence.length();
            for (int i10 = 0; i10 < n10; ++i10) {
                boolean bl2 = b.r(charSequence.charAt(i10));
                if (bl2) continue;
                n10 = charSequence.length();
                charSequence = charSequence.subSequence(i10, n10);
                break block1;
            }
            charSequence = "";
        }
        return charSequence;
    }

    public static final m C3(CharSequence charSequence) {
        f0.p(charSequence, "$this$lineSequence");
        String[] stringArray = new String[]{"\r\n", "\n", "\r"};
        return StringsKt__StringsKt.M4(charSequence, stringArray, false, 0, 6, null);
    }

    private static final List C4(CharSequence charSequence, Regex regex, int n10) {
        return regex.split(charSequence, n10);
    }

    public static final CharSequence C5(CharSequence charSequence, l l10) {
        f0.p(charSequence, "$this$trimStart");
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

    public static final List D3(CharSequence charSequence) {
        f0.p(charSequence, "$this$lines");
        return SequencesKt___SequencesKt.V2(StringsKt__StringsKt.C3(charSequence));
    }

    public static final List D4(CharSequence charSequence, char[] object, boolean bl2, int n10) {
        f0.p(charSequence, "$this$split");
        CharSequence charSequence2 = "delimiters";
        f0.p(object, charSequence2);
        int n11 = ((char[])object).length;
        int n12 = 1;
        if (n11 == n12) {
            object = String.valueOf(object[0]);
            return StringsKt__StringsKt.F4(charSequence, (String)object, bl2, n10);
        }
        int n13 = 2;
        charSequence2 = charSequence;
        object = SequencesKt___SequencesKt.G(StringsKt__StringsKt.Q3(charSequence, (char[])object, 0, bl2, n10, n13, null));
        n10 = f.x1.u.Y((Iterable)object, 10);
        ArrayList<Object> arrayList = new ArrayList<Object>(n10);
        object = object.iterator();
        while ((n10 = (int)(object.hasNext() ? 1 : 0)) != 0) {
            Object object2 = (k)object.next();
            object2 = StringsKt__StringsKt.W4(charSequence, (k)object2);
            arrayList.add(object2);
        }
        return arrayList;
    }

    public static final CharSequence D5(CharSequence charSequence, char ... cArray) {
        block1: {
            f0.p(charSequence, "$this$trimStart");
            String string2 = "chars";
            f0.p(cArray, string2);
            int n10 = charSequence.length();
            for (int i10 = 0; i10 < n10; ++i10) {
                char c10 = charSequence.charAt(i10);
                if ((c10 = (char)(ArraysKt___ArraysKt.K7(cArray, c10) ? 1 : 0)) != '\u0000') continue;
                int n11 = charSequence.length();
                charSequence = charSequence.subSequence(i10, n11);
                break block1;
            }
            charSequence = "";
        }
        return charSequence;
    }

    private static final boolean E3(CharSequence charSequence, Regex regex) {
        return regex.matches(charSequence);
    }

    public static final List E4(CharSequence charSequence, String[] object, boolean n10, int n11) {
        int n12;
        String string2;
        f0.p(charSequence, "$this$split");
        CharSequence charSequence2 = "delimiters";
        f0.p(object, charSequence2);
        int n13 = ((String[])object).length;
        int n14 = 1;
        if (n13 == n14) {
            n13 = 0;
            charSequence2 = null;
            string2 = object[0];
            n12 = string2.length();
            if (n12 != 0) {
                n14 = 0;
            }
            if (n14 == 0) {
                return StringsKt__StringsKt.F4(charSequence, string2, n10 != 0, n11);
            }
        }
        string2 = null;
        int n15 = 2;
        charSequence2 = charSequence;
        n12 = n10;
        object = SequencesKt___SequencesKt.G(StringsKt__StringsKt.R3(charSequence, (String[])object, 0, n10 != 0, n11, n15, null));
        n11 = f.x1.u.Y((Iterable)object, 10);
        ArrayList<Object> arrayList = new ArrayList<Object>(n11);
        object = object.iterator();
        while ((n11 = (int)(object.hasNext() ? 1 : 0)) != 0) {
            Object object2 = (k)object.next();
            object2 = StringsKt__StringsKt.W4(charSequence, (k)object2);
            arrayList.add(object2);
        }
        return arrayList;
    }

    private static final String E5(String string2) {
        Objects.requireNonNull(string2, "null cannot be cast to non-null type kotlin.CharSequence");
        return ((Object)StringsKt__StringsKt.B5(string2)).toString();
    }

    private static final String F3(String string2) {
        if (string2 == null) {
            string2 = "";
        }
        return string2;
    }

    private static final List F4(CharSequence charSequence, String object, boolean bl2, int n10) {
        int n11 = 0;
        String string2 = null;
        int n12 = 1;
        int n13 = n10 >= 0 ? n12 : 0;
        if (n13 != 0) {
            int n14;
            n13 = StringsKt__StringsKt.f3(charSequence, (String)object, 0, bl2);
            if (n13 != (n14 = -1) && n10 != n12) {
                int n15 = n10 > 0 ? n12 : 0;
                int n16 = 10;
                if (n15 != 0) {
                    n16 = q.u(n10, n16);
                }
                ArrayList<CharSequence> arrayList = new ArrayList<CharSequence>(n16);
                do {
                    string2 = ((Object)charSequence.subSequence(n11, n13)).toString();
                    arrayList.add(string2);
                    n11 = ((String)object).length() + n13;
                } while ((n15 == 0 || (n13 = arrayList.size()) != (n16 = n10 + -1)) && (n13 = StringsKt__StringsKt.f3(charSequence, (String)object, n11, bl2)) != n14);
                int n17 = charSequence.length();
                charSequence = ((Object)charSequence.subSequence(n11, n17)).toString();
                arrayList.add(charSequence);
                return arrayList;
            }
            return t.k(((Object)charSequence).toString());
        }
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("Limit must be non-negative, but was ");
        ((StringBuilder)charSequence).append(n10);
        ((StringBuilder)charSequence).append('.');
        charSequence = ((StringBuilder)charSequence).toString();
        charSequence = ((Object)charSequence).toString();
        object = new IllegalArgumentException((String)charSequence);
        throw object;
    }

    public static final String F5(String charSequence, l l10) {
        block1: {
            f0.p(charSequence, "$this$trimStart");
            String string2 = "predicate";
            f0.p(l10, string2);
            int n10 = charSequence.length();
            for (int i10 = 0; i10 < n10; ++i10) {
                Comparable<Character> comparable = Character.valueOf(charSequence.charAt(i10));
                boolean bl2 = (Boolean)(comparable = (Boolean)l10.invoke(comparable));
                if (bl2) continue;
                int n11 = charSequence.length();
                charSequence = charSequence.subSequence(i10, n11);
                break block1;
            }
            charSequence = "";
        }
        return charSequence.toString();
    }

    public static final /* synthetic */ Pair G2(CharSequence charSequence, Collection collection, int n10, boolean bl2, boolean bl3) {
        return StringsKt__StringsKt.V2(charSequence, collection, n10, bl2, bl3);
    }

    public static final CharSequence G3(CharSequence object, int n10, char c10) {
        CharSequence charSequence = "$this$padEnd";
        f0.p(object, (String)charSequence);
        if (n10 >= 0) {
            int n11 = object.length();
            if (n10 <= n11) {
                c10 = (char)object.length();
                return object.subSequence(0, c10);
            }
            charSequence = new StringBuilder(n10);
            ((StringBuilder)charSequence).append((CharSequence)object);
            int n12 = object.length();
            n10 -= n12;
            n12 = 1;
            if (n12 <= n10) {
                while (true) {
                    ((StringBuilder)charSequence).append(c10);
                    if (n12 == n10) break;
                    ++n12;
                }
            }
            return charSequence;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Desired length ");
        stringBuilder.append(n10);
        stringBuilder.append(" is less than zero.");
        String string2 = stringBuilder.toString();
        object = new IllegalArgumentException(string2);
        throw object;
    }

    public static /* synthetic */ List G4(CharSequence charSequence, Regex regex, int n10, int n11, Object object) {
        if ((n11 &= 2) != 0) {
            n10 = 0;
        }
        return regex.split(charSequence, n10);
    }

    public static final String G5(String charSequence, char ... cArray) {
        block1: {
            f0.p(charSequence, "$this$trimStart");
            String string2 = "chars";
            f0.p(cArray, string2);
            int n10 = charSequence.length();
            for (int i10 = 0; i10 < n10; ++i10) {
                char c10 = charSequence.charAt(i10);
                if ((c10 = (char)(ArraysKt___ArraysKt.K7(cArray, c10) ? 1 : 0)) != '\u0000') continue;
                int n11 = charSequence.length();
                charSequence = charSequence.subSequence(i10, n11);
                break block1;
            }
            charSequence = "";
        }
        return charSequence.toString();
    }

    public static final String H2(CharSequence charSequence, CharSequence charSequence2, boolean bl2) {
        boolean bl3;
        int n10;
        f0.p(charSequence, "$this$commonPrefixWith");
        String string2 = "other";
        f0.p(charSequence2, string2);
        int n11 = charSequence.length();
        int n12 = charSequence2.length();
        n11 = Math.min(n11, n12);
        n12 = 0;
        for (n10 = 0; n10 < n11; ++n10) {
            char c10 = charSequence.charAt(n10);
            char c11 = charSequence2.charAt(n10);
            if ((c10 = (char)(c.v(c10, c11, bl2) ? 1 : 0)) == '\u0000') break;
        }
        if ((n11 = (int)(StringsKt__StringsKt.b3(charSequence, (int)((bl2 = n10 + -1) ? 1 : 0)) ? 1 : 0)) != 0 || (bl3 = StringsKt__StringsKt.b3(charSequence2, (int)(bl2 ? 1 : 0)))) {
            n10 += -1;
        }
        return ((Object)charSequence.subSequence(0, n10)).toString();
    }

    public static final String H3(String string2, int n10, char c10) {
        f0.p(string2, "$this$padEnd");
        return ((Object)StringsKt__StringsKt.G3(string2, n10, c10)).toString();
    }

    public static /* synthetic */ List H4(CharSequence charSequence, char[] cArray, boolean bl2, int n10, int n11, Object object) {
        int n12 = n11 & 2;
        if (n12 != 0) {
            bl2 = false;
        }
        if ((n11 &= 4) != 0) {
            n10 = 0;
        }
        return StringsKt__StringsKt.D4(charSequence, cArray, bl2, n10);
    }

    public static /* synthetic */ String I2(CharSequence charSequence, CharSequence charSequence2, boolean bl2, int n10, Object object) {
        if ((n10 &= 2) != 0) {
            bl2 = false;
        }
        return StringsKt__StringsKt.H2(charSequence, charSequence2, bl2);
    }

    public static /* synthetic */ CharSequence I3(CharSequence charSequence, int n10, char c10, int n11, Object object) {
        if ((n11 &= 2) != 0) {
            c10 = (char)32;
        }
        return StringsKt__StringsKt.G3(charSequence, n10, c10);
    }

    public static /* synthetic */ List I4(CharSequence charSequence, String[] stringArray, boolean bl2, int n10, int n11, Object object) {
        int n12 = n11 & 2;
        if (n12 != 0) {
            bl2 = false;
        }
        if ((n11 &= 4) != 0) {
            n10 = 0;
        }
        return StringsKt__StringsKt.E4(charSequence, stringArray, bl2, n10);
    }

    public static final String J2(CharSequence charSequence, CharSequence charSequence2, boolean bl2) {
        int n10;
        int n11;
        boolean bl3;
        int n12;
        f0.p(charSequence, "$this$commonSuffixWith");
        String string2 = "other";
        f0.p(charSequence2, string2);
        int n13 = charSequence.length();
        int n14 = charSequence2.length();
        int n15 = Math.min(n13, n14);
        for (n12 = 0; n12 < n15; ++n12) {
            char c10 = n13 - n12 + -1;
            c10 = charSequence.charAt(c10);
            char c11 = n14 - n12 + -1;
            if ((c10 = (char)(c.v(c10, c11 = (char)charSequence2.charAt(c11), bl2) ? 1 : 0)) == '\u0000') break;
        }
        if ((bl3 = StringsKt__StringsKt.b3(charSequence, n11 = n13 - n12 + -1)) || (n10 = (int)(StringsKt__StringsKt.b3(charSequence2, n14 = n14 - n12 + -1) ? 1 : 0)) != 0) {
            n12 += -1;
        }
        n10 = n13 - n12;
        return ((Object)charSequence.subSequence(n10, n13)).toString();
    }

    public static /* synthetic */ String J3(String string2, int n10, char c10, int n11, Object object) {
        if ((n11 &= 2) != 0) {
            c10 = (char)32;
        }
        return StringsKt__StringsKt.H3(string2, n10, c10);
    }

    public static final m J4(CharSequence charSequence, char[] object, boolean bl2, int n10) {
        f0.p(charSequence, "$this$splitToSequence");
        f0.p(object, "delimiters");
        object = StringsKt__StringsKt.Q3(charSequence, object, 0, bl2, n10, 2, null);
        StringsKt__StringsKt$splitToSequence$2 stringsKt__StringsKt$splitToSequence$2 = new StringsKt__StringsKt$splitToSequence$2(charSequence);
        return SequencesKt___SequencesKt.b1((m)object, stringsKt__StringsKt$splitToSequence$2);
    }

    public static /* synthetic */ String K2(CharSequence charSequence, CharSequence charSequence2, boolean bl2, int n10, Object object) {
        if ((n10 &= 2) != 0) {
            bl2 = false;
        }
        return StringsKt__StringsKt.J2(charSequence, charSequence2, bl2);
    }

    public static final CharSequence K3(CharSequence object, int n10, char c10) {
        CharSequence charSequence = "$this$padStart";
        f0.p(object, (String)charSequence);
        if (n10 >= 0) {
            int n11 = object.length();
            if (n10 <= n11) {
                c10 = (char)object.length();
                return object.subSequence(0, c10);
            }
            charSequence = new StringBuilder(n10);
            int n12 = object.length();
            n12 = 1;
            if (n12 <= (n10 -= n12)) {
                while (true) {
                    ((StringBuilder)charSequence).append(c10);
                    if (n12 == n10) break;
                    ++n12;
                }
            }
            ((StringBuilder)charSequence).append((CharSequence)object);
            return charSequence;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Desired length ");
        stringBuilder.append(n10);
        stringBuilder.append(" is less than zero.");
        String string2 = stringBuilder.toString();
        object = new IllegalArgumentException(string2);
        throw object;
    }

    public static final m K4(CharSequence charSequence, String[] object, boolean bl2, int n10) {
        f0.p(charSequence, "$this$splitToSequence");
        f0.p(object, "delimiters");
        object = StringsKt__StringsKt.R3(charSequence, object, 0, bl2, n10, 2, null);
        StringsKt__StringsKt$splitToSequence$1 stringsKt__StringsKt$splitToSequence$1 = new StringsKt__StringsKt$splitToSequence$1(charSequence);
        return SequencesKt___SequencesKt.b1((m)object, stringsKt__StringsKt$splitToSequence$1);
    }

    /*
     * WARNING - void declaration
     */
    public static final boolean L2(CharSequence charSequence, char c10, boolean bl2) {
        void var5_8;
        String string2 = "$this$contains";
        f0.p(charSequence, string2);
        int n10 = 2;
        int bl3 = StringsKt__StringsKt.i3(charSequence, c10, 0, bl2, n10, null);
        if (bl3 >= 0) {
            boolean bl4 = true;
        } else {
            boolean bl5 = false;
            charSequence = null;
        }
        return (boolean)var5_8;
    }

    public static final String L3(String string2, int n10, char c10) {
        f0.p(string2, "$this$padStart");
        return ((Object)StringsKt__StringsKt.K3(string2, n10, c10)).toString();
    }

    public static /* synthetic */ m L4(CharSequence charSequence, char[] cArray, boolean bl2, int n10, int n11, Object object) {
        int n12 = n11 & 2;
        if (n12 != 0) {
            bl2 = false;
        }
        if ((n11 &= 4) != 0) {
            n10 = 0;
        }
        return StringsKt__StringsKt.J4(charSequence, cArray, bl2, n10);
    }

    public static final boolean M2(CharSequence charSequence, CharSequence charSequence2, boolean bl2) {
        boolean bl3;
        block4: {
            block3: {
                block2: {
                    f0.p(charSequence, "$this$contains");
                    String string2 = "other";
                    f0.p(charSequence2, string2);
                    boolean bl4 = charSequence2 instanceof String;
                    bl3 = true;
                    if (!bl4) break block2;
                    CharSequence charSequence3 = charSequence2;
                    charSequence3 = (String)charSequence2;
                    int n10 = 2;
                    boolean bl5 = bl2;
                    int n11 = StringsKt__StringsKt.j3(charSequence, (String)charSequence3, 0, bl2, n10, null);
                    if (n11 < 0) break block3;
                    break block4;
                }
                int n12 = charSequence.length();
                int n13 = 16;
                CharSequence charSequence4 = charSequence2;
                boolean bl6 = bl2;
                int n14 = StringsKt__StringsKt.h3(charSequence, charSequence2, 0, n12, bl2, false, n13, null);
                if (n14 >= 0) break block4;
            }
            bl3 = false;
        }
        return bl3;
    }

    public static /* synthetic */ CharSequence M3(CharSequence charSequence, int n10, char c10, int n11, Object object) {
        if ((n11 &= 2) != 0) {
            c10 = (char)32;
        }
        return StringsKt__StringsKt.K3(charSequence, n10, c10);
    }

    public static /* synthetic */ m M4(CharSequence charSequence, String[] stringArray, boolean bl2, int n10, int n11, Object object) {
        int n12 = n11 & 2;
        if (n12 != 0) {
            bl2 = false;
        }
        if ((n11 &= 4) != 0) {
            n10 = 0;
        }
        return StringsKt__StringsKt.K4(charSequence, stringArray, bl2, n10);
    }

    private static final boolean N2(CharSequence charSequence, Regex regex) {
        f0.p(charSequence, "$this$contains");
        return regex.containsMatchIn(charSequence);
    }

    public static /* synthetic */ String N3(String string2, int n10, char c10, int n11, Object object) {
        if ((n11 &= 2) != 0) {
            c10 = (char)32;
        }
        return StringsKt__StringsKt.L3(string2, n10, c10);
    }

    public static final boolean N4(CharSequence charSequence, char c10, boolean bl2) {
        boolean bl3;
        String string2 = "$this$startsWith";
        f0.p(charSequence, string2);
        int n10 = charSequence.length();
        boolean bl4 = false;
        if (n10 > 0 && (bl3 = c.v(charSequence.charAt(0), c10, bl2))) {
            bl4 = true;
        }
        return bl4;
    }

    public static /* synthetic */ boolean O2(CharSequence charSequence, char c10, boolean bl2, int n10, Object object) {
        if ((n10 &= 2) != 0) {
            bl2 = false;
        }
        return StringsKt__StringsKt.L2(charSequence, c10, bl2);
    }

    private static final m O3(CharSequence charSequence, char[] object, int n10, boolean bl2, int n11) {
        f f10;
        boolean bl3;
        if (n11 >= 0) {
            bl3 = true;
        } else {
            bl3 = false;
            f10 = null;
        }
        if (bl3) {
            StringsKt__StringsKt$rangesDelimitedBy$2 stringsKt__StringsKt$rangesDelimitedBy$2 = new StringsKt__StringsKt$rangesDelimitedBy$2((char[])object, bl2);
            f10 = new f(charSequence, n10, n11, stringsKt__StringsKt$rangesDelimitedBy$2);
            return f10;
        }
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("Limit must be non-negative, but was ");
        ((StringBuilder)charSequence).append(n11);
        ((StringBuilder)charSequence).append('.');
        charSequence = ((StringBuilder)charSequence).toString();
        object = new IllegalArgumentException;
        charSequence = ((Object)charSequence).toString();
        object((String)charSequence);
        throw object;
    }

    public static final boolean O4(CharSequence charSequence, CharSequence charSequence2, int n10, boolean bl2) {
        boolean bl3;
        f0.p(charSequence, "$this$startsWith");
        CharSequence charSequence3 = "prefix";
        f0.p(charSequence2, charSequence3);
        if (!bl2 && (bl3 = charSequence instanceof String) && (bl3 = charSequence2 instanceof String)) {
            CharSequence charSequence4 = charSequence;
            charSequence4 = (String)charSequence;
            CharSequence charSequence5 = charSequence2;
            charSequence5 = (String)charSequence2;
            return u.p2((String)charSequence4, (String)charSequence5, n10, false, 4, null);
        }
        int n11 = charSequence2.length();
        charSequence3 = charSequence;
        CharSequence charSequence6 = charSequence2;
        return StringsKt__StringsKt.S3(charSequence, n10, charSequence2, 0, n11, bl2);
    }

    public static /* synthetic */ boolean P2(CharSequence charSequence, CharSequence charSequence2, boolean bl2, int n10, Object object) {
        if ((n10 &= 2) != 0) {
            bl2 = false;
        }
        return StringsKt__StringsKt.M2(charSequence, charSequence2, bl2);
    }

    private static final m P3(CharSequence charSequence, String[] object, int n10, boolean bl2, int n11) {
        f f10;
        boolean bl3;
        if (n11 >= 0) {
            bl3 = true;
        } else {
            bl3 = false;
            f10 = null;
        }
        if (bl3) {
            object = n.t(object);
            StringsKt__StringsKt$rangesDelimitedBy$4 stringsKt__StringsKt$rangesDelimitedBy$4 = new StringsKt__StringsKt$rangesDelimitedBy$4((List)object, bl2);
            f10 = new f(charSequence, n10, n11, stringsKt__StringsKt$rangesDelimitedBy$4);
            return f10;
        }
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("Limit must be non-negative, but was ");
        ((StringBuilder)charSequence).append(n11);
        ((StringBuilder)charSequence).append('.');
        charSequence = ((StringBuilder)charSequence).toString();
        charSequence = ((Object)charSequence).toString();
        object = new IllegalArgumentException((String)charSequence);
        throw object;
    }

    public static final boolean P4(CharSequence charSequence, CharSequence charSequence2, boolean bl2) {
        boolean bl3;
        f0.p(charSequence, "$this$startsWith");
        CharSequence charSequence3 = "prefix";
        f0.p(charSequence2, charSequence3);
        if (!bl2 && (bl3 = charSequence instanceof String) && (bl3 = charSequence2 instanceof String)) {
            charSequence = (String)charSequence;
            charSequence2 = (String)charSequence2;
            return u.q2((String)charSequence, (String)charSequence2, false, 2, null);
        }
        int n10 = charSequence2.length();
        charSequence3 = charSequence;
        return StringsKt__StringsKt.S3(charSequence, 0, charSequence2, 0, n10, bl2);
    }

    public static final boolean Q2(CharSequence charSequence, char c10, boolean bl2) {
        boolean bl3;
        String string2 = "$this$endsWith";
        f0.p(charSequence, string2);
        int n10 = charSequence.length();
        if (n10 > 0 && (bl3 = c.v(charSequence.charAt(n10 = StringsKt__StringsKt.a3(charSequence)), c10, bl2))) {
            bl3 = true;
        } else {
            bl3 = false;
            charSequence = null;
        }
        return bl3;
    }

    public static /* synthetic */ m Q3(CharSequence charSequence, char[] cArray, int n10, boolean bl2, int n11, int n12, Object object) {
        int n13 = n12 & 2;
        if (n13 != 0) {
            n10 = 0;
        }
        if ((n13 = n12 & 4) != 0) {
            bl2 = false;
        }
        if ((n12 &= 8) != 0) {
            n11 = 0;
        }
        return StringsKt__StringsKt.O3(charSequence, cArray, n10, bl2, n11);
    }

    public static /* synthetic */ boolean Q4(CharSequence charSequence, char c10, boolean bl2, int n10, Object object) {
        if ((n10 &= 2) != 0) {
            bl2 = false;
        }
        return StringsKt__StringsKt.N4(charSequence, c10, bl2);
    }

    public static final boolean R2(CharSequence charSequence, CharSequence charSequence2, boolean bl2) {
        int n10;
        f0.p(charSequence, "$this$endsWith");
        String string2 = "suffix";
        f0.p(charSequence2, string2);
        if (!bl2 && (n10 = charSequence instanceof String) != 0 && (n10 = charSequence2 instanceof String) != 0) {
            charSequence = (String)charSequence;
            charSequence2 = (String)charSequence2;
            return u.H1((String)charSequence, (String)charSequence2, false, 2, null);
        }
        n10 = charSequence.length();
        int n11 = charSequence2.length();
        int n12 = n10 - n11;
        int n13 = charSequence2.length();
        return StringsKt__StringsKt.S3(charSequence, n12, charSequence2, 0, n13, bl2);
    }

    public static /* synthetic */ m R3(CharSequence charSequence, String[] stringArray, int n10, boolean bl2, int n11, int n12, Object object) {
        int n13 = n12 & 2;
        if (n13 != 0) {
            n10 = 0;
        }
        if ((n13 = n12 & 4) != 0) {
            bl2 = false;
        }
        if ((n12 &= 8) != 0) {
            n11 = 0;
        }
        return StringsKt__StringsKt.P3(charSequence, stringArray, n10, bl2, n11);
    }

    public static /* synthetic */ boolean R4(CharSequence charSequence, CharSequence charSequence2, int n10, boolean bl2, int n11, Object object) {
        if ((n11 &= 4) != 0) {
            bl2 = false;
        }
        return StringsKt__StringsKt.O4(charSequence, charSequence2, n10, bl2);
    }

    public static /* synthetic */ boolean S2(CharSequence charSequence, char c10, boolean bl2, int n10, Object object) {
        if ((n10 &= 2) != 0) {
            bl2 = false;
        }
        return StringsKt__StringsKt.Q2(charSequence, c10, bl2);
    }

    public static final boolean S3(CharSequence charSequence, int n10, CharSequence charSequence2, int n11, int n12, boolean bl2) {
        int n13;
        f0.p(charSequence, "$this$regionMatchesImpl");
        f0.p(charSequence2, "other");
        if (n11 >= 0 && n10 >= 0 && n10 <= (n13 = charSequence.length() - n12) && n11 <= (n13 = charSequence2.length() - n12)) {
            for (n13 = 0; n13 < n12; ++n13) {
                char c10 = n10 + n13;
                c10 = charSequence.charAt(c10);
                char c11 = n11 + n13;
                if ((c10 = (char)(c.v(c10, c11 = (char)charSequence2.charAt(c11), bl2) ? 1 : 0)) != '\u0000') continue;
                return false;
            }
            return true;
        }
        return false;
    }

    public static /* synthetic */ boolean S4(CharSequence charSequence, CharSequence charSequence2, boolean bl2, int n10, Object object) {
        if ((n10 &= 2) != 0) {
            bl2 = false;
        }
        return StringsKt__StringsKt.P4(charSequence, charSequence2, bl2);
    }

    public static /* synthetic */ boolean T2(CharSequence charSequence, CharSequence charSequence2, boolean bl2, int n10, Object object) {
        if ((n10 &= 2) != 0) {
            bl2 = false;
        }
        return StringsKt__StringsKt.R2(charSequence, charSequence2, bl2);
    }

    public static final CharSequence T3(CharSequence charSequence, CharSequence charSequence2) {
        f0.p(charSequence, "$this$removePrefix");
        f0.p(charSequence2, "prefix");
        int n10 = 0;
        boolean bl2 = StringsKt__StringsKt.S4(charSequence, charSequence2, false, 2, null);
        if (bl2) {
            int n11 = charSequence2.length();
            n10 = charSequence.length();
            return charSequence.subSequence(n11, n10);
        }
        int n12 = charSequence.length();
        return charSequence.subSequence(0, n12);
    }

    public static final CharSequence T4(CharSequence charSequence, k k10) {
        f0.p(charSequence, "$this$subSequence");
        f0.p(k10, "range");
        int n10 = k10.l();
        int n11 = k10.k() + 1;
        return charSequence.subSequence(n10, n11);
    }

    public static final Pair U2(CharSequence charSequence, Collection collection, int n10, boolean bl2) {
        f0.p(charSequence, "$this$findAnyOf");
        f0.p(collection, "strings");
        return StringsKt__StringsKt.V2(charSequence, collection, n10, bl2, false);
    }

    public static final String U3(String string2, CharSequence charSequence) {
        f0.p(string2, "$this$removePrefix");
        f0.p(charSequence, "prefix");
        int n10 = 2;
        boolean bl2 = StringsKt__StringsKt.S4(string2, charSequence, false, n10, null);
        if (bl2) {
            int n11 = charSequence.length();
            string2 = string2.substring(n11);
            charSequence = "(this as java.lang.String).substring(startIndex)";
            f0.o(string2, (String)charSequence);
        }
        return string2;
    }

    private static final CharSequence U4(String string2, int n10, int n11) {
        return string2.subSequence(n10, n11);
    }

    private static final Pair V2(CharSequence object, Collection object2, int n10, boolean bl2, boolean n11) {
        i i10;
        int n12;
        int n13;
        Pair pair = null;
        if (!bl2 && (n13 = object2.size()) == (n12 = 1)) {
            object2 = (String)CollectionsKt___CollectionsKt.S4((Iterable)object2);
            Object var8_8 = null;
            int n14 = 4;
            boolean bl3 = false;
            Object object3 = object2;
            int n15 = n11 == 0 ? StringsKt__StringsKt.j3((CharSequence)object, (String)object2, n10, false, n14, null) : StringsKt__StringsKt.x3((CharSequence)object, (String)object2, n10, false, n14, null);
            if (n15 >= 0) {
                object = n15;
                pair = w0.a(object, object2);
            }
            return pair;
        }
        n13 = 0;
        if (n11 == 0) {
            n10 = q.n(n10, 0);
            n13 = object.length();
            i10 = new k(n10, n13);
        } else {
            n11 = StringsKt__StringsKt.a3((CharSequence)object);
            n10 = q.u(n10, n11);
            i10 = q.W(n10, 0);
        }
        n10 = object instanceof String;
        if (n10 != 0) {
            n10 = i10.e();
            n13 = i10.f();
            n11 = i10.g();
            if (n11 >= 0 ? n10 <= n13 : n10 >= n13) {
                while (true) {
                    String string2;
                    block15: {
                        Iterator iterator2 = object2.iterator();
                        while ((n12 = (int)(iterator2.hasNext() ? 1 : 0)) != 0) {
                            String string3 = string2 = (String)iterator2.next();
                            string3 = string2;
                            Object object4 = object;
                            object4 = (String)object;
                            int n16 = string3.length();
                            int n17 = n10;
                            n12 = (int)(u.Z1(string3, 0, (String)object4, n10, n16, bl2) ? 1 : 0);
                            if (n12 == 0) continue;
                            break block15;
                        }
                        string2 = null;
                    }
                    string2 = string2;
                    if (string2 != null) {
                        return w0.a(n10, string2);
                    }
                    if (n10 != n13) {
                        n10 += n11;
                        continue;
                    }
                    break;
                }
            }
        } else {
            n10 = i10.e();
            n13 = i10.f();
            n11 = i10.g();
            if (n11 >= 0 ? n10 <= n13 : n10 >= n13) {
                while (true) {
                    String string4;
                    block17: {
                        Iterator iterator3 = object2.iterator();
                        while ((n12 = (int)(iterator3.hasNext() ? 1 : 0)) != 0) {
                            String string5 = string4 = (String)iterator3.next();
                            string5 = string4;
                            int n18 = string5.length();
                            Object object5 = object;
                            int n19 = n10;
                            n12 = (int)(StringsKt__StringsKt.S3(string5, 0, (CharSequence)object, n10, n18, bl2) ? 1 : 0);
                            if (n12 == 0) continue;
                            break block17;
                        }
                        string4 = null;
                    }
                    string4 = string4;
                    if (string4 != null) {
                        return w0.a(n10, string4);
                    }
                    if (n10 == n13) break;
                    n10 += n11;
                }
            }
        }
        return null;
    }

    public static final CharSequence V3(CharSequence object, int n10, int n11) {
        CharSequence charSequence = "$this$removeRange";
        f0.p(object, (String)charSequence);
        if (n11 >= n10) {
            int n12 = 0;
            charSequence = null;
            if (n11 == n10) {
                n10 = object.length();
                return object.subSequence(0, n10);
            }
            int n13 = object.length();
            int n14 = n11 - n10;
            StringBuilder stringBuilder = new StringBuilder(n13 -= n14);
            stringBuilder.append((CharSequence)object, 0, n10);
            String string2 = "this.append(value, startIndex, endIndex)";
            f0.o(stringBuilder, string2);
            n12 = object.length();
            stringBuilder.append((CharSequence)object, n11, n12);
            f0.o(stringBuilder, string2);
            return stringBuilder;
        }
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("End index (");
        ((StringBuilder)charSequence).append(n11);
        ((StringBuilder)charSequence).append(") is less than start index (");
        ((StringBuilder)charSequence).append(n10);
        ((StringBuilder)charSequence).append(").");
        String string3 = ((StringBuilder)charSequence).toString();
        object = new IndexOutOfBoundsException(string3);
        throw object;
    }

    private static final String V4(CharSequence charSequence, int n10, int n11) {
        return ((Object)charSequence.subSequence(n10, n11)).toString();
    }

    public static /* synthetic */ Pair W2(CharSequence charSequence, Collection collection, int n10, boolean bl2, int n11, Object object) {
        int n12 = n11 & 2;
        if (n12 != 0) {
            n10 = 0;
        }
        if ((n11 &= 4) != 0) {
            bl2 = false;
        }
        return StringsKt__StringsKt.U2(charSequence, collection, n10, bl2);
    }

    public static final CharSequence W3(CharSequence charSequence, k k10) {
        f0.p(charSequence, "$this$removeRange");
        f0.p(k10, "range");
        int n10 = k10.l();
        int n11 = k10.k() + 1;
        return StringsKt__StringsKt.V3(charSequence, n10, n11);
    }

    public static final String W4(CharSequence charSequence, k k10) {
        f0.p(charSequence, "$this$substring");
        f0.p(k10, "range");
        int n10 = k10.l();
        int n11 = k10.k() + 1;
        return ((Object)charSequence.subSequence(n10, n11)).toString();
    }

    public static final Pair X2(CharSequence charSequence, Collection collection, int n10, boolean bl2) {
        f0.p(charSequence, "$this$findLastAnyOf");
        f0.p(collection, "strings");
        return StringsKt__StringsKt.V2(charSequence, collection, n10, bl2, true);
    }

    private static final String X3(String string2, int n10, int n11) {
        Objects.requireNonNull(string2, "null cannot be cast to non-null type kotlin.CharSequence");
        return ((Object)StringsKt__StringsKt.V3(string2, n10, n11)).toString();
    }

    public static final String X4(String string2, k k10) {
        f0.p(string2, "$this$substring");
        f0.p(k10, "range");
        int n10 = k10.l();
        int n11 = k10.k() + 1;
        string2 = string2.substring(n10, n11);
        f0.o(string2, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
        return string2;
    }

    public static /* synthetic */ Pair Y2(CharSequence charSequence, Collection collection, int n10, boolean bl2, int n11, Object object) {
        int n12 = n11 & 2;
        if (n12 != 0) {
            n10 = StringsKt__StringsKt.a3(charSequence);
        }
        if ((n11 &= 4) != 0) {
            bl2 = false;
        }
        return StringsKt__StringsKt.X2(charSequence, collection, n10, bl2);
    }

    private static final String Y3(String string2, k k10) {
        Objects.requireNonNull(string2, "null cannot be cast to non-null type kotlin.CharSequence");
        return ((Object)StringsKt__StringsKt.W3(string2, k10)).toString();
    }

    public static /* synthetic */ String Y4(CharSequence charSequence, int n10, int n11, int n12, Object object) {
        if ((n12 &= 2) != 0) {
            n11 = charSequence.length();
        }
        return ((Object)charSequence.subSequence(n10, n11)).toString();
    }

    public static final k Z2(CharSequence charSequence) {
        f0.p(charSequence, "$this$indices");
        int n10 = charSequence.length() + -1;
        k k10 = new k(0, n10);
        return k10;
    }

    public static final CharSequence Z3(CharSequence charSequence, CharSequence charSequence2) {
        f0.p(charSequence, "$this$removeSuffix");
        f0.p(charSequence2, "suffix");
        int n10 = StringsKt__StringsKt.T2(charSequence, charSequence2, false, 2, null);
        if (n10 != 0) {
            n10 = charSequence.length();
            int n11 = charSequence2.length();
            return charSequence.subSequence(0, n10 -= n11);
        }
        int n12 = charSequence.length();
        return charSequence.subSequence(0, n12);
    }

    public static final String Z4(String string2, char c10, String string3) {
        f0.p(string2, "$this$substringAfter");
        String string4 = "missingDelimiterValue";
        f0.p(string3, string4);
        int n10 = 6;
        c10 = (char)StringsKt__StringsKt.i3(string2, c10, 0, false, n10, null);
        char c11 = '\uffffffff';
        if (c10 != c11) {
            c10 = (char)(c10 + '\u0001');
            int n11 = string2.length();
            string3 = string2.substring(c10, n11);
            string2 = "(this as java.lang.Strin\u2026ing(startIndex, endIndex)";
            f0.o(string3, string2);
        }
        return string3;
    }

    public static final int a3(CharSequence charSequence) {
        f0.p(charSequence, "$this$lastIndex");
        return charSequence.length() + -1;
    }

    public static final String a4(String string2, CharSequence charSequence) {
        f0.p(string2, "$this$removeSuffix");
        f0.p(charSequence, "suffix");
        int n10 = StringsKt__StringsKt.T2(string2, charSequence, false, 2, null);
        if (n10 != 0) {
            n10 = string2.length();
            int n11 = charSequence.length();
            string2 = string2.substring(0, n10 -= n11);
            charSequence = "(this as java.lang.Strin\u2026ing(startIndex, endIndex)";
            f0.o(string2, (String)charSequence);
        }
        return string2;
    }

    public static final String a5(String string2, String string3, String string4) {
        f0.p(string2, "$this$substringAfter");
        f0.p(string3, "delimiter");
        String string5 = "missingDelimiterValue";
        f0.p(string4, string5);
        int n10 = 6;
        int n11 = StringsKt__StringsKt.j3(string2, string3, 0, false, n10, null);
        int n12 = -1;
        if (n11 != n12) {
            int n13 = string3.length();
            n11 += n13;
            n13 = string2.length();
            string4 = string2.substring(n11, n13);
            string2 = "(this as java.lang.Strin\u2026ing(startIndex, endIndex)";
            f0.o(string4, string2);
        }
        return string4;
    }

    public static final boolean b3(CharSequence charSequence, int n10) {
        boolean bl2;
        String string2 = "$this$hasSurrogatePairAt";
        f0.p(charSequence, string2);
        int n11 = charSequence.length() + -2;
        int n12 = 1;
        if (n10 < 0 || n11 < n10 || (n11 = (int)(Character.isHighSurrogate(charSequence.charAt(n10)) ? 1 : 0)) == 0 || !(bl2 = Character.isLowSurrogate(charSequence.charAt(n10 += n12)))) {
            n12 = 0;
        }
        return n12 != 0;
    }

    public static final CharSequence b4(CharSequence charSequence, CharSequence charSequence2) {
        f0.p(charSequence, "$this$removeSurrounding");
        f0.p(charSequence2, "delimiter");
        return StringsKt__StringsKt.c4(charSequence, charSequence2, charSequence2);
    }

    public static /* synthetic */ String b5(String string2, char c10, String string3, int n10, Object object) {
        if ((n10 &= 2) != 0) {
            string3 = string2;
        }
        return StringsKt__StringsKt.Z4(string2, c10, string3);
    }

    private static final Object c3(CharSequence object, a a10) {
        boolean bl2 = u.S1((CharSequence)object);
        if (bl2) {
            object = a10.invoke();
        }
        return object;
    }

    public static final CharSequence c4(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3) {
        f0.p(charSequence, "$this$removeSurrounding");
        f0.p(charSequence2, "prefix");
        String string2 = "suffix";
        f0.p(charSequence3, string2);
        int n10 = charSequence.length();
        int n11 = charSequence2.length();
        int n12 = charSequence3.length();
        n11 += n12;
        n12 = 0;
        if (n10 >= n11) {
            n10 = 2;
            n11 = 0;
            boolean bl2 = StringsKt__StringsKt.S4(charSequence, charSequence2, false, n10, null);
            if (bl2 && (n10 = (int)(StringsKt__StringsKt.T2(charSequence, charSequence3, false, n10, null) ? 1 : 0)) != 0) {
                int n13 = charSequence2.length();
                n10 = charSequence.length();
                int n14 = charSequence3.length();
                return charSequence.subSequence(n13, n10 -= n14);
            }
        }
        int n15 = charSequence.length();
        return charSequence.subSequence(0, n15);
    }

    public static /* synthetic */ String c5(String string2, String string3, String string4, int n10, Object object) {
        if ((n10 &= 2) != 0) {
            string4 = string2;
        }
        return StringsKt__StringsKt.a5(string2, string3, string4);
    }

    private static final Object d3(CharSequence object, a a10) {
        int n10 = object.length();
        n10 = n10 == 0 ? 1 : 0;
        if (n10 != 0) {
            object = a10.invoke();
        }
        return object;
    }

    public static final String d4(String string2, CharSequence charSequence) {
        f0.p(string2, "$this$removeSurrounding");
        f0.p(charSequence, "delimiter");
        return StringsKt__StringsKt.e4(string2, charSequence, charSequence);
    }

    public static final String d5(String string2, char c10, String string3) {
        f0.p(string2, "$this$substringAfterLast");
        String string4 = "missingDelimiterValue";
        f0.p(string3, string4);
        int n10 = 6;
        c10 = (char)StringsKt__StringsKt.w3(string2, c10, 0, false, n10, null);
        char c11 = '\uffffffff';
        if (c10 != c11) {
            c10 = (char)(c10 + '\u0001');
            int n11 = string2.length();
            string3 = string2.substring(c10, n11);
            string2 = "(this as java.lang.Strin\u2026ing(startIndex, endIndex)";
            f0.o(string3, string2);
        }
        return string3;
    }

    public static final int e3(CharSequence charSequence, char c10, int n10, boolean bl2) {
        int n11;
        int n12;
        Object object = "$this$indexOf";
        f0.p(charSequence, (String)object);
        if (!bl2 && (n12 = charSequence instanceof String) != 0) {
            charSequence = (String)charSequence;
            n11 = ((String)charSequence).indexOf(c10, n10);
        } else {
            n12 = 1;
            object = new char[n12];
            object[0] = c10;
            n11 = StringsKt__StringsKt.l3(charSequence, (char[])object, n10, bl2);
        }
        return n11;
    }

    public static final String e4(String string2, CharSequence charSequence, CharSequence charSequence2) {
        f0.p(string2, "$this$removeSurrounding");
        f0.p(charSequence, "prefix");
        String string3 = "suffix";
        f0.p(charSequence2, string3);
        int n10 = string2.length();
        int n11 = charSequence.length();
        int n12 = charSequence2.length();
        if (n10 >= (n11 += n12)) {
            n10 = 0;
            string3 = null;
            n11 = 2;
            n12 = 0;
            boolean bl2 = StringsKt__StringsKt.S4(string2, charSequence, false, n11, null);
            if (bl2 && (n10 = (int)(StringsKt__StringsKt.T2(string2, charSequence2, false, n11, null) ? 1 : 0)) != 0) {
                int n13 = charSequence.length();
                n10 = string2.length();
                int n14 = charSequence2.length();
                string2 = string2.substring(n13, n10 -= n14);
                charSequence = "(this as java.lang.Strin\u2026ing(startIndex, endIndex)";
                f0.o(string2, (String)charSequence);
            }
        }
        return string2;
    }

    public static final String e5(String string2, String string3, String string4) {
        f0.p(string2, "$this$substringAfterLast");
        f0.p(string3, "delimiter");
        String string5 = "missingDelimiterValue";
        f0.p(string4, string5);
        int n10 = 6;
        int n11 = StringsKt__StringsKt.x3(string2, string3, 0, false, n10, null);
        int n12 = -1;
        if (n11 != n12) {
            int n13 = string3.length();
            n11 += n13;
            n13 = string2.length();
            string4 = string2.substring(n11, n13);
            string2 = "(this as java.lang.Strin\u2026ing(startIndex, endIndex)";
            f0.o(string4, string2);
        }
        return string4;
    }

    public static final int f3(CharSequence charSequence, String string2, int n10, boolean bl2) {
        int n11;
        boolean bl3;
        f0.p(charSequence, "$this$indexOf");
        CharSequence charSequence2 = "string";
        f0.p(string2, charSequence2);
        if (!bl2 && (bl3 = charSequence instanceof String)) {
            charSequence = (String)charSequence;
            n11 = ((String)charSequence).indexOf(string2, n10);
        } else {
            int n12 = charSequence.length();
            int n13 = 16;
            charSequence2 = charSequence;
            n11 = StringsKt__StringsKt.h3(charSequence, string2, n10, n12, bl2, false, n13, null);
        }
        return n11;
    }

    private static final String f4(CharSequence charSequence, Regex regex, String string2) {
        return regex.replace(charSequence, string2);
    }

    public static /* synthetic */ String f5(String string2, char c10, String string3, int n10, Object object) {
        if ((n10 &= 2) != 0) {
            string3 = string2;
        }
        return StringsKt__StringsKt.d5(string2, c10, string3);
    }

    private static final int g3(CharSequence charSequence, CharSequence charSequence2, int n10, int n11, boolean bl2, boolean n12) {
        i i10;
        int n13 = 0;
        CharSequence charSequence3 = null;
        if (n12 == 0) {
            n10 = q.n(n10, 0);
            n13 = charSequence.length();
            n11 = q.u(n11, n13);
            i10 = new k(n10, n11);
        } else {
            n12 = StringsKt__StringsKt.a3(charSequence);
            n10 = q.u(n10, n12);
            n11 = q.n(n11, 0);
            i10 = q.W(n10, n11);
        }
        n10 = charSequence instanceof String;
        if (n10 != 0 && (n10 = charSequence2 instanceof String) != 0) {
            n10 = i10.e();
            n11 = i10.f();
            n12 = i10.g();
            if (n12 >= 0 ? n10 <= n11 : n10 >= n11) {
                while (true) {
                    charSequence3 = charSequence2;
                    charSequence3 = (String)charSequence2;
                    CharSequence charSequence4 = charSequence;
                    charSequence4 = (String)charSequence;
                    int n14 = charSequence2.length();
                    n13 = (int)(u.Z1((String)charSequence3, 0, (String)charSequence4, n10, n14, bl2) ? 1 : 0);
                    if (n13 != 0) {
                        return n10;
                    }
                    if (n10 != n11) {
                        n10 += n12;
                        continue;
                    }
                    break;
                }
            }
        } else {
            n10 = i10.e();
            n11 = i10.f();
            n12 = i10.g();
            if (n12 >= 0 ? n10 <= n11 : n10 >= n11) {
                while (true) {
                    int n15 = charSequence2.length();
                    charSequence3 = charSequence2;
                    CharSequence charSequence5 = charSequence;
                    n13 = (int)(StringsKt__StringsKt.S3(charSequence2, 0, charSequence, n10, n15, bl2) ? 1 : 0);
                    if (n13 != 0) {
                        return n10;
                    }
                    if (n10 == n11) break;
                    n10 += n12;
                }
            }
        }
        return -1;
    }

    private static final String g4(CharSequence charSequence, Regex regex, l l10) {
        return regex.replace(charSequence, l10);
    }

    public static /* synthetic */ String g5(String string2, String string3, String string4, int n10, Object object) {
        if ((n10 &= 2) != 0) {
            string4 = string2;
        }
        return StringsKt__StringsKt.e5(string2, string3, string4);
    }

    public static /* synthetic */ int h3(CharSequence charSequence, CharSequence charSequence2, int n10, int n11, boolean bl2, boolean bl3, int n12, Object object) {
        if ((n12 &= 0x10) != 0) {
            bl3 = false;
        }
        return StringsKt__StringsKt.g3(charSequence, charSequence2, n10, n11, bl2, bl3);
    }

    public static final String h4(String charSequence, char c10, String string2, String string3) {
        f0.p(charSequence, "$this$replaceAfter");
        f0.p(string2, "replacement");
        String string4 = "missingDelimiterValue";
        f0.p(string3, string4);
        int n10 = 6;
        c10 = (char)StringsKt__StringsKt.i3(charSequence, c10, 0, false, n10, null);
        char c11 = '\uffffffff';
        if (c10 != c11) {
            c10 = (char)(c10 + '\u0001');
            int n11 = ((String)charSequence).length();
            charSequence = StringsKt__StringsKt.y4(charSequence, c10, n11, string2);
            string3 = charSequence.toString();
        }
        return string3;
    }

    public static final String h5(String string2, char c10, String string3) {
        f0.p(string2, "$this$substringBefore");
        String string4 = "missingDelimiterValue";
        f0.p(string3, string4);
        int n10 = 6;
        c10 = (char)StringsKt__StringsKt.i3(string2, c10, 0, false, n10, null);
        char c11 = '\uffffffff';
        if (c10 != c11) {
            string3 = string2.substring(0, c10);
            string2 = "(this as java.lang.Strin\u2026ing(startIndex, endIndex)";
            f0.o(string3, string2);
        }
        return string3;
    }

    public static /* synthetic */ int i3(CharSequence charSequence, char c10, int n10, boolean bl2, int n11, Object object) {
        int n12 = n11 & 2;
        if (n12 != 0) {
            n10 = 0;
        }
        if ((n11 &= 4) != 0) {
            bl2 = false;
        }
        return StringsKt__StringsKt.e3(charSequence, c10, n10, bl2);
    }

    public static final String i4(String charSequence, String string2, String string3, String string4) {
        f0.p(charSequence, "$this$replaceAfter");
        f0.p(string2, "delimiter");
        f0.p(string3, "replacement");
        String string5 = "missingDelimiterValue";
        f0.p(string4, string5);
        int n10 = 6;
        int n11 = StringsKt__StringsKt.j3(charSequence, string2, 0, false, n10, null);
        int n12 = -1;
        if (n11 != n12) {
            int n13 = string2.length();
            n11 += n13;
            n13 = ((String)charSequence).length();
            charSequence = StringsKt__StringsKt.y4(charSequence, n11, n13, string3);
            string4 = charSequence.toString();
        }
        return string4;
    }

    public static final String i5(String string2, String string3, String string4) {
        f0.p(string2, "$this$substringBefore");
        f0.p(string3, "delimiter");
        String string5 = "missingDelimiterValue";
        f0.p(string4, string5);
        int n10 = 6;
        int n11 = StringsKt__StringsKt.j3(string2, string3, 0, false, n10, null);
        int n12 = -1;
        if (n11 != n12) {
            string4 = string2.substring(0, n11);
            string2 = "(this as java.lang.Strin\u2026ing(startIndex, endIndex)";
            f0.o(string4, string2);
        }
        return string4;
    }

    public static /* synthetic */ int j3(CharSequence charSequence, String string2, int n10, boolean bl2, int n11, Object object) {
        int n12 = n11 & 2;
        if (n12 != 0) {
            n10 = 0;
        }
        if ((n11 &= 4) != 0) {
            bl2 = false;
        }
        return StringsKt__StringsKt.f3(charSequence, string2, n10, bl2);
    }

    public static /* synthetic */ String j4(String string2, char c10, String string3, String string4, int n10, Object object) {
        if ((n10 &= 4) != 0) {
            string4 = string2;
        }
        return StringsKt__StringsKt.h4(string2, c10, string3, string4);
    }

    public static /* synthetic */ String j5(String string2, char c10, String string3, int n10, Object object) {
        if ((n10 &= 2) != 0) {
            string3 = string2;
        }
        return StringsKt__StringsKt.h5(string2, c10, string3);
    }

    public static final int k3(CharSequence object, Collection collection, int n10, boolean bl2) {
        f0.p(object, "$this$indexOfAny");
        f0.p(collection, "strings");
        object = StringsKt__StringsKt.V2((CharSequence)object, collection, n10, bl2, false);
        int n11 = object != null && (object = (Integer)((Pair)object).getFirst()) != null ? (Integer)object : -1;
        return n11;
    }

    public static /* synthetic */ String k4(String string2, String string3, String string4, String string5, int n10, Object object) {
        if ((n10 &= 4) != 0) {
            string5 = string2;
        }
        return StringsKt__StringsKt.i4(string2, string3, string4, string5);
    }

    public static /* synthetic */ String k5(String string2, String string3, String string4, int n10, Object object) {
        if ((n10 &= 2) != 0) {
            string4 = string2;
        }
        return StringsKt__StringsKt.i5(string2, string3, string4);
    }

    public static final int l3(CharSequence charSequence, char[] cArray, int n10, boolean bl2) {
        int n11;
        int n12;
        f0.p(charSequence, "$this$indexOfAny");
        String string2 = "chars";
        f0.p(cArray, string2);
        int n13 = 1;
        if (!bl2 && (n12 = cArray.length) == n13 && (n12 = charSequence instanceof String) != 0) {
            char c10 = ArraysKt___ArraysKt.Is(cArray);
            return ((String)charSequence).indexOf(c10, n10);
        }
        n12 = 0;
        if ((n10 = q.n(n10, 0)) <= (n11 = StringsKt__StringsKt.a3(charSequence))) {
            while (true) {
                int n14;
                block5: {
                    n14 = charSequence.charAt(n10);
                    int n15 = cArray.length;
                    for (int i10 = 0; i10 < n15; ++i10) {
                        boolean bl3 = c.v(cArray[i10], (char)n14, bl2);
                        if (!bl3) continue;
                        n14 = n13;
                        break block5;
                    }
                    n14 = 0;
                }
                if (n14 != 0) {
                    return n10;
                }
                if (n10 == n11) break;
                ++n10;
            }
        }
        return -1;
    }

    public static final String l4(String charSequence, char c10, String string2, String string3) {
        f0.p(charSequence, "$this$replaceAfterLast");
        f0.p(string2, "replacement");
        String string4 = "missingDelimiterValue";
        f0.p(string3, string4);
        int n10 = 6;
        c10 = (char)StringsKt__StringsKt.w3(charSequence, c10, 0, false, n10, null);
        char c11 = '\uffffffff';
        if (c10 != c11) {
            c10 = (char)(c10 + '\u0001');
            int n11 = ((String)charSequence).length();
            charSequence = StringsKt__StringsKt.y4(charSequence, c10, n11, string2);
            string3 = charSequence.toString();
        }
        return string3;
    }

    public static final String l5(String string2, char c10, String string3) {
        f0.p(string2, "$this$substringBeforeLast");
        String string4 = "missingDelimiterValue";
        f0.p(string3, string4);
        int n10 = 6;
        c10 = (char)StringsKt__StringsKt.w3(string2, c10, 0, false, n10, null);
        char c11 = '\uffffffff';
        if (c10 != c11) {
            string3 = string2.substring(0, c10);
            string2 = "(this as java.lang.Strin\u2026ing(startIndex, endIndex)";
            f0.o(string3, string2);
        }
        return string3;
    }

    public static /* synthetic */ int m3(CharSequence charSequence, Collection collection, int n10, boolean bl2, int n11, Object object) {
        int n12 = n11 & 2;
        if (n12 != 0) {
            n10 = 0;
        }
        if ((n11 &= 4) != 0) {
            bl2 = false;
        }
        return StringsKt__StringsKt.k3(charSequence, collection, n10, bl2);
    }

    public static final String m4(String charSequence, String string2, String string3, String string4) {
        f0.p(charSequence, "$this$replaceAfterLast");
        f0.p(string2, "delimiter");
        f0.p(string3, "replacement");
        String string5 = "missingDelimiterValue";
        f0.p(string4, string5);
        int n10 = 6;
        int n11 = StringsKt__StringsKt.x3(charSequence, string2, 0, false, n10, null);
        int n12 = -1;
        if (n11 != n12) {
            int n13 = string2.length();
            n11 += n13;
            n13 = ((String)charSequence).length();
            charSequence = StringsKt__StringsKt.y4(charSequence, n11, n13, string3);
            string4 = charSequence.toString();
        }
        return string4;
    }

    public static final String m5(String string2, String string3, String string4) {
        f0.p(string2, "$this$substringBeforeLast");
        f0.p(string3, "delimiter");
        String string5 = "missingDelimiterValue";
        f0.p(string4, string5);
        int n10 = 6;
        int n11 = StringsKt__StringsKt.x3(string2, string3, 0, false, n10, null);
        int n12 = -1;
        if (n11 != n12) {
            string4 = string2.substring(0, n11);
            string2 = "(this as java.lang.Strin\u2026ing(startIndex, endIndex)";
            f0.o(string4, string2);
        }
        return string4;
    }

    public static /* synthetic */ int n3(CharSequence charSequence, char[] cArray, int n10, boolean bl2, int n11, Object object) {
        int n12 = n11 & 2;
        if (n12 != 0) {
            n10 = 0;
        }
        if ((n11 &= 4) != 0) {
            bl2 = false;
        }
        return StringsKt__StringsKt.l3(charSequence, cArray, n10, bl2);
    }

    public static /* synthetic */ String n4(String string2, char c10, String string3, String string4, int n10, Object object) {
        if ((n10 &= 4) != 0) {
            string4 = string2;
        }
        return StringsKt__StringsKt.l4(string2, c10, string3, string4);
    }

    public static /* synthetic */ String n5(String string2, char c10, String string3, int n10, Object object) {
        if ((n10 &= 2) != 0) {
            string3 = string2;
        }
        return StringsKt__StringsKt.l5(string2, c10, string3);
    }

    private static final boolean o3(CharSequence charSequence) {
        int n10 = charSequence.length();
        if (!n10) {
            n10 = 1;
        } else {
            n10 = 0;
            charSequence = null;
        }
        return n10 != 0;
    }

    public static /* synthetic */ String o4(String string2, String string3, String string4, String string5, int n10, Object object) {
        if ((n10 &= 4) != 0) {
            string5 = string2;
        }
        return StringsKt__StringsKt.m4(string2, string3, string4, string5);
    }

    public static /* synthetic */ String o5(String string2, String string3, String string4, int n10, Object object) {
        if ((n10 &= 2) != 0) {
            string4 = string2;
        }
        return StringsKt__StringsKt.m5(string2, string3, string4);
    }

    private static final boolean p3(CharSequence charSequence) {
        return u.S1(charSequence) ^ true;
    }

    public static final String p4(String charSequence, char c10, String string2, String string3) {
        f0.p(charSequence, "$this$replaceBefore");
        f0.p(string2, "replacement");
        String string4 = "missingDelimiterValue";
        f0.p(string3, string4);
        int n10 = 6;
        c10 = (char)StringsKt__StringsKt.i3(charSequence, c10, 0, false, n10, null);
        char c11 = '\uffffffff';
        if (c10 != c11) {
            charSequence = StringsKt__StringsKt.y4(charSequence, 0, c10, string2);
            string3 = charSequence.toString();
        }
        return string3;
    }

    public static final CharSequence p5(CharSequence charSequence) {
        String string2 = "$this$trim";
        f0.p(charSequence, string2);
        int n10 = charSequence.length();
        int n11 = 1;
        n10 -= n11;
        int n12 = 0;
        int n13 = 0;
        while (n12 <= n10) {
            int n14 = n13 == 0 ? n12 : n10;
            n14 = (int)(b.r(charSequence.charAt(n14)) ? 1 : 0);
            if (n13 == 0) {
                if (n14 == 0) {
                    n13 = n11;
                    continue;
                }
                ++n12;
                continue;
            }
            if (n14 == 0) break;
            n10 += -1;
        }
        return charSequence.subSequence(n12, n10 += n11);
    }

    private static final boolean q3(CharSequence charSequence) {
        int n10 = charSequence.length();
        if (n10 > 0) {
            n10 = 1;
        } else {
            n10 = 0;
            charSequence = null;
        }
        return n10 != 0;
    }

    public static final String q4(String charSequence, String string2, String string3, String string4) {
        f0.p(charSequence, "$this$replaceBefore");
        f0.p(string2, "delimiter");
        f0.p(string3, "replacement");
        String string5 = "missingDelimiterValue";
        f0.p(string4, string5);
        int n10 = 6;
        int n11 = StringsKt__StringsKt.j3(charSequence, string2, 0, false, n10, null);
        int n12 = -1;
        if (n11 != n12) {
            charSequence = StringsKt__StringsKt.y4(charSequence, 0, n11, string3);
            string4 = charSequence.toString();
        }
        return string4;
    }

    public static final CharSequence q5(CharSequence charSequence, l l10) {
        f0.p(charSequence, "$this$trim");
        String string2 = "predicate";
        f0.p(l10, string2);
        int n10 = charSequence.length();
        int n11 = 1;
        n10 -= n11;
        int n12 = 0;
        int n13 = 0;
        while (n12 <= n10) {
            int n14 = n13 == 0 ? n12 : n10;
            Comparable<Character> comparable = Character.valueOf(charSequence.charAt(n14));
            comparable = (Boolean)l10.invoke(comparable);
            n14 = (int)(((Boolean)comparable).booleanValue() ? 1 : 0);
            if (n13 == 0) {
                if (n14 == 0) {
                    n13 = n11;
                    continue;
                }
                ++n12;
                continue;
            }
            if (n14 == 0) break;
            n10 += -1;
        }
        return charSequence.subSequence(n12, n10 += n11);
    }

    private static final boolean r3(CharSequence charSequence) {
        boolean bl2;
        if (charSequence != null && !(bl2 = u.S1(charSequence))) {
            bl2 = false;
            charSequence = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    public static /* synthetic */ String r4(String string2, char c10, String string3, String string4, int n10, Object object) {
        if ((n10 &= 4) != 0) {
            string4 = string2;
        }
        return StringsKt__StringsKt.p4(string2, c10, string3, string4);
    }

    public static final CharSequence r5(CharSequence charSequence, char ... cArray) {
        f0.p(charSequence, "$this$trim");
        String string2 = "chars";
        f0.p(cArray, string2);
        int n10 = charSequence.length();
        int n11 = 1;
        n10 -= n11;
        int n12 = 0;
        int n13 = 0;
        while (n12 <= n10) {
            int n14 = n13 == 0 ? n12 : n10;
            n14 = charSequence.charAt(n14);
            n14 = (int)(ArraysKt___ArraysKt.K7(cArray, (char)n14) ? 1 : 0);
            if (n13 == 0) {
                if (n14 == 0) {
                    n13 = n11;
                    continue;
                }
                ++n12;
                continue;
            }
            if (n14 == 0) break;
            n10 += -1;
        }
        return charSequence.subSequence(n12, n10 += n11);
    }

    private static final boolean s3(CharSequence charSequence) {
        boolean bl2;
        if (charSequence != null && (bl2 = charSequence.length())) {
            bl2 = false;
            charSequence = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    public static /* synthetic */ String s4(String string2, String string3, String string4, String string5, int n10, Object object) {
        if ((n10 &= 4) != 0) {
            string5 = string2;
        }
        return StringsKt__StringsKt.q4(string2, string3, string4, string5);
    }

    private static final String s5(String string2) {
        Objects.requireNonNull(string2, "null cannot be cast to non-null type kotlin.CharSequence");
        return ((Object)StringsKt__StringsKt.p5(string2)).toString();
    }

    public static final r t3(CharSequence charSequence) {
        f0.p(charSequence, "$this$iterator");
        StringsKt__StringsKt$a stringsKt__StringsKt$a = new StringsKt__StringsKt$a(charSequence);
        return stringsKt__StringsKt$a;
    }

    public static final String t4(String charSequence, char c10, String string2, String string3) {
        f0.p(charSequence, "$this$replaceBeforeLast");
        f0.p(string2, "replacement");
        String string4 = "missingDelimiterValue";
        f0.p(string3, string4);
        int n10 = 6;
        c10 = (char)StringsKt__StringsKt.w3(charSequence, c10, 0, false, n10, null);
        char c11 = '\uffffffff';
        if (c10 != c11) {
            charSequence = StringsKt__StringsKt.y4(charSequence, 0, c10, string2);
            string3 = charSequence.toString();
        }
        return string3;
    }

    public static final String t5(String string2, l l10) {
        f0.p(string2, "$this$trim");
        String string3 = "predicate";
        f0.p(l10, string3);
        int n10 = string2.length();
        int n11 = 1;
        n10 -= n11;
        int n12 = 0;
        int n13 = 0;
        while (n12 <= n10) {
            int n14 = n13 == 0 ? n12 : n10;
            Comparable<Character> comparable = Character.valueOf(string2.charAt(n14));
            comparable = (Boolean)l10.invoke(comparable);
            n14 = (int)(((Boolean)comparable).booleanValue() ? 1 : 0);
            if (n13 == 0) {
                if (n14 == 0) {
                    n13 = n11;
                    continue;
                }
                ++n12;
                continue;
            }
            if (n14 == 0) break;
            n10 += -1;
        }
        return ((Object)string2.subSequence(n12, n10 += n11)).toString();
    }

    public static final int u3(CharSequence charSequence, char c10, int n10, boolean bl2) {
        int n11;
        int n12;
        Object object = "$this$lastIndexOf";
        f0.p(charSequence, (String)object);
        if (!bl2 && (n12 = charSequence instanceof String) != 0) {
            charSequence = (String)charSequence;
            n11 = ((String)charSequence).lastIndexOf(c10, n10);
        } else {
            n12 = 1;
            object = new char[n12];
            object[0] = c10;
            n11 = StringsKt__StringsKt.z3(charSequence, (char[])object, n10, bl2);
        }
        return n11;
    }

    public static final String u4(String charSequence, String string2, String string3, String string4) {
        f0.p(charSequence, "$this$replaceBeforeLast");
        f0.p(string2, "delimiter");
        f0.p(string3, "replacement");
        String string5 = "missingDelimiterValue";
        f0.p(string4, string5);
        int n10 = 6;
        int n11 = StringsKt__StringsKt.x3(charSequence, string2, 0, false, n10, null);
        int n12 = -1;
        if (n11 != n12) {
            charSequence = StringsKt__StringsKt.y4(charSequence, 0, n11, string3);
            string4 = charSequence.toString();
        }
        return string4;
    }

    public static final String u5(String string2, char ... cArray) {
        f0.p(string2, "$this$trim");
        String string3 = "chars";
        f0.p(cArray, string3);
        int n10 = string2.length();
        int n11 = 1;
        n10 -= n11;
        int n12 = 0;
        int n13 = 0;
        while (n12 <= n10) {
            int n14 = n13 == 0 ? n12 : n10;
            n14 = string2.charAt(n14);
            n14 = (int)(ArraysKt___ArraysKt.K7(cArray, (char)n14) ? 1 : 0);
            if (n13 == 0) {
                if (n14 == 0) {
                    n13 = n11;
                    continue;
                }
                ++n12;
                continue;
            }
            if (n14 == 0) break;
            n10 += -1;
        }
        return ((Object)string2.subSequence(n12, n10 += n11)).toString();
    }

    public static final int v3(CharSequence charSequence, String string2, int n10, boolean bl2) {
        int n11;
        boolean bl3;
        f0.p(charSequence, "$this$lastIndexOf");
        CharSequence charSequence2 = "string";
        f0.p(string2, charSequence2);
        if (!bl2 && (bl3 = charSequence instanceof String)) {
            charSequence = (String)charSequence;
            n11 = ((String)charSequence).lastIndexOf(string2, n10);
        } else {
            boolean bl4 = true;
            charSequence2 = charSequence;
            n11 = StringsKt__StringsKt.g3(charSequence, string2, n10, 0, bl2, bl4);
        }
        return n11;
    }

    public static /* synthetic */ String v4(String string2, char c10, String string3, String string4, int n10, Object object) {
        if ((n10 &= 4) != 0) {
            string4 = string2;
        }
        return StringsKt__StringsKt.t4(string2, c10, string3, string4);
    }

    public static final CharSequence v5(CharSequence charSequence) {
        block1: {
            String string2 = "$this$trimEnd";
            f0.p(charSequence, string2);
            int n10 = charSequence.length();
            while ((n10 += -1) >= 0) {
                boolean bl2 = b.r(charSequence.charAt(n10));
                if (bl2) continue;
                bl2 = false;
                charSequence = charSequence.subSequence(0, ++n10);
                break block1;
            }
            charSequence = "";
        }
        return charSequence;
    }

    public static /* synthetic */ int w3(CharSequence charSequence, char c10, int n10, boolean bl2, int n11, Object object) {
        int n12 = n11 & 2;
        if (n12 != 0) {
            n10 = StringsKt__StringsKt.a3(charSequence);
        }
        if ((n11 &= 4) != 0) {
            bl2 = false;
        }
        return StringsKt__StringsKt.u3(charSequence, c10, n10, bl2);
    }

    public static /* synthetic */ String w4(String string2, String string3, String string4, String string5, int n10, Object object) {
        if ((n10 &= 4) != 0) {
            string5 = string2;
        }
        return StringsKt__StringsKt.u4(string2, string3, string4, string5);
    }

    public static final CharSequence w5(CharSequence charSequence, l l10) {
        f0.p(charSequence, "$this$trimEnd");
        String string2 = "predicate";
        f0.p(l10, string2);
        int n10 = charSequence.length();
        while ((n10 += -1) >= 0) {
            Comparable<Character> comparable = Character.valueOf(charSequence.charAt(n10));
            boolean bl2 = (Boolean)(comparable = (Boolean)l10.invoke(comparable));
            if (bl2) continue;
            return charSequence.subSequence(0, ++n10);
        }
        return "";
    }

    public static /* synthetic */ int x3(CharSequence charSequence, String string2, int n10, boolean bl2, int n11, Object object) {
        int n12 = n11 & 2;
        if (n12 != 0) {
            n10 = StringsKt__StringsKt.a3(charSequence);
        }
        if ((n11 &= 4) != 0) {
            bl2 = false;
        }
        return StringsKt__StringsKt.v3(charSequence, string2, n10, bl2);
    }

    private static final String x4(CharSequence charSequence, Regex regex, String string2) {
        return regex.replaceFirst(charSequence, string2);
    }

    public static final CharSequence x5(CharSequence charSequence, char ... cArray) {
        block1: {
            f0.p(charSequence, "$this$trimEnd");
            String string2 = "chars";
            f0.p(cArray, string2);
            int n10 = charSequence.length();
            while ((n10 += -1) >= 0) {
                char c10 = charSequence.charAt(n10);
                if ((c10 = (char)(ArraysKt___ArraysKt.K7(cArray, c10) ? 1 : 0)) != '\u0000') continue;
                cArray = null;
                charSequence = charSequence.subSequence(0, ++n10);
                break block1;
            }
            charSequence = "";
        }
        return charSequence;
    }

    public static final int y3(CharSequence object, Collection collection, int n10, boolean bl2) {
        f0.p(object, "$this$lastIndexOfAny");
        String string2 = "strings";
        f0.p(collection, string2);
        boolean bl3 = true;
        object = StringsKt__StringsKt.V2((CharSequence)object, collection, n10, bl2, bl3);
        int n11 = object != null && (object = (Integer)((Pair)object).getFirst()) != null ? (Integer)object : -1;
        return n11;
    }

    public static final CharSequence y4(CharSequence object, int n10, int n11, CharSequence charSequence) {
        f0.p(object, "$this$replaceRange");
        CharSequence charSequence2 = "replacement";
        f0.p(charSequence, (String)charSequence2);
        if (n11 >= n10) {
            charSequence2 = new StringBuilder();
            ((StringBuilder)charSequence2).append((CharSequence)object, 0, n10);
            String string2 = "this.append(value, startIndex, endIndex)";
            f0.o(charSequence2, string2);
            ((StringBuilder)charSequence2).append(charSequence);
            int n12 = object.length();
            ((StringBuilder)charSequence2).append((CharSequence)object, n11, n12);
            f0.o(charSequence2, string2);
            return charSequence2;
        }
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("End index (");
        ((StringBuilder)charSequence).append(n11);
        ((StringBuilder)charSequence).append(") is less than start index (");
        ((StringBuilder)charSequence).append(n10);
        ((StringBuilder)charSequence).append(").");
        String string3 = ((StringBuilder)charSequence).toString();
        object = new IndexOutOfBoundsException(string3);
        throw object;
    }

    private static final String y5(String string2) {
        Objects.requireNonNull(string2, "null cannot be cast to non-null type kotlin.CharSequence");
        return ((Object)StringsKt__StringsKt.v5(string2)).toString();
    }

    public static final int z3(CharSequence charSequence, char[] cArray, int n10, boolean bl2) {
        char c10;
        f0.p(charSequence, "$this$lastIndexOfAny");
        String string2 = "chars";
        f0.p(cArray, string2);
        char c11 = '\u0001';
        if (!bl2 && (c10 = cArray.length) == c11 && (c10 = charSequence instanceof String) != '\u0000') {
            char c12 = ArraysKt___ArraysKt.Is(cArray);
            return ((String)charSequence).lastIndexOf(c12, n10);
        }
        c10 = StringsKt__StringsKt.a3(charSequence);
        for (n10 = q.u(n10, c10); n10 >= 0; n10 += -1) {
            c10 = charSequence.charAt(n10);
            int n11 = cArray.length;
            char c13 = '\u0000';
            for (int i10 = 0; i10 < n11; ++i10) {
                boolean bl3 = c.v(cArray[i10], c10, bl2);
                if (!bl3) continue;
                c13 = c11;
                break;
            }
            if (c13 == '\u0000') continue;
            return n10;
        }
        return -1;
    }

    public static final CharSequence z4(CharSequence charSequence, k k10, CharSequence charSequence2) {
        f0.p(charSequence, "$this$replaceRange");
        f0.p(k10, "range");
        f0.p(charSequence2, "replacement");
        int n10 = k10.l();
        int n11 = k10.k() + 1;
        return StringsKt__StringsKt.y4(charSequence, n10, n11, charSequence2);
    }

    public static final String z5(String charSequence, l l10) {
        block1: {
            f0.p(charSequence, "$this$trimEnd");
            String string2 = "predicate";
            f0.p(l10, string2);
            int n10 = charSequence.length();
            while ((n10 += -1) >= 0) {
                Comparable<Character> comparable = Character.valueOf(charSequence.charAt(n10));
                boolean bl2 = (Boolean)(comparable = (Boolean)l10.invoke(comparable));
                if (bl2) continue;
                l10 = null;
                charSequence = charSequence.subSequence(0, ++n10);
                break block1;
            }
            charSequence = "";
        }
        return charSequence.toString();
    }
}

