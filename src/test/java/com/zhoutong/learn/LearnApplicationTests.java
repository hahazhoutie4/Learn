package com.zhoutong.learn;

import com.zhoutong.learn.mapper.DepartDao;
import com.zhoutong.learn.mapper.TbUserinfoDao;
import com.zhoutong.learn.model.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest		//spring boot整合单元测试的
class LearnApplicationTests {

	@Autowired
	private DepartDao departDao;

	@Autowired
	private TbUserinfoDao tbUserinfoDao;
	@Test
	void contextLoads() {
		List<Depart> list = departDao.list();
		list.stream().forEach(depart -> System.out.println(depart.getName()+depart.getId()));
	}
	@Test
	public  void testDp(){
		List<Depart> list = departDao.list();
		Result r = ResultImpl.okResult(list);
		System.out.println(r);
	}
	@Test
	public void testList(){
		List<TbUserinfo> list1 = tbUserinfoDao.list();
		Result r = ResultImpl.okResult(list1);
		System.out.println(r);
	}

	@Test
	public void testDao(){
		TbUserinfo tb_userinfo= new TbUserinfo();
		tb_userinfo.setUserinfo("resoushijian");
		System.out.println(tb_userinfo);
		int zhoutong321321 = tbUserinfoDao.insertUser(tb_userinfo);
		System.out.println(zhoutong321321);
	}

}
