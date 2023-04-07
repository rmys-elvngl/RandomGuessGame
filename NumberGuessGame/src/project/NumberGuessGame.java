package project;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class NumberGuessGame {
	public static void main(String[] args) {
		//Değerleri alma ve oluşturma
		Random rnd = new Random();
		int selected = rnd.nextInt(100);
		Scanner input = new Scanner(System.in);
		int number;
		int count=0;
		
		int[] wrong = new int[5];
        boolean isWin = false;
        boolean isWrong = false;
		
        System.out.println(selected);
		//programın işlevi
		for(int i=0; i<5;i++) {
			System.out.print("Enter a number: ");
			number = input.nextInt();
			
			if(number<0 || number>100) {
				System.out.print("Hatalı Giriş! Lütfen 0 ile 100 aralığında bir sayı giriniz.");
				if (isWrong) {
					count++;
                    System.out.println("Çok fazla hatalı giriş yaptınız. Kalan hak : " + (5-count));
                } else {
                    isWrong = true;
                    System.out.println("Bir daha hatalı girişinizde hakkınızdan düşülecektir.");
                }
                continue;
			}
			
			if(number == selected) {
				System.out.print("Tebrikler!! Doğru Tahmin");
				isWin = true;
				break;
			}
			
			else if(number < selected) {
				count++;
				wrong[i] = number;
				System.out.println("Girilen sayı rastgele sayıdan küçük lütfen daha büyük bir değer giriniz. ");
				System.out.println("Kalan hak: " + (5-count));
				//continue;
				if(count == 0) {
					System.out.println("Haklarınız bitmiştir. Lütfen sistemden çıkıp tekrar giriş yapınız.");
				}
			}
			else if(number > selected) {
				count++;
				wrong[i] = number;
				System.out.println("Girilen sayı rastgele sayıdan büyük lütfen daha küçük bir sayı giriniz. ");
				System.out.println("Kalan hak: " + (5-count));
				//continue;
				if(count == 0) {
					System.out.println("Haklarınız bitmiştir. Lütfen sistemden çıkıp tekrar giriş yapınız.");
				}
			}
			
		}
		if (!isWin) {
            System.out.println("Kaybettiniz ! ");
            if (!isWrong) {
                System.out.println("Tahminleriniz : " + Arrays.toString(wrong));
            }
        }
	}
}
