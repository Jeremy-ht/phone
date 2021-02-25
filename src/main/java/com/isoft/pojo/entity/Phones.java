package com.isoft.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author ${author}

 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Phones implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String name;

    private String image;

    private Integer kucun;

    private Integer price;

    /**
     * 重量 kg
     */
    private String weight;

    /**
     * 描述内容
     */
    private String content;

    /**
     * 品牌分类
     */
    private Integer categoryid;

    /**
     * 颜色（黑色 白色 蓝色 绿色 红色）
     */
    private String color;

    /**
     * 内存容量（8GB + 256GB 64 128 256）
     */
    private String version;

    /**
     * 产品名称
     */
    private String title;

    /**
     * 上市年份
     */
    private String year;

    /**
     * 无线充电
     */
    private Integer wuxian;

    /**
     * 主屏幕尺寸（英寸）
     */
    private String chicun;

    /**
     * NFC/NFC模式
     */
    private Integer nfc;

    /**
     * 充电接口类型
     */
    private Integer typec;

    /**
     * 电池容量 5000mAh
     */
    private String pool;

    /**
     * 首页 四类使用 图片
     */
    private String icon;

    private Integer state;

    private LocalDateTime creatime;


}
