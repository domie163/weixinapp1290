package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.ChongwuLiuyanEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 寻宠留言
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("chongwu_liuyan")
public class ChongwuLiuyanView extends ChongwuLiuyanEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表

	//级联表 寻宠
		/**
		* 寻宠标题
		*/

		@ColumnInfo(comment="寻宠标题",type="varchar(200)")
		private String chongwuName;
		/**
		* 寻宠照片
		*/

		@ColumnInfo(comment="寻宠照片",type="varchar(200)")
		private String chongwuPhoto;
		/**
		* 位置
		*/

		@ColumnInfo(comment="位置",type="varchar(200)")
		private String chongwuAddress;
		/**
		* 赞
		*/

		@ColumnInfo(comment="赞",type="int(11)")
		private Integer zanNumber;
		/**
		* 踩
		*/

		@ColumnInfo(comment="踩",type="int(11)")
		private Integer caiNumber;
		/**
		* 寻宠类型
		*/
		@ColumnInfo(comment="寻宠类型",type="int(11)")
		private Integer chongwuTypes;
			/**
			* 寻宠类型的值
			*/
			@ColumnInfo(comment="寻宠类型的字典表值",type="varchar(200)")
			private String chongwuValue;
		/**
		* 寻宠热度
		*/

		@ColumnInfo(comment="寻宠热度",type="int(11)")
		private Integer chongwuClicknum;
		/**
		* 寻宠介绍
		*/

		@ColumnInfo(comment="寻宠介绍",type="longtext")
		private String chongwuContent;
		/**
		* 逻辑删除
		*/

		@ColumnInfo(comment="逻辑删除",type="int(11)")
		private Integer chongwuDelete;
	//级联表 用户
		/**
		* 用户名称
		*/

		@ColumnInfo(comment="用户名称",type="varchar(200)")
		private String yonghuName;
		/**
		* 用户手机号
		*/

		@ColumnInfo(comment="用户手机号",type="varchar(200)")
		private String yonghuPhone;
		/**
		* 用户身份证号
		*/

		@ColumnInfo(comment="用户身份证号",type="varchar(200)")
		private String yonghuIdNumber;
		/**
		* 用户头像
		*/

		@ColumnInfo(comment="用户头像",type="varchar(200)")
		private String yonghuPhoto;
		/**
		* 用户邮箱
		*/

		@ColumnInfo(comment="用户邮箱",type="varchar(200)")
		private String yonghuEmail;
		/**
		* 逻辑删除
		*/

		@ColumnInfo(comment="逻辑删除",type="int(11)")
		private Integer yonghuDelete;



	public ChongwuLiuyanView() {

	}

	public ChongwuLiuyanView(ChongwuLiuyanEntity chongwuLiuyanEntity) {
		try {
			BeanUtils.copyProperties(this, chongwuLiuyanEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}





	//级联表的get和set 寻宠

		/**
		* 获取： 寻宠标题
		*/
		public String getChongwuName() {
			return chongwuName;
		}
		/**
		* 设置： 寻宠标题
		*/
		public void setChongwuName(String chongwuName) {
			this.chongwuName = chongwuName;
		}

		/**
		* 获取： 寻宠照片
		*/
		public String getChongwuPhoto() {
			return chongwuPhoto;
		}
		/**
		* 设置： 寻宠照片
		*/
		public void setChongwuPhoto(String chongwuPhoto) {
			this.chongwuPhoto = chongwuPhoto;
		}

		/**
		* 获取： 位置
		*/
		public String getChongwuAddress() {
			return chongwuAddress;
		}
		/**
		* 设置： 位置
		*/
		public void setChongwuAddress(String chongwuAddress) {
			this.chongwuAddress = chongwuAddress;
		}

		/**
		* 获取： 赞
		*/
		public Integer getZanNumber() {
			return zanNumber;
		}
		/**
		* 设置： 赞
		*/
		public void setZanNumber(Integer zanNumber) {
			this.zanNumber = zanNumber;
		}

		/**
		* 获取： 踩
		*/
		public Integer getCaiNumber() {
			return caiNumber;
		}
		/**
		* 设置： 踩
		*/
		public void setCaiNumber(Integer caiNumber) {
			this.caiNumber = caiNumber;
		}
		/**
		* 获取： 寻宠类型
		*/
		public Integer getChongwuTypes() {
			return chongwuTypes;
		}
		/**
		* 设置： 寻宠类型
		*/
		public void setChongwuTypes(Integer chongwuTypes) {
			this.chongwuTypes = chongwuTypes;
		}


			/**
			* 获取： 寻宠类型的值
			*/
			public String getChongwuValue() {
				return chongwuValue;
			}
			/**
			* 设置： 寻宠类型的值
			*/
			public void setChongwuValue(String chongwuValue) {
				this.chongwuValue = chongwuValue;
			}

		/**
		* 获取： 寻宠热度
		*/
		public Integer getChongwuClicknum() {
			return chongwuClicknum;
		}
		/**
		* 设置： 寻宠热度
		*/
		public void setChongwuClicknum(Integer chongwuClicknum) {
			this.chongwuClicknum = chongwuClicknum;
		}

		/**
		* 获取： 寻宠介绍
		*/
		public String getChongwuContent() {
			return chongwuContent;
		}
		/**
		* 设置： 寻宠介绍
		*/
		public void setChongwuContent(String chongwuContent) {
			this.chongwuContent = chongwuContent;
		}

		/**
		* 获取： 逻辑删除
		*/
		public Integer getChongwuDelete() {
			return chongwuDelete;
		}
		/**
		* 设置： 逻辑删除
		*/
		public void setChongwuDelete(Integer chongwuDelete) {
			this.chongwuDelete = chongwuDelete;
		}
	//级联表的get和set 用户

		/**
		* 获取： 用户名称
		*/
		public String getYonghuName() {
			return yonghuName;
		}
		/**
		* 设置： 用户名称
		*/
		public void setYonghuName(String yonghuName) {
			this.yonghuName = yonghuName;
		}

		/**
		* 获取： 用户手机号
		*/
		public String getYonghuPhone() {
			return yonghuPhone;
		}
		/**
		* 设置： 用户手机号
		*/
		public void setYonghuPhone(String yonghuPhone) {
			this.yonghuPhone = yonghuPhone;
		}

		/**
		* 获取： 用户身份证号
		*/
		public String getYonghuIdNumber() {
			return yonghuIdNumber;
		}
		/**
		* 设置： 用户身份证号
		*/
		public void setYonghuIdNumber(String yonghuIdNumber) {
			this.yonghuIdNumber = yonghuIdNumber;
		}

		/**
		* 获取： 用户头像
		*/
		public String getYonghuPhoto() {
			return yonghuPhoto;
		}
		/**
		* 设置： 用户头像
		*/
		public void setYonghuPhoto(String yonghuPhoto) {
			this.yonghuPhoto = yonghuPhoto;
		}

		/**
		* 获取： 用户邮箱
		*/
		public String getYonghuEmail() {
			return yonghuEmail;
		}
		/**
		* 设置： 用户邮箱
		*/
		public void setYonghuEmail(String yonghuEmail) {
			this.yonghuEmail = yonghuEmail;
		}

		/**
		* 获取： 逻辑删除
		*/
		public Integer getYonghuDelete() {
			return yonghuDelete;
		}
		/**
		* 设置： 逻辑删除
		*/
		public void setYonghuDelete(Integer yonghuDelete) {
			this.yonghuDelete = yonghuDelete;
		}


	@Override
	public String toString() {
		return "ChongwuLiuyanView{" +
			", chongwuName=" + chongwuName +
			", chongwuPhoto=" + chongwuPhoto +
			", chongwuAddress=" + chongwuAddress +
			", zanNumber=" + zanNumber +
			", caiNumber=" + caiNumber +
			", chongwuClicknum=" + chongwuClicknum +
			", chongwuContent=" + chongwuContent +
			", chongwuDelete=" + chongwuDelete +
			", yonghuName=" + yonghuName +
			", yonghuPhone=" + yonghuPhone +
			", yonghuIdNumber=" + yonghuIdNumber +
			", yonghuPhoto=" + yonghuPhoto +
			", yonghuEmail=" + yonghuEmail +
			", yonghuDelete=" + yonghuDelete +
			"} " + super.toString();
	}
}
