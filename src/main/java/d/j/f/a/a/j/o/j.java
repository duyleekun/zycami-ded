/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.pm.PackageInfo
 *  android.content.pm.PackageManager$NameNotFoundException
 */
package d.j.f.a.a.j.o;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import d.j.f.a.a.j.o.e;
import d.j.f.a.a.j.o.i;

public class j {
    private static final String a = "h";

    public static String a(String string2) {
        Object object = e.a();
        String string3 = "";
        if (object == null) {
            return string3;
        }
        object = object.getPackageManager();
        StringBuilder stringBuilder = null;
        string2 = object.getPackageInfo(string2, 0);
        try {
            return ((PackageInfo)string2).versionName;
        }
        catch (Throwable throwable) {
            string2 = a;
            object = "throwable";
            i.d(string2, (String)object);
        }
        catch (Exception exception) {
            object = a;
            stringBuilder = new StringBuilder();
            String string4 = "getVersion: ";
            stringBuilder.append(string4);
            String string5 = exception.getMessage();
            stringBuilder.append(string5);
            string5 = stringBuilder.toString();
            i.d((String)object, string5);
        }
        catch (PackageManager.NameNotFoundException nameNotFoundException) {
            object = a;
            stringBuilder = new StringBuilder();
            String string6 = "getVersion NameNotFoundException : ";
            stringBuilder.append(string6);
            String string7 = nameNotFoundException.getMessage();
            stringBuilder.append(string7);
            string7 = stringBuilder.toString();
            i.d((String)object, string7);
        }
        return string3;
    }

    public static int b(String string2) {
        Object object = e.a();
        if (object == null) {
            return 0;
        }
        object = object.getPackageManager();
        string2 = object.getPackageInfo(string2, 0);
        try {
            return ((PackageInfo)string2).versionCode;
        }
        catch (Exception exception) {
            object = a;
            StringBuilder stringBuilder = new StringBuilder();
            String string3 = "getVersion: ";
            stringBuilder.append(string3);
            String string4 = exception.getMessage();
            stringBuilder.append(string4);
            string4 = stringBuilder.toString();
            i.d((String)object, string4);
        }
        catch (PackageManager.NameNotFoundException nameNotFoundException) {
            string2 = a;
            object = "getVersion NameNotFoundException";
            i.d(string2, (String)object);
        }
        return 0;
    }
}

