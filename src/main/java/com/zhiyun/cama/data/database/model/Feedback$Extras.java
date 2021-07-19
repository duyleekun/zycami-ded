/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 */
package com.zhiyun.cama.data.database.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.zhiyun.cama.data.database.model.Feedback$Extras$1;

public class Feedback$Extras
implements Parcelable {
    public static final Parcelable.Creator CREATOR;
    private String content;
    private String createdAt;
    private String files;
    private int id;

    static {
        Feedback$Extras$1 feedback$Extras$1 = new Feedback$Extras$1();
        CREATOR = feedback$Extras$1;
    }

    public Feedback$Extras() {
    }

    public Feedback$Extras(Parcel object) {
        String string2;
        int n10;
        this.id = n10 = object.readInt();
        this.content = string2 = object.readString();
        this.files = string2 = object.readString();
        object = object.readString();
        this.createdAt = object;
    }

    public int describeContents() {
        return 0;
    }

    public String getContent() {
        return this.content;
    }

    public String getCreatedAt() {
        return this.createdAt;
    }

    public String getFiles() {
        return this.files;
    }

    public int getId() {
        return this.id;
    }

    public void setContent(String string2) {
        this.content = string2;
    }

    public void setCreatedAt(String string2) {
        this.createdAt = string2;
    }

    public void setFiles(String string2) {
        this.files = string2;
    }

    public void setId(int n10) {
        this.id = n10;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Extras{id=");
        int c10 = this.id;
        stringBuilder.append(c10);
        stringBuilder.append(", content='");
        String string2 = this.content;
        stringBuilder.append(string2);
        char c11 = '\'';
        stringBuilder.append(c11);
        stringBuilder.append(", files='");
        String string3 = this.files;
        stringBuilder.append(string3);
        stringBuilder.append(c11);
        stringBuilder.append(", createdAt='");
        string3 = this.createdAt;
        stringBuilder.append(string3);
        stringBuilder.append(c11);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int n10) {
        n10 = this.id;
        parcel.writeInt(n10);
        String string2 = this.content;
        parcel.writeString(string2);
        string2 = this.files;
        parcel.writeString(string2);
        string2 = this.createdAt;
        parcel.writeString(string2);
    }
}

