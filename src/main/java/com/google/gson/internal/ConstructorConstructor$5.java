/*
 * Decompiled with CFR 0.151.
 */
package com.google.gson.internal;

import com.google.gson.JsonIOException;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.ObjectConstructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.EnumSet;

public class ConstructorConstructor$5
implements ObjectConstructor {
    public final /* synthetic */ ConstructorConstructor this$0;
    public final /* synthetic */ Type val$type;

    public ConstructorConstructor$5(ConstructorConstructor constructorConstructor, Type type) {
        this.this$0 = constructorConstructor;
        this.val$type = type;
    }

    public Object construct() {
        Object object = this.val$type;
        boolean bl2 = object instanceof ParameterizedType;
        String string2 = "Invalid EnumSet type: ";
        if (bl2) {
            object = ((ParameterizedType)object).getActualTypeArguments();
            CharSequence charSequence = null;
            bl2 = (object = object[0]) instanceof Class;
            if (bl2) {
                return EnumSet.noneOf((Class)object);
            }
            charSequence = new StringBuilder();
            charSequence.append(string2);
            string2 = this.val$type.toString();
            charSequence.append(string2);
            charSequence = charSequence.toString();
            object = new JsonIOException((String)charSequence);
            throw object;
        }
        CharSequence charSequence = new StringBuilder();
        charSequence.append(string2);
        string2 = this.val$type.toString();
        charSequence.append(string2);
        charSequence = charSequence.toString();
        object = new JsonIOException((String)charSequence);
        throw object;
    }
}

