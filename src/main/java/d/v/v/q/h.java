/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.PointF
 *  android.text.TextUtils
 *  android.util.Size
 */
package d.v.v.q;

import android.graphics.Bitmap;
import android.graphics.PointF;
import android.text.TextUtils;
import android.util.Size;
import com.meicam.sdk.NvsAVFileInfo;
import com.meicam.sdk.NvsAudioClip;
import com.meicam.sdk.NvsAudioTrack;
import com.meicam.sdk.NvsLiveWindow;
import com.meicam.sdk.NvsRational;
import com.meicam.sdk.NvsSize;
import com.meicam.sdk.NvsStreamingContext;
import com.meicam.sdk.NvsStreamingContext$CompileCallback;
import com.meicam.sdk.NvsTimeline;
import com.meicam.sdk.NvsTimelineAnimatedSticker;
import com.meicam.sdk.NvsTimelineCaption;
import com.meicam.sdk.NvsTrack;
import com.meicam.sdk.NvsVideoClip;
import com.meicam.sdk.NvsVideoFrameRetriever;
import com.meicam.sdk.NvsVideoResolution;
import com.meicam.sdk.NvsVideoTrack;
import com.zhiyun.editorinterface.EditConfig$ResourceType;
import com.zhiyun.editorinterface.compose.ComposeParams;
import com.zhiyun.editorinterface.compose.ComposeParams$Resolution;
import com.zhiyun.nvseditor.data.NvsTimelineData;
import d.v.h.b;
import d.v.h.c.b$a;
import d.v.h.d.a$a;
import d.v.v.g.g;
import d.v.v.q.d;
import d.v.v.q.f;
import d.v.v.q.h$a;
import d.v.v.q.h$b;
import d.v.v.q.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class h {
    private static NvsStreamingContext a = NvsStreamingContext.getInstance();

    public static NvsAudioClip A(int n10) {
        h.i();
        NvsAudioTrack nvsAudioTrack = h.G();
        if (nvsAudioTrack == null) {
            return null;
        }
        return nvsAudioTrack.getClipByIndex(n10);
    }

    public static NvsAudioClip B(long l10) {
        h.i();
        NvsAudioTrack nvsAudioTrack = h.G();
        if (nvsAudioTrack == null) {
            return null;
        }
        return nvsAudioTrack.getClipByTimelinePosition(l10);
    }

    public static long C(String object) {
        NvsStreamingContext nvsStreamingContext = a;
        if ((object = nvsStreamingContext.getAVFileInfo((String)object)) == null) {
            return -1;
        }
        return ((NvsAVFileInfo)object).getDuration();
    }

    public static long D(int n10) {
        h.i();
        NvsAudioClip nvsAudioClip = h.A(n10);
        if (nvsAudioClip == null) {
            return -1;
        }
        return nvsAudioClip.getOutPoint();
    }

    public static int E(long l10) {
        h.i();
        NvsAudioClip nvsAudioClip = h.B(l10);
        if (nvsAudioClip == null) {
            return -1;
        }
        return nvsAudioClip.getIndex();
    }

    public static long F(int n10) {
        h.i();
        NvsAudioClip nvsAudioClip = h.A(n10);
        if (nvsAudioClip == null) {
            return -1;
        }
        return nvsAudioClip.getInPoint();
    }

    public static NvsAudioTrack G() {
        h.i();
        return h.Q().getAudioTrackByIndex(0);
    }

    public static long H() {
        h.i();
        NvsAudioTrack nvsAudioTrack = h.G();
        if (nvsAudioTrack != null) {
            return nvsAudioTrack.getDuration();
        }
        return -1;
    }

    public static NvsAudioClip I(int n10) {
        h.i();
        NvsAudioTrack nvsAudioTrack = h.M();
        if (nvsAudioTrack == null) {
            return null;
        }
        return nvsAudioTrack.getClipByIndex(n10);
    }

    public static NvsAudioClip J(long l10) {
        h.i();
        NvsAudioTrack nvsAudioTrack = h.M();
        if (nvsAudioTrack == null) {
            return null;
        }
        return nvsAudioTrack.getClipByTimelinePosition(l10);
    }

    public static long K(int n10) {
        h.i();
        NvsAudioClip nvsAudioClip = h.I(n10);
        if (nvsAudioClip == null) {
            return -1;
        }
        return nvsAudioClip.getOutPoint();
    }

    public static long L(int n10) {
        h.i();
        NvsAudioClip nvsAudioClip = h.I(n10);
        if (nvsAudioClip == null) {
            return -1;
        }
        return nvsAudioClip.getInPoint();
    }

    public static NvsAudioTrack M() {
        h.i();
        return h.Q().getAudioTrackByIndex(1);
    }

    public static Bitmap N(String string2, long l10, int n10) {
        return a.createVideoFrameRetriever(string2).getFrameAtTimeWithCustomVideoFrameHeight(l10, n10);
    }

    public static Bitmap O(int n10, String object, long l10) {
        object = NvsStreamingContext.getInstance().createVideoFrameRetriever((String)object);
        n10 = n10 / 2 * 2;
        Bitmap bitmap = ((NvsVideoFrameRetriever)object).getFrameAtTimeWithCustomVideoFrameHeight(l10, n10);
        ((NvsVideoFrameRetriever)object).release();
        return bitmap;
    }

    public static Bitmap P(String object, long l10) {
        object = NvsStreamingContext.getInstance().createVideoFrameRetriever((String)object);
        Bitmap bitmap = ((NvsVideoFrameRetriever)object).getFrameAtTime(l10, 0);
        ((NvsVideoFrameRetriever)object).release();
        return bitmap;
    }

    private static NvsTimeline Q() {
        return d.v.v.j.i.e().f();
    }

    public static Bitmap R(long l10) {
        h.i();
        NvsStreamingContext nvsStreamingContext = NvsStreamingContext.getInstance();
        NvsTimeline nvsTimeline = h.Q();
        int n10 = 1;
        NvsRational nvsRational = new NvsRational(n10, n10);
        return nvsStreamingContext.grabImageFromTimeline(nvsTimeline, l10, nvsRational);
    }

    public static NvsSize S() {
        int n10;
        int n11;
        h.i();
        NvsSize nvsSize = new NvsSize(0, 0);
        NvsVideoResolution nvsVideoResolution = h.Q().getVideoRes();
        nvsSize.width = n11 = nvsVideoResolution.imageWidth;
        nvsSize.height = n10 = nvsVideoResolution.imageHeight;
        return nvsSize;
    }

    public static long T(int n10) {
        h.i();
        NvsVideoClip nvsVideoClip = h.W(n10);
        NvsVideoClip nvsVideoClip2 = h.W(++n10);
        if (nvsVideoClip != null && nvsVideoClip2 != null) {
            long l10 = nvsVideoClip.getOutPoint();
            long l11 = nvsVideoClip.getInPoint();
            l10 -= l11;
            l11 = nvsVideoClip2.getOutPoint();
            long l12 = nvsVideoClip2.getInPoint();
            long l13 = l10 - (l11 -= l12);
            n10 = (int)(l13 == 0L ? 0 : (l13 < 0L ? -1 : 1));
            if (n10 > 0) {
                l10 = l11;
            }
            return l10 * (long)2;
        }
        return -1;
    }

    public static long U(int n10, long l10) {
        h.i();
        long l11 = h.a0(n10);
        long l12 = -1;
        Object object = l11 == l12 ? 0 : (l11 < l12 ? -1 : 1);
        if (object == false) {
            return l12;
        }
        long l13 = h.g0(n10);
        n10 = 1;
        long l14 = l10 >> n10;
        long l15 = (l13 = l11 - l13) - l14;
        object = l15 == 0L ? 0 : (l15 < 0L ? -1 : 1);
        if (object < 0) {
            return l12;
        }
        return l11 - l10 >> n10;
    }

    private static long V(Size object) {
        int n10 = object.getWidth();
        int n11 = object.getHeight();
        object = h.k(2);
        double d10 = n10 *= n11;
        double d11 = (double)object[0];
        d10 /= d11;
        d11 = (double)object[1];
        return (long)(d10 * d11);
    }

    public static NvsVideoClip W(int n10) {
        h.i();
        NvsVideoTrack nvsVideoTrack = h.h0();
        if (nvsVideoTrack == null) {
            return null;
        }
        return nvsVideoTrack.getClipByIndex(n10);
    }

    public static NvsVideoClip X(long l10) {
        h.i();
        NvsVideoTrack nvsVideoTrack = h.h0();
        if (nvsVideoTrack == null) {
            return null;
        }
        return nvsVideoTrack.getClipByTimelinePosition(l10);
    }

    public static long Y(int n10) {
        h.i();
        long l10 = h.a0(n10);
        long l11 = h.g0(n10);
        return l10 - l11;
    }

    public static long Z(String object) {
        NvsStreamingContext nvsStreamingContext = a;
        if ((object = nvsStreamingContext.getAVFileInfo((String)object)) == null) {
            return 0L;
        }
        return ((NvsAVFileInfo)object).getDuration();
    }

    public static long a(int n10, long l10) {
        h.i();
        NvsVideoClip nvsVideoClip = h.W(n10);
        if (nvsVideoClip == null) {
            return -1;
        }
        return nvsVideoClip.GetClipPosByTimelinePosCurvesVariableSpeed(l10);
    }

    public static long a0(int n10) {
        h.i();
        NvsVideoClip nvsVideoClip = h.W(n10);
        if (nvsVideoClip == null) {
            return -1;
        }
        return nvsVideoClip.getOutPoint();
    }

    public static long b(long l10) {
        h.i();
        int n10 = h.b0(l10);
        NvsVideoClip nvsVideoClip = h.W(n10);
        if (nvsVideoClip == null) {
            return -1;
        }
        return nvsVideoClip.GetClipPosByTimelinePosCurvesVariableSpeed(l10);
    }

    public static int b0(long l10) {
        h.i();
        NvsVideoClip nvsVideoClip = h.X(l10);
        if (nvsVideoClip == null) {
            return -1;
        }
        return nvsVideoClip.getIndex();
    }

    public static long c(int n10, long l10) {
        h.i();
        NvsVideoClip nvsVideoClip = h.W(n10);
        if (nvsVideoClip == null) {
            return -1;
        }
        return nvsVideoClip.GetTimelinePosByClipPosCurvesVariableSpeed(l10);
    }

    public static Size c0() {
        h.i();
        NvsVideoResolution nvsVideoResolution = h.Q().getVideoRes();
        int n10 = 0;
        int n11 = nvsVideoResolution == null ? 0 : nvsVideoResolution.imageWidth;
        if (nvsVideoResolution != null) {
            n10 = nvsVideoResolution.imageHeight;
        }
        Size size = new Size(n11, n10);
        return size;
    }

    public static /* synthetic */ NvsStreamingContext d() {
        return a;
    }

    public static Size d0(int n10, int n11) {
        NvsVideoResolution nvsVideoResolution = h.Q().getVideoRes();
        float f10 = n11;
        float f11 = n10;
        float f12 = f10 / f11;
        int n12 = nvsVideoResolution.imageHeight;
        float f13 = n12;
        int n13 = nvsVideoResolution.imageWidth;
        float f14 = n13;
        float f15 = f13 / f14;
        float f16 = f12 - f15;
        Object object = f16 == 0.0f ? 0 : (f16 < 0.0f ? -1 : 1);
        if (object < 0) {
            n10 = (int)(f10 *= (f14 /= f13));
        } else {
            n11 = (int)(f11 *= f15);
        }
        nvsVideoResolution = new Size(n10, n11);
        return nvsVideoResolution;
    }

    public static boolean e(String string2) {
        return f.d().a(string2);
    }

    public static Size e0(String object) {
        object = a.getAVFileInfo((String)object);
        int n10 = 0;
        Size size = null;
        if (object == null) {
            return null;
        }
        int n11 = 0;
        int n12 = ((NvsAVFileInfo)object).getVideoStreamRotation(0);
        if ((object = ((NvsAVFileInfo)object).getVideoStreamDimension(0)) == null) {
            return null;
        }
        n10 = 1;
        if (n12 == n10 || n12 == (n10 = 3)) {
            n10 = ((NvsSize)object).width;
            ((NvsSize)object).width = n11 = ((NvsSize)object).height;
            ((NvsSize)object).height = n10;
        }
        n11 = ((NvsSize)object).width;
        int n13 = ((NvsSize)object).height;
        size = new Size(n11, n13);
        return size;
    }

    public static long f(ComposeParams composeParams) {
        long l10;
        long l11 = composeParams.b();
        ComposeParams$Resolution composeParams$Resolution = composeParams.d();
        if (composeParams$Resolution != null) {
            composeParams$Resolution = h.f0(composeParams.d());
            l10 = 0L;
            long l12 = l11 - l10;
            Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (object == false) {
                l11 = h.V((Size)composeParams$Resolution);
            }
        }
        float f10 = (float)h.Q().getDuration() / 1000.0f;
        l10 = composeParams.a();
        return (long)((float)(l11 + l10) * f10 / 8000000.0f);
    }

    /*
     * Enabled aggressive block sorting
     */
    public static Size f0(ComposeParams$Resolution composeParams$Resolution) {
        int n10;
        int n11;
        block5: {
            block0: {
                block1: {
                    int n12;
                    block2: {
                        block3: {
                            block4: {
                                n11 = composeParams$Resolution.getHeight();
                                n10 = n11 * 9 / 16;
                                NvsTimelineData nvsTimelineData = d.v.v.j.h.t().n();
                                int n13 = nvsTimelineData.getAspectRadio();
                                if (n13 == 0) break block0;
                                int n14 = 1;
                                if (n13 == n14) break block1;
                                n14 = 2;
                                n12 = 3;
                                if (n13 == n14) break block2;
                                if (n13 == n12) break block3;
                                n14 = 5;
                                if (n13 == n14) break block4;
                                n14 = 6;
                                if (n13 == n14) break block1;
                                break block5;
                            }
                            n11 = n11 * 4 / n12;
                            n10 = n11 * 3 / 4;
                            break block5;
                        }
                        n10 = n11 * 16 / 9;
                        break block5;
                    }
                    n10 = n11 * 4 / n12;
                    break block5;
                }
                n10 = n11;
                return new Size(n11, n10);
            }
            n11 = n11 * 16 / 9;
            n10 = n11 * 9 / 16;
        }
        int n15 = n10;
        n10 = n11;
        n11 = n15;
        return new Size(n11, n10);
    }

    public static void g() {
        NvsStreamingContext nvsStreamingContext = a;
        if (nvsStreamingContext != null) {
            int n10 = 1;
            nvsStreamingContext.stop(n10);
        }
    }

    public static long g0(int n10) {
        h.i();
        NvsVideoClip nvsVideoClip = h.W(n10);
        if (nvsVideoClip == null) {
            return -1;
        }
        return nvsVideoClip.getInPoint();
    }

    public static void h(g object) {
        NvsStreamingContext nvsStreamingContext = a;
        NvsTimeline nvsTimeline = h.Q();
        object = (NvsLiveWindow)object.getDisplayView();
        nvsStreamingContext.connectTimelineWithLiveWindow(nvsTimeline, (NvsLiveWindow)((Object)object));
    }

    public static NvsVideoTrack h0() {
        h.i();
        return h.Q().getVideoTrackByIndex(0);
    }

    private static void i() {
        Object object = h.Q();
        if (object != null) {
            return;
        }
        object = new IllegalStateException("NvsTimeline should be initialization");
        throw object;
    }

    public static void i0(String string2) {
        f.d().f(string2);
    }

    public static void j(String string2, String string3, long l10, long l11, b$a b$a) {
        int n10;
        b$a b$a2 = b$a;
        Object object = h.e0(string2);
        if (object != null && (n10 = object.getWidth()) != 0 && (n10 = object.getWidth()) != 0) {
            n10 = object.getWidth() / 4 * 4;
            int n11 = object.getHeight() / 2 * 2;
            NvsTimeline nvsTimeline = i.n(n10, n11);
            object = "unknown error";
            if (nvsTimeline == null) {
                if (b$a != null) {
                    Exception exception = new Exception((String)object);
                    b$a.a(exception, (String)object);
                }
                return;
            }
            Object object2 = nvsTimeline.appendVideoTrack();
            if (object2 == null) {
                if (b$a != null) {
                    object2 = new Exception((String)object);
                    b$a.a((Exception)object2, (String)object);
                }
                return;
            }
            long l12 = 0L;
            Object object3 = ((NvsVideoTrack)object2).addClip(string2, l12, l10, l11);
            if (object3 == null) {
                if (b$a != null) {
                    object2 = new Exception((String)object);
                    b$a.a((Exception)object2, (String)object);
                }
                return;
            }
            object3 = a;
            l12 = ((NvsTrack)object2).getDuration();
            ((NvsStreamingContext)object3).compileTimeline(nvsTimeline, 0L, l12, string3, 256, 2, 0);
            object = a;
            object3 = string3;
            object2 = new h$a(b$a, string3);
            ((NvsStreamingContext)object).setCompileCallback((NvsStreamingContext$CompileCallback)object2);
            return;
        }
        if (b$a2 != null) {
            String string4 = "video path is wrong";
            object = new Exception(string4);
            b$a2.a((Exception)object, string4);
        }
    }

    public static boolean j0(EditConfig$ResourceType editConfig$ResourceType, String string2, String string3) {
        return f.d().i(editConfig$ResourceType, string2, string3);
    }

    private static int[] k(int n10) {
        int n11 = 414720;
        int n12 = 2;
        int n13 = 1;
        if (n10 != 0) {
            if (n10 != n13) {
                if (n10 != n12) {
                    n10 = 0;
                    n11 = 0;
                } else {
                    n11 = 921600;
                    n10 = 6000000;
                }
            } else {
                n10 = 1500000;
            }
        } else {
            n10 = 1000000;
        }
        int[] nArray = new int[n12];
        nArray[0] = n11;
        nArray[n13] = n10;
        return nArray;
    }

    public static boolean k0(Long object) {
        boolean bl2;
        h.i();
        long l10 = object == null ? h.n() : (Long)object;
        object = h.Q().getCaptionsByTimelinePosition(l10);
        if (object != null && (bl2 = object.size()) > false) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public static a$a l(PointF object) {
        h.i();
        NvsSize nvsSize = h.S();
        float f10 = object.x;
        float f11 = nvsSize.width;
        f10 /= f11;
        f11 = 0.5f;
        f10 += f11;
        float f12 = object.y;
        float f13 = nvsSize.height;
        object = new a$a(f10, f11 -= (f12 /= f13));
        return object;
    }

    public static boolean l0(String object) {
        int n10;
        int n11;
        object = a.getAVFileInfo((String)object);
        boolean bl2 = false;
        if (object == null) {
            return false;
        }
        if ((object = ((NvsAVFileInfo)object).getVideoStreamDimension(0)) != null && ((n11 = ((NvsSize)object).width) != 0 || (n10 = ((NvsSize)object).height) != 0)) {
            bl2 = true;
        }
        return bl2;
    }

    public static int m() {
        h.i();
        long l10 = h.n();
        NvsAudioClip nvsAudioClip = h.B(l10);
        if (nvsAudioClip == null) {
            return -1;
        }
        return nvsAudioClip.getIndex();
    }

    public static boolean m0(Long object) {
        boolean bl2;
        h.i();
        long l10 = object == null ? h.n() : (Long)object;
        object = h.Q().getAnimatedStickersByTimelinePosition(l10);
        if (object != null && (bl2 = object.size()) > false) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public static long n() {
        h.i();
        NvsStreamingContext nvsStreamingContext = a;
        NvsTimeline nvsTimeline = h.Q();
        return nvsStreamingContext.getTimelineCurrentPosition(nvsTimeline);
    }

    public static void n0(String string2, String string3, int n10, b$a b$a) {
        int n11;
        int n12 = n10;
        b$a b$a2 = b$a;
        Object object = h.e0(string2);
        if (object != null && (n11 = object.getWidth()) != 0 && (n11 = object.getWidth()) != 0) {
            n11 = object.getWidth();
            float f10 = n11;
            float f11 = object.getHeight();
            float f12 = (f10 /= f11) - (f11 = 1.0f);
            Object object2 = f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1);
            if (object2 > 0) {
                f11 = (float)n10 * f10;
                int n13 = (int)f11;
                object2 = n10;
                n12 = n13;
            } else {
                f11 = (float)n10 / f10;
                object2 = (int)f11;
            }
            n12 = n12 / 4 * 4;
            n11 = (int)(object2 / 2 * 2);
            NvsTimeline nvsTimeline = i.n(n12, n11);
            Object object3 = "unknown error";
            if (nvsTimeline == null) {
                if (b$a2 != null) {
                    object = new Exception((String)object3);
                    b$a2.a((Exception)object, (String)object3);
                }
                return;
            }
            Object object4 = nvsTimeline.appendVideoTrack();
            if (object4 == null) {
                if (b$a2 != null) {
                    object = new Exception((String)object3);
                    b$a2.a((Exception)object, (String)object3);
                }
                return;
            }
            Object object5 = string2;
            object5 = ((NvsVideoTrack)object4).appendClip(string2);
            if (object5 == null) {
                if (b$a2 != null) {
                    object = new Exception((String)object3);
                    b$a2.a((Exception)object, (String)object3);
                }
                return;
            }
            a.setCustomCompileVideoHeight((int)object2);
            object5 = a;
            long l10 = ((NvsTrack)object4).getDuration();
            ((NvsStreamingContext)object5).compileTimeline(nvsTimeline, 0L, l10, string3, 256, 2, 0);
            object3 = a;
            object4 = string3;
            object = new h$b(b$a2, string3);
            ((NvsStreamingContext)object3).setCompileCallback((NvsStreamingContext$CompileCallback)object);
            return;
        }
        if (b$a2 != null) {
            object = "video path is wrong";
            Exception exception = new Exception((String)object);
            b$a2.a(exception, (String)object);
        }
    }

    public static int o() {
        h.i();
        long l10 = h.n();
        NvsAudioClip nvsAudioClip = h.J(l10);
        if (nvsAudioClip == null) {
            return -1;
        }
        return nvsAudioClip.getIndex();
    }

    public static boolean o0(int n10, List list, String string2) {
        int n11;
        if (list != null && (n11 = list.isEmpty()) == 0) {
            n11 = list.size();
            if (n10 >= n11) {
                return false;
            }
            Object e10 = list.get(n10);
            if (e10 == null) {
                return false;
            }
            ((b)list.get(n10)).b(string2);
            return true;
        }
        return false;
    }

    public static int p() {
        NvsVideoClip nvsVideoClip;
        h.i();
        long l10 = h.n();
        long l11 = h.z();
        long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        if (l12 >= 0) {
            l10 = l11 - 1L;
        }
        if ((nvsVideoClip = h.X(l10)) == null) {
            return -1;
        }
        return nvsVideoClip.getIndex();
    }

    public static List q(String pointF) {
        ArrayList<PointF> arrayList = new ArrayList<PointF>();
        boolean bl2 = TextUtils.isEmpty((CharSequence)pointF);
        if (!bl2) {
            PointF pointF2;
            float f10;
            int n10;
            int n11;
            pointF = pointF.split("\\)");
            bl2 = false;
            float f11 = 0.0f;
            PointF pointF3 = null;
            int n12 = 0;
            Iterator iterator2 = null;
            while (true) {
                n11 = ((String[])pointF).length;
                n10 = 1;
                f10 = Float.MIN_VALUE;
                if (n12 >= n11) break;
                pointF2 = pointF[n12].substring(n10).split(",");
                String string2 = pointF2[0];
                float f12 = Float.parseFloat(string2);
                pointF2 = pointF2[n10];
                float f13 = Float.parseFloat((String)pointF2);
                PointF pointF4 = new PointF();
                pointF4.x = f12;
                pointF4.y = f13;
                arrayList.add(pointF4);
                n12 += 3;
            }
            int n13 = arrayList.size() - n10;
            pointF = (PointF)arrayList.get(n13);
            pointF3 = (PointF)arrayList.get(0);
            f11 = pointF3.x;
            float f14 = pointF.x - f11;
            iterator2 = arrayList.iterator();
            while ((n11 = (int)(iterator2.hasNext() ? 1 : 0)) != 0) {
                pointF2 = (PointF)iterator2.next();
                pointF2.x = f10 = (pointF2.x - f11) / f14;
            }
        }
        return arrayList;
    }

    /*
     * Unable to fully structure code
     */
    public static String r(long var0, List var2_1) {
        var3_2 = new StringBuilder();
        for (var4_3 = 0; var4_3 < (var5_4 = var2_1.size()); ++var4_3) {
            var6_5 = (PointF)var2_1.get(var4_3);
            var7_6 = var2_1.size() + -1;
            var8_7 = 0.0;
            if (var4_3 != var7_6) {
                var7_6 = var4_3 + 1;
                var10_8 = (PointF)var2_1.get(var7_6);
                var11_9 = var10_8.x;
                var12_10 = var6_5.x;
                var11_9 -= var12_10;
                var12_10 = var0;
                var13_11 = var11_9 *= var12_10;
            } else {
                var13_11 = var8_7;
            }
            if (var4_3 != 0) {
                var7_6 = var4_3 + -1;
                var10_8 = (PointF)var2_1.get(var7_6);
                var15_12 = var6_5.x;
                var11_9 = var10_8.x;
                var15_12 -= var11_9;
                var11_9 = var0;
                var8_7 = var15_12 *= var11_9;
            }
            var11_9 = var6_5.x;
            var16_13 = var0;
            var17_14 = var11_9 *= var16_13;
            var19_15 = var6_5.y;
            var20_16 = var19_15;
            var3_2 = d.a(var3_2, var17_14, var20_16);
            var22_17 = 3.0;
            if (var4_3 == 0) {
                var8_7 = var17_14 - (var13_11 /= var22_17);
lbl33:
                // 2 sources

                while (true) {
                    var17_14 += var13_11;
                    break;
                }
            } else {
                var24_18 = var2_1.size() + -1;
                if (var4_3 == var24_18) {
                    var13_11 = var17_14 - (var8_7 /= var22_17);
                    var17_14 += var8_7;
                    var8_7 = var13_11;
                } else {
                    var8_7 /= var22_17;
                    var8_7 = var17_14 - var8_7;
                    var13_11 /= var22_17;
                    ** continue;
                }
            }
            var3_2 = d.a(d.a(var3_2, var8_7, var20_16), var17_14, var20_16);
        }
        return var3_2.toString();
    }

    public static double s(String string2) {
        int n10;
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        double d10 = -1.0;
        if (bl2) {
            return d10;
        }
        ArrayList<PointF> arrayList = new ArrayList<PointF>();
        String[] stringArray = string2.split("\\)");
        int n11 = 0;
        while (true) {
            int n12 = stringArray.length;
            n10 = 1;
            if (n11 >= n12) break;
            Object object = stringArray[n11].substring(n10).split(",");
            String string3 = object[0];
            float f10 = Float.parseFloat(string3);
            object = object[n10];
            float f11 = Float.parseFloat((String)object);
            PointF pointF = new PointF();
            pointF.x = f10;
            pointF.y = f11;
            arrayList.add(pointF);
            n11 += 3;
        }
        boolean bl3 = arrayList.isEmpty();
        if (!bl3) {
            int n13 = arrayList.size() - n10;
            float f12 = ((PointF)arrayList.get((int)n13)).x;
            float f13 = ((PointF)arrayList.get((int)0)).x;
            long l10 = (long)(f12 - f13);
            double d11 = NvsStreamingContext.getInstance().calcDurationAfterCurvesVariableSpeed(string2);
            double d12 = l10;
            return d11 / d12;
        }
        return d10;
    }

    public static long t(long l10, List list) {
        String string2 = h.r(l10, list);
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (bl2) {
            return -1;
        }
        return NvsStreamingContext.getInstance().calcDurationAfterCurvesVariableSpeed(string2);
    }

    public static long u(String string2) {
        return NvsStreamingContext.getInstance().calcDurationAfterCurvesVariableSpeed(string2);
    }

    public static long v(NvsTimelineCaption nvsTimelineCaption) {
        h.i();
        if (nvsTimelineCaption == null) {
            return -1;
        }
        long l10 = nvsTimelineCaption.getInPoint();
        NvsTimeline nvsTimeline = h.Q();
        nvsTimelineCaption = nvsTimeline.getNextCaption(nvsTimelineCaption);
        long l11 = nvsTimelineCaption == null ? h.z() : nvsTimelineCaption.getInPoint();
        return l11 - l10;
    }

    public static long w(NvsTimelineAnimatedSticker nvsTimelineAnimatedSticker) {
        h.i();
        if (nvsTimelineAnimatedSticker == null) {
            return -1;
        }
        long l10 = nvsTimelineAnimatedSticker.getInPoint();
        NvsTimeline nvsTimeline = h.Q();
        nvsTimelineAnimatedSticker = nvsTimeline.getNextAnimatedSticker(nvsTimelineAnimatedSticker);
        long l11 = nvsTimelineAnimatedSticker == null ? h.z() : nvsTimelineAnimatedSticker.getInPoint();
        return l11 - l10;
    }

    public static long x() {
        h.i();
        return h.y(h.n());
    }

    public static long y(long l10) {
        long l11;
        long l12;
        block4: {
            h.i();
            NvsAudioTrack nvsAudioTrack = h.M();
            int n10 = nvsAudioTrack.getClipCount();
            NvsAudioClip nvsAudioClip = h.J(l10);
            if (nvsAudioClip != null) {
                return 0L;
            }
            int n11 = 0;
            nvsAudioClip = null;
            while (true) {
                l12 = -1;
                if (n11 >= n10) break;
                NvsAudioClip nvsAudioClip2 = nvsAudioTrack.getClipByIndex(n11);
                l11 = nvsAudioClip2.getInPoint();
                long l13 = l10 - l11;
                Object object = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
                if (object < 0) {
                    l11 -= l10;
                    break block4;
                }
                ++n11;
            }
            l11 = l12;
        }
        long l14 = l11 == l12 ? 0 : (l11 < l12 ? -1 : 1);
        if (l14 == false) {
            long l15 = h.z();
            l11 = l15 - l10;
        }
        return l11;
    }

    public static long z() {
        h.i();
        NvsVideoTrack nvsVideoTrack = h.h0();
        if (nvsVideoTrack != null) {
            return nvsVideoTrack.getDuration();
        }
        return -1;
    }
}

