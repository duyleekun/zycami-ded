/*
 * Decompiled with CFR 0.151.
 */
package com.bumptech.glide.manager;

import com.bumptech.glide.manager.RequestManagerFragment;
import d.c.a.i;
import d.c.a.p.l;
import java.util.HashSet;
import java.util.Set;

public class RequestManagerFragment$a
implements l {
    public final /* synthetic */ RequestManagerFragment a;

    public RequestManagerFragment$a(RequestManagerFragment requestManagerFragment) {
        this.a = requestManagerFragment;
    }

    public Set a() {
        Object object = this.a.b();
        int n10 = object.size();
        HashSet<RequestManagerFragment> hashSet = new HashSet<RequestManagerFragment>(n10);
        object = object.iterator();
        while ((n10 = (int)(object.hasNext() ? 1 : 0)) != 0) {
            Object object2 = (RequestManagerFragment)((Object)object.next());
            i i10 = object2.e();
            if (i10 == null) continue;
            object2 = object2.e();
            hashSet.add((RequestManagerFragment)((Object)object2));
        }
        return hashSet;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Object object = super.toString();
        stringBuilder.append((String)object);
        stringBuilder.append("{fragment=");
        object = this.a;
        stringBuilder.append(object);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

