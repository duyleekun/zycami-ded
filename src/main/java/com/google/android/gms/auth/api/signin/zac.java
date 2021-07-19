/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.auth.api.signin;

import com.google.android.gms.common.api.Scope;
import java.util.Comparator;

public final class zac
implements Comparator {
    public final /* synthetic */ int compare(Object object, Object object2) {
        object = (Scope)object;
        object2 = (Scope)object2;
        object = ((Scope)object).getScopeUri();
        object2 = ((Scope)object2).getScopeUri();
        return ((String)object).compareTo((String)object2);
    }
}

