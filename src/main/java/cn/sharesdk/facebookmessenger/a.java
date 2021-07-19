/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.mob.tools.utils.BitmapHelper
 */
package cn.sharesdk.facebookmessenger;

import android.content.Context;
import cn.sharesdk.facebookmessenger.b;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import com.mob.MobSDK;
import com.mob.tools.utils.BitmapHelper;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

public class a {
    private static a a;
    private String b;
    private Platform c;

    public static a a() {
        a a10 = a;
        if (a10 == null) {
            a = a10 = new a();
        }
        return a;
    }

    public String a(String object) {
        boolean bl2;
        boolean bl3;
        boolean bl4;
        Object object2;
        String string2 = ((String)object).toLowerCase();
        boolean n10 = string2.endsWith((String)(object2 = ".png"));
        if (!(n10 || (bl4 = string2.endsWith((String)(object2 = ".jpg"))) || (bl3 = string2.endsWith((String)(object2 = ".jpeg"))) || (bl2 = string2.endsWith((String)(object2 = ".bmp"))))) {
            string2 = BitmapHelper.getMime((String)object);
            object2 = new StringBuilder();
            ((StringBuilder)object2).append((String)object);
            Object object3 = ".";
            ((StringBuilder)object2).append((String)object3);
            ((StringBuilder)object2).append(string2);
            string2 = ((StringBuilder)object2).toString();
            object2 = new File(string2);
            boolean bl5 = ((File)object2).exists();
            if (!bl5) {
                int n11;
                int n12 = 1024;
                object2 = new byte[n12];
                object3 = new File((String)object);
                object = new File(string2);
                FileInputStream fileInputStream = new FileInputStream((File)object3);
                object3 = new FileOutputStream((File)object);
                object = null;
                int n13 = 0;
                while (n13 != (n11 = -1)) {
                    ((OutputStream)object3).write((byte[])object2, 0, n13);
                    n13 = ((InputStream)fileInputStream).read((byte[])object2);
                }
                ((InputStream)fileInputStream).close();
                ((OutputStream)object3).close();
            }
            object = string2;
        }
        return object;
    }

    public void a(Platform platform, String string2) {
        this.b = string2;
        this.c = platform;
    }

    public void a(String string2, int n10, PlatformActionListener platformActionListener, String string3, String string4, String string5, String string6, List list, String string7) {
        b b10 = new b();
        Object object = this.c;
        String string8 = this.b;
        b10.a((Platform)object, string8);
        object = platformActionListener;
        b10.a(platformActionListener);
        object = b10;
        string8 = string2;
        b10.a(string2, n10, string3, string4, string5, string6, list, string7);
        object = MobSDK.getContext();
        b10.show((Context)object, null);
    }
}

