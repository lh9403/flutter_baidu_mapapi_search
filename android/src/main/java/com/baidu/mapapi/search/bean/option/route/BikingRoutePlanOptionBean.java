package com.baidu.mapapi.search.bean.option.route;

import com.baidu.mapapi.search.route.BikingRoutePlanOption;
import com.baidu.mapapi.search.route.PlanNode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 骑行检索属性
 */
public class BikingRoutePlanOptionBean extends BaseRoutePlanOptionBean{
    /** 骑行类型 */
    int ridingType;
    List<BMFRoutePlanNode> wayPointsArray;

    public BikingRoutePlanOption toOption(){
        BikingRoutePlanOption bikingRoutePlanOption = new BikingRoutePlanOption();
        bikingRoutePlanOption.mFrom = null != from ? from.toPlanNode() : null;
        bikingRoutePlanOption.mTo = null != to ? to.toPlanNode() : null;
        bikingRoutePlanOption.mRidingType = ridingType;
        List<PlanNode> planNodes = wayPointsConvert();
        if (null != planNodes) {
            bikingRoutePlanOption.passBy(planNodes);
        }
        return bikingRoutePlanOption;
    }

    private List<PlanNode> wayPointsConvert(){
        if (null == wayPointsArray){
            return null;
        }

        List<PlanNode> wayPoints = new ArrayList<>();
        Iterator itr = wayPointsArray.listIterator();

        BMFRoutePlanNode bmfRoutePlanNode;
        while (itr.hasNext()){
            bmfRoutePlanNode = (BMFRoutePlanNode) itr.next();
            PlanNode planNode = bmfRoutePlanNode.toPlanNode();
            wayPoints.add(planNode);
        }

        return wayPoints;
    }
}
