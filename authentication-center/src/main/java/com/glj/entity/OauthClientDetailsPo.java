package com.glj.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
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
 * @since 2019-04-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("oauth_client_details")
@ApiModel(value = "OauthClientDetailsPo对象", description = "")
public class OauthClientDetailsPo extends Model<OauthClientDetailsPo> {

    private static final long serialVersionUID = 1L;

    private String clientId;

    private String resourceIds;

    private String clientSecret;

    private String scope;

    private String authorizedGrantTypes;

    private String webServerRedirectUri;

    private String authorities;

    private Integer accessTokenValidity;

    private Integer refreshTokenValidity;

    private String additionalInformation;

    private String autoapprove;


    public static final String CLIENT_ID = "client_id";

    public static final String RESOURCE_IDS = "resource_ids";

    public static final String CLIENT_SECRET = "client_secret";

    public static final String SCOPE = "scope";

    public static final String AUTHORIZED_GRANT_TYPES = "authorized_grant_types";

    public static final String WEB_SERVER_REDIRECT_URI = "web_server_redirect_uri";

    public static final String AUTHORITIES = "authorities";

    public static final String ACCESS_TOKEN_VALIDITY = "access_token_validity";

    public static final String REFRESH_TOKEN_VALIDITY = "refresh_token_validity";

    public static final String ADDITIONAL_INFORMATION = "additional_information";

    public static final String AUTOAPPROVE = "autoapprove";

    @Override
    protected Serializable pkVal() {
        return this.clientId;
    }

}
