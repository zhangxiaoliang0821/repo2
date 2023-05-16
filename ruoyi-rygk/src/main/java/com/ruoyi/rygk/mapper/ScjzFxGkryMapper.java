package com.ruoyi.rygk.mapper;

import java.util.List;
import com.ruoyi.rygk.domain.ScjzFxGkry;

/**
 * 人员Mapper接口
 * 
 * @author ruoyi
 * @date 2023-05-01
 */
public interface ScjzFxGkryMapper 
{
    /**
     * 查询人员
     * 
     * @param ID 人员主键
     * @return 人员
     */
    public ScjzFxGkry selectScjzFxGkryByID(String ID);

    /**
     * 查询人员列表
     * 
     * @param scjzFxGkry 人员
     * @return 人员集合
     */
    public List<ScjzFxGkry> selectScjzFxGkryList(ScjzFxGkry scjzFxGkry);

    /**
     * 新增人员
     * 
     * @param scjzFxGkry 人员
     * @return 结果
     */
    public int insertScjzFxGkry(ScjzFxGkry scjzFxGkry);

    /**
     * 修改人员
     * 
     * @param scjzFxGkry 人员
     * @return 结果
     */
    public int updateScjzFxGkry(ScjzFxGkry scjzFxGkry);

    /**
     * 删除人员
     * 
     * @param ID 人员主键
     * @return 结果
     */
    public int deleteScjzFxGkryByID(String ID);

    /**
     * 批量删除人员
     * 
     * @param IDs 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteScjzFxGkryByIDs(String[] IDs);
}
