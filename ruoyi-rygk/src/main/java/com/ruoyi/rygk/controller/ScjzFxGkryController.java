package com.ruoyi.rygk.controller;

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
import com.ruoyi.rygk.domain.ScjzFxGkry;
import com.ruoyi.rygk.service.IScjzFxGkryService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 人员Controller
 * 
 * @author ruoyi
 * @date 2023-05-01
 */
@RestController
@RequestMapping("/gkry/ry")
public class ScjzFxGkryController extends BaseController
{
    @Autowired
    private IScjzFxGkryService scjzFxGkryService;

    /**
     * 查询人员列表
     */
    @PreAuthorize("@ss.hasPermi('gkry:ry:list')")
    @GetMapping("/list")
    public TableDataInfo list(ScjzFxGkry scjzFxGkry)
    {
        startPage();
        List<ScjzFxGkry> list = scjzFxGkryService.selectScjzFxGkryList(scjzFxGkry);
        return getDataTable(list);
    }

    /**
     * 导出人员列表
     */
    @PreAuthorize("@ss.hasPermi('gkry:ry:export')")
    @Log(title = "人员", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ScjzFxGkry scjzFxGkry)
    {
        List<ScjzFxGkry> list = scjzFxGkryService.selectScjzFxGkryList(scjzFxGkry);
        ExcelUtil<ScjzFxGkry> util = new ExcelUtil<ScjzFxGkry>(ScjzFxGkry.class);
        util.exportExcel(response, list, "人员数据");
    }

    /**
     * 获取人员详细信息
     */
    @PreAuthorize("@ss.hasPermi('gkry:ry:query')")
    @GetMapping(value = "/{ID}")
    public AjaxResult getInfo(@PathVariable("ID") String ID)
    {
        return success(scjzFxGkryService.selectScjzFxGkryByID(ID));
    }

    /**
     * 新增人员
     */
    @PreAuthorize("@ss.hasPermi('gkry:ry:add')")
    @Log(title = "人员", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ScjzFxGkry scjzFxGkry)
    {
        return toAjax(scjzFxGkryService.insertScjzFxGkry(scjzFxGkry));
    }

    /**
     * 修改人员
     */
    @PreAuthorize("@ss.hasPermi('gkry:ry:edit')")
    @Log(title = "人员", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ScjzFxGkry scjzFxGkry)
    {
        return toAjax(scjzFxGkryService.updateScjzFxGkry(scjzFxGkry));
    }

    /**
     * 删除人员
     */
    @PreAuthorize("@ss.hasPermi('gkry:ry:remove')")
    @Log(title = "人员", businessType = BusinessType.DELETE)
	@DeleteMapping("/{IDs}")
    public AjaxResult remove(@PathVariable String[] IDs)
    {
        return toAjax(scjzFxGkryService.deleteScjzFxGkryByIDs(IDs));
    }
}
