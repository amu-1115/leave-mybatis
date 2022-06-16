package com.gxuwz.leave.mapper;

import com.gxuwz.leave.entity.Department;

import java.util.List;

/**
 * @author amu_1115@126.com
 * @version 1.0
 */
public interface DepartmentMapper {

    public void insert(Department entity);
    public void update(Department entity);
    public void delete(String id);
    public List<Department> query(Department entity);

}
