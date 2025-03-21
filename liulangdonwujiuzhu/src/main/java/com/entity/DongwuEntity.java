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
 * 动物求助
 *
 * @author 
 * @email
 */
@TableName("dongwu")
public class DongwuEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public DongwuEntity() {

	}

	public DongwuEntity(T t) {
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
     * 求助名称
     */
    @ColumnInfo(comment="求助名称",type="varchar(200)")
    @TableField(value = "dongwu_name")

    private String dongwuName;


    /**
     * 求助照片
     */
    @ColumnInfo(comment="求助照片",type="varchar(200)")
    @TableField(value = "dongwu_photo")

    private String dongwuPhoto;


    /**
     * 求助类型
     */
    @ColumnInfo(comment="求助类型",type="int(11)")
    @TableField(value = "dongwu_types")

    private Integer dongwuTypes;


    /**
     * 用户
     */
    @ColumnInfo(comment="用户",type="int(11)")
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 求助热度
     */
    @ColumnInfo(comment="求助热度",type="int(11)")
    @TableField(value = "dongwu_clicknum")

    private Integer dongwuClicknum;


    /**
     * 求助详情
     */
    @ColumnInfo(comment="求助详情",type="longtext")
    @TableField(value = "dongwu_content")

    private String dongwuContent;


    /**
     * 求助状态
     */
    @ColumnInfo(comment="求助状态",type="int(11)")
    @TableField(value = "qiuzhuzhuangtai_types")

    private Integer qiuzhuzhuangtaiTypes;


    /**
     * 逻辑删除
     */
    @ColumnInfo(comment="逻辑删除",type="int(11)")
    @TableField(value = "dongwu_delete")

    private Integer dongwuDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="录入时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间     homeMain
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
	 * 获取：求助名称
	 */
    public String getDongwuName() {
        return dongwuName;
    }
    /**
	 * 设置：求助名称
	 */

    public void setDongwuName(String dongwuName) {
        this.dongwuName = dongwuName;
    }
    /**
	 * 获取：求助照片
	 */
    public String getDongwuPhoto() {
        return dongwuPhoto;
    }
    /**
	 * 设置：求助照片
	 */

    public void setDongwuPhoto(String dongwuPhoto) {
        this.dongwuPhoto = dongwuPhoto;
    }
    /**
	 * 获取：求助类型
	 */
    public Integer getDongwuTypes() {
        return dongwuTypes;
    }
    /**
	 * 设置：求助类型
	 */

    public void setDongwuTypes(Integer dongwuTypes) {
        this.dongwuTypes = dongwuTypes;
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
	 * 获取：求助热度
	 */
    public Integer getDongwuClicknum() {
        return dongwuClicknum;
    }
    /**
	 * 设置：求助热度
	 */

    public void setDongwuClicknum(Integer dongwuClicknum) {
        this.dongwuClicknum = dongwuClicknum;
    }
    /**
	 * 获取：求助详情
	 */
    public String getDongwuContent() {
        return dongwuContent;
    }
    /**
	 * 设置：求助详情
	 */

    public void setDongwuContent(String dongwuContent) {
        this.dongwuContent = dongwuContent;
    }
    /**
	 * 获取：求助状态
	 */
    public Integer getQiuzhuzhuangtaiTypes() {
        return qiuzhuzhuangtaiTypes;
    }
    /**
	 * 设置：求助状态
	 */

    public void setQiuzhuzhuangtaiTypes(Integer qiuzhuzhuangtaiTypes) {
        this.qiuzhuzhuangtaiTypes = qiuzhuzhuangtaiTypes;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getDongwuDelete() {
        return dongwuDelete;
    }
    /**
	 * 设置：逻辑删除
	 */

    public void setDongwuDelete(Integer dongwuDelete) {
        this.dongwuDelete = dongwuDelete;
    }
    /**
	 * 获取：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间     homeMain
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间     homeMain
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Dongwu{" +
            ", id=" + id +
            ", dongwuName=" + dongwuName +
            ", dongwuPhoto=" + dongwuPhoto +
            ", dongwuTypes=" + dongwuTypes +
            ", yonghuId=" + yonghuId +
            ", dongwuClicknum=" + dongwuClicknum +
            ", dongwuContent=" + dongwuContent +
            ", qiuzhuzhuangtaiTypes=" + qiuzhuzhuangtaiTypes +
            ", dongwuDelete=" + dongwuDelete +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
