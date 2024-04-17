package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CreditCard {
    private double limit;
    private double balance;
    private List<Purchase> shoppingList;

    public CreditCard(double limit) {
        this.limit = limit;
        this.balance = limit;
        this.shoppingList = new ArrayList<>();
    }

    public double getLimit() {
        return limit;
    }

    public double getBalance() {
        return balance;
    }

    public List<Purchase> getShoppingList() {
        return shoppingList;
    }

    public boolean addToShoppingList(Purchase item){
        if (this.balance < item.getPrice()){
            return false;
        }else{
            this.shoppingList.add(item);
            this.balance -= item.getPrice();
            return true;
        }
    }

    public void printShoppingList(){
        System.out.println("******************************");
        System.out.println("COMPRAS REALIZADAS: \n");
        Collections.sort(this.shoppingList);
        for (Purchase item : this.shoppingList ){
            System.out.println(item.getDescription() + " - " + item.getPrice());
        }
        System.out.println("\n******************************\n");
        System.out.println("Saldo do cartão: " + this.balance);
    }
}
