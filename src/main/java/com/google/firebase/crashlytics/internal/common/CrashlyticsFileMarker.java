/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.common;

import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.persistence.FileStore;
import java.io.File;
import java.io.IOException;

public class CrashlyticsFileMarker {
    private final FileStore fileStore;
    private final String markerName;

    public CrashlyticsFileMarker(String string2, FileStore fileStore) {
        this.markerName = string2;
        this.fileStore = fileStore;
    }

    private File getMarkerFile() {
        File file = this.fileStore.getFilesDir();
        String string2 = this.markerName;
        File file2 = new File(file, string2);
        return file2;
    }

    public boolean create() {
        boolean bl2;
        File file = this.getMarkerFile();
        try {
            bl2 = file.createNewFile();
        }
        catch (IOException iOException) {
            Logger logger = Logger.getLogger();
            CharSequence charSequence = new StringBuilder();
            charSequence.append("Error creating marker: ");
            String string2 = this.markerName;
            charSequence.append(string2);
            charSequence = charSequence.toString();
            logger.e((String)charSequence, iOException);
            bl2 = false;
            Object var1_3 = null;
        }
        return bl2;
    }

    public boolean isPresent() {
        return this.getMarkerFile().exists();
    }

    public boolean remove() {
        return this.getMarkerFile().delete();
    }
}

