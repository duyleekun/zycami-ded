/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.Parcelable
 *  android.util.Log
 */
package com.huawei.hms.core.aidl;

import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class e {
    private Bundle a(String string2, Bundle bundle, Object object) {
        Bundle bundle2 = new Bundle();
        this.a(string2, object, bundle2);
        bundle.putBundle("_next_item_", bundle2);
        return bundle2;
    }

    private Object a(Field object, Bundle object2) {
        Object object3;
        block11: {
            int n10;
            block10: {
                int n11;
                String string2;
                Bundle bundle;
                String string3 = ((Field)object).getName();
                object3 = object2.get(string3);
                boolean bl2 = object3 instanceof Bundle;
                if (!bl2) break block11;
                Object object4 = object3;
                try {
                    bundle = (Bundle)object3;
                    string2 = "_val_type_";
                    n11 = -1;
                }
                catch (Exception exception) {
                    object = new StringBuilder();
                    ((StringBuilder)object).append("decode, read value of the field exception, field name: ");
                    ((StringBuilder)object).append(string3);
                    object = ((StringBuilder)object).toString();
                    Log.e((String)"MessageCodec", (String)object);
                    return null;
                }
                n10 = bundle.getInt(string2, n11);
                n11 = 1;
                if (n10 != n11) break block10;
                object = ((Field)object).getGenericType();
                return this.a((Type)object, bundle);
            }
            if (n10 != 0) break block11;
            object = ((Field)object).getType();
            object = ((Class)object).newInstance();
            object = (IMessageEntity)object;
            Bundle bundle = (Bundle)object3;
            return this.a(bundle, (IMessageEntity)object);
        }
        return object3;
    }

    private void a(IMessageEntity iMessageEntity, Field field, Bundle object) {
        if ((object = this.a(field, (Bundle)object)) != null) {
            boolean bl2 = field.isAccessible();
            boolean bl3 = true;
            field.setAccessible(bl3);
            field.set(iMessageEntity, object);
            field.setAccessible(bl2);
        }
    }

    private void b(IMessageEntity object, Field field, Bundle bundle) {
        boolean bl2 = field.isAccessible();
        field.setAccessible(true);
        String string2 = field.getName();
        object = field.get(object);
        this.a(string2, object, bundle);
        field.setAccessible(bl2);
    }

    private boolean b(String string2, Object object, Bundle bundle) {
        block9: {
            block3: {
                boolean bl2;
                block8: {
                    block7: {
                        block6: {
                            block5: {
                                block4: {
                                    block2: {
                                        bl2 = object instanceof String;
                                        if (!bl2) break block2;
                                        object = (String)object;
                                        bundle.putString(string2, (String)object);
                                        break block3;
                                    }
                                    bl2 = object instanceof Integer;
                                    if (!bl2) break block4;
                                    object = (Integer)object;
                                    int n10 = (Integer)object;
                                    bundle.putInt(string2, n10);
                                    break block3;
                                }
                                bl2 = object instanceof Short;
                                if (!bl2) break block5;
                                object = (Short)object;
                                short s10 = (Short)object;
                                bundle.putShort(string2, s10);
                                break block3;
                            }
                            bl2 = object instanceof Long;
                            if (!bl2) break block6;
                            object = (Long)object;
                            long l10 = (Long)object;
                            bundle.putLong(string2, l10);
                            break block3;
                        }
                        bl2 = object instanceof Float;
                        if (!bl2) break block7;
                        object = (Float)object;
                        float f10 = ((Float)object).floatValue();
                        bundle.putFloat(string2, f10);
                        break block3;
                    }
                    bl2 = object instanceof Double;
                    if (!bl2) break block8;
                    object = (Double)object;
                    double d10 = (Double)object;
                    bundle.putDouble(string2, d10);
                    break block3;
                }
                bl2 = object instanceof Boolean;
                if (!bl2) break block9;
                object = (Boolean)object;
                boolean bl3 = (Boolean)object;
                bundle.putBoolean(string2, bl3);
            }
            return true;
        }
        return false;
    }

    public Bundle a(IMessageEntity iMessageEntity, Bundle bundle) {
        for (Class<?> clazz = iMessageEntity.getClass(); clazz != null; clazz = clazz.getSuperclass()) {
            for (Field field : clazz.getDeclaredFields()) {
                Class<Packed> clazz2 = Packed.class;
                boolean bl2 = field.isAnnotationPresent(clazz2);
                if (!bl2) continue;
                try {
                    this.b(iMessageEntity, field, bundle);
                }
                catch (IllegalAccessException | IllegalArgumentException exception) {
                    clazz2 = new StringBuilder();
                    String string2 = "encode, get value of the field exception, field name: ";
                    ((StringBuilder)((Object)clazz2)).append(string2);
                    String string3 = field.getName();
                    ((StringBuilder)((Object)clazz2)).append(string3);
                    String string4 = ((StringBuilder)((Object)clazz2)).toString();
                    clazz2 = "MessageCodec";
                    Log.e((String)((Object)clazz2), (String)string4);
                }
            }
        }
        return bundle;
    }

    public IMessageEntity a(Bundle bundle, IMessageEntity iMessageEntity) {
        if (bundle == null) {
            return iMessageEntity;
        }
        Class clazz = this.getClass().getClassLoader();
        bundle.setClassLoader((ClassLoader)((Object)clazz));
        for (clazz = iMessageEntity.getClass(); clazz != null; clazz = clazz.getSuperclass()) {
            for (Field field : clazz.getDeclaredFields()) {
                Class<Packed> clazz2 = Packed.class;
                boolean bl2 = field.isAnnotationPresent(clazz2);
                if (!bl2) continue;
                try {
                    this.a(iMessageEntity, field, bundle);
                }
                catch (IllegalAccessException | IllegalArgumentException exception) {
                    clazz2 = new StringBuilder();
                    String string2 = "decode, set value of the field exception, field name:";
                    ((StringBuilder)((Object)clazz2)).append(string2);
                    String string3 = field.getName();
                    ((StringBuilder)((Object)clazz2)).append(string3);
                    String string4 = ((StringBuilder)((Object)clazz2)).toString();
                    clazz2 = "MessageCodec";
                    Log.e((String)((Object)clazz2), (String)string4);
                }
            }
        }
        return iMessageEntity;
    }

    public List a(Type object, Bundle bundle) {
        ArrayList<Object> arrayList = new ArrayList<Object>();
        String string2 = "_next_item_";
        for (bundle = bundle.getBundle(string2); bundle != null; bundle = bundle.getBundle(string2)) {
            Object object2 = bundle.get("_value_");
            Object object3 = object2.getClass();
            int n10 = object3.isPrimitive();
            if (n10 == 0 && (n10 = object2 instanceof String) == 0 && (n10 = object2 instanceof Serializable) == 0) {
                int n11;
                n10 = object2 instanceof Bundle;
                if (n10 == 0) continue;
                String string3 = "_val_type_";
                n10 = (object2 = (Bundle)object2).getInt(string3, -1);
                if (n10 != (n11 = 1)) {
                    if (n10 == 0) {
                        object3 = object;
                        object3 = ((ParameterizedType)object).getActualTypeArguments();
                        n11 = 0;
                        string3 = null;
                        object3 = (IMessageEntity)((Class)object3[0]).newInstance();
                        object2 = this.a((Bundle)object2, (IMessageEntity)object3);
                        arrayList.add(object2);
                        continue;
                    }
                    object = new InstantiationException("Unknown type can not be supported");
                    throw object;
                }
                object = new InstantiationException("Nested List can not be supported");
                throw object;
            }
            arrayList.add(object2);
        }
        return arrayList;
    }

    public void a(String string2, Object object, Bundle object2) {
        if (object == null) {
            return;
        }
        boolean bl2 = this.b(string2, object, (Bundle)object2);
        if (bl2) {
            return;
        }
        bl2 = object instanceof CharSequence;
        if (bl2) {
            object = (CharSequence)object;
            object2.putCharSequence(string2, (CharSequence)object);
        } else {
            bl2 = object instanceof Parcelable;
            if (bl2) {
                object = (Parcelable)object;
                object2.putParcelable(string2, (Parcelable)object);
            } else {
                bl2 = object instanceof byte[];
                if (bl2) {
                    object = (byte[])object;
                    object2.putByteArray(string2, (byte[])object);
                } else {
                    bl2 = object instanceof List;
                    if (bl2) {
                        object = (List)object;
                        this.a(string2, (List)object, (Bundle)object2);
                    } else {
                        bl2 = object instanceof Serializable;
                        if (bl2) {
                            object = (Serializable)object;
                            object2.putSerializable(string2, (Serializable)object);
                        } else {
                            bl2 = object instanceof IMessageEntity;
                            if (bl2) {
                                object = (IMessageEntity)object;
                                Bundle bundle = new Bundle();
                                object = this.a((IMessageEntity)object, bundle);
                                bl2 = false;
                                bundle = null;
                                String string3 = "_val_type_";
                                object.putInt(string3, 0);
                                object2.putBundle(string2, (Bundle)object);
                            } else {
                                object = new StringBuilder();
                                object2 = "cannot support type, ";
                                ((StringBuilder)object).append((String)object2);
                                ((StringBuilder)object).append(string2);
                                string2 = ((StringBuilder)object).toString();
                                object = "MessageCodec";
                                Log.e((String)object, (String)string2);
                            }
                        }
                    }
                }
            }
        }
    }

    public void a(String string2, List object, Bundle bundle) {
        boolean bl2;
        object = object.iterator();
        Bundle bundle2 = null;
        while (bl2 = object.hasNext()) {
            Object e10 = object.next();
            if (bundle2 == null) {
                bundle2 = new Bundle();
                bundle.putBundle(string2, bundle2);
                int n10 = 1;
                String string3 = "_val_type_";
                bundle2.putInt(string3, n10);
            }
            String string4 = "_value_";
            bundle2 = this.a(string4, bundle2, e10);
        }
    }
}

