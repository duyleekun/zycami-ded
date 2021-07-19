/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.api.entity.sticker;

import androidx.databinding.BaseObservable;
import d.v.e.l.w1;

public class StickerTabInfo
extends BaseObservable {
    private long id;
    private String label;
    private int labelIndex;
    private String label_en;
    private String label_tw;

    public long getId() {
        return this.id;
    }

    public String getLabel() {
        return this.label;
    }

    public int getLabelIndex() {
        return this.labelIndex;
    }

    public String getLabel_en() {
        return this.label_en;
    }

    public String getLabel_tw() {
        return this.label_tw;
    }

    public StickerTabInfo setId(long l10) {
        this.id = l10;
        return this;
    }

    public StickerTabInfo setLabel(String string2) {
        this.label = string2;
        return this;
    }

    public StickerTabInfo setLabelIndex(int n10) {
        this.labelIndex = n10;
        this.notifyPropertyChanged(77);
        return this;
    }

    public StickerTabInfo setLabel_en(String string2) {
        this.label_en = string2;
        return this;
    }

    public StickerTabInfo setLabel_tw(String string2) {
        this.label_tw = string2;
        return this;
    }

    public String showLabel() {
        boolean bl2;
        String string2;
        String string3 = w1.a();
        boolean bl3 = string3.equals(string2 = "zh".toLowerCase());
        string3 = !bl3 && !(bl3 = string3.equals(string2 = "zh_CN".toLowerCase())) ? ((bl2 = string3.equals(string2 = "zh_TW".toLowerCase())) ? this.getLabel_tw() : this.getLabel_en()) : this.getLabel();
        if (string3 == null) {
            string3 = "";
        }
        return string3;
    }
}

