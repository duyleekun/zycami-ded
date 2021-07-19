/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Api$Client;
import com.google.android.gms.common.api.internal.zaak;
import com.google.android.gms.common.api.internal.zaau;
import com.google.android.gms.common.api.internal.zaaw;
import com.google.android.gms.common.internal.IAccountAccessor;
import java.util.ArrayList;
import java.util.Set;

public final class zaaq
extends zaau {
    private final /* synthetic */ zaak zagj;
    private final ArrayList zagp;

    public zaaq(zaak zaak2, ArrayList arrayList) {
        this.zagj = zaak2;
        super(zaak2, null);
        this.zagp = arrayList;
    }

    public final void zaan() {
        Set set;
        Object object = zaak.zad((zaak)this.zagj).zaee;
        ((zaaw)object).zaha = set = zaak.zag(this.zagj);
        object = this.zagp;
        int n10 = ((ArrayList)object).size();
        for (int i10 = 0; i10 < n10; ++i10) {
            Object object2 = ((ArrayList)object).get(i10);
            object2 = (Api$Client)object2;
            IAccountAccessor iAccountAccessor = zaak.zah(this.zagj);
            Set set2 = zaak.zad((zaak)this.zagj).zaee.zaha;
            object2.getRemoteService(iAccountAccessor, set2);
        }
    }
}

