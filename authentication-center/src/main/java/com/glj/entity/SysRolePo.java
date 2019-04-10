package com.glj.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
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
import java.util.List;

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
@TableName("sys_role")
@ApiModel(value = "SysRolePo对象", description = "")
public class SysRolePo extends Model<SysRolePo> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "角色名称")
    private String roleName;

    private String roleCode;

    @ApiModelProperty(value = "角色描述")
    private String roleDescription;

    private String createUser;

    private LocalDateTime createTime;

    private String updateUser;

    private LocalDateTime updateTime;
    @TableField(exist = false)
    private List<SysPermissionPo> permissionPoList;


    public static final String ID = "id";

    public static final String ROLE_NAME = "role_name";

    public static final String ROLE_CODE = "role_code";

    public static final String ROLE_DESCRIPTION = "role_description";

    public static final String CREATE_USER = "create_user";

    public static final String CREATE_TIME = "create_time";

    public static final String UPDATE_USER = "update_user";

    public static final String UPDATE_TIME = "update_time";

    @Override
    protected Serializable pkVal() {
        return this.id;
    }


}
