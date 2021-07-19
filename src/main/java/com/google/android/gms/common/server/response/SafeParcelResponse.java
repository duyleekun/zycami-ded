/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  android.util.SparseArray
 */
package com.google.android.gms.common.server.response;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader$ParseException;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.common.server.response.FastJsonResponse$Field;
import com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse;
import com.google.android.gms.common.server.response.zak;
import com.google.android.gms.common.server.response.zap;
import com.google.android.gms.common.util.ArrayUtils;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.common.util.JsonUtils;
import com.google.android.gms.common.util.MapUtils;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class SafeParcelResponse
extends FastSafeParcelableJsonResponse {
    public static final Parcelable.Creator CREATOR;
    private final String mClassName;
    private final int zalf;
    private final zak zapz;
    private final Parcel zarb;
    private final int zarc;
    private int zard;
    private int zare;

    static {
        zap zap2 = new zap();
        CREATOR = zap2;
    }

    public SafeParcelResponse(int n10, Parcel object, zak zak2) {
        Parcel parcel;
        this.zalf = n10;
        this.zarb = parcel = (Parcel)Preconditions.checkNotNull(object);
        this.zarc = n10 = 2;
        this.zapz = zak2;
        if (zak2 == null) {
            object = null;
            this.mClassName = null;
        } else {
            object = zak2.zact();
            this.mClassName = object;
        }
        this.zard = n10;
    }

    private SafeParcelResponse(SafeParcelable object, zak zak2, String string2) {
        Parcel parcel;
        int n10;
        this.zalf = n10 = 1;
        this.zarb = parcel = Parcel.obtain();
        object.writeToParcel(parcel, 0);
        this.zarc = n10;
        object = (zak)Preconditions.checkNotNull(zak2);
        this.zapz = object;
        this.mClassName = object = (String)Preconditions.checkNotNull(string2);
        this.zard = 2;
    }

    public SafeParcelResponse(zak object, String string2) {
        Parcel parcel;
        this.zalf = 1;
        this.zarb = parcel = Parcel.obtain();
        this.zarc = 0;
        object = (zak)Preconditions.checkNotNull(object);
        this.zapz = object;
        this.mClassName = object = (String)Preconditions.checkNotNull(string2);
        this.zard = 0;
    }

    public static SafeParcelResponse from(FastJsonResponse object) {
        String string2 = object.getClass().getCanonicalName();
        Object object2 = object.getClass();
        zak zak2 = new zak((Class)object2);
        SafeParcelResponse.zaa(zak2, (FastJsonResponse)object);
        zak2.zacs();
        zak2.zacr();
        object = (SafeParcelable)object;
        object2 = new SafeParcelResponse((SafeParcelable)object, zak2, string2);
        return object2;
    }

    private static void zaa(zak zak2, FastJsonResponse object) {
        Class<?> clazz = object.getClass();
        boolean bl2 = zak2.zaa(clazz);
        if (!bl2) {
            object = ((FastJsonResponse)object).getFieldMappings();
            zak2.zaa(clazz, (Map)object);
            clazz = object.keySet().iterator();
            while (bl2 = clazz.hasNext()) {
                Object object2 = (String)clazz.next();
                object2 = (FastJsonResponse$Field)object.get(object2);
                Object object3 = ((FastJsonResponse$Field)object2).zapx;
                if (object3 == null) continue;
                object3 = ((Class)object3).newInstance();
                object3 = (FastJsonResponse)object3;
                try {
                    SafeParcelResponse.zaa(zak2, (FastJsonResponse)object3);
                }
                catch (IllegalAccessException illegalAccessException) {
                    clazz = "Could not access object of type ";
                    object2 = String.valueOf(((FastJsonResponse$Field)object2).zapx.getCanonicalName());
                    int n10 = ((String)object2).length();
                    clazz = n10 != 0 ? ((String)((Object)clazz)).concat((String)object2) : (object2 = new String((String)((Object)clazz)));
                    object = new IllegalStateException((String)((Object)clazz), illegalAccessException);
                    throw object;
                }
                catch (InstantiationException instantiationException) {
                    clazz = "Could not instantiate an object of type ";
                    object2 = String.valueOf(((FastJsonResponse$Field)object2).zapx.getCanonicalName());
                    int n11 = ((String)object2).length();
                    clazz = n11 != 0 ? ((String)((Object)clazz)).concat((String)object2) : (object2 = new String((String)((Object)clazz)));
                    object = new IllegalStateException((String)((Object)clazz), instantiationException);
                    throw object;
                }
            }
        }
    }

    private static void zaa(StringBuilder serializable, int n10, Object object) {
        CharSequence charSequence = "\"";
        switch (n10) {
            default: {
                charSequence = new StringBuilder(26);
                ((StringBuilder)charSequence).append("Unknown type = ");
                ((StringBuilder)charSequence).append(n10);
                String string2 = ((StringBuilder)charSequence).toString();
                serializable = new IllegalArgumentException(string2);
                throw serializable;
            }
            case 11: {
                serializable = new IllegalArgumentException("Method does not accept concrete type.");
                throw serializable;
            }
            case 10: {
                object = (HashMap)object;
                MapUtils.writeStringMapToJson((StringBuilder)serializable, (HashMap)object);
                return;
            }
            case 9: {
                ((StringBuilder)serializable).append((String)charSequence);
                String string3 = Base64Utils.encodeUrlSafe((byte[])object);
                ((StringBuilder)serializable).append(string3);
                ((StringBuilder)serializable).append((String)charSequence);
                return;
            }
            case 8: {
                ((StringBuilder)serializable).append((String)charSequence);
                String string4 = Base64Utils.encode((byte[])object);
                ((StringBuilder)serializable).append(string4);
                ((StringBuilder)serializable).append((String)charSequence);
                return;
            }
            case 7: {
                ((StringBuilder)serializable).append((String)charSequence);
                String string5 = JsonUtils.escapeString(object.toString());
                ((StringBuilder)serializable).append(string5);
                ((StringBuilder)serializable).append((String)charSequence);
                return;
            }
            case 0: 
            case 1: 
            case 2: 
            case 3: 
            case 4: 
            case 5: 
            case 6: 
        }
        ((StringBuilder)serializable).append(object);
    }

    private final void zaa(StringBuilder serializable, Map object, Parcel parcel) {
        int n10;
        int n11;
        FastJsonResponse$Field fastJsonResponse$Field;
        Object object2;
        boolean bl2;
        Object object3 = new SparseArray();
        object = object.entrySet().iterator();
        while (bl2 = object.hasNext()) {
            object2 = object.next();
            fastJsonResponse$Field = (FastJsonResponse$Field)object2.getValue();
            n11 = fastJsonResponse$Field.getSafeParcelableFieldId();
            object3.put(n11, object2);
        }
        ((StringBuilder)serializable).append('{');
        int n12 = SafeParcelReader.validateObjectHeader(parcel);
        bl2 = true;
        float f10 = Float.MIN_VALUE;
        n11 = 0;
        fastJsonResponse$Field = null;
        boolean n13 = false;
        Object object4 = null;
        float f11 = 0.0f;
        while ((n10 = parcel.dataPosition()) < n12) {
            long l10;
            double d10;
            Object object5;
            int n14;
            Iterator iterator2;
            int n15;
            n10 = SafeParcelReader.readHeader(parcel);
            int n16 = SafeParcelReader.getFieldId(n10);
            Object object6 = (Map.Entry)object3.get(n16);
            if (object6 == null) continue;
            Object object7 = ",";
            if (n15 != 0) {
                ((StringBuilder)serializable).append((String)object7);
            }
            object4 = (String)object6.getKey();
            object6 = (FastJsonResponse$Field)object6.getValue();
            String string2 = "\"";
            ((StringBuilder)serializable).append(string2);
            ((StringBuilder)serializable).append((String)object4);
            object4 = "\":";
            ((StringBuilder)serializable).append((String)object4);
            n15 = ((FastJsonResponse$Field)object6).zacn();
            if (n15 != 0) {
                n15 = ((FastJsonResponse$Field)object6).zapt;
                switch (n15) {
                    default: {
                        n12 = ((FastJsonResponse$Field)object6).zapt;
                        object3 = new StringBuilder(36);
                        ((StringBuilder)object3).append("Unknown field out type = ");
                        ((StringBuilder)object3).append(n12);
                        object = ((StringBuilder)object3).toString();
                        serializable = new IllegalArgumentException((String)object);
                        throw serializable;
                    }
                    case 11: {
                        serializable = new IllegalArgumentException("Method does not accept concrete type.");
                        throw serializable;
                    }
                    case 10: {
                        object4 = SafeParcelReader.createBundle(parcel, n10);
                        iterator2 = new Iterator();
                        object7 = object4.keySet().iterator();
                        while ((n14 = object7.hasNext()) != 0) {
                            string2 = (String)object7.next();
                            object5 = object4.getString(string2);
                            ((HashMap)((Object)iterator2)).put(string2, object5);
                        }
                        object4 = FastJsonResponse.zab((FastJsonResponse$Field)object6, iterator2);
                        this.zab((StringBuilder)serializable, (FastJsonResponse$Field)object6, object4);
                        break;
                    }
                    case 8: 
                    case 9: {
                        object4 = SafeParcelReader.createByteArray(parcel, n10);
                        object4 = FastJsonResponse.zab((FastJsonResponse$Field)object6, object4);
                        this.zab((StringBuilder)serializable, (FastJsonResponse$Field)object6, object4);
                        break;
                    }
                    case 7: {
                        object4 = SafeParcelReader.createString(parcel, n10);
                        object4 = FastJsonResponse.zab((FastJsonResponse$Field)object6, object4);
                        this.zab((StringBuilder)serializable, (FastJsonResponse$Field)object6, object4);
                        break;
                    }
                    case 6: {
                        n15 = (int)(SafeParcelReader.readBoolean(parcel, n10) ? 1 : 0);
                        object4 = n15 != 0;
                        object4 = FastJsonResponse.zab((FastJsonResponse$Field)object6, object4);
                        this.zab((StringBuilder)serializable, (FastJsonResponse$Field)object6, object4);
                        break;
                    }
                    case 5: {
                        object4 = SafeParcelReader.createBigDecimal(parcel, n10);
                        object4 = FastJsonResponse.zab((FastJsonResponse$Field)object6, object4);
                        this.zab((StringBuilder)serializable, (FastJsonResponse$Field)object6, object4);
                        break;
                    }
                    case 4: {
                        d10 = SafeParcelReader.readDouble(parcel, n10);
                        object4 = d10;
                        object4 = FastJsonResponse.zab((FastJsonResponse$Field)object6, object4);
                        this.zab((StringBuilder)serializable, (FastJsonResponse$Field)object6, object4);
                        break;
                    }
                    case 3: {
                        f11 = SafeParcelReader.readFloat(parcel, n10);
                        object4 = Float.valueOf(f11);
                        object4 = FastJsonResponse.zab((FastJsonResponse$Field)object6, object4);
                        this.zab((StringBuilder)serializable, (FastJsonResponse$Field)object6, object4);
                        break;
                    }
                    case 2: {
                        l10 = SafeParcelReader.readLong(parcel, n10);
                        object4 = l10;
                        object4 = FastJsonResponse.zab((FastJsonResponse$Field)object6, object4);
                        this.zab((StringBuilder)serializable, (FastJsonResponse$Field)object6, object4);
                        break;
                    }
                    case 1: {
                        object4 = SafeParcelReader.createBigInteger(parcel, n10);
                        object4 = FastJsonResponse.zab((FastJsonResponse$Field)object6, object4);
                        this.zab((StringBuilder)serializable, (FastJsonResponse$Field)object6, object4);
                        break;
                    }
                    case 0: {
                        n15 = SafeParcelReader.readInt(parcel, n10);
                        object4 = n15;
                        object4 = FastJsonResponse.zab((FastJsonResponse$Field)object6, object4);
                        this.zab((StringBuilder)serializable, (FastJsonResponse$Field)object6, object4);
                        break;
                    }
                }
            } else {
                n15 = (int)(((FastJsonResponse$Field)object6).zapu ? 1 : 0);
                if (n15 != 0) {
                    object4 = "[";
                    ((StringBuilder)serializable).append((String)object4);
                    n15 = ((FastJsonResponse$Field)object6).zapt;
                    switch (n15) {
                        default: {
                            serializable = new IllegalStateException("Unknown field type out.");
                            throw serializable;
                        }
                        case 11: {
                            object4 = SafeParcelReader.createParcelArray(parcel, n10);
                            n10 = ((Parcel[])object4).length;
                            string2 = null;
                            for (n14 = 0; n14 < n10; ++n14) {
                                if (n14 > 0) {
                                    ((StringBuilder)serializable).append((String)object7);
                                }
                                object4[n14].setDataPosition(0);
                                object5 = ((FastJsonResponse$Field)object6).zacq();
                                Parcel parcel2 = object4[n14];
                                this.zaa((StringBuilder)serializable, (Map)object5, parcel2);
                            }
                            break;
                        }
                        case 8: 
                        case 9: 
                        case 10: {
                            serializable = new UnsupportedOperationException("List of type BASE64, BASE64_URL_SAFE, or STRING_MAP is not supported");
                            throw serializable;
                        }
                        case 7: {
                            object4 = SafeParcelReader.createStringArray(parcel, n10);
                            ArrayUtils.writeStringArray((StringBuilder)serializable, (String[])object4);
                            break;
                        }
                        case 6: {
                            object4 = SafeParcelReader.createBooleanArray(parcel, n10);
                            ArrayUtils.writeArray((StringBuilder)serializable, (boolean[])object4);
                            break;
                        }
                        case 5: {
                            object4 = SafeParcelReader.createBigDecimalArray(parcel, n10);
                            ArrayUtils.writeArray((StringBuilder)serializable, object4);
                            break;
                        }
                        case 4: {
                            object4 = SafeParcelReader.createDoubleArray(parcel, n10);
                            ArrayUtils.writeArray((StringBuilder)serializable, (double[])object4);
                            break;
                        }
                        case 3: {
                            object4 = SafeParcelReader.createFloatArray(parcel, n10);
                            ArrayUtils.writeArray((StringBuilder)serializable, (float[])object4);
                            break;
                        }
                        case 2: {
                            object4 = SafeParcelReader.createLongArray(parcel, n10);
                            ArrayUtils.writeArray((StringBuilder)serializable, (long[])object4);
                            break;
                        }
                        case 1: {
                            object4 = SafeParcelReader.createBigIntegerArray(parcel, n10);
                            ArrayUtils.writeArray((StringBuilder)serializable, object4);
                            break;
                        }
                        case 0: {
                            object4 = SafeParcelReader.createIntArray(parcel, n10);
                            ArrayUtils.writeArray((StringBuilder)serializable, (int[])object4);
                        }
                    }
                    object4 = "]";
                    ((StringBuilder)serializable).append((String)object4);
                } else {
                    n15 = ((FastJsonResponse$Field)object6).zapt;
                    switch (n15) {
                        default: {
                            serializable = new IllegalStateException("Unknown field type out");
                            throw serializable;
                        }
                        case 11: {
                            object4 = SafeParcelReader.createParcel(parcel, n10);
                            object4.setDataPosition(0);
                            iterator2 = ((FastJsonResponse$Field)object6).zacq();
                            this.zaa((StringBuilder)serializable, (Map)((Object)iterator2), (Parcel)object4);
                            break;
                        }
                        case 10: {
                            boolean bl3;
                            object4 = SafeParcelReader.createBundle(parcel, n10);
                            iterator2 = object4.keySet();
                            iterator2.size();
                            object6 = "{";
                            ((StringBuilder)serializable).append((String)object6);
                            iterator2 = iterator2.iterator();
                            n16 = (int)(bl2 ? 1 : 0);
                            while (bl3 = iterator2.hasNext()) {
                                object5 = (String)iterator2.next();
                                if (n16 == 0) {
                                    ((StringBuilder)serializable).append((String)object7);
                                }
                                ((StringBuilder)serializable).append(string2);
                                ((StringBuilder)serializable).append((String)object5);
                                ((StringBuilder)serializable).append(string2);
                                ((StringBuilder)serializable).append(":");
                                ((StringBuilder)serializable).append(string2);
                                object6 = JsonUtils.escapeString(object4.getString((String)object5));
                                ((StringBuilder)serializable).append((String)object6);
                                ((StringBuilder)serializable).append(string2);
                                n16 = 0;
                                object6 = null;
                            }
                            object4 = "}";
                            ((StringBuilder)serializable).append((String)object4);
                            break;
                        }
                        case 9: {
                            object4 = SafeParcelReader.createByteArray(parcel, n10);
                            ((StringBuilder)serializable).append(string2);
                            object4 = Base64Utils.encodeUrlSafe((byte[])object4);
                            ((StringBuilder)serializable).append((String)object4);
                            ((StringBuilder)serializable).append(string2);
                            break;
                        }
                        case 8: {
                            object4 = SafeParcelReader.createByteArray(parcel, n10);
                            ((StringBuilder)serializable).append(string2);
                            object4 = Base64Utils.encode((byte[])object4);
                            ((StringBuilder)serializable).append((String)object4);
                            ((StringBuilder)serializable).append(string2);
                            break;
                        }
                        case 7: {
                            object4 = SafeParcelReader.createString(parcel, n10);
                            ((StringBuilder)serializable).append(string2);
                            object4 = JsonUtils.escapeString((String)object4);
                            ((StringBuilder)serializable).append((String)object4);
                            ((StringBuilder)serializable).append(string2);
                            break;
                        }
                        case 6: {
                            n15 = (int)(SafeParcelReader.readBoolean(parcel, n10) ? 1 : 0);
                            ((StringBuilder)serializable).append(n15 != 0);
                            break;
                        }
                        case 5: {
                            object4 = SafeParcelReader.createBigDecimal(parcel, n10);
                            ((StringBuilder)serializable).append(object4);
                            break;
                        }
                        case 4: {
                            d10 = SafeParcelReader.readDouble(parcel, n10);
                            ((StringBuilder)serializable).append(d10);
                            break;
                        }
                        case 3: {
                            f11 = SafeParcelReader.readFloat(parcel, n10);
                            ((StringBuilder)serializable).append(f11);
                            break;
                        }
                        case 2: {
                            l10 = SafeParcelReader.readLong(parcel, n10);
                            ((StringBuilder)serializable).append(l10);
                            break;
                        }
                        case 1: {
                            object4 = SafeParcelReader.createBigInteger(parcel, n10);
                            ((StringBuilder)serializable).append(object4);
                            break;
                        }
                        case 0: {
                            n15 = SafeParcelReader.readInt(parcel, n10);
                            ((StringBuilder)serializable).append(n15);
                        }
                    }
                }
            }
            n15 = (int)(bl2 ? 1 : 0);
            f11 = f10;
        }
        int n17 = parcel.dataPosition();
        if (n17 == n12) {
            ((StringBuilder)serializable).append('}');
            return;
        }
        object2 = new StringBuilder(37);
        ((StringBuilder)object2).append("Overread allowed size end=");
        ((StringBuilder)object2).append(n12);
        object = ((StringBuilder)object2).toString();
        serializable = new SafeParcelReader$ParseException((String)object, parcel);
        throw serializable;
    }

    private final void zab(FastJsonResponse$Field object) {
        int n10 = ((FastJsonResponse$Field)object).zapw;
        int n11 = 1;
        int n12 = -1;
        if (n10 != n12) {
            n10 = n11;
        } else {
            n10 = 0;
            object = null;
        }
        if (n10 != 0) {
            object = this.zarb;
            if (object != null) {
                n12 = this.zard;
                if (n12 != 0) {
                    if (n12 != n11) {
                        n10 = 2;
                        if (n12 != n10) {
                            object = new IllegalStateException("Unknown parse state in SafeParcelResponse.");
                            throw object;
                        }
                        object = new IllegalStateException("Attempted to parse JSON with a SafeParcelResponse object that is already filled with data.");
                        throw object;
                    }
                    return;
                }
                this.zare = n10 = SafeParcelWriter.beginObjectHeader((Parcel)object);
                this.zard = n11;
                return;
            }
            object = new IllegalStateException("Internal Parcel object is null.");
            throw object;
        }
        object = new IllegalStateException("Field does not have a valid safe parcelable field id.");
        throw object;
    }

    private final void zab(StringBuilder stringBuilder, FastJsonResponse$Field fastJsonResponse$Field, Object object) {
        int n10 = fastJsonResponse$Field.zaps;
        if (n10 != 0) {
            object = (ArrayList)object;
            String string2 = "[";
            stringBuilder.append(string2);
            n10 = ((ArrayList)object).size();
            for (int i10 = 0; i10 < n10; ++i10) {
                if (i10 != 0) {
                    String string3 = ",";
                    stringBuilder.append(string3);
                }
                int n11 = fastJsonResponse$Field.zapr;
                Object e10 = ((ArrayList)object).get(i10);
                SafeParcelResponse.zaa(stringBuilder, n11, e10);
            }
            stringBuilder.append("]");
            return;
        }
        int n12 = fastJsonResponse$Field.zapr;
        SafeParcelResponse.zaa(stringBuilder, n12, object);
    }

    private final Parcel zacu() {
        block2: {
            Parcel parcel;
            int n10;
            int n11;
            block1: {
                block0: {
                    n11 = this.zard;
                    if (n11 == 0) break block0;
                    n10 = 1;
                    if (n11 == n10) break block1;
                    break block2;
                }
                parcel = this.zarb;
                this.zare = n11 = SafeParcelWriter.beginObjectHeader(parcel);
            }
            parcel = this.zarb;
            n10 = this.zare;
            SafeParcelWriter.finishObjectHeader(parcel, n10);
            this.zard = n11 = 2;
        }
        return this.zarb;
    }

    public void addConcreteTypeArrayInternal(FastJsonResponse$Field fastJsonResponse$Field, String arrayList, ArrayList arrayList2) {
        this.zab(fastJsonResponse$Field);
        arrayList = new ArrayList();
        arrayList2.size();
        int n10 = arrayList2.size();
        for (int i10 = 0; i10 < n10; ++i10) {
            Object object = arrayList2.get(i10);
            object = ((SafeParcelResponse)((FastJsonResponse)object)).zacu();
            arrayList.add(object);
        }
        arrayList2 = this.zarb;
        int n11 = fastJsonResponse$Field.getSafeParcelableFieldId();
        SafeParcelWriter.writeParcelList((Parcel)arrayList2, n11, arrayList, true);
    }

    public void addConcreteTypeInternal(FastJsonResponse$Field fastJsonResponse$Field, String string2, FastJsonResponse fastJsonResponse) {
        this.zab(fastJsonResponse$Field);
        string2 = ((SafeParcelResponse)fastJsonResponse).zacu();
        fastJsonResponse = this.zarb;
        int n10 = fastJsonResponse$Field.getSafeParcelableFieldId();
        SafeParcelWriter.writeParcel((Parcel)fastJsonResponse, n10, (Parcel)string2, true);
    }

    public Map getFieldMappings() {
        zak zak2 = this.zapz;
        if (zak2 == null) {
            return null;
        }
        String string2 = this.mClassName;
        return zak2.zai(string2);
    }

    public Object getValueObject(String object) {
        object = new UnsupportedOperationException("Converting to JSON does not require this method.");
        throw object;
    }

    public boolean isPrimitiveFieldSet(String object) {
        object = new UnsupportedOperationException("Converting to JSON does not require this method.");
        throw object;
    }

    public void setBooleanInternal(FastJsonResponse$Field fastJsonResponse$Field, String string2, boolean bl2) {
        this.zab(fastJsonResponse$Field);
        string2 = this.zarb;
        int n10 = fastJsonResponse$Field.getSafeParcelableFieldId();
        SafeParcelWriter.writeBoolean((Parcel)string2, n10, bl2);
    }

    public void setDecodedBytesInternal(FastJsonResponse$Field fastJsonResponse$Field, String string2, byte[] byArray) {
        this.zab(fastJsonResponse$Field);
        string2 = this.zarb;
        int n10 = fastJsonResponse$Field.getSafeParcelableFieldId();
        SafeParcelWriter.writeByteArray((Parcel)string2, n10, byArray, true);
    }

    public void setIntegerInternal(FastJsonResponse$Field fastJsonResponse$Field, String string2, int n10) {
        this.zab(fastJsonResponse$Field);
        string2 = this.zarb;
        int n11 = fastJsonResponse$Field.getSafeParcelableFieldId();
        SafeParcelWriter.writeInt((Parcel)string2, n11, n10);
    }

    public void setLongInternal(FastJsonResponse$Field fastJsonResponse$Field, String string2, long l10) {
        this.zab(fastJsonResponse$Field);
        string2 = this.zarb;
        int n10 = fastJsonResponse$Field.getSafeParcelableFieldId();
        SafeParcelWriter.writeLong((Parcel)string2, n10, l10);
    }

    public void setStringInternal(FastJsonResponse$Field fastJsonResponse$Field, String string2, String string3) {
        this.zab(fastJsonResponse$Field);
        string2 = this.zarb;
        int n10 = fastJsonResponse$Field.getSafeParcelableFieldId();
        SafeParcelWriter.writeString((Parcel)string2, n10, string3, true);
    }

    public void setStringsInternal(FastJsonResponse$Field fastJsonResponse$Field, String string2, ArrayList arrayList) {
        this.zab(fastJsonResponse$Field);
        int n10 = arrayList.size();
        String[] stringArray = new String[n10];
        for (int i10 = 0; i10 < n10; ++i10) {
            String string3;
            stringArray[i10] = string3 = (String)arrayList.get(i10);
        }
        string2 = this.zarb;
        int n11 = fastJsonResponse$Field.getSafeParcelableFieldId();
        SafeParcelWriter.writeStringArray((Parcel)string2, n11, stringArray, true);
    }

    public String toString() {
        Preconditions.checkNotNull(this.zapz, "Cannot convert to JSON on client side.");
        Parcel parcel = this.zacu();
        parcel.setDataPosition(0);
        StringBuilder stringBuilder = new StringBuilder(100);
        Object object = this.zapz;
        String string2 = this.mClassName;
        object = ((zak)object).zai(string2);
        this.zaa(stringBuilder, (Map)object, parcel);
        return stringBuilder.toString();
    }

    /*
     * Enabled aggressive block sorting
     */
    public void writeToParcel(Parcel object, int n10) {
        int n11;
        int n12 = SafeParcelWriter.beginObjectHeader(object);
        int n13 = this.zalf;
        int n14 = 1;
        SafeParcelWriter.writeInt(object, n14, n13);
        Object object2 = this.zacu();
        int n15 = 2;
        SafeParcelWriter.writeParcel(object, n15, (Parcel)object2, false);
        n13 = this.zarc;
        if (n13 != 0) {
            if (n13 != n14) {
                if (n13 != n15) {
                    n11 = this.zarc;
                    object2 = new StringBuilder(34);
                    ((StringBuilder)object2).append("Invalid creation type: ");
                    ((StringBuilder)object2).append(n11);
                    String string2 = ((StringBuilder)object2).toString();
                    IllegalStateException illegalStateException = new IllegalStateException(string2);
                    throw illegalStateException;
                }
                object2 = this.zapz;
            } else {
                object2 = this.zapz;
            }
        } else {
            n13 = 0;
            object2 = null;
        }
        SafeParcelWriter.writeParcelable(object, 3, (Parcelable)object2, n11, false);
        SafeParcelWriter.finishObjectHeader(object, n12);
    }

    public final void zaa(FastJsonResponse$Field fastJsonResponse$Field, String string2, double d10) {
        this.zab(fastJsonResponse$Field);
        string2 = this.zarb;
        int n10 = fastJsonResponse$Field.getSafeParcelableFieldId();
        SafeParcelWriter.writeDouble((Parcel)string2, n10, d10);
    }

    public final void zaa(FastJsonResponse$Field fastJsonResponse$Field, String string2, float f10) {
        this.zab(fastJsonResponse$Field);
        string2 = this.zarb;
        int n10 = fastJsonResponse$Field.getSafeParcelableFieldId();
        SafeParcelWriter.writeFloat((Parcel)string2, n10, f10);
    }

    public final void zaa(FastJsonResponse$Field fastJsonResponse$Field, String string2, BigDecimal bigDecimal) {
        this.zab(fastJsonResponse$Field);
        string2 = this.zarb;
        int n10 = fastJsonResponse$Field.getSafeParcelableFieldId();
        SafeParcelWriter.writeBigDecimal((Parcel)string2, n10, bigDecimal, true);
    }

    public final void zaa(FastJsonResponse$Field fastJsonResponse$Field, String string2, BigInteger bigInteger) {
        this.zab(fastJsonResponse$Field);
        string2 = this.zarb;
        int n10 = fastJsonResponse$Field.getSafeParcelableFieldId();
        SafeParcelWriter.writeBigInteger((Parcel)string2, n10, bigInteger, true);
    }

    public final void zaa(FastJsonResponse$Field fastJsonResponse$Field, String string2, ArrayList arrayList) {
        this.zab(fastJsonResponse$Field);
        int n10 = arrayList.size();
        int[] nArray = new int[n10];
        for (int i10 = 0; i10 < n10; ++i10) {
            int n11;
            Integer n12 = (Integer)arrayList.get(i10);
            nArray[i10] = n11 = n12.intValue();
        }
        string2 = this.zarb;
        int n13 = fastJsonResponse$Field.getSafeParcelableFieldId();
        SafeParcelWriter.writeIntArray((Parcel)string2, n13, nArray, true);
    }

    public final void zaa(FastJsonResponse$Field fastJsonResponse$Field, String string2, Map map) {
        boolean bl2;
        this.zab(fastJsonResponse$Field);
        string2 = new Bundle();
        Iterator iterator2 = map.keySet().iterator();
        while (bl2 = iterator2.hasNext()) {
            String string3 = (String)iterator2.next();
            String string4 = (String)map.get(string3);
            string2.putString(string3, string4);
        }
        map = this.zarb;
        int n10 = fastJsonResponse$Field.getSafeParcelableFieldId();
        SafeParcelWriter.writeBundle((Parcel)map, n10, (Bundle)string2, true);
    }

    public final void zab(FastJsonResponse$Field fastJsonResponse$Field, String string2, ArrayList arrayList) {
        this.zab(fastJsonResponse$Field);
        int n10 = arrayList.size();
        BigInteger[] bigIntegerArray = new BigInteger[n10];
        for (int i10 = 0; i10 < n10; ++i10) {
            BigInteger bigInteger;
            bigIntegerArray[i10] = bigInteger = (BigInteger)arrayList.get(i10);
        }
        string2 = this.zarb;
        int n11 = fastJsonResponse$Field.getSafeParcelableFieldId();
        SafeParcelWriter.writeBigIntegerArray((Parcel)string2, n11, bigIntegerArray, true);
    }

    public final void zac(FastJsonResponse$Field fastJsonResponse$Field, String string2, ArrayList arrayList) {
        this.zab(fastJsonResponse$Field);
        int n10 = arrayList.size();
        long[] lArray = new long[n10];
        for (int i10 = 0; i10 < n10; ++i10) {
            long l10;
            Long l11 = (Long)arrayList.get(i10);
            lArray[i10] = l10 = l11.longValue();
        }
        string2 = this.zarb;
        int n11 = fastJsonResponse$Field.getSafeParcelableFieldId();
        SafeParcelWriter.writeLongArray((Parcel)string2, n11, lArray, true);
    }

    public final void zad(FastJsonResponse$Field fastJsonResponse$Field, String string2, ArrayList arrayList) {
        this.zab(fastJsonResponse$Field);
        int n10 = arrayList.size();
        float[] fArray = new float[n10];
        for (int i10 = 0; i10 < n10; ++i10) {
            float f10;
            Float f11 = (Float)arrayList.get(i10);
            fArray[i10] = f10 = f11.floatValue();
        }
        string2 = this.zarb;
        int n11 = fastJsonResponse$Field.getSafeParcelableFieldId();
        SafeParcelWriter.writeFloatArray((Parcel)string2, n11, fArray, true);
    }

    public final void zae(FastJsonResponse$Field fastJsonResponse$Field, String string2, ArrayList arrayList) {
        this.zab(fastJsonResponse$Field);
        int n10 = arrayList.size();
        double[] dArray = new double[n10];
        for (int i10 = 0; i10 < n10; ++i10) {
            double d10;
            Double d11 = (Double)arrayList.get(i10);
            dArray[i10] = d10 = d11.doubleValue();
        }
        string2 = this.zarb;
        int n11 = fastJsonResponse$Field.getSafeParcelableFieldId();
        SafeParcelWriter.writeDoubleArray((Parcel)string2, n11, dArray, true);
    }

    public final void zaf(FastJsonResponse$Field fastJsonResponse$Field, String string2, ArrayList arrayList) {
        this.zab(fastJsonResponse$Field);
        int n10 = arrayList.size();
        BigDecimal[] bigDecimalArray = new BigDecimal[n10];
        for (int i10 = 0; i10 < n10; ++i10) {
            BigDecimal bigDecimal;
            bigDecimalArray[i10] = bigDecimal = (BigDecimal)arrayList.get(i10);
        }
        string2 = this.zarb;
        int n11 = fastJsonResponse$Field.getSafeParcelableFieldId();
        SafeParcelWriter.writeBigDecimalArray((Parcel)string2, n11, bigDecimalArray, true);
    }

    public final void zag(FastJsonResponse$Field fastJsonResponse$Field, String string2, ArrayList arrayList) {
        this.zab(fastJsonResponse$Field);
        int n10 = arrayList.size();
        boolean[] blArray = new boolean[n10];
        for (int i10 = 0; i10 < n10; ++i10) {
            boolean bl2;
            Boolean bl3 = (Boolean)arrayList.get(i10);
            blArray[i10] = bl2 = bl3.booleanValue();
        }
        string2 = this.zarb;
        int n11 = fastJsonResponse$Field.getSafeParcelableFieldId();
        SafeParcelWriter.writeBooleanArray((Parcel)string2, n11, blArray, true);
    }
}

