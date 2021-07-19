/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 */
package com.huawei.hms.framework.network.grs.b;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.a.a;
import com.huawei.hms.framework.network.grs.b.e;
import com.huawei.hms.framework.network.grs.c.c;
import java.util.Collections;
import java.util.Set;

public class f {
    private static final String a = "f";
    public static final Set b;

    static {
        e e10 = new e(16);
        b = Collections.unmodifiableSet(e10);
    }

    public static String a(Context context, a a10, String string2, GrsBaseInfo grsBaseInfo, boolean bl2) {
        boolean bl3 = TextUtils.isEmpty((CharSequence)string2);
        if (bl3) {
            Logger.w(a, "routeBy must be not empty string or null.");
            return null;
        }
        String string3 = "no_route";
        bl3 = string3.equals(string2);
        if (!bl3 && !(bl3 = (string3 = "unconditional").equals(string2))) {
            return f.b(context, a10, string2, grsBaseInfo, bl2);
        }
        Logger.v(a, "routeBy equals NO_ROUTE_POLICY");
        return "no_route_country";
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     */
    private static String b(Context object, a object2, String object3, GrsBaseInfo object4, boolean bl2) {
        Object object5;
        Object object6;
        Object object7 = ((GrsBaseInfo)object6).getSerCountry();
        String string2 = ((GrsBaseInfo)object6).getRegCountry();
        object6 = ((GrsBaseInfo)object6).getIssueCountry();
        String string3 = ">";
        object5 = ((String)object5).split(string3);
        int n10 = ((String[])object5).length;
        int n11 = 0;
        while (true) {
            block7: {
                void var0_2;
                CharSequence charSequence;
                block9: {
                    void var4_9;
                    boolean bl3;
                    String string4;
                    String string5;
                    Object object8;
                    block8: {
                        if (n11 >= n10) {
                            return "";
                        }
                        object8 = b;
                        string5 = object5[n11];
                        string4 = string5.trim();
                        bl3 = object8.contains(string4);
                        if (!bl3) break block7;
                        object8 = string5.trim();
                        bl3 = "ser_country".equals(object8);
                        string4 = "UNKNOWN";
                        if (!bl3 || (bl3 = TextUtils.isEmpty((CharSequence)object7)) || (bl3 = string4.equals(object7))) break block8;
                        String string6 = a;
                        charSequence = new StringBuilder();
                        object5 = "current route_by is serCountry and routerCountry is:";
                        break block9;
                    }
                    String string7 = "reg_country";
                    object8 = string5.trim();
                    bl3 = string7.equals(object8);
                    if (bl3 && !(bl3 = TextUtils.isEmpty((CharSequence)string2)) && !(bl3 = string4.equals(string2))) {
                        String string8 = a;
                        charSequence = new StringBuilder();
                        object5 = "current route_by is regCountry and routerCountry is:";
                        ((StringBuilder)charSequence).append((String)object5);
                        ((StringBuilder)charSequence).append(string2);
                        charSequence = ((StringBuilder)charSequence).toString();
                        Logger.i(string8, charSequence);
                        return string2;
                    }
                    string7 = "issue_country";
                    object8 = string5.trim();
                    bl3 = string7.equals(object8);
                    if (bl3 && !(bl3 = TextUtils.isEmpty((CharSequence)object6)) && !(bl3 = string4.equals(object6))) {
                        String string9 = a;
                        charSequence = new StringBuilder();
                        object5 = "current route_by is issueCountry and routerCountry is:";
                        ((StringBuilder)charSequence).append((String)object5);
                        ((StringBuilder)charSequence).append((String)object6);
                        charSequence = ((StringBuilder)charSequence).toString();
                        Logger.i(string9, charSequence);
                        return object6;
                    }
                    object8 = "geo_ip";
                    boolean bl4 = ((String)object8).equals(string5 = string5.trim());
                    if (!bl4) break block7;
                    object6 = new GrsBaseInfo();
                    object5 = new c((Context)object, (a)((Object)charSequence), (GrsBaseInfo)object6);
                    object7 = ((c)object5).a((boolean)var4_9);
                    String string10 = a;
                    charSequence = new StringBuilder();
                    object5 = "current route_by is geo_ip and routerCountry is: ";
                }
                ((StringBuilder)charSequence).append((String)object5);
                ((StringBuilder)charSequence).append((String)object7);
                charSequence = ((StringBuilder)charSequence).toString();
                Logger.i((String)var0_2, charSequence);
                return object7;
            }
            ++n11;
        }
    }
}

