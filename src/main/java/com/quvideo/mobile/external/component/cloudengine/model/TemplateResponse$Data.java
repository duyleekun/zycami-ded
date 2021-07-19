/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  org.json.JSONObject
 */
package com.quvideo.mobile.external.component.cloudengine.model;

import android.text.TextUtils;
import com.quvideo.mobile.external.component.cloudengine.model.TemplateResponse$Data$DataType;
import com.quvideo.mobile.external.platform.api.template.model.TemplateInfoListV3Response$Data;
import org.json.JSONObject;

public class TemplateResponse$Data {
    private int OooO;
    private long OooO00o;
    private int OooO0O0;
    private String OooO0OO;
    private String OooO0Oo;
    private String OooO0o;
    private int OooO0o0;
    private int OooO0oO;
    private int OooO0oo;
    private String OooOO0;
    private String OooOO0O;
    private String OooOO0o;
    private TemplateResponse$Data$DataType OooOOO0;

    public TemplateResponse$Data(TemplateInfoListV3Response$Data object) {
        String string2;
        int n10;
        long l10;
        this.OooO00o = l10 = ((TemplateInfoListV3Response$Data)object).templateId;
        this.OooO0O0 = n10 = ((TemplateInfoListV3Response$Data)object).orderNo;
        this.OooO0OO = string2 = ((TemplateInfoListV3Response$Data)object).icon;
        this.OooO0Oo = string2 = ((TemplateInfoListV3Response$Data)object).previewurl;
        this.OooO0o0 = n10 = ((TemplateInfoListV3Response$Data)object).previewtype;
        this.OooO0o = string2 = ((TemplateInfoListV3Response$Data)object).duration;
        this.OooO0oO = n10 = ((TemplateInfoListV3Response$Data)object).width;
        this.OooO0oo = n10 = ((TemplateInfoListV3Response$Data)object).height;
        this.OooO = n10 = ((TemplateInfoListV3Response$Data)object).templateImgLength;
        this.OooOO0 = string2 = ((TemplateInfoListV3Response$Data)object).title;
        this.OooOO0O = string2 = ((TemplateInfoListV3Response$Data)object).intro;
        this.OooOO0o = string2 = ((TemplateInfoListV3Response$Data)object).tcid;
        object = ((TemplateInfoListV3Response$Data)object).templateExtend;
        object = this.OooO00o((String)object);
        this.OooOOO0 = object;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private TemplateResponse$Data$DataType OooO00o(String string2) {
        block9: {
            String string3;
            JSONObject jSONObject;
            boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
            if (bl2) {
                return TemplateResponse$Data$DataType.both;
            }
            try {
                jSONObject = new JSONObject(string2);
                string2 = "dataType";
                string3 = "0";
            }
            catch (Throwable throwable) {
                return TemplateResponse$Data$DataType.both;
            }
            string2 = jSONObject.optString(string2, string3);
            String string4 = "1";
            bl2 = string2.equals(string4);
            if (!bl2) break block9;
            return TemplateResponse$Data$DataType.image;
        }
        String string5 = "2";
        boolean bl3 = string2.equals(string5);
        if (!bl3) return TemplateResponse$Data$DataType.both;
        return TemplateResponse$Data$DataType.video;
    }

    public TemplateResponse$Data$DataType getDataType() {
        return this.OooOOO0;
    }

    public String getDuration() {
        return this.OooO0o;
    }

    public int getHeight() {
        return this.OooO0oo;
    }

    public String getIcon() {
        return this.OooO0OO;
    }

    public String getIntro() {
        return this.OooOO0O;
    }

    public int getMaxMediaCount() {
        return this.OooO;
    }

    public int getOrderNo() {
        return this.OooO0O0;
    }

    public int getPreviewtype() {
        return this.OooO0o0;
    }

    public String getPreviewurl() {
        return this.OooO0Oo;
    }

    public String getTcid() {
        return this.OooOO0o;
    }

    public long getTemplateId() {
        return this.OooO00o;
    }

    public String getTitle() {
        return this.OooOO0;
    }

    public int getWidth() {
        return this.OooO0oO;
    }
}

