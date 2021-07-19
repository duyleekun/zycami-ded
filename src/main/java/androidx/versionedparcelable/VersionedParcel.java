/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.BadParcelableException
 *  android.os.Bundle
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.NetworkOnMainThreadException
 *  android.os.Parcelable
 *  android.util.Size
 *  android.util.SizeF
 *  android.util.SparseBooleanArray
 */
package androidx.versionedparcelable;

import android.os.BadParcelableException;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.NetworkOnMainThreadException;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import android.util.SparseBooleanArray;
import androidx.collection.ArrayMap;
import androidx.collection.ArraySet;
import androidx.collection.SimpleArrayMap;
import androidx.versionedparcelable.VersionedParcel$1;
import androidx.versionedparcelable.VersionedParcelable;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class VersionedParcel {
    private static final int EX_BAD_PARCELABLE = 254;
    private static final int EX_ILLEGAL_ARGUMENT = 253;
    private static final int EX_ILLEGAL_STATE = 251;
    private static final int EX_NETWORK_MAIN_THREAD = 250;
    private static final int EX_NULL_POINTER = 252;
    private static final int EX_PARCELABLE = 247;
    private static final int EX_SECURITY = 255;
    private static final int EX_UNSUPPORTED_OPERATION = 249;
    private static final String TAG = "VersionedParcel";
    private static final int TYPE_BINDER = 5;
    private static final int TYPE_FLOAT = 8;
    private static final int TYPE_INTEGER = 7;
    private static final int TYPE_PARCELABLE = 2;
    private static final int TYPE_SERIALIZABLE = 3;
    private static final int TYPE_STRING = 4;
    private static final int TYPE_VERSIONED_PARCELABLE = 1;
    public final ArrayMap mParcelizerCache;
    public final ArrayMap mReadCache;
    public final ArrayMap mWriteCache;

    public VersionedParcel(ArrayMap arrayMap, ArrayMap arrayMap2, ArrayMap arrayMap3) {
        this.mReadCache = arrayMap;
        this.mWriteCache = arrayMap2;
        this.mParcelizerCache = arrayMap3;
    }

    private Exception createException(int n10, String string2) {
        switch (n10) {
            default: {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unknown exception code: ");
                stringBuilder.append(n10);
                stringBuilder.append(" msg ");
                stringBuilder.append(string2);
                String string3 = stringBuilder.toString();
                RuntimeException runtimeException = new RuntimeException(string3);
                return runtimeException;
            }
            case -1: {
                SecurityException securityException = new SecurityException(string2);
                return securityException;
            }
            case -2: {
                BadParcelableException badParcelableException = new BadParcelableException(string2);
                return badParcelableException;
            }
            case -3: {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string2);
                return illegalArgumentException;
            }
            case -4: {
                NullPointerException nullPointerException = new NullPointerException(string2);
                return nullPointerException;
            }
            case -5: {
                IllegalStateException illegalStateException = new IllegalStateException(string2);
                return illegalStateException;
            }
            case -6: {
                NetworkOnMainThreadException networkOnMainThreadException = new NetworkOnMainThreadException();
                return networkOnMainThreadException;
            }
            case -7: {
                UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException(string2);
                return unsupportedOperationException;
            }
            case -9: 
        }
        return (Exception)this.readParcelable();
    }

    private Class findParcelClass(Class object) {
        Class<?> clazz = this.mParcelizerCache;
        Object object2 = ((Class)object).getName();
        if ((clazz = (Class)((SimpleArrayMap)((Object)clazz)).get(object2)) == null) {
            clazz = ((Class)object).getPackage().getName();
            int n10 = 2;
            object2 = new Object[n10];
            object2[0] = clazz;
            int n11 = 1;
            String string2 = ((Class)object).getSimpleName();
            object2[n11] = string2;
            clazz = String.format("%s.%sParcelizer", (Object[])object2);
            object2 = ((Class)object).getClassLoader();
            clazz = Class.forName((String)((Object)clazz), false, (ClassLoader)object2);
            object2 = this.mParcelizerCache;
            object = ((Class)object).getName();
            ((SimpleArrayMap)object2).put(object, clazz);
        }
        return clazz;
    }

    private Method getReadMethod(String string2) {
        Object object = VersionedParcel.class;
        GenericDeclaration genericDeclaration = (Method)this.mReadCache.get(string2);
        if (genericDeclaration == null) {
            System.currentTimeMillis();
            genericDeclaration = ((Class)object).getClassLoader();
            int n10 = 1;
            genericDeclaration = Class.forName(string2, n10 != 0, (ClassLoader)((Object)genericDeclaration));
            Class[] classArray = new Class[n10];
            classArray[0] = object;
            genericDeclaration = genericDeclaration.getDeclaredMethod("read", classArray);
            object = this.mReadCache;
            ((SimpleArrayMap)object).put(string2, genericDeclaration);
        }
        return genericDeclaration;
    }

    public static Throwable getRootCause(Throwable throwable) {
        Throwable throwable2;
        while ((throwable2 = throwable.getCause()) != null) {
            throwable = throwable.getCause();
        }
        return throwable;
    }

    private int getType(Object object) {
        boolean bl2 = object instanceof String;
        if (bl2) {
            return 4;
        }
        bl2 = object instanceof Parcelable;
        if (bl2) {
            return 2;
        }
        bl2 = object instanceof VersionedParcelable;
        if (bl2) {
            return 1;
        }
        bl2 = object instanceof Serializable;
        if (bl2) {
            return 3;
        }
        bl2 = object instanceof IBinder;
        if (bl2) {
            return 5;
        }
        bl2 = object instanceof Integer;
        if (bl2) {
            return 7;
        }
        bl2 = object instanceof Float;
        if (bl2) {
            return 8;
        }
        StringBuilder stringBuilder = new StringBuilder();
        object = object.getClass().getName();
        stringBuilder.append((String)object);
        stringBuilder.append(" cannot be VersionedParcelled");
        object = stringBuilder.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
        throw illegalArgumentException;
    }

    private Method getWriteMethod(Class object) {
        Object object2 = this.mWriteCache;
        Object object3 = ((Class)object).getName();
        if ((object2 = (Method)((SimpleArrayMap)object2).get(object3)) == null) {
            Class<VersionedParcel> clazz;
            object2 = this.findParcelClass((Class)object);
            System.currentTimeMillis();
            int n10 = 2;
            object3 = new Class[n10];
            object3[0] = object;
            int n11 = 1;
            object3[n11] = clazz = VersionedParcel.class;
            String string2 = "write";
            object2 = ((Class)object2).getDeclaredMethod(string2, (Class<?>)object3);
            object3 = this.mWriteCache;
            object = ((Class)object).getName();
            ((SimpleArrayMap)object3).put(object, object2);
        }
        return object2;
    }

    private Collection readCollection(Collection collection) {
        block7: {
            int n10;
            Object object;
            block8: {
                block9: {
                    block10: {
                        block11: {
                            int n11 = 0;
                            object = null;
                            if (n10 < 0) {
                                return null;
                            }
                            if (n10 == 0) break block7;
                            int n12 = this.readInt();
                            if (n10 < 0) {
                                return null;
                            }
                            n11 = 1;
                            if (n12 == n11) break block8;
                            n11 = 2;
                            if (n12 == n11) break block9;
                            n11 = 3;
                            if (n12 == n11) break block10;
                            n11 = 4;
                            if (n12 == n11) break block11;
                            n11 = 5;
                            if (n12 != n11) break block7;
                            for (n10 = this.readInt(); n10 > 0; n10 += -1) {
                                object = this.readStrongBinder();
                                collection.add(object);
                            }
                            break block7;
                        }
                        while (n10 > 0) {
                            object = this.readString();
                            collection.add(object);
                            n10 += -1;
                        }
                        break block7;
                    }
                    while (n10 > 0) {
                        object = this.readSerializable();
                        collection.add(object);
                        n10 += -1;
                    }
                    break block7;
                }
                while (n10 > 0) {
                    object = this.readParcelable();
                    collection.add(object);
                    n10 += -1;
                }
                break block7;
            }
            while (n10 > 0) {
                object = this.readVersionedParcelable();
                collection.add(object);
                n10 += -1;
            }
        }
        return collection;
    }

    private Exception readException(int n10, String string2) {
        return this.createException(n10, string2);
    }

    private int readExceptionCode() {
        return this.readInt();
    }

    private void writeCollection(Collection iterator2) {
        if (iterator2 == null) {
            this.writeInt(-1);
            return;
        }
        int n10 = iterator2.size();
        this.writeInt(n10);
        if (n10 > 0) {
            Object object = iterator2.iterator().next();
            n10 = this.getType(object);
            this.writeInt(n10);
            switch (n10) {
                default: {
                    break;
                }
                case 8: {
                    iterator2 = iterator2.iterator();
                    while ((n10 = (int)(iterator2.hasNext() ? 1 : 0)) != 0) {
                        object = (Float)iterator2.next();
                        float f10 = ((Float)object).floatValue();
                        this.writeFloat(f10);
                    }
                    break;
                }
                case 7: {
                    iterator2 = iterator2.iterator();
                    while ((n10 = (int)(iterator2.hasNext() ? 1 : 0)) != 0) {
                        object = (Integer)iterator2.next();
                        n10 = (Integer)object;
                        this.writeInt(n10);
                    }
                    break;
                }
                case 5: {
                    iterator2 = iterator2.iterator();
                    while ((n10 = (int)(iterator2.hasNext() ? 1 : 0)) != 0) {
                        object = (IBinder)iterator2.next();
                        this.writeStrongBinder((IBinder)object);
                    }
                    break;
                }
                case 4: {
                    iterator2 = iterator2.iterator();
                    while ((n10 = (int)(iterator2.hasNext() ? 1 : 0)) != 0) {
                        object = (String)iterator2.next();
                        this.writeString((String)object);
                    }
                    break;
                }
                case 3: {
                    iterator2 = iterator2.iterator();
                    while ((n10 = (int)(iterator2.hasNext() ? 1 : 0)) != 0) {
                        object = (Serializable)iterator2.next();
                        this.writeSerializable((Serializable)object);
                    }
                    break;
                }
                case 2: {
                    iterator2 = iterator2.iterator();
                    while ((n10 = (int)(iterator2.hasNext() ? 1 : 0)) != 0) {
                        object = (Parcelable)iterator2.next();
                        this.writeParcelable((Parcelable)object);
                    }
                    break;
                }
                case 1: {
                    iterator2 = iterator2.iterator();
                    while ((n10 = (int)(iterator2.hasNext() ? 1 : 0)) != 0) {
                        object = (VersionedParcelable)iterator2.next();
                        this.writeVersionedParcelable((VersionedParcelable)object);
                    }
                    break block0;
                }
            }
        }
    }

    private void writeCollection(Collection collection, int n10) {
        this.setOutputField(n10);
        this.writeCollection(collection);
    }

    private void writeSerializable(Serializable object) {
        Object object2;
        if (object == null) {
            this.writeString(null);
            return;
        }
        String string2 = object.getClass().getName();
        this.writeString(string2);
        Object object3 = new ByteArrayOutputStream();
        try {
            object2 = new ObjectOutputStream((OutputStream)object3);
        }
        catch (IOException iOException) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("VersionedParcelable encountered IOException writing serializable object (name = ");
            ((StringBuilder)object2).append(string2);
            ((StringBuilder)object2).append(")");
            string2 = ((StringBuilder)object2).toString();
            object3 = new RuntimeException(string2, iOException);
            throw object3;
        }
        ((ObjectOutputStream)object2).writeObject(object);
        ((ObjectOutputStream)object2).close();
        object = ((ByteArrayOutputStream)object3).toByteArray();
        this.writeByteArray((byte[])object);
    }

    private void writeVersionedParcelableCreator(VersionedParcelable object) {
        Class<?> clazz;
        try {
            clazz = object.getClass();
        }
        catch (ClassNotFoundException classNotFoundException) {
            StringBuilder stringBuilder = new StringBuilder();
            object = object.getClass().getSimpleName();
            stringBuilder.append((String)object);
            stringBuilder.append(" does not have a Parcelizer");
            object = stringBuilder.toString();
            RuntimeException runtimeException = new RuntimeException((String)object, classNotFoundException);
            throw runtimeException;
        }
        object = this.findParcelClass(clazz).getName();
        this.writeString((String)object);
    }

    public abstract void closeField();

    public abstract VersionedParcel createSubParcel();

    public boolean isStream() {
        return false;
    }

    public Object[] readArray(Object[] objectArray) {
        ArrayList<Object> arrayList;
        block7: {
            int n10;
            Object object;
            block8: {
                block9: {
                    block10: {
                        block11: {
                            int n11 = 0;
                            object = null;
                            if (n10 < 0) {
                                return null;
                            }
                            arrayList = new ArrayList<Object>(n10);
                            if (n10 == 0) break block7;
                            int n12 = this.readInt();
                            if (n10 < 0) {
                                return null;
                            }
                            n11 = 1;
                            if (n12 == n11) break block8;
                            n11 = 2;
                            if (n12 == n11) break block9;
                            n11 = 3;
                            if (n12 == n11) break block10;
                            n11 = 4;
                            if (n12 == n11) break block11;
                            n11 = 5;
                            if (n12 != n11) break block7;
                            for (n10 = this.readInt(); n10 > 0; n10 += -1) {
                                object = this.readStrongBinder();
                                arrayList.add(object);
                            }
                            break block7;
                        }
                        while (n10 > 0) {
                            object = this.readString();
                            arrayList.add(object);
                            n10 += -1;
                        }
                        break block7;
                    }
                    while (n10 > 0) {
                        object = this.readSerializable();
                        arrayList.add(object);
                        n10 += -1;
                    }
                    break block7;
                }
                while (n10 > 0) {
                    object = this.readParcelable();
                    arrayList.add(object);
                    n10 += -1;
                }
                break block7;
            }
            while (n10 > 0) {
                object = this.readVersionedParcelable();
                arrayList.add(object);
                n10 += -1;
            }
        }
        return arrayList.toArray(objectArray);
    }

    public Object[] readArray(Object[] objectArray, int n10) {
        if ((n10 = (int)(this.readField(n10) ? 1 : 0)) == 0) {
            return objectArray;
        }
        return this.readArray(objectArray);
    }

    public abstract boolean readBoolean();

    public boolean readBoolean(boolean bl2, int n10) {
        if ((n10 = (int)(this.readField(n10) ? 1 : 0)) == 0) {
            return bl2;
        }
        return this.readBoolean();
    }

    public boolean[] readBooleanArray() {
        int n10 = this.readInt();
        if (n10 < 0) {
            return null;
        }
        boolean[] blArray = new boolean[n10];
        for (int i10 = 0; i10 < n10; ++i10) {
            int n11 = this.readInt();
            n11 = n11 != 0 ? 1 : 0;
            blArray[i10] = n11;
        }
        return blArray;
    }

    public boolean[] readBooleanArray(boolean[] blArray, int n10) {
        if ((n10 = (int)(this.readField(n10) ? 1 : 0)) == 0) {
            return blArray;
        }
        return this.readBooleanArray();
    }

    public abstract Bundle readBundle();

    public Bundle readBundle(Bundle bundle, int n10) {
        if ((n10 = (int)(this.readField(n10) ? 1 : 0)) == 0) {
            return bundle;
        }
        return this.readBundle();
    }

    public byte readByte(byte by2, int n10) {
        if ((n10 = (int)(this.readField(n10) ? 1 : 0)) == 0) {
            return by2;
        }
        return (byte)(this.readInt() & 0xFF);
    }

    public abstract byte[] readByteArray();

    public byte[] readByteArray(byte[] byArray, int n10) {
        if ((n10 = (int)(this.readField(n10) ? 1 : 0)) == 0) {
            return byArray;
        }
        return this.readByteArray();
    }

    public char[] readCharArray(char[] cArray, int n10) {
        if ((n10 = (int)(this.readField(n10) ? 1 : 0)) == 0) {
            return cArray;
        }
        int n11 = this.readInt();
        if (n11 < 0) {
            return null;
        }
        char[] cArray2 = new char[n11];
        for (int i10 = 0; i10 < n11; ++i10) {
            char c10;
            cArray2[i10] = c10 = (char)this.readInt();
        }
        return cArray2;
    }

    public abstract CharSequence readCharSequence();

    public CharSequence readCharSequence(CharSequence charSequence, int n10) {
        if ((n10 = (int)(this.readField(n10) ? 1 : 0)) == 0) {
            return charSequence;
        }
        return this.readCharSequence();
    }

    public abstract double readDouble();

    public double readDouble(double d10, int n10) {
        if ((n10 = (int)(this.readField(n10) ? 1 : 0)) == 0) {
            return d10;
        }
        return this.readDouble();
    }

    public double[] readDoubleArray() {
        int n10 = this.readInt();
        if (n10 < 0) {
            return null;
        }
        double[] dArray = new double[n10];
        for (int i10 = 0; i10 < n10; ++i10) {
            double d10;
            dArray[i10] = d10 = this.readDouble();
        }
        return dArray;
    }

    public double[] readDoubleArray(double[] dArray, int n10) {
        if ((n10 = (int)(this.readField(n10) ? 1 : 0)) == 0) {
            return dArray;
        }
        return this.readDoubleArray();
    }

    public Exception readException(Exception object, int n10) {
        if ((n10 = (int)(this.readField(n10) ? 1 : 0)) == 0) {
            return object;
        }
        n10 = this.readExceptionCode();
        if (n10 != 0) {
            object = this.readString();
            object = this.readException(n10, (String)object);
        }
        return object;
    }

    public abstract boolean readField(int var1);

    public abstract float readFloat();

    public float readFloat(float f10, int n10) {
        if ((n10 = (int)(this.readField(n10) ? 1 : 0)) == 0) {
            return f10;
        }
        return this.readFloat();
    }

    public float[] readFloatArray() {
        int n10 = this.readInt();
        if (n10 < 0) {
            return null;
        }
        float[] fArray = new float[n10];
        for (int i10 = 0; i10 < n10; ++i10) {
            float f10;
            fArray[i10] = f10 = this.readFloat();
        }
        return fArray;
    }

    public float[] readFloatArray(float[] fArray, int n10) {
        if ((n10 = (int)(this.readField(n10) ? 1 : 0)) == 0) {
            return fArray;
        }
        return this.readFloatArray();
    }

    public VersionedParcelable readFromParcel(String object, VersionedParcel object2) {
        object = this.getReadMethod((String)object);
        int n10 = 1;
        Object[] objectArray = new Object[n10];
        objectArray[0] = object2;
        object = ((Method)object).invoke(null, objectArray);
        try {
            return (VersionedParcelable)object;
        }
        catch (ClassNotFoundException classNotFoundException) {
            object2 = new RuntimeException("VersionedParcel encountered ClassNotFoundException", classNotFoundException);
            throw object2;
        }
        catch (NoSuchMethodException noSuchMethodException) {
            object2 = new RuntimeException("VersionedParcel encountered NoSuchMethodException", noSuchMethodException);
            throw object2;
        }
        catch (InvocationTargetException invocationTargetException) {
            object2 = invocationTargetException.getCause();
            boolean bl2 = object2 instanceof RuntimeException;
            if (bl2) {
                throw (RuntimeException)invocationTargetException.getCause();
            }
            object2 = new RuntimeException("VersionedParcel encountered InvocationTargetException", invocationTargetException);
            throw object2;
        }
        catch (IllegalAccessException illegalAccessException) {
            object2 = new RuntimeException("VersionedParcel encountered IllegalAccessException", illegalAccessException);
            throw object2;
        }
    }

    public abstract int readInt();

    public int readInt(int n10, int n11) {
        if ((n11 = (int)(this.readField(n11) ? 1 : 0)) == 0) {
            return n10;
        }
        return this.readInt();
    }

    public int[] readIntArray() {
        int n10 = this.readInt();
        if (n10 < 0) {
            return null;
        }
        int[] nArray = new int[n10];
        for (int i10 = 0; i10 < n10; ++i10) {
            int n11;
            nArray[i10] = n11 = this.readInt();
        }
        return nArray;
    }

    public int[] readIntArray(int[] nArray, int n10) {
        if ((n10 = (int)(this.readField(n10) ? 1 : 0)) == 0) {
            return nArray;
        }
        return this.readIntArray();
    }

    public List readList(List arrayList, int n10) {
        if ((n10 = (int)(this.readField(n10) ? 1 : 0)) == 0) {
            return arrayList;
        }
        arrayList = new ArrayList();
        return (List)this.readCollection(arrayList);
    }

    public abstract long readLong();

    public long readLong(long l10, int n10) {
        if ((n10 = (int)(this.readField(n10) ? 1 : 0)) == 0) {
            return l10;
        }
        return this.readLong();
    }

    public long[] readLongArray() {
        int n10 = this.readInt();
        if (n10 < 0) {
            return null;
        }
        long[] lArray = new long[n10];
        for (int i10 = 0; i10 < n10; ++i10) {
            long l10;
            lArray[i10] = l10 = this.readLong();
        }
        return lArray;
    }

    public long[] readLongArray(long[] lArray, int n10) {
        if ((n10 = (int)(this.readField(n10) ? 1 : 0)) == 0) {
            return lArray;
        }
        return this.readLongArray();
    }

    public Map readMap(Map map, int n10) {
        if ((n10 = (int)(this.readField(n10) ? 1 : 0)) == 0) {
            return map;
        }
        int n11 = this.readInt();
        if (n11 < 0) {
            return null;
        }
        ArrayMap arrayMap = new ArrayMap();
        if (n11 == 0) {
            return arrayMap;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        this.readCollection(arrayList);
        this.readCollection(arrayList2);
        for (int i10 = 0; i10 < n11; ++i10) {
            Object e10 = arrayList.get(i10);
            Object e11 = arrayList2.get(i10);
            arrayMap.put(e10, e11);
        }
        return arrayMap;
    }

    public abstract Parcelable readParcelable();

    public Parcelable readParcelable(Parcelable parcelable, int n10) {
        if ((n10 = (int)(this.readField(n10) ? 1 : 0)) == 0) {
            return parcelable;
        }
        return this.readParcelable();
    }

    public Serializable readSerializable() {
        String string2 = ")";
        String string3 = this.readString();
        if (string3 == null) {
            return null;
        }
        Object object = this.readByteArray();
        Object object2 = new ByteArrayInputStream((byte[])object);
        object = new VersionedParcel$1;
        ((VersionedParcel$1)object)(this, (InputStream)object2);
        object = ((ObjectInputStream)object).readObject();
        try {
            return (Serializable)object;
        }
        catch (ClassNotFoundException classNotFoundException) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("VersionedParcelable encountered ClassNotFoundException reading a Serializable object (name = ");
            stringBuilder.append(string3);
            stringBuilder.append(string2);
            string2 = stringBuilder.toString();
            object2 = new RuntimeException(string2, classNotFoundException);
            throw object2;
        }
        catch (IOException iOException) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("VersionedParcelable encountered IOException reading a Serializable object (name = ");
            stringBuilder.append(string3);
            stringBuilder.append(string2);
            string2 = stringBuilder.toString();
            object2 = new RuntimeException(string2, iOException);
            throw object2;
        }
    }

    public Set readSet(Set set, int n10) {
        if ((n10 = (int)(this.readField(n10) ? 1 : 0)) == 0) {
            return set;
        }
        set = new ArraySet();
        return (Set)this.readCollection(set);
    }

    public Size readSize(Size size, int n10) {
        if ((n10 = (int)(this.readField(n10) ? 1 : 0)) == 0) {
            return size;
        }
        int n11 = this.readBoolean();
        if (n11 != 0) {
            n11 = this.readInt();
            n10 = this.readInt();
            Size size2 = new Size(n11, n10);
            return size2;
        }
        return null;
    }

    public SizeF readSizeF(SizeF sizeF, int n10) {
        if ((n10 = (int)(this.readField(n10) ? 1 : 0)) == 0) {
            return sizeF;
        }
        boolean bl2 = this.readBoolean();
        if (bl2) {
            float f10 = this.readFloat();
            float f11 = this.readFloat();
            SizeF sizeF2 = new SizeF(f10, f11);
            return sizeF2;
        }
        return null;
    }

    public SparseBooleanArray readSparseBooleanArray(SparseBooleanArray sparseBooleanArray, int n10) {
        if ((n10 = (int)(this.readField(n10) ? 1 : 0)) == 0) {
            return sparseBooleanArray;
        }
        int n11 = this.readInt();
        if (n11 < 0) {
            return null;
        }
        SparseBooleanArray sparseBooleanArray2 = new SparseBooleanArray(n11);
        for (int i10 = 0; i10 < n11; ++i10) {
            int n12 = this.readInt();
            boolean bl2 = this.readBoolean();
            sparseBooleanArray2.put(n12, bl2);
        }
        return sparseBooleanArray2;
    }

    public abstract String readString();

    public String readString(String string2, int n10) {
        if ((n10 = (int)(this.readField(n10) ? 1 : 0)) == 0) {
            return string2;
        }
        return this.readString();
    }

    public abstract IBinder readStrongBinder();

    public IBinder readStrongBinder(IBinder iBinder, int n10) {
        if ((n10 = (int)(this.readField(n10) ? 1 : 0)) == 0) {
            return iBinder;
        }
        return this.readStrongBinder();
    }

    public VersionedParcelable readVersionedParcelable() {
        String string2 = this.readString();
        if (string2 == null) {
            return null;
        }
        VersionedParcel versionedParcel = this.createSubParcel();
        return this.readFromParcel(string2, versionedParcel);
    }

    public VersionedParcelable readVersionedParcelable(VersionedParcelable versionedParcelable, int n10) {
        if ((n10 = (int)(this.readField(n10) ? 1 : 0)) == 0) {
            return versionedParcelable;
        }
        return this.readVersionedParcelable();
    }

    public abstract void setOutputField(int var1);

    public void setSerializationFlags(boolean bl2, boolean bl3) {
    }

    public void writeArray(Object[] objectArray) {
        block6: {
            int n10;
            Object object;
            int n11;
            block7: {
                block8: {
                    block9: {
                        block10: {
                            if (objectArray == null) {
                                this.writeInt(-1);
                                return;
                            }
                            n11 = objectArray.length;
                            this.writeInt(n11);
                            if (n11 <= 0) break block6;
                            object = objectArray[0];
                            int n12 = this.getType(object);
                            this.writeInt(n12);
                            int n13 = 1;
                            if (n12 == n13) break block7;
                            n13 = 2;
                            if (n12 == n13) break block8;
                            n13 = 3;
                            if (n12 == n13) break block9;
                            n13 = 4;
                            if (n12 == n13) break block10;
                            n13 = 5;
                            if (n12 != n13) break block6;
                            for (n10 = 0; n10 < n11; ++n10) {
                                object = (IBinder)objectArray[n10];
                                this.writeStrongBinder((IBinder)object);
                            }
                            break block6;
                        }
                        while (n10 < n11) {
                            object = (String)objectArray[n10];
                            this.writeString((String)object);
                            ++n10;
                        }
                        break block6;
                    }
                    while (n10 < n11) {
                        object = (Serializable)objectArray[n10];
                        this.writeSerializable((Serializable)object);
                        ++n10;
                    }
                    break block6;
                }
                while (n10 < n11) {
                    object = (Parcelable)objectArray[n10];
                    this.writeParcelable((Parcelable)object);
                    ++n10;
                }
                break block6;
            }
            while (n10 < n11) {
                object = (VersionedParcelable)objectArray[n10];
                this.writeVersionedParcelable((VersionedParcelable)object);
                ++n10;
            }
        }
    }

    public void writeArray(Object[] objectArray, int n10) {
        this.setOutputField(n10);
        this.writeArray(objectArray);
    }

    public abstract void writeBoolean(boolean var1);

    public void writeBoolean(boolean bl2, int n10) {
        this.setOutputField(n10);
        this.writeBoolean(bl2);
    }

    public void writeBooleanArray(boolean[] blArray) {
        if (blArray != null) {
            int n10 = blArray.length;
            this.writeInt(n10);
            for (int i10 = 0; i10 < n10; ++i10) {
                int n11 = blArray[i10];
                this.writeInt(n11);
            }
        } else {
            int n12 = -1;
            this.writeInt(n12);
        }
    }

    public void writeBooleanArray(boolean[] blArray, int n10) {
        this.setOutputField(n10);
        this.writeBooleanArray(blArray);
    }

    public abstract void writeBundle(Bundle var1);

    public void writeBundle(Bundle bundle, int n10) {
        this.setOutputField(n10);
        this.writeBundle(bundle);
    }

    public void writeByte(byte by2, int n10) {
        this.setOutputField(n10);
        this.writeInt(by2);
    }

    public abstract void writeByteArray(byte[] var1);

    public void writeByteArray(byte[] byArray, int n10) {
        this.setOutputField(n10);
        this.writeByteArray(byArray);
    }

    public abstract void writeByteArray(byte[] var1, int var2, int var3);

    public void writeByteArray(byte[] byArray, int n10, int n11, int n12) {
        this.setOutputField(n12);
        this.writeByteArray(byArray, n10, n11);
    }

    public void writeCharArray(char[] cArray, int n10) {
        this.setOutputField(n10);
        if (cArray != null) {
            n10 = cArray.length;
            this.writeInt(n10);
            for (int i10 = 0; i10 < n10; ++i10) {
                char c10 = cArray[i10];
                this.writeInt(c10);
            }
        } else {
            int n11 = -1;
            this.writeInt(n11);
        }
    }

    public abstract void writeCharSequence(CharSequence var1);

    public void writeCharSequence(CharSequence charSequence, int n10) {
        this.setOutputField(n10);
        this.writeCharSequence(charSequence);
    }

    public abstract void writeDouble(double var1);

    public void writeDouble(double d10, int n10) {
        this.setOutputField(n10);
        this.writeDouble(d10);
    }

    public void writeDoubleArray(double[] dArray) {
        if (dArray != null) {
            int n10 = dArray.length;
            this.writeInt(n10);
            for (int i10 = 0; i10 < n10; ++i10) {
                double d10 = dArray[i10];
                this.writeDouble(d10);
            }
        } else {
            int n11 = -1;
            this.writeInt(n11);
        }
    }

    public void writeDoubleArray(double[] dArray, int n10) {
        this.setOutputField(n10);
        this.writeDoubleArray(dArray);
    }

    public void writeException(Exception exception, int n10) {
        ClassLoader classLoader;
        Object object;
        this.setOutputField(n10);
        if (exception == null) {
            this.writeNoException();
            return;
        }
        n10 = 0;
        RuntimeException runtimeException = null;
        boolean bl2 = exception instanceof Parcelable;
        int n11 = -9;
        if (bl2 && (object = exception.getClass().getClassLoader()) == (classLoader = Parcelable.class.getClassLoader())) {
            n10 = n11;
        } else {
            bl2 = exception instanceof SecurityException;
            if (bl2) {
                n10 = -1;
            } else {
                bl2 = exception instanceof BadParcelableException;
                if (bl2) {
                    n10 = -2;
                } else {
                    bl2 = exception instanceof IllegalArgumentException;
                    if (bl2) {
                        n10 = -3;
                    } else {
                        bl2 = exception instanceof NullPointerException;
                        if (bl2) {
                            n10 = -4;
                        } else {
                            bl2 = exception instanceof IllegalStateException;
                            if (bl2) {
                                n10 = -5;
                            } else {
                                bl2 = exception instanceof NetworkOnMainThreadException;
                                if (bl2) {
                                    n10 = -6;
                                } else {
                                    bl2 = exception instanceof UnsupportedOperationException;
                                    if (bl2) {
                                        n10 = -7;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        this.writeInt(n10);
        if (n10 == 0) {
            n10 = exception instanceof RuntimeException;
            if (n10 != 0) {
                throw (RuntimeException)exception;
            }
            runtimeException = new RuntimeException(exception);
            throw runtimeException;
        }
        object = exception.getMessage();
        this.writeString((String)object);
        if (n10 == n11) {
            exception = (Parcelable)exception;
            this.writeParcelable((Parcelable)exception);
        }
    }

    public abstract void writeFloat(float var1);

    public void writeFloat(float f10, int n10) {
        this.setOutputField(n10);
        this.writeFloat(f10);
    }

    public void writeFloatArray(float[] fArray) {
        if (fArray != null) {
            int n10 = fArray.length;
            this.writeInt(n10);
            for (int i10 = 0; i10 < n10; ++i10) {
                float f10 = fArray[i10];
                this.writeFloat(f10);
            }
        } else {
            int n11 = -1;
            this.writeInt(n11);
        }
    }

    public void writeFloatArray(float[] fArray, int n10) {
        this.setOutputField(n10);
        this.writeFloatArray(fArray);
    }

    public abstract void writeInt(int var1);

    public void writeInt(int n10, int n11) {
        this.setOutputField(n11);
        this.writeInt(n10);
    }

    public void writeIntArray(int[] nArray) {
        if (nArray != null) {
            int n10 = nArray.length;
            this.writeInt(n10);
            for (int i10 = 0; i10 < n10; ++i10) {
                int n11 = nArray[i10];
                this.writeInt(n11);
            }
        } else {
            int n12 = -1;
            this.writeInt(n12);
        }
    }

    public void writeIntArray(int[] nArray, int n10) {
        this.setOutputField(n10);
        this.writeIntArray(nArray);
    }

    public void writeList(List list, int n10) {
        this.writeCollection(list, n10);
    }

    public abstract void writeLong(long var1);

    public void writeLong(long l10, int n10) {
        this.setOutputField(n10);
        this.writeLong(l10);
    }

    public void writeLongArray(long[] lArray) {
        if (lArray != null) {
            int n10 = lArray.length;
            this.writeInt(n10);
            for (int i10 = 0; i10 < n10; ++i10) {
                long l10 = lArray[i10];
                this.writeLong(l10);
            }
        } else {
            int n11 = -1;
            this.writeInt(n11);
        }
    }

    public void writeLongArray(long[] lArray, int n10) {
        this.setOutputField(n10);
        this.writeLongArray(lArray);
    }

    public void writeMap(Map object, int n10) {
        boolean bl2;
        this.setOutputField(n10);
        if (object == null) {
            this.writeInt(-1);
            return;
        }
        n10 = object.size();
        this.writeInt(n10);
        if (n10 == 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList<Map.Entry> arrayList2 = new ArrayList<Map.Entry>();
        object = object.entrySet().iterator();
        while (bl2 = object.hasNext()) {
            Map.Entry entry = (Map.Entry)object.next();
            Object k10 = entry.getKey();
            arrayList.add(k10);
            entry = entry.getValue();
            arrayList2.add(entry);
        }
        this.writeCollection(arrayList);
        this.writeCollection(arrayList2);
    }

    public void writeNoException() {
        this.writeInt(0);
    }

    public abstract void writeParcelable(Parcelable var1);

    public void writeParcelable(Parcelable parcelable, int n10) {
        this.setOutputField(n10);
        this.writeParcelable(parcelable);
    }

    public void writeSerializable(Serializable serializable, int n10) {
        this.setOutputField(n10);
        this.writeSerializable(serializable);
    }

    public void writeSet(Set set, int n10) {
        this.writeCollection(set, n10);
    }

    public void writeSize(Size size, int n10) {
        this.setOutputField(n10);
        n10 = size != null ? 1 : 0;
        this.writeBoolean(n10 != 0);
        if (size != null) {
            n10 = size.getWidth();
            this.writeInt(n10);
            int n11 = size.getHeight();
            this.writeInt(n11);
        }
    }

    public void writeSizeF(SizeF sizeF, int n10) {
        float f10;
        this.setOutputField(n10);
        if (sizeF != null) {
            n10 = 1;
            f10 = Float.MIN_VALUE;
        } else {
            n10 = 0;
            f10 = 0.0f;
        }
        this.writeBoolean(n10 != 0);
        if (sizeF != null) {
            f10 = sizeF.getWidth();
            this.writeFloat(f10);
            float f11 = sizeF.getHeight();
            this.writeFloat(f11);
        }
    }

    public void writeSparseBooleanArray(SparseBooleanArray sparseBooleanArray, int n10) {
        this.setOutputField(n10);
        if (sparseBooleanArray == null) {
            this.writeInt(-1);
            return;
        }
        n10 = sparseBooleanArray.size();
        this.writeInt(n10);
        for (int i10 = 0; i10 < n10; ++i10) {
            boolean bl2 = sparseBooleanArray.keyAt(i10);
            this.writeInt((int)(bl2 ? 1 : 0));
            bl2 = sparseBooleanArray.valueAt(i10);
            this.writeBoolean(bl2);
        }
    }

    public abstract void writeString(String var1);

    public void writeString(String string2, int n10) {
        this.setOutputField(n10);
        this.writeString(string2);
    }

    public abstract void writeStrongBinder(IBinder var1);

    public void writeStrongBinder(IBinder iBinder, int n10) {
        this.setOutputField(n10);
        this.writeStrongBinder(iBinder);
    }

    public abstract void writeStrongInterface(IInterface var1);

    public void writeStrongInterface(IInterface iInterface, int n10) {
        this.setOutputField(n10);
        this.writeStrongInterface(iInterface);
    }

    public void writeToParcel(VersionedParcelable versionedParcelable, VersionedParcel object) {
        GenericDeclaration genericDeclaration = versionedParcelable.getClass();
        genericDeclaration = this.getWriteMethod((Class)genericDeclaration);
        int n10 = 2;
        Object[] objectArray = new Object[n10];
        objectArray[0] = versionedParcelable;
        int n11 = 1;
        objectArray[n11] = object;
        try {
            ((Method)genericDeclaration).invoke(null, objectArray);
            return;
        }
        catch (ClassNotFoundException classNotFoundException) {
            object = new RuntimeException("VersionedParcel encountered ClassNotFoundException", classNotFoundException);
            throw object;
        }
        catch (NoSuchMethodException noSuchMethodException) {
            object = new RuntimeException("VersionedParcel encountered NoSuchMethodException", noSuchMethodException);
            throw object;
        }
        catch (InvocationTargetException invocationTargetException) {
            object = invocationTargetException.getCause();
            boolean bl2 = object instanceof RuntimeException;
            if (bl2) {
                throw (RuntimeException)invocationTargetException.getCause();
            }
            object = new RuntimeException("VersionedParcel encountered InvocationTargetException", invocationTargetException);
            throw object;
        }
        catch (IllegalAccessException illegalAccessException) {
            object = new RuntimeException("VersionedParcel encountered IllegalAccessException", illegalAccessException);
            throw object;
        }
    }

    public void writeVersionedParcelable(VersionedParcelable versionedParcelable) {
        if (versionedParcelable == null) {
            this.writeString(null);
            return;
        }
        this.writeVersionedParcelableCreator(versionedParcelable);
        VersionedParcel versionedParcel = this.createSubParcel();
        this.writeToParcel(versionedParcelable, versionedParcel);
        versionedParcel.closeField();
    }

    public void writeVersionedParcelable(VersionedParcelable versionedParcelable, int n10) {
        this.setOutputField(n10);
        this.writeVersionedParcelable(versionedParcelable);
    }
}

