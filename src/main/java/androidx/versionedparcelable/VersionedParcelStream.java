/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Parcelable
 */
package androidx.versionedparcelable;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcelable;
import androidx.collection.ArrayMap;
import androidx.versionedparcelable.VersionedParcel;
import androidx.versionedparcelable.VersionedParcel$ParcelException;
import androidx.versionedparcelable.VersionedParcelStream$1;
import androidx.versionedparcelable.VersionedParcelStream$FieldBuffer;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;

public class VersionedParcelStream
extends VersionedParcel {
    private static final int TYPE_BOOLEAN = 5;
    private static final int TYPE_BOOLEAN_ARRAY = 6;
    private static final int TYPE_DOUBLE = 7;
    private static final int TYPE_DOUBLE_ARRAY = 8;
    private static final int TYPE_FLOAT = 13;
    private static final int TYPE_FLOAT_ARRAY = 14;
    private static final int TYPE_INT = 9;
    private static final int TYPE_INT_ARRAY = 10;
    private static final int TYPE_LONG = 11;
    private static final int TYPE_LONG_ARRAY = 12;
    private static final int TYPE_NULL = 0;
    private static final int TYPE_STRING = 3;
    private static final int TYPE_STRING_ARRAY = 4;
    private static final int TYPE_SUB_BUNDLE = 1;
    private static final int TYPE_SUB_PERSISTABLE_BUNDLE = 2;
    private static final Charset UTF_16 = Charset.forName("UTF-16");
    public int mCount;
    private DataInputStream mCurrentInput;
    private DataOutputStream mCurrentOutput;
    private VersionedParcelStream$FieldBuffer mFieldBuffer;
    private int mFieldId;
    public int mFieldSize;
    private boolean mIgnoreParcelables;
    private final DataInputStream mMasterInput;
    private final DataOutputStream mMasterOutput;

    public VersionedParcelStream(InputStream inputStream, OutputStream outputStream) {
        ArrayMap arrayMap = new ArrayMap();
        ArrayMap arrayMap2 = new ArrayMap();
        ArrayMap arrayMap3 = new ArrayMap();
        this(inputStream, outputStream, arrayMap, arrayMap2, arrayMap3);
    }

    private VersionedParcelStream(InputStream inputStream, OutputStream outputStream, ArrayMap object, ArrayMap object2, ArrayMap object3) {
        super((ArrayMap)object, (ArrayMap)object2, (ArrayMap)object3);
        int n10;
        this.mCount = 0;
        this.mFieldId = n10 = -1;
        this.mFieldSize = n10;
        n10 = 0;
        object = null;
        if (inputStream != null) {
            object3 = new VersionedParcelStream$1(this, inputStream);
            object2 = new DataInputStream((InputStream)object3);
        } else {
            object2 = null;
        }
        this.mMasterInput = object2;
        if (outputStream != null) {
            object = new DataOutputStream(outputStream);
        }
        this.mMasterOutput = object;
        this.mCurrentInput = object2;
        this.mCurrentOutput = object;
    }

    private void readObject(int n10, String object, Bundle object2) {
        switch (n10) {
            default: {
                object2 = new StringBuilder();
                ((StringBuilder)object2).append("Unknown type ");
                ((StringBuilder)object2).append(n10);
                String string2 = ((StringBuilder)object2).toString();
                object = new RuntimeException(string2);
                throw object;
            }
            case 14: {
                float[] fArray = this.readFloatArray();
                object2.putFloatArray((String)object, fArray);
                break;
            }
            case 13: {
                float f10 = this.readFloat();
                object2.putFloat((String)object, f10);
                break;
            }
            case 12: {
                long[] lArray = this.readLongArray();
                object2.putLongArray((String)object, lArray);
                break;
            }
            case 11: {
                long l10 = this.readLong();
                object2.putLong((String)object, l10);
                break;
            }
            case 10: {
                int[] nArray = this.readIntArray();
                object2.putIntArray((String)object, nArray);
                break;
            }
            case 9: {
                n10 = this.readInt();
                object2.putInt((String)object, n10);
                break;
            }
            case 8: {
                double[] dArray = this.readDoubleArray();
                object2.putDoubleArray((String)object, dArray);
                break;
            }
            case 7: {
                double d10 = this.readDouble();
                object2.putDouble((String)object, d10);
                break;
            }
            case 6: {
                boolean[] blArray = this.readBooleanArray();
                object2.putBooleanArray((String)object, blArray);
                break;
            }
            case 5: {
                n10 = (int)(this.readBoolean() ? 1 : 0);
                object2.putBoolean((String)object, n10 != 0);
                break;
            }
            case 4: {
                n10 = 0;
                float f11 = 0.0f;
                Object[] objectArray = new String[]{};
                objectArray = (String[])this.readArray(objectArray);
                object2.putStringArray((String)object, (String[])objectArray);
                break;
            }
            case 3: {
                String string3 = this.readString();
                object2.putString((String)object, string3);
                break;
            }
            case 2: {
                Bundle bundle = this.readBundle();
                object2.putBundle((String)object, bundle);
                break;
            }
            case 1: {
                Bundle bundle = this.readBundle();
                object2.putBundle((String)object, bundle);
                break;
            }
            case 0: {
                n10 = 0;
                float f12 = 0.0f;
                Object var4_14 = null;
                object2.putParcelable((String)object, null);
            }
        }
    }

    private void writeObject(Object object) {
        block16: {
            block3: {
                int n10;
                block15: {
                    block14: {
                        block13: {
                            block12: {
                                block11: {
                                    block10: {
                                        block9: {
                                            block8: {
                                                block7: {
                                                    block6: {
                                                        block5: {
                                                            block4: {
                                                                block2: {
                                                                    if (object != null) break block2;
                                                                    boolean bl2 = false;
                                                                    float f10 = 0.0f;
                                                                    object = null;
                                                                    this.writeInt(0);
                                                                    break block3;
                                                                }
                                                                n10 = object instanceof Bundle;
                                                                if (n10 == 0) break block4;
                                                                n10 = 1;
                                                                this.writeInt(n10);
                                                                object = (Bundle)object;
                                                                this.writeBundle((Bundle)object);
                                                                break block3;
                                                            }
                                                            n10 = object instanceof String;
                                                            if (n10 == 0) break block5;
                                                            n10 = 3;
                                                            this.writeInt(n10);
                                                            object = (String)object;
                                                            this.writeString((String)object);
                                                            break block3;
                                                        }
                                                        n10 = object instanceof String[];
                                                        if (n10 == 0) break block6;
                                                        n10 = 4;
                                                        this.writeInt(n10);
                                                        object = (String[])object;
                                                        this.writeArray((Object[])object);
                                                        break block3;
                                                    }
                                                    n10 = object instanceof Boolean;
                                                    if (n10 == 0) break block7;
                                                    n10 = 5;
                                                    this.writeInt(n10);
                                                    object = (Boolean)object;
                                                    boolean bl3 = (Boolean)object;
                                                    this.writeBoolean(bl3);
                                                    break block3;
                                                }
                                                n10 = object instanceof boolean[];
                                                if (n10 == 0) break block8;
                                                n10 = 6;
                                                this.writeInt(n10);
                                                object = (boolean[])object;
                                                this.writeBooleanArray((boolean[])object);
                                                break block3;
                                            }
                                            n10 = object instanceof Double;
                                            if (n10 == 0) break block9;
                                            n10 = 7;
                                            this.writeInt(n10);
                                            object = (Double)object;
                                            double d10 = (Double)object;
                                            this.writeDouble(d10);
                                            break block3;
                                        }
                                        n10 = object instanceof double[];
                                        if (n10 == 0) break block10;
                                        n10 = 8;
                                        this.writeInt(n10);
                                        object = (double[])object;
                                        this.writeDoubleArray((double[])object);
                                        break block3;
                                    }
                                    n10 = object instanceof Integer;
                                    if (n10 == 0) break block11;
                                    n10 = 9;
                                    this.writeInt(n10);
                                    object = (Integer)object;
                                    int n11 = (Integer)object;
                                    this.writeInt(n11);
                                    break block3;
                                }
                                n10 = object instanceof int[];
                                if (n10 == 0) break block12;
                                n10 = 10;
                                this.writeInt(n10);
                                object = (int[])object;
                                this.writeIntArray((int[])object);
                                break block3;
                            }
                            n10 = object instanceof Long;
                            if (n10 == 0) break block13;
                            n10 = 11;
                            this.writeInt(n10);
                            object = (Long)object;
                            long l10 = (Long)object;
                            this.writeLong(l10);
                            break block3;
                        }
                        n10 = object instanceof long[];
                        if (n10 == 0) break block14;
                        n10 = 12;
                        this.writeInt(n10);
                        object = (long[])object;
                        this.writeLongArray((long[])object);
                        break block3;
                    }
                    n10 = object instanceof Float;
                    if (n10 == 0) break block15;
                    n10 = 13;
                    this.writeInt(n10);
                    object = (Float)object;
                    float f11 = ((Float)object).floatValue();
                    this.writeFloat(f11);
                    break block3;
                }
                n10 = object instanceof float[];
                if (n10 == 0) break block16;
                n10 = 14;
                this.writeInt(n10);
                object = (float[])object;
                this.writeFloatArray((float[])object);
            }
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unsupported type ");
        object = object.getClass();
        stringBuilder.append(object);
        object = stringBuilder.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
        throw illegalArgumentException;
    }

    public void closeField() {
        Object object = this.mFieldBuffer;
        if (object != null) {
            int n10;
            block6: {
                try {
                    object = ((VersionedParcelStream$FieldBuffer)object).mOutput;
                }
                catch (IOException iOException) {
                    VersionedParcel$ParcelException versionedParcel$ParcelException = new VersionedParcel$ParcelException(iOException);
                    throw versionedParcel$ParcelException;
                }
                n10 = ((ByteArrayOutputStream)object).size();
                if (n10 == 0) break block6;
                object = this.mFieldBuffer;
                ((VersionedParcelStream$FieldBuffer)object).flushField();
            }
            n10 = 0;
            object = null;
            this.mFieldBuffer = null;
        }
    }

    public VersionedParcel createSubParcel() {
        DataInputStream dataInputStream = this.mCurrentInput;
        DataOutputStream dataOutputStream = this.mCurrentOutput;
        ArrayMap arrayMap = this.mReadCache;
        ArrayMap arrayMap2 = this.mWriteCache;
        ArrayMap arrayMap3 = this.mParcelizerCache;
        VersionedParcelStream versionedParcelStream = new VersionedParcelStream(dataInputStream, dataOutputStream, arrayMap, arrayMap2, arrayMap3);
        return versionedParcelStream;
    }

    public boolean isStream() {
        return true;
    }

    public boolean readBoolean() {
        DataInputStream dataInputStream;
        try {
            dataInputStream = this.mCurrentInput;
        }
        catch (IOException iOException) {
            VersionedParcel$ParcelException versionedParcel$ParcelException = new VersionedParcel$ParcelException(iOException);
            throw versionedParcel$ParcelException;
        }
        return dataInputStream.readBoolean();
    }

    public Bundle readBundle() {
        int n10 = this.readInt();
        if (n10 < 0) {
            return null;
        }
        Bundle bundle = new Bundle();
        for (int i10 = 0; i10 < n10; ++i10) {
            String string2 = this.readString();
            int n11 = this.readInt();
            this.readObject(n11, string2, bundle);
        }
        return bundle;
    }

    public byte[] readByteArray() {
        block6: {
            Object object;
            Object object2;
            try {
                object2 = this.mCurrentInput;
            }
            catch (IOException iOException) {
                object = new VersionedParcel$ParcelException(iOException);
                throw object;
            }
            int n10 = ((DataInputStream)object2).readInt();
            if (n10 <= 0) break block6;
            object2 = new byte[n10];
            object = this.mCurrentInput;
            ((DataInputStream)object).readFully((byte[])object2);
            return object2;
        }
        return null;
    }

    public CharSequence readCharSequence() {
        return null;
    }

    public double readDouble() {
        DataInputStream dataInputStream;
        try {
            dataInputStream = this.mCurrentInput;
        }
        catch (IOException iOException) {
            VersionedParcel$ParcelException versionedParcel$ParcelException = new VersionedParcel$ParcelException(iOException);
            throw versionedParcel$ParcelException;
        }
        return dataInputStream.readDouble();
    }

    /*
     * Unable to fully structure code
     */
    public boolean readField(int var1_1) {
        while (true) {
            var2_2 = this.mFieldId;
            if (var2_2 != var1_1) ** break block18
            return true;
            break;
        }
        catch (IOException v0) {
            return false;
        }
        {
            block20: {
                block19: {
                    var3_3 = String.valueOf(var2_2);
                    var4_4 = String.valueOf(var1_1);
                    var2_2 = var3_3.compareTo(var4_4);
                    if (var2_2 <= 0) break block19;
                    return false;
                }
                var2_2 = this.mCount;
                var5_5 = this.mFieldSize;
                if (var2_2 >= var5_5) break block20;
                var6_6 = this.mMasterInput;
                var7_7 = var5_5 -= var2_2;
                var6_6.skip(var7_7);
            }
            var2_2 = -1;
            this.mFieldSize = var2_2;
            var3_3 = this.mMasterInput;
            var2_2 = var3_3.readInt();
            this.mCount = 0;
            var5_5 = (char)-1;
            var9_8 = var2_2 & var5_5;
            if (var9_8 == var5_5) {
                var6_6 = this.mMasterInput;
                var9_8 = var6_6.readInt();
            }
            var2_2 = var2_2 >> 16 & var5_5;
            this.mFieldId = var2_2;
            this.mFieldSize = var9_8;
            continue;
        }
    }

    public float readFloat() {
        DataInputStream dataInputStream;
        try {
            dataInputStream = this.mCurrentInput;
        }
        catch (IOException iOException) {
            VersionedParcel$ParcelException versionedParcel$ParcelException = new VersionedParcel$ParcelException(iOException);
            throw versionedParcel$ParcelException;
        }
        return dataInputStream.readFloat();
    }

    public int readInt() {
        DataInputStream dataInputStream;
        try {
            dataInputStream = this.mCurrentInput;
        }
        catch (IOException iOException) {
            VersionedParcel$ParcelException versionedParcel$ParcelException = new VersionedParcel$ParcelException(iOException);
            throw versionedParcel$ParcelException;
        }
        return dataInputStream.readInt();
    }

    public long readLong() {
        DataInputStream dataInputStream;
        try {
            dataInputStream = this.mCurrentInput;
        }
        catch (IOException iOException) {
            VersionedParcel$ParcelException versionedParcel$ParcelException = new VersionedParcel$ParcelException(iOException);
            throw versionedParcel$ParcelException;
        }
        return dataInputStream.readLong();
    }

    public Parcelable readParcelable() {
        return null;
    }

    public String readString() {
        block8: {
            Object object;
            Object object2;
            try {
                object2 = this.mCurrentInput;
            }
            catch (IOException iOException) {
                object = new VersionedParcel$ParcelException(iOException);
                throw object;
            }
            int n10 = ((DataInputStream)object2).readInt();
            if (n10 <= 0) break block8;
            object2 = new byte[n10];
            object = this.mCurrentInput;
            ((DataInputStream)object).readFully((byte[])object2);
            Charset charset = UTF_16;
            object = new String((byte[])object2, charset);
            return object;
        }
        return null;
    }

    public IBinder readStrongBinder() {
        return null;
    }

    public void setOutputField(int n10) {
        DataOutputStream dataOutputStream;
        VersionedParcelStream$FieldBuffer versionedParcelStream$FieldBuffer;
        this.closeField();
        DataOutputStream dataOutputStream2 = this.mMasterOutput;
        this.mFieldBuffer = versionedParcelStream$FieldBuffer = new VersionedParcelStream$FieldBuffer(n10, dataOutputStream2);
        this.mCurrentOutput = dataOutputStream = versionedParcelStream$FieldBuffer.mDataStream;
    }

    public void setSerializationFlags(boolean bl2, boolean bl3) {
        if (bl2) {
            this.mIgnoreParcelables = bl3;
            return;
        }
        RuntimeException runtimeException = new RuntimeException("Serialization of this object is not allowed");
        throw runtimeException;
    }

    public void writeBoolean(boolean bl2) {
        Object object;
        try {
            object = this.mCurrentOutput;
        }
        catch (IOException iOException) {
            object = new VersionedParcel$ParcelException(iOException);
            throw object;
        }
        ((DataOutputStream)object).writeBoolean(bl2);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void writeBundle(Bundle var1_1) {
        if (var1_1 == null) ** GOTO lbl16
        try {
            var2_3 = var1_1.keySet();
            var3_5 = this.mCurrentOutput;
            var4_6 = var2_3.size();
            var3_5.writeInt(var4_6);
            var2_3 = var2_3.iterator();
            while (var5_7 = var2_3.hasNext()) {
                var3_5 = var2_3.next();
                var3_5 = (String)var3_5;
                this.writeString((String)var3_5);
                var3_5 = var1_1.get((String)var3_5);
                this.writeObject(var3_5);
            }
            return;
lbl16:
            // 1 sources

            var1_1 = this.mCurrentOutput;
            var6_8 = -1;
            var1_1.writeInt(var6_8);
            return;
        }
        catch (IOException var1_2) {
            var2_4 = new VersionedParcel$ParcelException(var1_2);
            throw var2_4;
        }
    }

    /*
     * Unable to fully structure code
     */
    public void writeByteArray(byte[] var1_1) {
        if (var1_1 == null) ** GOTO lbl15
        try {
            var2_3 = this.mCurrentOutput;
        }
        catch (IOException var1_2) {
            var2_3 = new VersionedParcel$ParcelException(var1_2);
            throw var2_3;
        }
        var3_4 = ((byte[])var1_1).length;
        var2_3.writeInt(var3_4);
        var2_3 = this.mCurrentOutput;
        var2_3.write((byte[])var1_1);
        ** GOTO lbl19
lbl15:
        // 1 sources

        var1_1 = this.mCurrentOutput;
        var4_5 = -1;
        var1_1.writeInt(var4_5);
lbl19:
        // 2 sources

    }

    /*
     * Unable to fully structure code
     */
    public void writeByteArray(byte[] var1_1, int var2_3, int var3_4) {
        if (var1_1 == null) ** GOTO lbl13
        try {
            var4_5 = this.mCurrentOutput;
        }
        catch (IOException var1_2) {
            var5_6 = new VersionedParcel$ParcelException(var1_2);
            throw var5_6;
        }
        var4_5.writeInt(var3_4);
        var4_5 = this.mCurrentOutput;
        var4_5.write((byte[])var1_1, var2_3, var3_4);
        ** GOTO lbl17
lbl13:
        // 1 sources

        var1_1 = this.mCurrentOutput;
        var2_3 = -1;
        var1_1.writeInt(var2_3);
lbl17:
        // 2 sources

    }

    public void writeCharSequence(CharSequence object) {
        boolean bl2 = this.mIgnoreParcelables;
        if (bl2) {
            return;
        }
        object = new RuntimeException("CharSequence cannot be written to an OutputStream");
        throw object;
    }

    public void writeDouble(double d10) {
        DataOutputStream dataOutputStream;
        try {
            dataOutputStream = this.mCurrentOutput;
        }
        catch (IOException iOException) {
            VersionedParcel$ParcelException versionedParcel$ParcelException = new VersionedParcel$ParcelException(iOException);
            throw versionedParcel$ParcelException;
        }
        dataOutputStream.writeDouble(d10);
    }

    public void writeFloat(float f10) {
        Object object;
        try {
            object = this.mCurrentOutput;
        }
        catch (IOException iOException) {
            object = new VersionedParcel$ParcelException(iOException);
            throw object;
        }
        ((DataOutputStream)object).writeFloat(f10);
    }

    public void writeInt(int n10) {
        Object object;
        try {
            object = this.mCurrentOutput;
        }
        catch (IOException iOException) {
            object = new VersionedParcel$ParcelException(iOException);
            throw object;
        }
        ((DataOutputStream)object).writeInt(n10);
    }

    public void writeLong(long l10) {
        DataOutputStream dataOutputStream;
        try {
            dataOutputStream = this.mCurrentOutput;
        }
        catch (IOException iOException) {
            VersionedParcel$ParcelException versionedParcel$ParcelException = new VersionedParcel$ParcelException(iOException);
            throw versionedParcel$ParcelException;
        }
        dataOutputStream.writeLong(l10);
    }

    public void writeParcelable(Parcelable object) {
        boolean bl2 = this.mIgnoreParcelables;
        if (bl2) {
            return;
        }
        object = new RuntimeException("Parcelables cannot be written to an OutputStream");
        throw object;
    }

    /*
     * Unable to fully structure code
     */
    public void writeString(String var1_1) {
        if (var1_1 == null) ** GOTO lbl19
        try {
            var2_3 = VersionedParcelStream.UTF_16;
        }
        catch (IOException var1_2) {
            var2_3 = new VersionedParcel$ParcelException(var1_2);
            throw var2_3;
        }
        var1_1 = var1_1.getBytes((Charset)var2_3);
        var2_3 = this.mCurrentOutput;
        var3_4 = ((Object)var1_1).length;
        var2_3.writeInt(var3_4);
        var2_3 = this.mCurrentOutput;
        var2_3.write((byte[])var1_1);
        ** GOTO lbl23
lbl19:
        // 1 sources

        var1_1 = this.mCurrentOutput;
        var4_5 = -1;
        var1_1.writeInt(var4_5);
lbl23:
        // 2 sources

    }

    public void writeStrongBinder(IBinder object) {
        boolean bl2 = this.mIgnoreParcelables;
        if (bl2) {
            return;
        }
        object = new RuntimeException("Binders cannot be written to an OutputStream");
        throw object;
    }

    public void writeStrongInterface(IInterface object) {
        boolean bl2 = this.mIgnoreParcelables;
        if (bl2) {
            return;
        }
        object = new RuntimeException("Binders cannot be written to an OutputStream");
        throw object;
    }
}

