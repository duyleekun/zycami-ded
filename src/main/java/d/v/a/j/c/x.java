/*
 * Decompiled with CFR 0.151.
 */
package d.v.a.j.c;

import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.zhiyun.account.R$id;

public class x {
    private x() {
    }

    public static NavDirections a() {
        int n10 = R$id.action_privateBindFragment_to_bindSuccessFragment;
        ActionOnlyNavDirections actionOnlyNavDirections = new ActionOnlyNavDirections(n10);
        return actionOnlyNavDirections;
    }

    public static NavDirections b() {
        int n10 = R$id.action_privateBindFragment_to_bindThirdFragment;
        ActionOnlyNavDirections actionOnlyNavDirections = new ActionOnlyNavDirections(n10);
        return actionOnlyNavDirections;
    }
}

