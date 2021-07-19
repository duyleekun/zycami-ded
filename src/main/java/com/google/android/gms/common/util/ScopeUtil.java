/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package com.google.android.gms.common.util;

import android.text.TextUtils;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public final class ScopeUtil {
    private ScopeUtil() {
    }

    public static Set fromScopeString(Collection collection) {
        Preconditions.checkNotNull(collection, "scopeStrings can't be null.");
        String[] stringArray = new String[collection.size()];
        return ScopeUtil.fromScopeString(collection.toArray(stringArray));
    }

    public static Set fromScopeString(String ... stringArray) {
        Preconditions.checkNotNull(stringArray, "scopeStrings can't be null.");
        int n10 = stringArray.length;
        HashSet<Scope> hashSet = new HashSet<Scope>(n10);
        for (String string2 : stringArray) {
            boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
            if (bl2) continue;
            Scope scope = new Scope(string2);
            hashSet.add(scope);
        }
        return hashSet;
    }

    public static String[] toScopeString(Set set) {
        Preconditions.checkNotNull(set, "scopes can't be null.");
        Scope[] scopeArray = new Scope[set.size()];
        return ScopeUtil.toScopeString(set.toArray(scopeArray));
    }

    public static String[] toScopeString(Scope[] scopeArray) {
        int n10;
        Preconditions.checkNotNull(scopeArray, "scopes can't be null.");
        int n11 = scopeArray.length;
        String[] stringArray = new String[n11];
        for (int i10 = 0; i10 < (n10 = scopeArray.length); ++i10) {
            String string2;
            stringArray[i10] = string2 = scopeArray[i10].getScopeUri();
        }
        return stringArray;
    }
}

