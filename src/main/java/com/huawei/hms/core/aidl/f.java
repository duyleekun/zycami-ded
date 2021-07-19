/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package com.huawei.hms.core.aidl;

import android.os.Bundle;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.e;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class f
extends e {
    public List a(Type object, Bundle bundle) {
        String string2 = "_list_size_";
        int n10 = bundle.getInt(string2);
        ArrayList<Object> arrayList = new ArrayList<Object>(n10);
        for (int i10 = 0; i10 < n10; ++i10) {
            Object object2 = new StringBuilder();
            ((StringBuilder)object2).append("_list_item_");
            ((StringBuilder)object2).append(i10);
            object2 = ((StringBuilder)object2).toString();
            object2 = bundle.get((String)object2);
            Object object3 = object2.getClass();
            int n11 = ((Class)object3).isPrimitive();
            if (n11 == 0 && (n11 = object2 instanceof String) == 0 && (n11 = object2 instanceof Serializable) == 0) {
                int n12;
                n11 = object2 instanceof Bundle;
                if (n11 == 0) continue;
                String string3 = "_val_type_";
                n11 = (object2 = (Bundle)object2).getInt(string3, -1);
                if (n11 != (n12 = 1)) {
                    if (n11 == 0) {
                        object3 = object;
                        object3 = (IMessageEntity)((Class)((ParameterizedType)object).getActualTypeArguments()[0]).newInstance();
                        object2 = this.a((Bundle)object2, (IMessageEntity)object3);
                        arrayList.add(object2);
                        continue;
                    }
                    object = new InstantiationException("Unknown type can not be supported");
                    throw object;
                }
                object = new InstantiationException("Nested List can not be supported");
                throw object;
            }
            arrayList.add(object2);
        }
        return arrayList;
    }

    public void a(String string2, List list, Bundle bundle) {
        Bundle bundle2 = new Bundle();
        int n10 = 1;
        bundle2.putInt("_val_type_", n10);
        int n11 = list.size();
        CharSequence charSequence = "_list_size_";
        bundle2.putInt((String)charSequence, n11);
        for (n11 = 0; n11 < (n10 = list.size()); ++n11) {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append("_list_item_");
            ((StringBuilder)charSequence).append(n11);
            charSequence = ((StringBuilder)charSequence).toString();
            Object e10 = list.get(n11);
            this.a((String)charSequence, e10, bundle2);
        }
        bundle.putBundle(string2, bundle2);
    }
}

