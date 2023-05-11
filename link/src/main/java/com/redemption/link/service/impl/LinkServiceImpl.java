package com.redemption.link.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.redemption.link.entity.Link;
import com.redemption.link.entity.Subject;
import com.redemption.link.mapper.LinkMapper;
import com.redemption.link.service.LinkService;
import com.redemption.link.vo.Converter;
import com.redemption.link.vo.LinkVo;
import com.redemption.link.vo.SubjectVo;
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
        IPage<LinkVo> linkVoIPage = linkMapper.selectPage(
            page,
            new QueryWrapper<Link>()
                .lambda()
//                .select(Link::getId)
                .eq(Link::getFnSubjectId, map.get("fnSubjectId"))
        ).convert(n -> {
            LinkVo linkVo = Converter.INSTANT.convertLinkVo((Link) n);
            return linkVo;
        });
        return linkVoIPage;
    }
}
