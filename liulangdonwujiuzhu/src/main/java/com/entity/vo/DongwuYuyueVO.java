package com.entity.vo;

import com.entity.DongwuYuyueEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 求助报名
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("dongwu_yuyue")
public class DongwuYuyueVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 求助
     */

    @TableField(value = "dongwu_id")
    private Integer dongwuId;


    /**
     * 用户
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 领养缘由
     */

    @TableField(value = "dongwu_yuyue_text")
    private String dongwuYuyueText;


    /**
     * 审核状态
     */

    @TableField(value = "dongwu_yuyue_yesno_types")
    private Integer dongwuYuyueYesnoTypes;


    /**
     * 审核回复
     */

    @TableField(value = "dongwu_yuyue_yesno_text")
    private String dongwuYuyueYesnoText;


    /**
     * 申请时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间 show3 listShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：求助
	 */
    public Integer getDongwuId() {
        return dongwuId;
    }


    /**
	 * 获取：求助
	 */

    public void setDongwuId(Integer dongwuId) {
        this.dongwuId = dongwuId;
    }
    /**
	 * 设置：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：领养缘由
	 */
    public String getDongwuYuyueText() {
        return dongwuYuyueText;
    }


    /**
	 * 获取：领养缘由
	 */

    public void setDongwuYuyueText(String dongwuYuyueText) {
        this.dongwuYuyueText = dongwuYuyueText;
    }
    /**
	 * 设置：审核状态
	 */
    public Integer getDongwuYuyueYesnoTypes() {
        return dongwuYuyueYesnoTypes;
    }


    /**
	 * 获取：审核状态
	 */

    public void setDongwuYuyueYesnoTypes(Integer dongwuYuyueYesnoTypes) {
        this.dongwuYuyueYesnoTypes = dongwuYuyueYesnoTypes;
    }
    /**
	 * 设置：审核回复
	 */
    public String getDongwuYuyueYesnoText() {
        return dongwuYuyueYesnoText;
    }


    /**
	 * 获取：审核回复
	 */

    public void setDongwuYuyueYesnoText(String dongwuYuyueYesnoText) {
        this.dongwuYuyueYesnoText = dongwuYuyueYesnoText;
    }
    /**
	 * 设置：申请时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：申请时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间 show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间 show3 listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
