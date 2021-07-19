/*
 * Decompiled with CFR 0.151.
 */
package f.m2;

import f.h2.t.f0;
import f.m2.r;
import f.m2.s;
import f.m2.v;
import f.x1.u;
import java.lang.annotation.Annotation;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Objects;
import kotlin.NotImplementedError;
import kotlin.reflect.TypesJVMKt;

public final class x
implements TypeVariable,
v {
    private final s a;

    public x(s s10) {
        f0.p(s10, "typeParameter");
        this.a = s10;
    }

    public final Annotation[] a() {
        return new Annotation[0];
    }

    public final Annotation b(Class clazz) {
        f0.p(clazz, "annotationClass");
        return null;
    }

    public final Annotation[] c() {
        return new Annotation[0];
    }

    public final Annotation[] d() {
        return new Annotation[0];
    }

    public boolean equals(Object object) {
        boolean bl2;
        String string2;
        Object object2;
        boolean bl3 = object instanceof TypeVariable;
        if (bl3 && (bl3 = f0.g(object2 = this.getName(), string2 = (object = (TypeVariable)object).getName())) && (bl2 = f0.g(object2 = this.getGenericDeclaration(), object = object.getGenericDeclaration()))) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public Type[] getBounds() {
        Type[] typeArray = this.a.getUpperBounds();
        int n10 = u.Y((Iterable)typeArray, 10);
        ArrayList<Object> arrayList = new ArrayList<Object>(n10);
        typeArray = typeArray.iterator();
        while ((n10 = (int)(typeArray.hasNext() ? 1 : 0)) != 0) {
            Object object = (r)typeArray.next();
            boolean bl2 = true;
            object = TypesJVMKt.a((r)object, bl2);
            arrayList.add(object);
        }
        typeArray = new Type[]{};
        typeArray = arrayList.toArray(typeArray);
        Objects.requireNonNull(typeArray, "null cannot be cast to non-null type kotlin.Array<T>");
        return typeArray;
    }

    public GenericDeclaration getGenericDeclaration() {
        CharSequence charSequence = new StringBuilder();
        charSequence.append("getGenericDeclaration() is not yet supported for type variables created from KType: ");
        Object object = this.a;
        charSequence.append(object);
        charSequence = charSequence.toString();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("An operation is not implemented: ");
        stringBuilder.append((String)charSequence);
        charSequence = stringBuilder.toString();
        object = new NotImplementedError((String)charSequence);
        throw object;
    }

    public String getName() {
        return this.a.getName();
    }

    public String getTypeName() {
        return this.getName();
    }

    public int hashCode() {
        int n10 = this.getName().hashCode();
        int n11 = this.getGenericDeclaration().hashCode();
        return n10 ^ n11;
    }

    public String toString() {
        return this.getTypeName();
    }
}

