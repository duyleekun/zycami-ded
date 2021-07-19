/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.data.database.model.template.templatelist;

import com.zhiyun.editorinterface.EditConfig$ResourceType;
import com.zhiyun.editortemplate.data.database.model.template.templatelist.FileExt;

public class FileData
implements Cloneable {
    private EditConfig$ResourceType category;
    private long downloadTimestamp;
    private FileExt ext;
    private String hash;
    private String name;
    private String path;
    private int size;
    private String type;
    private String url;

    public FileData() {
    }

    public FileData(FileData fileData) {
        String string2 = fileData.getHash();
        String string3 = fileData.getName();
        EditConfig$ResourceType editConfig$ResourceType = fileData.getCategory();
        String string4 = fileData.getType();
        int n10 = fileData.getSize();
        String string5 = fileData.getUrl();
        String string6 = fileData.getPath();
        long l10 = fileData.getDownloadTimestamp();
        FileExt fileExt = fileData.getExt();
        this(string2, string3, editConfig$ResourceType, string4, n10, string5, string6, l10, fileExt);
    }

    public FileData(String string2, String string3, EditConfig$ResourceType editConfig$ResourceType, String string4, int n10, String string5, String string6, long l10) {
        this.hash = string2;
        this.name = string3;
        this.category = editConfig$ResourceType;
        this.type = string4;
        this.size = n10;
        this.url = string5;
        this.path = string6;
        this.downloadTimestamp = l10;
    }

    public FileData(String string2, String string3, EditConfig$ResourceType editConfig$ResourceType, String string4, int n10, String string5, String string6, long l10, FileExt fileExt) {
        this.hash = string2;
        this.name = string3;
        this.category = editConfig$ResourceType;
        this.type = string4;
        this.size = n10;
        this.url = string5;
        this.path = string6;
        this.downloadTimestamp = l10;
        this.ext = fileExt;
    }

    public FileData clone() {
        String string2 = this.hash;
        String string3 = this.name;
        EditConfig$ResourceType editConfig$ResourceType = this.category;
        String string4 = this.type;
        int n10 = this.size;
        String string5 = this.url;
        String string6 = this.path;
        long l10 = this.downloadTimestamp;
        FileExt fileExt = this.ext;
        FileData fileData = new FileData(string2, string3, editConfig$ResourceType, string4, n10, string5, string6, l10, fileExt);
        return fileData;
    }

    public EditConfig$ResourceType getCategory() {
        return this.category;
    }

    public long getDownloadTimestamp() {
        return this.downloadTimestamp;
    }

    public FileExt getExt() {
        return this.ext;
    }

    public String getHash() {
        return this.hash;
    }

    public String getName() {
        return this.name;
    }

    public String getPath() {
        return this.path;
    }

    public int getSize() {
        return this.size;
    }

    public String getType() {
        return this.type;
    }

    public String getUrl() {
        return this.url;
    }

    public void setCategory(EditConfig$ResourceType editConfig$ResourceType) {
        this.category = editConfig$ResourceType;
    }

    public void setDownloadTimestamp(long l10) {
        this.downloadTimestamp = l10;
    }

    public void setExt(FileExt fileExt) {
        this.ext = fileExt;
    }

    public void setHash(String string2) {
        this.hash = string2;
    }

    public void setName(String string2) {
        this.name = string2;
    }

    public void setPath(String string2) {
        this.path = string2;
    }

    public void setSize(int n10) {
        this.size = n10;
    }

    public void setType(String string2) {
        this.type = string2;
    }

    public void setUrl(String string2) {
        this.url = string2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("FileData{hash='");
        Object object = this.hash;
        stringBuilder.append((String)object);
        char c10 = '\'';
        stringBuilder.append(c10);
        stringBuilder.append(", name='");
        Object object2 = this.name;
        stringBuilder.append((String)object2);
        stringBuilder.append(c10);
        stringBuilder.append(", category=");
        object2 = this.category;
        stringBuilder.append(object2);
        stringBuilder.append(", type='");
        object2 = this.type;
        stringBuilder.append((String)object2);
        stringBuilder.append(c10);
        stringBuilder.append(", size=");
        int n10 = this.size;
        stringBuilder.append(n10);
        stringBuilder.append(", url='");
        object2 = this.url;
        stringBuilder.append((String)object2);
        stringBuilder.append(c10);
        stringBuilder.append(", path='");
        object2 = this.path;
        stringBuilder.append((String)object2);
        stringBuilder.append(c10);
        stringBuilder.append(", downloadTimestamp=");
        long l10 = this.downloadTimestamp;
        stringBuilder.append(l10);
        stringBuilder.append(", ext=");
        object = this.ext;
        stringBuilder.append(object);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

