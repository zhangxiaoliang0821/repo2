package com.ruoyi.fksystem.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.fksystem.domain.FkFksystem;
import com.ruoyi.fksystem.service.IFkFksystemService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 访客信息Controller
 * 
 * @author ruoyi
 * @date 2023-03-26
 */
@RestController
@RequestMapping("/fksystem/fkinformation")
public class FkFksystemController extends BaseController
{
    @Autowired
    private IFkFksystemService fkFksystemService;

    /**
     * 查询访客信息列表
     */
    @PreAuthorize("@ss.hasPermi('fksystem:fkinformation:list')")
    @GetMapping("/list")
    public TableDataInfo list(FkFksystem fkFksystem)
    {
        startPage();
        List<FkFksystem> list = fkFksystemService.selectFkFksystemList(fkFksystem);
        return getDataTable(list);
    }

    /**
     * 导出访客信息列表
     */
    @PreAuthorize("@ss.hasPermi('fksystem:fkinformation:export')")
    @Log(title = "访客信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, FkFksystem fkFksystem)
    {
        List<FkFksystem> list = fkFksystemService.selectFkFksystemList(fkFksystem);
        ExcelUtil<FkFksystem> util = new ExcelUtil<FkFksystem>(FkFksystem.class);
        util.exportExcel(response, list, "访客信息数据");
    }

    /**
     * 获取访客信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('fksystem:fkinformation:query')")
    @GetMapping(value = "/{fksystemId}")
    public AjaxResult getInfo(@PathVariable("fksystemId") Long fksystemId)
    {
        return success(fkFksystemService.selectFkFksystemByFksystemId(fksystemId));
    }

    /**
     * 新增访客信息
     */
    @PreAuthorize("@ss.hasPermi('fksystem:fkinformation:add')")
    @Log(title = "访客信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody FkFksystem fkFksystem)
    {
        return toAjax(fkFksystemService.insertFkFksystem(fkFksystem));
    }

    /**
     * 修改访客信息
     */
    @PreAuthorize("@ss.hasPermi('fksystem:fkinformation:edit')")
    @Log(title = "访客信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody FkFksystem fkFksystem)
    {
        return toAjax(fkFksystemService.updateFkFksystem(fkFksystem));
    }

    /**
     * 删除访客信息
     */
    @PreAuthorize("@ss.hasPermi('fksystem:fkinformation:remove')")
    @Log(title = "访客信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{fksystemIds}")
    public AjaxResult remove(@PathVariable Long[] fksystemIds)
    {
        return toAjax(fkFksystemService.deleteFkFksystemByFksystemIds(fksystemIds));
    }
}
