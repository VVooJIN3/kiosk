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
        int input;
        product.Show();
        if (product.getSizeupPrice() != 0) { //사이즈업이 있을때
            Product sizeupProduct = new Product(product.getName(), product.getDescription(), product.getSizeupPrice(), product.getCategory());
            System.out.println("위 메뉴의 어떤 옵션으로 추가하시겠습니까?");
            System.out.println("1. M(W " + product.getPrice() + ")          2. L(W " + sizeupProduct.getPrice() + ")");
            input = sc.nextInt();
            if (input == 1) { //기본 사이즈
                question(product);
            } else if (input == 2) {//사이즈업
                question(sizeupProduct);
            }
        }
    }
    public void question (Product product) {
        Scanner sc = new Scanner(System.in);
        int input;
        product.Show();
        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
        System.out.println("1.확인          2.취소");
        input = sc.nextInt();
        if (input == 1) {//장바구니 추가
            System.out.println(product.getName() + "가 장바구니에 추가되었습니다.");
            shoppingBag.add(product);
        } else if (input == 2) {
            System.out.println("장바구니에 추가하지 않았습니다.");
        }
    }
    public double getShoppingBag(){//쇼핑백 내용 보여주기, 가격 return
        double totalprice = 0;
        for (Product item : shoppingBag) {
            item.Show();
            totalprice += item.getPrice(); //가격계산
        }
        totalprice=Math.round((totalprice*100))/100.0;//소수점 둘째자리까지 나타내고 반올림 ( 자바는 IEEE 754 부동 소수점 방식 - 근사치 제공에 의해 소수 오차 발생 방지)
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