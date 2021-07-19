/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.quvideo.mobile.external.component.cloudengine;

import android.content.Context;
import com.quvideo.mobile.external.component.cloudcomposite.protocal.OnCompositeListener;
import com.quvideo.mobile.external.component.cloudengine.core.OooO00o;
import com.quvideo.mobile.external.component.cloudengine.model.CloudEngineConfig;
import com.quvideo.mobile.external.component.cloudengine.model.CompositeConfig;
import com.quvideo.mobile.external.component.cloudengine.model.TemplateConfig;
import com.quvideo.mobile.external.component.cloudengine.model.VideoConfig;
import com.quvideo.mobile.external.component.cloudengine.protocal.OnTemplateListener;
import com.quvideo.mobile.external.component.cloudengine.protocal.OnVideoListener;
import java.util.List;

public class QVCloudEngine {
    public static void cancelUpload() {
        OooO00o.OooO0OO().OooO00o();
    }

    public static void composite(CompositeConfig compositeConfig, OnCompositeListener onCompositeListener) {
        OooO00o.OooO0OO().OooO00o(compositeConfig, onCompositeListener);
    }

    public static void getTemplates(TemplateConfig templateConfig, OnTemplateListener onTemplateListener) {
        OooO00o.OooO0OO().OooO00o(templateConfig, onTemplateListener);
    }

    public static void getVideos(VideoConfig videoConfig, OnVideoListener onVideoListener) {
        OooO00o.OooO0OO().OooO00o(videoConfig, onVideoListener);
    }

    public static void initialize(Context context, CloudEngineConfig cloudEngineConfig) {
        OooO00o.OooO0OO().OooO00o(context, cloudEngineConfig);
    }

    public static void report(List list) {
        OooO00o.OooO0OO().OooO0O0(list);
    }
}

