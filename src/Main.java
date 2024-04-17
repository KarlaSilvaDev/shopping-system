import models.CreditCard;
import models.Purchase;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int option = 1;
        String description;
        double price;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o limite do cartão:");
        CreditCard myCreditCard = new CreditCard(scanner.nextDouble());

        while (option == 1){
            System.out.println("Digite a descricao da compra");
            description = scanner.next();
            System.out.println("Digite o valor da compra: ");
            price = scanner.nextDouble();

            Purchase purchase = new Purchase(description, price);
            boolean purchaseConfirmed = myCreditCard.addToShoppingList(purchase);

            if (purchaseConfirmed){
                System.out.println("Compra realizada");
                System.out.println("Digite 0 para sair ou 1 para continuar.");
                option = scanner.nextInt();
            }else{
                System.out.println("Saldo insuficiente");
                option = 0;
            }
        }
        scanner.close();

        myCreditCard.printShoppingList();
    }
}
