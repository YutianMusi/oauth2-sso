package com.glj.model.entity;

import lombok.Data;

/**
 * <p>
 *
 * </p>
 *
 * @author gaoleijie
 * @since 2019-04-09
 */
@Data
public class OauthClientDetails {

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

}
