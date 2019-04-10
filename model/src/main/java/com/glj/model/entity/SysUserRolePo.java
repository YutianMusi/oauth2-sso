package com.glj.model.base.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

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
@TableName("sys_user_role")
public class SysUserRolePo extends Model<SysUserRolePo> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer roleId;

    private Integer userId;


    public static final String ID = "id";

    public static final String ROLE_ID = "role_id";

    public static final String USER_ID = "user_id";

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
