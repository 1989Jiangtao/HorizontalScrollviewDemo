package com.cjt.horizontalscrollviewdemo;

/**
 * Created by CaoJiangtao on 2017/2/8.
 *  测试的实体类，图片的资源ID和图片的描述
 */
public class ItemBean {

    private String id ; // 形如2-3 以坐标的形式来表示
    private int pictureResId ;
    private String pictureName ;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getPictureResId() {
        return pictureResId;
    }

    public void setPictureResId(int pictureResId) {
        this.pictureResId = pictureResId;
    }

    public String getPictureName() {
        return pictureName;
    }

    public void setPictureName(String pictureName) {
        this.pictureName = pictureName;
    }

    @Override
    public String toString() {
        return "ItemBean{" +
                "id='" + id + '\'' +
                ", pictureResId=" + pictureResId +
                ", pictureName='" + pictureName + '\'' +
                '}';
    }
}
