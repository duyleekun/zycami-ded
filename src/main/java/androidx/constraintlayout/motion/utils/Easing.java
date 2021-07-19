/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Log
 */
package androidx.constraintlayout.motion.utils;

import android.util.Log;
import androidx.constraintlayout.motion.utils.Easing$CubicEasing;
import java.util.Arrays;

public class Easing {
    private static final String ACCELERATE = "cubic(0.4, 0.05, 0.8, 0.7)";
    private static final String ACCELERATE_NAME = "accelerate";
    private static final String DECELERATE = "cubic(0.0, 0.0, 0.2, 0.95)";
    private static final String DECELERATE_NAME = "decelerate";
    private static final String LINEAR = "cubic(1, 1, 0, 0)";
    private static final String LINEAR_NAME = "linear";
    public static String[] NAMED_EASING;
    private static final String STANDARD = "cubic(0.4, 0.0, 0.2, 1)";
    private static final String STANDARD_NAME = "standard";
    public static Easing sDefault;
    public String str = "identity";

    static {
        Easing easing;
        sDefault = easing = new Easing();
        NAMED_EASING = new String[]{STANDARD_NAME, ACCELERATE_NAME, DECELERATE_NAME, LINEAR_NAME};
    }

    /*
     * WARNING - void declaration
     */
    public static Easing getInterpolator(String object) {
        void var2_8;
        if (object == null) {
            return null;
        }
        Object object2 = "cubic";
        boolean n10 = ((String)object).startsWith((String)object2);
        if (n10) {
            object2 = new Easing$CubicEasing((String)object);
            return object2;
        }
        ((String)object).hashCode();
        int n11 = -1;
        int n12 = ((String)object).hashCode();
        switch (n12) {
            default: {
                break;
            }
            case 1312628413: {
                String string2 = STANDARD_NAME;
                boolean bl2 = ((String)object).equals(string2);
                if (!bl2) break;
                int n13 = 3;
                break;
            }
            case -1102672091: {
                String string3 = LINEAR_NAME;
                boolean bl3 = ((String)object).equals(string3);
                if (!bl3) break;
                int n14 = 2;
                break;
            }
            case -1263948740: {
                String string4 = DECELERATE_NAME;
                boolean bl4 = ((String)object).equals(string4);
                if (!bl4) break;
                boolean bl5 = true;
                break;
            }
            case -1354466595: {
                String string5 = ACCELERATE_NAME;
                boolean bl6 = ((String)object).equals(string5);
                if (!bl6) break;
                boolean bl7 = false;
                object2 = null;
            }
        }
        switch (var2_8) {
            default: {
                object = new StringBuilder();
                ((StringBuilder)object).append("transitionEasing syntax error syntax:transitionEasing=\"cubic(1.0,0.5,0.0,0.6)\" or ");
                object2 = Arrays.toString(NAMED_EASING);
                ((StringBuilder)object).append((String)object2);
                object = ((StringBuilder)object).toString();
                Log.e((String)"ConstraintSet", (String)object);
                return sDefault;
            }
            case 3: {
                object = new Easing$CubicEasing(STANDARD);
                return object;
            }
            case 2: {
                object = new Easing$CubicEasing(LINEAR);
                return object;
            }
            case 1: {
                object = new Easing$CubicEasing(DECELERATE);
                return object;
            }
            case 0: 
        }
        object = new Easing$CubicEasing(ACCELERATE);
        return object;
    }

    public double get(double d10) {
        return d10;
    }

    public double getDiff(double d10) {
        return 1.0;
    }

    public String toString() {
        return this.str;
    }
}

