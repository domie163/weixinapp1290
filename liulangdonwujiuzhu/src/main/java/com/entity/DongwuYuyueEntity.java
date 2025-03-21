package com.entity;

import com.annotation.ColumnInfo;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;
import java.io.Serializable;
import java.util.*;
import org.apache.tools.ant.util.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.utils.DateUtil;


/**
 * 求助报名
 *
 * @author 
 * @email
 */
@TableName("dongwu_yuyue")
public class DongwuYuyueEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public DongwuYuyueEntity() {

	}

	public DongwuYuyueEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @ColumnInfo(comment="主键",type="int(11)")
    @TableField(value = "id")

    private Integer id;


    /**
     * 求助
     */
    @ColumnInfo(comment="求助",type="int(11)")
    @TableField(value = "dongwu_id")

    private Integer dongwuId;


    /**
     * 用户
     */
    @ColumnInfo(comment="用户",type="int(11)")
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 领养缘由
     */
    @ColumnInfo(comment="领养缘由",type="longtext")
    @TableField(value = "dongwu_yuyue_text")

    private String dongwuYuyueText;


    /**
     * 审核状态
     */
    @ColumnInfo(comment="审核状态",type="int(11)")
    @TableField(value = "dongwu_yuyue_yesno_types")

    private Integer dongwuYuyueYesnoTypes;


    /**
     * 审核回复
     */
    @ColumnInfo(comment="审核回复",type="longtext")
    @TableField(value = "dongwu_yuyue_yesno_text")

    private String dongwuYuyueYesnoText;


    /**
     * 申请时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="申请时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间  listShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="创建时间",type="timestamp")
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }
    /**
	 * 设置：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：求助
	 */
    public Integer getDongwuId() {
        return dongwuId;
    }
    /**
	 * 设置：求助
	 */

    public void setDongwuId(Integer dongwuId) {
        this.dongwuId = dongwuId;
    }
    /**
	 * 获取：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }
    /**
	 * 设置：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：领养缘由
	 */
    public String getDongwuYuyueText() {
        return dongwuYuyueText;
    }
    /**
	 * 设置：领养缘由
	 */

    public void setDongwuYuyueText(String dongwuYuyueText) {
        this.dongwuYuyueText = dongwuYuyueText;
    }
    /**
	 * 获取：审核状态
	 */
    public Integer getDongwuYuyueYesnoTypes() {
        return dongwuYuyueYesnoTypes;
    }
    /**
	 * 设置：审核状态
	 */

    public void setDongwuYuyueYesnoTypes(Integer dongwuYuyueYesnoTypes) {
        this.dongwuYuyueYesnoTypes = dongwuYuyueYesnoTypes;
    }
    /**
	 * 获取：审核回复
	 */
    public String getDongwuYuyueYesnoText() {
        return dongwuYuyueYesnoText;
    }
    /**
	 * 设置：审核回复
	 */

    public void setDongwuYuyueYesnoText(String dongwuYuyueYesnoText) {
        this.dongwuYuyueYesnoText = dongwuYuyueYesnoText;
    }
    /**
	 * 获取：申请时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：申请时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间  listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间  listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "DongwuYuyue{" +
            ", id=" + id +
            ", dongwuId=" + dongwuId +
            ", yonghuId=" + yonghuId +
            ", dongwuYuyueText=" + dongwuYuyueText +
            ", dongwuYuyueYesnoTypes=" + dongwuYuyueYesnoTypes +
            ", dongwuYuyueYesnoText=" + dongwuYuyueYesnoText +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
