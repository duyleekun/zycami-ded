/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 */
package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.push.dv;
import com.xiaomi.push.ed;
import com.xiaomi.push.ho;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class ec
extends ed {
    public static String a = "";
    public static String b = "";

    public ec(Context context, int n10) {
        super(context, n10);
    }

    private String a(String string2, String string3) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (!bl2 && !(bl2 = TextUtils.isEmpty((CharSequence)string3))) {
            int n10;
            String[] stringArray = string3.split(",");
            int n11 = stringArray.length;
            if (n11 > (n10 = 10)) {
                for (int i10 = stringArray.length + -1; i10 >= (n11 = stringArray.length - n10); i10 += -1) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(string2);
                    string2 = stringArray[i10];
                    stringBuilder.append(string2);
                    string2 = stringBuilder.toString();
                }
                return string2;
            }
            return string3;
        }
        return "";
    }

    public int a() {
        return 12;
    }

    public ho a() {
        return ho.j;
    }

    public String a() {
        String string2;
        CharSequence charSequence;
        CharSequence charSequence2 = a;
        boolean bl2 = TextUtils.isEmpty((CharSequence)charSequence2);
        String string3 = "";
        if (!bl2) {
            charSequence2 = new StringBuilder();
            ((StringBuilder)charSequence2).append(string3);
            charSequence = dv.a;
            string2 = a;
            charSequence = this.a((String)charSequence, string2);
            ((StringBuilder)charSequence2).append((String)charSequence);
            charSequence2 = ((StringBuilder)charSequence2).toString();
            a = string3;
        } else {
            charSequence2 = string3;
        }
        charSequence = b;
        boolean bl3 = TextUtils.isEmpty((CharSequence)charSequence);
        if (!bl3) {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append((String)charSequence2);
            charSequence2 = dv.b;
            string2 = b;
            charSequence2 = this.a((String)charSequence2, string2);
            ((StringBuilder)charSequence).append((String)charSequence2);
            charSequence2 = ((StringBuilder)charSequence).toString();
            b = string3;
        }
        return charSequence2;
    }
}

