/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.webkit.WebView
 *  android.widget.RelativeLayout
 */
package cn.sharesdk.facebook;

import android.app.Activity;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import cn.sharesdk.framework.TitleLayout;

public class FBWebShareAdapter {
    private Activity activity;
    private boolean noTitle;
    private RelativeLayout rlBody;
    private TitleLayout title;
    private WebView webview;

    public Activity getActivity() {
        return this.activity;
    }

    public RelativeLayout getBodyView() {
        return this.rlBody;
    }

    public TitleLayout getTitleLayout() {
        return this.title;
    }

    public WebView getWebBody() {
        return this.webview;
    }

    public boolean isNotitle() {
        return this.noTitle;
    }

    public void onCreate() {
    }

    public void onDestroy() {
    }

    public boolean onFinish() {
        return false;
    }

    public void onPause() {
    }

    public void onRestart() {
    }

    public void onResume() {
    }

    public void onStart() {
    }

    public void onStop() {
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public void setBodyView(RelativeLayout relativeLayout) {
        this.rlBody = relativeLayout;
    }

    public void setNotitle(boolean bl2) {
        this.noTitle = bl2;
    }

    public void setTitleView(TitleLayout titleLayout) {
        this.title = titleLayout;
    }

    public void setWebView(WebView webView) {
        this.webview = webView;
    }
}

