/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.database.model;

import java.util.Objects;

public class MessageViolation {
    public static final String VERB_PROFILE_ILLEGAL = "person_info_approval_notice";
    public static final String VERB_PUNISH = "punish_notice";
    public static final String VERB_REPEAL = "repeal_approval_notice";
    public static final String VERB_WORKS_ILLEGAL = "person_production_approval_notice";
    private String appeal_id;
    private String appeal_status;
    private String build_time;
    private String circle_name;
    private String classify;
    private String content;
    private String createAt;
    private String degree;
    private String forever;
    private String has_punish;
    private int id;
    private int isRead;
    private String punish;
    private String punish_endtime;
    private int refId;
    private String refType;
    private String refuse_reason;
    private String source;
    private long source_id;
    private String verb;

    public MessageViolation(int n10, String string2, int n11, String string3, String string4, String string5, int n12, String string6, String string7, String string8, String string9, String string10, String string11, String string12, String string13, String string14, String string15, String string16, String string17, long l10) {
        String string18;
        this.verb = string18 = "";
        this.content = string18;
        this.id = n10;
        string18 = string2;
        this.verb = string2;
        this.refId = n11;
        string18 = string3;
        this.refType = string3;
        string18 = string4;
        this.content = string4;
        string18 = string5;
        this.createAt = string5;
        this.isRead = n12;
        string18 = string6;
        this.build_time = string6;
        string18 = string7;
        this.degree = string7;
        string18 = string8;
        this.refuse_reason = string8;
        string18 = string9;
        this.appeal_id = string9;
        string18 = string10;
        this.appeal_status = string10;
        string18 = string11;
        this.has_punish = string11;
        string18 = string12;
        this.classify = string12;
        string18 = string13;
        this.punish = string13;
        string18 = string14;
        this.forever = string14;
        string18 = string15;
        this.punish_endtime = string15;
        string18 = string16;
        this.circle_name = string16;
        string18 = string17;
        this.source = string17;
        this.source_id = l10;
    }

