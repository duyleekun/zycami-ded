/*
 * Decompiled with CFR 0.151.
 */
package com.airbnb.lottie.network;

import com.airbnb.lottie.utils.Logger;

public final class FileExtension
extends Enum {
    private static final /* synthetic */ FileExtension[] $VALUES;
    public static final /* enum */ FileExtension JSON;
    public static final /* enum */ FileExtension ZIP;
    public final String extension;

    static {
        FileExtension fileExtension;
        FileExtension fileExtension2;
        JSON = fileExtension2 = new FileExtension("JSON", 0, ".json");
        int n10 = 1;
        ZIP = fileExtension = new FileExtension("ZIP", n10, ".zip");
        FileExtension[] fileExtensionArray = new FileExtension[2];
        fileExtensionArray[0] = fileExtension2;
        fileExtensionArray[n10] = fileExtension;
        $VALUES = fileExtensionArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private FileExtension() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.extension = var3_1;
    }

    public static FileExtension forFile(String string2) {
        for (FileExtension fileExtension : FileExtension.values()) {
            String string3 = fileExtension.extension;
            boolean bl2 = string2.endsWith(string3);
            if (!bl2) continue;
            return fileExtension;
        }
        Object object = new StringBuilder();
        ((StringBuilder)object).append("Unable to find correct extension for ");
        ((StringBuilder)object).append(string2);
        Logger.warning(((StringBuilder)object).toString());
        return JSON;
    }

    public static FileExtension valueOf(String string2) {
        return Enum.valueOf(FileExtension.class, string2);
    }

    public static FileExtension[] values() {
        return (FileExtension[])$VALUES.clone();
    }

    public String tempExtension() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(".temp");
        String string2 = this.extension;
        stringBuilder.append(string2);
        return stringBuilder.toString();
    }

    public String toString() {
        return this.extension;
    }
}

