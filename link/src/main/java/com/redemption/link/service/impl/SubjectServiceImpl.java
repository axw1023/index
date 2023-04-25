package com.redemption.link.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.redemption.link.entity.Subject;
import com.redemption.link.mapper.SubjectMapper;
import com.redemption.link.service.LinkService;
import com.redemption.link.service.SubjectService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.redemption.link.vo.SubjectVo;
import java.util.HashMap;
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
    private LinkService linkService;

    @Override
    public IPage<SubjectVo> subjectPage(Page page) {
        //todo convert速度较慢
        IPage<SubjectVo> subjectPage = page(page).convert(n -> {
            SubjectVo subjectVo = new SubjectVo();
            BeanUtils.copyProperties(n, subjectVo);
            return subjectVo;
        });
        for (SubjectVo subjectVo : subjectPage.getRecords()) {
            Map map = new HashMap();
            map.put("fnSubjectId", subjectVo.getId());
            //每组显示5条
            subjectVo.setLinkIPage(linkService.linkVoPage(new Page(1, 5), map));
        }
        return subjectPage;
    }
}
