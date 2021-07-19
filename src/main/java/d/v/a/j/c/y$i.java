/*
 * Decompiled with CFR 0.151.
 */
package d.v.a.j.c;

import com.zhiyun.account.data.me.ThirdPlatform;
import com.zhiyun.account.set.privacy.getcode.PrivateGetCodeStatus;

public class y$i {
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
        Enum enum_;
        int n11;
        Object object2;
        int n12;
        Object object3;
        int n13;
        Object object4;
        int n14 = ThirdPlatform.values().length;
        int[] nArray = new int[n14];
        b = nArray;
        int n15 = 1;
        try {
            object4 = ThirdPlatform.WE_CHAT;
            n13 = object4.ordinal();
            nArray[n13] = n15;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        n14 = 2;
        try {
            object4 = b;
            object3 = ThirdPlatform.WEIBO;
            n12 = object3.ordinal();
            object4[n12] = (ThirdPlatform)n14;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        n13 = 3;
        try {
            object3 = b;
            object2 = ThirdPlatform.QQ;
            n11 = ((Enum)object2).ordinal();
            object3[n11] = (ThirdPlatform)n13;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        n12 = 4;
        try {
            object2 = b;
            enum_ = ThirdPlatform.FACEBOOK;
            n10 = enum_.ordinal();
            object2[n10] = (ThirdPlatform)n12;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        n11 = PrivateGetCodeStatus.values().length;
        object2 = new int[n11];
        a = (int[])object2;
        try {
            enum_ = PrivateGetCodeStatus.MODIFY_PASS;
            n10 = enum_.ordinal();
            object2[n10] = (ThirdPlatform)n15;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            object = a;
            object2 = PrivateGetCodeStatus.CHANGE_BIND_FIRST;
            n11 = ((Enum)object2).ordinal();
            object[n11] = n14;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            object = (Object)PrivateGetCodeStatus.CHANGE_BIND_SECOND;
            n15 = ((Enum)object).ordinal();
            nArray[n15] = n13;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            object = PrivateGetCodeStatus.BIND;
            n15 = ((Enum)object).ordinal();
            nArray[n15] = n12;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

