package com.practice.dao;

import com.practice.entity.Area;

import java.util.List;

/**
 * Created by administer on 12/5/19.
 */
public interface AreaDao {
    List<Area> queryArea();
    Area queryAreaById(int areaId);
    int insertArea(Area area);
    int updateArea(Area area);
    int deleteArea(int areaId);
}
