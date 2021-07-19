/*
 * Decompiled with CFR 0.151.
 */
package d.v.b0.c.e;

import d.v.b0.c.e.c$a;
import java.util.List;

public class c {
    private static c b;
    public List a;

    static {
        c c10;
        b = c10 = new c();
    }

    private c() {
        List<c$a> list = new List<c$a>();
        this.a = list;
        int n10 = 4;
        c$a c$a = new c$a("FilterName_Green", "lut/cine_ice_3dl.png", 8, n10);
        list.add(c$a);
        list = this.a;
        c$a = new c$a("FilterName_Time", "lut/indiana_jones_alexa_3dl.png", 17, 1);
        list.add(c$a);
        list = this.a;
        c$a = new c$a("FilterName_Twilight", "lut/cube_1.png", n10, n10);
        list.add(c$a);
        list = this.a;
        c$a = new c$a("FilterName_Lemon", "lut/cube_5.png", n10, n10);
        list.add(c$a);
        list = this.a;
        c$a = new c$a("FilterName_Dawn", "lut/cube_16.png", n10, n10);
        list.add(c$a);
        list = this.a;
        c$a = new c$a("FilterName_Autumn", "lut/cube_21.png", n10, n10);
        list.add(c$a);
        list = this.a;
        c$a = new c$a("FilterName_Feast", "lut/cube_23.png", n10, n10);
        list.add(c$a);
        list = this.a;
        c$a = new c$a("FilterName_Black_white", "lut/cube_60.png", n10, n10);
        list.add(c$a);
        list = this.a;
        c$a = new c$a("FilterName_Light", "lut/cube_62.png", n10, n10);
        list.add(c$a);
        list = this.a;
        c$a = new c$a("FilterName_Lush", "lut/cube_68.png", n10, n10);
        list.add(c$a);
        list = this.a;
        c$a = new c$a("FilterName_Elapse", "lut/cube_71.png", n10, n10);
        list.add(c$a);
    }

    public static List a() {
        return c.b.a;
    }
}

