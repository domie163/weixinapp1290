package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.DongwuLiuyanEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 求助留言
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("dongwu_liuyan")
public class DongwuLiuyanView extends DongwuLiuyanEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表

	//级联表 动物求助
		/**
		* 求助名称
		*/

		@ColumnInfo(comment="求助名称",type="varchar(200)")
		private String dongwuName;
		/**
		* 求助照片
		*/

		@ColumnInfo(comment="求助照片",type="varchar(200)")
		private String dongwuPhoto;
		/**
		* 求助类型
		*/
		@ColumnInfo(comment="求助类型",type="int(11)")
		private Integer dongwuTypes;
			/**
			* 求助类型的值
			*/
			@ColumnInfo(comment="求助类型的字典表值",type="varchar(200)")
			private String dongwuValue;
					 
		/**
		* 动物求助 的 用户
		*/
		@ColumnInfo(comment="用户",type="int(11)")
		private Integer dongwuYonghuId;
		/**
		* 求助热度
		*/

		@ColumnInfo(comment="求助热度",type="int(11)")
		private Integer dongwuClicknum;
		/**
		* 求助详情
		*/

		@ColumnInfo(comment="求助详情",type="longtext")
		private String dongwuContent;
		/**
		* 求助状态
		*/
		@ColumnInfo(comment="求助状态",type="int(11)")
		private Integer qiuzhuzhuangtaiTypes;
			/**
			* 求助状态的值
			*/
			@ColumnInfo(comment="求助状态的字典表值",type="varchar(200)")
			private String qiuzhuzhuangtaiValue;
		/**
		* 逻辑删除
		*/

		@ColumnInfo(comment="逻辑删除",type="int(11)")
		private Integer dongwuDelete;
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



	public DongwuLiuyanView() {

	}

	public DongwuLiuyanView(DongwuLiuyanEntity dongwuLiuyanEntity) {
		try {
			BeanUtils.copyProperties(this, dongwuLiuyanEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}





	//级联表的get和set 动物求助

		/**
		* 获取： 求助名称
		*/
		public String getDongwuName() {
			return dongwuName;
		}
		/**
		* 设置： 求助名称
		*/
		public void setDongwuName(String dongwuName) {
			this.dongwuName = dongwuName;
		}

		/**
		* 获取： 求助照片
		*/
		public String getDongwuPhoto() {
			return dongwuPhoto;
		}
		/**
		* 设置： 求助照片
		*/
		public void setDongwuPhoto(String dongwuPhoto) {
			this.dongwuPhoto = dongwuPhoto;
		}
		/**
		* 获取： 求助类型
		*/
		public Integer getDongwuTypes() {
			return dongwuTypes;
		}
		/**
		* 设置： 求助类型
		*/
		public void setDongwuTypes(Integer dongwuTypes) {
			this.dongwuTypes = dongwuTypes;
		}


			/**
			* 获取： 求助类型的值
			*/
			public String getDongwuValue() {
				return dongwuValue;
			}
			/**
			* 设置： 求助类型的值
			*/
			public void setDongwuValue(String dongwuValue) {
				this.dongwuValue = dongwuValue;
			}
		/**
		* 获取：动物求助 的 用户
		*/
		public Integer getDongwuYonghuId() {
			return dongwuYonghuId;
		}
		/**
		* 设置：动物求助 的 用户
		*/
		public void setDongwuYonghuId(Integer dongwuYonghuId) {
			this.dongwuYonghuId = dongwuYonghuId;
		}

		/**
		* 获取： 求助热度
		*/
		public Integer getDongwuClicknum() {
			return dongwuClicknum;
		}
		/**
		* 设置： 求助热度
		*/
		public void setDongwuClicknum(Integer dongwuClicknum) {
			this.dongwuClicknum = dongwuClicknum;
		}

		/**
		* 获取： 求助详情
		*/
		public String getDongwuContent() {
			return dongwuContent;
		}
		/**
		* 设置： 求助详情
		*/
		public void setDongwuContent(String dongwuContent) {
			this.dongwuContent = dongwuContent;
		}
		/**
		* 获取： 求助状态
		*/
		public Integer getQiuzhuzhuangtaiTypes() {
			return qiuzhuzhuangtaiTypes;
		}
		/**
		* 设置： 求助状态
		*/
		public void setQiuzhuzhuangtaiTypes(Integer qiuzhuzhuangtaiTypes) {
			this.qiuzhuzhuangtaiTypes = qiuzhuzhuangtaiTypes;
		}


			/**
			* 获取： 求助状态的值
			*/
			public String getQiuzhuzhuangtaiValue() {
				return qiuzhuzhuangtaiValue;
			}
			/**
			* 设置： 求助状态的值
			*/
			public void setQiuzhuzhuangtaiValue(String qiuzhuzhuangtaiValue) {
				this.qiuzhuzhuangtaiValue = qiuzhuzhuangtaiValue;
			}

		/**
		* 获取： 逻辑删除
		*/
		public Integer getDongwuDelete() {
			return dongwuDelete;
		}
		/**
		* 设置： 逻辑删除
		*/
		public void setDongwuDelete(Integer dongwuDelete) {
			this.dongwuDelete = dongwuDelete;
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
		return "DongwuLiuyanView{" +
			", dongwuName=" + dongwuName +
			", dongwuPhoto=" + dongwuPhoto +
			", dongwuClicknum=" + dongwuClicknum +
			", dongwuContent=" + dongwuContent +
			", dongwuDelete=" + dongwuDelete +
			", yonghuName=" + yonghuName +
			", yonghuPhone=" + yonghuPhone +
			", yonghuIdNumber=" + yonghuIdNumber +
			", yonghuPhoto=" + yonghuPhoto +
			", yonghuEmail=" + yonghuEmail +
			", yonghuDelete=" + yonghuDelete +
			"} " + super.toString();
	}
}
