/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.components;

import com.google.firebase.components.Component;
import java.util.HashSet;
import java.util.Set;

public class CycleDetector$ComponentNode {
    private final Component component;
    private final Set dependencies;
    private final Set dependents;

    public CycleDetector$ComponentNode(Component component) {
        HashSet hashSet;
        this.dependencies = hashSet = new HashSet();
        this.dependents = hashSet = new HashSet();
        this.component = component;
    }

    public void addDependency(CycleDetector$ComponentNode cycleDetector$ComponentNode) {
        this.dependencies.add(cycleDetector$ComponentNode);
    }

    public void addDependent(CycleDetector$ComponentNode cycleDetector$ComponentNode) {
        this.dependents.add(cycleDetector$ComponentNode);
    }

    public Component getComponent() {
        return this.component;
    }

    public Set getDependencies() {
        return this.dependencies;
    }

    public boolean isLeaf() {
        return this.dependencies.isEmpty();
    }

    public boolean isRoot() {
        return this.dependents.isEmpty();
    }

    public void removeDependent(CycleDetector$ComponentNode cycleDetector$ComponentNode) {
        this.dependents.remove(cycleDetector$ComponentNode);
    }
}

