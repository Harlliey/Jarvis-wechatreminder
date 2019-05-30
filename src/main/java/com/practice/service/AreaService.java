package com.practice.service;

import com.practice.entity.Area;

import java.util.List;

/**
 * Created by administer on 13/5/19.
 */
public interface AreaService {

    List<Area> getAreaList();

    Area getAreaById(int areaId);

    boolean addArea(Area area);

    boolean modifyArea(Area area);

    boolean deleteArea(int areaId);
}
