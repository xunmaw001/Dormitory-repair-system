package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 故障上报
 *
 * @author 
 * @email
 */
@TableName("guzhangshangbao")
public class GuzhangshangbaoEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public GuzhangshangbaoEntity() {

	}

	public GuzhangshangbaoEntity(T t) {
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
    @TableField(value = "id")

    private Integer id;


    /**
     * 学生
     */
    @TableField(value = "xuesheng_id")

    private Integer xueshengId;


    /**
     * 任务编号
     */
    @TableField(value = "guzhangshangbao_uuid_number")

    private String guzhangshangbaoUuidNumber;


    /**
     * 区域
     */
    @TableField(value = "quyu_types")

    private Integer quyuTypes;


    /**
     * 所在区域
     */
    @TableField(value = "guzhangshangbao_address")

    private String guzhangshangbaoAddress;


    /**
     * 故障信息
     */
    @TableField(value = "guzhangshangbao_guzhang")

    private String guzhangshangbaoGuzhang;


    /**
     * 故障类型
     */
    @TableField(value = "guzhangshangbao_types")

    private Integer guzhangshangbaoTypes;


    /**
     * 维修人员
     */
    @TableField(value = "weixiuyuan_id")

    private Integer weixiuyuanId;


    /**
     * 处理结果
     */
    @TableField(value = "chulijieguo_types")

    private Integer chulijieguoTypes;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time",fill = FieldFill.INSERT)

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
	 * 设置：学生
	 */
    public Integer getXueshengId() {
        return xueshengId;
    }


    /**
	 * 获取：学生
	 */

    public void setXueshengId(Integer xueshengId) {
        this.xueshengId = xueshengId;
    }
    /**
	 * 设置：任务编号
	 */
    public String getGuzhangshangbaoUuidNumber() {
        return guzhangshangbaoUuidNumber;
    }


    /**
	 * 获取：任务编号
	 */

    public void setGuzhangshangbaoUuidNumber(String guzhangshangbaoUuidNumber) {
        this.guzhangshangbaoUuidNumber = guzhangshangbaoUuidNumber;
    }
    /**
	 * 设置：区域
	 */
    public Integer getQuyuTypes() {
        return quyuTypes;
    }


    /**
	 * 获取：区域
	 */

    public void setQuyuTypes(Integer quyuTypes) {
        this.quyuTypes = quyuTypes;
    }
    /**
	 * 设置：所在区域
	 */
    public String getGuzhangshangbaoAddress() {
        return guzhangshangbaoAddress;
    }


    /**
	 * 获取：所在区域
	 */

    public void setGuzhangshangbaoAddress(String guzhangshangbaoAddress) {
        this.guzhangshangbaoAddress = guzhangshangbaoAddress;
    }
    /**
	 * 设置：故障信息
	 */
    public String getGuzhangshangbaoGuzhang() {
        return guzhangshangbaoGuzhang;
    }


    /**
	 * 获取：故障信息
	 */

    public void setGuzhangshangbaoGuzhang(String guzhangshangbaoGuzhang) {
        this.guzhangshangbaoGuzhang = guzhangshangbaoGuzhang;
    }
    /**
	 * 设置：故障类型
	 */
    public Integer getGuzhangshangbaoTypes() {
        return guzhangshangbaoTypes;
    }


    /**
	 * 获取：故障类型
	 */

    public void setGuzhangshangbaoTypes(Integer guzhangshangbaoTypes) {
        this.guzhangshangbaoTypes = guzhangshangbaoTypes;
    }
    /**
	 * 设置：维修人员
	 */
    public Integer getWeixiuyuanId() {
        return weixiuyuanId;
    }


    /**
	 * 获取：维修人员
	 */

    public void setWeixiuyuanId(Integer weixiuyuanId) {
        this.weixiuyuanId = weixiuyuanId;
    }
    /**
	 * 设置：处理结果
	 */
    public Integer getChulijieguoTypes() {
        return chulijieguoTypes;
    }


    /**
	 * 获取：处理结果
	 */

    public void setChulijieguoTypes(Integer chulijieguoTypes) {
        this.chulijieguoTypes = chulijieguoTypes;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Guzhangshangbao{" +
            "id=" + id +
            ", xueshengId=" + xueshengId +
            ", guzhangshangbaoUuidNumber=" + guzhangshangbaoUuidNumber +
            ", quyuTypes=" + quyuTypes +
            ", guzhangshangbaoAddress=" + guzhangshangbaoAddress +
            ", guzhangshangbaoGuzhang=" + guzhangshangbaoGuzhang +
            ", guzhangshangbaoTypes=" + guzhangshangbaoTypes +
            ", weixiuyuanId=" + weixiuyuanId +
            ", chulijieguoTypes=" + chulijieguoTypes +
            ", createTime=" + createTime +
        "}";
    }
}
