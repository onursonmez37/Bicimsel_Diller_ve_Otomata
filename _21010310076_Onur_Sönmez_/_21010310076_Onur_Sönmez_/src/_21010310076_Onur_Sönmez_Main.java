import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
public class _21010310076_Onur_Sönmez_Main {
	public static void main(String[] args) {
		ArrayList<String> AltıncıSatirVerileri = new ArrayList<>();
		ArrayList<String> AltıncıSatirListesi = new ArrayList<>();
		ArrayList<String> BaşlangıcStati = new ArrayList<>();
		ArrayList<String> qList = new ArrayList<>();
		ArrayList<String> EListesi = new ArrayList<>();
		ArrayList<String> geçişlerAlfabesi = new ArrayList<>();
		ArrayList<String> dorduncuSatirListesi = new ArrayList<>();
		ArrayList<String> besinciSatirVerileri = new ArrayList<>();
		ArrayList<String> beşinciSatirListesi = new ArrayList<>();
		List<String> StatelerListesi = new ArrayList<>();
		List<String> dorduncuSatirVerileri = new ArrayList<>();
		String filename = "FST.txt";
		try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
			String line;
			int lineNumber = 0;
			while ((line = reader.readLine()) != null) {
				lineNumber++;
				System.out.println("Satır " + lineNumber + ": " + line);
				if (lineNumber == 1) {

					String input = line;

					Pattern pattern = Pattern.compile("[^{,}]+");
					Matcher matcher = pattern.matcher(input);

					if (matcher.find()) {
						do {
							qList.add(matcher.group().trim());
						} while (matcher.find());					}
					StatelerListesi.add(qList.get(1));
					StatelerListesi.add(qList.get(2));
					System.out.println("Q kümesinin ilk elemanı: " + StatelerListesi.get(0) + " Q kümesinin2.elemanı: "
							+ StatelerListesi.get(1));				}
				if (lineNumber == 2) {
					String input = line;
					Pattern pattern = Pattern.compile("[^{,}]+");
					Matcher matcher = pattern.matcher(input);
					if (matcher.find()) {
						do {
							EListesi.add(matcher.group().trim());
						} while (matcher.find());
					}
					StatelerListesi.add(EListesi.get(1));
					StatelerListesi.add(EListesi.get(2));
					System.out.println("Geçiş Elemanları Listesi: " + EListesi.get(1) + " " + EListesi.get(2) + " "
							+ EListesi.get(3));
				}
				if (lineNumber == 3) {
					String input = line;
					Pattern pattern = Pattern.compile("[^{,}]+");
					Matcher matcher = pattern.matcher(input);
					if (matcher.find()) {
						do {
							geçişlerAlfabesi.add(matcher.group().trim());
						} while (matcher.find());
					}
					StatelerListesi.add(geçişlerAlfabesi.get(1));
					StatelerListesi.add(geçişlerAlfabesi.get(2));
					System.out.println(
							"Geçiş Elemanları Listesi: " + geçişlerAlfabesi.get(1) + " " + geçişlerAlfabesi.get(2));
				}
				if (lineNumber == 4) {
					String input = line;
					Pattern pattern = Pattern.compile("[^{,}]+");
					Matcher matcher = pattern.matcher(input);
					while (matcher.find()) {
						dorduncuSatirListesi.add(matcher.group().trim());
					}
					dorduncuSatirVerileri.addAll(dorduncuSatirListesi);
					System.out.println("4. Satır Verileri: " + dorduncuSatirVerileri);
					ArrayList<ArrayList<String>> yeniArrayList = new ArrayList<>();
					for (String satir : dorduncuSatirVerileri) {
						String[] parcalar = satir.split("\\s+");
						ArrayList<String> parcaListesi = new ArrayList<>();
						for (String parca : parcalar) {

							if (parca.matches("\\d+")) {
								parcaListesi.add(parca);
							}
						}
						yeniArrayList.add(parcaListesi);
					}
					for (ArrayList<String> parcaListesi : yeniArrayList) {
						System.out.println(parcaListesi);
					}
					for (ArrayList<String> parcaListesi : yeniArrayList) {
						for (int i = 0; i < parcaListesi.size(); i++) {
							System.out.println("4.satır " + i + ". index => " + parcaListesi.get(i));
						}
					}
				}
				if (lineNumber == 5) {
					String input = line;
					Pattern pattern = Pattern.compile("\\((.*?)\\)");
					Matcher matcher = pattern.matcher(input);
					while (matcher.find()) {
						beşinciSatirListesi.add(matcher.group(1).trim());
					}
					besinciSatirVerileri.addAll(beşinciSatirListesi);
					System.out.println("5. Satır Verileri: " + besinciSatirVerileri);
				}
				if (lineNumber == 6) {
					String input = line;
					Pattern pattern = Pattern.compile("\\((.*?)\\)");
					Matcher matcher = pattern.matcher(input);
					while (matcher.find()) {
						AltıncıSatirListesi.add(matcher.group(1).trim());
					}
					AltıncıSatirVerileri.addAll(AltıncıSatirListesi);
					System.out.println("6. Satır Verileri: " + AltıncıSatirVerileri);
				}
				if (lineNumber == 7) {
					String input = line;

					Pattern pattern = Pattern.compile("a1");
					Matcher matcher = pattern.matcher(input);

					if (matcher.find()) {
						do {
							BaşlangıcStati.add(matcher.group().trim());
						} while (matcher.find());}
			StatelerListesi.add(BaşlangıcStati.get(0));
			System.out.println("Başlangıc statei " + BaşlangıcStati.get(0));	}
			}			
			System.err.println("FST.txt dosyası okundu");
			System.err.println("BAŞLANGIC STATE'İ:" + StatelerListesi.get(0));
			Scanner scanner = new Scanner(System.in);
			Map<String, String> çıkışFonksiyonu = new HashMap<>();
			List<String> çıkışlarSirasi = new ArrayList<>();
			Map<String, String> gecisFonksiyonu = new HashMap<>();
			List<String> durumlarSirasi = new ArrayList<>();
			gecisFonksiyonu.put("a1-0", "a1"); çıkışFonksiyonu.put("a1-0", "0"); 
			gecisFonksiyonu.put("a1-1", "a1");  çıkışFonksiyonu.put("a1-0", "0");
			gecisFonksiyonu.put("a1-2", "a2");  çıkışFonksiyonu.put("a1-0", "1");
			gecisFonksiyonu.put("a2-0", "a1");  çıkışFonksiyonu.put("a1-0", "0");
			gecisFonksiyonu.put("a2-1", "a2");  çıkışFonksiyonu.put("a1-0", "1");
			gecisFonksiyonu.put("a2-2", "a2");  çıkışFonksiyonu.put("a1-0", "1");
			String suankiDurum = BaşlangıcStati.get(0);
			durumlarSirasi.add(suankiDurum);
		for (int i = 1; i < 3; i++) {
			Scanner scanner1 = new Scanner(System.in);
			System.out.print("İnput "+i+".değerini giriniz");
			String giris = scanner1.nextLine();
			String yeniDurum = gecisFonksiyonu.get(suankiDurum + "-" + giris);
			String yeniDurumcıkıs = çıkışFonksiyonu.get(suankiDurum + "-" + giris);
			if (yeniDurum != null) {
				durumlarSirasi.add(yeniDurum);
				çıkışlarSirasi.add("0");
				System.out.println("Durumların Sırası: " + durumlarSirasi.toString());
				System.out.println("Çıkışların Sırası: " + çıkışlarSirasi.toString());
				
			} else { System.out.println("Geçiş fonksiyonu tanımlanmamış giriş.");	}}} catch (IOException e) {
			e.printStackTrace();}}}