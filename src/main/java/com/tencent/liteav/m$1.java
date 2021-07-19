/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package com.tencent.liteav;

import android.os.Bundle;
import com.tencent.ijk.media.player.MediaInfo;
import com.tencent.liteav.basic.b.b;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.basic.util.g;
import com.tencent.liteav.k;
import com.tencent.liteav.m;
import com.tencent.liteav.txcvodplayer.TXCVodVideoView;
import com.tencent.liteav.txcvodplayer.d;
import com.tencent.liteav.txcvodplayer.e;
import java.lang.ref.Reference;

public class m$1
implements e {
    public final /* synthetic */ m a;

    public m$1(m m10) {
        this.a = m10;
    }

    /*
     * Enabled aggressive block sorting
     */
    public void a(int n10, Bundle object) {
        Object object2;
        String string2;
        int n11;
        Bundle bundle;
        block44: {
            float f10;
            int n12;
            float f11;
            block39: {
                String string3;
                float f12;
                int n13;
                block40: {
                    float f13;
                    int n14;
                    block41: {
                        float f14;
                        int n15;
                        block42: {
                            float f15;
                            int n16;
                            block43: {
                                bundle = new Bundle((Bundle)object);
                                n11 = -2303;
                                f11 = 0.0f / 0.0f;
                                int n17 = -2304;
                                float f16 = 0.0f / 0.0f;
                                int n18 = -2305;
                                float f17 = 0.0f / 0.0f;
                                int n19 = 2014;
                                float f18 = 2.822E-42f;
                                n16 = 2013;
                                f15 = 2.821E-42f;
                                n15 = 2106;
                                f14 = 2.951E-42f;
                                n14 = 2103;
                                f13 = 2.947E-42f;
                                n13 = 2011;
                                f12 = 2.818E-42f;
                                int n20 = 2008;
                                float f19 = 2.814E-42f;
                                n12 = -2301;
                                f10 = 0.0f / 0.0f;
                                string2 = "description";
                                if (n10 == n12) break block39;
                                string3 = "EVT_PARAM1";
                                if (n10 == n13) break block40;
                                if (n10 == n14) break block41;
                                n14 = 0;
                                f13 = 0.0f;
                                if (n10 == n15) break block42;
                                if (n10 == n16) break block43;
                                if (n10 != n19) {
                                    block0 : switch (n10) {
                                        default: {
                                            float f20;
                                            n11 = 1;
                                            f11 = Float.MIN_VALUE;
                                            String string4 = "TXVodPlayer";
                                            switch (n10) {
                                                default: {
                                                    switch (n10) {
                                                        default: {
                                                            object = new StringBuilder();
                                                            String string5 = "miss match event ";
                                                            ((StringBuilder)object).append(string5);
                                                            ((StringBuilder)object).append(n10);
                                                            String string6 = ((StringBuilder)object).toString();
                                                            TXCLog.d(string4, string6);
                                                        }
                                                        case 2019: {
                                                            return;
                                                        }
                                                        case 2018: {
                                                            TXCLog.i(string4, "vod play dns resolved");
                                                            m.a(this.a).h();
                                                            return;
                                                        }
                                                        case 2017: {
                                                            TXCLog.i(string4, "vod play first video packet");
                                                            m.a(this.a).i();
                                                            return;
                                                        }
                                                        case 2016: 
                                                    }
                                                    TXCLog.i(string4, "vod play tcp connect success");
                                                    m.a(this.a).g();
                                                    return;
                                                }
                                                case 2009: {
                                                    n11 = 2009;
                                                    f11 = 2.815E-42f;
                                                    break block0;
                                                }
                                                case 2008: {
                                                    n11 = n20;
                                                    f11 = f19;
                                                    break block0;
                                                }
                                                case 2007: {
                                                    n11 = 2007;
                                                    f11 = 2.812E-42f;
                                                    object2 = m.a(this.a);
                                                    ((k)object2).j();
                                                    break block0;
                                                }
                                                case 2006: {
                                                    object2 = m.a(this.a);
                                                    ((k)object2).b();
                                                    n10 = 2006;
                                                    f20 = 2.811E-42f;
                                                    m m10 = this.a;
                                                    n19 = (int)(m10.a ? 1 : 0);
                                                    if (n19 == 0) break;
                                                    m.c(m10).b();
                                                    m.a(this.a).a(n11 != 0);
                                                    TXCLog.d(string4, "loop play");
                                                    return;
                                                }
                                                case 2005: {
                                                    n11 = 2005;
                                                    f11 = 2.81E-42f;
                                                    object2 = m.a(this.a);
                                                    string4 = "EVT_PLAY_DURATION";
                                                    n17 = object.getInt(string4, 0);
                                                    String string7 = "EVT_PLAY_PROGRESS";
                                                    n18 = object.getInt(string7, 0);
                                                    ((k)object2).a(n17, n18);
                                                    break block0;
                                                }
                                                case 2004: {
                                                    n11 = 2004;
                                                    f11 = 2.808E-42f;
                                                    object2 = m.a(this.a);
                                                    ((k)object2).e();
                                                    break block0;
                                                }
                                                case 2003: {
                                                    object2 = this.a;
                                                    n10 = (int)(m.b((m)object2) ? 1 : 0);
                                                    if (n10 != 0) {
                                                        return;
                                                    }
                                                    object2 = this.a;
                                                    m.a((m)object2, n11 != 0);
                                                    n10 = 2003;
                                                    f20 = 2.807E-42f;
                                                    m.a(this.a).f();
                                                    string4 = new Bundle();
                                                    string4.putInt("EVT_ID", n20);
                                                    long l10 = TXCTimeUtil.getTimeTick();
                                                    string4.putLong("EVT_TIME", l10);
                                                    l10 = TXCTimeUtil.getUtcTimeTick();
                                                    Object object3 = "EVT_UTC_TIME";
                                                    string4.putLong((String)object3, l10);
                                                    Object object4 = m.c(this.a).getMediaInfo();
                                                    Object object5 = "hevc";
                                                    if (object4 != null && (object4 = ((MediaInfo)object4).mVideoDecoderImpl) != null && (n18 = (int)(((String)object4).contains((CharSequence)object5) ? 1 : 0)) != 0) {
                                                        n18 = n11;
                                                        f17 = f11;
                                                    } else {
                                                        n18 = 0;
                                                        object4 = null;
                                                        f17 = 0.0f;
                                                    }
                                                    object3 = m.c(this.a);
                                                    n16 = ((TXCVodVideoView)((Object)object3)).getPlayerType();
                                                    String string8 = "Enables hardware decoding";
                                                    n13 = 2;
                                                    f12 = 2.8E-45f;
                                                    if (n16 == 0) {
                                                        if (n18 == 0) {
                                                            object3 = m.d(this.a);
                                                            n16 = (int)(((d)object3).a() ? 1 : 0);
                                                            if (n16 == 0) {
                                                                string8 = "Enables software decoding";
                                                            }
                                                            string4.putCharSequence(string2, (CharSequence)string8);
                                                        } else {
                                                            object3 = m.d(this.a);
                                                            n16 = (int)(((d)object3).a() ? 1 : 0);
                                                            object3 = n16 != 0 ? "Enables hardware decoding H265" : "Enables software decoding h265";
                                                            string4.putCharSequence(string2, (CharSequence)object3);
                                                        }
                                                        object3 = m.d(this.a);
                                                        n16 = (int)(((d)object3).a() ? 1 : 0);
                                                        if (n16 != 0) {
                                                            n16 = n11;
                                                            f15 = f11;
                                                        } else {
                                                            n16 = n13;
                                                            f15 = f12;
                                                        }
                                                        string4.putInt(string3, n16);
                                                        string4.putInt((String)object5, n18);
                                                    } else {
                                                        string4.putCharSequence(string2, (CharSequence)string8);
                                                        string4.putInt(string3, n13);
                                                    }
                                                    object5 = m.d(this.a);
                                                    n19 = (int)(((d)object5).a() ? 1 : 0);
                                                    if (n19 != 0) {
                                                        if (n18 != 0) {
                                                            n11 = 3;
                                                            f11 = 4.2E-45f;
                                                        }
                                                    } else {
                                                        if (n18 != 0) {
                                                            n14 = n13;
                                                            f13 = f12;
                                                        }
                                                        n11 = n14;
                                                        f11 = f13;
                                                    }
                                                    object4 = m.a(this.a);
                                                    ((k)object4).b(n11);
                                                    this.a(n20, (Bundle)string4);
                                                }
                                            }
                                            n11 = n10;
                                            f11 = f20;
                                            break;
                                        }
                                        case -2303: {
                                            object2 = m.a(this.a);
                                            String string9 = "file not found";
                                            ((k)object2).a(n11, string9);
                                            break;
                                        }
                                        case -2304: {
                                            object2 = m.a(this.a);
                                            String string10 = "h265 decode failed";
                                            ((k)object2).a(n17, string10);
                                            object2 = this.a;
                                            n10 = (int)(m.b((m)object2) ? 1 : 0);
                                            if (n10 == 0) {
                                                object2 = m.d(this.a);
                                                ((d)object2).a(false);
                                            }
                                            n11 = n17;
                                            f11 = f16;
                                            break;
                                        }
                                        case -2305: {
                                            object2 = m.a(this.a);
                                            String string11 = "HLS decrypt key error";
                                            ((k)object2).a(n18, string11);
                                            n11 = n18;
                                            f11 = f17;
                                            break;
                                        }
                                    }
                                    break block44;
                                } else {
                                    n11 = n19;
                                    f11 = f18;
                                }
                                break block44;
                            }
                            object2 = m.a(this.a);
                            ((k)object2).e();
                            n11 = n16;
                            f11 = f15;
                            break block44;
                        }
                        object2 = this.a;
                        n10 = (int)(m.b((m)object2) ? 1 : 0);
                        if (n10 == 0) {
                            object2 = m.d(this.a);
                            ((d)object2).a(false);
                        }
                        n11 = n15;
                        f11 = f14;
                        break block44;
                    }
                    n11 = n14;
                    f11 = f13;
                    break block44;
                }
                object2 = m.c(this.a);
                n10 = ((TXCVodVideoView)((Object)object2)).getMetaRotationDegree();
                bundle.putInt(string3, n10);
                n11 = n13;
                f11 = f12;
                break block44;
            }
            object2 = m.a(this.a);
            String string12 = "network disconnect, has retry reconnect, but still failed!";
            ((k)object2).a(n12, string12);
            n11 = n12;
            f11 = f10;
        }
        object2 = object.getString(string2, "");
        object = "EVT_MSG";
        bundle.putString((String)object, (String)object2);
        object2 = this.a.e;
        if (object2 != null && (object2 = (b)((Reference)object2).get()) != null) {
            object2.onNotifyEvent(n11, bundle);
        }
    }

    public void a(Bundle object) {
        Bundle bundle = new Bundle();
        Object object2 = g.a();
        int n10 = Integer.valueOf(object2[0]) / 10;
        int n11 = 1;
        int n12 = Integer.valueOf(object2[n11]) / 10;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(n10);
        stringBuilder.append("/");
        stringBuilder.append(n12);
        stringBuilder.append("%");
        object2 = stringBuilder.toString();
        bundle.putCharSequence("CPU_USAGE", (CharSequence)object2);
        n12 = (int)object.getFloat("fps");
        bundle.putInt("VIDEO_FPS", n12);
        float f10 = object.getFloat("dps");
        n12 = (int)f10;
        bundle.putInt("VIDEO_DPS", n12);
        n12 = (int)object.getLong("tcpSpeed") / 1000;
        String string2 = "NET_SPEED";
        bundle.putInt(string2, n12);
        long l10 = object.getLong("cachedBytes");
        int n13 = (int)l10 / 1000;
        bundle.putInt("AUDIO_CACHE", n13);
        n13 = m.c(this.a).getVideoWidth();
        bundle.putInt("VIDEO_WIDTH", n13);
        n13 = m.c(this.a).getVideoHeight();
        bundle.putInt("VIDEO_HEIGHT", n13);
        object = m.c(this.a).getServerIp();
        bundle.putString("SERVER_IP", (String)object);
        object = m.a(this.a);
        object2 = m.c(this.a).getServerIp();
        ((k)object).e((String)object2);
        object = this.a.e;
        if (object != null && (object = (b)((Reference)object).get()) != null) {
            n12 = 15001;
            f10 = 2.1021E-41f;
            object.onNotifyEvent(n12, bundle);
        }
    }
}

