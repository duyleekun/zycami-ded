/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.IBinder
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.util.SparseArray
 *  android.util.SparseBooleanArray
 *  android.util.SparseIntArray
 *  android.util.SparseLongArray
 */
package com.huawei.hms.common.internal.safeparcel;

import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import android.util.SparseLongArray;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

public class SafeParcelWriter {
    private static final int BIT16_MARK = 65535;
    private static final int FIELD_ID_CHECKER = 20293;
    private static final int NEGATIVE_MARK = 0xFF0000;
    private static final int OFFSET16 = 16;

    private SafeParcelWriter() {
    }

    public static int beginObjectHeader(Parcel parcel) {
        return SafeParcelWriter.getStartPosition(parcel, 20293);
    }

    public static void finishObjectHeader(Parcel parcel, int n10) {
        SafeParcelWriter.handleDataOver(parcel, n10);
    }

    private static int getStartPosition(Parcel parcel, int n10) {
        parcel.writeInt(n10 |= 0xFFFF0000);
        parcel.writeInt(0);
        return parcel.dataPosition();
    }

    private static void handleDataOver(Parcel parcel, int n10) {
        int n11 = parcel.dataPosition();
        int n12 = n11 - n10;
        parcel.setDataPosition(n10 += -4);
        parcel.writeInt(n12);
        parcel.setDataPosition(n11);
    }

    private static void setHeader(Parcel parcel, int n10, int n11) {
        char c10 = (char)-1;
        if (n11 >= c10) {
            parcel.writeInt(n10 |= 0xFFFF0000);
            parcel.writeInt(n11);
            return;
        }
        parcel.writeInt(n10 |= (n11 <<= 16));
    }

    private static void setSizeOfData(Parcel parcel, Parcelable parcelable, int n10) {
        int n11 = parcel.dataPosition();
        parcel.writeInt(1);
        int n12 = parcel.dataPosition();
        parcelable.writeToParcel(parcel, n10);
        int n13 = parcel.dataPosition();
        parcel.setDataPosition(n11);
        n10 = n13 - n12;
        parcel.writeInt(n10);
        parcel.setDataPosition(n13);
    }

    public static void writeBigDecimal(Parcel parcel, int n10, BigDecimal bigDecimal, boolean bl2) {
        if (bigDecimal != null) {
            n10 = SafeParcelWriter.getStartPosition(parcel, n10);
            byte[] byArray = bigDecimal.unscaledValue().toByteArray();
            parcel.writeByteArray(byArray);
            int n11 = bigDecimal.scale();
            parcel.writeInt(n11);
            SafeParcelWriter.handleDataOver(parcel, n10);
        } else if (bl2) {
            boolean bl3 = false;
            bigDecimal = null;
            SafeParcelWriter.setHeader(parcel, n10, 0);
        }
    }

    public static void writeBigDecimalArray(Parcel parcel, int n10, BigDecimal[] bigDecimalArray, boolean n11) {
        if (bigDecimalArray != null) {
            n10 = SafeParcelWriter.getStartPosition(parcel, n10);
            n11 = bigDecimalArray.length;
            parcel.writeInt(n11);
            for (int i10 = 0; i10 < n11; ++i10) {
                Object object = bigDecimalArray[i10].unscaledValue().toByteArray();
                parcel.writeByteArray((byte[])object);
                object = bigDecimalArray[i10];
                int n12 = ((BigDecimal)object).scale();
                parcel.writeInt(n12);
            }
            SafeParcelWriter.handleDataOver(parcel, n10);
        } else if (n11) {
            SafeParcelWriter.setHeader(parcel, n10, 0);
        }
    }

    public static void writeBigInteger(Parcel parcel, int n10, BigInteger object, boolean bl2) {
        if (object != null) {
            n10 = SafeParcelWriter.getStartPosition(parcel, n10);
            object = ((BigInteger)object).toByteArray();
            parcel.writeByteArray((byte[])object);
            SafeParcelWriter.handleDataOver(parcel, n10);
        } else if (bl2) {
            object = null;
            SafeParcelWriter.setHeader(parcel, n10, 0);
        }
    }

