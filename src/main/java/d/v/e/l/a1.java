/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.net.Uri
 *  android.os.Build$VERSION
 */
package d.v.e.l;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import androidx.core.content.FileProvider;
import d.v.e.l.d1;
import java.io.File;
import java.io.IOException;

public class a1 {
    private static void a(String string2, String string3) {
        Object object = "chmod 777 ";
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append((String)object);
        stringBuilder.append(string2);
        string2 = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append((String)object);
        stringBuilder.append(string3);
        string3 = stringBuilder.toString();
        object = Runtime.getRuntime();
        ((Runtime)object).exec(string2);
        try {
            ((Runtime)object).exec(string3);
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }

    public static void b(Context context, String string2, String string3) {
        a1.a(string2, string3);
        Object object = "android.intent.action.VIEW";
        string2 = new Intent((String)object);
        int n10 = Build.VERSION.SDK_INT;
        String string4 = "application/vnd.android.package-archive";
        int n11 = 24;
        if (n10 >= n11) {
            n10 = 1;
            string2.setFlags(n10);
            object = new StringBuilder();
            Object object2 = d1.d();
            ((StringBuilder)object).append((String)object2);
            ((StringBuilder)object).append(".provider");
            object = ((StringBuilder)object).toString();
            object2 = new File(string3);
            string3 = FileProvider.getUriForFile(context, (String)object, (File)object2);
            string2.setDataAndType((Uri)string3, string4);
        } else {
            object = new File(string3);
            string3 = Uri.fromFile((File)object);
            string2.setDataAndType((Uri)string3, string4);
        }
        string2.addFlags(0x10000000);
        context.startActivity((Intent)string2);
    }
}

