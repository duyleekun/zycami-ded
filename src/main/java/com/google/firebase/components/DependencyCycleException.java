/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.components;

import com.google.firebase.components.DependencyException;
import java.util.Arrays;
import java.util.List;

public class DependencyCycleException
extends DependencyException {
    private final List componentsInCycle;

    public DependencyCycleException(List list) {
        CharSequence charSequence = new StringBuilder();
        charSequence.append("Dependency cycle detected: ");
        String string2 = Arrays.toString(list.toArray());
        charSequence.append(string2);
        charSequence = charSequence.toString();
        super((String)charSequence);
        this.componentsInCycle = list;
    }

    public List getComponentsInCycle() {
        return this.componentsInCycle;
    }
}

