/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  android.net.Uri$Builder
 *  android.text.TextUtils
 */
package cn.sharesdk.framework.utils;

import android.net.Uri;
import android.text.TextUtils;
import cn.sharesdk.framework.utils.SSDKLog;
import cn.sharesdk.framework.utils.ShareSDKFileProvider$PathStrategy;
import com.mob.tools.log.NLog;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class ShareSDKFileProvider$a
implements ShareSDKFileProvider$PathStrategy {
    private final String a;
    private final HashMap b;

    public ShareSDKFileProvider$a(String string2) {
        HashMap hashMap;
        this.b = hashMap = new HashMap();
        this.a = string2;
    }

    public void a(String object, File object2) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        if (!bl2) {
            try {
                object2 = ((File)object2).getCanonicalFile();
            }
            catch (IOException iOException) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Failed to resolve canonical path for ");
                stringBuilder.append(object2);
                object2 = stringBuilder.toString();
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object2, iOException);
                throw illegalArgumentException;
            }
            NLog nLog = SSDKLog.b();
            CharSequence charSequence = new StringBuilder();
            charSequence.append("ShareSDKFileProvider addRoot name ===> ");
            charSequence.append((String)object);
            charSequence.append(" root===> ");
            charSequence.append(object2);
            charSequence = charSequence.toString();
            Object[] objectArray = new Object[]{};
            nLog.d(charSequence, objectArray);
            this.b.put(object, object2);
            return;
        }
        object = new IllegalArgumentException("Name must not be empty");
        throw object;
    }

    public File getFileForUri(Uri object) {
        Object object2 = object.getEncodedPath();
        int n10 = 1;
        int n11 = ((String)object2).indexOf(47, n10);
        String string2 = Uri.decode((String)((String)object2).substring(n10, n11));
        object2 = Uri.decode((String)((String)object2).substring(n11 += n10));
        Object object3 = (File)this.b.get(string2);
        if (object3 != null) {
            object = new File((File)object3, (String)object2);
            try {
                object = ((File)object).getCanonicalFile();
                object2 = ((File)object).getPath();
                object3 = ((File)object3).getPath();
                boolean bl2 = ((String)object2).startsWith((String)object3);
                if (bl2) {
                    return object;
                }
                object = new SecurityException("Resolved path jumped beyond configured root");
            }
            catch (IOException iOException) {
                object3 = new StringBuilder();
                ((StringBuilder)object3).append("Failed to resolve canonical path for ");
                ((StringBuilder)object3).append(object);
                object = ((StringBuilder)object3).toString();
                object2 = new IllegalArgumentException((String)object);
                throw object2;
            }
            throw object;
        }
        object3 = new StringBuilder();
        ((StringBuilder)object3).append("Unable to find configured root for ");
        ((StringBuilder)object3).append(object);
        object = ((StringBuilder)object3).toString();
        object2 = new IllegalArgumentException((String)object);
        throw object2;
    }

    public Uri getUriForFile(File object) {
        boolean bl2;
        Object object2 = SSDKLog.b();
        Object object3 = new StringBuilder();
        Object[] objectArray = "ShareSDKFileProvider !!! getUriForFile !!! file ";
        ((StringBuilder)object3).append((String)objectArray);
        ((StringBuilder)object3).append(object);
        object3 = ((StringBuilder)object3).toString();
        objectArray = null;
        Object object4 = new Object[]{};
        ((NLog)object2).d(object3, (Object[])object4);
        object2 = ((File)object).getCanonicalPath();
        object3 = SSDKLog.b();
        object4 = new StringBuilder();
        Object object5 = "ShareSDKFileProvider getUriForFile path ";
        ((StringBuilder)object4).append((String)object5);
        ((StringBuilder)object4).append((String)object2);
        object4 = ((StringBuilder)object4).toString();
        object5 = new Object[]{};
        try {
            ((NLog)object3).d(object4, (Object[])object5);
            object = null;
            object3 = this.b.entrySet().iterator();
        }
        catch (IOException iOException) {
            object3 = new StringBuilder();
            ((StringBuilder)object3).append("Failed to resolve canonical path for ");
            ((StringBuilder)object3).append(object);
            object = ((StringBuilder)object3).toString();
            object2 = new IllegalArgumentException((String)object);
            throw object2;
        }
        while (bl2 = object3.hasNext()) {
            Object[] objectArray2;
            int n10;
            object4 = object3.next();
            object5 = ((File)object4.getValue()).getPath();
            int n11 = ((String)object2).startsWith((String)object5);
            if (n11 == 0 || object != null && (n10 = ((String)object5).length()) <= (n11 = (objectArray2 = ((File)object.getValue()).getPath()).length())) continue;
            object = SSDKLog.b();
            object5 = new StringBuilder();
            ((StringBuilder)object5).append("ShareSDKFileProvider getUriForFile mostSpecific ");
            ((StringBuilder)object5).append(object4);
            object5 = ((StringBuilder)object5).toString();
            objectArray2 = new Object[]{};
            ((NLog)object).d(object5, objectArray2);
            object = object4;
        }
        if (object != null) {
            object3 = ((File)object.getValue()).getPath();
            bl2 = ((String)object3).endsWith((String)(objectArray = "/"));
            if (bl2) {
                int n12 = ((String)object3).length();
                object2 = ((String)object2).substring(n12);
            } else {
                int n13 = ((String)object3).length() + 1;
                object2 = ((String)object2).substring(n13);
            }
            object3 = new StringBuilder();
            object = Uri.encode((String)((String)object.getKey()));
            ((StringBuilder)object3).append((String)object);
            ((StringBuilder)object3).append('/');
            object = Uri.encode((String)object2, (String)objectArray);
            ((StringBuilder)object3).append((String)object);
            object = ((StringBuilder)object3).toString();
            object2 = new Uri.Builder();
            object2 = object2.scheme("content");
            object3 = this.a;
            return object2.authority((String)object3).encodedPath((String)object).build();
        }
        object = SSDKLog.b();
        object3 = new StringBuilder();
        ((StringBuilder)object3).append("ShareSDKFileProvider Failed to find configured root that contains ");
        ((StringBuilder)object3).append((String)object2);
        object3 = ((StringBuilder)object3).toString();
        objectArray = new Object[]{};
        ((NLog)object).d(object3, objectArray);
        object3 = new StringBuilder();
        ((StringBuilder)object3).append("Failed to find configured root that contains ");
        ((StringBuilder)object3).append((String)object2);
        object2 = ((StringBuilder)object3).toString();
        object = new IllegalArgumentException((String)object2);
        throw object;
    }
}

