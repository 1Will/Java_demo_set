package com.bstek.demo.ims.dao;

import org.springframework.stereotype.Repository;

import com.bstek.demo.ims.entity.Customer;
import com.bstek.dorado.hibernate.HibernateDao;

/**
 * <p>
 * Ϊ�˿�����㣬�����в���Dorado7�ṩ��Hibernate Add On��չ������ͨ���̳�HibernateDao������ʵ���Լ���ҵ��Dao����
 * HibernateDao�Ѿ�ʵ������ɾ�Ĳ�Ļ�������������Dao����ʱ����Ҫ��д��������ݡ����η�����Ϊ���е�ʵ����󴴽�Dao�ࡣ
 * </p>
 * @author JERR
 * 
 */

@Repository
public class CustomerDao extends HibernateDao<Customer, Integer> {

}
