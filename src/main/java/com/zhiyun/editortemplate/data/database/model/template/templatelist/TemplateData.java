/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.data.database.model.template.templatelist;

import com.zhiyun.editorinterface.EditConfig$a;
import com.zhiyun.editortemplate.data.database.model.template.templatelist.TemplateDescription;
import com.zhiyun.editortemplate.data.database.model.track.ScriptDataExt;
import d.v.e.l.c2;
import d.v.j.e.e.b;
import java.util.Locale;
import java.util.Objects;

public class TemplateData
implements b {
    public static final String[] RATIO_STR_ARRAY = EditConfig$a.l;
    private String coverUrl;
    private boolean downloadFinished;
    private Long downloadTimestamp;
    private String editorTemplate;
    private boolean firstLoaded;
    private long id;
    private boolean isPrimeUsable;
    private int resSize;
    private ScriptDataExt scriptDataExt;
    private int tempType;
    private TemplateDescription templateDescription;
    private int templateProtocolType;
    private int templateUseType;
    private String textEn;
    private String textZh;
    private String textZhTw;
    private String trackEditorConfigData;
    private int videoCount;
    private String videoRatio;
    private double videoTime;
    private String videoUrl;

    public TemplateData() {
        this.downloadFinished = false;
    }

    public TemplateData(String string2, String string3, String string4, String string5, String string6, double d10, int n10, String string7, int n11, boolean bl2, int n12, boolean bl3, Long l10, TemplateDescription templateDescription, String string8, String string9, int n13, int n14, ScriptDataExt scriptDataExt, boolean bl4) {
        this.textZh = string2;
        this.textZhTw = string3;
        this.textEn = string4;
        this.coverUrl = string5;
        this.videoUrl = string6;
        this.videoTime = d10;
        this.videoCount = n10;
        this.videoRatio = string7;
        this.resSize = n11;
        this.isPrimeUsable = bl2;
        this.tempType = n12;
        this.downloadFinished = bl3;
        this.downloadTimestamp = l10;
        this.templateDescription = templateDescription;
        this.editorTemplate = string8;
        this.trackEditorConfigData = string9;
        this.templateUseType = n13;
        this.templateProtocolType = n14;
        this.scriptDataExt = scriptDataExt;
        this.firstLoaded = bl4;
    }

    public TemplateData clone() {
        TemplateData templateData;
        TemplateData templateData2 = this;
        String string2 = this.textZh;
        String string3 = this.textZhTw;
        String string4 = this.textEn;
        String string5 = this.coverUrl;
        String string6 = this.videoUrl;
        double d10 = this.videoTime;
        int n10 = this.videoCount;
        String string7 = this.videoRatio;
        int n11 = this.resSize;
        boolean bl2 = this.isPrimeUsable;
        int n12 = this.tempType;
        boolean bl3 = this.downloadFinished;
        Object object = this.downloadTimestamp;
        Object object2 = this.templateDescription;
        TemplateDescription templateDescription = null;
        Object object3 = object2 == null ? null : (object2 = ((TemplateDescription)object2).clone());
        object2 = templateData2.editorTemplate;
        Object object4 = object;
        Object object5 = object = templateData2.trackEditorConfigData;
        int n13 = templateData2.templateUseType;
        int n14 = templateData2.templateProtocolType;
        Object object6 = object2;
        object2 = templateData2.scriptDataExt;
        Object object7 = object2 == null ? null : (object2 = ((ScriptDataExt)object2).clone());
        boolean bl4 = templateData2.firstLoaded;
        object2 = templateData;
        object = object4;
        templateDescription = object3;
        object3 = object6;
        object4 = object5;
        int n15 = n13;
        n13 = n14;
        object6 = object7;
        templateData = new TemplateData(string2, string3, string4, string5, string6, d10, n10, string7, n11, bl2, n12, bl3, (Long)object, templateDescription, (String)object3, (String)object5, n15, n14, (ScriptDataExt)object7, bl4);
        return templateData;
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
            int n10;
            double d10;
            double d11;
            object = (TemplateData)object;
            long l10 = this.id;
            long l11 = ((TemplateData)object).id;
            long l12 = l10 - l11;
            Object object4 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (object4 != false || (object4 = (Object)Double.compare(d11 = ((TemplateData)object).videoTime, d10 = this.videoTime)) != false || (object4 = (Object)this.videoCount) != (n10 = ((TemplateData)object).videoCount) || (object4 = (Object)this.resSize) != (n10 = ((TemplateData)object).resSize) || (object4 = (Object)this.isPrimeUsable) != (n10 = (int)(((TemplateData)object).isPrimeUsable ? 1 : 0)) || (object4 = (Object)this.tempType) != (n10 = ((TemplateData)object).tempType) || (object4 = (Object)this.downloadFinished) != (n10 = (int)(((TemplateData)object).downloadFinished ? 1 : 0)) || (object4 = (Object)this.templateUseType) != (n10 = ((TemplateData)object).templateUseType) || (object4 = (Object)this.templateProtocolType) != (n10 = ((TemplateData)object).templateProtocolType) || (object4 = (Object)this.firstLoaded) != (n10 = (int)(((TemplateData)object).firstLoaded ? 1 : 0)) || (object4 = (Object)Objects.equals(object3 = this.textZh, object2 = ((TemplateData)object).textZh)) == false || (object4 = (Object)Objects.equals(object3 = this.textZhTw, object2 = ((TemplateData)object).textZhTw)) == false || (object4 = (Object)Objects.equals(object3 = this.textEn, object2 = ((TemplateData)object).textEn)) == false || (object4 = (Object)Objects.equals(object3 = this.coverUrl, object2 = ((TemplateData)object).coverUrl)) == false || (object4 = (Object)Objects.equals(object3 = this.videoUrl, object2 = ((TemplateData)object).videoUrl)) == false || (object4 = (Object)Objects.equals(object3 = this.videoRatio, object2 = ((TemplateData)object).videoRatio)) == false || (object4 = (Object)Objects.equals(object3 = this.downloadTimestamp, object2 = ((TemplateData)object).downloadTimestamp)) == false || (object4 = (Object)Objects.equals(object3 = this.templateDescription, object2 = ((TemplateData)object).templateDescription)) == false || (object4 = (Object)Objects.equals(object3 = this.editorTemplate, object2 = ((TemplateData)object).editorTemplate)) == false || (object4 = (Object)Objects.equals(object3 = this.trackEditorConfigData, object2 = ((TemplateData)object).trackEditorConfigData)) == false || !(bl3 = Objects.equals(object3 = this.scriptDataExt, object = ((TemplateData)object).scriptDataExt))) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public String getCoverUrl() {
        return this.coverUrl;
    }

    public Long getDownloadTimestamp() {
        return this.downloadTimestamp;
    }

    public String getEditorTemplate() {
        return this.editorTemplate;
    }

    public long getId() {
        return this.id;
    }

    public int getResSize() {
        return this.resSize;
    }

    public ScriptDataExt getScriptDataExt() {
        return this.scriptDataExt;
    }

    public int getTempType() {
        return this.tempType;
    }

    public TemplateDescription getTemplateDescription() {
        return this.templateDescription;
    }

    public int getTemplateProtocolType() {
        return this.templateProtocolType;
    }

    public int getTemplateUseType() {
        return this.templateUseType;
    }

    public String getTextEn() {
        return this.textEn;
    }

    public String getTextZh() {
        return this.textZh;
    }

    public String getTextZhTw() {
        return this.textZhTw;
    }

    public String getTrackEditorConfigData() {
        return this.trackEditorConfigData;
    }

    public int getVideoCount() {
        return this.videoCount;
    }

    public String getVideoRatio() {
        return this.videoRatio;
    }

    public double getVideoTime() {
        return this.videoTime;
    }

    public String getVideoUrl() {
        return this.videoUrl;
    }

    public int hashCode() {
        Object object = this.id;
        Object[] objectArray = new Object[]{object, object = this.textZh, object = this.textZhTw, object = this.textEn, object = this.coverUrl, object = this.videoUrl, object = Double.valueOf(this.videoTime), object = Integer.valueOf(this.videoCount), object = this.videoRatio, object = Integer.valueOf(this.resSize), object = Boolean.valueOf(this.isPrimeUsable), object = Integer.valueOf(this.tempType), object = Boolean.valueOf(this.downloadFinished), object = this.downloadTimestamp, object = this.templateDescription, object = this.editorTemplate, object = this.trackEditorConfigData, object = Integer.valueOf(this.templateUseType), object = Integer.valueOf(this.templateProtocolType), object = this.scriptDataExt, object = Boolean.valueOf(this.firstLoaded)};
        return Objects.hash(objectArray);
    }

    public boolean isBuiltInTemplate() {
        int n10 = this.tempType;
        int n11 = -1;
        n10 = n10 == n11 ? 1 : 0;
        return n10 != 0;
    }

    public boolean isDIYTemplate() {
        int n10 = this.tempType;
        int n11 = -2;
        n10 = n10 == n11 ? 1 : 0;
        return n10 != 0;
    }

    public boolean isDownloadFinished() {
        return this.downloadFinished;
    }

    public boolean isEditorTemplate() {
        int n10 = this.templateUseType;
        n10 = n10 == 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean isEndOfVideo() {
        int n10 = this.templateProtocolType;
        int n11 = 1;
        if (n10 != n11) {
            n11 = 0;
        }
        return n11 != 0;
    }

    public boolean isFileTemplate() {
        int n10 = this.tempType;
        n10 = n10 == 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean isFirstLoaded() {
        return this.firstLoaded;
    }

    public boolean isNetworkTemplate() {
        return this.isFileTemplate();
    }

    public boolean isPrimeUsable() {
        return this.isPrimeUsable;
    }

    public boolean isSmartTemplate() {
        int n10 = this.templateUseType;
        int n11 = 1;
        if (n10 != n11) {
            n11 = 0;
        }
        return n11 != 0;
    }

    public boolean isTemplate() {
        int n10 = this.templateProtocolType;
        n10 = n10 == 0 ? 1 : 0;
        return n10 != 0;
    }

    public void setCoverUrl(String string2) {
        this.coverUrl = string2;
    }

    public void setDownloadFinished(boolean bl2) {
        this.downloadFinished = bl2;
    }

    public void setDownloadTimestamp(Long l10) {
        this.downloadTimestamp = l10;
    }

    public void setEditorTemplate(String string2) {
        this.editorTemplate = string2;
    }

    public void setFirstLoaded(boolean bl2) {
        this.firstLoaded = bl2;
    }

    public void setId(long l10) {
        this.id = l10;
    }

    public void setPrimeUsable(boolean bl2) {
        this.isPrimeUsable = bl2;
    }

    public void setResSize(int n10) {
        this.resSize = n10;
    }

    public void setScriptDataExt(ScriptDataExt scriptDataExt) {
        this.scriptDataExt = scriptDataExt;
    }

    public void setTempType(int n10) {
        this.tempType = n10;
    }

    public void setTemplateDescription(TemplateDescription templateDescription) {
        this.templateDescription = templateDescription;
    }

    public void setTemplateProtocolType(int n10) {
        this.templateProtocolType = n10;
    }

    public void setTemplateUseType(int n10) {
        this.templateUseType = n10;
    }

    public void setTextEn(String string2) {
        this.textEn = string2;
    }

    public void setTextZh(String string2) {
        this.textZh = string2;
    }

    public void setTextZhTw(String string2) {
        this.textZhTw = string2;
    }

    public void setTrackEditorConfigData(String string2) {
        this.trackEditorConfigData = string2;
    }

    public void setVideoCount(int n10) {
        this.videoCount = n10;
    }

    public void setVideoRatio(String string2) {
        this.videoRatio = string2;
    }

    public void setVideoTime(double d10) {
        this.videoTime = d10;
    }

    public void setVideoUrl(String string2) {
        this.videoUrl = string2;
    }

    public String showDesc() {
        Object object = this.getTemplateDescription();
        object = object != null ? this.getTemplateDescription().a() : "";
        return object;
    }

    public String showResSize() {
        String string2;
        int n10 = this.resSize;
        if (n10 > 0) {
            double d10 = n10;
            int n11 = 1;
            string2 = c2.b(d10, n11);
        } else {
            string2 = "";
        }
        return string2;
    }

    public String showTitle() {
        return this.a();
    }

    public String showVideoCount() {
        Locale locale = Locale.getDefault();
        Object[] objectArray = new Object[1];
        Integer n10 = this.getVideoCount();
        objectArray[0] = n10;
        return String.format(locale, "%dp", objectArray);
    }

    public String showVideoCountP() {
        Locale locale = Locale.getDefault();
        Object[] objectArray = new Object[1];
        Integer n10 = this.getVideoCount();
        objectArray[0] = n10;
        return String.format(locale, "%dP", objectArray);
    }

    public String showVideoTime() {
        StringBuilder stringBuilder = new StringBuilder();
        int n10 = (int)this.videoTime;
        stringBuilder.append(n10);
        stringBuilder.append("\u2033");
        return stringBuilder.toString();
    }

    public String showVideoTimeSecond() {
        Locale locale = Locale.getDefault();
        Object[] objectArray = new Object[1];
        Double d10 = this.videoTime;
        objectArray[0] = d10;
        return String.format(locale, "%.1fs", objectArray);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("TemplateData{id=");
        long l10 = this.id;
        stringBuilder.append(l10);
        stringBuilder.append(", textZh='");
        Object object = this.textZh;
        stringBuilder.append((String)object);
        char bl2 = '\'';
        stringBuilder.append(bl2);
        stringBuilder.append(", textZhTw='");
        Object object2 = this.textZhTw;
        stringBuilder.append((String)object2);
        stringBuilder.append(bl2);
        stringBuilder.append(", textEn='");
        object2 = this.textEn;
        stringBuilder.append((String)object2);
        stringBuilder.append(bl2);
        stringBuilder.append(", coverUrl='");
        object2 = this.coverUrl;
        stringBuilder.append((String)object2);
        stringBuilder.append(bl2);
        stringBuilder.append(", videoUrl='");
        object2 = this.videoUrl;
        stringBuilder.append((String)object2);
        stringBuilder.append(bl2);
        stringBuilder.append(", videoTime=");
        double d10 = this.videoTime;
        stringBuilder.append(d10);
        stringBuilder.append(", videoCount=");
        int n10 = this.videoCount;
        stringBuilder.append(n10);
        stringBuilder.append(", videoRatio='");
        object2 = this.videoRatio;
        stringBuilder.append((String)object2);
        stringBuilder.append(bl2);
        stringBuilder.append(", resSize=");
        int n11 = this.resSize;
        stringBuilder.append(n11);
        stringBuilder.append(", isPrimeUsable=");
        boolean bl3 = this.isPrimeUsable;
        stringBuilder.append(bl3);
        stringBuilder.append(", tempType=");
        int n12 = this.tempType;
        stringBuilder.append(n12);
        stringBuilder.append(", downloadFinished=");
        boolean bl4 = this.downloadFinished;
        stringBuilder.append(bl4);
        stringBuilder.append(", downloadTimestamp=");
        object2 = this.downloadTimestamp;
        stringBuilder.append(object2);
        stringBuilder.append(", templateDescription=");
        object2 = this.templateDescription;
        stringBuilder.append(object2);
        stringBuilder.append(", editorTemplate='");
        object2 = this.editorTemplate;
        stringBuilder.append((String)object2);
        stringBuilder.append(bl2);
        stringBuilder.append(", trackEditorConfigData='");
        object2 = this.trackEditorConfigData;
        stringBuilder.append((String)object2);
        stringBuilder.append(bl2);
        stringBuilder.append(", templateUseType=");
        int n13 = this.templateUseType;
        stringBuilder.append(n13);
        stringBuilder.append(", templateProtocolType=");
        int n14 = this.templateProtocolType;
        stringBuilder.append(n14);
        stringBuilder.append(", scriptDataExt=");
        object = this.scriptDataExt;
        stringBuilder.append(object);
        stringBuilder.append(", firstLoaded=");
        boolean bl5 = this.firstLoaded;
        stringBuilder.append(bl5);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

