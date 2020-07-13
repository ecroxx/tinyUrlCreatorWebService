package com.testRestWebService.testrestfulwebservice.domain;

public class WebUrlResultWrapper {
   public String deeplink;

    public WebUrlResultWrapper() {
    }

    public WebUrlResultWrapper(String deeplink) {
        this.deeplink = deeplink;
    }

    public String getDeeplink() {
        return deeplink;
    }

    public void setDeeplink(String deeplink) {
        this.deeplink = deeplink;
    }
}
