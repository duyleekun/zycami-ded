/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  android.util.Log
 */
package d.j.f.a.a.f;

import android.text.TextUtils;
import android.util.Log;
import d.j.f.a.a.f.b;

public class a {
    private static final String a = "a";

    public static String a(String string2) {
        int n10;
        if (string2 != null && (n10 = string2.length()) > 0) {
            int n11;
            int n12;
            n10 = string2.length();
            if (n10 <= (n12 = 1)) {
                return "*";
            }
            n10 = string2.length();
            if (n10 < (n11 = 8)) {
                return d.j.f.a.a.f.a.d(string2, 0, n12);
            }
            return d.j.f.a.a.f.a.d(string2, 0, 4);
        }
        return "";
    }

    public static String b(String string2) {
        int n10;
        if (string2 != null && (n10 = string2.length()) > 0) {
            int n11;
            n10 = string2.length();
            if (n10 <= (n11 = 2)) {
                return b.k(string2, '*');
            }
            n10 = string2.length();
            n11 = 11;
            int n12 = 4;
            if (n10 >= n11 && (n10 = string2.length()) < (n11 = 20)) {
                return d.j.f.a.a.f.a.d(string2, n12, n12);
            }
            return d.j.f.a.a.f.a.d(string2, 6, n12);
        }
        return "";
    }

    public static String c(String object) {
        int n10;
        String string2 = "";
        if (object != null && (n10 = object.length()) > 0) {
            String string3;
            int n11;
            n10 = object.length();
            if (n10 <= (n11 = 4)) {
                return b.k((String)object, '*');
            }
            object = b.m((String)object, n11);
            String[] stringArray = new String[2];
            stringArray[0] = string3 = b.c(object, 0);
            n11 = 1;
            stringArray[n11] = object = b.b(b.c(object, n11), "0123456789", "*");
            return b.l(string2, stringArray);
        }
        return string2;
    }

    public static String d(String object, int n10, int n11) {
        int n12;
        String string2 = "";
        if (object != null && (n12 = object.length()) > 0) {
            String string3;
            String[] stringArray;
            n12 = 0;
            if (n10 < 0) {
                n10 = 0;
                stringArray = null;
            }
            if (n11 < 0) {
                n11 = 0;
                string3 = null;
            }
            int n13 = object.length();
            int n14 = n10 + n11;
            int n15 = 1;
            if (n13 <= n14) {
                n11 = object.length() - n15;
                n10 = n15;
            } else {
                n13 = object.length();
                n11 = n13 - n11;
            }
            object = b.e((String)object, n10, n11);
            stringArray = new String[3];
            stringArray[0] = string3 = b.c(object, 0);
            stringArray[n15] = string3 = b.k(b.c(object, n15), '*');
            n11 = 2;
            stringArray[n11] = object = b.c(object, n11);
            return b.l(string2, stringArray);
        }
        return string2;
    }

    public static String e(String object) {
        int n10;
        String string2 = "";
        if (object != null && (n10 = object.length()) > 0) {
            String string3;
            String string4;
            int n11;
            n10 = object.length();
            if (n10 <= (n11 = 1)) {
                return "*";
            }
            n10 = object.indexOf(64);
            int n12 = 2;
            char c10 = '*';
            String string5 = null;
            if (n10 < 0) {
                String string6;
                object = b.m((String)object, n11);
                String[] stringArray = new String[n12];
                stringArray[0] = string6 = b.c(object, 0);
                stringArray[n11] = object = b.k(b.c(object, n11), c10);
                return b.l(string2, stringArray);
            }
            int n13 = object.lastIndexOf(46);
            int n14 = n10 + 1;
            object = b.f((String)object, n10, n14, n13);
            String[] stringArray = new String[4];
            stringArray[0] = string4 = b.k(b.c(object, 0), c10);
            stringArray[n11] = string5 = b.c(object, n11);
            stringArray[n12] = string3 = b.k(b.c(object, n12), c10);
            n11 = 3;
            stringArray[n11] = object = b.c(object, n11);
            return b.l(string2, stringArray);
        }
        return string2;
    }

    public static String f(String string2) {
        int n10;
        if (string2 != null && (n10 = string2.length()) > 0) {
            n10 = string2.length() + -12;
            return d.j.f.a.a.f.a.d(string2, n10, 0);
        }
        return "";
    }

