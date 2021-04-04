package com.arcadio.arcresourcemanager;

import android.util.Patterns;
import android.webkit.URLUtil;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class ResourcesModule {
    public String folderName;
    public String catgoryName;
    public String extention;
    public String rootUrl;
    public int freeCounter;
    public int paidCounter;
    public int adCounter;
    private boolean premiumUser;
    private boolean isFreeAsset = true;

    public ArrayList<String> getResLinks() {
        return allLinks;
    }

    private ArrayList<String> allLinks = new ArrayList<>();

    public ResourcesModule(String rootUrl, String folderName, String catgoryName, String extention, int freeCounter,
                           int paidCounter, int adCounter, boolean premiumUser) {
        this.folderName = folderName;
        this.catgoryName = catgoryName;
        this.freeCounter = freeCounter;
        this.paidCounter = paidCounter;
        this.adCounter = adCounter;
        this.premiumUser = premiumUser;
        this.extention = extention;
        this.rootUrl = rootUrl;
        setUpLinks();
    }

    private void setUpLinks() {
        for (int i = 1; i <= paidCounter; i++) {
            allLinks.add(i + ArcResProperty.ResType.PAID.getValue() + "." + extention);
            isFreeAsset = premiumUser ? true : false;
        }

        for (int i = 1; i <= adCounter; i++) {
            allLinks.add(i + ArcResProperty.ResType.ADS.getValue() + "." + extention);
            isFreeAsset = premiumUser ? true : false;
        }
        for (int i = 1; i <= freeCounter; i++) {
            allLinks.add(i + "." + extention);
        }
        //Collections.sort(allLinks);

    }

    public boolean isFreeAsset() {
        return isFreeAsset;
    }

    public String getLink(int pos) {
        //return "file:///android_asset/stickers/1.webp";
        return rootUrl + "/" + folderName + "/" + catgoryName + "/" + allLinks.get(pos);
    }

    public ArcResProperty.ResType getPricingType(int pos) {
        if (!premiumUser) {
            if (allLinks.get(pos).contains(ArcResProperty.ResType.PAID.getValue())) {
                return ArcResProperty.ResType.PAID;
            } else if (allLinks.get(pos).contains(ArcResProperty.ResType.ADS.getValue())) {
                return ArcResProperty.ResType.ADS;
            }
        }
        return ArcResProperty.ResType.FREE;
    }

    public ResMOD IsValidUrl(int pos) {
        try {
            new URL(allLinks.get(pos));
            if (URLUtil.isValidUrl(allLinks.get(pos)) && Patterns.WEB_URL.matcher(allLinks.get(pos)).matches()) {
                return ResMOD.URL;
            }
        } catch (MalformedURLException ignored) {
        }
        return ResMOD.ASSET;
    }

    enum ResMOD {
        ASSET,
        URL
    }
}
