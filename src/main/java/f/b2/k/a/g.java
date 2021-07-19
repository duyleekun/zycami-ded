/*
 * Decompiled with CFR 0.151.
 */
package f.b2.k.a;

import f.b2.k.a.g$a;
import f.h2.t.f0;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Method;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;

public final class g {
    private static final g$a a;
    public static g$a b;
    public static final g c;

    static {
        Object object = new g();
        c = object;
        a = object = new g$a(null, null, null);
    }

    private g() {
    }

    private final g$a a(BaseContinuationImpl genericDeclaration) {
        Object object;
        Object object2 = Class.class;
        GenericDeclaration genericDeclaration2 = "getModule";
        Object object3 = null;
        try {
            object = new Class[]{};
        }
        catch (Exception exception) {
            genericDeclaration = a;
            b = genericDeclaration;
            return genericDeclaration;
        }
        object2 = ((Class)object2).getDeclaredMethod((String)((Object)genericDeclaration2), (Class<?>)object);
        genericDeclaration2 = genericDeclaration.getClass();
        genericDeclaration2 = genericDeclaration2.getClassLoader();
        object = "java.lang.Module";
        genericDeclaration2 = ((ClassLoader)((Object)genericDeclaration2)).loadClass((String)object);
        object = "getDescriptor";
        Class[] classArray = new Class[]{};
        genericDeclaration2 = genericDeclaration2.getDeclaredMethod((String)object, classArray);
        genericDeclaration = genericDeclaration.getClass();
        genericDeclaration = genericDeclaration.getClassLoader();
        object = "java.lang.module.ModuleDescriptor";
        genericDeclaration = ((ClassLoader)((Object)genericDeclaration)).loadClass((String)object);
        object = "name";
        object3 = new Class[]{};
        genericDeclaration = genericDeclaration.getDeclaredMethod((String)object, (Class<?>)object3);
        b = object3 = new g$a((Method)object2, (Method)genericDeclaration2, (Method)genericDeclaration);
        return object3;
    }

    public final String b(BaseContinuationImpl object) {
        f0.p(object, "continuation");
        Object object2 = b;
        if (object2 == null) {
            object2 = this.a((BaseContinuationImpl)object);
        }
        Object object3 = a;
        Object object4 = null;
        if (object2 == object3) {
            return null;
        }
        object3 = ((g$a)object2).a;
        if (object3 != null) {
            object = object.getClass();
            Object[] objectArray = new Object[0];
            if ((object = object3.invoke(object, objectArray)) != null && (object3 = ((g$a)object2).b) != null && (object = object3.invoke(object, objectArray = new Object[0])) != null) {
                object2 = ((g$a)object2).c;
                if (object2 != null) {
                    object3 = new Object[]{};
                    object = ((Method)object2).invoke(object, object3);
                } else {
                    object = null;
                }
                boolean bl2 = object instanceof String;
                if (bl2) {
                    object4 = object;
                }
                object4 = (String)object4;
            }
        }
        return object4;
    }
}

