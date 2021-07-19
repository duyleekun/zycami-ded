/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap$CompressFormat
 *  com.mob.tools.utils.BitmapHelper
 */
package com.mob.tools.utils;

import android.graphics.Bitmap;
import com.mob.tools.network.HttpConnection;
import com.mob.tools.network.HttpResponseCallback;
import com.mob.tools.utils.BitmapHelper;
import com.mob.tools.utils.BitmapHelper$1$1;
import com.mob.tools.utils.Hashon;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.HashMap;

public final class BitmapHelper$1
implements HttpResponseCallback {
    public final /* synthetic */ HashMap val$buffer;
    public final /* synthetic */ String val$imageUrl;
    public final /* synthetic */ String val$path;

    public BitmapHelper$1(String string2, String string3, HashMap hashMap) {
        this.val$imageUrl = string2;
        this.val$path = string3;
        this.val$buffer = hashMap;
    }

    public void onResponse(HttpConnection object) {
        int n10;
        int n11 = object.getResponseCode();
        if (n11 == (n10 = 200)) {
            String string2 = this.val$imageUrl;
            string2 = BitmapHelper.access$000((HttpConnection)object, (String)string2);
            Object object2 = this.val$path;
            Object object3 = new File((String)object2, string2);
            boolean bl2 = ((File)(object2 = ((File)object3).getParentFile())).exists();
            if (!bl2) {
                object2 = ((File)object3).getParentFile();
                ((File)object2).mkdirs();
            }
            if (bl2 = ((File)object3).exists()) {
                ((File)object3).delete();
            }
            try {
                object = object.getInputStream();
            }
            catch (Throwable throwable) {
                n11 = (int)(((File)object3).exists() ? 1 : 0);
                if (n11 != 0) {
                    ((File)object3).delete();
                }
                throw throwable;
            }
            object2 = new BitmapHelper$1$1(this, (InputStream)object);
            int n12 = 1;
            object = BitmapHelper.getBitmap((InputStream)object2, (int)n12);
            if (object != null && !(bl2 = object.isRecycled())) {
                String string3;
                object2 = new FileOutputStream((File)object3);
                String string4 = string2.toLowerCase();
                int n13 = string4.endsWith(string3 = ".gif");
                if (n13 == 0 && (n11 = (int)((string2 = string2.toLowerCase()).endsWith(string4 = ".png") ? 1 : 0)) == 0) {
                    string2 = Bitmap.CompressFormat.JPEG;
                    n13 = 80;
                    object.compress((Bitmap.CompressFormat)string2, n13, (OutputStream)object2);
                } else {
                    string2 = Bitmap.CompressFormat.PNG;
                    n13 = 100;
                    object.compress((Bitmap.CompressFormat)string2, n13, (OutputStream)object2);
                }
                ((OutputStream)object2).flush();
                ((FileOutputStream)object2).close();
                object = this.val$buffer;
                string2 = ((File)object3).getAbsolutePath();
                object3 = "bitmap";
                ((HashMap)object).put(object3, string2);
            }
            return;
        }
        Object object4 = new StringBuilder();
        object = object.getErrorStream();
        Charset charset = Charset.forName("utf-8");
        Object object5 = new InputStreamReader((InputStream)object, charset);
        object = new BufferedReader((Reader)object5);
        object5 = ((BufferedReader)object).readLine();
        while (object5 != null) {
            int n14 = ((StringBuilder)object4).length();
            if (n14 > 0) {
                n14 = 10;
                ((StringBuilder)object4).append((char)n14);
            }
            ((StringBuilder)object4).append((String)object5);
            object5 = ((BufferedReader)object).readLine();
        }
        ((BufferedReader)object).close();
        object = new HashMap();
        object4 = ((StringBuilder)object4).toString();
        ((HashMap)object).put("error", object4);
        Serializable serializable = n11;
        ((HashMap)object).put("status", serializable);
        object4 = new Hashon();
        object = ((Hashon)object4).fromHashMap((HashMap)object);
        serializable = new Throwable((String)object);
        throw serializable;
    }
}

