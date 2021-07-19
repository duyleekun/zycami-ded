/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  android.net.Uri$Builder
 *  android.text.TextUtils
 */
package com.huawei.updatesdk.fileprovider;

import android.net.Uri;
import android.text.TextUtils;
import com.huawei.updatesdk.fileprovider.a;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class b
implements a {
    private final String a;
    private final HashMap b;

    public b(String string2) {
        HashMap hashMap;
        this.b = hashMap = new HashMap();
        this.a = string2;
    }

    public Uri a(File object) {
        Map.Entry entry;
        boolean bl2;
        Object object2;
        Object object3;
        try {
            object = ((File)object).getCanonicalPath();
            object3 = null;
            object2 = this.b.entrySet().iterator();
        }
        catch (Exception exception) {
            object = new IllegalArgumentException("Failed to resolve canonical path for wisedist");
            throw object;
        }
        while (bl2 = object2.hasNext()) {
            String string2;
            int n10;
            entry = object2.next();
            String string3 = ((File)entry.getValue()).getPath();
            int n11 = ((String)object).startsWith(string3);
            if (n11 == 0 || object3 != null && (n10 = string3.length()) <= (n11 = (string2 = ((File)object3.getValue()).getPath()).length())) continue;
            object3 = entry;
        }
        if (object3 != null) {
            object2 = ((File)object3.getValue()).getPath();
            entry = "/";
            boolean bl3 = ((String)object2).endsWith((String)((Object)entry));
            int n10 = ((String)object2).length();
            if (!bl3) {
                ++n10;
            }
            object = ((String)object).substring(n10);
            object2 = new StringBuilder();
            object3 = Uri.encode((String)((String)object3.getKey()));
            ((StringBuilder)object2).append((String)object3);
            ((StringBuilder)object2).append('/');
            object = Uri.encode((String)object, (String)((Object)entry));
            ((StringBuilder)object2).append((String)object);
            object = ((StringBuilder)object2).toString();
            object3 = new Uri.Builder();
            object3 = object3.scheme("content");
            object2 = this.a;
            return object3.authority((String)object2).encodedPath((String)object).build();
        }
        object = new IllegalArgumentException("wisedist: Failed to find configured root that contains");
        throw object;
    }

    public File a(Uri object) {
        block14: {
            Object object2;
            Object object3;
            int n10;
            int n11;
            try {
                object = object.getEncodedPath();
                n11 = 47;
                n10 = 1;
            }
            catch (Exception exception) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("UpdateSDKFileProvider error: ");
                String string2 = exception.toString();
                stringBuilder.append(string2);
                string2 = stringBuilder.toString();
                object3 = new IllegalArgumentException(string2);
                throw object3;
            }
            n11 = ((String)object).indexOf(n11, n10);
            String string3 = ((String)object).substring(n10, n11);
            string3 = Uri.decode((String)string3);
            n11 += n10;
            object = ((String)object).substring(n11);
            object = Uri.decode((String)object);
            object3 = this.b;
            object3 = ((HashMap)object3).get(string3);
            object3 = (File)object3;
            if (object3 == null) break block14;
            n10 = (int)(TextUtils.isEmpty((CharSequence)object) ? 1 : 0);
            if (n10 == 0 && (n10 = (int)(((String)object).contains((CharSequence)(object2 = "../")) ? 1 : 0)) == 0 && (n10 = (int)(((String)object).contains((CharSequence)(object2 = "..")) ? 1 : 0)) == 0 && (n10 = (int)(((String)object).contains((CharSequence)(object2 = "%00")) ? 1 : 0)) == 0 && (n10 = (int)(((String)object).contains((CharSequence)(object2 = ".\\.\\")) ? 1 : 0)) == 0 && (n10 = (int)(((String)object).contains((CharSequence)(object2 = "./")) ? 1 : 0)) == 0) {
                object2 = new File((File)object3, (String)object);
                try {
                    object = ((File)object2).getCanonicalFile();
                    object2 = ((File)object).getPath();
                    object3 = ((File)object3).getPath();
                }
                catch (IOException iOException) {
                    object = new IllegalArgumentException("wisedist: Failed to resolve canonical path for");
                    throw object;
                }
                n11 = (int)(((String)object2).startsWith((String)object3) ? 1 : 0);
                if (n11 != 0) {
                    return object;
                }
                object = new SecurityException("wisedist: Resolved path jumped beyond configured root");
                throw object;
            }
            object = new IllegalArgumentException("wisedist: Not a standard path");
            throw object;
        }
        object = new IllegalArgumentException("wisedist: Unable to find configured root for");
        throw object;
    }

    public void a(String object, File file) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        if (!bl2) {
            try {
                file = file.getCanonicalFile();
                this.b.put(object, file);
            }
            catch (Exception exception) {
                object = new IllegalArgumentException("Failed to resolve canonical path for root");
                throw object;
            }
            return;
        }
        object = new IllegalArgumentException("wisedist Name must not be empty");
        throw object;
    }
}

