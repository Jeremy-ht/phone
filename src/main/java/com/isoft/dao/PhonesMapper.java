package com.isoft.dao;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.isoft.pojo.entity.Phones;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.isoft.pojo.vo.PhonesVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author ${author}
 */
public interface PhonesMapper extends BaseMapper<Phones> {

    @Update("update Phones set state = #{state} where id = #{id}")
    int pullScenery(@Param("id") Integer id, @Param("state") Integer state);

    Page<PhonesVo> getSceneryList(Page<PhonesVo> page, Integer categoryId);

    List<PhonesVo> getFourIcon();

    PhonesVo getSceneryInfo(Integer id);

    @Select("SELECT categoryname FROM category where id = #{id}")
    String getSceneryListByCate(Integer id);

    Page<PhonesVo> getSearchList(@Param("page") Page<PhonesVo> page,
                                 @Param("searchText") String searchText);
}
