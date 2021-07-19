/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.database.model;

import com.zhiyun.cama.data.database.model.SplashAdWatch;
import java.util.Objects;

public class SplashAd {
    private String code;
    private String endAt;
    private long endUnix;
    private String filePath;
    private int id;
    private String image;
    private boolean isAutoDisappear;
    private boolean isVideo;
    private String lang;
    private SplashAdWatch mSplashAdWatch;
    private int period;
    private long refId;
    private String refType;
    private String region;
    private String startAt;
    private long startUnix;
    private String text;
    private int type;
    private String url;
    public String video;

    public SplashAd(int n10, String string2, String string3, String string4, String string5, String string6, long l10, int n11, int n12, String string7, String string8, String string9, long l11, long l12, String string10, boolean bl2, boolean bl3, String string11, SplashAdWatch splashAdWatch) {
        Object object = "";
        this.code = object;
        this.text = object;
        this.image = object;
        this.url = object;
        this.refType = object;
        this.region = object;
        this.startAt = object;
        this.endAt = object;
        this.filePath = object;
        this.lang = object;
        this.id = n10;
        object = string2;
        this.code = string2;
        object = string3;
        this.text = string3;
        object = string4;
        this.image = string4;
        object = string5;
        this.url = string5;
        object = string6;
        this.refType = string6;
        this.refId = l10;
        this.type = n11;
        this.period = n12;
        object = string7;
        this.region = string7;
        object = string8;
        this.startAt = string8;
        object = string9;
        this.endAt = string9;
        this.startUnix = l11;
        this.endUnix = l12;
        object = string10;
        this.filePath = string10;
        this.isVideo = bl2;
        this.isAutoDisappear = bl3;
        object = string11;
        this.lang = string11;
        object = splashAdWatch;
        this.mSplashAdWatch = splashAdWatch;
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
            long l10;
            long l11;
            long l12;
            long l13;
            long l14;
            object = (SplashAd)object;
            int n10 = this.id;
            int n11 = ((SplashAd)object).id;
            if (n10 != n11 || (n10 = (int)((l14 = (l13 = this.refId) - (l12 = ((SplashAd)object).refId)) == 0L ? 0 : (l14 < 0L ? -1 : 1))) != 0 || (n10 = this.type) != (n11 = ((SplashAd)object).type) || (n10 = this.period) != (n11 = ((SplashAd)object).period) || (n10 = (int)((l11 = (l13 = this.startUnix) - (l12 = ((SplashAd)object).startUnix)) == 0L ? 0 : (l11 < 0L ? -1 : 1))) != 0 || (n10 = (int)((l10 = (l13 = this.endUnix) - (l12 = ((SplashAd)object).endUnix)) == 0L ? 0 : (l10 < 0L ? -1 : 1))) != 0 || (n10 = (int)(this.isVideo ? 1 : 0)) != (n11 = (int)(((SplashAd)object).isVideo ? 1 : 0)) || (n10 = (int)(this.isAutoDisappear ? 1 : 0)) != (n11 = (int)(((SplashAd)object).isAutoDisappear ? 1 : 0)) || (n10 = (int)(Objects.equals(object3 = this.code, object2 = ((SplashAd)object).code) ? 1 : 0)) == 0 || (n10 = (int)(Objects.equals(object3 = this.text, object2 = ((SplashAd)object).text) ? 1 : 0)) == 0 || (n10 = (int)(Objects.equals(object3 = this.image, object2 = ((SplashAd)object).image) ? 1 : 0)) == 0 || (n10 = (int)(Objects.equals(object3 = this.url, object2 = ((SplashAd)object).url) ? 1 : 0)) == 0 || (n10 = (int)(Objects.equals(object3 = this.refType, object2 = ((SplashAd)object).refType) ? 1 : 0)) == 0 || (n10 = (int)(Objects.equals(object3 = this.region, object2 = ((SplashAd)object).region) ? 1 : 0)) == 0 || (n10 = (int)(Objects.equals(object3 = this.startAt, object2 = ((SplashAd)object).startAt) ? 1 : 0)) == 0 || (n10 = (int)(Objects.equals(object3 = this.endAt, object2 = ((SplashAd)object).endAt) ? 1 : 0)) == 0 || (n10 = (int)(Objects.equals(object3 = this.filePath, object2 = ((SplashAd)object).filePath) ? 1 : 0)) == 0 || (n10 = (int)(Objects.equals(object3 = this.lang, object2 = ((SplashAd)object).lang) ? 1 : 0)) == 0 || !(bl3 = Objects.equals(object3 = this.mSplashAdWatch, object = ((SplashAd)object).mSplashAdWatch))) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public String getCode() {
        return this.code;
    }

    public String getEndAt() {
        return this.endAt;
    }

    public long getEndUnix() {
        return this.endUnix;
    }

    public String getFilePath() {
        return this.filePath;
    }

    public int getId() {
        return this.id;
    }

    public String getImage() {
        return this.image;
    }

    public String getLang() {
        return this.lang;
    }

    public int getPeriod() {
        return this.period;
    }

    public long getRefId() {
        return this.refId;
    }

    public String getRefType() {
        return this.refType;
    }

    public String getRegion() {
        return this.region;
    }

    public SplashAdWatch getSplashAdWatch() {
        return this.mSplashAdWatch;
    }

    public String getStartAt() {
        return this.startAt;
    }

    public long getStartUnix() {
        return this.startUnix;
    }

    public String getText() {
        return this.text;
    }

    public int getType() {
        return this.type;
    }

    public String getUrl() {
        return this.url;
    }

    public int hashCode() {
        Object object = this.id;
        Object[] objectArray = new Object[]{object, object = this.code, object = this.text, object = this.image, object = this.url, object = this.refType, object = Long.valueOf(this.refId), object = Integer.valueOf(this.type), object = Integer.valueOf(this.period), object = this.region, object = this.startAt, object = this.endAt, object = Long.valueOf(this.startUnix), object = Long.valueOf(this.endUnix), object = this.filePath, object = Boolean.valueOf(this.isVideo), object = Boolean.valueOf(this.isAutoDisappear), object = this.lang, object = this.mSplashAdWatch};
        return Objects.hash(objectArray);
    }

    public boolean isAutoDisappear() {
        return this.isAutoDisappear;
    }

    public boolean isVideo() {
        return this.isVideo;
    }

    public void setAutoDisappear(boolean bl2) {
        this.isAutoDisappear = bl2;
    }

    public void setCode(String string2) {
        this.code = string2;
    }

    public void setEndAt(String string2) {
        this.endAt = string2;
    }

    public void setEndUnix(long l10) {
        this.endUnix = l10;
    }

    public void setFilePath(String string2) {
        this.filePath = string2;
    }

    public void setId(int n10) {
        this.id = n10;
    }

    public void setImage(String string2) {
        this.image = string2;
    }

    public void setLang(String string2) {
        this.lang = string2;
    }

    public void setPeriod(int n10) {
        this.period = n10;
    }

    public void setRefId(long l10) {
        this.refId = l10;
    }

    public void setRefType(String string2) {
        this.refType = string2;
    }

    public void setRegion(String string2) {
        this.region = string2;
    }

    public void setSplashAdWatch(SplashAdWatch splashAdWatch) {
        this.mSplashAdWatch = splashAdWatch;
    }

    public void setStartAt(String string2) {
        this.startAt = string2;
    }

    public void setStartUnix(long l10) {
        this.startUnix = l10;
    }

    public void setText(String string2) {
        this.text = string2;
    }

    public void setType(int n10) {
        this.type = n10;
    }

    public void setUrl(String string2) {
        this.url = string2;
    }

    public void setVideo(boolean bl2) {
        this.isVideo = bl2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SplashAd{id=");
        int c10 = this.id;
        stringBuilder.append(c10);
        stringBuilder.append(", code='");
        Object object = this.code;
        stringBuilder.append((String)object);
        char c11 = '\'';
        stringBuilder.append(c11);
        stringBuilder.append(", text='");
        String string2 = this.text;
        stringBuilder.append(string2);
        stringBuilder.append(c11);
        stringBuilder.append(", image='");
        string2 = this.image;
        stringBuilder.append(string2);
        stringBuilder.append(c11);
        stringBuilder.append(", url='");
        string2 = this.url;
        stringBuilder.append(string2);
        stringBuilder.append(c11);
        stringBuilder.append(", refType='");
        string2 = this.refType;
        stringBuilder.append(string2);
        stringBuilder.append(c11);
        stringBuilder.append(", refId=");
        long l10 = this.refId;
        stringBuilder.append(l10);
        stringBuilder.append(", type=");
        int n10 = this.type;
        stringBuilder.append(n10);
        stringBuilder.append(", period=");
        int n11 = this.period;
        stringBuilder.append(n11);
        stringBuilder.append(", region='");
        string2 = this.region;
        stringBuilder.append(string2);
        stringBuilder.append(c11);
        stringBuilder.append(", startAt='");
        string2 = this.startAt;
        stringBuilder.append(string2);
        stringBuilder.append(c11);
        stringBuilder.append(", endAt='");
        string2 = this.endAt;
        stringBuilder.append(string2);
        stringBuilder.append(c11);
        stringBuilder.append(", startUnix=");
        l10 = this.startUnix;
        stringBuilder.append(l10);
        stringBuilder.append(", endUnix=");
        l10 = this.endUnix;
        stringBuilder.append(l10);
        stringBuilder.append(", filePath='");
        string2 = this.filePath;
        stringBuilder.append(string2);
        stringBuilder.append(c11);
        stringBuilder.append(", isVideo=");
        boolean bl2 = this.isVideo;
        stringBuilder.append(bl2);
        stringBuilder.append(", isAutoDisappear=");
        boolean bl3 = this.isAutoDisappear;
        stringBuilder.append(bl3);
        stringBuilder.append(", lang='");
        string2 = this.lang;
        stringBuilder.append(string2);
        stringBuilder.append(c11);
        stringBuilder.append(", mSplashAdWatch=");
        object = this.mSplashAdWatch;
        stringBuilder.append(object);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

