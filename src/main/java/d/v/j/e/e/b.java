/*
 * Decompiled with CFR 0.151.
 */
package d.v.j.e.e;

import d.v.e.l.w1;

public interface b {
    default public String a() {
        boolean bl2;
        String string2;
        String string3 = w1.a();
        boolean bl3 = string3.equals(string2 = "zh".toLowerCase());
        string3 = !bl3 && !(bl3 = string3.equals(string2 = "zh_CN".toLowerCase())) ? ((bl3 = string3.equals(string2 = "zh_TW".toLowerCase())) ? this.getTextZhTw() : ((bl2 = string3.equals(string2 = "en".toLowerCase())) ? this.getTextEn() : this.getTextEn())) : this.getTextZh();
        if (string3 == null) {
            string3 = "";
        }
        return string3;
    }

    public String getTextEn();

    public String getTextZh();

    public String getTextZhTw();
}

