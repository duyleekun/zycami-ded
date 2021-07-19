/*
 * Decompiled with CFR 0.151.
 */
package d.v.a.i.a;

import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.zhiyun.account.R$id;

public class l0 {
    private l0() {
    }

    public static NavDirections a() {
        int n10 = R$id.action_accountFragment_to_loginFragment;
        ActionOnlyNavDirections actionOnlyNavDirections = new ActionOnlyNavDirections(n10);
        return actionOnlyNavDirections;
    }

    public static NavDirections b() {
        int n10 = R$id.action_accountFragment_to_registerFragment;
        ActionOnlyNavDirections actionOnlyNavDirections = new ActionOnlyNavDirections(n10);
        return actionOnlyNavDirections;
    }

    public static NavDirections c() {
        int n10 = R$id.action_accountFragment_to_thirdBindFragment;
        ActionOnlyNavDirections actionOnlyNavDirections = new ActionOnlyNavDirections(n10);
        return actionOnlyNavDirections;
    }
}

