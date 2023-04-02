package com.ruoyi.fksystem.mapper;

import java.util.List;
import com.ruoyi.fksystem.domain.FkFksystem;

/**
 * 访客信息Mapper接口
 * 
 * @author ruoyi
 * @date 2023-03-26
 */
public interface FkFksystemMapper 
{
    /**
     * 查询访客信息
     * 
     * @param fksystemId 访客信息主键
     * @return 访客信息
     */
    public FkFksystem selectFkFksystemByFksystemId(Long fksystemId);

    /**
     * 查询访客信息列表
     * 
     * @param fkFksystem 访客信息
     * @return 访客信息集合
     */
    public List<FkFksystem> selectFkFksystemList(FkFksystem fkFksystem);

    /**
     * 新增访客信息
     * 
     * @param fkFksystem 访客信息
     * @return 结果
     */
    public int insertFkFksystem(FkFksystem fkFksystem);

    /**
     * 修改访客信息
     * 
     * @param fkFksystem 访客信息
     * @return 结果
     */
    public int updateFkFksystem(FkFksystem fkFksystem);

    /**
     * 删除访客信息
     * 
     * @param fksystemId 访客信息主键
     * @return 结果
     */
    public int deleteFkFksystemByFksystemId(Long fksystemId);

    /**
     * 批量删除访客信息
     * 
     * @param fksystemIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteFkFksystemByFksystemIds(Long[] fksystemIds);
}