    public static void writeBigIntegerArray(Parcel parcel, int n10, BigInteger[] bigIntegerArray, boolean n11) {
        if (bigIntegerArray != null) {
            n10 = SafeParcelWriter.getStartPosition(parcel, n10);
            n11 = bigIntegerArray.length;
            parcel.writeInt(n11);
            for (int i10 = 0; i10 < n11; ++i10) {
                byte[] byArray = bigIntegerArray[i10].toByteArray();
                parcel.writeByteArray(byArray);
            }
            SafeParcelWriter.handleDataOver(parcel, n10);
        } else if (n11) {
            SafeParcelWriter.setHeader(parcel, n10, 0);
        }
    }

    public static void writeBoolean(Parcel parcel, int n10, boolean bl2) {
        int n11 = 4;
        SafeParcelWriter.setHeader(parcel, n10, n11);
        if (bl2) {
            n10 = 1;
            parcel.writeInt(n10);
        } else {
            n10 = 0;
            parcel.writeInt(0);
        }
    }

    public static void writeBooleanArray(Parcel parcel, int n10, boolean[] blArray, boolean bl2) {
        if (blArray != null) {
            n10 = SafeParcelWriter.getStartPosition(parcel, n10);
            parcel.writeBooleanArray(blArray);
            SafeParcelWriter.handleDataOver(parcel, n10);
        } else if (bl2) {
            blArray = null;
            SafeParcelWriter.setHeader(parcel, n10, 0);
        }
    }

    public static void writeBooleanList(Parcel parcel, int n10, List list, boolean n11) {
        if (list != null) {
            n10 = SafeParcelWriter.getStartPosition(parcel, n10);
            n11 = list.size();
            parcel.writeInt(n11);
            for (int i10 = 0; i10 < n11; ++i10) {
                Boolean bl2 = (Boolean)list.get(i10);
                int n12 = bl2.booleanValue();
                parcel.writeInt(n12);
            }
            SafeParcelWriter.handleDataOver(parcel, n10);
        } else if (n11 != 0) {
            SafeParcelWriter.setHeader(parcel, n10, 0);
        }
    }

    public static void writeBooleanObject(Parcel parcel, int n10, Boolean bl2, boolean bl3) {
        if (bl2 != null) {
            int n11 = 4;
            SafeParcelWriter.setHeader(parcel, n10, n11);
            n10 = (int)(bl2.booleanValue() ? 1 : 0);
            parcel.writeInt(n10);
        } else if (bl3) {
            bl2 = null;
            SafeParcelWriter.setHeader(parcel, n10, 0);
        }
    }

    public static void writeBundle(Parcel parcel, int n10, Bundle bundle, boolean bl2) {
        if (bundle != null) {
            n10 = SafeParcelWriter.getStartPosition(parcel, n10);
            parcel.writeBundle(bundle);
            SafeParcelWriter.handleDataOver(parcel, n10);
        } else if (bl2) {
            bundle = null;
            SafeParcelWriter.setHeader(parcel, n10, 0);
        }
    }

    public static void writeByte(Parcel parcel, int n10, byte by2) {
        SafeParcelWriter.setHeader(parcel, n10, 4);
        parcel.writeInt((int)by2);
    }

    public static void writeByteArray(Parcel parcel, int n10, byte[] byArray, boolean bl2) {
        if (byArray != null) {
            n10 = SafeParcelWriter.getStartPosition(parcel, n10);
            parcel.writeByteArray(byArray);
            SafeParcelWriter.handleDataOver(parcel, n10);
        } else if (bl2) {
            byArray = null;
            SafeParcelWriter.setHeader(parcel, n10, 0);
        }
    }

    public static void writeByteArrayArray(Parcel parcel, int n10, byte[][] byArray, boolean n11) {
        if (byArray != null) {
            n10 = SafeParcelWriter.getStartPosition(parcel, n10);
            n11 = byArray.length;
            parcel.writeInt(n11);
            for (int i10 = 0; i10 < n11; ++i10) {
                byte[] byArray2 = byArray[i10];
                parcel.writeByteArray(byArray2);
            }
            SafeParcelWriter.handleDataOver(parcel, n10);
        } else if (n11) {
            SafeParcelWriter.setHeader(parcel, n10, 0);
        }
    }

    public static void writeByteArraySparseArray(Parcel parcel, int n10, SparseArray sparseArray, boolean n11) {
        if (sparseArray != null) {
            n10 = SafeParcelWriter.getStartPosition(parcel, n10);
            n11 = sparseArray.size();
            parcel.writeInt(n11);
            for (int i10 = 0; i10 < n11; ++i10) {
                int n12 = sparseArray.keyAt(i10);
                parcel.writeInt(n12);
                byte[] byArray = (byte[])sparseArray.valueAt(i10);
                parcel.writeByteArray(byArray);
            }
            SafeParcelWriter.handleDataOver(parcel, n10);
        } else if (n11) {
            SafeParcelWriter.setHeader(parcel, n10, 0);
        }
    }

