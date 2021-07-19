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
import com.zhiyun.cama.data.database.model.Approval$1;
import java.util.Objects;

public class Approval
implements Parcelable {
    public static final Parcelable.Creator CREATOR;
    private String circle_name;
    private String classify;
    private String comment;
    private String createAt;
    private String degree;
    private int id;
    private String modify;
    private String refuse_reason;

    static {
        Approval$1 approval$1 = new Approval$1();
        CREATOR = approval$1;
    }

    public Approval() {
    }

    public Approval(int n10, String string2, String string3, String string4, String string5, String string6, String string7, String string8) {
        this.id = n10;
        this.degree = string2;
        this.createAt = string3;
        this.refuse_reason = string4;
        this.classify = string5;
        this.circle_name = string6;
        this.modify = string7;
        this.comment = string8;
    }

    public Approval(Parcel object) {
        String string2;
        int n10;
        this.id = n10 = object.readInt();
        this.degree = string2 = object.readString();
        this.createAt = string2 = object.readString();
        this.refuse_reason = string2 = object.readString();
        this.classify = string2 = object.readString();
        this.circle_name = string2 = object.readString();
        this.modify = string2 = object.readString();
        object = object.readString();
        this.comment = object;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object object) {
        Object object2;
        Object object3;
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        if (object != null && (object3 = this.getClass()) == (object2 = object.getClass())) {
            boolean bl3;
            object = (Approval)object;
            int n10 = this.id;
            int n11 = ((Approval)object).id;
            if (n10 != n11 || (n10 = (int)(Objects.equals(object3 = this.degree, object2 = ((Approval)object).degree) ? 1 : 0)) == 0 || (n10 = (int)(Objects.equals(object3 = this.createAt, object2 = ((Approval)object).createAt) ? 1 : 0)) == 0 || (n10 = (int)(Objects.equals(object3 = this.refuse_reason, object2 = ((Approval)object).refuse_reason) ? 1 : 0)) == 0 || (n10 = (int)(Objects.equals(object3 = this.classify, object2 = ((Approval)object).classify) ? 1 : 0)) == 0 || (n10 = (int)(Objects.equals(object3 = this.circle_name, object2 = ((Approval)object).circle_name) ? 1 : 0)) == 0 || (n10 = (int)(Objects.equals(object3 = this.modify, object2 = ((Approval)object).modify) ? 1 : 0)) == 0 || !(bl3 = Objects.equals(object3 = this.comment, object = ((Approval)object).comment))) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public String getCircle_name() {
        return this.circle_name;
    }

    public String getClassify() {
        return this.classify;
    }

    public String getComment() {
        return this.comment;
    }

    public String getCreateAt() {
        return this.createAt;
    }

    public String getDegree() {
        return this.degree;
    }

    public int getId() {
        return this.id;
    }

    public String getModify() {
        return this.modify;
    }

    public String getRefuse_reason() {
        return this.refuse_reason;
    }

    public int hashCode() {
        Object object = this.id;
        Object[] objectArray = new Object[]{object, object = this.degree, object = this.createAt, object = this.refuse_reason, object = this.classify, object = this.circle_name, object = this.modify, object = this.comment};
        return Objects.hash(objectArray);
    }

    public void setCircle_name(String string2) {
        this.circle_name = string2;
    }

    public void setClassify(String string2) {
        this.classify = string2;
    }

    public void setComment(String string2) {
        this.comment = string2;
    }

    public void setCreateAt(String string2) {
        this.createAt = string2;
    }

    public void setDegree(String string2) {
        this.degree = string2;
    }

    public void setId(int n10) {
        this.id = n10;
    }

    public void setModify(String string2) {
        this.modify = string2;
    }

    public void setRefuse_reason(String string2) {
        this.refuse_reason = string2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Approval{id=");
        int c10 = this.id;
        stringBuilder.append(c10);
        stringBuilder.append(", degree='");
        String string2 = this.degree;
        stringBuilder.append(string2);
        char c11 = '\'';
        stringBuilder.append(c11);
        stringBuilder.append(", createAt='");
        String string3 = this.createAt;
        stringBuilder.append(string3);
        stringBuilder.append(c11);
        stringBuilder.append(", refuse_reason='");
        string3 = this.refuse_reason;
        stringBuilder.append(string3);
        stringBuilder.append(c11);
        stringBuilder.append(", classify='");
        string3 = this.classify;
        stringBuilder.append(string3);
        stringBuilder.append(c11);
        stringBuilder.append(", circle_name='");
        string3 = this.circle_name;
        stringBuilder.append(string3);
        stringBuilder.append(c11);
        stringBuilder.append(", modify='");
        string3 = this.modify;
        stringBuilder.append(string3);
        stringBuilder.append(c11);
        stringBuilder.append(", comment='");
        string3 = this.comment;
        stringBuilder.append(string3);
        stringBuilder.append(c11);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int n10) {
        n10 = this.id;
        parcel.writeInt(n10);
        String string2 = this.degree;
        parcel.writeString(string2);
        string2 = this.createAt;
        parcel.writeString(string2);
        string2 = this.refuse_reason;
        parcel.writeString(string2);
        string2 = this.classify;
        parcel.writeString(string2);
        string2 = this.circle_name;
        parcel.writeString(string2);
        string2 = this.modify;
        parcel.writeString(string2);
        string2 = this.comment;
        parcel.writeString(string2);
    }
}

