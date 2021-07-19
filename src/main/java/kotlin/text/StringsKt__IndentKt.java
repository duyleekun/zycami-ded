/*
 * Decompiled with CFR 0.151.
 */
package kotlin.text;

import f.h2.s.l;
import f.h2.t.f0;
import f.n2.m;
import f.q2.b;
import f.q2.n;
import f.q2.u;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.sequences.SequencesKt___SequencesKt;
import kotlin.text.StringsKt__IndentKt$getIndentFunction$1;
import kotlin.text.StringsKt__IndentKt$getIndentFunction$2;
import kotlin.text.StringsKt__IndentKt$prependIndent$1;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.StringsKt___StringsKt;

public class StringsKt__IndentKt
extends n {
    private static final l g(String object) {
        StringsKt__IndentKt$getIndentFunction$2 stringsKt__IndentKt$getIndentFunction$2;
        int n10 = object.length();
        if (n10 == 0) {
            n10 = 1;
        } else {
            n10 = 0;
            stringsKt__IndentKt$getIndentFunction$2 = null;
        }
        if (n10 != 0) {
            object = StringsKt__IndentKt$getIndentFunction$1.INSTANCE;
        } else {
            stringsKt__IndentKt$getIndentFunction$2 = new StringsKt__IndentKt$getIndentFunction$2((String)object);
            object = stringsKt__IndentKt$getIndentFunction$2;
        }
        return object;
    }

    private static final int h(String string2) {
        int n10;
        int n11;
        block3: {
            int n12 = string2.length();
            n11 = 0;
            while (true) {
                n10 = -1;
                if (n11 >= n12) break;
                boolean bl2 = b.r(string2.charAt(n11)) ^ true;
                if (!bl2) {
                    ++n11;
                    continue;
                }
                break block3;
                break;
            }
            n11 = n10;
        }
        if (n11 == n10) {
            n11 = string2.length();
        }
        return n11;
    }

    public static final String i(String object, String string2) {
        f0.p(object, "$this$prependIndent");
        f0.p(string2, "indent");
        object = StringsKt__StringsKt.C3((CharSequence)object);
        StringsKt__IndentKt$prependIndent$1 stringsKt__IndentKt$prependIndent$1 = new StringsKt__IndentKt$prependIndent$1(string2);
        return SequencesKt___SequencesKt.V0(SequencesKt___SequencesKt.b1((m)object, stringsKt__IndentKt$prependIndent$1), "\n", null, null, 0, null, null, 62, null);
    }

    public static /* synthetic */ String j(String string2, String string3, int n10, Object object) {
        if ((n10 &= 1) != 0) {
            string3 = "    ";
        }
        return StringsKt__IndentKt.i(string2, string3);
    }

    private static final String k(List object, int n10, l l10, l l11) {
        boolean bl2;
        int n11 = CollectionsKt__CollectionsKt.G((List)object);
        ArrayList arrayList = new ArrayList();
        object = object.iterator();
        StringBuilder stringBuilder = null;
        int n12 = 0;
        String string2 = null;
        while (bl2 = object.hasNext()) {
            Object object2 = object.next();
            int n13 = n12 + 1;
            if (n12 < 0) {
                int n14 = 1;
                boolean bl3 = f.d2.l.a(n14, 3, 0);
                if (bl3) {
                    CollectionsKt__CollectionsKt.W();
                } else {
                    object = new ArithmeticException("Index overflow has happened.");
                    throw object;
                }
            }
            object2 = (String)object2;
            if ((n12 == 0 || n12 == n11) && (n12 = (int)(u.S1(object2) ? 1 : 0)) != 0) {
                bl2 = false;
                object2 = null;
            } else {
                string2 = (String)l11.invoke(object2);
                if (string2 != null && (string2 = (String)l10.invoke(string2)) != null) {
                    object2 = string2;
                }
            }
            if (object2 != null) {
                arrayList.add(object2);
            }
            n12 = n13;
        }
        stringBuilder = new StringBuilder(n10);
        object = ((StringBuilder)CollectionsKt___CollectionsKt.V2(arrayList, stringBuilder, "\n", null, null, 0, null, null, 124, null)).toString();
        f0.o(object, "mapIndexedNotNull { inde\u2026\"\\n\")\n        .toString()");
        return object;
    }

    public static final String l(String string2, String object) {
        Object object2;
        boolean bl2;
        int n10;
        int n11;
        Object object3;
        Object object4;
        int n12;
        f0.p(string2, "$this$replaceIndent");
        f0.p(object, "newIndent");
        Object object5 = StringsKt__StringsKt.D3(string2);
        Object object6 = new ArrayList();
        Object object7 = object5.iterator();
        while ((n12 = object7.hasNext()) != 0) {
            object4 = object7.next();
            object3 = object4;
            object3 = (String)object4;
            n11 = u.S1(object3) ^ 1;
            if (n11 == 0) continue;
            object6.add(object4);
        }
        n12 = f.x1.u.Y(object6, 10);
        object7 = new ArrayList(n12);
        object6 = object6.iterator();
        while ((n12 = (int)(object6.hasNext() ? 1 : 0)) != 0) {
            n12 = StringsKt__IndentKt.h((String)object6.next());
            object4 = n12;
            object7.add(object4);
        }
        object6 = (Integer)CollectionsKt___CollectionsKt.V3(object7);
        int n13 = 0;
        object7 = null;
        if (object6 != null) {
            n10 = (Integer)object6;
        } else {
            n10 = 0;
            object6 = null;
        }
        int n14 = string2.length();
        n12 = ((String)object).length();
        n11 = object5.size();
        n14 += (n12 *= n11);
        object = StringsKt__IndentKt.g((String)object);
        n12 = CollectionsKt__CollectionsKt.G((List)object5);
        object3 = new ArrayList();
        object5 = object5.iterator();
        while (bl2 = object5.hasNext()) {
            object2 = object5.next();
            int n15 = n13 + 1;
            if (n13 < 0) {
                CollectionsKt__CollectionsKt.W();
            }
            object2 = (String)object2;
            if ((n13 == 0 || n13 == n12) && (n13 = (int)(u.S1((CharSequence)object2) ? 1 : 0)) != 0) {
                bl2 = false;
                object2 = null;
            } else {
                object7 = StringsKt___StringsKt.f6((String)object2, n10);
                if (object7 != null && (object7 = (String)object.invoke(object7)) != null) {
                    object2 = object7;
                }
            }
            if (object2 != null) {
                object3.add((StringBuilder)object2);
            }
            n13 = n15;
        }
        object2 = new StringBuilder(n14);
        string2 = ((StringBuilder)CollectionsKt___CollectionsKt.V2(object3, (Appendable)object2, "\n", null, null, 0, null, null, 124, null)).toString();
        f0.o(string2, "mapIndexedNotNull { inde\u2026\"\\n\")\n        .toString()");
        return string2;
    }

    public static /* synthetic */ String m(String string2, String string3, int n10, Object object) {
        if ((n10 &= 1) != 0) {
            string3 = "";
        }
        return StringsKt__IndentKt.l(string2, string3);
    }

    public static final String n(String string2, String string3, String string4) {
        String string5 = string2;
        f0.p(string2, "$this$replaceIndentByMargin");
        String string6 = string3;
        f0.p(string3, "newIndent");
        Object object = "marginPrefix";
        f0.p(string4, (String)object);
        boolean bl2 = u.S1(string4) ^ true;
        if (bl2) {
            int n10;
            object = StringsKt__StringsKt.D3(string2);
            int n11 = string2.length();
            int n12 = string3.length();
            int n13 = object.size();
            int n14 = n11 + (n12 *= n13);
            l l10 = StringsKt__IndentKt.g(string3);
            int n15 = CollectionsKt__CollectionsKt.G((List)object);
            ArrayList<String> arrayList = new ArrayList<String>();
            object = object.iterator();
            StringBuilder stringBuilder = null;
            n11 = 0;
            string5 = null;
            while ((n10 = object.hasNext()) != 0) {
                string6 = object.next();
                int n16 = n11 + 1;
                if (n11 < 0) {
                    CollectionsKt__CollectionsKt.W();
                }
                String string7 = string6;
                string7 = string6;
                String string8 = null;
                if ((n11 == 0 || n11 == n15) && (n11 = (int)(u.S1(string7) ? 1 : 0)) != 0) {
                    string7 = null;
                } else {
                    int n17;
                    block11: {
                        n11 = string7.length();
                        n10 = 0;
                        string6 = null;
                        while (true) {
                            n12 = -1;
                            if (n10 >= n11) break;
                            n13 = b.r(string7.charAt(n10)) ^ 1;
                            if (n13 != 0) {
                                n17 = n10;
                                break block11;
                            }
                            ++n10;
                        }
                        n17 = n12;
                    }
                    if (n17 != n12) {
                        n13 = 0;
                        int n18 = 4;
                        string5 = string7;
                        string6 = string4;
                        n12 = n17;
                        n17 = 0;
                        n11 = (int)(u.p2(string7, string4, n12, false, n18, null) ? 1 : 0);
                        if (n11 != 0) {
                            n11 = string4.length();
                            n17 = n12 + n11;
                            Objects.requireNonNull(string7, "null cannot be cast to non-null type java.lang.String");
                            string8 = string7.substring(n17);
                            string5 = "(this as java.lang.String).substring(startIndex)";
                            f0.o(string8, string5);
                        }
                    }
                    if (string8 != null && (string5 = (String)l10.invoke(string8)) != null) {
                        string7 = string5;
                    }
                }
                if (string7 != null) {
                    arrayList.add(string7);
                }
                n11 = n16;
            }
            stringBuilder = new StringBuilder(n14);
            object = ((StringBuilder)CollectionsKt___CollectionsKt.V2(arrayList, stringBuilder, "\n", null, null, 0, null, null, 124, null)).toString();
            f0.o(object, "mapIndexedNotNull { inde\u2026\"\\n\")\n        .toString()");
            return object;
        }
        string5 = "marginPrefix must be non-blank string.".toString();
        object = new IllegalArgumentException(string5);
        throw object;
    }

    public static /* synthetic */ String o(String string2, String string3, String string4, int n10, Object object) {
        int n11 = n10 & 1;
        if (n11 != 0) {
            string3 = "";
        }
        if ((n10 &= 2) != 0) {
            string4 = "|";
        }
        return StringsKt__IndentKt.n(string2, string3, string4);
    }

    public static final String p(String string2) {
        f0.p(string2, "$this$trimIndent");
        return StringsKt__IndentKt.l(string2, "");
    }

    public static final String q(String string2, String string3) {
        f0.p(string2, "$this$trimMargin");
        f0.p(string3, "marginPrefix");
        return StringsKt__IndentKt.n(string2, "", string3);
    }

    public static /* synthetic */ String r(String string2, String string3, int n10, Object object) {
        if ((n10 &= 1) != 0) {
            string3 = "|";
        }
        return StringsKt__IndentKt.q(string2, string3);
    }
}

