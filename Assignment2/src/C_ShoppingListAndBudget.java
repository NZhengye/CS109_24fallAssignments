import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;

public class C_ShoppingListAndBudget {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double budget = input.nextDouble();
        int num_items = input.nextInt();
        double[] prices = new double[num_items];
        for (int i = 0; i < num_items; i++){
            prices[i] = input.nextDouble();
        }

        if (remain(budget, prices) > 0){
            System.out.printf("Budget sufficient, remaining %.2f", remain(budget, prices));
        }else{
            Item[] items = new Item[num_items];
            for (int i = 0; i < num_items; i ++){
                items[i] = new Item(i, prices[i]);
            }

            Arrays.sort(items, Comparator.comparingDouble(item -> item.price));

            int pos = -1;
            double remain = budget;
            for (int i = 0; i < num_items; i ++){
                if (remain >= items[i].price)
                    remain -= items[i].price;
                else {
                    pos = i;
                    break;
                }
            }

            int[] notpurchased = new int[num_items - pos];
            for (int i = 0, j = pos; i < num_items - pos; i ++){
                notpurchased[i] = items[j].index;
                j ++;
            }
            Arrays.sort(notpurchased);

            System.out.printf("Budget insufficient, remaining %.2f, ", remain);
            for (int index : notpurchased) {
                System.out.print(index + " ");
            }
        }
    }

    public static double remain(double budget, double[] prices){
        double remain = budget;
        for (int i = 0; i < prices.length; i ++){
            remain -= prices[i];
        }
        return remain;
    }

    static class Item {
        int index;
        double price;

        Item(int index, double price) {
            this.index = index;
            this.price = price;
        }
    }
}
