/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.PackageManager
 *  android.content.pm.PackageManager$NameNotFoundException
 */
package com.huawei.hms.push;

import android.content.Context;
import android.content.pm.PackageManager;
import com.huawei.hms.support.log.HMSLog;
import java.lang.reflect.Field;

public class r {
    public static int a(Context object, String string2) {
        block6: {
            PackageManager packageManager = object.getPackageManager();
            object = object.getPackageName();
            int n10 = 128;
            object = packageManager.getApplicationInfo((String)object, n10);
            if (object == null) break block6;
            object = object.metaData;
            if (object == null) break block6;
            try {
                return object.getInt(string2);
            }
            catch (PackageManager.NameNotFoundException nameNotFoundException) {
                object = "ResourceLoader";
                string2 = "load meta data resource failed.";
                HMSLog.w((String)object, string2);
            }
        }
        return 0;
    }

    public static int a(Context object, String string2, String string3) {
        block29: {
            int n10;
            block28: {
                String string4 = "ResourceLoader";
                String string5 = "--resourceName=";
                Object object2 = object.getResources();
                String string6 = object.getPackageName();
                n10 = object2.getIdentifier(string3, string2, string6);
                if (n10 != 0) break block28;
                object2 = new StringBuilder();
                object = object.getPackageName();
                ((StringBuilder)object2).append((String)object);
                object = ".R$";
                ((StringBuilder)object2).append((String)object);
                ((StringBuilder)object2).append(string2);
                object = ((StringBuilder)object2).toString();
                object = Class.forName((String)object);
                object = ((Class)object).getField(string3);
                object2 = ((Field)object).getName();
                object = ((Field)object).get(object2);
                object = object.toString();
                n10 = Integer.parseInt((String)object);
                if (n10 != 0) break block28;
                object = new StringBuilder();
                string6 = "Error-resourceType=";
                ((StringBuilder)object).append(string6);
                ((StringBuilder)object).append(string2);
                ((StringBuilder)object).append(string5);
                ((StringBuilder)object).append(string3);
                string6 = "--resourceId =";
                ((StringBuilder)object).append(string6);
                ((StringBuilder)object).append(n10);
                object = ((StringBuilder)object).toString();
                try {
                    HMSLog.i(string4, (String)object);
                }
                catch (IllegalArgumentException illegalArgumentException) {
                    object2 = new StringBuilder();
                    string6 = "!!!! ResourceLoader: IllegalArgumentException-resourceType=";
                    ((StringBuilder)object2).append(string6);
                    ((StringBuilder)object2).append(string2);
                    ((StringBuilder)object2).append(string5);
                    ((StringBuilder)object2).append(string3);
                    string2 = ((StringBuilder)object2).toString();
                    HMSLog.e(string4, string2, illegalArgumentException);
                    break block29;
                }
                catch (IllegalAccessException illegalAccessException) {
                    object2 = new StringBuilder();
                    string6 = "!!!! ResourceLoader: IllegalAccessException-resourceType=";
                    ((StringBuilder)object2).append(string6);
                    ((StringBuilder)object2).append(string2);
                    ((StringBuilder)object2).append(string5);
                    ((StringBuilder)object2).append(string3);
                    string2 = ((StringBuilder)object2).toString();
                    HMSLog.e(string4, string2, illegalAccessException);
                    break block29;
                }
                catch (NumberFormatException numberFormatException) {
                    object2 = new StringBuilder();
                    string6 = "!!!! ResourceLoader: NumberFormatException-resourceType=";
                    ((StringBuilder)object2).append(string6);
                    ((StringBuilder)object2).append(string2);
                    ((StringBuilder)object2).append(string5);
                    ((StringBuilder)object2).append(string3);
                    string2 = ((StringBuilder)object2).toString();
                    HMSLog.e(string4, string2, numberFormatException);
                    break block29;
                }
                catch (NoSuchFieldException noSuchFieldException) {
                    object2 = new StringBuilder();
                    string6 = "!!!! ResourceLoader: NoSuchFieldException-resourceType=";
                    ((StringBuilder)object2).append(string6);
                    ((StringBuilder)object2).append(string2);
                    ((StringBuilder)object2).append(string5);
                    ((StringBuilder)object2).append(string3);
                    string2 = ((StringBuilder)object2).toString();
                    HMSLog.e(string4, string2, noSuchFieldException);
                    break block29;
                }
                catch (ClassNotFoundException classNotFoundException) {
                    object2 = new StringBuilder();
                    string6 = "!!!! ResourceLoader: ClassNotFoundException-resourceType=";
                    ((StringBuilder)object2).append(string6);
                    ((StringBuilder)object2).append(string2);
                    ((StringBuilder)object2).append(string5);
                    ((StringBuilder)object2).append(string3);
                    string2 = ((StringBuilder)object2).toString();
                    HMSLog.e(string4, string2, classNotFoundException);
                }
            }
            return n10;
        }
        return 0;
    }
}

