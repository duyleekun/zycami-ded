/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.database.sqlite.SQLiteDatabase
 *  android.database.sqlite.SQLiteException
 *  android.text.TextUtils
 */
package com.google.android.gms.measurement.internal;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import com.google.android.gms.measurement.internal.zzeg;
import com.google.android.gms.measurement.internal.zzei;
import java.io.File;
import java.util.Collections;
import java.util.HashSet;

public final class zzaj {
    /*
     * Loose catch block
     * WARNING - void declaration
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static void zza(zzei zzei2, SQLiteDatabase sQLiteDatabase, String string2, String sQLiteDatabase2, String string3, String[] stringArray) {
        block58: {
            void var10_17;
            SQLiteDatabase sQLiteDatabase3;
            block54: {
                int n10;
                Object object;
                String string4;
                Object object2;
                Object object3;
                int n11;
                String[] stringArray2;
                String string5;
                block59: {
                    block55: {
                        block53: {
                            int n12;
                            block52: {
                                string5 = string2;
                                stringArray2 = stringArray;
                                if (zzei2 == null) break block58;
                                n11 = 0;
                                sQLiteDatabase3 = null;
                                object3 = "name";
                                String[] stringArray3 = new String[]{object3};
                                n12 = 1;
                                String[] stringArray4 = new String[n12];
                                stringArray4[0] = string2;
                                object2 = "SQLITE_MASTER";
                                string4 = "name=?";
                                object = sQLiteDatabase;
                                object = sQLiteDatabase.query((String)object2, stringArray3, string4, stringArray4, null, null, null);
                                try {
                                    n12 = (int)(object.moveToFirst() ? 1 : 0);
                                    if (object == null) break block52;
                                }
                                catch (SQLiteException sQLiteException) {
                                    break block53;
                                }
                                object.close();
                            }
                            if (n12 != 0) break block59;
                            break block55;
                            catch (Throwable throwable) {
                                break block54;
                            }
                            catch (SQLiteException sQLiteException) {
                                n10 = 0;
                                object = null;
                            }
                        }
                        object2 = zzei2.zze();
                        String string6 = "Error querying for table";
                        ((zzeg)object2).zzc(string6, string5, object3);
                        if (object == null) break block55;
                        object.close();
                    }
                    object = sQLiteDatabase2;
                    sQLiteDatabase.execSQL((String)sQLiteDatabase2);
                }
                object3 = new HashSet();
                n10 = string2.length() + 22;
                object2 = new StringBuilder(n10);
                object = "SELECT * FROM ";
                ((StringBuilder)object2).append((String)object);
                ((StringBuilder)object2).append(string5);
                object = " LIMIT 0";
                ((StringBuilder)object2).append((String)object);
                object = ((StringBuilder)object2).toString();
                object = sQLiteDatabase.rawQuery((String)object, null);
                object2 = object.getColumnNames();
                Collections.addAll(object3, object2);
                object.close();
                object = ",";
                object2 = string3;
                object = string3.split((String)object);
                int n13 = ((String[])object).length;
                Object var11_22 = null;
                for (int i10 = 0; i10 < n13; ++i10) {
                    block56: {
                        string4 = object[i10];
                        boolean bl2 = object3.remove(string4);
                        if (!bl2) break block56;
                        continue;
                    }
                    n10 = string2.length() + 35;
                    object2 = String.valueOf(string4);
                    n13 = ((String)object2).length();
                    n10 += n13;
                    object2 = new StringBuilder(n10);
                    object = "Table ";
                    ((StringBuilder)object2).append((String)object);
                    ((StringBuilder)object2).append(string5);
                    object = " is missing required column: ";
                    ((StringBuilder)object2).append((String)object);
                    ((StringBuilder)object2).append(string4);
                    object = ((StringBuilder)object2).toString();
                    object3 = new SQLiteException((String)object);
                    throw object3;
                }
                if (stringArray2 != null) {
                    while (true) {
                        block57: {
                            n10 = stringArray2.length;
                            if (n11 >= n10) break;
                            object = stringArray2[n11];
                            n10 = (int)(object3.remove(object) ? 1 : 0);
                            if (n10 != 0) break block57;
                            n10 = n11 + 1;
                            object = stringArray2[n10];
                            sQLiteDatabase.execSQL((String)object);
                        }
                        n11 += 2;
                    }
                }
                n10 = (int)(object3.isEmpty() ? 1 : 0);
                if (n10 != 0) return;
                {
                    catch (SQLiteException sQLiteException) {
                        zzei2.zzb().zzb("Failed to verify columns on table that was just created", string5);
                        throw sQLiteException;
                    }
                }
                object = zzei2.zze();
                object2 = "Table has extra columns. table, columns";
                String string7 = ", ";
                object3 = TextUtils.join((CharSequence)string7, (Iterable)object3);
                ((zzeg)object).zzc((String)object2, string5, object3);
                return;
                catch (Throwable throwable) {
                    object.close();
                    throw throwable;
                }
                catch (Throwable throwable) {
                    sQLiteDatabase3 = object;
                }
            }
            if (sQLiteDatabase3 == null) throw var10_17;
            sQLiteDatabase3.close();
            throw var10_17;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Monitor must not be null");
        throw illegalArgumentException;
    }

    public static void zzb(zzei object, SQLiteDatabase object2) {
        if (object != null) {
            String string2;
            Object object3;
            object2 = object2.getPath();
            File file = new File((String)object2);
            boolean bl2 = false;
            object2 = null;
            boolean bl3 = file.setReadable(false, false);
            if (!bl3) {
                object3 = ((zzei)object).zze();
                string2 = "Failed to turn off database read permission";
                ((zzeg)object3).zza(string2);
            }
            if (!(bl2 = file.setWritable(false, false))) {
                object2 = ((zzei)object).zze();
                object3 = "Failed to turn off database write permission";
                ((zzeg)object2).zza((String)object3);
            }
            if (!(bl3 = file.setReadable(bl2 = true, bl2))) {
                object3 = ((zzei)object).zze();
                string2 = "Failed to turn on database read permission for owner";
                ((zzeg)object3).zza(string2);
            }
            if (!(bl2 = file.setWritable(bl2, bl2))) {
                object = ((zzei)object).zze();
                object2 = "Failed to turn on database write permission for owner";
                ((zzeg)object).zza((String)object2);
            }
            return;
        }
        object = new IllegalArgumentException("Monitor must not be null");
        throw object;
    }
}

