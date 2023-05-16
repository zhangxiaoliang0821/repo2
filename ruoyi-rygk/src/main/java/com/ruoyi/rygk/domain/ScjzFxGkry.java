package com.ruoyi.rygk.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 人员对象 scjz_fx_gkry
 * 
 * @author ruoyi
 * @date 2023-05-01
 */
public class ScjzFxGkry extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private String ID;

    /** 风险单位ID */
    @Excel(name = "风险单位ID")
    private String FXDWID;

    /** 单位编码 */
    @Excel(name = "单位编码")
    private String DWBM;

    /** 单位名称 */
    @Excel(name = "单位名称")
    private String DWMC;

    /** 所属单位全编码 */
    @Excel(name = "所属单位全编码")
    private String DWQBM;

    /** 管控全名称 */
    @Excel(name = "管控全名称")
    private String DWQMC;

    /** 管控岗位 */
    @Excel(name = "管控岗位")
    private String GKGW;

    /** 管控人员编码 */
    @Excel(name = "管控人员编码")
    private String GKRYBM;

    /** 管控人员姓名 */
    @Excel(name = "管控人员姓名")
    private String GKRYXM;

    /** 操作人单位编码 */
    @Excel(name = "操作人单位编码")
    private String CZRDWBM;

    /** 操作人单位名称 */
    @Excel(name = "操作人单位名称")
    private String CZRDWMC;

    /** 操作人编码 */
    @Excel(name = "操作人编码")
    private String CZRBM;

    /** 操作人姓名 */
    @Excel(name = "操作人姓名")
    private String CZRXM;

    /** 操作时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "操作时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date CZSJ;

    /** 管控次数 */
    @Excel(name = "管控次数")
    private String GKCS;

    /** 风险单位编码 */
    @Excel(name = "风险单位编码")
    private String FXDWBM;

    public void setID(String ID) 
    {
        this.ID = ID;
    }

    public String getID() 
    {
        return ID;
    }
    public void setFXDWID(String FXDWID) 
    {
        this.FXDWID = FXDWID;
    }

    public String getFXDWID() 
    {
        return FXDWID;
    }
    public void setDWBM(String DWBM) 
    {
        this.DWBM = DWBM;
    }

    public String getDWBM() 
    {
        return DWBM;
    }
    public void setDWMC(String DWMC) 
    {
        this.DWMC = DWMC;
    }

    public String getDWMC() 
    {
        return DWMC;
    }
    public void setDWQBM(String DWQBM) 
    {
        this.DWQBM = DWQBM;
    }

    public String getDWQBM() 
    {
        return DWQBM;
    }
    public void setDWQMC(String DWQMC) 
    {
        this.DWQMC = DWQMC;
    }

    public String getDWQMC() 
    {
        return DWQMC;
    }
    public void setGKGW(String GKGW) 
    {
        this.GKGW = GKGW;
    }

    public String getGKGW() 
    {
        return GKGW;
    }
    public void setGKRYBM(String GKRYBM) 
    {
        this.GKRYBM = GKRYBM;
    }

    public String getGKRYBM() 
    {
        return GKRYBM;
    }
    public void setGKRYXM(String GKRYXM) 
    {
        this.GKRYXM = GKRYXM;
    }

    public String getGKRYXM() 
    {
        return GKRYXM;
    }
    public void setCZRDWBM(String CZRDWBM) 
    {
        this.CZRDWBM = CZRDWBM;
    }

    public String getCZRDWBM() 
    {
        return CZRDWBM;
    }
    public void setCZRDWMC(String CZRDWMC) 
    {
        this.CZRDWMC = CZRDWMC;
    }

    public String getCZRDWMC() 
    {
        return CZRDWMC;
    }
    public void setCZRBM(String CZRBM) 
    {
        this.CZRBM = CZRBM;
    }

    public String getCZRBM() 
    {
        return CZRBM;
    }
    public void setCZRXM(String CZRXM) 
    {
        this.CZRXM = CZRXM;
    }

    public String getCZRXM() 
    {
        return CZRXM;
    }
    public void setCZSJ(Date CZSJ) 
    {
        this.CZSJ = CZSJ;
    }

    public Date getCZSJ() 
    {
        return CZSJ;
    }
    public void setGKCS(String GKCS) 
    {
        this.GKCS = GKCS;
    }

    public String getGKCS() 
    {
        return GKCS;
    }
    public void setFXDWBM(String FXDWBM) 
    {
        this.FXDWBM = FXDWBM;
    }

    public String getFXDWBM() 
    {
        return FXDWBM;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("ID", getID())
            .append("FXDWID", getFXDWID())
            .append("DWBM", getDWBM())
            .append("DWMC", getDWMC())
            .append("DWQBM", getDWQBM())
            .append("DWQMC", getDWQMC())
            .append("GKGW", getGKGW())
            .append("GKRYBM", getGKRYBM())
            .append("GKRYXM", getGKRYXM())
            .append("CZRDWBM", getCZRDWBM())
            .append("CZRDWMC", getCZRDWMC())
            .append("CZRBM", getCZRBM())
            .append("CZRXM", getCZRXM())
            .append("CZSJ", getCZSJ())
            .append("GKCS", getGKCS())
            .append("FXDWBM", getFXDWBM())
            .toString();
    }
}
