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
@TableName("sys_permission")
public class SysPermissionPo extends Model<SysPermissionPo> {

    private static final long serialVersionUID = 1L;
    @TableId(value = "per_id", type = IdType.AUTO)
    private Integer perId;

    private String name;

    private String code;

    private Integer type;

    private String url;

    private Integer sort;

    private Integer pid;


    public static final String ID = "per_id";

    public static final String NAME = "name";

    public static final String CODE = "code";

    public static final String TYPE = "type";

    public static final String URL = "url";

    public static final String SORT = "sort";

    public static final String PID = "pid";

    @Override
    protected Serializable pkVal() {
        return this.perId;
    }

}
