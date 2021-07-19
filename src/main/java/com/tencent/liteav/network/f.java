/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Looper
 *  android.os.Message
 *  org.json.JSONObject
 */
package com.tencent.liteav.network;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.network.f$1;
import com.tencent.liteav.network.f$2;
import com.tencent.liteav.network.g;
import com.tencent.liteav.network.i;
import org.json.JSONObject;

public class f {
    public g a;
    public i b;
    private final String c;
    private final String d;
    private final int e;
    private final int f;
    private Thread g;
    private boolean h;
    private Handler i;
    private String j;

    public f() {
        this.c = "http://playvideo.qcloud.com/getplayinfo/v2";
        this.d = "https://playvideo.qcloud.com/getplayinfo/v2";
        this.e = 0;
        this.f = 1;
        Looper looper = Looper.getMainLooper();
        f$1 f$1 = new f$1(this, looper);
        this.i = f$1;
        this.j = "{\"code\":0,\"message\":\"\",\"playerInfo\":{\"playerId\":\"0\",\"name\":\"\u521d\u59cb\u64ad\u653e\u5668\",\"defaultVideoClassification\":\"SD\",\"videoClassification\":[{\"id\":\"FLU\",\"name\":\"\u6d41\u7545\",\"definitionList\":[10,510,210,610,10046,710]},{\"id\":\"SD\",\"name\":\"\u6807\u6e05\",\"definitionList\":[20,520,220,620,10047,720]},{\"id\":\"HD\",\"name\":\"\u9ad8\u6e05\",\"definitionList\":[30,530,230,630,10048,730]},{\"id\":\"FHD\",\"name\":\"\u5168\u9ad8\u6e05\",\"definitionList\":[40,540,240,640,10049,740]},{\"id\":\"2K\",\"name\":\"2K\",\"definitionList\":[70,570,270,670,370,770]},{\"id\":\"4K\",\"name\":\"4K\",\"definitionList\":[80,580,280,680,380,780]}],\"logoLocation\":\"1\",\"logoPic\":\"\",\"logoUrl\":\"\"},\"coverInfo\":{\"coverUrl\":\"http://1255566655.vod2.myqcloud.com/7e9cee55vodtransgzp1255566655/8f5fbff14564972818519602447/coverBySnapshot/1513156403_1311093072.100_0.jpg?t=5c08d9fa&us=someus&sign=95f34beb353fe32cfe7f8b5e79cc28b1\"},\"imageSpriteInfo\":{\"imageSpriteList\":[{\"definition\":10,\"height\":80,\"width\":142,\"totalCount\":4,\"imageUrls\":[\"http://1255566655.vod2.myqcloud.com/ca754badvodgzp1255566655/8f5fbff14564972818519602447/imageSprite/1513156058_533711271_00001.jpg?t=5c08d9fa&us=someus&sign=79449db4e1fb05a3becfa096613659c3\"],\"webVttUrl\":\"http://1255566655.vod2.myqcloud.com/ca754badvodgzp1255566655/8f5fbff14564972818519602447/imageSprite/1513156058_533711271.vtt?t=5c08d9fa&us=someus&sign=79449db4e1fb05a3becfa096613659c3\"}]},\"videoInfo\":{\"sourceVideo\":{\"url\":\"http://1255566655.vod2.myqcloud.com/ca754badvodgzp1255566655/8f5fbff14564972818519602447/uAnXX0OMLSAA.wmv?t=5c08d9fa&us=someus&sign=659af5dd3f27eb92dc4ed74eb561daa4\",\"definition\":0,\"duration\":30,\"floatDuration\":30.093000411987305,\"size\":26246026,\"bitrate\":6134170,\"height\":720,\"width\":1280,\"container\":\"asf\",\"md5\":\"\",\"videoStreamList\":[{\"bitrate\":5942130,\"height\":720,\"width\":1280,\"codec\":\"vc1\",\"fps\":29}],\"audioStreamList\":[{\"samplingRate\":44100,\"bitrate\":192040,\"codec\":\"wmav2\"}]},\"mas\u00a9terPlayList1\":{\"idrAligned\":false,\"url\":\"http://1255566655.vod2.myqcloud.com/7e9cee55vodtransgzp1255566655/8f5fbff14564972818519602447/master_playlist.m3u8?t=5c08d9fa&us=someus&sign=66290475b7182c89193f03b8f74a979d\",\"definition\":10000,\"md5\":\"23ecc2cfe4cb7c8f87af41993ba8c09c\"},\"transcodeList\":[{\"url\":\"http://1255566655.vod2.myqcloud.com/7e9cee55vodtransgzp1255566655/8f5fbff14564972818519602447/v.f220.m3u8?t=5c08d9fa&us=someus&sign=66290475b7182c89193f03b8f74a979d\",\"definition\":220,\"duration\":30,\"floatDuration\":30.08329963684082,\"size\":796,\"bitrate\":646036,\"height\":360,\"width\":640,\"container\":\"hls,applehttp\",\"md5\":\"dce044407826b4d809c16b6d1a9e9f13\",\"videoStreamList\":[{\"bitrate\":607449,\"height\":360,\"width\":640,\"codec\":\"h264\",\"fps\":24}],\"audioStreamList\":[{\"samplingRate\":44100,\"bitrate\":38587,\"codec\":\"aac\"}]},{\"url\":\"http://1255566655.vod2.myqcloud.com/7e9cee55vodtransgzp1255566655/8f5fbff14564972818519602447/v.f230.m3u8?t=5c08d9fa&us=someus&sign=66290475b7182c89193f03b8f74a979d\",\"definition\":230,\"duration\":30,\"floatDuration\":30.04170036315918,\"size\":802,\"bitrate\":1224776,\"height\":720,\"width\":1280,\"container\":\"hls,applehttp\",\"md5\":\"f07bb0be9e2fee967d87b6c310d3c036\",\"videoStreamList\":[{\"bitrate\":1186189,\"height\":720,\"width\":1280,\"codec\":\"h264\",\"fps\":24}],\"audioStreamList\":[{\"samplingRate\":44100,\"bitrate\":38587,\"codec\":\"aac\"}]},{\"url\":\"http://1255566655.vod2.myqcloud.com/7e9cee55vodtransgzp1255566655/8f5fbff14564972818519602447/v.f240.m3u8?t=5c08d9fa&us=someus&sign=66290475b7182c89193f03b8f74a979d\",\"definition\":240,\"duration\":30,\"floatDuration\":0,\"size\":809,\"bitrate\":2866685,\"height\":1080,\"width\":1920,\"container\":\"hls,applehttp\",\"md5\":\"ff8190cf07afceb8ed053b198453e954\",\"videoStreamList\":[{\"bitrate\":2828098,\"height\":1080,\"width\":1920,\"codec\":\"h264\",\"fps\":24}],\"audioStreamList\":[{\"samplingRate\":44100,\"bitrate\":38587,\"codec\":\"aac\"}]},{\"url\":\"http://1255566655.vod2.myqcloud.com/7e9cee55vodtransgzp1255566655/8f5fbff14564972818519602447/v.f210.m3u8?t=5c08d9fa&us=someus&sign=66290475b7182c89193f03b8f74a979d\",\"definition\":210,\"duration\":30,\"floatDuration\":30.08329963684082,\"size\":788,\"bitrate\":358908,\"height\":180,\"width\":320,\"container\":\"hls,applehttp\",\"md5\":\"5fa784e0a588c51dc2d7428ad6787079\",\"videoStreamList\":[{\"bitrate\":320321,\"height\":180,\"width\":320,\"codec\":\"h264\",\"fps\":24}],\"audioStreamList\":[{\"samplingRate\":44100,\"bitrate\":38587,\"codec\":\"aac\"}]},{\"url\":\"http://1255566655.vod2.myqcloud.com/7e9cee55vodtransgzp1255566655/8f5fbff14564972818519602447/v.f10.mp4?t=5c08d9fa&us=someus&sign=66290475b7182c89193f03b8f74a979d\",\"definition\":10,\"duration\":30,\"floatDuration\":30.139400482177734,\"size\":1169168,\"bitrate\":303916,\"height\":180,\"width\":320,\"container\":\"mov,mp4,m4a,3gp,3g2,mj2\",\"md5\":\"85002ed20125acf150d014b192cf39a0\",\"videoStreamList\":[{\"bitrate\":255698,\"height\":180,\"width\":320,\"codec\":\"h264\",\"fps\":24}],\"audioStreamList\":[{\"samplingRate\":44100,\"bitrate\":48218,\"codec\":\"aac\"}]},{\"url\":\"http://1255566655.vod2.myqcloud.com/7e9cee55vodtransgzp1255566655/8f5fbff14564972818519602447/v.f20.mp4?t=5c08d9fa&us=someus&sign=66290475b7182c89193f03b8f74a979d\",\"definition\":20,\"duration\":30,\"floatDuration\":30.139400482177734,\"size\":2158411,\"bitrate\":566647,\"height\":360,\"width\":640,\"container\":\"mov,mp4,m4a,3gp,3g2,mj2\",\"md5\":\"cba3630e5f92325041da7fee336246b6\",\"videoStreamList\":[{\"bitrate\":518429,\"height\":360,\"width\":640,\"codec\":\"h264\",\"fps\":24}],\"audioStreamList\":[{\"samplingRate\":44100,\"bitrate\":48218,\"codec\":\"aac\"}]}]}}";
    }

