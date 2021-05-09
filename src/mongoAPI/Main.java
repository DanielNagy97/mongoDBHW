package mongoAPI;

import java.util.Scanner;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int input;

		AlbumsHandler albumsHandler = new AlbumsHandler();
		ArtistsHandler artistsHandler = new ArtistsHandler();
		CustomersHandler customersHandler = new CustomersHandler();

		MongoClient dbserver = new MongoClient("localhost", 9999);
		MongoDatabase db = dbserver.getDatabase("AB_MSC_JJ181J");

		do {
			System.out.println("----------Menu----------");
			System.out.println("1. Albumok kilistázása");
			System.out.println("2. Előadók kilistázása");
			System.out.println("3. Vásárlók kilistázása");
			System.out.println("4. Új album felvitele");
			System.out.println("5. Új előadó felvitele");
			System.out.println("6. Új vásárló felvitele");
			System.out.println("7. Új rendelés felvitele");
			System.out.println("8. Album adatainak módosítása");
			System.out.println("9. Előadó adatainak módosítása");
			System.out.println("10. Vásárló adatainak módosítása");
			System.out.println("11. Album törlése");
			System.out.println("12. Előadó törlése");
			System.out.println("13. Vásárló törlése");

			System.out.println("0. Kilépés");
			input = Integer.parseInt(scanner.nextLine());
			switch (input) {
			case 0:
				System.out.println("Viszlát!");
				break;
			case 1:
				// Albumok kilistázása
				printCollection(albumsHandler.getAll(db));
				break;
			case 2:
				// Előadók kilistázása
				printCollection(artistsHandler.getAll(db));
				break;
			case 3:
				// Vásárlók kilistázása
				printCollection(customersHandler.getAll(db));
				break;
			case 4:
				// Új album felvitele
				albumsHandler.addNew(db, scanner);
				break;

			case 5:
				// Új előadó felvitele
				artistsHandler.addNew(db, scanner);
				break;

			case 6:
				// Új vásárló felvitele
				customersHandler.addNew(db, scanner);
				break;

			case 7:
				// Új rendelés felvitele
				customersHandler.makeNewOrder(db, scanner);
				break;

			case 8:
				// Album adatainak módosítása
				albumsHandler.updateOne(db, scanner);
				break;

			case 9:
				// Előadó adatainak módosítása
				artistsHandler.updateOne(db, scanner);
				break;

			case 10:
				// Vásárló adatainak módosítása
				customersHandler.updateOne(db, scanner);
				break;

			case 11:
				// Album törlése
				albumsHandler.deleteOne(db, scanner);
				break;

			case 12:
				// Előadó törlése
				artistsHandler.deleteOne(db, scanner);
				break;

			case 13:
				// Vásárló törlése
				customersHandler.deleteOne(db, scanner);
				break;

			default:
				break;
			}

		} while (input != 0);
		scanner.close();
		dbserver.close();
	}
	
	public static void printCollection(MongoCollection<Document> res) {
		System.out.println("---");
		for (Document doc : res.find()) {
			System.out.println(doc);
		}
	}
}
