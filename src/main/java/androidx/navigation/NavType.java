/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.Parcelable
 */
package androidx.navigation;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.navigation.NavType$1;
import androidx.navigation.NavType$10;
import androidx.navigation.NavType$11;
import androidx.navigation.NavType$2;
import androidx.navigation.NavType$3;
import androidx.navigation.NavType$4;
import androidx.navigation.NavType$5;
import androidx.navigation.NavType$6;
import androidx.navigation.NavType$7;
import androidx.navigation.NavType$8;
import androidx.navigation.NavType$9;
import androidx.navigation.NavType$EnumType;
import androidx.navigation.NavType$ParcelableArrayType;
import androidx.navigation.NavType$ParcelableType;
import androidx.navigation.NavType$SerializableArrayType;
import androidx.navigation.NavType$SerializableType;
import java.io.Serializable;

public abstract class NavType {
    public static final NavType BoolArrayType;
    public static final NavType BoolType;
    public static final NavType FloatArrayType;
    public static final NavType FloatType;
    public static final NavType IntArrayType;
    public static final NavType IntType;
    public static final NavType LongArrayType;
    public static final NavType LongType;
    public static final NavType ReferenceType;
    public static final NavType StringArrayType;
    public static final NavType StringType;
    private final boolean mNullableAllowed;

    static {
        NavType navType = new NavType$1(false);
        IntType = navType;
        navType = new NavType$2(false);
        ReferenceType = navType;
        boolean bl2 = true;
        navType = new NavType$3(bl2);
        IntArrayType = navType;
        navType = new NavType$4(false);
        LongType = navType;
        navType = new NavType$5(bl2);
        LongArrayType = navType;
        navType = new NavType$6(false);
        FloatType = navType;
        navType = new NavType$7(bl2);
        FloatArrayType = navType;
        navType = new NavType$8(false);
        BoolType = navType;
        navType = new NavType$9(bl2);
        BoolArrayType = navType;
        navType = new NavType$10(bl2);
        StringType = navType;
        navType = new NavType$11(bl2);
        StringArrayType = navType;
    }

    public NavType(boolean bl2) {
        this.mNullableAllowed = bl2;
    }

    public static NavType fromArgType(String serializable, String object) {
        Object object2 = IntType;
        Object object3 = ((NavType)object2).getName();
        boolean bl2 = ((String)object3).equals(serializable);
        if (bl2) {
            return object2;
        }
        object2 = IntArrayType;
        object3 = ((NavType)object2).getName();
        bl2 = ((String)object3).equals(serializable);
        if (bl2) {
            return object2;
        }
        object2 = LongType;
        object3 = ((NavType)object2).getName();
        bl2 = ((String)object3).equals(serializable);
        if (bl2) {
            return object2;
        }
        object2 = LongArrayType;
        object3 = ((NavType)object2).getName();
        bl2 = ((String)object3).equals(serializable);
        if (bl2) {
            return object2;
        }
        object2 = BoolType;
        object3 = ((NavType)object2).getName();
        bl2 = ((String)object3).equals(serializable);
        if (bl2) {
            return object2;
        }
        object2 = BoolArrayType;
        object3 = ((NavType)object2).getName();
        bl2 = ((String)object3).equals(serializable);
        if (bl2) {
            return object2;
        }
        object2 = StringType;
        object3 = ((NavType)object2).getName();
        bl2 = ((String)object3).equals(serializable);
        if (bl2) {
            return object2;
        }
        object3 = StringArrayType;
        String string2 = ((NavType)object3).getName();
        boolean bl3 = string2.equals(serializable);
        if (bl3) {
            return object3;
        }
        object3 = FloatType;
        string2 = ((NavType)object3).getName();
        bl3 = string2.equals(serializable);
        if (bl3) {
            return object3;
        }
        object3 = FloatArrayType;
        string2 = ((NavType)object3).getName();
        bl3 = string2.equals(serializable);
        if (bl3) {
            return object3;
        }
        object3 = ReferenceType;
        string2 = ((NavType)object3).getName();
        bl3 = string2.equals(serializable);
        if (bl3) {
            return object3;
        }
        if (serializable != null && !(bl2 = ((String)((Object)serializable)).isEmpty())) {
            block47: {
                block49: {
                    block48: {
                        block45: {
                            block46: {
                                block44: {
                                    object2 = ".";
                                    try {
                                        boolean n10 = ((String)((Object)serializable)).startsWith((String)object2);
                                        if (!n10 || object == null) break block44;
                                    }
                                    catch (ClassNotFoundException classNotFoundException) {
                                        object = new RuntimeException(classNotFoundException);
                                        throw object;
                                    }
                                    object2 = new StringBuilder();
                                    ((StringBuilder)object2).append((String)object);
                                    ((StringBuilder)object2).append((String)((Object)serializable));
                                    object = ((StringBuilder)object2).toString();
                                }
                                object = serializable;
                                object2 = "[]";
                                boolean bl4 = ((String)((Object)serializable)).endsWith((String)object2);
                                if (!bl4) break block45;
                                bl4 = false;
                                serializable = null;
                                int n10 = ((String)object).length() + -2;
                                object = ((String)object).substring(0, n10);
                                serializable = Class.forName((String)object);
                                object2 = Parcelable.class;
                                boolean bl5 = ((Class)object2).isAssignableFrom((Class<?>)serializable);
                                if (!bl5) break block46;
                                object = new NavType$ParcelableArrayType((Class)serializable);
                                return object;
                            }
                            object2 = Serializable.class;
                            boolean bl6 = ((Class)object2).isAssignableFrom((Class<?>)serializable);
                            if (!bl6) break block47;
                            object = new NavType$SerializableArrayType((Class)serializable);
                            return object;
                        }
                        serializable = Class.forName((String)object);
                        object2 = Parcelable.class;
                        boolean bl7 = ((Class)object2).isAssignableFrom((Class<?>)serializable);
                        if (!bl7) break block48;
                        object = new NavType$ParcelableType((Class)serializable);
                        return object;
                    }
                    object2 = Enum.class;
                    boolean bl8 = ((Class)object2).isAssignableFrom((Class<?>)serializable);
                    if (!bl8) break block49;
                    object = new NavType$EnumType((Class)serializable);
                    return object;
                }
                object2 = Serializable.class;
                boolean bl9 = ((Class)object2).isAssignableFrom((Class<?>)serializable);
                if (!bl9) break block47;
                object = new NavType$SerializableType((Class)serializable);
                return object;
            }
            object2 = new StringBuilder();
            ((StringBuilder)object2).append((String)object);
            object = " is not Serializable or Parcelable.";
            ((StringBuilder)object2).append((String)object);
            object = ((StringBuilder)object2).toString();
            serializable = new IllegalArgumentException((String)object);
            throw serializable;
        }
        return object2;
    }

