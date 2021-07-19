/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.PointF
 *  android.text.TextUtils
 *  android.util.Size
 */
package d.v.v.q;

import android.graphics.PointF;
import android.text.TextUtils;
import android.util.Size;
import com.meicam.sdk.NvsAnimatedSticker;
import com.meicam.sdk.NvsArbitraryData;
import com.meicam.sdk.NvsAudioResolution;
import com.meicam.sdk.NvsAudioTrack;
import com.meicam.sdk.NvsClip;
import com.meicam.sdk.NvsColor;
import com.meicam.sdk.NvsFx;
import com.meicam.sdk.NvsMaskRegionInfo;
import com.meicam.sdk.NvsMaskRegionInfo$Ellipse2D;
import com.meicam.sdk.NvsMaskRegionInfo$RegionInfo;
import com.meicam.sdk.NvsObject;
import com.meicam.sdk.NvsPosition2D;
import com.meicam.sdk.NvsRational;
import com.meicam.sdk.NvsSize;
import com.meicam.sdk.NvsStreamingContext;
import com.meicam.sdk.NvsTimeline;
import com.meicam.sdk.NvsTimelineAnimatedSticker;
import com.meicam.sdk.NvsTimelineCaption;
import com.meicam.sdk.NvsTrack;
import com.meicam.sdk.NvsTrackVideoFx;
import com.meicam.sdk.NvsVideoClip;
import com.meicam.sdk.NvsVideoResolution;
import com.meicam.sdk.NvsVideoTrack;
import com.zhiyun.editorinterface.edit.MediaType;
import com.zhiyun.nvseditor.data.NvsAssetInfo;
import com.zhiyun.nvseditor.data.NvsTimelineData;
import d.v.e.l.h2;
import d.v.h.d.a$a;
import d.v.h.d.c;
import d.v.h.e.d;
import d.v.h.m.b;
import d.v.v.m.a;
import d.v.v.q.f;
import d.v.v.q.h;
import d.v.v.q.j;
import d.v.v.q.k;
import java.util.List;

public class i {
    private static final String a = "i";

    private static void A(NvsTimeline nvsTimeline) {
        int n10;
        if (nvsTimeline == null) {
            return;
        }
        Object object = i.r().getMusicInfoList();
        if (object != null) {
            i.j(nvsTimeline, (List)object);
        }
        if ((object = i.r().getRecordInfoList()) != null) {
            i.k(nvsTimeline, (List)object);
        }
        if ((object = i.r().getGlobalFrameEffectInfo()) != null && (n10 = ((d.v.h.f.a)object).f()) >= 0) {
            i.i(nvsTimeline, (d.v.h.f.a)object);
        }
        i.h(nvsTimeline, (d.v.h.f.a)object);
        object = i.r().getPasteInfoList();
        if (object != null) {
            i.z(nvsTimeline, (List)object);
        }
        if ((object = i.r().getTextInfoList()) != null) {
            i.x(nvsTimeline, (List)object);
        }
        i.w();
    }

