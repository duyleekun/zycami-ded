/*
 * Decompiled with CFR 0.151.
 */
package com.mob.tools.network;

import com.mob.tools.network.HTTPPart;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class FilePart
extends HTTPPart {
    private File file;

    public InputStream getInputStream() {
        File file = this.file;
        FileInputStream fileInputStream = new FileInputStream(file);
        return fileInputStream;
    }

    public long length() {
        return this.file.length();
    }

    public void setFile(File file) {
        this.file = file;
    }

    public void setFile(String string2) {
        File file;
        this.file = file = new File(string2);
    }

    public String toString() {
        return this.file.toString();
    }
}

