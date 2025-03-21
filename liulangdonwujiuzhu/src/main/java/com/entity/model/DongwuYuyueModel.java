package com.entity.model;

import com.entity.DongwuYuyueEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 求助报名
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class DongwuYuyueModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 求助
     */
    private Integer dongwuId;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 领养缘由
     */
    private String dongwuYuyueText;


    /**
     * 审核状态
     */
    private Integer dongwuYuyueYesnoTypes;


    /**
     * 审核回复
     */
    private String dongwuYuyueYesnoText;


    /**
     * 申请时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间 show3 listShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
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
	 * 获取：创建时间 show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show3 listShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
