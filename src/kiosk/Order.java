package kiosk;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Order {
    private ArrayList<Product> shoppingBag = new ArrayList<Product>();
    private HashSet<Product> soldProduct = new HashSet<Product>();
    private int counter = 0;

    public void AddOrder(Product product) {
        Scanner sc = new Scanner(System.in);
        product.Show();
        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
        System.out.println("1.확인          2.취소");
        if (sc.nextInt() == 1) {
            System.out.println(product.getName() + "가 장바구니에 추가되었습니다.");
            shoppingBag.add(product);
        }
    }
    public double getShoppingBag(){//쇼핑백 내용 보여주기, 가격 return
        double totalprice = 0;
        for (Product item : shoppingBag) {
            item.Show();
            totalprice += item.getPrice(); //가격계산
        }
        totalprice=Math.round((totalprice*10)/10.0);//소수점 첫째자리까지 나타내고 반올림 ( 자바는 IEEE 754 부동 소수점 방식 - 근사치 제공에 의해 소수 오차 발생 방지)
        return totalprice;
    }
    public int CompleteOrder() {

        shoppingBag.clear();//
        counter++;          //대기번호 +1
        return counter;
    }

    public void CancelOrder() {
        shoppingBag.clear();
    }
}