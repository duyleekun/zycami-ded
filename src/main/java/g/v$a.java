/*
 * Decompiled with CFR 0.151.
 */
package g;

import f.h2.t.f0;
import f.q2.u;
import g.v;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Objects;
import java.util.regex.Matcher;

public final class v$a {
    private v$a() {
    }

    public /* synthetic */ v$a(f.h2.t.u u10) {
        this();
    }

    public final v a(String string2) {
        f0.p(string2, "mediaType");
        return this.c(string2);
    }

    public final v b(String string2) {
        f0.p(string2, "mediaType");
        return this.d(string2);
    }

    public final v c(String string2) {
        f0.p(string2, "$this$toMediaType");
        Object object = v.d().matcher(string2);
        boolean n10 = ((Matcher)object).lookingAt();
        char c10 = '\"';
        if (n10) {
            String[] stringArray;
            String string3;
            String string4;
            String string5;
            ArrayList<Object> arrayList;
            block6: {
                int n11 = 1;
                arrayList = ((Matcher)object).group(n11);
                f0.o(arrayList, "typeSubtype.group(1)");
                Object object2 = Locale.US;
                String string6 = "Locale.US";
                f0.o(object2, string6);
                String string7 = "null cannot be cast to non-null type java.lang.String";
                Objects.requireNonNull(arrayList, string7);
                string5 = ((String)((Object)arrayList)).toLowerCase((Locale)object2);
                arrayList = "(this as java.lang.String).toLowerCase(locale)";
                f0.o(string5, (String)((Object)arrayList));
                int n12 = 2;
                string4 = ((Matcher)object).group(n12);
                f0.o(string4, "typeSubtype.group(2)");
                f0.o(object2, string6);
                Objects.requireNonNull(string4, string7);
                string3 = string4.toLowerCase((Locale)object2);
                f0.o(string3, (String)((Object)arrayList));
                arrayList = new ArrayList<Object>();
                object2 = v.c().matcher(string2);
                int n13 = ((Matcher)object).end();
                while (true) {
                    int n14 = string2.length();
                    int n15 = 0;
                    string7 = null;
                    if (n13 >= n14) break block6;
                    n14 = string2.length();
                    ((Matcher)object2).region(n13, n14);
                    n14 = (int)(((Matcher)object2).lookingAt() ? 1 : 0);
                    if (n14 == 0) break;
                    object = ((Matcher)object2).group(n11);
                    if (object == null) {
                        n13 = ((Matcher)object2).end();
                        continue;
                    }
                    string6 = ((Matcher)object2).group(n12);
                    if (string6 == null) {
                        n14 = 3;
                        string6 = ((Matcher)object2).group(n14);
                    } else {
                        string4 = "'";
                        stringArray = null;
                        boolean bl2 = u.q2(string6, string4, false, n12, null);
                        if (bl2 && (n15 = u.H1(string6, string4, false, n12, null)) != 0 && (n15 = string6.length()) > n12) {
                            n15 = string6.length() - n11;
                            string6 = string6.substring(n11, n15);
                            string7 = "(this as java.lang.Strin\u2026ing(startIndex, endIndex)";
                            f0.o(string6, string7);
                        }
                    }
                    arrayList.add(object);
                    arrayList.add(string6);
                    n13 = ((Matcher)object2).end();
                }
                StringBuilder stringArray2 = new StringBuilder();
                stringArray2.append("Parameter is not formatted correctly: \"");
                object = string2.substring(n13);
                f0.o(object, "(this as java.lang.String).substring(startIndex)");
                stringArray2.append((String)object);
                stringArray2.append("\" for: \"");
                stringArray2.append(string2);
                stringArray2.append(c10);
                string2 = stringArray2.toString();
                string2 = string2.toString();
                object = new IllegalArgumentException(string2);
                throw object;
            }
            String[] stringArray2 = new String[]{};
            stringArray2 = arrayList.toArray(stringArray2);
            Objects.requireNonNull(stringArray2, "null cannot be cast to non-null type kotlin.Array<T>");
            stringArray = stringArray2;
            stringArray = stringArray2;
            string4 = string2;
            object = new v(string2, string5, string3, stringArray, null);
            return object;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("No subtype found for: \"");
        ((StringBuilder)object).append(string2);
        ((StringBuilder)object).append(c10);
        string2 = ((StringBuilder)object).toString();
        string2 = string2.toString();
        object = new IllegalArgumentException(string2);
        throw object;
    }

    public final v d(String object) {
        String string2 = "$this$toMediaTypeOrNull";
        f0.p(object, string2);
        try {
            object = this.c((String)object);
        }
        catch (IllegalArgumentException illegalArgumentException) {
            object = null;
        }
        return object;
    }
}

