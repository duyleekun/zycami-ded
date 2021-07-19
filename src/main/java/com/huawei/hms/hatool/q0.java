/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package com.huawei.hms.hatool;

import android.text.TextUtils;
import com.huawei.hms.hatool.y;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class q0 {
    public static String a(String string2, String charSequence, String string3, String string4) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)charSequence);
        if (bl2) {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append("checkStrParameter() Parameter verification failure! Parameter:");
            ((StringBuilder)charSequence).append(string2);
            string2 = ((StringBuilder)charSequence).toString();
            y.f("hmsSdk", string2);
            return string4;
        }
        boolean bl3 = q0.a(string2, (String)charSequence, string3);
        if (bl3) {
            return charSequence;
        }
        return string4;
    }

    public static boolean a(String string2) {
        return q0.a("eventId", string2, 256) ^ true;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static boolean a(String string2, String charSequence, int n10) {
        String string3;
        boolean bl2 = TextUtils.isEmpty((CharSequence)charSequence);
        String string4 = "hmsSdk";
        if (bl2) {
            charSequence = new StringBuilder();
            string3 = "checkString() Parameter is empty : ";
        } else {
            int n11 = ((String)charSequence).length();
            if (n11 <= n10) {
                return true;
            }
            charSequence = new StringBuilder();
            string3 = "checkString() Failure of parameter length check! Parameter:";
        }
        ((StringBuilder)charSequence).append(string3);
        ((StringBuilder)charSequence).append(string2);
        string2 = ((StringBuilder)charSequence).toString();
        y.f(string4, string2);
        return false;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static boolean a(String string2, String object, String object2) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        String string3 = "hmsSdk";
        if (bl2) {
            object = new StringBuilder();
            object2 = "checkString() Parameter is null! Parameter:";
        } else {
            object = ((Pattern)(object2 = Pattern.compile((String)object2))).matcher((CharSequence)object);
            boolean bl3 = ((Matcher)object).matches();
            if (bl3) {
                return true;
            }
            object = new StringBuilder();
            object2 = "checkString() Parameter verification failure! Parameter:";
        }
        ((StringBuilder)object).append((String)object2);
        ((StringBuilder)object).append(string2);
        string2 = ((StringBuilder)object).toString();
        y.f(string3, string2);
        return false;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static boolean a(Map object) {
        int n10;
        String string2 = "hmsSdk";
        if (object != null && (n10 = object.size()) != 0) {
            Object object2;
            int n11;
            n10 = object.size();
            if (n10 == (n11 = 1) && ((object2 = object.get("constants")) != null || (object2 = object.get("_constants")) != null)) {
                object = "checkMap() the key can't be constants or _constants";
            } else {
                int n12;
                n10 = object.size();
                if (n10 <= (n12 = 2048) && (n10 = ((String)(object2 = object.toString())).length()) <= (n12 = 204800)) {
                    return n11 != 0;
                }
                object2 = new StringBuilder();
                ((StringBuilder)object2).append("checkMap Map data is too big! size: ");
                n11 = object.size();
                ((StringBuilder)object2).append(n11);
                String string3 = " length: ";
                ((StringBuilder)object2).append(string3);
                int n13 = object.toString().length();
                ((StringBuilder)object2).append(n13);
                object = ((StringBuilder)object2).toString();
            }
        } else {
            object = "onEvent() mapValue has not data.so,The data will be empty";
        }
        y.f(string2, (String)object);
        return false;
    }
}

