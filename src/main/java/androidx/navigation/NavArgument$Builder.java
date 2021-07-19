/*
 * Decompiled with CFR 0.151.
 */
package androidx.navigation;

import androidx.navigation.NavArgument;
import androidx.navigation.NavType;

public final class NavArgument$Builder {
    private Object mDefaultValue;
    private boolean mDefaultValuePresent = false;
    private boolean mIsNullable = false;
    private NavType mType;

    public NavArgument build() {
        Object object = this.mType;
        if (object == null) {
            this.mType = object = NavType.inferFromValueType(this.mDefaultValue);
        }
        NavType navType = this.mType;
        boolean bl2 = this.mIsNullable;
        Object object2 = this.mDefaultValue;
        boolean bl3 = this.mDefaultValuePresent;
        object = new NavArgument(navType, bl2, object2, bl3);
        return object;
    }

    public NavArgument$Builder setDefaultValue(Object object) {
        this.mDefaultValue = object;
        this.mDefaultValuePresent = true;
        return this;
    }

    public NavArgument$Builder setIsNullable(boolean bl2) {
        this.mIsNullable = bl2;
        return this;
    }

    public NavArgument$Builder setType(NavType navType) {
        this.mType = navType;
        return this;
    }
}

