package com.entity.vo;

import com.entity.DongwuEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 动物求助
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("dongwu")
public class DongwuVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 求助名称
     */

    @TableField(value = "dongwu_name")
    private String dongwuName;


    /**
     * 求助照片
     */

    @TableField(value = "dongwu_photo")
    private String dongwuPhoto;


    /**
     * 求助类型
     */

    @TableField(value = "dongwu_types")
    private Integer dongwuTypes;


    /**
     * 用户
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 求助热度
     */

    @TableField(value = "dongwu_clicknum")
    private Integer dongwuClicknum;


    /**
     * 求助详情
     */

    @TableField(value = "dongwu_content")
    private String dongwuContent;


    /**
     * 求助状态
     */

    @TableField(value = "qiuzhuzhuangtai_types")
    private Integer qiuzhuzhuangtaiTypes;


    /**
     * 逻辑删除
     */

    @TableField(value = "dongwu_delete")
    private Integer dongwuDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间  show1 show2 photoShow homeMain
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
	 * 设置：求助名称
	 */
    public String getDongwuName() {
        return dongwuName;
    }


    /**
	 * 获取：求助名称
	 */

    public void setDongwuName(String dongwuName) {
        this.dongwuName = dongwuName;
    }
    /**
	 * 设置：求助照片
	 */
    public String getDongwuPhoto() {
        return dongwuPhoto;
    }


    /**
	 * 获取：求助照片
	 */

    public void setDongwuPhoto(String dongwuPhoto) {
        this.dongwuPhoto = dongwuPhoto;
    }
    /**
	 * 设置：求助类型
	 */
    public Integer getDongwuTypes() {
        return dongwuTypes;
    }


    /**
	 * 获取：求助类型
	 */

    public void setDongwuTypes(Integer dongwuTypes) {
        this.dongwuTypes = dongwuTypes;
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
	 * 设置：求助热度
	 */
    public Integer getDongwuClicknum() {
        return dongwuClicknum;
    }


    /**
	 * 获取：求助热度
	 */

    public void setDongwuClicknum(Integer dongwuClicknum) {
        this.dongwuClicknum = dongwuClicknum;
    }
    /**
	 * 设置：求助详情
	 */
    public String getDongwuContent() {
        return dongwuContent;
    }


    /**
	 * 获取：求助详情
	 */

    public void setDongwuContent(String dongwuContent) {
        this.dongwuContent = dongwuContent;
    }
    /**
	 * 设置：求助状态
	 */
    public Integer getQiuzhuzhuangtaiTypes() {
        return qiuzhuzhuangtaiTypes;
    }


    /**
	 * 获取：求助状态
	 */

    public void setQiuzhuzhuangtaiTypes(Integer qiuzhuzhuangtaiTypes) {
        this.qiuzhuzhuangtaiTypes = qiuzhuzhuangtaiTypes;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getDongwuDelete() {
        return dongwuDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setDongwuDelete(Integer dongwuDelete) {
        this.dongwuDelete = dongwuDelete;
    }
    /**
	 * 设置：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间  show1 show2 photoShow homeMain
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间  show1 show2 photoShow homeMain
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
