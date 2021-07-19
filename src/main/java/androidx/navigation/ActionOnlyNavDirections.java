/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package androidx.navigation;

import android.os.Bundle;
import androidx.navigation.NavDirections;

public final class ActionOnlyNavDirections
implements NavDirections {
    private final int mActionId;

    public ActionOnlyNavDirections(int n10) {
        this.mActionId = n10;
    }

    public boolean equals(Object object) {
        Class<?> clazz;
        Class<ActionOnlyNavDirections> clazz2;
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        if (object != null && (clazz2 = ActionOnlyNavDirections.class) == (clazz = object.getClass())) {
            int n10;
            object = (ActionOnlyNavDirections)object;
            int n11 = this.getActionId();
            if (n11 != (n10 = ((ActionOnlyNavDirections)object).getActionId())) {
                return false;
            }
            return bl2;
        }
        return false;
    }

    public int getActionId() {
        return this.mActionId;
    }

    public Bundle getArguments() {
        Bundle bundle = new Bundle();
        return bundle;
    }

    public int hashCode() {
        int n10 = this.getActionId();
        return 31 + n10;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ActionOnlyNavDirections(actionId=");
        int n10 = this.getActionId();
        stringBuilder.append(n10);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}

