/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class MultiValueSet {
    private Set mSet;

    public MultiValueSet() {
        HashSet hashSet;
        this.mSet = hashSet = new HashSet();
    }

    public void addAll(List list) {
        this.mSet.addAll(list);
    }

    public abstract MultiValueSet clone();

    public List getAllItems() {
        Set set = this.mSet;
        ArrayList arrayList = new ArrayList(set);
        return Collections.unmodifiableList(arrayList);
    }
}

