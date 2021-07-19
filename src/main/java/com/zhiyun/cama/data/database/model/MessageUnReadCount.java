/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.database.model;

import java.lang.constant.Constable;
import java.util.Objects;

public class MessageUnReadCount {
    private int comment;
    private int follow;
    private int id;
    private int like;
    private int message;
    private int notice;
    private int personal;
    private boolean punished;

    public MessageUnReadCount(int n10, int n11, int n12, int n13, int n14, int n15, int n16, boolean bl2) {
        this.id = n10;
        this.message = n11;
        this.comment = n12;
        this.follow = n13;
        this.like = n14;
        this.personal = n15;
        this.notice = n16;
        this.punished = bl2;
    }

    public boolean equals(Object object) {
        Class<?> clazz;
        Class<?> clazz2;
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        if (object != null && (clazz2 = this.getClass()) == (clazz = object.getClass())) {
            int n10;
            object = (MessageUnReadCount)object;
            int n11 = this.id;
            int n12 = ((MessageUnReadCount)object).id;
            if (n11 != n12 || (n11 = this.message) != (n12 = ((MessageUnReadCount)object).message) || (n11 = this.comment) != (n12 = ((MessageUnReadCount)object).comment) || (n11 = this.follow) != (n12 = ((MessageUnReadCount)object).follow) || (n11 = this.like) != (n12 = ((MessageUnReadCount)object).like) || (n11 = this.personal) != (n12 = ((MessageUnReadCount)object).personal) || (n11 = this.notice) != (n12 = ((MessageUnReadCount)object).notice) || (n11 = (int)(this.punished ? 1 : 0)) != (n10 = ((MessageUnReadCount)object).punished)) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public int getComment() {
        return this.comment;
    }

    public int getFollow() {
        return this.follow;
    }

    public int getId() {
        return this.id;
    }

    public int getLike() {
        return this.like;
    }

    public int getMessage() {
        return this.message;
    }

    public int getNotice() {
        return this.notice;
    }

    public int getPersonal() {
        return this.personal;
    }

    public boolean getPunished() {
        return this.punished;
    }

    public int hashCode() {
        Object[] objectArray = new Object[8];
        Constable constable = this.id;
        objectArray[0] = constable;
        constable = this.message;
        objectArray[1] = constable;
        constable = this.comment;
        objectArray[2] = constable;
        constable = this.follow;
        objectArray[3] = constable;
        constable = this.like;
        objectArray[4] = constable;
        constable = this.personal;
        objectArray[5] = constable;
        constable = this.notice;
        objectArray[6] = constable;
        constable = Boolean.valueOf(this.punished);
        objectArray[7] = constable;
        return Objects.hash(objectArray);
    }

    public void setComment(int n10) {
        this.comment = n10;
    }

    public void setFollow(int n10) {
        this.follow = n10;
    }

    public void setId(int n10) {
        this.id = n10;
    }

    public void setLike(int n10) {
        this.like = n10;
    }

    public void setMessage(int n10) {
        this.message = n10;
    }

    public void setNotice(int n10) {
        this.notice = n10;
    }

    public void setPersonal(int n10) {
        this.personal = n10;
    }

    public void setPunished(boolean bl2) {
        this.punished = bl2;
    }
}

