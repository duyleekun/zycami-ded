/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package d.v.c.o0;

import android.text.TextUtils;

public class s0 {
    public static final String a = "zy_tag_favorite";

    private String b(String charSequence, String ... object) {
        int n10 = 0;
        String string2 = null;
        int n11 = object == null ? 0 : ((String[])object).length;
        StringBuilder stringBuilder = new StringBuilder();
        while (n10 < n11) {
            int n12 = n10 + 1;
            String string3 = "%";
            String string4 = " LIKE ";
            String string5 = "'";
            if (n11 > n12) {
                stringBuilder.append((String)charSequence);
                stringBuilder.append(string4);
                stringBuilder.append(string5);
                string2 = object[n10];
                stringBuilder.append(string2);
                stringBuilder.append(string3);
                stringBuilder.append(string5);
                string2 = " OR ";
                stringBuilder.append(string2);
            } else {
                stringBuilder.append((String)charSequence);
                stringBuilder.append(string4);
                stringBuilder.append(string5);
                string2 = object[n10];
                stringBuilder.append(string2);
                stringBuilder.append(string3);
                stringBuilder.append(string5);
            }
            n10 = n12;
        }
        charSequence = stringBuilder.toString();
        boolean bl2 = TextUtils.isEmpty((CharSequence)charSequence);
        if (bl2) {
            bl2 = false;
            charSequence = null;
        } else {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append("(");
            ((StringBuilder)charSequence).append((Object)stringBuilder);
            object = ")";
            ((StringBuilder)charSequence).append((String)object);
            charSequence = ((StringBuilder)charSequence).toString();
        }
        return charSequence;
    }

    public String a(int n10, String ... object) {
        object = this.b("_data", (String)object);
        String string2 = ")";
        String string3 = " AND (";
        int n11 = 3;
        int n12 = 1;
        String string4 = " = ";
        String string5 = "media_type";
        if (n10 != n12) {
            int n13 = 2;
            if (n10 != n13) {
                String string6 = " OR ";
                if (n10 != n11) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append((String)object);
                    stringBuilder.append(string3);
                    stringBuilder.append(string5);
                    stringBuilder.append(string4);
                    stringBuilder.append(n12);
                    stringBuilder.append(string6);
                    stringBuilder.append(string5);
                    stringBuilder.append(string4);
                    stringBuilder.append(n11);
                    stringBuilder.append(string2);
                    return stringBuilder.toString();
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append((String)object);
                stringBuilder.append(string3);
                stringBuilder.append(string5);
                stringBuilder.append(string4);
                stringBuilder.append(n12);
                stringBuilder.append(string6);
                stringBuilder.append(string5);
                stringBuilder.append(string4);
                stringBuilder.append(n11);
                stringBuilder.append(") AND ");
                stringBuilder.append("tags");
                stringBuilder.append(" = '");
                stringBuilder.append(a);
                stringBuilder.append("'");
                return stringBuilder.toString();
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append((String)object);
            stringBuilder.append(string3);
            stringBuilder.append(string5);
            stringBuilder.append(string4);
            stringBuilder.append(n12);
            stringBuilder.append(string2);
            return stringBuilder.toString();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append((String)object);
        stringBuilder.append(string3);
        stringBuilder.append(string5);
        stringBuilder.append(string4);
        stringBuilder.append(n11);
        stringBuilder.append(string2);
        return stringBuilder.toString();
    }
}

