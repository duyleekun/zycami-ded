/*
 * Decompiled with CFR 0.151.
 */
package k;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Optional;
import k.h;
import k.h$a;
import k.m$a;
import k.s;

public final class m
extends h$a {
    public static final h$a a;

    static {
        m m10 = new m();
        a = m10;
    }

    public h responseBodyConverter(Type object, Annotation[] object2, s s10) {
        Class<Optional> clazz;
        Class clazz2 = h$a.getRawType((Type)object);
        if (clazz2 != (clazz = Optional.class)) {
            return null;
        }
        object = (ParameterizedType)object;
        object = h$a.getParameterUpperBound(0, (ParameterizedType)object);
        object = s10.n((Type)object, (Annotation[])object2);
        object2 = new m$a((h)object);
        return object2;
    }
}

