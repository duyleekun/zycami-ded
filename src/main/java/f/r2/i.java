/*
 * Decompiled with CFR 0.151.
 */
package f.r2;

import f.h2.t.f0;
import f.r2.f;
import f.r2.h;
import java.util.concurrent.TimeUnit;
import kotlin.NoWhenBranchMatchedException;

public class i
extends h {
    public static final String c(TimeUnit object) {
        f0.p(object, "$this$shortName");
        int[] nArray = f.a;
        int n10 = object.ordinal();
        n10 = nArray[n10];
        switch (n10) {
            default: {
                object = new NoWhenBranchMatchedException();
                throw object;
            }
            case 7: {
                object = "d";
                break;
            }
            case 6: {
                object = "h";
                break;
            }
            case 5: {
                object = "m";
                break;
            }
            case 4: {
                object = "s";
                break;
            }
            case 3: {
                object = "ms";
                break;
            }
            case 2: {
                object = "us";
                break;
            }
            case 1: {
                object = "ns";
            }
        }
        return object;
    }
}

