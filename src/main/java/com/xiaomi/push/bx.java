/*
 * Decompiled with CFR 0.151.
 */
package com.xiaomi.push;

import com.xiaomi.push.cb$d;

public class bx
extends cb$d {
    public String a = "MessageDeleteJob";

    public bx(String string2, String string3, String[] stringArray, String string4) {
        super(string2, string3, stringArray);
        this.a = string4;
    }

    public static bx a(String string2) {
        CharSequence charSequence = new StringBuilder();
        charSequence.append("status = ?");
        String[] stringArray = new String[1];
        Object object = String.valueOf(2);
        stringArray[0] = object;
        charSequence = charSequence.toString();
        object = new bx(string2, (String)charSequence, stringArray, "a job build to delete uploaded job");
        return object;
    }
}

