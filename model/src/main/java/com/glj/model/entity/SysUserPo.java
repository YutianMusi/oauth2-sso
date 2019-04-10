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
@TableName("sys_user")
public class SysUserPo extends Model<SysUserPo> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "user_id", type = IdType.AUTO)
    private Integer userId;

    private String userCode;

    private String userPassword;

    private String userName;

    private Integer age;

    private Integer sex;

    private String address;

    private String email;

    private String phone;

    private String salt;

    @TableField(exist = false)
    private List<SysRolePo> rolePoList;

    public static final String USER_ID = "user_id";

    public static final String USER_CODE = "user_code";

    public static final String USER_PASSWORD = "user_password";

    public static final String USER_NAME = "user_name";

    public static final String AGE = "age";

    public static final String SEX = "sex";

    public static final String ADDRESS = "address";

    public static final String EMAIL = "email";

    public static final String PHONE = "phone";

    public static final String SALT = "salt";

    @Override
    protected Serializable pkVal() {
        return this.userId;
    }

}
