/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package androidx.navigation;

import android.os.Bundle;
import androidx.navigation.NavType;

public final class NavArgument {
    private final Object mDefaultValue;
    private final boolean mDefaultValuePresent;
    private final boolean mIsNullable;
    private final NavType mType;

    public NavArgument(NavType object, boolean bl2, Object object2, boolean bl3) {
        boolean bl4 = ((NavType)object).isNullableAllowed();
        if (!bl4 && bl2) {
            object2 = new StringBuilder();
            object = ((NavType)object).getName();
            ((StringBuilder)object2).append((String)object);
            ((StringBuilder)object2).append(" does not allow nullable values");
            object = ((StringBuilder)object2).toString();
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
            throw illegalArgumentException;
        }
        if (!bl2 && bl3 && object2 == null) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("Argument with type ");
            object = ((NavType)object).getName();
            ((StringBuilder)object2).append((String)object);
            ((StringBuilder)object2).append(" has null value but is not nullable.");
            object = ((StringBuilder)object2).toString();
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
            throw illegalArgumentException;
        }
        this.mType = object;
        this.mIsNullable = bl2;
        this.mDefaultValue = object2;
        this.mDefaultValuePresent = bl3;
    }

    public boolean equals(Object object) {
        Object object2;
        Object object3;
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        if (object != null && (object3 = NavArgument.class) == (object2 = object.getClass())) {
            object = (NavArgument)object;
            boolean bl3 = this.mIsNullable;
            boolean bl4 = ((NavArgument)object).mIsNullable;
            if (bl3 != bl4) {
                return false;
            }
            bl3 = this.mDefaultValuePresent;
            bl4 = ((NavArgument)object).mDefaultValuePresent;
            if (bl3 != bl4) {
                return false;
            }
            object3 = this.mType;
            object2 = ((NavArgument)object).mType;
            bl3 = object3.equals(object2);
            if (!bl3) {
                return false;
            }
            object3 = this.mDefaultValue;
            if (object3 != null) {
                object = ((NavArgument)object).mDefaultValue;
                bl2 = object3.equals(object);
            } else {
                object = ((NavArgument)object).mDefaultValue;
                if (object != null) {
                    bl2 = false;
                }
            }
            return bl2;
        }
        return false;
    }

    public Object getDefaultValue() {
        return this.mDefaultValue;
    }

    public NavType getType() {
        return this.mType;
    }

    /*
     * WARNING - void declaration
     */
    public int hashCode() {
        void var3_7;
        NavType navType = this.mType;
        int n10 = navType.hashCode() * 31;
        int n11 = this.mIsNullable;
        n10 = (n10 + n11) * 31;
        int n12 = this.mDefaultValuePresent;
        n10 = (n10 + n12) * 31;
        Object object = this.mDefaultValue;
        if (object != null) {
            int n13 = object.hashCode();
        } else {
            boolean bl2 = false;
            object = null;
        }
        return n10 + var3_7;
    }

    public boolean isDefaultValuePresent() {
        return this.mDefaultValuePresent;
    }

    public boolean isNullable() {
        return this.mIsNullable;
    }

    public void putDefaultValue(String string2, Bundle bundle) {
        boolean bl2 = this.mDefaultValuePresent;
        if (bl2) {
            NavType navType = this.mType;
            Object object = this.mDefaultValue;
            navType.put(bundle, string2, object);
        }
    }

    public boolean verify(String string2, Bundle bundle) {
        Object object;
        boolean bl2 = this.mIsNullable;
        if (!bl2 && (bl2 = bundle.containsKey(string2)) && (object = bundle.get(string2)) == null) {
            return false;
        }
        try {
            object = this.mType;
        }
        catch (ClassCastException classCastException) {
            return false;
        }
        ((NavType)object).get(bundle, string2);
        return true;
    }
}