    public static NavType inferFromValue(String string2) {
        NavType navType;
        try {
            navType = IntType;
        }
        catch (IllegalArgumentException illegalArgumentException) {
            try {
                navType = LongType;
            }
            catch (IllegalArgumentException illegalArgumentException2) {
                try {
                    navType = FloatType;
                }
                catch (IllegalArgumentException illegalArgumentException3) {
                    try {
                        navType = BoolType;
                    }
                    catch (IllegalArgumentException illegalArgumentException4) {
                        return StringType;
                    }
                    navType.parseValue(string2);
                    return navType;
                }
                navType.parseValue(string2);
                return navType;
            }
            navType.parseValue(string2);
            return navType;
        }
        navType.parseValue(string2);
        return navType;
    }

    public static NavType inferFromValueType(Object object) {
        boolean bl2 = object instanceof Integer;
        if (bl2) {
            return IntType;
        }
        bl2 = object instanceof int[];
        if (bl2) {
            return IntArrayType;
        }
        bl2 = object instanceof Long;
        if (bl2) {
            return LongType;
        }
        bl2 = object instanceof long[];
        if (bl2) {
            return LongArrayType;
        }
        bl2 = object instanceof Float;
        if (bl2) {
            return FloatType;
        }
        bl2 = object instanceof float[];
        if (bl2) {
            return FloatArrayType;
        }
        bl2 = object instanceof Boolean;
        if (bl2) {
            return BoolType;
        }
        bl2 = object instanceof boolean[];
        if (bl2) {
            return BoolArrayType;
        }
        bl2 = object instanceof String;
        if (!bl2 && object != null) {
            Serializable serializable;
            bl2 = object instanceof String[];
            if (bl2) {
                return StringArrayType;
            }
            Class clazz = object.getClass();
            bl2 = clazz.isArray();
            if (bl2 && (bl2 = (clazz = Parcelable.class).isAssignableFrom((Class<?>)(serializable = object.getClass().getComponentType())))) {
                object = object.getClass().getComponentType();
                clazz = new NavType$ParcelableArrayType((Class)object);
                return clazz;
            }
            clazz = object.getClass();
            bl2 = clazz.isArray();
            if (bl2 && (bl2 = (clazz = Serializable.class).isAssignableFrom((Class<?>)(serializable = object.getClass().getComponentType())))) {
                object = object.getClass().getComponentType();
                clazz = new NavType$SerializableArrayType((Class)object);
                return clazz;
            }
            bl2 = object instanceof Parcelable;
            if (bl2) {
                object = object.getClass();
                clazz = new NavType$ParcelableType((Class)object);
                return clazz;
            }
            bl2 = object instanceof Enum;
            if (bl2) {
                object = object.getClass();
                clazz = new NavType$EnumType((Class)object);
                return clazz;
            }
            bl2 = object instanceof Serializable;
            if (bl2) {
                object = object.getClass();
                clazz = new NavType$SerializableType((Class)object);
                return clazz;
            }
            serializable = new StringBuilder();
            ((StringBuilder)serializable).append("Object of type ");
            object = object.getClass().getName();
            ((StringBuilder)serializable).append((String)object);
            ((StringBuilder)serializable).append(" is not supported for navigation arguments.");
            object = ((StringBuilder)serializable).toString();
            clazz = new IllegalArgumentException((String)object);
            throw clazz;
        }
        return StringType;
    }

    public abstract Object get(Bundle var1, String var2);

    public abstract String getName();

    public boolean isNullableAllowed() {
        return this.mNullableAllowed;
    }

    public Object parseAndPut(Bundle bundle, String string2, String object) {
        object = this.parseValue((String)object);
        this.put(bundle, string2, object);
        return object;
    }

    public abstract Object parseValue(String var1);

    public abstract void put(Bundle var1, String var2, Object var3);

    public String toString() {
        return this.getName();
    }
}