    public static String g(String string2) {
        int n10;
        if (string2 != null && (n10 = string2.length()) > 0) {
            n10 = string2.length() + -4;
            return d.j.f.a.a.f.a.d(string2, n10, 0);
        }
        return "";
    }

    public static String h(String object) {
        int n10;
        String string2 = "";
        if (object != null && (n10 = object.length()) > 0) {
            String string3;
            n10 = object.lastIndexOf(46);
            char c10 = '*';
            if (n10 < 0) {
                return b.k((String)object, c10);
            }
            int n11 = 1;
            object = b.m((String)object, n10 += n11);
            String[] stringArray = new String[2];
            stringArray[0] = string3 = b.c(object, 0);
            stringArray[n11] = object = b.k(b.c(object, n11), c10);
            return b.l(string2, stringArray);
        }
        return string2;
    }

    public static String i(String object) {
        int n10;
        String string2 = "";
        if (object != null && (n10 = object.length()) > 0) {
            int n11;
            n10 = 58;
            String[] stringArray = b.d((String)object, (char)n10);
            int n12 = stringArray.length;
            char c10 = '*';
            int n13 = 1;
            if (n12 <= n13) {
                return b.k((String)object, c10);
            }
            n12 = stringArray.length;
            int n14 = 8;
            int n15 = 2;
            if (n12 != n14) {
                String string3;
                n10 = object.indexOf(n10) + n13;
                object = b.m((String)object, n10);
                String[] stringArray2 = new String[n15];
                stringArray2[0] = string3 = b.c(object, 0);
                stringArray2[n13] = object = b.b(b.c(object, n13), "0123456789ABCDEFabcdef", "*");
                return b.l(string2, stringArray2);
            }
            object = d.j.f.a.a.f.a.j(stringArray[n15]);
            stringArray[n15] = object;
            for (int i10 = 3; i10 < (n11 = stringArray.length); ++i10) {
                stringArray[i10] = string2 = b.k(stringArray[i10], c10);
            }
            return b.l(":", stringArray);
        }
        return string2;
    }

    public static String j(String object) {
        String string2;
        int n10 = TextUtils.isEmpty((CharSequence)object);
        String string3 = "";
        if (n10 != 0) {
            Log.e((String)a, (String)"maskLower8Bit: s is null");
            return string3;
        }
        n10 = object.length();
        char c10 = '*';
        int n11 = 2;
        if (n10 <= n11) {
            return b.k((String)object, c10);
        }
        n10 = object.length() - n11;
        object = b.m((String)object, n10);
        String[] stringArray = new String[n11];
        stringArray[0] = string2 = b.c(object, 0);
        n11 = 1;
        stringArray[n11] = object = b.k(b.c(object, n11), c10);
        return b.l(string3, stringArray);
    }

    public static String k(String object) {
        int n10;
        String string2 = "";
        if (object != null && (n10 = object.length()) > 0) {
            String string3;
            int n11 = 2;
            n10 = b.a((String)object, '-', n11);
            String string4 = "*";
            String string5 = "0123456789ABCDEFabcdef";
            if (n10 < 0) {
                return b.b((String)object, string5, string4);
            }
            object = b.m((String)object, n10);
            String[] stringArray = new String[n11];
            stringArray[0] = string3 = b.c(object, 0);
            n11 = 1;
            stringArray[n11] = object = b.b(b.c(object, n11), string5, string4);
            return b.l(string2, stringArray);
        }
        return string2;
    }

    public static String l(String string2) {
        int n10;
        if (string2 != null && (n10 = string2.length()) > 0) {
            int n11;
            n10 = string2.length();
            if (n10 <= (n11 = 1)) {
                return "*";
            }
            return d.j.f.a.a.f.a.d(string2, n11, 0);
        }
        return "";
    }

    public static String m(String string2) {
        int n10;
        if (string2 != null && (n10 = string2.length()) > 0) {
            int n11;
            int n12;
            n10 = string2.length();
            if (n10 <= (n12 = 2)) {
                return b.k(string2, '*');
            }
            n10 = string2.length();
            if (n10 >= (n11 = 8) && (n10 = string2.length()) < (n11 = 11)) {
                return d.j.f.a.a.f.a.d(string2, n12, n12);
            }
            return d.j.f.a.a.f.a.d(string2, 3, 4);
        }
        return "";
    }
}

