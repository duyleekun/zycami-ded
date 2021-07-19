/*
 * Decompiled with CFR 0.151.
 */
package f.h2.t;

import f.h2.t.b0;
import f.h2.t.l0;
import f.h2.t.s;
import f.h2.t.v0;
import f.m2.d;
import f.m2.g;
import f.m2.h;
import f.m2.i;
import f.m2.k;
import f.m2.l;
import f.m2.m;
import f.m2.o;
import f.m2.p;
import f.m2.q;
import f.m2.r;
import java.util.List;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.MutablePropertyReference0;
import kotlin.jvm.internal.MutablePropertyReference1;
import kotlin.jvm.internal.MutablePropertyReference2;
import kotlin.jvm.internal.PropertyReference0;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference2;
import kotlin.jvm.internal.TypeReference;
import kotlin.reflect.KVariance;

public class o0 {
    private static final String a = "kotlin.jvm.functions.";

    public d a(Class clazz) {
        s s10 = new s(clazz);
        return s10;
    }

    public d b(Class clazz, String object) {
        object = new s(clazz);
        return object;
    }

    public i c(FunctionReference functionReference) {
        return functionReference;
    }

    public d d(Class clazz) {
        s s10 = new s(clazz);
        return s10;
    }

    public d e(Class clazz, String object) {
        object = new s(clazz);
        return object;
    }

    public h f(Class clazz, String string2) {
        l0 l02 = new l0(clazz, string2);
        return l02;
    }

    public k g(MutablePropertyReference0 mutablePropertyReference0) {
        return mutablePropertyReference0;
    }

    public l h(MutablePropertyReference1 mutablePropertyReference1) {
        return mutablePropertyReference1;
    }

    public m i(MutablePropertyReference2 mutablePropertyReference2) {
        return mutablePropertyReference2;
    }

    public o j(PropertyReference0 propertyReference0) {
        return propertyReference0;
    }

    public p k(PropertyReference1 propertyReference1) {
        return propertyReference1;
    }

    public q l(PropertyReference2 propertyReference2) {
        return propertyReference2;
    }

    public String m(b0 object) {
        String string2;
        boolean n10 = ((String)(object = object.getClass().getGenericInterfaces()[0].toString())).startsWith(string2 = a);
        if (n10) {
            int n11 = 21;
            object = ((String)object).substring(n11);
        }
        return object;
    }

    public String n(Lambda lambda2) {
        return this.m(lambda2);
    }

    public void o(f.m2.s s10, List list) {
        ((v0)s10).j(list);
    }

    public r p(g g10, List list, boolean bl2) {
        TypeReference typeReference = new TypeReference(g10, list, bl2);
        return typeReference;
    }

    public f.m2.s q(Object object, String string2, KVariance kVariance, boolean bl2) {
        v0 v02 = new v0(object, string2, kVariance, bl2);
        return v02;
    }
}

