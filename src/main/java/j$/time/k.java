/*
 * Decompiled with CFR 0.151.
 */
package j$.time;

import j$.time.l;
import j$.time.m;
import j$.time.r.c;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public abstract class k
implements Serializable {
    public static final Map a;

    static {
        HashMap<String, String> hashMap = new HashMap<String, String>(64);
        hashMap.put("ACT", "Australia/Darwin");
        hashMap.put("AET", "Australia/Sydney");
        hashMap.put("AGT", "America/Argentina/Buenos_Aires");
        hashMap.put("ART", "Africa/Cairo");
        hashMap.put("AST", "America/Anchorage");
        hashMap.put("BET", "America/Sao_Paulo");
        hashMap.put("BST", "Asia/Dhaka");
        hashMap.put("CAT", "Africa/Harare");
        hashMap.put("CNT", "America/St_Johns");
        hashMap.put("CST", "America/Chicago");
        hashMap.put("CTT", "Asia/Shanghai");
        hashMap.put("EAT", "Africa/Addis_Ababa");
        hashMap.put("ECT", "Europe/Paris");
        hashMap.put("IET", "America/Indiana/Indianapolis");
        hashMap.put("IST", "Asia/Kolkata");
        hashMap.put("JST", "Asia/Tokyo");
        hashMap.put("MIT", "Pacific/Apia");
        hashMap.put("NET", "Asia/Yerevan");
        hashMap.put("NST", "Pacific/Auckland");
        hashMap.put("PLT", "Asia/Karachi");
        hashMap.put("PNT", "America/Phoenix");
        hashMap.put("PRT", "America/Puerto_Rico");
        hashMap.put("PST", "America/Los_Angeles");
        hashMap.put("SST", "Pacific/Guadalcanal");
        hashMap.put("VST", "Asia/Ho_Chi_Minh");
        hashMap.put("EST", "-05:00");
        hashMap.put("MST", "-07:00");
        hashMap.put("HST", "-10:00");
        a = Collections.unmodifiableMap(hashMap);
    }

    k() {
        Object object = this.getClass();
        Class clazz = l.class;
        if (object != clazz && (object = this.getClass()) != (clazz = m.class)) {
            object = new AssertionError((Object)"Invalid subclass");
            throw object;
        }
    }

    /*
     * WARNING - void declaration
     */
    public static k n(String object, Map object2) {
        block5: {
            block1: {
                void var3_11;
                boolean bl2;
                block4: {
                    block2: {
                        block3: {
                            boolean bl3;
                            boolean bl4;
                            boolean bl5;
                            boolean bl32;
                            Objects.requireNonNull(object, "zoneId");
                            String string2 = "aliasMap";
                            Objects.requireNonNull(object2, string2);
                            object2 = (String)object2.get(object);
                            if (object2 != null) {
                                object = object2;
                            }
                            if ((bl32 = ((String)object).length()) <= (bl2 = true) || (bl5 = ((String)object).startsWith((String)(object2 = "+"))) || (bl4 = ((String)object).startsWith((String)(object2 = "-")))) break block1;
                            object2 = "UTC";
                            boolean bl6 = ((String)object).startsWith((String)object2);
                            if (bl6 || (bl3 = ((String)object).startsWith((String)(object2 = "GMT")))) break block2;
                            object2 = "UT";
                            boolean bl7 = ((String)object).startsWith((String)object2);
                            if (!bl7) break block3;
                            int n10 = 2;
                            break block4;
                        }
                        object = m.C((String)object, bl2);
                        break block5;
                    }
                    int n11 = 3;
                }
                object = k.x((String)object, (int)var3_11, bl2);
                break block5;
            }
            object = l.D((String)object);
        }
        return object;
    }

    public static k o(String string2, l serializable) {
        Objects.requireNonNull(string2, "prefix");
        Object object = "offset";
        Objects.requireNonNull(serializable, (String)object);
        int n10 = string2.length();
        if (n10 == 0) {
            return serializable;
        }
        object = "GMT";
        n10 = (int)(string2.equals(object) ? 1 : 0);
        if (n10 == 0 && (n10 = (int)(string2.equals(object = "UTC") ? 1 : 0)) == 0 && (n10 = (int)(string2.equals(object = "UT") ? 1 : 0)) == 0) {
            object = new StringBuilder();
            ((StringBuilder)object).append("prefix should be GMT, UTC or UT, is: ");
            ((StringBuilder)object).append(string2);
            string2 = ((StringBuilder)object).toString();
            serializable = new IllegalArgumentException(string2);
            throw serializable;
        }
        n10 = serializable.C();
        if (n10 != 0) {
            object = serializable.q();
            string2 = string2.concat((String)object);
        }
        serializable = c.j(serializable);
        object = new m(string2, (c)serializable);
        return object;
    }

    private static k x(String object, int n10, boolean bl2) {
        Object object2;
        CharSequence charSequence;
        block8: {
            Serializable serializable;
            int n11;
            charSequence = ((String)object).substring(0, n10);
            int n12 = ((String)object).length();
            if (n12 == n10) {
                object = l.f;
                return k.o((String)charSequence, (l)object);
            }
            n12 = ((String)object).charAt(n10);
            if (n12 != (n11 = 43) && (n12 = (int)((String)object).charAt(n10)) != (n11 = 45)) {
                return m.C((String)object, bl2);
            }
            try {
                object2 = ((String)object).substring(n10);
            }
            catch (j$.time.c c10) {
                charSequence = new StringBuilder();
                ((StringBuilder)charSequence).append("Invalid ID for offset-based ZoneId: ");
                ((StringBuilder)charSequence).append((String)object);
                object = ((StringBuilder)charSequence).toString();
                serializable = new j$.time.c((String)object, c10);
                throw serializable;
            }
            object2 = l.D((String)object2);
            serializable = l.f;
            if (object2 != serializable) break block8;
            return k.o((String)charSequence, (l)object2);
        }
        return k.o((String)charSequence, (l)object2);
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        boolean bl2 = object instanceof k;
        if (bl2) {
            object = (k)object;
            String string2 = this.q();
            object = ((k)object).q();
            return string2.equals(object);
        }
        return false;
    }

    public int hashCode() {
        return this.q().hashCode();
    }

    public abstract c m();

    public abstract String q();

    public String toString() {
        return this.q();
    }
}

