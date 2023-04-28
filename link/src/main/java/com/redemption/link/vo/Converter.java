package com.redemption.link.vo;


import com.redemption.link.entity.Subject;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public abstract class Converter {

    public static Converter INSTANT = Mappers.getMapper(Converter.class);

    public abstract SubjectVo convert(Subject subject);

    public abstract List<SubjectVo> covertList(List<Subject> subjectList);
}
