package com.redemption.link.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.redemption.link.entity.Link;
import com.redemption.link.mapper.LinkMapper;
import com.redemption.link.service.LikeCountService;
import com.redemption.link.service.LinkService;
import com.redemption.link.vo.Converter;
import com.redemption.link.vo.LinkVo;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 链接 服务实现类
 * </p>
 *
 * @author axw
 * @since 2023-04-07
 */
@Service
public class LinkServiceImpl extends ServiceImpl<LinkMapper, Link> implements LinkService {


    @Autowired
    private LinkMapper linkMapper;

    @Override
    public IPage<LinkVo> linkVoPage(Page page, Map map) {
        IPage<Link> linkIPage = linkMapper.selectPage(
            page,
            new QueryWrapper<Link>()
                .lambda()
                .eq(Link::getFnSubjectId, map.get("fnSubjectId"))
        );

        IPage<LinkVo> linkVoIPage = linkIPage.convert(n -> {
            LinkVo linkVo = Converter.INSTANT.convertLinkVo(n);
            return linkVo;
        });

        return linkVoIPage;
    }
}
