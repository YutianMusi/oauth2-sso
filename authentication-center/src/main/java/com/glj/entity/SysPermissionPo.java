package com.glj.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 *
 * </p>
 *
 * @author gaoleijie
 * @since 2019-04-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sys_permission")
@ApiModel(value = "SysPermissionPo对象", description = "")
public class SysPermissionPo extends Model<SysPermissionPo> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "父ID")
    private Integer pid;

    @ApiModelProperty(value = "资源类型（1：菜单，2：按钮，3：操作）")
    private Integer type;

    @ApiModelProperty(value = "资源名称")
    private String name;

    @ApiModelProperty(value = "资源标识（或者叫权限字符串）")
    private String code;

    @ApiModelProperty(value = "资源URI")
    private String uri;

    @ApiModelProperty(value = "序号")
    private Integer seq;

    private String createUser;

    private LocalDateTime createTime;

    private String updateUser;

    private LocalDateTime updateTime;


    public static final String ID = "id";

    public static final String PID = "pid";

    public static final String TYPE = "type";

    public static final String NAME = "name";

    public static final String CODE = "code";

    public static final String URI = "uri";

    public static final String SEQ = "seq";

    public static final String CREATE_USER = "create_user";

    public static final String CREATE_TIME = "create_time";

    public static final String UPDATE_USER = "update_user";

    public static final String UPDATE_TIME = "update_time";

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
