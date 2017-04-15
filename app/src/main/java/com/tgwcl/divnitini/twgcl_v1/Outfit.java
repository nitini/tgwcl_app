package com.tgwcl.divnitini.twgcl_v1;

import java.io.Serializable;
import java.util.Map;

/**
 * Created by nitini on 3/7/17.
 */

public class Outfit implements Serializable {


    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getPostDate() {
        return postDate;
    }

    public void setPostDate(String postDate) {
        this.postDate = postDate;
    }

    public String getCollageLink() {
        return collageLink;
    }

    public void setCollageLink(String collageLink) {
        this.collageLink = collageLink;
    }

    public String getPageLink() {
        return pageLink;
    }

    public void setPageLink(String pageLink) {
        this.pageLink = pageLink;
    }

    public String getDos() {
        return dos;
    }

    public void setDos(String dos) {
        this.dos = dos;
    }

    public String getDonts() {
        return donts;
    }

    public void setDonts(String donts) {
        this.donts = donts;
    }

    public String getStylingTips() {
        return stylingTips;
    }

    public void setStylingTips(String stylingTips) {
        this.stylingTips = stylingTips;
    }

    public String getVibe() {
        return vibe;
    }

    public void setVibe(String vibe) {
        this.vibe = vibe;
    }

    public Map<String, Piece> getOutfitPieces() {
        return outfitPieces;
    }

    public void setOutfitPieces(Map<String, Piece> outfitPieces) {
        this.outfitPieces = outfitPieces;
    }

    public Map<String, Store> getStoreDescriptions() {
        return storeDescriptions;
    }

    public void setStoreDescriptions(Map<String, Store> storeDescriptions) {
        this.storeDescriptions = storeDescriptions;
    }

    public String getThumbnailLink() {
        return thumbnailLink;
    }

    public void setThumbnailLink(String thumbnailLink) {
        this.thumbnailLink = thumbnailLink;
    }

    public String getProTip() {
        return proTip;
    }

    public void setProTip(String proTip) {
        this.proTip = proTip;
    }

    private String uid;
    private String postDate;
    private String collageLink;
    private String pageLink;
    private String dos;
    private String donts;
    private String stylingTips;
    private String thumbnailLink;
    private String proTip;
    private String vibe;
    private Map<String, Piece> outfitPieces;
    private Map<String, Store> storeDescriptions;


    public Outfit() {

    }

    public Outfit(String outfitImageUrl,
                  String outfitPageUrl,
                  String vibe,
                  String postDate,
                  String dos,
                  String donts,
                  String stylingTips,
                  String thumbnailLink,
                  String proTip,
                  String uid,
                  Map<String, Piece> outfitPieces,
                  Map<String, Store> storeDescriptions) {

        this.collageLink = outfitImageUrl;
        this.pageLink = outfitPageUrl;
        this.vibe = vibe;
        this.postDate = postDate;
        this.dos = dos;
        this.donts = donts;
        this.stylingTips = stylingTips;
        this.thumbnailLink = thumbnailLink;
        this.proTip = proTip;
        this.uid = uid;
        this.outfitPieces = outfitPieces;
        this.storeDescriptions = storeDescriptions;

    }


    public static class Piece implements Serializable {

        private String imageLink;

        public String getImageLink() {
            return imageLink;
        }

        public void setImageLink(String imageLink) {
            this.imageLink = imageLink;
        }

        public String getPieceTitle() {
            return pieceTitle;
        }

        public void setPieceTitle(String pieceTitle) {
            this.pieceTitle = pieceTitle;
        }

        public float getPrice() {
            return price;
        }

        public void setPrice(float price) {
            this.price = price;
        }

        public String getStoreLink() {
            return storeLink;
        }

        public void setStoreLink(String storeLink) {
            this.storeLink = storeLink;
        }

        private String pieceTitle;
        private float price;
        private String storeLink;


        public Piece() {

        }

    }


    public static class Store implements Serializable {

        public String getStoreDetail() {
            return storeDetail;
        }

        public void setStoreDetail(String storeDetail) {
            this.storeDetail = storeDetail;
        }

        public String getStoreName() {
            return storeName;
        }

        public void setStoreName(String storeName) {
            this.storeName = storeName;
        }

        private String storeDetail;
        private String storeName;

        public Store() {

        }

    }

}
