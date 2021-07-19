/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editorsdk.fundation;

import com.zhiyun.editorsdk.fundation.IUseCase;
import d.v.h.e.c;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UseCaseFactory {
    private c a;
    private List b;
    private Map c;

    public UseCaseFactory(c c10, List list) {
        HashMap hashMap;
        this.c = hashMap = new HashMap();
        this.a = c10;
        this.b = list;
    }

    private String b(Class clazz) {
        return clazz.getSimpleName();
    }

    public IUseCase a(Class object) {
        Object object2 = this.c;
        Object object3 = this.b((Class)object);
        if ((object2 = (IUseCase)object2.get(object3)) != null) {
            return object2;
        }
        object2 = null;
        int n10 = 2;
        Object object4 = new Class[n10];
        Object object5 = c.class;
        object4[0] = object5;
        object5 = List.class;
        int n11 = 1;
        object4[n11] = object5;
        object4 = ((Class)object).getDeclaredConstructor((Class<?>)object4);
        object3 = new Object[n10];
        object5 = this.a;
        object3[0] = object5;
        object5 = this.b;
        object3[n11] = object5;
        object3 = ((Constructor)object4).newInstance(object3);
        try {
            object2 = object3 = (IUseCase)object3;
        }
        catch (IllegalAccessException illegalAccessException) {
            illegalAccessException.printStackTrace();
        }
        catch (NoSuchMethodException noSuchMethodException) {
            noSuchMethodException.printStackTrace();
        }
        catch (InvocationTargetException invocationTargetException) {
            invocationTargetException.printStackTrace();
        }
        catch (InstantiationException instantiationException) {
            instantiationException.printStackTrace();
        }
        object3 = this.c;
        object = this.b((Class)object);
        object3.put(object, object2);
        return object2;
    }
}

