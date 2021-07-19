/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.zzfz;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class zzga {
    public static String zza(zzfz object) {
        String string2 = "Error printing proto: ";
        if (object == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        StringBuffer stringBuffer2 = new StringBuffer();
        try {
            zzga.zza(null, object, stringBuffer2, stringBuffer);
            return stringBuffer.toString();
        }
        catch (InvocationTargetException invocationTargetException) {
            object = String.valueOf(invocationTargetException.getMessage());
            int n10 = ((String)object).length();
            if (n10 != 0) {
                return string2.concat((String)object);
            }
            object = new String(string2);
            return object;
        }
        catch (IllegalAccessException illegalAccessException) {
            object = String.valueOf(illegalAccessException.getMessage());
            int n11 = ((String)object).length();
            if (n11 != 0) {
                return string2.concat((String)object);
            }
            object = new String(string2);
            return object;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static void zza(String string2, Object object, StringBuffer stringBuffer, StringBuffer stringBuffer2) {
        block18: {
            block25: {
                int n10;
                int n11;
                int n12;
                int n13;
                int n14;
                block26: {
                    StringBuilder stringBuilder;
                    block22: {
                        Object object2;
                        Object object3;
                        String string3;
                        int n15;
                        Field[] fieldArray;
                        Object object4;
                        int n16;
                        block20: {
                            block23: {
                                block24: {
                                    block21: {
                                        int n17;
                                        block19: {
                                            if (object == null) break block18;
                                            boolean bl2 = object instanceof zzfz;
                                            n14 = 1;
                                            if (!bl2) break block19;
                                            n16 = stringBuffer.length();
                                            if (string2 != null) {
                                                stringBuffer2.append(stringBuffer);
                                                object4 = zzga.zzl(string2);
                                                stringBuffer2.append((String)object4);
                                                stringBuffer2.append(" <\n");
                                                object4 = "  ";
                                                stringBuffer.append((String)object4);
                                            }
                                            object4 = object.getClass();
                                            fieldArray = ((Class)object4).getFields();
                                            n15 = fieldArray.length;
                                            string3 = null;
                                            break block20;
                                        }
                                        string2 = zzga.zzl(string2);
                                        stringBuffer2.append(stringBuffer);
                                        stringBuffer2.append(string2);
                                        string2 = ": ";
                                        stringBuffer2.append(string2);
                                        n13 = object instanceof String;
                                        n12 = 32;
                                        n11 = 34;
                                        if (n13 == 0) break block21;
                                        string2 = "http";
                                        n13 = ((String)(object = (String)object)).startsWith(string2);
                                        if (n13 == 0 && (n13 = ((String)object).length()) > (n17 = 200)) {
                                            string2 = String.valueOf(((String)object).substring(0, n17));
                                            object = string2.concat("[...]");
                                        }
                                        n13 = ((String)object).length();
                                        stringBuilder = new StringBuilder(n13);
                                        Object var7_12 = null;
                                        break block22;
                                    }
                                    n13 = object instanceof byte[];
                                    if (n13 == 0) break block23;
                                    if ((object = (Object)((byte[])object)) != null) break block24;
                                    string2 = "\"\"";
                                    stringBuffer2.append(string2);
                                    break block25;
                                }
                                stringBuffer2.append((char)n11);
                                string2 = null;
                                break block26;
                            }
                            stringBuffer2.append(object);
                            break block25;
                        }
                        for (int i10 = 0; i10 < n15; ++i10) {
                            object3 = fieldArray[i10];
                            int n18 = ((Field)object3).getModifiers();
                            Object object5 = "cachedSize";
                            String string4 = ((Field)object3).getName();
                            int n19 = ((String)object5).equals(string4);
                            if (n19 != 0 || (n19 = n18 & 1) != n14 || (n18 &= 8) == (n19 = 8) || (n19 = (int)(string4.startsWith((String)(object2 = "_")) ? 1 : 0)) != 0 || (n18 = (int)(string4.endsWith((String)object2) ? 1 : 0)) != 0) continue;
                            object2 = ((Field)object3).getType();
                            object3 = ((Field)object3).get(object);
                            n19 = (int)(((Class)object2).isArray() ? 1 : 0);
                            if (n19 != 0 && (object2 = ((Class)object2).getComponentType()) != (object5 = Byte.TYPE)) {
                                if (object3 == null) {
                                    n18 = 0;
                                    object2 = null;
                                } else {
                                    n18 = Array.getLength(object3);
                                }
                                object5 = null;
                                for (n19 = 0; n19 < n18; ++n19) {
                                    Object object6 = Array.get(object3, n19);
                                    zzga.zza(string4, object6, stringBuffer, stringBuffer2);
                                }
                                continue;
                            }
                            zzga.zza(string4, object3, stringBuffer, stringBuffer2);
                        }
                        Method[] methodArray = ((Class)object4).getMethods();
                        int n20 = methodArray.length;
                        Object var20_31 = null;
                        for (n15 = 0; n15 < n20; ++n15) {
                            int n22;
                            string3 = methodArray[n15].getName();
                            int n21 = string3.startsWith((String)(object3 = "set"));
                            if (n21 == 0) continue;
                            n21 = 3;
                            string3 = string3.substring(n21);
                            object3 = "has";
                            try {
                                object2 = String.valueOf(string3);
                                n22 = ((String)object2).length();
                                object3 = n22 != 0 ? ((String)object3).concat((String)object2) : (object2 = new String((String)object3));
                                object2 = new Class[]{};
                                object3 = ((Class)object4).getMethod((String)object3, (Class<?>)object2);
                            }
                            catch (NoSuchMethodException noSuchMethodException) {}
                            object2 = new Object[]{};
                            object3 = (Boolean)((Method)object3).invoke(object, (Object[])object2);
                            n21 = (int)(((Boolean)object3).booleanValue() ? 1 : 0);
                            if (n21 == 0) continue;
                            object3 = "get";
                            object2 = String.valueOf(string3);
                            n22 = ((String)object2).length();
                            object3 = n22 != 0 ? ((String)object3).concat((String)object2) : (object2 = new String((String)object3));
                            object2 = new Class[]{};
                            object3 = ((Class)object4).getMethod((String)object3, (Class<?>)object2);
                            object2 = new Object[]{};
                            object3 = ((Method)object3).invoke(object, (Object[])object2);
                            zzga.zza(string3, object3, stringBuffer, stringBuffer2);
                        }
                        if (string2 != null) {
                            stringBuffer.setLength(n16);
                            stringBuffer2.append(stringBuffer);
                            string2 = ">\n";
                            stringBuffer2.append(string2);
                        }
                        return;
                    }
                    for (int i11 = 0; i11 < n13; ++i11) {
                        Object object7;
                        int n23;
                        int n24 = ((String)object).charAt(i11);
                        if (n24 >= n12 && n24 <= (n23 = 126) && n24 != n11 && n24 != (n23 = 39)) {
                            stringBuilder.append((char)n24);
                            continue;
                        }
                        Object[] objectArray = new Object[n14];
                        objectArray[0] = object7 = Integer.valueOf(n24);
                        object7 = String.format("\\u%04x", objectArray);
                        stringBuilder.append((String)object7);
                    }
                    string2 = stringBuilder.toString();
                    object = "\"";
                    stringBuffer2.append((String)object);
                    stringBuffer2.append(string2);
                    stringBuffer2.append((String)object);
                    break block25;
                }
                for (n13 = 0; n13 < (n10 = ((Object)object).length); ++n13) {
                    n10 = object[n13] & 0xFF;
                    int n25 = 92;
                    if (n10 != n25 && n10 != n11) {
                        if (n10 < n12 || n10 >= (n25 = 127)) {
                            Object object8;
                            Object[] objectArray = new Object[n14];
                            objectArray[0] = object8 = Integer.valueOf(n10);
                            object8 = String.format("\\%03o", objectArray);
                            stringBuffer2.append((String)object8);
                            continue;
                        }
                    } else {
                        stringBuffer2.append((char)n25);
                    }
                    n10 = (char)n10;
                    stringBuffer2.append((char)n10);
                }
                stringBuffer2.append((char)n11);
            }
            string2 = "\n";
            stringBuffer2.append(string2);
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    private static String zzl(String string2) {
        StringBuffer stringBuffer = new StringBuffer();
        int n10 = 0;
        while (true) {
            int n11;
            block6: {
                block5: {
                    if (n10 >= (n11 = string2.length())) {
                        return stringBuffer.toString();
                    }
                    n11 = string2.charAt(n10);
                    if (n10 == 0) break block5;
                    char c10 = Character.isUpperCase((char)n11);
                    if (c10 == '\u0000') break block6;
                    c10 = '_';
                    stringBuffer.append(c10);
                }
                n11 = Character.toLowerCase((char)n11);
            }
            stringBuffer.append((char)n11);
            ++n10;
        }
    }
}

