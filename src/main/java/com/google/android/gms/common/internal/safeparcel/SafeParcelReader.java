/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.IBinder
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  android.util.SparseArray
 *  android.util.SparseBooleanArray
 *  android.util.SparseIntArray
 *  android.util.SparseLongArray
 */
package com.google.android.gms.common.internal.safeparcel;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import android.util.SparseLongArray;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader$ParseException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class SafeParcelReader {
    private SafeParcelReader() {
    }

    public static BigDecimal createBigDecimal(Parcel object, int n10) {
        n10 = SafeParcelReader.readSize(object, n10);
        int n11 = object.dataPosition();
        if (n10 == 0) {
            return null;
        }
        byte[] byArray = object.createByteArray();
        int n12 = object.readInt();
        object.setDataPosition(n11 += n10);
        BigInteger bigInteger = new BigInteger(byArray);
        object = new BigDecimal(bigInteger, n12);
        return object;
    }

    public static BigDecimal[] createBigDecimalArray(Parcel parcel, int n10) {
        n10 = SafeParcelReader.readSize(parcel, n10);
        int n11 = parcel.dataPosition();
        if (n10 == 0) {
            return null;
        }
        int n12 = parcel.readInt();
        BigDecimal[] bigDecimalArray = new BigDecimal[n12];
        for (int i10 = 0; i10 < n12; ++i10) {
            BigDecimal bigDecimal;
            byte[] byArray = parcel.createByteArray();
            int n13 = parcel.readInt();
            BigInteger bigInteger = new BigInteger(byArray);
            bigDecimalArray[i10] = bigDecimal = new BigDecimal(bigInteger, n13);
        }
        parcel.setDataPosition(n11 += n10);
        return bigDecimalArray;
    }

    public static BigInteger createBigInteger(Parcel object, int n10) {
        n10 = SafeParcelReader.readSize(object, n10);
        int n11 = object.dataPosition();
        if (n10 == 0) {
            return null;
        }
        byte[] byArray = object.createByteArray();
        object.setDataPosition(n11 += n10);
        object = new BigInteger(byArray);
        return object;
    }

    public static BigInteger[] createBigIntegerArray(Parcel parcel, int n10) {
        n10 = SafeParcelReader.readSize(parcel, n10);
        int n11 = parcel.dataPosition();
        if (n10 == 0) {
            return null;
        }
        int n12 = parcel.readInt();
        BigInteger[] bigIntegerArray = new BigInteger[n12];
        for (int i10 = 0; i10 < n12; ++i10) {
            BigInteger bigInteger;
            byte[] byArray = parcel.createByteArray();
            bigIntegerArray[i10] = bigInteger = new BigInteger(byArray);
        }
        parcel.setDataPosition(n11 += n10);
        return bigIntegerArray;
    }

    public static boolean[] createBooleanArray(Parcel parcel, int n10) {
        n10 = SafeParcelReader.readSize(parcel, n10);
        int n11 = parcel.dataPosition();
        if (n10 == 0) {
            return null;
        }
        boolean[] blArray = parcel.createBooleanArray();
        parcel.setDataPosition(n11 += n10);
        return blArray;
    }

    public static ArrayList createBooleanList(Parcel parcel, int n10) {
        n10 = SafeParcelReader.readSize(parcel, n10);
        int n11 = parcel.dataPosition();
        if (n10 == 0) {
            return null;
        }
        ArrayList<Boolean> arrayList = new ArrayList<Boolean>();
        int n12 = parcel.readInt();
        for (int i10 = 0; i10 < n12; ++i10) {
            Boolean bl2;
            int n13 = parcel.readInt();
            if (n13) {
                n13 = 1;
            } else {
                n13 = 0;
                bl2 = null;
            }
            bl2 = n13 != 0;
            arrayList.add(bl2);
        }
        parcel.setDataPosition(n11 += n10);
        return arrayList;
    }

    public static Bundle createBundle(Parcel parcel, int n10) {
        n10 = SafeParcelReader.readSize(parcel, n10);
        int n11 = parcel.dataPosition();
        if (n10 == 0) {
            return null;
        }
        Bundle bundle = parcel.readBundle();
        parcel.setDataPosition(n11 += n10);
        return bundle;
    }

    public static byte[] createByteArray(Parcel parcel, int n10) {
        n10 = SafeParcelReader.readSize(parcel, n10);
        int n11 = parcel.dataPosition();
        if (n10 == 0) {
            return null;
        }
        byte[] byArray = parcel.createByteArray();
        parcel.setDataPosition(n11 += n10);
        return byArray;
    }

    public static byte[][] createByteArrayArray(Parcel parcel, int n10) {
        n10 = SafeParcelReader.readSize(parcel, n10);
        int n11 = parcel.dataPosition();
        if (n10 == 0) {
            return null;
        }
        int n12 = parcel.readInt();
        byte[][] byArrayArray = new byte[n12][];
        for (int i10 = 0; i10 < n12; ++i10) {
            byte[] byArray = parcel.createByteArray();
            byArrayArray[i10] = byArray;
        }
        parcel.setDataPosition(n11 += n10);
        return byArrayArray;
    }

    public static SparseArray createByteArraySparseArray(Parcel parcel, int n10) {
        n10 = SafeParcelReader.readSize(parcel, n10);
        int n11 = parcel.dataPosition();
        if (n10 == 0) {
            return null;
        }
        int n12 = parcel.readInt();
        SparseArray sparseArray = new SparseArray(n12);
        for (int i10 = 0; i10 < n12; ++i10) {
            int n13 = parcel.readInt();
            byte[] byArray = parcel.createByteArray();
            sparseArray.append(n13, (Object)byArray);
        }
        parcel.setDataPosition(n11 += n10);
        return sparseArray;
    }

    public static char[] createCharArray(Parcel parcel, int n10) {
        n10 = SafeParcelReader.readSize(parcel, n10);
        int n11 = parcel.dataPosition();
        if (n10 == 0) {
            return null;
        }
        char[] cArray = parcel.createCharArray();
        parcel.setDataPosition(n11 += n10);
        return cArray;
    }

    public static double[] createDoubleArray(Parcel parcel, int n10) {
        n10 = SafeParcelReader.readSize(parcel, n10);
        int n11 = parcel.dataPosition();
        if (n10 == 0) {
            return null;
        }
        double[] dArray = parcel.createDoubleArray();
        parcel.setDataPosition(n11 += n10);
        return dArray;
    }

    public static ArrayList createDoubleList(Parcel parcel, int n10) {
        n10 = SafeParcelReader.readSize(parcel, n10);
        int n11 = parcel.dataPosition();
        if (n10 == 0) {
            return null;
        }
        ArrayList<Double> arrayList = new ArrayList<Double>();
        int n12 = parcel.readInt();
        for (int i10 = 0; i10 < n12; ++i10) {
            double d10 = parcel.readDouble();
            Double d11 = d10;
            arrayList.add(d11);
        }
        parcel.setDataPosition(n11 += n10);
        return arrayList;
    }

    public static SparseArray createDoubleSparseArray(Parcel parcel, int n10) {
        n10 = SafeParcelReader.readSize(parcel, n10);
        int n11 = parcel.dataPosition();
        if (n10 == 0) {
            return null;
        }
        SparseArray sparseArray = new SparseArray();
        int n12 = parcel.readInt();
        for (int i10 = 0; i10 < n12; ++i10) {
            int n13 = parcel.readInt();
            double d10 = parcel.readDouble();
            Double d11 = d10;
            sparseArray.append(n13, (Object)d11);
        }
        parcel.setDataPosition(n11 += n10);
        return sparseArray;
    }

    public static float[] createFloatArray(Parcel parcel, int n10) {
        n10 = SafeParcelReader.readSize(parcel, n10);
        int n11 = parcel.dataPosition();
        if (n10 == 0) {
            return null;
        }
        float[] fArray = parcel.createFloatArray();
        parcel.setDataPosition(n11 += n10);
        return fArray;
    }

    public static ArrayList createFloatList(Parcel parcel, int n10) {
        n10 = SafeParcelReader.readSize(parcel, n10);
        int n11 = parcel.dataPosition();
        if (n10 == 0) {
            return null;
        }
        ArrayList<Float> arrayList = new ArrayList<Float>();
        int n12 = parcel.readInt();
        for (int i10 = 0; i10 < n12; ++i10) {
            float f10 = parcel.readFloat();
            Float f11 = Float.valueOf(f10);
            arrayList.add(f11);
        }
        parcel.setDataPosition(n11 += n10);
        return arrayList;
    }

    public static SparseArray createFloatSparseArray(Parcel parcel, int n10) {
        n10 = SafeParcelReader.readSize(parcel, n10);
        int n11 = parcel.dataPosition();
        if (n10 == 0) {
            return null;
        }
        SparseArray sparseArray = new SparseArray();
        int n12 = parcel.readInt();
        for (int i10 = 0; i10 < n12; ++i10) {
            int n13 = parcel.readInt();
            float f10 = parcel.readFloat();
            Float f11 = Float.valueOf(f10);
            sparseArray.append(n13, (Object)f11);
        }
        parcel.setDataPosition(n11 += n10);
        return sparseArray;
    }

    public static IBinder[] createIBinderArray(Parcel parcel, int n10) {
        n10 = SafeParcelReader.readSize(parcel, n10);
        int n11 = parcel.dataPosition();
        if (n10 == 0) {
            return null;
        }
        IBinder[] iBinderArray = parcel.createBinderArray();
        parcel.setDataPosition(n11 += n10);
        return iBinderArray;
    }

    public static ArrayList createIBinderList(Parcel parcel, int n10) {
        n10 = SafeParcelReader.readSize(parcel, n10);
        int n11 = parcel.dataPosition();
        if (n10 == 0) {
            return null;
        }
        ArrayList arrayList = parcel.createBinderArrayList();
        parcel.setDataPosition(n11 += n10);
        return arrayList;
    }

    public static SparseArray createIBinderSparseArray(Parcel parcel, int n10) {
        n10 = SafeParcelReader.readSize(parcel, n10);
        int n11 = parcel.dataPosition();
        if (n10 == 0) {
            return null;
        }
        int n12 = parcel.readInt();
        SparseArray sparseArray = new SparseArray(n12);
        for (int i10 = 0; i10 < n12; ++i10) {
            int n13 = parcel.readInt();
            IBinder iBinder = parcel.readStrongBinder();
            sparseArray.append(n13, (Object)iBinder);
        }
        parcel.setDataPosition(n11 += n10);
        return sparseArray;
    }

    public static int[] createIntArray(Parcel parcel, int n10) {
        n10 = SafeParcelReader.readSize(parcel, n10);
        int n11 = parcel.dataPosition();
        if (n10 == 0) {
            return null;
        }
        int[] nArray = parcel.createIntArray();
        parcel.setDataPosition(n11 += n10);
        return nArray;
    }

    public static ArrayList createIntegerList(Parcel parcel, int n10) {
        n10 = SafeParcelReader.readSize(parcel, n10);
        int n11 = parcel.dataPosition();
        if (n10 == 0) {
            return null;
        }
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        int n12 = parcel.readInt();
        for (int i10 = 0; i10 < n12; ++i10) {
            int n13 = parcel.readInt();
            Integer n14 = n13;
            arrayList.add(n14);
        }
        parcel.setDataPosition(n11 += n10);
        return arrayList;
    }

    public static long[] createLongArray(Parcel parcel, int n10) {
        n10 = SafeParcelReader.readSize(parcel, n10);
        int n11 = parcel.dataPosition();
        if (n10 == 0) {
            return null;
        }
        long[] lArray = parcel.createLongArray();
        parcel.setDataPosition(n11 += n10);
        return lArray;
    }

    public static ArrayList createLongList(Parcel parcel, int n10) {
        n10 = SafeParcelReader.readSize(parcel, n10);
        int n11 = parcel.dataPosition();
        if (n10 == 0) {
            return null;
        }
        ArrayList<Long> arrayList = new ArrayList<Long>();
        int n12 = parcel.readInt();
        for (int i10 = 0; i10 < n12; ++i10) {
            long l10 = parcel.readLong();
            Long l11 = l10;
            arrayList.add(l11);
        }
        parcel.setDataPosition(n11 += n10);
        return arrayList;
    }

    public static Parcel createParcel(Parcel parcel, int n10) {
        n10 = SafeParcelReader.readSize(parcel, n10);
        int n11 = parcel.dataPosition();
        if (n10 == 0) {
            return null;
        }
        Parcel parcel2 = Parcel.obtain();
        parcel2.appendFrom(parcel, n11, n10);
        parcel.setDataPosition(n11 += n10);
        return parcel2;
    }

    public static Parcel[] createParcelArray(Parcel parcel, int n10) {
        n10 = SafeParcelReader.readSize(parcel, n10);
        int n11 = parcel.dataPosition();
        if (n10 == 0) {
            return null;
        }
        int n12 = parcel.readInt();
        Parcel[] parcelArray = new Parcel[n12];
        for (int i10 = 0; i10 < n12; ++i10) {
            int n13 = parcel.readInt();
            if (n13 != 0) {
                int n14 = parcel.dataPosition();
                Parcel parcel2 = Parcel.obtain();
                parcel2.appendFrom(parcel, n14, n13);
                parcelArray[i10] = parcel2;
                parcel.setDataPosition(n14 += n13);
                continue;
            }
            parcelArray[i10] = null;
        }
        parcel.setDataPosition(n11 += n10);
        return parcelArray;
    }

    public static ArrayList createParcelList(Parcel parcel, int n10) {
        n10 = SafeParcelReader.readSize(parcel, n10);
        int n11 = parcel.dataPosition();
        if (n10 == 0) {
            return null;
        }
        int n12 = parcel.readInt();
        ArrayList<Parcel> arrayList = new ArrayList<Parcel>();
        for (int i10 = 0; i10 < n12; ++i10) {
            int n13 = parcel.readInt();
            if (n13 != 0) {
                int n14 = parcel.dataPosition();
                Parcel parcel2 = Parcel.obtain();
                parcel2.appendFrom(parcel, n14, n13);
                arrayList.add(parcel2);
                parcel.setDataPosition(n14 += n13);
                continue;
            }
            arrayList.add(null);
        }
        parcel.setDataPosition(n11 += n10);
        return arrayList;
    }

    public static SparseArray createParcelSparseArray(Parcel parcel, int n10) {
        n10 = SafeParcelReader.readSize(parcel, n10);
        int n11 = parcel.dataPosition();
        if (n10 == 0) {
            return null;
        }
        int n12 = parcel.readInt();
        SparseArray sparseArray = new SparseArray();
        for (int i10 = 0; i10 < n12; ++i10) {
            int n13 = parcel.readInt();
            int n14 = parcel.readInt();
            if (n14 != 0) {
                int n15 = parcel.dataPosition();
                Parcel parcel2 = Parcel.obtain();
                parcel2.appendFrom(parcel, n15, n14);
                sparseArray.append(n13, (Object)parcel2);
                parcel.setDataPosition(n15 += n14);
                continue;
            }
            sparseArray.append(n13, null);
        }
        parcel.setDataPosition(n11 += n10);
        return sparseArray;
    }

    public static Parcelable createParcelable(Parcel parcel, int n10, Parcelable.Creator creator) {
        n10 = SafeParcelReader.readSize(parcel, n10);
        int n11 = parcel.dataPosition();
        if (n10 == 0) {
            return null;
        }
        creator = (Parcelable)creator.createFromParcel(parcel);
        parcel.setDataPosition(n11 += n10);
        return creator;
    }

    public static SparseBooleanArray createSparseBooleanArray(Parcel parcel, int n10) {
        n10 = SafeParcelReader.readSize(parcel, n10);
        int n11 = parcel.dataPosition();
        if (n10 == 0) {
            return null;
        }
        SparseBooleanArray sparseBooleanArray = parcel.readSparseBooleanArray();
        parcel.setDataPosition(n11 += n10);
        return sparseBooleanArray;
    }

    public static SparseIntArray createSparseIntArray(Parcel parcel, int n10) {
        n10 = SafeParcelReader.readSize(parcel, n10);
        int n11 = parcel.dataPosition();
        if (n10 == 0) {
            return null;
        }
        SparseIntArray sparseIntArray = new SparseIntArray();
        int n12 = parcel.readInt();
        for (int i10 = 0; i10 < n12; ++i10) {
            int n13 = parcel.readInt();
            int n14 = parcel.readInt();
            sparseIntArray.append(n13, n14);
        }
        parcel.setDataPosition(n11 += n10);
        return sparseIntArray;
    }

    public static SparseLongArray createSparseLongArray(Parcel parcel, int n10) {
        n10 = SafeParcelReader.readSize(parcel, n10);
        int n11 = parcel.dataPosition();
        if (n10 == 0) {
            return null;
        }
        SparseLongArray sparseLongArray = new SparseLongArray();
        int n12 = parcel.readInt();
        for (int i10 = 0; i10 < n12; ++i10) {
            int n13 = parcel.readInt();
            long l10 = parcel.readLong();
            sparseLongArray.append(n13, l10);
        }
        parcel.setDataPosition(n11 += n10);
        return sparseLongArray;
    }

    public static String createString(Parcel parcel, int n10) {
        n10 = SafeParcelReader.readSize(parcel, n10);
        int n11 = parcel.dataPosition();
        if (n10 == 0) {
            return null;
        }
        String string2 = parcel.readString();
        parcel.setDataPosition(n11 += n10);
        return string2;
    }

    public static String[] createStringArray(Parcel parcel, int n10) {
        n10 = SafeParcelReader.readSize(parcel, n10);
        int n11 = parcel.dataPosition();
        if (n10 == 0) {
            return null;
        }
        String[] stringArray = parcel.createStringArray();
        parcel.setDataPosition(n11 += n10);
        return stringArray;
    }

    public static ArrayList createStringList(Parcel parcel, int n10) {
        n10 = SafeParcelReader.readSize(parcel, n10);
        int n11 = parcel.dataPosition();
        if (n10 == 0) {
            return null;
        }
        ArrayList arrayList = parcel.createStringArrayList();
        parcel.setDataPosition(n11 += n10);
        return arrayList;
    }

    public static SparseArray createStringSparseArray(Parcel parcel, int n10) {
        n10 = SafeParcelReader.readSize(parcel, n10);
        int n11 = parcel.dataPosition();
        if (n10 == 0) {
            return null;
        }
        SparseArray sparseArray = new SparseArray();
        int n12 = parcel.readInt();
        for (int i10 = 0; i10 < n12; ++i10) {
            int n13 = parcel.readInt();
            String string2 = parcel.readString();
            sparseArray.append(n13, (Object)string2);
        }
        parcel.setDataPosition(n11 += n10);
        return sparseArray;
    }

    public static Object[] createTypedArray(Parcel parcel, int n10, Parcelable.Creator objectArray) {
        n10 = SafeParcelReader.readSize(parcel, n10);
        int n11 = parcel.dataPosition();
        if (n10 == 0) {
            return null;
        }
        objectArray = parcel.createTypedArray((Parcelable.Creator)objectArray);
        parcel.setDataPosition(n11 += n10);
        return objectArray;
    }

    public static ArrayList createTypedList(Parcel parcel, int n10, Parcelable.Creator object) {
        n10 = SafeParcelReader.readSize(parcel, n10);
        int n11 = parcel.dataPosition();
        if (n10 == 0) {
            return null;
        }
        object = parcel.createTypedArrayList(object);
        parcel.setDataPosition(n11 += n10);
        return object;
    }

    public static SparseArray createTypedSparseArray(Parcel parcel, int n10, Parcelable.Creator creator) {
        n10 = SafeParcelReader.readSize(parcel, n10);
        int n11 = parcel.dataPosition();
        if (n10 == 0) {
            return null;
        }
        int n12 = parcel.readInt();
        SparseArray sparseArray = new SparseArray();
        for (int i10 = 0; i10 < n12; ++i10) {
            Object object;
            int n13 = parcel.readInt();
            int n14 = parcel.readInt();
            if (n14 != 0) {
                object = creator.createFromParcel(parcel);
            } else {
                n14 = 0;
                object = null;
            }
            sparseArray.append(n13, object);
        }
        parcel.setDataPosition(n11 += n10);
        return sparseArray;
    }

    public static void ensureAtEnd(Parcel parcel, int n10) {
        int n11 = parcel.dataPosition();
        if (n11 == n10) {
            return;
        }
        StringBuilder stringBuilder = new StringBuilder(37);
        stringBuilder.append("Overread allowed size end=");
        stringBuilder.append(n10);
        String string2 = stringBuilder.toString();
        SafeParcelReader$ParseException safeParcelReader$ParseException = new SafeParcelReader$ParseException(string2, parcel);
        throw safeParcelReader$ParseException;
    }

    public static int getFieldId(int n10) {
        return n10 & (char)-1;
    }

    public static boolean readBoolean(Parcel parcel, int n10) {
        int n11 = 4;
        SafeParcelReader.zza(parcel, n10, n11);
        int n12 = parcel.readInt();
        return n12 != 0;
    }

    /*
     * WARNING - void declaration
     */
    public static Boolean readBooleanObject(Parcel parcel, int n10) {
        void var4_7;
        int n11 = SafeParcelReader.readSize(parcel, n10);
        if (n11 == 0) {
            return null;
        }
        int n12 = 4;
        SafeParcelReader.zza(parcel, n10, n11, n12);
        int bl2 = parcel.readInt();
        if (bl2 != 0) {
            boolean bl3 = true;
        } else {
            boolean bl4 = false;
            parcel = null;
        }
        return (boolean)var4_7;
    }

    public static byte readByte(Parcel parcel, int n10) {
        SafeParcelReader.zza(parcel, n10, 4);
        return (byte)parcel.readInt();
    }

    public static char readChar(Parcel parcel, int n10) {
        SafeParcelReader.zza(parcel, n10, 4);
        return (char)parcel.readInt();
    }

    public static double readDouble(Parcel parcel, int n10) {
        SafeParcelReader.zza(parcel, n10, 8);
        return parcel.readDouble();
    }

    public static Double readDoubleObject(Parcel parcel, int n10) {
        int n11 = SafeParcelReader.readSize(parcel, n10);
        if (n11 == 0) {
            return null;
        }
        SafeParcelReader.zza(parcel, n10, n11, 8);
        return parcel.readDouble();
    }

    public static float readFloat(Parcel parcel, int n10) {
        SafeParcelReader.zza(parcel, n10, 4);
        return parcel.readFloat();
    }

    public static Float readFloatObject(Parcel parcel, int n10) {
        int n11 = SafeParcelReader.readSize(parcel, n10);
        if (n11 == 0) {
            return null;
        }
        SafeParcelReader.zza(parcel, n10, n11, 4);
        return Float.valueOf(parcel.readFloat());
    }

    public static int readHeader(Parcel parcel) {
        return parcel.readInt();
    }

    public static IBinder readIBinder(Parcel parcel, int n10) {
        n10 = SafeParcelReader.readSize(parcel, n10);
        int n11 = parcel.dataPosition();
        if (n10 == 0) {
            return null;
        }
        IBinder iBinder = parcel.readStrongBinder();
        parcel.setDataPosition(n11 += n10);
        return iBinder;
    }

    public static int readInt(Parcel parcel, int n10) {
        SafeParcelReader.zza(parcel, n10, 4);
        return parcel.readInt();
    }

    public static Integer readIntegerObject(Parcel parcel, int n10) {
        int n11 = SafeParcelReader.readSize(parcel, n10);
        if (n11 == 0) {
            return null;
        }
        SafeParcelReader.zza(parcel, n10, n11, 4);
        return parcel.readInt();
    }

    public static void readList(Parcel parcel, int n10, List list, ClassLoader classLoader) {
        n10 = SafeParcelReader.readSize(parcel, n10);
        int n11 = parcel.dataPosition();
        if (n10 == 0) {
            return;
        }
        parcel.readList(list, classLoader);
        parcel.setDataPosition(n11 += n10);
    }

    public static long readLong(Parcel parcel, int n10) {
        SafeParcelReader.zza(parcel, n10, 8);
        return parcel.readLong();
    }

    public static Long readLongObject(Parcel parcel, int n10) {
        int n11 = SafeParcelReader.readSize(parcel, n10);
        if (n11 == 0) {
            return null;
        }
        SafeParcelReader.zza(parcel, n10, n11, 8);
        return parcel.readLong();
    }

    public static short readShort(Parcel parcel, int n10) {
        SafeParcelReader.zza(parcel, n10, 4);
        return (short)parcel.readInt();
    }

    public static int readSize(Parcel parcel, int n10) {
        int n11 = -65536;
        int n12 = n10 & n11;
        if (n12 != n11) {
            return n10 >> 16 & (char)-1;
        }
        return parcel.readInt();
    }

    public static void skipUnknownField(Parcel parcel, int n10) {
        n10 = SafeParcelReader.readSize(parcel, n10);
        int n11 = parcel.dataPosition() + n10;
        parcel.setDataPosition(n11);
    }

    public static int validateObjectHeader(Parcel parcel) {
        int n10;
        int n11 = SafeParcelReader.readHeader(parcel);
        int n12 = SafeParcelReader.readSize(parcel, n11);
        int n13 = parcel.dataPosition();
        int n14 = SafeParcelReader.getFieldId(n11);
        if (n14 != (n10 = 20293)) {
            String string2 = "Expected object header. Got 0x";
            String string3 = String.valueOf(Integer.toHexString(n11));
            n14 = string3.length();
            string3 = n14 != 0 ? string2.concat(string3) : new String(string2);
            SafeParcelReader$ParseException safeParcelReader$ParseException = new SafeParcelReader$ParseException(string3, parcel);
            throw safeParcelReader$ParseException;
        }
        if ((n12 += n13) >= n13 && n12 <= (n11 = parcel.dataSize())) {
            return n12;
        }
        StringBuilder stringBuilder = new StringBuilder(54);
        stringBuilder.append("Size read is invalid start=");
        stringBuilder.append(n13);
        stringBuilder.append(" end=");
        stringBuilder.append(n12);
        String string4 = stringBuilder.toString();
        SafeParcelReader$ParseException safeParcelReader$ParseException = new SafeParcelReader$ParseException(string4, parcel);
        throw safeParcelReader$ParseException;
    }

    private static void zza(Parcel parcel, int n10, int n11) {
        if ((n10 = SafeParcelReader.readSize(parcel, n10)) == n11) {
            return;
        }
        String string2 = Integer.toHexString(n10);
        int n12 = String.valueOf(string2).length() + 46;
        StringBuilder stringBuilder = new StringBuilder(n12);
        stringBuilder.append("Expected size ");
        stringBuilder.append(n11);
        stringBuilder.append(" got ");
        stringBuilder.append(n10);
        stringBuilder.append(" (0x");
        stringBuilder.append(string2);
        stringBuilder.append(")");
        String string3 = stringBuilder.toString();
        SafeParcelReader$ParseException safeParcelReader$ParseException = new SafeParcelReader$ParseException(string3, parcel);
        throw safeParcelReader$ParseException;
    }

    private static void zza(Parcel parcel, int n10, int n11, int n12) {
        if (n11 == n12) {
            return;
        }
        String string2 = Integer.toHexString(n11);
        int n13 = String.valueOf(string2).length() + 46;
        StringBuilder stringBuilder = new StringBuilder(n13);
        stringBuilder.append("Expected size ");
        stringBuilder.append(n12);
        stringBuilder.append(" got ");
        stringBuilder.append(n11);
        stringBuilder.append(" (0x");
        stringBuilder.append(string2);
        stringBuilder.append(")");
        String string3 = stringBuilder.toString();
        SafeParcelReader$ParseException safeParcelReader$ParseException = new SafeParcelReader$ParseException(string3, parcel);
        throw safeParcelReader$ParseException;
    }
}

