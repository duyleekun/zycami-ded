/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.components;

import com.google.firebase.components.Component;
import com.google.firebase.components.CycleDetector$ComponentNode;
import com.google.firebase.components.CycleDetector$Dep;
import com.google.firebase.components.Dependency;
import com.google.firebase.components.DependencyCycleException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class CycleDetector {
    public static void detect(List arrayList) {
        boolean bl2;
        boolean bl3;
        Object object = CycleDetector.toGraph(arrayList);
        Object object2 = CycleDetector.getRoots((Set)object);
        int n10 = 0;
        while (!(bl3 = object2.isEmpty())) {
            boolean bl4;
            CycleDetector$ComponentNode cycleDetector$ComponentNode = (CycleDetector$ComponentNode)object2.iterator().next();
            object2.remove(cycleDetector$ComponentNode);
            ++n10;
            Iterator iterator2 = cycleDetector$ComponentNode.getDependencies().iterator();
            while (bl4 = iterator2.hasNext()) {
                CycleDetector$ComponentNode cycleDetector$ComponentNode2 = (CycleDetector$ComponentNode)iterator2.next();
                cycleDetector$ComponentNode2.removeDependent(cycleDetector$ComponentNode);
                boolean bl5 = cycleDetector$ComponentNode2.isRoot();
                if (!bl5) continue;
                object2.add(cycleDetector$ComponentNode2);
            }
        }
        int n11 = arrayList.size();
        if (n10 == n11) {
            return;
        }
        arrayList = new ArrayList<Object>();
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            object2 = (CycleDetector$ComponentNode)object.next();
            n10 = (int)(((CycleDetector$ComponentNode)object2).isRoot() ? 1 : 0);
            if (n10 != 0 || (n10 = (int)(((CycleDetector$ComponentNode)object2).isLeaf() ? 1 : 0)) != 0) continue;
            object2 = ((CycleDetector$ComponentNode)object2).getComponent();
            arrayList.add(object2);
        }
        object = new DependencyCycleException(arrayList);
        throw object;
    }

    private static Set getRoots(Set object) {
        boolean bl2;
        HashSet<CycleDetector$ComponentNode> hashSet = new HashSet<CycleDetector$ComponentNode>();
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            CycleDetector$ComponentNode cycleDetector$ComponentNode = (CycleDetector$ComponentNode)object.next();
            boolean bl3 = cycleDetector$ComponentNode.isRoot();
            if (!bl3) continue;
            hashSet.add(cycleDetector$ComponentNode);
        }
        return hashSet;
    }

    private static Set toGraph(List serializable) {
        boolean bl2;
        Object object;
        Object object2;
        Object object3;
        boolean bl3;
        Iterator iterator2;
        CycleDetector$ComponentNode cycleDetector$ComponentNode;
        Object object4;
        int n10 = serializable.size();
        Object object5 = new HashMap(n10);
        serializable = serializable.iterator();
        while ((n10 = (int)(serializable.hasNext() ? 1 : 0)) != 0) {
            object4 = (Component)serializable.next();
            cycleDetector$ComponentNode = new CycleDetector$ComponentNode((Component)object4);
            iterator2 = ((Component)object4).getProvidedInterfaces().iterator();
            while (bl3 = iterator2.hasNext()) {
                boolean bl4;
                object3 = (Class)iterator2.next();
                boolean bl5 = ((Component)object4).isValue();
                int n11 = 1;
                bl5 ^= n11;
                object2 = new CycleDetector$Dep((Class)object3, bl5, null);
                if (!(bl5 = object5.containsKey(object2))) {
                    object = new HashSet();
                    object5.put(object2, object);
                }
                if (!(bl4 = (object = (Set)object5.get(object2)).isEmpty()) && !(bl2 = CycleDetector$Dep.access$100((CycleDetector$Dep)object2))) {
                    object5 = new Object[n11];
                    object5[0] = object3;
                    object5 = String.format("Multiple components provide %s.", object5);
                    serializable = new Serializable((String)object5);
                    throw serializable;
                }
                object.add(cycleDetector$ComponentNode);
            }
        }
        serializable = object5.values().iterator();
        while ((n10 = (int)(serializable.hasNext() ? 1 : 0)) != 0) {
            boolean bl6;
            object4 = ((Set)serializable.next()).iterator();
            while (bl6 = object4.hasNext()) {
                cycleDetector$ComponentNode = (CycleDetector$ComponentNode)object4.next();
                iterator2 = cycleDetector$ComponentNode.getComponent().getDependencies().iterator();
                while (bl3 = iterator2.hasNext()) {
                    object3 = (Dependency)iterator2.next();
                    bl2 = ((Dependency)object3).isDirectInjection();
                    if (!bl2 || (object3 = (Set)object5.get(object2 = new CycleDetector$Dep((Class)(object = ((Dependency)object3).getInterface()), bl3 = ((Dependency)object3).isSet(), null))) == null) continue;
                    object3 = object3.iterator();
                    while (bl2 = object3.hasNext()) {
                        object2 = (CycleDetector$ComponentNode)object3.next();
                        cycleDetector$ComponentNode.addDependency((CycleDetector$ComponentNode)object2);
                        ((CycleDetector$ComponentNode)object2).addDependent(cycleDetector$ComponentNode);
                    }
                }
            }
        }
        serializable = new Serializable();
        object5 = object5.values().iterator();
        while ((n10 = (int)(object5.hasNext() ? 1 : 0)) != 0) {
            object4 = (Set)object5.next();
            serializable.addAll(object4);
        }
        return serializable;
    }
}

