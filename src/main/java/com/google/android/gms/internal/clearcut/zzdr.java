/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.zzbb;
import com.google.android.gms.internal.clearcut.zzcg;
import com.google.android.gms.internal.clearcut.zzcg$zzd;
import com.google.android.gms.internal.clearcut.zzcg$zze;
import com.google.android.gms.internal.clearcut.zzdo;
import com.google.android.gms.internal.clearcut.zzet;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public final class zzdr {
    public static String zza(zzdo zzdo2, String string2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("# ");
        stringBuilder.append(string2);
        zzdr.zza(zzdo2, stringBuilder, 0);
        return stringBuilder.toString();
    }

    /*
     * Unable to fully structure code
     */
    private static void zza(zzdo var0, StringBuilder var1_1, int var2_2) {
        var3_3 = var0;
        var4_4 = var1_1;
        var5_5 = var2_2;
        var6_6 = new HashMap();
        var7_7 = new HashMap();
        var8_8 = new TreeSet();
        var9_9 = var0.getClass().getDeclaredMethods();
        var10_10 = ((Method[])var9_9).length;
        var11_11 = 0;
        var12_12 = null;
        while (true) {
            var13_13 = "get";
            if (var11_11 >= var10_10) break;
            var14_14 = var9_9[var11_11];
            var15_15 = var14_14.getName();
            var7_7.put(var15_15, var14_14);
            var15_15 = var14_14.getParameterTypes();
            var16_16 = ((Class<?>[])var15_15).length;
            if (var16_16 == 0) {
                var15_15 = var14_14.getName();
                var6_6.put(var15_15, var14_14);
                var15_15 = var14_14.getName();
                var17_17 = var15_15.startsWith(var13_13);
                if (var17_17) {
                    var13_13 = var14_14.getName();
                    var8_8.add(var13_13);
                }
            }
            ++var11_11;
        }
        var8_8 = var8_8.iterator();
        while ((var18_18 = var8_8.hasNext()) != 0) {
            block25: {
                block20: {
                    block19: {
                        block24: {
                            block23: {
                                block22: {
                                    block21: {
                                        var9_9 = (String)var8_8.next();
                                        var19_19 = "";
                                        var12_12 = var9_9.replaceFirst(var13_13, (String)var19_19);
                                        var14_14 = "List";
                                        var16_16 = (int)var12_12.endsWith((String)var14_14);
                                        var20_20 = 1;
                                        var21_21 = 1.4E-45f;
                                        if (var16_16 != 0 && (var16_16 = (int)var12_12.endsWith((String)(var15_15 = "OrBuilderList"))) == 0 && (var22_22 = var12_12.equals(var14_14)) == 0) {
                                            var14_14 = String.valueOf(var12_12.substring(0, var20_20).toLowerCase());
                                            var16_16 = var12_12.length() + -4;
                                            var15_15 = String.valueOf(var12_12.substring(var20_20, var16_16));
                                            var23_23 = var15_15.length();
                                            var14_14 = var23_23 != 0 ? var14_14.concat((String)var15_15) : (var15_15 = new String((String)var14_14));
                                            var15_15 = (Method)var6_6.get(var9_9);
                                            if (var15_15 != null && (var23_23 = (int)(var24_24 = var15_15.getReturnType()).equals(var25_25 = List.class)) != 0) {
                                                var9_9 = zzdr.zzj((String)var14_14);
                                                var19_19 = new Object[]{};
                                                var19_19 = zzcg.zza((Method)var15_15, var3_3, (Object[])var19_19);
                                                zzdr.zza(var4_4, var5_5, (String)var9_9, var19_19);
                                                continue;
                                            }
                                        }
                                        if ((var16_16 = (int)var12_12.endsWith((String)(var14_14 = "Map"))) != 0 && (var22_22 = var12_12.equals(var14_14)) == 0) {
                                            var14_14 = String.valueOf(var12_12.substring(0, var20_20).toLowerCase());
                                            var16_16 = var12_12.length() + -3;
                                            var15_15 = String.valueOf(var12_12.substring(var20_20, var16_16));
                                            var23_23 = var15_15.length();
                                            var14_14 = var23_23 != 0 ? var14_14.concat((String)var15_15) : (var15_15 = new String((String)var14_14));
                                            if ((var9_9 = (Method)var6_6.get(var9_9)) != null && (var16_16 = (int)(var15_15 = var9_9.getReturnType()).equals(var24_24 = Map.class)) != 0 && (var16_16 = (int)var9_9.isAnnotationPresent((Class<? extends Annotation>)(var15_15 = Deprecated.class))) == 0 && (var16_16 = (int)Modifier.isPublic(var9_9.getModifiers())) != 0) {
                                                var19_19 = zzdr.zzj((String)var14_14);
                                                var12_12 = new Object[]{};
                                                var9_9 = zzcg.zza((Method)var9_9, var3_3, (Object[])var12_12);
                                                zzdr.zza(var4_4, var5_5, (String)var19_19, var9_9);
                                                continue;
                                            }
                                        }
                                        var9_9 = "set";
                                        var14_14 = String.valueOf(var12_12);
                                        var16_16 = var14_14.length();
                                        var9_9 = var16_16 != 0 ? var9_9.concat((String)var14_14) : (var14_14 = new String((String)var9_9));
                                        if ((var9_9 = (Method)var7_7.get(var9_9)) == null || (var18_18 = (int)var12_12.endsWith((String)(var9_9 = "Bytes"))) != 0 && (var18_18 = (int)var6_6.containsKey(var9_9 = (var22_22 = (var9_9 = String.valueOf(var12_12.substring(0, var18_18 = var12_12.length() + -5))).length()) != 0 ? var13_13.concat((String)var9_9) : new String(var13_13))) != 0) continue;
                                        var9_9 = String.valueOf(var12_12.substring(0, var20_20).toLowerCase());
                                        var14_14 = String.valueOf(var12_12.substring(var20_20));
                                        var16_16 = var14_14.length();
                                        var9_9 = var16_16 != 0 ? var9_9.concat((String)var14_14) : (var14_14 = new String((String)var9_9));
                                        var14_14 = String.valueOf(var12_12);
                                        var16_16 = var14_14.length();
                                        var14_14 = var16_16 != 0 ? var13_13.concat((String)var14_14) : new String(var13_13);
                                        var14_14 = (Method)var6_6.get(var14_14);
                                        var15_15 = "has";
                                        var12_12 = String.valueOf(var12_12);
                                        var23_23 = var12_12.length();
                                        var12_12 = var23_23 != 0 ? var15_15.concat((String)var12_12) : new String((String)var15_15);
                                        var12_12 = (Method)var6_6.get(var12_12);
                                        if (var14_14 == null) continue;
                                        var15_15 = new Object[]{};
                                        var14_14 = zzcg.zza((Method)var14_14, var3_3, (Object[])var15_15);
                                        if (var12_12 != null) break block20;
                                        var11_11 = var14_14 instanceof Boolean;
                                        if (var11_11 != 0) {
                                            var19_19 = var14_14;
                                            var19_19 = (Boolean)var14_14;
                                            var10_10 = (int)var19_19.booleanValue();
                                            if (var10_10 == 0) lbl-1000:
                                            // 6 sources

                                            {
                                                while (true) {
                                                    var10_10 = var20_20;
                                                    var26_26 = var21_21;
                                                    break block19;
                                                    break;
                                                }
                                            }
lbl98:
                                            // 8 sources

                                            while (true) {
                                                var10_10 = 0;
                                                var19_19 = null;
                                                var26_26 = 0.0f;
                                                break block19;
                                                break;
                                            }
                                        }
                                        var11_11 = var14_14 instanceof Integer;
                                        if (var11_11 == 0) break block21;
                                        var19_19 = var14_14;
                                        var19_19 = (Integer)var14_14;
                                        var10_10 = var19_19.intValue();
                                        if (var10_10 != 0) ** GOTO lbl98
                                        ** GOTO lbl-1000
                                    }
                                    var11_11 = var14_14 instanceof Float;
                                    if (var11_11 == 0) break block22;
                                    var19_19 = var14_14;
                                    var19_19 = (Float)var14_14;
                                    var26_26 = var19_19.floatValue();
                                    var11_11 = 0;
                                    var12_12 = null;
                                    cfr_temp_0 = var26_26 - 0.0f;
                                    var10_10 = (int)(cfr_temp_0 == 0.0f ? 0 : (cfr_temp_0 > 0.0f ? 1 : -1));
                                    if (var10_10 != 0) ** GOTO lbl98
                                    ** GOTO lbl-1000
                                }
                                var11_11 = var14_14 instanceof Double;
                                if (var11_11 == 0) break block23;
                                var19_19 = var14_14;
                                var19_19 = (Double)var14_14;
                                var27_27 = var19_19.doubleValue();
                                cfr_temp_1 = var27_27 - (var29_28 = 0.0);
                                var10_10 = (int)(cfr_temp_1 == 0.0 ? 0 : (cfr_temp_1 > 0.0 ? 1 : -1));
                                if (var10_10 != 0) ** GOTO lbl98
                                ** GOTO lbl-1000
                            }
                            var11_11 = var14_14 instanceof String;
                            if (var11_11 != 0) lbl-1000:
                            // 2 sources

                            {
                                while (true) {
                                    var10_10 = (int)var14_14.equals(var19_19);
                                    break block19;
                                    break;
                                }
                            }
                            var10_10 = var14_14 instanceof zzbb;
                            if (var10_10 != 0) {
                                var19_19 = zzbb.zzfi;
                                ** continue;
                            }
                            var10_10 = var14_14 instanceof zzdo;
                            if (var10_10 == 0) break block24;
                            var19_19 = var14_14;
                            var19_19 = ((zzdo)var14_14).zzbe();
                            if (var14_14 != var19_19) ** GOTO lbl98
                            ** GOTO lbl-1000
                        }
                        var10_10 = var14_14 instanceof Enum;
                        if (var10_10 == 0) ** GOTO lbl98
                        var19_19 = var14_14;
                        var19_19 = (Enum)var14_14;
                        var10_10 = var19_19.ordinal();
                        if (var10_10 == 0) ** break;
                        ** continue;
                        ** continue;
                    }
                    if (var10_10 != 0) {
                        var20_20 = 0;
                        var21_21 = 0.0f;
                    }
                    break block25;
                }
                var19_19 = new Object[]{};
                var19_19 = (Boolean)zzcg.zza((Method)var12_12, var3_3, (Object[])var19_19);
                var20_20 = (int)var19_19.booleanValue();
            }
            if (var20_20 == 0) continue;
            var9_9 = zzdr.zzj((String)var9_9);
            zzdr.zza(var4_4, var5_5, (String)var9_9, var14_14);
        }
        var31_29 = var3_3 instanceof zzcg$zzd;
        if (var31_29) {
            var6_6 = var3_3;
            var6_6 = ((zzcg$zzd)var3_3).zzjv.iterator();
            while (var32_30 = var6_6.hasNext()) {
                var7_7 = (Map.Entry)var6_6.next();
                var33_31 = ((zzcg$zze)var7_7.getKey()).number;
                var18_18 = 13;
                var19_19 = new StringBuilder(var18_18);
                var9_9 = "[";
                var19_19.append((String)var9_9);
                var19_19.append(var33_31);
                var19_19.append("]");
                var8_8 = var19_19.toString();
                var7_7 = var7_7.getValue();
                zzdr.zza(var4_4, var5_5, (String)var8_8, var7_7);
            }
        }
        if ((var3_3 = ((zzcg)var3_3).zzjp) != null) {
            var3_3.zza(var4_4, var5_5);
        }
    }

    public static final void zza(StringBuilder stringBuilder, int n10, String string2, Object object) {
        char c10;
        int n11 = object instanceof List;
        if (n11 != 0) {
            object = ((List)object).iterator();
            while ((n11 = object.hasNext()) != 0) {
                Object e10 = object.next();
                zzdr.zza(stringBuilder, n10, string2, e10);
            }
            return;
        }
        n11 = object instanceof Map;
        if (n11 != 0) {
            object = ((Map)object).entrySet().iterator();
            while ((n11 = object.hasNext()) != 0) {
                Map.Entry entry = (Map.Entry)object.next();
                zzdr.zza(stringBuilder, n10, string2, entry);
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
            String string5 = zzet.zzc(zzbb.zzf((String)object));
            stringBuilder.append(string5);
            stringBuilder.append(c11);
            return;
        }
        n12 = object instanceof zzbb;
        if (n12 != 0) {
            stringBuilder.append(string4);
            String string6 = zzet.zzc((zzbb)object);
            stringBuilder.append(string6);
            stringBuilder.append(c11);
            return;
        }
        n12 = object instanceof zzcg;
        string3 = "}";
        string4 = "\n";
        String string7 = " {";
        if (n12 != 0) {
            stringBuilder.append(string7);
            object = (zzcg)object;
            n12 = n10 + 2;
            zzdr.zza((zzdo)object, stringBuilder, n12);
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
            zzdr.zza(stringBuilder, n12, string8, string7);
            object = object.getValue();
            string7 = "value";
            zzdr.zza(stringBuilder, n12, string7, object);
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

    private static final String zzj(String string2) {
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

