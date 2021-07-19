/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzgs;
import com.google.android.gms.internal.measurement.zzhp;
import com.google.android.gms.internal.measurement.zzhs;
import com.google.android.gms.internal.measurement.zzix;
import com.google.android.gms.internal.measurement.zzju;
import com.google.android.gms.internal.measurement.zzjx;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public final class zziz {
    public static String zza(zzix zzix2, String string2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("# ");
        stringBuilder.append(string2);
        zziz.zzc(zzix2, stringBuilder, 0);
        return stringBuilder.toString();
    }

    public static final void zzb(StringBuilder stringBuilder, int n10, String string2, Object object) {
        char c10;
        int n11 = object instanceof List;
        if (n11 != 0) {
            object = ((List)object).iterator();
            while ((n11 = object.hasNext()) != 0) {
                Object e10 = object.next();
                zziz.zzb(stringBuilder, n10, string2, e10);
            }
            return;
        }
        n11 = object instanceof Map;
        if (n11 != 0) {
            object = ((Map)object).entrySet().iterator();
            while ((n11 = object.hasNext()) != 0) {
                Map.Entry entry = (Map.Entry)object.next();
                zziz.zzb(stringBuilder, n10, string2, entry);
            }
            return;
        }
        stringBuilder.append('\n');
        n11 = 0;
        Object var5_7 = null;
        char c11 = '\u0000';
        String string3 = null;
        while (true) {
            c10 = ' ';
            if (c11 >= n10) break;
            stringBuilder.append(c10);
            ++c11;
        }
        stringBuilder.append(string2);
        int n12 = object instanceof String;
        c11 = '\"';
        String string4 = ": \"";
        if (n12 != 0) {
            stringBuilder.append(string4);
            String string5 = zzju.zza(zzgs.zzk((String)object));
            stringBuilder.append(string5);
            stringBuilder.append(c11);
            return;
        }
        n12 = object instanceof zzgs;
        if (n12 != 0) {
            stringBuilder.append(string4);
            String string6 = zzju.zza((zzgs)object);
            stringBuilder.append(string6);
            stringBuilder.append(c11);
            return;
        }
        n12 = object instanceof zzhs;
        string3 = "}";
        string4 = "\n";
        String string7 = " {";
        if (n12 != 0) {
            stringBuilder.append(string7);
            object = (zzhs)object;
            n12 = n10 + 2;
            zziz.zzc((zzix)object, stringBuilder, n12);
            stringBuilder.append(string4);
            while (n11 < n10) {
                stringBuilder.append(c10);
                ++n11;
            }
            stringBuilder.append(string3);
            return;
        }
        n12 = object instanceof Map.Entry;
        if (n12 != 0) {
            stringBuilder.append(string7);
            object = (Map.Entry)object;
            n12 = n10 + 2;
            string7 = object.getKey();
            String string8 = "key";
            zziz.zzb(stringBuilder, n12, string8, string7);
            object = object.getValue();
            string7 = "value";
            zziz.zzb(stringBuilder, n12, string7, object);
            stringBuilder.append(string4);
            while (n11 < n10) {
                stringBuilder.append(c10);
                ++n11;
            }
            stringBuilder.append(string3);
            return;
        }
        stringBuilder.append(": ");
        String string9 = object.toString();
        stringBuilder.append(string9);
    }

    /*
     * Enabled aggressive block sorting
     */
    private static void zzc(zzix object, StringBuilder stringBuilder, int n10) {
        int n11;
        int n12;
        String string2;
        HashMap<Class<?>[], Method> hashMap = new HashMap<Class<?>[], Method>();
        HashMap<Class<?>[], Method> hashMap2 = new HashMap<Class<?>[], Method>();
        Object object2 = new TreeSet();
        Object object3 = object.getClass().getDeclaredMethods();
        int n13 = ((Method[])object3).length;
        int n14 = 0;
        Object object4 = null;
        while (true) {
            string2 = "get";
            if (n14 >= n13) break;
            Method method = object3[n14];
            Object object5 = method.getName();
            hashMap2.put((Class<?>[])object5, method);
            object5 = method.getParameterTypes();
            n12 = ((Class<?>[])object5).length;
            if (n12 == 0) {
                object5 = method.getName();
                hashMap.put((Class<?>[])object5, method);
                object5 = method.getName();
                boolean bl2 = ((String)object5).startsWith(string2);
                if (bl2) {
                    string2 = method.getName();
                    object2.add(string2);
                }
            }
            ++n14;
        }
        object2 = object2.iterator();
        while ((n11 = object2.hasNext()) != 0) {
            block21: {
                Object object6;
                block19: {
                    block27: {
                        block26: {
                            block25: {
                                block24: {
                                    double d10;
                                    block23: {
                                        int n15;
                                        float f10;
                                        block22: {
                                            block20: {
                                                Class<Object> clazz;
                                                int n16;
                                                String string3;
                                                object3 = (String)object2.next();
                                                n13 = (int)(((String)object3).startsWith(string2) ? 1 : 0);
                                                if (n13 != 0) {
                                                    n13 = 3;
                                                    f10 = 4.2E-45f;
                                                    object6 = ((String)object3).substring(n13);
                                                } else {
                                                    object6 = object3;
                                                }
                                                object4 = "List";
                                                n15 = ((String)object6).endsWith((String)object4);
                                                n12 = 1;
                                                if (n15 != 0 && (n15 = ((String)object6).endsWith(string3 = "OrBuilderList")) == 0 && (n14 = (int)(((String)object6).equals(object4) ? 1 : 0)) == 0) {
                                                    Class<List> clazz2;
                                                    object4 = String.valueOf(((String)object6).substring(0, n12).toLowerCase());
                                                    n15 = ((String)object6).length() + -4;
                                                    String string4 = String.valueOf(((String)object6).substring(n12, n15));
                                                    n16 = string4.length();
                                                    if (n16 != 0) {
                                                        object4 = ((String)object4).concat(string4);
                                                    } else {
                                                        String string5 = new String((String)object4);
                                                        object4 = string5;
                                                    }
                                                    Method method = (Method)hashMap.get(object3);
                                                    if (method != null && (n16 = (int)((clazz = method.getReturnType()).equals(clazz2 = List.class) ? 1 : 0)) != 0) {
                                                        object3 = zziz.zzd((String)object4);
                                                        object6 = new Object[]{};
                                                        object6 = zzhs.zzbA(method, object, (Object[])object6);
                                                        zziz.zzb(stringBuilder, n10, (String)object3, object6);
                                                        continue;
                                                    }
                                                }
                                                if ((n15 = ((String)object6).endsWith((String)(object4 = "Map"))) != 0 && (n14 = (int)(((String)object6).equals(object4) ? 1 : 0)) == 0) {
                                                    Class<Deprecated> clazz3;
                                                    Class<?> clazz4;
                                                    object4 = String.valueOf(((String)object6).substring(0, n12).toLowerCase());
                                                    n15 = ((String)object6).length() + -3;
                                                    String string6 = String.valueOf(((String)object6).substring(n12, n15));
                                                    n16 = string6.length();
                                                    if (n16 != 0) {
                                                        object4 = ((String)object4).concat(string6);
                                                    } else {
                                                        String string7 = new String((String)object4);
                                                        object4 = string7;
                                                    }
                                                    object3 = (Method)hashMap.get(object3);
                                                    if (object3 != null && (n15 = (int)((clazz4 = ((Method)object3).getReturnType()).equals(clazz = Map.class) ? 1 : 0)) != 0 && (n15 = (int)(((AccessibleObject)object3).isAnnotationPresent(clazz3 = Deprecated.class) ? 1 : 0)) == 0 && (n15 = (int)(Modifier.isPublic(((Method)object3).getModifiers()) ? 1 : 0)) != 0) {
                                                        object6 = zziz.zzd((String)object4);
                                                        object4 = new Object[]{};
                                                        object3 = zzhs.zzbA((Method)object3, object, (Object[])object4);
                                                        zziz.zzb(stringBuilder, n10, (String)object6, object3);
                                                        continue;
                                                    }
                                                }
                                                object3 = String.valueOf(object6);
                                                object4 = "set";
                                                n15 = ((String)object3).length();
                                                object3 = n15 != 0 ? ((String)object4).concat((String)object3) : new String((String)object4);
                                                if ((object3 = (Method)hashMap2.get(object3)) == null || (n11 = ((String)object6).endsWith((String)(object3 = "Bytes"))) != 0 && (n11 = (int)(hashMap.containsKey(object3 = (n14 = ((String)(object3 = String.valueOf(((String)object6).substring(0, n11 = ((String)object6).length() + -5)))).length()) != 0 ? string2.concat((String)object3) : new String(string2)) ? 1 : 0)) != 0) continue;
                                                object3 = String.valueOf(((String)object6).substring(0, n12).toLowerCase());
                                                object4 = String.valueOf(((String)object6).substring(n12));
                                                n15 = ((String)object4).length();
                                                object3 = n15 != 0 ? ((String)object3).concat((String)object4) : (object4 = new String((String)object3));
                                                object4 = String.valueOf(object6);
                                                n15 = ((String)object4).length();
                                                object4 = n15 != 0 ? string2.concat((String)object4) : new String(string2);
                                                object4 = (Method)hashMap.get(object4);
                                                object6 = String.valueOf(object6);
                                                String string8 = "has";
                                                n12 = ((String)object6).length();
                                                object6 = n12 != 0 ? string8.concat((String)object6) : new String(string8);
                                                object6 = (Method)hashMap.get(object6);
                                                if (object4 == null) continue;
                                                Object[] objectArray = new Object[]{};
                                                object4 = zzhs.zzbA((Method)object4, object, objectArray);
                                                if (object6 != null) break block19;
                                                n13 = object4 instanceof Boolean;
                                                if (n13 == 0) break block20;
                                                object6 = object4;
                                                object6 = (Boolean)object4;
                                                n13 = (int)(((Boolean)object6).booleanValue() ? 1 : 0);
                                                if (n13 == 0) continue;
                                                break block21;
                                            }
                                            n13 = object4 instanceof Integer;
                                            if (n13 == 0) break block22;
                                            object6 = object4;
                                            object6 = (Integer)object4;
                                            n13 = (Integer)object6;
                                            if (n13 == 0) continue;
                                            break block21;
                                        }
                                        n13 = object4 instanceof Float;
                                        if (n13 == 0) break block23;
                                        object6 = object4;
                                        object6 = (Float)object4;
                                        f10 = ((Float)object6).floatValue();
                                        n15 = 0;
                                        Object var11_25 = null;
                                        float f11 = f10 - 0.0f;
                                        n13 = (int)(f11 == 0.0f ? 0 : (f11 > 0.0f ? 1 : -1));
                                        if (n13 == 0) continue;
                                        break block21;
                                    }
                                    n13 = object4 instanceof Double;
                                    if (n13 == 0) break block24;
                                    object6 = object4;
                                    object6 = (Double)object4;
                                    double d11 = (Double)object6;
                                    double d12 = d11 - (d10 = 0.0);
                                    n13 = (int)(d12 == 0.0 ? 0 : (d12 > 0.0 ? 1 : -1));
                                    if (n13 == 0) continue;
                                    break block21;
                                }
                                n13 = object4 instanceof String;
                                if (n13 == 0) break block25;
                                object6 = "";
                                n13 = (int)(object4.equals(object6) ? 1 : 0);
                                break block26;
                            }
                            n13 = object4 instanceof zzgs;
                            if (n13 == 0) break block27;
                            object6 = zzgs.zzb;
                            n13 = (int)(object4.equals(object6) ? 1 : 0);
                        }
                        if (n13 != 0) continue;
                        break block21;
                    }
                    n13 = object4 instanceof zzix;
                    if (n13 != 0) {
                        object6 = object4;
                        object6 = ((zzix)object4).zzbK();
                        if (object4 == object6) continue;
                        break block21;
                    } else {
                        n13 = object4 instanceof Enum;
                        if (n13 != 0) {
                            object6 = object4;
                            object6 = (Enum)object4;
                            n13 = ((Enum)object6).ordinal();
                            if (n13 == 0) continue;
                        }
                    }
                    break block21;
                }
                Object[] objectArray = new Object[0];
                n13 = (int)(((Boolean)(object6 = (Boolean)zzhs.zzbA((Method)object6, object, objectArray))).booleanValue() ? 1 : 0);
                if (n13 == 0) continue;
            }
            object3 = zziz.zzd((String)object3);
            zziz.zzb(stringBuilder, n10, (String)object3, object4);
        }
        boolean bl3 = object instanceof zzhp;
        if (bl3) {
            object = ((zzhp)object).zza;
            throw null;
        }
        object = ((zzhs)object).zzc;
        if (object != null) {
            ((zzjx)object).zzg(stringBuilder, n10);
        }
    }

    private static final String zzd(String string2) {
        int n10;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i10 = 0; i10 < (n10 = string2.length()); ++i10) {
            n10 = string2.charAt(i10);
            boolean bl2 = Character.isUpperCase((char)n10);
            if (bl2) {
                String string3 = "_";
                stringBuilder.append(string3);
            }
            n10 = Character.toLowerCase((char)n10);
            stringBuilder.append((char)n10);
        }
        return stringBuilder.toString();
    }
}

