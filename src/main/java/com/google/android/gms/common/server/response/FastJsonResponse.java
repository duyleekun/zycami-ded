/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Log
 */
package com.google.android.gms.common.server.response;

import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.server.response.FastJsonResponse$Field;
import com.google.android.gms.common.server.response.FastJsonResponse$FieldConverter;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.common.util.JsonUtils;
import com.google.android.gms.common.util.MapUtils;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public abstract class FastJsonResponse {
    private final void zaa(FastJsonResponse$Field object, Object object2) {
        String string2 = ((FastJsonResponse$Field)object).zapv;
        object2 = ((FastJsonResponse$Field)object).convert(object2);
        int n10 = ((FastJsonResponse$Field)object).zapt;
        switch (n10) {
            default: {
                int n11 = ((FastJsonResponse$Field)object).zapt;
                StringBuilder stringBuilder = new StringBuilder(44);
                stringBuilder.append("Unsupported type for conversion: ");
                stringBuilder.append(n11);
                object = stringBuilder.toString();
                object2 = new IllegalStateException((String)object);
                throw object2;
            }
            case 8: 
            case 9: {
                n10 = (int)(FastJsonResponse.zaa(string2, object2) ? 1 : 0);
                if (n10 == 0) break;
                object2 = (byte[])object2;
                this.setDecodedBytesInternal((FastJsonResponse$Field)object, string2, (byte[])object2);
                return;
            }
            case 7: {
                object2 = (String)object2;
                this.setStringInternal((FastJsonResponse$Field)object, string2, (String)object2);
                return;
            }
            case 6: {
                n10 = (int)(FastJsonResponse.zaa(string2, object2) ? 1 : 0);
                if (n10 == 0) break;
                boolean bl2 = (Boolean)object2;
                this.setBooleanInternal((FastJsonResponse$Field)object, string2, bl2);
                return;
            }
            case 5: {
                object2 = (BigDecimal)object2;
                this.zaa((FastJsonResponse$Field)object, string2, (BigDecimal)object2);
                return;
            }
            case 4: {
                n10 = (int)(FastJsonResponse.zaa(string2, object2) ? 1 : 0);
                if (n10 == 0) break;
                double d10 = (Double)object2;
                this.zaa((FastJsonResponse$Field)object, string2, d10);
                return;
            }
            case 2: {
                n10 = (int)(FastJsonResponse.zaa(string2, object2) ? 1 : 0);
                if (n10 == 0) break;
                long l10 = (Long)object2;
                this.setLongInternal((FastJsonResponse$Field)object, string2, l10);
                return;
            }
            case 1: {
                object2 = (BigInteger)object2;
                this.zaa((FastJsonResponse$Field)object, string2, (BigInteger)object2);
                return;
            }
            case 0: {
                n10 = (int)(FastJsonResponse.zaa(string2, object2) ? 1 : 0);
                if (n10 == 0) break;
                object2 = (Integer)object2;
                int n12 = (Integer)object2;
                this.setIntegerInternal((FastJsonResponse$Field)object, string2, n12);
            }
        }
    }

    private static void zaa(StringBuilder stringBuilder, FastJsonResponse$Field object, Object object2) {
        int n10 = ((FastJsonResponse$Field)object).zapr;
        int n11 = 11;
        if (n10 == n11) {
            object = ((FastJsonResponse)((FastJsonResponse$Field)object).zapx.cast(object2)).toString();
            stringBuilder.append((String)object);
            return;
        }
        int n12 = 7;
        if (n10 == n12) {
            object = "\"";
            stringBuilder.append((String)object);
            object2 = JsonUtils.escapeString((String)object2);
            stringBuilder.append((String)object2);
            stringBuilder.append((String)object);
            return;
        }
        stringBuilder.append(object2);
    }

    private static boolean zaa(String string2, Object object) {
        if (object == null) {
            String string3 = "FastJsonResponse";
            int n10 = Log.isLoggable((String)string3, (int)6);
            if (n10 != 0) {
                n10 = String.valueOf(string2).length() + 58;
                StringBuilder stringBuilder = new StringBuilder(n10);
                object = "Output field (";
                stringBuilder.append((String)object);
                stringBuilder.append(string2);
                stringBuilder.append(") has a null value, but expected a primitive");
                string2 = stringBuilder.toString();
                Log.e((String)string3, (String)string2);
            }
            return false;
        }
        return true;
    }

    public static Object zab(FastJsonResponse$Field fastJsonResponse$Field, Object object) {
        FastJsonResponse$FieldConverter fastJsonResponse$FieldConverter = FastJsonResponse$Field.zaa(fastJsonResponse$Field);
        if (fastJsonResponse$FieldConverter != null) {
            return fastJsonResponse$Field.convertBack(object);
        }
        return object;
    }

    public void addConcreteTypeArrayInternal(FastJsonResponse$Field object, String string2, ArrayList arrayList) {
        object = new UnsupportedOperationException("Concrete type array not supported");
        throw object;
    }

    public void addConcreteTypeInternal(FastJsonResponse$Field object, String string2, FastJsonResponse fastJsonResponse) {
        object = new UnsupportedOperationException("Concrete type not supported");
        throw object;
    }

    public abstract Map getFieldMappings();

    public Object getFieldValue(FastJsonResponse$Field object) {
        Object[] objectArray = ((FastJsonResponse$Field)object).zapv;
        Object object2 = ((FastJsonResponse$Field)object).zapx;
        if (object2 != null) {
            int n10;
            object2 = this.getValueObject((String)objectArray);
            int n11 = 1;
            if (object2 == null) {
                n10 = n11;
            } else {
                n10 = 0;
                object2 = null;
            }
            Object[] objectArray2 = new Object[n11];
            String string2 = ((FastJsonResponse$Field)object).zapv;
            objectArray2[0] = string2;
            string2 = "Concrete field shouldn't be value object: %s";
            Preconditions.checkState(n10 != 0, string2, objectArray2);
            char c10 = ((FastJsonResponse$Field)object).zapu;
            try {
                c10 = objectArray.charAt(0);
            }
            catch (Exception exception) {
                objectArray = new RuntimeException(exception);
                throw objectArray;
            }
            c10 = Character.toUpperCase(c10);
            objectArray = objectArray.substring(n11);
            object2 = String.valueOf(objectArray);
            n10 = object2.length() + 4;
            StringBuilder stringBuilder = new StringBuilder(n10);
            object2 = "get";
            stringBuilder.append((String)object2);
            stringBuilder.append(c10);
            stringBuilder.append((String)objectArray);
            object = stringBuilder.toString();
            objectArray = this.getClass();
            object2 = new Class[]{};
            object = objectArray.getMethod((String)object, (Class<?>)object2);
            objectArray = new Object[]{};
            return ((Method)object).invoke(this, objectArray);
        }
        return this.getValueObject((String)objectArray);
    }

    public abstract Object getValueObject(String var1);

    public boolean isFieldSet(FastJsonResponse$Field object) {
        int n10 = ((FastJsonResponse$Field)object).zapt;
        int n11 = 11;
        if (n10 == n11) {
            n10 = (int)(((FastJsonResponse$Field)object).zapu ? 1 : 0);
            if (n10 != 0) {
                object = ((FastJsonResponse$Field)object).zapv;
                object = new UnsupportedOperationException("Concrete type arrays not supported");
                throw object;
            }
            object = ((FastJsonResponse$Field)object).zapv;
            object = new UnsupportedOperationException("Concrete types not supported");
            throw object;
        }
        object = ((FastJsonResponse$Field)object).zapv;
        return this.isPrimitiveFieldSet((String)object);
    }

    public abstract boolean isPrimitiveFieldSet(String var1);

    public void setBooleanInternal(FastJsonResponse$Field object, String string2, boolean bl2) {
        object = new UnsupportedOperationException("Boolean not supported");
        throw object;
    }

    public void setDecodedBytesInternal(FastJsonResponse$Field object, String string2, byte[] byArray) {
        object = new UnsupportedOperationException("byte[] not supported");
        throw object;
    }

    public void setIntegerInternal(FastJsonResponse$Field object, String string2, int n10) {
        object = new UnsupportedOperationException("Integer not supported");
        throw object;
    }

    public void setLongInternal(FastJsonResponse$Field object, String string2, long l10) {
        object = new UnsupportedOperationException("Long not supported");
        throw object;
    }

    public void setStringInternal(FastJsonResponse$Field object, String string2, String string3) {
        object = new UnsupportedOperationException("String not supported");
        throw object;
    }

    public void setStringsInternal(FastJsonResponse$Field object, String string2, ArrayList arrayList) {
        object = new UnsupportedOperationException("String list not supported");
        throw object;
    }

    public String toString() {
        int n10;
        Object object = this.getFieldMappings();
        int n11 = 100;
        StringBuilder stringBuilder = new StringBuilder(n11);
        Iterator iterator2 = object.keySet().iterator();
        block5: while ((n10 = iterator2.hasNext()) != 0) {
            Object object2;
            FastJsonResponse$Field fastJsonResponse$Field;
            block14: {
                String string2;
                String string3 = (String)iterator2.next();
                fastJsonResponse$Field = (FastJsonResponse$Field)object.get(string3);
                boolean bl2 = this.isFieldSet(fastJsonResponse$Field);
                if (!bl2) continue;
                object2 = this.getFieldValue(fastJsonResponse$Field);
                object2 = FastJsonResponse.zab(fastJsonResponse$Field, object2);
                int n12 = stringBuilder.length();
                String string4 = ",";
                if (n12 == 0) {
                    string2 = "{";
                    stringBuilder.append(string2);
                } else {
                    stringBuilder.append(string4);
                }
                string2 = "\"";
                stringBuilder.append(string2);
                stringBuilder.append(string3);
                string3 = "\":";
                stringBuilder.append(string3);
                if (object2 == null) {
                    string3 = "null";
                    stringBuilder.append(string3);
                    continue;
                }
                n10 = fastJsonResponse$Field.zapt;
                switch (n10) {
                    default: {
                        n10 = (int)(fastJsonResponse$Field.zaps ? 1 : 0);
                        if (n10 != 0) {
                            object2 = (ArrayList)object2;
                            stringBuilder.append("[");
                            string3 = null;
                            n12 = ((ArrayList)object2).size();
                            break;
                        }
                        break block14;
                    }
                    case 10: {
                        object2 = (HashMap)object2;
                        MapUtils.writeStringMapToJson(stringBuilder, (HashMap)object2);
                        continue block5;
                    }
                    case 9: {
                        stringBuilder.append(string2);
                        object2 = (byte[])object2;
                        string3 = Base64Utils.encodeUrlSafe((byte[])object2);
                        stringBuilder.append(string3);
                        stringBuilder.append(string2);
                        continue block5;
                    }
                    case 8: {
                        stringBuilder.append(string2);
                        object2 = (byte[])object2;
                        string3 = Base64Utils.encode((byte[])object2);
                        stringBuilder.append(string3);
                        stringBuilder.append(string2);
                        continue block5;
                    }
                }
                for (n10 = 0; n10 < n12; ++n10) {
                    Object e10;
                    if (n10 > 0) {
                        stringBuilder.append(string4);
                    }
                    if ((e10 = ((ArrayList)object2).get(n10)) == null) continue;
                    FastJsonResponse.zaa(stringBuilder, fastJsonResponse$Field, e10);
                }
                string3 = "]";
                stringBuilder.append(string3);
                continue;
            }
            FastJsonResponse.zaa(stringBuilder, fastJsonResponse$Field, object2);
        }
        int n13 = stringBuilder.length();
        if (n13 > 0) {
            object = "}";
            stringBuilder.append((String)object);
        } else {
            object = "{}";
            stringBuilder.append((String)object);
        }
        return stringBuilder.toString();
    }

    public final void zaa(FastJsonResponse$Field fastJsonResponse$Field, double d10) {
        Object object = FastJsonResponse$Field.zaa(fastJsonResponse$Field);
        if (object != null) {
            Double d11 = d10;
            this.zaa(fastJsonResponse$Field, d11);
            return;
        }
        object = fastJsonResponse$Field.zapv;
        this.zaa(fastJsonResponse$Field, (String)object, d10);
    }

    public final void zaa(FastJsonResponse$Field fastJsonResponse$Field, float f10) {
        Object object = FastJsonResponse$Field.zaa(fastJsonResponse$Field);
        if (object != null) {
            Float f11 = Float.valueOf(f10);
            this.zaa(fastJsonResponse$Field, f11);
            return;
        }
        object = fastJsonResponse$Field.zapv;
        this.zaa(fastJsonResponse$Field, (String)object, f10);
    }

    public final void zaa(FastJsonResponse$Field fastJsonResponse$Field, int n10) {
        Object object = FastJsonResponse$Field.zaa(fastJsonResponse$Field);
        if (object != null) {
            Integer n11 = n10;
            this.zaa(fastJsonResponse$Field, n11);
            return;
        }
        object = fastJsonResponse$Field.zapv;
        this.setIntegerInternal(fastJsonResponse$Field, (String)object, n10);
    }

    public final void zaa(FastJsonResponse$Field fastJsonResponse$Field, long l10) {
        Object object = FastJsonResponse$Field.zaa(fastJsonResponse$Field);
        if (object != null) {
            Long l11 = l10;
            this.zaa(fastJsonResponse$Field, l11);
            return;
        }
        object = fastJsonResponse$Field.zapv;
        this.setLongInternal(fastJsonResponse$Field, (String)object, l10);
    }

    public final void zaa(FastJsonResponse$Field fastJsonResponse$Field, String string2) {
        Object object = FastJsonResponse$Field.zaa(fastJsonResponse$Field);
        if (object != null) {
            this.zaa(fastJsonResponse$Field, (Object)string2);
            return;
        }
        object = fastJsonResponse$Field.zapv;
        this.setStringInternal(fastJsonResponse$Field, (String)object, string2);
    }

    public void zaa(FastJsonResponse$Field object, String string2, double d10) {
        object = new UnsupportedOperationException("Double not supported");
        throw object;
    }

    public void zaa(FastJsonResponse$Field object, String string2, float f10) {
        object = new UnsupportedOperationException("Float not supported");
        throw object;
    }

    public void zaa(FastJsonResponse$Field object, String string2, BigDecimal bigDecimal) {
        object = new UnsupportedOperationException("BigDecimal not supported");
        throw object;
    }

    public void zaa(FastJsonResponse$Field object, String string2, BigInteger bigInteger) {
        object = new UnsupportedOperationException("BigInteger not supported");
        throw object;
    }

    public void zaa(FastJsonResponse$Field object, String string2, ArrayList arrayList) {
        object = new UnsupportedOperationException("Integer list not supported");
        throw object;
    }

    public void zaa(FastJsonResponse$Field object, String string2, Map map) {
        object = new UnsupportedOperationException("String map not supported");
        throw object;
    }

    public final void zaa(FastJsonResponse$Field fastJsonResponse$Field, BigDecimal bigDecimal) {
        Object object = FastJsonResponse$Field.zaa(fastJsonResponse$Field);
        if (object != null) {
            this.zaa(fastJsonResponse$Field, (Object)bigDecimal);
            return;
        }
        object = fastJsonResponse$Field.zapv;
        this.zaa(fastJsonResponse$Field, (String)object, bigDecimal);
    }

    public final void zaa(FastJsonResponse$Field fastJsonResponse$Field, BigInteger bigInteger) {
        Object object = FastJsonResponse$Field.zaa(fastJsonResponse$Field);
        if (object != null) {
            this.zaa(fastJsonResponse$Field, (Object)bigInteger);
            return;
        }
        object = fastJsonResponse$Field.zapv;
        this.zaa(fastJsonResponse$Field, (String)object, bigInteger);
    }

    public final void zaa(FastJsonResponse$Field fastJsonResponse$Field, ArrayList arrayList) {
        Object object = FastJsonResponse$Field.zaa(fastJsonResponse$Field);
        if (object != null) {
            this.zaa(fastJsonResponse$Field, (Object)arrayList);
            return;
        }
        object = fastJsonResponse$Field.zapv;
        this.zaa(fastJsonResponse$Field, (String)object, arrayList);
    }

    public final void zaa(FastJsonResponse$Field fastJsonResponse$Field, Map map) {
        Object object = FastJsonResponse$Field.zaa(fastJsonResponse$Field);
        if (object != null) {
            this.zaa(fastJsonResponse$Field, (Object)map);
            return;
        }
        object = fastJsonResponse$Field.zapv;
        this.zaa(fastJsonResponse$Field, (String)object, map);
    }

    public final void zaa(FastJsonResponse$Field fastJsonResponse$Field, boolean bl2) {
        Object object = FastJsonResponse$Field.zaa(fastJsonResponse$Field);
        if (object != null) {
            Boolean bl3 = bl2;
            this.zaa(fastJsonResponse$Field, bl3);
            return;
        }
        object = fastJsonResponse$Field.zapv;
        this.setBooleanInternal(fastJsonResponse$Field, (String)object, bl2);
    }

    public final void zaa(FastJsonResponse$Field fastJsonResponse$Field, byte[] byArray) {
        Object object = FastJsonResponse$Field.zaa(fastJsonResponse$Field);
        if (object != null) {
            this.zaa(fastJsonResponse$Field, (Object)byArray);
            return;
        }
        object = fastJsonResponse$Field.zapv;
        this.setDecodedBytesInternal(fastJsonResponse$Field, (String)object, byArray);
    }

    public void zab(FastJsonResponse$Field object, String string2, ArrayList arrayList) {
        object = new UnsupportedOperationException("BigInteger list not supported");
        throw object;
    }

    public final void zab(FastJsonResponse$Field fastJsonResponse$Field, ArrayList arrayList) {
        Object object = FastJsonResponse$Field.zaa(fastJsonResponse$Field);
        if (object != null) {
            this.zaa(fastJsonResponse$Field, (Object)arrayList);
            return;
        }
        object = fastJsonResponse$Field.zapv;
        this.zab(fastJsonResponse$Field, (String)object, arrayList);
    }

    public void zac(FastJsonResponse$Field object, String string2, ArrayList arrayList) {
        object = new UnsupportedOperationException("Long list not supported");
        throw object;
    }

    public final void zac(FastJsonResponse$Field fastJsonResponse$Field, ArrayList arrayList) {
        Object object = FastJsonResponse$Field.zaa(fastJsonResponse$Field);
        if (object != null) {
            this.zaa(fastJsonResponse$Field, (Object)arrayList);
            return;
        }
        object = fastJsonResponse$Field.zapv;
        this.zac(fastJsonResponse$Field, (String)object, arrayList);
    }

    public void zad(FastJsonResponse$Field object, String string2, ArrayList arrayList) {
        object = new UnsupportedOperationException("Float list not supported");
        throw object;
    }

    public final void zad(FastJsonResponse$Field fastJsonResponse$Field, ArrayList arrayList) {
        Object object = FastJsonResponse$Field.zaa(fastJsonResponse$Field);
        if (object != null) {
            this.zaa(fastJsonResponse$Field, (Object)arrayList);
            return;
        }
        object = fastJsonResponse$Field.zapv;
        this.zad(fastJsonResponse$Field, (String)object, arrayList);
    }

    public void zae(FastJsonResponse$Field object, String string2, ArrayList arrayList) {
        object = new UnsupportedOperationException("Double list not supported");
        throw object;
    }

    public final void zae(FastJsonResponse$Field fastJsonResponse$Field, ArrayList arrayList) {
        Object object = FastJsonResponse$Field.zaa(fastJsonResponse$Field);
        if (object != null) {
            this.zaa(fastJsonResponse$Field, (Object)arrayList);
            return;
        }
        object = fastJsonResponse$Field.zapv;
        this.zae(fastJsonResponse$Field, (String)object, arrayList);
    }

    public void zaf(FastJsonResponse$Field object, String string2, ArrayList arrayList) {
        object = new UnsupportedOperationException("BigDecimal list not supported");
        throw object;
    }

    public final void zaf(FastJsonResponse$Field fastJsonResponse$Field, ArrayList arrayList) {
        Object object = FastJsonResponse$Field.zaa(fastJsonResponse$Field);
        if (object != null) {
            this.zaa(fastJsonResponse$Field, (Object)arrayList);
            return;
        }
        object = fastJsonResponse$Field.zapv;
        this.zaf(fastJsonResponse$Field, (String)object, arrayList);
    }

    public void zag(FastJsonResponse$Field object, String string2, ArrayList arrayList) {
        object = new UnsupportedOperationException("Boolean list not supported");
        throw object;
    }

    public final void zag(FastJsonResponse$Field fastJsonResponse$Field, ArrayList arrayList) {
        Object object = FastJsonResponse$Field.zaa(fastJsonResponse$Field);
        if (object != null) {
            this.zaa(fastJsonResponse$Field, (Object)arrayList);
            return;
        }
        object = fastJsonResponse$Field.zapv;
        this.zag(fastJsonResponse$Field, (String)object, arrayList);
    }

    public final void zah(FastJsonResponse$Field fastJsonResponse$Field, ArrayList arrayList) {
        Object object = FastJsonResponse$Field.zaa(fastJsonResponse$Field);
        if (object != null) {
            this.zaa(fastJsonResponse$Field, (Object)arrayList);
            return;
        }
        object = fastJsonResponse$Field.zapv;
        this.setStringsInternal(fastJsonResponse$Field, (String)object, arrayList);
    }
}