    public static void writeChar(Parcel parcel, int n10, char c10) {
        SafeParcelWriter.setHeader(parcel, n10, 4);
        parcel.writeInt((int)c10);
    }

    public static void writeCharArray(Parcel parcel, int n10, char[] cArray, boolean bl2) {
        if (cArray != null) {
            n10 = SafeParcelWriter.getStartPosition(parcel, n10);
            parcel.writeCharArray(cArray);
            SafeParcelWriter.handleDataOver(parcel, n10);
        } else if (bl2) {
            cArray = null;
            SafeParcelWriter.setHeader(parcel, n10, 0);
        }
    }

    public static void writeDouble(Parcel parcel, int n10, double d10) {
        SafeParcelWriter.setHeader(parcel, n10, 8);
        parcel.writeDouble(d10);
    }

    public static void writeDoubleArray(Parcel parcel, int n10, double[] dArray, boolean bl2) {
        if (dArray != null) {
            n10 = SafeParcelWriter.getStartPosition(parcel, n10);
            parcel.writeDoubleArray(dArray);
            SafeParcelWriter.handleDataOver(parcel, n10);
        } else if (bl2) {
            dArray = null;
            SafeParcelWriter.setHeader(parcel, n10, 0);
        }
    }

    public static void writeDoubleList(Parcel parcel, int n10, List list, boolean n11) {
        if (list != null) {
            n10 = SafeParcelWriter.getStartPosition(parcel, n10);
            n11 = list.size();
            parcel.writeInt(n11);
            for (int i10 = 0; i10 < n11; ++i10) {
                Double d10 = (Double)list.get(i10);
                double d11 = d10;
                parcel.writeDouble(d11);
            }
            SafeParcelWriter.handleDataOver(parcel, n10);
        } else if (n11) {
            SafeParcelWriter.setHeader(parcel, n10, 0);
        }
    }

    public static void writeDoubleObject(Parcel parcel, int n10, Double d10, boolean bl2) {
        if (d10 != null) {
            int n11 = 8;
            SafeParcelWriter.setHeader(parcel, n10, n11);
            double d11 = d10;
            parcel.writeDouble(d11);
        } else if (bl2) {
            d10 = null;
            SafeParcelWriter.setHeader(parcel, n10, 0);
        }
    }

    public static void writeDoubleSparseArray(Parcel parcel, int n10, SparseArray sparseArray, boolean n11) {
        if (sparseArray != null) {
            n10 = SafeParcelWriter.getStartPosition(parcel, n10);
            n11 = sparseArray.size();
            parcel.writeInt(n11);
            for (int i10 = 0; i10 < n11; ++i10) {
                int n12 = sparseArray.keyAt(i10);
                parcel.writeInt(n12);
                Double d10 = (Double)sparseArray.valueAt(i10);
                double d11 = d10;
                parcel.writeDouble(d11);
            }
            SafeParcelWriter.handleDataOver(parcel, n10);
        } else if (n11) {
            SafeParcelWriter.setHeader(parcel, n10, 0);
        }
    }

    public static void writeFloat(Parcel parcel, int n10, float f10) {
        SafeParcelWriter.setHeader(parcel, n10, 4);
        parcel.writeFloat(f10);
    }

    public static void writeFloatArray(Parcel parcel, int n10, float[] fArray, boolean bl2) {
        if (fArray != null) {
            n10 = SafeParcelWriter.getStartPosition(parcel, n10);
            parcel.writeFloatArray(fArray);
            SafeParcelWriter.handleDataOver(parcel, n10);
        } else if (bl2) {
            fArray = null;
            SafeParcelWriter.setHeader(parcel, n10, 0);
        }
    }

    public static void writeFloatList(Parcel parcel, int n10, List list, boolean n11) {
        if (list != null) {
            n10 = SafeParcelWriter.getStartPosition(parcel, n10);
            n11 = list.size();
            parcel.writeInt(n11);
            for (int i10 = 0; i10 < n11; ++i10) {
                Float f10 = (Float)list.get(i10);
                float f11 = f10.floatValue();
                parcel.writeFloat(f11);
            }
            SafeParcelWriter.handleDataOver(parcel, n10);
        } else if (n11) {
            SafeParcelWriter.setHeader(parcel, n10, 0);
        }
    }

