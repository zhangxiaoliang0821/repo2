package com.ruoyi.rygk.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.rygk.mapper.ScjzFxGkryMapper;
import com.ruoyi.rygk.domain.ScjzFxGkry;
import com.ruoyi.rygk.service.IScjzFxGkryService;

/**
 * 人员Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-05-01
 */
@Service
public class ScjzFxGkryServiceImpl implements IScjzFxGkryService 
{
    @Autowired
    private ScjzFxGkryMapper scjzFxGkryMapper;

    /**
     * 查询人员
     * 
     * @param ID 人员主键
     * @return 人员
     */
    @Override
    public ScjzFxGkry selectScjzFxGkryByID(String ID)
    {
        return scjzFxGkryMapper.selectScjzFxGkryByID(ID);
    }

    /**
     * 查询人员列表
     * 
     * @param scjzFxGkry 人员
     * @return 人员
     */
    @Override
    public List<ScjzFxGkry> selectScjzFxGkryList(ScjzFxGkry scjzFxGkry)
    {
        return scjzFxGkryMapper.selectScjzFxGkryList(scjzFxGkry);
    }

    /**
     * 新增人员
     * 
     * @param scjzFxGkry 人员
     * @return 结果
     */
    @Override
    public int insertScjzFxGkry(ScjzFxGkry scjzFxGkry)
    {
        return scjzFxGkryMapper.insertScjzFxGkry(scjzFxGkry);
    }

    /**
     * 修改人员
     * 
     * @param scjzFxGkry 人员
     * @return 结果
     */
    @Override
    public int updateScjzFxGkry(ScjzFxGkry scjzFxGkry)
    {
        return scjzFxGkryMapper.updateScjzFxGkry(scjzFxGkry);
    }

    /**
     * 批量删除人员
     * 
     * @param IDs 需要删除的人员主键
     * @return 结果
     */
    @Override
    public int deleteScjzFxGkryByIDs(String[] IDs)
    {
        return scjzFxGkryMapper.deleteScjzFxGkryByIDs(IDs);
    }

    /**
     * 删除人员信息
     * 
     * @param ID 人员主键
     * @return 结果
     */
    @Override
    public int deleteScjzFxGkryByID(String ID)
    {
        return scjzFxGkryMapper.deleteScjzFxGkryByID(ID);
    }
}
