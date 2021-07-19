/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.t0;

import com.quvideo.mobile.external.component.cloudcomposite.protocal.OnCompositeListener$State;

public class v$b {
    public static final /* synthetic */ int[] a;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        int n10;
        int n11;
        OnCompositeListener$State onCompositeListener$State;
        int n12 = OnCompositeListener$State.values().length;
        int[] nArray = new int[n12];
        a = nArray;
        try {
            onCompositeListener$State = OnCompositeListener$State.IDEL;
            n11 = onCompositeListener$State.ordinal();
            nArray[n11] = n10 = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            onCompositeListener$State = OnCompositeListener$State.UPLOAD;
            n11 = onCompositeListener$State.ordinal();
            nArray[n11] = n10 = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            onCompositeListener$State = OnCompositeListener$State.COMPOSITE;
            n11 = onCompositeListener$State.ordinal();
            nArray[n11] = n10 = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            onCompositeListener$State = OnCompositeListener$State.QUERY;
            n11 = onCompositeListener$State.ordinal();
            nArray[n11] = n10 = 4;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            onCompositeListener$State = OnCompositeListener$State.SUCCESS;
            n11 = onCompositeListener$State.ordinal();
            nArray[n11] = n10 = 5;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

