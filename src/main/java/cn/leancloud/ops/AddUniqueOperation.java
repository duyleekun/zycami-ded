/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.ops;

import cn.leancloud.json.JSONArray;
import cn.leancloud.ops.AddOperation;
import java.util.ArrayList;
import java.util.List;

public class AddUniqueOperation
extends AddOperation {
    public AddUniqueOperation(String string2, Object object) {
        super(string2, object);
        this.op = "AddUnique";
    }

    public Object apply(Object object) {
        Object[] objectArray;
        int n10;
        boolean bl2;
        if ((object = super.apply(object)) != null && ((bl2 = object instanceof List) || (n10 = object instanceof JSONArray) != 0)) {
            if (bl2) {
                object = ((List)object).toArray();
                objectArray = new ArrayList();
                for (Object object2 : object) {
                    boolean bl3 = objectArray.contains(object2);
                    if (bl3) continue;
                    objectArray.add(object2);
                }
            } else {
                object = (JSONArray)object;
                objectArray = object.toArray();
                object.clear();
                object = new ArrayList();
                int n11 = objectArray.length;
                while (n10 < n11) {
                    Object object3 = objectArray[n10];
                    boolean bl4 = object.contains(object3);
                    if (!bl4) {
                        object.add(object3);
                    }
                    ++n10;
                }
                objectArray = object;
            }
        } else {
            bl2 = false;
            objectArray = null;
        }
        return objectArray;
    }
}

