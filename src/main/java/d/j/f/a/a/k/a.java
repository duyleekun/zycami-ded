/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  android.util.Log
 */
package d.j.f.a.a.k;

import android.text.TextUtils;
import android.util.Log;
import d.j.f.a.a.k.m;
import java.util.Locale;

public class a {
    private static final String a = "a";
    private static final char[] b;
    private static final String[] c;

    static {
        char c10;
        char[] cArray;
        char[] cArray2 = cArray = new char[3];
        cArray[0] = 44;
        cArray2[1] = 46;
        cArray2[2] = 45;
        b = cArray;
        c = new String[256];
        cArray = null;
        for (char c11 = '\u0000'; c11 < (c10 = '\u00ff'); c11 = (char)(c11 + '\u0001')) {
            String string2;
            String[] stringArray;
            c10 = '0';
            if (c11 >= c10 && c11 <= (c10 = '9') || c11 >= (c10 = 'A') && c11 <= (c10 = 'Z') || c11 >= (c10 = 'a') && c11 <= (c10 = 'z')) {
                stringArray = c;
                string2 = null;
                stringArray[c11] = null;
                continue;
            }
            stringArray = c;
            stringArray[c11] = string2 = d.j.f.a.a.k.a.f(c11).intern();
        }
    }

    private static Character a(m m10) {
        Character c10;
        block38: {
            int n10;
            int n11;
            m10.j();
            c10 = m10.c();
            if (c10 == null) {
                m10.m();
                return null;
            }
            int n12 = c10.charValue();
            if (n12 != (n11 = 92)) {
                m10.m();
                return null;
            }
            c10 = m10.c();
            if (c10 == null) {
                m10.m();
                return null;
            }
            int n13 = c10.charValue();
            int n14 = 98;
            char c11 = '\b';
            if (n13 == n14) {
                return Character.valueOf(c11);
            }
            n13 = c10.charValue();
            if (n13 == (n14 = 116)) {
                return Character.valueOf('\t');
            }
            n13 = c10.charValue();
            if (n13 == (n14 = 110)) {
                return Character.valueOf('\n');
            }
            n13 = c10.charValue();
            if (n13 == (n14 = 118)) {
                return Character.valueOf('\u000b');
            }
            n13 = c10.charValue();
            if (n13 == (n14 = 102)) {
                return Character.valueOf('\f');
            }
            n13 = c10.charValue();
            if (n13 == (n14 = 114)) {
                return Character.valueOf('\r');
            }
            n13 = c10.charValue();
            if (n13 == (n14 = 34)) {
                return Character.valueOf((char)n14);
            }
            n13 = c10.charValue();
            if (n13 == (n14 = 39)) {
                return Character.valueOf((char)n14);
            }
            n13 = c10.charValue();
            if (n13 == n11) {
                return Character.valueOf((char)n11);
            }
            n11 = Character.toLowerCase(c10.charValue());
            n13 = 120;
            n14 = 16;
            if (n11 == n13) {
                CharSequence charSequence = new StringBuilder();
                for (n10 = 0; n10 < (n13 = 2); ++n10) {
                    Character c12 = m10.e();
                    if (c12 != null) {
                        ((StringBuilder)charSequence).append(c12);
                        continue;
                    }
                    m10.m();
                    return null;
                }
                try {
                    charSequence = ((StringBuilder)charSequence).toString();
                }
                catch (NumberFormatException numberFormatException) {
                    m10.m();
                    return null;
                }
                n11 = Integer.parseInt((String)charSequence, n14);
                n13 = (int)(Character.isValidCodePoint(n11) ? 1 : 0);
                if (n13 == 0) break block38;
                n12 = (char)n11;
                return Character.valueOf((char)n12);
            }
            n11 = Character.toLowerCase(c10.charValue());
            if (n11 == (n13 = 117)) {
                CharSequence charSequence = new StringBuilder();
                while (n10 < (n13 = 4)) {
                    Character c13 = m10.e();
                    if (c13 != null) {
                        ((StringBuilder)charSequence).append(c13);
                        ++n10;
                        continue;
                    }
                    m10.m();
                    return null;
                }
                try {
                    charSequence = ((StringBuilder)charSequence).toString();
                }
                catch (NumberFormatException numberFormatException) {
                    m10.m();
                    return null;
                }
                n11 = Integer.parseInt((String)charSequence, n14);
                n13 = (int)(Character.isValidCodePoint(n11) ? 1 : 0);
                if (n13 == 0) break block38;
                n12 = (char)n11;
                return Character.valueOf((char)n12);
            }
            n11 = (int)(m.g(c10) ? 1 : 0);
            if (n11 != 0) {
                CharSequence charSequence = new StringBuilder();
                ((StringBuilder)charSequence).append(c10);
                Character c14 = m10.c();
                n14 = (int)(m.g(c14) ? 1 : 0);
                if (n14 == 0) {
                    m10.b(c14);
                } else {
                    ((StringBuilder)charSequence).append(c14);
                    c14 = m10.c();
                    n14 = (int)(m.g(c14) ? 1 : 0);
                    if (n14 == 0) {
                        m10.b(c14);
                    } else {
                        ((StringBuilder)charSequence).append(c14);
                    }
                }
                try {
                    charSequence = ((StringBuilder)charSequence).toString();
                }
                catch (NumberFormatException numberFormatException) {
                    m10.m();
                    return null;
                }
                n11 = Integer.parseInt((String)charSequence, c11);
                n13 = (int)(Character.isValidCodePoint(n11) ? 1 : 0);
                if (n13 == 0) break block38;
                n12 = (char)n11;
                return Character.valueOf((char)n12);
            }
        }
        return c10;
    }

