/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Pair
 */
package com.airbnb.lottie.network;

import android.util.Pair;
import com.airbnb.lottie.network.FileExtension;
import com.airbnb.lottie.network.LottieNetworkCacheProvider;
import com.airbnb.lottie.utils.Logger;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class NetworkCache {
    private final LottieNetworkCacheProvider cacheProvider;

    public NetworkCache(LottieNetworkCacheProvider lottieNetworkCacheProvider) {
        this.cacheProvider = lottieNetworkCacheProvider;
    }

    private static String filenameForUrl(String string2, FileExtension fileExtension, boolean bl2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("lottie_cache_");
        String string3 = "\\W+";
        String string4 = "";
        string2 = string2.replaceAll(string3, string4);
        stringBuilder.append(string2);
        string2 = bl2 ? fileExtension.tempExtension() : fileExtension.extension;
        stringBuilder.append(string2);
        return stringBuilder.toString();
    }

    private File getCachedFile(String string2) {
        File file = this.parentDir();
        Object object = FileExtension.JSON;
        File file2 = new File(file, (String)(object = NetworkCache.filenameForUrl(string2, object, false)));
        boolean bl2 = file2.exists();
        if (bl2) {
            return file2;
        }
        file = this.parentDir();
        file2 = new File(file, string2 = NetworkCache.filenameForUrl(string2, object = FileExtension.ZIP, false));
        boolean bl3 = file2.exists();
        if (bl3) {
            return file2;
        }
        return null;
    }

    private File parentDir() {
        File file = this.cacheProvider.getCacheDir();
        boolean bl2 = file.isFile();
        if (bl2) {
            file.delete();
        }
        if (!(bl2 = file.exists())) {
            file.mkdirs();
        }
        return file;
    }

    public void clear() {
        File file = this.parentDir();
        int n10 = file.exists();
        if (n10 != 0) {
            File[] fileArray = file.listFiles();
            if (fileArray != null && (n10 = fileArray.length) > 0) {
                for (File file2 : file.listFiles()) {
                    file2.delete();
                }
            }
            file.delete();
        }
    }

    public Pair fetch(String string2) {
        File file;
        Object object;
        boolean bl2;
        block4: {
            bl2 = false;
            object = null;
            try {
                file = this.getCachedFile(string2);
                if (file != null) break block4;
                return null;
            }
            catch (FileNotFoundException fileNotFoundException) {
                return null;
            }
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        object = file.getAbsolutePath();
        CharSequence charSequence = ".zip";
        bl2 = object.endsWith((String)charSequence);
        object = bl2 ? FileExtension.ZIP : FileExtension.JSON;
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("Cache hit for ");
        ((StringBuilder)charSequence).append(string2);
        ((StringBuilder)charSequence).append(" at ");
        string2 = file.getAbsolutePath();
        ((StringBuilder)charSequence).append(string2);
        Logger.debug(((StringBuilder)charSequence).toString());
        string2 = new Pair(object, (Object)fileInputStream);
        return string2;
    }

    public void renameTempFile(String charSequence, FileExtension object) {
        boolean bl2 = true;
        charSequence = NetworkCache.filenameForUrl((String)charSequence, (FileExtension)((Object)object), bl2);
        File file = this.parentDir();
        object = new File(file, (String)charSequence);
        charSequence = ((File)object).getAbsolutePath().replace(".temp", "");
        file = new File((String)charSequence);
        boolean bl3 = ((File)object).renameTo(file);
        CharSequence charSequence2 = new StringBuilder();
        charSequence2.append("Copying temp file to real file (");
        charSequence2.append(file);
        String string2 = ")";
        charSequence2.append(string2);
        charSequence2 = charSequence2.toString();
        Logger.debug((String)charSequence2);
        if (!bl3) {
            charSequence = new StringBuilder();
            charSequence2 = "Unable to rename cache file ";
            ((StringBuilder)charSequence).append((String)charSequence2);
            object = ((File)object).getAbsolutePath();
            ((StringBuilder)charSequence).append((String)object);
            ((StringBuilder)charSequence).append(" to ");
            object = file.getAbsolutePath();
            ((StringBuilder)charSequence).append((String)object);
            object = ".";
            ((StringBuilder)charSequence).append((String)object);
            charSequence = ((StringBuilder)charSequence).toString();
            Logger.warning((String)charSequence);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public File writeTempCacheFile(String object, InputStream inputStream, FileExtension object2) {
        int n10 = 1;
        object = NetworkCache.filenameForUrl((String)object, object2, n10 != 0);
        Object object3 = this.parentDir();
        object2 = new File((File)object3, (String)object);
        object = new FileOutputStream((File)object2);
        n10 = 1024;
        try {
            int n11;
            int n12;
            object3 = new byte[n10];
            while ((n12 = inputStream.read((byte[])object3)) != (n11 = -1)) {
                n11 = 0;
                ((OutputStream)object).write((byte[])object3, 0, n12);
            }
            ((OutputStream)object).flush();
        }
        catch (Throwable throwable) {
            ((OutputStream)object).close();
            throw throwable;
        }
        try {
            ((OutputStream)object).close();
            return object2;
        }
        finally {
            inputStream.close();
        }
    }
}

