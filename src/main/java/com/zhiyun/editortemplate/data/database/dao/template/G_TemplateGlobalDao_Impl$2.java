/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.data.database.dao.template;

import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateGlobalDao_Impl;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateEffect;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateFilter;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateGlobal;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateRoi;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateRotate;

public class G_TemplateGlobalDao_Impl$2
extends EntityInsertionAdapter {
    public final /* synthetic */ G_TemplateGlobalDao_Impl this$0;

    public G_TemplateGlobalDao_Impl$2(G_TemplateGlobalDao_Impl g_TemplateGlobalDao_Impl, RoomDatabase roomDatabase) {
        this.this$0 = g_TemplateGlobalDao_Impl;
        super(roomDatabase);
    }

    public void bind(SupportSQLiteStatement supportSQLiteStatement, TemplateGlobal object) {
        double d10;
        double d11;
        double d12;
        long l10;
        long l11 = ((TemplateGlobal)object).getId();
        supportSQLiteStatement.bindLong(1, l11);
        l11 = ((TemplateGlobal)object).getTempId();
        supportSQLiteStatement.bindLong(2, l11);
        l11 = ((TemplateGlobal)object).getDuration();
        supportSQLiteStatement.bindLong(3, l11);
        l11 = ((TemplateGlobal)object).getTimebase();
        int n11 = 4;
        float f10 = 5.6E-45f;
        supportSQLiteStatement.bindLong(n11, l11);
        Object object2 = ((TemplateGlobal)object).getRender();
        int n12 = 5;
        float f11 = 7.0E-45f;
        if (object2 == null) {
            supportSQLiteStatement.bindNull(n12);
        } else {
            object2 = ((TemplateGlobal)object).getRender();
            supportSQLiteStatement.bindString(n12, (String)object2);
        }
        long l12 = ((TemplateGlobal)object).getDisplayType();
        supportSQLiteStatement.bindLong(6, l12);
        float f12 = 9.8E-45f;
        double d13 = ((TemplateGlobal)object).getVolume();
        supportSQLiteStatement.bindDouble(7, d13);
        long l13 = (long)((TemplateGlobal)object).isMute();
        supportSQLiteStatement.bindLong(8, l13);
        int n13 = ((TemplateGlobal)object).isVoiceEnable();
        l13 = n13;
        supportSQLiteStatement.bindLong(9, l13);
        object2 = ((TemplateGlobal)object).getFilter();
        n12 = 13;
        f11 = 1.8E-44f;
        n11 = 12;
        f10 = 1.7E-44f;
        int n10 = 10;
        float f13 = 1.4E-44f;
        int n14 = 11;
        float f14 = 1.5E-44f;
        if (object2 != null) {
            int n15 = ((TemplateFilter)object2).isEnable();
            long l14 = n15;
            supportSQLiteStatement.bindLong(n10, l14);
            String string2 = ((TemplateFilter)object2).getName();
            if (string2 == null) {
                supportSQLiteStatement.bindNull(n14);
            } else {
                string2 = ((TemplateFilter)object2).getName();
                supportSQLiteStatement.bindString(n14, string2);
            }
            n10 = (int)(((TemplateFilter)object2).isLocalSource() ? 1 : 0);
            l10 = n10;
            supportSQLiteStatement.bindLong(n11, l10);
            f12 = ((TemplateFilter)object2).getStrength();
            d12 = f12;
            supportSQLiteStatement.bindDouble(n12, d12);
        } else {
            supportSQLiteStatement.bindNull(n10);
            supportSQLiteStatement.bindNull(n14);
            supportSQLiteStatement.bindNull(n11);
            supportSQLiteStatement.bindNull(n12);
        }
        object2 = ((TemplateGlobal)object).getEffect();
        n12 = 21;
        f11 = 2.9E-44f;
        n11 = 20;
        f10 = 2.8E-44f;
        n10 = 19;
        f13 = 2.7E-44f;
        n14 = 18;
        f14 = 2.5E-44f;
        int n16 = 17;
        float f15 = 2.4E-44f;
        int n17 = 16;
        float f16 = 2.24E-44f;
        int n18 = 15;
        float f17 = 2.1E-44f;
        int n19 = 14;
        float f18 = 2.0E-44f;
        if (object2 != null) {
            int n20 = ((TemplateEffect)object2).isEnable();
            long l15 = n20;
            supportSQLiteStatement.bindLong(n19, l15);
            f18 = ((TemplateEffect)object2).getSaturation();
            double d14 = f18;
            supportSQLiteStatement.bindDouble(n18, d14);
            f17 = ((TemplateEffect)object2).getContrast();
            double d15 = f17;
            supportSQLiteStatement.bindDouble(n17, d15);
            f16 = ((TemplateEffect)object2).getTemperature();
            d11 = f16;
            supportSQLiteStatement.bindDouble(n16, d11);
            f15 = ((TemplateEffect)object2).getHue();
            double d16 = f15;
            supportSQLiteStatement.bindDouble(n14, d16);
            f14 = ((TemplateEffect)object2).getExposure();
            double d17 = f14;
            supportSQLiteStatement.bindDouble(n10, d17);
            f13 = ((TemplateEffect)object2).getVignette();
            d10 = f13;
            supportSQLiteStatement.bindDouble(n11, d10);
            f12 = ((TemplateEffect)object2).getSharpen();
            d12 = f12;
            supportSQLiteStatement.bindDouble(n12, d12);
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
        object2 = ((TemplateGlobal)object).getRotate();
        n12 = 23;
        f11 = 3.2E-44f;
        n11 = 22;
        f10 = 3.1E-44f;
        if (object2 != null) {
            n10 = (int)(((TemplateRotate)object2).isEnable() ? 1 : 0);
            l10 = n10;
            supportSQLiteStatement.bindLong(n11, l10);
            int n21 = ((TemplateRotate)object2).getRotate();
            l13 = n21;
            supportSQLiteStatement.bindLong(n12, l13);
        } else {
            supportSQLiteStatement.bindNull(n11);
            supportSQLiteStatement.bindNull(n12);
        }
        object = ((TemplateGlobal)object).getRoi();
        int n22 = 30;
        f12 = 4.2E-44f;
        n12 = 29;
        f11 = 4.1E-44f;
        n11 = 27;
        f10 = 3.8E-44f;
        n10 = 26;
        f13 = 3.6E-44f;
        n14 = 24;
        f14 = 3.4E-44f;
        int n23 = 28;
        f15 = 3.9E-44f;
        n17 = 25;
        f16 = 3.5E-44f;
        if (object != null) {
            n18 = (int)(((TemplateRoi)object).isEnable() ? 1 : 0);
            long l16 = n18;
            supportSQLiteStatement.bindLong(n14, l16);
            String string3 = ((TemplateRoi)object).getStartCenter();
            if (string3 == null) {
                supportSQLiteStatement.bindNull(n17);
            } else {
                string3 = ((TemplateRoi)object).getStartCenter();
                supportSQLiteStatement.bindString(n17, string3);
            }
            f14 = ((TemplateRoi)object).getStartWidth();
            d11 = f14;
            supportSQLiteStatement.bindDouble(n10, d11);
            f13 = ((TemplateRoi)object).getStartHeight();
            d10 = f13;
            supportSQLiteStatement.bindDouble(n11, d10);
            String string4 = ((TemplateRoi)object).getEndCenter();
            if (string4 == null) {
                supportSQLiteStatement.bindNull(n23);
            } else {
                string4 = ((TemplateRoi)object).getEndCenter();
                supportSQLiteStatement.bindString(n23, string4);
            }
            f10 = ((TemplateRoi)object).getEndWidth();
            d12 = f10;
            supportSQLiteStatement.bindDouble(n12, d12);
            f11 = ((TemplateRoi)object).getEndHeight();
            d13 = f11;
            supportSQLiteStatement.bindDouble(n22, d13);
            int n24 = 31;
            f12 = 4.3E-44f;
            l12 = ((TemplateRoi)object).getDuration();
            supportSQLiteStatement.bindLong(n24, l12);
        } else {
            supportSQLiteStatement.bindNull(n14);
            supportSQLiteStatement.bindNull(n17);
            supportSQLiteStatement.bindNull(n10);
            supportSQLiteStatement.bindNull(n11);
            supportSQLiteStatement.bindNull(n23);
            supportSQLiteStatement.bindNull(n12);
            supportSQLiteStatement.bindNull(n22);
            int n25 = 31;
            supportSQLiteStatement.bindNull(n25);
        }
    }

    public String createQuery() {
        return "INSERT OR IGNORE INTO `TemplateGlobal` (`id`,`temp_id`,`temp_duration`,`temp_timebase`,`temp_render`,`temp_display_type`,`temp_volume`,`temp_mute`,`voice_enable`,`filter_enable`,`filter_name`,`filter_local_source`,`filter_strength`,`effect_enable`,`effect_saturation`,`effect_contrast`,`effect_temperature`,`effect_hue`,`effect_exposure`,`effect_vignette`,`effect_sharpen`,`rotate_enable`,`rotate_rotate`,`roi_enable`,`roi_start_center`,`roi_start_width`,`roi_start_height`,`roi_end_center`,`roi_end_width`,`roi_end_height`,`roi_duration`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    }
}

