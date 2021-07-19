/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzgs;
import com.google.android.gms.internal.vision.zzid;
import com.google.android.gms.internal.vision.zzid$zzd;
import com.google.android.gms.internal.vision.zzid$zze;
import com.google.android.gms.internal.vision.zzjn;
import com.google.android.gms.internal.vision.zzkt;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public final class zzjo {
    public static String zza(zzjn zzjn2, String string2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("# ");
        stringBuilder.append(string2);
        zzjo.zza(zzjn2, stringBuilder, 0);
        return stringBuilder.toString();
    }

    /*
     * Unable to fully structure code
     */
    private static void zza(zzjn var0, StringBuilder var1_1, int var2_2) {
        var3_3 = new HashMap();
        var4_4 = new HashMap();
        var5_5 = new TreeSet();
        var6_6 = var0.getClass().getDeclaredMethods();
        var7_7 = ((Method[])var6_6).length;
        var8_8 = 0;
        var9_9 = null;
        while (true) {
            var10_10 = "get";
            if (var8_8 >= var7_7) break;
            var11_11 = var6_6[var8_8];
            var12_12 = var11_11.getName();
            var4_4.put(var12_12, var11_11);
            var12_12 = var11_11.getParameterTypes();
            var13_13 = ((Class<?>[])var12_12).length;
            if (var13_13 == 0) {
                var12_12 = var11_11.getName();
                var3_3.put(var12_12, var11_11);
                var12_12 = var11_11.getName();
                var14_14 = var12_12.startsWith(var10_10);
                if (var14_14) {
                    var10_10 = var11_11.getName();
                    var5_5.add(var10_10);
                }
            }
            ++var8_8;
        }
        var5_5 = var5_5.iterator();
        while ((var15_15 = var5_5.hasNext()) != 0) {
            block26: {
                block19: {
                    block18: {
                        block25: {
                            block24: {
                                block23: {
                                    block22: {
                                        block21: {
                                            block20: {
                                                var6_6 = (String)var5_5.next();
                                                var7_7 = (int)var6_6.startsWith(var10_10);
                                                var8_8 = 3;
                                                var16_16 = var7_7 != 0 ? var6_6.substring(var8_8) : var6_6;
                                                var11_11 = "List";
                                                var13_13 = (int)var16_16.endsWith((String)var11_11);
                                                var17_17 = 1;
                                                var18_18 = 1.4E-45f;
                                                if (var13_13 != 0 && (var13_13 = (int)var16_16.endsWith((String)(var12_12 = "OrBuilderList"))) == 0 && (var19_19 = var16_16.equals(var11_11)) == 0) {
                                                    var11_11 = String.valueOf(var16_16.substring(0, var17_17).toLowerCase());
                                                    var13_13 = var16_16.length() + -4;
                                                    var12_12 = String.valueOf(var16_16.substring(var17_17, var13_13));
                                                    var20_20 = var12_12.length();
                                                    if (var20_20 != 0) {
                                                        var11_11 = var11_11.concat((String)var12_12);
                                                    } else {
                                                        var12_12 = new String((String)var11_11);
                                                        var11_11 = var12_12;
                                                    }
                                                    var12_12 = (Method)var3_3.get(var6_6);
                                                    if (var12_12 != null && (var20_20 = (int)(var21_21 = var12_12.getReturnType()).equals(var22_22 = List.class)) != 0) {
                                                        var6_6 = zzjo.zzy(var11_11);
                                                        var16_16 = new Object[]{};
                                                        var16_16 = zzid.zza((Method)var12_12, var0, (Object[])var16_16);
                                                        zzjo.zza(var1_1, var2_2, (String)var6_6, var16_16);
                                                        continue;
                                                    }
                                                }
                                                if ((var13_13 = (int)var16_16.endsWith((String)(var11_11 = "Map"))) != 0 && (var19_19 = var16_16.equals(var11_11)) == 0) {
                                                    var11_11 = String.valueOf(var16_16.substring(0, var17_17).toLowerCase());
                                                    var13_13 = var16_16.length() - var8_8;
                                                    var9_9 = String.valueOf(var16_16.substring(var17_17, var13_13));
                                                    var9_9 = (var13_13 = var9_9.length()) != 0 ? var11_11.concat((String)var9_9) : new String((String)var11_11);
                                                    if ((var6_6 = (Method)var3_3.get(var6_6)) != null && (var19_19 = (int)(var11_11 = var6_6.getReturnType()).equals(var12_12 = Map.class)) != 0 && (var19_19 = (int)var6_6.isAnnotationPresent((Class<? extends Annotation>)(var11_11 = Deprecated.class))) == 0 && (var19_19 = (int)Modifier.isPublic(var6_6.getModifiers())) != 0) {
                                                        var16_16 = zzjo.zzy((String)var9_9);
                                                        var9_9 = new Object[]{};
                                                        var6_6 = zzid.zza((Method)var6_6, var0, (Object[])var9_9);
                                                        zzjo.zza(var1_1, var2_2, (String)var16_16, var6_6);
                                                        continue;
                                                    }
                                                }
                                                var6_6 = "set";
                                                var9_9 = String.valueOf(var16_16);
                                                var19_19 = var9_9.length();
                                                var6_6 = var19_19 != 0 ? var6_6.concat((String)var9_9) : (var9_9 = new String((String)var6_6));
                                                if ((var6_6 = (Method)var4_4.get(var6_6)) == null || (var15_15 = (int)var16_16.endsWith((String)(var6_6 = "Bytes"))) != 0 && (var15_15 = (int)var3_3.containsKey(var6_6 = (var8_8 = (var6_6 = String.valueOf(var16_16.substring(0, var15_15 = var16_16.length() + -5))).length()) != 0 ? var10_10.concat((String)var6_6) : new String(var10_10))) != 0) continue;
                                                var6_6 = String.valueOf(var16_16.substring(0, var17_17).toLowerCase());
                                                var9_9 = String.valueOf(var16_16.substring(var17_17));
                                                var19_19 = var9_9.length();
                                                var6_6 = var19_19 != 0 ? var6_6.concat((String)var9_9) : (var9_9 = new String((String)var6_6));
                                                var9_9 = String.valueOf(var16_16);
                                                var19_19 = var9_9.length();
                                                var9_9 = var19_19 != 0 ? var10_10.concat((String)var9_9) : new String(var10_10);
                                                var9_9 = (Method)var3_3.get(var9_9);
                                                var11_11 = "has";
                                                var16_16 = String.valueOf(var16_16);
                                                var13_13 = var16_16.length();
                                                var16_16 = var13_13 != 0 ? var11_11.concat((String)var16_16) : new String((String)var11_11);
                                                var16_16 = (Method)var3_3.get(var16_16);
                                                if (var9_9 == null) continue;
                                                var11_11 = new Object[]{};
                                                var9_9 = zzid.zza((Method)var9_9, var0, var11_11);
                                                if (var16_16 != null) break block19;
                                                var7_7 = var9_9 instanceof Boolean;
                                                if (var7_7 != 0) {
                                                    var16_16 = var9_9;
                                                    var16_16 = (Boolean)var9_9;
                                                    var7_7 = (int)var16_16.booleanValue();
                                                    if (var7_7 == 0) lbl-1000:
                                                    // 6 sources

                                                    {
                                                        while (true) {
                                                            var7_7 = var17_17;
                                                            var23_23 = var18_18;
                                                            break block18;
                                                            break;
                                                        }
                                                    }
lbl99:
                                                    // 8 sources

                                                    while (true) {
                                                        var7_7 = 0;
                                                        var16_16 = null;
                                                        var23_23 = 0.0f;
                                                        break block18;
                                                        break;
                                                    }
                                                }
                                                var7_7 = var9_9 instanceof Integer;
                                                if (var7_7 == 0) break block20;
                                                var16_16 = var9_9;
                                                var16_16 = (Integer)var9_9;
                                                var7_7 = var16_16.intValue();
                                                if (var7_7 != 0) ** GOTO lbl99
                                                ** GOTO lbl-1000
                                            }
                                            var7_7 = var9_9 instanceof Float;
                                            if (var7_7 == 0) break block21;
                                            var16_16 = var9_9;
                                            var16_16 = (Float)var9_9;
                                            var23_23 = var16_16.floatValue();
                                            var19_19 = 0;
                                            var11_11 = null;
                                            cfr_temp_0 = var23_23 - 0.0f;
                                            var7_7 = (int)(cfr_temp_0 == 0.0f ? 0 : (cfr_temp_0 > 0.0f ? 1 : -1));
                                            if (var7_7 != 0) ** GOTO lbl99
                                            ** GOTO lbl-1000
                                        }
                                        var7_7 = var9_9 instanceof Double;
                                        if (var7_7 == 0) break block22;
                                        var16_16 = var9_9;
                                        var16_16 = (Double)var9_9;
                                        var24_24 = var16_16.doubleValue();
                                        cfr_temp_1 = var24_24 - (var26_25 = 0.0);
                                        var7_7 = (int)(cfr_temp_1 == 0.0 ? 0 : (cfr_temp_1 > 0.0 ? 1 : -1));
                                        if (var7_7 != 0) ** GOTO lbl99
                                        ** GOTO lbl-1000
                                    }
                                    var7_7 = var9_9 instanceof String;
                                    if (var7_7 == 0) break block23;
                                    var16_16 = "";
                                    var7_7 = (int)var9_9.equals(var16_16);
                                    break block18;
                                }
                                var7_7 = var9_9 instanceof zzgs;
                                if (var7_7 == 0) break block24;
                                var16_16 = zzgs.zztt;
                                var7_7 = (int)var9_9.equals(var16_16);
                                break block18;
                            }
                            var7_7 = var9_9 instanceof zzjn;
                            if (var7_7 == 0) break block25;
                            var16_16 = var9_9;
                            var16_16 = ((zzjn)var9_9).zzgx();
                            if (var9_9 != var16_16) ** GOTO lbl99
                            ** GOTO lbl-1000
                        }
                        var7_7 = var9_9 instanceof Enum;
                        if (var7_7 == 0) ** GOTO lbl99
                        var16_16 = var9_9;
                        var16_16 = (Enum)var9_9;
                        var7_7 = var16_16.ordinal();
                        if (var7_7 == 0) ** break;
                        ** continue;
                        ** continue;
                    }
                    if (var7_7 != 0) {
                        var17_17 = 0;
                        var18_18 = 0.0f;
                    }
                    break block26;
                }
                var11_11 = new Object[]{};
                var16_16 = (Boolean)zzid.zza((Method)var16_16, var0, var11_11);
                var17_17 = (int)var16_16.booleanValue();
            }
            if (var17_17 == 0) continue;
            var6_6 = zzjo.zzy((String)var6_6);
            zzjo.zza(var1_1, var2_2, (String)var6_6, var9_9);
        }
        var28_26 = var0 instanceof zzid$zze;
        if (var28_26) {
            var3_3 = var0;
            var3_3 = ((zzid$zze)var0).zzyg.iterator();
            while (var29_27 = var3_3.hasNext()) {
                var4_4 = (Map.Entry)var3_3.next();
                var30_28 = ((zzid$zzd)var4_4.getKey()).number;
                var15_15 = 13;
                var16_16 = new StringBuilder(var15_15);
                var6_6 = "[";
                var16_16.append((String)var6_6);
                var16_16.append(var30_28);
                var16_16.append("]");
                var5_5 = var16_16.toString();
                var4_4 = var4_4.getValue();
                zzjo.zza(var1_1, var2_2, (String)var5_5, var4_4);
            }
        }
        if ((var0 = ((zzid)var0).zzxz) != null) {
            var0.zza(var1_1, var2_2);
        }
    }

    public static final void zza(StringBuilder stringBuilder, int n10, String string2, Object object) {
        char c10;
        int n11 = object instanceof List;
        if (n11 != 0) {
            object = ((List)object).iterator();
            while ((n11 = object.hasNext()) != 0) {
                Object e10 = object.next();
                zzjo.zza(stringBuilder, n10, string2, e10);
            }
            return;
        }
        n11 = object instanceof Map;
        if (n11 != 0) {
            object = ((Map)object).entrySet().iterator();
            while ((n11 = object.hasNext()) != 0) {
                Map.Entry entry = (Map.Entry)object.next();
                zzjo.zza(stringBuilder, n10, string2, entry);
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
            String string5 = zzkt.zzd(zzgs.zzv((String)object));
            stringBuilder.append(string5);
            stringBuilder.append(c11);
            return;
        }
        n12 = object instanceof zzgs;
        if (n12 != 0) {
            stringBuilder.append(string4);
            String string6 = zzkt.zzd((zzgs)object);
            stringBuilder.append(string6);
            stringBuilder.append(c11);
            return;
        }
        n12 = object instanceof zzid;
        string3 = "}";
        string4 = "\n";
        String string7 = " {";
        if (n12 != 0) {
            stringBuilder.append(string7);
            object = (zzid)object;
            n12 = n10 + 2;
            zzjo.zza((zzjn)object, stringBuilder, n12);
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
            zzjo.zza(stringBuilder, n12, string8, string7);
            object = object.getValue();
            string7 = "value";
            zzjo.zza(stringBuilder, n12, string7, object);
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

    private static final String zzy(String string2) {
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

