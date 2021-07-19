/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.data.database.dao.template;

import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateGlobalDao_Impl;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateEffect;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateFilter;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateGlobal;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateRoi;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateRotate;

public class G_TemplateGlobalDao_Impl$4
extends EntityDeletionOrUpdateAdapter {
    public final /* synthetic */ G_TemplateGlobalDao_Impl this$0;

    public G_TemplateGlobalDao_Impl$4(G_TemplateGlobalDao_Impl g_TemplateGlobalDao_Impl, RoomDatabase roomDatabase) {
        this.this$0 = g_TemplateGlobalDao_Impl;
        super(roomDatabase);
    }

    public void bind(SupportSQLiteStatement supportSQLiteStatement, TemplateGlobal templateGlobal) {
        double d10;
        double d11;
        double d12;
        double d13;
        long l10;
        String string2;
        long l11 = templateGlobal.getId();
        supportSQLiteStatement.bindLong(1, l11);
        l11 = templateGlobal.getTempId();
        supportSQLiteStatement.bindLong(2, l11);
        l11 = templateGlobal.getDuration();
        supportSQLiteStatement.bindLong(3, l11);
        l11 = templateGlobal.getTimebase();
        int n11 = 4;
        float f10 = 5.6E-45f;
        supportSQLiteStatement.bindLong(n11, l11);
        Object object = templateGlobal.getRender();
        int n12 = 5;
        if (object == null) {
            supportSQLiteStatement.bindNull(n12);
        } else {
            object = templateGlobal.getRender();
            supportSQLiteStatement.bindString(n12, (String)object);
        }
        long l12 = templateGlobal.getDisplayType();
        supportSQLiteStatement.bindLong(6, l12);
        float f11 = 9.8E-45f;
        double d14 = templateGlobal.getVolume();
        supportSQLiteStatement.bindDouble(7, d14);
        long l13 = (long)templateGlobal.isMute();
        supportSQLiteStatement.bindLong(8, l13);
        int n13 = templateGlobal.isVoiceEnable();
        l13 = n13;
        supportSQLiteStatement.bindLong(9, l13);
        object = templateGlobal.getFilter();
        n12 = 13;
        n11 = 12;
        f10 = 1.7E-44f;
        int n10 = 10;
        float f12 = 1.4E-44f;
        int n14 = 11;
        float f13 = 1.5E-44f;
        if (object != null) {
            int n15 = ((TemplateFilter)object).isEnable();
            long l14 = n15;
            supportSQLiteStatement.bindLong(n10, l14);
            string2 = ((TemplateFilter)object).getName();
            if (string2 == null) {
                supportSQLiteStatement.bindNull(n14);
            } else {
                string2 = ((TemplateFilter)object).getName();
                supportSQLiteStatement.bindString(n14, string2);
            }
            n10 = (int)(((TemplateFilter)object).isLocalSource() ? 1 : 0);
            l10 = n10;
            supportSQLiteStatement.bindLong(n11, l10);
            f11 = ((TemplateFilter)object).getStrength();
            d13 = f11;
            supportSQLiteStatement.bindDouble(n12, d13);
        } else {
            supportSQLiteStatement.bindNull(n10);
            supportSQLiteStatement.bindNull(n14);
            supportSQLiteStatement.bindNull(n11);
            supportSQLiteStatement.bindNull(n12);
        }
        object = templateGlobal.getEffect();
        n12 = 21;
        n11 = 20;
        f10 = 2.8E-44f;
        n10 = 19;
        f12 = 2.7E-44f;
        n14 = 18;
        f13 = 2.5E-44f;
        int n16 = 17;
        float f14 = 2.4E-44f;
        int n17 = 16;
        float f15 = 2.24E-44f;
        int n18 = 15;
        float f16 = 2.1E-44f;
        int n19 = 14;
        float f17 = 2.0E-44f;
        if (object != null) {
            int n20 = ((TemplateEffect)object).isEnable();
            long l15 = n20;
            supportSQLiteStatement.bindLong(n19, l15);
            f17 = ((TemplateEffect)object).getSaturation();
            double d15 = f17;
            supportSQLiteStatement.bindDouble(n18, d15);
            f16 = ((TemplateEffect)object).getContrast();
            d12 = f16;
            supportSQLiteStatement.bindDouble(n17, d12);
            f15 = ((TemplateEffect)object).getTemperature();
            double d16 = f15;
            supportSQLiteStatement.bindDouble(n16, d16);
            f14 = ((TemplateEffect)object).getHue();
            double d17 = f14;
            supportSQLiteStatement.bindDouble(n14, d17);
            f13 = ((TemplateEffect)object).getExposure();
            d11 = f13;
            supportSQLiteStatement.bindDouble(n10, d11);
            f12 = ((TemplateEffect)object).getVignette();
            d10 = f12;
            supportSQLiteStatement.bindDouble(n11, d10);
            f11 = ((TemplateEffect)object).getSharpen();
            d13 = f11;
            supportSQLiteStatement.bindDouble(n12, d13);
        } else {
            supportSQLiteStatement.bindNull(n19);
            supportSQLiteStatement.bindNull(n18);
            supportSQLiteStatement.bindNull(n17);
            supportSQLiteStatement.bindNull(n16);
            supportSQLiteStatement.bindNull(n14);
            supportSQLiteStatement.bindNull(n10);
            supportSQLiteStatement.bindNull(n11);
            supportSQLiteStatement.bindNull(n12);
        }
        object = templateGlobal.getRotate();
        n12 = 23;
        n11 = 22;
        f10 = 3.1E-44f;
        if (object != null) {
            n10 = (int)(((TemplateRotate)object).isEnable() ? 1 : 0);
            l10 = n10;
            supportSQLiteStatement.bindLong(n11, l10);
            int n21 = ((TemplateRotate)object).getRotate();
            l13 = n21;
            supportSQLiteStatement.bindLong(n12, l13);
        } else {
            supportSQLiteStatement.bindNull(n11);
            supportSQLiteStatement.bindNull(n12);
        }
        object = templateGlobal.getRoi();
        n12 = 30;
        n11 = 29;
        f10 = 4.1E-44f;
        n10 = 27;
        f12 = 3.8E-44f;
        n14 = 26;
        f13 = 3.6E-44f;
        int n22 = 24;
        f14 = 3.4E-44f;
        n17 = 28;
        f15 = 3.9E-44f;
        n18 = 25;
        f16 = 3.5E-44f;
        if (object != null) {
            n19 = (int)(((TemplateRoi)object).isEnable() ? 1 : 0);
            long l16 = n19;
            supportSQLiteStatement.bindLong(n22, l16);
            String string3 = ((TemplateRoi)object).getStartCenter();
            if (string3 == null) {
                supportSQLiteStatement.bindNull(n18);
            } else {
                string3 = ((TemplateRoi)object).getStartCenter();
                supportSQLiteStatement.bindString(n18, string3);
            }
            f14 = ((TemplateRoi)object).getStartWidth();
            d12 = f14;
            supportSQLiteStatement.bindDouble(n14, d12);
            f13 = ((TemplateRoi)object).getStartHeight();
            d11 = f13;
            supportSQLiteStatement.bindDouble(n10, d11);
            string2 = ((TemplateRoi)object).getEndCenter();
            if (string2 == null) {
                supportSQLiteStatement.bindNull(n17);
            } else {
                string2 = ((TemplateRoi)object).getEndCenter();
                supportSQLiteStatement.bindString(n17, string2);
            }
            f12 = ((TemplateRoi)object).getEndWidth();
            d10 = f12;
            supportSQLiteStatement.bindDouble(n11, d10);
            f10 = ((TemplateRoi)object).getEndHeight();
            d13 = f10;
            supportSQLiteStatement.bindDouble(n12, d13);
            n12 = 31;
            l13 = ((TemplateRoi)object).getDuration();
            supportSQLiteStatement.bindLong(n12, l13);
        } else {
            supportSQLiteStatement.bindNull(n22);
            supportSQLiteStatement.bindNull(n18);
            supportSQLiteStatement.bindNull(n14);
            supportSQLiteStatement.bindNull(n10);
            supportSQLiteStatement.bindNull(n17);
            supportSQLiteStatement.bindNull(n11);
            supportSQLiteStatement.bindNull(n12);
            int n23 = 31;
            f11 = 4.3E-44f;
            supportSQLiteStatement.bindNull(n23);
        }
        l12 = templateGlobal.getId();
        supportSQLiteStatement.bindLong(32, l12);
    }

    public String createQuery() {
        return "UPDATE OR REPLACE `TemplateGlobal` SET `id` = ?,`temp_id` = ?,`temp_duration` = ?,`temp_timebase` = ?,`temp_render` = ?,`temp_display_type` = ?,`temp_volume` = ?,`temp_mute` = ?,`voice_enable` = ?,`filter_enable` = ?,`filter_name` = ?,`filter_local_source` = ?,`filter_strength` = ?,`effect_enable` = ?,`effect_saturation` = ?,`effect_contrast` = ?,`effect_temperature` = ?,`effect_hue` = ?,`effect_exposure` = ?,`effect_vignette` = ?,`effect_sharpen` = ?,`rotate_enable` = ?,`rotate_rotate` = ?,`roi_enable` = ?,`roi_start_center` = ?,`roi_start_width` = ?,`roi_start_height` = ?,`roi_end_center` = ?,`roi_end_width` = ?,`roi_end_height` = ?,`roi_duration` = ? WHERE `id` = ?";
    }
}

