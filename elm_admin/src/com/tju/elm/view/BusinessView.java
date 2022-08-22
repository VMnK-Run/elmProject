package com.tju.elm.view;

import com.tju.elm.po.Business;

public interface BusinessView {

    public void listBusinessAll();
    public void listBusiness();

    public void saveBusiness();
    public void removeBusiness();

    public Business logIn();
    public void showBusiness(Integer businessId);
    public void editBusiness(Integer businessId);
    public void updateBusinessByPassword(Integer businessId);
}
