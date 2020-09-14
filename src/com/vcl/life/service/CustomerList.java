package com.vcl.life.service;

import com.sun.corba.se.impl.oa.toa.TOA;
import com.vcl.life.Bean.Customer;

/**
 *@Description service模块负责数据的传递
 * @author Steven
 * @vision 1.0
 * @date 20.9.8 17:08
 * 构造器用来初始化customers数组
 * 参数totalCustomers用来指定customers数组的最大空间
 * public boolean addCustomer(Customer customer)
 * 用途：将参数customer添加到数组的最后一位之后
 * 参数：customer用来指定添加的客户对象。
 * 返回：添加成功返回true 添加失败返回false
 **/

public class CustomerList {
    /**total用来记录已经保存的用户个数
     * 用来保存用户对象的数组
     */
    private Customer[] customers;
    private int total=0;

    public CustomerList(int totalCustomer){
        customers=new Customer[totalCustomer];
    }

    /**
     *将指定的用户添加到数组中
     * @param customer
     * @return true：添加成功 false:添加失败
     */
    public boolean addCustomer(Customer customer){
          if(total>=customers.length){
              return false;
          }
            customers[total]=customer;
            total++;
        return true;
    }

    /**
     *修改指定索引位置的用户信息
     * @param index
     * @param cust
     * @return true:修改成功 false:修改失败
     */
    public boolean replaceCustomer(int index,Customer cust){
        if(index<0||index>=total){
            return false;
        }
        customers[index]=cust;
        return true;
    }

    /**
     * 删除指定索引位置上的用户
     * @param index
     * @return false 删除失败 true：成功
     */
    public boolean deleteCustomer(int index){
        if(index<0||index>=total){
            return false;
        }
        for(int i=index;i<=total-1;i++){
            customers[i]=customers[i+1];
        }
        //最后一个有数据的要置成null;
        customers[total-1]=null;
        total--;
        return true;
    }

    /**
     * 获取所有的客户信息
     * 不能直接返回customers避免没存满的情况
     *
     * @return
     */
    public Customer[] getAllCustomers(){
        Customer[] custs=new Customer[total];
        for(int i=0;i<total;i++){
            custs[i]=customers[i];
        }
        return custs;
    }

    /**
     * 获取指定位置上的客户信息
     * @param index
     * @return 如果找到就返回信息，没有找到就返回null
     */
    public Customer getCustomer(int index){
        if(index<0||index>=total){
            return null;
        }
        return customers[index];
    }

    /**
     * 获取存储客户数据的数量
     * @return
     */
    public int getTotal(){
        return total;
    }

}