    public static /* synthetic */ String a(f f10, String string2, String string3, int n10, String string4) {
        return f10.a(string2, string3, n10, string4);
    }

    private String a(String charSequence, String string2, int n10, String string3) {
        int n11;
        int n12;
        CharSequence charSequence2;
        StringBuilder stringBuilder = new StringBuilder();
        String string4 = "&";
        if (charSequence != null) {
            charSequence2 = new StringBuilder();
            String string5 = "t=";
            ((StringBuilder)charSequence2).append(string5);
            ((StringBuilder)charSequence2).append((String)charSequence);
            ((StringBuilder)charSequence2).append(string4);
            charSequence = ((StringBuilder)charSequence2).toString();
            stringBuilder.append((String)charSequence);
        }
        if (string2 != null) {
            charSequence = new StringBuilder();
            charSequence2 = "us=";
            ((StringBuilder)charSequence).append((String)charSequence2);
            ((StringBuilder)charSequence).append(string2);
            ((StringBuilder)charSequence).append(string4);
            charSequence = ((StringBuilder)charSequence).toString();
            stringBuilder.append((String)charSequence);
        }
        if (string3 != null) {
            charSequence = new StringBuilder();
            string2 = "sign=";
            ((StringBuilder)charSequence).append(string2);
            ((StringBuilder)charSequence).append(string3);
            ((StringBuilder)charSequence).append(string4);
            charSequence = ((StringBuilder)charSequence).toString();
            stringBuilder.append((String)charSequence);
        }
        if (n10 >= 0) {
            charSequence = new StringBuilder();
            string2 = "exper=";
            ((StringBuilder)charSequence).append(string2);
            ((StringBuilder)charSequence).append(n10);
            ((StringBuilder)charSequence).append(string4);
            charSequence = ((StringBuilder)charSequence).toString();
            stringBuilder.append((String)charSequence);
        }
        if ((n12 = stringBuilder.length()) > (n11 = 1)) {
            n12 = stringBuilder.length() - n11;
            stringBuilder.deleteCharAt(n12);
        }
        return stringBuilder.toString();
    }

