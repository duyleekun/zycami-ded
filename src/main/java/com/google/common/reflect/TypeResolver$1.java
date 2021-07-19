/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.reflect;

import com.google.common.base.Preconditions;
import com.google.common.reflect.TypeResolver;
import com.google.common.reflect.TypeResolver$TypeVariableKey;
import com.google.common.reflect.TypeVisitor;
import com.google.common.reflect.Types;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Map;

public final class TypeResolver$1
extends TypeVisitor {
    public final /* synthetic */ Map val$mappings;
    public final /* synthetic */ Type val$to;

    public TypeResolver$1(Map map, Type type) {
        this.val$mappings = map;
        this.val$to = type;
    }

    public void visitClass(Class object) {
        Object object2 = this.val$to;
        boolean bl2 = object2 instanceof WildcardType;
        if (bl2) {
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("No type mapping from ");
        stringBuilder.append(object);
        stringBuilder.append(" to ");
        object = this.val$to;
        stringBuilder.append(object);
        object = stringBuilder.toString();
        object2 = new IllegalArgumentException((String)object);
        throw object2;
    }

    public void visitGenericArrayType(GenericArrayType type) {
        Map map;
        Type type2 = this.val$to;
        boolean bl2 = type2 instanceof WildcardType;
        if (bl2) {
            return;
        }
        if ((type2 = Types.getComponentType(type2)) != null) {
            bl2 = true;
        } else {
            bl2 = false;
            map = null;
        }
        Type type3 = this.val$to;
        Preconditions.checkArgument(bl2, "%s is not an array type.", (Object)type3);
        map = this.val$mappings;
        type = type.getGenericComponentType();
        TypeResolver.access$000(map, type, type2);
    }

    public void visitParameterizedType(ParameterizedType object) {
        int n10;
        Object object2;
        Type[] typeArray;
        Type type = this.val$to;
        boolean bl2 = type instanceof WildcardType;
        if (bl2) {
            return;
        }
        type = (ParameterizedType)TypeResolver.access$100(ParameterizedType.class, type);
        Object object3 = object.getOwnerType();
        if (object3 != null && (object3 = type.getOwnerType()) != null) {
            object3 = this.val$mappings;
            typeArray = object.getOwnerType();
            object2 = type.getOwnerType();
            TypeResolver.access$000((Map)object3, (Type)typeArray, (Type)object2);
        }
        object3 = object.getRawType();
        typeArray = type.getRawType();
        bl2 = object3.equals(typeArray);
        typeArray = this.val$to;
        object2 = "Inconsistent raw type: %s vs. %s";
        Preconditions.checkArgument(bl2, (String)object2, object, (Object)typeArray);
        object3 = object.getActualTypeArguments();
        typeArray = type.getActualTypeArguments();
        int n11 = ((Type[])object3).length;
        int n12 = typeArray.length;
        int n13 = 0;
        if (n11 == n12) {
            n11 = 1;
        } else {
            n11 = 0;
            object2 = null;
        }
        String string2 = "%s not compatible with %s";
        Preconditions.checkArgument(n11 != 0, string2, object, (Object)type);
        while (n13 < (n10 = ((Type[])object3).length)) {
            object = this.val$mappings;
            type = object3[n13];
            object2 = typeArray[n13];
            TypeResolver.access$000((Map)object, type, (Type)object2);
            ++n13;
        }
    }

    public void visitTypeVariable(TypeVariable type) {
        Map map = this.val$mappings;
        TypeResolver$TypeVariableKey typeResolver$TypeVariableKey = new TypeResolver$TypeVariableKey((TypeVariable)type);
        type = this.val$to;
        map.put(typeResolver$TypeVariableKey, type);
    }

    public void visitWildcardType(WildcardType object) {
        int n10;
        Map map;
        Type[] typeArray = this.val$to;
        boolean bl2 = typeArray instanceof WildcardType;
        if (!bl2) {
            return;
        }
        typeArray = (WildcardType)typeArray;
        Object object2 = object.getUpperBounds();
        Object object3 = typeArray.getUpperBounds();
        Type[] typeArray2 = object.getLowerBounds();
        typeArray = typeArray.getLowerBounds();
        int n11 = ((Type[])object2).length;
        int n12 = ((Type[])object3).length;
        int n13 = 0;
        if (n11 == n12 && (n11 = typeArray2.length) == (n12 = typeArray.length)) {
            n11 = 1;
        } else {
            n11 = 0;
            map = null;
        }
        Type type = this.val$to;
        Object object4 = "Incompatible type: %s vs. %s";
        Preconditions.checkArgument(n11 != 0, (String)object4, object, (Object)type);
        object = null;
        for (n10 = 0; n10 < (n11 = ((Type[])object2).length); ++n10) {
            map = this.val$mappings;
            type = object2[n10];
            object4 = object3[n10];
            TypeResolver.access$000(map, type, (Type)object4);
        }
        while (n13 < (n10 = typeArray2.length)) {
            object = this.val$mappings;
            object2 = typeArray2[n13];
            object3 = typeArray[n13];
            TypeResolver.access$000((Map)object, (Type)object2, (Type)object3);
            ++n13;
        }
    }
}

