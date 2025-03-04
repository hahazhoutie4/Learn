package com.zhoutong.learn;

import com.zhoutong.learn.mapper.DepartDao;
import com.zhoutong.learn.mapper.TbUserinfoDao;
import com.zhoutong.learn.model.*;
import com.zhoutong.learn.service.TbBaiduresouService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest		//spring boot整合单元测试的
class LearnApplicationTests {

	public static String json = "{\n" +
			"    '2024-08-17T08:49:18.402Z': [\n" +
			"        '\uE662\\n总书记对这项技艺高度赞赏',\n" +
			"        '1\\n中国乒协：饭圈乱象严重干扰训练比赛热',\n" +
			"        '2\\n41名事业编人员遭清退 汝州通报热',\n" +
			"        '3\\n钱塘江潮汐树与交叉潮同框绝美壮阔',\n" +
			"        '4\\n中奖2.2亿不交个税成历史',\n" +
			"        '5\\n潘玮柏因体重退出跳水体验',\n" +
			"        '6\\n入住千万精装房后业主每天抓虫子',\n" +
			"        '7\\n裸婚老太花光再婚配偶224万元',\n" +
			"        '8\\n城管扔共享单车阻止摆摊？谣言',\n" +
			"        '9\\n老板娘穿着清凉被围观后暂时关门',\n" +
			"        '10\\niPhone16ProMax或新增古铜色',\n" +
			"        '11\\n邓亚萍18岁儿子获乒乓球全国冠军热',\n" +
			"        '12\\n奥运冠军郑钦文止步十六强热',\n" +
			"        '13\\n8岁小孩被吓坏 家长投诉《异形》',\n" +
			"        '14\\n婚登取消户口簿会致重婚？民政部回应热',\n" +
			"        '15\\n西湖边的树冒黑烟是蚊子在交配',\n" +
			"        '16新房未入住被陌生人住了4天',\n" +
			"        '17男子偷走村里的水泥公路',\n" +
			"        '18打1400公里顺风车逃单乘客已付车费',\n" +
			"        '19高铁即将关门2岁娃突然跑下车',\n" +
			"        '20蔬菜价格达近10年同期最高热',\n" +
			"        '21酒店竟用马桶刷蘸马桶水刷马桶',\n" +
			"        '22张兰直播途中摔倒',\n" +
			"        '23张根硕自曝1年前患甲状腺癌',\n" +
			"        '24女子直播间买珍珠一抠竟掉皮',\n" +
			"        '25网友西湖边偶遇哈登',\n" +
			"        '26绿牌特斯拉Cybertruck现身天津街头',\n" +
			"        '27陈梦说就是要赢给所有人看',\n" +
			"        '28女子趴小区地上晒背被车撞伤',\n" +
			"        '29警方通报男子睡梦中遭同事割伤',\n" +
			"        '30AI马斯克，1分钟骗走几十万'\n" +
			"    ],\n" +
			"    '2024-08-17T08:51:27.212Z': [\n" +
			"        '\uE662\\n总书记对这项技艺高度赞赏',\n" +
			"        '1\\n中国乒协：饭圈乱象严重干扰训练比赛热',\n" +
			"        '2\\n41名事业编人员遭清退 汝州通报热',\n" +
			"        '3\\n钱塘江潮汐树与交叉潮同框绝美壮阔',\n" +
			"        '4\\n中奖2.2亿不交个税成历史',\n" +
			"        '5\\n潘玮柏因体重退出跳水体验',\n" +
			"        '6\\n入住千万精装房后业主每天抓虫子',\n" +
			"        '7\\n裸婚老太花光再婚配偶224万元',\n" +
			"        '8\\n城管扔共享单车阻止摆摊？谣言',\n" +
			"        '9\\n老板娘穿着清凉被围观后暂时关门',\n" +
			"        '10\\niPhone16ProMax或新增古铜色',\n" +
			"        '11\\n邓亚萍18岁儿子获乒乓球全国冠军热',\n" +
			"        '12\\n奥运冠军郑钦文止步十六强热',\n" +
			"        '13\\n8岁小孩被吓坏 家长投诉《异形》',\n" +
			"        '14\\n婚登取消户口簿会致重婚？民政部回应热',\n" +
			"        '15\\n西湖边的树冒黑烟是蚊子在交配',\n" +
			"        '16新房未入住被陌生人住了4天',\n" +
			"        '17男子偷走村里的水泥公路',\n" +
			"        '18打1400公里顺风车逃单乘客已付车费',\n" +
			"        '19高铁即将关门2岁娃突然跑下车',\n" +
			"        '20蔬菜价格达近10年同期最高热',\n" +
			"        '21酒店竟用马桶刷蘸马桶水刷马桶',\n" +
			"        '22张兰直播途中摔倒',\n" +
			"        '23张根硕自曝1年前患甲状腺癌',\n" +
			"        '24女子直播间买珍珠一抠竟掉皮',\n" +
			"        '25网友西湖边偶遇哈登',\n" +
			"        '26绿牌特斯拉Cybertruck现身天津街头',\n" +
			"        '27陈梦说就是要赢给所有人看',\n" +
			"        '28女子趴小区地上晒背被车撞伤',\n" +
			"        '29警方通报男子睡梦中遭同事割伤',\n" +
			"        '30AI马斯克，1分钟骗走几十万'\n" +
			"    ]"+
			"}";


	@Autowired
	private TbBaiduresouService tbBaiduresouService;

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

	@Test
	public void testJsonParse(){
		List<TbBaiduresou> tbBaiduresous = tbBaiduresouService.parseJson(json);
		System.out.println(tbBaiduresous+"\r\n");
	}

}
