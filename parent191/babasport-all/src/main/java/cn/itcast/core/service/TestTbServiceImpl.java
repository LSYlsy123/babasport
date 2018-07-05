package cn.itcast.core.service;
import cn.itcast.core.bean.product.TestTb;
import cn.itcast.core.dao.TestTbDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service("testTbService")
public class TestTbServiceImpl implements TestTbService {

    @Autowired
    private TestTbDao testTbDao;

    public void insertTestTb(TestTb testTb){
        testTbDao.insertTestTb(testTb);

        //throw new RuntimeException();
    }
}
