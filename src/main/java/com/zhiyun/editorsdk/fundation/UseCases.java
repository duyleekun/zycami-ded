/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editorsdk.fundation;

import com.zhiyun.editorsdk.fundation.IUseCase;
import d.v.j.b;
import d.v.v.q.h;
import m.a.a;

public class UseCases {
    public static boolean a(String objectArray) {
        int n10;
        int n11 = b.b((String)objectArray);
        boolean bl2 = true;
        if (n11 != 0) {
            return bl2;
        }
        Object object = h.e0((String)objectArray);
        if (object != null && (n10 = object.getWidth()) != 0 && (n11 = object.getHeight()) != 0) {
            long l10;
            long l11 = h.Z((String)objectArray);
            long l12 = l11 - (l10 = 0L);
            Object object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (object2 == false) {
                objectArray = new Object[bl2];
                objectArray[0] = object = Long.valueOf(l11);
                a.i("media duration 0:%d", objectArray);
                return bl2;
            }
            return false;
        }
        object = new Object[bl2];
        object[0] = objectArray;
        a.i("media width and height error:%s", object);
        return bl2;
    }

    public static boolean b(IUseCase iUseCase) {
        boolean bl2;
        if (iUseCase == null) {
            bl2 = true;
        } else {
            bl2 = false;
            iUseCase = null;
        }
        return bl2;
    }
}

