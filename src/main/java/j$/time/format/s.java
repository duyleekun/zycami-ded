/*
 * Decompiled with CFR 0.151.
 */
package j$.time.format;

import j$.time.Instant;
import j$.time.format.C;
import j$.time.format.r;
import j$.time.format.v;
import j$.time.k;
import j$.time.l;
import j$.time.q.d;
import j$.time.q.g;
import j$.time.q.h;
import j$.time.q.u;
import j$.time.q.w;
import j$.time.r.c;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;

final class s
extends r {
    private static final Map d;
    private final C c;

    static {
        ConcurrentHashMap concurrentHashMap;
        d = concurrentHashMap = new ConcurrentHashMap();
    }

    s(C c10, Set object) {
        object = g.a;
        CharSequence charSequence = new StringBuilder();
        charSequence.append("ZoneText(");
        charSequence.append((Object)c10);
        charSequence.append(")");
        charSequence = charSequence.toString();
        super((w)object, (String)charSequence);
        new HashMap();
        new HashMap();
        Objects.requireNonNull(c10, "textStyle");
        this.c = c10;
    }

    public boolean m(v object, StringBuilder stringBuilder) {
        int n10;
        String string2;
        block10: {
            Object object2;
            block11: {
                int n11;
                int n12;
                String[] stringArray;
                int n13;
                block13: {
                    String string3;
                    String string4;
                    int n14;
                    Object object3;
                    String string5;
                    int n15;
                    block12: {
                        n13 = j$.time.q.v.a;
                        Object object4 = j$.time.q.d.a;
                        object4 = (k)((v)object).f((w)object4);
                        n15 = 0;
                        string5 = null;
                        if (object4 == null) {
                            return false;
                        }
                        string2 = ((k)object4).q();
                        boolean bl2 = object4 instanceof l;
                        n10 = 1;
                        if (bl2) break block10;
                        object3 = ((v)object).d();
                        stringArray = h.G;
                        n14 = object3.g((u)stringArray);
                        int n16 = 2;
                        if (n14 != 0) {
                            n13 = (int)(((c)(object4 = ((k)object4).m())).h((Instant)(object3 = Instant.o((j$.time.q.s)object3))) ? 1 : 0);
                            if (n13 != 0) {
                                n13 = n10;
                            } else {
                                n13 = 0;
                                object4 = null;
                            }
                        } else {
                            n13 = n16;
                        }
                        object = ((v)object).c();
                        object3 = this.c;
                        stringArray = C.f;
                        object2 = null;
                        if (object3 == stringArray) break block11;
                        object3 = d;
                        stringArray = (SoftReference)object3.get(string2);
                        n12 = 5;
                        n11 = 3;
                        if (stringArray == null) break block12;
                        object2 = stringArray = stringArray.get();
                        object2 = (Map)stringArray;
                        if (object2 != null && (stringArray = (String[])object2.get(object)) != null) break block13;
                    }
                    stringArray = TimeZone.getTimeZone(string2);
                    int n17 = 7;
                    String[] stringArray2 = new String[n17];
                    stringArray2[0] = string2;
                    stringArray2[n10] = string4 = stringArray.getDisplayName(false, n10, (Locale)object);
                    stringArray2[n16] = string4 = stringArray.getDisplayName(false, 0, (Locale)object);
                    stringArray2[n11] = string3 = stringArray.getDisplayName(n10 != 0, n10, (Locale)object);
                    string5 = stringArray.getDisplayName(n10 != 0, 0, (Locale)object);
                    n14 = 4;
                    stringArray2[n14] = string5;
                    stringArray2[n12] = string2;
                    n15 = 6;
                    stringArray2[n15] = string2;
                    if (object2 == null) {
                        object2 = new ConcurrentHashMap();
                    }
                    object2.put(object, stringArray2);
                    object = new SoftReference(object2);
                    object3.put(string2, object);
                    stringArray = stringArray2;
                }
                object = this.c;
                int n18 = ((C)((Object)object)).m();
                object2 = n13 != 0 ? (n13 != n10 ? stringArray[n18 += n12] : stringArray[n18 += n11]) : stringArray[n18 += n10];
            }
            if (object2 != null) {
                string2 = object2;
            }
        }
        stringBuilder.append(string2);
        return n10 != 0;
    }
}

