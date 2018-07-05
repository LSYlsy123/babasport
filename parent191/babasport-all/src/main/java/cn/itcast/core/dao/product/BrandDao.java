package cn.itcast.core.dao.product;

import cn.itcast.core.bean.product.Brand;
import cn.itcast.core.bean.product.BrandQuery;

import java.util.List;

public interface BrandDao {

    //查询结果集
    List<Brand> selectBrandListByQuery(BrandQuery brandQuery);

    //查询总条数
    Integer selectCount(BrandQuery brandQuery);
}
