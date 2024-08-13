package com.baidu.mapapi.search.bean.result.building;

import com.baidu.mapapi.search.bean.option.LatLngBean;
import com.baidu.mapapi.search.core.BuildingInfo;

public class BuildingInfoBean {

    /**
     * 高度
     */
    public double height;

    /**
     * 加密后的面
     */
    public String paths;

    /**
     * 加密后的中心点
     */
    public LatLngBean center;

    /**
     * 准确度
     */
    public int accuracy;

    public BuildingInfoBean (BuildingInfo buildingInfo) {
        if (null == buildingInfo) {
            return;
        }

        this.height = buildingInfo.getHeight();
        this.paths = buildingInfo.getGeom();
        String center = buildingInfo.getCenter();
        if (!center.isEmpty()) {
            String[] split = center.split(",");
            if (split.length > 0) {
                String log = split[0];
                String lat = split[1];
                try {
                    double longitude = Double.parseDouble(log);
                    double latitude = Double.parseDouble(lat);
                    this.center = new LatLngBean(latitude, longitude);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
        }
        this.accuracy = buildingInfo.getAccuracy();
    }
}
