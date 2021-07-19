/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import java.io.Serializable;
import java.lang.reflect.Field;

public final class GeneratedMessageLite$SerializedForm
implements Serializable {
    private static final long serialVersionUID;
    private final byte[] asBytes;
    private final Class messageClass;
    private final String messageClassName;

    public GeneratedMessageLite$SerializedForm(MessageLite object) {
        Object object2 = object.getClass();
        this.messageClass = object2;
        this.messageClassName = object2 = ((Class)object2).getName();
        object = object.toByteArray();
        this.asBytes = (byte[])object;
    }

    public static GeneratedMessageLite$SerializedForm of(MessageLite messageLite) {
        GeneratedMessageLite$SerializedForm generatedMessageLite$SerializedForm = new GeneratedMessageLite$SerializedForm(messageLite);
        return generatedMessageLite$SerializedForm;
    }

    private Object readResolveFallback() {
        Object object = this.resolveMessageClass();
        Object object2 = "defaultInstance";
        object = ((Class)object).getDeclaredField((String)object2);
        boolean bl2 = true;
        ((Field)object).setAccessible(bl2);
        bl2 = false;
        object2 = null;
        object = ((Field)object).get(null);
        object = (MessageLite)object;
        object = object.newBuilderForType();
        object2 = this.asBytes;
        object = object.mergeFrom((byte[])object2);
        try {
            return object.buildPartial();
        }
        catch (InvalidProtocolBufferException invalidProtocolBufferException) {
            object2 = new RuntimeException("Unable to understand proto buffer", invalidProtocolBufferException);
            throw object2;
        }
        catch (IllegalAccessException illegalAccessException) {
            object2 = new RuntimeException("Unable to call parsePartialFrom", illegalAccessException);
            throw object2;
        }
        catch (SecurityException securityException) {
            CharSequence charSequence = new StringBuilder();
            charSequence.append("Unable to call defaultInstance in ");
            String string2 = this.messageClassName;
            charSequence.append(string2);
            charSequence = charSequence.toString();
            object2 = new RuntimeException((String)charSequence, securityException);
            throw object2;
        }
        catch (NoSuchFieldException noSuchFieldException) {
            CharSequence charSequence = new StringBuilder();
            charSequence.append("Unable to find defaultInstance in ");
            String string3 = this.messageClassName;
            charSequence.append(string3);
            charSequence = charSequence.toString();
            object2 = new RuntimeException((String)charSequence, noSuchFieldException);
            throw object2;
        }
        catch (ClassNotFoundException classNotFoundException) {
            CharSequence charSequence = new StringBuilder();
            charSequence.append("Unable to find proto buffer class: ");
            String string4 = this.messageClassName;
            charSequence.append(string4);
            charSequence = charSequence.toString();
            object2 = new RuntimeException((String)charSequence, classNotFoundException);
            throw object2;
        }
    }

    private Class resolveMessageClass() {
        Class<?> clazz = this.messageClass;
        if (clazz == null) {
            clazz = Class.forName(this.messageClassName);
        }
        return clazz;
    }

    public Object readResolve() {
        Object object = this.resolveMessageClass();
        Object object2 = "DEFAULT_INSTANCE";
        object = ((Class)object).getDeclaredField((String)object2);
        boolean bl2 = true;
        ((Field)object).setAccessible(bl2);
        bl2 = false;
        object2 = null;
        object = ((Field)object).get(null);
        object = (MessageLite)object;
        object = object.newBuilderForType();
        object2 = this.asBytes;
        object = object.mergeFrom((byte[])object2);
        try {
            return object.buildPartial();
        }
        catch (InvalidProtocolBufferException invalidProtocolBufferException) {
            object2 = new RuntimeException("Unable to understand proto buffer", invalidProtocolBufferException);
            throw object2;
        }
        catch (IllegalAccessException illegalAccessException) {
            object2 = new RuntimeException("Unable to call parsePartialFrom", illegalAccessException);
            throw object2;
        }
        catch (SecurityException securityException) {
            CharSequence charSequence = new StringBuilder();
            charSequence.append("Unable to call DEFAULT_INSTANCE in ");
            String string2 = this.messageClassName;
            charSequence.append(string2);
            charSequence = charSequence.toString();
            object2 = new RuntimeException((String)charSequence, securityException);
            throw object2;
        }
        catch (NoSuchFieldException noSuchFieldException) {
            return this.readResolveFallback();
        }
        catch (ClassNotFoundException classNotFoundException) {
            CharSequence charSequence = new StringBuilder();
            charSequence.append("Unable to find proto buffer class: ");
            String string3 = this.messageClassName;
            charSequence.append(string3);
            charSequence = charSequence.toString();
            object2 = new RuntimeException((String)charSequence, classNotFoundException);
            throw object2;
        }
    }
}

