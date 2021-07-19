/*
 * Decompiled with CFR 0.151.
 */
package com.meicam.sdk;

import java.util.HashMap;

public class NvsObject {
    public static final String TEMPLATE_KEY_CLIP_RAW_HEIGHT = "MSTemplate-ClipRawHeight";
    public static final String TEMPLATE_KEY_CLIP_RAW_WIDTH = "MSTemplate-ClipRawWidth";
    public static final String TEMPLATE_KEY_FOOTAGE_CAN_REPLACE = "MSTemplate-FootageCanReplace";
    public static final String TEMPLATE_KEY_FOOTAGE_ID = "MSTemplate-FootageId";
    public static final String TEMPLATE_KEY_FOOTAGE_NAME = "MSTemplate-FootageName";
    public static final String TEMPLATE_KEY_FOOTAGE_NEED_REVERSE = "MSTemplate-FootageNeedReverse";
    public static final String TEMPLATE_KEY_FOOTAGE_TAGS = "MSTemplate-FootageTags";
    public static final String TEMPLATE_KEY_FOOTAGE_TYPE = "MSTemplate-FootageType";
    public static final String TEMPLATE_KEY_REPLACE_ID = "MSTemplate-ReplaceId";
    private HashMap m_attachmentMap;
    public long m_internalObject = 0L;

    public NvsObject() {
        HashMap hashMap;
        this.m_attachmentMap = hashMap = new HashMap();
    }

    private native String nativeGetTemplateAttachment(long var1, String var3);

    private native void nativeSetTemplateAttachment(long var1, String var3, String var4);

    public Object getAttachment(String string2) {
        return this.m_attachmentMap.get(string2);
    }

    public long getInternalObject() {
        return this.m_internalObject;
    }

    public String getTemplateAttachment(String string2) {
        long l10 = this.m_internalObject;
        return this.nativeGetTemplateAttachment(l10, string2);
    }

    public void setAttachment(String string2, Object object) {
        this.m_attachmentMap.put(string2, object);
    }

    public void setInternalObject(long l10) {
        this.m_internalObject = l10;
    }

    public void setTemplateAttachment(String string2, String string3) {
        long l10 = this.m_internalObject;
        this.nativeSetTemplateAttachment(l10, string2, string3);
    }
}

