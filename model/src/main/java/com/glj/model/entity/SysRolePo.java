package com.glj.model.base.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 
 * </p>
 *
 * @author gaoleijie
 * @since 2019-01-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sys_role")
public class SysRolePo extends Model<SysRolePo> {

    private static final long serialVersionUID = 1L;
    @TableId(value = "role_id", type = IdType.AUTO)
    private Integer roleId;

    private String roleCode;

    private String roleName;
    @TableField(exist = false)
    private List<SysPermissionPo> permissionPoList;

    public static final String ROLE_ID = "role_id";

    public static final String ROLE_CODE = "role_code";

    public static final String ROLE_NAME = "role_name";

    @Override
    protected Serializable pkVal() {
        return this.roleId;
    }

}
