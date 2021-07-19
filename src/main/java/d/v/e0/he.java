/*
 * Decompiled with CFR 0.151.
 */
package d.v.e0;

import com.zhiyun.protocol.constants.Model;
import d.v.e0.he$a;
import java.util.UUID;

public final class he {
    public static final UUID a;
    public static final UUID b;
    private static final UUID c;
    private static final UUID d;
    private static final UUID e;
    private static final UUID f;
    private static final UUID g;
    private static final UUID h;
    private static final UUID i;

    static {
        String string2 = "D44BC439-ABFD-45A2-B575-925416129601";
        a = UUID.fromString(string2);
        String string3 = "D44BC439-ABFD-45A2-B575-925416129600";
        b = UUID.fromString(string3);
        c = UUID.fromString(string3);
        d = UUID.fromString(string2);
        e = UUID.fromString("D44BC439-ABFD-45A2-B575-925416129610");
        f = UUID.fromString("00002A29-0000-1000-8000-00805F9B34FB");
        g = UUID.fromString("00002A24-0000-1000-8000-00805F9B34FB");
        h = UUID.fromString("00002A26-0000-1000-8000-00805F9B34FB");
        i = UUID.fromString("0000180A-0000-1000-8000-00805F9B34FB");
    }

    public static UUID a(Model model) {
        int[] nArray = he$a.a;
        int n10 = model.ordinal();
        n10 = nArray[n10];
        switch (n10) {
            default: {
                return d;
            }
            case 1: 
            case 2: 
            case 3: 
            case 4: 
            case 5: 
            case 6: 
            case 7: 
            case 8: 
            case 9: 
            case 10: 
            case 11: 
            case 12: 
        }
        return e;
    }

    public static UUID b(Model model) {
        return d;
    }

    public static UUID c(Model model) {
        return c;
    }
}

