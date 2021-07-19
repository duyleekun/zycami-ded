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
import com.zhiyun.cama.data.database.model.Appeal$1;
import java.util.Objects;

public class Appeal
implements Parcelable {
    public static final Parcelable.Creator CREATOR;
    private String appeal_reason;
    private String approval_id;
    private int classify;
    private String comment;
    private String createAt;
    private int id;
    private String punish_id;
    private String refuse_reason;
    private String sourceUrls;
    private int status;

    static {
        Appeal$1 appeal$1 = new Appeal$1();
        CREATOR = appeal$1;
    }

    public Appeal() {
    }

    public Appeal(int n10) {
        this.id = n10;
    }

    public Appeal(int n10, String string2, String string3, String string4, int n11, int n12, String string5, String string6, String string7, String string8) {
        this.id = n10;
        this.approval_id = string2;
        this.appeal_reason = string3;
        this.punish_id = string4;
        this.classify = n11;
        this.status = n12;
        this.sourceUrls = string5;
        this.createAt = string6;
        this.refuse_reason = string7;
        this.comment = string8;
    }

    public Appeal(Parcel object) {
        String string2;
        int n10;
        this.id = n10 = object.readInt();
        this.approval_id = string2 = object.readString();
        this.appeal_reason = string2 = object.readString();
        this.punish_id = string2 = object.readString();
        this.classify = n10 = object.readInt();
        this.status = n10 = object.readInt();
        this.sourceUrls = string2 = object.readString();
        this.createAt = string2 = object.readString();
        this.refuse_reason = string2 = object.readString();
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
            object = (Appeal)object;
            int n10 = this.id;
            int n11 = ((Appeal)object).id;
            if (n10 != n11 || (n10 = this.classify) != (n11 = ((Appeal)object).classify) || (n10 = this.status) != (n11 = ((Appeal)object).status) || (n10 = (int)(Objects.equals(object3 = this.approval_id, object2 = ((Appeal)object).approval_id) ? 1 : 0)) == 0 || (n10 = (int)(Objects.equals(object3 = this.appeal_reason, object2 = ((Appeal)object).appeal_reason) ? 1 : 0)) == 0 || (n10 = (int)(Objects.equals(object3 = this.punish_id, object2 = ((Appeal)object).punish_id) ? 1 : 0)) == 0 || (n10 = (int)(Objects.equals(object3 = this.sourceUrls, object2 = ((Appeal)object).sourceUrls) ? 1 : 0)) == 0 || (n10 = (int)(Objects.equals(object3 = this.createAt, object2 = ((Appeal)object).createAt) ? 1 : 0)) == 0 || (n10 = (int)(Objects.equals(object3 = this.refuse_reason, object2 = ((Appeal)object).refuse_reason) ? 1 : 0)) == 0 || !(bl3 = Objects.equals(object3 = this.comment, object = ((Appeal)object).comment))) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public String getAppeal_reason() {
        return this.appeal_reason;
    }

    public String getApproval_id() {
        return this.approval_id;
    }

    public int getClassify() {
        return this.classify;
    }

    public String getComment() {
        return this.comment;
    }

    public String getCreateAt() {
        return this.createAt;
    }

    public int getId() {
        return this.id;
    }

    public String getPunish_id() {
        return this.punish_id;
    }

    public String getRefuse_reason() {
        return this.refuse_reason;
    }

    public String getSourceUrls() {
        return this.sourceUrls;
    }

    public int getStatus() {
        return this.status;
    }

    public int hashCode() {
        Object object = this.id;
        Object[] objectArray = new Object[]{object, object = this.approval_id, object = this.appeal_reason, object = this.punish_id, object = Integer.valueOf(this.classify), object = Integer.valueOf(this.status), object = this.sourceUrls, object = this.createAt, object = this.refuse_reason, object = this.comment};
        return Objects.hash(objectArray);
    }

    public void setAppeal_reason(String string2) {
        this.appeal_reason = string2;
    }

    public void setApproval_id(String string2) {
        this.approval_id = string2;
    }

    public void setClassify(int n10) {
        this.classify = n10;
    }

    public void setComment(String string2) {
        this.comment = string2;
    }

    public void setCreateAt(String string2) {
        this.createAt = string2;
    }

    public void setId(int n10) {
        this.id = n10;
    }

    public void setPunish_id(String string2) {
        this.punish_id = string2;
    }

    public void setRefuse_reason(String string2) {
        this.refuse_reason = string2;
    }

    public void setSourceUrls(String string2) {
        this.sourceUrls = string2;
    }

    public void setStatus(int n10) {
        this.status = n10;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Appeal{id=");
        int c10 = this.id;
        stringBuilder.append(c10);
        stringBuilder.append(", approval_id='");
        String string2 = this.approval_id;
        stringBuilder.append(string2);
        char c11 = '\'';
        stringBuilder.append(c11);
        stringBuilder.append(", appeal_reason='");
        String string3 = this.appeal_reason;
        stringBuilder.append(string3);
        stringBuilder.append(c11);
        stringBuilder.append(", punish_id='");
        string3 = this.punish_id;
        stringBuilder.append(string3);
        stringBuilder.append(c11);
        stringBuilder.append(", classify=");
        int n10 = this.classify;
        stringBuilder.append(n10);
        stringBuilder.append(", status=");
        n10 = this.status;
        stringBuilder.append(n10);
        stringBuilder.append(", sourceUrls='");
        string3 = this.sourceUrls;
        stringBuilder.append(string3);
        stringBuilder.append(c11);
        stringBuilder.append(", createAt='");
        string3 = this.createAt;
        stringBuilder.append(string3);
        stringBuilder.append(c11);
        stringBuilder.append(", refuse_reason='");
        string3 = this.refuse_reason;
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
        String string2 = this.approval_id;
        parcel.writeString(string2);
        string2 = this.appeal_reason;
        parcel.writeString(string2);
        string2 = this.punish_id;
        parcel.writeString(string2);
        n10 = this.classify;
        parcel.writeInt(n10);
        n10 = this.status;
        parcel.writeInt(n10);
        string2 = this.sourceUrls;
        parcel.writeString(string2);
        string2 = this.createAt;
        parcel.writeString(string2);
        string2 = this.refuse_reason;
        parcel.writeString(string2);
        string2 = this.comment;
        parcel.writeString(string2);
    }
}

