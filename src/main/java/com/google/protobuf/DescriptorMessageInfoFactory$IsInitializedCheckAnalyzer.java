/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.DescriptorMessageInfoFactory$IsInitializedCheckAnalyzer$Node;
import com.google.protobuf.DescriptorMessageInfoFactory$IsInitializedCheckAnalyzer$StronglyConnectedComponent;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.Descriptors$FieldDescriptor;
import com.google.protobuf.Descriptors$FieldDescriptor$JavaType;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
import java.util.Stack;

public class DescriptorMessageInfoFactory$IsInitializedCheckAnalyzer {
    private int index;
    private final Map nodeCache;
    private final Map resultCache;
    private final Stack stack;

    public DescriptorMessageInfoFactory$IsInitializedCheckAnalyzer() {
        Serializable serializable;
        this.resultCache = serializable = new Serializable();
        this.index = 0;
        this.stack = serializable;
        super();
        this.nodeCache = serializable;
    }

    /*
     * Enabled aggressive block sorting
     */
    private void analyze(DescriptorMessageInfoFactory$IsInitializedCheckAnalyzer$StronglyConnectedComponent descriptorMessageInfoFactory$IsInitializedCheckAnalyzer$StronglyConnectedComponent) {
        Object object;
        Map map;
        boolean bl2;
        Object object2;
        boolean bl3;
        boolean bl4;
        Iterator iterator2 = descriptorMessageInfoFactory$IsInitializedCheckAnalyzer$StronglyConnectedComponent.messages.iterator();
        block0: while (true) {
            bl4 = iterator2.hasNext();
            bl3 = true;
            if (bl4) {
                object2 = (Descriptors$Descriptor)iterator2.next();
                bl2 = ((Descriptors$Descriptor)object2).isExtendable();
                if (bl2) break;
            } else {
                bl3 = false;
                map = null;
                break;
            }
            object2 = ((Descriptors$Descriptor)object2).getFields().iterator();
            while (true) {
                Descriptors$FieldDescriptor$JavaType descriptors$FieldDescriptor$JavaType;
                if (!(bl2 = object2.hasNext())) continue block0;
                object = (Descriptors$FieldDescriptor)object2.next();
                boolean bl5 = ((Descriptors$FieldDescriptor)object).isRequired();
                if (bl5) break block0;
                Object object3 = ((Descriptors$FieldDescriptor)object).getJavaType();
                if (object3 != (descriptors$FieldDescriptor$JavaType = Descriptors$FieldDescriptor$JavaType.MESSAGE)) continue;
                object3 = this.nodeCache;
                object = ((Descriptors$FieldDescriptor)object).getMessageType();
                object = ((DescriptorMessageInfoFactory$IsInitializedCheckAnalyzer$Node)object3.get((Object)object)).component;
                if (object != descriptorMessageInfoFactory$IsInitializedCheckAnalyzer$StronglyConnectedComponent && (bl2 = ((DescriptorMessageInfoFactory$IsInitializedCheckAnalyzer$StronglyConnectedComponent)object).needsIsInitializedCheck)) break block0;
            }
            break;
        }
        descriptorMessageInfoFactory$IsInitializedCheckAnalyzer$StronglyConnectedComponent.needsIsInitializedCheck = bl3;
        iterator2 = descriptorMessageInfoFactory$IsInitializedCheckAnalyzer$StronglyConnectedComponent.messages.iterator();
        while (bl4 = iterator2.hasNext()) {
            object2 = (Descriptors$Descriptor)iterator2.next();
            map = this.resultCache;
            bl2 = descriptorMessageInfoFactory$IsInitializedCheckAnalyzer$StronglyConnectedComponent.needsIsInitializedCheck;
            object = bl2;
            map.put(object2, object);
        }
        return;
    }

