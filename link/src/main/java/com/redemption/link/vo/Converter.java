package com.redemption.link.vo;


import com.redemption.link.entity.Link;
import com.redemption.link.entity.Subject;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public abstract class Converter {

    public static Converter INSTANT = Mappers.getMapper(Converter.class);

    //前端获取雪花id长度问题精度缺失，转为String类型
    @Mapping(source = "id", target = "id", resultType = String.class)
    public abstract SubjectVo convertSubjectVo(Subject subject);

    public abstract LinkVo convertLinkVo(Link link);

}
