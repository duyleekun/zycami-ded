/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.convertor;

import cn.leancloud.callback.CloudQueryCallback;
import cn.leancloud.callback.CountCallback;
import cn.leancloud.callback.DeleteCallback;
import cn.leancloud.callback.FindCallback;
import cn.leancloud.callback.FollowCallback;
import cn.leancloud.callback.FollowersAndFolloweesCallback;
import cn.leancloud.callback.FunctionCallback;
import cn.leancloud.callback.GetCallback;
import cn.leancloud.callback.GetDataCallback;
import cn.leancloud.callback.GetDataStreamCallback;
import cn.leancloud.callback.LogInCallback;
import cn.leancloud.callback.MobilePhoneVerifyCallback;
import cn.leancloud.callback.RefreshCallback;
import cn.leancloud.callback.RequestEmailVerifyCallback;
import cn.leancloud.callback.RequestMobileCodeCallback;
import cn.leancloud.callback.RequestPasswordResetCallback;
import cn.leancloud.callback.SaveCallback;
import cn.leancloud.callback.SendCallback;
import cn.leancloud.callback.SignUpCallback;
import cn.leancloud.callback.StatusCallback;
import cn.leancloud.callback.StatusListCallback;
import cn.leancloud.callback.UpdatePasswordCallback;
import cn.leancloud.convertor.ObserverBuilder$CollectionObserver;
import cn.leancloud.convertor.ObserverBuilder$SingleObjectObserver;

public class ObserverBuilder {
    public static ObserverBuilder$CollectionObserver buildCollectionObserver(FindCallback findCallback) {
        ObserverBuilder$CollectionObserver observerBuilder$CollectionObserver = new ObserverBuilder$CollectionObserver(findCallback);
        return observerBuilder$CollectionObserver;
    }

    public static ObserverBuilder$CollectionObserver buildCollectionObserver(StatusListCallback statusListCallback) {
        ObserverBuilder$CollectionObserver observerBuilder$CollectionObserver = new ObserverBuilder$CollectionObserver(statusListCallback);
        return observerBuilder$CollectionObserver;
    }

    public static ObserverBuilder$CollectionObserver buildSingleObserver(FindCallback findCallback) {
        ObserverBuilder$CollectionObserver observerBuilder$CollectionObserver = new ObserverBuilder$CollectionObserver(findCallback);
        return observerBuilder$CollectionObserver;
    }

    public static ObserverBuilder$SingleObjectObserver buildSingleObserver(CloudQueryCallback cloudQueryCallback) {
        ObserverBuilder$SingleObjectObserver observerBuilder$SingleObjectObserver = new ObserverBuilder$SingleObjectObserver(cloudQueryCallback);
        return observerBuilder$SingleObjectObserver;
    }

    public static ObserverBuilder$SingleObjectObserver buildSingleObserver(CountCallback countCallback) {
        ObserverBuilder$SingleObjectObserver observerBuilder$SingleObjectObserver = new ObserverBuilder$SingleObjectObserver(countCallback);
        return observerBuilder$SingleObjectObserver;
    }

    public static ObserverBuilder$SingleObjectObserver buildSingleObserver(DeleteCallback deleteCallback) {
        ObserverBuilder$SingleObjectObserver observerBuilder$SingleObjectObserver = new ObserverBuilder$SingleObjectObserver(deleteCallback);
        return observerBuilder$SingleObjectObserver;
    }

    public static ObserverBuilder$SingleObjectObserver buildSingleObserver(FollowCallback followCallback) {
        ObserverBuilder$SingleObjectObserver observerBuilder$SingleObjectObserver = new ObserverBuilder$SingleObjectObserver(followCallback);
        return observerBuilder$SingleObjectObserver;
    }

    public static ObserverBuilder$SingleObjectObserver buildSingleObserver(FollowersAndFolloweesCallback followersAndFolloweesCallback) {
        ObserverBuilder$SingleObjectObserver observerBuilder$SingleObjectObserver = new ObserverBuilder$SingleObjectObserver(followersAndFolloweesCallback);
        return observerBuilder$SingleObjectObserver;
    }

    public static ObserverBuilder$SingleObjectObserver buildSingleObserver(FunctionCallback functionCallback) {
        ObserverBuilder$SingleObjectObserver observerBuilder$SingleObjectObserver = new ObserverBuilder$SingleObjectObserver(functionCallback);
        return observerBuilder$SingleObjectObserver;
    }

    public static ObserverBuilder$SingleObjectObserver buildSingleObserver(GetCallback getCallback) {
        ObserverBuilder$SingleObjectObserver observerBuilder$SingleObjectObserver = new ObserverBuilder$SingleObjectObserver(getCallback);
        return observerBuilder$SingleObjectObserver;
    }

