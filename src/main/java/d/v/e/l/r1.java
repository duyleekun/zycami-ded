/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package d.v.e.l;

import android.content.Context;
import com.zhiyun.common.util.Times;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import m.a.a$b;

public class r1
extends a$b {
    private static final int g = 5;
    public static final String h = "yyyy-MM-dd HH:mm:ss.SSS";
    private static final String i = "timber_log.txt";
    private FileOutputStream f;

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public r1(Context object) {
        try {
            object = object.getApplicationContext();
        }
        catch (FileNotFoundException fileNotFoundException) {
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        object = object.getExternalFilesDir(null);
        object = ((File)object).getAbsolutePath();
        stringBuilder.append((String)object);
        object = "/";
        stringBuilder.append((String)object);
        object = i;
        stringBuilder.append((String)object);
        object = stringBuilder.toString();
        FileOutputStream fileOutputStream = new FileOutputStream((String)object);
        this.f = fileOutputStream;
    }

    private String D(int n10) {
        String string2;
        switch (n10) {
            default: {
                string2 = "";
                break;
            }
            case 7: {
                string2 = "A";
                break;
            }
            case 6: {
                string2 = "E";
                break;
            }
            case 5: {
                string2 = "W";
                break;
            }
            case 4: {
                string2 = "I";
                break;
            }
            case 3: {
                string2 = "D";
                break;
            }
            case 2: {
                string2 = "V";
            }
        }
        return string2;
    }

    public final String E(String object) {
        int n10;
        if (object != null) {
            return object;
        }
        object = new Throwable();
        int n11 = ((StackTraceElement[])(object = object.getStackTrace())).length;
        if (n11 > (n10 = 5)) {
            object = object[n10];
            return this.C((StackTraceElement)object);
        }
        object = new IllegalStateException("Synthetic stacktrace didn't have enough elements: are you using proguard?");
        throw object;
    }

    public void o(int n10, String object, String string2, Throwable object2) {
        object2 = this.f;
        if (object2 != null) {
            object2 = new StringBuilder();
            String string3 = h;
            string3 = Times.getDate(string3);
            ((StringBuilder)object2).append(string3);
            string3 = "/ ";
            ((StringBuilder)object2).append(string3);
            Object object3 = this.D(n10);
            ((StringBuilder)object2).append((String)object3);
            object3 = "/";
            ((StringBuilder)object2).append((String)object3);
            object3 = this.E((String)object);
            ((StringBuilder)object2).append((String)object3);
            object3 = ": ";
            ((StringBuilder)object2).append((String)object3);
            ((StringBuilder)object2).append(string2);
            object3 = ((StringBuilder)object2).toString();
            object = this.f;
            object3 = ((String)object3).getBytes();
            try {
                ((FileOutputStream)object).write((byte[])object3);
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
            }
        }
    }
}

