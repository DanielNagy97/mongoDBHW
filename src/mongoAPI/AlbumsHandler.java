package mongoAPI;

import java.util.Scanner;

import org.bson.Document;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class AlbumsHandler extends Methods implements Handler {

	@Override
	public MongoCollection<Document> getAll(MongoDatabase db) {
		return query(db, "albums");
	}

	@Override
	public void addNew(MongoDatabase db, Scanner scanner) {
		Document newAlbum = new Document();

		System.out.println("_id:");
		newAlbum.put("_id", Float.parseFloat(scanner.nextLine()));

		System.out.println("Album cime:");
		newAlbum.put("title", scanner.nextLine());

		System.out.println("Eloado _id-ja:");
		newAlbum.put("artist", Float.parseFloat(scanner.nextLine()));

		System.out.println("Megjelenes eve:");
		newAlbum.put("year", Float.parseFloat(scanner.nextLine()));

		System.out.println("Műfaj:");
		newAlbum.put("genre", scanner.nextLine());

		System.out.println("Ar:");
		newAlbum.put("price", Float.parseFloat(scanner.nextLine()));

		insert(db, "albums", newAlbum);
	}

	@Override
	public void updateOne(MongoDatabase db, Scanner scanner) {
		System.out.println("Mit szeretne módosítani?");
		System.out.println("1. Album címe");
		System.out.println("2. Album előadója");
		System.out.println("3. Album megjelenési éve");
		System.out.println("4. Album műfaja");
		System.out.println("5. Album ára");
		System.out.println("0. Visszalépés");
		int input2 = Integer.parseInt(scanner.nextLine());
		Float id;
		String newVal;
		Float newFloatVal;
		switch (input2) {
		case 1:
			System.out.println("Adja meg az _id-t:");
			id = Float.parseFloat(scanner.nextLine());
			System.out.println("Adja meg az új címet:");
			newVal = scanner.nextLine();

			update(db, "albums", id, "title", newVal);
			break;

		case 2:
			System.out.println("Adja meg az _id-t:");
			id = Float.parseFloat(scanner.nextLine());
			System.out.println("Adja meg az új előadó _id-ját:");
			newFloatVal = Float.parseFloat(scanner.nextLine());

			update(db, "albums", id, "artist", newFloatVal);
			break;

		case 3:
			System.out.println("Adja meg az _id-t:");
			id = Float.parseFloat(scanner.nextLine());
			System.out.println("Adja meg az új megjelenési évet");
			newFloatVal = Float.parseFloat(scanner.nextLine());

			update(db, "albums", id, "year", newFloatVal);
			break;

		case 4:
			System.out.println("Adja meg az _id-t:");
			id = Float.parseFloat(scanner.nextLine());
			System.out.println("Adja meg az új műfajt:");
			newVal = scanner.nextLine();

			update(db, "albums", id, "genre", newVal);
			break;

		case 5:
			System.out.println("Adja meg az _id-t:");
			id = Float.parseFloat(scanner.nextLine());
			System.out.println("Adja meg az új árat");
			newFloatVal = Float.parseFloat(scanner.nextLine());

			update(db, "albums", id, "price", newFloatVal);
			break;

		case 0:
			break;
		default:
			break;
		}
	}

	@Override
	public void deleteOne(MongoDatabase db, Scanner scanner) {
		System.out.println("Adja meg az _id-t:");
		Float id = Float.parseFloat(scanner.nextLine());

		deleteById(db, "albums", id);
	}

}
