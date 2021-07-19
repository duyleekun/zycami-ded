/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.ops;

import cn.leancloud.AVLogger;
import cn.leancloud.json.JSONArray;
import cn.leancloud.ops.AddRelationOperation;
import cn.leancloud.ops.AddUniqueOperation;
import cn.leancloud.ops.BaseOperation;
import cn.leancloud.ops.BitAndOperation;
import cn.leancloud.ops.BitOrOperation;
import cn.leancloud.ops.BitXOROperation;
import cn.leancloud.ops.CompoundOperation;
import cn.leancloud.ops.DecrementOperation;
import cn.leancloud.ops.DeleteOperation;
import cn.leancloud.ops.IncrementOperation;
import cn.leancloud.ops.NullOperation;
import cn.leancloud.ops.ObjectFieldOperation;
import cn.leancloud.ops.RemoveOperation;
import cn.leancloud.ops.RemoveRelationOperation;
import cn.leancloud.ops.SetOperation;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AddOperation
extends BaseOperation {
    public AddOperation(String list, Object object) {
        String string2 = "Add";
        super(string2, (String)((Object)list), null, false);
        list = new List<Object>();
        this.value = list;
        if (object == null) {
            return;
        }
        boolean bl2 = object instanceof Collection;
        if (!bl2) {
            list = list;
            list.add(object);
        } else {
            list = list;
            object = (Collection)object;
            list.addAll((Collection<Object>)object);
        }
    }

    public Object apply(Object object) {
        if (object == null) {
            return this.getValue();
        }
        boolean bl2 = object instanceof List;
        if (!bl2 && !(bl2 = object instanceof JSONArray)) {
            AVLogger aVLogger = BaseOperation.LOGGER;
            CharSequence charSequence = new StringBuilder();
            charSequence.append("cannot apply AddOperation on non list attribute. targetValueType=");
            String string2 = object.getClass().getSimpleName();
            charSequence.append(string2);
            charSequence = charSequence.toString();
            aVLogger.w((String)charSequence);
        } else {
            Object object2 = this.value;
            boolean bl3 = object2 instanceof List;
            if (bl3) {
                Object object3 = object;
                object3 = (Collection)object;
                object2 = (List)object2;
                object3.addAll(object2);
            } else {
                Object object4 = object;
                object4 = (Collection)object;
                object4.add(object2);
            }
        }
        return object;
    }

    public Map encode() {
        HashMap<String, Object> hashMap = new HashMap<String, Object>(2);
        HashMap hashMap2 = this.getOperation();
        hashMap.put("__op", hashMap2);
        hashMap2 = BaseOperation.encodeObject(this.getValue());
        hashMap.put("objects", hashMap2);
        hashMap2 = new HashMap();
        String string2 = this.getField();
        hashMap2.put(string2, hashMap);
        return hashMap2;
    }

    public ObjectFieldOperation mergeWithPrevious(ObjectFieldOperation object) {
        boolean bl2 = object instanceof SetOperation;
        if (!bl2 && !(bl2 = object instanceof DeleteOperation)) {
            bl2 = object instanceof AddOperation;
            if (bl2) {
                Object object2 = this.value;
                object = ((AddOperation)object).value;
                this.value = object = this.concatCollections(object2, object);
                return this;
            }
            bl2 = object instanceof AddUniqueOperation;
            if (bl2) {
                Object object3 = this.value;
                object = ((AddOperation)object).value;
                this.value = object = this.concatCollections(object3, object);
                return this;
            }
            bl2 = object instanceof RemoveOperation;
            if (bl2) {
                String string2 = this.field;
                ObjectFieldOperation[] objectFieldOperationArray = new ObjectFieldOperation[]{object, this};
                CompoundOperation compoundOperation = new CompoundOperation(string2, objectFieldOperationArray);
                return compoundOperation;
            }
            bl2 = object instanceof CompoundOperation;
            if (bl2) {
                return ((CompoundOperation)object).mergeWithPrevious(this);
            }
            bl2 = object instanceof AddRelationOperation;
            if (bl2 || (bl2 = object instanceof RemoveRelationOperation) || (bl2 = object instanceof BitAndOperation) || (bl2 = object instanceof BitOrOperation) || (bl2 = object instanceof BitXOROperation) || (bl2 = object instanceof IncrementOperation) || (bl2 = object instanceof DecrementOperation)) {
                this.reportIllegalOperations(this, (ObjectFieldOperation)object);
            }
            object = NullOperation.gInstance;
        }
        return object;
    }
}

