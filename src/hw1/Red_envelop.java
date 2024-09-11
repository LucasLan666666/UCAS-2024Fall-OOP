package hw1;

import java.util.Scanner;
import java.util.Random;

public class Red_envelop {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("输入红包总金额: ");
        double money = input.nextDouble();  // 红包总金额
        System.out.print("输入红包总数量: ");
        int count = input.nextInt();  // 红包总数量

        // 计算每个红包的金额
        double[] res = split(money, count);

        // 输出每个红包的金额
        for (double amount : res) {
            System.out.printf("红包金额: %.2f元\n", amount);
        }

        input.close();
    }

    public static double[] split(double totalAmount, int totalCount) {
        double[] amounts = new double[totalCount];
        Random random = new Random();
        double remainingAmount = totalAmount; // 剩余金额
        int remainingCount = totalCount; // 剩余红包数量

        for (int i = 0; i < totalCount - 1; i++) {
            double max = (remainingAmount * 2) / remainingCount; // 二倍均值法
            double amount = random.nextDouble() * max; // 产生一个 0 ~ max 之间的随机数
            amounts[i] = amount;
            remainingAmount -= amount;
            remainingCount--;
        }
        amounts[totalCount - 1] = remainingAmount; // 最后一个红包

        return amounts;
    }
}