    public static /* synthetic */ void a(f f10, String string2) {
        f10.a(string2);
    }

    private void a(String object) {
        Object object2 = new JSONObject((String)object);
        int n10 = object2.getInt((String)(object = "code"));
        if (n10 != 0) {
            object2 = object2.getString("message");
            TXCLog.e("TXCVodPlayerNetApi", (String)object2);
            this.a((String)object2, n10);
            return;
        }
        this.b = object = new i((JSONObject)object2);
        if ((object = ((i)object).a()) == null) {
            n10 = -3;
            object2 = "No playback address";
            this.a((String)object2, n10);
        } else {
            object = this.i;
            object2 = null;
            object.sendEmptyMessage(0);
        }
    }

    public static /* synthetic */ boolean a(f f10) {
        return f10.h;
    }

    public int a(int n10, String string2, String string3, String string4, int n11, String string5) {
        int n12 = -1;
        if (n10 != 0 && string2 != null) {
            if ((string3 != null || n11 > 0) && string5 == null) {
                return n12;
            }
            f$2 f$2 = new f$2(this, "getPlayInfo", n10, string2, string3, string4, n11, string5);
            this.g = f$2;
            f$2.start();
            return 0;
        }
        return n12;
    }

    public i a() {
        return this.b;
    }

    public void a(g g10) {
        this.a = g10;
    }

    public void a(String string2, int n10) {
        Message message = new Message();
        message.what = 1;
        message.arg1 = n10;
        message.obj = string2;
        this.i.sendMessage(message);
    }

    public void a(boolean bl2) {
        this.h = bl2;
    }
}

