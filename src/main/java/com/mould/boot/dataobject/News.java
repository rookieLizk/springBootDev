package com.mould.boot.dataobject;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import com.mould.boot.dataobject.base.BaseDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * <p>
 * 
 * </p>
 *
 * @author lizk
 * @since 2019-11-09
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="News对象", description="")
@Document(indexName = "test",type = "news", shards = 1,replicas = 0, refreshInterval = "-1")
public class News extends BaseDO {

    private static final long serialVersionUID = 1L;


    @ApiModelProperty(value = "主键")
    @Id
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "标题")
    @Field(type= FieldType.Text,searchAnalyzer="ik_max_word",analyzer="ik_max_word")
    private String title;

    @ApiModelProperty(value = "来源")
    @Field(type=FieldType.Text)
    private String origin;

    @ApiModelProperty(value = "来源id")
    @TableField("originId")
    @Field(type=FieldType.Text)
    private Integer originId;

    @ApiModelProperty(value = "类型")
    @Field(type=FieldType.Text,searchAnalyzer="ik_max_word",analyzer="ik_max_word")
    @TableField("typeName")
    private String typeName;

    @ApiModelProperty(value = "封面图标")
    @Field(type=FieldType.Text,index=false)
    private String icon;

    @ApiModelProperty(value = "发布日期")
    @TableField("publishDate")
    @Field(type=FieldType.Text,fielddata=true)
    private String publishDate;

    @ApiModelProperty(value = "简介")
    @Field(type=FieldType.Text,searchAnalyzer="ik_max_word",analyzer="ik_max_word")
    private String info;

    @ApiModelProperty(value = "内容")
    @Field(type=FieldType.Text,searchAnalyzer="ik_max_word",analyzer="ik_max_word")
    private String content;

    @ApiModelProperty(value = "浏览次数")
    @TableField("browseNum")
    @Field(type=FieldType.Integer)
    private Integer browseNum;

    @ApiModelProperty(value = "创建时间")
    @TableField("createTime")
    @Field(type=FieldType.Text,fielddata=true)
    private String createTime;

    @ApiModelProperty(value = "更新时间")
    @TableField("modifyTime")
    @Field(type=FieldType.Text,fielddata=true)
    private String modifyTime;


}
