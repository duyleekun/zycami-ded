/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.auth.api.signin;

import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Scope;
import java.util.Comparator;

public final class zaa
implements Comparator {
    public static final Comparator zaq;

    static {
        zaa zaa2 = new zaa();
        zaq = zaa2;
    }

    private zaa() {
    }

    public final int compare(Object object, Object object2) {
        object = (Scope)object;
        object2 = (Scope)object2;
        return GoogleSignInAccount.zaa((Scope)object, (Scope)object2);
    }
}

