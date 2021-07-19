/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.v0.l;

import com.zhiyun.net.BaseEntity;
import k.d;

public interface c {
    public static final String a = "base_url:purchase";
    public static final String b = "timeout:60000";

    public static boolean h(String string2) {
        return "inapp_consume".equals(string2);
    }

    public static boolean n(String string2) {
        return "subs".equals(string2);
    }

    public static String q(String string2, BaseEntity baseEntity) {
        StringBuilder stringBuilder;
        if (string2 == null) {
            string2 = "";
        } else {
            stringBuilder = new StringBuilder();
            stringBuilder.append(string2);
            stringBuilder.append(",");
            string2 = stringBuilder.toString();
        }
        if (baseEntity != null) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(string2);
            stringBuilder.append(" errcode:");
            int n10 = baseEntity.errcode;
            stringBuilder.append(n10);
            stringBuilder.append(", errmsg:");
            string2 = baseEntity.errmsg;
            stringBuilder.append(string2);
            string2 = stringBuilder.toString();
        }
        return string2;
    }

    public d c(int var1, String var2);

    public d d(int var1, String var2, String var3, int var4, String var5, String var6, String var7, String var8, String var9, String var10);

    public d e(int var1, String var2, String var3, String var4);

    public d g(int var1, String var2, String var3);

    public d i(int var1, String var2, String var3, String var4);

    public d j(String var1);

    public d l(String var1, String var2, String var3, String var4, String var5);

    public d m();

    public d o(int var1, String var2, String var3);
}