    public static void writeFloatObject(Parcel parcel, int n10, Float f10, boolean bl2) {
        if (f10 != null) {
            int n11 = 4;
            SafeParcelWriter.setHeader(parcel, n10, n11);
            float f11 = f10.floatValue();
            parcel.writeFloat(f11);
        } else if (bl2) {
            f10 = null;
            SafeParcelWriter.setHeader(parcel, n10, 0);
        }
    }

    public static void writeFloatSparseArray(Parcel parcel, int n10, SparseArray sparseArray, boolean n11) {
        if (sparseArray != null) {
            n10 = SafeParcelWriter.getStartPosition(parcel, n10);
            n11 = sparseArray.size();
            parcel.writeInt(n11);
            for (int i10 = 0; i10 < n11; ++i10) {
                int n12 = sparseArray.keyAt(i10);
                parcel.writeInt(n12);
                Float f10 = (Float)sparseArray.valueAt(i10);
                float f11 = f10.floatValue();
                parcel.writeFloat(f11);
            }
            SafeParcelWriter.handleDataOver(parcel, n10);
        } else if (n11) {
            SafeParcelWriter.setHeader(parcel, n10, 0);
        }
    }

    public static void writeIBinder(Parcel parcel, int n10, IBinder iBinder, boolean bl2) {
        if (iBinder != null) {
            n10 = SafeParcelWriter.getStartPosition(parcel, n10);
            parcel.writeStrongBinder(iBinder);
            SafeParcelWriter.handleDataOver(parcel, n10);
        } else if (bl2) {
            iBinder = null;
            SafeParcelWriter.setHeader(parcel, n10, 0);
        }
    }

    public static void writeIBinderArray(Parcel parcel, int n10, IBinder[] iBinderArray, boolean bl2) {
        if (iBinderArray != null) {
            n10 = SafeParcelWriter.getStartPosition(parcel, n10);
            parcel.writeBinderArray(iBinderArray);
            SafeParcelWriter.handleDataOver(parcel, n10);
        } else if (bl2) {
            iBinderArray = null;
            SafeParcelWriter.setHeader(parcel, n10, 0);
        }
    }

    public static void writeIBinderList(Parcel parcel, int n10, List list, boolean bl2) {
        if (list != null) {
            n10 = SafeParcelWriter.getStartPosition(parcel, n10);
            parcel.writeBinderList(list);
            SafeParcelWriter.handleDataOver(parcel, n10);
        } else if (bl2) {
            list = null;
            SafeParcelWriter.setHeader(parcel, n10, 0);
        }
    }

    public static void writeIBinderSparseArray(Parcel parcel, int n10, SparseArray sparseArray, boolean n11) {
        if (sparseArray != null) {
            n10 = SafeParcelWriter.getStartPosition(parcel, n10);
            n11 = sparseArray.size();
            parcel.writeInt(n11);
            for (int i10 = 0; i10 < n11; ++i10) {
                int n12 = sparseArray.keyAt(i10);
                parcel.writeInt(n12);
                IBinder iBinder = (IBinder)sparseArray.valueAt(i10);
                parcel.writeStrongBinder(iBinder);
            }
            SafeParcelWriter.handleDataOver(parcel, n10);
        } else if (n11) {
            SafeParcelWriter.setHeader(parcel, n10, 0);
        }
    }

    public static void writeInt(Parcel parcel, int n10, int n11) {
        SafeParcelWriter.setHeader(parcel, n10, 4);
        parcel.writeInt(n11);
    }

    public static void writeIntArray(Parcel parcel, int n10, int[] nArray, boolean bl2) {
        if (nArray != null) {
            n10 = SafeParcelWriter.getStartPosition(parcel, n10);
            parcel.writeIntArray(nArray);
            SafeParcelWriter.handleDataOver(parcel, n10);
        } else if (bl2) {
            nArray = null;
            SafeParcelWriter.setHeader(parcel, n10, 0);
        }
    }

    public static void writeIntegerList(Parcel parcel, int n10, List list, boolean n11) {
        if (list != null) {
            n10 = SafeParcelWriter.getStartPosition(parcel, n10);
            n11 = list.size();
            parcel.writeInt(n11);
            for (int i10 = 0; i10 < n11; ++i10) {
                Integer n12 = (Integer)list.get(i10);
                int n13 = n12;
                parcel.writeInt(n13);
            }
            SafeParcelWriter.handleDataOver(parcel, n10);
        } else if (n11) {
            SafeParcelWriter.setHeader(parcel, n10, 0);
        }
    }

