/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.liteav.txcvodplayer;

import com.tencent.ijk.media.player.IMediaPlayer;
import com.tencent.ijk.media.player.IMediaPlayer$OnInfoListener;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.txcvodplayer.TXCVodVideoView;

public class TXCVodVideoView$12
implements IMediaPlayer$OnInfoListener {
    public final /* synthetic */ TXCVodVideoView a;

    public TXCVodVideoView$12(TXCVodVideoView tXCVodVideoView) {
        this.a = tXCVodVideoView;
    }

    public boolean onInfo(IMediaPlayer iMediaPlayer, int n10, int n11) {
        boolean bl2;
        block21: {
            float f10;
            block15: {
                block16: {
                    block17: {
                        block18: {
                            int n12;
                            block19: {
                                block20: {
                                    bl2 = true;
                                    int n13 = 3;
                                    if (n10 == n13) break block15;
                                    n12 = 10011;
                                    if (n10 == n12) break block16;
                                    n12 = 901;
                                    if (n10 == n12) break block17;
                                    n12 = 902;
                                    if (n10 == n12) break block18;
                                    n12 = 10001;
                                    if (n10 == n12) break block19;
                                    n12 = 10002;
                                    if (n10 == n12) break block20;
                                    block0 : switch (n10) {
                                        default: {
                                            switch (n10) {
                                                default: {
                                                    break block0;
                                                }
                                                case 802: {
                                                    String string2 = TXCVodVideoView.k(this.a);
                                                    String string3 = "MEDIA_INFO_METADATA_UPDATE:";
                                                    TXCLog.i(string2, string3);
                                                    break block0;
                                                }
                                                case 801: {
                                                    String string4 = TXCVodVideoView.k(this.a);
                                                    String string5 = "MEDIA_INFO_NOT_SEEKABLE:";
                                                    TXCLog.i(string4, string5);
                                                    break block0;
                                                }
                                                case 800: 
                                            }
                                            String string6 = TXCVodVideoView.k(this.a);
                                            String string7 = "MEDIA_INFO_BAD_INTERLEAVING:";
                                            TXCLog.i(string6, string7);
                                            break;
                                        }
                                        case 703: {
                                            String string8 = TXCVodVideoView.k(this.a);
                                            StringBuilder stringBuilder = new StringBuilder();
                                            String string9 = "MEDIA_INFO_NETWORK_BANDWIDTH: ";
                                            stringBuilder.append(string9);
                                            stringBuilder.append(n11);
                                            String string10 = stringBuilder.toString();
                                            TXCLog.i(string8, string10);
                                            break;
                                        }
                                        case 702: {
                                            String string11;
                                            Object object = TXCVodVideoView.k(this.a);
                                            CharSequence charSequence = new StringBuilder();
                                            charSequence.append("MEDIA_INFO_BUFFERING_END: eof ");
                                            charSequence.append(n11);
                                            charSequence = charSequence.toString();
                                            TXCLog.i(object, (String)charSequence);
                                            object = this.a;
                                            n12 = 2014;
                                            String string12 = "Buffer ended";
                                            String string13 = "loading end";
                                            TXCVodVideoView.a((TXCVodVideoView)((Object)object), n12, string12, string13);
                                            if (n11 != 0 && (object = TXCVodVideoView.n(this.a)) != null && (object = TXCVodVideoView.n(this.a).getPath()) != null && (n10 = (int)((object = TXCVodVideoView.n(this.a).getPath()).endsWith(string11 = "m3u8") ? 1 : 0)) != 0) break;
                                            object = this.a;
                                            n10 = TXCVodVideoView.j((TXCVodVideoView)((Object)object));
                                            if (n10 == n13) {
                                                object = this.a;
                                                n11 = 2004;
                                                float f11 = 2.808E-42f;
                                                String string14 = "Playback started";
                                                charSequence = "playing";
                                                TXCVodVideoView.a((TXCVodVideoView)((Object)object), n11, string14, (String)charSequence);
                                                break;
                                            }
                                            break block21;
                                        }
                                        case 701: {
                                            Object object = TXCVodVideoView.k(this.a);
                                            String string15 = "MEDIA_INFO_BUFFERING_START:";
                                            TXCLog.i(object, string15);
                                            object = this.a;
                                            n11 = 2007;
                                            float f12 = 2.812E-42f;
                                            String string16 = "Buffer started";
                                            String string17 = "loading start";
                                            TXCVodVideoView.a((TXCVodVideoView)((Object)object), n11, string16, string17);
                                            break;
                                        }
                                        case 700: {
                                            String string18 = TXCVodVideoView.k(this.a);
                                            String string19 = "MEDIA_INFO_VIDEO_TRACK_LAGGING:";
                                            TXCLog.i(string18, string19);
                                            break;
                                        }
                                    }
                                    break block21;
                                }
                                String string20 = TXCVodVideoView.k(this.a);
                                String string21 = "MEDIA_INFO_AUDIO_RENDERING_START:";
                                TXCLog.i(string20, string21);
                                break block21;
                            }
                            Object object = TXCVodVideoView.k(this.a);
                            CharSequence charSequence = new StringBuilder();
                            CharSequence charSequence2 = "MEDIA_INFO_VIDEO_ROTATION_CHANGED: ";
                            ((StringBuilder)charSequence).append((String)charSequence2);
                            ((StringBuilder)charSequence).append(n11);
                            charSequence = ((StringBuilder)charSequence).toString();
                            TXCLog.i((String)object, (String)charSequence);
                            TXCVodVideoView.h(this.a, n11);
                            object = this.a;
                            n11 = (int)(((TXCVodVideoView)object).a ? 1 : 0);
                            if (n11 != 0 && (n10 = TXCVodVideoView.o((TXCVodVideoView)((Object)object))) > 0) {
                                object = this.a;
                                n11 = TXCVodVideoView.o((TXCVodVideoView)((Object)object));
                                TXCVodVideoView.i((TXCVodVideoView)((Object)object), n11);
                                object = TXCVodVideoView.a(this.a);
                                if (object != null) {
                                    object = TXCVodVideoView.a(this.a);
                                    TXCVodVideoView tXCVodVideoView = this.a;
                                    n11 = TXCVodVideoView.p(tXCVodVideoView);
                                    object.setVideoRotation(n11);
                                }
                            }
                            object = this.a;
                            n11 = 2011;
                            float f13 = 2.818E-42f;
                            charSequence = new StringBuilder();
                            ((StringBuilder)charSequence).append("Video angle ");
                            n12 = TXCVodVideoView.o(this.a);
                            ((StringBuilder)charSequence).append(n12);
                            charSequence = ((StringBuilder)charSequence).toString();
                            charSequence2 = new StringBuilder();
                            ((StringBuilder)charSequence2).append("rotation ");
                            TXCVodVideoView tXCVodVideoView = this.a;
                            int n14 = TXCVodVideoView.o(tXCVodVideoView);
                            ((StringBuilder)charSequence2).append(n14);
                            charSequence2 = ((StringBuilder)charSequence2).toString();
                            TXCVodVideoView.a((TXCVodVideoView)((Object)object), n11, (String)charSequence, (String)charSequence2);
                            break block21;
                        }
                        String string22 = TXCVodVideoView.k(this.a);
                        String string23 = "MEDIA_INFO_SUBTITLE_TIMED_OUT:";
                        TXCLog.i(string22, string23);
                        break block21;
                    }
                    String string24 = TXCVodVideoView.k(this.a);
                    String string25 = "MEDIA_INFO_UNSUPPORTED_SUBTITLE:";
                    TXCLog.i(string24, string25);
                    break block21;
                }
                TXCVodVideoView tXCVodVideoView = this.a;
                n11 = 2017;
                float f14 = 2.826E-42f;
                String string26 = "Video data received";
                String string27 = "first video packet";
                TXCVodVideoView.a(tXCVodVideoView, n11, string26, string27);
                break block21;
            }
            Object object = TXCVodVideoView.k(this.a);
            String string28 = "MEDIA_INFO_VIDEO_RENDERING_START:";
            TXCLog.i(object, string28);
            object = this.a;
            n10 = (int)(TXCVodVideoView.l((TXCVodVideoView)((Object)object)) ? 1 : 0);
            if (n10 == 0) {
                object = this.a;
                n11 = 2003;
                f10 = 2.807E-42f;
                String string29 = "VOD displayed the first frame";
                String string30 = "render start";
                TXCVodVideoView.a((TXCVodVideoView)((Object)object), n11, string29, string30);
            }
            object = this.a;
            f10 = TXCVodVideoView.m((TXCVodVideoView)((Object)object));
            ((TXCVodVideoView)((Object)object)).setRate(f10);
            object = this.a;
            TXCVodVideoView.a((TXCVodVideoView)((Object)object), bl2);
        }
        return bl2;
    }
}

