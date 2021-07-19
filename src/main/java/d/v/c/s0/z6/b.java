/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Size
 */
package d.v.c.s0.z6;

import android.util.Size;
import androidx.core.util.Pair;

public class b {
    public static final int A = 4;
    public static final int B = 0;
    public static final int C = 1;
    public static final int D = 0;
    public static final int E = 1;
    public static final String F = "0.0";
    public static final float G = 0.0f;
    public static final float H = -10.0f;
    public static final float I = 10.0f;
    public static final String J = "1.3333";
    public static final String K = "1.7778";
    public static final String L = "2.0000";
    public static final String M = "1.0000";
    public static final String a = "extra_title";
    public static final String b = "extra_content";
    public static final String c = "choose_type";
    public static final String d = "choose_list";
    public static final String e = "choose_drawable_res_list";
    public static final String f = "choose_text";
    public static final String g = "choose_position";
    public static final Pair h;
    public static final Pair i;
    public static final Pair j;
    public static final String k = "720P";
    public static final String l = "1080P";
    public static final String m = "4K";
    public static final String n = "fps";
    public static final String o = "24";
    public static final String p = "25";
    public static final String q = "30";
    public static final String r = "60";
    public static final String s = "5X";
    public static final String t = "10X";
    public static final String u = "15X";
    public static final String v = "30X";
    public static final int w = 0;
    public static final int x = 1;
    public static final int y = 2;
    public static final int z = 3;

    static {
        Size size = new Size(1280, 720);
        h = Pair.create(k, size);
        size = new Size(1920, 1080);
        i = Pair.create(l, size);
        size = new Size(3840, 2160);
        j = Pair.create(m, size);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static int a(String string2) {
        int n10;
        int n11;
        block4: {
            block3: {
                block1: {
                    block2: {
                        String string3;
                        int n12 = string2.hashCode();
                        int n13 = 1602;
                        n11 = 1;
                        if (n12 == n13) break block1;
                        n13 = 1629;
                        if (n12 == n13) break block2;
                        n13 = 1722;
                        if (n12 != n13 || (n10 = (int)(string2.equals(string3 = r) ? 1 : 0)) == 0) break block3;
                        n10 = n11;
                        break block4;
                    }
                    String string4 = q;
                    n10 = (int)(string2.equals(string4) ? 1 : 0);
                    if (n10 == 0) break block3;
                    n10 = 2;
                    break block4;
                }
                String string5 = o;
                n10 = string2.equals(string5);
                if (n10 != 0) {
                    return 24;
                }
            }
            n10 = -1;
        }
        if (n10 == 0) return 24;
        if (n10 == n11) return 60;
        return 30;
    }
}