    public boolean equals(Object object) {
        Object object2;
        Object object3;
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        if (object != null && (object3 = this.getClass()) == (object2 = object.getClass())) {
            long l10;
            long l11;
            long l12;
            long l13;
            object = (MessageViolation)object;
            int n10 = this.id;
            int n11 = ((MessageViolation)object).id;
            if (n10 != n11 || (n10 = this.refId) != (n11 = ((MessageViolation)object).refId) || (n10 = this.isRead) != (n11 = ((MessageViolation)object).isRead) || (n10 = (int)(Objects.equals(object3 = this.verb, object2 = ((MessageViolation)object).verb) ? 1 : 0)) == 0 || (n10 = (int)(Objects.equals(object3 = this.refType, object2 = ((MessageViolation)object).refType) ? 1 : 0)) == 0 || (n10 = (int)(Objects.equals(object3 = this.content, object2 = ((MessageViolation)object).content) ? 1 : 0)) == 0 || (n10 = (int)(Objects.equals(object3 = this.createAt, object2 = ((MessageViolation)object).createAt) ? 1 : 0)) == 0 || (n10 = (int)(Objects.equals(object3 = this.build_time, object2 = ((MessageViolation)object).build_time) ? 1 : 0)) == 0 || (n10 = (int)(Objects.equals(object3 = this.degree, object2 = ((MessageViolation)object).degree) ? 1 : 0)) == 0 || (n10 = (int)(Objects.equals(object3 = this.refuse_reason, object2 = ((MessageViolation)object).refuse_reason) ? 1 : 0)) == 0 || (n10 = (int)(Objects.equals(object3 = this.appeal_id, object2 = ((MessageViolation)object).appeal_id) ? 1 : 0)) == 0 || (n10 = (int)(Objects.equals(object3 = this.appeal_status, object2 = ((MessageViolation)object).appeal_status) ? 1 : 0)) == 0 || (n10 = (int)(Objects.equals(object3 = this.has_punish, object2 = ((MessageViolation)object).has_punish) ? 1 : 0)) == 0 || (n10 = (int)(Objects.equals(object3 = this.classify, object2 = ((MessageViolation)object).classify) ? 1 : 0)) == 0 || (n10 = (int)(Objects.equals(object3 = this.punish, object2 = ((MessageViolation)object).punish) ? 1 : 0)) == 0 || (n10 = (int)(Objects.equals(object3 = this.forever, object2 = ((MessageViolation)object).forever) ? 1 : 0)) == 0 || (n10 = (int)(Objects.equals(object3 = this.punish_endtime, object2 = ((MessageViolation)object).punish_endtime) ? 1 : 0)) == 0 || (n10 = (int)(Objects.equals(object3 = this.circle_name, object2 = ((MessageViolation)object).circle_name) ? 1 : 0)) == 0 || (n10 = (int)(Objects.equals(object3 = this.source, object2 = ((MessageViolation)object).source) ? 1 : 0)) == 0 || (l13 = (l12 = (l11 = this.source_id) - (l10 = ((MessageViolation)object).source_id)) == 0L ? 0 : (l12 < 0L ? -1 : 1)) != false) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public String getAppeal_id() {
        return this.appeal_id;
    }

    public String getAppeal_status() {
        return this.appeal_status;
    }

    public String getBuild_time() {
        return this.build_time;
    }

    public String getCircle_name() {
        return this.circle_name;
    }

    public String getClassify() {
        return this.classify;
    }

    public String getContent() {
        return this.content;
    }

    public String getCreateAt() {
        return this.createAt;
    }

    public String getDegree() {
        return this.degree;
    }

    public String getForever() {
        return this.forever;
    }

    public String getHas_punish() {
        return this.has_punish;
    }

    public int getId() {
        return this.id;
    }

    public int getIsRead() {
        return this.isRead;
    }

    public String getPunish() {
        return this.punish;
    }

    public String getPunish_endtime() {
        return this.punish_endtime;
    }

    public int getRefId() {
        return this.refId;
    }

    public String getRefType() {
        return this.refType;
    }

    public String getRefuse_reason() {
        return this.refuse_reason;
    }

    public String getSource() {
        return this.source;
    }

    public long getSource_id() {
        return this.source_id;
    }

    public String getVerb() {
        return this.verb;
    }

    public int hashCode() {
        Object object = this.id;
        Object[] objectArray = new Object[]{object, object = this.verb, object = Integer.valueOf(this.refId), object = this.refType, object = this.content, object = this.createAt, object = Integer.valueOf(this.isRead), object = this.build_time, object = this.degree, object = this.refuse_reason, object = this.appeal_id, object = this.appeal_status, object = this.has_punish, object = this.classify, object = this.punish, object = this.forever, object = this.punish_endtime, object = this.circle_name, object = this.source, object = Long.valueOf(this.source_id)};
        return Objects.hash(objectArray);
    }

    public void setAppeal_id(String string2) {
        this.appeal_id = string2;
    }

    public void setAppeal_status(String string2) {
        this.appeal_status = string2;
    }

    public void setBuild_time(String string2) {
        this.build_time = string2;
    }

    public void setCircle_name(String string2) {
        this.circle_name = string2;
    }

    public void setClassify(String string2) {
        this.classify = string2;
    }

    public void setContent(String string2) {
        this.content = string2;
    }

    public void setCreateAt(String string2) {
        this.createAt = string2;
    }

    public void setDegree(String string2) {
        this.degree = string2;
    }

    public void setForever(String string2) {
        this.forever = string2;
    }

    public void setHas_punish(String string2) {
        this.has_punish = string2;
    }

    public void setId(int n10) {
        this.id = n10;
    }

    public void setIsRead(int n10) {
        this.isRead = n10;
    }

    public void setPunish(String string2) {
        this.punish = string2;
    }

    public void setPunish_endtime(String string2) {
        this.punish_endtime = string2;
    }

    public void setRefId(int n10) {
        this.refId = n10;
    }

    public void setRefType(String string2) {
        this.refType = string2;
    }

    public void setRefuse_reason(String string2) {
        this.refuse_reason = string2;
    }

    public void setSource(String string2) {
        this.source = string2;
    }

    public void setSource_id(long l10) {
        this.source_id = l10;
    }

    public void setVerb(String string2) {
        this.verb = string2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("MessageViolation{id=");
        int c10 = this.id;
        stringBuilder.append(c10);
        stringBuilder.append(", verb='");
        String string2 = this.verb;
        stringBuilder.append(string2);
        char c11 = '\'';
        stringBuilder.append(c11);
        stringBuilder.append(", refId=");
        int n10 = this.refId;
        stringBuilder.append(n10);
        stringBuilder.append(", refType='");
        String string3 = this.refType;
        stringBuilder.append(string3);
        stringBuilder.append(c11);
        stringBuilder.append(", content='");
        string3 = this.content;
        stringBuilder.append(string3);
        stringBuilder.append(c11);
        stringBuilder.append(", createAt='");
        string3 = this.createAt;
        stringBuilder.append(string3);
        stringBuilder.append(c11);
        stringBuilder.append(", isRead=");
        n10 = this.isRead;
        stringBuilder.append(n10);
        stringBuilder.append(", build_time='");
        string3 = this.build_time;
        stringBuilder.append(string3);
        stringBuilder.append(c11);
        stringBuilder.append(", degree='");
        string3 = this.degree;
        stringBuilder.append(string3);
        stringBuilder.append(c11);
        stringBuilder.append(", refuse_reason='");
        string3 = this.refuse_reason;
        stringBuilder.append(string3);
        stringBuilder.append(c11);
        stringBuilder.append(", appeal_id='");
        string3 = this.appeal_id;
        stringBuilder.append(string3);
        stringBuilder.append(c11);
        stringBuilder.append(", appeal_status='");
        string3 = this.appeal_status;
        stringBuilder.append(string3);
        stringBuilder.append(c11);
        stringBuilder.append(", has_punish='");
        string3 = this.has_punish;
        stringBuilder.append(string3);
        stringBuilder.append(c11);
        stringBuilder.append(", classify='");
        string3 = this.classify;
        stringBuilder.append(string3);
        stringBuilder.append(c11);
        stringBuilder.append(", punish='");
        string3 = this.punish;
        stringBuilder.append(string3);
        stringBuilder.append(c11);
        stringBuilder.append(", forever='");
        string3 = this.forever;
        stringBuilder.append(string3);
        stringBuilder.append(c11);
        stringBuilder.append(", punish_endtime='");
        string3 = this.punish_endtime;
        stringBuilder.append(string3);
        stringBuilder.append(c11);
        stringBuilder.append(", circle_name='");
        string3 = this.circle_name;
        stringBuilder.append(string3);
        stringBuilder.append(c11);
        stringBuilder.append(", source='");
        string3 = this.source;
        stringBuilder.append(string3);
        stringBuilder.append(c11);
        stringBuilder.append(", source_id=");
        long l10 = this.source_id;
        stringBuilder.append(l10);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

