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
 * 寻宠
 *
 * @author 
 * @email
 */
@TableName("chongwu")
public class ChongwuEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ChongwuEntity() {

	}

	public ChongwuEntity(T t) {
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
     * 寻宠标题
     */
    @ColumnInfo(comment="寻宠标题",type="varchar(200)")
    @TableField(value = "chongwu_name")

    private String chongwuName;


    /**
     * 寻宠照片
     */
    @ColumnInfo(comment="寻宠照片",type="varchar(200)")
    @TableField(value = "chongwu_photo")

    private String chongwuPhoto;


    /**
     * 位置
     */
    @ColumnInfo(comment="位置",type="varchar(200)")
    @TableField(value = "chongwu_address")

    private String chongwuAddress;


    /**
     * 赞
     */
    @ColumnInfo(comment="赞",type="int(11)")
    @TableField(value = "zan_number")

    private Integer zanNumber;


    /**
     * 踩
     */
    @ColumnInfo(comment="踩",type="int(11)")
    @TableField(value = "cai_number")

    private Integer caiNumber;


    /**
     * 寻宠类型
     */
    @ColumnInfo(comment="寻宠类型",type="int(11)")
    @TableField(value = "chongwu_types")

    private Integer chongwuTypes;


    /**
     * 寻宠热度
     */
    @ColumnInfo(comment="寻宠热度",type="int(11)")
    @TableField(value = "chongwu_clicknum")

    private Integer chongwuClicknum;


    /**
     * 寻宠介绍
     */
    @ColumnInfo(comment="寻宠介绍",type="longtext")
    @TableField(value = "chongwu_content")

    private String chongwuContent;


    /**
     * 逻辑删除
     */
    @ColumnInfo(comment="逻辑删除",type="int(11)")
    @TableField(value = "chongwu_delete")

    private Integer chongwuDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="录入时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间
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
	 * 获取：寻宠标题
	 */
    public String getChongwuName() {
        return chongwuName;
    }
    /**
	 * 设置：寻宠标题
	 */

    public void setChongwuName(String chongwuName) {
        this.chongwuName = chongwuName;
    }
    /**
	 * 获取：寻宠照片
	 */
    public String getChongwuPhoto() {
        return chongwuPhoto;
    }
    /**
	 * 设置：寻宠照片
	 */

    public void setChongwuPhoto(String chongwuPhoto) {
        this.chongwuPhoto = chongwuPhoto;
    }
    /**
	 * 获取：位置
	 */
    public String getChongwuAddress() {
        return chongwuAddress;
    }
    /**
	 * 设置：位置
	 */

    public void setChongwuAddress(String chongwuAddress) {
        this.chongwuAddress = chongwuAddress;
    }
    /**
	 * 获取：赞
	 */
    public Integer getZanNumber() {
        return zanNumber;
    }
    /**
	 * 设置：赞
	 */

    public void setZanNumber(Integer zanNumber) {
        this.zanNumber = zanNumber;
    }
    /**
	 * 获取：踩
	 */
    public Integer getCaiNumber() {
        return caiNumber;
    }
    /**
	 * 设置：踩
	 */

    public void setCaiNumber(Integer caiNumber) {
        this.caiNumber = caiNumber;
    }
    /**
	 * 获取：寻宠类型
	 */
    public Integer getChongwuTypes() {
        return chongwuTypes;
    }
    /**
	 * 设置：寻宠类型
	 */

    public void setChongwuTypes(Integer chongwuTypes) {
        this.chongwuTypes = chongwuTypes;
    }
    /**
	 * 获取：寻宠热度
	 */
    public Integer getChongwuClicknum() {
        return chongwuClicknum;
    }
    /**
	 * 设置：寻宠热度
	 */

    public void setChongwuClicknum(Integer chongwuClicknum) {
        this.chongwuClicknum = chongwuClicknum;
    }
    /**
	 * 获取：寻宠介绍
	 */
    public String getChongwuContent() {
        return chongwuContent;
    }
    /**
	 * 设置：寻宠介绍
	 */

    public void setChongwuContent(String chongwuContent) {
        this.chongwuContent = chongwuContent;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getChongwuDelete() {
        return chongwuDelete;
    }
    /**
	 * 设置：逻辑删除
	 */

    public void setChongwuDelete(Integer chongwuDelete) {
        this.chongwuDelete = chongwuDelete;
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
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Chongwu{" +
            ", id=" + id +
            ", chongwuName=" + chongwuName +
            ", chongwuPhoto=" + chongwuPhoto +
            ", chongwuAddress=" + chongwuAddress +
            ", zanNumber=" + zanNumber +
            ", caiNumber=" + caiNumber +
            ", chongwuTypes=" + chongwuTypes +
            ", chongwuClicknum=" + chongwuClicknum +
            ", chongwuContent=" + chongwuContent +
            ", chongwuDelete=" + chongwuDelete +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
