/*
 * Decompiled with CFR 0.151.
 */
package d.v.a.i.a;

import com.zhiyun.account.me.account.getcode.GetCodeStatus;

public class m0$b {
    public static final /* synthetic */ int[] a;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        int n10;
        int n11;
        GetCodeStatus getCodeStatus;
        int n12 = GetCodeStatus.values().length;
        int[] nArray = new int[n12];
        a = nArray;
        try {
            getCodeStatus = GetCodeStatus.FORGET_PASS;
            n11 = getCodeStatus.ordinal();
            nArray[n11] = n10 = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            getCodeStatus = GetCodeStatus.THIRD_BIND;
            n11 = getCodeStatus.ordinal();
            nArray[n11] = n10 = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            getCodeStatus = GetCodeStatus.REGISTER;
            n11 = getCodeStatus.ordinal();
            nArray[n11] = n10 = 3;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

