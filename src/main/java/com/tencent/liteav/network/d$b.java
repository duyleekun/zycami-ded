/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package com.tencent.liteav.network;

import android.os.Bundle;
import com.tencent.liteav.basic.b.b;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.structs.TXSNALPacket;
import com.tencent.liteav.basic.structs.a;
import com.tencent.liteav.network.TXIStreamDownloader;
import com.tencent.liteav.network.d;
import com.tencent.liteav.network.h;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class d$b
implements b,
h {
    private final int a;
    private long b;
    private long c;
    private int d;
    private boolean e;
    private long f;
    private long g;
    private long h;
    private ArrayList i;
    private ArrayList j;
    private TXIStreamDownloader k;
    private WeakReference l;
    private h m;

    public d$b(TXIStreamDownloader tXIStreamDownloader, d d10) {
        long l10;
        this.a = 2;
        this.b = l10 = 0L;
        this.c = l10;
        this.d = 0;
        this.e = false;
        this.f = l10;
        this.g = l10;
        this.h = l10;
        WeakReference<d> weakReference = new WeakReference<d>();
        this.i = weakReference;
        weakReference = new WeakReference<d>();
        this.j = weakReference;
        this.k = null;
        this.l = weakReference = new WeakReference<d>(d10);
        this.k = tXIStreamDownloader;
        tXIStreamDownloader.setListener(this);
    }

    private void a(TXSNALPacket tXSNALPacket) {
        long l10;
        long l11;
        String string2;
        int n10;
        long l12;
        Object object;
        Object object2 = (d)this.l.get();
        int n11 = tXSNALPacket.nalType;
        Object object3 = 1;
        String string3 = "TXCMultiStreamDownloader";
        if (n11 == 0 && (n11 = (int)(this.e ? 1 : 0)) == 0) {
            long l13;
            long l14;
            long l15;
            this.d = n11 = this.d + object3;
            object = new StringBuilder();
            ((StringBuilder)object).append("[SwitchStream] processing... current video ts:");
            l12 = tXSNALPacket.pts;
            ((StringBuilder)object).append(l12);
            ((StringBuilder)object).append(" target video ts:");
            l12 = tXSNALPacket.pts;
            ((StringBuilder)object).append(l12);
            ((StringBuilder)object).append(" check times:");
            n10 = this.d;
            ((StringBuilder)object).append(n10);
            string2 = " maxTimes:";
            ((StringBuilder)object).append(string2);
            n10 = 2;
            ((StringBuilder)object).append(n10);
            object = ((StringBuilder)object).toString();
            TXCLog.i(string3, (String)object);
            if (object2 != null && ((n11 = (int)((l15 = (l14 = com.tencent.liteav.network.d.a((d)object2)) - (l13 = tXSNALPacket.pts)) == 0L ? 0 : (l15 < 0L ? -1 : 1))) <= 0 || (n11 = this.d) == n10)) {
                l14 = com.tencent.liteav.network.d.a((d)object2);
                long l16 = l14 - (l13 = tXSNALPacket.pts);
                n11 = (int)(l16 == 0L ? 0 : (l16 < 0L ? -1 : 1));
                if (n11 <= 0) {
                    object = "[SwitchStream] switch video success, video data is ready.";
                    TXCLog.i(string3, (String)object);
                } else {
                    n11 = this.d;
                    if (n11 == n10) {
                        object = "[SwitchStream] switch video failed. all times retried. max times:2";
                        TXCLog.e(string3, (String)object);
                    }
                }
                this.b = l12 = ((d)object2).c();
                this.e = object3;
            }
        }
        if ((n11 = (int)(this.e ? 1 : 0)) == 0) {
            return;
        }
        if (object2 != null) {
            l12 = tXSNALPacket.pts;
            ((d)object2).a(l12);
        }
        if ((n11 = (int)((l11 = (l12 = tXSNALPacket.pts) - (l10 = this.b)) == 0L ? 0 : (l11 < 0L ? -1 : 1))) >= 0) {
            long l17;
            long l18;
            long l19;
            n11 = tXSNALPacket.nalType;
            l10 = 0L;
            String string4 = " type ";
            String string5 = " from ";
            if (n11 == 0 && (n11 = (int)((l19 = (l18 = this.c) - l10) == 0L ? 0 : (l19 < 0L ? -1 : 1))) == 0) {
                this.c = l12;
                object = new StringBuilder();
                string2 = "[SwitchStream] pre start end ";
                ((StringBuilder)object).append(string2);
                l12 = tXSNALPacket.pts;
                ((StringBuilder)object).append(l12);
                ((StringBuilder)object).append(string5);
                l12 = this.b;
                ((StringBuilder)object).append(l12);
                ((StringBuilder)object).append(string4);
                n10 = tXSNALPacket.nalType;
                ((StringBuilder)object).append(n10);
                object = ((StringBuilder)object).toString();
                TXCLog.w(string3, (String)object);
            }
            if ((n11 = (int)((l17 = (l12 = this.c) - l10) == 0L ? 0 : (l17 < 0L ? -1 : 1))) > 0) {
                object = this.m;
                if (object != null) {
                    Object object4;
                    boolean bl2;
                    if (object2 != null) {
                        object = this.k;
                        ((d)object2).a((TXIStreamDownloader)object, (boolean)object3);
                    }
                    if (!(bl2 = ((ArrayList)(object2 = this.j)).isEmpty())) {
                        object2 = this.j.iterator();
                        while ((n11 = (int)(object2.hasNext() ? 1 : 0)) != 0) {
                            object = (a)object2.next();
                            l12 = ((a)object).e;
                            l10 = this.c;
                            long l20 = l12 - l10;
                            object3 = l20 == 0L ? 0 : (l20 < 0L ? -1 : 1);
                            if (object3 < 0) continue;
                            object4 = new StringBuilder();
                            string2 = "[SwitchStream] pre start cache audio pts ";
                            ((StringBuilder)object4).append(string2);
                            l12 = ((a)object).e;
                            ((StringBuilder)object4).append(l12);
                            ((StringBuilder)object4).append(string5);
                            l12 = this.c;
                            ((StringBuilder)object4).append(l12);
                            object4 = ((StringBuilder)object4).toString();
                            TXCLog.i(string3, (String)object4);
                            object4 = this.m;
                            object4.onPullAudio((a)object);
                        }
                        object2 = new StringBuilder();
                        ((StringBuilder)object2).append("[SwitchStream] pre start end audio cache  ");
                        object = this.j;
                        n11 = ((ArrayList)object).size();
                        ((StringBuilder)object2).append(n11);
                        object2 = ((StringBuilder)object2).toString();
                        TXCLog.w(string3, (String)object2);
                        object2 = this.j;
                        ((ArrayList)object2).clear();
                    }
                    if (!(bl2 = ((ArrayList)(object2 = this.i)).isEmpty())) {
                        object2 = new StringBuilder();
                        ((StringBuilder)object2).append("[SwitchStream] pre start end video cache  ");
                        object = this.i;
                        n11 = ((ArrayList)object).size();
                        ((StringBuilder)object2).append(n11);
                        object2 = ((StringBuilder)object2).toString();
                        TXCLog.w(string3, (String)object2);
                        object2 = this.i.iterator();
                        while ((n11 = (int)(object2.hasNext() ? 1 : 0)) != 0) {
                            object = (TXSNALPacket)object2.next();
                            object4 = this.m;
                            object4.onPullNAL((TXSNALPacket)object);
                        }
                        object2 = this.i;
                        ((ArrayList)object2).clear();
                    }
                    object2 = new StringBuilder();
                    object = "[SwitchStream] pre start first pull nal ";
                    ((StringBuilder)object2).append((String)object);
                    long l21 = tXSNALPacket.pts;
                    ((StringBuilder)object2).append(l21);
                    ((StringBuilder)object2).append(string5);
                    l21 = this.c;
                    ((StringBuilder)object2).append(l21);
                    ((StringBuilder)object2).append(string4);
                    n11 = tXSNALPacket.nalType;
                    ((StringBuilder)object2).append(n11);
                    object2 = ((StringBuilder)object2).toString();
                    TXCLog.w(string3, (String)object2);
                    object2 = this.m;
                    object2.onPullNAL(tXSNALPacket);
                    tXSNALPacket = null;
                    this.m = null;
                } else {
                    object2 = new StringBuilder();
                    object = "[SwitchStream] pre start cache video pts ";
                    ((StringBuilder)object2).append((String)object);
                    long l22 = tXSNALPacket.pts;
                    ((StringBuilder)object2).append(l22);
                    ((StringBuilder)object2).append(string5);
                    l22 = this.c;
                    ((StringBuilder)object2).append(l22);
                    ((StringBuilder)object2).append(string4);
                    n11 = tXSNALPacket.nalType;
                    ((StringBuilder)object2).append(n11);
                    object2 = ((StringBuilder)object2).toString();
                    TXCLog.i(string3, (String)object2);
                    object2 = this.i;
                    ((ArrayList)object2).add(tXSNALPacket);
                }
            }
        }
    }

    private void a(a a10) {
        long l10;
        long l11;
        if (a10 == null) {
            return;
        }
        long l12 = a10.e;
        long l13 = this.c;
        long l14 = l12 - l13;
        Object object = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
        if (object >= 0 && (object = (l11 = l12 - (l10 = this.b)) == 0L ? 0 : (l11 < 0L ? -1 : 1)) >= 0) {
            long l15;
            long l16;
            long l17;
            long l18;
            h h10 = this.m;
            if (h10 != null && (l18 = (l17 = l13 - (l16 = 0L)) == 0L ? 0 : (l17 < 0L ? -1 : 1)) > 0 && (l15 = l12 == l13 ? 0 : (l12 < l13 ? -1 : 1)) >= 0) {
                h10.onPullAudio(a10);
            } else {
                ArrayList arrayList = this.j;
                arrayList.add(a10);
            }
        }
    }

    private void b(TXSNALPacket object) {
        long l10;
        long l11;
        long l12;
        long l13;
        Object object2 = (d)this.l.get();
        if (object2 != null) {
            l13 = ((TXSNALPacket)object).pts;
            ((d)object2).b(l13);
        }
        if ((l12 = (l11 = (l13 = ((TXSNALPacket)object).pts) - (l10 = this.f)) == 0L ? 0 : (l11 < 0L ? -1 : 1)) >= 0) {
            long l14;
            long l15;
            l12 = ((TXSNALPacket)object).nalType;
            if (l12 == false) {
                this.g = l13;
            }
            if ((l15 = (l14 = (l13 = this.g) - (l10 = 0L)) == 0L ? 0 : (l14 < 0L ? -1 : 1)) > 0) {
                l13 = this.h;
                l15 = l13 == l10 ? 0 : (l13 < l10 ? -1 : 1);
                String string2 = "TXCMultiStreamDownloader";
                if (l15 > 0) {
                    object = new StringBuilder();
                    ((StringBuilder)object).append("[SwitchStream] switch finish and stop old downloader. video ts:");
                    l10 = this.g;
                    ((StringBuilder)object).append(l10);
                    ((StringBuilder)object).append(" audio ts:");
                    l10 = this.h;
                    ((StringBuilder)object).append(l10);
                    String string3 = " stop ts:";
                    ((StringBuilder)object).append(string3);
                    l10 = this.f;
                    ((StringBuilder)object).append(l10);
                    object = ((StringBuilder)object).toString();
                    TXCLog.i(string2, (String)object);
                    if (object2 != null) {
                        ((d)object2).b();
                    }
                    boolean bl2 = false;
                    this.m = null;
                    object2 = this.k;
                    ((TXIStreamDownloader)object2).setListener(null);
                    object = this.k;
                    ((TXIStreamDownloader)object).stopDownload();
                } else {
                    object2 = new StringBuilder();
                    ((StringBuilder)object2).append("[SwitchStream] delay stop video end wait audio end video pts ");
                    l10 = ((TXSNALPacket)object).pts;
                    ((StringBuilder)object2).append(l10);
                    ((StringBuilder)object2).append(" from ");
                    l10 = this.f;
                    ((StringBuilder)object2).append(l10);
                    String string4 = " type ";
                    ((StringBuilder)object2).append(string4);
                    int n10 = ((TXSNALPacket)object).nalType;
                    ((StringBuilder)object2).append(n10);
                    object = ((StringBuilder)object2).toString();
                    TXCLog.w(string2, (String)object);
                }
            } else {
                object2 = this.m;
                if (object2 != null) {
                    object2.onPullNAL((TXSNALPacket)object);
                }
            }
        } else {
            object2 = this.m;
            if (object2 != null) {
                object2.onPullNAL((TXSNALPacket)object);
            }
        }
    }

    private void b(a a10) {
        long l10;
        long l11 = this.h;
        long l12 = 0L;
        long l13 = l11 - l12;
        Object object = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (object > 0) {
            return;
        }
        l11 = this.g;
        long l14 = l11 - l12;
        Object object2 = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
        if (object2 > 0 && a10 != null && (object = (l10 = (l12 = a10.e) - l11) == 0L ? 0 : (l10 < 0L ? -1 : 1)) >= 0) {
            this.h = l12;
            return;
        }
        h h10 = this.m;
        if (h10 != null) {
            h10.onPullAudio(a10);
        }
    }

    public void a(long l10) {
        CharSequence charSequence = new StringBuilder();
        charSequence.append("[SwitchStream] start switch. current video pts:");
        charSequence.append(l10);
        charSequence = charSequence.toString();
        TXCLog.i("TXCMultiStreamDownloader", (String)charSequence);
        this.d = 0;
        this.b = l10;
        this.k.setListener(this);
        this.k.setNotifyListener(this);
    }

    public void a(h h10) {
        this.m = h10;
    }

    public void b(long l10) {
        long l11;
        long l12;
        CharSequence charSequence = new StringBuilder();
        charSequence.append("[SwitchStream] stop switch. pts:");
        charSequence.append(l10);
        charSequence = charSequence.toString();
        String string2 = "TXCMultiStreamDownloader";
        TXCLog.i(string2, (String)charSequence);
        this.b = l12 = 0L;
        this.f = l10;
        this.h = l12;
        this.g = l12;
        TXIStreamDownloader tXIStreamDownloader = this.k;
        if (tXIStreamDownloader != null && (l11 = l10 == l12 ? 0 : (l10 < l12 ? -1 : 1)) == false) {
            tXIStreamDownloader.stopDownload();
            l11 = 0;
            this.k = null;
        }
    }

    public void onNotifyEvent(int n10, Bundle object) {
        int n11 = -2301;
        if (n10 == n11 || n10 == (n11 = 3010)) {
            Object object2 = (d)this.l.get();
            if (object2 != null) {
                object = this.k;
                ((d)object2).a((TXIStreamDownloader)object, false);
            }
            object2 = this.k;
            n11 = 0;
            object = null;
            ((TXIStreamDownloader)object2).setNotifyListener(null);
        }
    }

    public void onPullAudio(a a10) {
        long l10 = this.b;
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object > 0) {
            this.a(a10);
        } else {
            l10 = this.f;
            long l13 = l10 - l11;
            object = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
            if (object > 0) {
                this.b(a10);
            } else {
                h h10 = this.m;
                if (h10 != null) {
                    h10.onPullAudio(a10);
                }
            }
        }
    }

    public void onPullNAL(TXSNALPacket tXSNALPacket) {
        if (tXSNALPacket == null) {
            return;
        }
        long l10 = this.b;
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object > 0) {
            this.a(tXSNALPacket);
        } else {
            l10 = this.f;
            long l13 = l10 - l11;
            object = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
            if (object > 0) {
                this.b(tXSNALPacket);
            } else {
                h h10 = this.m;
                if (h10 != null) {
                    h10.onPullNAL(tXSNALPacket);
                }
            }
        }
    }
}