    public static ObserverBuilder$SingleObjectObserver buildSingleObserver(GetDataCallback getDataCallback) {
        ObserverBuilder$SingleObjectObserver observerBuilder$SingleObjectObserver = new ObserverBuilder$SingleObjectObserver(getDataCallback);
        return observerBuilder$SingleObjectObserver;
    }

    public static ObserverBuilder$SingleObjectObserver buildSingleObserver(GetDataStreamCallback getDataStreamCallback) {
        ObserverBuilder$SingleObjectObserver observerBuilder$SingleObjectObserver = new ObserverBuilder$SingleObjectObserver(getDataStreamCallback);
        return observerBuilder$SingleObjectObserver;
    }

    public static ObserverBuilder$SingleObjectObserver buildSingleObserver(LogInCallback logInCallback) {
        ObserverBuilder$SingleObjectObserver observerBuilder$SingleObjectObserver = new ObserverBuilder$SingleObjectObserver(logInCallback);
        return observerBuilder$SingleObjectObserver;
    }

    public static ObserverBuilder$SingleObjectObserver buildSingleObserver(MobilePhoneVerifyCallback mobilePhoneVerifyCallback) {
        ObserverBuilder$SingleObjectObserver observerBuilder$SingleObjectObserver = new ObserverBuilder$SingleObjectObserver(mobilePhoneVerifyCallback);
        return observerBuilder$SingleObjectObserver;
    }

    public static ObserverBuilder$SingleObjectObserver buildSingleObserver(RefreshCallback refreshCallback) {
        ObserverBuilder$SingleObjectObserver observerBuilder$SingleObjectObserver = new ObserverBuilder$SingleObjectObserver(refreshCallback);
        return observerBuilder$SingleObjectObserver;
    }

    public static ObserverBuilder$SingleObjectObserver buildSingleObserver(RequestEmailVerifyCallback requestEmailVerifyCallback) {
        ObserverBuilder$SingleObjectObserver observerBuilder$SingleObjectObserver = new ObserverBuilder$SingleObjectObserver(requestEmailVerifyCallback);
        return observerBuilder$SingleObjectObserver;
    }

    public static ObserverBuilder$SingleObjectObserver buildSingleObserver(RequestMobileCodeCallback requestMobileCodeCallback) {
        ObserverBuilder$SingleObjectObserver observerBuilder$SingleObjectObserver = new ObserverBuilder$SingleObjectObserver(requestMobileCodeCallback);
        return observerBuilder$SingleObjectObserver;
    }

    public static ObserverBuilder$SingleObjectObserver buildSingleObserver(RequestPasswordResetCallback requestPasswordResetCallback) {
        ObserverBuilder$SingleObjectObserver observerBuilder$SingleObjectObserver = new ObserverBuilder$SingleObjectObserver(requestPasswordResetCallback);
        return observerBuilder$SingleObjectObserver;
    }

    public static ObserverBuilder$SingleObjectObserver buildSingleObserver(SaveCallback saveCallback) {
        ObserverBuilder$SingleObjectObserver observerBuilder$SingleObjectObserver = new ObserverBuilder$SingleObjectObserver(saveCallback);
        return observerBuilder$SingleObjectObserver;
    }

    public static ObserverBuilder$SingleObjectObserver buildSingleObserver(SendCallback sendCallback) {
        ObserverBuilder$SingleObjectObserver observerBuilder$SingleObjectObserver = new ObserverBuilder$SingleObjectObserver(sendCallback);
        return observerBuilder$SingleObjectObserver;
    }

    public static ObserverBuilder$SingleObjectObserver buildSingleObserver(SignUpCallback signUpCallback) {
        ObserverBuilder$SingleObjectObserver observerBuilder$SingleObjectObserver = new ObserverBuilder$SingleObjectObserver(signUpCallback);
        return observerBuilder$SingleObjectObserver;
    }

    public static ObserverBuilder$SingleObjectObserver buildSingleObserver(StatusCallback statusCallback) {
        ObserverBuilder$SingleObjectObserver observerBuilder$SingleObjectObserver = new ObserverBuilder$SingleObjectObserver(statusCallback);
        return observerBuilder$SingleObjectObserver;
    }

    public static ObserverBuilder$SingleObjectObserver buildSingleObserver(UpdatePasswordCallback updatePasswordCallback) {
        ObserverBuilder$SingleObjectObserver observerBuilder$SingleObjectObserver = new ObserverBuilder$SingleObjectObserver(updatePasswordCallback);
        return observerBuilder$SingleObjectObserver;
    }
}

