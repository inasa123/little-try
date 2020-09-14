package com.vcl.life.ui;

import com.vcl.life.Bean.Customer;
import com.vcl.life.service.CustomerList;
import util.CMUtility;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapters;

/*
 *@Description Customer为主模块负责菜单的显示和处理用户数据的操作
 * @author Steven
 * @vision
 * @date 20.9.8 17:08*/
public class CustomerView {
    private CustomerList customerList = new CustomerList(10);

    public CustomerView() {
        Customer customer = new Customer("Steven", '男', 18, "110110", "110@qq.com");
        customerList.addCustomer(customer);

    }

    /**
     * 显示《客户管理界面的方法》
     */

    private void enterMainMenu() {
        boolean isFlag = true;
        while (isFlag) {
            System.out.println("\n--------------------客户信息管理软件----------------");
            System.out.println("                       1、添加客户");
            System.out.println("                       2、修改客户");
            System.out.println("                       3、删除客户");
            System.out.println("                       4、客户列表");
            System.out.println("                       5、退  出\n");
            System.out.printf("                       请选择(1-5):");
            char menu = CMUtility.readMenuSection();
            switch (menu) {
                case '1':
                    addNewCustomer();
                    break;
                case '2':
                    modifyCustomer();
                    break;
                case '3':
                    deleteCustomer();
                    break;
                case '4':
                    listAllCustomers();
                    break;
                case '5':
                    System.out.print("确认是否退出(Y/N):");
                    char isExit = CMUtility.readConfirmSelection();
                    if (isExit == 'Y') {
                        isFlag = false;
                    }
                    break;
            }
            //flag=false退出
        }
    }

    /**
     * 添加新用户的操作
     */
    private void addNewCustomer() {
        System.out.println("------------------------------添加客户---------------------------");
        System.out.print("姓名：");
        String name = CMUtility.readString(10);
        System.out.print("性别：");
        char gender = CMUtility.readChar();
        System.out.print("年龄：");
        // TODO: 2020/9/12 需要修改CMUtility中的readInt
        int age = CMUtility.readInt(23);
        System.out.print("电话：");
        String phone = CMUtility.readString(13);
        System.out.print("邮箱：");
        String email = CMUtility.readString(30);
        //将上述数据封装到对象中
        Customer customer = new Customer(name, gender, age, phone, email);
        boolean isSuccess = customerList.addCustomer(customer);
        if (isSuccess) {
            System.out.println("-----------------------添加完成-----------------------");
        } else {
            System.out.println("-----------客户目录已满，添加失败-----------------------");
        }


    }

    /**
     * 修改客户的操作
     */
    private void modifyCustomer() {
        //System.out.println(" 修改客户的操作");
        Customer customer;
        int number;

        System.out.println("-------------------------修改客户信息-----------------------");
        for(; ;){
            System.out.println("请选择待修改客户的编号(-1退出):");
             number=CMUtility.readInt();
            if(number==-1){
                return;
            }
             customer = customerList.getCustomer(number - 1);
            if(customer==null){
                System.out.println("-------------------------没有找到客户信息-------------------");
            }
            else{//找到了相应的客户信息
                break;
            }

        }
        System.out.print("姓名("+customer.getName()+"):");
        String name = CMUtility.readString(10, customer.getName());
        System.out.print("性别("+customer.getGender()+"):");
        char gender = CMUtility.readChar(customer.getGender());
        System.out.print("年龄("+customer.getAge()+"):");
        int age = CMUtility.readInt(customer.getAge());
        System.out.print("电话("+customer.getPhone()+"):");
        String phone = CMUtility.readString(13, customer.getPhone());
        System.out.print("邮箱("+customer.getEmail()+"):");
        String email = CMUtility.readString(30, customer.getEmail());
        Customer Newcustomer = new Customer(name, gender, age, phone, email);
        boolean isReplaced = customerList.replaceCustomer(number - 1, Newcustomer);
        if(isReplaced){
            System.out.println("-------------------------信息修改成功-----------------------");
        }





    }

    /**
     * 删除客户的操作
     */
    private void deleteCustomer() {
       int number;
        //System.out.println("删除用户");
        System.out.println("--------------------删除客户---------------------");
        for(; ;){
            System.out.print("请输入删除客户的编号(-1退出):");
           number = CMUtility.readInt();
           if(number==-1){
               return;
           }
            Customer customer = customerList.getCustomer(number - 1);
           if(customer==null){
               System.out.println("输入的用户不存在");
           }else{
               break;
           }
        }
        //找到了指定用户
        System.out.print("确认是否删除(Y/N):");
        char isDelete = CMUtility.readConfirmSelection();
        if(isDelete=='Y'){
            boolean deleteSuccess=customerList.deleteCustomer(number-1);
            if (deleteSuccess){
                System.out.println("----------------删除成功-----------------");
            }else {
                System.out.println("----------------删除失败-----------------");
            }
        }else{
            return;
        }

    }

    /**
     * 客户列表的展示
     */
    private void listAllCustomers() {
        System.out.println("--------------------------客户列表展示-------------------------------");
        int total = customerList.getTotal();
        if (total == 0) {
            System.out.println("用户列表为空");
        } else {
            Customer[] allCustomers = customerList.getAllCustomers();
            System.out.println("编号\t姓名\t性别\t年龄\t电话\t\t邮箱");
            for (int i = 0; i < total; i++) {
                Customer customer = allCustomers[i];
                System.out.println(i + 1 + "\t\t" + customer.getName() + "\t" + customer.getGender() + "\t\t" + customer.getAge() + "\t\t" + customer.getPhone() + "\t\t" + customer.getEmail());

            }
        }


        System.out.println("--------------------------客户列表完成-------------------------------");

    }

    public static void main(String[] args) {
        CustomerView customerView = new CustomerView();
        customerView.enterMainMenu();

    }
}
