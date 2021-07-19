/*
 * Decompiled with CFR 0.151.
 */
package d.v.a.i.a;

import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.zhiyun.account.R$id;

public class q0 {
    private q0() {
    }

    public static NavDirections a() {
        int n10 = R$id.action_registerFragment_to_loginFragment;
        ActionOnlyNavDirections actionOnlyNavDirections = new ActionOnlyNavDirections(n10);
        return actionOnlyNavDirections;
    }

    public static NavDirections b() {
        int n10 = R$id.action_registerFragment_to_setPassFragment;
        ActionOnlyNavDirections actionOnlyNavDirections = new ActionOnlyNavDirections(n10);
        return actionOnlyNavDirections;
    }
}

