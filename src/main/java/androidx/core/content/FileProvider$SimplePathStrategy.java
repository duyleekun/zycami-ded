/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  android.net.Uri$Builder
 *  android.text.TextUtils
 */
package androidx.core.content;

import android.net.Uri;
import android.text.TextUtils;
import androidx.core.content.FileProvider$PathStrategy;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class FileProvider$SimplePathStrategy
implements FileProvider$PathStrategy {
    private final String mAuthority;
    private final HashMap mRoots;

    public FileProvider$SimplePathStrategy(String string2) {
        HashMap hashMap;
        this.mRoots = hashMap = new HashMap();
        this.mAuthority = string2;
    }

    public void addRoot(String object, File object2) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        if (!bl2) {
            try {
                object2 = ((File)object2).getCanonicalFile();
                this.mRoots.put(object, object2);
            }
            catch (IOException iOException) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Failed to resolve canonical path for ");
                stringBuilder.append(object2);
                object2 = stringBuilder.toString();
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object2, iOException);
                throw illegalArgumentException;
            }
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
        Object object3 = (File)this.mRoots.get(string2);
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
        Map.Entry entry;
        boolean bl2;
        Object object2;
        Object object3;
        try {
            object = ((File)object).getCanonicalPath();
            object3 = null;
            object2 = this.mRoots.entrySet().iterator();
        }
        catch (IOException iOException) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Failed to resolve canonical path for ");
            stringBuilder.append(object);
            object = stringBuilder.toString();
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
            throw illegalArgumentException;
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
            boolean bl3 = ((String)object2).endsWith((String)((Object)(entry = "/")));
            if (bl3) {
                int n13 = ((String)object2).length();
                object = ((String)object).substring(n13);
            } else {
                int n10 = ((String)object2).length() + 1;
                object = ((String)object).substring(n10);
            }
            object2 = new StringBuilder();
            object3 = Uri.encode((String)((String)object3.getKey()));
            ((StringBuilder)object2).append((String)object3);
            ((StringBuilder)object2).append('/');
            object = Uri.encode((String)object, (String)((Object)entry));
            ((StringBuilder)object2).append((String)object);
            object = ((StringBuilder)object2).toString();
            object3 = new Uri.Builder();
            object3 = object3.scheme("content");
            object2 = this.mAuthority;
            return object3.authority((String)object2).encodedPath((String)object).build();
        }
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("Failed to find configured root that contains ");
        ((StringBuilder)object2).append((String)object);
        object = ((StringBuilder)object2).toString();
        object3 = new IllegalArgumentException((String)object);
        throw object3;
    }
}

