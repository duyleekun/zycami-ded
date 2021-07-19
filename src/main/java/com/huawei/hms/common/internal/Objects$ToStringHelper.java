/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.hms.common.internal;

import com.huawei.hms.common.internal.Objects$a;
import com.huawei.hms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.List;

public final class Objects$ToStringHelper {
    public final List a;
    public final Object b;

    public Objects$ToStringHelper(Object arrayList) {
        arrayList = Preconditions.checkNotNull(arrayList);
        this.b = arrayList;
        this.a = arrayList = new ArrayList();
    }

    public /* synthetic */ Objects$ToStringHelper(Object object, Objects.a a10) {
        this(object);
    }

    public final Objects$ToStringHelper add(String string2, Object object) {
        string2 = (String)Preconditions.checkNotNull(string2);
        object = String.valueOf(object);
        int n10 = string2.length();
        int n11 = ((String)object).length();
        n10 = n10 + n11 + 1;
        StringBuilder stringBuilder = new StringBuilder(n10);
        stringBuilder.append(string2);
        stringBuilder.append("=");
        stringBuilder.append((String)object);
        string2 = stringBuilder.toString();
        this.a.add(string2);
        return this;
    }

    public final String toString() {
        Object object = this.b.getClass().getSimpleName();
        StringBuilder stringBuilder = new StringBuilder(100);
        stringBuilder.append((String)object);
        stringBuilder.append('{');
        object = this.a;
        int n10 = object.size();
        for (int i10 = 0; i10 < n10; ++i10) {
            String string2 = (String)this.a.get(i10);
            stringBuilder.append(string2);
            int n11 = n10 + -1;
            if (i10 >= n11) continue;
            string2 = ", ";
            stringBuilder.append(string2);
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