    private static String b(char c10) {
        char c11 = '\u00ff';
        if (c10 < c11) {
            return c[c10];
        }
        return d.j.f.a.a.k.a.f(c10);
    }

    private static String c(char[] object, Character comparable) {
        int n10 = ((Character)comparable).charValue();
        char c10 = d.j.f.a.a.k.a.e((char)n10, (char[])object);
        Object object2 = "";
        if (c10 != '\u0000') {
            object = new StringBuilder;
            ((StringBuilder)object)();
            ((StringBuilder)object).append((String)object2);
            ((StringBuilder)object).append(comparable);
            return ((StringBuilder)object).toString();
        }
        c10 = ((Character)comparable).charValue();
        object = d.j.f.a.a.k.a.b(c10);
        if (object == null) {
            object = new StringBuilder;
            ((StringBuilder)object)();
            ((StringBuilder)object).append((String)object2);
            ((StringBuilder)object).append(comparable);
            return ((StringBuilder)object).toString();
        }
        c10 = ((Character)comparable).charValue();
        object = Integer.toHexString(c10);
        int n11 = ((Character)comparable).charValue();
        if (n11 < (n10 = 256)) {
            comparable = new Comparable<Character>();
            ((StringBuilder)comparable).append("\\x");
            n10 = ((String)object).length();
            object2 = "00".substring(n10);
            ((StringBuilder)comparable).append((String)object2);
            object2 = Locale.ENGLISH;
            object = ((String)object).toUpperCase((Locale)object2);
            ((StringBuilder)comparable).append((String)object);
            return ((StringBuilder)comparable).toString();
        }
        comparable = new Comparable<Character>();
        ((StringBuilder)comparable).append("\\u");
        n10 = ((String)object).length();
        object2 = "0000".substring(n10);
        ((StringBuilder)comparable).append((String)object2);
        object2 = Locale.ENGLISH;
        object = ((String)object).toUpperCase((Locale)object2);
        ((StringBuilder)comparable).append((String)object);
        return ((StringBuilder)comparable).toString();
    }

    private static String d(char[] cArray, String string2) {
        int n10;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i10 = 0; i10 < (n10 = string2.length()); ++i10) {
            n10 = string2.charAt(i10);
            Object object = Character.valueOf((char)n10);
            object = d.j.f.a.a.k.a.c(cArray, (Character)object);
            stringBuilder.append((String)object);
        }
        return stringBuilder.toString();
    }

    private static boolean e(char c10, char[] cArray) {
        for (char c11 : cArray) {
            if (c10 != c11) continue;
            return true;
        }
        return false;
    }

    private static String f(char c10) {
        return Integer.toHexString(c10);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static String g(String object) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        String string2 = "";
        if (bl2) {
            return string2;
        }
        try {
            StringBuilder stringBuilder = new StringBuilder();
            m m10 = new m((String)object);
            while (true) {
                boolean bl3;
                if (!(bl3 = m10.l())) {
                    return stringBuilder.toString();
                }
                object = d.j.f.a.a.k.a.a(m10);
                if (object != null) {
                    stringBuilder.append(object);
                    continue;
                }
                object = m10.c();
                stringBuilder.append(object);
            }
        }
        catch (Exception exception) {
            String string3 = a;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("decode js: ");
            String string4 = exception.getMessage();
            stringBuilder.append(string4);
            string4 = stringBuilder.toString();
            Log.e((String)string3, (String)string4);
            return string2;
        }
    }

    public static String h(String string2) {
        char[] cArray = b;
        return d.j.f.a.a.k.a.i(string2, cArray);
    }

    public static String i(String string2, char[] object) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        String string3 = "";
        if (bl2) {
            return string3;
        }
        try {
            return d.j.f.a.a.k.a.d(object, string2);
        }
        catch (Exception exception) {
            object = a;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("encode js: ");
            String string4 = exception.getMessage();
            stringBuilder.append(string4);
            string4 = stringBuilder.toString();
            Log.e((String)object, (String)string4);
            return string3;
        }
    }
}

