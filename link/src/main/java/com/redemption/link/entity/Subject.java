package com.redemption.link.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 分组
 * </p>
 *
 * @author axw
 * @since 2023-04-18
 */
@Getter
@Setter
@Schema(name = "Subject", description = "分组")
public class Subject implements Serializable {

  private static final long serialVersionUID = 1L;

  @Schema(description = "id")
  @TableId
  private Long id;

  @Schema(description = "名称（限制4字）")
  private String subjectName;

  @Schema(description = "图片")
  private String subjectPicture;

  @Schema(description = "说明")
  private String subjectExplain;
}
