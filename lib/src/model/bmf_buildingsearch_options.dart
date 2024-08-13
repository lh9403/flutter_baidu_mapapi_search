import 'package:flutter_baidu_mapapi_base/flutter_baidu_mapapi_base.dart'
    show BMFModel, BMFCoordinate;
import 'package:flutter_baidu_mapapi_search/src/model/bmf_search_base.dart';

///  地图建筑物参数信息类
class BMFBuildingSearchOption extends BMFSearch implements BMFModel {
  /// 地图建筑物经纬度 （必选）
  BMFCoordinate? location;

  /// 有参构造
  BMFBuildingSearchOption({required this.location});

  /// map => BMFBuildingSearchOption
  BMFBuildingSearchOption.fromMap(Map map) : super.fromMap(map) {
    location =
        map['location'] == null ? null : BMFCoordinate.fromMap(map['location']);
  }

  @override
  fromMap(Map map) {
    return BMFBuildingSearchOption.fromMap(map);
  }

  @override
  Map<String, Object?> toMap() {
    return Map.from(super.toMap())
      ..addAll({'location': this.location?.toMap()});
  }
}
