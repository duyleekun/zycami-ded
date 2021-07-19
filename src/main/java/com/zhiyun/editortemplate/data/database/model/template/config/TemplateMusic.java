/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.data.database.model.template.config;

import com.zhiyun.editortemplate.data.database.model.template.config.TemplateAudioData;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateAudioTransition;

public class TemplateMusic
extends TemplateAudioData {
    public TemplateMusic() {
    }

    public TemplateMusic(long l10, long l11, String string2, String string3, long l12, long l13, long l14, long l15, float f10, boolean bl2, boolean bl3, TemplateAudioTransition templateAudioTransition, TemplateAudioTransition templateAudioTransition2) {
        super(l10, l11, string2, string3, l12, l13, l14, l15, f10, bl2, bl3, templateAudioTransition, templateAudioTransition2);
    }

    public TemplateMusic(String string2, String string3, long l10, long l11, long l12, long l13, float f10, boolean bl2, boolean bl3, TemplateAudioTransition templateAudioTransition, TemplateAudioTransition templateAudioTransition2) {
        super(string2, string3, l10, l11, l12, l13, f10, bl2, bl3, templateAudioTransition, templateAudioTransition2);
    }

    public TemplateMusic clone() {
        Object object;
        TemplateAudioTransition templateAudioTransition;
        Object object2 = this.getName();
        String string2 = this.getTitle();
        long l10 = this.getAttachTime();
        long l11 = this.getStartTime();
        long l12 = this.getEndTime();
        long l13 = this.getTimebase();
        float f10 = this.getVolume();
        boolean bl2 = this.isMute();
        boolean bl3 = this.isLocalSource();
        Object object3 = this.getFadeIn();
        if (object3 == null) {
            templateAudioTransition = null;
        } else {
            object3 = this.getFadeIn().clone();
            templateAudioTransition = object3;
        }
        object3 = this.getFadeout();
        Object object4 = object3 == null ? null : (object3 = this.getFadeout().clone());
        object3 = object;
        TemplateMusic templateMusic = object;
        object = object4;
        ((TemplateMusic)object3)((String)object2, string2, l10, l11, l12, l13, f10, bl2, bl3, templateAudioTransition, (TemplateAudioTransition)object4);
        object3 = this.getCustomerUUID();
        object2 = templateMusic;
        templateMusic.setCustomerUUID((String)object3);
        return templateMusic;
    }
}

