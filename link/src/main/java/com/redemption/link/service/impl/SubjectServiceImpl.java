package com.redemption.link.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.redemption.link.entity.Link;
import com.redemption.link.entity.Subject;
import com.redemption.link.mapper.LinkMapper;
import com.redemption.link.mapper.SubjectMapper;
import com.redemption.link.service.LinkService;
import com.redemption.link.service.SubjectService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.redemption.link.vo.Converter;
import com.redemption.link.vo.LinkVo;
import com.redemption.link.vo.SubjectVo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 分组 服务实现类
 * </p>
 *
 * @author axw
 * @since 2023-04-18
 */
@Service
public class SubjectServiceImpl extends ServiceImpl<SubjectMapper, Subject> implements SubjectService {

    @Autowired
    private SubjectMapper subjectMapper;

    @Override
    public IPage<SubjectVo> subjectVoPage(Page page) {

        IPage<SubjectVo> subjectPage = page(page).convert(n -> {
            SubjectVo subjectVo = Converter.INSTANT.convert((Subject) n);
            return subjectVo;
        });
        return subjectPage;
    }
}
