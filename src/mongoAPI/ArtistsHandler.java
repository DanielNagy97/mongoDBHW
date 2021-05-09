package mongoAPI;

import java.util.Scanner;

import org.bson.Document;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class ArtistsHandler extends Methods implements Handler {

	@Override
	public MongoCollection<Document> getAll(MongoDatabase db) {
		return query(db, "artists");
	}

	@Override
	public void addNew(MongoDatabase db, Scanner scanner) {
		Document newArtist = new Document();
		System.out.println("_id:");
		newArtist.put("_id", Float.parseFloat(scanner.nextLine()));

		System.out.println("Eloado neve:");
		newArtist.put("name", scanner.nextLine());

		System.out.println("Eloado orszaga:");
		newArtist.put("country", scanner.nextLine());

		insert(db, "artists", newArtist);
	}

	@Override
	public void updateOne(MongoDatabase db, Scanner scanner) {
		System.out.println("Mit szeretne módosítani?");
		System.out.println("1. Előadó neve");
		System.out.println("2. Előadó országa");
		System.out.println("0. Visszalépés");
		int input2 = Integer.parseInt(scanner.nextLine());
		Float id;
		String newVal;
		switch (input2) {
		case 1:
			System.out.println("Adja meg az _id-t:");
			id = Float.parseFloat(scanner.nextLine());
			System.out.println("Adja meg az új nevet:");
			newVal = scanner.nextLine();

			update(db, "artists", id, "name", newVal);
			break;

		case 2:
			System.out.println("Adja meg az _id-t:");
			id = Float.parseFloat(scanner.nextLine());
			System.out.println("Adja meg az új országot:");
			newVal = scanner.nextLine();

			update(db, "artists", id, "country", newVal);
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

		deleteById(db, "artists", id);
	}

}
