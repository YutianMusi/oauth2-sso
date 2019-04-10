package com.glj.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.glj.entity.OauthClientDetailsPo;
import com.glj.mapper.OauthClientDetailsMapper;
import com.glj.service.IOauthClientDetailsService;
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