    private DescriptorMessageInfoFactory$IsInitializedCheckAnalyzer$Node dfs(Descriptors$Descriptor object) {
        Object object2;
        Object object3;
        int n10;
        int n11 = this.index;
        this.index = n10 = n11 + 1;
        DescriptorMessageInfoFactory$IsInitializedCheckAnalyzer$Node descriptorMessageInfoFactory$IsInitializedCheckAnalyzer$Node = new DescriptorMessageInfoFactory$IsInitializedCheckAnalyzer$Node((Descriptors$Descriptor)object, n11);
        this.stack.push(descriptorMessageInfoFactory$IsInitializedCheckAnalyzer$Node);
        Object object4 = this.nodeCache;
        object4.put(object, descriptorMessageInfoFactory$IsInitializedCheckAnalyzer$Node);
        object = ((Descriptors$Descriptor)object).getFields().iterator();
        while ((n11 = (int)(object.hasNext() ? 1 : 0)) != 0) {
            object4 = (Descriptors$FieldDescriptor)object.next();
            object3 = ((Descriptors$FieldDescriptor)object4).getJavaType();
            if (object3 != (object2 = Descriptors$FieldDescriptor$JavaType.MESSAGE)) continue;
            object3 = this.nodeCache;
            object2 = ((Descriptors$FieldDescriptor)object4).getMessageType();
            if ((object3 = (DescriptorMessageInfoFactory$IsInitializedCheckAnalyzer$Node)object3.get(object2)) == null) {
                object4 = ((Descriptors$FieldDescriptor)object4).getMessageType();
                object4 = this.dfs((Descriptors$Descriptor)object4);
                n10 = descriptorMessageInfoFactory$IsInitializedCheckAnalyzer$Node.lowLink;
                n11 = ((DescriptorMessageInfoFactory$IsInitializedCheckAnalyzer$Node)object4).lowLink;
                descriptorMessageInfoFactory$IsInitializedCheckAnalyzer$Node.lowLink = n11 = Math.min(n10, n11);
                continue;
            }
            object4 = ((DescriptorMessageInfoFactory$IsInitializedCheckAnalyzer$Node)object3).component;
            if (object4 != null) continue;
            n11 = descriptorMessageInfoFactory$IsInitializedCheckAnalyzer$Node.lowLink;
            n10 = ((DescriptorMessageInfoFactory$IsInitializedCheckAnalyzer$Node)object3).lowLink;
            descriptorMessageInfoFactory$IsInitializedCheckAnalyzer$Node.lowLink = n11 = Math.min(n11, n10);
        }
        int n12 = descriptorMessageInfoFactory$IsInitializedCheckAnalyzer$Node.index;
        n11 = descriptorMessageInfoFactory$IsInitializedCheckAnalyzer$Node.lowLink;
        if (n12 == n11) {
            n11 = 0;
            object4 = null;
            object = new DescriptorMessageInfoFactory$IsInitializedCheckAnalyzer$StronglyConnectedComponent(null);
            do {
                object4 = (DescriptorMessageInfoFactory$IsInitializedCheckAnalyzer$Node)this.stack.pop();
                ((DescriptorMessageInfoFactory$IsInitializedCheckAnalyzer$Node)object4).component = object;
                object3 = ((DescriptorMessageInfoFactory$IsInitializedCheckAnalyzer$StronglyConnectedComponent)object).messages;
                object2 = ((DescriptorMessageInfoFactory$IsInitializedCheckAnalyzer$Node)object4).descriptor;
                object3.add(object2);
            } while (object4 != descriptorMessageInfoFactory$IsInitializedCheckAnalyzer$Node);
            this.analyze((DescriptorMessageInfoFactory$IsInitializedCheckAnalyzer$StronglyConnectedComponent)object);
        }
        return descriptorMessageInfoFactory$IsInitializedCheckAnalyzer$Node;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean needsIsInitializedCheck(Descriptors$Descriptor object) {
        Object object2 = (Boolean)this.resultCache.get(object);
        if (object2 != null) {
            return (Boolean)object2;
        }
        synchronized (this) {
            object2 = this.resultCache;
            object2 = object2.get(object);
            object2 = (Boolean)object2;
            if (object2 != null) {
                return (Boolean)object2;
            }
            object = this.dfs((Descriptors$Descriptor)object);
            object = ((DescriptorMessageInfoFactory$IsInitializedCheckAnalyzer$Node)object).component;
            return ((DescriptorMessageInfoFactory$IsInitializedCheckAnalyzer$StronglyConnectedComponent)object).needsIsInitializedCheck;
        }
    }
}

