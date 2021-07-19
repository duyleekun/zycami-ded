/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.l1;

import com.zhiyun.pay.data.PayFlowResult;
import com.zhiyun.pay.data.PurchaseResult;

public class x$a {
    public static final /* synthetic */ int[] a;
    public static final /* synthetic */ int[] b;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        Object object;
        int n10;
        int n11;
        Enum enum_;
        int n12;
        Object object2;
        int n13;
        Object object3;
        int n14 = PayFlowResult.values().length;
        int[] nArray = new int[n14];
        b = nArray;
        int n15 = 1;
        try {
            object3 = PayFlowResult.PAY_FLOW_OK;
            n13 = object3.ordinal();
            nArray[n13] = n15;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        n14 = 2;
        try {
            object3 = b;
            object2 = PayFlowResult.SERVICE_UNAVAILABLE;
            n12 = ((Enum)object2).ordinal();
            object3[n12] = (PayFlowResult)n14;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        n13 = 3;
        try {
            object2 = b;
            enum_ = PayFlowResult.PAY_FLOW_FAIL;
            n11 = enum_.ordinal();
            object2[n11] = (PayFlowResult)n13;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            object2 = b;
            enum_ = PayFlowResult.PAY_FLOW_FAIL_CREATE_ORDER;
            n11 = enum_.ordinal();
            n10 = 4;
            object2[n11] = (PayFlowResult)n10;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            object2 = b;
            enum_ = PayFlowResult.PAY_FLOW_FAIL_GET_PARAM;
            n11 = enum_.ordinal();
            n10 = 5;
            object2[n11] = (PayFlowResult)n10;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        n12 = PurchaseResult.values().length;
        object2 = new int[n12];
        a = (int[])object2;
        try {
            enum_ = PurchaseResult.PURCHASE_OK;
            n11 = enum_.ordinal();
            object2[n11] = (PayFlowResult)n15;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            object = a;
            object2 = PurchaseResult.PURCHASE_USER_CANCELED;
            n12 = ((Enum)object2).ordinal();
            object[n12] = n14;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            object = (Object)PurchaseResult.PURCHASE_FAIL;
            n15 = ((Enum)object).ordinal();
            nArray[n15] = n13;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

