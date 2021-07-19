/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.ops;

import cn.leancloud.AVObject;
import cn.leancloud.ops.BaseOperation;
import cn.leancloud.ops.ObjectFieldOperation;
import cn.leancloud.ops.Utils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class CompoundOperation
extends BaseOperation {
    private List operations;

    public CompoundOperation(String linkedList) {
        super("Compound", (String)((Object)linkedList), null, false);
        this.operations = linkedList = new LinkedList();
    }

    public CompoundOperation(String object, ObjectFieldOperation ... object2) {
        this((String)object);
        object = this.operations;
        object2 = Arrays.asList(object2);
        object.addAll(object2);
    }

    private Map encodeHeadOp() {
        int n10;
        List list = this.operations;
        int n11 = list.size();
        if (n11 < (n10 = 1)) {
            return null;
        }
        return ((ObjectFieldOperation)this.operations.get(0)).encode();
    }

    public Object apply(Object object) {
        boolean bl2;
        Iterator iterator2 = this.operations.iterator();
        while (bl2 = iterator2.hasNext()) {
            ObjectFieldOperation objectFieldOperation = (ObjectFieldOperation)iterator2.next();
            object = objectFieldOperation.apply(object);
        }
        return object;
    }

    public boolean checkCircleReference(Map map) {
        boolean bl2;
        Iterator iterator2 = this.operations.iterator();
        block0: while (true) {
            boolean bl3;
            bl2 = false;
            while (bl3 = iterator2.hasNext()) {
                ObjectFieldOperation objectFieldOperation = (ObjectFieldOperation)iterator2.next();
                if (!bl2 && !(bl2 = objectFieldOperation.checkCircleReference(map))) continue block0;
                bl2 = true;
            }
            break;
        }
        return bl2;
    }

    public Map encode() {
        return this.encodeHeadOp();
    }

    public List encodeRestOp(AVObject aVObject) {
        Object object;
        int n10;
        ArrayList<Object> arrayList = new ArrayList<Object>();
        if (aVObject == null) {
            return arrayList;
        }
        String string2 = aVObject.getRequestRawEndpoint();
        String string3 = aVObject.getRequestMethod();
        for (int i10 = 1; i10 < (n10 = (object = this.operations).size()); ++i10) {
            object = ((ObjectFieldOperation)this.operations.get(i10)).encode();
            String string4 = aVObject.getObjectId();
            object = Utils.makeCompletedRequest(string4, string2, string3, (Map)object);
            if (object == null) continue;
            arrayList.add(object);
        }
        return arrayList;
    }

    public List getSubOperations() {
        return this.operations;
    }

    public ObjectFieldOperation mergeWithPrevious(ObjectFieldOperation objectFieldOperation) {
        this.operations.add(objectFieldOperation);
        return this;
    }
}

