/*
 * Decompiled with CFR 0.151.
 */
package d.v.v.q;

import com.meicam.sdk.NvsFx;
import com.meicam.sdk.NvsTimeline;
import com.meicam.sdk.NvsTimelineVideoFx;
import com.zhiyun.nvseditor.data.NvsTimelineData;
import d.v.e.l.h2;
import d.v.h.m.b;
import d.v.v.j.h;

public class k {
    public static void a(NvsTimeline nvsTimeline) {
        nvsTimeline.deleteWatermark();
        b b10 = new b();
        b10.v(1);
        b10.q("assets:/shuiyin.png");
        int n10 = h2.b(56.5f);
        b10.m(n10);
        n10 = h2.b(14.0f);
        b10.l(n10);
        float f10 = 5.0f;
        int n11 = h2.b(f10);
        b10.n(n11);
        n10 = h2.b(f10);
        b10.o(n10);
        b10.r(1.0f);
        k.d(nvsTimeline, b10);
    }

    public static void b(NvsTimeline nvsTimeline, String string2) {
        nvsTimeline.deleteWatermark();
        b b10 = new b();
        b10.v(1);
        b10.q(string2);
        b10.m(0);
        b10.l(0);
        float f10 = 5.0f;
        int n10 = h2.b(f10);
        b10.n(n10);
        int n11 = h2.b(f10);
        b10.o(n11);
        b10.r(1.0f);
        k.d(nvsTimeline, b10);
    }

    public static NvsTimelineVideoFx c(NvsTimeline nvsObject, int n10, int n11, String string2, int n12, int n13, String string3, float f10, float f11, float f12) {
        long l10 = ((NvsTimeline)nvsObject).getDuration();
        Object object = nvsObject;
        nvsObject = ((NvsTimeline)nvsObject).addBuiltinTimelineVideoFx(0L, l10, "Storyboard");
        object = new StringBuilder();
        ((StringBuilder)object).append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>        <storyboard sceneWidth=\"");
        ((StringBuilder)object).append(n10);
        ((StringBuilder)object).append("\" sceneHeight=\"");
        ((StringBuilder)object).append(n11);
        ((StringBuilder)object).append("\">           <track source=\"");
        ((StringBuilder)object).append(string2);
        ((StringBuilder)object).append("\" width=\"");
        ((StringBuilder)object).append(n12);
        ((StringBuilder)object).append("\" height=\"");
        ((StringBuilder)object).append(n13);
        ((StringBuilder)object).append("\" clipStart=\"0\" clipDuration=\"");
        ((StringBuilder)object).append(2000);
        ((StringBuilder)object).append("\" repeat=\"");
        n10 = 1;
        ((StringBuilder)object).append(n10 != 0);
        ((StringBuilder)object).append("\"><effect name=\"transform\"><param name=\"opacity\" value=\"1\"/><param name=\"transX\" value=\"0\"/><param name=\"transY\" value=\"0\"/></effect></track></storyboard>");
        String string4 = ((StringBuilder)object).toString();
        ((NvsFx)nvsObject).setStringVal("Resource Dir", string3);
        ((NvsFx)nvsObject).setStringVal("Description String", string4);
        ((NvsFx)nvsObject).setBooleanVal("Is Animated Sticker", n10 != 0);
        double d10 = f12;
        ((NvsFx)nvsObject).setFloatVal("Sticker Scale", d10);
        d10 = f10;
        ((NvsFx)nvsObject).setFloatVal("Sticker TransX", d10);
        d10 = -f11;
        ((NvsFx)nvsObject).setFloatVal("Sticker TransY", d10);
        return nvsObject;
    }

    public static void d(NvsTimeline nvsTimeline, b b10) {
        if (b10 != null && nvsTimeline != null) {
            int n10 = b10.k();
            int n11 = b10.b();
            int n12 = b10.a();
            String string2 = b10.f();
            int n13 = b10.c();
            int n14 = b10.d();
            Object object = h.t().n();
            ((NvsTimelineData)object).setWaterMarkPath(string2);
            int n15 = 1;
            if (n10 == n15) {
                float f10 = b10.g();
                n10 = 2;
                object = nvsTimeline;
                int n16 = n11;
                int n17 = n12;
                n12 = n10;
                nvsTimeline.addWatermark(string2, n11, n17, f10, n10, n13, n14);
            } else {
                nvsTimeline.deleteWatermark();
                String string3 = b10.e();
                String string4 = b10.f();
                int n18 = 1080;
                int n19 = 821;
                float f11 = b10.i();
                float f12 = b10.j();
                float f13 = 1.0f;
                object = nvsTimeline;
                k.c(nvsTimeline, n18, n19, string3, n11, n12, string4, f11, f12, f13);
            }
        }
    }
}