    public static void writeIntegerObject(Parcel parcel, int n10, Integer n11, boolean bl2) {
        if (n11 != null) {
            int n12 = 4;
            SafeParcelWriter.setHeader(parcel, n10, n12);
            n10 = n11;
            parcel.writeInt(n10);
        } else if (bl2) {
            n11 = null;
            SafeParcelWriter.setHeader(parcel, n10, 0);
        }
    }

    public static void writeList(Parcel parcel, int n10, List list, boolean bl2) {
        if (list != null) {
            n10 = SafeParcelWriter.getStartPosition(parcel, n10);
            parcel.writeList(list);
            SafeParcelWriter.handleDataOver(parcel, n10);
        } else if (bl2) {
            list = null;
            SafeParcelWriter.setHeader(parcel, n10, 0);
        }
    }

    public static void writeLong(Parcel parcel, int n10, long l10) {
        SafeParcelWriter.setHeader(parcel, n10, 8);
        parcel.writeLong(l10);
    }

    public static void writeLongArray(Parcel parcel, int n10, long[] lArray, boolean bl2) {
        if (lArray != null) {
            n10 = SafeParcelWriter.getStartPosition(parcel, n10);
            parcel.writeLongArray(lArray);
            SafeParcelWriter.handleDataOver(parcel, n10);
        } else if (bl2) {
            lArray = null;
            SafeParcelWriter.setHeader(parcel, n10, 0);
        }
    }

    public static void writeLongList(Parcel parcel, int n10, List list, boolean n11) {
        if (list != null) {
            n10 = SafeParcelWriter.getStartPosition(parcel, n10);
            n11 = list.size();
            parcel.writeInt(n11);
            for (int i10 = 0; i10 < n11; ++i10) {
                Long l10 = (Long)list.get(i10);
                long l11 = l10;
                parcel.writeLong(l11);
            }
            SafeParcelWriter.handleDataOver(parcel, n10);
        } else if (n11) {
            SafeParcelWriter.setHeader(parcel, n10, 0);
        }
    }

    public static void writeLongObject(Parcel parcel, int n10, Long l10, boolean bl2) {
        if (l10 != null) {
            int n11 = 8;
            SafeParcelWriter.setHeader(parcel, n10, n11);
            long l11 = l10;
            parcel.writeLong(l11);
        } else if (bl2) {
            l10 = null;
            SafeParcelWriter.setHeader(parcel, n10, 0);
        }
    }

    public static void writeParcel(Parcel parcel, int n10, Parcel parcel2, boolean bl2) {
        if (parcel2 != null) {
            n10 = SafeParcelWriter.getStartPosition(parcel, n10);
            int n11 = parcel2.dataSize();
            parcel.appendFrom(parcel2, 0, n11);
            SafeParcelWriter.handleDataOver(parcel, n10);
        } else if (bl2) {
            SafeParcelWriter.setHeader(parcel, n10, 0);
        }
    }

    public static void writeParcelArray(Parcel parcel, int n10, Parcel[] parcelArray, boolean n11) {
        if (parcelArray != null) {
            n10 = SafeParcelWriter.getStartPosition(parcel, n10);
            n11 = parcelArray.length;
            parcel.writeInt(n11);
            for (int i10 = 0; i10 < n11; ++i10) {
                Parcel parcel2 = parcelArray[i10];
                if (parcel2 == null) {
                    parcel.writeInt(0);
                    continue;
                }
                int n12 = parcelArray[i10].dataSize();
                parcel.writeInt(n12);
                parcel2 = parcelArray[i10];
                Parcel parcel3 = parcelArray[i10];
                int n13 = parcel3.dataSize();
                parcel.appendFrom(parcel2, 0, n13);
            }
            SafeParcelWriter.handleDataOver(parcel, n10);
        } else if (n11) {
            SafeParcelWriter.setHeader(parcel, n10, 0);
        }
    }

