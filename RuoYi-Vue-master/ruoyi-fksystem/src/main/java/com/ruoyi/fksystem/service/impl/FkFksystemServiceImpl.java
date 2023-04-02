package com.ruoyi.fksystem.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.fksystem.mapper.FkFksystemMapper;
import com.ruoyi.fksystem.domain.FkFksystem;
import com.ruoyi.fksystem.service.IFkFksystemService;

/**
 * 访客信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-03-26
 */
@Service
public class FkFksystemServiceImpl implements IFkFksystemService 
{
    @Autowired
    private FkFksystemMapper fkFksystemMapper;

    /**
     * 查询访客信息
     * 
     * @param fksystemId 访客信息主键
     * @return 访客信息
     */
    @Override
    public FkFksystem selectFkFksystemByFksystemId(Long fksystemId)
    {
        return fkFksystemMapper.selectFkFksystemByFksystemId(fksystemId);
    }

    /**
     * 查询访客信息列表
     * 
     * @param fkFksystem 访客信息
     * @return 访客信息
     */
    @Override
    public List<FkFksystem> selectFkFksystemList(FkFksystem fkFksystem)
    {
        return fkFksystemMapper.selectFkFksystemList(fkFksystem);
    }

    /**
     * 新增访客信息
     * 
     * @param fkFksystem 访客信息
     * @return 结果
     */
    @Override
    public int insertFkFksystem(FkFksystem fkFksystem)
    {
        return fkFksystemMapper.insertFkFksystem(fkFksystem);
    }

    /**
     * 修改访客信息
     * 
     * @param fkFksystem 访客信息
     * @return 结果
     */
    @Override
    public int updateFkFksystem(FkFksystem fkFksystem)
    {
        return fkFksystemMapper.updateFkFksystem(fkFksystem);
    }

    /**
     * 批量删除访客信息
     * 
     * @param fksystemIds 需要删除的访客信息主键
     * @return 结果
     */
    @Override
    public int deleteFkFksystemByFksystemIds(Long[] fksystemIds)
    {
        return fkFksystemMapper.deleteFkFksystemByFksystemIds(fksystemIds);
    }

    /**
     * 删除访客信息信息
     * 
     * @param fksystemId 访客信息主键
     * @return 结果
     */
    @Override
    public int deleteFkFksystemByFksystemId(Long fksystemId)
    {
        return fkFksystemMapper.deleteFkFksystemByFksystemId(fksystemId);
    }
}
