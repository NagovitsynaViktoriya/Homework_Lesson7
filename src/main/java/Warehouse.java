
import java.util.Scanner;

public class Warehouse {



    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Содежимое склада -view   |   Добавить товар -add   |   Удалить товар -del   |   Экспорт в EXCEL -export   |   Завершить работу -exit");
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------");



        do {
            System.out.print("Какую операцию вы хотите выполнить?: ");
            String str = scan.nextLine();

            if (str.equals("-view")) {
                Product.viewProduct();
            }
            else if (str.equals("-del")) {
                Product.delProduct();

            }
          else if (str.equals("-add")) {
               Product.addProduct();
            }

            else if (str.equals("-export")) {
               Product.exportProduct();
            }

            else if (str.equals("-exit")) {
                System.out.println("ПОКА!");
                break;
            }
            else {
               System.out.println("-------------------------------");
               System.out.println("| Такой команды в системе нет |");
               System.out.println("-------------------------------");
               System.out.println("");}

       } while (true);
    }
}