    public static void writeParcelList(Parcel parcel, int n10, List list, boolean n11) {
        if (list != null) {
            n10 = SafeParcelWriter.getStartPosition(parcel, n10);
            n11 = list.size();
            parcel.writeInt(n11);
            for (int i10 = 0; i10 < n11; ++i10) {
                Parcel parcel2 = (Parcel)list.get(i10);
                if (parcel2 == null) {
                    parcel.writeInt(0);
                    continue;
                }
                int n12 = parcel2.dataSize();
                parcel.writeInt(n12);
                n12 = parcel2.dataSize();
                parcel.appendFrom(parcel2, 0, n12);
            }
            SafeParcelWriter.handleDataOver(parcel, n10);
        } else if (n11) {
            SafeParcelWriter.setHeader(parcel, n10, 0);
        }
    }

    public static void writeParcelSparseArray(Parcel parcel, int n10, SparseArray sparseArray, boolean n11) {
        if (sparseArray != null) {
            n10 = SafeParcelWriter.getStartPosition(parcel, n10);
            n11 = sparseArray.size();
            parcel.writeInt(n11);
            for (int i10 = 0; i10 < n11; ++i10) {
                int n12 = sparseArray.keyAt(i10);
                parcel.writeInt(n12);
                Parcel parcel2 = (Parcel)sparseArray.valueAt(i10);
                if (parcel2 == null) {
                    parcel.writeInt(0);
                    continue;
                }
                int n13 = parcel2.dataSize();
                parcel.writeInt(n13);
                n13 = parcel2.dataSize();
                parcel.appendFrom(parcel2, 0, n13);
            }
            SafeParcelWriter.handleDataOver(parcel, n10);
        } else if (n11) {
            SafeParcelWriter.setHeader(parcel, n10, 0);
        }
    }

    public static void writeParcelable(Parcel parcel, int n10, Parcelable parcelable, int n11, boolean bl2) {
        if (parcelable != null) {
            n10 = SafeParcelWriter.getStartPosition(parcel, n10);
            parcelable.writeToParcel(parcel, n11);
            SafeParcelWriter.handleDataOver(parcel, n10);
        } else if (bl2) {
            parcelable = null;
            SafeParcelWriter.setHeader(parcel, n10, 0);
        }
    }

    public static void writeShort(Parcel parcel, int n10, short s10) {
        SafeParcelWriter.setHeader(parcel, n10, 4);
        parcel.writeInt((int)s10);
    }

    public static void writeSparseBooleanArray(Parcel parcel, int n10, SparseBooleanArray sparseBooleanArray, boolean bl2) {
        if (sparseBooleanArray != null) {
            n10 = SafeParcelWriter.getStartPosition(parcel, n10);
            parcel.writeSparseBooleanArray(sparseBooleanArray);
            SafeParcelWriter.handleDataOver(parcel, n10);
        } else if (bl2) {
            sparseBooleanArray = null;
            SafeParcelWriter.setHeader(parcel, n10, 0);
        }
    }

    public static void writeSparseIntArray(Parcel parcel, int n10, SparseIntArray sparseIntArray, boolean n11) {
        if (sparseIntArray != null) {
            n10 = SafeParcelWriter.getStartPosition(parcel, n10);
            n11 = sparseIntArray.size();
            parcel.writeInt(n11);
            for (int i10 = 0; i10 < n11; ++i10) {
                int n12 = sparseIntArray.keyAt(i10);
                parcel.writeInt(n12);
                n12 = sparseIntArray.valueAt(i10);
                parcel.writeInt(n12);
            }
            SafeParcelWriter.handleDataOver(parcel, n10);
        } else if (n11) {
            SafeParcelWriter.setHeader(parcel, n10, 0);
        }
    }

    public static void writeSparseLongArray(Parcel parcel, int n10, SparseLongArray sparseLongArray, boolean n11) {
        int n12 = Build.VERSION.SDK_INT;
        if (sparseLongArray != null) {
            n10 = SafeParcelWriter.getStartPosition(parcel, n10);
            n11 = 18;
            int n13 = n12 >= n11 ? sparseLongArray.size() : 0;
            parcel.writeInt(n13);
            for (int i10 = 0; i10 < n13; ++i10) {
                if (n12 >= n11) {
                    int n14 = sparseLongArray.keyAt(i10);
                    parcel.writeInt(n14);
                }
                if (n12 < n11) continue;
                long l10 = sparseLongArray.valueAt(i10);
                parcel.writeLong(l10);
            }
            SafeParcelWriter.handleDataOver(parcel, n10);
        } else if (n11 != 0) {
            SafeParcelWriter.setHeader(parcel, n10, 0);
        }
    }