    private static void B(NvsTimelineCaption nvsTimelineCaption, d.v.h.d.d d10) {
        float f10;
        float f11;
        float f12;
        boolean bl2;
        Object object;
        int n10;
        boolean bl3;
        if (nvsTimelineCaption == null) {
            return;
        }
        if (d10 == null) {
            return;
        }
        Object object2 = d10.t();
        int n11 = 1;
        if (object2 != null) {
            object2 = d10.u();
            if (object2 != null && !(bl3 = TextUtils.isEmpty((CharSequence)object2))) {
                object2 = d10.u();
                nvsTimelineCaption.applyCaptionStyle((String)object2);
            } else {
                object2 = d10.t().b();
                if (object2 != null && (n10 = ((NvsAssetInfo)(object2 = ((f)(object = f.d())).j((String)object2))).getStatus()) == n11) {
                    object2 = ((NvsAssetInfo)object2).getUuid();
                    nvsTimelineCaption.applyCaptionStyle((String)object2);
                }
            }
        }
        bl3 = false;
        float f13 = 0.0f;
        object2 = null;
        nvsTimelineCaption.setClipAffinityEnabled(false);
        object = d10.v();
        if (object != null && !(bl2 = ((String)object).isEmpty())) {
            nvsTimelineCaption.setFontByFilePath((String)object);
        }
        n10 = d10.w();
        float f14 = n10;
        bl2 = false;
        float f15 = f14 - 0.0f;
        Object object3 = f15 == 0.0f ? 0 : (f15 > 0.0f ? 1 : -1);
        if (object3 > 0) {
            nvsTimelineCaption.setFontSize(f14);
        }
        if ((n10 = d10.x()) != 0 && (object = j.c(j.a(n10))) != null) {
            nvsTimelineCaption.setTextColor((NvsColor)object);
        }
        object = d10.z();
        float[] fArray = d10.j();
        float f16 = d10.d();
        if (object != null) {
            nvsTimelineCaption.setCaptionTranslation((PointF)object);
        }
        if ((n10 = (int)((f12 = (f14 = fArray[0]) - 0.0f) == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1))) != 0) {
            f13 = fArray[0];
            nvsTimelineCaption.setScaleX(f13);
        }
        if (bl3 = (f11 = (f13 = fArray[n11]) - 0.0f) == 0.0f ? 0 : (f11 > 0.0f ? 1 : -1)) {
            f13 = fArray[n11];
            nvsTimelineCaption.setScaleY(f13);
        }
        if (bl3 = (f10 = f16 - 0.0f) == 0.0f ? 0 : (f10 > 0.0f ? 1 : -1)) {
            nvsTimelineCaption.setRotationZ(f16);
        }
    }

    public static void C() {
        NvsVideoTrack nvsVideoTrack = h.h0();
        if (nvsVideoTrack == null) {
            return;
        }
        NvsTimelineData nvsTimelineData = i.r();
        boolean bl2 = nvsTimelineData.isGlobalZoomModeEnable();
        NvsTimelineData nvsTimelineData2 = i.r();
        int n10 = nvsTimelineData2.getGlobalZoomMode();
        List list = i.r().getMediaInfoList();
        int n11 = nvsVideoTrack.getClipCount();
        for (int i10 = 0; i10 < n11; ++i10) {
            d d10 = (d)list.get(i10);
            NvsVideoClip nvsVideoClip = nvsVideoTrack.getClipByIndex(i10);
            int n12 = bl2 ? n10 : d10.A();
            d10 = d10.z();
            d.v.v.u.a.h(nvsVideoClip, n12, (Size)d10);
        }
    }

    private static void a(float f10) {
        Object object;
        Object object2;
        Object object3;
        boolean bl2;
        long l10;
        NvsObject nvsObject = h.h0();
        Object object4 = ((NvsVideoTrack)nvsObject).getTrackVideoFxByPosition(l10 = 40000L);
        if (object4 != null) {
            object4 = object4.iterator();
            while (bl2 = object4.hasNext()) {
                boolean bl3;
                object3 = (NvsTrackVideoFx)object4.next();
                if (object3 == null || !(bl3 = ((String)(object2 = ((NvsTrackVideoFx)object3).getBuiltinTrackVideoFxName())).equals(object = "Mask Generator"))) continue;
                break;
            }
        } else {
            bl2 = false;
            object3 = null;
        }
        if (object3 != null) {
            ((NvsVideoTrack)nvsObject).removeTrackVideoFx((NvsTrackVideoFx)object3);
        }
        long l11 = ((NvsTrack)nvsObject).getDuration();
        nvsObject = ((NvsVideoTrack)nvsObject).addBuiltinTrackVideoFx(0L, l11, "Mask Generator");
        object4 = new NvsMaskRegionInfo();
        object3 = new NvsMaskRegionInfo$RegionInfo(2);
        object2 = new NvsMaskRegionInfo$Ellipse2D();
        object = new NvsPosition2D(0.0f, 0.0f);
        ((NvsMaskRegionInfo$Ellipse2D)object2).setCenter((NvsPosition2D)object);
        ((NvsMaskRegionInfo$Ellipse2D)object2).setA(f10);
        ((NvsMaskRegionInfo$Ellipse2D)object2).setB(f10);
        ((NvsMaskRegionInfo$RegionInfo)object3).setEllipse2D((NvsMaskRegionInfo$Ellipse2D)object2);
        ((NvsMaskRegionInfo)object4).addRegionInfo((NvsMaskRegionInfo$RegionInfo)object3);
        bl2 = true;
        ((NvsFx)nvsObject).setIntVal("Region Coordinate System Type", (int)(bl2 ? 1 : 0));
        ((NvsFx)nvsObject).setBooleanVal("Reverse Region", false);
        ((NvsFx)nvsObject).setBooleanVal("Ignore Region Background", bl2);
        ((NvsFx)nvsObject).setBooleanVal("Enable Region", bl2);
        ((NvsFx)nvsObject).setArbDataVal("Region Data", (NvsArbitraryData)object4);
    }

    private static boolean b(NvsVideoTrack nvsObject, d d10) {
        int n10 = 0;
        float f10 = 0.0f;
        Object object = null;
        if (nvsObject != null && d10 != null) {
            String string2 = d10.E();
            MediaType mediaType = d10.f();
            Object object2 = MediaType.VIDEO;
            boolean bl2 = true;
            if (mediaType == object2) {
                nvsObject = ((NvsVideoTrack)nvsObject).appendClip(string2);
            } else {
                long l10 = NvsStreamingContext.getInstance().getAVFileInfo(string2).getDuration();
                long l11 = d10.d();
                l11 = Math.max(l10, l11);
                l10 = 0L;
                object2 = nvsObject;
                nvsObject = ((NvsVideoTrack)nvsObject).appendClip(string2, l10, l11);
                long l12 = d10.d();
                ((NvsClip)nvsObject).changeTrimOutPoint(l12, bl2);
            }
            if (nvsObject == null) {
                return false;
            }
            object = MediaType.GIF;
            if (mediaType == object) {
                n10 = 2;
                f10 = 2.8E-45f;
                ((NvsVideoClip)nvsObject).setClipWrapMode(n10);
            }
            object = i.r();
            n10 = ((NvsTimelineData)object).getAspectRadio();
            int n11 = 4;
            string2 = null;
            if (n10 == n11) {
                ((NvsVideoClip)nvsObject).setPanAndScan(0.0f, 0.0f);
            } else {
                n10 = 1065353216;
                f10 = 1.0f;
                ((NvsVideoClip)nvsObject).setPanAndScan(0.0f, f10);
            }
            ((NvsVideoClip)nvsObject).setSoftWareDecoding(bl2);
            return i.v((NvsVideoClip)nvsObject, d10);
        }
        return false;
    }

    private static void c(NvsTimeline nvsTimeline) {
        b b10 = new b();
        b10.v(1);
        b10.q("assets:/shuiyin.png");
        int n10 = h2.b(56.5f);
        b10.m(n10);
        n10 = h2.b(14.0f);
        b10.l(n10);
        float f10 = 10.0f;
        int n11 = h2.b(f10);
        b10.n(n11);
        n10 = h2.b(f10);
        b10.o(n10);
        b10.r(1.0f);
        k.d(nvsTimeline, b10);
    }

    private static boolean d(NvsVideoClip nvsVideoClip, d.v.h.f.a a10) {
        boolean bl2 = false;
        float f10 = 0.0f;
        d.v.v.h.a a11 = null;
        if (nvsVideoClip != null && a10 != null) {
            float f11;
            float f12;
            float f13;
            int n10;
            float f14;
            float f15;
            float f16 = a10.e();
            int n11 = -1073741824;
            float f17 = -2.0f;
            float f18 = f16 - f17;
            Object object = f18 == 0.0f ? 0 : (f18 > 0.0f ? 1 : -1);
            if (object != false) {
                d.v.v.h.a a12 = d.v.v.h.a.x();
                f15 = a10.e();
                a12.e(nvsVideoClip, 0, f15);
            }
            f10 = a10.d();
            bl2 = f10 == f17 ? 0 : (f10 > f17 ? 1 : -1);
            object = true;
            f16 = Float.MIN_VALUE;
            if (bl2) {
                a11 = d.v.v.h.a.x();
                f15 = a10.d();
                a11.e(nvsVideoClip, (int)object, f15);
            }
            if (bl2 = (f14 = (f10 = a10.o()) - f17) == 0.0f ? 0 : (f14 > 0.0f ? 1 : -1)) {
                a11 = d.v.v.h.a.x();
                n10 = 2;
                f15 = 2.8E-45f;
                f13 = a10.o();
                a11.e(nvsVideoClip, n10, f13);
            }
            if (bl2 = (f12 = (f10 = a10.q()) - f17) == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1)) {
                a11 = d.v.v.h.a.x();
                n10 = 5;
                f15 = 7.0E-45f;
                f13 = a10.q();
                a11.e(nvsVideoClip, n10, f13);
            }
            if (bl2 = (f11 = (f10 = a10.p()) - f17) == 0.0f ? 0 : (f11 > 0.0f ? 1 : -1)) {
                a11 = d.v.v.h.a.x();
                n11 = 6;
                f17 = 8.4E-45f;
                float f19 = a10.p();
                a11.e(nvsVideoClip, n11, f19);
            }
            return (boolean)object;
        }
        return false;
    }

    public static boolean e(NvsVideoTrack nvsVideoTrack, d.v.h.f.a a10) {
        if (a10 != null && nvsVideoTrack != null) {
            int n10 = nvsVideoTrack.getClipCount();
            for (int i10 = 0; i10 < n10; ++i10) {
                NvsVideoClip nvsVideoClip = nvsVideoTrack.getClipByIndex(i10);
                if (nvsVideoClip == null) continue;
                i.d(nvsVideoClip, a10);
            }
            return true;
        }
        return false;
    }

    public static boolean f(NvsVideoClip nvsVideoClip, d.v.h.f.a a10) {
        if (a10 != null && nvsVideoClip != null) {
            return i.d(nvsVideoClip, a10);
        }
        return false;
    }

    public static boolean g(NvsVideoClip nvsVideoClip, d.v.h.f.a a10) {
        if (a10 != null && nvsVideoClip != null) {
            return d.v.v.h.a.x().a(nvsVideoClip, a10);
        }
        return false;
    }

    private static boolean h(NvsTimeline nvsObject, d.v.h.f.a a10) {
        nvsObject = h.h0();
        if (nvsObject == null) {
            return false;
        }
        return i.e((NvsVideoTrack)nvsObject, a10);
    }

    private static boolean i(NvsTimeline nvsObject, d.v.h.f.a a10) {
        nvsObject = h.h0();
        if (nvsObject == null) {
            return false;
        }
        return d.v.v.h.a.x().f((NvsVideoTrack)nvsObject, a10);
    }

    public static boolean j(NvsTimeline nvsObject, List object) {
        boolean bl2;
        nvsObject = h.G();
        boolean bl3 = false;
        Object object2 = null;
        if (nvsObject == null) {
            return false;
        }
        if (object != null && !(bl2 = object.isEmpty())) {
            float f10;
            ((NvsTrack)nvsObject).removeAllClips();
            object = object.iterator();
            while (true) {
                bl3 = object.hasNext();
                f10 = 1.0f;
                if (!bl3) break;
                object2 = object.next();
                d.v.h.h.b b10 = object2;
                b10 = (d.v.h.h.b)object2;
                if (b10 == null) continue;
                String string2 = b10.k();
                long l10 = b10.d();
                long l11 = b10.m();
                long l12 = b10.f();
                object2 = nvsObject;
                object2 = ((NvsAudioTrack)nvsObject).addClip(string2, l10, l11, l12);
                if (object2 == null) continue;
                float f11 = b10.n() * f10;
                ((NvsClip)object2).setVolumeGain(f11, f11);
            }
            object = i.r();
            boolean bl4 = ((NvsTimelineData)object).isGlobalMusicVolumeEnable();
            if (bl4) {
                object = i.r();
                float f12 = ((NvsTimelineData)object).getGlobalMusicVolume() * f10;
                ((NvsTrack)nvsObject).setVolumeGain(f12, f12);
            }
            return true;
        }
        ((NvsTrack)nvsObject).removeAllClips();
        return false;
    }

    public static boolean k(NvsTimeline nvsObject, List object) {
        boolean bl2;
        nvsObject = h.M();
        boolean bl3 = false;
        Object object2 = null;
        if (nvsObject == null) {
            return false;
        }
        if (object != null && !(bl2 = object.isEmpty())) {
            float f10;
            ((NvsTrack)nvsObject).removeAllClips();
            object = object.iterator();
            while (true) {
                bl3 = object.hasNext();
                f10 = 1.0f;
                if (!bl3) break;
                object2 = object.next();
                d.v.h.h.b b10 = object2;
                b10 = (d.v.h.h.b)object2;
                if (b10 == null) continue;
                String string2 = b10.k();
                long l10 = b10.d();
                long l11 = b10.m();
                long l12 = b10.f();
                object2 = nvsObject;
                object2 = ((NvsAudioTrack)nvsObject).addClip(string2, l10, l11, l12);
                if (object2 == null) continue;
                float f11 = b10.n() * f10;
                ((NvsClip)object2).setVolumeGain(f11, f11);
            }
            object = i.r();
            boolean bl4 = ((NvsTimelineData)object).isGlobalRecordVolumeEnable();
            if (bl4) {
                object = i.r();
                float f12 = ((NvsTimelineData)object).getGlobalRecordVolume() * f10;
                ((NvsTrack)nvsObject).setVolumeGain(f12, f12);
            }
            return true;
        }
        ((NvsTrack)nvsObject).removeAllClips();
        return false;
    }

    private static boolean l(NvsTimeline nvsObject) {
        int n10;
        int n11 = 0;
        float f10 = 0.0f;
        if (nvsObject == null) {
            return false;
        }
        if ((nvsObject = ((NvsTimeline)nvsObject).appendVideoTrack()) == null) {
            return false;
        }
        List list = i.r().getMediaInfoList();
        while (true) {
            int n12 = list.size();
            n10 = 1;
            if (n11 >= n12) break;
            d d10 = (d)list.get(n11);
            n12 = (int)(i.b((NvsVideoTrack)nvsObject, d10) ? 1 : 0);
            if (n12 == 0) {
                list.remove(n11);
                n11 += -1;
            }
            n11 += n10;
        }
        f10 = i.r().getGlobalVideoVolume() * 1.0f;
        ((NvsTrack)nvsObject).setVolumeGain(f10, f10);
        return n10 != 0;
    }

    public static void m(int n10, int n11) {
        i.q().changeVideoSize(n10, n11);
        NvsTimelineData nvsTimelineData = i.r();
        int n12 = nvsTimelineData.getAspectRadio();
        int n13 = 6;
        if (n12 == n13) {
            n10 = Math.min(n10, n11);
            float f10 = n10;
            n11 = 0x40000000;
            float f11 = 2.0f;
            i.a(f10 /= f11);
        }
        i.C();
        i.u();
    }

    public static NvsTimeline n(int n10, int n11) {
        NvsVideoResolution nvsVideoResolution = new NvsVideoResolution();
        nvsVideoResolution.imageHeight = n11;
        nvsVideoResolution.imageWidth = n10;
        return i.o(nvsVideoResolution);
    }

    public static NvsTimeline o(NvsVideoResolution nvsVideoResolution) {
        NvsRational nvsRational;
        NvsStreamingContext nvsStreamingContext = NvsStreamingContext.getInstance();
        if (nvsStreamingContext == null) {
            return null;
        }
        int n10 = 1;
        nvsVideoResolution.imagePAR = nvsRational = new NvsRational(n10, n10);
        nvsRational = new NvsRational(25, n10);
        NvsAudioResolution nvsAudioResolution = new NvsAudioResolution();
        nvsAudioResolution.sampleRate = 44100;
        nvsAudioResolution.channelCount = 2;
        return nvsStreamingContext.createTimeline(nvsVideoResolution, nvsRational, nvsAudioResolution);
    }

    private static NvsTimelineCaption p(int n10) {
        Object object = d.v.v.j.h.t().z(n10);
        if (object == null) {
            return null;
        }
        long l10 = ((d.v.h.d.a)object).e();
        object = d.v.v.j.i.e().f().getCaptionsByTimelinePosition(l10);
        boolean bl2 = object.isEmpty();
        if (!bl2) {
            return (NvsTimelineCaption)object.get(0);
        }
        return null;
    }

    private static NvsTimeline q() {
        return d.v.v.j.i.e().f();
    }

    private static NvsTimelineData r() {
        return d.v.v.j.h.t().n();
    }

    public static void s(NvsTimeline nvsTimeline) {
        i.l(nvsTimeline);
        nvsTimeline.appendAudioTrack();
        nvsTimeline.appendAudioTrack();
        i.A(nvsTimeline);
    }

    public static boolean t(NvsVideoTrack nvsObject, d d10, int n10) {
        int n11 = 0;
        if (nvsObject != null && d10 != null) {
            float f10;
            MediaType mediaType;
            String string2 = d10.e();
            Object object = d10.f();
            if (object == (mediaType = MediaType.VIDEO)) {
                long l10 = d10.J();
                long l11 = d10.u();
                object = nvsObject;
                nvsObject = ((NvsVideoTrack)nvsObject).insertClip(string2, l10, l11, n10);
            } else {
                long l12 = d10.J();
                long l13 = d10.u();
                object = nvsObject;
                if ((nvsObject = ((NvsVideoTrack)nvsObject).insertClip(string2, l12, l13, n10)) != null) {
                    n10 = 2;
                    f10 = 2.8E-45f;
                    ((NvsVideoClip)nvsObject).setClipWrapMode(n10);
                }
            }
            if (nvsObject == null) {
                return false;
            }
            NvsTimelineData nvsTimelineData = i.r();
            n10 = nvsTimelineData.getAspectRadio();
            n11 = 4;
            object = null;
            if (n10 == n11) {
                ((NvsVideoClip)nvsObject).setPanAndScan(0.0f, 0.0f);
            } else {
                n10 = 1065353216;
                f10 = 1.0f;
                ((NvsVideoClip)nvsObject).setPanAndScan(0.0f, f10);
            }
            return i.v((NvsVideoClip)nvsObject, d10);
        }
        return false;
    }

    public static void u() {
        int n10;
        List list = i.r().getTextInfoList();
        for (int i10 = 0; i10 < (n10 = list.size()); ++i10) {
            Cloneable cloneable = (d.v.h.d.d)list.get(i10);
            NvsTimelineCaption nvsTimelineCaption = i.p(i10);
            cloneable = cloneable.f();
            i.y(nvsTimelineCaption, (a$a)cloneable);
        }
    }

    public static boolean v(NvsVideoClip nvsVideoClip, d d10) {
        long l10 = d10.J();
        long l11 = nvsVideoClip.getOutPoint();
        long l12 = nvsVideoClip.getInPoint();
        d10.W(l10 += (l11 -= l12));
        Object object = d10.w();
        if (object != null) {
            i.g(nvsVideoClip, (d.v.h.f.a)object);
            i.f(nvsVideoClip, (d.v.h.f.a)object);
        }
        boolean bl2 = nvsVideoClip.getVideoType();
        long l13 = 0L;
        boolean bl3 = true;
        if (bl2 == bl3) {
            l12 = nvsVideoClip.getTrimIn();
            long l14 = d10.u();
            long l15 = l14 - l13;
            Object object2 = l15 == 0L ? 0 : (l15 < 0L ? -1 : 1);
            if (object2 > 0 && (object2 = l14 == l12 ? 0 : (l14 < l12 ? -1 : 1)) > 0) {
                nvsVideoClip.changeTrimOutPoint(l14, bl3);
            }
            object2 = 0;
            d10 = null;
            nvsVideoClip.setImageMotionAnimationEnabled(false);
        } else {
            float f10;
            object = i.r();
            boolean bl4 = ((NvsTimelineData)object).isGlobalVideoVolumeEnable();
            int n10 = 1065353216;
            float f11 = 1.0f;
            if (bl4) {
                object = i.r();
                f10 = ((NvsTimelineData)object).getGlobalVideoVolume();
            } else {
                f10 = d10.O();
            }
            f10 = f10 * f11 * f11;
            nvsVideoClip.setVolumeGain(f10, f10);
            double d11 = d10.I();
            long l16 = 0L;
            double d12 = 0.0;
            double d13 = d11 == d12 ? 0 : (d11 > d12 ? 1 : -1);
            if (d13 > 0) {
                l16 = 0x3FF0000000000000L;
                d12 = 1.0;
                double d14 = d11 - d12;
                Object object3 = d14 == 0.0 ? 0 : (d14 > 0.0 ? 1 : -1);
                if (object3 != false) {
                    nvsVideoClip.changeSpeed(d11);
                    boolean bl5 = false;
                    f10 = 0.0f;
                    object = null;
                    nvsVideoClip.setVolumeGain(0.0f, 0.0f);
                }
            }
            object = d.v.v.m.a.h();
            n10 = d10.y();
            ((a)object).r(nvsVideoClip, n10);
            l12 = d10.J();
            l16 = d10.u();
            long l17 = l12 == l13 ? 0 : (l12 < l13 ? -1 : 1);
            if (l17 > 0) {
                nvsVideoClip.changeTrimInPoint(l12, bl3);
            }
            if ((l17 = l16 == l13 ? 0 : (l16 < l13 ? -1 : 1)) > 0 && (l17 = l16 == l12 ? 0 : (l16 < l12 ? -1 : 1)) > 0) {
                nvsVideoClip.changeTrimOutPoint(l16, bl3);
            }
        }
        return bl3;
    }

    private static void w() {
        int n10;
        List list = i.r().getMediaInfoList();
        for (int i10 = 0; i10 < (n10 = list.size() + -1); ++i10) {
            int n11;
            Object object = (d)list.get(i10);
            if (object == null) continue;
            if ((object = ((d)object).N()) != null && (n11 = ((d.v.h.k.b)object).e()) != 0) {
                d.v.v.p.b b10 = d.v.v.p.b.j();
                b10.a(i10, (d.v.h.k.b)object);
                continue;
            }
            object = d.v.v.p.b.j();
            ((d.v.v.p.b)object).i(i10);
        }
    }

    public static boolean x(NvsTimeline nvsTimeline, List object) {
        boolean bl2;
        if (nvsTimeline == null) {
            return false;
        }
        Object object2 = nvsTimeline.getFirstCaption();
        while (object2 != null) {
            object2 = nvsTimeline.removeCaption((NvsTimelineCaption)object2);
        }
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            object2 = (d.v.h.d.d)object.next();
            long l10 = ((d.v.h.d.a)object2).i();
            String string2 = ((d.v.h.d.d)object2).y();
            long l11 = ((d.v.h.d.a)object2).e();
            NvsObject nvsObject = nvsTimeline;
            nvsObject = nvsTimeline.addCaption(string2, l11, l10, null);
            i.B((NvsTimelineCaption)nvsObject, (d.v.h.d.d)object2);
        }
        return true;
    }

    private static void y(NvsTimelineCaption nvsTimelineCaption, a$a a$a) {
        if (a$a == null) {
            return;
        }
        NvsSize nvsSize = h.S();
        int n10 = nvsSize.width;
        int n11 = nvsSize.height;
        float f10 = a$a.a;
        float f11 = 0.5f;
        f10 -= f11;
        float f12 = n10;
        float f13 = a$a.b;
        f11 -= f13;
        f13 = n11;
        a$a = new PointF(f10 *= f12, f11 *= f13);
        nvsTimelineCaption.setCaptionTranslation((PointF)a$a);
    }

    public static boolean z(NvsTimeline nvsTimeline, List object) {
        boolean bl2;
        if (nvsTimeline == null) {
            return false;
        }
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            NvsObject nvsObject;
            String string2;
            long l10;
            c c10 = (c)object.next();
            long l11 = c10.i();
            boolean bl3 = c10.F();
            if (bl3) {
                l10 = c10.e();
                string2 = c10.v();
                String string3 = c10.u();
                nvsObject = nvsTimeline;
                nvsObject = nvsTimeline.addCustomAnimatedSticker(l10, l11, string2, string3);
            } else {
                l10 = c10.e();
                string2 = c10.v();
                nvsObject = nvsTimeline;
                nvsObject = nvsTimeline.addAnimatedSticker(l10, l11, string2);
            }
            if (nvsObject == null) continue;
            int n10 = c10.E();
            float f10 = n10;
            ((NvsAnimatedSticker)nvsObject).setZValue(f10);
            ((NvsTimelineAnimatedSticker)nvsObject).setClipAffinityEnabled(false);
            PointF pointF = c10.B();
            float[] fArray = c10.j();
            float f11 = fArray[0];
            float f12 = c10.w();
            float f13 = c10.d();
            ((NvsAnimatedSticker)nvsObject).setScale(f11 *= f12);
            ((NvsAnimatedSticker)nvsObject).setRotationZ(f13);
            ((NvsAnimatedSticker)nvsObject).setTranslation(pointF);
        }
        return true;
    }
}

