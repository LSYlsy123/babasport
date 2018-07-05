package cn.itcast.core.service.product;

import cn.itcast.common.page.Pagination;
import cn.itcast.core.bean.product.BrandQuery;
import cn.itcast.core.dao.product.BrandDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandDao brandDao;

    //查询分页对象
    public Pagination selectPaginationByQuery(String name,Integer isDisplay,Integer pageNo){


        BrandQuery brandQuery=new BrandQuery();

        //当前页设置
        brandQuery.setPageNo(Pagination.cpn(pageNo));

        //每页条数
        brandQuery.setPageSize(3);

        StringBuilder params=new StringBuilder();

        //设置brandQuery里的筛选条件
        if (name !=null&&name.length()>0){
            brandQuery.setName(name);
            params.append("name=").append(name);
        }

        if (null != isDisplay){
            brandQuery.setIsDisplay(isDisplay);
            params.append("&isDisplay=").append(isDisplay);
        }else {
            brandQuery.setIsDisplay(1);
            params.append("&isDisplay=").append(1);
        }
        Pagination pagination=new Pagination(
                //当前页
                brandQuery.getPageNo(),
                //每页数
                brandQuery.getPageSize(),
                //总条数
                brandDao.selectCount(brandQuery)
        );

        //设置结果集
        pagination.setList(brandDao.selectBrandListByQuery(brandQuery));

        //分页展示
        String url="/brand/list.do";
        pagination.pageView(url,params.toString());

        return pagination;
    }
}