    public static void writeString(Parcel parcel, int n10, String string2, boolean bl2) {
        if (string2 != null) {
            n10 = SafeParcelWriter.getStartPosition(parcel, n10);
            parcel.writeString(string2);
            SafeParcelWriter.handleDataOver(parcel, n10);
        } else if (bl2) {
            string2 = null;
            SafeParcelWriter.setHeader(parcel, n10, 0);
        }
    }

    public static void writeStringArray(Parcel parcel, int n10, String[] stringArray, boolean bl2) {
        if (stringArray != null) {
            n10 = SafeParcelWriter.getStartPosition(parcel, n10);
            parcel.writeStringArray(stringArray);
            SafeParcelWriter.handleDataOver(parcel, n10);
        } else if (bl2) {
            stringArray = null;
            SafeParcelWriter.setHeader(parcel, n10, 0);
        }
    }

    public static void writeStringList(Parcel parcel, int n10, List list, boolean bl2) {
        if (list != null) {
            n10 = SafeParcelWriter.getStartPosition(parcel, n10);
            parcel.writeStringList(list);
            SafeParcelWriter.handleDataOver(parcel, n10);
        } else if (bl2) {
            list = null;
            SafeParcelWriter.setHeader(parcel, n10, 0);
        }
    }

    public static void writeStringSparseArray(Parcel parcel, int n10, SparseArray sparseArray, boolean n11) {
        if (sparseArray != null) {
            n10 = SafeParcelWriter.getStartPosition(parcel, n10);
            n11 = sparseArray.size();
            parcel.writeInt(n11);
            for (int i10 = 0; i10 < n11; ++i10) {
                int n12 = sparseArray.keyAt(i10);
                parcel.writeInt(n12);
                String string2 = (String)sparseArray.valueAt(i10);
                parcel.writeString(string2);
            }
            SafeParcelWriter.handleDataOver(parcel, n10);
        } else if (n11) {
            SafeParcelWriter.setHeader(parcel, n10, 0);
        }
    }

    public static void writeTypedArray(Parcel parcel, int n10, Parcelable[] parcelableArray, int n11, boolean n12) {
        if (parcelableArray != null) {
            n10 = SafeParcelWriter.getStartPosition(parcel, n10);
            parcel.writeInt(n10);
            n12 = parcelableArray.length;
            for (int i10 = 0; i10 < n12; ++i10) {
                Parcelable parcelable = parcelableArray[i10];
                if (parcelable != null) {
                    parcelable = parcelableArray[i10];
                    SafeParcelWriter.setSizeOfData(parcel, parcelable, n11);
                    continue;
                }
                parcel.writeInt(0);
            }
            SafeParcelWriter.handleDataOver(parcel, n10);
        } else if (n12) {
            SafeParcelWriter.setHeader(parcel, n10, 0);
        }
    }

    public static void writeTypedList(Parcel parcel, int n10, List list, boolean n11) {
        if (list != null) {
            n10 = SafeParcelWriter.getStartPosition(parcel, n10);
            n11 = list.size();
            parcel.writeInt(n11);
            for (int i10 = 0; i10 < n11; ++i10) {
                Parcelable parcelable = (Parcelable)list.get(i10);
                if (parcelable != null) {
                    SafeParcelWriter.setSizeOfData(parcel, parcelable, 0);
                    continue;
                }
                parcel.writeInt(0);
            }
            SafeParcelWriter.handleDataOver(parcel, n10);
        } else if (n11) {
            SafeParcelWriter.setHeader(parcel, n10, 0);
        }
    }

    public static void writeTypedSparseArray(Parcel parcel, int n10, SparseArray sparseArray, boolean n11) {
        if (sparseArray != null) {
            n10 = SafeParcelWriter.getStartPosition(parcel, n10);
            n11 = sparseArray.size();
            parcel.writeInt(n11);
            for (int i10 = 0; i10 < n11; ++i10) {
                int n12 = sparseArray.keyAt(i10);
                parcel.writeInt(n12);
                Parcelable parcelable = (Parcelable)sparseArray.valueAt(i10);
                if (parcelable != null) {
                    SafeParcelWriter.setSizeOfData(parcel, parcelable, 0);
                    continue;
                }
                parcel.writeInt(0);
            }
            SafeParcelWriter.handleDataOver(parcel, n10);
        } else if (n11) {
            SafeParcelWriter.setHeader(parcel, n10, 0);
        }
    }
}

