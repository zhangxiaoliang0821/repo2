package com.ruoyi.fksystem.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 访客信息对象 fk_fksystem
 * 
 * @author ruoyi
 * @date 2023-03-26
 */
public class FkFksystem extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long fksystemId;

    /** 访客名称 */
    @Excel(name = "访客名称")
    private String fksystemName;

    /** 年龄 */
    @Excel(name = "年龄")
    private Integer fksystemAge;

    /** 住址 */
    @Excel(name = "住址")
    private String fksystemAddress;

    /** 性别（0男 1女） */
    @Excel(name = "性别", readConverterExp = "0=男,1=女")
    private String fksystemSex;

    /** 状态（0阴性 1阳性） */
    @Excel(name = "状态", readConverterExp = "0=阴性,1=阳性")
    private String fksystemStatus;

    /** 日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date fksystemBirthday;

    public void setFksystemId(Long fksystemId) 
    {
        this.fksystemId = fksystemId;
    }

    public Long getFksystemId() 
    {
        return fksystemId;
    }
    public void setFksystemName(String fksystemName) 
    {
        this.fksystemName = fksystemName;
    }

    public String getFksystemName() 
    {
        return fksystemName;
    }
    public void setFksystemAge(Integer fksystemAge) 
    {
        this.fksystemAge = fksystemAge;
    }

    public Integer getFksystemAge() 
    {
        return fksystemAge;
    }
    public void setFksystemAddress(String fksystemAddress) 
    {
        this.fksystemAddress = fksystemAddress;
    }

    public String getFksystemAddress() 
    {
        return fksystemAddress;
    }
    public void setFksystemSex(String fksystemSex) 
    {
        this.fksystemSex = fksystemSex;
    }

    public String getFksystemSex() 
    {
        return fksystemSex;
    }
    public void setFksystemStatus(String fksystemStatus) 
    {
        this.fksystemStatus = fksystemStatus;
    }

    public String getFksystemStatus() 
    {
        return fksystemStatus;
    }
    public void setFksystemBirthday(Date fksystemBirthday) 
    {
        this.fksystemBirthday = fksystemBirthday;
    }

    public Date getFksystemBirthday() 
    {
        return fksystemBirthday;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("fksystemId", getFksystemId())
            .append("fksystemName", getFksystemName())
            .append("fksystemAge", getFksystemAge())
            .append("fksystemAddress", getFksystemAddress())
            .append("fksystemSex", getFksystemSex())
            .append("fksystemStatus", getFksystemStatus())
            .append("fksystemBirthday", getFksystemBirthday())
            .toString();
    }
}
