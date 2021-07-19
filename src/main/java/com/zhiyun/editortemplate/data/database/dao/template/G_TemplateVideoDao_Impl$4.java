/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.data.database.dao.template;

import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateVideoDao_Impl;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateEffect;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateFilter;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateRoi;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateRotate;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateRotateFrame;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateTransition;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateVideo;

public class G_TemplateVideoDao_Impl$4
extends EntityDeletionOrUpdateAdapter {
    public final /* synthetic */ G_TemplateVideoDao_Impl this$0;

    public G_TemplateVideoDao_Impl$4(G_TemplateVideoDao_Impl g_TemplateVideoDao_Impl, RoomDatabase roomDatabase) {
        this.this$0 = g_TemplateVideoDao_Impl;
        super(roomDatabase);
    }

    public void bind(SupportSQLiteStatement supportSQLiteStatement, TemplateVideo templateVideo) {
        String string2;
        double d10;
        double d11;
        long l10;
        String string3;
        long l11;
        long l12 = templateVideo.getId();
        supportSQLiteStatement.bindLong(1, l12);
        l12 = templateVideo.getTempId();
        supportSQLiteStatement.bindLong(2, l12);
        l12 = templateVideo.getTimebase();
        supportSQLiteStatement.bindLong(3, l12);
        l12 = templateVideo.getStartTime();
        supportSQLiteStatement.bindLong(4, l12);
        l12 = templateVideo.getEndTime();
        supportSQLiteStatement.bindLong(5, l12);
        l12 = templateVideo.getDuration();
        int n11 = 6;
        float f10 = 8.4E-45f;
        supportSQLiteStatement.bindLong(n11, l12);
        long l13 = (long)templateVideo.isMute();
        supportSQLiteStatement.bindLong(7, l13);
        double d12 = templateVideo.getVolume();
        supportSQLiteStatement.bindDouble(8, d12);
        l13 = (long)templateVideo.isVoiceEnable();
        supportSQLiteStatement.bindLong(9, l13);
        d12 = templateVideo.getRate();
        supportSQLiteStatement.bindDouble(10, d12);
        int n12 = 11;
        float f11 = 1.5E-44f;
        long l14 = templateVideo.getRateType();
        supportSQLiteStatement.bindLong(n12, l14);
        Object object = templateVideo.getBezierRate();
        int n13 = 12;
        if (object == null) {
            supportSQLiteStatement.bindNull(n13);
        } else {
            object = templateVideo.getBezierRate();
            supportSQLiteStatement.bindString(n13, (String)object);
        }
        object = templateVideo.getVideoPath();
        n13 = 13;
        if (object == null) {
            supportSQLiteStatement.bindNull(n13);
        } else {
            object = templateVideo.getVideoPath();
            supportSQLiteStatement.bindString(n13, (String)object);
        }
        l13 = (long)templateVideo.isLocalSource();
        supportSQLiteStatement.bindLong(14, l13);
        n12 = (int)(templateVideo.isReverse() ? 1 : 0);
        l13 = n12;
        supportSQLiteStatement.bindLong(15, l13);
        object = templateVideo.getReversePath();
        n13 = 16;
        if (object == null) {
            supportSQLiteStatement.bindNull(n13);
        } else {
            object = templateVideo.getReversePath();
            supportSQLiteStatement.bindString(n13, (String)object);
        }
        object = templateVideo.getCustomerUUID();
        n13 = 17;
        if (object == null) {
            supportSQLiteStatement.bindNull(n13);
        } else {
            object = templateVideo.getCustomerUUID();
            supportSQLiteStatement.bindString(n13, (String)object);
        }
        object = templateVideo.getFilter();
        n13 = 21;
        n11 = 20;
        f10 = 2.8E-44f;
        int n14 = 18;
        float f12 = 2.5E-44f;
        int n15 = 19;
        float f13 = 2.7E-44f;
        if (object != null) {
            int n10 = ((TemplateFilter)object).isEnable();
            l11 = n10;
            supportSQLiteStatement.bindLong(n14, l11);
            string3 = ((TemplateFilter)object).getName();
            if (string3 == null) {
                supportSQLiteStatement.bindNull(n15);
            } else {
                string3 = ((TemplateFilter)object).getName();
                supportSQLiteStatement.bindString(n15, string3);
            }
            n14 = (int)(((TemplateFilter)object).isLocalSource() ? 1 : 0);
            l10 = n14;
            supportSQLiteStatement.bindLong(n11, l10);
            f11 = ((TemplateFilter)object).getStrength();
            d11 = f11;
            supportSQLiteStatement.bindDouble(n13, d11);
        } else {
            supportSQLiteStatement.bindNull(n14);
            supportSQLiteStatement.bindNull(n15);
            supportSQLiteStatement.bindNull(n11);
            supportSQLiteStatement.bindNull(n13);
        }
        object = templateVideo.getEffect();
        n13 = 29;
        n11 = 28;
        f10 = 3.9E-44f;
        n14 = 27;
        f12 = 3.8E-44f;
        n15 = 26;
        f13 = 3.6E-44f;
        int n10 = 25;
        float f14 = 3.5E-44f;
        int n16 = 24;
        float f15 = 3.4E-44f;
        int n17 = 23;
        float f16 = 3.2E-44f;
        int n18 = 22;
        float f17 = 3.1E-44f;
        if (object != null) {
            int n19 = ((TemplateEffect)object).isEnable();
            long l15 = n19;
            supportSQLiteStatement.bindLong(n18, l15);
            f17 = ((TemplateEffect)object).getSaturation();
            double d13 = f17;
            supportSQLiteStatement.bindDouble(n17, d13);
            f16 = ((TemplateEffect)object).getContrast();
            double d14 = f16;
            supportSQLiteStatement.bindDouble(n16, d14);
            f15 = ((TemplateEffect)object).getTemperature();
            double d15 = f15;
            supportSQLiteStatement.bindDouble(n10, d15);
            f14 = ((TemplateEffect)object).getHue();
            double d16 = f14;
            supportSQLiteStatement.bindDouble(n15, d16);
            f13 = ((TemplateEffect)object).getExposure();
            double d17 = f13;
            supportSQLiteStatement.bindDouble(n14, d17);
            f12 = ((TemplateEffect)object).getVignette();
            d10 = f12;
            supportSQLiteStatement.bindDouble(n11, d10);
            f11 = ((TemplateEffect)object).getSharpen();
            d11 = f11;
            supportSQLiteStatement.bindDouble(n13, d11);
        } else {
            supportSQLiteStatement.bindNull(n18);
            supportSQLiteStatement.bindNull(n17);
            supportSQLiteStatement.bindNull(n16);
            supportSQLiteStatement.bindNull(n10);
            supportSQLiteStatement.bindNull(n15);
            supportSQLiteStatement.bindNull(n14);
            supportSQLiteStatement.bindNull(n11);
            supportSQLiteStatement.bindNull(n13);
        }
        object = templateVideo.getRotate();
        if (object != null) {
            n13 = (int)(((TemplateRotate)object).isEnable() ? 1 : 0);
            n11 = 30;
            f10 = 4.2E-44f;
            l10 = n13;
            supportSQLiteStatement.bindLong(n11, l10);
            n13 = 31;
            n12 = ((TemplateRotate)object).getRotate();
            l13 = n12;
            supportSQLiteStatement.bindLong(n13, l13);
        } else {
            supportSQLiteStatement.bindNull(30);
            n12 = 31;
            f11 = 4.3E-44f;
            supportSQLiteStatement.bindNull(n12);
        }
        object = templateVideo.getTransition();
        n13 = 36;
        n11 = 32;
        f10 = 4.5E-44f;
        if (object != null) {
            string3 = ((TemplateTransition)object).getName();
            if (string3 == null) {
                supportSQLiteStatement.bindNull(n11);
            } else {
                string3 = ((TemplateTransition)object).getName();
                supportSQLiteStatement.bindString(n11, string3);
            }
            l10 = ((TemplateTransition)object).getDuration();
            supportSQLiteStatement.bindLong(33, l10);
            f10 = 4.8E-44f;
            l10 = ((TemplateTransition)object).getTimebase();
            supportSQLiteStatement.bindLong(34, l10);
            n11 = (int)(((TemplateTransition)object).isLocalSource() ? 1 : 0);
            n14 = 35;
            f12 = 4.9E-44f;
            long l16 = n11;
            supportSQLiteStatement.bindLong(n14, l16);
            string2 = ((TemplateTransition)object).getThumb();
            if (string2 == null) {
                supportSQLiteStatement.bindNull(n13);
            } else {
                object = ((TemplateTransition)object).getThumb();
                supportSQLiteStatement.bindString(n13, (String)object);
            }
        } else {
            supportSQLiteStatement.bindNull(n11);
            supportSQLiteStatement.bindNull(33);
            supportSQLiteStatement.bindNull(34);
            n12 = 35;
            f11 = 4.9E-44f;
            supportSQLiteStatement.bindNull(n12);
            supportSQLiteStatement.bindNull(n13);
        }
        object = templateVideo.getRoi();
        n13 = 41;
        n11 = 38;
        f10 = 5.3E-44f;
        if (object != null) {
            n14 = (int)(((TemplateRoi)object).isEnable() ? 1 : 0);
            n15 = 37;
            f13 = 5.2E-44f;
            l11 = n14;
            supportSQLiteStatement.bindLong(n15, l11);
            string3 = ((TemplateRoi)object).getStartCenter();
            if (string3 == null) {
                supportSQLiteStatement.bindNull(n11);
            } else {
                string3 = ((TemplateRoi)object).getStartCenter();
                supportSQLiteStatement.bindString(n11, string3);
            }
            d10 = ((TemplateRoi)object).getStartWidth();
            supportSQLiteStatement.bindDouble(39, d10);
            n11 = 40;
            f10 = 5.6E-44f;
            f12 = ((TemplateRoi)object).getStartHeight();
            d10 = f12;
            supportSQLiteStatement.bindDouble(n11, d10);
            string2 = ((TemplateRoi)object).getEndCenter();
            if (string2 == null) {
                supportSQLiteStatement.bindNull(n13);
            } else {
                string2 = ((TemplateRoi)object).getEndCenter();
                supportSQLiteStatement.bindString(n13, string2);
            }
            d11 = ((TemplateRoi)object).getEndWidth();
            supportSQLiteStatement.bindDouble(42, d11);
            f10 = ((TemplateRoi)object).getEndHeight();
            d11 = f10;
            supportSQLiteStatement.bindDouble(43, d11);
            n13 = 44;
            l13 = ((TemplateRoi)object).getDuration();
            supportSQLiteStatement.bindLong(n13, l13);
        } else {
            supportSQLiteStatement.bindNull(37);
            supportSQLiteStatement.bindNull(n11);
            supportSQLiteStatement.bindNull(39);
            supportSQLiteStatement.bindNull(40);
            supportSQLiteStatement.bindNull(n13);
            supportSQLiteStatement.bindNull(42);
            supportSQLiteStatement.bindNull(43);
            n12 = 44;
            f11 = 6.2E-44f;
            supportSQLiteStatement.bindNull(n12);
        }
        object = templateVideo.getRotateFrame();
        n13 = 46;
        n11 = 45;
        f10 = 6.3E-44f;
        if (object != null) {
            string3 = ((TemplateRotateFrame)object).getCenter();
            if (string3 == null) {
                supportSQLiteStatement.bindNull(n11);
            } else {
                string3 = ((TemplateRotateFrame)object).getCenter();
                supportSQLiteStatement.bindString(n11, string3);
            }
            string2 = ((TemplateRotateFrame)object).getScale();
            if (string2 == null) {
                supportSQLiteStatement.bindNull(n13);
            } else {
                string2 = ((TemplateRotateFrame)object).getScale();
                supportSQLiteStatement.bindString(n13, string2);
            }
            n13 = 47;
            n12 = ((TemplateRotateFrame)object).getRotate();
            l13 = n12;
            supportSQLiteStatement.bindLong(n13, l13);
        } else {
            supportSQLiteStatement.bindNull(n11);
            supportSQLiteStatement.bindNull(n13);
            n12 = 47;
            f11 = 6.6E-44f;
            supportSQLiteStatement.bindNull(n12);
        }
        l14 = templateVideo.getId();
        supportSQLiteStatement.bindLong(48, l14);
    }

    public String createQuery() {
        return "UPDATE OR REPLACE `TemplateVideo` SET `id` = ?,`temp_id` = ?,`timebase` = ?,`start_time` = ?,`end_time` = ?,`duration` = ?,`mute` = ?,`volume` = ?,`voice_enable` = ?,`rate` = ?,`rate_type` = ?,`bezier_rate` = ?,`videoPath` = ?,`is_local_source` = ?,`is_reverse` = ?,`reverse_path` = ?,`customer_uuid` = ?,`filter_enable` = ?,`filter_name` = ?,`filter_local_source` = ?,`filter_strength` = ?,`effect_enable` = ?,`effect_saturation` = ?,`effect_contrast` = ?,`effect_temperature` = ?,`effect_hue` = ?,`effect_exposure` = ?,`effect_vignette` = ?,`effect_sharpen` = ?,`rotate_enable` = ?,`rotate_rotate` = ?,`transition_name` = ?,`transition_duration` = ?,`transition_timebase` = ?,`transition_local_source` = ?,`transition_thumb` = ?,`roi_enable` = ?,`roi_start_center` = ?,`roi_start_width` = ?,`roi_start_height` = ?,`roi_end_center` = ?,`roi_end_width` = ?,`roi_end_height` = ?,`roi_duration` = ?,`rotate_frame_center` = ?,`rotate_frame_scale` = ?,`rotate_frame_rotate` = ? WHERE `id` = ?";
    }
}

