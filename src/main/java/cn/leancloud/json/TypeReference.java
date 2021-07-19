/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.json;

import cn.leancloud.json.ParameterizedTypeImpl;
import java.io.Serializable;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class TypeReference {
    public static ConcurrentMap classTypeCache;
    public final Type type;

    static {
        ConcurrentHashMap concurrentHashMap;
        classTypeCache = concurrentHashMap = new ConcurrentHashMap(16, 0.75f, 1);
    }

    public TypeReference() {
        Type type = ((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        Type type2 = (Type)classTypeCache.get(type);
        if (type2 == null) {
            classTypeCache.putIfAbsent(type, type);
            type2 = type = classTypeCache.get(type);
            type2 = type;
        }
        this.type = type2;
    }

    public TypeReference(Type ... typeArray) {
        int n10;
        Object object = this.getClass();
        Object object2 = ((ParameterizedType)object.getGenericSuperclass()).getActualTypeArguments();
        object2 = (ParameterizedType)object2[0];
        Type type = object2.getRawType();
        object2 = object2.getActualTypeArguments();
        int n11 = 0;
        Type type2 = null;
        for (int i10 = 0; i10 < (n10 = ((Object)object2).length); ++i10) {
            Object object3 = object2[i10];
            n10 = object3 instanceof TypeVariable;
            if (n10 != 0 && n11 < (n10 = typeArray.length)) {
                n10 = n11 + 1;
                type2 = typeArray[n11];
                object2[i10] = type2;
                n11 = n10;
            }
            if ((n10 = (object3 = object2[i10]) instanceof GenericArrayType) != 0) {
                object2[i10] = object3 = TypeReference.checkPrimitiveArray((GenericArrayType)object2[i10]);
            }
            if ((n10 = (object3 = object2[i10]) instanceof ParameterizedType) == 0) continue;
            object3 = (ParameterizedType)object2[i10];
            object2[i10] = object3 = this.handlerParameterizedType((ParameterizedType)object3, typeArray, n11);
        }
        super((Type[])object2, (Type)object, type);
        object = (Type)classTypeCache.get(typeArray);
        if (object == null) {
            classTypeCache.putIfAbsent(typeArray, typeArray);
            typeArray = classTypeCache.get(typeArray);
            object = typeArray;
            object = (Type)typeArray;
        }
        this.type = object;
    }

    /*
     * Loose catch block
     * WARNING - void declaration
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static Type checkPrimitiveArray(GenericArrayType type) {
        void var0_9;
        block59: {
            Serializable serializable;
            boolean bl2;
            Object object = type.getGenericComponentType();
            String string2 = "[";
            while (bl2 = object instanceof GenericArrayType) {
                object = ((GenericArrayType)object).getGenericComponentType();
                serializable = new StringBuilder();
                ((StringBuilder)serializable).append(string2);
                ((StringBuilder)serializable).append(string2);
                string2 = ((StringBuilder)serializable).toString();
            }
            bl2 = object instanceof Class;
            if (bl2 && (bl2 = ((Class)(object = (Class)object)).isPrimitive())) {
                block58: {
                    block57: {
                        block56: {
                            block55: {
                                block54: {
                                    block53: {
                                        block52: {
                                            serializable = Boolean.TYPE;
                                            if (object != serializable) break block52;
                                            object = new StringBuilder();
                                            ((StringBuilder)object).append(string2);
                                            string2 = "Z";
                                            ((StringBuilder)object).append(string2);
                                            object = ((StringBuilder)object).toString();
                                            Class<?> clazz = Class.forName((String)object);
                                            return var0_9;
                                        }
                                        serializable = Character.TYPE;
                                        if (object != serializable) break block53;
                                        object = new StringBuilder();
                                        ((StringBuilder)object).append(string2);
                                        string2 = "C";
                                        ((StringBuilder)object).append(string2);
                                        object = ((StringBuilder)object).toString();
                                        Class<?> clazz = Class.forName((String)object);
                                        return var0_9;
                                    }
                                    serializable = Byte.TYPE;
                                    if (object != serializable) break block54;
                                    object = new StringBuilder();
                                    ((StringBuilder)object).append(string2);
                                    string2 = "B";
                                    ((StringBuilder)object).append(string2);
                                    object = ((StringBuilder)object).toString();
                                    Class<?> clazz = Class.forName((String)object);
                                    return var0_9;
                                }
                                serializable = Short.TYPE;
                                if (object != serializable) break block55;
                                object = new StringBuilder();
                                ((StringBuilder)object).append(string2);
                                string2 = "S";
                                ((StringBuilder)object).append(string2);
                                object = ((StringBuilder)object).toString();
                                Class<?> clazz = Class.forName((String)object);
                                return var0_9;
                            }
                            serializable = Integer.TYPE;
                            if (object != serializable) break block56;
                            object = new StringBuilder();
                            ((StringBuilder)object).append(string2);
                            string2 = "I";
                            ((StringBuilder)object).append(string2);
                            object = ((StringBuilder)object).toString();
                            Class<?> clazz = Class.forName((String)object);
                            return var0_9;
                        }
                        serializable = Long.TYPE;
                        if (object != serializable) break block57;
                        object = new StringBuilder();
                        ((StringBuilder)object).append(string2);
                        string2 = "J";
                        ((StringBuilder)object).append(string2);
                        object = ((StringBuilder)object).toString();
                        Class<?> clazz = Class.forName((String)object);
                        return var0_9;
                    }
                    serializable = Float.TYPE;
                    if (object != serializable) break block58;
                    object = new StringBuilder();
                    ((StringBuilder)object).append(string2);
                    string2 = "F";
                    ((StringBuilder)object).append(string2);
                    object = ((StringBuilder)object).toString();
                    Class<?> clazz = Class.forName((String)object);
                    return var0_9;
                }
                serializable = Double.TYPE;
                if (object != serializable) break block59;
                object = new StringBuilder();
                ((StringBuilder)object).append(string2);
                string2 = "D";
                ((StringBuilder)object).append(string2);
                object = ((StringBuilder)object).toString();
                Class<?> clazz = Class.forName((String)object);
            }
        }
        return var0_9;
        catch (ClassNotFoundException classNotFoundException) {
            return var0_9;
        }
    }

    private Type handlerParameterizedType(ParameterizedType object, Type[] typeArray, int n10) {
        int n11;
        Class<?> clazz = this.getClass();
        Type type = object.getRawType();
        object = object.getActualTypeArguments();
        for (int i10 = 0; i10 < (n11 = ((Type[])object).length); ++i10) {
            Type type2 = object[i10];
            n11 = type2 instanceof TypeVariable;
            if (n11 != 0 && n10 < (n11 = typeArray.length)) {
                Type type3;
                n11 = n10 + 1;
                object[i10] = type3 = typeArray[n10];
                n10 = n11;
            }
            if ((n11 = (type2 = object[i10]) instanceof GenericArrayType) != 0) {
                object[i10] = type2 = TypeReference.checkPrimitiveArray((GenericArrayType)object[i10]);
            }
            if ((n11 = (type2 = object[i10]) instanceof ParameterizedType) == 0) continue;
            object = (ParameterizedType)object[i10];
            return this.handlerParameterizedType((ParameterizedType)object, typeArray, n10);
        }
        typeArray = new ParameterizedTypeImpl((Type[])object, clazz, type);
        return typeArray;
    }

    public Type getType() {
        return this.type;
    }
}

