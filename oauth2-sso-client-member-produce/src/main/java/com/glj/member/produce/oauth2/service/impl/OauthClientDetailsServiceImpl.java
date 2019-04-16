package com.glj.member.produce.oauth2.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.glj.member.produce.oauth2.mapper.OauthClientDetailsMapper;
import com.glj.member.produce.oauth2.service.IOauthClientDetailsService;
import com.glj.model.entity.OauthClientDetailsPo;

import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author gaoleijie
 * @since 2019-01-11
 */
@Service
public class OauthClientDetailsServiceImpl extends ServiceImpl<OauthClientDetailsMapper, OauthClientDetailsPo> implements IOauthClientDetailsService {

}
